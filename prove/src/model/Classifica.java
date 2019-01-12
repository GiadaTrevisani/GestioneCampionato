/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.FileNotFoundException;
import java.io.PrintWriter; 
import org.json.simple.JSONObject; 
/**
 *
 * @author giadatrevisani
 */
public abstract class Classifica {
    private Squadra[] squadre;
    private Classifica classifica;
    
    public Classifica(Squadra[] squadre, Classifica classifica, int numero){
        this.classifica = classifica;
        for (int i = 0; i < numero; i++) {
            this.squadre[i] = squadre[i];
        }
    }
    
    public Classifica getClassifica(){
        return classifica;
    }
    
    public Squadra[] getSquadre(){
        return squadre;
    }
    
    public void setClassifica(Classifica classifica){
        this.classifica = classifica;
    }
    
    public void setSquadre(Squadra[] squadre, int numero){
        for (int i = 0; i < numero ; i++) {
            this.squadre[i] = squadre[i];
        }
    }
    /*
         * creiamo un file Json per salvarmi le mie squadre su file
         * procederò creando un file Json e inserendoci tutte le
         * entità presenti per ogni squadra, cioè il nome della
         * squadra, il nome della città, e il percorso del logo
         * (es. images/solierav.jpg)
         * Per creare questo file mi affiderò alle librerie di Java
         * riportate all'inizio del file.
         */
    public void salvaSquadre(int numero, Squadra[] squadre) throws FileNotFoundException{
        JSONObject jo = new JSONObject();
        for (int i = 0; i < numero; i++) {
            jo.put("nome" , squadre[i].getNome());
            jo.put("città", squadre[i].getCittà());
            jo.put("logo", squadre[i].getLogo());
        }
        // writing JSON to file:"JSONExample.json" in cwd 
        PrintWriter pw = new PrintWriter("JSONExample.json"); 
        pw.write(jo.toJSONString()); 
          
        pw.flush(); 
        pw.close(); 
    }
    
    public abstract int getVinteForSquadra(String nomeSquadra, Partita[] partite, int numero);
    
    public abstract int getPerseForSquadra(String nomeSquadra, int numero, Partita[] partite);
    
    public abstract int getPuntiForSquadra(String nomeSquadra, int numero, Partita[] partite);
}
