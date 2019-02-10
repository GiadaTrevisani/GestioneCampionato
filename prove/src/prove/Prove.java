/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prove;

import java.util.ArrayList;
import model.Match;
import model.Team;
import model.Calendar;

/**
 *
 * @author giadatrevisani
 */
public class Prove {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //MainFrame mainframe = new MainFrame("Gestione campionati");
        //mainframe.setVisible(true);
        System.out.println("Gestione campionati avviato");
        
        //inserimento di una squadra
        Team sv = new Team("sv150", "soliera", 1);
        System.out.println(sv.getName() + " " + sv.getCity() + " " + sv.getLogo());
        Team m = new Team("mondial","carpi",2);
        System.out.println(m.getName() + " " + m.getCity() + " " + m.getLogo());
        Team re = new Team("everton", "reggio", 3);
        Team bo = new Team("Vooleyar", "argelato", 4);
        
        //inserimento di un match già giocato
        //creiamo una data 
        int day = 1;
        Match partita = new Match(sv, m, 3, 2, day);
        System.out.println("\nSquadra casa: " + partita.getHomeTeam().getName());
        System.out.println("Squadra ospite: " + partita.getGuestTeam().getName());
        System.out.println("Punti casa: " + partita.getPointsHome());
        System.out.println("punti ospite: " + partita.getPointsGuest());
        System.out.println("data: " + partita.getDay());
        Match partita_three = new Match(re, bo, 3, 1, day);
        //inseriemnto di un match non ancora giocato
        //creiamo una data 
        Match partita_two = new Match(m, sv, day);
        System.out.println("\nSquadra casa: " + partita_two.getHomeTeam().getName());
        System.out.println("Squadra ospite: " + partita_two.getGuestTeam().getName());
        System.out.println("data: " + partita_two.getDay());
        
        System.out.println("\nSquadra casa: " + partita_three.getHomeTeam().getName());
        System.out.println("Squadra ospite: " + partita_three.getGuestTeam().getName());
        System.out.println("Punti casa: " + partita_three.getPointsHome());
        System.out.println("punti ospite: " + partita_three.getPointsGuest());
        System.out.println("data: " + partita_three.getDay());
        
        ArrayList<Team> teams = new ArrayList();
        teams.add(sv);
        teams.add(m);
        teams.add(re);
        teams.add(bo);
        for (int i = 0; i < teams.size(); i++) {
        System.out.println("\nSquadra casa: " + teams.get(i).getName());
        }
    }
    
}
