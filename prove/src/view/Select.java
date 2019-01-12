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
    private final JButton gestione;
    private final JButton calendario;
    private final JButton classifica;
    private final String sport;
    private final JPanel select;
     
    public Select(String sport){
        this.sport = sport;
        gestione = new JButton("Gestione Squadre");
        calendario = new JButton("Calendario");
        classifica = new JButton("Classifica");
        select = new JPanel();
        vertical = Box.createHorizontalBox();
        this.creaGui();
    }
    
    @SuppressWarnings("empty-statement")
    private void creaGui(){
        this.setMinimumSize(new Dimension(300, 300));;
        this.setSize(800, 600);
        
        gestione.setPreferredSize(new Dimension(150, 150));
        classifica.setPreferredSize(new Dimension(150, 150));
        calendario.setPreferredSize(new Dimension(150, 150));
        select.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        select.add(gestione, gbc);
        select.add(calendario, gbc);
        select.add(classifica, gbc);
        this.add(select, SwingConstants.CENTER);
        
        System.out.println(sport);
    }
}
