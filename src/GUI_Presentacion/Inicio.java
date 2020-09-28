/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Presentacion;

import GUI_Controlador.Controlador;
import Negocio_Util.Conectar;
import Negocio_Util.Desconectar;

/**
 *
 * @author User
 */
@SuppressWarnings("serial")
public class Inicio extends javax.swing.JFrame {

    private Metodos metodos = new Metodos();
    private Controlador Mycontrol;
    private int Cout = 0, ini = 0, fin = 25;

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        Conectar.AbrirConeccion();
        this.Mycontrol = new Controlador();
        metodos();
    }

    public void metodos() {
        metodos.propiedadesInicio(this);
        metodos.LlenarTabalaInventarioInicio(this);
        metodos.ajustartablaInicio(this);
        metodos.validarFiltroInventario(this);
    }

    public Controlador getMycontrol() {
        return Mycontrol;
    }

    public void setMycontrol(Controlador Mycontrol) {
        this.Mycontrol = Mycontrol;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DtbInventario = new com.nqadmin.swingSet.SSDataGrid();
        tlbrInventario = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        lblMaterial = new javax.swing.JLabel();
        chxbCodigoInvent = new javax.swing.JCheckBox();
        jButton24 = new javax.swing.JButton();
        chxbNombreInvent = new javax.swing.JCheckBox();
        cbxMaterial = new javax.swing.JComboBox<Object>();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        btnBuscar1 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        btnBuscar2 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        mnuListaMater = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        mnuRegistar = new javax.swing.JMenu();
        mnuItmRegMaterial = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        mnuExportar = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        mnuCargar = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio Bodega");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        DtbInventario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DtbInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        DtbInventario.setSSCellEditing(null);
        DtbInventario.setSSDataGridHandler(null);
        DtbInventario.setSSDataValue(null);
        DtbInventario.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jScrollPane2.setViewportView(DtbInventario);

        tlbrInventario.setRollover(true);
        tlbrInventario.setPreferredSize(new java.awt.Dimension(28, 28));

        jButton1.setBackground(new java.awt.Color(225, 225, 225));
        jButton1.setText(" ");
        jButton1.setEnabled(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton1);

        lblMaterial.setText("Filtrado Por: ");
        tlbrInventario.add(lblMaterial);

        chxbCodigoInvent.setText("Codigo  ");
        chxbCodigoInvent.setFocusable(false);
        chxbCodigoInvent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chxbCodigoInvent.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        chxbCodigoInvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chxbCodigoInventActionPerformed(evt);
            }
        });
        tlbrInventario.add(chxbCodigoInvent);

        jButton24.setBackground(new java.awt.Color(225, 225, 225));
        jButton24.setText(" ");
        jButton24.setEnabled(false);
        jButton24.setFocusable(false);
        jButton24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton24.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton24);

        chxbNombreInvent.setText("Descripción");
        chxbNombreInvent.setFocusable(false);
        chxbNombreInvent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chxbNombreInvent.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        chxbNombreInvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chxbNombreInventActionPerformed(evt);
            }
        });
        tlbrInventario.add(chxbNombreInvent);

        cbxMaterial.setRequestFocusEnabled(false);
        cbxMaterial.setVerifyInputWhenFocusTarget(false);
        cbxMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMaterialActionPerformed(evt);
            }
        });
        tlbrInventario.add(cbxMaterial);

        jButton2.setBackground(new java.awt.Color(225, 225, 225));
        jButton2.setText(" ");
        jButton2.setEnabled(false);
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton2);

        jButton4.setBackground(new java.awt.Color(225, 225, 225));
        jButton4.setText(" ");
        jButton4.setEnabled(false);
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton4);

        jButton5.setBackground(new java.awt.Color(225, 225, 225));
        jButton5.setText(" ");
        jButton5.setEnabled(false);
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton5);

        jButton6.setBackground(new java.awt.Color(225, 225, 225));
        jButton6.setText(" ");
        jButton6.setEnabled(false);
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton6);

        jButton3.setBackground(new java.awt.Color(225, 225, 225));
        jButton3.setText(" ");
        jButton3.setEnabled(false);
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton3);

        btnBuscar.setText("Filtrar");
        btnBuscar.setFocusable(false);
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        tlbrInventario.add(btnBuscar);

        jButton7.setBackground(new java.awt.Color(225, 225, 225));
        jButton7.setText(" ");
        jButton7.setEnabled(false);
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton7);

        jButton8.setBackground(new java.awt.Color(225, 225, 225));
        jButton8.setText(" ");
        jButton8.setEnabled(false);
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton8);

        jButton9.setBackground(new java.awt.Color(225, 225, 225));
        jButton9.setText(" ");
        jButton9.setEnabled(false);
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton9);

        jButton10.setBackground(new java.awt.Color(225, 225, 225));
        jButton10.setText(" ");
        jButton10.setEnabled(false);
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton10);

        jButton11.setBackground(new java.awt.Color(225, 225, 225));
        jButton11.setText(" ");
        jButton11.setEnabled(false);
        jButton11.setFocusable(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton11);

        jButton12.setBackground(new java.awt.Color(225, 225, 225));
        jButton12.setText(" ");
        jButton12.setEnabled(false);
        jButton12.setFocusable(false);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton12);

        btnBuscar1.setText("< Anterior");
        btnBuscar1.setFocusable(false);
        btnBuscar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });
        tlbrInventario.add(btnBuscar1);

        jButton13.setBackground(new java.awt.Color(225, 225, 225));
        jButton13.setText(" ");
        jButton13.setEnabled(false);
        jButton13.setFocusable(false);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton13);

        jButton14.setBackground(new java.awt.Color(225, 225, 225));
        jButton14.setText(" ");
        jButton14.setEnabled(false);
        jButton14.setFocusable(false);
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton14);

        jButton15.setBackground(new java.awt.Color(225, 225, 225));
        jButton15.setText(" ");
        jButton15.setEnabled(false);
        jButton15.setFocusable(false);
        jButton15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton15);

        jButton16.setBackground(new java.awt.Color(225, 225, 225));
        jButton16.setText(" ");
        jButton16.setEnabled(false);
        jButton16.setFocusable(false);
        jButton16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton16.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton16);

        jButton17.setBackground(new java.awt.Color(225, 225, 225));
        jButton17.setText(" ");
        jButton17.setEnabled(false);
        jButton17.setFocusable(false);
        jButton17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton17.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton17);

        jButton18.setBackground(new java.awt.Color(225, 225, 225));
        jButton18.setText(" ");
        jButton18.setEnabled(false);
        jButton18.setFocusable(false);
        jButton18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton18.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton18);

        btnBuscar2.setText("Siguiente >");
        btnBuscar2.setFocusable(false);
        btnBuscar2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar2ActionPerformed(evt);
            }
        });
        tlbrInventario.add(btnBuscar2);

        jButton19.setBackground(new java.awt.Color(225, 225, 225));
        jButton19.setText(" ");
        jButton19.setEnabled(false);
        jButton19.setFocusable(false);
        jButton19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton19.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton19);

        jButton20.setBackground(new java.awt.Color(225, 225, 225));
        jButton20.setText(" ");
        jButton20.setEnabled(false);
        jButton20.setFocusable(false);
        jButton20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton20.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton20);

        jButton21.setBackground(new java.awt.Color(225, 225, 225));
        jButton21.setText(" ");
        jButton21.setEnabled(false);
        jButton21.setFocusable(false);
        jButton21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton21.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton21);

        jButton22.setBackground(new java.awt.Color(225, 225, 225));
        jButton22.setText(" ");
        jButton22.setEnabled(false);
        jButton22.setFocusable(false);
        jButton22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton22.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton22);

        jButton23.setBackground(new java.awt.Color(225, 225, 225));
        jButton23.setText(" ");
        jButton23.setEnabled(false);
        jButton23.setFocusable(false);
        jButton23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton23.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbrInventario.add(jButton23);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addComponent(tlbrInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(tlbrInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        jScrollPane1.setViewportView(jPanel1);

        jMenu2.setText(" ");
        jMenu2.setEnabled(false);
        jMenuBar1.add(jMenu2);

        mnuListaMater.setText("Listado De Materiales");
        mnuListaMater.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuListaMaterMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnuListaMater);

        jMenu3.setText(" ");
        jMenu3.setEnabled(false);
        jMenuBar1.add(jMenu3);

        mnuRegistar.setText("Registrar");

        mnuItmRegMaterial.setText("Material");
        mnuItmRegMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItmRegMaterialActionPerformed(evt);
            }
        });
        mnuRegistar.add(mnuItmRegMaterial);

        jMenuBar1.add(mnuRegistar);

        jMenu6.setText(" ");
        jMenu6.setEnabled(false);
        jMenuBar1.add(jMenu6);

        mnuExportar.setText("Exportar");
        mnuExportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuExportarMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnuExportar);

        jMenu7.setText(" ");
        jMenu7.setEnabled(false);
        jMenuBar1.add(jMenu7);

        mnuCargar.setText("Cargar Datos");
        mnuCargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuCargarMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnuCargar);

        jMenu5.setText(" ");
        jMenu5.setEnabled(false);
        jMenuBar1.add(jMenu5);

        jMenu4.setText(" ");
        jMenu4.setEnabled(false);
        jMenuBar1.add(jMenu4);

        jMenu8.setText(" ");
        jMenu8.setEnabled(false);
        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Desconectar.CerrarConeccion();
    }//GEN-LAST:event_formWindowClosing

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        metodos.ajustartablaInicio(this);
    }//GEN-LAST:event_formComponentResized

    private void mnuListaMaterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuListaMaterMouseClicked
        metodos.AbrirFormMateriales(this);
    }//GEN-LAST:event_mnuListaMaterMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        metodos.BuscarEnInventario(this);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        metodos.mensajeInicio(this);
    }//GEN-LAST:event_formComponentShown

    private void mnuItmRegMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItmRegMaterialActionPerformed
        metodos.AbrirRegistrarMateriales(this);
    }//GEN-LAST:event_mnuItmRegMaterialActionPerformed

    private void mnuExportarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuExportarMouseClicked
        metodos.ExportarExelInventario(this);
    }//GEN-LAST:event_mnuExportarMouseClicked

    private void mnuCargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuCargarMouseClicked
        metodos.CargarDatos(this);
    }//GEN-LAST:event_mnuCargarMouseClicked

    private void chxbNombreInventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chxbNombreInventActionPerformed
        metodos.validarFiltroInventario(this);
    }//GEN-LAST:event_chxbNombreInventActionPerformed

    private void chxbCodigoInventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chxbCodigoInventActionPerformed
        metodos.validarFiltroInventario(this);
    }//GEN-LAST:event_chxbCodigoInventActionPerformed

    private void cbxMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMaterialActionPerformed

    }//GEN-LAST:event_cbxMaterialActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        try {
            ini -= 25;
            fin -= 25;
            if (ini < 0) {
                ini = 0;
                fin = 25;
                metodos.reiniciarJTable(DtbInventario);
                metodos.LlenarTabalaInventariopaginar(this, ini, fin);
            } else {
                System.out.println("  -ini " + ini);
                System.out.println("  -fin " + fin);
                metodos.reiniciarJTable(DtbInventario);
                metodos.LlenarTabalaInventariopaginar(this, ini, fin);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar2ActionPerformed
        try {
            ini += 25;
            fin += 25;
            if (fin > Mycontrol.maxInventario()) {
                ini = Mycontrol.maxInventario();
                fin = Mycontrol.maxInventario();
                System.out.println(Mycontrol.maxInventario());
                ini = 0;
                fin = 25;
                metodos.reiniciarJTable(DtbInventario);
                metodos.LlenarTabalaInventariopaginar(this, ini, fin);
            } else {
                System.out.println("  +ini " + ini);
                System.out.println("  +fin " + fin);
                metodos.reiniciarJTable(DtbInventario);
                metodos.LlenarTabalaInventariopaginar(this, ini, fin);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscar2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public com.nqadmin.swingSet.SSDataGrid DtbInventario;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnBuscar1;
    public javax.swing.JButton btnBuscar2;
    public javax.swing.JComboBox<Object> cbxMaterial;
    public javax.swing.JCheckBox chxbCodigoInvent;
    public javax.swing.JCheckBox chxbNombreInvent;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    public javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lblMaterial;
    public javax.swing.JMenu mnuCargar;
    public javax.swing.JMenu mnuExportar;
    public javax.swing.JMenuItem mnuItmRegMaterial;
    public javax.swing.JMenu mnuListaMater;
    public javax.swing.JMenu mnuRegistar;
    public javax.swing.JToolBar tlbrInventario;
    // End of variables declaration//GEN-END:variables
}