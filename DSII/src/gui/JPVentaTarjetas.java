/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controladores.ControladorPasajero;
import controladores.ControladorTarjetasPersonalizadas;
import controladores.ControladorPasajeroPersonalizado;
import entidades.Pasajeros;
import entidades.PasajerosPersonalizadas;
import entidades.PasajerosPersonalizadasPK;
import entidades.TarjetasPersonalizadas;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Juan
 */
public class JPVentaTarjetas extends javax.swing.JPanel {

    /**
     * Creates new form JPVentaTarjetas
     */
    
    ControladorTarjetasPersonalizadas controladorTP;
    ControladorPasajero controladorPasajero;
    ControladorPasajeroPersonalizado controladorPP;
    public JPVentaTarjetas() {
        initComponents();
        controladorTP= new ControladorTarjetasPersonalizadas();
        controladorPasajero=new ControladorPasajero();
        controladorPP=new ControladorPasajeroPersonalizado();
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
        jLabel28 = new javax.swing.JLabel();
        jCBPasajero1 = new javax.swing.JComboBox();
        jCBTarjeta1 = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jBLimpiarConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTResultados = new javax.swing.JTable();
        jBConsultar1 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jCBPasajero2 = new javax.swing.JComboBox();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Venta de Tarjetas"));

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
        jBLimpiar3.setBounds(120, 120, 70, 23);

        jBCrear1.setText("Crear");
        jBCrear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCrear1ActionPerformed(evt);
            }
        });
        jPanel12.add(jBCrear1);
        jBCrear1.setBounds(230, 120, 59, 23);

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Tarjeta");
        jPanel12.add(jLabel28);
        jLabel28.setBounds(-10, 60, 90, 30);

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

        jCBTarjeta1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        jCBTarjeta1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jCBTarjeta1PopupMenuWillBecomeVisible(evt);
            }
        });
        jPanel12.add(jCBTarjeta1);
        jCBTarjeta1.setBounds(110, 60, 180, 30);

        jPanel11.add(jPanel12);
        jPanel12.setBounds(0, 0, 340, 210);

        jTPVentas.addTab("Vender", jPanel11);

        jPanel3.setLayout(null);

        jPanel13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel13.setLayout(null);

        jBLimpiarConsultar.setText("Limpiar");
        jBLimpiarConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarConsultarActionPerformed(evt);
            }
        });
        jPanel13.add(jBLimpiarConsultar);
        jBLimpiarConsultar.setBounds(290, 30, 90, 23);

        jTResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pasajero", "Pin Tarjeta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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
        jScrollPane1.setBounds(30, 120, 410, 100);

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

        jPanel3.add(jPanel13);
        jPanel13.setBounds(0, 0, 590, 270);

        jTPVentas.addTab("Consultar", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTPVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTPVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBConsultar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultar1ActionPerformed
       LinkedList consulta = new LinkedList();

        try {
            
            
            
            consulta = controladorPP.consultar(
                 
                    jCBPasajero2.getSelectedItem().toString()
                 );

            Object[][] s = new Object[consulta.size()][2];
            for (int i = 0; i < consulta.size(); i++) {
                PasajerosPersonalizadas p = (PasajerosPersonalizadas) consulta.get(i);
                if (p.getPasajerosPersonalizadasPK().getIdentificacion() != null) {
                    s[i][0] = p.getPasajerosPersonalizadasPK().getIdentificacion();
                    s[i][1] = p.getPasajerosPersonalizadasPK().getPinTarjeta();
                

                } else {
                    s = null;
                }
            }
            TableModel myModel = new DefaultTableModel(s, new String[]{
                         "Pasajero", "Pin Tarjeta"}) {

                boolean[] canEdit = new boolean[]{ false, false};

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

    private void jTResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTResultadosMouseClicked

//        int selectedRow = jTResultados.getSelectedRow();
//        jCBRuta3.setModel(
//                new javax.swing.DefaultComboBoxModel(controladorRuta.listar()));
//        jTFPlaca3.setText("" + jTResultados.getModel().getValueAt(selectedRow, 0));
//        jTFMarca3.setText("" + jTResultados.getModel().getValueAt(selectedRow, 1));
//        jTFChasis3.setText("" + jTResultados.getModel().getValueAt(selectedRow, 2));
//        jCBTipo3.setSelectedItem("" + jTResultados.getModel().getValueAt(selectedRow, 3));
//        jTFAsientos3.setText("" + jTResultados.getModel().getValueAt(selectedRow, 4));
//        jTFCapacidad3.setText("" + jTResultados.getModel().getValueAt(selectedRow, 5));
//        jCBRuta3.setSelectedItem("" + jTResultados.getModel().getValueAt(selectedRow, 6));
//
//
//        jTPBus.setSelectedIndex(2);
    }//GEN-LAST:event_jTResultadosMouseClicked

    private void jBLimpiarConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarConsultarActionPerformed
        
    }//GEN-LAST:event_jBLimpiarConsultarActionPerformed

    private void jCBTarjeta1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jCBTarjeta1PopupMenuWillBecomeVisible
        jCBTarjeta1.setModel(
                new javax.swing.DefaultComboBoxModel(controladorTP.listar()));
    }//GEN-LAST:event_jCBTarjeta1PopupMenuWillBecomeVisible

    private void jBCrear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCrear1ActionPerformed

        int guardar = -1;
        try {


            String pasajero = jCBPasajero1.getSelectedItem().toString();
            String tarjeta = jCBTarjeta1.getSelectedItem().toString();
            Pasajeros p = controladorPasajero.consultar(pasajero);
            TarjetasPersonalizadas t = controladorTP.consultar(tarjeta);
            guardar = controladorPP.insertar(p, t);

        } catch (Exception e) {
        }
        if (guardar == -1) {
            JOptionPane.showMessageDialog(this, "No se pudo crear ", "Error Base Datos", JOptionPane.ERROR_MESSAGE);
        } else {

            if (guardar == 1) {

                JOptionPane.showMessageDialog(this, "Ya existe la venta ", "Error", ERROR);


            } else {
                JOptionPane.showMessageDialog(this, "Venta Creada correctamente", "Sistema", JOptionPane.INFORMATION_MESSAGE);


            }
        }
    }//GEN-LAST:event_jBCrear1ActionPerformed

    private void jBLimpiar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiar3ActionPerformed
        
    }//GEN-LAST:event_jBLimpiar3ActionPerformed

    private void jCBPasajero1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jCBPasajero1PopupMenuWillBecomeVisible
        // TODO add your handling code here:
         jCBPasajero1.setModel(
                new javax.swing.DefaultComboBoxModel(controladorPasajero.listar()));
    }//GEN-LAST:event_jCBPasajero1PopupMenuWillBecomeVisible

    private void jCBPasajero2PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jCBPasajero2PopupMenuWillBecomeVisible
        // TODO add your handling code here:
        jCBPasajero2.setModel(
                new javax.swing.DefaultComboBoxModel(controladorPasajero.listar()));
    }//GEN-LAST:event_jCBPasajero2PopupMenuWillBecomeVisible

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBConsultar1;
    private javax.swing.JButton jBCrear1;
    private javax.swing.JButton jBLimpiar3;
    private javax.swing.JButton jBLimpiarConsultar;
    private javax.swing.JComboBox jCBPasajero1;
    private javax.swing.JComboBox jCBPasajero2;
    private javax.swing.JComboBox jCBTarjeta1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTPVentas;
    private javax.swing.JTable jTResultados;
    // End of variables declaration//GEN-END:variables
}