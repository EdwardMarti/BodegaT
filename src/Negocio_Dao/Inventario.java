package Negocio_Dao;

import Negocio_Util.BaseDeDatosBodega;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class Inventario {

    public static ArrayList<String> ListaMaterial() {
        ArrayList<String> lista = new ArrayList<>();
        try {
            String sql = null;
            ResultSet r = null;
            sql = "SELECT * FROM `material`  ";
            r = BaseDeDatosBodega.ejecutarSQL(sql);
            while (r.next()) {
                int Id = r.getInt("id");
                String Codigo = r.getString("codigo");
                int linea = r.getInt("linea");
                int Grupo = r.getInt("grupo");
                int Elemento = r.getInt("elemento");
                String Decripcion = r.getString("decripcion");
                String O = Id + "_" + Codigo + "_" + linea + "_" + Grupo + "_" + Elemento + "_" + Decripcion;
                lista.add(O);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            lista = null;
        }
        return lista;
    }

    public static ArrayList<String> BuscarListaMaterial(String Dato, int Select) {
        ArrayList<String> lista = new ArrayList<>();
        try {
            String sql = null;
            ResultSet r = null;
            switch (Select) {
                case 1:
                    Dato = Dato;
                    break;
                case 2:
                    Dato = IdDeMaterial(Dato);
                    break;
                case 3:
                    Dato = Dato;
                    break;
                default:
                    Dato = "0";
                    break;
            }
            sql = "SELECT * FROM `material` WHERE `codigo`='" + Dato + "'";
            r = BaseDeDatosBodega.ejecutarSQL(sql);
            while (r.next()) {
                int Id = r.getInt("id");
                String Codigo = r.getString("codigo");
                int linea = r.getInt("linea");
                int Grupo = r.getInt("grupo");
                int Elemento = r.getInt("elemento");
                String Decripcion = r.getString("decripcion");
                String O = Id + "_" + Codigo + "_" + linea + "_" + Grupo + "_" + Elemento + "_" + Decripcion;
                lista.add(O);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            lista = null;
        }
        return lista;
    }

    public static String NombreDeMaterial(String Idmaterial) {
        try {
            String nombre = null;
            String sql = "SELECT `decripcion` FROM `material` WHERE `codigo`='" + Idmaterial + "'";
            ResultSet l = BaseDeDatosBodega.ejecutarSQL(sql);
            while (l.next()) {
                nombre = (l.getString("decripcion"));
            }
            return nombre;

        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static String IdDeMaterial(String Material) {
        try {
            String nombre = null;
            String sql = "SELECT `codigo` FROM `material` WHERE `decripcion`='" + Material + "'";
            ResultSet l = BaseDeDatosBodega.ejecutarSQL(sql);
            System.out.println(sql);
            while (l.next()) {
                nombre = (l.getString("codigo"));
            }

            return nombre;
        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static ArrayList<String> ListaInventario(int inico, int fin) {
        ArrayList<String> lista = new ArrayList<>();
        try {
            String sql = null;
            ResultSet r = null;
            sql = "SELECT * FROM `inventario`  LIMIT " + inico + "," + fin + "";
//            System.out.println("sql " + sql);
            r = BaseDeDatosBodega.ejecutarSQL(sql);
            while (r.next()) {
                int Id = r.getInt("id");
                String Material = r.getString("codigo");
                int Existencia = r.getInt("existencia");
                int Retirado = r.getInt("retirado");
                String material = NombreDeMaterial(Material);
                String O = Id + "_" + Material + "_" + material + "_" + Existencia + "_" + Retirado;
                lista.add(O);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            lista = null;
        }
        return lista;
    }

    public static ArrayList<String> BuscarListaInventario(String Dato, int Select) {
        ArrayList<String> lista = new ArrayList<>();
        try {
            String sql = null;
            ResultSet r = null;
            switch (Select) {
                case 1:
                    Dato = Dato;
                    break;
                case 2:
                    Dato = IdDeMaterial(Dato);
                    break;
                case 3:
                    Dato = Dato;
                    break;
                default:
                    Dato = "0";
                    break;
            }
            sql = "SELECT * FROM `inventario` WHERE `codigo`='" + Dato + "'";
            r = BaseDeDatosBodega.ejecutarSQL(sql);
            System.out.println(sql);
            while (r.next()) {
                int Id = r.getInt("id");
                String Material = r.getString("codigo");
                int Existencia = r.getInt("existencia");
                int Retirado = r.getInt("retirado");
                String material = NombreDeMaterial(Material);
                String O = Id + "_" + Material + "_" + material + "_" + Existencia + "_" + Retirado;
                lista.add(O);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            lista = null;
        }
        return lista;
    }

    public static boolean editarInventario(String MaterialN, String MaterialA, int Existencia, int Retirado) {
        String Id = IdDeMaterial(MaterialA);
        editarNombremater(MaterialN, MaterialA);
        String sql = "UPDATE `inventario` SET `existencia`='" + Existencia + "',`retirado`= '" + Retirado + "'WHERE `codigo`='" + Id + "'";
        boolean rpta = BaseDeDatosBodega.ejecutarActualizacionSQL(sql);
        return rpta;
    }

    public static boolean editarNombremater(String MaterialN, String MaterialA) {
        String sql = "UPDATE  `material` SET `decripcion`='" + MaterialN + "' WHERE `decripcion`='" + MaterialA + "'";
        boolean rpta = BaseDeDatosBodega.ejecutarActualizacionSQL(sql);
        return rpta;
    }

    public static boolean editarMaterial(String Codigo, int Linea, int Grupo, int Elemento, String Decripcion, int Id) {
        String sql = " UPDATE `material` SET `codigo`='" + Codigo + "',`linea`='" + Linea + "',`grupo`='" + Grupo + "',`elemento`='" + Elemento + "',`decripcion`='" + Decripcion + "' WHERE `id`='" + Id + "'";
        boolean rpta = BaseDeDatosBodega.ejecutarActualizacionSQL(sql);

        return rpta;
    }

    public static ArrayList<String> llenarProduct() {
        try {
            ArrayList<String> lista = new ArrayList<>();
            String sql;
            sql = "SELECT `decripcion` FROM `material` GROUP BY `decripcion` ORDER BY `decripcion` ASC";
            ResultSet Rc = BaseDeDatosBodega.ejecutarSQL(sql);
            while (Rc.next()) {
                lista.add(Rc.getString("decripcion"));
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static int maxMaterial() {
        try {
            int cad = 0;
            String consulta = "SELECT MAX(`id`)AS 'max'  FROM `material`";
            ResultSet r = BaseDeDatosBodega.ejecutarSQL(consulta);
            while (r.next()) {
                cad = r.getInt("max");
            }
            if (cad != 0) {
                return cad;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 0;
    }

    public static int maxInventario() {
        try {
            int cad = 0;
            String consulta = "SELECT MAX(`id`)AS 'max'  FROM `inventario`";
            ResultSet r = BaseDeDatosBodega.ejecutarSQL(consulta);
            while (r.next()) {
                cad = r.getInt("max");
            }
            if (cad != 0) {
                return cad;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 0;
    }

    public static boolean verificarMaterialExixte(String codigo) {
        String cad = null;
        try {
            String sql = "SELECT `codigo`  FROM `material` WHERE `codigo` ='" + codigo + "'";
            ResultSet r = BaseDeDatosBodega.ejecutarSQL(sql);
            while (r.next()) {
                cad = r.getString("codigo");
            }
            if (cad != null) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }

    public static boolean verificarMaterialExixteInventario(String Codigo) {
        String cad = null;
        try {
            String sql = "SELECT`codigo`FROM `inventario` WHERE `codigo`='" + Codigo + "'";
            ResultSet r = BaseDeDatosBodega.ejecutarSQL(sql);
            while (r.next()) {
                cad = r.getString("codigo");
            }
            if (cad != null) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }

    public static boolean registrarNuevoMaterial(String Codigo, int Codigo1, int Codigo2, int Codigo3, String Nombre) {
        if (verificarMaterialExixte(Codigo)) {
            return false;
        }
        String sql = "INSERT INTO `material`(`codigo`, `linea`, `grupo`, `elemento`, `decripcion`) "
                + "VALUES ('" + Codigo + "','" + Codigo1 + "','" + Codigo2 + "','" + Codigo3 + "','" + Nombre + "')";
        boolean rpta = BaseDeDatosBodega.ejecutarActualizacionSQL(sql);
        registrarNuevoMaterialInventario(Codigo);
        return rpta;
    }

    public static boolean registrarNuevoMaterialInventario(String Codigo) {
        if (verificarMaterialExixteInventario(Codigo)) {
            return false;
        }
        int codigo = 100000;
        String sql = "INSERT INTO `inventario`(`codigo`, `existencia`, `retirado`)"
                + "VALUES ('" + Codigo + "','" + codigo + "','" + codigo + "')";
        boolean rpta = BaseDeDatosBodega.ejecutarActualizacionSQL(sql);
        return rpta;
    }

    public static boolean eliminarMaterialInventario(String Idmaterial) {
        String sql = "DELETE FROM `inventario`  WHERE `codigo`='" + Idmaterial + "'";
        boolean rpta = BaseDeDatosBodega.ejecutarActualizacionSQL(sql);
        eliminarMaterialInventario1(Idmaterial);
        CuadrarAutoincremnet();
        return rpta;
    }

    public static boolean CuadrarAutoincremnet() {
        int maxMaterial = maxMaterial();
        String sql = "ALTER TABLE `inventario` AUTO_INCREMENT=" + maxMaterial + "";
        boolean rpta = BaseDeDatosBodega.ejecutarActualizacionSQL(sql);
        return rpta;
    }

    public static boolean eliminarMaterialInventario1(String Idmaterial) {
        String sql = "DELETE FROM `material`  WHERE `codigo`= '" + Idmaterial + "'";
        boolean rpta = BaseDeDatosBodega.ejecutarActualizacionSQL(sql);
        CuadrarAutoincremnet1();
        return rpta;
    }

    public static boolean CuadrarAutoincremnet1() {
        int maxMaterial = maxMaterial();
        String sql = "ALTER TABLE `material` AUTO_INCREMENT=" + maxMaterial + ";";
        boolean rpta = BaseDeDatosBodega.ejecutarActualizacionSQL(sql);
        return rpta;
    }

///////////////////*/preguntar si no borrar
    public static boolean registrarControl(String Accion, String Cambiado, String Fecha) {
        String dat = null;
        if (dat == null) {
            String sql = "INSERT INTO `control`(`accion`, `cambiado`, `fecha`) VALUES ('" + Accion + "','" + Cambiado + "','" + Fecha + "')";
            boolean rpta = BaseDeDatosBodega.ejecutarActualizacionSQL(sql);
            return rpta;
        }
        return false;
    }
}
