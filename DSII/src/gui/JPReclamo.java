/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controladores.ControladorEstacion;
import controladores.ControladorPasajero;
import controladores.ControladorReclamo;
import entidades.Pasajeros;
import entidades.Estaciones;
import entidades.Reclamos;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Juan
 */
public class JPReclamo extends javax.swing.JPanel {

    /**
     * Creates new form JPReclamo
     */
    ControladorReclamo controladorReclamo;
    ControladorPasajero controladorPasajero;
    ControladorEstacion controladorEstacion;

    public JPReclamo() {
        initComponents();
        controladorEstacion = new ControladorEstacion();
        controladorPasajero = new ControladorPasajero();
        controladorReclamo = new ControladorReclamo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTPReclamo = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTFCod1 = new javax.swing.JTextField();
        jBLimpiar1 = new javax.swing.JButton();
        jBCrear1 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jCBPasajero1 = new javax.swing.JComboBox();
        jCBEstacion1 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTADescripcion1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jBLimpiarConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTResultados = new javax.swing.JTable();
        jBConsultar1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTFCod2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jCBPasajero2 = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        jCBEstacion2 = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jBModificar = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jTFCod3 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTADescripcion3 = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jCBEstacion3 = new javax.swing.JComboBox();
        jCBPasajero3 = new javax.swing.JComboBox();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Reclamo"));

        jPanel7.setLayout(null);

        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setLayout(null);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Pasajero");
        jPanel8.add(jLabel11);
        jLabel11.setBounds(0, 170, 90, 30);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Codigo");
        jPanel8.add(jLabel12);
        jLabel12.setBounds(0, 10, 80, 30);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Descripcion");
        jPanel8.add(jLabel13);
        jLabel13.setBounds(-10, 50, 120, 30);
        jPanel8.add(jTFCod1);
        jTFCod1.setBounds(100, 10, 180, 30);

        jBLimpiar1.setText("Limpiar");
        jBLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiar1ActionPerformed(evt);
            }
        });
        jPanel8.add(jBLimpiar1);
        jBLimpiar1.setBounds(100, 270, 70, 23);

        jBCrear1.setText("Crear");
        jBCrear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCrear1ActionPerformed(evt);
            }
        });
        jPanel8.add(jBCrear1);
        jBCrear1.setBounds(220, 270, 59, 23);

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Estacion");
        jPanel8.add(jLabel28);
        jLabel28.setBounds(0, 220, 90, 30);

        jCBPasajero1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Troncal", "Alimentador", "Padron" }));
        jCBPasajero1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jCBPasajero1PopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel8.add(jCBPasajero1);
        jCBPasajero1.setBounds(100, 170, 180, 30);

        jCBEstacion1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        jCBEstacion1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jCBEstacion1PopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel8.add(jCBEstacion1);
        jCBEstacion1.setBounds(100, 220, 180, 30);

        jTADescripcion1.setColumns(20);
        jTADescripcion1.setRows(5);
        jScrollPane2.setViewportView(jTADescripcion1);

        jPanel8.add(jScrollPane2);
        jScrollPane2.setBounds(100, 60, 180, 96);

        jPanel7.add(jPanel8);
        jPanel8.setBounds(0, 0, 450, 380);

        jTPReclamo.addTab("Crear", jPanel7);

        jPanel3.setLayout(null);

        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel9.setLayout(null);

        jBLimpiarConsultar.setText("Limpiar");
        jBLimpiarConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarConsultarActionPerformed(evt);
            }
        });
        jPanel9.add(jBLimpiarConsultar);
        jBLimpiarConsultar.setBounds(290, 100, 90, 23);

        jTResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Pasajero", "Estacion", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        jPanel9.add(jScrollPane1);
        jScrollPane1.setBounds(20, 200, 410, 100);

        jBConsultar1.setText("Consultar");
        jBConsultar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultar1ActionPerformed(evt);
            }
        });
        jPanel9.add(jBConsultar1);
        jBConsultar1.setBounds(290, 140, 90, 23);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Codigo");
        jPanel9.add(jLabel14);
        jLabel14.setBounds(0, 10, 80, 30);
        jPanel9.add(jTFCod2);
        jTFCod2.setBounds(100, 10, 180, 30);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Pasajero");
        jPanel9.add(jLabel15);
        jLabel15.setBounds(0, 50, 90, 30);

        jCBPasajero2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Troncal", "Alimentador", "Padron" }));
        jCBPasajero2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jCBPasajero2PopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel9.add(jCBPasajero2);
        jCBPasajero2.setBounds(100, 50, 180, 30);

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Estacion");
        jPanel9.add(jLabel31);
        jLabel31.setBounds(0, 100, 90, 30);

        jCBEstacion2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        jCBEstacion2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jCBEstacion2PopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel9.add(jCBEstacion2);
        jCBEstacion2.setBounds(100, 100, 180, 30);

        jPanel3.add(jPanel9);
        jPanel9.setBounds(0, 0, 590, 340);

        jTPReclamo.addTab("Consultar", jPanel3);

        jPanel4.setLayout(null);

        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.setLayout(null);

        jBModificar.setText("Modificar");
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });
        jPanel10.add(jBModificar);
        jBModificar.setBounds(170, 270, 110, 23);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Codigo");
        jPanel10.add(jLabel24);
        jLabel24.setBounds(-10, 10, 80, 30);

        jTFCod3.setEditable(false);
        jTFCod3.setEnabled(false);
        jPanel10.add(jTFCod3);
        jTFCod3.setBounds(100, 10, 180, 30);

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Descripcion");
        jPanel10.add(jLabel25);
        jLabel25.setBounds(-10, 50, 110, 30);

        jTADescripcion3.setColumns(20);
        jTADescripcion3.setRows(5);
        jScrollPane3.setViewportView(jTADescripcion3);

        jPanel10.add(jScrollPane3);
        jScrollPane3.setBounds(100, 56, 180, 100);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Pasajero");
        jPanel10.add(jLabel16);
        jLabel16.setBounds(0, 170, 90, 30);

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Estacion");
        jPanel10.add(jLabel32);
        jLabel32.setBounds(0, 220, 90, 30);

        jCBEstacion3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        jCBEstacion3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jCBEstacion3PopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel10.add(jCBEstacion3);
        jCBEstacion3.setBounds(100, 220, 180, 30);

        jCBPasajero3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Troncal", "Alimentador", "Padron" }));
        jCBPasajero3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jCBPasajero3PopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel10.add(jCBPasajero3);
        jCBPasajero3.setBounds(100, 170, 180, 30);

        jPanel4.add(jPanel10);
        jPanel10.setBounds(0, 10, 450, 320);

        jTPReclamo.addTab("Modificar", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTPReclamo, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTPReclamo, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiar1ActionPerformed
        jTFCod1.setText("");
        jTADescripcion1.setText("");
        jCBPasajero1.setSelectedIndex(0);
        jCBEstacion1.setSelectedIndex(0);
    }//GEN-LAST:event_jBLimpiar1ActionPerformed

    private void jBCrear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCrear1ActionPerformed

        int guardar = -1;
        try {

            String codigo = jTFCod1.getText();
            String descripcion = jTADescripcion1.getText();
            Pasajeros pasajero = controladorPasajero.consultar(jCBPasajero1.getSelectedItem().toString());
            Estaciones estacion = controladorEstacion.consultar(jCBEstacion1.getSelectedItem().toString());

            guardar = controladorReclamo.insertar(codigo, descripcion, pasajero, estacion);

        } catch (Exception e) {
        }
        if (guardar == -1) {
            JOptionPane.showMessageDialog(this, "No se pudo crear ", "Error Base Datos", JOptionPane.ERROR_MESSAGE);
        } else {

            if (guardar == 1) {

                JOptionPane.showMessageDialog(this, "Ya existe el Codigo del Reclamo ", "Error", ERROR);


            } else {
                JOptionPane.showMessageDialog(this, "Reclamo Creado correctamente", "Sistema", JOptionPane.INFORMATION_MESSAGE);

                limpiarCamposConsultar();
                jTFCod2.setText(jTFCod1.getText());
                jBConsultar1.doClick();
                jTPReclamo.setSelectedIndex(1);
                jBLimpiar1.doClick();
            }
        }
    }//GEN-LAST:event_jBCrear1ActionPerformed

    private void jCBEstacion1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jCBEstacion1PopupMenuWillBecomeVisible
        jCBEstacion1.setModel(
                new javax.swing.DefaultComboBoxModel(controladorEstacion.listar()));
    }//GEN-LAST:event_jCBEstacion1PopupMenuWillBecomeVisible

    private void jBLimpiarConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarConsultarActionPerformed
        limpiarCamposConsultar();
    }//GEN-LAST:event_jBLimpiarConsultarActionPerformed
    public void limpiarCamposConsultar() {
        jTFCod2.setText("");
        jCBPasajero2.setSelectedIndex(0);
        jCBEstacion2.setSelectedIndex(0);
    }
    private void jTResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTResultadosMouseClicked

        int selectedRow = jTResultados.getSelectedRow();
        jCBEstacion3.setModel(
                new javax.swing.DefaultComboBoxModel(controladorEstacion.listar()));
        jCBPasajero3.setModel(
                new javax.swing.DefaultComboBoxModel(controladorPasajero.listar()));

        jTFCod3.setText("" + jTResultados.getModel().getValueAt(selectedRow, 0));
        jCBPasajero3.setSelectedItem("" + jTResultados.getModel().getValueAt(selectedRow, 1));
        jCBEstacion3.setSelectedItem("" + jTResultados.getModel().getValueAt(selectedRow, 2));
        jTADescripcion3.setText("" + jTResultados.getModel().getValueAt(selectedRow, 3));


        jTPReclamo.setSelectedIndex(2);
    }//GEN-LAST:event_jTResultadosMouseClicked

    private void jBConsultar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultar1ActionPerformed
        LinkedList consulta = new LinkedList();

        try {



            consulta = controladorReclamo.consultar(
                    jTFCod2.getText(),
                    jCBPasajero2.getSelectedItem().toString(),
                    jCBEstacion2.getSelectedItem().toString());

            Object[][] s = new Object[consulta.size()][4];
            for (int i = 0; i < consulta.size(); i++) {
                Reclamos r = (Reclamos) consulta.get(i);
                if (r.getCodigo() != null) {
                    s[i][0] = r.getCodigo();
                    s[i][1] = r.getPasajero();
                    s[i][2] = r.getEstacion();
                    s[i][3] = r.getDescripcion();


                } else {
                    s = null;
                }
            }
            TableModel myModel = new DefaultTableModel(s, new String[]{
                        "Codigo", "Pasajero", "Estacion",
                        "Descripcion"}) {

                boolean[] canEdit = new boolean[]{false, false, false, false};

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

    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed
        int editar = -1;

        try {

            Pasajeros p = controladorPasajero.consultar(jCBPasajero3.getSelectedItem().toString());
           Estaciones estacion = controladorEstacion.consultar(jCBEstacion3.getSelectedItem().toString());
            
            editar = controladorReclamo.modificar(
                    jTFCod3.getText(),
                    jTADescripcion3.getText(),
                    p,
                    estacion);


        } catch (Exception e) {
            System.out.print(e);
        }
        if (editar == -1) {
            JOptionPane.showMessageDialog(this, "No su pudo modificar", "Error Base Datos", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "modificado correctamente", "Base Datos", JOptionPane.INFORMATION_MESSAGE);
            limpiarCamposConsultar();
            jTResultados.removeAll();
            jTFCod2.setText(jTFCod3.getText());
            jBConsultar1.doClick();
            jTPReclamo.setSelectedIndex(1);
            
        }
    }//GEN-LAST:event_jBModificarActionPerformed

    private void jCBEstacion2PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jCBEstacion2PopupMenuWillBecomeVisible
        // TODO add your handling code here:
          jCBEstacion2.setModel(
                new javax.swing.DefaultComboBoxModel(controladorEstacion.listar()));
   
    }//GEN-LAST:event_jCBEstacion2PopupMenuWillBecomeVisible

    private void jCBEstacion3PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jCBEstacion3PopupMenuWillBecomeVisible
         jCBEstacion3.setModel(
                new javax.swing.DefaultComboBoxModel(controladorEstacion.listar()));
   
    }//GEN-LAST:event_jCBEstacion3PopupMenuWillBecomeVisible

    private void jCBPasajero1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jCBPasajero1PopupMenuWillBecomeVisible
        jCBPasajero1.setModel(
                new javax.swing.DefaultComboBoxModel(controladorPasajero.listar()));
   
    }//GEN-LAST:event_jCBPasajero1PopupMenuWillBecomeVisible

    private void jCBPasajero2PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jCBPasajero2PopupMenuWillBecomeVisible
         jCBPasajero2.setModel(
                new javax.swing.DefaultComboBoxModel(controladorPasajero.listar()));
   
    }//GEN-LAST:event_jCBPasajero2PopupMenuWillBecomeVisible

    private void jCBPasajero3PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jCBPasajero3PopupMenuWillBecomeVisible
        jCBPasajero3.setModel(
                new javax.swing.DefaultComboBoxModel(controladorPasajero.listar()));
   
    }//GEN-LAST:event_jCBPasajero3PopupMenuWillBecomeVisible

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBConsultar1;
    private javax.swing.JButton jBCrear1;
    private javax.swing.JButton jBLimpiar1;
    private javax.swing.JButton jBLimpiarConsultar;
    private javax.swing.JButton jBModificar;
    private javax.swing.JComboBox jCBEstacion1;
    private javax.swing.JComboBox jCBEstacion2;
    private javax.swing.JComboBox jCBEstacion3;
    private javax.swing.JComboBox jCBPasajero1;
    private javax.swing.JComboBox jCBPasajero2;
    private javax.swing.JComboBox jCBPasajero3;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTADescripcion1;
    private javax.swing.JTextArea jTADescripcion3;
    private javax.swing.JTextField jTFCod1;
    private javax.swing.JTextField jTFCod2;
    private javax.swing.JTextField jTFCod3;
    private javax.swing.JTabbedPane jTPReclamo;
    private javax.swing.JTable jTResultados;
    // End of variables declaration//GEN-END:variables
}