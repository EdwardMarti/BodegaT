package Negocio_Util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sadalsuud
 */
/**
 * Un objeto JDBCMiddler permite abstraer cualquier conexion JDBC. Entonces
 * permite conectar con una Base De datos Mysql; sin embargo, con solo cambiar
 * el atributo controlador puede usarse para cualquier motor de base de datos La
 * conexion a una base de datos con JDBC requiere dos pasos fundamentales: 1.
 * Registrar el controlador 2. Establecer la conexion Para esto es necesario
 * tener los controladores, la URL de recurso de base de datos, el usuario y su
 * clave. Esta clase permite encapsular todo el trabajo y la informacion de una
 * Base de Datos, en un unico objeto dentro de una aplicacion.
 *
 * @param <T> Se generaliza para poder regresar listas del tipo de objetos que
 * se le indique.
 */
public class JDBCM<T> {

    /**
     * Nombre de la base de datos.
     */
    private final String bd = "ufps_11";

    /**
     * Usuario por el cuál se conecta a la base de datos.
     */
    private final String usuario = "ufps_11";

    /**
     * Contraseña del usuario para conectarse a la base de datos.
     */
    private final String clave = "ufps_90";

    /**
     * Un controlador, es uno distinto para cada tipo de base de datos, este
     * está inicializado para una base de datos mysentencia.
     */
    private final String controlador = "com.mysql.jdbc.Driver";

    /**
     * Una cadena con la ubicacion del recurso de base de datos en la forma
     * protocolo:subprotocolo:nombrerecurso. Y permite el uso con consultas
     * parametrizadas.
     */
    //private final String url = "jdbc:mysql://sandbox2.ufps.edu.co/" + bd + "?useServerPrepStmts=true";
    private final String url = "jdbc:mysql://localhost:3306/" + bd + "?useServerPrepStmts=true";
    /**
     * Una referencia al objeto Connection de la base de datos.
     */
    protected Connection conexion;

    /**
     * Crea un objeto JDBCMiddler vacio sin parametros de conexion. Constructor
     * por defecto.
     */
    public JDBCM() {
    }

    //  - H A C E R  C O N E X I O N  ->  
    /**
     * Averigua si la conexion con la Base de Datos está disponible.
     *
     * @return	Regresa verdadero (true) si la conexion está disponible. La
     * conexión está disponible cuando conexión != null y !conexión.isClosed()
     */
    public boolean hayConexion() {
        return this.conexion != null;
    }

