package com.mycompany.proyecto;

import com.mycompany.proyecto.DAO.ConsultarArticulosDAO;
import com.mycompany.models.Articulos;
import com.mycompany.models.TiposDArticulo;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import com.mycompany.proyecto.App;



public class ConsultarArticulosController{
    private static ConsultarArticulosDAO cadao;
    private Articulos artselec;
    private ObservableList<TiposDArticulo>tipos=FXCollections.observableArrayList(Arrays.asList(TiposDArticulo.values()));
    


// TEXTFIELDS 
@FXML
private TextField fieldID;
@FXML
private TextField fieldNOMBRE;
@FXML
private TextField fieldDESCRIPCION;
@FXML
private TextField fieldPRECIO;
@FXML
private TextField fieldSTOCK;
@FXML
private TextField fieldCATEGORIA;
  
// BUTTONS 
@FXML
private Button añadir;
@FXML
private Button eliminar;
@FXML
private Button modificar;
@FXML
private Button salir;
@FXML
private Button volver;

//COMBOBOX
@FXML
private ComboBox combo;
// LIST VIEW
@FXML
private ListView listaArticulos;
//BIENVENIDO LABEL
@FXML
private Text bienvenido;

//ADD ARTICLES
@FXML
private void aniadirArticulo(){
    try{
        cadao.insertArticulos(new Articulos(Integer.parseInt(fieldID.getText()),fieldNOMBRE.getText(),fieldDESCRIPCION.getText(),Float.parseFloat(fieldPRECIO.getText()),Integer.parseInt(fieldSTOCK.getText()),Integer.parseInt(fieldCATEGORIA.getText()),combo.getValue().toString()));
        initArticulos();
        Alert confirmacion= new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Añadir articulo");
        confirmacion.setContentText("¿Estás seguro que deseas añadir este articulo?");
    }catch (SQLException ex){
        Alertas.mostrarError("ERROR AL AÑADIR EL ARTICULO A LA BASE DE DATOS"+ex.getMessage());
    }
}
//DELETE ARTICLES
@FXML
private void eliminarArticulos(){
    artselec=(Articulos)listaArticulos.getSelectionModel().getSelectedItem();
    if(artselec==null){
        Alertas.mostrarError("No se ha seleccionado ningún articulo");
        return;
    }
    try{
        Alert confirmacion= new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Eliminar Articulo");
        confirmacion.setContentText("¿Estás seguro que deseas eliminar este articulo?");
        Optional<ButtonType>respuesta=confirmacion.showAndWait();
        if(respuesta.get().getButtonData()==ButtonBar.ButtonData.CANCEL_CLOSE)
            return;
        cadao.deleteArticulos(artselec);
        initArticulos();
    }catch(SQLException ex){
        Alertas.mostrarError("ERROR AL ELIMINAR EL ARTICULO");
    }
}
@FXML
private void modificarArticulos(){
    artselec=(Articulos)listaArticulos.getSelectionModel().getSelectedItem();
    if(artselec==null){
        Alertas.mostrarError("NO SE HA SELECCIONADO NINGUN ARTICULO");
        
    }
    try{
        cadao.modifyArticulos(new Articulos(artselec.getId_producto(),fieldNOMBRE.getText(),fieldDESCRIPCION.getText(),Float.parseFloat(fieldPRECIO.getText()),Integer.parseInt(fieldSTOCK.getText()),Integer.parseInt(fieldCATEGORIA.getText()),combo.getValue().toString()));
        initArticulos();
    }catch(SQLException ex){
        Alertas.mostrarError("ERROR AL MODIFICAR EL ARTICULO"+ex.getMessage());
    }
}



//CONECTAR A BASEDATOS
private static void conectarBD(){
    cadao=new ConsultarArticulosDAO() {};
    try{
        cadao.conectar();
    }catch(SQLException ex){
        Alertas.mostrarError("ERROR AL CONECTAR A LA BASE DE DATOS"+ex.getMessage());
    }catch(ClassNotFoundException ex){
        Alertas.mostrarError("Error al iniciar la apliacacion");
    }catch(IOException ex){
        Alertas.mostrarError("ERROR AL CARGAR LA CONFIGURACION");
    }
}
public void initArticulos(){
    bienvenido.setText("Bienvenido");
    combo.setItems(tipos);
    listaArticulos.getItems().clear();
    try{
        conectarBD();
        List<Articulos>articulos=cadao.listArticulos();
        listaArticulos.setItems(FXCollections.observableList(articulos));
    }catch(SQLException ex){
        Alertas.mostrarError("ERROR AL CARGAR LOS DATOS");
    }
}

//CARGAR LOS ARTICULOS
private void cargarArticulos(Articulos articulo){
    fieldID.setText(Integer.toString(articulo.getId_producto()));
    fieldNOMBRE.setText(articulo.getNombre_producto());
    fieldDESCRIPCION.setText(articulo.getDescripcion_producto());
    fieldPRECIO.setText(Float.toString(articulo.getPrecio()));
    fieldSTOCK.setText(Integer.toString(articulo.getStock_producto()));
    fieldCATEGORIA.setText(Integer.toString(articulo.getCategoria_id()));
}
//LIMPIAR LOS ARTICULOS
private void limpiarArticulos(){
    fieldID.setText("");
    fieldNOMBRE.setText("");
    fieldDESCRIPCION.setText("");
    fieldPRECIO.setText("");
    fieldSTOCK.setText("");
    fieldCATEGORIA.setText("");
    
}
//SELECCIONAR EL ARTICULO

public void seleccionarArticulo(Event event){
    artselec=(Articulos)listaArticulos.getSelectionModel().getSelectedItem();
    cargarArticulos(artselec);
}


//DISCONNECT

@FXML
      public void disconnect(){
          try{
              cadao.desconectar();
              Platform.exit();
          }catch(SQLException ex){
              Alertas.mostrarError("Error desconexion");
          
          }
      }
      
      @FXML
      private void BotonVolver() throws IOException{
        App.setLogin("Login");
        
          
      }
      
}