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
public class SignUp extends JPanel{
    private SARestaurantApp sara ;
    
    JLabel titlu = new JLabel("Welcome to SA-Restaurant");
    JPanel signUpForm = new JPanel();
    JPanel signUpPanel = new JPanel();
    JPanel imaginePanel = new JPanel();
    JLabel email = new JLabel("Email : ");
    JTextField emailText = new JTextField("adresa de email");
    JLabel parola = new JLabel("Parola :");
    JTextField parolaText = new JTextField("parola");
    JButton signUpButton = new JButton("Register");
    
    public SignUp(SARestaurantApp sara){
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
        

        signUpForm.setPreferredSize(new Dimension(1000, 500));
        signUpForm.setLayout(null);
        signUpForm.setVisible(true);
        fundal.add(signUpForm);
        
        
        signUpPanel.setBounds(500, 0,500,500);
        signUpPanel.setLayout(null);
        signUpPanel.setVisible(true);
        signUpPanel.setBackground(Color.BLACK);
        signUpForm.add(signUpPanel);
        
        
        FundalPanel imaginePanel  = null;
        try {
            imaginePanel = new FundalPanel("images/img.jpg");
        } catch (IOException ex) {
            System.out.println("Image not found!");
        } 
        imaginePanel.setBounds(0, 0,500,500);
        imaginePanel.setVisible(true);
        signUpForm.add(imaginePanel);
        
        
        titlu.setBounds(60, 50, 400, 50);
        titlu.setVisible(true);
        titlu.setFont(new Font("Courier New", Font.BOLD, 50));
        titlu.setForeground(Color.WHITE);
        signUpPanel.add(titlu);
        
        
        email.setBounds(60, 135, 240, 50);
        email.setVisible(true);
        email.setFont(new Font("Courier New", Font.BOLD, 35));
        email.setForeground(Color.WHITE);
        signUpPanel.add(email);
        
        
        emailText.setBounds(260, 140, 220, 40 );
        emailText.setVisible(true);
        emailText.setFont(new Font("Courier New", Font.ITALIC, 20));
        emailText.setOpaque(false);
        emailText.setBorder(BorderFactory.createCompoundBorder(emailText.getBorder(), new EmptyBorder(5, 10, 5, 10)));
        emailText.addActionListener(goliretext(emailText));
        signUpPanel.add(emailText);
        
        
        parola.setBounds(60, 215, 240, 50);
        parola.setVisible(true);
        parola.setFont(new Font("Courier New", Font.BOLD, 35));
        parola.setForeground(Color.WHITE);
        signUpPanel.add(parola);
        
        
        parolaText.setBounds(260, 220, 220, 40 );
        parolaText.setFont(new Font("Courier New", Font.ITALIC, 20));
        parolaText.setVisible(true);
        parolaText.setOpaque(false);
        parolaText.setBorder(BorderFactory.createCompoundBorder(parolaText.getBorder(), new EmptyBorder(5, 10, 5, 10)));
        parolaText.addActionListener(goliretext(parolaText));
        signUpPanel.add(parolaText);
        
        

        
        
        signUpButton.setBounds(330, 400, 100, 50);
        signUpButton.setFont(new Font("Arial", Font.ITALIC, 15));
        signUpButton.setVisible(true);
        signUpButton.addMouseListener(signUpButtonClick());
        signUpPanel.add(signUpButton);
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
    private MouseAdapter signUpButtonClick(){
        return new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                String email = emailText.getText();
                String parola = parolaText.getText();
                if(emailText.getText().equals("") || parolaText.getText().equals("")){
                    emailText.setBorder(new LineBorder(Color.RED, 2));
                    parolaText.setBorder(new LineBorder(Color.RED, 2));
                }
                else {
                    try{  
                        emailText.setBorder(new LineBorder(Color.WHITE, 2));
                        parolaText.setBorder(new LineBorder(Color.WHITE, 2));
                        Connection conn = DBConnect.getConnection();
                        PreparedStatement stmt = conn.prepareStatement("INSERT INTO test (email, parola) VALUES (?, ?)");
                        stmt.setString(1, email);
                        stmt.setString(2, parola);
                        int rowsInserted = stmt.executeUpdate();
                        if (rowsInserted > 0) {
                            System.out.println("Successful creation of account !");
                            JOptionPane.showMessageDialog(null,"Successful registration!","Well done",JOptionPane.INFORMATION_MESSAGE);
                            sara.showPanel("meniuPrincipal");
                        }
                        }catch(SQLException ex){
                            JOptionPane.showMessageDialog(null,"Error! Account already in use!","Account error",JOptionPane.ERROR_MESSAGE);
                        }        
                }
            }
        };
    }
}
