/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_TablaModel;

import GUI_Presentacion.FormMateriales;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class TabalaModeloMaterial {

    public FormMateriales mater;
       
    public DefaultTableModel modelo;
    public String Dato;
    public int select;
    public ArrayList<String> lista = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public void tablaCionsulMaterial(JTable tabla, FormMateriales from) {
        try {
            mater = from;
            modelo = new DefaultTableModel() {
                private static final long serialVersionUID = 1L;

                @Override
                public boolean isCellEditable(int fila, int columna) {
                    if (columna == 6) {
                        return true;
                    } else {
                        return false;
                    }
                }
            };
            modelo.addColumn("Id");//0
            modelo.addColumn("Codigo");//
            modelo.addColumn("Linea");//
            modelo.addColumn("Grupo");//
            modelo.addColumn("Elemento");//
            modelo.addColumn("Descripició De Material");//            
            modelo.addColumn("Editar");//   
            ArrayList<String> lista = mater.getInicio().getMycontrol().ListaMaterial();
            if (lista != null) {
                for (String C : lista) {
                    Object[] fila = new Object[7];
                    fila[0] = C.split("_")[0];
                    fila[1] = C.split("_")[1];
                    fila[2] = C.split("_")[2];
                    fila[3] = C.split("_")[3];
                    fila[4] = C.split("_")[4];
                    fila[5] = C.split("_")[5];
                    fila[6] = "EDITAR";
                    modelo.addRow(fila);
                    
                }
            } else {
                String[] datos = {"", "NO HAY DATOS", ""};
                modelo.addRow(datos);

            }
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(700);
            tabla.getColumnModel().getColumn(6).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(6).setCellEditor(new ButoonEditor1(mater));//CAGO RL COMBOBOXT ALA COLUMANA QUE NECECITO
            tabla.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer1());
        } catch (Exception ex) {
            Logger.getLogger(TabalaModeloMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void tablaCionsulBuscarMaterial(JTable tabla, FormMateriales from) {
        try {
            mater = from;
            modelo = new DefaultTableModel() {
                private static final long serialVersionUID = 1L;

                @Override
                public boolean isCellEditable(int fila, int columna) {
                    if (columna == 6) {
                        return true;
                    } else {
                        return false;
                    }
                }
            };
            modelo.addColumn("Id");//0
            modelo.addColumn("Codigo");//
            modelo.addColumn("Linea");//
            modelo.addColumn("Grupo");//
            modelo.addColumn("Elemento");//
            modelo.addColumn("Descripició De Material");//            
            modelo.addColumn("Editar");//   
            ArrayList<String> lista = mater.getInicio().getMycontrol().BuscarListaMaterial(Dato, select);
            if (lista != null) {
                for (String C : lista) {
                    Object[] fila = new Object[7];
                    fila[0] = C.split("_")[0];
                    fila[1] = C.split("_")[1];
                    fila[2] = C.split("_")[2];
                    fila[3] = C.split("_")[3];
                    fila[4] = C.split("_")[4];
                    fila[5] = C.split("_")[5];
                    fila[6] = "EDITAR";
                    modelo.addRow(fila);
                }
            } else {
                String[] datos = {"", "NO HAY DATOS", ""};
                modelo.addRow(datos);

            }
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(700);
            tabla.getColumnModel().getColumn(6).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(6).setCellEditor(new ButoonEditor1(mater));//CAGO RL COMBOBOXT ALA COLUMANA QUE NECECITO
            tabla.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer1());
        } catch (Exception ex) {
            Logger.getLogger(TabalaModeloMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void TamañoCol(JTable tabla) {
//        tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(700);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(100);
    }
}
