/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio_Util;

/**
 *
 * @author User
 */
public class Desconectar {

    public static void CerrarConeccion() {
        BaseDeDatosPescadero.desconectar();
        BDCompras.desconectar();
        BaseDeDatosBodega.desconectar();
        BaseDeDatosNovedades.desconectar();
        BaseDeDatosPeticiones.desconectar();
        System.out.println("Desconectado");
    }
}
