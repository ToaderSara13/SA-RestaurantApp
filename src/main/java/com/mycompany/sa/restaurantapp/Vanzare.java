/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp;

import java.time.LocalDateTime;

/**
 *
 * @author Sara
 */
public class Vanzare {
    private int v_id;
    private int p_id;
    private int u_id;
    private int cantitate;
    private double pret;
    private double pret_total;
    private LocalDateTime timestamp;

    public Vanzare(int v_id, int p_id, int u_id, int cantitate, double pret, double pret_total, LocalDateTime timestamp) {
        this.v_id = v_id;
        this.p_id = p_id;
        this.u_id = u_id;
        this.cantitate = cantitate;
        this.pret = pret;
        this.pret_total = pret_total;
        this.timestamp = timestamp;
    }

    public int getV_id() {
        return v_id;
    }

    public void setV_id(int v_id) {
        this.v_id = v_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public double getPret_total() {
        return pret_total;
    }

    public void setPret_total(double pret_total) {
        this.pret_total = pret_total;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    
}
