/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import model.Ranking;

/**
 *
 * @author giadatrevisani
 */
public final class ViewRanking extends JFrame{
    private final JPanel table;
    private final JTable viewRanking;
    private final JScrollPane jScrollPane1;
    private final String sport;
    
    public ViewRanking(Ranking rank, String sport){
        this.sport = sport;
        viewRanking = new JTable();
        table = new JPanel();
        jScrollPane1 = new JScrollPane();
        if(sport.equals("basket") || sport.equals("volley")){
            //creo la mia tabella senza la colonna pareggiate
            viewRanking.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Posto", "Logo", "Nome", "Punti", "Giocate", "Vinte", "Perse"
                }
                ) {
                Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
            });
            jScrollPane1.setViewportView(viewRanking);
        }
        
        if(sport.equals("calcio")){
            viewRanking.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Posto", "Logo", "Nome", "Punti", "Giocate", "Vinte", "Perse", "Pareggiate"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
            });
                jScrollPane1.setViewportView(viewRanking);
        }
        
        creaGui();
    }
    
    public void creaGui(){
       this.setTitle(sport);
       this.setMinimumSize(new Dimension(700, 500));
       this.setSize(800, 600); 
       this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
