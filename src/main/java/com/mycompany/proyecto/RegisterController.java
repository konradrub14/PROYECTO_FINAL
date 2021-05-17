/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto;

import com.mycompany.proyecto.DAO.RegisterDAO;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.mycompany.models.Usuario;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
/**
 *
 * @author konra
 */
public class RegisterController {
   private static RegisterDAO rdao;
   private static Usuario user;
   
    
    //FIELDS
    @FXML
    private TextField fieldID;
    @FXML
    private TextField fieldNOMBREU;
    @FXML
    private TextField fieldCONTRAU;
    @FXML
    private TextField fieldNOMBRE;
    @FXML
    private TextField fieldAPELLIDO;
    @FXML
    private TextField fieldCORREO;
    // BUTTON
    @FXML
    private Button REGISTRARSE;
    @FXML
    private Button volver;
    //IMAGES
    @FXML
    private ImageView imagen;
    
    
    
    @FXML
      private void BotonVolver() throws IOException{
        App.setLogin("Login");
      }
      //METODO PARA REGISTRARSE
    @FXML
    private void Registrarse(){ 
        try{
            rdao.Registrar(new Usuario(Integer.parseInt(fieldID.getText()),fieldNOMBREU.getText(),fieldCONTRAU.getText(),fieldNOMBRE.getText(),fieldAPELLIDO.getText(),fieldCORREO.getText()));
            
            Alert confirmacion= new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Crear usuario");
            confirmacion.setContentText("¿Quiere crear el usuario?");
        } catch(SQLException ex) {
            Alertas.mostrarError("ERROR AL CREAR EL USUARIO");
        }
    }
    
    //CONECTARSE A LA BASEDATOS
    private static void conectarBD(){
        rdao=new RegisterDAO();
        try{
            rdao.conectar();
        }catch(SQLException ex){
            Alertas.mostrarError("ERROR AL CONECTAR CON LA BASE"+ex.getMessage());
        }catch(ClassNotFoundException ex){
            Alertas.mostrarError("ERROR AL INICIAR LA APP");
        }catch(IOException ex){
            Alertas.mostrarError("ERROR A CARGAR LA CONEXION");
        }
    }
    public RegisterController(Usuario u){
        user=u;
        conectarBD();
    }
    
    
    
   
    
    
    
}
