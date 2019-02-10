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
    private ArrayList<Team> teams;
    private final Team team;
    private static final String filePath = "prove/JSONExample.json";
    
    public Ranking(ArrayList<Team> teams, Team team){
        this.team = team;
        this.teams = teams;   
    }
    
    public ArrayList<Team> getTeams(){
        return teams;
    }
    
    public void setTeams(ArrayList<Team> teams){
            this.teams = teams;
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
    
    public void setAllTeam(ArrayList<Team> teams){
        this.teams = teams;
    }
    
    
    /**
     * questo metodo aggiunge un team all'array di squadre.
     * (quando aggiungo una squadra uso questo metodo )
     */
    public void addTeam(String name, String city,int logo){
        this.team.name = name;
        this.team.city = city;
        this.team.logo = logo;
        teams.add( team);
    }
    
    public abstract int getWinForTeam(String teamName, ArrayList<Match> games);
    
    public abstract int getLooseForTeam(String teamName, ArrayList<Match> games);
    
    public abstract int getpointsForTeam(String teamName, ArrayList<Match> games);
}
