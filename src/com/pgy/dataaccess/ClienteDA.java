/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pgy.dataaccess;

import com.business.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author franciscavaldiviapalma
 */
public class ClienteDA {
    
    public ResultSet get(int rut, String dv){
        
        DBContext dbCtx = new DBContext();
        String st = "SELECT * FROM cliente WHERE rut = ? AND dv = ?";
        ResultSet rs;
        try {
            PreparedStatement pst = dbCtx.getConexion().prepareStatement(st);
            pst.setInt(1,rut);
            pst.setString(2,dv);
            rs = pst.executeQuery();
            return rs;
        } catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    
    public boolean insertar(Cliente cliente){
        
        boolean res = false;
        
        DBContext dbCtx = new DBContext();
        String st = "INSERT INTO cliente(rut,dv,nombre,apPaterno,apMaterno,domicilio,comuna,telefono,clave,numCuenta) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = dbCtx.getConexion().prepareStatement(st);
            pst.setInt(1,cliente.getRut());
            pst.setString(2,cliente.getDv());
            pst.setString(3,cliente.getNombre());
            pst.setString(4,cliente.getApPaterno());
            pst.setString(5,cliente.getApMaterno());
            pst.setString(6,cliente.getDomicilio());
            pst.setString(7,cliente.getComuna());
            pst.setInt(8,cliente.getTelefono());
            pst.setString(9, cliente.getClave());
            pst.setInt(10,cliente.getCuenta().getNumCuenta());
            pst.executeUpdate();
            res = true;
        } catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
            res = false;
        }
        return res;
    }
    
    public ResultSet login(int rut, String dv, String clave){
        
        DBContext dbCtx = new DBContext();
        String st = "SELECT * FROM cliente WHERE rut = ? AND dv = ? AND clave = ?";
        ResultSet rs;
        try {
            PreparedStatement pst = dbCtx.getConexion().prepareStatement(st);
            pst.setInt(1,rut);
            pst.setString(2,dv);
            pst.setString(3,clave);
            rs = pst.executeQuery();
            return rs;
        } catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    
    
    
    
}
