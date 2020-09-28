/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio_Util;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sadalsuud
 */
public class DataBaseHelper<T> {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/";
    private static final String USUARIO = "root";
    private static final String CLAVE = "fibonacci";

    public int modificarRegistro(String cosultaSQL) {

        Connection conexion = null;
        Statement sentencia = null;
        int filasAfectadas = 0;

        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            sentencia = conexion.createStatement();
            filasAfectadas = sentencia.executeUpdate(cosultaSQL);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de SQL" + e.getMessage());
        } finally {
            // cierra los recursos
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException e) {
                    System.out.println("Error cerrando la sentencia" + e.getMessage());
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    System.out.println("Error cerrando la conexion" + e.getMessage());
                }
            }

        }
        return filasAfectadas;
    }

     @SuppressWarnings("unchecked")
//    @SuppressWarnings("UseSpecificCatch")
    public List<T> seleccionarRegistros(String consultaSQL, Class clase) {

        Connection conexion = null;
        Statement sentencia = null;
        @SuppressWarnings("UnusedAssignment")
        ResultSet filas = null;

        List<T> objetos = new ArrayList<>();
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            sentencia = conexion.createStatement();
            filas = sentencia.executeQuery(consultaSQL);

            while (filas.next()) {

                 T objeto             
                 = (T) Class.forName(clase.getName()).newInstance();
                Method[] metodos = objeto.getClass().getDeclaredMethods();
                for (Method metodo : metodos) {
                    if (metodo.getName().startsWith("set")) {
                        metodo.invoke(objeto, filas.getString(metodo.getName().substring(3)));
                    }
                    if (objeto.getClass().getName().equals("java.lang.String")) {
                        objeto = (T) filas.getString(1);
                    }
                }
                objetos.add(objeto);
            }
        } catch (Exception e) {
            System.out.println("Error al seleccionar registros" + e.getMessage());
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException e) {
                    System.out.println("Error al seleccionar registros" + e.getMessage());

                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    System.out.println("Error al seleccionar registros" + e.getMessage());

                }
            }
        }
        return objetos;
    }
}
