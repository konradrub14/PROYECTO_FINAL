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
public class Administrador extends Usuario {
    private int codigo_admin;
    
    
public Administrador(){
    
}
/**
 * 
 * @param codigo_admin
 * @param nombre_u
 * @param nombre_p
 * @param apellido_p
 * @param correo
 * @param contra 
 */
public Administrador(int codigo_admin,String nombre_u,String nombre_p,String apellido_p,String correo,String contra){
    super(nombre_u,nombre_p,apellido_p,correo,contra);
    this.codigo_admin=codigo_admin;
}
    /**
     * 
     * @return 
     */
    public int getCodigo_admin() {
        return codigo_admin;
    }
    /**
     * 
     * @param codigo_admin 
     */
    public void setCodigo_admin(int codigo_admin) {
        this.codigo_admin = codigo_admin;
    }
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Administrador{codigo_admin=").append(codigo_admin);
        sb.append('}');
        return sb.toString();
    }
    

}
