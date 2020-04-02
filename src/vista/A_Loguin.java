
package vista;

//libreria para poner el ICONO

import controlador.UsuarioJpaController;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

import modelo.Usuario;
import persistencia.Persistencia;
import persistencia.Recursos;

public class A_Loguin extends javax.swing.JFrame {

    
    private UsuarioJpaController userJpa;
    private Usuario user;
    private Persistencia persistencia;

    public A_Loguin() {

        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("../iconos/IconoISTL.png")).getImage());
        setLocationRelativeTo(null);
        user = new Usuario();
        persistencia = new Persistencia();
        userJpa = new UsuarioJpaController(persistencia.getFactory());
        txtUsuario.requestFocus();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelBackgroundTitle1 = new org.edisoncor.gui.label.LabelBackgroundTitle();
        panelLoguin = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        labelUsuario = new javax.swing.JLabel();
        labelContraseña = new javax.swing.JLabel();
        btnAyuda = new javax.swing.JButton();
        barraProgreso = new javax.swing.JProgressBar();
        labelFondoLoguin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loguin");
        setMinimumSize(new java.awt.Dimension(366, 386));
        getContentPane().setLayout(null);

        panelLoguin.setMaximumSize(new java.awt.Dimension(366, 386));
        panelLoguin.setMinimumSize(new java.awt.Dimension(366, 386));
        panelLoguin.setPreferredSize(new java.awt.Dimension(366, 386));
        panelLoguin.setLayout(null);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btnSalir_1.png"))); // NOI18N
        btnCancelar.setBorder(null);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelLoguin.add(btnCancelar);
        btnCancelar.setBounds(80, 220, 80, 30);

        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btnIngresar_1.png"))); // NOI18N
        btnIngresar.setBorder(null);
        btnIngresar.setContentAreaFilled(false);
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        panelLoguin.add(btnIngresar);
        btnIngresar.setBounds(0, 220, 80, 30);

        txtUsuario.setBorder(null);
        panelLoguin.add(txtUsuario);
        txtUsuario.setBounds(60, 130, 110, 20);

        txtContraseña.setBorder(null);
        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyPressed(evt);
            }
        });
        panelLoguin.add(txtContraseña);
        txtContraseña.setBounds(60, 180, 110, 20);

        labelUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconoUsuario.png"))); // NOI18N
        panelLoguin.add(labelUsuario);
        labelUsuario.setBounds(10, 100, 50, 50);

        labelContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iconContraseña.png"))); // NOI18N
        panelLoguin.add(labelContraseña);
        labelContraseña.setBounds(10, 150, 50, 50);

        btnAyuda.setForeground(new java.awt.Color(240, 240, 240));
        btnAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btnAyuda_1.png"))); // NOI18N
        btnAyuda.setToolTipText("");
        btnAyuda.setBorder(null);
        btnAyuda.setContentAreaFilled(false);
        btnAyuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });
        panelLoguin.add(btnAyuda);
        btnAyuda.setBounds(0, 300, 80, 30);
        panelLoguin.add(barraProgreso);
        barraProgreso.setBounds(10, 260, 140, 14);

        labelFondoLoguin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Loguin.jpg"))); // NOI18N
        labelFondoLoguin.setMaximumSize(new java.awt.Dimension(366, 386));
        labelFondoLoguin.setMinimumSize(new java.awt.Dimension(366, 386));
        labelFondoLoguin.setPreferredSize(new java.awt.Dimension(366, 386));
        panelLoguin.add(labelFondoLoguin);
        labelFondoLoguin.setBounds(0, 0, 350, 350);

        getContentPane().add(panelLoguin);
        panelLoguin.setBounds(0, 0, 350, 350);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        cargarBarra();
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void txtContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cargarBarra();
        }
    }//GEN-LAST:event_txtContraseñaKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(A_Loguin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A_Loguin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A_Loguin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A_Loguin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new A_Loguin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgreso;
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIngresar;
    private org.edisoncor.gui.label.LabelBackgroundTitle labelBackgroundTitle1;
    private javax.swing.JLabel labelContraseña;
    private javax.swing.JLabel labelFondoLoguin;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel panelLoguin;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    public void validarUser() {
        user = userJpa.validarUsuario(txtUsuario.getText(), String.valueOf(txtContraseña.getText()));
        if (user != null) {
            Recursos.success("Sistema de Control de Gastos", "BIENVENIDO");
            B_Administracion adm = new B_Administracion(persistencia);
            adm.setVisible(true);
            this.dispose();
        } else {
            Recursos.warning("Sistema de Control de Gastos", "Usuario y/o Contraseña incorrecto(s)");
        }
    }

    public void cargarBarra() {
        Thread hilo = new Thread(new Runnable() {
            int a = 0;

            @Override
            public void run() {

                try {
                    while (a <= 100) {
                        Thread.sleep(10);
                        barraProgreso.setValue(a);

                        a++;
                    }
                    validarUser();
                } catch (Exception e) {
                }
            }
        });
        hilo.start();

    }

}