    /**
     * Establece una conexion con la base de datos, usando el usuario y clave
     * especificados. Si ya hay una conexion, esta es cerrada.
     *
     * @return	Regresa verdadero (true) si pudo establecer la conexion de lo
     * contrario regresa falso (false).
     */
    private boolean conectar() {

        try {
            //Registra el controlador de manera implicita
            System.out.println(this.url);
            Class.forName(this.controlador).newInstance();
            //Obtiene la conexion
            System.err.println(this.url + "," + this.usuario + "," + this.clave + ":ON!!!");
            try {
                this.conexion = DriverManager.getConnection(this.url, this.usuario, this.clave);
            } catch (SQLException ex) {
                Logger.getLogger(JDBCM.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(JDBCM.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.conexion != null;
    }

    /**
     * Cierra la conexion con la base de datos
     *
     */
    private void desconectar() {
        if (this.hayConexion()) {
            try {
                this.conexion.close();
                this.conexion = null;
            } catch (SQLException ex) {
                Logger.getLogger(JDBCM.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.err.println(url + "," + usuario + "," + clave + ":OFF!!!");
        }
    }

    // - C O N S U L T A R -> 
    /**
     * Ejecuta una sentencia SQL y regresa como resultado una lista con el tipo
     * de dato
     *
     * @param	consultaSQL	Cadena que contiene una sentencia de consulta SQL:
     * SELECT listaCampos FROM listaTablas WHERE listaCondiciones
     * @param clase que deben ser los objetos de la lista.
     * @return	Regresa una lista de objetos con el resultado de la consulta
     * @throws java.lang.Exception
     */
    public List<T> ejecutarSQL(String consultaSQL, Class clase) throws Exception {
        return this.ejecutarSQL(consultaSQL, null, clase);
    }

    public boolean ejecutarActualizacionSQL(String comandoSQL) throws Exception {
        return this.ejecutarActualizacionSQL(comandoSQL, null);
    }

    //  ==  C O N S U L T A S  P A R A M E T R I Z A D A S ==
    /**
     * Ejecuta una sentencia SQL. La sentencia requiere de arametros en tiempo
     * de ejecucion. La consulta es preparada porque requiere de parametros por
     * ejemplo: delete from producto where precio=? insert into producto values
     * (?,?,?,?,?) los ? indican parametros ordenados por posicion
     *
     * @param comandoSQL Cadena que contiene una sentencia
     * @param param Object[] Un arreglo de parametros de la consulta sentencia.
     * @return	falso o verdadero si pudo ejecutar la consulta
     * @throws java.lang.Exception
     */
    // modificarRegistros
    public boolean ejecutarActualizacionSQL(String comandoSQL, Object[] param) throws Exception {

        boolean ok;
        if (this.conectar()) {
            try (PreparedStatement sql = this.conexion.prepareStatement(comandoSQL)) {
                if (param != null) {    // carga los parametros en la consulta
                    cargarParametros(sql, param);
                }
                ok = sql.executeUpdate() != 0;
            }
            this.desconectar();
            return ok;
        }
        return false;
    }

    /**
     * Ejecuta una sentencia SQL y regresa como resultado una lista con el tipo
     * de objetos que se pasaron como parametro.
     *
     * @param consultaSQL consultaSQL Cadena que contiene una sentencia de
     * consulta SQL SELECT listaCampos FROM listaTablas WHERE listaCondiciones
     * @param param Object[] Un arreglo de parametros de la consulta sentencia.
     * @param clase
     * @return	Una lista de objetos con el resultado de la consulta
     * @throws java.lang.Exception
     */
    //  seleccionarRegistros
     @SuppressWarnings("unchecked")
    public List<T> ejecutarSQL(String consultaSQL, Object[] param, Class clase) throws Exception {

        ResultSet rs = null;
        List<T> listaDeObjetos = new ArrayList<>();
        if (this.conectar()) {
            PreparedStatement sentencia = this.conexion.prepareStatement(consultaSQL);
            if (param != null) {
                cargarParametros(sentencia, param);
            }
            rs = sentencia.executeQuery();
            try {
                @SuppressWarnings("UnusedAssignment")
                String dato = "";

                while (rs.next()) {
                    T objeto;
                    objeto = (T) Class.forName(clase.getName()).newInstance();
                    Method[] metodos = objeto.getClass().getDeclaredMethods();
                    for (Method metodo : metodos) {
                        // supone que los atributos del dto se llaman igual a los campos de la tabla 
                        if (metodo.getName().startsWith("set")) {

                            Class<?>[] tipo = metodo.getParameterTypes();
                            switch (tipo[0].getName()) {
                                case "int":
                                    int datoInt = rs.getInt(metodo.getName().substring(3));
                                    metodo.invoke(objeto, datoInt);
                                    break;
                                case "java.lang.String":
                                    dato = rs.getString(metodo.getName().substring(3));
                                    metodo.invoke(objeto, dato);
                                    break;
                            }
                        }
//                        // no entiendo muy bien qué hace esta linea
//                            if (objeto.getClass().getName().equals("java.lang.String")) {
//                                objeto = (T) rs.getString(1);
//                            }
                    }
                    listaDeObjetos.add(objeto);
                }
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | SecurityException | InvocationTargetException | SQLException e) {
                System.err.println("Error al seleccionar registros -> " + e.toString());
            } finally {
                if (sentencia != null) {
                    try {
                        sentencia.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                }
                if (this.conexion != null) {
                    this.desconectar();
                }
            }
        }
        return listaDeObjetos;
    }

    // -  V A R I O S ->
    /**
     * Método para asignarle los valores correspondientes a los ? de la consulta
     * precompilada
     *
     * @param sql PreparedStatement la consulta precompilada
     * @param parametros Object[] arreglo con los valores de los parametros
     * @throws java.lang.Exception
     */
    private void cargarParametros(PreparedStatement sql, Object[] parametros) throws Exception {
        /*
         Hay que tener en cuenta cuando se envié dentro del arreglo de 
         parametros un valor null, la pregunta es si en algún momento se quiere
         que un campo de una tabla sea null.... 
         */
        String clase;
        for (int i = 1; i <= parametros.length; i++) {

            clase = parametros[i - 1].getClass().getName();   // nombre de la clase
            switch (clase) {
                case "java.lang.String":
                    sql.setString(i, (String) parametros[i - 1]);
                    break;
                case "java.lang.Integer":
                    sql.setInt(i, (Integer) parametros[i - 1]);
                    break;
                case "java.lang.Float":
                    sql.setFloat(i, (Float) parametros[i - 1]);
                    break;
            }
        }
    }

    /*
     * M E T O D O S  D E  A C C E S O -
     */
    public String getUsuario() {
        return this.usuario;
    }

    public String getClave() {
        return this.clave;
    }

    public String getUrl() {
        return this.url;
    }

    public String getControlador() {
        return this.controlador;
    }
}
