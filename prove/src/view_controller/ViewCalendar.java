/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import model.Match;
import model.Ranking;
import org.json.simple.parser.ParseException;

/**
 * Questo JFrame permette di visualizzare il campionato nella tabella viewCalendar.
 * Inizialmente quando si apre il JFrame, verrà chiesto di inserire l'anno in cui 
 * si svolge il campionato, inserito l'anno viene visualizzata la tabella vuota,
 * se si vuole creare un campionato si deve cliccare sul bottone "Crea Calendario".
 * Permette anche di cercare le partite di una squadra e cercare le partite per 
 * una giornata attraverso il bottone cerca e la textfield dove sarà inserito
 * il nome di una squadra o il numero della giornata. Inoltre è possibile 
 * visualizzare una singola giornata selezionando la partita dalla tabella e 
 * cliccando sul bottone "Modifca Visualizza" dove si potrà modificare il punteggio.
 * Attraverso i bottoni carica e salva campionato è possibile salvare o caricare 
 * il campionato stesso su file o caricarlo da file con estensione ".json".
 * Il bottone "Elimina Risultati" elimina tutti i risultati inseriti fino a quel momento.
 * In questo Jframe è possibile stampare il campionato attraverso il bottone "Stampa".
 * @author giadatrevisani
 */
public class ViewCalendar extends javax.swing.JFrame {
    
    private final String sport;
    private final Ranking rank;
    private final DefaultTableModel model;
    private boolean openViewUpdate;
    private boolean openYear;
    private ArrayList<Match> matchesModel;
    private final JFileChooser fc;
    
    /**
     * Costruttore che prende in ingresso un oggetto di tipo Ranking, che è una 
     * classe astratta e quindi viene sfruttato il polimorfismo, da cui 
     * attinge ai dati per riempire la tabella e modificare i dati di calendario,
     * e una stringa che definisce lo sport.
     * @param rank oggetto di tipo Ranking.
     * @param sport stringa che definisce lo sport.
     */
    public ViewCalendar(Ranking rank, String sport){
        this.fc = new JFileChooser(new File("./"));
        this.sport = sport;
        openViewUpdate = false;
        openYear = false;
        this.rank = rank;
        initComponents();
        model = (DefaultTableModel) viewCalendar.getModel();
        matchesModel = new ArrayList<Match>();
        
        this.setTitle(sport);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        viewCalendar.getTableHeader().setEnabled(false);
        viewCalendar.setDefaultEditor(Object.class, null);
        
        printTable();
    }
    
    /**
     * Metodo per impostare il colore di background diverso per le partite del 
     * girone di ritorno.
     */
    public void setTableBG(){
        int returnStart = rank.getCalendar().getNumDays()/2+1; // Calcolo il valore del primo giorno del ritorno
        
        int numCols = viewCalendar.getColumnModel().getColumnCount();
        for (int i = 0; i < numCols; i++) {
            // Setto un nuovo cell renderer per colorare solo le righe del ritorno
            // Ho due diversi renderer, perchè nell'ultima colonna voglio le checkbox
            if(i != numCols-1){
                viewCalendar.getColumnModel().getColumn(i).setCellRenderer(getCellRenderer(returnStart));
            } else {
                viewCalendar.getColumnModel().getColumn(i).setCellRenderer(new CheckBoxRenderer(returnStart));
            }
        }
    }
    
