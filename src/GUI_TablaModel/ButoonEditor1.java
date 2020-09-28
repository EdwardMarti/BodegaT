/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_TablaModel;

import GUI_Presentacion.FormEditarMaterial;
import GUI_Presentacion.FormMateriales;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;

/**
 *
 * @author User
 */
@SuppressWarnings("serial")
public class ButoonEditor1 extends DefaultCellEditor {

    protected JButton boton;
    private FormMateriales formulario;
    public static boolean noabre = false;
    private Gui_DefaultProperties.Propiedades defaul = new Gui_DefaultProperties.Propiedades();

    public ButoonEditor1(FormMateriales form) {
        super(new JCheckBox());
        formulario = form;
        boton = new JButton();
        defaul.PropiedadesButton(boton, 2);
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (noabre == false) {
                        FormEditarMaterial abrir = new FormEditarMaterial(formulario);
                        int fila = formulario.DtbMaterial.getSelectedRow();
                        abrir.Id = Integer.valueOf(formulario.DtbMaterial.getValueAt(fila, 0).toString().trim());                      
                        abrir.Nombre = formulario.DtbMaterial.getValueAt(fila, 5).toString().trim();
                        abrir.txtNomMaterial.setText(formulario.DtbMaterial.getValueAt(fila, 5).toString().trim());
                        abrir.txtCodMater.setText(formulario.DtbMaterial.getValueAt(fila, 1).toString().trim());
                        abrir.txtLinea.setText(formulario.DtbMaterial.getValueAt(fila, 2).toString().trim());
                        abrir.txtGrupo.setText(formulario.DtbMaterial.getValueAt(fila, 3).toString().trim());
                        abrir.txtElemento.setText(formulario.DtbMaterial.getValueAt(fila, 4).toString().trim());
                        abrir.txtNomMaterial.setRequestFocusEnabled(true);
                        abrir.txtCodMater.setRequestFocusEnabled(true);
                        abrir.setVisible(true);
                        noabre = true;                        
                    } else {
                        JOptionPane.showMessageDialog(null, "No Sé  Puede Mostrar La Ventana, Ya Existe Una Ventana Abierta!!!");
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
//                    Logger.getLogger(ButoonEditor1.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        boton.setText((String) value);
        if (isSelected) {
            boton.setForeground(table.getSelectionForeground());
            boton.setBackground(table.getSelectionBackground());
        } else {
            boton.setForeground(table.getForeground());
            boton.setBackground(UIManager.getColor("Button.background"));
        }
        defaul.PropiedadesButton(boton, 2);
        return boton;
    }

    public Object getCellEditorValue() {
        return boton.getText();
    }

}
