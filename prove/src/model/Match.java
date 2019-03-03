/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
// import javax.swing.JOptionPane;
import org.json.simple.JSONObject;

/**
 *
 * @author giadatrevisani
 */
/**
 * Nella classe Match sono presenti come parametri i nomi delle 
 * due squadre (casa e ospite) che giocheranno la partita, la data, 
 * il risultato che ha ottenuto la squadra che gioca in casa e 
 * il risutato che ha ottenuto la squadra ospite.
 * In più si è aggiunto un altra variabile booleana che dice se la 
 * partita è stata giocata oppure no.
*/
public class Match{
    
    private Team homeTeam;
    private Team guestTeam;
    private int homeResult;
    private int day;
    private int guestResult;
    private boolean played;
    
   
    /**
     * se la partita è già stata giocata chiamo il primo costrutore.
     * @param homeTeam indica la squadra che gioca in casa
     * @param guestTeam indica la squadra che gioca fuori casa 
     * @param homeResult indica il numero di punti accumulato dalla squadra di casa.
     * Nel caso in cui la partita non si fosse ancora giocata chiamo il secondo
     * costruttore e gli attribuirò un punteggio negativo.
     * @param guestResult indica il numero di punti accumulato dalla squadra ospite.
     * Nel caso in cui la partita non si fosse ancora giocata chiamo il secondo
     * costruttore e gli attribuirò un punteggio negativo. 
     * @param day indica la giornata.
     */
    public Match(Team homeTeam, Team guestTeam, int homeResult, int guestResult, int day){
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.day = day;
        this.homeResult = homeResult;
        this.guestResult = guestResult;
        this.played = true;
    }
    /**
     * se la partita non è ancora stata svolta, allora attribuirò un punteggio 
     * negativo al punteggio di ogni squadra e played a false.
     * @param homeTeam indica il nome della squadra di casa.
     * @param guestTeam indica il nome della squadra ospite.
     * @param day indica la giornata.
     */
    public Match(Team homeTeam, Team guestTeam, int day){
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.day = day;
        this.homeResult = -1;
        this.guestResult = -1;
        this.played = false;
    }
    
    /**
     * Metodo per visualizzare la squadra di casa fuori dalla classe.
     * @return il nome della squadra di casa .
     */
    public Team getHomeTeam(){
        return this.homeTeam;
    }
    
    /**
     * Metodo per visualizzare la squadra in trasferta fuori dalla classe.
     * @return il nome della squadra ospite .
     */
    public Team getGuestTeam(){
        return this.guestTeam;
    }
    
    /**
     * Metodo per visualizzare i punti della squadra di casa fuori dalla classe.
     * @return numero di punti della squadra di casa.
     */
    public int getPointsHome(){
        return this.homeResult;
    }
    
    /**
     * Metodo per visualizzare i punti della squadra ospite fuori dalla classe.
     * @return numero di punti della squadra ospite.
     */
    public int getPointsGuest(){
        return this.guestResult;
    }
    
    /**
     * Metodo che ritorna la giornata di un determinato macth fuori dalla classe.
     * @return numero della giornata.
     */
    public int getDay(){
        return this.day;
    }
    
    /**
     * Metodo per vedere se la partita è stata giocata fuori dalla classe Match.
     * @return un booleano che sarà true se la partita è stata giocatam false altrimenti.
     */
    public boolean getPlayed(){
        return this.played;
    }
    
    /**
     * Metodo che setta il nome della squadra di casa passandolo come parametro.
     * @param homeTeam nome della squadra di casa.
     */
    public void setHomeTeam(Team homeTeam){
        this.homeTeam = homeTeam;
    }
    
    /**
     * Metodo che setta il nome della squadra ospite passandolo come parametro.
     * @param guestTeam indica il nome della squadra ospite.
     */
    public void setGuestTeam(Team guestTeam){
        this.guestTeam = guestTeam;
    }
    
    /**
     * Metodo che setta i punti accumulati dalla squadra di casa passandolo come parametro.
     * @param homeResult intero con il numero dei punti della squadra di casa.
     */
    public void setHomePoints(int homeResult){
        this.homeResult = homeResult;
    }
    
    /**
     * Metodo che setta i punti accumulati dalla squadra ospite passandolo come parametro.
     * @param guestResult indica il punteggio della squadra ospite.
     */
    public void setGuestPoints(int guestResult){
        this.guestResult = guestResult;
    }
    
    /**
     * Metodo che cancella i rsultato di tutte le partite dell'arraymatch contenuto 
     * nella classe calendar.
     */
    public void resetResults(){
        this.homeResult = -1;
        this.guestResult = -1;
        this.played = false;
    }
    
    /**
     * Metodo che setta la giornata di un match passandola come parametro.
     * @param day intero che indica la giornata.
     */
    public void setDay(int day){
        this.day = day;
    }
    
    /**
     * Metodo che setta se la partita è stata giocata o meno, passando un booleano
     * come parametro
     * @param played 
     */
    public void setPlayed(boolean played){
        this.played = played;
    }
    
    public JSONObject toJSONObject(){
        JSONObject jo = new JSONObject();
        jo.put("HomeTeam", getHomeTeam().getName());
        jo.put("GuestTeam", getGuestTeam().getName());
        jo.put("HomeResutl", getPointsHome());
        jo.put("GuestResult", getPointsGuest());
        jo.put("Day", getDay());
        jo.put("Played", getPlayed());
        
        return jo;
    }
    
    /**
     * Metodo statico per creare un match da un JsonObject.
     * @param jo indica il JsonObject.
     * @param teams indica la lista delle squadre presenti.
     * @return il match creato.
     * @throws Exception 
     */
    public static Match fromJSONObject(JSONObject jo, ArrayList<Team> teams) throws Exception {
        String homeTeam = (String) jo.get("HomeTeam");
        String guestTeam = (String) jo.get("GuestTeam");
        int homeResult =  new Long((long) jo.get("HomeResutl")).intValue();
        int guestResult = new Long((long) jo.get("GuestResult")).intValue();
        int day = new Long((long) jo.get("Day")).intValue();
        boolean played = (boolean) jo.get("Played");
        int indexHome = -1;
        int indexGuest = -1;
        for (int i = 0; i < teams.size(); i++) {
            if(teams.get(i).getName().equals(homeTeam)){
                indexHome = i;
            }
            if(teams.get(i).getName().equals(guestTeam)){
                indexGuest = i;
            }
        }
        
        if(indexHome ==-1 || indexGuest == -1){
            System.out.println("Una delle squadre nel match non esiste");
            // JOptionPane.showMessageDialog(null, "Una delle squadre nel match non esiste");
            throw new Exception("Una delle squadre nel match non esiste");
        } 
        Match nm = new Match(teams.get(indexHome), teams.get(indexGuest), homeResult, guestResult, day);
        nm.setPlayed(played);
        return nm;
    }
    
    public static Match swapHomeGuest(Match m, int n_days){
        return new Match(m.getGuestTeam(), m.getHomeTeam(), m.getDay() + n_days);
    }
    
}
