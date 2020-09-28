/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_TablaModel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author jorge
 */
@SuppressWarnings("serial")
public class RenderCavecera {

    public static JTable cambiarCabezera(JTable table) {
        Border myRaisedBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null);
        DefaultTableCellRenderer ren = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        ren.setAutoscrolls(true);
        ren.setBorder(myRaisedBorder);
        ren.setPreferredSize(new Dimension(0, 40));
        ren.setHorizontalAlignment(0);
        ren.setVerticalAlignment(0);
        table.getTableHeader().setDefaultRenderer(ren);//cabie el render de la cabezera
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));//estilos de letra,estilo,tamaño texto encavezados 
        table.getTableHeader().setReorderingAllowed(false);
//        table.getTableHeader().setBackground(new Color(159, 190, 245));
        return table;
    }

}
