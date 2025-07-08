/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp;

import com.mycompany.sa.restaurantapp.clase_produse.Produs;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

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
        
        
        
        JPanel baraOptiuni = new JPanel(new FlowLayout(FlowLayout.RIGHT));
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
        
        JPanel produsePanel = new JPanel();
        produsePanel.setBounds(0,50,1300,650);
        produsePanel.setLayout(null);
        produsePanel.setBackground(Color.BLACK);
        produsePanel.setVisible(true);
        add(produsePanel);
        
        List<Produs> allProducts = Produs.getAllProducts();
        ProduseList vizualizareProdusePanel = new ProduseList(allProducts);
        vizualizareProdusePanel.setBounds(200, 100, 900, 500);
        vizualizareProdusePanel.setVisible(true);
        produsePanel.add(vizualizareProdusePanel);
        
        
        
        
        

        
    }
}
