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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import controller.OpenSelectWindow;
import java.awt.event.ActionListener;
/**
 *
 * @author giadatrevisani
 */

/*
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
        soccerbtn = new JButton("Calcio");
        volleybtn = new JButton("Volley");
        basketbtn = new JButton("Basket");
        vertical = Box.createHorizontalBox();
    this.createGUI();
    }
    
    @SuppressWarnings("empty-statement")
    private void createGUI(){
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setMinimumSize(new Dimension(300, 300));;
       this.setSize(800, 600);
       //se voglio mettere che quando clicco x mi chieda se sono sicura
       //creo il listeners qua sotto
       //this.addWindowListener(new FrameClosingListener(this));
       soccerbtn.setPreferredSize(new Dimension(150, 150));
       ActionListener calcioactionListener = new OpenSelectWindow("calcio", whichsports, this);
       soccerbtn.addActionListener(calcioactionListener);
       volleybtn.setPreferredSize(new Dimension(150, 150));
       ActionListener volleyactionListener = new OpenSelectWindow("volley", whichsports, this);
       volleybtn.addActionListener(volleyactionListener);
       basketbtn.setPreferredSize(new Dimension(150, 150));
       ActionListener basketactionListener = new OpenSelectWindow("basket", whichsports, this);
       basketbtn.addActionListener(basketactionListener);
       whichsports.setLayout(new GridBagLayout());
       GridBagConstraints gbc = new GridBagConstraints();
       whichsports.add(soccerbtn, gbc);
       whichsports.add(volleybtn, gbc);
       whichsports.add(basketbtn, gbc);
       whichsports.setVisible(true);
       this.add(whichsports, SwingConstants.CENTER);
       
    }
    


}
