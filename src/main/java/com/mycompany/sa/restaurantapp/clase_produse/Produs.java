/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp.clase_produse;

import com.mycompany.sa.restaurantapp.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sara
 */
public abstract class Produs {

    
    protected int id;
    protected String denumire;
    protected int calorii;
    protected int stoc;
    protected double pret;
    protected String imagine;
    protected String descriere;

    public Produs(int id, String denumire, int calorii, int stoc, double pret, String imagine, String descriere) {
        this.id = id;
        this.denumire = denumire;
        this.calorii = calorii;
        this.stoc = stoc;
        this.pret = pret;
        this.imagine = imagine;
        this.descriere = descriere;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getCalorii() {
        return calorii;
    }

    public void setCalorii(int calorii) {
        this.calorii = calorii;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getImagine() {
        return imagine;
    }

    public void setImagine(String imagine) {
        this.imagine = imagine;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
    
    public static List<Produs> getAllProducts() throws SQLException {
        List<Produs> result = new ArrayList<>();
        Connection conn = DBConnect.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM produs");

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String denumire = rs.getString("denumire");
            int calorii = rs.getInt("calorii");
            int stoc = rs.getInt("stoc");
            double pret = rs.getDouble("pret");
            String imagine = rs.getString("imagine");
            String descriere = rs.getString("descriere");
            String tipprodus = rs.getString("tipprodus");
            
            if (tipprodus.equals("Bautura")) {
                int productId = id;
                PreparedStatement bauturaStmt = conn.prepareStatement("SELECT tip, calda FROM bautura WHERE id = ?");
                bauturaStmt.setInt(1, productId);
                ResultSet bauturaRs = bauturaStmt.executeQuery();
                String tip = ""; boolean calda = false;
                if (bauturaRs.next()) {
                    tip = bauturaRs.getString("tip");
                    calda = bauturaRs.getBoolean("calda");
                }
                bauturaRs.close();
                bauturaStmt.close();
            
                Bautura bautura = new Bautura( id,  denumire,  calorii,  stoc,  pret,  imagine,  descriere , tip, calda);
                
                result.add(bautura);
            } else if (tipprodus.equals("Desert")) {
                int productId = id;
                PreparedStatement desertStmt = conn.prepareStatement("SELECT tip FROM desert WHERE id = ?");
                desertStmt.setInt(1, productId);
                ResultSet desertRs = desertStmt.executeQuery();
                String tip = "";
                if (desertRs.next()) {
                    tip = desertRs.getString("tip");
                }
                desertRs.close();
                desertStmt.close();
                Desert desert = new Desert( id,  denumire,  calorii,  stoc,  pret,  imagine,  descriere , tip);
                result.add(desert);
            }else if (tipprodus.equals("Mancare")) {
                int productId = id;
                PreparedStatement mancareStmt = conn.prepareStatement("SELECT stil FROM mancare WHERE id = ?");
                mancareStmt.setInt(1, productId);
                ResultSet mancaretRs = mancareStmt.executeQuery();
                String stil = "";
                if (mancaretRs.next()) {
                    stil = mancaretRs.getString("stil");
                }
                mancaretRs.close();
                mancareStmt.close();
                Mancare mancare = new Mancare( id,  denumire,  calorii,  stoc,  pret,  imagine,  descriere , stil);
                result.add(mancare);
        }
        
    }
        return result;
    }
}
