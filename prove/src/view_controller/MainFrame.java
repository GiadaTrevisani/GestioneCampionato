/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
/**
 *
 * @author giadatrevisani
 */

/**
 * Generazione del mainframe con interfaccia grafica.
 * Nel peimo frame si dovrà scegliere su quale sport si 
 * vuole intervenire.
 */
public class MainFrame extends JFrame{

    private final JButton soccerbtn;
    private final JButton volleybtn;
    private final JButton basketbtn;
    private final JPanel whichsports;
    Box vertical;
    public MainFrame(String gestione_campionati) {
        whichsports = new JPanel();
        soccerbtn = new JButton("Soccer");
        volleybtn = new JButton("Volley");
        basketbtn = new JButton("Basket");
        vertical = Box.createHorizontalBox();
    this.createGUI();
    }
    
    private void createGUI(){
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setMinimumSize(new Dimension(600, 400));;
       this.setSize(800, 600);
       soccerbtn.setPreferredSize(new Dimension(150, 150));
       volleybtn.setPreferredSize(new Dimension(150, 150));
       basketbtn.setPreferredSize(new Dimension(150, 150));
       
       soccerbtn.addActionListener((ActionEvent e) -> {
           Select select = new Select("calcio", whichsports);
           whichsports.setVisible(false);
           select.setVisible(true);
           this.add(select, SwingConstants.CENTER);
       });
       
       volleybtn.addActionListener((ActionEvent e) -> {
           Select select = new Select("volley", whichsports);
           whichsports.setVisible(false);
           select.setVisible(true);
           this.add(select, SwingConstants.CENTER);
       });
       
       basketbtn.addActionListener((ActionEvent e) -> {
           Select select = new Select("basket", whichsports);
           whichsports.setVisible(false);
           select.setVisible(true);
           this.add(select, SwingConstants.CENTER);
       });

       whichsports.setLayout(new GridBagLayout());
       GridBagConstraints gbc = new GridBagConstraints();
       whichsports.add(soccerbtn, gbc);
       whichsports.add(volleybtn, gbc);
       whichsports.add(basketbtn, gbc);
       whichsports.setVisible(true);
       this.add(whichsports, SwingConstants.CENTER);      
    }
}
