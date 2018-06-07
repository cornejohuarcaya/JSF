/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATOS;

/**
 *
 * @author Erick
 */
public class Logeo {
  private static String usuario;
  private static String contrasena;

    /**
     * @return the usuario
     */
    public static String getUsuario() {
        return usuario;
    }

    /**
     * @param aUsuario the usuario to set
     */
    public static void setUsuario(String aUsuario) {
        usuario = aUsuario;
    }

    /**
     * @return the contrasena
     */
    public static String getContrasena() {
        return contrasena;
    }

    /**
     * @param aContrasena the contrasena to set
     */
    public static void setContrasena(String aContrasena) {
        contrasena = aContrasena;
    }
  
}
