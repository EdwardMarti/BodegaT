/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_TablaModel;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author User
 */
@SuppressWarnings("serial")
public class ButtonRenderer1 extends JButton implements TableCellRenderer {

    private Gui_DefaultProperties.Propiedades defaul = new Gui_DefaultProperties.Propiedades();

    public ButtonRenderer1() {
        setOpaque(true);
        defaul.PropiedadesButton(this, 2);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
      if (row % 2 == 0) {
            setBackground(new Color(226, 226, 226));
            setForeground(Color.black);             
        } else {
            setBackground(Color.white);
            setForeground(Color.black);
        }
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());           
        } 
        else {
            setForeground(table.getForeground());
            setForeground(table.getBackground());
            setBackground(UIManager.getColor("CheckBox.background"));            
        }
        defaul.PropiedadesButton(this, 2);
        setText((value == null) ? "" : value.toString());
        return this;
    }
}
