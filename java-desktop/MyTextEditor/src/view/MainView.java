/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

/**
 *
 * @author dattran
 */
public class MainView extends javax.swing.JFrame {

    private String textCheckSaved = "";
    private boolean saved = true;
    private File file = null;

    /**
     * Creates new form MainForm
     */
    public MainView() {
        initComponents();
    }

    public JMenuBar getMnbMain() {
        return mnbMain;
    }

    public void setMnbMain(JMenuBar mnbMain) {
        this.mnbMain = mnbMain;
    }

    public JMenuItem getMniEditChangeFont() {
        return mniEditChangeFont;
    }

    public void setMniEditChangeFont(JMenuItem mniChangeFont) {
        this.mniEditChangeFont = mniChangeFont;
    }

    public JMenuItem getMniEditCopy() {
        return mniEditCopy;
    }

    public void setMniEditCopy(JMenuItem mniCopy) {
        this.mniEditCopy = mniCopy;
    }

    public JMenuItem getMniEditCut() {
        return mniEditCut;
    }

    public void setMniEditCut(JMenuItem mniCut) {
        this.mniEditCut = mniCut;
    }

    public JMenuItem getMniFileExit() {
        return mniFileExit;
    }

    public void setMniFileExit(JMenuItem mniExit) {
        this.mniFileExit = mniExit;
    }

    public JMenuItem getMniEditFind() {
        return mniEditFind;
    }

    public void setMniEditFind(JMenuItem mniFind) {
        this.mniEditFind = mniFind;
    }

    public JMenuItem getMniFileOpen() {
        return mniFileOpen;
    }

    public void setMniFileOpen(JMenuItem mniOpen) {
        this.mniFileOpen = mniOpen;
    }

    public JMenuItem getMniEditPaste() {
        return mniEditPaste;
    }

    public void setMniEditPaste(JMenuItem mniPaste) {
        this.mniEditPaste = mniPaste;
    }

    public JMenuItem getMniEditRedo() {
        return mniEditRedo;
    }

    public void setMniEditRedo(JMenuItem mniRedo) {
        this.mniEditRedo = mniRedo;
    }

    public JMenuItem getMniEditReplace() {
        return mniEditReplace;
    }

    public void setMniEditReplace(JMenuItem mniReplace) {
        this.mniEditReplace = mniReplace;
    }

    public JMenuItem getMniFileSave() {
        return mniFileSave;
    }

    public void setMniFileSave(JMenuItem mniSave) {
        this.mniFileSave = mniSave;
    }

    public JMenuItem getMniFileSaveAs() {
        return mniFileSaveAs;
    }

    public void setMniFileSaveAs(JMenuItem mniSaveAs) {
        this.mniFileSaveAs = mniSaveAs;
    }

    public JMenuItem getMniEditSelectAll() {
        return mniEditSelectAll;
    }

    public void setMniEditSelectAll(JMenuItem mniSelectAll) {
        this.mniEditSelectAll = mniSelectAll;
    }

    public JMenuItem getMniEditUndo() {
        return mniEditUndo;
    }

    public void setMniEditUndo(JMenuItem mniUndo) {
        this.mniEditUndo = mniUndo;
    }

    public JMenu getMnuEdit() {
        return mnuEdit;
    }

    public void setMnuEdit(JMenu mnuEdit) {
        this.mnuEdit = mnuEdit;
    }

    public JMenu getMnuFile() {
        return mnuFile;
    }

    public void setMnuFile(JMenu mnuFile) {
        this.mnuFile = mnuFile;
    }

    public JTextArea getTxaEditor() {
        return txaEditor;
    }

    public void setTxaEditor(JTextArea txaMain) {
        this.txaEditor = txaMain;
    }

    public JMenuItem getMniFileNew() {
        return mniFileNew;
    }

    public void setMniFileNew(JMenuItem mniFileNew) {
        this.mniFileNew = mniFileNew;
    }

    public String getTextCheckSaved() {
        return textCheckSaved;
    }

