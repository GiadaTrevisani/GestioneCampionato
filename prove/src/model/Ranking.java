/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.FileNotFoundException;
import java.io.PrintWriter; 
import org.json.simple.JSONObject; 
/**
 *
 * @author giadatrevisani
 */
public abstract class Ranking {
    private Team[] teams;
    private Ranking ranking;
    
    public Ranking(Team[] teams, Ranking ranking, int numero){
        this.ranking = ranking;
        for (int i = 0; i < numero; i++) {
            this.teams[i] = teams[i];
        }
    }
    
    public Ranking getRanking(){
        return ranking;
    }
    
    public Team[] getTeams(){
        return teams;
    }
    
    public void setRanking(Ranking ranking){
        this.ranking = ranking;
    }
    
    public void setTeams(Team[] teams, int numero){
        for (int i = 0; i < numero ; i++) {
            this.teams[i] = teams[i];
        }
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
    public void saveTeams(int numero, Team[] teams) throws FileNotFoundException{
        JSONObject jo = new JSONObject();
        for (int i = 0; i < numero; i++) {
            jo.put("nome" , teams[i].getName());
            jo.put("città", teams[i].getCity());
            jo.put("logo", teams[i].getLogo());
        }
        // writing JSON to file:"JSONExample.json" in cwd 
        PrintWriter pw = new PrintWriter("JSONExample.json"); 
        pw.write(jo.toJSONString()); 
          
        pw.flush(); 
        pw.close(); 
    }
    
    public abstract int getWinForTeam(String teamName, Match[] games, int numero);
    
    public abstract int getLooseForTeam(String teamName, int numero, Match[] games);
    
    public abstract int getpointsForTeam(String teamName, int numero, Match[] games);
}
