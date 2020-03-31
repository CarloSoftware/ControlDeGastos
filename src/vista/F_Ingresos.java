package vista;

import controlador.IngresoJpaController;




import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.Ingreso;
import modeloTablas.TablaIngresos;

import persistencia.Persistencia;
import persistencia.Recursos;


public class F_Ingresos extends javax.swing.JInternalFrame {
    
    private TablaIngresos modelIngreso = new TablaIngresos();
    private IngresoJpaController IngresoJpa;
    private Persistencia pst;
    private Ingreso ingresos;
    private ListSelectionModel listaRolselect;
    private boolean seleccionar = false;
    
    public F_Ingresos(Persistencia pst) {
        
        initComponents();
        
        this.pst = pst;
        IngresoJpa = new IngresoJpaController(pst.getFactory());
        modelIngreso.setFilaIngreso(IngresoJpa.findIngresoEntities());//Sentencia que obtiene los datos de la BD

        tablaIngreso.setModel(modelIngreso);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        buttonIpod1 = new org.edisoncor.gui.button.ButtonIpod();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaIngreso = new javax.swing.JTable();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtConcepto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 3)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 70, 180, 20));

        buttonIpod1.setBackground(new java.awt.Color(255, 255, 255));
        buttonIpod1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/buscar.png"))); // NOI18N
        buttonIpod1.setText(".\n");
        buttonIpod1.setActionCommand("\n");
        buttonIpod1.setAutoscrolls(true);
        buttonIpod1.setFont(new java.awt.Font("Arial", 0, 1)); // NOI18N
        buttonIpod1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIpod1ActionPerformed(evt);
            }
        });
        jPanel1.add(buttonIpod1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 50, 50, 50));

        jLabel8.setFont(new java.awt.Font("Raleway", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("BUSCAR");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, 80, 20));

        tablaIngreso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaIngreso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaRolselect=tablaIngreso.getSelectionModel();
        listaRolselect.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                if(!e.getValueIsAdjusting()){
                    tbIngresoLineaSeleccionada(tablaIngreso);
                }
            }

        });
        jScrollPane1.setViewportView(tablaIngreso);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 970, 400));

        btnLimpiar.setFont(new java.awt.Font("Raleway", 1, 11)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(102, 102, 102));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconoEditar.png"))); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.setBorder(null);
        btnLimpiar.setOpaque(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 100, 34));

        btnEliminar.setFont(new java.awt.Font("Raleway", 1, 11)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(102, 102, 102));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconoEliminar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(null);
        btnEliminar.setOpaque(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 110, 33));

        btnEditar.setFont(new java.awt.Font("Raleway", 1, 11)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(102, 102, 102));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconoActualizar.png"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.setBorder(null);
        btnEditar.setBorderPainted(false);
        btnEditar.setOpaque(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 110, 33));

        btnGuardar.setFont(new java.awt.Font("Raleway", 1, 11)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(102, 102, 102));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconoGuardar.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorder(null);
        btnGuardar.setOpaque(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 100, 50));

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel11.setText("CANTIDAD:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 120, -1));

        txtCantidad.setBorder(null);
        jPanel2.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 180, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconoFoco.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 250, 230));

        txtConcepto.setBorder(null);
        jPanel2.add(txtConcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 180, -1));

        jLabel3.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabel3.setText("CONCEPTO:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 170, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 400));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void buttonIpod1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIpod1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonIpod1ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       crearIngreso();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editarIngreso();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarIngreso();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
       limpiarDatos();
    }//GEN-LAST:event_btnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private org.edisoncor.gui.button.ButtonIpod buttonIpod1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaIngreso;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtConcepto;
    // End of variables declaration//GEN-END:variables

    public void tbIngresoLineaSeleccionada(JTable tabla) {
        if (tabla.getSelectedRow() != -1) {
            seleccionar = true;
            controlBotones();
            ingresos = modelIngreso.getFilaIngreso().get(tabla.getSelectedRow());
           
            txtConcepto.setText(ingresos.getConcepto());
            txtCantidad.setText(ingresos.getCantidad());
            
        }
    }
    
    public void controlBotones() {
        if (seleccionar) {
            btnGuardar.setEnabled(false);
            btnEditar.setEnabled(true);
//            btnLimpiar.setEnabled(false);
            btnEliminar.setEnabled(true);
        } else {
            btnGuardar.setEnabled(true);
            btnEditar.setEnabled(false);
//            btnLimpiar.setEnabled(true);
            btnEliminar.setEnabled(false);
        }
    }
    
    public void limpiarDatos() {
        
        txtConcepto.setText("");
        txtCantidad.setText("");
        
        seleccionar = false;
        
        tablaIngreso.getSelectionModel().clearSelection();//Limpia la seleccion de la tabla o la linea resaltada con la flecha

        ingresos = null; // Despues de obtener la linea seleccionada borra los campos de los txt
        controlBotones();
    }
    
    public Ingreso validarCampos() {
        if (!txtConcepto.getText().equals("")) {
            ingresos.setConcepto(txtConcepto.getText());
            
            if (!txtCantidad.getText().equals("")) {
                ingresos.setCantidad(txtCantidad.getText());
            } else {
                Recursos.warning("Sistema de Control de Gastos", "Ingrese su nombre de Usuario");
            }
            
        } else {
            Recursos.warning("Sistema de Control de Gastos", "Ingrese su NOMBRE DE USUARIO");
        }
        return ingresos;
    }
    
    public void crearIngreso() {
        try {
//            persona = new Persona(); //Despues de obtener y limpiar los campos vuelve a designar a una persona como vacio
            IngresoJpa.create(validarCampos());
            modelIngreso.agregar(ingresos);
            limpiarDatos();
            Recursos.success("Sistema de Control de Gatos", "Usted se ha registrado su contraseña y usuario correctamente");
        } catch (Exception e) {
            
        }
    }
    
    public void editarIngreso() {
        if (validarCampos() != null) {
            ingresos.setConcepto(txtConcepto.getText());
            ingresos.setCantidad(txtCantidad.getText());
            
            try {
                IngresoJpa.edit(ingresos);
                modelIngreso.editar(ingresos);
                limpiarDatos();
            } catch (Exception e) {
            }
            Recursos.success("Sistema de Control de Gastos", "Ha modificado sus datos correctamente");
            
        } else {
            Recursos.warning("Sistema de Control de Gastos", "No se ha podido modificar sus datos");
        }
        
    }
    
    public void eliminarIngreso() {
        try {
            IngresoJpa.destroy(ingresos.getIdIngreso());
            modelIngreso.eliminar();
            Recursos.success("Sistema de COntrol de Gastos", "Se ha eliminado del registro de forma correcta");
            limpiarDatos();
        } catch (Exception e) {
        }
    }
    
}
