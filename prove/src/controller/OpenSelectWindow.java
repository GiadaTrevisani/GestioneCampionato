/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Select;

/**
 *
 * @author giadatrevisani
 */
public class OpenSelectWindow implements ActionListener{

    private String sport;
    
    public OpenSelectWindow(String sport){
        this.sport = sport;
    }

    public OpenSelectWindow() {
        Select select = new Select(sport);
        select.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Select select = new Select(sport);
        select.setVisible(true);
    }
    
}
