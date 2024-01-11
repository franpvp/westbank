/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pgy.dataaccess;

import com.business.Transferencias;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author franciscavaldiviapalma
 */
public class TransferenciasDA {
    
    public ResultSet getAll(){
        
        DBContext dbCtx = new DBContext();
        String st = "SELECT * FROM historial_transferencias";
        ResultSet rs;
        try {
            PreparedStatement pst = dbCtx.getConexion().prepareStatement(st);
            rs = pst.executeQuery();
            return rs;
        } catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    
    
    public boolean insertar(Transferencias transferencias){
        
        boolean res = false;
        
        DBContext dbCtx = new DBContext();
        String st = "INSERT INTO historial_transferencias(cuenta_origen,monto,cuenta_destino,fecha_hora) VALUES (?,?,?,?)";
        try {
            PreparedStatement pst = dbCtx.getConexion().prepareStatement(st);
            pst.setInt(1,transferencias.getCuentaOrigen());
            pst.setInt(2,transferencias.getMonto());
            pst.setInt(3,transferencias.getCuentaDestino());
            pst.setTimestamp(4, new java.sql.Timestamp(transferencias.getFechaHora().getTime()));
            pst.executeUpdate();
            res = true;
        } catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
            res = false;
        }
        return res;
    }
    
    
}
