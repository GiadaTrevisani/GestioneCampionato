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
 * La classe Team avrà come parametri il nome della squadra,
 * il nome della città e il logo.
 * Il logo sarà rappresentato da un'immagine del logo della squdra,
 * se non esiste un logo, ne sarà assegnato uno di default.
*/


public class Team {
    
    private String name;
    private String city;
    private int logo; 
    
    public Team(String name, String city, int logo){
        this.name = name;
        this.city = city;
        this.logo = logo;
    }
    
    public String getName(){
        return name;
    }
    
    public String getCity(){
        return city;
    }
    
    public int getLogo(){
        return logo;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setCity(String city){
        this.city = city;
    }
    
    public void setLogo(int logo){
        this.logo = logo;
    }
}
