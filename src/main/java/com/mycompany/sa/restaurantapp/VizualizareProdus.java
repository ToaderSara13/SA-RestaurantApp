/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp;

import com.mycompany.sa.restaurantapp.clase_produse.Bautura;
import com.mycompany.sa.restaurantapp.clase_produse.Desert;
import com.mycompany.sa.restaurantapp.clase_produse.Mancare;
import com.mycompany.sa.restaurantapp.clase_produse.Produs;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author denia
 */
public class VizualizareProdus extends JPanel {
    
    private ProduseList produseList;
    private JScrollPane scrollPane;
    
    public VizualizareProdus(){
    
    }
    
    public VizualizareProdus(Produs produs , ProduseList produseList, JScrollPane scrollPane){
        this.produseList = produseList;
        this.scrollPane = scrollPane;
        initComponents(produs, produseList);
    }
    
    private void initComponents(Produs produs , ProduseList produseList){
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        
        
        denumireLabel.setVisible(true);
        denumireLabel.setBounds(20, 20, 200, 50);
        denumireLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        denumireLabel.setForeground(new Color(102, 100, 204));
        add(denumireLabel);
        
        denumireText.setText(produs.getDenumire());
        denumireText.setBounds(225, 20, 230, 50);
        denumireText.setBackground(new Color(10,25,40));
        denumireText.setForeground(Color.CYAN);
        denumireText.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        denumireText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        denumireText.setVisible(true);
        denumireText.setEditable(false);
        add(denumireText);
        
        
        stocLabel.setVisible(true);
        stocLabel.setBounds(20, 90, 200, 50);
        stocLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        stocLabel.setForeground(new Color(102, 100, 204));
        add(stocLabel);
        
        stocText.setText(String.valueOf(produs.getStoc()));
        stocText.setBounds(225, 90, 230, 50);
        stocText.setBackground(new Color(10,25,40));
        stocText.setForeground(Color.CYAN);
        stocText.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        stocText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        stocText.setVisible(true);
        stocText.setEditable(false);
        add(stocText);
        
        pretLabel.setVisible(true);
        pretLabel.setBounds(20, 160, 200, 50);
        pretLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        pretLabel.setForeground(new Color(102, 100, 204));
        add(pretLabel);
        
        pretText.setText(String.valueOf(produs.getPret()));
        pretText.setBounds(225, 160, 230, 50);
        pretText.setBackground(new Color(10,25,40));
        pretText.setForeground(Color.CYAN);
        pretText.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        pretText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        pretText.setVisible(true);
        pretText.setEditable(false);
        add(pretText);
        
        
        caloriiLabel.setVisible(true);
        caloriiLabel.setBounds(20, 230, 200, 50);
        caloriiLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        caloriiLabel.setForeground(new Color(102, 100, 204));
        add(caloriiLabel);
        
        caloriiText.setText(String.valueOf(produs.getCalorii()));
        caloriiText.setBounds(225, 230, 230, 50);
        caloriiText.setBackground(new Color(10,25,40));
        caloriiText.setForeground(Color.CYAN);
        caloriiText.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        caloriiText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        caloriiText.setVisible(true);
        caloriiText.setEditable(false);
        add(caloriiText);
        
        
        tipProdusLabel.setVisible(true);
        tipProdusLabel.setBounds(20, 300, 200, 50);
        tipProdusLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        tipProdusLabel.setForeground(new Color(102, 100, 204));
        add(tipProdusLabel);
        
        tipProdusText.setText(produs.getTipProdus());
        tipProdusText.setBounds(225, 300, 230, 50);
        tipProdusText.setBackground(new Color(10,25,40));
        tipProdusText.setForeground(Color.CYAN);
        tipProdusText.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        tipProdusText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        tipProdusText.setVisible(true);
        tipProdusText.setEditable(false);
        add(tipProdusText);
        
        if(produs instanceof Mancare m){
            stilLabel.setVisible(true);
            stilLabel.setBounds(20, 370, 200, 50);
            stilLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
            stilLabel.setForeground(new Color(102, 100, 204));
            add(stilLabel);

            stilText.setText(m.getStil());
            stilText.setBounds(225, 370, 230, 50);
            stilText.setBackground(new Color(10,25,40));
            stilText.setForeground(Color.CYAN);
            stilText.setFont(new Font("Segoe UI", Font.ITALIC, 20));
            stilText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            stilText.setVisible(true);
            stilText.setEditable(false);
            add(stilText);
        }else if(produs instanceof Desert d){
            tipDesertLabel.setVisible(true);
            tipDesertLabel.setBounds(20, 370, 200, 50);
            tipDesertLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tipDesertLabel.setForeground(new Color(102, 100, 204));
            add(tipDesertLabel);

            tipDesertText.setText(d.getTip());
            tipDesertText.setBounds(225, 370, 230, 50);
            tipDesertText.setBackground(new Color(10,25,40));
            tipDesertText.setForeground(Color.CYAN);
            tipDesertText.setFont(new Font("Segoe UI", Font.ITALIC, 20));
            tipDesertText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            tipDesertText.setVisible(true);
            tipDesertText.setEditable(false);
            add(tipDesertText);
        }else if(produs instanceof Bautura b){
            tipBauturaLabel.setVisible(true);
            tipBauturaLabel.setBounds(20, 370, 200, 50);
            tipBauturaLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
            tipBauturaLabel.setForeground(new Color(102, 100, 204));
            add(tipBauturaLabel);

            tipBauturaText.setText(b.getTip());
            tipBauturaText.setBounds(225, 370, 230, 50);
            tipBauturaText.setBackground(new Color(10,25,40));
            tipBauturaText.setForeground(Color.CYAN);
            tipBauturaText.setFont(new Font("Segoe UI", Font.ITALIC, 20));
            tipBauturaText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            tipBauturaText.setVisible(true);
            tipBauturaText.setEditable(false);
            add(tipBauturaText);

            caldaCheckBox.setSelected(b.isCalda());
            caldaCheckBox.setBounds(20, 440, 250, 50);
            caldaCheckBox.setVisible(true);
            caldaCheckBox.setOpaque(false);
            caldaCheckBox.setForeground(Color.CYAN);
            caldaCheckBox.setFont(new Font("Segoe UI", Font.ITALIC, 25));
            caldaCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
            caldaCheckBox.setOpaque(false);
            caldaCheckBox.setEnabled(false);
            add(caldaCheckBox);
        }
        imagineProdus = new ImagineCard(produs.getImagine(),250, 250);
        imagineProdus.setBounds(700, 20, 250, 250);
        imagineProdus.setVisible(true);
        imagineProdus.setBorder(new LineBorder(Color.RED, 1));
        add(imagineProdus);
        
        puneImagine.setVisible(false);
        puneImagine.setForeground(Color.CYAN);
        puneImagine.setFont(new Font("Arial", Font.BOLD, 15));
        puneImagine.setBackground(new Color(10,25,40));
        puneImagine.setOpaque(true);
        puneImagine.setContentAreaFilled(true);           
        puneImagine.setBorderPainted(false);
        puneImagine.setFocusPainted(false);
        puneImagine.setBounds(475, 120, 180, 50);
        puneImagine.addMouseListener(puneImagineAction());
        add(puneImagine);
        
        descriereLabel.setVisible(true);
        descriereLabel.setBounds(490, 290, 200, 50);
        descriereLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        descriereLabel.setForeground(new Color(102, 100, 204));
        add(descriereLabel);
        
        descriereArea.setText(produs.getDescriere());
        descriereArea.setBackground(new Color(10,25,40));
        descriereArea.setForeground(Color.WHITE);
        descriereArea.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        descriereArea.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        descriereArea.setVisible(true);
        descriereArea.setLineWrap(true);
        descriereArea.setWrapStyleWord(true);
        descriereArea.setEditable(false);
        
        descriereScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        descriereScroll.getVerticalScrollBar().setUnitIncrement(16);
        descriereScroll.setBorder(null);
        descriereScroll.setVisible(true);
        descriereScroll.setBounds(490, 340, 430, 150);
        descriereScroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(0,0,130);
            }
        });
        descriereScroll.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
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
        add(descriereScroll);
        
        modificaProdus.setVisible(false);
        modificaProdus.setForeground(Color.WHITE);
        modificaProdus.setFont(new Font("Arial", Font.BOLD, 15));
        modificaProdus.setBackground(new Color(90, 90, 20));
        modificaProdus.setOpaque(true);
        modificaProdus.setContentAreaFilled(true);           
        modificaProdus.setBorderPainted(false);
        modificaProdus.setFocusPainted(false);
        modificaProdus.setBounds(550, 500, 180, 50);
        modificaProdus.addMouseListener(modificaProdusActiune(produs));
        add(modificaProdus);
        
        salveazaProdus.setVisible(false);
        salveazaProdus.setForeground(Color.WHITE);
        salveazaProdus.setFont(new Font("Arial", Font.BOLD, 15));
        salveazaProdus.setBackground(new Color(10,60,40));
        salveazaProdus.setOpaque(true);
        salveazaProdus.setContentAreaFilled(true);           
        salveazaProdus.setBorderPainted(false);
        salveazaProdus.setFocusPainted(false);
        salveazaProdus.setBounds(740, 500, 180, 50);
        salveazaProdus.addMouseListener(salveazaProdusAction(produs));
        add(salveazaProdus); 
        
        stergereProdus.setVisible(false);
        stergereProdus.setForeground(Color.CYAN);
        stergereProdus.setFont(new Font("Arial", Font.BOLD, 15));
        stergereProdus.setBackground(new Color(90,25,40));
        stergereProdus.setOpaque(true);
        stergereProdus.setContentAreaFilled(true);           
        stergereProdus.setBorderPainted(false);
        stergereProdus.setFocusPainted(false);
        stergereProdus.setBounds(740, 500, 180, 50);
        stergereProdus.addMouseListener(stergeProdusActiune(produs ,produseList));
        add(stergereProdus);
        
        
        cumparaButton.setVisible(false);
        cumparaButton.setForeground(Color.CYAN);
        cumparaButton.setFont(new Font("Arial", Font.BOLD, 15));
        cumparaButton.setBackground(new Color(10,80,40));
        cumparaButton.setOpaque(true);
        cumparaButton.setContentAreaFilled(true);           
        cumparaButton.setBorderPainted(false);
        cumparaButton.setFocusPainted(false);
        cumparaButton.setBounds(740, 500, 180, 50);
        cumparaButton.addMouseListener(cumparaButtonAction(produs));
        add(cumparaButton);


        backButton.setBounds(420, 500, 100, 50);
        backButton.setVisible(true);
        backButton.setOpaque(true);                     
        backButton.setContentAreaFilled(true);
        backButton.setFont(new Font("Arial", Font.BOLD, 17));
        backButton.setForeground(Color.WHITE);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        backButton.addMouseListener(backAction());
        backButton.setBackground(new Color(60, 15, 25));
        add(backButton);
        
        
    }
    private boolean cumparareSucces = false;
    private void cumparare(int pId, int uId , double pret, int cantitate){
        try{
            Connection conn = DBConnect.getConnection();
            conn.setAutoCommit(false);
            String sql = "INSERT INTO vanzari (p_id, u_id, cantitate, pret, pret_total) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement productStmt = conn.prepareStatement(sql);
            productStmt.setInt(1, pId);
            productStmt.setInt(2, uId);
            productStmt.setInt(3, cantitate);
            productStmt.setDouble(4, pret);
            productStmt.setDouble(5, pret * cantitate);
            productStmt.executeUpdate();
            
            String updateStock = "UPDATE produs SET stoc = stoc - ? WHERE id = ?";
            try (PreparedStatement stockStmt = conn.prepareStatement(updateStock)) {
                stockStmt.setInt(1, cantitate);
                stockStmt.setInt(2, pId);
                stockStmt.executeUpdate();
                cumparareSucces = true;
            }
            conn.commit(); 
            conn.setAutoCommit(true);
        }catch (SQLException ex) {
            ex.printStackTrace();
            cumparareSucces = false;
            JOptionPane.showMessageDialog(null,"Error! Database error.","Account error",JOptionPane.ERROR_MESSAGE);
        }
    }
    private MouseAdapter cumparaButtonAction(Produs p){
        return new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int produsId = p.getId();
                int utilizatorId = Sesiune.getUtilizatorCurent().getUtilizatorId();
                double pret = Double.parseDouble(pretText.getText());
                
                String input = JOptionPane.showInputDialog(null, "How many units would you like to buy?", "Purchase", JOptionPane.QUESTION_MESSAGE);
                if (input != null) {
                    try {
                        int cantitate = Integer.parseInt(input);
                        if (cantitate <= 0) {
                            JOptionPane.showMessageDialog(null, "Quantity must be greater than zero!");
                            return;
                        }
                        int stoc = Integer.parseInt(stocText.getText());
                        if(cantitate > stoc){
                            JOptionPane.showMessageDialog(null, "Insufficient stocks!");
                        }else{
                        cumparare(produsId, utilizatorId, pret, cantitate);
                        if(cumparareSucces){
                        JOptionPane.showMessageDialog(null, "Purchase successful!");
                        stocText.setText(String.valueOf(stoc - cantitate));
                        }
                     }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(null, "Purchase failed: " + exc.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Purchase canceled.");
                }
                        
            }
        };
    }
    
    
    
    
    
    
    
    
    public void stergereModificareBackBuyTrue(){
        backButton.setVisible(true);
        
        if(Sesiune.getUtilizatorCurent().getRol().toLowerCase().equals("admin")){
            modificaProdus.setVisible(true);
            stergereProdus.setVisible(true);
            cumparaButton.setVisible(false);
        }else{
            cumparaButton.setVisible(true);
        }
    }
    public void stergereModificareBackBuyFalse(){
        backButton.setVisible(false);
        modificaProdus.setVisible(false);
        stergereProdus.setVisible(false);
        cumparaButton.setVisible(false);
    }
    
    private MouseAdapter backAction(){
        return new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                
                setVisible(false);
                stergereModificareBackBuyFalse();
                scrollPane.setVisible(true);
                produseList.revalidate();
                produseList.repaint();
            }
        };
    }
    
    
