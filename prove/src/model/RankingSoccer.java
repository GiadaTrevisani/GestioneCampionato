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
public class RankingSoccer extends Ranking{

    public RankingSoccer(Team[] squadre, Ranking classifica, int numero) {
        super(squadre, classifica, numero);
    }

    @Override
    public int getWinForTeam(String TeamName, Match[] games, int numero) {
        int partiteVinte = 0;
        for (int i = 0; i < numero; i++) {
            if(TeamName == games[i].getHomeTeam().getName()){
                if(games[i].getPointsHome() > games[i].getPointsGuest()){
                   partiteVinte++;
                }
            }
            if(TeamName == games[i].getGuestTeam().getName()){
                if(games[i].getPointsGuest() > games[i].getPointsHome()){
                   partiteVinte++;
                }
            }
        }
        return partiteVinte;
    }

    @Override
    public int getLooseForTeam(String TeamName, int numero, Match[] games) {
        int partitePerse = 0;
        for (int i = 0; i < numero; i++) {
            if(TeamName == games[i].getHomeTeam().getName()){
                if(games[i].getPointsHome() < games[i].getPointsGuest()){
                   partitePerse++;
                }
            }
            if(TeamName == games[i].getGuestTeam().getName()){
                if(games[i].getPointsGuest() < games[i].getPointsHome()){
                   partitePerse++;
                }
            }
            
        }
        return partitePerse;
    }

    @Override
    public int getpointsForTeam(String TeamName, int numero, Match[] games) {
         int totalePunti = 0;
        for (int i = 0; i < numero; i++) {
            if(TeamName == games[i].getHomeTeam().getName()){
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
                        totalePunti = totalePunti + 3;
                    }
                } else if(games[i].getPointsHome() < games[i].getPointsGuest()){
                    /*
                     * oppure se i punti sono minori di quelli della squadra
                     * allora la partita è persa, quindi non aggiungeremo
                     * nessun punto
                    */
                        totalePunti = totalePunti +0;
                } else {
                    /*
                     * nel caso in cui nessuna delle due altre condizioni sia 
                     * vera, allora vuol dire che le due squadre hanno 
                     * pareggiato, si aggiungerà solo 1 punto.
                    */
                    totalePunti = totalePunti + 1;                  
                }
            
            if(TeamName == games[i].getGuestTeam().getName()){
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
                        totalePunti = totalePunti + 3;
                    
                } else if(games[i].getPointsGuest() < games[i].getPointsHome()){
                    /*
                     * oppure se i punti sono minori di quelli della squadra
                     * allora la partita è persa, quindi non aggiungeremo
                     * nessun punto
                    */
                        totalePunti = totalePunti +0;
                } else {
                    /*
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
    

   public int getPareggiateForSqadra(String TeamName, int numero, Match[] games){
       int partitePareggiate = 0;
       for (int i = 0; i < numero; i++) {
           if(TeamName == games[i].getHomeTeam().getName()){
                if(games[i].getPointsHome() == games[i].getPointsGuest()){
                   partitePareggiate++;
                }
            }
            if(TeamName == games[i].getGuestTeam().getName()){
                if(games[i].getPointsGuest() == games[i].getPointsHome()){
                   partitePareggiate++;
                }
            }
       }
       return partitePareggiate;
   }

    
}
