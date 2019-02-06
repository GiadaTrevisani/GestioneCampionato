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
/**
 * Nella classe Match sono presenti come parametri i nomi delle 
 * due squadre (casa e ospite) che giocheranno la partita, la data, 
 * il risultato che ha ottenuto la squadra che gioca in casa e 
 * il risutato che ha ottenuto la squadra ospite.
 * In più si è aggiunto un altra variabile booleana che dice se la 
 * partita è stata giocata oppure no.
*/
public class Match{
    
    private Team homeTeam;
    private Team guestTeam;
    private Date data;
    private int homeResult;
    private int guestResult;
    private boolean played;
    
    /**
     * Quando viene chiamato il costruttore, la partita può essere già stata
     * giocata oppure no. Si prevede che, nel caso in cui la partita non sia 
     * stata giocata, il punteggio delle due squadre passato per paramentro 
     * sia uguale a 0 e che il parametro giocata sia settato a false.
     */
    public Match(Team homeTeam, Team guestTeam, int homeResult, int guestResult, Date data, boolean played){
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.data = data;
        this.homeResult = homeResult;
        this.guestResult = guestResult;
        this.played = played;
    }
    
    public Team getHomeTeam(){
        return this.homeTeam;
    }
    
    public Team getGuestTeam(){
        return this.guestTeam;
    }
    
    public int getPointsHome(){
        return this.homeResult;
    }
    
    public int getPointsGuest(){
        return this.guestResult;
    }
    
    public Date getData(){
        return this.data;
    }
    
    public boolean getPlayed(){
        return this.played;
    }
    
    public void setHomeTeam(Team homeTeam){
        this.homeTeam = homeTeam;
    }
    
    public void setGuestTeam(Team guestTeam){
        this.guestTeam = guestTeam;
    }
    
    public void setHomePoints(int homeResult){
        this.homeResult = homeResult;
    }
    
    public void setGuestPoints(int guestResult){
        this.guestResult = guestResult;
    }
    
    public void setData(Date data){
        this.data = data;
    }
    
    public void setPlayed(boolean played){
        this.played = played;
    }
    
}
