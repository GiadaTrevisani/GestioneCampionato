/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.Calendar;
import model.Ranking;
import model.RankingBasket;
import model.RankingSoccer;
import model.RankingVolley;

/**
 * In questa classe viene creato un JPanel che permette di selezionare 
 * la scelta su cosa lavorare, come la gestione delle squadre, il 
 * calendario o visualizzare la classifica.
 * 
 * @author giadatrevisani
 */
public class Select extends JPanel{
    private Ranking rank;
    private final Calendar cal;
    Box vertical;
    private final JButton managementbtn;
    private final JButton calendarbtn;
    private final JButton rankingbtn;
    private final JButton prevpage;
    private final JPanel previus;
    private final String sport;
    private final JPanel father;
    private boolean openmanagement;
    private boolean opencalendar;
    private boolean openranking;
    
     /**
      * Costruttore che prende in ingresso una stringa che indica il tipo di 
      * sport e un JPanel chiamato father.
      * @param sport stringa che indica il nome dello sport.
      * @param father oggetto di tipo JPanel.
      */
    public Select(String sport, JPanel father){      
        cal = new Calendar(); // new Calendar(year);
        
        if(sport.equals("Volley")){
            rank = new RankingVolley(cal);
        }
        
        if(sport.equals("Soccer")){
            rank = new RankingSoccer(cal);
        }
        
        if(sport.equals("Basket")){
            rank = new RankingBasket(cal);
        }
        
        this.sport = sport;
        this.father = father;
        openmanagement = false;
        opencalendar = false;
        openranking = false;
        managementbtn = new JButton("Gestione Squadre");
        calendarbtn = new JButton("Calendario");
        rankingbtn = new JButton("Classifica");
        prevpage = new JButton("<---");
        previus = new JPanel();
        this.creaGui();
    }
    
    private void creaGui(){
        prevpage.setPreferredSize(new Dimension(90, 23));
        managementbtn.setPreferredSize(new Dimension(150, 150));
        calendarbtn.setPreferredSize(new Dimension(150, 150));
        rankingbtn.setPreferredSize(new Dimension(150, 150));
        

        prevpage.addActionListener((ActionEvent e) -> {
           this.setVisible(false);
           father.setVisible(true);
        });

        managementbtn.addActionListener((ActionEvent e) -> {
            if(openmanagement == false){
                openmanagement = true;
                ManagementTeams management;
                management = new ManagementTeams(rank, sport);
                management.setVisible(true);
                management.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        openmanagement = false;
                    }
                });
            }
        });
        
        calendarbtn.addActionListener((ActionEvent e) -> {
            if(opencalendar == false){
                opencalendar = true;
                ViewCalendar calendar;
                calendar = new ViewCalendar(rank, sport);
                calendar.setVisible(true);
                calendar.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        opencalendar = false;
                    }
                });
            }
        });
        
        rankingbtn.addActionListener((ActionEvent e) -> {
            if(openranking == false){
                openranking = true;
                ViewRanking ranking;
                ranking = new ViewRanking(rank, sport);
                ranking.setVisible(true);
                ranking.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        openranking = false;
                    }
                });
            }
        });
        
        

        this.setLayout(new GridBagLayout());
        previus.add(prevpage, BorderLayout.PAGE_START);
        this.add(previus);
        this.add(managementbtn);
        this.add(calendarbtn);
        this.add(rankingbtn);

        System.out.println(sport);
    }
}
