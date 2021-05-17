/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author konra
 */
public class UsuarioTest {
    
    public UsuarioTest() {
    }
   

    /**
     * Test of checkNombre method, of class Usuario.
     */
    @Test
    @DisplayName("Comprobamos que se cumpla la condición del Nombre")
    public void testCheckNombre() {
        System.out.println("checkNombre");
        String nombre = "jaja";
        Usuario instance = new Usuario();
        boolean expResult = false;
        boolean result = instance.checkNombre(nombre);
        assertFalse(result);
        
    }

    /**
     * Test of checkEmail method, of class Usuario.
     */
    @Test
    @DisplayName("Comprobamos que se cumpla la condición del Email.")
    public void testCheckEmail() {
        System.out.println("checkEmail");
        String email = "emaillllll";
        Usuario instance = new Usuario();
        boolean expResult = false;
        boolean result = instance.checkEmail(email);
        assertFalse(result);
        
    }

    /**
     * Test of checkPassword method, of class Usuario.
     */
    @Test
    @DisplayName("Comprobamos que se cumpla la condición de la contraseña")
    public void testCheckPassword() {
        System.out.println("checkPassword");
        String passw = "con";
        Usuario instance = new Usuario();
        boolean expResult = false;
        boolean result = instance.checkPassword(passw);
        assertFalse(result);
            
    }

    
}
