/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.DefaultEditorKit;
import javax.swing.undo.UndoManager;
import view.FindView;
import view.FontChooserView;
import view.MainView;
import view.ReplacementView;

/**
 *
 * @author dattran
 */
public class EditController {

    public EditController() {
    }

    // Controller edit
    public EditController(MainView mainView) {
        UndoManager undoManager = new UndoManager();
        mainView.getTxaEditor().getDocument().addUndoableEditListener(undoManager);

        this.canEdit(mainView);
        this.canUndoRedo(mainView, undoManager);

        this.undo(mainView, undoManager);
        this.redo(mainView, undoManager);
        this.copyPasteCut(mainView);
        this.selectAll(mainView);

        this.runFindController(mainView);
        this.runReplacementController(mainView);
        this.runFontChooserController(mainView);
    }

    // Check user can undo, redo, copy
    private void canEdit(MainView mainView) {
        // When open editor can't undo, redo
        mainView.getMniEditCopy().setEnabled(false);
        mainView.getMniEditCut().setEnabled(false);
        mainView.getMniEditFind().setEnabled(false);
        mainView.getMniEditReplace().setEnabled(false);

        // Check when context area change
        mainView.getTxaEditor().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String txtEditor = mainView.getTxaEditor().getText();
                // Can undo, redo when user change text
                if (txtEditor.length() != 0) {
                    mainView.getMniEditFind().setEnabled(true);
                    mainView.getMniEditReplace().setEnabled(true);
                }

                // Can show cut, copy
                if (mainView.getTxaEditor().getSelectedText() != null) {
                    mainView.getMniEditCut().setEnabled(true);
                    mainView.getMniEditCopy().setEnabled(true);
                } else {
                    mainView.getMniEditCut().setEnabled(false);
                    mainView.getMniEditCopy().setEnabled(false);
                }
            }
        });
    }

    // Check user can undo redo
    private void canUndoRedo(MainView mainView, UndoManager manager) {
        // When new app, user can't undo redo
        mainView.getMniEditUndo().setEnabled(false);
        mainView.getMniEditRedo().setEnabled(false);
        mainView.getTxaEditor().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                if (manager.canUndo()) {
                    mainView.getMniEditUndo().setEnabled(true);
                } else {
                    mainView.getMniEditUndo().setEnabled(false);
                }

                if (manager.canRedo()) {
                    mainView.getMniEditRedo().setEnabled(true);
                } else {
                    mainView.getMniEditRedo().setEnabled(false);
                }
            }
        });
    }

    // Implement undo
    private void undo(MainView mainView, UndoManager manager) {
        mainView.getMniEditUndo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.undo();
            }
        });
    }

    // Implement redo
    private void redo(MainView mainView, UndoManager manager) {
        mainView.getMniEditRedo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.redo();
            }
        });
    }

    // Copy, paste, cut
    private void copyPasteCut(MainView mainView) {
        Action actCopy = new DefaultEditorKit.CopyAction();
        Action actPaste = new DefaultEditorKit.PasteAction();
        Action actCut = new DefaultEditorKit.CutAction();

        mainView.getMniEditCopy().addActionListener(actCopy);
        mainView.getMniEditPaste().addActionListener(actPaste);
        mainView.getMniEditCut().addActionListener(actCut);
    }

    // Select all
    private void selectAll(MainView mainView) {
        mainView.getMniEditSelectAll().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.getTxaEditor().selectAll();
            }
        });
    }

    // Find controller
    private void runFindController(MainView mainView) {
        mainView.getMniEditFind().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FindView findView = new FindView();
                findView.setVisible(true);
                findView.getBtnFind().setEnabled(false);

                FindController findController = new FindController();
                findController.checkFindWhatIsEmpty(findView);
                findController.find(mainView, findView);
                findController.cancel(findView);
            }
        });
    }

    // Replace controller
    private void runReplacementController(MainView mainView) {
        mainView.getMniEditReplace().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReplacementView replacementView = new ReplacementView();
                replacementView.setVisible(true);
                replacementView.getBtnReplace().setEnabled(false);
                replacementView.getBtnReplaceAll().setEnabled(false);

                ReplacementController replacementController = new ReplacementController();
                replacementController.checkFindWhatIsEmpty(replacementView);
                replacementController.replace(mainView, replacementView);
                replacementController.replaceAll(mainView, replacementView);
                replacementController.cancel(replacementView);
            }
        });
    }

    // Font chooser controller
    private void runFontChooserController(MainView mainView) {
        mainView.getMniEditChangeFont().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FontChooserView fontChooserView = new FontChooserView();
                fontChooserView.setVisible(true);

                FontChooserController fontChooserController = new FontChooserController(fontChooserView);
                fontChooserController.setup(mainView, fontChooserView);
                fontChooserController.changeFont(mainView, fontChooserView);
                fontChooserController.changeSize(mainView, fontChooserView);
                fontChooserController.changeStyle(mainView, fontChooserView);
                fontChooserController.applyFontChanges(mainView, fontChooserView);
            }
        });
    }
}
