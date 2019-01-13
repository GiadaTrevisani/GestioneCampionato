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
public class RankingBasket extends Ranking{

    public RankingBasket(Team[] teams, Ranking ranking, int numero) {
        super(teams, ranking, numero);
    }

    @Override
    public int getWinForTeam(String teamName, Match[] games, int numero) {
        int partiteVinte = 0;
        for (int i = 0; i < numero; i++) {
            if(teamName == games[i].getHomeTeam().getName()){
                if(games[i].getPointsHome() > games[i].getPointsGuest()){
                   partiteVinte++;
                }
            }
            if(teamName == games[i].getGuestTeam().getName()){
                if(games[i].getPointsGuest() > games[i].getPointsHome()){
                   partiteVinte++;
                }
            }
        }
        return partiteVinte;
    }
    
    @Override
    public int getLooseForTeam(String teamName, int numero, Match[] games) {
        int partitePerse = 0;
        for (int i = 0; i < numero; i++) {
            if(teamName == games[i].getHomeTeam().getName()){
                if(games[i].getPointsHome() < games[i].getPointsGuest()){
                   partitePerse++;
                }
            }
            if(teamName == games[i].getGuestTeam().getName()){
                if(games[i].getPointsGuest() < games[i].getPointsHome()){
                   partitePerse++;
                }
            }
            
        }
        return partitePerse;
    }

    @Override
    public int getpointsForTeam(String teamName, int numero, Match[] games) {
         int totalePunti = 0;
        for (int i = 0; i < numero; i++) {
            if(teamName == games[i].getHomeTeam().getName()){
                /*
                 * se la condizione è vera vuol dire che la squadra in 
                 * questione è quella che cerchiamo, guardiamo se ha vinto e
                 * calcoliamo i punti da assegnare.
                 */
                if(games[i].getPointsHome() > games[i].getPointsGuest()){
                    /*
                     * se la condizione è vera vuol dire che la squadra in
                     * questione ha vinto il match.
                    */
                        totalePunti = totalePunti + 2;
                    }
                }
                if(games[i].getPointsHome() < games[i].getPointsGuest()){
                    /*
                     * oppure se i punti sono minori di quelli della squadra
                     * allora la partita è persa, quindi non aggiungeremo
                     * nessun punto
                    */
                        totalePunti = totalePunti +0;
                }
            
            if(teamName == games[i].getGuestTeam().getName()){
                /*
                * se la condizione è vera vuol dire che la squadra in 
                * questione è quella che cerchiamo, guardiamo se ha vinto e
                * calcoliamo i punti da assegnare.
                */
                if(games[i].getPointsGuest() > games[i].getPointsHome()){
                    /*
                     * se la condizione è vera vuol dire che la squadra in
                     * questione ha vinto il match.
                    */
                        totalePunti = totalePunti + 2;
                    
                }
                if(games[i].getPointsGuest() < games[i].getPointsHome()){
                    /*
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
