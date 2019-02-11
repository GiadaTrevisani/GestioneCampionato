/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author giadatrevisani
 */

/**
 * La classe Team avrà come parametri il nome della squadra,
 * il nome della città e il logo.
 * Il logo sarà rappresentato da un'immagine del logo della squdra,
 * se non esiste un logo, ne sarà assegnato uno di default.
*/

public class Team {
    String name;
    String city;
    int logo; 
    
    /**
     * Costruttore che crea una squadra.
     * @param name indica il nome della squadra.
     * @param city indica la città della squadra.
     * @param logo indica il logo della squadra.
     */
    public Team(String name, String city, int logo){
        this.name = name;
        this.city = city;
        this.logo = logo; 
    }
    
    /**
     * Metodo per visualizzare il nome della squadra fuori dalla classe Team.
     * @return il nome della squadra.
     */
    public String getName(){
        return name;
    }
    
    /**
     * Metodo per visualizzare il nome della città fuori dalla classe Team.
     * @return il nome della città.
     */
    public String getCity(){
        return city;
    }
    
    /**
     * Metodo per visualizzare il logo della squadra fuori dalla classe Team.
     * @return il logo della squadra.
     */
    public int getLogo(){
        return logo;
    }
    
    /**
     * Metodo per settare il nome della squadra passato come parametro.
     * @param name nome della squadra.
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Metodo per settare il nome della città passato come parametro.
     * @param name nome della città.
     */
    public void setCity(String city){
        this.city = city;
    }
    
    /**
     * Metodo per settare il logo della squadra passato come parametro.
     * @param name logo della squadra.
     */
    public void setLogo(int logo){
        this.logo = logo;
    }
  
}

