/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Controlador;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public interface IControlador {

    public ArrayList<String> ListaMaterial() throws Exception;

    public ArrayList<String> BuscarListaMaterial(String Dato, int Select) throws Exception;

    public String NombreDeMaterial(String Idmaterial) throws Exception;

    public ArrayList<String> ListaInventario(int inicio, int fin) throws Exception;

    public ArrayList<String> BuscarListaInventario(String Dato, int Select) throws Exception;

    public String editarInventario(String MaterialN, String MaterialA, int Existencia, int Retirado) throws Exception;

    public String editarNombremater(String MaterialN, String MaterialA) throws Exception;

    public String editarMaterial(String Codigo, int Linea, int Grupo, int Elemento, String Decripcion, int Id) throws Exception;

    public String registrarNuevoMaterial(String Codigo, int Codigo1, int Codigo2, int Codigo3, String Nombre) throws Exception;

    public String registrarNuevoMaterialInventario(String Codigo) throws Exception;

    public String eliminarMaterialInventario(String Idmaterial) throws Exception;
///////////////////*/preguntar si no borrar

    public String registrarControl(String Accion, String Cambiado, String Fecha) throws Exception;

    public int maxMaterial() throws Exception;

    public int maxInventario() throws Exception;
}
