/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio_Util;
import java.sql.*;


/**
 *
 * @author madarme
 */
public class TestConnection {




 public static void main(String[] args) throws Exception 
 {
   BaseDeDatosPeticiones.conectar();
    if (BaseDeDatosPeticiones.hayConexion())
        System.out.println("...BIENVENIDO...");
    else
        System.out.println("...NO HAY CONEXION CON LA BASE DE DATOS...");
   

 }
}