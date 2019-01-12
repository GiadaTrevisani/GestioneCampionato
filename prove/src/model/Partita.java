/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import model.Squadra;
/**
 *
 * @author giadatrevisani
 */

/*
 * Nella classe Partita sono presenti come parametri i nomi delle 
 * due squadre (casa e ospite) che giocheranno la partita, la data, 
 * il risultato che ha ottenuto la squadra che gioca in casa e 
 * il risutato che ha ottenuto la squadra ospite.
 * In più si è aggiunto un altra variabile booleana che dice se la 
 * partita è stata giocata oppure no.
*/
public class Partita{
    
    private Squadra squadraCasa;
    private Squadra squadraOspite;
    private Date data;
    private int risultatoCasa;
    private int risultatoOspite;
    private boolean giocata;
    
    /*
     * Quando viene chiamato il costruttore, la partita può essere già stata
     * giocata oppure no. Si prevede che, nel caso in cui la partita non sia 
     * stata giocata, il punteggio delle due squadre passato per paramentro 
     * sia uguale a 0 e che il parametro giocata sia settato a false.
     */
    public Partita(Squadra sCasa, Squadra sOspite, int rCasa, int rOspite, Date data, boolean giocata){
        this.squadraCasa = sCasa;
        this.squadraOspite = sOspite;
        this.data = data;
        this.risultatoCasa = rCasa;
        this.risultatoOspite = rOspite;
        this.giocata = giocata;
    }
    
    public Squadra getSquadraCasa(){
        return this.squadraCasa;
    }
    
    public Squadra getSquadraOspite(){
        return this.squadraOspite;
    }
    
    public int getPuntiCasa(){
        return this.risultatoCasa;
    }
    
    public int getPuntiOspite(){
        return this.risultatoOspite;
    }
    
    public Date getData(){
        return this.data;
    }
    
    public boolean getGiocata(){
        return this.giocata;
    }
    
    public void setSquadraCasa(Squadra sCasa){
        this.squadraCasa = sCasa;
    }
    
    public void setSquadraOspite(Squadra sOspite){
        this.squadraOspite = sOspite;
    }
    
    public void setPuntiCasa(int rCasa){
        this.risultatoCasa = rCasa;
    }
    
    public void setPuntiOspite(int rOspite){
        this.risultatoOspite = rOspite;
    }
    
    public void setData(Date data){
        this.data = data;
    }
    
    public void setGiocata(boolean giocata){
        this.giocata = giocata;
    }
    
}
