/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.pgy.ui;

import com.pgy.frames.IniciarSesion;

/**
 *
 * @author franciscavaldiviapalma
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IniciarSesion frmIniciarSesion = new IniciarSesion();
        frmIniciarSesion.setTitle("West Bank");
        frmIniciarSesion.setLocation(600, 300);
        frmIniciarSesion.setVisible(true);
        
    }
    
}
