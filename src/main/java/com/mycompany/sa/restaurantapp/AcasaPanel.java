/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author Sara
 */
public class AcasaPanel extends JPanel{
    
    public AcasaPanel(){
        initComponents();
    }
    
    private void initComponents(){
        
        setLayout(null);
        setBackground(new Color(10, 15, 20));
        
        ImagineCard imagine = new ImagineCard("images/pagAcs.png", 500, 500);
        imagine.setBounds(100, 100, 500, 500);
        imagine.setVisible(true);
        add(imagine);
        
        JTextArea descriereArea = new JTextArea("Bine ai venit la SA-Restaurant – locul unde gustul întâlnește rafinamentul.\n" +
"\n" +
"Aici, fiecare preparat este mai mult decât o simplă rețetă – este o poveste, o experiență și o promisiune de calitate. Fie că îți dorești o porție de paste inspirate din bucătăria italiană, o friptură suculentă gătită cu grijă sau un desert fin care să-ți încheie ziua perfect, ai ajuns în locul potrivit.\n" +
"\n" +
"Interfața noastră modernă îți oferă acces rapid la un meniu variat, organizat clar și intuitiv. Poți filtra produsele după preferințe, stil culinar sau preț, astfel încât să găsești mereu ceea ce ți se potrivește.\n" +
"\n" +
"Aplicația SA-Restaurant este creată special pentru a oferi o experiență digitală plăcută, eficientă și adaptată nevoilor tale. Fie că ești client obișnuit sau administrator, fiecare secțiune este gândită să fie clară, ușor de folosit și estetică.\n" +
"\n" +
"În spatele fiecărui click se află muncă, pasiune și dorința de a transforma o simplă aplicație într-un partener de încredere atunci când vine vorba de alegerea mesei perfecte.\n" +
"\n" +
"Bucură-te de rafinament, simplitate și gust. Bine ai venit în familia SA-Restaurant.");
        descriereArea.setBackground(new Color(10,15,20));
        descriereArea.setForeground(Color.WHITE);
        descriereArea.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        descriereArea.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        descriereArea.setVisible(true);
        descriereArea.setLineWrap(true);
        descriereArea.setWrapStyleWord(true);
        descriereArea.setEditable(false);
        
        JScrollPane descriereScroll = new JScrollPane(descriereArea);
        descriereScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        descriereScroll.getVerticalScrollBar().setUnitIncrement(16);
        descriereScroll.setBorder(null);
        descriereScroll.setVisible(true);
        descriereScroll.setBounds(700, 100, 400, 500);
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
        
    }
}
