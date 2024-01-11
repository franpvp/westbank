/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.business;

/**
 *
 * @author franciscavaldiviapalma
 */
public class Persona {
    
    int rut;
    String dv;
    String nombre;
    String apPaterno;
    String apMaterno;
    String domicilio;
    String comuna;
    int telefono;

    public Persona() {
    }

    public Persona(int rut, String dv, String nombre, String apPaterno, String apMaterno, String domicilio, String comuna, int telefono) {
        this.rut = rut;
        this.dv = dv;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "rut=" + rut + ", dv=" + dv + ", nombre=" + nombre + ", apPaterno=" + apPaterno + ", apMaterno=" + apMaterno + ", domicilio=" + domicilio + ", comuna=" + comuna + ", telefono=" + telefono + '}';
    }

    
    
    

}
