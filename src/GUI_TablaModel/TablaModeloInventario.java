/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_TablaModel;

import GUI_Presentacion.Inicio;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author User
 */
public class TablaModeloInventario {

    public Inicio invent;
    public DefaultTableModel modelo;
    public String Dato;
    public int select, inicio, fin;
    public ArrayList<String> lista = new ArrayList<>();

    public void tablaCionsulInventaarioInicio(JTable tabla, Inicio from) {
        try {
            this.invent = from;
            modelo = new DefaultTableModel() {
                private static final long serialVersionUID = 1L;

                @Override
                public boolean isCellEditable(int fila, int columna) {
                    if (columna == 4) {
                        return true;
                    } else {
                        return false;
                    }
                }
            };
            modelo.addColumn("Codigo");//0
            modelo.addColumn("Descripción De Material");//
            modelo.addColumn("Cantidad En Existencia");//
            modelo.addColumn("Cantidad Retirado");//
            modelo.addColumn("Editar");//            
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(500);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(250);
            tabla.getColumnModel().getColumn(4).setCellEditor(new ButoonEditor(invent));//CAGO RL COMBOBOXT ALA COLUMANA QUE NECECITO
            tabla.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
        } catch (Exception ex) {
            Logger.getLogger(TabalaModeloMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void tablaCionsulInventaario(JTable tabla, Inicio from) {
        try {
            this.invent = from;
            modelo = new DefaultTableModel() {
                private static final long serialVersionUID = 1L;

                @Override
                public boolean isCellEditable(int fila, int columna) {
                    if (columna == 4) {
                        return true;
                    } else {
                        return false;
                    }
                }
            };
            modelo.addColumn("Codigo");//0
            modelo.addColumn("Nombre De Material");//
            modelo.addColumn("Cantidad En Existencia");//
            modelo.addColumn("Cantidad Retirado");//
            modelo.addColumn("Editar");//
            ArrayList<String> lista = invent.getMycontrol().ListaInventario(inicio, fin);

            if (lista != null) {
                for (String C : lista) {
                    Object[] fila = new Object[5];
                    fila[0] = C.split("_")[1];
                    fila[1] = C.split("_")[2];
                    fila[2] = C.split("_")[3];
                    fila[3] = C.split("_")[4];
                    fila[4] = "EDITAR";
                    modelo.addRow(fila);
                }
            } else {
                String[] datos = {"", "NO HAY DATOS", ""};
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(500);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(250);
            tabla.getColumnModel().getColumn(4).setCellEditor(new ButoonEditor(invent));//CAGO RL COMBOBOXT ALA COLUMANA QUE NECECITO
            tabla.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
        } catch (Exception ex) {
            Logger.getLogger(TabalaModeloMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void tablaCionsulBuscarInventaario(JTable tabla, Inicio from) {
        try {
            this.invent = from;
            modelo = new DefaultTableModel() {
                private static final long serialVersionUID = 1L;

                @Override
                public boolean isCellEditable(int fila, int columna) {
                    if (columna == 4) {
                        return true;
                    } else {
                        return false;
                    }
                }
            };
            modelo.addColumn("Codigo");//0
            modelo.addColumn("Nombre De Material");//
            modelo.addColumn("Cantidad En Existencia");//
            modelo.addColumn("Cantidad Retirado");//
            modelo.addColumn("Editar");//
            ArrayList<String> lista = invent.getMycontrol().BuscarListaInventario(Dato, select);
            if (lista != null) {
                for (String C : lista) {
                    Object[] fila = new Object[5];
                    fila[0] = C.split("_")[1];
                    fila[1] = C.split("_")[2];
                    fila[2] = C.split("_")[3];
                    fila[3] = C.split("_")[4];
                    fila[4] = "EDITAR";
                    modelo.addRow(fila);
                }
            } else {
                String[] datos = {"", "NO HAY DATOS", ""};
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(500);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(250);
            tabla.getColumnModel().getColumn(4).setCellEditor(new ButoonEditor(invent));//CAGO RL COMBOBOXT ALA COLUMANA QUE NECECITO
            tabla.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
        } catch (Exception ex) {
            Logger.getLogger(TabalaModeloMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void reiniciarJTable(JTable Tabla) {
        DefaultTableModel modelo = (DefaultTableModel) Tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        TableColumnModel modCol = Tabla.getColumnModel();
        while (modCol.getColumnCount() > 0) {
            modCol.removeColumn(modCol.getColumn(0));
        }
    }
}
