/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.awt.List;
import java.io.FileNotFoundException;
import java.io.PrintWriter; 
import java.util.ArrayList;
import org.json.simple.JSONObject; 
/**
 *
 * @author giadatrevisani
 */
public abstract class Ranking {
    private ArrayList<Team> teams;
    private Ranking ranking;
    
    public Ranking(ArrayList<Team> teams, Ranking ranking){
        this.teams = teams;
        this.ranking = ranking;
        
    }
    
    public Ranking getRanking(){
        return ranking;
    }
    
    public ArrayList<Team> getTeams(){
        return teams;
    }
    
    public void setRanking(Ranking ranking){
        this.ranking = ranking;
    }
    
    public void setTeams(ArrayList<Team> teams){
            this.teams = teams;
    }
    /*
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
    
    public abstract int getWinForTeam(String teamName, ArrayList<Match> games);
    
    public abstract int getLooseForTeam(String teamName, ArrayList<Match> games);
    
    public abstract int getpointsForTeam(String teamName, ArrayList<Match> games);
}
