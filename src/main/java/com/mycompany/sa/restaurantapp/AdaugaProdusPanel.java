/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
 * @author Sara
 */
public class AdaugaProdusPanel extends JPanel{
    
    public AdaugaProdusPanel(){
        initComponents();
    }
    
    private void initComponents(){
        
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        
        
        denumireLabel.setVisible(true);
        denumireLabel.setBounds(20, 20, 200, 50);
        denumireLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        denumireLabel.setForeground(new Color(102, 100, 204));
        add(denumireLabel);
        
        
        denumireText.setBounds(225, 20, 230, 50);
        denumireText.setBackground(new Color(10,25,40));
        denumireText.setForeground(Color.CYAN);
        denumireText.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        denumireText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        denumireText.setVisible(true);
        denumireText.addFocusListener(golireText(denumireText));
        add(denumireText);
        
        
        stocLabel.setVisible(true);
        stocLabel.setBounds(20, 90, 200, 50);
        stocLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        stocLabel.setForeground(new Color(102, 100, 204));
        add(stocLabel);
        
        
        stocText.setBounds(225, 90, 230, 50);
        stocText.setBackground(new Color(10,25,40));
        stocText.setForeground(Color.CYAN);
        stocText.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        stocText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        stocText.setVisible(true);
        stocText.addFocusListener(golireText(stocText));
        add(stocText);
        
        
        pretLabel.setVisible(true);
        pretLabel.setBounds(20, 160, 200, 50);
        pretLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        pretLabel.setForeground(new Color(102, 100, 204));
        add(pretLabel);
        
        
        pretText.setBounds(225, 160, 230, 50);
        pretText.setBackground(new Color(10,25,40));
        pretText.setForeground(Color.CYAN);
        pretText.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        pretText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        pretText.setVisible(true);
        pretText.addFocusListener(golireText(pretText));
        add(pretText);
        
        
        caloriiLabel.setVisible(true);
        caloriiLabel.setBounds(20, 230, 200, 50);
        caloriiLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        caloriiLabel.setForeground(new Color(102, 100, 204));
        add(caloriiLabel);
        
        
        caloriiText.setBounds(225, 230, 230, 50);
        caloriiText.setBackground(new Color(10,25,40));
        caloriiText.setForeground(Color.CYAN);
        caloriiText.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        caloriiText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        caloriiText.setVisible(true);
        caloriiText.addFocusListener(golireText(caloriiText));
        add(caloriiText);
        
        
        tipProdusLabel.setVisible(true);
        tipProdusLabel.setBounds(20, 300, 200, 50);
        tipProdusLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        tipProdusLabel.setForeground(new Color(102, 100, 204));
        add(tipProdusLabel);
        
        
        tipCombo.setBounds(225, 300, 230, 50);
        tipCombo.setVisible(true);
        tipCombo.setFont(new Font("Segoe UI", Font.ITALIC ,20));
        tipCombo.setBackground(new Color(10,25,40));
        tipCombo.setForeground(Color.CYAN);
        tipCombo.addActionListener(tipComboBox());
        add(tipCombo);
        
        
        stilLabel.setVisible(false);
        stilLabel.setBounds(20, 370, 200, 50);
        stilLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        stilLabel.setForeground(new Color(102, 100, 204));
        add(stilLabel);
        
        
        stilText.setBounds(225, 370, 230, 50);
        stilText.setBackground(new Color(10,25,40));
        stilText.setForeground(Color.CYAN);
        stilText.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        stilText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        stilText.setVisible(false);
        stilText.addFocusListener(golireText(stilText));
        add(stilText);
        
        
        tipDesertLabel.setVisible(false);
        tipDesertLabel.setBounds(20, 370, 200, 50);
        tipDesertLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        tipDesertLabel.setForeground(new Color(102, 100, 204));
        add(tipDesertLabel);
        
        
        tipDesertText.setBounds(225, 370, 230, 50);
        tipDesertText.setBackground(new Color(10,25,40));
        tipDesertText.setForeground(Color.CYAN);
        tipDesertText.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        tipDesertText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        tipDesertText.setVisible(false);
        tipDesertText.addFocusListener(golireText(tipDesertText));
        add(tipDesertText);
        
        
        tipBauturaLabel.setVisible(false);
        tipBauturaLabel.setBounds(20, 370, 200, 50);
        tipBauturaLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        tipBauturaLabel.setForeground(new Color(102, 100, 204));
        add(tipBauturaLabel);
        
        
        tipBauturaText.setBounds(225, 370, 230, 50);
        tipBauturaText.setBackground(new Color(10,25,40));
        tipBauturaText.setForeground(Color.CYAN);
        tipBauturaText.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        tipBauturaText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        tipBauturaText.setVisible(false);
        tipBauturaText.addFocusListener(golireText(tipBauturaText));
        add(tipBauturaText);
        
        
        caldaCheckBox.setBounds(20, 440, 250, 50);
        caldaCheckBox.setVisible(false);
        caldaCheckBox.setOpaque(false);
        caldaCheckBox.setForeground(Color.CYAN);
        caldaCheckBox.setFont(new Font("Segoe UI", Font.ITALIC, 25));
        caldaCheckBox.setHorizontalTextPosition(SwingConstants.LEFT);
        caldaCheckBox.setOpaque(false);
        add(caldaCheckBox);
        
        
        imagineProdus.setBounds(700, 20, 250, 250);
        imagineProdus.setVisible(true);
        imagineProdus.setBorder(new LineBorder(Color.RED, 1));
        add(imagineProdus);
        
        
        puneImagine.setVisible(true);
        puneImagine.setForeground(Color.CYAN);
        puneImagine.setFont(new Font("Arial", Font.BOLD, 15));
        puneImagine.setBackground(new Color(10,25,40));
        puneImagine.setOpaque(true);
        puneImagine.setContentAreaFilled(true);           
        puneImagine.setBorderPainted(false);
        puneImagine.setFocusPainted(false);
        puneImagine.setBounds(475, 120, 180, 50);
        puneImagine.addMouseListener(selectProductImageAction());
        add(puneImagine);
        
        
        descriereLabel.setVisible(true);
        descriereLabel.setBounds(490, 290, 200, 50);
        descriereLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        descriereLabel.setForeground(new Color(102, 100, 204));
        add(descriereLabel);
        
        
        descriereArea.setBackground(new Color(10,25,40));
        descriereArea.setForeground(Color.WHITE);
        descriereArea.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        descriereArea.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        descriereArea.setVisible(true);
        descriereArea.setLineWrap(true);
        descriereArea.setWrapStyleWord(true);
        descriereArea.addFocusListener(golireArea(descriereArea));
        
        
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
        
        
        salveazaProdus.setVisible(true);
        salveazaProdus.setForeground(Color.WHITE);
        salveazaProdus.setFont(new Font("Arial", Font.BOLD, 15));
        salveazaProdus.setBackground(new Color(10,60,40));
        salveazaProdus.setOpaque(true);
        salveazaProdus.setContentAreaFilled(true);           
        salveazaProdus.setBorderPainted(false);
        salveazaProdus.setFocusPainted(false);
        salveazaProdus.setBounds(740, 500, 180, 50);
        salveazaProdus.addMouseListener(salveazaProdusAction());
        add(salveazaProdus);
        
        cancelProdus.setVisible(true);
        cancelProdus.setForeground(Color.WHITE);
        cancelProdus.setFont(new Font("Arial", Font.BOLD, 15));
        cancelProdus.setBackground(new Color(80,25,40));
        cancelProdus.setOpaque(true);
        cancelProdus.setContentAreaFilled(true);           
        cancelProdus.setBorderPainted(false);
        cancelProdus.setFocusPainted(false);
        cancelProdus.setBounds(550, 500, 180, 50);
        cancelProdus.addMouseListener(cancelAction());
        add(cancelProdus);
        
    }
private MouseAdapter salveazaProdusAction() {
    return new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            String denumire = denumireText.getText().trim();
            String stocStr = stocText.getText().trim();
            String pretStr = pretText.getText().trim();
            String caloriiStr = caloriiText.getText().trim();
            String descriere = descriereArea.getText().trim();
            String tipSelectat = (String) tipCombo.getSelectedItem();

            if (denumire.isEmpty() || stocStr.isEmpty() || pretStr.isEmpty() || caloriiStr.isEmpty() || tipSelectat == null || descriere.isEmpty()) {
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
                String insertSQL = "INSERT INTO produs (denumire, calorii, stoc, pret, imagine, descriere, tipprodus) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement produsStmt = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
                produsStmt.setString(1, denumire);
                produsStmt.setInt(2, calorii);
                produsStmt.setInt(3, stoc);
                produsStmt.setDouble(4, pret);
                produsStmt.setString(5, imagePathInProject);
                produsStmt.setString(6, descriere);
                produsStmt.setString(7, tipSelectat);
                produsStmt.executeUpdate();

                ResultSet rs = produsStmt.getGeneratedKeys();
                if (rs.next()) {
                    int produsId = rs.getInt(1);

                    switch (tipSelectat.toLowerCase()) {
                        case "mancare":
                            String stil = stilText.getText().trim().toLowerCase();
                            if (stil.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Completează câmpul STIL pentru mancare.", "Eroare", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            PreparedStatement mancareStmt = conn.prepareStatement("INSERT INTO mancare (id, stil) VALUES (?, ?)");
                            mancareStmt.setInt(1, produsId);
                            mancareStmt.setString(2, stil);
                            mancareStmt.executeUpdate();
                            break;

                        case "desert":
                            String tipDesert = tipDesertText.getText().trim().toLowerCase();
                            if (tipDesert.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Completează câmpul TIP pentru desert.", "Eroare", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            PreparedStatement desertStmt = conn.prepareStatement("INSERT INTO desert (id, tip) VALUES (?, ?)");
                            desertStmt.setInt(1, produsId);
                            desertStmt.setString(2, tipDesert);
                            desertStmt.executeUpdate();
                            break;

                        case "bautura":
                            String tipBautura = tipBauturaText.getText().trim().toLowerCase();
                            boolean calda = caldaCheckBox.isSelected();
                            if (tipBautura.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Completează câmpul TIP pentru băutură.", "Eroare", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            PreparedStatement bauturaStmt = conn.prepareStatement("INSERT INTO bautura (id, tip, calda) VALUES (?, ?, ?)");
                            bauturaStmt.setInt(1, produsId);
                            bauturaStmt.setString(2, tipBautura);
                            bauturaStmt.setBoolean(3, calda);
                            bauturaStmt.executeUpdate();
                            break;
                    }

                    JOptionPane.showMessageDialog(null, "Produs adăugat cu succes!", "Succes", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Eroare la baza de date!", "Eroare", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
}


private MouseAdapter cancelAction() {
    return new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            denumireText.setText("Denumire");
            stocText.setText("Stoc");
            pretText.setText("Pret");
            caloriiText.setText("Calorii");
            stilText.setText("Stil");
            tipDesertText.setText("Tip desert");
            tipBauturaText.setText("tip Bautura");
            descriereArea.setText("Descriere");
            if (tipCombo.getItemCount() > 0) {
                tipCombo.setSelectedIndex(0);
            }
            imagineSelectata = null;
            imagineProdus = new ImagineCard("images/default.png",250, 250);
            
            caldaCheckBox.setSelected(false);
            stilLabel.setVisible(false);
            stilText.setVisible(false);
            tipDesertLabel.setVisible(false);
            tipDesertText.setVisible(false);
            tipBauturaLabel.setVisible(false);
            tipBauturaText.setVisible(false);
            caldaCheckBox.setVisible(false);
            revalidate();
            repaint();
        }
    };
}

    private FocusListener golireArea(JTextArea a){
        return new FocusListener(){
            String string;
        @Override
        public void focusGained(FocusEvent e) {
                if (a.getText().equalsIgnoreCase("Description")) { 
                    string = a.getText();
                    a.setText("");
                }
            
        }
            @Override
            public void focusLost(FocusEvent e) {
                if (a.getText().trim().isEmpty()) {
                    a.setText(string);
                }
            }
        };
    } 
    
    private FocusListener golireText(JTextField a){
        return new FocusListener(){
            String string;
        @Override
        public void focusGained(FocusEvent e) {
            for (String camp : campuri) {
                if (camp.equalsIgnoreCase(a.getText())) { 
                    camp = a.getText();
                    a.setText("");
                }
            }
        }
            @Override
            public void focusLost(FocusEvent e) {
                if (a.getText().trim().isEmpty()) {
                    a.setText(string);
                }
            }
    };
    } 
    private MouseAdapter selectProductImageAction() {
        return new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            FileDialog fileDialog = new FileDialog((Frame) SwingUtilities.getWindowAncestor(AdaugaProdusPanel.this), "Select Product Image", FileDialog.LOAD);
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
    
        private ActionListener tipComboBox() {
    return new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            String tip = (String) tipCombo.getSelectedItem();
            if(tip.equals("None")){
                
                stilLabel.setVisible(false);
                stilText.setVisible(false);
                
                tipDesertLabel.setVisible(false);
                tipDesertText.setVisible(false);
                
                tipBauturaLabel.setVisible(false);
                tipBauturaText.setVisible(false);
                caldaCheckBox.setVisible(false);
                
            }else if(tip.equals("Desert")){
                
                stilLabel.setVisible(false);
                stilText.setVisible(false);
                
                tipDesertLabel.setVisible(true);
                tipDesertText.setVisible(true);
                
                tipBauturaLabel.setVisible(false);
                tipBauturaText.setVisible(false);
                caldaCheckBox.setVisible(false);
                
            }else if(tip.equals("Mancare")) {
                
                stilLabel.setVisible(true);
                stilText.setVisible(true);
                
                tipDesertLabel.setVisible(false);
                tipDesertText.setVisible(false);
                
                tipBauturaLabel.setVisible(false);
                tipBauturaText.setVisible(false);
                caldaCheckBox.setVisible(false);
            }else{
                stilLabel.setVisible(false);
                stilText.setVisible(false);
                
                tipDesertLabel.setVisible(false);
                tipDesertText.setVisible(false);
                
                tipBauturaLabel.setVisible(true);
                tipBauturaText.setVisible(true);
                caldaCheckBox.setVisible(true);
            }
        }
    };
    }
    private JLabel denumireLabel = new JLabel("Denumire :");
    private JTextField denumireText = new JTextField("Denumire");
    private JLabel stocLabel = new JLabel("Stoc :");
    private JTextField stocText = new JTextField("Stoc");
    private JLabel pretLabel = new JLabel("Pret :");
    private JTextField pretText = new JTextField("Pret");
    private JLabel caloriiLabel = new JLabel("Calorii :");
    private JTextField caloriiText = new JTextField("Calorii");
    private JLabel tipProdusLabel = new JLabel("Tip produs :");
    String[] tipString = {"None", "Mancare", "Desert", "Bautura" };
    private JComboBox<String> tipCombo = new JComboBox<>(tipString);
    private JLabel stilLabel = new JLabel("Stil :");
    private JTextField stilText = new JTextField("Calorii");
    private JLabel tipDesertLabel = new JLabel("Tip  desert:");
    private JTextField tipDesertText = new JTextField("Tip desert");
    private JLabel tipBauturaLabel = new JLabel("Tip  bautura:");
    private JTextField tipBauturaText = new JTextField("Tip bautura");
    private JCheckBox caldaCheckBox = new JCheckBox("Bautura calda?");
    private ImagineCard imagineProdus = new ImagineCard("images/default.png",250, 250);
    private File imagineSelectata;
    private JButton puneImagine = new JButton("Alege o imagine ");
    private JLabel descriereLabel = new JLabel("Descriere");
    private JTextArea descriereArea = new JTextArea("Descriere");
    private JScrollPane descriereScroll = new JScrollPane(descriereArea);
    private JButton salveazaProdus = new JButton("Salveaza");
    private JButton cancelProdus = new JButton("Cancel");
    String[] campuri = {"Denumire","Stoc","Pret","Calorii","Stil","tip Bautura","Descriere"};
}
