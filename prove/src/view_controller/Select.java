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
    
     
    public Select(String sport, JPanel father){
        if(sport.equals("volley")){
            rank = new RankingVolley();
        }
        
        if(sport.equals("calcio")){
            rank = new RankingSoccer();
        }
        
        if(sport.equals("basket")){
            rank = new RankingBasket();
        }
        
        cal = new Calendar();
        this.sport = sport;
        this.father = father;
        openmanagement = false;
        opencalendar = false;
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
                management = new ManagementTeams(rank);
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
                calendar = new ViewCalendar(cal, rank);
                calendar.setVisible(true);
                calendar.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        opencalendar = false;
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
