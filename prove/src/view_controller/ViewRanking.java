/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;
import model.Ranking;
import model.Team;

/**
 *In questo Jframe è presente solo una tabella in cui viene visualizzata la 
 * classifica delle squadre. Nella classifica abbiamo il posto ottenuto dalla 
 * squadra attraverso i punti totalizzati, il nome della squadra e i punti.
 * Si è pensato di personalizzare la classifica mostrando la colonna delle 
 * partite giocate, vinte e perse per la pallavolo e basket, in più per il
 * calcio si è aggiunta la colonna delle partite pareggiate perchè dei tre 
 * sport scelti solo nel calcio è preisto il pareggio.
 * @author giadatrevisani
 */
public class ViewRanking extends javax.swing.JFrame {
    
    private final String sport;
    private final Ranking rank;
    private final DefaultTableModel model;
    
    private ArrayList<Team> teamsInOrder;
    
    /**
     * Costruttore che prende in ingresso un oggetto di tipo Ranking e una
     * stringa.
     * @param rank indica un oggetto di tipo Ranking.
     * @param sport stringa che indica lo sport.
     */
    public ViewRanking(Ranking rank, String sport) {
        this.rank = rank;
        this.sport = sport;
        initComponents();
        
        if(sport.equals("Soccer")){
            viewRanking.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Posto", "Nome", "Punti", "Giocate", "Vinte", "Perse", "Pareggiate"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
                
                @Override
                public boolean isCellEditable(int row, int column){  
                    return false;  
                }
            });
        }
        
        model = (DefaultTableModel) viewRanking.getModel();
        this.setTitle(sport);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        viewRanking.getTableHeader().setEnabled(false);
        viewRanking.setDefaultEditor(Object.class, null);
        
        teamsInOrder = new ArrayList<Team>(rank.getTeams()); // Costruttore copia
        
        // Ordino le squadre per punti
        teamsInOrder.sort(new Comparator<Team>() {
            @Override
            public int compare(Team t1, Team t2) {
                int pt1 = rank.getPointsForTeam(t1.getName());
                int pt2 = rank.getPointsForTeam(t2.getName());
                if(pt1 == pt2){
                    int w1 = rank.getWinForTeam(t1.getName());
                    int w2 = rank.getWinForTeam(t2.getName());
                    if(w1 > w2) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else {
                    if(pt1 > pt2){
                        return -1;
                    } else {
                        return 1;
                    }
                }

            }
	});
        
        printTable();
    }
    

    /**
     * Questo metodo crea un arraylist di team ordinati iper punteggio, la prima
     * squadra presente nell'array sarà quella con maggiori punti e così via 
     * fino alla fine dell'array. In questo metodo quindi creeremo due array
     * uno di supporto per inserire le squadre i ordine di punteggio, l'altro 
     * è una copia dell'array di squadre originale che presa una squadra la 
     * elimina dall'array.
     */
    private void printTable(){
        model.setRowCount(0);
        if(sport.equals("Soccer")){
            for (int i = 0; i < teamsInOrder.size(); i++) {
                model.insertRow(i, new Object[]{i+1, teamsInOrder.get(i).getName(), rank.getPointsForTeam(teamsInOrder.get(i).getName()), rank.getPlayedForTeam(teamsInOrder.get(i).getName()), rank.getWinForTeam(teamsInOrder.get(i).getName()), rank.getLooseForTeam(teamsInOrder.get(i).getName()), rank.getPareForTeam(teamsInOrder.get(i).getName())});
            }
        } else {
            for (int i = 0; i < rank.getTeams().size(); i++) {
                model.insertRow(i, new Object[]{i+1, teamsInOrder.get(i).getName(), rank.getPointsForTeam(teamsInOrder.get(i).getName()) , rank.getPlayedForTeam(teamsInOrder.get(i).getName()), rank.getWinForTeam(teamsInOrder.get(i).getName()), rank.getLooseForTeam(teamsInOrder.get(i).getName())});
            }
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        viewRanking = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        viewRanking.setAutoCreateRowSorter(true);
        viewRanking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Posto", "Nome", "Punti", "Giocate", "Vinte", "Perse"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        viewRanking.getTableHeader().setResizingAllowed(false);
        viewRanking.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(viewRanking);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable viewRanking;
    // End of variables declaration//GEN-END:variables
}
