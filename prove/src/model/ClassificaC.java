/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import model.Calendario;
/**
 *
 * @author giadatrevisani
 */
public class ClassificaC extends Classifica{

    public ClassificaC(Squadra[] squadre, Classifica classifica, int numero) {
        super(squadre, classifica, numero);
    }

    @Override
    public int getVinteForSquadra(String nomeSquadra, Partita[] partite, int numero) {
        int partiteVinte = 0;
        for (int i = 0; i < numero; i++) {
            if(nomeSquadra == partite[i].getSquadraCasa().getNome()){
                if(partite[i].getPuntiCasa() > partite[i].getPuntiOspite()){
                   partiteVinte++;
                }
            }
            if(nomeSquadra == partite[i].getSquadraOspite().getNome()){
                if(partite[i].getPuntiOspite() > partite[i].getPuntiCasa()){
                   partiteVinte++;
                }
            }
        }
        return partiteVinte;
    }

    @Override
    public int getPerseForSquadra(String nomeSquadra, int numero, Partita[] partite) {
        int partitePerse = 0;
        for (int i = 0; i < numero; i++) {
            if(nomeSquadra == partite[i].getSquadraCasa().getNome()){
                if(partite[i].getPuntiCasa() < partite[i].getPuntiOspite()){
                   partitePerse++;
                }
            }
            if(nomeSquadra == partite[i].getSquadraOspite().getNome()){
                if(partite[i].getPuntiOspite() < partite[i].getPuntiCasa()){
                   partitePerse++;
                }
            }
            
        }
        return partitePerse;
    }

    @Override
    public int getPuntiForSquadra(String nomeSquadra, int numero, Partita[] partite) {
         int totalePunti = 0;
        for (int i = 0; i < numero; i++) {
            if(nomeSquadra == partite[i].getSquadraCasa().getNome()){
                /*
                 * se la condizione è vera vuol dire che la squadra in 
                 * questione è quella che cerchiamo, guardiamo se ha vinto e
                 * calcoliamo i punti da assegnare.
                 */
                if(partite[i].getPuntiCasa() > partite[i].getPuntiOspite()){
                    /*
                     * se la condizione è vera vuol dire che la squadra in
                     * questione ha vinto il match.
                    */
                        totalePunti = totalePunti + 3;
                    }
                } else if(partite[i].getPuntiCasa() < partite[i].getPuntiOspite()){
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
            
            if(nomeSquadra == partite[i].getSquadraOspite().getNome()){
                /*
                * se la condizione è vera vuol dire che la squadra in 
                * questione è quella che cerchiamo, guardiamo se ha vinto e
                * calcoliamo i punti da assegnare.
                */
                if(partite[i].getPuntiOspite() > partite[i].getPuntiCasa()){
                    /*
                     * se la condizione è vera vuol dire che la squadra in
                     * questione ha vinto il match.
                    */
                        totalePunti = totalePunti + 3;
                    
                } else if(partite[i].getPuntiOspite() < partite[i].getPuntiCasa()){
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
    

   public int getPareggiateForSqadra(String nomeSquadra, int numero, Partita[] partite){
       int partitePareggiate = 0;
       for (int i = 0; i < numero; i++) {
           if(nomeSquadra == partite[i].getSquadraCasa().getNome()){
                if(partite[i].getPuntiCasa() == partite[i].getPuntiOspite()){
                   partitePareggiate++;
                }
            }
            if(nomeSquadra == partite[i].getSquadraOspite().getNome()){
                if(partite[i].getPuntiOspite() == partite[i].getPuntiCasa()){
                   partitePareggiate++;
                }
            }
       }
       return partitePareggiate;
   }

    
}
