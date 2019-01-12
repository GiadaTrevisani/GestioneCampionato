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
public class ClassificaV extends Classifica{

    public ClassificaV(Squadra[] squadre, Classifica classifica, int numero) {
        super(squadre, classifica, numero);
    } 
    
    /*
     * algoritmo non troppo efficente perchè guardo nella stessa partita
     * se la squadra è quella di casa, se corrisponde guardo anche quella 
     * fuori casa e quindi l'algoritmo non è perfetto
     */
    @Override
    public int getVinteForSquadra(String nomeSquadra, Partita[] partite, int numero){
        int partiteVinte = 0;
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
                     * Quindi aggiungerò un punto per la partita vinta
                    */
                   partiteVinte ++;
                }
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
                     * Quindi aggiungerò un punto per la partita vinta.
                    */
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
                /*
                 * se la condizione è vera vuol dire che la squadra in 
                 * questione è quella che cerchiamo, guardiamo se ha vinto e
                 * calcoliamo i punti da assegnare.
                 */
                if(partite[i].getPuntiCasa() < partite[i].getPuntiOspite()){
                    /*
                     * se la condizione è vera, aggiungiamo una partita persa
                     * al totale delle partite perse.
                    */
                    partitePerse++;
                }
            }
            if(nomeSquadra == partite[i].getSquadraOspite().getNome()){
                /*
                * se la condizione è vera vuol dire che la squadra in 
                * questione è quella che cerchiamo, guardiamo se ha vinto e
                * calcoliamo i punti da assegnare.
                */
                if(partite[i].getPuntiOspite() > partite[i].getPuntiCasa() ){
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
                    if(partite[i].getPuntiOspite() == 2 ){
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
                    if(partite[i].getPuntiCasa() == 2){
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
            if(nomeSquadra == partite[i].getSquadraOspite().getNome()){
                /*
                * se la condizione è vera vuol dire che la squadra in 
                * questione è quella che cerchiamo, guardiamo se ha vinto e
                * calcoliamo i punti da assegnare.
                */
                if(partite[i].getPuntiOspite() > partite[i].getPuntiCasa() ){
                    /*
                     * se la condizione è vera vuol dire che la squadra in
                     * questione ha vinto il match.
                    */
                    if(partite[i].getPuntiCasa() == 2 ){
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
                    if(partite[i].getPuntiOspite() == 2){
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
