/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp;

import com.mycompany.sa.restaurantapp.clase_produse.Utilizator;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Sara
 */
public class ContPanel extends JPanel{
     private SARestaurantApp sara ;
     
    public ContPanel(SARestaurantApp sara){
        this.sara = sara;
        initComponents();
    }
    
    private void initComponents(){
        setLayout(null);
        setBackground(new Color(10, 15, 20));
        
        
        emailLabel.setVisible(true);
        emailLabel.setBounds(50, 50, 200, 50);
        emailLabel.setFont(new Font("Courier New", Font.BOLD, 30));
        emailLabel.setForeground(new Color(102, 100, 204));
        add(emailLabel);
        
        
        emailText.setBounds(220, 50, 230, 50);
        emailText.setBackground(new Color(10,25,40));
        emailText.setForeground(Color.CYAN);
        emailText.setFont(new Font("Courier New", Font.ITALIC, 20));
        emailText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        emailText.setVisible(true);
        emailText.setEditable(false);
        add(emailText);
        
        
        parolaLabel.setVisible(true);
        parolaLabel.setBounds(50, 150, 200, 50);
        parolaLabel.setFont(new Font("Courier New", Font.BOLD, 30));
        parolaLabel.setForeground(new Color(102, 100, 204));
        add(parolaLabel);
        
        
        parolaText.setBounds(220, 150, 230, 50);
        parolaText.setBackground(new Color(10,25,40));
        parolaText.setForeground(Color.CYAN);
        parolaText.setFont(new Font("Courier New", Font.ITALIC, 20));
        parolaText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        parolaText.setVisible(true);
        parolaText.setEditable(false);
        add(parolaText);
        
        
        rolLabel.setVisible(true);
        rolLabel.setBounds(50, 250, 200, 50);
        rolLabel.setFont(new Font("Courier New", Font.BOLD, 30));
        rolLabel.setForeground(new Color(102, 100, 204));
        add(rolLabel);
        
        
        rolText.setBounds(220, 250, 230, 50);
        rolText.setBackground(new Color(10,25,40));
        rolText.setForeground(Color.CYAN);
        rolText.setFont(new Font("Courier New", Font.ITALIC, 20));
        rolText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        rolText.setVisible(true);
        rolText.setEditable(false);
        add(rolText);
        
        
        parolaVizibila.setVisible(true);
        parolaVizibila.setBounds(450, 165, 25, 25);
        parolaVizibila.setOpaque(false);                     
        parolaVizibila.setContentAreaFilled(false);           
        parolaVizibila.setBorderPainted(false);
        parolaVizibila.setFocusPainted(false);
        parolaVizibila.addMouseListener(showPasswordAction());
        add(parolaVizibila);

       
        schimbaDate.setVisible(true);
        schimbaDate.setForeground(Color.CYAN);
        schimbaDate.setFont(new Font("Arial", Font.BOLD, 15));
        schimbaDate.setBackground(new Color(10,25,40));
        schimbaDate.setOpaque(true);
        schimbaDate.setContentAreaFilled(true);           
        schimbaDate.setBorderPainted(false);
        schimbaDate.setFocusPainted(false);
        schimbaDate.setBounds(500, 50, 250, 50);
        schimbaDate.addMouseListener(changePersonalDataAction());
        add(schimbaDate);
        
        
        saveChanges.setVisible(false);
        saveChanges.setForeground(Color.CYAN);
        saveChanges.setFont(new Font("Arial", Font.BOLD, 15));
        saveChanges.setBackground(new Color(10,80,40));
        saveChanges.setOpaque(true);
        saveChanges.setContentAreaFilled(true);           
        saveChanges.setBorderPainted(false);
        saveChanges.setFocusPainted(false);
        saveChanges.setBounds(500, 120, 100, 50);
        saveChanges.addMouseListener(saveChangesAction());
        add(saveChanges);
        
        
        cancelChanges.setVisible(false);
        cancelChanges.setForeground(Color.CYAN);
        cancelChanges.setFont(new Font("Arial", Font.BOLD, 15));
        cancelChanges.setBackground(new Color(80,25,40));
        cancelChanges.setOpaque(true);
        cancelChanges.setContentAreaFilled(true);           
        cancelChanges.setBorderPainted(false);
        cancelChanges.setFocusPainted(false);
        cancelChanges.setBounds(650, 120, 100, 50);
        cancelChanges.addMouseListener(cancelAction());
        add(cancelChanges);
        
        
        logout.setVisible(true);
        logout.setForeground(Color.CYAN);
        logout.setFont(new Font("Arial", Font.BOLD, 20));
        logout.setBackground(new Color(80,25,40));
        logout.setOpaque(true);
        logout.setContentAreaFilled(true);           
        logout.setBorderPainted(false);
        logout.setFocusPainted(false);
        logout.setBounds(60, 450, 130, 50);
        logout.addMouseListener(logoutAction());
        add(logout);
        
        
        incarcareDate();
        
        userModel = new UtilizatorTableModel(utilizatorDataLinie);
        
        tabelaUtilizatori = new JTable(userModel);
        tabelaUtilizatori.setBackground(new Color(20,15,40));
        tabelaUtilizatori.setFont(new Font("Segoe UI", Font.PLAIN, 16)); 
        tabelaUtilizatori.setRowHeight(24);
        tabelaUtilizatori.setGridColor(new Color(50, 50, 70));
        
        JTableHeader header = tabelaUtilizatori.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 16));           
        header.setForeground(Color.YELLOW);                             
        header.setBackground(new Color(60, 60, 120));
        
        //Columns width
        TableColumnModel columnModel = tabelaUtilizatori.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100); 
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(100);
        
        //Columns foreground 
        DefaultTableCellRenderer colorRenderer = new DefaultTableCellRenderer();
        colorRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        colorRenderer.setForeground(Color.CYAN);
        for (int i = 0; i < tabelaUtilizatori.getColumnCount(); i++) {
            tabelaUtilizatori.getColumnModel().getColumn(i).setCellRenderer(colorRenderer);
            columnModel.getColumn(i).setResizable(false);
        }
        tabelaUtilizatori.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        scrollTabela = new JScrollPane(tabelaUtilizatori);
        scrollTabela.getViewport().setBackground(new Color(20, 15, 40));
        scrollTabela.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollTabela.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollTabela.getVerticalScrollBar().setUnitIncrement(16);
        scrollTabela.setBorder(null);
        scrollTabela.setVisible(true);
        scrollTabela.setBounds(600, 300, 550, 250);
        scrollTabela.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(0,0,130);
            }
        });
        scrollTabela.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(80, 90, 130);      
                this.trackColor = new Color(30, 35, 60);        
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }
            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }
            private JButton createZeroButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                button.setVisible(false);
                return button;
            }
        });
        add(scrollTabela);
        
    }
        private MouseAdapter logoutAction(){
        return new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                sara.showPanel("login");
                setVisible(false);
                Sesiune.logout();
            }
        };
    }
        private MouseAdapter saveChangesAction(){
        return new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                
                String email = emailText.getText();
                String parola = parolaText.getText();
                
                if(email.toLowerCase().contains("@gmail.com") || email.toLowerCase().contains("@yahoo.com")){
                    emailText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                    if(!parolaConfirmataText.getText().equals(parola)){
                        parolaText.setBorder(new LineBorder(Color.RED, 1));
                        parolaConfirmataText.setBorder(new LineBorder(Color.RED, 1));
                        JOptionPane.showMessageDialog(null,"Error! Please enter the same password!","Account error",JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        try{  
                            Connection conn = DBConnect.getConnection();
                            PreparedStatement stmt = conn.prepareStatement("UPDATE utilizator SET email = ?, parola = ? WHERE id = ?");
                            stmt.setString(1, email);
                            stmt.setString(2, parola);
                            int id = Sesiune.getUtilizatorCurent().getUtilizatorId();
                            stmt.setInt(3, id);
                            String rol = Sesiune.getUtilizatorCurent().getRol();

                            int rowsUpdated = stmt.executeUpdate();
                            if (rowsUpdated > 0) {
                                System.out.println("Successful changing of data !");
                                parolaText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                                parolaConfirmataText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                                JOptionPane.showMessageDialog(null,"Account updated!","Well done",JOptionPane.INFORMATION_MESSAGE);
                                Utilizator utilizator = new Utilizator(id, email, parola, rol);
                                Sesiune.login(utilizator);
                            }
                            }catch(SQLException ex){
                                parolaText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                                parolaConfirmataText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                                JOptionPane.showMessageDialog(null,"Error! Account already in use!","Account error",JOptionPane.ERROR_MESSAGE);
                            }        
                        }
                }else{
                    emailText.setBorder(new LineBorder(Color.RED, 1));
                    JOptionPane.showMessageDialog(null,"Error! Invalid email credentials!","Account error",JOptionPane.ERROR_MESSAGE);
                }
                saveChanges.setVisible(false);
                cancelChanges.setVisible(false);
                rolText.setEditable(false);
                parolaText.setEditable(false);
                emailText.setEditable(false);
            }
        };
    }
    
    private MouseAdapter cancelAction(){
        return new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
              
                if(!emailText.getText().equals(Sesiune.getUtilizatorCurent().getEmail()))
                    emailText.setText(Sesiune.getUtilizatorCurent().getEmail());
                if(!parolaText.getText().equals(Sesiune.getUtilizatorCurent().getParola()))
                    parolaText.setText(Sesiune.getUtilizatorCurent().getParola());
                
                saveChanges.setVisible(false);
                cancelChanges.setVisible(false);
                parolaText.setEditable(false);
                emailText.setEditable(false);
                parolaConfirmataText.setVisible(false);
                parolaConfirmataLabel.setVisible(false);
                parolaConfirmataVizibila.setVisible(false);
                rolLabel.setBounds(50, 250, 200, 50);
                rolText.setBounds(220, 250, 230, 50);
                
            }
        };
    }
    
    
    private boolean passwordClicked = false;
    private MouseAdapter showPasswordAction(){
        return new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                passwordClicked = !passwordClicked;
                if(passwordClicked){
                   parolaText.setEchoChar((char) 0); 
                   parolaVizibila.imagineNoua("images/visibilityOn.png", 25, 25);
                }else{
                    parolaText.setEchoChar('*');
                    parolaVizibila.imagineNoua("images/visibilityOff.png", 25, 25);
                }
                
                
            }
        };
    }
    
    private MouseAdapter changePersonalDataAction(){
        return new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                saveChanges.setVisible(true);
                cancelChanges.setVisible(true);
                parolaText.setEditable(true);
                emailText.setEditable(true);
                
                parolaConfirmataLabel.setVisible(true);
                parolaConfirmataLabel.setBounds(50, 250, 200, 50);
                parolaConfirmataLabel.setFont(new Font("Courier New", Font.BOLD, 30));
                parolaConfirmataLabel.setForeground(new Color(102, 100, 204));
                add(parolaConfirmataLabel);
                
                parolaConfirmataText.setText(parolaText.getText());
                parolaConfirmataText.setBounds(220, 250, 230, 50);
                parolaConfirmataText.setBackground(new Color(10,25,40));
                parolaConfirmataText.setForeground(Color.CYAN);
                parolaConfirmataText.setFont(new Font("Courier New", Font.ITALIC, 20));
                parolaConfirmataText.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                parolaConfirmataText.setVisible(true);
                add(parolaConfirmataText);
                
                parolaConfirmataVizibila.setVisible(true);
                parolaConfirmataVizibila.setBounds(450, 265, 25, 25);
                parolaConfirmataVizibila.setOpaque(false);                     
                parolaConfirmataVizibila.setContentAreaFilled(false);           
                parolaConfirmataVizibila.setBorderPainted(false);
                parolaConfirmataVizibila.setFocusPainted(false);
                parolaConfirmataVizibila.addMouseListener(showConfirmedPasswordAction());
                add(parolaConfirmataVizibila);
                
                rolLabel.setBounds(50, 350, 200, 50);
                rolText.setBounds(220, 350, 230, 50);
                
            }
        };
    }
    
    private boolean confirmPasswordClicked = false;
    private MouseAdapter showConfirmedPasswordAction(){
        return new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                confirmPasswordClicked = !confirmPasswordClicked;
                if(confirmPasswordClicked){
                   parolaConfirmataText.setEchoChar((char) 0); 
                   parolaConfirmataVizibila.imagineNoua("images/visibilityOn.png", 25, 25);
                }else{
                    parolaConfirmataText.setEchoChar('*');
                    parolaConfirmataVizibila.imagineNoua("images/visibilityOff.png", 25, 25);
                }
                
                
            }
        };
    }
    
    public void setariContCurent(){
        try{  
            Connection conn = DBConnect.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM utilizator WHERE id = ?");
            stmt.setInt(1, Sesiune.getUtilizatorCurent().getUtilizatorId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                emailText.setText(rs.getString("email"));
                parolaText.setText(rs.getString("parola"));
                rolText.setText(rs.getString("rol"));
                } else {
                    System.out.println("problema cu datele");
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            } 
    }
    
    
        private void incarcareDate(){
        utilizatorDataLinie.clear();
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement userStmt = conn.prepareStatement("SELECT * FROM utilizator");
            ResultSet rs = userStmt.executeQuery();
            while(rs.next()){
                
                int userId = rs.getInt("id");
                String email = rs.getString("email");
                String parola = rs.getString("parola");
                String rol = rs.getString("rol");
                Utilizator utilizator = new Utilizator(userId, email, parola, rol);
                utilizatorDataLinie.add(utilizator);
            }
        } catch (SQLException ex) {
            System.getLogger(ContPanel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    private JLabel emailLabel = new JLabel("Email : ");
    private JTextField emailText = new JTextField();
    private JLabel parolaLabel = new JLabel("Parola : ");
    private JPasswordField parolaText = new JPasswordField();
    private JTextField rolText = new JTextField();
    private JLabel rolLabel = new JLabel("Rol :");
    private JButton schimbaDate = new JButton("Editare");
    private JButton saveChanges = new JButton("Salveaza");
    private JButton cancelChanges = new JButton("Cancel");
    private JLabel parolaConfirmataLabel = new JLabel("Confirm : ");
    private JPasswordField parolaConfirmataText = new JPasswordField("password");
    ImagineButon parolaVizibila = new ImagineButon("images/visibilityOff.png",25, 25);
    ImagineButon parolaConfirmataVizibila = new ImagineButon("images/visibilityOff.png",25, 25);
    private JButton logout = new JButton("Logout");
     private JTable tabelaUtilizatori;
    private JScrollPane scrollTabela;
    private List<Utilizator> utilizatorDataLinie = new ArrayList<>();
    private UtilizatorTableModel userModel;
}
