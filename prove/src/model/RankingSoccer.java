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
public class RankingSoccer extends Ranking{

    public RankingSoccer(Calendar calendar){
        super(calendar);
    }

    public RankingSoccer(ArrayList<Team> teams, Calendar calendar){
        super(teams, calendar);
    }

    public RankingSoccer(ArrayList<Team> teams){
        super(teams);
    }

    public RankingSoccer(){
        super();
    }

    /**
     * Metodo per il calcolo delle partite vinte per una squadra passata come parametro.
     * @param TeamName nome della squada.
     * @return intero con il nomero delle partite vente dalla squadra.
     */
    @Override
    public int getWinForTeam(String TeamName) {
        ArrayList<Match> games = this.calendar.getGames();
        int partiteVinte = 0;
        for (int i = 0; i < games.size(); i++) {
            if(TeamName.equals(games.get(i).getHomeTeam().getName())){
                if(games.get(i).getPointsHome() > games.get(i).getPointsGuest()){
                   partiteVinte++;
                }
            }
            if(TeamName.equals(games.get(i).getGuestTeam().getName())){
                if(games.get(i).getPointsGuest() > games.get(i).getPointsHome()){
                   partiteVinte++;
                }
            }
        }
        return partiteVinte;
    }

    /**
     * Metodo che calcola il numero delle partite perse della squadra passata come parametro.
     * @param TeamName nome della squadra.
     * @return intero con il numero delle partite perse dalla squadra.
     */
    @Override
    public int getLooseForTeam(String TeamName) {
        ArrayList<Match> games = this.calendar.getGames();
        int partitePerse = 0;
        for (int i = 0; i < games.size(); i++) {
            if(TeamName.equals(games.get(i).getHomeTeam().getName())){
                if(games.get(i).getPointsHome() < games.get(i).getPointsGuest()){
                   partitePerse++;
                }
            }
            if(TeamName.equals(games.get(i).getGuestTeam().getName())){
                if(games.get(i).getPointsGuest() < games.get(i).getPointsHome()){
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
    public int getpointsForTeam(String TeamName){
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
                        totalePunti = totalePunti + 3;
                    }
                } else if(games.get(i).getPointsHome() < games.get(i).getPointsGuest()){
                    /**
                     * oppure se i punti sono minori di quelli della squadra
                     * allora la partita è persa, quindi non aggiungeremo
                     * nessun punto
                    */
                        totalePunti = totalePunti +0;
                } else {
                    /**
                     * nel caso in cui nessuna delle due altre condizioni sia 
                     * vera, allora vuol dire che le due squadre hanno 
                     * pareggiato, si aggiungerà solo 1 punto.
                    */
                    totalePunti = totalePunti + 1;                  
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
                    */
                        totalePunti = totalePunti + 3;
                    
                } else if(games.get(i).getPointsGuest() < games.get(i).getPointsHome()){
                    /**
                     * oppure se i punti sono minori di quelli della squadra
                     * allora la partita è persa, quindi non aggiungeremo
                     * nessun punto
                    */
                        totalePunti = totalePunti +0;
                } else {
                    /**
                     * nel caso in cui nessuna delle due altre condizioni sia 
                     * vera, allora vuol dire che le due squadre hanno 
                     * pareggiato, si aggiungerà solo 1 punto.
                    */
                    totalePunti = totalePunti + 1;                  
                }
            }
        }
        return totalePunti;  
    }
    

    /**
     * Metodo per il calcolo delle partite pareggiate dalla squadra passata come parametro.
     * @param TeamName nome della squadra.
     * @return intero con il numero delle partite pareggiate della squadra.
     */
   public int getPareggiateForSqadra(String TeamName){
       ArrayList<Match> games = this.calendar.getGames();
       int partitePareggiate = 0;
       for (int i = 0; i < games.size(); i++) {
           if(TeamName.equals(games.get(i).getHomeTeam().getName())){
                if(games.get(i).getPointsHome() == games.get(i).getPointsGuest()){
                   partitePareggiate++;
                }
            }
            if(TeamName.equals(games.get(i).getGuestTeam().getName())){
                if(games.get(i).getPointsGuest() == games.get(i).getPointsHome()){
                   partitePareggiate++;
                }
            }
       }
       return partitePareggiate;
   }

    
}
