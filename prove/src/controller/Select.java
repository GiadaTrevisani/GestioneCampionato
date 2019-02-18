/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
    private final JPanel body;
    private final String sport;
    private final MainFrame father;
    //private final BoxLayout prev;
    
     
    public Select(String sport, MainFrame father){
        this.sport = sport;
        this.father = father;
        managementbtn = new JButton("Gestione Squadre");
        calendarbtn = new JButton("Calendario");
        rankingbtn = new JButton("Classifica");
        prevpage = new JButton("<---");
        previus = new JPanel();
        body = new JPanel();
        vertical = Box.createHorizontalBox();
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
           //MainFrame main = new MainFrame("GestioneCampionato");
           this.setVisible(false);
           father.setVisible(true);
           this.add(father, SwingConstants.CENTER);
       });
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        previus.add(prevpage, BorderLayout.PAGE_START);
        body.add(managementbtn);
        body.add(calendarbtn);
        body.add(rankingbtn);
        this.add(previus);
        this.add(body, gbc);
        
        System.out.println(sport);
    }
}
