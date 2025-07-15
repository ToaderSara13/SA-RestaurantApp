/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Sara
 */
public class VanzariPanel extends JPanel{
    
    
    public VanzariPanel(){
        initComponents();
    }
    private void initComponents(){
        setLayout(null);
        setBackground(new Color(10,15,20));
        
        incarcareDate();
        
        vanzareTableModel = new VanzareTableModel(vanzariDateLinie);
        tabelaVanzari = new JTable(vanzareTableModel);
        tabelaVanzari.setBackground(new Color(20,15,40));
        tabelaVanzari.setFont(new Font("Segoe UI", Font.PLAIN, 16)); 
        tabelaVanzari.setRowHeight(24);
        tabelaVanzari.setGridColor(new Color(173, 216, 230));
        
        JTableHeader header = tabelaVanzari.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 16));           
        header.setForeground(Color.RED);                             
        header.setBackground(new Color(60, 60, 120));
        
        TableColumnModel columnModel = tabelaVanzari.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150); 
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(150);
        columnModel.getColumn(4).setPreferredWidth(150);
        columnModel.getColumn(5).setPreferredWidth(160);
        columnModel.getColumn(6).setPreferredWidth(250);
        
        DefaultTableCellRenderer colorRenderer = new DefaultTableCellRenderer();
        colorRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        colorRenderer.setForeground(Color.BLUE);
        for (int i = 0; i < tabelaVanzari.getColumnCount(); i++) {
            tabelaVanzari.getColumnModel().getColumn(i).setCellRenderer(colorRenderer);
            columnModel.getColumn(i).setResizable(false);
        }
        tabelaVanzari.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        scrollTabela = new JScrollPane(tabelaVanzari);
        scrollTabela.getViewport().setBackground(new Color(20, 15, 40));
        scrollTabela.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollTabela.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollTabela.getVerticalScrollBar().setUnitIncrement(16);
        scrollTabela.setBorder(null);
        scrollTabela.setVisible(true);
        scrollTabela.setBounds(60, 280, 1160, 300);
        scrollTabela.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(0,0,130);
            }
        });
        scrollTabela.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(80, 90, 130);      
                this.trackColor = new Color(30, 35, 60);        
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }
            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }
            private JButton createZeroButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                button.setVisible(false);
                return button;
            }
        });
        add(scrollTabela);
        
        cantitateLabel.setBounds(90, 50, 200, 30);                     
        cantitateLabel.setVisible(true);
        cantitateLabel.setForeground(new Color(102, 100, 204));
        cantitateLabel.setFont(new Font("Courier New", Font.BOLD, 25));
        add(cantitateLabel);
        
        
        sortareCantitate.setBounds(260,50,120,30);
        sortareCantitate.setVisible(true);
        sortareCantitate.setFont(new Font("Arial", Font.BOLD ,15));
        sortareCantitate.setBackground(new Color(30, 35, 60));
        sortareCantitate.setForeground(Color.WHITE);
        sortareCantitate.addActionListener(sortareCantitateActiune());
        add(sortareCantitate);
        
        dataLabel.setBounds(790, 50, 250, 30);                     
        dataLabel.setVisible(true);
        dataLabel.setForeground(new Color(102, 100, 204));
        dataLabel.setFont(new Font("Courier New", Font.BOLD, 25));
        add(dataLabel);
        
        
        sortareData.setBounds(1010,50,120,30);
        sortareData.setVisible(true);
        sortareData.setFont(new Font("Arial", Font.BOLD ,15));
        sortareData.setBackground(new Color(30, 35, 60));
        sortareData.setForeground(Color.WHITE);
        sortareData.addActionListener(sortareDataActiune());
        add(sortareData);
        
        
        pretTotalMinLabel.setBounds(20, 120, 250, 30);                     
        pretTotalMinLabel.setVisible(true);
        pretTotalMinLabel.setForeground(new Color(102, 100, 204));
        pretTotalMinLabel.setFont(new Font("Courier New", Font.BOLD, 20));
        add(pretTotalMinLabel);
        
        
        pretTotalMaxLabel.setBounds(20, 180, 250, 30);                     
        pretTotalMaxLabel.setVisible(true);
        pretTotalMaxLabel.setForeground(new Color(102, 100, 204));
        pretTotalMaxLabel.setFont(new Font("Courier New", Font.BOLD, 20));
        add(pretTotalMaxLabel);
        
        
        pretTotalMinText.setBounds(250, 120, 70, 30);
        pretTotalMinText.setBackground(new Color(10,25,40));
        pretTotalMinText.setForeground(Color.CYAN);
        pretTotalMinText.setFont(new Font("Courier New", Font.ITALIC, 15));
        pretTotalMinText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        pretTotalMinText.setVisible(true);
        add(pretTotalMinText);
        
        
        pretTotalMaxText.setBounds(250, 180, 70, 30);
        pretTotalMaxText.setBackground(new Color(10,25,40));
        pretTotalMaxText.setForeground(Color.CYAN);
        pretTotalMaxText.setFont(new Font("Courier New", Font.ITALIC, 15));
        pretTotalMaxText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        pretTotalMaxText.setVisible(true);
        add(pretTotalMaxText);
        
        
        filtruPretButton.setVisible(true);
        filtruPretButton.setForeground(Color.CYAN);
        filtruPretButton.setFont(new Font("Arial", Font.BOLD, 15));
        filtruPretButton.setBackground(new Color(10,25,40));
        filtruPretButton.setOpaque(true);
        filtruPretButton.setContentAreaFilled(true);           
        filtruPretButton.setBorderPainted(false);
        filtruPretButton.setFocusPainted(false);
        filtruPretButton.setBounds(340, 150, 150, 40);
        filtruPretButton.addMouseListener(filtrarePret());
        add(filtruPretButton);
        
        
        dupaLabel.setBounds(600, 120, 250, 30);                     
        dupaLabel.setVisible(true);
        dupaLabel.setForeground(new Color(102, 100, 204));
        dupaLabel.setFont(new Font("Courier New", Font.BOLD, 20));
        add(dupaLabel);
        
        
        inainteLabel.setBounds(600, 180, 280, 30);                     
        inainteLabel.setVisible(true);
        inainteLabel.setForeground(new Color(102, 100, 204));
        inainteLabel.setFont(new Font("Courier New", Font.BOLD, 20));
        add(inainteLabel);
        
        
        dupaText.setBounds(830, 120, 70, 30);
        dupaText.setBackground(new Color(10,25,40));
        dupaText.setForeground(Color.CYAN);
        dupaText.setFont(new Font("Courier New", Font.ITALIC, 15));
        dupaText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        dupaText.setVisible(true);
        add(dupaText);
        
        
        inainteText.setBounds(830, 180, 70, 30);
        inainteText.setBackground(new Color(10,25,40));
        inainteText.setForeground(Color.CYAN);
        inainteText.setFont(new Font("Courier New", Font.ITALIC, 15));
        inainteText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        inainteText.setVisible(true);
        add(inainteText);
        
        
        filtruDateButton.setVisible(true);
        filtruDateButton.setForeground(Color.CYAN);
        filtruDateButton.setFont(new Font("Arial", Font.BOLD, 15));
        filtruDateButton.setBackground(new Color(10,25,40));
        filtruDateButton.setOpaque(true);
        filtruDateButton.setContentAreaFilled(true);           
        filtruDateButton.setBorderPainted(false);
        filtruDateButton.setFocusPainted(false);
        filtruDateButton.setBounds(920, 150, 150, 40);
        filtruDateButton.addMouseListener(filtrareData());
        add(filtruDateButton);
        
        
        refreshButton.setVisible(true);
        refreshButton.setForeground(Color.CYAN);
        refreshButton.setFont(new Font("Arial", Font.BOLD, 17));
        refreshButton.setBackground(new Color(10,25,40));
        refreshButton.setOpaque(true);
        refreshButton.setContentAreaFilled(true);           
        refreshButton.setBorderPainted(false);
        refreshButton.setFocusPainted(false);
        refreshButton.setBounds(800, 590, 150, 50);
        refreshButton.addMouseListener(refreshActiune());
        add(refreshButton);
        
        
        stergereButton.setVisible(true);
        stergereButton.setForeground(Color.CYAN);
        stergereButton.setFont(new Font("Arial", Font.BOLD, 15));
        stergereButton.setBackground(new Color(90,25,40));
        stergereButton.setOpaque(true);
        stergereButton.setContentAreaFilled(true);           
        stergereButton.setBorderPainted(false);
        stergereButton.setFocusPainted(false);
        stergereButton.setBounds(970, 590, 150, 50);
        stergereButton.addMouseListener(stergereActiune());
        add(stergereButton);
        
        sortator = new TableRowSorter<>(tabelaVanzari.getModel());
        tabelaVanzari.setRowSorter(sortator);
        
        for (int i = 0; i < tabelaVanzari.getColumnCount(); i++) {
            sortator.setSortable(i, false);
        }
    }
    
     private MouseAdapter filtrareData() {
    return new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            String dupaDataDeStr = dupaText.getText().trim();
            String inainteDeDataStr = inainteText.getText().trim();

            if (dupaDataDeStr.isEmpty() && inainteDeDataStr.isEmpty()) {
                sortator.setRowFilter(null);
                return;
            }

            LocalDate dupaDataDe = null;
            LocalDate inainteDeDat = null;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try {
                if (!dupaDataDeStr.isEmpty()) {
                    dupaDataDe = LocalDate.parse(dupaDataDeStr, formatter);
                }
                if (!inainteDeDataStr.isEmpty()) {
                    inainteDeDat = LocalDate.parse(inainteDeDataStr, formatter);
                }
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(null, "Invalid date format. Use dd-MM-yyyy.");
                return;
            }
            LocalDate finalDupaDataDe = dupaDataDe;
            LocalDate finalInainteDeData = inainteDeDat;
            sortator.setRowFilter(new RowFilter<TableModel, Integer>() {
                @Override
                public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
                    try {
                        String timestampStr = entry.getStringValue(5);
                        LocalDate entryDate = LocalDateTime.parse(timestampStr).toLocalDate();

                        if (finalDupaDataDe != null && entryDate.isBefore(finalDupaDataDe)) return false;
                        if (finalInainteDeData != null && entryDate.isAfter(finalInainteDeData)) return false;

                        return true;
                    } catch (Exception ex) {
                        return false;
                    }
                }
            });
        }
    };
}
    
     private MouseAdapter stergereActiune() {
        return new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tabelaVanzari.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a row to delete.");
                    return;
                }
                int modelRow = tabelaVanzari.convertRowIndexToModel(selectedRow);
                Vanzare vanzareDeSters = vanzariDateLinie.get(modelRow);

                int confirm = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete sale with ID " + vanzareDeSters.getV_id() + "?",
                        "Confirm Delete", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        Connection conn = DBConnect.getConnection();
                        PreparedStatement stmt = conn.prepareStatement("DELETE FROM vanzari WHERE v_id = ?");
                        stmt.setInt(1, vanzareDeSters.getV_id());
                        int affectedRows = stmt.executeUpdate();

                        if (affectedRows > 0) {
                            vanzariDateLinie.remove(modelRow);
                            vanzareTableModel.fireTableRowsDeleted(modelRow, modelRow);
                            JOptionPane.showMessageDialog(null, "Sale deleted successfully.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Sale could not be deleted.");
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
                    }
                }
            }
        };
    }

    private MouseAdapter refreshActiune(){
        return new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                vanzariDateLinie.clear();
                incarcareDate();
                vanzareTableModel.fireTableDataChanged();
            }
        };
    }
    private MouseAdapter filtrarePret(){
        return new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(pretTotalMinText.getText().isEmpty() && pretTotalMaxText.getText().isEmpty())
                    sortator.setRowFilter(null);
                else{
                    Double min = null; Double max = null;
                    try {
                        if (!pretTotalMinText.getText().isEmpty()) {
                             min = Double.parseDouble(pretTotalMinText.getText());
                        }
                        if (!pretTotalMaxText.getText().isEmpty()) {
                             max = Double.parseDouble(pretTotalMaxText.getText());
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid number format for amount.");
                        return;
                    }
                    Double finalMin = min;
                    Double finalMax = max;
                    sortator.setRowFilter(new RowFilter<TableModel, Integer>() {
                        @Override
                        public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
                            try {
                                double amount = Double.parseDouble(entry.getStringValue(5));
                                if (finalMin != null && amount < finalMin) return false;
                                if (finalMax != null && amount > finalMax) return false;
                                return true;
                            } catch (NumberFormatException e) {
                                return false;
                            }
                        }
                    });
                    
                }
            }
        };
    }
    
    
    private ActionListener sortareCantitateActiune(){
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String selection = (String) sortareCantitate.getSelectedItem();

                if (selection != null) {
                    switch (selection) {
                        case "Descrescator":
                            sortator.setSortKeys(List.of(new RowSorter.SortKey(3, SortOrder.DESCENDING)));
                            break;
                        case "Crescator":
                            sortator.setSortKeys(List.of(new RowSorter.SortKey(3, SortOrder.ASCENDING)));
                            break;
                        default:
                            sortator.setSortKeys(null);
                    }
                }
            }
        };
    }
    
    private ActionListener sortareDataActiune(){
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String selection = (String) sortareData.getSelectedItem();

                if (selection != null) {
                    switch (selection) {
                        case "Recente":
                            sortator.setSortKeys(List.of(new RowSorter.SortKey(6, SortOrder.DESCENDING)));
                            break;
                        case "Vechi":
                            sortator.setSortKeys(List.of(new RowSorter.SortKey(6, SortOrder.ASCENDING)));
                            break;
                        default:
                            sortator.setSortKeys(null);
                    }
                }
            }
        };
    }
    
    private void incarcareDate(){
        vanzariDateLinie.clear();
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement saleStmt = conn.prepareStatement("SELECT * FROM vanzari");
            ResultSet rs = saleStmt.executeQuery();
            while(rs.next()){
                
                int v_id = rs.getInt("v_id");
                int p_id = rs.getInt("p_id");
                int u_id = rs.getInt("u_id");
                int cantitate = rs.getInt("cantitate");
                double pret = rs.getDouble("pret");
                double pret_total = rs.getDouble("pret_total");
                Timestamp ts = rs.getTimestamp("timestamp") ;
                LocalDateTime timestamp = ts.toLocalDateTime();
                
                Vanzare vanzare = new Vanzare(v_id, p_id, u_id, cantitate, pret, pret_total, timestamp);
                vanzariDateLinie.add(vanzare);
            }
        } catch (SQLException ex) {
            System.getLogger(VanzariPanel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    List<Vanzare> vanzariDateLinie = new ArrayList<>();
    private VanzareTableModel vanzareTableModel;
    private JTable tabelaVanzari; 
    private JScrollPane scrollTabela;
    private JLabel cantitateLabel = new JLabel("Cantitate ");
    private String[] optiuni = { "None", "Crescator" , "Descrescator"};
    private JComboBox<String> sortareCantitate = new JComboBox<>(optiuni);
    private TableRowSorter<TableModel> sortator;
    private JLabel dataLabel = new JLabel("Data vanzarii ");
    private String[] optiuniData = { "None", "Recente" , "Vechi"};
    private JComboBox<String> sortareData = new JComboBox<>(optiuniData);
    private JLabel pretTotalMinLabel = new JLabel("Pret total minim :");
    private JLabel pretTotalMaxLabel = new JLabel("Pret total maxim :");
    private JTextField pretTotalMinText = new JTextField();
    private JTextField pretTotalMaxText = new JTextField();
    private JButton filtruPretButton = new JButton("Aplica filtru");
    private JLabel dupaLabel = new JLabel("Dupa data de :");
    private JLabel inainteLabel = new JLabel("Inainte de data de ");
    private JTextField dupaText = new JTextField();
    private JTextField inainteText = new JTextField();
    private JButton filtruDateButton = new JButton("Aplica filtru");
    JButton refreshButton = new JButton("Refresh");
    JButton stergereButton = new JButton("Sterge");
}   
