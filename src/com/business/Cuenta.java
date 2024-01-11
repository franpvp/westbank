/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business;

import com.pgy.dataaccess.CuentaDA;
import java.sql.ResultSet;


/**
 *
 * @author franciscavaldiviapalma
 */
public class Cuenta {
    
    int numCuenta;
    int saldo;
    String desc;

    public Cuenta() {
    }

    public Cuenta(int numCuenta, int saldo, String desc) {
        this.numCuenta = numCuenta;
        this.saldo = saldo;
        this.desc = desc;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public Cuenta obtener(int numCuenta){
        
        ResultSet rs = new CuentaDA().get(numCuenta);
        
        if(rs != null){
            try {
                if(rs.next()){
                    this.numCuenta = rs.getInt("numCuenta");
                    this.saldo = rs.getInt("saldo");
                    this.desc = rs.getString("descripcion");
                    return this;
                } else {
                    return null;
                }
            } catch (Exception ex){
                System.out.println("Error al recuperar el cliente: " + ex.getMessage());
                return null;
            }
        }
        return this;
    }
    
    public boolean insertar(Cuenta cuenta){
        
        boolean res = new CuentaDA().insertar(cuenta);
        return res;
    }
    
    public boolean update(int numCuenta, int saldo){
        
        boolean res = new CuentaDA().updateSaldo(numCuenta, saldo);
        return res;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numCuenta=" + numCuenta + ", saldo=" + saldo + ", desc=" + desc + '}';
    }
}
