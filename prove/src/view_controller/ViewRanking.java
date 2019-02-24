/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author giadatrevisani
 */
public class ViewRanking extends JFrame{
    private JPanel table;
    private JTable viewRanking;
    private final String sport;
    
    public ViewRanking(String sport){
        this.sport = sport;
        if(sport.equals("basket") || sport.equals("volley")){
            //creo la mia tabella senza la colonna pareggiate
        }
        
        if(sport.equals("calcio")){
            //creo la tabella con la colonna pareggiate.
        }
        
    }
    
}
