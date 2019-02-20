/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author giadatrevisani
 */
public class Select extends JPanel{
    Box vertical;
    private final JButton managementbtn;
    private final JButton calendarbtn;
    private final JButton rankingbtn;
    private final JButton prevpage;
    private final JPanel previus;
    private final String sport;
    private final JPanel father;
    private boolean openmanagement;
    
     
    public Select(String sport, JPanel father){
        this.sport = sport;
        this.father = father;
        openmanagement = false;
        managementbtn = new JButton("Gestione Squadre");
        calendarbtn = new JButton("Calendario");
        rankingbtn = new JButton("Classifica");
        prevpage = new JButton("<---");
        previus = new JPanel();
        this.creaGui();
    }
    
    private void creaGui(){
        this.setMinimumSize(new Dimension(300, 300));
        this.setSize(800, 600);
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
                management = new ManagementTeams(sport);
                management.setVisible(true);
                management.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        openmanagement = false;
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
