/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Sara
 */
public class ImagineCard extends JLabel{
    private int width ;
    private int height;
    public ImagineCard (String imagePath, int width, int height){
        URL imgURL = getClass().getResource("/" + imagePath);
        if (imgURL != null) {
            
            ImageIcon icon = new ImageIcon(imgURL);
            Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(scaledImage));
        } else {
            setText("Image not found");
            setForeground(Color.RED);
        }
        
    }
    
    public void loadPreviewFromFile(File imageFile, int width, int height) {
        try {
            if (imageFile != null && imageFile.exists()) {
                BufferedImage img = ImageIO.read(imageFile);
                Image scaled = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                setIcon(new ImageIcon(scaled));
                setText(null);
                setForeground(Color.BLACK);
                revalidate();
                repaint();
            } else {
                throw new IOException("Preview file doesn't exist: " + imageFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
            setText("Preview failed");
            setForeground(Color.RED);
        }
    }
}
