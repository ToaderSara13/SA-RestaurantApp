/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Sara
 */
public class FundalPanel extends JPanel{
    private BufferedImage image;
    
    public FundalPanel(String imagePath) throws IOException{
        InputStream stream = getClass().getClassLoader().getResourceAsStream(imagePath);
        if (stream == null) throw new FileNotFoundException("Image not found: " + imagePath);
            image = ImageIO.read(stream);
        setLayout(new GridBagLayout());
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if (image != null) {
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        Image scaled = image.getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH);
        g.drawImage(scaled, 0, 0, this);
    }
}
}
