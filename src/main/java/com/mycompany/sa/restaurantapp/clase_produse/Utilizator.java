/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp.clase_produse;

/**
 *
 * @author Sara
 */
public class Utilizator {
    private int utilizatorId;
    private String email;
    private String parola;
    private String rol;

    public Utilizator() {
        this.utilizatorId = 0;
        this.email = null;
        this.parola = null;
        this.rol = null;
    }

    public Utilizator(int utilizatorId, String email, String parola, String rol) {
        this.utilizatorId = utilizatorId;
        this.email = email;
        this.parola = parola;
        this.rol = rol;
    }

    public int getUtilizatorId() {
        return utilizatorId;
    }

    public void setUtilizatorId(int utilizatorId) {
        this.utilizatorId = utilizatorId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
