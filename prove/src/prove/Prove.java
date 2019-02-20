/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prove;

import view_controller.MainFrame;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import model.Team;
import model.Calendar;
import model.RankingVolley;

/**
 *
 * @author giadatrevisani
 */
public class Prove {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, Exception{
        //MainFrame mainframe = new MainFrame("Gestione campionati");
        //mainframe.setVisible(true);
        System.out.println("Gestione campionati avviato");
        
        
        //proviamo l'algoritmo di berger 
        //creiamo 4 squadre, le inseriamo in un array di squadre e lo passiamo alla 
        //funzione Algoritmo di berger che dovrà creare un calendario di 
        //partite. E poi attraverso la funzione stampaClendario lo stamperemo.
        Team sv = new Team("cacca", "caccalandia", "GestioneCampionato/prove/img_logo");
        Team m = new Team("mondial","carpi","GestioneCampionato/prove/img_logo");
        Team re = new Team("everton", "reggio", "GestioneCampionato/prove/img_logo");
        Team bo = new Team("VoolleyAr", "argelato", "GestioneCampionato/prove/img_logo");
        
        
        ArrayList<Team> teams = new ArrayList();
        teams.add(sv);
        teams.add(m);
        teams.add(re);
        teams.add(bo);
        System.out.println("Stampa calendario");
        
        Calendar calendario = new Calendar(2019);
        calendario.AlgoritmoDiBerger(teams);
        
        //calendario.printCalendar();
        
        RankingVolley classifica = new RankingVolley(/*teams, */calendario);
        
        classifica.saveTeams();
        //classifica.takeFromFile();
        /*
        for (int i = 0; i < classifica.getTeam().size(); i++) {
            System.out.println(classifica.getTeam().get(i).getName());
            System.out.println(classifica.getTeam().get(i).getCity());
            System.out.println(classifica.getTeam().get(i).getLogo());
        }
        */
        MainFrame main =new MainFrame("GestioneCampionato");
        main.setVisible(true);
    }
    
}
