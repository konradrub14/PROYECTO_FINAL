/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto;


import com.mycompany.proyecto.DAO.LoginDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;





/**
 *
 * @author konra
 */

public class LoginController {
    
    private LoginDAO login;
    //FIELDS
    @FXML
    private TextField user;
    //PASSWORD FIELD
    @FXML
    private PasswordField pass;
    // IMAGEN VIEW
    @FXML
    private ImageView imagen;
    @FXML
    private ImageView imagen2;
    // BUTTONS
    @FXML
    private Button Register;
    /**
     * 
     * @throws IOException 
     */
    @FXML
    
    public void loadRegister()throws IOException{
        App.loadRegister();
    }
    
    @FXML
    public void login(){
        login= new LoginDAO();
        
        String Usuario=user.getText();
        String password=pass.getText();
        boolean ok=false;
        try {
            login.conectar();
            
            ok=login.searchUsuario(Usuario, password);
            if(ok){
                App.loadSegundaPantalla();
            }else{
                Alertas.mostrarError("Usuario o contraseña erronea");
            } 
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void loadImage(){
        Image img = new Image(getClass().getResourceAsStream("/img/descarga.png"));
        imagen.setImage(img);
    }
    public void loadImage2(){
        Image img2= new Image(getClass().getResourceAsStream("/img/images.png"));
        imagen2.setImage(img2);
    }
   
   
    
    
    
 
    
    
  
      
   
    
    
   
   
   
   
 
   
   


    
    
}


