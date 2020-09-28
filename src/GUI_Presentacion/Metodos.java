/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Presentacion;

import GUI_TablaModel.TabalaModeloMaterial;
import GUI_TablaModel.TablaModeloInventario;
import Gui_DefaultProperties.Propiedades;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author User
 */
public class Metodos {

    public static boolean noabre = false, noabre1 = false;
    public GUI_TablaModel.TabalaModeloMaterial tabMater;
    public GUI_TablaModel.TablaModeloInventario tabInvent;
    public Gui_DefaultProperties.Propiedades propiedades = new Propiedades();
    private int opcion = 0, opcion1 = 0;
    private String Dato = "", Dato1 = "";

    private String capturarFechaSistem() {
        Date fechasis = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = dateFormat.format(fechasis);
        int año = Integer.valueOf(fecha.split("-")[0]);
        int mes = Integer.valueOf(fecha.split("-")[1]);
        int dia = Integer.valueOf(fecha.split("-")[2]);
        return fecha;
    }

    public void propiedadesInicio(Inicio form) {
        propiedades.PropiedadesForm(form, 6);
        propiedades.PropiedadesTabla(form.DtbInventario);
        propiedades.PropiedadesScrollPane(form.jScrollPane2, 1);
        propiedades.PropiedadesMenuBar(form.jMenuBar1);
        propiedades.PropiedadesMenu(form.mnuListaMater, 0);
        propiedades.PropiedadesMenu(form.mnuRegistar, 0);
        propiedades.PropiedadesMenu(form.mnuCargar, 0);
        propiedades.PropiedadesMenu(form.mnuExportar, 0);
        propiedades.PropiedadesMenuItem(form.mnuItmRegMaterial);
        propiedades.PropiedadesToolBar(form.tlbrInventario);
        propiedades.PropiedadesButton(form.btnBuscar, 2);
        propiedades.PropiedadesButton(form.btnBuscar1, 2);
        propiedades.PropiedadesButton(form.btnBuscar2, 2);
        propiedades.PropiedadesComboboxt(form.cbxMaterial);
        propiedades.PropiedadesLabel(form.lblMaterial, 0);
        propiedades.PropiedadesCheckBox(form.chxbCodigoInvent, 2);
        propiedades.PropiedadesCheckBox(form.chxbNombreInvent, 2);
    }

    public void propiedadesFormMateriales(FormMateriales form) {
        propiedades.PropiedadesForm(form, 6);
        propiedades.PropiedadesTabla(form.DtbMaterial);
        propiedades.PropiedadesScrollPane(form.jScrollPane2, 1);
        propiedades.PropiedadesMenuBar(form.jMenuBar1);
        propiedades.PropiedadesMenu(form.mnuCargar, 0);
        propiedades.PropiedadesMenu(form.mnuExportar, 0);
        propiedades.PropiedadesMenu(form.mnuEliminar, 0);
        propiedades.PropiedadesToolBar(form.tlbrMaterial);
        propiedades.PropiedadesButton(form.btnBuscar, 2);
        propiedades.PropiedadesComboboxt(form.cbxMaterial);
        propiedades.PropiedadesLabel(form.lblMaterial, 0);
        propiedades.PropiedadesCheckBox(form.chxbCodigoMater, 2);
        propiedades.PropiedadesCheckBox(form.chxbNombreMater, 2);

    }

    public void propiedadesFormEditarInventario(FormEditarInventario form) {
        propiedades.PropiedadesForm(form, 8);
        propiedades.PropiedadesLabel(form.lblCamtEntre, 0);
        propiedades.PropiedadesLabel(form.lblMater, 0);
        propiedades.PropiedadesLabel(form.lblCanExis, 0);
//        propiedades.PropiedadesTextboxt(form.txtNomMaterial);
        propiedades.PropiedadesTextboxt(form.txtCantiDadEntre);
        propiedades.PropiedadesTextboxt(form.txtCantiadExis);
        propiedades.PropiedadesButton(form.btnCambiar, 1);
        propiedades.PropiedadesPanel(form.pnlConten, 1);
        form.txtNomMaterial.setEditable(false);
        Color color = form.pnlConten.getBackground();
        form.txtNomMaterial.setBackground(color);
        form.txtNomMaterial.setEnabled(false);
        form.txtNomMaterial.setFont(new Font("Segoe UI", Font.BOLD, 15));//damos estilos de letra,estilo,tamaño texto encavezados  
        UIManager.put("TextField.selectionBackground", new Color(176, 196, 222));
        form.txtNomMaterial.updateUI();
    }

