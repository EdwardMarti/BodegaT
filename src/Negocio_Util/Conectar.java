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
public class Conectar {

    public static void AbrirConeccion() {
        BaseDeDatosPescadero.asignarip();
        BDCompras.asignarip1();
        BaseDeDatosBodega.asignarip();
        BaseDeDatosPeticiones.asignarip();
        BaseDeDatosNovedades.asignarip();
        BaseDeDatosPescadero.conectar();
        BDCompras.conectar();
        BaseDeDatosBodega.conectar();
        BaseDeDatosNovedades.conectar();
        BaseDeDatosPeticiones.conectar();
        System.out.println("Conectado");
    }
}
