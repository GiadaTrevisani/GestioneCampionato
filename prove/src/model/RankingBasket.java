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

    public RankingBasket(ArrayList<Team> teams, Team team) {
        super(teams, team);
    }

    @Override
    public int getWinForTeam(String teamName, ArrayList<Match> games) {
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
    
    @Override
    public int getLooseForTeam(String teamName, ArrayList<Match> games) {
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

    @Override
    public int getpointsForTeam(String teamName,ArrayList<Match> games) {
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
