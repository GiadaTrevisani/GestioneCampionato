/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter; 
import java.util.ArrayList;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

/**
 * La classe Ranking avrà come parametri un array di Team chiamato teams e un
 * oggetto di tipo Calendario.
 * @author giadatrevisani
 */
public abstract class Ranking {
    protected ArrayList<Team> teams;
    protected Calendar calendar;
    
    /**
     * Primo costruttore che inizialiiza l'ArrayList di squadre e il calendario.
     * @param calendar parametro di tipo calendario.
     */
    public Ranking(Calendar calendar){
        teams = new ArrayList<Team>();
        this.calendar = calendar;
    }

    /**
     * Secondo costuttore che inizzializza l'ArrayList di squadre e il calendario
     * passato come parametri.
     * @param teams ArrayList di squadre.
     * @param calendar parametro di tipo calendario.
     */
    public Ranking(ArrayList<Team> teams, Calendar calendar){
        this.teams = teams;
        this.calendar = calendar;
    }

    /**
     * Terzo costruttore che inizzializza l'ArrayList di squadre passato come parametro
     * e un calendario.
     * @param teams ArrayList di squadre.
     */
    public Ranking(ArrayList<Team> teams){
        this.teams = teams;
        calendar = new Calendar();
    }

    /**
     * Quarto costruttore che inizialliza l'ArrayList di squadre e il clendario.
     */
    public Ranking(){
        teams = new ArrayList<Team>();
        calendar = new Calendar();
    }
    
    /**
     * Metodo getter per l'ArrayList delle squadre.
     * @return l'ArrayList contenente le squadre.
     */
    public ArrayList<Team> getTeams(){
        return teams;
    }
    
    /**
     * Metodo per settare l'ArrayList delle squadre passato come parametro.
     * @param teams ArrayList di squadre.
     */
    public void setTeams(ArrayList<Team> teams){
            this.teams = teams;
    }
    
    /**
     * Metodo che serve per eliminare una squadra dall'array delle squadre dato
     * un nome.
     * @param name indica il nome della squadra. 
     */
    public void deleteTeam(String name){
        for (int i = 0; i < teams.size(); i++) {
            if(teams.get(i).getName().equals(name)){
                teams.remove(i);
                return ;
            }
        }
    }
    
    /**
     * Metodo che serve per eliminare una squadra dall'array delle squadre dato
     * un riferimento al team da eliminare. 
     * @param t riferimento al team da eliminare
     */
    public void deleteTeam(Team t){
        for (int i = 0; i < teams.size(); i++) {
            if(teams.get(i) == t){
                teams.remove(i);
                return ;
            }
        }
    }
    
    /**
     * Metodo usato per trovare una squadra passandogli il nome.
     * @param name indica il nome della squadra.
     * @return il team con il nome passato come parametro.
     * @throws Exception 
     */
    public Team getTeamforName(String name) throws Exception {
        for (Team t : teams) {
            if(t.getName().equals(name)){
                return t;
            }
        }
        throw new Exception();
    }
    
