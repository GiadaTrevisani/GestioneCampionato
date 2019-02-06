/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
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

    public ArrayList getGamesForDate(Date data){
        ArrayList<Match> p;
        p = new ArrayList();
        int j = 0;
        for (int i = 0; i < games.size(); i++) {
            if(data == games.get(i).getData()){
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
}