    /**
     * Metodo che stampa i valori inseriti nell'oggetto calendario dentro 
     * la JTable viewCalendar.
     */
    public void printTable(){
        setTableBG();
        
        matchesModel = new ArrayList<Match>();
        model.setRowCount(0);
        for(int i = 0; i < rank.getCalendar().getGames().size(); i++){
            if(rank.getCalendar().getGames().get(i).getPlayed() == false){
                model.insertRow(i, new Object[]{rank.getCalendar().getGames().get(i).getDay(), rank.getCalendar().getGames().get(i).getHomeTeam().getCity(), rank.getCalendar().getGames().get(i).getHomeTeam().getName(), rank.getCalendar().getGames().get(i).getGuestTeam().getName(), "-", "-", rank.getCalendar().getGames().get(i).getPlayed()});
            } else {
                model.insertRow(i, new Object[]{rank.getCalendar().getGames().get(i).getDay(), rank.getCalendar().getGames().get(i).getHomeTeam().getCity(), rank.getCalendar().getGames().get(i).getHomeTeam().getName(), rank.getCalendar().getGames().get(i).getGuestTeam().getName(), String.valueOf(rank.getCalendar().getGames().get(i).getPointsHome()), String.valueOf(rank.getCalendar().getGames().get(i).getPointsGuest()), rank.getCalendar().getGames().get(i).getPlayed()});
            }
            matchesModel.add(rank.getCalendar().getGames().get(i));
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

        searchtxt = new javax.swing.JTextField();
        finebtn = new javax.swing.JButton();
        serachbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewCalendar = new javax.swing.JTable();
        javax.swing.JButton takeCalendarbtn = new javax.swing.JButton();
        saveCalendarbtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        viewbtn = new javax.swing.JButton();
        printbtn = new javax.swing.JButton();
        createCalendar = new javax.swing.JButton();
        yearlbl = new javax.swing.JLabel();
        insertYearlbl = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        finebtn.setText("X");
        finebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finebtnActionPerformed(evt);
            }
        });

        serachbtn.setText("cerca");
        serachbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serachbtnActionPerformed(evt);
            }
        });

        viewCalendar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Giornata", "Città", "Squadra Casa", "Squadra Ospite", "Punti Casa", "Punti Ospite", "Giocata"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(viewCalendar);

        takeCalendarbtn.setText("<html><p style = \"text-align: center\">Carica <br>Campionato</p></html>");
        takeCalendarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takeCalendarbtnActionPerformed(evt);
            }
        });

        saveCalendarbtn.setText("<html><p style = \"text-align: center\">Salva <br>Campionato</p></html>");
        saveCalendarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveCalendarbtnActionPerformed(evt);
            }
        });

        deletebtn.setText("<html><p style = \"text-align: center\">Elimina<br>Risultati</p></html>");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });

        viewbtn.setText("<html><p style = \"text-align: center\">Modifica<br>Visualizza</p></html>");
        viewbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewbtnActionPerformed(evt);
            }
        });

        printbtn.setText("<html><p style = \"text-align: center\">Stampa<br></p></html>");
        printbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printbtnActionPerformed(evt);
            }
        });

        createCalendar.setText("<html><p style = \"text-align: center\">Crea <br>Calendario</p></html>");
        createCalendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCalendarActionPerformed(evt);
            }
        });

        yearlbl.setText("Anno: ");

        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(yearlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(insertYearlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(finebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(serachbtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(viewbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(takeCalendarbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(saveCalendarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(createCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(printbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(finebtn)
                        .addComponent(serachbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(viewbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(yearlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(insertYearlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(takeCalendarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(saveCalendarbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(createCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(printbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo chiamato quando il bottone "X" della finestra viene premuto, per 
     * resettare il campo ricerca e mostrare di nuovo tutti i math.
     * @param evt evento java.
     */
    private void finebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finebtnActionPerformed
        searchtxt.setText("");
        printTable();
    }//GEN-LAST:event_finebtnActionPerformed

    /**
     * Metodo chiamato quando il bottone "Cerca" viene cliccato e che scorre 
     * tutti i match presenti e mostra nella tabella solo quelli il cui nome 
     * o la giornata corrispondono al campo ricerca.
     * @param evt evento java.
     */
    private void serachbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serachbtnActionPerformed
        setTableBG();
        int j = 0;
        matchesModel = new ArrayList<Match>();
        model.setRowCount(0);
        for (int i = 0; i < rank.getCalendar().getGames().size(); i++) {
            int srcDay;
            try {
                srcDay = Integer.parseInt(searchtxt.getText());
            } catch (NumberFormatException e){
                srcDay = -1;
            }
            if(rank.getCalendar().getGames().get(i).getHomeTeam().getName().equals(searchtxt.getText()) || rank.getCalendar().getGames().get(i).getGuestTeam().getName().equals(searchtxt.getText()) || srcDay == rank.getCalendar().getGames().get(i).getDay()){
                if(rank.getCalendar().getGames().get(i).getPlayed() == false){
                    model.insertRow(j, new Object[]{rank.getCalendar().getGames().get(i).getDay(), rank.getCalendar().getGames().get(i).getHomeTeam().getCity(), rank.getCalendar().getGames().get(i).getHomeTeam().getName(), rank.getCalendar().getGames().get(i).getGuestTeam().getName(), "-", "-", rank.getCalendar().getGames().get(i).getPlayed()});
                } else {
                    model.insertRow(j, new Object[]{rank.getCalendar().getGames().get(i).getDay(), rank.getCalendar().getGames().get(i).getHomeTeam().getCity(), rank.getCalendar().getGames().get(i).getHomeTeam().getName(), rank.getCalendar().getGames().get(i).getGuestTeam().getName(), String.valueOf(rank.getCalendar().getGames().get(i).getPointsHome()), String.valueOf(rank.getCalendar().getGames().get(i).getPointsGuest()), rank.getCalendar().getGames().get(i).getPlayed()});
                }
                matchesModel.add(rank.getCalendar().getGames().get(i));
                j++;
            }
        }
    }//GEN-LAST:event_serachbtnActionPerformed

    /**
     * Metodo chiamato quando si clicca il bottone "Carica Campionato" che delega
     * alla classe Calendario il caricamento del salvataggio utilizzndo la
     * serializzazione.
     * @param evt evento java.
     */
    private void takeCalendarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takeCalendarbtnActionPerformed
        try {
            int returnVal = fc.showOpenDialog(null);
            File file;
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = fc.getSelectedFile();
            } else {
                return ;
            }
            
            rank.getCalendar().takeFromFile(file.getAbsolutePath(), rank.getTeams(), (i) -> jProgressBar1.setValue(i));
            printTable();
            insertYearlbl.setText(String.valueOf(rank.getCalendar().getYear()));
            JOptionPane.showMessageDialog(null, "Calendario caricato con successo");
        } catch (IOException | ParseException ex) {
            JOptionPane.showMessageDialog(null, "Calendario non caricato: file mancante oppure non corrretto");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Una delle squadre nel match non esiste");
        }
    }//GEN-LAST:event_takeCalendarbtnActionPerformed

    /**
     * Metodo chiamato quando si clicca il bottone "Salva Campionato" che delega
     * alla classe Calendario il salvataggio delle informazioni utilizzando la
     * serializzazione.
     * @param evt evento java.
     */
    private void saveCalendarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveCalendarbtnActionPerformed
        try {
            int returnVal = fc.showSaveDialog(null);
            
            File file;
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = fc.getSelectedFile();
            } else {
                return ;
            }
            
            rank.getCalendar().saveCalendar(file.getAbsolutePath());
            System.out.println("Salvato su file");
            JOptionPane.showMessageDialog(null, "Salvato su file");
        } catch (FileNotFoundException ex) {
            System.out.println("Salvataggio non avvenuto");
            JOptionPane.showMessageDialog(null, "Salvataggio non avvenuto");
        }
    }//GEN-LAST:event_saveCalendarbtnActionPerformed

    /**
     * Metodo chiamato quando si clicca sul bottone "Elimina" che delega alla 
     * classe Calendario l'eliminazione di tutti i risultati di tutti i match.
     * @param evt evento java.
     */
    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        rank.getCalendar().deleteResults();
        printTable();
    }//GEN-LAST:event_deletebtnActionPerformed

    /**
     * Metodo chiamato quando si clicca sul bottone "Visualizza Modifica" che 
     * apre una nuova finestra dove è permesso all'utente di visualizzare o
     * modificare il punteggio del match selezionato nella tabella.
     * @param evt evento java.
     */
    private void viewbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewbtnActionPerformed
        if(openViewUpdate == false){ 
            openViewUpdate = true;
            int selectedRowIndex = viewCalendar.getSelectedRow();
            if(selectedRowIndex < 0){
                System.out.println("Nessuna riga della tabella selezionata");
                openViewUpdate = false;
                return ;
            }
            Match view_update = matchesModel.get(selectedRowIndex);
            
            ViewMatch viewMatch;
            
            viewMatch= new ViewMatch(view_update, this, sport);
            viewMatch.setVisible(true);
            viewMatch.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    openViewUpdate = false;
                }
            });
        }
    }//GEN-LAST:event_viewbtnActionPerformed

    /**
     * Metodo chiamato quando si clicca sul bottone "Crea Calendario" che delega
     * alla classe Calendario la creazione di un nuovo calendario attraverso
     * la funzione AlgoritmoDiBerger.
     * @param evt evento java.
     */
    private void createCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCalendarActionPerformed
        if(openYear == false){ 
            openYear = true;
            
            InsertYear insertYear;
            insertYear = new InsertYear(rank, sport, this);
            insertYear.setVisible(true);
            insertYear.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    openYear = false;
                }
            });
            insertYear.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            rank.getCalendar().AlgoritmoDiBerger(rank.getTeams());
            printTable();
        }
    }//GEN-LAST:event_createCalendarActionPerformed

    /**
     * Moetodo chiamato quando viene cliccato il bottone "Stampa" utilizzato
     * per stampare su stampante il calendario delle partite.
     * @param evt evento java.
     */
    private void printbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printbtnActionPerformed
        try{
            this.viewCalendar.print(JTable.PrintMode.FIT_WIDTH);
        } catch (PrinterException ex){
            System.out.println("Impossibile stampare il campionato");
            JOptionPane.showMessageDialog(null, "Impossibile stampare il campionato");
        }
    }//GEN-LAST:event_printbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createCalendar;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton finebtn;
    public javax.swing.JLabel insertYearlbl;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton printbtn;
    private javax.swing.JButton saveCalendarbtn;
    private javax.swing.JTextField searchtxt;
    private javax.swing.JButton serachbtn;
    private javax.swing.JTable viewCalendar;
    private javax.swing.JButton viewbtn;
    private javax.swing.JLabel yearlbl;
    // End of variables declaration//GEN-END:variables

    // Table renderers--------------------------------------------------------
    
    /**
     * Inner class che mi serve per creare un renderer apposito che mostri una 
     * checkbox in base al valore booleano della cella.
     */
    public class CheckBoxRenderer extends JCheckBox implements TableCellRenderer {
        private final int returnStart;
        CheckBoxRenderer(int returnStart) {
            setHorizontalAlignment(JLabel.CENTER);
            this.returnStart = returnStart;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
            
            int daySelected = (int) table.getValueAt(row, 0);
            Color bgColor = daySelected >= returnStart ? Color.LIGHT_GRAY : Color.WHITE;
            Color fgColor = Color.BLACK;
            if(isSelected){
                bgColor = Color.GRAY;
                fgColor = Color.WHITE;
            }
            
            setBackground(bgColor);
            setForeground(fgColor);
            
            setSelected((value != null && ((Boolean) value).booleanValue()));
            return this;
        }
    }
    
    /**
     * Metodo che ritorna un DefaultTableCellRenderer per cambiare il colore di 
     * background alla tabella per righe che mostrano le partite di ritorno in 
     * base a un valore intero chiamato returnStart.
     * @param returnStart valore intero che decide da quale giornata in poi è 
     * il ritorno.
     * @return un oggetto DefaultTableCellRenderer.
     */
    private DefaultTableCellRenderer getCellRenderer(int returnStart){
        return new DefaultTableCellRenderer()
        {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
            {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                int daySelected = (int) table.getValueAt(row, 0);
                Color bgColor = daySelected >= returnStart ? Color.LIGHT_GRAY : Color.WHITE;
                Color fgColor = Color.BLACK;
                if(isSelected){
                    bgColor = Color.GRAY;
                    fgColor = Color.WHITE;
                }

                c.setBackground(bgColor);
                c.setForeground(fgColor);
                return c;
            }
        };
    }
    
    // Table renderers--------------------------------------------------------
}
