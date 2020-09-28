/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio_Util;

import java.sql.ResultSet;

/**
 * Clase que permite conectar con una Base De datos Mysql; sin embargo, con solo
 * cambiar el atributo controlador puede usarse para cualquier motor de base de
 * datos
 *
 * @author Marco Adarme
 * @version 2.0
 */
public class BaseDeDatosPescadero {

    //--== LOCALHOST ==--//
//    private static  String bd = "ufps_11";
//    private static  String login = "ufps_11";
//    private static  String password = "ufps_90";
//    private static  String url = "jdbc:mysql://localhost:3306/"+bd;
    //--== SANDBOX ==--//
    private static String bd;
    private static String login;
    private static String password;
    private static String ip;
    //private static String url = "jdbc:mysql://sandbox2.ufps.edu.co/" + bd;
    private static String url;

    private static String controlador;
    private static JDBCMiddler jdbc;

    /**
     * Comprueba si hay o no hay conexion
     *
     * @return un boolean, true si hay conexion y false si no
     */
    public static boolean hayConexion() {

        return (jdbc != null && jdbc.hayconexion());

    }

    /**
     * Método que realiza la conexion con administrador de la base de datos
     */
    public static void asignarip() {
        archivos a = new archivos();
        String ipExt = a.leerTxt("C:\\Sistema\\config\\ipBodega.txt");
//        String dbExt = a.leerTxt("C:\\Sistema\\config\\dbP.txt");
         String dbExt = a.leerTxt("C:\\Sistema\\config\\dbP1.txt");
        ip = ipExt;
        bd = dbExt;
        login = "root";
        password = "Soporte";
        url = "jdbc:mysql://" + ip + ":3306/" + bd;
        controlador = "com.mysql.jdbc.Driver";
        JDBCMiddler jdbc;
        //<editor-fold desc="SE ASEGURA QUE LA BASE DE DATOS ESTE SIEMPRE ACTUALIZADA">
/*  String dbExt = a.leerTxt("C:\\Sistema\\config\\dbb.txt");
         int validar = Integer.valueOf(dbExt.split("ovedades")[1]);       
         Date fechasis = new Date();//capturo la fecha del sistema
         DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
         String fecha = dateFormat.format(fechasis);
         int año = Integer.valueOf(fecha.split("/")[2]);//capturo año
         int mes = Integer.valueOf(fecha.split("/")[1]);//capturo mes
         int dia = Integer.valueOf(fecha.split("/")[0]);//capturo dia     
         if (validar != año) {
         a.texto = "novedades" + año;
         a.Escribir("C:/Sistema/config/dbb.txt");
         }*/
//</editor-fold>

    }

    public static void conectar() {

        jdbc = new JDBCMiddler(controlador, url, login, password);
        try {
            jdbc.conectar();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Método que ejecuta una actualizacion en una bae de datos
     *
     * @param comandoSQL es de tipo Sting y contiene el comando SQL para
     * ejecutar la actualizacion
     * @return un tipo boolean, true si ejecuta la actualiza y false sino.
     */
    public static boolean ejecutarActualizacionSQL(String comandoSQL) {

        try {
            return (jdbc.ejecutarActualizacionSQL(comandoSQL));
        } catch (Exception e) {
            System.err.println("SQL Error:" + e.getMessage());
            return (false);
        }

    }

    public static ResultSet ejecutarSQL(String consultaSQL, Object[] param) {
        try {
            return (jdbc.ejecutarSQL(consultaSQL, param));
        } catch (Exception e) {
            System.err.println("SQL Error:" + e.getMessage());
            return (null);
        }
    }

    /**
     * Método que desconecta la aplicacion de la base de datos
     */
    public static void desconectar() {

        try {
            jdbc.desconectar();
        } catch (Exception e) {
            System.err.println("SQL Error:" + e.getMessage());
        }

    }

    /**
     * Método que retorna una consulta en formato de tabla HTML
     *
     * @param sql contiene la consulta en sql
     * @return un Stirng con la informacion en formato de tabla HTML
     */
    public static String getTablaHTML(String sql) {

        try {

            return (jdbc.getHTML(sql));

        } catch (Exception e) {

            System.err.println("SQL Error:" + e.getMessage());
            return ("No se pudo crear la tabla");

        }

    }

    /**
     * Método que ejecuta una instruccion SQL
     *
     * @param consultaSQL es de tipo Stringy contiene la consulta en SQL
     * @return un tipo ResultSet que contiene la informacion sobre la consulta.
     */
    public static ResultSet ejecutarSQL(String consultaSQL) {

        try {

            return (jdbc.ejecutarSQL(consultaSQL));

        } catch (Exception e) {

            System.err.println("SQL Error:" + e.getMessage());
            return (null);

        }

    }

    /**
     * Método que ejecuta una consulta en SQL
     *
     * @param sql es de tipo String y contiene la consulta en sql
     * @return un tipo ArrayList y contiene la informacion que retorna la
     * consulta
     */
    public static java.util.ArrayList<String> getConsultaSQL(String sql) {

        try {

            return (jdbc.getSQL(sql));

        } catch (Exception e) {

            System.err.println("SQL Error:" + e.getMessage());
            return (null);

        }

    }

    /**
     * Metodo para ejecutar consultas parametrizadas en la base de datos
     *
     * @param String sql con la con la consulta parametrizada
     * @param Object[] param arreglo de tamaño igual al numero de ? en la
     * consulta parametrizada y en cada posición guarda el dato correspondiente.
     * @return boolean si es verdad que se pudo ejecutar la consulta
     */
    public static boolean ejecutarActualizacionSQL(String sql, Object[] param) {

        try {
            return (jdbc.ejecutarActualizacionSQL(sql, param));
        } catch (Exception e) {
            System.err.println("SQL error " + e.getMessage());
            return false;
        }
    }

}//Fin de la Clase
