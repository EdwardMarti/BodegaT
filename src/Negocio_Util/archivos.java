package Negocio_Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class archivos {

    public String texto = "";

    public String leerTxt(String direccion) { //direccion del archivo

        String texto = "";

        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                //haz el ciclo, mientras bfRead tiene datos
                temp = temp + bfRead; //guardado el texto del archivo
            }

            texto = temp;

        } catch (Exception e) {
            System.err.println("No se encontro archivo");
        }

        return texto;

    }

    public void Escribir(String direccion) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            String db = direccion;
            fichero = new FileWriter(db);
            pw = new PrintWriter(fichero);
            for (int i = 0; i < 1; i++) {
                pw.println(texto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
