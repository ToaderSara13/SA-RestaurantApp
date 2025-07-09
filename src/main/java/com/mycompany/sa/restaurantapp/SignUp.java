package com.mycompany.sa.restaurantapp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class SignUp extends JPanel {
    private SARestaurantApp sara;

    JLabel titlu1 = new JLabel("Welcome to");
    JLabel titlu2 = new JLabel("SA-Restaurant");
    JPanel signUpForm = new JPanel();
    JPanel signUpPanel = new JPanel();
    JLabel email = new JLabel("Email : ");
    JTextField emailText = new JTextField("adresa de email");
    JLabel parola = new JLabel("Parola :");
    JPasswordField parolaText = new JPasswordField("parola");
    JButton toggleParolaButton = new JButton("👁");
    JLabel confirmaParola = new JLabel("Confirmare :");
    JPasswordField confirmaParolaText = new JPasswordField("confirmare");
    JButton toggleConfirmareButton = new JButton("👁");
    JButton signUpButton = new JButton("Register");
    JButton backButton = new JButton("Back to Login");

    public SignUp(SARestaurantApp sara) {
        this.sara = sara;
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        FundalPanel fundal = null;
        try {
            fundal = new FundalPanel("images/REST.png");
        } catch (IOException ex) {
            System.out.println("Image not found!");
        }
        if (fundal != null) {
            fundal.setBounds(0, 0, 1300, 700);
            add(fundal);

            signUpForm.setPreferredSize(new Dimension(1000, 500));
            signUpForm.setLayout(null);
            fundal.add(signUpForm);

            signUpPanel.setBounds(500, 0, 500, 500);
            signUpPanel.setLayout(null);
            signUpPanel.setBackground(Color.BLACK);
            signUpForm.add(signUpPanel);

            titlu1.setBounds(120, 30, 400, 40);
            titlu1.setFont(new Font("Georgia", Font.BOLD, 38));
            titlu1.setForeground(Color.WHITE);
            signUpPanel.add(titlu1);

            titlu2.setBounds(90, 70, 400, 40);
            titlu2.setFont(new Font("Georgia", Font.BOLD, 38));
            titlu2.setForeground(Color.WHITE);
            signUpPanel.add(titlu2);

            email.setBounds(60, 150, 240, 40);
            email.setFont(new Font("Segoe UI", Font.BOLD, 25));
            email.setForeground(Color.WHITE);
            signUpPanel.add(email);

            emailText.setBounds(260, 150, 200, 35);
            emailText.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            emailText.setOpaque(false);
            emailText.setBackground(new Color(205, 255, 255, 30));
            emailText.setForeground(Color.WHITE);
            emailText.setBorder(BorderFactory.createCompoundBorder(emailText.getBorder(), new EmptyBorder(5, 10, 5, 10)));
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
            signUpPanel.add(emailText);

            parola.setBounds(60, 210, 240, 40);
            parola.setFont(new Font("Segoe UI", Font.BOLD, 25));
            parola.setForeground(Color.WHITE);
            signUpPanel.add(parola);

            parolaText.setBounds(260, 210, 160, 35);
            parolaText.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            parolaText.setOpaque(false);
            parolaText.setBackground(new Color(255, 255, 255, 30));
            parolaText.setForeground(Color.WHITE);
            parolaText.setEchoChar((char) 0);
            parolaText.setBorder(BorderFactory.createCompoundBorder(parolaText.getBorder(), new EmptyBorder(5, 10, 5, 10)));
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
            signUpPanel.add(parolaText);

            toggleParolaButton.setBounds(425, 210, 35, 35);
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
            signUpPanel.add(toggleParolaButton);

            confirmaParola.setBounds(60, 270, 240, 40);
            confirmaParola.setFont(new Font("Segoe UI", Font.BOLD, 25));
            confirmaParola.setForeground(Color.WHITE);
            signUpPanel.add(confirmaParola);

            confirmaParolaText.setBounds(260, 270, 160, 35);
            confirmaParolaText.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            confirmaParolaText.setOpaque(false);
            confirmaParolaText.setBackground(new Color(255, 255, 255, 30));
            confirmaParolaText.setForeground(Color.WHITE);
            confirmaParolaText.setEchoChar((char) 0);
            confirmaParolaText.setBorder(BorderFactory.createCompoundBorder(confirmaParolaText.getBorder(), new EmptyBorder(5, 10, 5, 10)));
            confirmaParolaText.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (String.valueOf(confirmaParolaText.getPassword()).equals("confirmare")) {
                        confirmaParolaText.setText("");
                        confirmaParolaText.setEchoChar('●');
                    }
                }
                @Override
                public void focusLost(FocusEvent e) {
                    if (String.valueOf(confirmaParolaText.getPassword()).isEmpty()) {
                        confirmaParolaText.setText("confirmare");
                        confirmaParolaText.setEchoChar((char) 0);
                    }
                }
            });
            signUpPanel.add(confirmaParolaText);

            toggleConfirmareButton.setBounds(425, 270, 35, 35);
            toggleConfirmareButton.setFocusPainted(false);
            toggleConfirmareButton.setContentAreaFilled(false);
            toggleConfirmareButton.setBorderPainted(false);
            toggleConfirmareButton.setForeground(Color.WHITE);
            toggleConfirmareButton.addActionListener(e -> {
                if (confirmaParolaText.getEchoChar() == (char) 0) {
                    confirmaParolaText.setEchoChar('●');
                } else {
                    confirmaParolaText.setEchoChar((char) 0);
                }
            });
            signUpPanel.add(toggleConfirmareButton);

            signUpButton.setBounds(330, 400, 100, 40);
            signUpButton.setFont(new Font("Arial", Font.ITALIC, 15));
            signUpButton.addMouseListener(signUpButtonClick());
            signUpPanel.add(signUpButton);

            backButton.setBounds(60, 400, 150, 40);
            backButton.setFont(new Font("Arial", Font.PLAIN, 14));
            backButton.addActionListener(e -> sara.showPanel("login"));
            signUpPanel.add(backButton);
        }
    }

    private MouseAdapter signUpButtonClick() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String email = emailText.getText().trim();
                String parola = String.valueOf(parolaText.getPassword());
                String confirmare = String.valueOf(confirmaParolaText.getPassword());

                if (email.equals("adresa de email") || parola.equals("parola") || confirmare.equals("confirmare") ||
                    email.isEmpty() || parola.isEmpty() || confirmare.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Completează toate câmpurile!", "Câmpuri goale", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (!email.matches("^\\S+@\\S+\\.\\S+$")) {
                    JOptionPane.showMessageDialog(null, "Email invalid!", "Email", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (parola.length() < 6) {
                    JOptionPane.showMessageDialog(null, "Parola trebuie să aibă minim 6 caractere!", "Parolă slabă", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (!parola.equals(confirmare)) {
                    JOptionPane.showMessageDialog(null, "Parolele nu coincid!", "Confirmare parolă", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    Connection conn = DBConnect.getConnection();
                    PreparedStatement stmt = conn.prepareStatement("INSERT INTO test (email, parola) VALUES (?, ?)");
                    stmt.setString(1, email);
                    stmt.setString(2, parola);
                    int rowsInserted = stmt.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(null, "Înregistrare reușită!", "Succes", JOptionPane.INFORMATION_MESSAGE);
                        sara.showPanel("meniuPrincipal");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Email deja înregistrat!", "Eroare", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
    }
}
