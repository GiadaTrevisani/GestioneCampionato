/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Ranking;

/**
 *
 * @author giadatrevisani
 */
public class AddLogo extends JFrame{
    private final JFrame newTeam;
    private Ranking rank;
    private final JButton conferma;
    
    public AddLogo(JFrame newTeam){
        this.newTeam = newTeam;
        conferma = new JButton("Conferma");
        JFileChooser fc = new JFileChooser();
        File file = null;
        fc.setFileFilter(new FileNameExtensionFilter("Only image extension filter", "jpg", "jpeg", "png"));
        int res = fc.showOpenDialog(this);
        if(res == JFileChooser.APPROVE_OPTION)
            file = fc.getSelectedFile();
        
        if(file!=null){
            
            try {
                //logo = new ImageIcon(file.getAbsolutePath());
                BufferedImage bi = ImageIO.read(file);
                //this.logo = new Logo(bi);
                
            }
            catch (IOException ex) {
                System.err.println("Errore di caricamento del file contenente"
                        + " il percorso dell'immagine del logo in "
                        + "SelectLogoListener");
            }
            
            conferma.setEnabled(true);
        }
        
        else
            System.err.println("Errore nel caricamento del file!");
    }
    
}
