/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp;

import com.mycompany.sa.restaurantapp.clase_produse.Utilizator;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Sara
 */
public class Login extends JPanel{
    private SARestaurantApp sara ;
    
    private JLabel titlu = new JLabel("Login");
    private JPanel loginForm = new JPanel();
    private JPanel loginPanel = new JPanel();
    private JPanel imaginePanel = new JPanel();
    private JLabel email = new JLabel("Email : ");
    private JTextField emailText = new JTextField("adresa de email");
    private JLabel parola = new JLabel("Parola :");
    private JButton toggleParolaButton = new JButton("👁");
    private JPasswordField parolaText = new JPasswordField("parola");
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
            fundal = new FundalPanel("images/Poza_fundal.jpg");
        } catch (IOException ex) {
            System.out.println("Image not found!");
        } 
        fundal.setVisible(true);
        fundal.setBounds(0,0,1300,750);
        add(fundal);
        
        JLabel logoLabel = new JLabel();
        logoLabel.setBounds(20, 20, 120, 120); // poziție și dimensiune (poți modifica)
        try {
                ImageIcon icon = new ImageIcon(getClass().getResource("/images/logo.png"));
                Image image = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH); // redimensionare
                logoLabel.setIcon(new ImageIcon(image));
            } catch (Exception e) {
        System.out.println("Logo not found!");
    }
        loginPanel.add(logoLabel); 

         // 🔥 Adăugăm overlay pentru întunecare
        OverlayPanel overlay = new OverlayPanel(new Color(0, 0, 0, 180)); // alpha 120 = semi-transparent
        overlay.setBounds(0, 0, 1300, 700);
        fundal.add(overlay);

        JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
        separator.setBounds(495, 0, 2, 500);
        loginForm.add(separator);

        //loginForm.setBounds(150, 75,1000,500);
        loginForm.setPreferredSize(new Dimension(1000, 500));
        loginForm.setLayout(null);
        loginForm.setOpaque(false);
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
            imaginePanel = new FundalPanel("images/poza.jpg");
        } catch (IOException ex) {
            System.out.println("Image not found!");
        } 
        imaginePanel.setBounds(500, 0,500,500);
        imaginePanel.setVisible(true);
        loginForm.add(imaginePanel);
        
        titlu.setBounds(200, 80, 400, 50);
        titlu.setVisible(true);
        titlu.setFont(new Font("Georgia", Font.BOLD, 45));
        titlu.setForeground(Color.WHITE);
        loginPanel.add(titlu);
        
        
        email.setBounds(60, 180, 240, 50);
        email.setVisible(true);
        email.setFont(new Font("Segoe UI", Font.BOLD, 30));
        email.setForeground(Color.WHITE);
        loginPanel.add(email);

        
        
        emailText.setBounds(210, 185, 220, 40 );
        emailText.setVisible(true);
        emailText.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        emailText.setOpaque(false);
        emailText.setBackground(new Color(205, 255, 255, 30));
        emailText.setForeground(Color.WHITE);
        emailText.setBorder(BorderFactory.createCompoundBorder(emailText.getBorder(), new EmptyBorder(5, 10, 5, 10)));
        emailText.addActionListener(goliretext(emailText));;
        loginPanel.add(emailText);
        
        ///
        
        emailText.addFocusListener(new FocusAdapter() {
    @Override
    public void focusGained(FocusEvent e) {
        if (emailText.getText().equals("adresa de email")) {
            emailText.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (emailText.getText().isEmpty()) {
            emailText.setText("adresa de email");
        }
    }
});
        ///
        
        parola.setBounds(60, 250, 240, 40);
        parola.setVisible(true);
        parola.setFont(new Font("Segoe UI", Font.BOLD, 30));
        parola.setForeground(Color.WHITE);
        loginPanel.add(parola);
        
        
        parolaText.setBounds(210, 255, 220, 40 );
        parolaText.setFont(new Font("Segoe UI",  Font.PLAIN, 18));
        parolaText.setVisible(true);
        parolaText.setOpaque(false);
        parolaText.setBackground(new Color(255, 255, 255, 30));
        parolaText.setForeground(Color.WHITE);
        parolaText.setBorder(BorderFactory.createCompoundBorder(parolaText.getBorder(), new EmptyBorder(5, 10, 5, 10)));
        parolaText.addActionListener(goliretext(parolaText));
        loginPanel.add(parolaText);
        
        toggleParolaButton.setBounds(435, 255, 35, 35);
        toggleParolaButton.setFocusPainted(false);
        toggleParolaButton.setContentAreaFilled(false);
        toggleParolaButton.setBorderPainted(false);
        toggleParolaButton.setForeground(Color.WHITE);
        toggleParolaButton.addActionListener(e -> {
             if (parolaText.getEchoChar() == (char) 0) {
          parolaText.setEchoChar('●');
             } else {
          parolaText.setEchoChar((char) 0);
        }
    });
        loginPanel.add(toggleParolaButton);

        
     
        parolaText.addFocusListener(new FocusAdapter() {
    @Override
    public void focusGained(FocusEvent e) {
        if (String.valueOf(parolaText.getPassword()).equals("parola")) {
            parolaText.setText("");
            parolaText.setEchoChar('●'); 
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (String.valueOf(parolaText.getPassword()).isEmpty()) {
            parolaText.setText("parola");
            parolaText.setEchoChar((char) 0); 
          }
        }
    });

        loginButton.setBounds(180, 320, 140, 45);
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(70, 130, 180));
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        loginButton.addMouseListener(loginButtonClick());
        loginButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            loginButton.setBackground(new Color(65, 105, 225));
        }
        @Override
        public void mouseExited(MouseEvent e) {
            loginButton.setBackground(new Color(70, 130, 180));
        }
    });
    loginPanel.add(loginButton);
        
        
     
        signUp.setBounds(80, 390, 200, 30);
        signUp.setFont(new Font("SansSerif", Font.BOLD, 14));
        signUp.setForeground(new Color(200, 200, 200));
        loginPanel.add(signUp);


        signUpButton.setBounds(270, 385, 120, 35);
        signUpButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBackground(new Color(100, 149, 237));
        signUpButton.setFocusPainted(false);
        signUpButton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        signUpButton.addMouseListener(signUpButtonClick());
        signUpButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            signUpButton.setBackground(new Color(65, 105, 225));
        }
        @Override
        public void mouseExited(MouseEvent e) {
            signUpButton.setBackground(new Color(100, 149, 237));
        }
    });

        loginPanel.add(signUpButton);


        /*signUp.setBounds(30, 400, 270, 50);
        signUp.setVisible(true);
        signUp.setFont(new Font("Courier New", Font.BOLD, 15));
        signUp.setForeground(Color.WHITE);
        
        loginPanel.add(signUp);
        
        
        signUpButton.setBounds(330, 400, 100, 50);
        signUpButton.setFont(new Font("Arial", Font.ITALIC, 15));
        signUpButton.setVisible(true);
        signUpButton.addMouseListener(signUpButtonClick());
        loginPanel.add(signUpButton);
*/
        
    
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
                String password = String.valueOf(parolaText.getPassword());

                try{  
                    Connection conn = DBConnect.getConnection();
                    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM utilizator WHERE email=? AND parola=?");
                    stmt.setString(1, email);
                    stmt.setString(2, password);

                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        System.out.println("Login successful!");
                        int id = rs.getInt("id");
                        String em = rs.getString("email");
                        String psw = rs.getString("parola");
                        String rol = rs.getString("rol");
                        Sesiune.login(new Utilizator(id, em, psw, rol));
                        sara.showPanel("meniuPrincipal");
                        MeniuPrincipal meniuPrincipal = (MeniuPrincipal) sara.getMeniuPrincipal();
                        meniuPrincipal.incarcareUtilizator();
                        meniuPrincipal.acasaPanelVizibil();
                        
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
