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
        
        ImagineCard imagine = new ImagineCard("images/imagine_acasa.jpg", 500, 500);
        imagine.setBounds(100, 100, 500, 500);
        imagine.setVisible(true);
        add(imagine);
        
        JTextArea descriereArea = new JTextArea("descriere");
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
