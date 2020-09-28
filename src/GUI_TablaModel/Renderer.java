package GUI_TablaModel;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Unknown
 */
@SuppressWarnings("serial")
public class Renderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (row % 2 == 0) {
            setBackground(new Color(226, 226, 226));
            setForeground(Color.black);
        } else {
            setBackground(Color.white);
            setForeground(Color.black);
        }

        table.getTableHeader().setReorderingAllowed(false);//no permite reordenarlas columnaaas
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }

}
