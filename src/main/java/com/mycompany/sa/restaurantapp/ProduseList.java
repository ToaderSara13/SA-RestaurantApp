/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp;

import com.mycompany.sa.restaurantapp.clase_produse.Produs;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Sara
 */
public class ProduseList extends JPanel{
        
    public ProduseList (List<Produs> produseList){
        setLayout(new BorderLayout());
        JPanel productsContainer = new JPanel();
        productsContainer.setLayout(new GridLayout(0, 3, 3, 3)); 
        productsContainer.setBackground(new Color(20,20,20));

        for (Produs p : produseList) { 
            ProdusCard card = new ProdusCard(p.getDenumire(), p.getPret(), p.getImagine());
            productsContainer.add(card);
        }

        JScrollPane scrollPane = new JScrollPane(productsContainer);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBackground(Color.BLACK);
        add(scrollPane, BorderLayout.CENTER);
    }
}
