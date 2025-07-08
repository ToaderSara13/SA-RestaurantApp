/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp;

import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Sara
 */
public class ImagineCard extends JLabel{
    public ImagineCard (String imagePath, int width, int height){
        URL imgURL = getClass().getResource("/" + imagePath);
        System.out.println(imagePath);
        if (imgURL != null) {
            
            ImageIcon icon = new ImageIcon(imgURL);
            Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(scaledImage));
        } else {
            setText("Image not found");
            setForeground(Color.RED);
        }
        
    }
}
