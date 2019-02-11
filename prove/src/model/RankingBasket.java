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
public class RankingBasket extends Ranking{

    public RankingBasket(Calendar calendar){
        super(calendar);
    }

    public RankingBasket(ArrayList<Team> teams, Calendar calendar){
        super(teams, calendar);
    }

    public RankingBasket(ArrayList<Team> teams){
        super(teams);
    }

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
        return partitePerse;
    }

    /**
     * Metodo per il calcolo dei punti tolalizzati dalla squadra passata come parametro.
     * @param teamName nome della squadra.
     * @return intero con il numero totale dei punti della squdra.
     */
    @Override
    public int getpointsForTeam(String teamName){
        ArrayList<Match> games = this.calendar.getGames();
        int totalePunti = 0;
        for (int i = 0; i < games.size(); i++) {
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
                if(games.get(i).getPointsHome() < games.get(i).getPointsGuest()){
                    /**
                     * oppure se i punti sono minori di quelli della squadra
                     * allora la partita è persa, quindi non aggiungeremo
                     * nessun punto
                    */
                        totalePunti = totalePunti +0;
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
                if(games.get(i).getPointsGuest() < games.get(i).getPointsHome()){
                    /**
                     * oppure se i punti sono minori di quelli della squadra
                     * allora la partita è persa, quindi non aggiungeremo
                     * nessun punto
                    */
                        totalePunti = totalePunti +0;
                }
            }
        }
        return totalePunti;  
    }
    
}
