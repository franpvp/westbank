/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pgy.dataaccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author franciscavaldiviapalma
 */
public class DBContext {
    
    private Connection conexion;
    
    public DBContext(){
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:8889/westbank";
            String user = "root";
            String pass = "root";
            conexion = (Connection) DriverManager.getConnection(url,user,pass);
        } 
        catch (SQLException | ClassNotFoundException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public Connection getConexion(){
        return conexion;
    }
}
