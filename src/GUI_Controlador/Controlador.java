/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Controlador;

import Gui_serviceLocator.ServiceLocator;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Controlador implements IControlador {

    private ServiceLocator serviceLocator;

    public ArrayList<String> ListaMaterial() throws Exception {
        return this.serviceLocator.getInstance().getBusinessFacadeInstance().ListaMaterial();
    }

    public ArrayList<String> BuscarListaMaterial(String Dato, int Select) throws Exception {
        return this.serviceLocator.getInstance().getBusinessFacadeInstance().BuscarListaMaterial(Dato, Select);
    }

    public String NombreDeMaterial(String Idmaterial) throws Exception {
        return this.serviceLocator.getInstance().getBusinessFacadeInstance().NombreDeMaterial(Idmaterial);
    }

    public ArrayList<String> ListaInventario(int inicio, int fin) throws Exception {
        return this.serviceLocator.getInstance().getBusinessFacadeInstance().ListaInventario(inicio, fin);
    }

    public ArrayList<String> BuscarListaInventario(String Dato, int Select) throws Exception {
        return this.serviceLocator.getInstance().getBusinessFacadeInstance().BuscarListaInventario(Dato, Select);
    }

    public String editarInventario(String MaterialN, String MaterialA, int Existencia, int Retirado) throws Exception {
        return this.serviceLocator.getInstance().getBusinessFacadeInstance().editarInventario(MaterialN, MaterialA, Existencia, Retirado);
    }

    public String editarNombremater(String MaterialN, String MaterialA) throws Exception {
        return this.serviceLocator.getInstance().getBusinessFacadeInstance().editarNombremater(MaterialN, MaterialA);
    }

    public String editarMaterial(String Codigo, int Linea, int Grupo, int Elemento, String Decripcion, int Id) throws Exception {
        return this.serviceLocator.getInstance().getBusinessFacadeInstance().editarMaterial(Codigo, Linea, Grupo, Elemento, Decripcion, Id);
    }

    public String registrarNuevoMaterial(String Codigo, int Codigo1, int Codigo2, int Codigo3, String Nombre) throws Exception {
        return this.serviceLocator.getInstance().getBusinessFacadeInstance().registrarNuevoMaterial(Codigo, Codigo1, Codigo2, Codigo3, Nombre);
    }

    public String registrarNuevoMaterialInventario(String Codigo) throws Exception {
        return this.serviceLocator.getInstance().getBusinessFacadeInstance().registrarNuevoMaterialInventario(Codigo);
    }

    public String eliminarMaterialInventario(String Idmaterial) throws Exception {
        return this.serviceLocator.getInstance().getBusinessFacadeInstance().eliminarMaterialInventario(Idmaterial);
    }
    ///////////////////*/preguntar si no borrar

    public String registrarControl(String Accion, String Cambiado, String Fecha) throws Exception {
        return this.serviceLocator.getInstance().getBusinessFacadeInstance().registrarControl(Accion, Cambiado, Fecha);
    }

    public int maxMaterial() throws Exception {
        return this.serviceLocator.getInstance().getBusinessFacadeInstance().maxMaterial();
    }

    public int maxInventario() throws Exception {
        return this.serviceLocator.getInstance().getBusinessFacadeInstance().maxInventario();
    }
}
