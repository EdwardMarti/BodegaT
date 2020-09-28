/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_TablaModel;

import GUI_Presentacion.FormEditarInventario;
import GUI_Presentacion.Inicio;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ButoonEditor extends DefaultCellEditor {

    protected JButton boton;
    private Inicio formulario;
    private Gui_DefaultProperties.Propiedades defaul = new Gui_DefaultProperties.Propiedades();
    public static boolean noabre = false;

    public ButoonEditor(Inicio form) {
        super(new JCheckBox());
        formulario = form;
        boton = new JButton();
        defaul.PropiedadesButton(boton, 2);
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (noabre == false) {
                        FormEditarInventario abrir = new FormEditarInventario(formulario);
                        int fila = formulario.DtbInventario.getSelectedRow();
                        abrir.Nombre = formulario.DtbInventario.getValueAt(fila, 1).toString().trim();
                        abrir.txtNomMaterial.setText(formulario.DtbInventario.getValueAt(fila, 1).toString().trim());
                        abrir.txtCantiadExis.setText(formulario.DtbInventario.getValueAt(fila, 2).toString().trim());
                        abrir.txtCantiDadEntre.setText(formulario.DtbInventario.getValueAt(fila, 3).toString().trim());
                        abrir.txtCantiDadEntre.setRequestFocusEnabled(true);
                        abrir.txtNomMaterial.setRequestFocusEnabled(true);
                        abrir.txtCantiadExis.setRequestFocusEnabled(true);
                        abrir.setVisible(true);
                        noabre = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "No Sé  Puede Mostrar La Ventana, Ya Existe Una Ventana Abierta!!!");
                    }

                } catch (Exception ex) {
                    Logger.getLogger(ButoonEditor.class.getName()).log(Level.SEVERE, null, ex);
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
