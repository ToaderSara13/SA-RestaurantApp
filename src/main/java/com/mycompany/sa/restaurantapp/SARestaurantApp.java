/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sa.restaurantapp;

import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Sara
 */
public class SARestaurantApp extends JFrame{
    private CardLayout customLayout = new CardLayout();
    private JPanel customPanel;
    
    public SARestaurantApp() throws SQLException{
    initComponents();
    }
     public void showPanel(String name) {
        customLayout.show(customPanel, name);
    }
    private void initComponents() throws SQLException{
        
        setTitle("SA-RestaurantApp");
        setSize(1300, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(customLayout);
        
        
        customPanel = new JPanel(customLayout);
        Login login = new Login(this);
        SignUp signUp = new SignUp(this);
        MeniuPrincipal meniuPrincipal = new MeniuPrincipal(this);
        customPanel.add(login, "login");
        customPanel.add(signUp, "signUp");
        customPanel.add(meniuPrincipal, "meniuPrincipal");
        add(customPanel);
        
        customLayout.show(customPanel, "login");
    }
    
    public static void main(String[] args) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SARestaurantApp().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(SARestaurantApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
