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
public class RankingVolley extends Ranking{

    public RankingVolley(Calendar calendar){
        super(calendar);
    }

    public RankingVolley(ArrayList<Team> teams, Calendar calendar){
        super(teams, calendar);
    }

    public RankingVolley(ArrayList<Team> teams){
        super(teams);
    }

    public RankingVolley(){
        super();
    }
    
    /**
     * Metodo per il calcolo delle partite vinte per una squadra passata come parametro.
     * @param TeamName nome della squadra.
     * @return intero con il numero delle parite vinte.
     */
    @Override
    public int getWinForTeam(String TeamName){
        ArrayList<Match> games = this.calendar.getGames();
        int partiteVinte = 0;
        for (int i = 0; i < games.size(); i++) {
            if(TeamName.equals(games.get(i).getHomeTeam().getName())){
                /**
                 * se la condizione è vera vuol dire che la squadra in 
                 * questione è quella che cerchiamo, guardiamo se ha vinto e
                 * calcoliamo i punti da assegnare.
                 */
                if(games.get(i).getPointsHome() > games.get(i).getPointsGuest()){
                    /**
                     * se la condizione è vera vuol dire che la squadra in
                     * questione ha vinto il match.
                     * Quindi aggiungerò un punto per la partita vinta
                    */
                   partiteVinte ++;
                }
            }
            if(TeamName.equals(games.get(i).getGuestTeam().getName())){
                /**
                * se la condizione è vera vuol dire che la squadra in 
                * questione è quella che cerchiamo, guardiamo se ha vinto e
                * calcoliamo i punti da assegnare.
                */
                if(games.get(i).getPointsGuest() > games.get(i).getPointsHome()){
                    /**
                     * se la condizione è vera vuol dire che la squadra in
                     * questione ha vinto il match.
                     * Quindi aggiungerò un punto per la partita vinta.
                    */
                    partiteVinte++;
                }
            }
        }
        return partiteVinte;
    }

    /**
     * Metodo che calcola il numero delle partite perse della squadra passata come parametro.
     * @param TeamName nome della squadra.
     * @return intero con il numero di partite perse della squadra.
     */
    @Override
    public int getLooseForTeam(String TeamName) {
        ArrayList<Match> games = this.calendar.getGames();
        int partitePerse = 0;
        for (int i = 0; i < games.size(); i++) {
            if(TeamName.equals(games.get(i).getHomeTeam().getName())){
                /**
                 * se la condizione è vera vuol dire che la squadra in 
                 * questione è quella che cerchiamo, guardiamo se ha vinto e
                 * calcoliamo i punti da assegnare.
                 */
                if(games.get(i).getPointsHome() < games.get(i).getPointsGuest()){
                    /**
                     * se la condizione è vera, aggiungiamo una partita persa
                     * al totale delle partite perse.
                    */
                    partitePerse++;
                }
            }
            if(TeamName.equals(games.get(i).getGuestTeam().getName())){
                /**
                * se la condizione è vera vuol dire che la squadra in 
                * questione è quella che cerchiamo, guardiamo se ha vinto e
                * calcoliamo i punti da assegnare.
                */
                if(games.get(i).getPointsGuest() > games.get(i).getPointsHome() ){
                    /**
                     * se la condizione è vera, la squadra ha perso il match,
                     * quindi aggiungiamo una partita persa al totale delle 
                     * partite perse.
                    */
                    partitePerse++;
                }
            }
        }
        return partitePerse;
    }

    /**
     * Metodo per il calcolo dei punti tolalizzati dalla squadra passata come parametro.
     * @param TeamName nome della squadra.
     * @return intero con il numero dei punti totalizzati dalla squadra.
     */
    @Override
    public int getpointsForTeam(String TeamName) {
        ArrayList<Match> games = this.calendar.getGames();
        int totalePunti = 0;
        for (int i = 0; i < games.size(); i++) {
            if(TeamName.equals(games.get(i).getHomeTeam().getName())){
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
                    if(games.get(i).getPointsGuest() == 2 ){
                        /**
                         * se la condizione è vera il match è stato vinto 3 a 2 
                         * quindi assegneremo alla squadra di casa 2 punti 
                         * invece che 3.
                        */
                        totalePunti = totalePunti + 2;
                    } else {
                        /**
                         * se la condizione è falsa il match è stato vinto 3 a 0
                         * o 3 a 1, quindi assegneremo alla squadra di casa
                         * tutti e 3 i punti.
                        */
                        
                        totalePunti = totalePunti + 3;
                    }
                } else {
                    /**
                     * se la condizione è falsa vuol dire che la squadra in 
                     * questione ha perso il match, vediamo se ha vinto almeno 
                     * due set in modo tale da assegnargli 1 punto.
                    */
                    if(games.get(i).getPointsHome() == 2){
                        /**
                         * se la condizione è vera la squadra ha vinto almeno 
                         * due set, in modo tale da guadagnarsi almeno un punto.
                        */
                        totalePunti = totalePunti +1;
                    } else {
                    /**
                     * se la condizione è falsa, la squadra ha perso con un
                     * punteggio di 3 set a 0 oppure 3 set a 1, quindi non 
                     * guadagna nemmeno un punto
                    */
                    totalePunti = totalePunti + 0;
                    }                    
                }
            }
            if(TeamName.equals(games.get(i).getGuestTeam().getName())){
                /**
                * se la condizione è vera vuol dire che la squadra in 
                * questione è quella che cerchiamo, guardiamo se ha vinto e
                * calcoliamo i punti da assegnare.
                */
                if(games.get(i).getPointsGuest() > games.get(i).getPointsHome() ){
                    /**
                     * se la condizione è vera vuol dire che la squadra in
                     * questione ha vinto il match.
                    */
                    if(games.get(i).getPointsHome() == 2 ){
                        /**
                         * se la condizione è vera il match è stato vinto 3 a 2 
                         * quindi assegneremo alla squadra di casa 2 punti 
                         * invece che 3.
                        */
                        totalePunti = totalePunti + 2;
                    } else {
                        /**
                         * se la condizione è falsa il match è stato vinto 3 a 0
                         * o 3 a 1, quindi assegneremo alla squadra di casa
                         * tutti e 3 i punti.
                        */
                        totalePunti = totalePunti + 3;
                    }
                } else {
                    /**
                     * se la condizione è falsa vuol dire che la squadra in 
                     * questione ha perso il match, vediamo se ha vinto almeno 
                     * due set in modo tale da assegnargli 1 punto.
                    */
                    if(games.get(i).getPointsGuest() == 2){
                        /**
                         * se la condizione è vera la squadra ha vinto almeno 
                         * due set, in modo tale da guadagnarsi almeno un punto.
                        */
                        totalePunti = totalePunti +1;
                    } else {
                    /**
                     * se la condizione è falsa, la squadra ha perso con un
                     * punteggio di 3 set a 0 oppure 3 set a 1, quindi non 
                     * guadagna nemmeno un punto
                    */
                    totalePunti = totalePunti + 0;
                    }                    
                }
            }
        }
        return totalePunti;  
    }
    
}
