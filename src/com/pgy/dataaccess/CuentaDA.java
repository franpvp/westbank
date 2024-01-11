/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pgy.dataaccess;

import com.business.Cuenta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author franciscavaldiviapalma
 */
public class CuentaDA {
    
    public ResultSet get(int numCuenta){
        
        DBContext dbCtx = new DBContext();
        String st = "SELECT * FROM cuenta WHERE numCuenta = ?";
        ResultSet rs; 
        try {
            PreparedStatement pst = dbCtx.getConexion().prepareStatement(st);
            pst.setInt(1,numCuenta);
            rs = pst.executeQuery();
            return rs;
        } catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    
    public boolean insertar(Cuenta cuenta){
        
        boolean res = false;
        DBContext dbCtx = new DBContext();
        String st = "INSERT INTO cuenta(numCuenta,saldo,descripcion) VALUES(?,?,?)";
        try {
            PreparedStatement pst = dbCtx.getConexion().prepareStatement(st);
            pst.setInt(1,cuenta.getNumCuenta());
            pst.setInt(2,cuenta.getSaldo());
            pst.setString(3,cuenta.getDesc());
            pst.executeUpdate();
            res = true;
        } catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
            res = false;
        }
        return res;
    }
    
    public boolean updateSaldo(int numCuenta, int saldo){
        
        boolean res = false;
        
        DBContext dbCtx = new DBContext();
        String st = "UPDATE cuenta SET saldo = ? WHERE numCuenta = ?";
        try {
            PreparedStatement pst = dbCtx.getConexion().prepareStatement(st);
            pst.setInt(1,saldo);
            pst.setInt(2,numCuenta);
            pst.executeUpdate();
            res = true;
        } catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
            res = false;
        }
        return res;
       
    }
}
