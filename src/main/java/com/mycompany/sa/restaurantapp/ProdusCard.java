/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Sara
 */
public class ProdusCard extends JPanel{
    public ProdusCard(String denumire, double pret, String imagePath){
        setPreferredSize(new Dimension(270, 320));
        setMaximumSize(new Dimension(270, 320));
        setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2 )); 
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(0,0,0));
        
        imagineCard = new ImagineCard(imagePath, 180, 200 );
        imagineCard.setPreferredSize(new Dimension(180, 200));
        imagineCard.setMaximumSize(new Dimension(180, 200));
        imagineCard.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel denumireLabel = new JLabel(denumire);
        denumireLabel.setPreferredSize(new Dimension(270, 50));
        denumireLabel.setHorizontalAlignment(JLabel.CENTER);
        denumireLabel.setForeground(new Color(255, 114, 118));
        denumireLabel.setFont(new Font("Courier New", Font.BOLD, 16));
        denumireLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        denumireLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        /*
        JTextPane denumirePane = new JTextPane();
        denumirePane.setText(denumire);
        denumirePane.setEditable(false);
        denumirePane.setFocusable(false);
        denumirePane.setOpaque(false);
        denumirePane.setForeground(Color.WHITE);
        denumirePane.setFont(new Font("Courier New", Font.BOLD, 18));
        denumirePane.setBorder(null);
        denumirePane.setAlignmentX(Component.CENTER_ALIGNMENT);

        StyledDocument doc = denumirePane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        */
        
        
        pretLabel = new JLabel("Pret: " + pret + " RON");
        pretLabel.setHorizontalAlignment(JLabel.CENTER);
        pretLabel.setPreferredSize(new Dimension(270, 50));
        pretLabel.setForeground(new Color(255, 114, 118));
        pretLabel.setFont(new Font("Courier New", Font.BOLD, 16));
        pretLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        

        add(imagineCard);
        add(Box.createVerticalStrut(10));
        add(denumireLabel);
        add(pretLabel);
        
    }
    public String insertLineBreaks(String text, int maxLineLength) {
        StringBuilder sb = new StringBuilder("<html>");
        int count = 0;
        for (String word : text.split(" ")) {
            if (count + word.length() > maxLineLength) {
                sb.append("<br>");
                count = 0;
            }
            sb.append(word).append(" ");
            count += word.length() + 1;
        }
        sb.append("</html>");
        return sb.toString();
    }

    private ImagineCard imagineCard;
    private JLabel pretLabel;
    private JLabel ratingLabel;
}
