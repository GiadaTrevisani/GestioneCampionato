/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import model.Partita;
/**
 *
 * @author giadatrevisani
 */

/*
 * La classe Calendario avrà come parametri un array di partite (grandezza?)
 * e l'anno del campionato.
 */
public class Calendario {
    
    private Partita[] partite;
    private int anno, numero;
    
    public Calendario(Partita[] partite, int anno, int numeroPartite){
        this.numero = numeroPartite;
        this.partite = new Partita[numero];
        for (int i = 0; i < numero; i++) {
            this.partite[i] = partite[i];
        }
        this.anno = anno;
    }
  
    public int getNumero(){
        return numero;
    }
    
    public Partita[] getPartite(){
        return partite;      
    }
    
    public int getAnno(){
        return anno;
    }
    
    public void setPartite(Partita[] p, int numero){
            for (int i = 0; i < numero; i++) {
                this.partite[i] = p[i]; 
            }
    }
    
    public void setAnno(int anno){
        this.anno = anno;
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public Partita[] getPartiteForDate(Date data){
        Partita[] p = new Partita[numero];
        for (int i = 0; i < numero; i++) {
            p[i] = null;
        }
        int j = 0;
        for (int i = 0; i < numero; i++) {
            if(data == partite[i].getData()){
               p[j] = partite[i];
               j++;
            }
        }
        
        return p;
    }  
    
    public Partita[] getPartiteForSquadra(String nomeSquadra){
        Partita[] p = new Partita[numero];
        for (int i = 0; i < numero; i++) {
            p[i] = null;
        }
        int j = 0;
        for (int i = 0; i < numero; i++) {
            if(nomeSquadra == partite[i].getSquadraCasa().getNome()){
               p[j] = partite[i];
               j++;
            }
            if(nomeSquadra == partite[i].getSquadraOspite().getNome()){
                p[j] = partite[i];
               j++;
            }
        }  
        return p;
    }
    
    public Partita[] getPartiteGiocate(Boolean is_played){
        Partita[] p = new Partita[numero];
        for (int i = 0; i < numero; i++) {
            p[i] = null;
        }
        int j = 0;
        for (int i = 0; i < numero; i++) {
            if(is_played == partite[i].getGiocata()){
               p[j] = partite[i];
               j++;
            }
        }  
        return p;
    }
}
