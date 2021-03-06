/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 * Classe che estende la classe Ranking e si specializza con lo sport basket.
 * @author giadatrevisani
 */
public class RankingBasket extends Ranking{

    /**
     * Primo costruttore che prende in ingresso un oggetto di tipo calendar.
     * @param calendar oggetto di tipo calendar.
     */
    public RankingBasket(Calendar calendar){
        super(calendar);
    }

    /**
     * Secondo costruttore che prende in ingresso un arraylist di team e un 
     * oggetto di tipo calendar.
     * @param teams ArrayList di team.
     * @param calendar oggetto di tipo Calendar.
     */
    public RankingBasket(ArrayList<Team> teams, Calendar calendar){
        super(teams, calendar);
    }

    /**
     * Terzo costruttore che prende in ingresso un ArrayList di team. 
     * @param teams ArrayList di team.
     */
    public RankingBasket(ArrayList<Team> teams){
        super(teams);
    }

    /**
     * Quarto costruttore che non prende in ingresso niente.
     */
    public RankingBasket(){
        super();
    }

    /**
     * Metodo per il calcolo delle partite vinte per una squadra passata come parametro.
     * @param teamName nome della squadra.
     * @return intero con il numero delle parite vinte.
     */
    @Override
    public int getWinForTeam(String teamName){
        ArrayList<Match> games = this.calendar.getGames();
        int partiteVinte = 0;
        for (int i = 0; i < games.size(); i++) {
            if(games.get(i).getPlayed() == true){
                if(teamName.equals(games.get(i).getHomeTeam().getName())){
                    if(games.get(i).getPointsHome() > games.get(i).getPointsGuest()){
                       partiteVinte++;
                    }
                }
                if(teamName.equals(games.get(i).getGuestTeam().getName())){
                    if(games.get(i).getPointsGuest() > games.get(i).getPointsHome()){
                       partiteVinte++;
                    }
                }
            }
        }
        return partiteVinte;
    }
    
    /**
     *  Metodo che calcola il numero delle partite perse della squadra passata come parametro.
     * @param teamName nome della squadra.
     * @return intero con il numero delle partite perse.
     */
    @Override
    public int getLooseForTeam(String teamName){
        ArrayList<Match> games = this.calendar.getGames();
        int partitePerse = 0;
        for (int i = 0; i < games.size(); i++) {
            if(games.get(i).getPlayed() == true){
                if(teamName.equals(games.get(i).getHomeTeam().getName())){
                    if(games.get(i).getPointsHome() < games.get(i).getPointsGuest()){
                       partitePerse++;
                    }
                }
                if(teamName.equals(games.get(i).getGuestTeam().getName())){
                    if(games.get(i).getPointsGuest() < games.get(i).getPointsHome()){
                       partitePerse++;
                    }
                }
            }
        }
        return partitePerse;
    }
    
    /**
     * Metodo per il calcolo delle partite pareggiate dalla squadra passata come parametro.
     * @param TeamName nome della squadra.
     * @return intero con il numero delle partite pareggiate della squadra.
     */
    @Override
    public int getPareForTeam(String TeamName){
        return 0;
    }

    /**
     * Metodo per il calcolo dei punti tolalizzati dalla squadra passata come parametro.
     * @param teamName nome della squadra.
     * @return intero con il numero totale dei punti della squdra.
     */
    @Override
    public int getPointsForTeam(String teamName){
        ArrayList<Match> games = this.calendar.getGames();
        int totalePunti = 0;
        for (int i = 0; i < games.size(); i++) {
            if(games.get(i).getPlayed() == true){
                if(teamName.equals(games.get(i).getHomeTeam().getName())){
                    /**
                     * se la condizione è vera vuol dire che la squadra in 
                     * questione è quella che cerchiamo, guardiamo se ha vinto e
                     * calcoliamo i punti da assegnare.
                     */
                    if(games.get(i).getPointsHome() > games.get(i).getPointsGuest()){
                        /**
                         * se la condizione è vera vuol dire che la squadra in
                         * questione ha vinto il match.
                        */
                            totalePunti = totalePunti + 2;
                    }
                }
                if(teamName.equals(games.get(i).getGuestTeam().getName())){
                    /**
                    * se la condizione è vera vuol dire che la squadra in 
                    * questione è quella che cerchiamo, guardiamo se ha vinto e
                    * calcoliamo i punti da assegnare.
                    */
                    if(games.get(i).getPointsGuest() > games.get(i).getPointsHome()){
                        /**
                         * se la condizione è vera vuol dire che la squadra in
                         * questione ha vinto il match.
                        */
                            totalePunti = totalePunti + 2;
                    }
                }
            }
        }
        return totalePunti;  
    }
}
