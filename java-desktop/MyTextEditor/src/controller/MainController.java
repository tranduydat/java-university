/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JFrame;
import javax.swing.SwingWorker;
import view.MainView;

/**
 * Run the program
 *
 * @author dattran
 */
public class MainController {

    public static void main(String[] args) {
        // Init main view
        MainView mainView = new MainView();
        FileController fileController = new FileController(mainView);
        EditController editController = new EditController(mainView);
        mainView.setVisible(true);
        mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
