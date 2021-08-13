/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileFilter;
import view.MainView;

/**
 *
 * @author dattran
 */
public class FileController {

    public FileController() {
    }

    public FileController(MainView mainView) {
        JFileChooser chooser = new JFileChooser();

        this.setupFileChooser(chooser);
        this.newFile(mainView, chooser);
        this.openFile(mainView, chooser);
        this.saveFile(mainView, chooser);
        this.saveFileAs(mainView, chooser);
        this.exit(mainView, chooser);
        this.confirmClosing(mainView, chooser);
        this.checkSaved(mainView);
    }

    /**
     * Allow user to choose between 2 file types (java and text file)
     *
     * @param chooser an instance of JFileChooser
     */
    private void setupFileChooser(JFileChooser chooser) {
        // Allow user choose file .java
        chooser.addChoosableFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().endsWith(".java");
                }
            }

            @Override
            public String getDescription() {
                return "Java Source File (*.java)";
            }
        });

        // Allow user choose file .txt
        chooser.addChoosableFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().endsWith(".txt");
                }
            }

            @Override
            public String getDescription() {
                return "Text Files (*.txt)";
            }
        });

        // Set current directory
        chooser.setCurrentDirectory(new File("."));
    }

    /**
     * Allow user to save file
     *
     * @param mainView main view of the program
     * @param chooser an instance of JFileChooser
     */
    private void saveFile(MainView mainView, JFileChooser chooser) {
        mainView.getMniFileSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeTextAreaToFile(mainView, chooser);
                mainView.setSaved(true);
            }
        });
    }

    /**
     * Allow user to save file as
     *
     * @param mainView main view of the program
     * @param chooser an instance of JFileChooser
     */
    private void saveFileAs(MainView mainView, JFileChooser chooser) {
        mainView.getMniFileSaveAs().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check user continue or cancel
                if (confirmSaving(mainView, chooser)) {
                    return;
                }
                saveAsToFile(mainView, chooser);
            }
        });
    }

    /**
     * Allow user to open file
     *
     * @param mainView main view of the program
     * @param chooser an instance of JFileChooser
     */
    private void openFile(MainView mainView, JFileChooser chooser) {
        mainView.getMniFileOpen().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check user continue or cancel
                if (confirmSaving(mainView, chooser)) {
                    return;
                }

                // Loop until user click file .txt or .java
                File fileCheck = null;
                while (true) {
                    chooser.showOpenDialog(mainView);
                    fileCheck = chooser.getSelectedFile();
                    if (fileCheck.exists()) {
                        break;
                    }
                    JOptionPane.showMessageDialog(mainView, "File not found",
                            "Open", JOptionPane.INFORMATION_MESSAGE);
                }
                mainView.setFile(fileCheck);
                // Clear the text area
                mainView.getTxaEditor().setText("");
                // Write content file to text area
                writeFileToTextArea(mainView);
                mainView.setSaved(true);
            }
        });
    }

    /**
     * Allow user to create a new file
     *
     * @param mainView main view of the program
     * @param chooser an instance of JFileChooser
     */
    private void newFile(MainView mainView, JFileChooser chooser) {
        mainView.getMniFileNew().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check user continue or cancel
                if (confirmSaving(mainView, chooser)) {
                    return;
                }
                mainView.getTxaEditor().setText("");
            }
        });
    }

    /**
     * Allow user to exit the program
     *
     * @param mainView main view of the program
     * @param chooser an instance of JFileChooser
     */
    private void exit(MainView mainView, JFileChooser chooser) {
        mainView.getMniFileExit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check user continue or cancel
                if (confirmSaving(mainView, chooser)) {
                    return;
                }
                System.exit(0);
            }
        });
    }

    /**
     * Write file from file to text area
     *
     * @param mainView main view of the program
     */
    private void writeFileToTextArea(MainView mainView) {
        try {
            FileInputStream fin = new FileInputStream(mainView.getFile());
            BufferedReader din = new BufferedReader(new InputStreamReader(fin));
            String str = "";
            while (str != null) {
                str = din.readLine();
                if (str == null) {
                    break;
                }
                mainView.getTxaEditor().append(str + "\n");
            }

            // When user open, not change then file save
            mainView.setTextCheckSaved(mainView.getTxaEditor().getText());
            mainView.setSaved(true);
            mainView.getTxaEditor().setCaretPosition(0);
        } catch (FileNotFoundException e1) {
            System.out.println(e1.getMessage());
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }
    }

    /**
     * Write text area content into file
     *
     * @param mainView
     * @param chooser
     */
    private void writeTextAreaToFile(MainView mainView, JFileChooser chooser) {
        FileWriter fout = null;
        try {
            if (mainView.getFile() == null) {
                saveAsToFile(mainView, chooser);
                return;
            }
            fout = new FileWriter(mainView.getFile());
            fout.write(mainView.getTxaEditor().getText());
            mainView.setTextCheckSaved(mainView.getTxaEditor().getText());
        } catch (IOException e1) {
            System.out.println(e1);
        } finally {
            try {
                fout.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    /**
     * Save file as another name
     *
     * @param mainView
     * @param chooser
     */
    private void saveAsToFile(MainView mainView, JFileChooser chooser) {
        File checkFile = null;
        while (true) {
            chooser.showSaveDialog(mainView);
            checkFile = chooser.getSelectedFile();
            if (!checkFile.exists()) {
                break;
            }
            int option = JOptionPane.showConfirmDialog(mainView,
                    "Do you want to replace it?",
                    "Save As", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                break;
            }
        }

        mainView.setFile(checkFile);
        mainView.setTextCheckSaved("");
        writeTextAreaToFile(mainView, chooser);
    }

    /**
     * Check file is saved or not
     *
     * @param mainView main view of the program
     */
    private void checkSaved(MainView mainView) {
        mainView.getTxaEditor().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                if (!mainView.getTxaEditor().getText().equals(mainView.getTextCheckSaved())) {
                    mainView.setSaved(false);
                }
            }
        });
    }

    /**
     * Check user choose yes or no or cancel in dialog
     *
     * @param mainView
     * @param fchooser
     * @return
     */
    private boolean confirmSaving(MainView mainView, JFileChooser fchooser) {
        // Check user choose yes or no
        boolean checkSaved = mainView.isSaved();
        if (checkSaved == false) {
            int userChoice = JOptionPane.showConfirmDialog(mainView,
                    "Do you want to save the changes to file",
                    "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
            // Action when user want to save file
            if (userChoice == JOptionPane.YES_OPTION) {
                if (mainView.getFile() == null) {
                    saveAsToFile(mainView, fchooser);
                } else {
                    writeTextAreaToFile(mainView, fchooser);
                }
            }

            if (userChoice == JOptionPane.CANCEL_OPTION || userChoice == JOptionPane.CLOSED_OPTION) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check user want to close or not then implement a proper action
     *
     * @param mainView
     * @param chooser
     */
    private void confirmClosing(MainView mainView, JFileChooser chooser) {
        // Do not close the program when user click Close symbol
        mainView.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Check does the text area is changed or not
                boolean isSaved = mainView.isSaved();

                // If the text area isn't changed
                if (isSaved == false) {
                    // Get the user chooice from the option panel
                    int userChoice = JOptionPane.showConfirmDialog(mainView,
                            "Do you want to save the changes to file",
                            "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
                    // Implement proper action
                    switch (userChoice) {
                        case JOptionPane.YES_OPTION:
                            saveAsToFile(mainView, chooser);
                            break;
                        case JOptionPane.CANCEL_OPTION:
                            return;
                        case JOptionPane.NO_OPTION:
                            System.exit(0);
                    }
                } else {
                    System.exit(0);
                }
            }
        });
    }
}
