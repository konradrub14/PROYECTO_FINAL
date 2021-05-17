/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.DAO;
import com.mycompany.models.Articulos;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
/**
 *
 * @author konra
 */
public abstract class ConsultarArticulosDAO {
    private Connection conectar;
    
    public void conectar() throws ClassNotFoundException, SQLException, IOException {
        String host = "localhost";
        String port = "3306";
        String name = "ProyectoTienda";
        String username = "root";
        String password = "KONRAD2000";
        
        //El connectionstring quedaria asi:jdbc:mariadb://localhost:3306/blockbuster?serverTimezone=UTC...username y password
        conectar = DriverManager.getConnection("jdbc:mariadb://" + host + ":" +
                port + "/" + name + "?serverTimezone=UTC",username, password);
    
    }
    public void desconectar() throws SQLException {
        conectar.close();
    }
    
    //METHOD OF INSERT
    public void insertArticulos(Articulos articulo)throws SQLException{
        String sql="{CALL spInsertarArticulos (?,?,?,?,?,?,?)}";
        System.out.println(sql);
        PreparedStatement sentencia= conectar.prepareStatement(sql);
        sentencia.setInt(1,articulo.getId_producto());
        sentencia.setString(2,articulo.getNombre_producto());
        sentencia.setString(3,articulo.getDescripcion_producto());
        sentencia.setFloat(4,articulo.getPrecio());
        sentencia.setInt(5,articulo.getStock_producto());
        sentencia.setInt(6,articulo.getCategoria_id());
        sentencia.setString(7,articulo.getTipo());
        sentencia.executeUpdate();
    }//METHOD OF DELETE
    public void deleteArticulos(Articulos articulo) throws SQLException{
         String sql=" delete from articulos where ID_ARTICULO=?";
         
         PreparedStatement sentencia= conectar.prepareStatement(sql);
         sentencia.setInt(1,articulo.getId_producto());
         sentencia.executeUpdate();
    }//METHOD OF MODIFY
    public void modifyArticulos( Articulos articulo)throws SQLException{
        String sql="{CALL spModificarArticulos (?,?,?,?,?,?,?)}";
        
        CallableStatement sentencia=conectar.prepareCall(sql);
        sentencia.setInt(1,articulo.getId_producto());
        sentencia.setString(2,articulo.getNombre_producto());
        sentencia.setString(3,articulo.getDescripcion_producto());
        sentencia.setFloat(4,articulo.getPrecio());
        sentencia.setInt(5,articulo.getStock_producto());
        sentencia.setInt(6,articulo.getCategoria_id());
        sentencia.setString(7,articulo.getTipo());
        sentencia.registerOutParameter(7, java.sql.Types.INTEGER);
        
        sentencia.execute();
        
      
    }
    //METHOD OF SELECT
    public void selectArticulos(Articulos articulo)throws SQLException{
        String sql="SELECT * FROM ARTICULOS ";
    }
    //MOSTRAR LISTA DE LOS ARTICULOS DE LA BASE DE DATOS
    public List<Articulos> listArticulos() throws SQLException{
        List<Articulos> articulos= new ArrayList<>();
        String sql="SELECT * FROM ARTICULOS";
        
        PreparedStatement sentencia=conectar.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            Articulos articulo=new Articulos();
            
            articulo.setId_producto(resultado.getInt(1));
            articulo.setNombre_producto(resultado.getString(2));
            articulo.setDescripcion_producto(resultado.getString(3));
            articulo.setPrecio(resultado.getFloat(4));
            articulo.setStock_producto(resultado.getInt(5));
            articulo.setCategoria_id(resultado.getInt(6));
            articulo.setTipo(resultado.getString(7));
            articulos.add(articulo);
        }
        return articulos;
    }
    public boolean searchArticulo(int id,String nombre)throws SQLException{
        String sql="SELECT * FROM articulos WHERE id_articulo LIKE ? LIMIT1";
        PreparedStatement sentencia=conectar.prepareStatement(sql);
        sentencia.setInt(1, id);
        sentencia.setString(2,nombre);
        ResultSet resultado= sentencia.executeQuery();
        
        return resultado.next();
    }
    
    
    
    
}
