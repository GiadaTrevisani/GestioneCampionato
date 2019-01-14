/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
    
     
    public Select(String sport){
        this.sport = sport;
        managementbtn = new JButton("Gestione Squadre");
        calendarbtn = new JButton("Calendario");
        rankingbtn = new JButton("Classifica");
        prevpage = new JButton("<---");
        previus = new JPanel();
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
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        previus.add(prevpage, BorderLayout.PAGE_START);
        this.add(previus);
        this.add(managementbtn, gbc);
        this.add(calendarbtn, gbc);
        this.add(rankingbtn, gbc);
        this.setVisible(true);
        
        System.out.println(sport);
    }

}
