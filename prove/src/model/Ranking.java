/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter; 
import java.util.ArrayList;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
/**
 *
 * @author giadatrevisani
 */
public abstract class Ranking {
    protected ArrayList<Team> teams;
    private static final String filePath = "prove/JSONExample.json";
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
    
    /**
     * Metodo per settare l'ArrayList delle squadre passato come parametro.
     * @param teams ArrayList di squadre.
     */
    public void setTeams(ArrayList<Team> teams){
            this.teams = teams;
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
     * (quando aggiungo una squadra uso questo metodo )
     */
    public void addTeam(Team newTeam){
        teams.add(newTeam);
    }

    /**
     * Metodo che aggiunge un team all'ArrayList di squadre.
     * @param name indica il nome della squadra.
     * @param city indica il nome della città.
     * @param logo indica il logo della squadra.
     */
    public void addTeam(String name, String city,int logo){
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
    */
    public void saveTeams() throws FileNotFoundException{
        JSONObject jo = new JSONObject();   
        for (int i = 0; i < teams.size(); i++) {
            jo.put("nome" , teams.get(i).getName());
            jo.put("città", teams.get(i).getCity());
            jo.put("logo", teams.get(i).getLogo());
        }
        
        // writing JSON to file:"JSONExample.json" in cwd 
        PrintWriter pw = new PrintWriter("JSONExample.json"); 
        pw.write(jo.toJSONString()); 
          
        pw.flush(); 
        pw.close(); 
    }
    
    /**
     * Metodo che crea un file JSon per il salvataggio delle squadre su file.
     */
    public void takeFromFile() throws Exception{
        // parsing file "JSONExample.json" 
        Object obj = new JSONParser().parse(new FileReader("JSONExample.json"));          
        // typecasting obj to JSONObject 
        JSONObject jo = (JSONObject) obj; 
          
        // getting firstName and lastName 
        String teamName = (String) jo.get("Name"); 
        String teamCity = (String) jo.get("City"); 
        int teamLogo = (int) jo.get("Logo");
          
        System.out.println(teamName); 
        System.out.println(teamCity); 
        System.out.println(teamLogo);
        
    
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
