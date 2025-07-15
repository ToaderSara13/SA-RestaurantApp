/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp;

import com.mycompany.sa.restaurantapp.clase_produse.Utilizator;

/**
 *
 * @author Sara
 */
public class Sesiune {
    private static Utilizator utilizatorCurent;
    public static void login(Utilizator utilizator) {
        utilizatorCurent = utilizator;
    }

    public static void logout() {
        utilizatorCurent = null;
    }

    public static Utilizator getUtilizatorCurent() {
        return utilizatorCurent;
    }

    public static boolean isLoggedIn() {
        return utilizatorCurent != null;
    }
}
