/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp;

import com.mycompany.sa.restaurantapp.clase_produse.Produs;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author Sara
 */
class MeniuPrincipal extends JPanel {
    private SARestaurantApp sara ;
    private JButton acasa = new JButton("Acasa");
    private JButton produse = new JButton("Produse");
    private JButton cont = new JButton("Cont");
    
    public MeniuPrincipal(SARestaurantApp sara) throws SQLException{
        this.sara = sara;
        initComponents();        
    }
    private void initComponents() throws SQLException{
        setLayout(null);
        
        baraOptiuni.setBackground(Color.DARK_GRAY);
        baraOptiuni.setBounds(0, 0, 1300, 50);
        baraOptiuni.setVisible(true);
        add(baraOptiuni);
        
        acasa.setVisible(true);
        acasa.setPreferredSize(new Dimension(100,50));
        
        produse.setVisible(true);
        produse.setPreferredSize(new Dimension(100,50));
        
        cont.setVisible(true);
        cont.setPreferredSize(new Dimension(100,50));
        
        baraOptiuni.add(acasa);
        baraOptiuni.add(produse);
        baraOptiuni.add(cont);
        
        produsePanel.setBounds(0,50,1300,700);
        produsePanel.setLayout(null);
        produsePanel.setBackground(Color.BLACK);
        produsePanel.setVisible(true);
        add(produsePanel);
        
        vizualizareProdusePanel.setBounds(275, 80, 1000, 575);
        vizualizareProdusePanel.setVisible(true);
        produsePanel.add(vizualizareProdusePanel);
        
        baraDeCautare.setBounds(1000, 20, 220, 30);
        baraDeCautare.setBackground(new Color(10,25,40));
        baraDeCautare.setForeground(Color.CYAN);
        baraDeCautare.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        baraDeCautare.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        baraDeCautare.setVisible(true);
        produsePanel.add(baraDeCautare);
        
        cautare.setBounds(1220, 20, 30, 30);
        cautare.setVisible(true);
        cautare.setOpaque(true);                     
        cautare.setContentAreaFilled(true);           
        cautare.setBorderPainted(false);
        cautare.setFocusPainted(false);
        cautare.setBackground(new Color(10,25,40));
        cautare.addMouseListener(cautareActiune());
        produsePanel.add(cautare);
        
        tipProdusLabel.setBounds(750, 20, 100, 30);                     
        tipProdusLabel.setVisible(true);
        tipProdusLabel.setForeground(new Color(102, 100, 204));
        tipProdusLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        produsePanel.add(tipProdusLabel);
        
        tipProdus.setBounds(820,20,150,30);
        tipProdus.setVisible(true);
        tipProdus.setFont(new Font("Segoe UI", Font.BOLD ,15));
        tipProdus.setBackground(new Color(30, 35, 60));
        tipProdus.setForeground(Color.WHITE);
        tipProdus.addActionListener(e -> {
            String selectedType = (String) tipProdus.getSelectedItem();
            String selectedPrice = (String) pretSortare.getSelectedItem();
            vizualizareProdusePanel.filtrareListaProduse(selectedType, selectedPrice, allProducts);
        });
        produsePanel.add(tipProdus);
        
        pretLabel.setBounds(470, 20, 100, 30);                     
        pretLabel.setVisible(true);
        pretLabel.setForeground(new Color(102, 100, 204));
        pretLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        produsePanel.add(pretLabel);
        
        pretSortare.setBounds(570,20,150,30);
        pretSortare.setVisible(true);
        pretSortare.setFont(new Font("Segoe UI", Font.BOLD ,15));
        pretSortare.setBackground(new Color(30, 35, 60));
        pretSortare.setForeground(Color.WHITE);
        
        produsePanel.add(pretSortare);
        pretSortare.addActionListener(e -> {
            String selectedType = (String) tipProdus.getSelectedItem();
            String selectedPrice = (String) pretSortare.getSelectedItem();
            vizualizareProdusePanel.filtrareListaProduse(selectedType, selectedPrice, allProducts);
        });
        
        filtrareMancarePanelButton.setVisible(true);
        filtrareMancarePanelButton.setBounds(20,50,200, 50);
        filtrareMancarePanelButton.addActionListener(e -> filterMancarePanelAnimation());
        produsePanel.add(filtrareMancarePanelButton);
        
        filtrareMancarePanel.setBackground(Color.DARK_GRAY);
        filtrareMancarePanel.setLayout(null);
        filtrareMancarePanel.setBounds(20, 100, 200, filtrarePanelHeight);
        produsePanel.add(filtrareMancarePanel);
        
        pretMinimMancareLabel.setBounds(5,0,190,35);
        pretMinimMancareLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        
        pretMinimMancareText.setBounds(5, 45 ,190,45);
        pretMinimMancareText.setBackground(new Color(10,25,40));
        pretMinimMancareText.setForeground(Color.CYAN);
        pretMinimMancareText.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        pretMinimMancareText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        pretMaximMancareLabel.setBounds(5, 100 ,190,35);
        pretMaximMancareLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        
        pretMaximMancareText.setBounds(5, 145 ,190,45);
        pretMaximMancareText.setBackground(new Color(10,25,40));
        pretMaximMancareText.setForeground(Color.CYAN);
        pretMaximMancareText.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        pretMaximMancareText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        checkBoxMancareItalian.setBounds(5, 200 ,190,40);
        checkBoxMancareItalian.setVisible(true);
        checkBoxMancareItalian.setOpaque(false);
        checkBoxMancareItalian.setForeground(Color.CYAN);
        checkBoxMancareItalian.setFont(new Font("Segoe UI", Font.ITALIC, 17));
        checkBoxMancareItalian.setHorizontalTextPosition(SwingConstants.LEFT);
        checkBoxMancareItalian.setOpaque(false);
        
        checkBoxMancareCoreean.setBounds(5, 250 ,190,40);
        checkBoxMancareCoreean.setVisible(true);
        checkBoxMancareCoreean.setOpaque(false);
        checkBoxMancareCoreean.setForeground(Color.CYAN);
        checkBoxMancareCoreean.setFont(new Font("Segoe UI", Font.ITALIC, 17));
        checkBoxMancareCoreean.setHorizontalTextPosition(SwingConstants.LEFT);
        checkBoxMancareCoreean.setOpaque(false);
        
        checkBoxMancareRomanesc.setBounds(5, 300 ,190,40);
        checkBoxMancareRomanesc.setVisible(true);
        checkBoxMancareRomanesc.setOpaque(false);
        checkBoxMancareRomanesc.setForeground(Color.CYAN);
        checkBoxMancareRomanesc.setFont(new Font("Segoe UI", Font.ITALIC, 17));
        checkBoxMancareRomanesc.setHorizontalTextPosition(SwingConstants.LEFT);
        checkBoxMancareRomanesc.setOpaque(false);
        
        filtrareMancare.setVisible(true);
        filtrareMancare.setBounds(5,360,190, 30);
        filtrareMancare.addActionListener(e -> {
            String minText = pretMinimMancareText.getText().trim();
            String maxText = pretMaximMancareText.getText().trim();
            boolean italian = checkBoxMancareItalian.isSelected();
            boolean coreean = checkBoxMancareCoreean.isSelected();
            boolean romanesc = checkBoxMancareRomanesc.isSelected();
            List<Produs> lista = new ArrayList<>();
            try {
                lista = Produs.getAllProducts();
            } catch (SQLException ex) {
                Logger.getLogger(MeniuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            vizualizareProdusePanel.filtrareMancare(lista,minText,maxText,italian,coreean,romanesc);
        });

        filtrareDesertPanelButton.setVisible(true);
        filtrareDesertPanelButton.setBounds(20,120,200, 50);
        filtrareDesertPanelButton.addActionListener(e -> filterDesertPanelAnimation());
        produsePanel.add(filtrareDesertPanelButton);
        
        filtrareDesertPanel.setBackground(Color.DARK_GRAY);
        filtrareDesertPanel.setLayout(null);
        filtrareDesertPanel.setBounds(20, 170, 200, filtrarePanelHeight);
        produsePanel.add(filtrareDesertPanel);
        
        pretMinimDesertLabel.setBounds(5,0,190,35);
        pretMinimDesertLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        
        pretMinimDesertText.setBounds(5, 45 ,190,45);
        pretMinimDesertText.setBackground(new Color(10,25,40));
        pretMinimDesertText.setForeground(Color.CYAN);
        pretMinimDesertText.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        pretMinimDesertText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        pretMaximDesertLabel.setBounds(5, 100 ,190,35);
        pretMaximDesertLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        
        pretMaximDesertText.setBounds(5, 145 ,190,45);
        pretMaximDesertText.setBackground(new Color(10,25,40));
        pretMaximDesertText.setForeground(Color.CYAN);
        pretMaximDesertText.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        pretMaximDesertText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        checkBoxPrajituri.setBounds(5, 200 ,190,40);
        checkBoxPrajituri.setVisible(true);
        checkBoxPrajituri.setOpaque(false);
        checkBoxPrajituri.setForeground(Color.CYAN);
        checkBoxPrajituri.setFont(new Font("Segoe UI", Font.ITALIC, 17));
        checkBoxPrajituri.setHorizontalTextPosition(SwingConstants.LEFT);
        checkBoxPrajituri.setOpaque(false);
        
        checkBoxBudinci.setBounds(5, 250 ,190,40);
        checkBoxBudinci.setVisible(true);
        checkBoxBudinci.setOpaque(false);
        checkBoxBudinci.setForeground(Color.CYAN);
        checkBoxBudinci.setFont(new Font("Segoe UI", Font.ITALIC, 17));
        checkBoxBudinci.setHorizontalTextPosition(SwingConstants.LEFT);
        checkBoxBudinci.setOpaque(false);
        
        checkBoxInghetata.setBounds(5, 300 ,190,40);
        checkBoxInghetata.setVisible(true);
        checkBoxInghetata.setOpaque(false);
        checkBoxInghetata.setForeground(Color.CYAN);
        checkBoxInghetata.setFont(new Font("Segoe UI", Font.ITALIC, 17));
        checkBoxInghetata.setHorizontalTextPosition(SwingConstants.LEFT);
        checkBoxInghetata.setOpaque(false);
        
        filtrareDesert.setVisible(true);
        filtrareDesert.setBounds(5,360,190, 30);
        filtrareDesert.addActionListener(e -> {
            String pretMin = pretMinimDesertText.getText();
            String pretMax = pretMaximDesertText.getText();

            boolean prajituri = checkBoxPrajituri.isSelected();
            boolean budinci = checkBoxBudinci.isSelected();
            boolean inghetata = checkBoxInghetata.isSelected();

            vizualizareProdusePanel.filtrareDesert(allProducts,pretMin,pretMax,prajituri,budinci,inghetata);
        });
        
        filtrareBauturaPanelButton.setVisible(true);
        filtrareBauturaPanelButton.setBounds(20,190,200, 50);
        filtrareBauturaPanelButton.addActionListener(e -> filterBauturaPanelAnimation());
        produsePanel.add(filtrareBauturaPanelButton);
        
        filtrareBauturaPanel.setBackground(Color.DARK_GRAY);
        filtrareBauturaPanel.setLayout(null);
        filtrareBauturaPanel.setBounds(20, 240, 200, filtrarePanelHeight);
        produsePanel.add(filtrareBauturaPanel);
        
        pretMinimBauturaLabel.setBounds(5,0,190,35);
        pretMinimBauturaLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        
        pretMinimBauturaText.setBounds(5, 45 ,190,45);
        pretMinimBauturaText.setBackground(new Color(10,25,40));
        pretMinimBauturaText.setForeground(Color.CYAN);
        pretMinimBauturaText.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        pretMinimBauturaText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        pretMaximBauturaLabel.setBounds(5, 100 ,190,35);
        pretMaximBauturaLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        
        pretMaximBauturaText.setBounds(5, 145 ,190,45);
        pretMaximBauturaText.setBackground(new Color(10,25,40));
        pretMaximBauturaText.setForeground(Color.CYAN);
        pretMaximBauturaText.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        pretMaximBauturaText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        checkBoxBauturi.setBounds(5, 200 ,190,40);
        checkBoxBauturi.setVisible(true);
        checkBoxBauturi.setOpaque(false);
        checkBoxBauturi.setForeground(Color.CYAN);
        checkBoxBauturi.setFont(new Font("Segoe UI", Font.ITALIC, 17));
        checkBoxBauturi.setHorizontalTextPosition(SwingConstants.LEFT);
        checkBoxBauturi.setOpaque(false);
        
        checkBoxCafea.setBounds(5, 250 ,190,40);
        checkBoxCafea.setVisible(true);
        checkBoxCafea.setOpaque(false);
        checkBoxCafea.setForeground(Color.CYAN);
        checkBoxCafea.setFont(new Font("Segoe UI", Font.ITALIC, 17));
        checkBoxCafea.setHorizontalTextPosition(SwingConstants.LEFT);
        checkBoxCafea.setOpaque(false);
        
        checkBoxFrappe.setBounds(5, 300 ,190,40);
        checkBoxFrappe.setVisible(true);
        checkBoxFrappe.setOpaque(false);
        checkBoxFrappe.setForeground(Color.CYAN);
        checkBoxFrappe.setFont(new Font("Segoe UI", Font.ITALIC, 17));
        checkBoxFrappe.setHorizontalTextPosition(SwingConstants.LEFT);
        checkBoxFrappe.setOpaque(false);
        
        filtrareBautura.setVisible(true);
        filtrareBautura.setBounds(5,360,190, 30);
        filtrareBautura.addActionListener(e -> {
            String pretMin = pretMinimBauturaText.getText();
            String pretMax = pretMaximBauturaText.getText();

            boolean bauturi = checkBoxBauturi.isSelected();
            boolean cafea = checkBoxCafea.isSelected();
            boolean frappe = checkBoxFrappe.isSelected();

            vizualizareProdusePanel.filtrareBautura(allProducts,pretMin,pretMax,bauturi,cafea,frappe);
        });

        filtrareMancarePanel.add(pretMinimMancareLabel);
        filtrareMancarePanel.add(pretMinimMancareText);
        filtrareMancarePanel.add(pretMaximMancareLabel);
        filtrareMancarePanel.add(pretMaximMancareText);
        filtrareMancarePanel.add(checkBoxMancareItalian);
        filtrareMancarePanel.add(checkBoxMancareCoreean);
        filtrareMancarePanel.add(checkBoxMancareRomanesc);
        filtrareMancarePanel.add(filtrareMancare);
        
        filtrareDesertPanel.add(pretMinimDesertLabel);
        filtrareDesertPanel.add(pretMinimDesertText);
        filtrareDesertPanel.add(pretMaximDesertLabel);
        filtrareDesertPanel.add(pretMaximDesertText);
        filtrareDesertPanel.add(checkBoxPrajituri);
        filtrareDesertPanel.add(checkBoxBudinci);
        filtrareDesertPanel.add(checkBoxInghetata);
        filtrareDesertPanel.add(filtrareDesert);
        
        filtrareBauturaPanel.add(pretMinimBauturaLabel);
        filtrareBauturaPanel.add(pretMinimBauturaText);
        filtrareBauturaPanel.add(pretMaximBauturaLabel);
        filtrareBauturaPanel.add(pretMaximBauturaText);
        filtrareBauturaPanel.add(checkBoxBauturi);
        filtrareBauturaPanel.add(checkBoxCafea);
        filtrareBauturaPanel.add(checkBoxFrappe);
        filtrareBauturaPanel.add(filtrareBautura);
        
        
        adaugaProdusPanelButton.setVisible(true);
        adaugaProdusPanelButton.setForeground(Color.CYAN);
        adaugaProdusPanelButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        adaugaProdusPanelButton.setBackground(new Color(10,60,40));
        adaugaProdusPanelButton.setOpaque(true);
        adaugaProdusPanelButton.setContentAreaFilled(true);           
        adaugaProdusPanelButton.setBorderPainted(false);
        adaugaProdusPanelButton.setFocusPainted(false);
        adaugaProdusPanelButton.setBounds(20, 500, 180, 50);
        adaugaProdusPanelButton.addMouseListener(adaugaProdusPaneAction(adaugaProdusPanelButton));
        produsePanel.add(adaugaProdusPanelButton);
        
        
        adaugaProdusPanel.setBounds(275, 80, 1000, 575);
        adaugaProdusPanel.setVisible(false);
        produsePanel.add(adaugaProdusPanel);
        
        
        
        
    }
    private boolean adaugaProdusPanelClicked = false;
    private MouseAdapter adaugaProdusPaneAction(JButton a){
        return new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                adaugaProdusPanelClicked = !adaugaProdusPanelClicked;
                if(adaugaProdusPanelClicked){
                    vizualizareProdusePanel.setVisible(false);
                    adaugaProdusPanel.setVisible(true);
                    a.setBackground(new Color(100,25,40));
                    a.setText("Cancel");
                }else{
                    adaugaProdusPanel.setVisible(false);
                    vizualizareProdusePanel.setVisible(true);
                    a.setBackground(new Color(10,60,40));
                    a.setText("Adauga produs");
                }
            }
        };
    }
    
    
    private boolean filtrareBauturaPanelOpen = false;
    private void filterBauturaPanelAnimation() {
        if (animationTimer != null && animationTimer.isRunning()) return;
        filtrareBauturaPanelOpen = !filtrareBauturaPanelOpen;
        animationTimer = new Timer(11, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int animationSpeed = 30;
                if (filtrareBauturaPanelOpen == true) {
                    filtrarePanelHeight += animationSpeed;
                    if(filtrarePanelHeight >= maxFiltrarePanel){
                        filtrarePanelHeight = maxFiltrarePanel;
                        animationTimer.stop();
                    }      
                }else{
                    filtrarePanelHeight -= animationSpeed;
                    if(filtrarePanelHeight <= 0){
                        filtrarePanelHeight = 0;
                        animationTimer.stop();
                    }
                }
                filtrareBauturaPanel.setBounds(20, 240, 200, filtrarePanelHeight);
                filtrareBauturaPanel.revalidate();
                filtrareBauturaPanel.repaint();
            }
        });
        animationTimer.start();
    }
    
    private boolean filtrareDesertPanelOpen = false;
    private void filterDesertPanelAnimation() {
        if (animationTimer != null && animationTimer.isRunning()) return;
        filtrareDesertPanelOpen = !filtrareDesertPanelOpen;
        animationTimer = new Timer(11, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int animationSpeed = 30;
                if (filtrareDesertPanelOpen == true) {
                    filtrarePanelHeight += animationSpeed;
                    if(filtrarePanelHeight >= maxFiltrarePanel){
                        filtrarePanelHeight = maxFiltrarePanel;
                        animationTimer.stop();
                        filtrareBauturaPanelButton.setVisible(false);
                        pretMinimBauturaLabel.setVisible(false);
                        pretMinimBauturaText.setVisible(false);
                        pretMaximBauturaLabel.setVisible(false);
                        pretMaximBauturaText.setVisible(false);
                        checkBoxBauturi.setVisible(false);
                        checkBoxCafea.setVisible(false);
                        checkBoxFrappe.setVisible(false);
                    }      
                }else{
                    filtrarePanelHeight -= animationSpeed;
                    if(filtrarePanelHeight <= 0){
                        filtrarePanelHeight = 0;
                        animationTimer.stop();
                        filtrareBauturaPanelButton.setVisible(true);
                        pretMinimBauturaLabel.setVisible(true);
                        pretMinimBauturaText.setVisible(true);
                        pretMaximBauturaLabel.setVisible(true);
                        pretMaximBauturaText.setVisible(true);
                        checkBoxBauturi.setVisible(true);
                        checkBoxCafea.setVisible(true);
                        checkBoxFrappe.setVisible(true);                       
                    }
                }
                filtrareDesertPanel.setBounds(20, 170, 200, filtrarePanelHeight);
                filtrareDesertPanel.revalidate();
                filtrareDesertPanel.repaint();
            }
        });
        animationTimer.start();
    }
    
    private MouseAdapter cautareActiune(){  
        return new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                String searchString = baraDeCautare.getText();
                vizualizareProdusePanel.cautareProdus(searchString, allProducts);
            }
        };
    }
    
    private void filterMancarePanelAnimation() {
        if (animationTimer != null && animationTimer.isRunning()) return;
        filtrareMancarePanelOpen = !filtrareMancarePanelOpen;
        animationTimer = new Timer(11, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int animationSpeed = 30;
                if (filtrareMancarePanelOpen == true) {
                    filtrarePanelHeight += animationSpeed;
                    if(filtrarePanelHeight >= maxFiltrarePanel){
                        filtrarePanelHeight = maxFiltrarePanel;
                        animationTimer.stop();
                        filtrareDesertPanelButton.setVisible(false);
                        pretMinimDesertLabel.setVisible(false);
                        pretMinimDesertText.setVisible(false);
                        pretMaximDesertLabel.setVisible(false);
                        pretMaximDesertText.setVisible(false);
                        checkBoxPrajituri.setVisible(false);
                        checkBoxBudinci.setVisible(false);
                        checkBoxInghetata.setVisible(false);
                        
                        filtrareBauturaPanelButton.setVisible(false);
                        pretMinimBauturaLabel.setVisible(false);
                        pretMinimBauturaText.setVisible(false);
                        pretMaximBauturaLabel.setVisible(false);
                        pretMaximBauturaText.setVisible(false);
                        checkBoxBauturi.setVisible(false);
                        checkBoxCafea.setVisible(false);
                        checkBoxFrappe.setVisible(false);
                        
                    }      
                }else{
                    filtrarePanelHeight -= animationSpeed;
                    if(filtrarePanelHeight <= 0){
                        filtrarePanelHeight = 0;
                        animationTimer.stop();
                        filtrareDesertPanelButton.setVisible(true);
                        pretMinimDesertLabel.setVisible(true);
                        pretMinimDesertText.setVisible(true);
                        pretMaximDesertLabel.setVisible(true);
                        pretMaximDesertText.setVisible(true);
                        checkBoxPrajituri.setVisible(true);
                        checkBoxBudinci.setVisible(true);
                        checkBoxInghetata.setVisible(true);
                        if(filtrareDesertPanelOpen){
                            filtrareBauturaPanelButton.setVisible(false);
                            pretMinimBauturaLabel.setVisible(false);
                            pretMinimBauturaText.setVisible(false);
                            pretMaximBauturaLabel.setVisible(false);
                            pretMaximBauturaText.setVisible(false);
                            checkBoxBauturi.setVisible(false);
                            checkBoxCafea.setVisible(false);
                            checkBoxFrappe.setVisible(false);
                        }else{
                            filtrareBauturaPanelButton.setVisible(true);
                            pretMinimBauturaLabel.setVisible(true);
                            pretMinimBauturaText.setVisible(true);
                            pretMaximBauturaLabel.setVisible(true);
                            pretMaximBauturaText.setVisible(true);
                            checkBoxBauturi.setVisible(true);
                            checkBoxCafea.setVisible(true);
                            checkBoxFrappe.setVisible(true);
                        }
                    }
                }
                filtrareMancarePanel.setBounds(20, 100, 200, filtrarePanelHeight);
                filtrareMancarePanel.revalidate();
                filtrareMancarePanel.repaint();
            }
        });
        animationTimer.start();
    }
    
    private JPanel baraOptiuni = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    private JPanel filtrareMancarePanel = new JPanel();
    private Timer animationTimer;
    private int filtrarePanelHeight = 0;
    private boolean filtrareMancarePanelOpen = false;
    private final int maxFiltrarePanel = 400;
    private JPanel produsePanel = new JPanel();
    private List<Produs> allProducts = Produs.getAllProducts();
    private ProduseList vizualizareProdusePanel = new ProduseList(allProducts);
    private JTextField baraDeCautare = new JTextField("Search");
    private ImagineButon cautare = new ImagineButon("images/search.png",30, 30);
    private JLabel tipProdusLabel = new JLabel("Tip: ");
    String[] tipProdusString = { "All", "Mancare", "Desert", "Bautura" };
    private JComboBox<String> tipProdus = new JComboBox<>(tipProdusString);
    private JLabel pretLabel = new JLabel("Pret: ");
    private JLabel pretMinimMancareLabel = new JLabel("  Pret minim :");
    String[] sortareString = { "None", "Crescator", "Descrescator"};
    private JComboBox<String> pretSortare = new JComboBox<>(sortareString);
    private JButton filtrareMancarePanelButton = new JButton("Filtrare mancare");
    private JTextField pretMinimMancareText = new JTextField();
    private JLabel pretMaximMancareLabel = new JLabel("  Pret maxim :");
    private JTextField pretMaximMancareText = new JTextField();
    private JCheckBox checkBoxMancareItalian = new JCheckBox("Stil italian");
    private JCheckBox checkBoxMancareCoreean = new JCheckBox("Stil coreean");
    private JCheckBox checkBoxMancareRomanesc = new JCheckBox("Stil romanesc");
    private JButton filtrareMancare = new JButton("Aplica filtre");
    private JButton filtrareDesertPanelButton = new JButton("Filtrare deserturi");
    private JLabel pretMinimDesertLabel = new JLabel("  Pret minim :");
    private JTextField pretMinimDesertText = new JTextField();
    private JLabel pretMaximDesertLabel = new JLabel("  Pret maxim :");
    private JTextField pretMaximDesertText = new JTextField();
    private JCheckBox checkBoxPrajituri = new JCheckBox("Prajituri");
    private JCheckBox checkBoxBudinci = new JCheckBox("Budinci");
    private JCheckBox checkBoxInghetata = new JCheckBox("Inghetata");
    private JButton filtrareDesert = new JButton("Aplica filtre");
    private JPanel filtrareDesertPanel = new JPanel();
    private JButton filtrareBauturaPanelButton = new JButton("Filtrare bauturi");
    private JLabel pretMinimBauturaLabel = new JLabel("  Pret minim :");
    private JTextField pretMinimBauturaText = new JTextField();
    private JLabel pretMaximBauturaLabel = new JLabel("  Pret maxim :");
    private JTextField pretMaximBauturaText = new JTextField();
    private JCheckBox checkBoxBauturi = new JCheckBox("Bauturi");
    private JCheckBox checkBoxCafea = new JCheckBox("Cafele");
    private JCheckBox checkBoxFrappe = new JCheckBox("Frappe-uri");
    private JButton filtrareBautura = new JButton("Aplica filtre");
    private JPanel filtrareBauturaPanel = new JPanel();
    private AdaugaProdusPanel adaugaProdusPanel = new AdaugaProdusPanel();
    private JButton adaugaProdusPanelButton = new JButton("Adauga produs");
}
