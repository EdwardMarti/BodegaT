/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_serviceLocator;

import Negocio.INegocio;
import Negocio.Negocio;

/**
 *
 * @author edward
 */

/**
 * *********************************************************************************************
 * Clase que une el NEGOCIO CON LA GUI 
 * *********************************************************************************************
 * @author Edward M
 */
public class ServiceLocator {

    private static ServiceLocator instance;
    private INegocio negocio;

    private ServiceLocator() throws Exception {       
        negocio = new Negocio();
        
    }

    public static ServiceLocator getInstance() throws Exception {
        if (instance == null) {
            instance = new ServiceLocator();
        }
        return instance;
    }

    public INegocio getBusinessFacadeInstance() {
        return negocio;
    }

}
