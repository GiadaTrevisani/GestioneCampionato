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

    public RankingVolley(ArrayList<Team> teams, Ranking ranking) {
        super(teams, ranking);
    } 
    
    /*
     * algoritmo non troppo efficente perchè guardo nella stessa partita
     * se la squadra è quella di casa, se corrisponde guardo anche quella 
     * fuori casa e quindi l'algoritmo non è perfetto
     */
    @Override
    public int getWinForTeam(String TeamName, ArrayList<Match> games){
        int partiteVinte = 0;
        for (int i = 0; i < games.size(); i++) {
            if(TeamName == games.get(i).getHomeTeam().getName()){
                /*
                 * se la condizione è vera vuol dire che la squadra in 
                 * questione è quella che cerchiamo, guardiamo se ha vinto e
                 * calcoliamo i punti da assegnare.
                 */
                if(games.get(i).getPointsHome() > games.get(i).getPointsGuest()){
                    /*
                     * se la condizione è vera vuol dire che la squadra in
                     * questione ha vinto il match.
                     * Quindi aggiungerò un punto per la partita vinta
                    */
                   partiteVinte ++;
                }
            }
            if(TeamName == games.get(i).getGuestTeam().getName()){
                /*
                * se la condizione è vera vuol dire che la squadra in 
                * questione è quella che cerchiamo, guardiamo se ha vinto e
                * calcoliamo i punti da assegnare.
                */
                if(games.get(i).getPointsGuest() > games.get(i).getPointsHome()){
                    /*
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

    @Override
    public int getLooseForTeam(String TeamName, ArrayList<Match> games) {
        int partitePerse = 0;
        for (int i = 0; i < games.size(); i++) {
            if(TeamName == games.get(i).getHomeTeam().getName()){
                /*
                 * se la condizione è vera vuol dire che la squadra in 
                 * questione è quella che cerchiamo, guardiamo se ha vinto e
                 * calcoliamo i punti da assegnare.
                 */
                if(games.get(i).getPointsHome() < games.get(i).getPointsGuest()){
                    /*
                     * se la condizione è vera, aggiungiamo una partita persa
                     * al totale delle partite perse.
                    */
                    partitePerse++;
                }
            }
            if(TeamName == games.get(i).getGuestTeam().getName()){
                /*
                * se la condizione è vera vuol dire che la squadra in 
                * questione è quella che cerchiamo, guardiamo se ha vinto e
                * calcoliamo i punti da assegnare.
                */
                if(games.get(i).getPointsGuest() > games.get(i).getPointsHome() ){
                    /*
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

    @Override
    public int getpointsForTeam(String TeamName, ArrayList<Match> games) {
        int totalePunti = 0;
        for (int i = 0; i < games.size(); i++) {
            if(TeamName == games.get(i).getHomeTeam().getName()){
                /*
                 * se la condizione è vera vuol dire che la squadra in 
                 * questione è quella che cerchiamo, guardiamo se ha vinto e
                 * calcoliamo i punti da assegnare.
                 */
                if(games.get(i).getPointsHome() > games.get(i).getPointsGuest()){
                    /*
                     * se la condizione è vera vuol dire che la squadra in
                     * questione ha vinto il match.
                    */
                    if(games.get(i).getPointsGuest() == 2 ){
                        /*
                         * se la condizione è vera il match è stato vinto 3 a 2 
                         * quindi assegneremo alla squadra di casa 2 punti 
                         * invece che 3.
                        */
                        totalePunti = totalePunti + 2;
                    } else {
                        /*
                         * se la condizione è falsa il match è stato vinto 3 a 0
                         * o 3 a 1, quindi assegneremo alla squadra di casa
                         * tutti e 3 i punti.
                        */
                        
                        totalePunti = totalePunti + 3;
                    }
                } else {
                    /*
                     * se la condizione è falsa vuol dire che la squadra in 
                     * questione ha perso il match, vediamo se ha vinto almeno 
                     * due set in modo tale da assegnargli 1 punto.
                    */
                    if(games.get(i).getPointsHome() == 2){
                        /*
                         * se la condizione è vera la squadra ha vinto almeno 
                         * due set, in modo tale da guadagnarsi almeno un punto.
                        */
                        totalePunti = totalePunti +1;
                    } else {
                    /*
                     * se la condizione è falsa, la squadra ha perso con un
                     * punteggio di 3 set a 0 oppure 3 set a 1, quindi non 
                     * guadagna nemmeno un punto
                    */
                    totalePunti = totalePunti + 0;
                    }                    
                }
            }
            if(TeamName == games.get(i).getGuestTeam().getName()){
                /*
                * se la condizione è vera vuol dire che la squadra in 
                * questione è quella che cerchiamo, guardiamo se ha vinto e
                * calcoliamo i punti da assegnare.
                */
                if(games.get(i).getPointsGuest() > games.get(i).getPointsHome() ){
                    /*
                     * se la condizione è vera vuol dire che la squadra in
                     * questione ha vinto il match.
                    */
                    if(games.get(i).getPointsHome() == 2 ){
                        /*
                         * se la condizione è vera il match è stato vinto 3 a 2 
                         * quindi assegneremo alla squadra di casa 2 punti 
                         * invece che 3.
                        */
                        totalePunti = totalePunti + 2;
                    } else {
                        /*
                         * se la condizione è falsa il match è stato vinto 3 a 0
                         * o 3 a 1, quindi assegneremo alla squadra di casa
                         * tutti e 3 i punti.
                        */
                        totalePunti = totalePunti + 3;
                    }
                } else {
                    /*
                     * se la condizione è falsa vuol dire che la squadra in 
                     * questione ha perso il match, vediamo se ha vinto almeno 
                     * due set in modo tale da assegnargli 1 punto.
                    */
                    if(games.get(i).getPointsGuest() == 2){
                        /*
                         * se la condizione è vera la squadra ha vinto almeno 
                         * due set, in modo tale da guadagnarsi almeno un punto.
                        */
                        totalePunti = totalePunti +1;
                    } else {
                    /*
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