    public void propiedadesFormEditarMterial(FormEditarMaterial form) {
        propiedades.PropiedadesForm(form, 8);
        propiedades.PropiedadesLabel(form.lblMater, 0);
        propiedades.PropiedadesLabel(form.lblCod, 0);
        propiedades.PropiedadesLabel(form.lblCod1, 0);
        propiedades.PropiedadesLabel(form.lblCod2, 0);
        propiedades.PropiedadesLabel(form.lblCod3, 0);
        propiedades.PropiedadesTextboxt(form.txtNomMaterial);
        propiedades.PropiedadesTextboxt(form.txtCodMater);
        propiedades.PropiedadesTextboxt(form.txtLinea);
        propiedades.PropiedadesTextboxt(form.txtGrupo);
        propiedades.PropiedadesTextboxt(form.txtElemento);
        propiedades.PropiedadesButton(form.btnCambiar, 1);
        propiedades.PropiedadesPanel(form.pnlConten, 1);
        form.txtLinea.setRequestFocusEnabled(false);
        form.txtGrupo.setRequestFocusEnabled(false);
        form.txtElemento.setRequestFocusEnabled(false);
    }

    public void propiedadesFormRejistarMterial(FormRegistrarMaterial form) {
        propiedades.PropiedadesForm(form, 8);
        propiedades.PropiedadesLabel(form.lblMater, 0);
        propiedades.PropiedadesLabel(form.lblCod, 0);
        propiedades.PropiedadesLabel(form.lblCod1, 0);
        propiedades.PropiedadesLabel(form.lblCod2, 0);
        propiedades.PropiedadesLabel(form.lblCod3, 0);
        propiedades.PropiedadesTextboxt(form.txtNomMaterial);
        propiedades.PropiedadesTextboxt(form.txtCodMater);
        propiedades.PropiedadesTextboxt(form.txtLinea);
        propiedades.PropiedadesTextboxt(form.txtGrupo);
        propiedades.PropiedadesTextboxt(form.txtElemento);
        propiedades.PropiedadesButton(form.btnCambiar, 1);
        propiedades.PropiedadesPanel(form.pnlConten, 1);
        form.txtLinea.setRequestFocusEnabled(false);
        form.txtGrupo.setRequestFocusEnabled(false);
        form.txtElemento.setRequestFocusEnabled(false);
    }

    public void LlenarTabalaInventarioInicio(Inicio form) {
        tabInvent = new TablaModeloInventario();
        tabInvent.tablaCionsulInventaarioInicio(form.DtbInventario, form);
    }

    public void LlenarTabalaInventario(Inicio form) {
        tabInvent = new TablaModeloInventario();
        tabInvent.inicio = 0;
        tabInvent.fin = 25;
        tabInvent.tablaCionsulInventaario(form.DtbInventario, form);
    }

    public void LlenarTabalaInventariopaginar(Inicio form, int ini, int fin) {
        tabInvent = new TablaModeloInventario();
        tabInvent.inicio = ini;
        tabInvent.fin = fin;
        tabInvent.tablaCionsulInventaario(form.DtbInventario, form);
    }

