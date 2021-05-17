/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.DAO;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author konra
 */
public class LoginDAO {
    private Connection conexion;

    public void conectar() throws ClassNotFoundException, SQLException, IOException {
     
        String host = "localhost";
        String port = "3306";
        String name = "proyectotienda";
        String username = "root";
        String password ="KONRAD2000";

        conexion = DriverManager.getConnection("jdbc:mariadb://" + host + ":" + port + "/" + name + "?serverTimezone=UTC",
                username, password);
    }
    public void desconectar() throws SQLException {
        conexion.close();
    }
    
    public boolean searchUsuario(String nombre,String pass) throws SQLException {
        String sql = "SELECT * FROM Usuario WHERE nombre_usuario=? and contrasea=? LIMIT 1";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, nombre);
        sentencia.setString(2, pass);
        ResultSet resultado = sentencia.executeQuery();

        return resultado.next();
    }
    
    

  
}
