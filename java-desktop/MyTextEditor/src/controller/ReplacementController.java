/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import view.MainView;
import view.ReplacementView;

/**
 *
 * @author dattran
 */
public class ReplacementController {

    /**
     * Perform replacement function
     *
     * @param mainView
     * @param replacementView
     */
    protected void replace(MainView mainView, ReplacementView replacementView) {
        replacementView.getBtnReplace().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtEditor = mainView.getTxaEditor().getText();
                String txtFindWhat = replacementView.getTxfFindWhat().getText();
                String txtReplaceWith = replacementView.getTxfReplaceWith().getText();

                mainView.getTxaEditor().setText(txtEditor.replaceFirst(txtFindWhat, txtReplaceWith));
                int idxCurrent = mainView.getTxaEditor().getText().lastIndexOf(txtReplaceWith) + txtReplaceWith.length();
                int idxTextSearch = -1;
                idxTextSearch = mainView.getTxaEditor().getText().indexOf(txtFindWhat, idxCurrent);

                // Check does txtFindWhat exist in editor or not
                if (idxTextSearch != -1) {
                    mainView.getTxaEditor().setSelectionStart(idxTextSearch);
                    mainView.getTxaEditor().setSelectionEnd(idxTextSearch + txtFindWhat.length());
                } else {
                    JOptionPane.showMessageDialog(replacementView, "Can't find \"" + txtFindWhat + "\"", "Result", 2);
                }
            }
        });
    }

    /**
     * Replace all found text in FindWhat text field, then replace that with
     * ReplaceWith Text field content
     *
     * @param mainView The main view of text editor
     * @param replacementView The replacement dialog
     */
    protected void replaceAll(MainView mainView, ReplacementView replacementView) {
        replacementView.getBtnReplaceAll().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show warning if text editor is empty
                if (mainView.getTxaEditor().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(replacementView, "Text Editor is empty!", "Error", 2);
                } else {
                    String txtEditor = mainView.getTxaEditor().getText();
                    String txtFindWhat = replacementView.getTxfFindWhat().getText();
                    String txtReplaceWith = replacementView.getTxfReplaceWith().getText();
                    mainView.getTxaEditor().setText(txtEditor.replaceAll(txtFindWhat, txtReplaceWith));
                }
            }
        });
    }

    /**
     * Check "Find What" text field is empty or not
     *
     * @param replacementView The Replacement view which this action is
     * performed
     */
    protected void checkFindWhatIsEmpty(ReplacementView replacementView) {
        replacementView.getTxfFindWhat().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                if (replacementView.getTxfFindWhat().getText().trim().isEmpty()) {
                    replacementView.getBtnReplace().setEnabled(false);
                    replacementView.getBtnReplaceAll().setEnabled(false);
                } else {
                    replacementView.getBtnReplace().setEnabled(true);
                    replacementView.getBtnReplaceAll().setEnabled(true);
                }
            }
        });
    }

    /**
     * Action when user click cancel button
     *
     * @param replacementView The Replacement view which this action is
     * performed
     */
    protected void cancel(ReplacementView replacementView) {
        replacementView.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replacementView.setVisible(false);
            }
        });
    }
}
