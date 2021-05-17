/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;






/**
 *
 * @author konra
 */

public class Articulos {
    private int id_producto;   
    private float precio;
    private String nombre_producto;
    private String descripcion_producto;
    private int stock_producto;
    private int categoria_id;
    private String tipo;
    
    //CONSTRUCTOR VACÃ�O
    public Articulos() {
        
    }

    /**
     *
     * @param id_producto
     * @param nombre_producto
     * @param descripcion_producto
     * @param precio
     * @param stock_producto
     * @param categoria_id
     * @param tipo
     */
    public Articulos(int id_producto,String nombre_producto,String descripcion_producto,float precio,int stock_producto,int categoria_id,String tipo){
        this.id_producto=id_producto;
        this.precio=precio;
        this.nombre_producto=nombre_producto;
        this.descripcion_producto=descripcion_producto;
        this.stock_producto=stock_producto;
        this.categoria_id=categoria_id;
        this.tipo=tipo;
        
        
    }
    /**
     * 
     * @param cantidad 
     */
    public void controlStock(int cantidad) {
        this.stock_producto += cantidad;
    }
    
    
    //GETTERS Y SETTERS
    
    /**
     * 
     * @return 
     */
    public int getId_producto() {
        return id_producto;
    }
    /**
     * 
     * @param id_producto 
     */
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
    /**
     * 
     * @return 
     */
    public String getNombre_producto() {
        return nombre_producto;
    }
    /**
     * 
     * @param nombre_producto 
     */
    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }
    /**
     * 
     * @return 
     */
    public String getDescripcion_producto() {
        return descripcion_producto;
    }
    /**
     * 
     * @param descripcion_producto 
     */
    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }
    /**
     * 
     * @return 
     */
    
    public int getCodigo_producto() {
        return id_producto;
    }
    /**
     * 
     * @param codigo_producto 
     */

    public void setCodigo_producto(int codigo_producto) {
        this.id_producto = codigo_producto;
    }
    /**
     * 
     * @return 
     */

    public int getStock_producto() {
        return stock_producto;
    }
    /**
     * 
     * @param stock_producto 
     */

    public void setStock_producto(int stock_producto) {
        this.stock_producto = stock_producto;
    }
    /**
     * 
     * @return 
     */

    public int getTipo_producto() {
        return categoria_id;
    }
    /**
     * 
     * @param precio 
     */

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    /**
     * 
     * @return 
     */

    public float getPrecio() {
        return precio;
    }
    /**
     * 
     * @param categoria_id 
     */
    public void setTipo_producto(int categoria_id) {
        this.categoria_id = categoria_id;
    }
    /**
     * 
     * @return 
     */
    public String getTipo() {
        return tipo;
    }
    /**
     * 
     * @param tipo 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    /**
     * 
     * @param categoria_id 
     */
    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }
    /**
     * 
     * @return 
     */

    public int getCategoria_id() {
        return categoria_id;
    }
    /**
     * 
     * @return 
     */
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ID_Producto{ID = ").append(id_producto);
        sb.append(", PRECIO = ").append(precio);
        sb.append(", NombreProducto = ").append(nombre_producto);
        sb.append(", DescripcionProducto = ").append(descripcion_producto);
        sb.append(", StockDelProducto = ").append(stock_producto);
        sb.append(", ID_CATEGORIA = ").append(categoria_id);
        sb.append(", TipoArticulo = ").append(tipo);
        return sb.toString();
    }

    
    
    
}

