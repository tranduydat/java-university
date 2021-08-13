/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import view.FontChooserView;
import view.MainView;

/**
 *
 * @author dattran
 */
public class FontChooserController {

    public FontChooserController(FontChooserView fontChooserView) {
        // Get list of availabel fonts in this computer
        String[] arrFonts = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();
        String[] arrStyles = {"Regular", "Bold", "Italic", "Bold Italic"};
        String[] arrSizes = {"8", "9", "10", "11", "12", "14", "16", "18",
            "20", "22", "24", "36", "40", "48", "72"};

        // Set values for lists in fontChooserView
        fontChooserView.getLstFonts().setListData(arrFonts);
        fontChooserView.getLstFontStyles().setListData(arrStyles);
        fontChooserView.getLstFontSizes().setListData(arrSizes);

    }
    
    /**
     * 
     * @param mainView
     * @param fontChooserView 
     */
    protected void setup(MainView mainView, FontChooserView fontChooserView) {
        // Get current font name, style and size from the text editor
        String currentFont = mainView.getTxaEditor().getFont().getFamily();
        int currentStyle = mainView.getTxaEditor().getFont().getStyle();
        int currentSize = mainView.getTxaEditor().getFont().getSize();

        // Set selected font name, style, and size
        // into lists in the font chooser view
        fontChooserView.getLstFonts().setSelectedValue(currentFont, true);
        fontChooserView.getLstFontStyles().setSelectedIndex(currentStyle);
        fontChooserView.getLstFontSizes().setSelectedValue(Integer
                .toString(currentSize), true);

        // Apply current font name, style and size in the text editor
        // into text fields of the font chooser view
        fontChooserView.getTxfFont().setText(currentFont);
        fontChooserView.getTxfFontSize().setText(Integer.toString(currentSize));
        fontChooserView.getTxfFontStyle().setText(fontChooserView
                .getLstFontStyles().getSelectedValue());
    }

    /**
     * Action when user change font
     *
     * @param mainView
     * @param fontChooserView
     */
    protected void changeFont(MainView mainView, FontChooserView fontChooserView) {
        fontChooserView.getLstFonts().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String currentFont = fontChooserView.getLstFonts().getSelectedValue();
                int currentStyle = fontChooserView.getLblSampleText().getFont().getStyle();
                int currentSize = fontChooserView.getLblSampleText().getFont().getSize();

                fontChooserView.getTxfFont().setText(currentFont);
                fontChooserView.getLblSampleText().setFont(new Font(currentFont, currentStyle, currentSize));
            }
        });
    }

    /**
     * Action when user change style of font
     *
     * @param mainView
     * @param fontChooserView
     */
    protected void changeStyle(MainView mainView, FontChooserView fontChooserView) {
        fontChooserView.getLstFontStyles().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int currentStyle = fontChooserView.getLstFontStyles().getSelectedIndex();
                String currentFont = fontChooserView.getLblSampleText().getFont().getFontName();
                int currentSize = fontChooserView.getLblSampleText().getFont().getSize();

                switch (currentStyle) {
                    case 0:
                        fontChooserView.getTxfFontStyle().setText("Regular");
                        break;
                    case 1:
                        fontChooserView.getTxfFontStyle().setText("Bold");
                        break;
                    case 2:
                        fontChooserView.getTxfFontStyle().setText("Italic");
                        break;
                    case 3:
                        fontChooserView.getTxfFontStyle().setText("Bold Italic");
                        break;
                }

                fontChooserView.getLblSampleText().setFont(new Font(currentFont, currentStyle, currentSize));
            }
        });
    }

    /**
     * Action when user change size of font
     *
     * @param mainView
     * @param fontChooserView
     */
    protected void changeSize(MainView mainView, FontChooserView fontChooserView) {
        fontChooserView.getLstFontSizes().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String currentSize = fontChooserView.getLstFontSizes().getSelectedValue();
                String currentFont = fontChooserView.getLblSampleText().getFont().getFontName();
                int currentStyle = fontChooserView.getLblSampleText().getFont().getStyle();

                fontChooserView.getTxfFontSize().setText(currentSize);
                fontChooserView.getLblSampleText().setFont(new Font(currentFont, currentStyle, Integer.parseInt(currentSize)));
            }
        });

        fontChooserView.getTxfFontSize().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String currentSize = fontChooserView.getTxfFontSize().getText();
                if (!currentSize.isEmpty()) {
                    String currentFont = fontChooserView.getLblSampleText().getFont().getFontName();
                    int currentStyle = fontChooserView.getLblSampleText().getFont().getStyle();

                    fontChooserView.getLblSampleText().setFont(new Font(currentFont, currentStyle, Integer.parseInt(currentSize)));
                }
            }
        });
    }

    /**
     * Apply font changes when user click 'OK' button in font chooser view
     *
     * @param mainView main view of the program
     * @param fontChooserView a windows for user to change fonts
     */
    protected void applyFontChanges(MainView mainView, FontChooserView fontChooserView) {
        fontChooserView.getBtnOK().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentFont = fontChooserView.getLstFonts().getSelectedValue();
                int currentStyle = fontChooserView.getLstFontStyles().getSelectedIndex();
                int currentSize = Integer.parseInt(fontChooserView.getTxfFontSize().getText());

                mainView.getTxaEditor().setFont(new Font(currentFont, currentStyle, currentSize));
                fontChooserView.setVisible(false);
            }
        });

        fontChooserView.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontChooserView.setVisible(false);
            }
        });
    }
}
