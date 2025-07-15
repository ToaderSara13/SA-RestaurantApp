/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp;

import com.mycompany.sa.restaurantapp.clase_produse.Utilizator;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sara
 */
public class UtilizatorTableModel extends AbstractTableModel{

   private  List<Utilizator> utilizatori = new ArrayList<>();
    private final String[] numeColoane = {"id", "email", "parola", "rol"};
    
    public UtilizatorTableModel(List<Utilizator> utilizatori) {
        this.utilizatori = utilizatori;
    }
    
    
    @Override
    public int getRowCount() {
        return utilizatori.size();
    }

    @Override
    public int getColumnCount() {
         return numeColoane.length;
    }
    
     @Override
    public String getColumnName(int column) {
        return numeColoane[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Utilizator utilizator = utilizatori.get(rowIndex);
        switch (columnIndex) {
            case 0: return utilizator.getUtilizatorId();   
            case 1: return utilizator.getEmail();
            case 2: return utilizator.getParola();  
            case 3: return utilizator.getRol();
            default: return null;
        }
    }
    
}
