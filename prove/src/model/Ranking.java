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
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
/**
 *
 * @author giadatrevisani
 */
public abstract class Ranking {
    protected ArrayList<Team> teams;
    protected Calendar calendar;
    
    /**
     * Primo costruttore che inizialiiza l'ArrayList di squadre e il calendario.
     * @param calendar parametro di tipo calendario.
     */
    public Ranking(Calendar calendar){
        teams = new ArrayList<Team>();
        this.calendar = calendar;
    }

    /**
     * Secondo costuttore che inizzializza l'ArrayList di squadre e il calendario
     * passato come parametri.
     * @param teams ArrayList di squadre.
     * @param calendar parametro di tipo calendario.
     */
    public Ranking(ArrayList<Team> teams, Calendar calendar){
        this.teams = teams;
        this.calendar = calendar;
    }

    /**
     * Terzo costruttore che inizzializza l'ArrayList di squadre passato come parametro
     * e un calendario.
     * @param teams ArrayList di squadre.
     */
    public Ranking(ArrayList<Team> teams){
        this.teams = teams;
        calendar = new Calendar(-1);
    }

    /**
     * Quarto costruttore che inizialliza l'ArrayList di squadre e il clendario.
     */
    public Ranking(){
        teams = new ArrayList<Team>();
        calendar = new Calendar(-1);
    }
    
    public ArrayList<Team> getTeam(){
        return teams;
    }
    
    /**
     * Metodo per settare l'ArrayList delle squadre passato come parametro.
     * @param teams ArrayList di squadre.
     */
    public void setTeams(ArrayList<Team> teams){
            this.teams = teams;
    }
    
    /**
     * Metodo che serve per eliminare una squadra dall'array delle squadre dato
     * un nome.
     * @param name indica i nome della squadra. 
     */
    public void deleteTeam(String name){
        for (int i = 0; i < teams.size(); i++) {
            if(teams.get(i).getName().equals(name)){
                teams.remove(i);
            }
        }
    }
    
    /**
     * Metodo per visualizzare il calendario al di fuori della classe Ranking.
     * @return oggetto di tipo Calendar.
     */
    public Calendar getCalendar(){
        return calendar;
    }
    
    /**
     * Metodo che setta un calendario passato come parametro.
     * @param calendar oggetto di tipo Calendar
     */
    public void setCalendar(Calendar calendar){
        this.calendar = calendar;
    }
    
    /**
     * questo metodo aggiunge un team all'array di squadre.
     * (quando aggiungo una squadra uso questo metodo).
     * @param newTeam indica una squadra.
     */
    public void addTeam(Team newTeam){
        for (int i = 0; i < teams.size(); i++) {
            if(newTeam.getName().equals(teams.get(i).getName())){
                System.out.println("Squadra con questo nome già esistente");
                return ;
            }     
        }
        teams.add(newTeam);
    }

    /**
     * Metodo che aggiunge un team all'ArrayList di squadre.
     * @param name indica il nome della squadra.
     * @param city indica il nome della città.
     * @param logo indica il file path del logo della squadra.
     */
    public void addTeam(String name, String city,String logo){
	Team newTeam = new Team(name, city, logo);
        this.addTeam(newTeam);
    }
    
    /**
    * creiamo un file Json per salvarmi le mie squadre su file
    * procederò creando un file Json e inserendoci tutte le
    * entità presenti per ogni squadra, cioè il nome della
    * squadra, il nome della città, e il percorso del logo
    * (es. images/solierav.jpg)
    * Per creare questo file mi affiderò alle librerie di Java
    * riportate all'inizio del file.
    * @throws java.io.FileNotFoundException
    */
    public void saveTeams() throws FileNotFoundException{
        // writing JSON to file:"teams.json" in cwd 
        PrintWriter pw = new PrintWriter("teams.json"); 
        JSONArray ja = new JSONArray();
        for (int i = 0; i < teams.size(); i++) { 
            ja.add(teams.get(i).toJSONObject());
        }
        pw.write(ja.toJSONString());
          
        pw.flush(); 
        pw.close(); 
    }
    
    /**
     * Metodo per caricare le squadre da un salvataggio Json.
     */
    public void takeFromFile() {
        teams = new ArrayList<Team>();
        // parsing file "teams.json" 
        Object obj;          
        try {
            obj = new JSONParser().parse(new FileReader("teams.json"));
        } catch (IOException | ParseException ex) {
            System.out.println("Il file salvatagio non esiste per i team");
            return ;
        }
        // typecasting obj to JSONObject 
        JSONArray ja = (JSONArray) obj;
          
        for (int i = 0; i < ja.size(); i++) {
            JSONObject jo = (JSONObject) ja.get(i);
            addTeam(Team.fromJSONObject(jo));

        }
    
    }
    
    /**
     * Metodo per il calcolo delle partite vinte per una squadra passata come parametro.
     * @param teamName nome della squadra.
     * @return intero con il numero delle parite vinte.
     */
    public abstract int getWinForTeam(String teamName);
    
    /**
     * Metodo per il calcolo delle partite perse per una squadra passata come parametro.
     * @param teamName nome della squadra.
     * @return intero con il numero delle parite perse.
     */
    public abstract int getLooseForTeam(String teamName);
    
    /**
     * Metodo per il calcolo dei punti per una squadra passata come parametro.
     * @param teamName nome della squadra.
     * @return intero con il numero dei punti totalizzati dalla squadra.
     */
    public abstract int getpointsForTeam(String teamName);
}
