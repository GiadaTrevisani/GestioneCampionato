/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prove;

import view_controller.MainFrame;

/**
 * Classe principale dell'applicazione che contiene il main.
 * @author giadatrevisani
 */
public class Prove {

    /**
     * Funzione main del progetto.
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        System.out.println("Gestione campionati avviato");
        
        MainFrame main =new MainFrame();
        main.setVisible(true);
    }
    
}