    public void CargarDatos(Inicio form) {
        Object[] options = {"Si", "No"};
        int car = JOptionPane.showOptionDialog(null, "Esta Operación Puede Tardar Unos Minutos \n" + "Desea Contunuar ?", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (car == 0) {
            LlenarTabalaInventario(form);
        } else {
            return;
        }
    }

    public void LlenarTabalaMaterial(FormMateriales form) {
        tabMater = new TabalaModeloMaterial();
        tabMater.tablaCionsulMaterial(form.DtbMaterial, form);
    }

    public void LlenarTabalaBuscarInventarioInicio(Inicio form) {
        tabInvent = new TablaModeloInventario();
        if (opcion == 3) {
            String dato = form.cbxMaterial.getSelectedItem().toString();
            Dato = dato.split("-")[0];
        } else {
            Dato = form.cbxMaterial.getSelectedItem().toString();
        }
        tabInvent.Dato = Dato;
        tabInvent.select = opcion;
        tabInvent.tablaCionsulBuscarInventaario(form.DtbInventario, form);
    }

    public void LlenarTabalaBuscarMaterial(FormMateriales form) {
        tabMater = new TabalaModeloMaterial();
        if (opcion1 == 3) {
            String dato = form.cbxMaterial.getSelectedItem().toString();
            Dato1 = dato.split("-")[0];
        } else {
            Dato1 = form.cbxMaterial.getSelectedItem().toString();
        }
        tabMater.Dato = Dato1;
        tabMater.select = opcion1;
        tabMater.tablaCionsulBuscarMaterial(form.DtbMaterial, form);
    }

    public void ajustartablaInicio(Inicio form) {
        double fancho = Double.valueOf(form.getSize().getWidth());//capturo el ancho  del formulario en tiepo real
//        double falto = Double.valueOf(getSize().getHeight()); //capturo el alto  del formulario en tiepo real 
        if (fancho > 900.0) {
            form.DtbInventario.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        } else if (fancho <= 900.0) {
            form.DtbInventario.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        } else {
            form.DtbInventario.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        }
    }

    public void ajustartablaFormMateriales(FormMateriales form) {
        double fancho = Double.valueOf(form.getSize().getWidth());//capturo el ancho  del formulario en tiepo real
//        double falto = Double.valueOf(getSize().getHeight()); //capturo el alto  del formulario en tiepo real 
        if (fancho > 900.0) {
            form.DtbMaterial.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            tabMater.TamañoCol(form.DtbMaterial);
        } else if (fancho <= 900.0) {
            form.DtbMaterial.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tabMater.TamañoCol(form.DtbMaterial);
        } else {
            form.DtbMaterial.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tabMater.TamañoCol(form.DtbMaterial);
        }
    }

    public void AbrirFormMateriales(Inicio form) {
        try {
            if (noabre == false) {
                FormMateriales ver = new FormMateriales(form);
                ver.setVisible(true);
                noabre = true;
            } else {
                JOptionPane.showMessageDialog(null, "No Sé  Puede Mostrar La Ventana, Ya Existe Una Ventana Abierta!!!");
            }
        } catch (Exception ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void AbrirRegistrarMateriales(Inicio form) {
        try {
            if (noabre1 == false) {
                FormRegistrarMaterial ver = new FormRegistrarMaterial(form);
                ver.setVisible(true);
                noabre1 = true;
            } else {
                JOptionPane.showMessageDialog(null, "No Sé  Puede Mostrar La Ventana, Ya Existe Una Ventana Abierta!!!");
            }
        } catch (Exception ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mensajeInicio(Inicio form) {
        Object[] options = {"Si", "No"};
        int resp = JOptionPane.showOptionDialog(null, "Desea Cargar Los Datos \n" + "Si Su Respuesta Es Si Por Favor Espere A Que Los Datos Sean Cargados \n" + "Esto Podria Tardar Unos Minutos", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (resp == 0) {
            LlenarTabalaInventario(form);
        } else {
            return;
        }
    }

    public void editarInventario(FormEditarInventario form) {
        try {
            if (form.txtNomMaterial.getText().isEmpty() || form.txtCantiDadEntre.getText().isEmpty() || form.txtCantiadExis.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Los Campos No Pueden Estar Vacios \n");
            } else {
                try {
                    String NombreA = form.Nombre;
                    String NombreN = String.valueOf(form.txtNomMaterial.getText());
                    int Cext = Integer.valueOf(form.txtCantiadExis.getText());
                    int Cert = Integer.valueOf(form.txtCantiDadEntre.getText());
                    Object[] options = {"Si", "No", "Cancelar"};
                    int resp = JOptionPane.showOptionDialog(null, "Se Se Editaran Los Siguientes Datos: "
                            + "\n" + "Nombre De Material: " + NombreN
                            + "\n" + "Cantidad En Existencia: " + Cext
                            + "\n" + "Cantidad Retirado: " + Cert, null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
                    if (resp == 0) {
                        String Edit = form.getInicio().getMycontrol().editarInventario(NombreN, NombreA, Cext, Cert);

                        if (Edit.equals("OK")) {
                            JOptionPane.showMessageDialog(null, "Se Edito Correctamente");
                            LlenarTabalaInventario(form.getInicio());
                            form.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "No Se Edito");
                        }
                    } else {
                        return;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
//            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarMaterial(FormEditarMaterial form) {
        try {
            Object[] options = {"Si", "No", "Cancelar"};
            if (form.txtNomMaterial.getText().isEmpty()
                    || form.txtCodMater.getText().isEmpty()
                    || form.txtLinea.getText().isEmpty()
                    || form.txtGrupo.getText().isEmpty()
                    || form.txtElemento.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ninguno De Los Campos No Pueden Estar Vacio \n" + "Por Favor Ingrese Datos En Ellos");
            } else {
                String NombreA = form.Nombre;
                String NombreN = String.valueOf(form.txtNomMaterial.getText());
                String Cod = form.txtCodMater.getText();
                int Cod1 = Integer.valueOf(form.txtLinea.getText());
                int Cod2 = Integer.valueOf(form.txtGrupo.getText());
                int Cod3 = Integer.valueOf(form.txtElemento.getText());
                int Id = form.Id;
                int resp = JOptionPane.showOptionDialog(null, "Se Se Editaran Los Siguientes Datos: "
                        + "\n" + "Codigo: " + Cod
                        + "\n" + "Linea: " + Cod1
                        + "\n" + "Grupo: " + Cod2
                        + "\n" + "Elemento: " + Cod3
                        + "\n" + "Nombre De Material: " + NombreN,
                        null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]
                );
                if (resp == 0) {
                    String Edit = form.getMateial().getInicio().getMycontrol().editarMaterial(Cod, Cod1, Cod2, Cod3, NombreN, Id);
                    if (Edit.equals("OK")) {
                        JOptionPane.showMessageDialog(null, "Se Edito Correctamente");
                        LlenarTabalaMaterial(form.getMateial());
                        form.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "No Se Edito");
                    }
                } else {
                    return;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rejistarMaterial(FormRegistrarMaterial form) {
        try {
            Object[] options = {"Si", "No", "Cancelar"};
            if (form.txtNomMaterial.getText().isEmpty()
                    || form.txtCodMater.getText().isEmpty()
                    || form.txtLinea.getText().isEmpty()
                    || form.txtGrupo.getText().isEmpty()
                    || form.txtElemento.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ninguno De Los Campos No Pueden Estar Vacio \n" + "Por Favor Ingrese Datos En Ellos");
            } else {
                String NombreA = form.Nombre;
                String NombreN = String.valueOf(form.txtNomMaterial.getText());
                String Cod = form.txtCodMater.getText();
                int Cod1 = Integer.valueOf(form.txtLinea.getText());
                int Cod2 = Integer.valueOf(form.txtGrupo.getText());
                int Cod3 = Integer.valueOf(form.txtElemento.getText());
                int Id = form.Id;
                int resp = JOptionPane.showOptionDialog(null, "Se Se Registran Los Siguientes Datos: "
                        + "\n" + "Codigo: " + Cod
                        + "\n" + "Linea: " + Cod1
                        + "\n" + "Grupo: " + Cod2
                        + "\n" + "Elemento: " + Cod3
                        + "\n" + "Nombre De Material: " + NombreN,
                        null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]
                );
                if (resp == 0) {
                    String Edit = form.getInicio().getMycontrol().registrarNuevoMaterial(Cod, Cod1, Cod2, Cod3, NombreN);
                    if (Edit.equals("OK")) {
                        JOptionPane.showMessageDialog(null, "Se Regiistro Correctamente");
                        form.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "No Se Registro");
                    }
                } else {
                    return;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarMaterialInventario(FormMateriales form) {
        try {
            int fila = form.DtbMaterial.getSelectedRow();
            System.out.println("fila " + fila);
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "No Ha Seleccionado Ningun Campo Para Eliminar\n");
            } else {
                String NombreN = String.valueOf(form.DtbMaterial.getValueAt(fila, 5).toString());
//                String Sigla = String.valueOf(form.DtbMaterial.getValueAt(fila, 8).toString());
                String Cod = form.DtbMaterial.getValueAt(fila, 1).toString();
                int Cod1 = Integer.valueOf(form.DtbMaterial.getValueAt(fila, 2).toString());
                int Cod2 = Integer.valueOf(form.DtbMaterial.getValueAt(fila, 3).toString());
                int Cod3 = Integer.valueOf(form.DtbMaterial.getValueAt(fila, 4).toString());
                Object[] options = {"Si", "No", "Cancelar"};
                int resp = JOptionPane.showOptionDialog(null, "Se Eliminaran Los Siguientes Datos:  "
                        + "\n" + "Esta Seguro ? "
                        + "\n" + "Nombre De Material: " + NombreN
                        + "\n" + "Codigo: " + Cod
                        + "\n" + "Codigo1: " + Cod1
                        + "\n" + "Codigo2: " + Cod2
                        + "\n" + "Codigo3: " + Cod3,
                        null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]
                );
                if (resp == 0) {
                    String Elim = form.getInicio().getMycontrol().eliminarMaterialInventario(Cod);
                    if (Elim.equals("OK")) {
                        JOptionPane.showMessageDialog(null, "Se Elimino Correctamente");
                        LlenarTabalaMaterial(form);
                    } else {
                        JOptionPane.showMessageDialog(null, "No Se Elimino");
                    }
                } else {
                    return;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ExportarExelMaterial(FormMateriales form) {
        Object[] options = {"Si", "No"};

        if (form.DtbMaterial.getValueAt(0, 4) == null || form.DtbMaterial.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No Existen Datos A Exportar");
            return;
        } else if (form.DtbMaterial.getValueAt(0, 4) == null || form.DtbMaterial.getRowCount() == 1) {
            JOptionPane.showMessageDialog(null, "Accion No Permitida \n" + "No Es Recomendable Exportar Un Solo Registro");
            return;
        } else {
            int seg = JOptionPane.showOptionDialog(null, "Esta Operación Puede Tardar Unos Minutos \n" + "Desea Contunuar ?", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (seg == 0) {
                try {

                    JFileChooser dialog = new JFileChooser();
                    File guardar = new File(form.getTitle() + "_" + capturarFechaSistem()); //creeamo sun nuevo archivo para darel nombre prederteminado  
                    dialog.setSelectedFile(guardar);//apliacamos el nombre por defecto al archivo
                    FileNameExtensionFilter xlsFilter = new FileNameExtensionFilter("Ecxel", "xls");// da la extecion por defecto que queremos guardar
                    // add filters
                    dialog.addChoosableFileFilter(xlsFilter);
                    dialog.setFileFilter(xlsFilter);
                    int opcion = dialog.showSaveDialog(form);
                    if (opcion == JFileChooser.APPROVE_OPTION) {
                        File dir = dialog.getSelectedFile();
                        try {
                            List<JTable> tb = new ArrayList<JTable>();
                            tb.add(form.DtbMaterial);
                            String nombrhoja = form.getTitle() + "_" + capturarFechaSistem();
                            int hoja = 0;
                            //---------------------- //String dato =cadena que se cambia caraacteres;
                            //    String user1 = user.replace(' ', '_');//remplasa caracteres
                            ExporExcel1 excelExporter = new ExporExcel1(tb, nombrhoja, hoja, new File(dir.getAbsolutePath() + ".xls"));
                            excelExporter.TITULO1 = "GESTION ADMINISTRATIVA Y FINANCIERA";
                            excelExporter.TITULO2 = "GESTION COMPRAS";
                            excelExporter.TITULO3 = "REGISTRO DE PEDIDOS";
                            excelExporter.FORMATO = "MPA 02-PR1R";
                            excelExporter.VERSION = "VERSIÓN 1";
                            if (excelExporter.export()) {
                                int resp = JOptionPane.showOptionDialog(null, "Información Exportada Con Éxito \n" + "Desea Abrir El Archivo", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                                if (resp == 0) {
                                    try {
                                        String archivo = "rundll32 url.dll,FileProtocolHandler " + dir.getAbsolutePath() + ".xls";
                                        Runtime.getRuntime().exec(archivo);//abre el achivo apenas se guarde
                                    } catch (IOException ex) {
                                        Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                        ex.printStackTrace();
                                        JOptionPane.showMessageDialog(null, ex.getMessage());
                                    }

                                } else {
                                    return;
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "La Información No Pudo Ser Exportada Con Éxito \n");
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "La Información No Pudo Ser Exportada Con Éxito \n" + ex.getMessage());
                        }
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            } else {
                return;
            }
        }
    }

    public void ExportarExelInventario(Inicio form) {
        if (form.DtbInventario.getRowCount() < 1) {
            JOptionPane.showMessageDialog(null, "No Existen Datos A Exportar");
            return;
        } else if (form.DtbInventario.getRowCount() == 1) {
            JOptionPane.showMessageDialog(null, "Accion No Permitida \n" + "No Es Recomendable Exportar Un Solo Registro");
            return;
        } else {
            Object[] options = {"Si", "No"};
            int seg = JOptionPane.showOptionDialog(null, "Esta Operación Puede Tardar Unos Minutos \n" + "Desea Contunuar ?", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (seg == 0) {
                if (form.DtbInventario.getValueAt(0, 4) == null || form.DtbInventario.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "No Existen Datos A Exportar");
                    return;
                } else {
                    try {
                        String dato = form.getTitle();
                        String dato1 = dato.replace(' ', '_');//remplasa caracteres                    
                        JFileChooser dialog = new JFileChooser();
                        File guardar = new File("Inventario" + "_" + dato1.split("_")[1] + "_" + capturarFechaSistem()); //creeamo sun nuevo archivo para darel nombre prederteminado               
                        dialog.setSelectedFile(guardar);//apliacamos el nombre por defecto al archivo
                        FileNameExtensionFilter xlsFilter = new FileNameExtensionFilter("Ecxel", "xls");// da la extecion por defecto que queremos guardar
                        // add filters
                        dialog.addChoosableFileFilter(xlsFilter);
                        dialog.setFileFilter(xlsFilter);
                        int opcion = dialog.showSaveDialog(form);
                        if (opcion == JFileChooser.APPROVE_OPTION) {
                            File dir = dialog.getSelectedFile();
                            try {
                                List<JTable> tb = new ArrayList<JTable>();
                                tb.add(form.DtbInventario);
                                String nombrhoja = "Inventario" + "_" + dato1.split("_")[1] + capturarFechaSistem();
                                int hoja = 0;
                                //---------------------- String dato =cadena que se cambia caraacteres;
                                //    String user1 = user.replace(' ', '_');//remplasa caracteres
                                ExporExcel excelExporter = new ExporExcel(tb, nombrhoja, hoja, new File(dir.getAbsolutePath() + ".xls"));
                                excelExporter.TITULO1 = "GESTION ADMINISTRATIVA Y FINANCIERA";
                                excelExporter.TITULO2 = "GESTION COMPRAS";
                                excelExporter.TITULO3 = "REGISTRO DE PEDIDOS";
                                excelExporter.FORMATO = "MPA 02-PR1R";
                                excelExporter.VERSION = "VERSIÓN 1";
                                if (excelExporter.export()) {
                                    int resp = JOptionPane.showOptionDialog(null, "Información Exportada Con Éxito \n" + "Desea Abrir El Archivo", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                                    if (resp == 0) {
                                        try {
                                            String archivo = "rundll32 url.dll,FileProtocolHandler " + dir.getAbsolutePath() + ".xls";
                                            Runtime.getRuntime().exec(archivo);//abre el achivo apenas se guarde
                                        } catch (IOException ex) {
                                            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                            ex.printStackTrace();
                                            JOptionPane.showMessageDialog(null, ex.getMessage());
                                        }

                                    } else {
                                        return;
                                    }

                                } else {
                                    JOptionPane.showMessageDialog(null, "La Información No Pudo Ser Exportada Con Éxito \n");
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(null, "La Información No Pudo Ser Exportada Con Éxito \n" + ex.getMessage());
                            }
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            } else {
                return;
            }
        }
    }

    public void CargarMaterialIDEnInventario(Inicio form) {
        try {
            form.cbxMaterial.removeAllItems();
            ArrayList<String> Rc;
            Rc = form.getMycontrol().ListaMaterial();
            String a = "Seleccione";
            Object b = a;
            form.cbxMaterial.addItem(b);
            for (String n : Rc) {
                a = n;
                b = a;
                b = a.split("_")[1];
                form.cbxMaterial.addItem(b);
            }
        } catch (Exception ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CargarMaterialEnInventario(Inicio form) {
        try {
            form.cbxMaterial.removeAllItems();
            ArrayList<String> Rc;
            Rc = form.getMycontrol().ListaMaterial();
            String a = "Seleccione";
            Object b = a;
            form.cbxMaterial.addItem(b);
            for (String n : Rc) {
                a = n;
                b = a;
                b = a.split("_")[5];
                form.cbxMaterial.addItem(b);
            }
        } catch (Exception ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CargarMaterialIdNomEnInventario(Inicio form) {
        try {
            form.cbxMaterial.removeAllItems();
            ArrayList<String> Rc;
            Rc = form.getMycontrol().ListaMaterial();
            String a = "Seleccione";
            Object b = a;
            form.cbxMaterial.addItem(b);
            for (String n : Rc) {
                a = n;
                b = a;
                b = a.split("_")[1] + "-" + a.split("_")[5];
                form.cbxMaterial.addItem(b);
            }
        } catch (Exception ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CargarMaterialIDEnMaterial(FormMateriales form) {
        try {
            form.cbxMaterial.removeAllItems();
            ArrayList<String> Rc;
            Rc = form.getInicio().getMycontrol().ListaMaterial();
            String a = "Seleccione";
            Object b = a;
            form.cbxMaterial.addItem(b);
            for (String n : Rc) {
                a = n;
                b = a;
                b = a.split("_")[1];
                form.cbxMaterial.addItem(b);
            }
        } catch (Exception ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CargarMaterialEnMaterial(FormMateriales form) {
        try {
            form.cbxMaterial.removeAllItems();
            ArrayList<String> Rc;
            Rc = form.getInicio().getMycontrol().ListaMaterial();
            String a = "Seleccione";
            Object b = a;
            form.cbxMaterial.addItem(b);
            for (String n : Rc) {
                a = n;
                b = a;
                b = a.split("_")[5];
                form.cbxMaterial.addItem(b);
            }
        } catch (Exception ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CargarMaterialIdNomEnMaterial(FormMateriales form) {
        try {
            form.cbxMaterial.removeAllItems();
            ArrayList<String> Rc;
            Rc = form.getInicio().getMycontrol().ListaMaterial();
            String a = "Seleccione";
            Object b = a;
            form.cbxMaterial.addItem(b);
            for (String n : Rc) {
                a = n;
                b = a;
                b = a.split("_")[1] + "-" + a.split("_")[5];
                form.cbxMaterial.addItem(b);
            }
        } catch (Exception ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void validarFiltroInventario(Inicio form) {
        if (form.chxbCodigoInvent.isSelected()) {
            CargarMaterialIDEnInventario(form);
            opcion = 1;
        } else if (form.chxbNombreInvent.isSelected()) {
            CargarMaterialEnInventario(form);
            opcion = 2;
        } else if (form.chxbCodigoInvent.isSelected() && form.chxbNombreInvent.isSelected()) {
            CargarMaterialIdNomEnInventario(form);
            opcion = 3;
        } else {
            form.cbxMaterial.removeAllItems();
            String a = "Seleccione";
            Object b = a;
            form.cbxMaterial.addItem(b);
            opcion = 0;
        }
        if (form.chxbCodigoInvent.isSelected() && form.chxbNombreInvent.isSelected()) {
            CargarMaterialIdNomEnInventario(form);
            opcion = 3;
        }
    }

    public void validarFiltroMaterial(FormMateriales form) {
        if (form.chxbCodigoMater.isSelected()) {
            CargarMaterialIDEnMaterial(form);
            opcion1 = 1;
        } else if (form.chxbNombreMater.isSelected()) {
            CargarMaterialEnMaterial(form);
            opcion1 = 2;
        } else if (form.chxbCodigoMater.isSelected() && form.chxbNombreMater.isSelected()) {
            CargarMaterialIdNomEnMaterial(form);
            opcion1 = 3;
        } else {
            form.cbxMaterial.removeAllItems();
            String a = "Seleccione";
            Object b = a;
            form.cbxMaterial.addItem(b);
            opcion1 = 0;
        }
        if (form.chxbCodigoMater.isSelected() && form.chxbNombreMater.isSelected()) {
            CargarMaterialIdNomEnMaterial(form);
            opcion1 = 3;
        }
    }

    public void BuscarEnMaterial(FormMateriales form) {
        if (form.cbxMaterial.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "El Dato No Es Válido\n " + "Por Favor Seleccione Una Opción Válida");
        } else {
            LlenarTabalaBuscarMaterial(form);
        }
    }

    public void BuscarEnInventario(Inicio form) {
        if (form.cbxMaterial.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "El Dato No Es Válido\n " + "Por Favor Seleccione Una Opción Válida");
        } else {
            LlenarTabalaBuscarInventarioInicio(form);
        }
    }

    public void txtCodMaterKeyTyped(FormRegistrarMaterial form, KeyEvent evt) {
        try {
            char Ca = evt.getKeyChar();
            if ((Ca < '0' || Ca > '9') && (Ca != '.') && (Ca != ',') && (Ca != 'v') && (Ca != 'V') && (Ca != evt.VK_DELETE) && (Ca != evt.VK_BACK_SPACE) && (Ca != evt.VK_CONTROL) && (Ca != evt.VK_ENTER)) {
                evt.consume();
            }
            String cadena = form.txtCodMater.getText();
            ArrayList<String> punto = new ArrayList<>();
            ArrayList<String> numero = new ArrayList<>();
            char[] arrayChar = cadena.toCharArray();
            for (int i = 0; i < arrayChar.length; i++) {
                if (arrayChar[i] == '.') {
                    punto.add(String.valueOf(arrayChar[i]));
                    System.out.println(punto.size());
                } else {
                    numero.add(String.valueOf(arrayChar[i]));
                }
            }
            if (punto.size() >= 3) {
                JOptionPane.showMessageDialog(null, "El Codigo Ingresado No Es Valido  \n" + "Por Favor Ingresar De De Nuevo");
                form.txtCodMater.setText(null);
                form.txtLinea.setText(null);
                form.txtGrupo.setText(null);
                form.txtElemento.setText(null);
                Robot robot = new Robot();//crea un nuevo objeto d ela clase robot 
                robot.keyPress(KeyEvent.VK_DELETE);
                robot.keyPress(KeyEvent.VK_BACK_SPACE);
            } else {
                if (Ca == evt.VK_ENTER) {
                    String codigo = form.txtCodMater.getText().toString();
                    String linea = codigo.split("\\.")[0];//para poder usar el .en eel split hay que colocar aaasi \\.lo mismo para cuando se usen -,*,+
                    String grupo = codigo.split("\\.")[1];
                    String elemento = codigo.split("\\.")[2];
                    form.txtLinea.setText(linea);
                    form.txtGrupo.setText(grupo);
                    form.txtElemento.setText(elemento);
                    form.txtNomMaterial.requestFocus();
                    punto.clear();
                    numero.clear();
                }
            }

        } catch (AWTException ex) {
            Logger.getLogger(FormRegistrarMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void txtNomMaterialFocusGained(FormRegistrarMaterial form) {
        String cadena = form.txtCodMater.getText();
        ArrayList<String> punto = new ArrayList<>();
        ArrayList<String> numero = new ArrayList<>();
        char[] arrayChar = cadena.toCharArray();
        for (int i = 0; i < arrayChar.length; i++) {
            if (arrayChar[i] == '.') {
                punto.add(String.valueOf(arrayChar[i]));
                System.out.println(punto.size());
                System.out.println(arrayChar[i] + " -> es la vocal a");
            } else {
                numero.add(String.valueOf(arrayChar[i]));
                System.out.println(arrayChar[i] + " -> no es la vocal a");
            }
        }
        if (punto.size() >= 3) {
            JOptionPane.showMessageDialog(null, "El Codigo Ingresado No Es Valido  \n" + "Por Favor Ingresar De De Nuevo");
            form.txtCodMater.setText(null);
            form.txtLinea.setText(null);
            form.txtGrupo.setText(null);
            form.txtElemento.setText(null);
        } else {
            String codigo = form.txtCodMater.getText().toString();
            String linea = codigo.split("\\.")[0];//para poder usar el .en eel split hay que colocar aaasi \\.lo mismo para cuando se usen -,*,+
            String grupo = codigo.split("\\.")[1];
            String elemento = codigo.split("\\.")[2];
            form.txtLinea.setText(linea);
            form.txtGrupo.setText(grupo);
            form.txtElemento.setText(elemento);
            punto.clear();
            numero.clear();
        }
    }

    public void txtCodMaterKeyTyped(FormEditarMaterial form, KeyEvent evt) {
        try {
            char Ca = evt.getKeyChar();
            if ((Ca < '0' || Ca > '9') && (Ca != '.') && (Ca != ',') && (Ca != 'v') && (Ca != 'V') && (Ca != evt.VK_DELETE) && (Ca != evt.VK_BACK_SPACE) && (Ca != evt.VK_CONTROL) && (Ca != evt.VK_ENTER)) {
                evt.consume();
            }
            String cadena = form.txtCodMater.getText();
            ArrayList<String> punto = new ArrayList<>();
            ArrayList<String> numero = new ArrayList<>();
            char[] arrayChar = cadena.toCharArray();
            for (int i = 0; i < arrayChar.length; i++) {
                if (arrayChar[i] == '.') {
                    punto.add(String.valueOf(arrayChar[i]));
                    System.out.println(punto.size());
                } else {
                    numero.add(String.valueOf(arrayChar[i]));
                }
            }
            if (punto.size() >= 3) {
                JOptionPane.showMessageDialog(null, "El Codigo Ingresado No Es Valido  \n" + "Por Favor Ingresar De De Nuevo");
                form.txtCodMater.setText(null);
                form.txtLinea.setText(null);
                form.txtGrupo.setText(null);
                form.txtElemento.setText(null);
                Robot robot = new Robot();//crea un nuevo objeto d ela clase robot 
                robot.keyPress(KeyEvent.VK_DELETE);
                robot.keyPress(KeyEvent.VK_BACK_SPACE);

            } else {
                if (Ca == evt.VK_ENTER) {
                    String codigo = form.txtCodMater.getText().toString();
                    String linea = codigo.split("\\.")[0];//para poder usar el .en eel split hay que colocar aaasi \\.lo mismo para cuando se usen -,*,+
                    String grupo = codigo.split("\\.")[1];
                    String elemento = codigo.split("\\.")[2];
                    form.txtLinea.setText(linea);
                    form.txtGrupo.setText(grupo);
                    form.txtElemento.setText(elemento);
                    form.txtNomMaterial.requestFocus();
                    punto.clear();
                    numero.clear();
                }
            }

        } catch (AWTException ex) {
            Logger.getLogger(FormRegistrarMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void txtNomMaterialFocusGained(FormEditarMaterial form) {
        String cadena = form.txtCodMater.getText();
        ArrayList<String> punto = new ArrayList<>();
        ArrayList<String> numero = new ArrayList<>();
        char[] arrayChar = cadena.toCharArray();
        for (int i = 0; i < arrayChar.length; i++) {
            if (arrayChar[i] == '.') {
                punto.add(String.valueOf(arrayChar[i]));
                System.out.println(punto.size());
                System.out.println(arrayChar[i] + " -> es la vocal a");
            } else {
                numero.add(String.valueOf(arrayChar[i]));
                System.out.println(arrayChar[i] + " -> no es la vocal a");
            }
        }
        if (punto.size() >= 3) {
            JOptionPane.showMessageDialog(null, "El Codigo Ingresado No Es Valido  \n" + "Por Favor Ingresar De De Nuevo");
            form.txtCodMater.setText(null);
            form.txtLinea.setText(null);
            form.txtGrupo.setText(null);
            form.txtElemento.setText(null);
        } else {
            String codigo = form.txtCodMater.getText().toString();
            String linea = codigo.split("\\.")[0];//para poder usar el .en eel split hay que colocar aaasi \\.lo mismo para cuando se usen -,*,+
            String grupo = codigo.split("\\.")[1];
            String elemento = codigo.split("\\.")[2];
            form.txtLinea.setText(linea);
            form.txtGrupo.setText(grupo);
            form.txtElemento.setText(elemento);
            punto.clear();
            numero.clear();
        }
    }

    public void TextoMayuscula(KeyEvent evt) {
        Character c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.setKeyChar(Character.toUpperCase(c));
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
