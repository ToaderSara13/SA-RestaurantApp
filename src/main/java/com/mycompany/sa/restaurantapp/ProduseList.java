/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp;

import com.mycompany.sa.restaurantapp.clase_produse.Bautura;
import com.mycompany.sa.restaurantapp.clase_produse.Desert;
import com.mycompany.sa.restaurantapp.clase_produse.Mancare;
import com.mycompany.sa.restaurantapp.clase_produse.Produs;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Sara
 */
public class ProduseList extends JPanel{
        
    private List<Produs> listaFiltrata = new ArrayList<>();
    
    
    
    public void filtrareBautura(List<Produs> allProducts,String pretMinText,String pretMaxText,boolean filterBauturi,boolean filterCafele,boolean filterFrappe) {
        productsContainer.removeAll();

        double pretMin = 0;
        double pretMax = Double.MAX_VALUE;

        try {
            if (!pretMinText.trim().isEmpty()) {
                pretMin = Double.parseDouble(pretMinText.trim());
            }
            if (!pretMaxText.trim().isEmpty()) {
                pretMax = Double.parseDouble(pretMaxText.trim());
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Prețurile introduse nu sunt valide.", "Eroare", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean useTipFilter = filterBauturi || filterCafele || filterFrappe;

        for (Produs p : allProducts) {
            if (p instanceof Bautura) {
                Bautura b = (Bautura) p;
                double pret = b.getPret();
                String tip = b.getTip().toLowerCase();

                if (pret >= pretMin && pret <= pretMax) {
                    if (!useTipFilter || 
                        (filterBauturi && tip.equals("bautura")) ||
                        (filterCafele && tip.equals("cafea")) ||
                        (filterFrappe && tip.equals("frappe"))) {

                        ProdusCard card = new ProdusCard(b.getDenumire(),b.getPret(),b.getImagine());
                        card.addMouseListener(isClicked(p));
                        productsContainer.add(card);
                    }
                }
            }
        }

        productsContainer.revalidate();
        productsContainer.repaint();
    }

    
    public void filtrareDesert(List<Produs> allProducts,String pretMinText,String pretMaxText,boolean filterPrajituri,boolean filterBudinci,boolean filterInghetata) {
        productsContainer.removeAll();

        double pretMin = 0;
        double pretMax = Double.MAX_VALUE;

        try {
            if (!pretMinText.trim().isEmpty()) {
                pretMin = Double.parseDouble(pretMinText.trim());
            }
            if (!pretMaxText.trim().isEmpty()) {
                pretMax = Double.parseDouble(pretMaxText.trim());
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Prețurile introduse nu sunt valide.", "Eroare", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean useTypeFilter = filterPrajituri || filterBudinci || filterInghetata;

        for (Produs p : allProducts) {
            if (p instanceof Desert) {
                Desert d = (Desert) p;
                double pret = d.getPret();
                String tip = d.getTip().toLowerCase();

                if (pret >= pretMin && pret <= pretMax) {
                    if (!useTypeFilter || 
                        (filterPrajituri && tip.equals("prajituri")) ||
                        (filterBudinci && tip.equals("budinci")) ||
                        (filterInghetata && tip.equals("inghetata"))) {

                        ProdusCard card = new ProdusCard(d.getDenumire(),d.getPret(),d.getImagine());
                        card.addMouseListener(isClicked(p));
                        productsContainer.add(card);
                    }
                }
            }
        }

        productsContainer.revalidate();
        productsContainer.repaint();
    }

    
    
    public void filtrareMancare(List<Produs> allProducts,String pretMinText,String pretMaxText,boolean filterItalian,boolean filterCoreean,boolean filterRomanesc) {
        productsContainer.removeAll();

        double pretMin = 0;
        double pretMax = Double.MAX_VALUE;

        try {
            if (!pretMinText.isEmpty()) {
                pretMin = Double.parseDouble(pretMinText);
            }
            if (!pretMaxText.isEmpty()) {
                pretMax = Double.parseDouble(pretMaxText);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Prețurile introduse nu sunt valide.", "Eroare", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean useStyleFilter = filterItalian || filterCoreean || filterRomanesc;

        for (Produs p : allProducts) {
            if (p instanceof Mancare) {
                Mancare m = (Mancare) p;
                double pret = m.getPret();
                String stil = m.getStil().toLowerCase();
                if(pretMin == 0 && pretMax == Double.MAX_VALUE){
                    if (pret >= pretMin && pret <= pretMax) {
                        if (!useStyleFilter || 
                            (filterItalian && stil.equals("italian")) ||
                            (filterCoreean && stil.equals("coreean")) ||
                            (filterRomanesc && stil.equals("romanesc"))) {

                            ProdusCard card = new ProdusCard(m.getDenumire(),m.getPret(),m.getImagine());
                            card.addMouseListener(isClicked(p));
                            productsContainer.add(card);
                        }
                    }
                }
            }
        }

        productsContainer.revalidate();
        productsContainer.repaint();
    }


    
    
    public void filtrarePret(double minPrice, double maxPrice, float minRating, float maxRating, List<Produs> list){
        
        productsContainer.removeAll();
        
        if(minPrice == 0 && maxPrice == 0 && minRating == 0 && maxRating == 0){
            for (Produs p : list) {
                ProdusCard card = new ProdusCard(p.getDenumire(),p.getPret(),p.getImagine());
                card.addMouseListener(isClicked(p));
                productsContainer.add(card);
            }
            productsContainer.revalidate();
            productsContainer.repaint();
            return;
            
        } 
    for (Produs p : list) {
        double price = p.getPret();
        boolean matches = true;
        
        if (minPrice > 0 && price < minPrice) {
            matches = false;
        }
        
        if (maxPrice > 0 && price > maxPrice) {
            matches = false;
        }
        if (matches == true) {
            ProdusCard card = new ProdusCard(p.getDenumire(),p.getPret(),p.getImagine());
            card.addMouseListener(isClicked(p));
            productsContainer.add(card);
        }
    }

        productsContainer.revalidate();
        productsContainer.repaint();
    }
    public void cautareProdus(String searchString, List<Produs> productList) {
        productsContainer.removeAll();

        String searchLower = searchString.toLowerCase();

        for (Produs p : productList) {
            if (p.getDenumire().toLowerCase().contains(searchLower)) {
                ProdusCard card = new ProdusCard(p.getDenumire(),p.getPret(),p.getImagine());
                card.addMouseListener(isClicked(p));
                productsContainer.add(card);
            }
        }
        if (searchString.equalsIgnoreCase("Search")) {
            for (Produs p : productList) {
                ProdusCard card = new ProdusCard(p.getDenumire(),p.getPret(),p.getImagine());
                card.addMouseListener(isClicked(p));
                productsContainer.add(card);
            }
        }

        productsContainer.revalidate();
        productsContainer.repaint();
    }

    
    
    public void filtrareListaProduse(String type, String price, List<Produs> productList) {
        productsContainer.removeAll();  

        List<Produs> filteredList = new ArrayList<>();

        for (Produs p : productList) {
            if (type.equals("All")) {
                filteredList.add(p);
            } else if (type.equals("Mancare") && p instanceof Mancare) {
                filteredList.add(p);
            } else if (type.equals("Desert") && p instanceof Desert) {
                filteredList.add(p);
            } else if (type.equals("Bautura") && p instanceof Bautura) {
                filteredList.add(p);
            }
        }
        if (price.equals("Crescator")) {
            filteredList.sort(Comparator.comparingDouble(Produs::getPret));
        } else if (price.equals("Descrescator")) {
            filteredList.sort(Comparator.comparingDouble(Produs::getPret).reversed());
        }

        for (Produs p : filteredList) {
            ProdusCard card = new ProdusCard(p.getDenumire(),p.getPret(),p.getImagine());
            card.addMouseListener(isClicked(p));
            productsContainer.add(card);
        }

        productsContainer.revalidate();
        productsContainer.repaint();

        listaFiltrata.clear();           
        listaFiltrata.addAll(filteredList);
    }

    private MouseAdapter isClicked(Produs p){
        return new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                remove(vizualizareProdus); 
                vizualizareProdus = new VizualizareProdus(p, ProduseList.this, scrollPane); 
                vizualizareProdus.setBounds(0, 0, 970, 600); 
                
                vizualizareProdus.stergereModificareBackBuyTrue();
                vizualizareProdus.setVisible(true);
                add(vizualizareProdus); 
                scrollPane.setVisible(false);

                revalidate();
                repaint();
                
            }
        };
    }
    
    public void scrollPaneTrue(){
        scrollPane.setVisible(true);
        revalidate();
        repaint();
    }
    
    
    
    public ProduseList (List<Produs> produseList){
        setLayout(new BorderLayout());
        
        productsContainer.setLayout(new WrapLayout(FlowLayout.LEFT, 30, 20)); 
        productsContainer.setBackground(new Color(20,20,20));

        for (Produs p : produseList) { 
            ProdusCard card = new ProdusCard(p.getDenumire(), p.getPret(), p.getImagine());
            card.addMouseListener(isClicked(p));
            productsContainer.add(card);
            
        }

        scrollPane = new JScrollPane(productsContainer);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBackground(Color.BLACK);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);
    }
    private JPanel productsContainer = new JPanel();
    private  JScrollPane scrollPane;
    private VizualizareProdus vizualizareProdus = new VizualizareProdus();
}
