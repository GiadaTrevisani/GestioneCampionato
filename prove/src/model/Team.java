/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.json.simple.JSONObject;

/**
 * La classe Team avrà come parametri il nome della squadra,
 * il nome della città e il logo.
 * Il logo sarà rappresentato da un'immagine del logo della squdra,
 * se non esiste un logo, ne sarà assegnato uno di default.
 * @author giadatrevisani
*/
public class Team {
    String name;
    String city;
    String logo; 
    
    /**
     * Costruttore che crea una squadra.
     * @param name indica il nome della squadra.
     * @param city indica la città della squadra.
     * @param logo indica il file path dell'immagine del logo della squadra.
     */
    public Team(String name, String city, String logo){
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
     * @return il file path del logo della squadra.
     */
    public String getLogo(){
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
     * @param city indica il nome della città della squadra.
     */
    public void setCity(String city){
        this.city = city;
    }
    
    /**
     * Metodo per settare il logo della squadra passato come parametro.
     * @param logo indica il file path del logo della squadra.
     */
    public void setLogo(String logo){
        this.logo = logo;
    }
    
    /**
     * Metodo che serializza questo oggetto di tipo Team in un oggetto di tipo
     * JSON.
     * @return un JSONObject contenente i dati di un Team.
     */
    public JSONObject toJSONObject(){
        JSONObject jo = new JSONObject();
        jo.put("Name" , getName());
        jo.put("City", getCity());
        jo.put("Logo", getLogo());
        
        return jo;
    }
    
    /**
     * Metodo che deserializza un oggetto di tipo JSON che viene passato come
     * parametro e genera un oggetto di tipo team con le informazioni contenute 
     * nell'oggetto di tipo JSON.
     * @param jo oggeto JSON.
     * @return un oggetto di tipo team con le informazioni contenute 
     * nell'oggetto di tipo JSON.
     */
    public static Team fromJSONObject(JSONObject jo){
        String teamName = (String) jo.get("Name"); 
        String teamCity = (String) jo.get("City"); 
        String teamLogo = (String) jo.get("Logo");

        Team nt = new Team(teamName, teamCity, teamLogo);
        return nt;
    }
}

