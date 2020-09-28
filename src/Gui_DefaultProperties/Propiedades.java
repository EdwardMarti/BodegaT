/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_DefaultProperties;

import GUI_TablaModel.RenderCavecera;
import GUI_TablaModel.Renderer;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import org.jdesktop.swingx.border.DropShadowBorder;

/**
 *
 * @author User
 */
public class Propiedades {

    public Color relieve = new Color(178, 216, 255);
    public Color fondo = new Color(176, 196, 222);

    /**
     *
     * @param from
     * @param val
     */
    public static void PropiedadesForm(JFrame from, int val) {
        try {
            from.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("OptionPane.font", new Font("Segoe UI", Font.BOLD, 15));//fuente de caja de mensaje
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 15));//fuente del mensaje
            UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.BOLD, 15));//fuente de boton de caja de mensaje
            from.setFont(new Font("Segoe UI", Font.BOLD, 15));
            from.getContentPane().setBackground(new Color(176, 196, 222));
            from.setAlwaysOnTop(false);
            Image ico = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("GUI_Img/Pescadero64x64.png"));
            from.setIconImage(ico);//implementamos la clase iconoy cambiamos el icono por defecto   
            switch (val) {
                case 1:
                    from.setSize(new Dimension(800, 600));
                    from.setMinimumSize(new Dimension(800, 600));
                    from.setLocationRelativeTo(null);//centra el formulario en el centro de la pantalla
                    break;
                case 2:
                    from.setExtendedState(from.MAXIMIZED_BOTH); //abre la ventana maximisada 
                    break;
                case 3:
                    from.setSize(new Dimension(800, 600));
                    from.setMinimumSize(new Dimension(800, 600));
                    from.setResizable(false);
                    from.setLocationRelativeTo(null);//centra el formulario en el centro de la pantalla 
                    break;
                case 4:
                    Point newLocation1 = new Point(10, 10);//parte superiorderecha
                    from.setLocation(newLocation1);
                    from.setResizable(false);
                    break;
                case 5:
                    Point newLocation2 = new Point(450, 10);//parte superiorderecha
                    from.setLocation(newLocation2);
                    from.setResizable(false);
                    break;
                case 6:
                    from.setExtendedState(from.MAXIMIZED_BOTH); //abre la ventana maximisada 
                    from.setSize(new Dimension(800, 600));
                    from.setMinimumSize(new Dimension(800, 600));
                    from.getContentPane().setBackground(new Color(225, 225, 225));
                    break;
                case 7:
                    //                                     from.setResizable(false);

                    from.setSize(new Dimension(800, 600));
                    from.setMinimumSize(new Dimension(800, 600));
                    from.setLocationRelativeTo(null);//centra el formulario en el centro de la pantalla
                    from.getContentPane().setBackground(new Color(225, 225, 225));
                    break;
                case 8:
                    from.setResizable(false);
                    from.setLocationRelativeTo(null);//centra el formulario en el centro de la pantalla
                    from.getContentPane().setBackground(new Color(225, 225, 225));
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     * @param internalform
     * @param val
     */
    public static void PropiedadesInternalFormMaximisado(JInternalFrame internalform, int val) {
        try {
            DropShadowBorder shadow = new DropShadowBorder();
            shadow.setCornerSize(15);
            shadow.setShadowColor(new Color(178, 216, 255));
            shadow.setShadowOpacity((float) 0.5);
            shadow.setShadowSize(10);
            shadow.setShowBottomShadow(true);
            shadow.setShowLeftShadow(true);
            shadow.setShowRightShadow(true);
            shadow.setShowTopShadow(true);
            ImageIcon ico = new ImageIcon(ClassLoader.getSystemResource("GUI_Img/Pescadero64x64.png")); //creamos la clase icono y la direccion donde se encuentra //          
            internalform.setFrameIcon(ico);//implementamos la clase icono y cambiamos el icono por defecto    
            internalform.setFont(new Font("Segoe UI", Font.BOLD, 15));
            internalform.setIcon(true);
            internalform.setLocation(new Point(5, 5));
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//aplica las propiedades propias del sitma operativo   
            switch (val) {
                case 1:
                    internalform.setBackground(new Color(176, 196, 222));
                    internalform.getContentPane().setBackground(new Color(176, 196, 222));
                    UIManager.put("InternalFrame.background", new Color(176, 196, 222));
                    internalform.updateUI();
                    break;
                default:
                    internalform.setBackground(new Color(225, 225, 225));
                    internalform.getContentPane().setBackground(new Color(225, 225, 225));
                    UIManager.put("InternalFrame.background", new Color(225, 225, 225));
                    internalform.updateUI();
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param internalform
     * @throws RemoteException
     */
    public static void PropiedadesInternalFormMimisado(JInternalFrame internalform) throws RemoteException {
        try {
            ImageIcon ico = new ImageIcon(ClassLoader.getSystemResource("GUI_Img/TalentoHumanoLogotipo48x48.png")); //creamos la clase icono y la direccion donde se encuentra //     
            internalform.setFrameIcon(ico);//implementamos la clase icono y cambiamos el icono por defecto    
            internalform.setFont(new Font("Segoe UI", Font.BOLD, 15));
            DropShadowBorder shadow = new DropShadowBorder();
            shadow.setCornerSize(15);
            shadow.setShadowColor(new Color(178, 216, 255));
            shadow.setShadowOpacity((float) 0.5);
            shadow.setShadowSize(10);
            shadow.setShowBottomShadow(true);
            shadow.setShowLeftShadow(true);
            shadow.setShowRightShadow(true);
            shadow.setShowTopShadow(true);
            internalform.setFrameIcon(null);//quita el icono del internal frame   
            internalform.setBorder(shadow);
            internalform.setIcon(true);
            internalform.setBackground(new Color(176, 196, 222));
        } catch (Exception ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param table
     */
    public static void PropiedadesTabla(JTable table) {
        try {
            Border myRaisedBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null);
            table.setFont(new Font("Segoe UI", Font.BOLD, 15));
            table.setBackground(new Color(225, 225, 225));//gris
            table.setBorder(myRaisedBorder);
            table.setGridColor(Color.BLACK);//cambiamos el color a las lineas de divicion
            table.setOpaque(true);
            table.getTableHeader().setOpaque(true);
            table.setRowHeight(40);//alto de celadas 
            UIManager.put("Table.opaque", true);
            UIManager.put("TableHeader.opaque", true);
            UIManager.put("TableHeader.background", new Color(225, 225, 225));
            UIManager.put("TableHeader.cellBorder", myRaisedBorder);
            UIManager.put("TableHeader.focusCellBackground", new Color(160, 200, 250));
            RenderCavecera cavecera = new RenderCavecera();
            cavecera.cambiarCabezera(table);
            Renderer celdas = new Renderer();
            table.setDefaultRenderer(Object.class, celdas);//cambia el cellRenderer
            table.updateUI();
        } catch (Exception ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param scrollPane
     * @param val
     */
    public static void PropiedadesScrollPane(JScrollPane scrollPane, int val) {
        try {
            switch (val) {
                case 1:
                    Border myRaisedBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null);
                    scrollPane.setBorder(myRaisedBorder);
                    scrollPane.setBackground(new Color(225, 225, 225));
                    break;
                case 2:
                    scrollPane.setBackground(new Color(176, 196, 222));
                    scrollPane.setBorder(null);
                    break;
                default:
                    scrollPane.setBorder(null);
                    break;
            }
            Border myRaisedBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null);
            scrollPane.setBorder(myRaisedBorder);
            scrollPane.updateUI();
        } catch (Exception ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     * @param checkbox
     */
    public static void PropiedadesCheckBox(JCheckBox checkbox, int val) {
        try {

            checkbox.setFont(new Font("Segoe UI", Font.BOLD, 15));//damos estilos de letra,estilo,tamaño texto encavezados 
            Border myRaisedBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null);
            checkbox.setBorder(myRaisedBorder);
            UIManager.put("CheckBox.disabledText", new Color(0, 0, 0));
            checkbox.updateUI();
            switch (val) {
                case 1:
                    checkbox.setBackground(new Color(176, 196, 222));//azul
                    UIManager.put("CheckBox.select", new Color(176, 196, 222));
                    break;
                case 2:
                    checkbox.setBackground(new Color(225, 225, 225));
                    UIManager.put("CheckBox.select", new Color(225, 225, 225));
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param radiobutton
     */
    public static void PropiedadesRadioButton(JRadioButton radiobutton) {
        try {
            radiobutton.setBackground(new Color(176, 196, 222));//<zul 
            radiobutton.setFont(new Font("Segoe UI", Font.BOLD, 15));//damos estilos de letra,estilo,tamaño texto encavezados 
            Border myRaisedBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null);
            radiobutton.setBorder(myRaisedBorder);
        } catch (Exception ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     * @param datechooser
     */
    public static void PropiedadesDateChooser(JDateChooser datechooser) {
        try {
            Border myRaisedBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null);
            datechooser.setBorder(myRaisedBorder);
            datechooser.setBackground(new Color(225, 225, 225));//gris
            datechooser.setFont(new Font("Segoe UI", Font.BOLD, 15));//damos estilos de letra,estilo,tamaño texto encavezados 
            ((JTextField) datechooser.getDateEditor()).setEditable(false);
            UIManager.put("TextField.selectionBackground", new Color(176, 196, 222));
            datechooser.updateUI();
        } catch (Exception ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param toolbar
     */
    public static void PropiedadesToolBar(JToolBar toolbar) {
        try {
            Border myRaisedBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null);
            toolbar.setFloatable(false);
            toolbar.setBorder(myRaisedBorder);
            toolbar.setBackground(new Color(225, 225, 225));
            toolbar.setSize(new Dimension(28, 28));
            toolbar.setFont(new Font("Segoe UI", Font.BOLD, 15));//damos estilos de letra,estilo,tamaño texto encavezados
            toolbar.updateUI();
        } catch (Exception ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param menubar
     */
    public static void PropiedadesMenuBar(JMenuBar menubar) {
        try {
            menubar.setBackground(new Color(225, 225, 225));
            menubar.setOpaque(true);
            menubar.setSize(new Dimension(28, 28));
            menubar.setFont(new Font("Segoe UI", Font.BOLD, 15));//damos estilos de letra,estilo,tamaño texto encavezados 
            UIManager.put("MenuBar.opaque", true);
            UIManager.put("MenuBar.selectionBackground", new Color(176, 196, 222));
            UIManager.put("MenuBar.background", new Color(225, 225, 225));
            UIManager.put("MenuBar.backgroundPainter", new Color(225, 225, 225));
            UIManager.put("MenuBar.highlight", new Color(225, 225, 225));
            UIManager.put("MenuBar.shadow", new Color(225, 225, 225));
            UIManager.put("MenuBar.darkShadow", new Color(225, 225, 225));
            UIManager.put("MenuBar.borderColor", new Color(225, 225, 225));
            UIManager.put("MenuBar.disabledBackground", new Color(225, 225, 225));
            UIManager.put("MenuBar.enabledBackground", new Color(225, 225, 225));
            menubar.updateUI();
        } catch (Exception ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param menu
     * @param val
     */
    public static void PropiedadesMenu(JMenu menu, int val) {
        try {
            Border myRaisedBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null);
            switch (val) {
                case 1:
                    menu.setBorder(myRaisedBorder);
                    menu.setFont(new Font("Segoe UI", Font.BOLD, 15));//damos estilos de letra,estilo,tamaño texto encavezados 
                    menu.setBackground(new Color(225, 225, 225));
                    menu.setOpaque(true);
                    UIManager.put("Menu.opaque", true);
                    UIManager.put("TabbedPane.selected", new Color(225, 225, 225));
                    UIManager.put("Menu.selectionBackground", new Color(176, 196, 222));
                    UIManager.put("Menu.selectionForeground", new Color(176, 196, 222));
                    UIManager.put("Menu.background", new Color(176, 196, 222));
                    UIManager.put("Menu.background", new Color(225, 225, 225));
                    UIManager.put("Menu.highlight", new Color(225, 225, 225));
                    UIManager.put("Menu.shadow", new Color(225, 225, 225));
                    UIManager.put("Menu.darkShadow", new Color(225, 225, 225));
                    UIManager.put("Menu.borderColor", new Color(225, 225, 225));
                    UIManager.put("Menu.disabledBackground", new Color(225, 225, 225));
                    UIManager.put("Menu.enabledBackground", new Color(225, 225, 225));
                    menu.updateUI();
                    break;
                default:
                    menu.setBorder(myRaisedBorder);
                    menu.setFont(new Font("Segoe UI", Font.BOLD, 15));//damos estilos de letra,estilo,tamaño texto encavezados 
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param menuitem
     */
    public static void PropiedadesMenuItem(JMenuItem menuitem) {
        try {
            Border myRaisedBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null);
            menuitem.setBorder(myRaisedBorder);
            menuitem.setOpaque(true);
            menuitem.setFont(new Font("Segoe UI", Font.BOLD, 15));//damos estilos de letra,estilo,tamaño texto encavezados 
            UIManager.put("MenuItem.opaque", true);
            UIManager.put("MenuItem.selectionBackground", new Color(176, 196, 222));
            UIManager.put("MenuItem.background", new Color(225, 225, 225));
            menuitem.updateUI();
        } catch (Exception ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param textarea
     */
    public static void PropiedadesTextArea(JTextArea textarea) {
        try {
            Border myRaisedBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED, null, null, null, null);
            textarea.setBorder(myRaisedBorder);
            textarea.setLineWrap(true);
            textarea.setBackground(new Color(225, 225, 225));
            textarea.setFont(new Font("Segoe UI", Font.BOLD, 15));//damos estilos de letra,estilo,tamaño texto encavezados 
            UIManager.put("TextArea.selectionBackground", new Color(176, 196, 222));
            textarea.updateUI();
        } catch (Exception ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param desktoppane
     * @param val
     */
    public static void PropiedadesDesKtopPane(JDesktopPane desktoppane, int val) {
        try {
            desktoppane.setFont(new Font("Segoe UI", Font.BOLD, 15));//damos estilos de letra,estilo,tamaño texto encavezados 
            desktoppane.setSize(desktoppane.getMaximumSize());
            switch (val) {
                case 1:
                    desktoppane.setBackground(new Color(176, 196, 222));
                    break;
                default:
                    desktoppane.setBackground(new Color(225, 225, 225));
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param panel
     * @param val
     */
    public void PropiedadesPanel(JPanel panel, int val) {
        try {
            Border myRaisedBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null);
            switch (val) {
                case 1:
                    panel.setBorder(myRaisedBorder);
                    panel.setBackground(new Color(176, 196, 222));
                    break;
                case 2:
                    panel.setBackground(new Color(176, 196, 222));
                    panel.setBorder(null);
                    break;
                case 3:
                    panel.setBackground(new Color(244, 164, 96));
                    panel.setBorder(myRaisedBorder);
                    break;
                case 4:
                    panel.setBackground(new Color(218, 165, 32));
                    panel.setBorder(myRaisedBorder);
                    break;
                case 5:
                    panel.setBackground(new Color(222, 184, 135));
                    panel.setBorder(myRaisedBorder);
                    break;
                default:
                    panel.setBackground(new Color(225, 225, 225));
                    panel.setBorder(null);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param comboboxt
     */
    public void PropiedadesComboboxt(JComboBox<Object> comboboxt) {
        try {
            Border myRaisedBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null);
            comboboxt.setBorder(myRaisedBorder);
            comboboxt.setBackground(new Color(225, 225, 225));
            comboboxt.setFont(new Font("Segoe UI", Font.BOLD, 15));//damos estilos de letra,estilo,tamaño texto encavezados  
            UIManager.put("ComboBox.selectionBackground", new Color(176, 196, 222));
            comboboxt.updateUI();
        } catch (Exception ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param texboxt
     */
    public void PropiedadesTextboxt(JTextField texboxt) {
        try {
            Border myRaisedBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED, null, null, null, null);//undido
            texboxt.setBorder(myRaisedBorder);
            texboxt.setBackground(new Color(225, 225, 225));
            texboxt.setFont(new Font("Segoe UI", Font.BOLD, 15));//damos estilos de letra,estilo,tamaño texto encavezados  
            UIManager.put("TextField.selectionBackground", new Color(176, 196, 222));
            texboxt.updateUI();
        } catch (Exception ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param label
     * @param val
     */
    public void PropiedadesLabel(JLabel label, int val) {
        try {
            label.setBackground(new Color(176, 196, 222));
            UIManager.put("Label.background", new Color(225, 225, 225));
            label.updateUI();
            label.setFont(new Font("Segoe UI", Font.BOLD, 15));//damos estilos de letra,estilo,tamaño texto encavezados              
            switch (val) {
                case 1:
                    label.setForeground(new Color(102, 0, 0));
                    break;
                case 2:
                    label.setFont(new Font("Segoe UI", Font.BOLD, 18));//damos estilos de letra,estilo,tamaño texto encavezados  
                    label.setForeground(new Color(0, 0, 0));
                    break;
                case 3:
                    label.setFont(new Font("Segoe UI", Font.BOLD, 28));//damos estilos de letra,estilo,tamaño texto encavezados  
                    label.setForeground(new Color(0, 0, 0));
                    break;
                case 4:
                    label.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));//damos estilos de letra,estilo,tamaño texto encavezados  
                    label.setForeground(new Color(128, 0, 0));
                    break;
                default:
                    label.setForeground(new Color(0, 0, 0));
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param button
     * @param val
     */
    public void PropiedadesButton(JButton button, int val) {
        try {
            Border myRaisedBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null);
            button.setBorder(myRaisedBorder);
            button.setOpaque(true);
            button.setBorderPainted(true);
            button.setContentAreaFilled(true);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setVerticalTextPosition(SwingConstants.BOTTOM);
            button.setFont(new Font("Segoe UI", Font.BOLD, 15));//damos estilos de letra,estilo,tamaño texto encavezados     
            UIManager.put("Button.select", new Color(176, 196, 222));
            button.updateUI();
            switch (val) {
                case 1:
                    button.setOpaque(true);
                    button.setRequestFocusEnabled(false);
                    button.setBorderPainted(true);
                    button.setContentAreaFilled(true);
                    button.setSize(button.getPreferredSize().width, 28);
                    button.setPreferredSize(new Dimension(button.getPreferredSize().width, 28));
                    button.setHorizontalAlignment(SwingConstants.CENTER);
                    button.setVerticalAlignment(SwingConstants.BOTTOM);
                    button.setHorizontalTextPosition(SwingConstants.CENTER);
                    button.setVerticalTextPosition(SwingConstants.CENTER);
                    break;
                case 2:
                    button.setOpaque(true);
                    button.setBorderPainted(true);
                    button.setContentAreaFilled(true);
                    button.setRequestFocusEnabled(false);
                    button.setForeground(new Color(0, 0, 0));
                    button.setBorder(myRaisedBorder);
                    button.setBackground(new Color(225, 225, 225));
                    button.setHorizontalAlignment(SwingConstants.CENTER);
                    button.setVerticalAlignment(SwingConstants.CENTER);
                    button.setHorizontalTextPosition(SwingConstants.CENTER);
                    button.setVerticalTextPosition(SwingConstants.CENTER);
                    UIManager.put("Button.select", new Color(176, 196, 222));
                    UIManager.put("Button.background", new Color(225, 225, 225));
                    UIManager.put("Button.foreground", new Color(0, 0, 0));
                    button.updateUI();
                    break;
                default:
                    button.setOpaque(true);
                    button.setBorderPainted(true);
                    button.setContentAreaFilled(true);
                    button.setRequestFocusEnabled(false);
                    button.setForeground(new Color(0, 0, 0));
                    button.setBorder(myRaisedBorder);
                    button.setBackground(new Color(225, 225, 225));
                    button.setHorizontalTextPosition(SwingConstants.RIGHT);
                    button.setVerticalTextPosition(SwingConstants.CENTER);
                    UIManager.put("Button.select", new Color(176, 196, 222));
                    UIManager.put("Button.background", new Color(225, 225, 225));
                    UIManager.put("Button.foreground", new Color(0, 0, 0));
                    button.updateUI();
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param tabbedPanel
     */
    public void PropiedadesTabbedPane(JTabbedPane tabbedPanel) {
        try {
            tabbedPanel.setOpaque(true);
            tabbedPanel.setBackground(new Color(176, 196, 222));
            tabbedPanel.setForeground(new Color(0, 0, 0));
            tabbedPanel.setFont(new Font("Segoe UI", Font.BOLD, 15));//damos estilos de letra,estilo,tamaño texto encavezados       
            tabbedPanel.setForegroundAt(0, new Color(0, 0, 0));
            tabbedPanel.setForegroundAt(1, new Color(0, 0, 0));
            tabbedPanel.setBackgroundAt(0, new Color(176, 196, 222));
            tabbedPanel.setBackgroundAt(1, new Color(176, 196, 222));
            UIManager UI = new UIManager();
            UI.put("TabbedPane.background", new Color(176, 196, 222));
            UI.put("TabbedPane.borderHightlightColor", new Color(176, 196, 222));
            UI.put("TabbedPane.contentAreaColor", new Color(176, 196, 222));
            UI.put("TabbedPane.darkShadow", new Color(176, 196, 222));
            UI.put("TabbedPane.focus", new Color(176, 196, 222));
            UI.put("TabbedPane.highlight", new Color(176, 196, 222));
            UI.put("TabbedPane.light", new Color(176, 196, 222));
            UI.put("TabbedPane.selected", new Color(176, 196, 222));
            UI.put("TabbedPane.selectedForeground", new Color(0, 0, 0));
            UI.put("TabbedPane.selectHighlight", new Color(176, 196, 222));
            UI.put("TabbedPane.shadow", new Color(176, 196, 222));
            UI.put("TabbedPane.tabAreaBackground", new Color(176, 196, 222));
            UI.put("TabbedPane.unselectedBackground", new Color(176, 196, 222));
            UI.put("TabbedPane.unselectedTabBackground", new Color(176, 196, 222));
            UI.put("TabbedPane.unselectedTabForeground", new Color(0, 0, 0));
            UI.put("TabbedPane.unselectedTabHighlight", new Color(176, 196, 222));
            UI.put("TabbedPane.unselectedTabShadow", new Color(176, 196, 222));
            UI.put("TabbedPane.opaque", true);
            UI.put("tabsOpaque", true);
            UI.put("TabbedPane.tabsOverlapBorder", false);
            tabbedPanel.updateUI();
        } catch (Exception ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param tabbedPanel
     */
    public void PropiedadesTabbedPane1(JTabbedPane tabbedPanel) {
        try {
            tabbedPanel.setOpaque(true);
            tabbedPanel.setBackground(new Color(225, 225, 225));
            tabbedPanel.setForeground(new Color(0, 0, 0));
            tabbedPanel.setFont(new Font("Segoe UI", Font.BOLD, 15));//damos estilos de letra,estilo,tamaño texto encavezados       
            tabbedPanel.setForegroundAt(0, new Color(0, 0, 0));
            tabbedPanel.setForegroundAt(1, new Color(0, 0, 0));
            tabbedPanel.setBackgroundAt(0, new Color(225, 225, 225));
            tabbedPanel.setBackgroundAt(1, new Color(225, 225, 225));
            UIManager UI = new UIManager();
            UI.put("TabbedPane.background", new Color(225, 225, 225));
            UI.put("TabbedPane.borderHightlightColor", new Color(225, 225, 225));
            UI.put("TabbedPane.contentAreaColor", new Color(225, 225, 225));
            UI.put("TabbedPane.darkShadow", new Color(225, 225, 225));
            UI.put("TabbedPane.focus", new Color(225, 225, 225));
            UI.put("TabbedPane.highlight", new Color(225, 225, 225));
            UI.put("TabbedPane.light", new Color(225, 225, 225));
            UI.put("TabbedPane.selected", new Color(225, 225, 225));
            UI.put("TabbedPane.selectedForeground", new Color(0, 0, 0));
            UI.put("TabbedPane.selectHighlight", new Color(225, 225, 225));
            UI.put("TabbedPane.shadow", new Color(225, 225, 225));
            UI.put("TabbedPane.tabAreaBackground", new Color(225, 225, 225));
            UI.put("TabbedPane.unselectedBackground", new Color(225, 225, 225));
            UI.put("TabbedPane.unselectedTabBackground", new Color(225, 225, 225));
            UI.put("TabbedPane.unselectedTabForeground", new Color(0, 0, 0));
            UI.put("TabbedPane.unselectedTabHighlight", new Color(225, 225, 225));
            UI.put("TabbedPane.unselectedTabShadow", new Color(225, 225, 225));
            UI.put("TabbedPane.opaque", true);
            UI.put("tabsOpaque", true);
            UI.put("TabbedPane.tabsOverlapBorder", false);
            tabbedPanel.updateUI();
        } catch (Exception ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