    public void setTextCheckSaved(String textCheckSaved) {
        this.textCheckSaved = textCheckSaved;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public boolean getSaved() {
        return this.saved;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaEditor = new javax.swing.JTextArea();
        mnbMain = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mniFileNew = new javax.swing.JMenuItem();
        mniFileOpen = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mniFileSave = new javax.swing.JMenuItem();
        mniFileSaveAs = new javax.swing.JMenuItem();
        mniFileExit = new javax.swing.JMenuItem();
        mnuEdit = new javax.swing.JMenu();
        mniEditUndo = new javax.swing.JMenuItem();
        mniEditRedo = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mniEditCut = new javax.swing.JMenuItem();
        mniEditCopy = new javax.swing.JMenuItem();
        mniEditPaste = new javax.swing.JMenuItem();
        mniEditSelectAll = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mniEditFind = new javax.swing.JMenuItem();
        mniEditReplace = new javax.swing.JMenuItem();
        mniEditChangeFont = new javax.swing.JMenuItem();

        jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText("jCheckBoxMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Text Editor (MTE)");

        txaEditor.setColumns(20);
        txaEditor.setRows(5);
        jScrollPane1.setViewportView(txaEditor);

        mnuFile.setText("File");

        mniFileNew.setText("New");
        mnuFile.add(mniFileNew);

        mniFileOpen.setText("Open");
        mnuFile.add(mniFileOpen);
        mnuFile.add(jSeparator1);

        mniFileSave.setText("Save");
        mniFileSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniFileSaveActionPerformed(evt);
            }
        });
        mnuFile.add(mniFileSave);

        mniFileSaveAs.setText("Save As");
        mnuFile.add(mniFileSaveAs);

        mniFileExit.setText("Exit");
        mnuFile.add(mniFileExit);

        mnbMain.add(mnuFile);

        mnuEdit.setText("Edit");

        mniEditUndo.setText("Undo");
        mnuEdit.add(mniEditUndo);

        mniEditRedo.setText("Redo");
        mnuEdit.add(mniEditRedo);
        mnuEdit.add(jSeparator2);

        mniEditCut.setText("Cut");
        mnuEdit.add(mniEditCut);

        mniEditCopy.setText("Copy");
        mnuEdit.add(mniEditCopy);

        mniEditPaste.setText("Paste");
        mnuEdit.add(mniEditPaste);

        mniEditSelectAll.setText("Select All");
        mnuEdit.add(mniEditSelectAll);
        mnuEdit.add(jSeparator3);

        mniEditFind.setText("Find");
        mnuEdit.add(mniEditFind);

        mniEditReplace.setText("Replace");
        mniEditReplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEditReplaceActionPerformed(evt);
            }
        });
        mnuEdit.add(mniEditReplace);

        mniEditChangeFont.setText("Change Font");
        mnuEdit.add(mniEditChangeFont);

        mnbMain.add(mnuEdit);

        setJMenuBar(mnbMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mniFileSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniFileSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniFileSaveActionPerformed

    private void mniEditReplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEditReplaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniEditReplaceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuBar mnbMain;
    private javax.swing.JMenuItem mniEditChangeFont;
    private javax.swing.JMenuItem mniEditCopy;
    private javax.swing.JMenuItem mniEditCut;
    private javax.swing.JMenuItem mniEditFind;
    private javax.swing.JMenuItem mniEditPaste;
    private javax.swing.JMenuItem mniEditRedo;
    private javax.swing.JMenuItem mniEditReplace;
    private javax.swing.JMenuItem mniEditSelectAll;
    private javax.swing.JMenuItem mniEditUndo;
    private javax.swing.JMenuItem mniFileExit;
    private javax.swing.JMenuItem mniFileNew;
    private javax.swing.JMenuItem mniFileOpen;
    private javax.swing.JMenuItem mniFileSave;
    private javax.swing.JMenuItem mniFileSaveAs;
    private javax.swing.JMenu mnuEdit;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JTextArea txaEditor;
    // End of variables declaration//GEN-END:variables
}
