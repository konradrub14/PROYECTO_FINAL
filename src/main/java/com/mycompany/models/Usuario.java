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
public  class Usuario {
   private int id_usuario;
   private String nombre_u;
   private String nombre_p;
   private String apellido_p;
   private String correo;
   private String contra;

    //CONSTRUCOTR VACIO
   public Usuario(){
       
   }
   //CONSTRUCTOR CON PARAMETROS 
   /**
    * 
    * @param nombre_u
    * @param nombre_p
    * @param apellido_p
    * @param correo
    * @param contra 
    */
    public Usuario( String nombre_u, String nombre_p, String apellido_p, String correo, String contra) {
 
        this.nombre_u = nombre_u;
        this.nombre_p = nombre_p;
        this.apellido_p = apellido_p;
        this.correo = correo;
        this.contra = contra;
    }
   
//GETTERS Y SETTERS 
    
    /**
     * 
     * @return 
     */
    public int getId_usuario() {
        return id_usuario;
    }
    /**
     * 
     * @param id_usuario 
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    /**
     * 
     * @return 
     */
    public String getNombre_u() {
        return nombre_u;
    }
    /**
     * 
     * @param nombre_u 
     */
    public void setNombre_u(String nombre_u) {
        this.nombre_u = nombre_u;
    }
    /**
     * 
     * @return 
     */
    public String getNombre_p() {
        return nombre_p;
    }
    /**
     * 
     * @param nombre_p 
     */
    public void setNombre_p(String nombre_p) {
        this.nombre_p = nombre_p;
    }
    /**
     * 
     * @return 
     */
    public String getApellido_p() {
        return apellido_p;
    }
    /**
     * 
     * @param apellido_p 
     */
    public void setApellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }
    /**
     * 
     * @return 
     */
    public String getCorreo() {
        return correo;
    }
    /**
     * 
     * @param correo 
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    /**
     * 
     * @return 
     */
    public String getContra() {
        return contra;
    }
    /**
     * 
     * @param contra 
     */
    public void setContra(String contra) {
        this.contra = contra;
    }
       

   
    /**
     * Metodo control nombre de usuario correcto, minimo 6 caracteres
     * @param nombre a chequear
     * @return true si el nombre es valido
     */
    public boolean checkNombre(String nombre){
        return nombre.length() >= 6;
    }
    
    /**
     * Metodo control email correcto, minimo 6 caracteres
     * @param email
     * @return 
     */
    public boolean checkEmail(String email){
        //return email.matches("@+");
        boolean ok = false;
        if (email.matches("[-\\w\\.]+@\\w+\\.\\w+")) 
            ok = true;
        return ok;
    }
    
    /**
     * Metodo control password correcto
     * @param passw
     * @return 
     */
    public boolean checkPassword(String passw){
        boolean ok = false;
        if (passw.matches(".*[A-Z].*") && passw.length() >=8) 
            ok = true;
        return ok;
    }
    
     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{ id_usuario=").append(id_usuario);
        sb.append(", nombre_u=").append(nombre_u);
        sb.append(", nombre_p=").append(nombre_p);
        sb.append(", apellido_p=").append(apellido_p);
        sb.append(", correo=").append(correo);
        sb.append(", contra=").append(contra);
        sb.append('}');
        return sb.toString();
    }

    

    

 

    
    
}
