/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business;


import com.pgy.dataaccess.TransferenciasDA;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author franciscavaldiviapalma
 */
public class Transferencias {

    int idTransaccion;
    int cuentaOrigen;
    int monto;
    int cuentaDestino;
    Date fechaHora;

    public Transferencias() {
    }

    public Transferencias(int idTransaccion, int cuentaOrigen, int monto, int cuentaDestino, Date fechaHora) {
        this.idTransaccion = idTransaccion;
        this.cuentaOrigen = cuentaOrigen;
        this.monto = monto;
        this.cuentaDestino = cuentaDestino;
        this.fechaHora = fechaHora;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(int cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(int cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public ArrayList<Transferencias> getAll() {

        ResultSet rs = new TransferenciasDA().getAll();
        ArrayList<Transferencias> transferencias = new ArrayList<>();

        if(rs != null){
            try {
                while(rs.next()){
                    Transferencias transf = new Transferencias();
                    transf.setIdTransaccion(rs.getInt("id_transaccion"));
                    transf.setCuentaOrigen(rs.getInt("cuenta_origen"));
                    transf.setMonto(rs.getInt("monto"));
                    transf.setCuentaDestino(rs.getInt("cuenta_destino"));
                    transf.setFechaHora(rs.getTimestamp("fecha_hora"));
                    transferencias.add(transf);
                }
            } catch (Exception ex) {
                System.out.println("Error al recuperar el cliente: " + ex.getMessage());
                return null;
            }
        }
        return transferencias;
    }
    
    public boolean insertar(Transferencias transferencias){
        
        boolean res = new TransferenciasDA().insertar(transferencias);
        return res;
    }
    

    @Override
    public String toString() {
        return "Registro{" + "idTransaccion=" + idTransaccion + ", cuentaOrigen=" + cuentaOrigen + ", monto=" + monto + ", cuentaDestino=" + cuentaDestino + ", fechaHora=" + fechaHora + '}';
    }

}
