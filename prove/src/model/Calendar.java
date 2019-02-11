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
    
    /**
     * Primo costruttore che prende in ingresso:
     * @param games che indica l'Arrayist di tipo Match che saranno inseriti
     * nell'ArrayList nuovo.
     * @param year che indica l'anno in cui si svolge il campionato.
     */
    public Calendar(ArrayList<Match> games, int year){
        this.games = games;
        this.year = year;
    }
    
    /**
     * Secondo costruttore che prende in ingresso:
     * @param year indica l'anno in cui si svolge il campionato.
     */
    public Calendar(int year){
        this.year = year;
        games = new ArrayList<Match>();
    }
    
    /**
     * @return Metodo che ritorna i match nell'ArrayList di partite.
     */
    public ArrayList<Match> getGames(){
        return games;      
    }
    
    /**
     * @return Metodo che ritorna l'anno in cui si svolge il campionato 
     */
    public int getYear(){
        return year;
    }
    
    /**
     * Metodo che setta l'ArrayList di partite che vengono passate in input
     * @param games ArrayList di partite 
     */
    public void setGames(ArrayList<Match> games){
        this.games = games; 
    }
    
    /**
     * Metodo che setta l'anno del campionato che si vuole creare
     * @param year intero che indica l'anno
     */
    public void setYear(int year){
        this.year = year;
    }
    
    /**
     * Metodo che torna un array di partite che si svolgono nella stessa giornata
     * @param day viene passato in ingresso al metodo che servirà per fare 
     * un controllo delle partite inserite nell'ArrayList games.
     * @return ArrayList con le partite che si volgono nella stessa giornata.
     */
    public ArrayList getGamesForDate(int day){
        ArrayList<Match> p;
        p = new ArrayList<Match>();
        for (int i = 0; i < games.size(); i++) {
            if(day == games.get(i).getDay()){
               p.add(games.get(i));
            }
        }
        
        return p;
    }  
    
    /**
     * Metodo che prende in ingresso il nome della squadra e ritorna tutte 
     * le partite che quella squadra deve giocare.
     * @param teamName stringa con il nome della squadra da cercare.
     * @return ArrayList delle partite che la squadra deve giocare.
     */
    public ArrayList<Match> getGamesForTeam(String teamName){
        ArrayList<Match> p;
        p = new ArrayList<Match>();
        for (int i = 0; i < games.size(); i++) {
            if(teamName.equals(games.get(i).getHomeTeam().getName())){
               p.add(games.get(i));
            }
            if(teamName.equals(games.get(i).getGuestTeam().getName())){
                p.add(games.get(i));
            }
        }  
        return p;
    }
    
    /**
     * Metodo che prende in ingresso un booleano e trona tutte e partite che 
     * sono state giocate o che non sono state giocate.
     * @param is_played booleano per vedere le partite giocate e non giocate.
     * @return un array di partite giocate o non giocate.
     */
    public ArrayList<Match> getPlayedGames(Boolean is_played){
        ArrayList<Match> p;
        p = new ArrayList<Match>();
        for (int i = 0; i < games.size(); i++) {
            if(is_played == games.get(i).getPlayed()){
               p.add(games.get(i));
            }
        }  
        return p;
    }
    
    /**
     * aggiungo stampa algpritmo di berger per stampare in modo bello tutte 
     * le mie partite di un calendario.
     * @param calendar viene passato alla funzione che stamperà il calendario
     * con le giornate, squadra di casa e squadra fuori casa.
     */
    public void printCalendar(Calendar calendar){
        System.out.println("Anno: " + calendar.getYear());
        for (int i = 0; i < getGames().size(); i++) {
            System.out.print(calendar.getGames().get(i).getDay());
            System.out.print(calendar.getGames().get(i).getHomeTeam() + " - ");
            System.out.print(calendar.getGames().get(i).getGuestTeam());
        }
    }
    
  /**
   * Algoritmo per la creazione del calendario di uno sport
   * @param teams indica l'ArrayList di squadre che vengono passate alla funzione 
   */  
public void AlgoritmoDiBerger(ArrayList<Team> teams){
    games = new ArrayList();
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
