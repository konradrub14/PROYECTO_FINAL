/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.DAO;

import com.mycompany.models.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author konra
 */
public class RegisterDAO {
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
    //REGISTAR A UN USUARIO
    public void Registrar(Usuario user)throws SQLException{
        String sql="{CALL spaddUsuario (?,?,?,?,?)}";
        PreparedStatement sentencia=conexion.prepareStatement(sql);
        sentencia.setString(1, user.getNombre_u());
        sentencia.setString(2, user.getNombre_p());
        sentencia.setString(3, user.getApellido_p());
        sentencia.setString(4, user.getCorreo());
        sentencia.setString(5, user.getContra());
        sentencia.executeUpdate();  
    }
   
         
    
}
