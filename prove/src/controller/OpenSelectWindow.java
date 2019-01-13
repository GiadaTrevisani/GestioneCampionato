/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import view.Select;


/**
 *
 * @author giadatrevisani
 */
public class OpenSelectWindow implements ActionListener{

    private final String sport;
    
    public OpenSelectWindow(String sport, JPanel whichsports, JFrame firstJfame){
        this.sport = sport;
        whichsports.setVisible(false);
        Select select = new Select(sport);
        select.setVisible(true);
        System.out.println(sport);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Select select = new Select(sport);
        select.setVisible(true);
    }
    
}
