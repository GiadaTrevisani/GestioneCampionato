/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author giadatrevisani
 */

/*
 * La classe Squadra avrà come parametri il nome della squadra,
 * il nome della città e il logo.
 * Il logo sarà rappresentato da un'immagine del logo della squdra,
 * se non esiste un logo, ne sarà assegnato uno di default.
*/


public class Squadra {
    
    private String nome, città;
    private int logo; 
    
    public Squadra(String nome, String città, int logo){
        this.nome = nome;
        this.città = città;
        this.logo = logo;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getCittà(){
        return città;
    }
    
    public int getLogo(){
        return logo;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setCittà(String città){
        this.città = città;
    }
    
    public void setLogo(int logo){
        this.logo = logo;
    }
}