    /**
     * Metodo che guarda se il team passato come parametro esiste 
     * nell'array di teams con quel nome o no.
     * @param name indica il nome della squadra.
     * @return un booleano che indica se la squadra esiste o no.
     */
    public boolean isTeamforName(String name){
        for (Team t : teams) {
            if(t.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo per visualizzare il calendario al di fuori della classe Ranking.
     * @return oggetto di tipo Calendar.
     */
    public Calendar getCalendar(){
        return calendar;
    }
    
    /**
     * Metodo che setta un calendario passato come parametro.
     * @param calendar oggetto di tipo Calendar.
     */
    public void setCalendar(Calendar calendar){
        this.calendar = calendar;
    }
    
    /**
     * questo metodo aggiunge un team all'array di squadre.
     * (quando aggiungo una squadra uso questo metodo).
     * @param newTeam indica una squadra.
     */
    public void addTeam(Team newTeam){
        for (int i = 0; i < teams.size(); i++) {
            if(newTeam.getName().equals(teams.get(i).getName()) || newTeam.getName().equals("") || newTeam.getCity().equals("")){
                System.out.println("Squadra con questo nome già esistente o aggiunta squadra senza un campo");
                // JOptionPane.showMessageDialog(null, "Squadra con questo nome già esistente o aggiunta squadra senza campo");
                return ;
            }     
        }
        
        teams.add(newTeam);
        System.out.println("Squadra inserita");
    }

    /**
     * Metodo che aggiunge un team all'ArrayList di squadre.
     * @param name indica il nome della squadra.
     * @param city indica il nome della città.
     * @param logo indica il file path del logo della squadra.
     */
    public void addTeam(String name, String city,String logo){
	Team newTeam = new Team(name, city, logo);
        this.addTeam(newTeam);
    }
    
    
    /**
     * Metodo per aggiornare una squadra. Se si inserisce come nome della squadra
     * un nome già esistente il motodo ritorna senza effettuare nessun aggiornamento.
     * @param name nome della squadra.
     * @param city città sede della squadra.
     * @param logo logo della squadra.
     * @param index indice dove è salvata la squadra nell'array.
     */
    public void updateTeam(String name, String city, String logo, int index){
        for (int i = 0; i < teams.size(); i++) {
            if(teams.get(i).getName().equals(name)){
                System.out.println("Esiste già un'altra squadra con quel nome");
                return ;
            }
        }
        teams.get(index).setName(name);
        teams.get(index).setCity(city);
        teams.get(index).setLogo(logo);
        System.out.println("Squadra aggiornata");
    }
    
    /**
    * Creiamo un file Json per salvarmi le mie squadre su file
    * procederò creando un file Json e inserendoci tutte le
    * entità presenti per ogni squadra, cioè il nome della
    * squadra, il nome della città, e il percorso del logo
    * (es. images/solierav.jpg).
    * Per creare questo file mi affiderò alle librerie di Java
    * riportate all'inizio del file.
    * @param filePath stringa che indica il percorso del file da slavare.
    * @throws java.io.FileNotFoundException
    */
    public void saveTeams(String filePath) throws FileNotFoundException {
        // writing JSON to file:"teams.json" in cwd 
        PrintWriter pw = new PrintWriter(filePath); 
        JSONArray ja = new JSONArray();
        for (int i = 0; i < teams.size(); i++) { 
            ja.add(teams.get(i).toJSONObject());
        }
        pw.write(ja.toJSONString());
          
        pw.flush(); 
        pw.close(); 
    }
    
    /**
     * Metodo per caricare le squadre da un salvataggio Json.
     * @param filePath stringa che indica il percorso del file salvato.
     * @throws java.io.FileNotFoundException
     * @throws org.json.simple.parser.ParseException
     */
    public void takeFromFile(String filePath) throws FileNotFoundException, IOException, ParseException {
        teams = new ArrayList<Team>();
        // parsing file "teams.json" 
        Object obj = new JSONParser().parse(new FileReader(filePath));
        // typecasting obj to JSONObject 
        JSONArray ja = (JSONArray) obj;
          
        for (int i = 0; i < ja.size(); i++) {
            JSONObject jo = (JSONObject) ja.get(i);
            addTeam(Team.fromJSONObject(jo));
        }
    }
    
    /**
     * Metodo per il calcolo del numero delle partite giocate di una squadra 
     * passata come parametro.
     * @param teamName nome della squadra.
     * @return intero con il numero di partite che la squadra ha giocato.
     */
    public int getPlayedForTeam(String teamName){
        int played = 0;
        for(int i = 0; i < calendar.getGames().size(); i++){
            if(teamName.equals(calendar.getGames().get(i).getHomeTeam().getName()) || teamName.equals(calendar.getGames().get(i).getGuestTeam().getName())){
                if(calendar.getGames().get(i).getPlayed() == true){
                    played++;
                }
                
            }
        }
        return played;
    }
    
    /**
     * Metodo per il calcolo delle partite vinte per una squadra passata come parametro.
     * @param teamName nome della squadra.
     * @return intero con il numero delle parite vinte.
     */
    public abstract int getWinForTeam(String teamName);
    
    /**
     * Metodo per il calcolo delle partite perse per una squadra passata come parametro.
     * @param teamName nome della squadra.
     * @return intero con il numero delle parite perse.
     */
    public abstract int getLooseForTeam(String teamName);
    
    /**
     * Metodo per il calcolo dei punti per una squadra passata come parametro.
     * @param teamName nome della squadra.
     * @return intero con il numero dei punti totalizzati dalla squadra.
     */
    public abstract int getPointsForTeam(String teamName);
    
    /**
     * Metodo per il calcolo delle partite pareggiate dalla squadra passata come parametro.
     * @param TeamName nome della squadra.
     * @return intero con il numero delle partite pareggiate della squadra.
     */
    public abstract int getPareForTeam(String TeamName);
}
