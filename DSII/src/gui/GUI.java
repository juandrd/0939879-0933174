/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.RutasJpaController;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

/**
 *
 * @author juandapp
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     *
     */
    int tipo_e;
    String usuario_id;

    public GUI() {
        initComponents();
        jPPrincipal.setLayout(new FlowLayout());
//        setResizable(false);
    }

    public GUI(int valor, String usuario_id) {


        initComponents();
        jPPrincipal.setLayout(new FlowLayout());
        tipo_e = valor;
        this.usuario_id = usuario_id;
        if (tipo_e == 1) { //El usuario es Gerente            
            jMIEstacion.setEnabled(false);
        }

        if (tipo_e == 2) { //El usuario es Vendedor
            jMReportes.setEnabled(false);
            jMIBuses.setEnabled(false);
            jMIEstacion.setEnabled(false);
        }
        if (tipo_e == 3) { //El usuario es jefe de taller
            jMReportes.setEnabled(false);
            jMVentas.setEnabled(false);
            jMIRutas.setEnabled(false);
            jMIBuses.setEnabled(false);

        }


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPPrincipal = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMPasajeros = new javax.swing.JMenu();
        jMILoginPasajeros = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        JMIReclamo = new javax.swing.JMenuItem();
        jMOpciones = new javax.swing.JMenu();
        jMICrearEmpleado = new javax.swing.JMenuItem();
        jMIRutas = new javax.swing.JMenuItem();
        jMIBuses = new javax.swing.JMenuItem();
        jMIEstacion = new javax.swing.JMenuItem();
        jMVentas = new javax.swing.JMenu();
        jMICrearCotizacion = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMIRegistrarVenta = new javax.swing.JMenuItem();
        jMReportes = new javax.swing.JMenu();
        jMIGenerarReporte = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPPrincipal.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        jPPrincipal.add(jLabel2);
        jLabel2.setBounds(0, 0, 670, 480);

        jMPasajeros.setText("Pasajeros");

        jMILoginPasajeros.setText("Login");
        jMILoginPasajeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMILoginPasajerosActionPerformed(evt);
            }
        });
        jMPasajeros.add(jMILoginPasajeros);
        jMPasajeros.add(jSeparator2);

        JMIReclamo.setText("Reclamos");
        JMIReclamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIReclamoActionPerformed(evt);
            }
        });
        jMPasajeros.add(JMIReclamo);

        jMenuBar1.add(jMPasajeros);

        jMOpciones.setText("Empleados");

        jMICrearEmpleado.setText("Crear");
        jMICrearEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICrearEmpleadoActionPerformed(evt);
            }
        });
        jMOpciones.add(jMICrearEmpleado);

        jMIRutas.setText("Rutas");
        jMIRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRutasActionPerformed(evt);
            }
        });
        jMOpciones.add(jMIRutas);

        jMIBuses.setText("Buses");
        jMIBuses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIBusesActionPerformed(evt);
            }
        });
        jMOpciones.add(jMIBuses);

        jMIEstacion.setText("Estaciones");
        jMIEstacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIEstacionActionPerformed(evt);
            }
        });
        jMOpciones.add(jMIEstacion);

        jMenuBar1.add(jMOpciones);

        jMVentas.setText(" Ventas  ");
        jMVentas.setEnabled(false);

        jMICrearCotizacion.setText("Crear Cotizacion");
        jMICrearCotizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICrearCotizacionActionPerformed(evt);
            }
        });
        jMVentas.add(jMICrearCotizacion);
        jMVentas.add(jSeparator3);

        jMIRegistrarVenta.setText("Registrar Venta");
        jMIRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRegistrarVentaActionPerformed(evt);
            }
        });
        jMVentas.add(jMIRegistrarVenta);

        jMenuBar1.add(jMVentas);

        jMReportes.setText(" Reportes  ");
        jMReportes.setEnabled(false);

        jMIGenerarReporte.setText("Generar Reporte");
        jMIGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIGenerarReporteActionPerformed(evt);
            }
        });
        jMReportes.add(jMIGenerarReporte);

        jMenuBar1.add(jMReportes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRutasActionPerformed
        ///interfaz completa
        try {
            jPPrincipal.removeAll();
        } catch (Exception e) {
        }
         
        JPRuta jPRR = new JPRuta();
        jPPrincipal.add(jPRR, BorderLayout.CENTER);
        jPPrincipal.updateUI();
        this.pack();
    }//GEN-LAST:event_jMIRutasActionPerformed

    private void jMIEstacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIEstacionActionPerformed
        try {
            jPPrincipal.removeAll();
        } catch (Exception e) {
        }
      JPEstacion jPO = new JPEstacion();
        jPPrincipal.add(jPO, BorderLayout.CENTER);
        jPPrincipal.updateUI();
        this.pack();
    }//GEN-LAST:event_jMIEstacionActionPerformed

    private void jMICrearCotizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICrearCotizacionActionPerformed
        try {
            jPPrincipal.removeAll();
        } catch (Exception e) {
        }
        //JPCotizacion jPC2 = new JPCotizacion();
        //jPPrincipal.add(jPC2, BorderLayout.CENTER);
        jPPrincipal.updateUI();
        this.pack();
    }//GEN-LAST:event_jMICrearCotizacionActionPerformed

    private void jMIRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRegistrarVentaActionPerformed
        try {
            jPPrincipal.removeAll();
        } catch (Exception e) {
        }
        //JPVenta jPV = new JPVenta();
        //jPPrincipal.add(jPV, BorderLayout.CENTER);
        jPPrincipal.updateUI();
        this.pack();
    }//GEN-LAST:event_jMIRegistrarVentaActionPerformed

    private void jMIBusesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIBusesActionPerformed
        ///interfaz completa
        try {
            jPPrincipal.removeAll();
        } catch (Exception e) {
        }
        JPBus jPB = new JPBus();
        jPPrincipal.add(jPB, BorderLayout.CENTER);
        jPPrincipal.updateUI();
        this.pack();
    }//GEN-LAST:event_jMIBusesActionPerformed

    private void jMIGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIGenerarReporteActionPerformed
        try {
            jPPrincipal.removeAll();
        } catch (Exception e) {
        }
        //JPReporte jPR = new JPReporte();
        //jPPrincipal.add(jPR, BorderLayout.CENTER);
        jPPrincipal.updateUI();
        this.pack();
    }//GEN-LAST:event_jMIGenerarReporteActionPerformed

    private void jMICrearEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICrearEmpleadoActionPerformed
        try {
            jPPrincipal.removeAll();
        } catch (Exception e) {
        }
        JPEmpleado jPE = new JPEmpleado();
        jPPrincipal.add(jPE, BorderLayout.CENTER);
        jPPrincipal.updateUI();
        this.pack();
    }//GEN-LAST:event_jMICrearEmpleadoActionPerformed

    private void jMILoginPasajerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMILoginPasajerosActionPerformed
        ///interfaz completa
        try {
            jPPrincipal.removeAll();
        } catch (Exception e) {
        }
        JPPasajero g = new JPPasajero();
        g.setBounds(jPPrincipal.getBounds());
        jPPrincipal.add(g, BorderLayout.CENTER);
        jPPrincipal.updateUI();
        this.pack();
    }//GEN-LAST:event_jMILoginPasajerosActionPerformed

    private void JMIReclamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIReclamoActionPerformed
       try {
            jPPrincipal.removeAll();
        } catch (Exception e) {
        }
        JPReclamo g = new JPReclamo();
        g.setBounds(jPPrincipal.getBounds());
        jPPrincipal.add(g, BorderLayout.CENTER);
        jPPrincipal.updateUI();
        this.pack();
    }//GEN-LAST:event_JMIReclamoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new GUI().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMIReclamo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMIBuses;
    private javax.swing.JMenuItem jMICrearCotizacion;
    private javax.swing.JMenuItem jMICrearEmpleado;
    private javax.swing.JMenuItem jMIEstacion;
    private javax.swing.JMenuItem jMIGenerarReporte;
    private javax.swing.JMenuItem jMILoginPasajeros;
    private javax.swing.JMenuItem jMIRegistrarVenta;
    private javax.swing.JMenuItem jMIRutas;
    private javax.swing.JMenu jMOpciones;
    private javax.swing.JMenu jMPasajeros;
    private javax.swing.JMenu jMReportes;
    private javax.swing.JMenu jMVentas;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPPrincipal;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
