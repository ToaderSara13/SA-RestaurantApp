/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Sara
 */
public class Login extends JPanel{
    private SARestaurantApp sara ;
    
    private JLabel titlu = new JLabel("Welcome back!");
    private JPanel loginForm = new JPanel();
    private JPanel loginPanel = new JPanel();
    private JPanel imaginePanel = new JPanel();
    private JLabel email = new JLabel("Email : ");
    private JTextField emailText = new JTextField("adresa de email");
    private JLabel parola = new JLabel("Parola :");
    private JTextField parolaText = new JTextField("parola");
    private JButton loginButton = new JButton("Login");
    private JLabel signUp = new JLabel("Don't have an account?");
    private JButton signUpButton = new JButton("Sign up!");
    
    public Login(SARestaurantApp sara){
        this.sara = sara;
        initComponents();        
    }
    
    private void initComponents(){
        
        setLayout(null);
        
        FundalPanel fundal = null;
        try {
            fundal = new FundalPanel("images/REST.png");
        } catch (IOException ex) {
            System.out.println("Image not found!");
        } 
        fundal.setVisible(true);
        fundal.setBounds(0,0,1300,700);
        add(fundal);
        

        //loginForm.setBounds(150, 75,1000,500);
        loginForm.setPreferredSize(new Dimension(1000, 500));
        loginForm.setLayout(null);
        loginForm.setVisible(true);
        loginForm.setBackground(Color.BLUE);
        fundal.add(loginForm);
        
        
        loginPanel.setBounds(0, 0,500,500);
        loginPanel.setLayout(null);
        loginPanel.setVisible(true);
        loginPanel.setBackground(Color.BLACK);
        loginForm.add(loginPanel);
        
        
        FundalPanel imaginePanel  = null;
        try {
            imaginePanel = new FundalPanel("images/img.jpg");
        } catch (IOException ex) {
            System.out.println("Image not found!");
        } 
        imaginePanel.setBounds(500, 0,500,500);
        imaginePanel.setVisible(true);
        loginForm.add(imaginePanel);
        
        titlu.setBounds(60, 50, 400, 50);
        titlu.setVisible(true);
        titlu.setFont(new Font("Courier New", Font.BOLD, 50));
        titlu.setForeground(Color.WHITE);
        loginPanel.add(titlu);
        
        
        email.setBounds(60, 135, 240, 50);
        email.setVisible(true);
        email.setFont(new Font("Courier New", Font.BOLD, 35));
        email.setForeground(Color.WHITE);
        loginPanel.add(email);
        
        
        emailText.setBounds(260, 140, 220, 40 );
        emailText.setVisible(true);
        emailText.setFont(new Font("Courier New", Font.ITALIC, 20));
        emailText.setOpaque(false);
        emailText.setBorder(BorderFactory.createCompoundBorder(emailText.getBorder(), new EmptyBorder(5, 10, 5, 10)));
        emailText.addActionListener(goliretext(emailText));
        loginPanel.add(emailText);
        
        
        parola.setBounds(60, 215, 240, 50);
        parola.setVisible(true);
        parola.setFont(new Font("Courier New", Font.BOLD, 35));
        parola.setForeground(Color.WHITE);
        loginPanel.add(parola);
        
        
        parolaText.setBounds(260, 220, 220, 40 );
        parolaText.setFont(new Font("Courier New", Font.ITALIC, 20));
        parolaText.setVisible(true);
        parolaText.setOpaque(false);
        parolaText.setBorder(BorderFactory.createCompoundBorder(parolaText.getBorder(), new EmptyBorder(5, 10, 5, 10)));
        parolaText.addActionListener(goliretext(parolaText));
        loginPanel.add(parolaText);
        
        
        loginButton.setBounds(220, 300, 100, 50);
        loginButton.setFont(new Font("Arial", Font.ITALIC, 15));
        loginButton.setVisible(true);
        loginButton.addMouseListener(loginButtonClick());
        loginPanel.add(loginButton);
        
        
        signUp.setBounds(30, 400, 270, 50);
        signUp.setVisible(true);
        signUp.setFont(new Font("Courier New", Font.BOLD, 15));
        signUp.setForeground(Color.WHITE);
        
        loginPanel.add(signUp);
        
        
        signUpButton.setBounds(330, 400, 100, 50);
        signUpButton.setFont(new Font("Arial", Font.ITALIC, 15));
        signUpButton.setVisible(true);
        signUpButton.addMouseListener(signUpButtonClick());
        loginPanel.add(signUpButton);

        
    }
    private ActionListener goliretext(JTextField a){
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(a.getText().equals("parola")||a.getText().equals("adresa de email"))
                    a.setText("");
            }
        };
    }
    private void invalidCredentials(){
        emailText.setBorder(new LineBorder(Color.RED, 2));
        parolaText.setBorder(new LineBorder(Color.RED, 2));
        loginButton.setBounds(340, 300, 100, 50);
        JOptionPane.showMessageDialog(null,"Invalid email or password!","Login Error",JOptionPane.ERROR_MESSAGE);  
        emailText.setBorder(new LineBorder(Color.WHITE, 2));
        parolaText.setBorder(new LineBorder(Color.WHITE, 2));
    } 
    private MouseAdapter loginButtonClick(){  
        return new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                String email = emailText.getText();
                String password = parolaText.getText();
                try{  
                    Connection conn = DBConnect.getConnection();
                    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM test WHERE email=? AND parola=?");
                    stmt.setString(1, email);
                    stmt.setString(2, password);

                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        System.out.println("Login successful!");
                        sara.showPanel("meniuPrincipal");
                        
                    } else {
                        System.out.println("Invalid credentials.");
                        invalidCredentials();
                    }

                    }catch(SQLException ex){
                        ex.printStackTrace();
                    }   
            }
        };
    }
    private MouseAdapter signUpButtonClick(){
        return new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                sara.showPanel("signUp");
            }
        };
    }
}
