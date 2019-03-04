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
import java.util.function.Consumer;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

/**
 * La classe Calendar avrà come parametri un array di partite
 * e l'anno del campionato.
 * @author giadatrevisani
 */
public class Calendar {
    private ArrayList<Match> games;
    private int year;
    
    /**
     * Primo costruttore che prende in ingresso un array di partite già esistente
     * e l'anno di questo campionato.
     * @param games che indica l'Arrayist di tipo Match che saranno inseriti
     * nell'ArrayList nuovo.
     * @param year che indica l'anno in cui si svolge il campionato.
     */
    public Calendar(ArrayList<Match> games, int year){
        this.games = games;
        this.year = year;
    }
    
    /**
     * Secondo costruttore che prende in ingresso un intero che indica l'anno
     * di questo campionato.
     * @param year indica l'anno in cui si svolge il campionato.
     */
    public Calendar(int year){
        this.year = year;
        games = new ArrayList<Match>();
    }
    
    /**
     * Terzo costruttore che non prende niente in ingresso.
     */
    public Calendar(){
        this.year = 0;
        games = new ArrayList<Match>();
    }
    
    /**
     * Metodo che ritorna i match nell'ArrayList di partite.
     * @return arraylist di partite.
     */
    public ArrayList<Match> getGames(){
        return games;
    }
    
    /**
     * Metodo che ritorna l'anno in cui si svolge il campionato.
     * @return intero che indica l'anno di questo campionato.
     */
    public int getYear(){
        return year;
    }
    
    /**
     * Metodo che setta l'ArrayList di partite che vengono passate in input.
     * @param games ArrayList di partite.
     */
    public void setGames(ArrayList<Match> games){
        this.games = games;
    }
    
    /**
     * Metodo che setta l'anno del campionato che si vuole creare.
     * @param year intero che indica l'anno.
     */
    public void setYear(int year){
        this.year = year;
    }
    
     
    /**
     * Metodo che serializza e salva siu file il calendario.
     * @param filePath stringa con il filepath.
     * @throws FileNotFoundException 
     */
    public void saveCalendar(String filePath) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(filePath); 
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
     * Metodo per deserializzare il calendario da un salvataggio Json.
     * @param filePath stringa che indica il filepath.
     * @param teams ArrayList di tipo Team.
     * @param callback funzione di callback che viene chiamata per notificare il
     * progresso del caricamento.
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     * @throws Exception 
     */
    public void takeFromFile(String filePath, ArrayList<Team> teams, Consumer<Integer> callback) throws FileNotFoundException, IOException, ParseException, Exception {
        games = new ArrayList<Match>();
        Object obj = new JSONParser().parse(new FileReader(filePath));
        JSONObject jo = (JSONObject) obj;

        this.year = new Long((long) jo.get("Year")).intValue();
        JSONArray ja = (JSONArray) jo.get("Games");
        float total = ja.size();
        try{
            for (int i = 0; i < ja.size(); i++) {
                int percent = (int) ((float)i/total * 100.0);
                if(callback != null){
                    callback.accept(percent);
                }
                games.add(Match.fromJSONObject((JSONObject) ja.get(i), teams));
            }

            if(callback != null){
                callback.accept(100);
            }
        } catch(Exception e) {
            if(callback != null){
                callback.accept(0);
            }
            System.out.println("Il calendario caricato non corrisponde ai team presenti");
            //JOptionPane.showMessageDialog(null, "Il calendario caricato non corrisponde ai team presenti");
            throw new Exception("Il calendario caricato non corrisponde ai team presenti");
        }
    }
    
    
    /**
     * Metodo che torna un array di partite che si svolgono nella stessa giornata.
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
     * Metodo per resettare i risultati di tutte le partite. Questo metodo 
     * scorre tutti i games e tramite il metodo resetResults elimina tutti i 
     * risultati.
     */
    public void deleteResults(){
        for (int i = 0; i < games.size(); i++) {
            games.get(i).resetResults();
        }
    }
    
    /**
     * Metodo per calcolare il numero di giornate nel campionato.
     * @return intero che contiene il numero di giornate.
     */
    public int getNumDays(){
        int maxDay = 0;
        for (Match game : games) {
            if(game.getDay() >= maxDay){
                maxDay = game.getDay();
            }
        }
        
        return maxDay;
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
   * Algoritmo per la creazione del calendario di uno sport.
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
        
        //Crea il ritorno, fino a qui l'algoritmo ha creato l'andata
        int num_games_andata = games.size();
        for (int i = 0; i < num_games_andata; i++) {
            games.add(Match.swapHomeGuest(games.get(i), days));
        }
    }

    /**
     * Metodo che esegue uno shift a sinistra di un array di team e che riempie
     * lo spazio vuoto con un'altro team.
     * @param data Array da shiftare.
     * @param add oggetto di tipo team che riempie lo spazio vuoto.
     * @return array shiftato.
     */
    private Team[] shiftLeft(Team[] data, Team add) {
       Team[] temp = new Team[data.length];
       for (int i = 0; i < data.length-1; i++) {
               temp[i] = data[i + 1];
       }
       temp[data.length - 1] = add;
       return temp;
    }
    
    /**
     * Metodo che esegue uno shift a destra di un array di team e che riempie
     * lo spazio vuoto con un'altro team.
     * @param data Array da shiftare.
     * @param add oggetto di tipo team che riempie lo spazio vuoto.
     * @return array shiftato.
     */
    private Team[] shiftRight(Team[] data, Team add) {
        Team[] temp = new Team[data.length];
        for (int i = 1; i < data.length; i++) {
                temp[i] = data[i - 1];
        }
        temp[0] = add;
        return temp;
    }
}