/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JOptionPane;
import controladores.*;
import entidades.Movilizacion;
import entidades.Pasajeros;
import entidades.Rutas;
import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Juan
 */
public class JPMovilizacion extends javax.swing.JPanel {

    /**
     * Creates new form JPMovilizacion
     */
    ControladorPasajero controladorPasajero;
    ControladorRuta controladorRuta;
    ControladorMovilizacion controladorMovilizacion;

    public JPMovilizacion() {
        initComponents();
        controladorPasajero = new ControladorPasajero();
        controladorRuta = new ControladorRuta();
        controladorMovilizacion = new ControladorMovilizacion();

         jCBPasajero2.setModel(
                new javax.swing.DefaultComboBoxModel(controladorPasajero.listar()));
    jCBRuta2.setModel(
                new javax.swing.DefaultComboBoxModel(controladorRuta.listar()));
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTPVentas = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jBLimpiar3 = new javax.swing.JButton();
        jBCrear1 = new javax.swing.JButton();
        jCBPasajero1 = new javax.swing.JComboBox();
        jCBRuta1 = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jDCFecha1 = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTResultados = new javax.swing.JTable();
        jBConsultar1 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jCBPasajero2 = new javax.swing.JComboBox();
        jCBRuta2 = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Simular Viaje"));

        jPanel11.setLayout(null);

        jPanel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel12.setLayout(null);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Pasajero");
        jPanel12.add(jLabel21);
        jLabel21.setBounds(10, 10, 60, 30);

        jBLimpiar3.setText("Limpiar");
        jBLimpiar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiar3ActionPerformed(evt);
            }
        });
        jPanel12.add(jBLimpiar3);
        jBLimpiar3.setBounds(130, 180, 70, 23);

        jBCrear1.setText("Crear");
        jBCrear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCrear1ActionPerformed(evt);
            }
        });
        jPanel12.add(jBCrear1);
        jBCrear1.setBounds(240, 180, 59, 23);

        jCBPasajero1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jCBPasajero1PopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel12.add(jCBPasajero1);
        jCBPasajero1.setBounds(110, 10, 180, 30);

        jCBRuta1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        jCBRuta1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jCBRuta1PopupMenuWillBecomeVisible(evt);
            }
        });
        jCBRuta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBRuta1ActionPerformed(evt);
            }
        });
        jPanel12.add(jCBRuta1);
        jCBRuta1.setBounds(110, 70, 180, 30);

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Fecha");
        jPanel12.add(jLabel29);
        jLabel29.setBounds(-10, 120, 90, 30);

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Ruta");
        jPanel12.add(jLabel30);
        jLabel30.setBounds(-10, 70, 90, 30);

        jDCFecha1.setDateFormatString("yyyy-MMM-dd");
        jPanel12.add(jDCFecha1);
        jDCFecha1.setBounds(110, 130, 150, 20);

        jPanel11.add(jPanel12);
        jPanel12.setBounds(0, 0, 350, 230);

        jTPVentas.addTab("Simular", jPanel11);

        jPanel3.setLayout(null);

        jPanel13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel13.setLayout(null);

        jTResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id-Pasajero", "Nombre", "Apellido", "Ruta", "Fechal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTResultadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTResultados);

        jPanel13.add(jScrollPane1);
        jScrollPane1.setBounds(10, 120, 370, 130);

        jBConsultar1.setText("Consultar");
        jBConsultar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultar1ActionPerformed(evt);
            }
        });
        jPanel13.add(jBConsultar1);
        jBConsultar1.setBounds(290, 60, 90, 23);

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Pasajero");
        jPanel13.add(jLabel27);
        jLabel27.setBounds(-10, 10, 80, 30);

        jCBPasajero2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jCBPasajero2PopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel13.add(jCBPasajero2);
        jCBPasajero2.setBounds(80, 10, 180, 30);

        jCBRuta2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        jCBRuta2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jCBRuta2PopupMenuWillBecomeVisible(evt);
            }
        });
        jCBRuta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBRuta2ActionPerformed(evt);
            }
        });
        jPanel13.add(jCBRuta2);
        jCBRuta2.setBounds(80, 70, 180, 30);

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Ruta");
        jPanel13.add(jLabel31);
        jLabel31.setBounds(-20, 70, 90, 30);

        jPanel3.add(jPanel13);
        jPanel13.setBounds(0, 0, 590, 270);

        jTPVentas.addTab("Consultar", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTPVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTPVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBLimpiar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiar3ActionPerformed
        jCBPasajero1.setSelectedIndex(0);
        jCBRuta1.setSelectedIndex(0);

    }//GEN-LAST:event_jBLimpiar3ActionPerformed

    private void jBCrear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCrear1ActionPerformed

        int guardar = -1;
        try {

            java.sql.Date fecha = new java.sql.Date(jDCFecha1.getDate().getTime());
            String pasajero = jCBPasajero1.getSelectedItem().toString();
            Pasajeros p = controladorPasajero.consultar(pasajero);
            String ruta = jCBRuta1.getSelectedItem().toString();
            Rutas r = controladorRuta.consultar(ruta);

            guardar = controladorMovilizacion.insertar(p, r, fecha);


        } catch (Exception e) {
        }
        if (guardar == -1) {
            JOptionPane.showMessageDialog(this, "No se pudo crear ", "Error Base Datos", JOptionPane.ERROR_MESSAGE);
        } else {

            if (guardar == 1) {

                JOptionPane.showMessageDialog(this, "Ya existe  ", "Error", ERROR);


            } else {

                JOptionPane.showMessageDialog(this, "Movilizacion Simulada correctamente", "Sistema", JOptionPane.INFORMATION_MESSAGE);
            }


        }

    }//GEN-LAST:event_jBCrear1ActionPerformed

    private void jCBPasajero1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jCBPasajero1PopupMenuWillBecomeVisible
        // TODO add your handling code here:
        jCBPasajero1.setModel(
                new javax.swing.DefaultComboBoxModel(controladorPasajero.listar()));
    }//GEN-LAST:event_jCBPasajero1PopupMenuWillBecomeVisible

    private void jCBRuta1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jCBRuta1PopupMenuWillBecomeVisible

        jCBRuta1.setModel(
                new javax.swing.DefaultComboBoxModel(controladorRuta.listar()));

    }//GEN-LAST:event_jCBRuta1PopupMenuWillBecomeVisible

    private void jCBRuta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBRuta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBRuta1ActionPerformed

    private void jTResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTResultadosMouseClicked
    }//GEN-LAST:event_jTResultadosMouseClicked

    private void jBConsultar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultar1ActionPerformed
        LinkedList consulta = new LinkedList();

        try {

            if (!jCBPasajero2.getSelectedItem().toString().equals(" ") || !jCBRuta2.getSelectedItem().toString().equals(" ")) {
                if (!jCBPasajero2.getSelectedItem().toString().equals(" ") && !jCBRuta2.getSelectedItem().toString().equals(" ")) {

                    consulta = controladorMovilizacion.consultar(jCBPasajero2.getSelectedItem().toString(),
                            jCBRuta2.getSelectedItem().toString());
                }
                if (!jCBPasajero2.getSelectedItem().toString().equals(" ") && jCBRuta2.getSelectedItem().toString().equals(" ")) {

                    consulta = controladorMovilizacion.consultarporPasajero(jCBPasajero2.getSelectedItem().toString());

                }
                if (jCBPasajero2.getSelectedItem().toString().equals(" ") && !jCBRuta2.getSelectedItem().toString().equals(" ")) {
                    consulta = controladorMovilizacion.consultarporRuta(jCBRuta2.getSelectedItem().toString());
                }

            } else {
                consulta = controladorMovilizacion.consultarAll();
            }

            //consulta = controladorMovilizacion.consultar(
            //      jCBPasajero2.getSelectedItem().toString(), jCBRuta2.getSelectedItem().toString(),            );

            Object[][] s = new Object[consulta.size()][5];
            for (int i = 0; i < consulta.size(); i++) {
                Movilizacion m = (Movilizacion) consulta.get(i);

                if (m.getMovilizacionPK().getPasajero() != null) {
                    Pasajeros p = controladorPasajero.consultar(m.getMovilizacionPK().getPasajero());

                    s[i][0] = m.getMovilizacionPK().getPasajero();
                    s[i][1] = p.getNombres();
                    s[i][2] = p.getApellidos();
                    s[i][3] = m.getMovilizacionPK().getRuta();
                    s[i][4] = m.getMovilizacionPK().getFecha().toString();

                } else {
                    s = null;
                }
            }

            TableModel myModel = new DefaultTableModel(s, new String[]{"Id","Nombre","Apellido", "Ruta","Fecha"}) {

                boolean[] canEdit = new boolean[]{false, false,false,false,false
                };

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            };
            ///remover filas
            jTResultados.setModel(myModel);
            jTResultados.setRowSorter(new TableRowSorter(myModel));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBConsultar1ActionPerformed

    private void jCBPasajero2PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jCBPasajero2PopupMenuWillBecomeVisible
        // TODO add your handling code here:
        jCBPasajero1.setModel(
                new javax.swing.DefaultComboBoxModel(controladorPasajero.listar()));

    }//GEN-LAST:event_jCBPasajero2PopupMenuWillBecomeVisible

    private void jCBRuta2PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jCBRuta2PopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBRuta2PopupMenuWillBecomeVisible

    private void jCBRuta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBRuta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBRuta2ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBConsultar1;
    private javax.swing.JButton jBCrear1;
    private javax.swing.JButton jBLimpiar3;
    private javax.swing.JComboBox jCBPasajero1;
    private javax.swing.JComboBox jCBPasajero2;
    private javax.swing.JComboBox jCBRuta1;
    private javax.swing.JComboBox jCBRuta2;
    private com.toedter.calendar.JDateChooser jDCFecha1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTPVentas;
    private javax.swing.JTable jTResultados;
    // End of variables declaration//GEN-END:variables
}
