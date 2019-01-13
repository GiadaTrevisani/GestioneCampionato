/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
/**
 *
 * @author giadatrevisani
 */

/*
 * La classe Calendar avrà come parametri un array di partite (grandezza?)
 * e l'anno del campionato.
 */
public class Calendar {
    
    private Match[] games;
    private int year, numero;
    
    public Calendar(Match[] games, int year, int numeroPartite){
        this.numero = numeroPartite;
        this.games = new Match[numero];
        for (int i = 0; i < numero; i++) {
            this.games[i] = games[i];
        }
        this.year = year;
    }
  
    public int getNumber(){
        return numero;
    }
    
    public Match[] getGames(){
        return games;      
    }
    
    public int getYear(){
        return year;
    }
    
    public void setGames(Match[] games, int numero){
            for (int i = 0; i < numero; i++) {
                this.games[i] = games[i]; 
            }
    }
    
    public void setYear(int year){
        this.year = year;
    }
    
    public void setNumber(int numero){
        this.numero = numero;
    }
    
    public Match[] getGamesForDate(Date data){
        Match[] p = new Match[numero];
        for (int i = 0; i < numero; i++) {
            p[i] = null;
        }
        int j = 0;
        for (int i = 0; i < numero; i++) {
            if(data == games[i].getData()){
               p[j] = games[i];
               j++;
            }
        }
        
        return p;
    }  
    
    public Match[] getGamesForTeam(String teamName){
        Match[] p = new Match[numero];
        for (int i = 0; i < numero; i++) {
            p[i] = null;
        }
        int j = 0;
        for (int i = 0; i < numero; i++) {
            if(teamName == games[i].getHomeTeam().getName()){
               p[j] = games[i];
               j++;
            }
            if(teamName == games[i].getGuestTeam().getName()){
                p[j] = games[i];
               j++;
            }
        }  
        return p;
    }
    
    public Match[] getPlayedGames(Boolean is_played){
        Match[] p = new Match[numero];
        for (int i = 0; i < numero; i++) {
            p[i] = null;
        }
        int j = 0;
        for (int i = 0; i < numero; i++) {
            if(is_played == games[i].getPlayed()){
               p[j] = games[i];
               j++;
            }
        }  
        return p;
    }
}
