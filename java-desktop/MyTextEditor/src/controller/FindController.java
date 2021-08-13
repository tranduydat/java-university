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
import javax.swing.text.BadLocationException;
import view.FindView;
import view.MainView;

/**
 *
 * @author dattran
 */
public class FindController {

    /**
     * Perform text find feature
     *
     * @param mainView
     * @param findView
     */
    protected void find(MainView mainView, FindView findView) {
        // Action when user click Find button
        findView.getBtnFind().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtFindWhat = findView.getTxfFind().getText();
                int idxCurrent;
                int idxTextSearch = -1;

                // Check user want to find after
                if (findView.getRadFindDown().isSelected()) {
                    // Must choose selection to change index cursor
                    idxCurrent = mainView.getTxaEditor().getSelectionEnd();
                    // Get the start index of substring in Mainview's text area
                    idxTextSearch = mainView.getTxaEditor().getText()
                            .indexOf(txtFindWhat, idxCurrent);
                } else {
                    try {
                        idxCurrent = mainView.getTxaEditor().getSelectionStart();
                        // Fetches a portion of the text represented by the component.
                        String findResult = mainView.getTxaEditor().getText(0, idxCurrent);
                        idxTextSearch = findResult.lastIndexOf(txtFindWhat);
                    } catch (BadLocationException ex) {
                        System.out.println(ex.getMessage());
                    }
                }

                // Highlight the text result, otherwise show message dialog
                if (idxTextSearch != -1) {
                    mainView.getTxaEditor().setSelectionStart(idxTextSearch);
                    mainView.getTxaEditor().setSelectionEnd(idxTextSearch + txtFindWhat.length());
                } else {
                    JOptionPane.showMessageDialog(findView,
                            "Can't find \"" + txtFindWhat + "\"",
                            "Result", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    /**
     * Action when user click Cancel button
     *
     * @param findView
     */
    protected void cancel(FindView findView) {
        findView.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findView.setVisible(false);
            }
        });
    }

    /**
     * Check find text field whether is empty or not
     *
     * @param findView
     */
    protected void checkFindWhatIsEmpty(FindView findView) {
        findView.getTxfFind().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                if (findView.getTxfFind().getText().trim().isEmpty()) {
                    findView.getBtnFind().setEnabled(false);
                } else {
                    findView.getBtnFind().setEnabled(true);
                }
            }
        });
    }
}
