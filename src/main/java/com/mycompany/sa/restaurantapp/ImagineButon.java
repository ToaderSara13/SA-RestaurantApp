/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Sara
 */
public class ImagineButon extends JButton{
    
    private int width;
    private int height;
    
     public ImagineButon(String ImagePath, int width, int height){
        
        URL iconUrl = getClass().getClassLoader().getResource(ImagePath);
        this.width = width;
        this.height= height;
        if (iconUrl != null) {
            ImageIcon originalIcon = new ImageIcon(iconUrl);
            Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(scaledImage));
        }
    }
     public void imagineNoua(String imagine, int width, int height){
         URL iconUrl = getClass().getClassLoader().getResource(imagine);
        this.width = width;
        this.height= height;
        if (iconUrl != null) {
            ImageIcon originalIcon = new ImageIcon(iconUrl);
            Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(scaledImage));
        }
     }
}
