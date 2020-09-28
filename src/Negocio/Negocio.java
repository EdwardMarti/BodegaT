/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Negocio_Dao.Inventario;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Negocio implements INegocio {

    public ArrayList<String> ListaMaterial() throws Exception {
        return Inventario.ListaMaterial();
    }

    public ArrayList<String> BuscarListaMaterial(String Dato, int Select) throws Exception {
        return Inventario.BuscarListaMaterial(Dato, Select);
    }

    public String NombreDeMaterial(String Idmaterial) throws Exception {
        return Inventario.NombreDeMaterial(Idmaterial);
    }

    public ArrayList<String> ListaInventario(int inicio, int fin) throws Exception {
        return Inventario.ListaInventario(inicio, fin);
    }

    public ArrayList<String> BuscarListaInventario(String Dato, int Select) throws Exception {
        return Inventario.BuscarListaInventario(Dato, Select);
    }

    public String editarInventario(String MaterialN, String MaterialA, int Existencia, int Retirado) throws Exception {
        String cad = "";
        if (Inventario.editarInventario(MaterialN, MaterialA, Existencia, Retirado)) {
            cad = "OK";
        } else {
            cad = "ERROR";
        }
        return cad;
    }

    public String editarNombremater(String MaterialN, String MaterialA) throws Exception {
        String cad = "";
        if (Inventario.editarNombremater(MaterialN, MaterialA)) {
            cad = "OK";
        } else {
            cad = "ERROR";
        }
        return cad;
    }

    public String editarMaterial(String Codigo, int Linea, int Grupo, int Elemento, String Decripcion, int Id) throws Exception {
        String cad = "";
        if (Inventario.editarMaterial(Codigo, Linea, Grupo, Elemento, Decripcion, Id)) {
            cad = "OK";
        } else {
            cad = "ERROR";
        }
        return cad;
    }

    public String registrarNuevoMaterial(String Codigo, int Codigo1, int Codigo2, int Codigo3, String Nombre) throws Exception {
        String cad = "";
        if (Inventario.registrarNuevoMaterial(Codigo, Codigo1, Codigo2, Codigo3, Nombre)) {
            cad = "OK";
        } else {
            cad = "ERROR";
        }
        return cad;
    }

    public String registrarNuevoMaterialInventario(String Codigo) throws Exception {
        String cad = "";
        if (Inventario.registrarNuevoMaterialInventario(Codigo)) {
            cad = "OK";
        } else {
            cad = "ERROR";
        }
        return cad;
    }

    public String eliminarMaterialInventario(String Idmaterial) throws Exception {
        String cad = "";
        if (Inventario.eliminarMaterialInventario(Idmaterial)) {
            cad = "OK";
        } else {
            cad = "ERROR";
        }
        return cad;
    }

    ///////////////////*/preguntar si no borrar
    public String registrarControl(String Accion, String Cambiado, String Fecha) throws Exception {
        String cad = "";
        if (Inventario.registrarControl(Accion, Cambiado, Fecha)) {
            cad = "OK";
        } else {
            cad = "ERROR";
        }
        return cad;
    }

    public int maxMaterial() throws Exception {
        return Inventario.maxMaterial();
    }
     public int maxInventario() throws Exception {       
        return Inventario.maxInventario();
    }
}
