/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prove;

import view_controller.MainFrame;
import java.io.FileNotFoundException;

/**
 *
 * @author giadatrevisani
 */
public class Prove {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, Exception{
        
        System.out.println("Gestione campionati avviato");
        
        MainFrame main =new MainFrame("GestioneCampionato");
        main.setVisible(true);
    }
    
}
