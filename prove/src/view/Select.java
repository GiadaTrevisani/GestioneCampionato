/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
    private final String sport;
    private final JPanel select;
     
    public Select(String sport){
        this.sport = sport;
        managementbtn = new JButton("Gestione Squadre");
        calendarbtn = new JButton("Calendario");
        rankingbtn = new JButton("Classifica");
        select = new JPanel();
        vertical = Box.createHorizontalBox();
        this.creaGui();
    }
    
    @SuppressWarnings("empty-statement")
    private void creaGui(){
        this.setMinimumSize(new Dimension(300, 300));;
        this.setSize(800, 600);
        
        managementbtn.setPreferredSize(new Dimension(150, 150));
        rankingbtn.setPreferredSize(new Dimension(150, 150));
        calendarbtn.setPreferredSize(new Dimension(150, 150));
        select.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        select.add(managementbtn, gbc);
        select.add(calendarbtn, gbc);
        select.add(rankingbtn, gbc);
        this.add(select, SwingConstants.CENTER);
        this.setVisible(true);
        System.out.println(sport);
    }
}
