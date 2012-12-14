/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entidades.TarjetasGenericas;
import controladores.ControladoresTarjetasGenericas;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author chokuno
 */
public class JPTarjetasGenericas extends javax.swing.JPanel {

    /**
     * Creates new form JPTarjetasGenericas
     */
    ControladoresTarjetasGenericas controladorTarjetasGenericas;
    
    public JPTarjetasGenericas() {
        initComponents();
        controladorTarjetasGenericas= new ControladoresTarjetasGenericas();
        jTabbedPane1.setSelectedIndex(0);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTFNumeroPasajes = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jBLimpiarCrear = new javax.swing.JButton();
        jBCrear = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTFPinTarjeta = new javax.swing.JTextField();
        jCEstado = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jBConsultar = new javax.swing.JButton();
        jBLimpiarConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTResultados = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTFPinTarjeta1 = new javax.swing.JTextField();
        jTFNumeroPasajes1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JCEstado1 = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jBModificar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTFPinTarjeta2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTFNumeroPasajes2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        JCEstado2 = new javax.swing.JComboBox();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Tarjetas Genericas"));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTFNumeroPasajes.setColumns(20);
        jPanel1.add(jTFNumeroPasajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

        jLabel2.setText("Pin Tarjeta");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel4.setText("Estado");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jBLimpiarCrear.setText("Limpiar");
        jBLimpiarCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarCrearActionPerformed(evt);
            }
        });
        jPanel1.add(jBLimpiarCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 80, -1));

        jBCrear.setText("Crear");
        jBCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCrearActionPerformed(evt);
            }
        });
        jPanel1.add(jBCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 70, -1));

        jLabel8.setText("Saldo");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jTFPinTarjeta.setColumns(20);
        jPanel1.add(jTFPinTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, 30));

        jCEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Disponible", "Vendido" }));
        jPanel1.add(jCEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 200, -1));

        jTabbedPane1.addTab("Crear", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBConsultar.setText("Consultar");
        jBConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConsultarActionPerformed(evt);
            }
        });
        jPanel2.add(jBConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 90, -1));

        jBLimpiarConsultar.setText("Limpiar");
        jBLimpiarConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarConsultarActionPerformed(evt);
            }
        });
        jPanel2.add(jBLimpiarConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 90, -1));

        jTResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pin Tarjeta", "Saldo", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 420, 120));

        jLabel3.setText("Pin Tarjeta");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jTFPinTarjeta1.setColumns(20);
        jPanel2.add(jTFPinTarjeta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 210, 30));

        jTFNumeroPasajes1.setColumns(20);
        jPanel2.add(jTFNumeroPasajes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 210, -1));

        jLabel9.setText("saldo");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 90, -1));

        jLabel10.setText("Estado");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        JCEstado1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Disponible", "Vendido" }));
        jPanel2.add(JCEstado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 200, -1));

        jTabbedPane1.addTab("Consultar", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBModificar.setText("Modificar");
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });
        jPanel3.add(jBModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 90, -1));

        jLabel5.setText("Pin Tarjeta");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jTFPinTarjeta2.setColumns(20);
        jTFPinTarjeta2.setEnabled(false);
        jPanel3.add(jTFPinTarjeta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 210, 30));

        jLabel11.setText("Numero de Pasajes");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jTFNumeroPasajes2.setColumns(20);
        jPanel3.add(jTFNumeroPasajes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 210, -1));

        jLabel12.setText("Estado");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        JCEstado2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Disponible", "Vendido" }));
        jPanel3.add(JCEstado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 200, -1));

        jTabbedPane1.addTab("Modificar", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 57, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 57, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 25, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 26, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCrearActionPerformed
        // TODO add your handling code here:
        int guardar = -1;
        
        try {
            guardar = controladorTarjetasGenericas.insertar(
                    jTFPinTarjeta.getText(),
                    Integer.parseInt(jTFNumeroPasajes.getText()),
                    jCEstado.getSelectedItem().toString());

        } catch (Exception e) {
        }

        if (guardar == -1) {
            JOptionPane.showMessageDialog(this, "No se pudo crear la tarjeta generica", "Error Base Datos", JOptionPane.ERROR_MESSAGE);
        } else {
            if (guardar == 1) {
                JOptionPane.showMessageDialog(this, "Ya existe la tarjeta generica", "Error Base Datos", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Tarjeta generica Creada correctamente", "Sistema", JOptionPane.INFORMATION_MESSAGE);
                jBLimpiarConsultar.doClick();
                jTFPinTarjeta1.setText(jTFPinTarjeta.getText());
                jBLimpiarCrear.doClick();
                jTabbedPane1.setSelectedIndex(1);
                jBConsultar.doClick();

            }
        }
    }//GEN-LAST:event_jBCrearActionPerformed

    private void jBLimpiarCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarCrearActionPerformed
        // TODO add your handling code here:
        jTFPinTarjeta.setText("");
        jTFNumeroPasajes.setText("");
        jCEstado.setSelectedIndex(0);
    }//GEN-LAST:event_jBLimpiarCrearActionPerformed

    private void jBConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConsultarActionPerformed
        // TODO add your handling code here:
         LinkedList consulta = new LinkedList();
        try {
            
            
             int num_pasaje=0;
            
            try{
                num_pasaje= Integer.parseInt(jTFNumeroPasajes1.getText());
            }
            catch(Exception e){
                num_pasaje=0;
            }
            
            System.out.println(num_pasaje);
            consulta = controladorTarjetasGenericas.consultar(jTFPinTarjeta1.getText(),
                    num_pasaje,JCEstado1.getSelectedItem().toString());
            
            Object[][] s = new Object[consulta.size()][3];
            for (int i = 0; i < consulta.size(); i++) {
                TarjetasGenericas tg = (TarjetasGenericas) consulta.get(i);
                if (tg.getPinTarjeta() != null) {
                    s[i][0] = tg.getPinTarjeta();
                    s[i][1] = tg.getNroPasajes();
                    s[i][2] = tg.getEstado();

                } else {
                    s = null;
                }
            }
            TableModel myModel = new DefaultTableModel(s, new String[]{"Pin Tarjeta", "Saldo", "Estado"}) {

                boolean[] canEdit = new boolean[]{false, false
                };

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            };
            
            ///remover filas
            jTResultados.setModel(myModel);
            jTResultados.setRowSorter(new TableRowSorter(myModel));

            
        }catch(Exception e)
        {e.printStackTrace();}
    }//GEN-LAST:event_jBConsultarActionPerformed

    private void jBLimpiarConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarConsultarActionPerformed
        // TODO add your handling code here:
        jTFPinTarjeta1.setText("");
        jTFNumeroPasajes1.setText("");
        JCEstado1.setSelectedIndex(0);
        jBConsultar.doClick();
        
    }//GEN-LAST:event_jBLimpiarConsultarActionPerformed

    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed
        // TODO add your handling code here:
                int editar = -1;
        try {
            
            int num_pasaje=0;
            
            try{
                num_pasaje= Integer.parseInt(jTFNumeroPasajes2.getText());
            }
            catch(Exception e){
                num_pasaje=0;
            }
            editar = controladorTarjetasGenericas.modificar(
                    jTFPinTarjeta2.getText(),
                   num_pasaje,
                    JCEstado2.getSelectedItem().toString());
        } catch (Exception e) {
            System.out.print(e);
        }
        if (editar == -1) {
            JOptionPane.showMessageDialog(this, "No se pudo modificar la tarjeta generica", "Error Base Datos", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Tarjeta generica modificada correctamente", "Base Datos", JOptionPane.INFORMATION_MESSAGE);
            jBLimpiarConsultar.doClick();
            jTFPinTarjeta1.setText(jTFPinTarjeta2.getText());
            jBConsultar.doClick();
            jTabbedPane1.setSelectedIndex(1);
            limpiarModificar();
        }
        
    }//GEN-LAST:event_jBModificarActionPerformed

    public void limpiarModificar()
    {
    jTFPinTarjeta2.setText("");
    jTFNumeroPasajes2.setText("");
    JCEstado2.setSelectedIndex(0);
    }
    
    private void jTResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTResultadosMouseClicked
        // TODO add your handling code here:
        int selectedRow = jTResultados.getSelectedRow();
        jTFPinTarjeta2.setText("" + jTResultados.getModel().getValueAt(selectedRow, 0));
        jTFNumeroPasajes2.setText("" + jTResultados.getModel().getValueAt(selectedRow, 1));
        JCEstado2.setSelectedItem("" + jTResultados.getModel().getValueAt(selectedRow, 2));


        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jTResultadosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox JCEstado1;
    private javax.swing.JComboBox JCEstado2;
    private javax.swing.JButton jBConsultar;
    private javax.swing.JButton jBCrear;
    private javax.swing.JButton jBLimpiarConsultar;
    private javax.swing.JButton jBLimpiarCrear;
    private javax.swing.JButton jBModificar;
    private javax.swing.JComboBox jCEstado;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFNumeroPasajes;
    private javax.swing.JTextField jTFNumeroPasajes1;
    private javax.swing.JTextField jTFNumeroPasajes2;
    private javax.swing.JTextField jTFPinTarjeta;
    private javax.swing.JTextField jTFPinTarjeta1;
    private javax.swing.JTextField jTFPinTarjeta2;
    private javax.swing.JTable jTResultados;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