private MouseAdapter salveazaProdusAction(Produs produs) {
    return new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            String denumire = denumireText.getText().trim();
            String stocStr = stocText.getText().trim();
            String pretStr = pretText.getText().trim();
            String caloriiStr = caloriiText.getText().trim();
            String descriere = descriereArea.getText().trim();
            String tipProdus = tipProdusText.getText().trim();
            //int produsId = produs.getId();
            if (denumire.isEmpty() || stocStr.isEmpty() || pretStr.isEmpty() || caloriiStr.isEmpty() || descriere.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Completează toate câmpurile!", "Eroare", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int stoc, calorii;
            double pret;
            try {
                stoc = Integer.parseInt(stocStr);
                calorii = Integer.parseInt(caloriiStr);
                pret = Double.parseDouble(pretStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Valori numerice invalide!", "Eroare", JOptionPane.ERROR_MESSAGE);
                return;
            }

            File selectedImage = imagineSelectata;
            if (selectedImage == null || !selectedImage.exists()) {
                JOptionPane.showMessageDialog(null, "Selectează o imagine validă.", "Eroare", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String imageDir = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "product_images").toString();
            String imageName = "produs_" + System.currentTimeMillis() + ".png";
            String imagePathInProject = "product_images/" + imageName;

            try {
                Files.createDirectories(Paths.get(imageDir));
                Files.copy(selectedImage.toPath(), Paths.get(imageDir, imageName), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ioEx) {
                ioEx.printStackTrace();
                JOptionPane.showMessageDialog(null, "Eroare la salvarea imaginii!", "Eroare", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try (Connection conn = DBConnect.getConnection()) {
                String insertSQL = "UPDATE produs SET denumire = ?, calorii = ?, stoc = ?, pret = ?, imagine = ?, descriere = ? WHERE id = ?";
                PreparedStatement produsStmt = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
                produsStmt.setString(1, denumire);
                produsStmt.setInt(2, calorii);
                produsStmt.setInt(3, stoc);
                produsStmt.setDouble(4, pret);
                produsStmt.setString(5, imagePathInProject);
                produsStmt.setString(6, descriere);
                produsStmt.setInt(7, produs.getId());
                
                produsStmt.executeUpdate();

                    switch (tipProdus.toLowerCase()) {
                        case "mancare":
                            String stil = stilText.getText().trim().toLowerCase();
                            if (stil.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Completează câmpul STIL pentru mancare.", "Eroare", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            PreparedStatement mancareStmt = conn.prepareStatement("UPDATE mancare SET stil = ? WHERE id = ?");
                            mancareStmt.setString(1, stil);
                            mancareStmt.setInt(2, produs.getId());
                            mancareStmt.executeUpdate();
                            break;

                        case "desert":
                            String tipDesert = tipDesertText.getText().trim().toLowerCase();
                            if (tipDesert.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Completează câmpul TIP pentru desert.", "Eroare", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            PreparedStatement desertStmt = conn.prepareStatement("UPDATE desert SET tip = ? WHERE id = ?");
                            desertStmt.setString(1, tipDesert);
                            desertStmt.setInt(2, produs.getId());
                            desertStmt.executeUpdate();
                            break;

                        case "bautura":
                            String tipBautura = tipBauturaText.getText().trim().toLowerCase();
                            boolean calda = caldaCheckBox.isSelected();
                            if (tipBautura.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Completează câmpul TIP pentru băutură.", "Eroare", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            PreparedStatement bauturaStmt = conn.prepareStatement("UPDATE bautura SET tip = ?, calda = ? WHERE id = ?");
                            bauturaStmt.setString(1, tipBautura);
                            bauturaStmt.setBoolean(2, calda);
                            bauturaStmt.setInt(3, produs.getId());
                            bauturaStmt.executeUpdate();
                            break;
                    }

                    JOptionPane.showMessageDialog(null, "Produs actualizat cu succes!", "Succes", JOptionPane.INFORMATION_MESSAGE);
                    puneImagine.setVisible(false);
                    modificaProdusClicked = false;
                    modificaProdus.setText("Modifica");
                    modificaProdus.setBackground(new Color(90, 90, 20));
                    salveazaProdus.setVisible(false);
                    stergereProdus.setVisible(true);
                

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Eroare la baza de date!", "Eroare", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
}
    
    
    
    
    
    
    
    private MouseAdapter stergeProdusActiune(Produs produs, ProduseList produseList) {
    return new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this product?","Confirm Deletion",JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }
            try (Connection conn = DBConnect.getConnection()) {
//                PreparedStatement deleteSales = conn.prepareStatement("DELETE FROM sales WHERE product_id = ?");
//                deleteSales.setInt(1, p.getId());
//                deleteSales.executeUpdate();
                if ("Mancare".equalsIgnoreCase(produs.getTipProdus())) {
                    PreparedStatement stergeMancare = conn.prepareStatement("DELETE FROM mancare WHERE id = ?");
                    stergeMancare.setInt(1, produs.getId());
                    stergeMancare.executeUpdate();
                } else if ("Desert".equalsIgnoreCase(produs.getTipProdus())) {
                    PreparedStatement stergeDesert = conn.prepareStatement("DELETE FROM desert WHERE id = ?");
                    stergeDesert.setInt(1, produs.getId());
                    stergeDesert.executeUpdate();
                }else if("Bautura".equalsIgnoreCase(produs.getTipProdus())){
                    PreparedStatement stergeBautura = conn.prepareStatement("DELETE FROM bautura WHERE id = ?");
                    stergeBautura.setInt(1, produs.getId());
                    stergeBautura.executeUpdate();
                }
                PreparedStatement stergeProdus = conn.prepareStatement("DELETE FROM produs WHERE id = ?");
                stergeProdus.setInt(1, produs.getId());
                stergeProdus.executeUpdate();
                File imageFile = new File(System.getProperty("user.dir"), "src/main/resources/" + produs.getImagine());
                if (imageFile.exists()) {
                    imageFile.delete();
                    System.out.println("Deleted image: " + imageFile.getAbsolutePath());
                }
                JOptionPane.showMessageDialog(null, "Product deleted successfully!", "Deleted", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
                produseList.scrollPaneTrue();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error deleting product from database.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
}
    
    
    
    
    
    private boolean modificaProdusClicked = false;
    private MouseAdapter modificaProdusActiune(Produs produs){
        return new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                modificaProdusClicked = !modificaProdusClicked;
                if(modificaProdusClicked){
                    puneImagine.setVisible(true);
                    modificaProdus.setText("Cancel");
                    modificaProdus.setBackground(new Color(75, 25, 40));
                    stergereProdus.setVisible(false);
                    salveazaProdus.setVisible(true);
                    editareTextTrue(produs);
                    
                }else{
                    cancelActiune(produs);
                    puneImagine.setVisible(false);
                    modificaProdus.setText("Modifica");
                    modificaProdus.setBackground(new Color(90, 90, 20));
                    salveazaProdus.setVisible(false);
                    stergereProdus.setVisible(true);
                
                }
            }
        };
    }
    
    private void cancelActiune(Produs produs){
        
        if(!descriereArea.getText().toLowerCase().equals(produs.getDescriere().toLowerCase()))
            descriereArea.setText(produs.getDescriere());
        if(!denumireText.getText().toLowerCase().equals(produs.getDenumire().toLowerCase()))
            denumireText.setText(produs.getDenumire());
        int stoc = Integer.parseInt(stocText.getText());
        if(stoc != produs.getStoc())
            stocText.setText(String.valueOf(produs.getStoc()));
        double pret = Double.parseDouble(pretText.getText());
        if(pret != produs.getPret())
            pretText.setText(String.valueOf(produs.getPret()));
        int calorii = Integer.parseInt(caloriiText.getText());
        if(calorii != produs.getCalorii())
            caloriiText.setText(String.valueOf(produs.getCalorii()));
        if(produs instanceof Mancare m){
            if(!stilText.getText().toLowerCase().equals(m.getStil().toLowerCase()))
                stilText.setText(m.getStil());
        }else if(produs instanceof Desert d){
            if(!tipDesertText.getText().toLowerCase().equals(d.getTip().toLowerCase()))
                tipDesertText.setText(d.getTip());  
        }else if(produs instanceof Bautura b){
            if(!tipBauturaText.getText().toLowerCase().equals(b.getTip().toLowerCase()))
                tipBauturaText.setText(b.getTip()); 
            if(caldaCheckBox.isSelected() != b.isCalda())
                caldaCheckBox.setSelected(b.isCalda());
        }
    }
    
    
    public void editareTextTrue(Produs produs){
        descriereArea.setEditable(true);
        denumireText.setEditable(true);
        stocText.setEditable(true);
        pretText.setEditable(true);
        caloriiText.setEditable(true);
        if(produs.getTipProdus().toLowerCase().equals("bautura")){
            tipBauturaText.setEditable(true);
            caldaCheckBox.setEnabled(true);
        }else if(produs.getTipProdus().toLowerCase().equals("desert")){
            tipDesertText.setEditable(true);
        }else if(produs.getTipProdus().toLowerCase().equals("mancare")){
            stilText.setEditable(true);
        }
    }
    
    
    private MouseAdapter puneImagineAction(){
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FileDialog fileDialog = new FileDialog((Frame) SwingUtilities.getWindowAncestor(VizualizareProdus.this), "Select Product Image", FileDialog.LOAD);
                fileDialog.setVisible(true);

                String directory = fileDialog.getDirectory();
                String selectedFile = fileDialog.getFile();

                if (directory != null && selectedFile != null &&
                    (selectedFile.endsWith(".jpg") || selectedFile.endsWith(".png") || selectedFile.endsWith(".jpeg"))) {

                    imagineSelectata = new File(directory, selectedFile);

                    imagineProdus.loadPreviewFromFile(imagineSelectata, 250, 250);
                }
            }
        };
    }
    
    
    
    
    private File imagineSelectata;
    private JLabel denumireLabel = new JLabel("Denumire :");
    private JTextField denumireText = new JTextField();
    private JLabel stocLabel = new JLabel("Stoc :");
    private JTextField stocText = new JTextField();
    private JLabel pretLabel = new JLabel("Pret :");
    private JTextField pretText = new JTextField();
    private JLabel caloriiLabel = new JLabel("Calorii :");
    private JTextField caloriiText = new JTextField();
    private JLabel tipProdusLabel = new JLabel("Tip produs :");
    private JLabel stilLabel = new JLabel("Stil :");
    private JTextField stilText = new JTextField();
    private JLabel tipDesertLabel = new JLabel("Tip  desert:");
    private JTextField tipDesertText = new JTextField();
    private JLabel tipBauturaLabel = new JLabel("Tip  bautura:");
    private JTextField tipBauturaText = new JTextField();
    private JCheckBox caldaCheckBox = new JCheckBox("Bautura calda?");
    private ImagineCard imagineProdus = new ImagineCard("images/default.png",250, 250);
    private JButton puneImagine = new JButton("Alege o imagine ");
    private JLabel descriereLabel = new JLabel("Descriere");
    private JTextArea descriereArea = new JTextArea();
    private JScrollPane descriereScroll = new JScrollPane(descriereArea);
    private JButton salveazaProdus = new JButton("Salveaza");
    private JButton modificaProdus = new JButton("Modifica");
    private JTextField tipProdusText = new JTextField();
    private JButton stergereProdus = new JButton("Stergere");
    private JButton backButton = new JButton("Back");
    private JButton cumparaButton = new JButton("Cumpara");
}
