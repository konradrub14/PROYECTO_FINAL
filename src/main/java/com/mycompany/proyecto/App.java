package com.mycompany.proyecto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import com.mycompany.models.Usuario;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Usuario user= new Usuario();

    @Override
    public void start(Stage stage) throws IOException {
        String fxml="Login";
        FXMLLoader fxmlLoader=new FXMLLoader(App.class.getResource(fxml+ ".fxml"));
        scene = new Scene(fxmlLoader.load(), 740, 580);
        stage.setScene(scene);
        stage.show();
        // Give the controller access to the main app.
        LoginController controller= fxmlLoader.getController();
        fxmlLoader.setController(controller);
        controller.loadImage();
        controller.loadImage2();
        
        
    }
    static void loadSegundaPantalla() throws IOException{
        String fxml="SegundaPagina";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml +".fxml"));
        
        ConsultarArticulosController controller= new ConsultarArticulosController();
        fxmlLoader.setController(controller);
        
        scene.setRoot(fxmlLoader.load());
        controller.initArticulos();   
    }
    static void loadRegister()throws IOException{
        String fxml="Register";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml +".fxml"));
        
       RegisterController controller= new RegisterController(user);
      fxmlLoader.setController(controller);
        scene.setRoot(fxmlLoader.load());
        controller.loadImage();
        
    }
    

    
    static void setUsuario(Usuario u) {       
        user = u;

    }
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    //METODO PARA IR AL LOGIN
    static void setLogin(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    static void setRegister(String fxml)throws IOException{
        scene.setRoot(loadFXML(fxml));
    }
 
    public static void main(String[] args) {
        launch();
    }
    

}