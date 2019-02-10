/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
/**
 * @author giadatrevisani
 */

/**
 * La classe Calendar avrà come parametri un array di partite (grandezza?)
 * e l'anno del campionato.
 */
public class Calendar {
    private ArrayList<Match> games;
    private int year;
    
    public Calendar(ArrayList<Match> games, int year){
        this.games = games;
        this.year = year;
    }
    
    public ArrayList<Match> getGames(){
        return games;      
    }
    
    public int getYear(){
        return year;
    }
    
    public void setGames(ArrayList<Match> games){
        this.games = games; 
    }
    
    public void setYear(int year){
        this.year = year;
    }

    public ArrayList getGamesForDate(int day){
        ArrayList<Match> p;
        p = new ArrayList();
        int j = 0;
        for (int i = 0; i < games.size(); i++) {
            if(day == games.get(i).getDay()){
               p.set(j, games.get(i));
               j++;
            }
        }
        
        return p;
    }  
    
    public ArrayList<Match> getGamesForTeam(String teamName){
        ArrayList<Match> p;
        p = new ArrayList();
        int j = 0;
        for (int i = 0; i < games.size(); i++) {
            if(teamName.equals(games.get(i).getHomeTeam().getName())){
               p.set(j, games.get(i));
               j++;
            }
            if(teamName.equals(games.get(i).getGuestTeam().getName())){
                p.set(j, games.get(i));
               j++;
            }
        }  
        return p;
    }
    
    public ArrayList<Match> getPlayedGames(Boolean is_played){
        ArrayList<Match> p;
        p = new ArrayList();
        int j = 0;
        for (int i = 0; i < games.size(); i++) {
            if(is_played == games.get(i).getPlayed()){
               p.set(j, games.get(i));
               j++;
            }
        }  
        return p;
    }
    
  /**
   * Algoritmo per la creazione del calendario di uno sport
   * @param squadre 
   */  
public ArrayList<Match> AlgoritmoDiBerger(ArrayList<Team> teams){
 
    ArrayList<Match> games = new ArrayList();
    int number_teams = teams.size();
    int days = number_teams - 1;
 
    /* crea gli array per le due liste in casa e fuori */
    Team[] home = new Team[number_teams /2];
    Team[] guest = new Team[number_teams /2];
 
    for (int i = 0; i < number_teams /2; i++){
        home[i] = teams.get(i); 
        guest[i] = teams.get(number_teams - 1 - i); 
    }
 
    for (int i = 0; i < days; i++) {
        /* stampa le partite di questa giornata */
        System.out.printf("%d^ Giornata\n",i+1);
        games.get(i).setDay(i);
 
        /* alterna le partite in casa e fuori */
        if (i % 2 == 0) {
            for (int j = 0; j < number_teams /2 ; j++){
                games.get(i).setGuestTeam(guest[j]);
                games.get(i).setHomeTeam(home[j]);
                System.out.printf("%d  %s - %s\n", j+1, guest[j].getName(), home[j].getName(), home[j].getCity()); 
            }
        }
        else {
            for (int j = 0; j < number_teams /2 ; j++) {
                games.get(i).setHomeTeam(home[j]);
                games.get(i).setGuestTeam(guest[j]);
                System.out.printf("%d  %s - %s\n", j+1, home[j].getName(), guest[j].getName(), home[j].getCity()); 
            }
        }
 
        // Ruota in gli elementi delle liste, tenendo fisso il primo elemento
        // Salva l'elemento fisso
        Team pivot = home [0];
 
        /* sposta in avanti gli elementi di "trasferta" inserendo 
         * all'inizio l'elemento casa[1] e salva l'elemento uscente in "riporto" */
		   
        Team riporto = guest[guest.length - 1];
        guest = shiftRight(guest, home[1]);

        /* sposta a sinistra gli elementi di "casa" inserendo all'ultimo 
         * posto l'elemento "riporto" */
		   
        home = shiftLeft(home, riporto);
 
        // ripristina l'elemento fisso
        home[0] = pivot ;
    } 
        return games;
}
 
 private Team[] shiftLeft(Team[] data, Team add) {
    Team[] temp = new Team[data.length];
    for (int i = 0; i < data.length-1; i++) {
            temp[i] = data[i + 1];
    }
    temp[data.length - 1] = add;
    return temp;
	}

private Team[] shiftRight(Team[] data, Team add) {
    Team[] temp = new Team[data.length];
    for (int i = 1; i < data.length; i++) {
            temp[i] = data[i - 1];
    }
    temp[0] = add;
    return temp;
}
}
