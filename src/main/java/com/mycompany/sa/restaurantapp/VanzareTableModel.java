/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sara
 */
public class VanzareTableModel extends AbstractTableModel{

    private List<Vanzare> vanzari = new ArrayList<>();
    private final String[] numeColoane = {"vanzare_id", "produs_id", "cumparator_id", "cantitate", "pret", "pret_total", "data_vanzarii"};
    
    
    public VanzareTableModel(List<Vanzare> vanzari){
        this.vanzari = vanzari;
    }
    
    @Override
    public int getRowCount() {
       return vanzari.size();
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
        Vanzare vanzare = vanzari.get(rowIndex);
        switch (columnIndex) {
            case 0: return vanzare.getV_id();
            case 1: return vanzare.getP_id();     
            case 2: return vanzare.getU_id();
            case 3: return vanzare.getCantitate();  
            case 4: return vanzare.getPret();
            case 5: return vanzare.getPret_total();
            case 6: return vanzare.getTimestamp();
            default: return null;
        }
    }
    
}
