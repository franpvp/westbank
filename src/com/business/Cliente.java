/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business;

import com.pgy.dataaccess.ClienteDA;
import java.sql.ResultSet;

/**
 *
 * @author franciscavaldiviapalma
 */
public class Cliente extends Persona{
    
    private String clave;
    private Cuenta cuenta;

    public Cliente() {
    }

    public Cliente(int rut, String dv, String nombre, String apPaterno, String apMaterno, String domicilio, String comuna, int telefono, String clave, Cuenta cuenta) {
        super(rut, dv, nombre, apPaterno, apMaterno, domicilio, comuna, telefono);
        this.clave = clave;
        this.cuenta = cuenta;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    //Obtener datos desde la base de datos
    public Cliente obtener(int rut, String dv){
        
        ResultSet rs = new ClienteDA().get(rut,dv);
        
        if(rs != null){
            try {
                if(rs.next()){
                    this.rut = rs.getInt("rut");
                    this.dv = rs.getString("dv");
                    this.nombre = rs.getString("nombre");
                    this.apPaterno = rs.getString("apPaterno");
                    this.apMaterno = rs.getString("apMaterno");
                    this.domicilio = rs.getString("domicilio");
                    this.comuna = rs.getString("comuna");
                    this.telefono = rs.getInt("telefono");
                    this.clave = rs.getString("clave");
                    this.cuenta = new Cuenta().obtener(rs.getInt("numCuenta"));
                    //return this, devuelve un objeto Cliente
                    return this;
                } else {
                    return null;
                }
            } catch (Exception ex){
                System.out.println("Error al recuperar el cliente: " + ex.getMessage());
                return null;
            }
        }
        return null;
    }
    
    public Cliente login(int rut, String dv, String clave){
        
        ResultSet rs = new ClienteDA().login(rut,dv,clave);
        
        if(rs != null){
            try {
                if(rs.next()){
                    this.rut = rs.getInt("rut");
                    this.dv = rs.getString("dv");
                    this.nombre = rs.getString("nombre");
                    this.apPaterno = rs.getString("apPaterno");
                    this.apMaterno = rs.getString("apMaterno");
                    this.domicilio = rs.getString("domicilio");
                    this.comuna = rs.getString("comuna");
                    this.telefono = rs.getInt("telefono");
                    this.clave = rs.getString("clave");
                    this.cuenta = new Cuenta().obtener(rs.getInt("numCuenta"));
                    //return this, devuelve un objeto Cliente
                    return this;
                } else {
                    return null;
                }
            } catch (Exception ex){
                System.out.println("Error al recuperar el cliente: " + ex.getMessage());
                return null;
            }
        }
        return null;
    }
    
    
    //Insertar objeto cliente al BD
    public boolean insertar(Cliente cliente){
        
        boolean res = new ClienteDA().insertar(cliente);
        return res;
    }

    @Override
    public String toString() {
        return "Cliente{" + "clave=" + clave + ", cuenta=" + cuenta + '}';
    }
    
    


    
    
}
