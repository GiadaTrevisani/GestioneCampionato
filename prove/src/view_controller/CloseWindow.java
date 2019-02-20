/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author giadatrevisani
 */
public class CloseWindow implements WindowListener{

    private final JFrame frame;

    CloseWindow(JFrame frame) {
        this.frame = frame;
    }
    
    
    @Override
    public void windowClosing(WindowEvent e) {
        Object[] opzioni = {"Sì","No"};
        
        int n = JOptionPane.showOptionDialog(frame, "Sei sicuro di voler uscire?",
                "Uscita GestioneCampionati", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opzioni, opzioni[0]);
        
        if(n == JOptionPane.YES_OPTION){
            System.exit(0);
        }
        
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("window opened");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("window close");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("window iconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("window deconified");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("window activated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("window deactivated");
    }

    
    
}
