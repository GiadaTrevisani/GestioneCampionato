/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import javax.swing.GroupLayout;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import model.Ranking;

/**
 *
 * @author giadatrevisani
 */
public class ViewRanking extends javax.swing.JFrame {
    
    private final String sport;
    private final Ranking rank;
    private final DefaultTableModel model;
    private final JScrollPane j1;
    
    public ViewRanking(Ranking rank, String sport) {
        this.rank = rank;
        this.sport = sport;
        initComponents();
        
        j1 = new JScrollPane();
        
        if(sport.equals("Soccer")){
            viewRanking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Posto", "Logo", "Nome", "Punti", "Giocate", "Vinte", "Perse", "Pareggiate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
            j1.setViewportView(viewRanking);
            GroupLayout layout2 = new GroupLayout(getContentPane());
            getContentPane().setLayout(layout2);
            layout2.setHorizontalGroup(
                layout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout2.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(j1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addContainerGap())
            );
            layout2.setVerticalGroup(
                layout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout2.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(j1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addContainerGap())
            );
        }
        model = (DefaultTableModel) viewRanking.getModel();
        this.setTitle(sport);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
            for (int i = 0; i < rank.getTeams().size(); i++) {
                model.insertRow(i, new Object[]{i+1, rank.getTeams().get(i).getLogo(), rank.getTeams().get(i).getName(), rank.getPointsForTeam(rank.getTeams().get(i).getName()),rank.getPlayedForTeam(rank.getTeams().get(i).getName()), rank.getWinForTeam(rank.getTeams().get(i).getName()), rank.getLooseForTeam(rank.getTeams().get(i).getName()), rank.getPareForTeam(rank.getTeams().get(i).getName())});
            }
            viewRanking.setAutoCreateRowSorter(true);
        }
        if(sport.equals("Volley")){
            for (int i = 0; i < rank.getTeams().size(); i++) {
                model.insertRow(i, new Object[]{i+1, rank.getTeams().get(i).getLogo(), rank.getTeams().get(i).getName(),rank.getPointsForTeam(rank.getTeams().get(i).getName()) , rank.getPlayedForTeam(rank.getTeams().get(i).getName()), rank.getWinForTeam(rank.getTeams().get(i).getName()), rank.getLooseForTeam(rank.getTeams().get(i).getName())});
            }
            viewRanking.setAutoCreateRowSorter(true);
        }
        if(sport.equals("Basket")){
            for (int i = 0; i < rank.getTeams().size(); i++) {
                model.insertRow(i, new Object[]{i+1, rank.getTeams().get(i).getLogo(), rank.getTeams().get(i).getName(), rank.getPointsForTeam(rank.getTeams().get(i).getName()) , rank.getPlayedForTeam(rank.getTeams().get(i).getName()), rank.getWinForTeam(rank.getTeams().get(i).getName()), rank.getLooseForTeam(rank.getTeams().get(i).getName())});
            }
            viewRanking.setAutoCreateRowSorter(true);
        }
        viewRanking.setVisible(true);
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

        viewRanking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Posto", "Logo", "Nome", "Punti", "Giocate", "Vinte", "Perse"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(viewRanking);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable viewRanking;
    // End of variables declaration//GEN-END:variables
}
