/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Sara
 */
public class OverlayPanel extends JPanel {
    private final Color overlayColor;

    public OverlayPanel(Color overlayColor) {
        this.overlayColor = overlayColor;
        setOpaque(false); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(overlayColor);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
    
}
