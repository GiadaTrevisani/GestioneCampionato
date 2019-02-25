/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
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
    public Calendar(){
        this.year = 0;
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
     * Metodo che crea un file JSon per il salvataggio del calendario su file.
     */
    public void saveCalendar() throws FileNotFoundException{
        PrintWriter pw = new PrintWriter("calendar.json"); 
        JSONObject jo = new JSONObject();
        jo.put("Year", year);
        JSONArray ja = new JSONArray();
        
        for (int i = 0; i < games.size(); i++) {
            ja.add(games.get(i).toJSONObject());
        }
        
        jo.put("Games", ja);
        
        pw.write(jo.toJSONString());
        pw.flush();
        pw.close();
        
    }
    
    /**
     * Metodo per caricare il calendario da un salvataggio Json.
     */
    public void takeFromFile(ArrayList<Team> teams){
       games = new ArrayList<Match>();
       Object obj;
       try {
            obj = new JSONParser().parse(new FileReader("calendar.json"));
        } catch (IOException | ParseException ex) {
            System.out.println("Il file salvatagio non esiste per i match");
            JOptionPane.showMessageDialog(null, "Il file salvataggio non esiste per i match");
            return ;
        }
       JSONObject jo = (JSONObject) obj;
       
       this.year = (int) jo.get("Year");
       JSONArray ja = (JSONArray) jo.get("Games");
       
       try{
        for (int i = 0; i < ja.size(); i++) {
            games.add(Match.fromJSONObject((JSONObject) ja.get(i), teams));
        }
       } catch(Exception e) {
           System.out.println("Il calendario caricato non corrisponde ai team presenti");
           JOptionPane.showMessageDialog(null, "Il calendario caricato non corrisponde ai team presenti");
       }
    }
    
    
    /**
     * Metodo che torna un array di partite che si svolgono nella stessa giornata
     * @param day viene passato in ingresso al metodo che servirà per fare 
     * un controllo delle partite inserite nell'ArrayList games.
     * @return ArrayList con le partite che si volgono nella stessa giornata.
     */
    public ArrayList<Match> getGamesForDate(int day){
        ArrayList<Match> p = new ArrayList<Match>();
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
        ArrayList<Match> p = new ArrayList<Match>();
        for (int i = 0; i < games.size(); i++) {
            if(teamName.equals(games.get(i).getHomeTeam().getName()) || teamName.equals(games.get(i).getGuestTeam().getName())){
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
        ArrayList<Match> p = new ArrayList<Match>();
        for (int i = 0; i < games.size(); i++) {
            if(is_played == games.get(i).getPlayed()){
               p.add(games.get(i));
            }
        }

        return p;
    }
    
    /**
     * Metodo per resettare i risultati di tutte le partite.
     */
    public void deleteResults(){
        for (int i = 0; i < games.size(); i++) {
            games.get(i).resetResults();
        }
    }
    
    /**
     * aggiungo stampa algpritmo di berger per stampare in modo bello tutte 
     * le mie partite di un calendario.
     */
    public void printCalendar(){
        System.out.println("Anno: " + year + "\n");
        for (int i = 0; i < games.size(); i++) {
            System.out.print(games.get(i).getDay() + "   ");
            System.out.print(games.get(i).getHomeTeam().getName() + "  -  ");
            System.out.print(games.get(i).getGuestTeam().getName() + "\n");
        }
    }
    
  /**
   * Algoritmo per la creazione del calendario di uno sport
   * @param teams indica l'ArrayList di squadre che vengono passate alla funzione 
   */  
    public void AlgoritmoDiBerger(ArrayList<Team> teams){
        games = new ArrayList<Match>(); // reset dell'array games (vuoto)
        int number_teams = teams.size();

        Team jolly = new Team("Jolly", "Jolly", "GestioneSquadre/prove/img_logo/Carpi.png");

        if (number_teams%2 != 0) {
            //Fai qualcosa quando le squadre sono dispari
            teams.add(jolly);
            number_teams = number_teams + 1;
        }

        int days = number_teams - 1;

        /* crea gli array per le due liste in casa e fuori */
        Team[] home = new Team[number_teams /2];
        Team[] guest = new Team[number_teams /2];

        for (int i = 0; i < number_teams /2; i++){
            home[i] = teams.get(i); 
            guest[i] = teams.get(number_teams - 1 - i); 
        }

        for (int i = 0; i < days; i++) {

            /* alterna le partite in casa e fuori */
            if (i % 2 == 0) {
                for (int j = 0; j < number_teams /2 ; j++){
                    // Controllo che non sia una delle partite con il jolly per gestire i dispari
                    if (guest[j] != jolly && home[j] != jolly) {
                            Match m = new Match(home[j], guest[j], i+1);
                            games.add(m);
                    }
                }
            }
            else {
                for (int j = 0; j < number_teams /2 ; j++) {
                    // Controllo che non sia una delle partite con il jolly per gestire i dispari
                    if (guest[j] != jolly && home[j] != jolly) {
                            Match m = new Match(guest[j], home[j], i+1); // inverto home e guest
                            games.add(m);
                    }
                }
            }

            // Ruota in gli elementi delle liste, tenendo fisso il primo elemento
            // Salva l'elemento fisso
            Team pivot = home[0];

            /* sposta in avanti gli elementi di "trasferta" inserendo 
             * all'inizio l'elemento casa[1] e salva l'elemento uscente in "riporto" */
            Team riporto = guest[guest.length - 1];
            guest = shiftRight(guest, home[1]);

            /* sposta a sinistra gli elementi di "casa" inserendo all'ultimo 
             * posto l'elemento "riporto" */
            home = shiftLeft(home, riporto);

            // ripristina l'elemento fisso
            home[0] = pivot;
        }

        // rimuovi se presente il team jolly
        teams.remove(jolly);
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