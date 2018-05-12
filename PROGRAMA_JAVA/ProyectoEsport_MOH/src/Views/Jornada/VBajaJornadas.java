/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Jornada;

import Views.Administradores.*;
import proyectoesport_moh.Controladora;
import Exceptions.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;


/**
 *
 * @author MIGUEL
 */
public class VBajaJornadas extends javax.swing.JFrame {

    private static Integer almacenarCodLogin;

    /**
     * Creates new form VAltaAdmin
     */
    public VBajaJornadas() {

        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configPredeterminadaVentana();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jBbaja = new javax.swing.JButton();
        jTnumTemporada = new javax.swing.JTextField();
        jBconsultar = new javax.swing.JButton();
        jBreset = new javax.swing.JButton();
        jBretroceder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(new java.awt.Dimension(368, 387));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("ELIMINAR TEMPORADA");

        jLabel3.setText("Nº Temporada");

        jBbaja.setBackground(new java.awt.Color(153, 0, 0));
        jBbaja.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBbaja.setForeground(new java.awt.Color(255, 255, 255));
        jBbaja.setText("DAR DE BAJA");
        jBbaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbajaActionPerformed(evt);
            }
        });

        jBconsultar.setBackground(new java.awt.Color(0, 153, 51));
        jBconsultar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBconsultar.setForeground(new java.awt.Color(255, 255, 255));
        jBconsultar.setText("CONSULTAR");
        jBconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBconsultarActionPerformed(evt);
            }
        });

        jBreset.setBackground(new java.awt.Color(0, 0, 153));
        jBreset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBreset.setForeground(new java.awt.Color(255, 255, 255));
        jBreset.setText("RESET");
        jBreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBresetActionPerformed(evt);
            }
        });

        jBretroceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/retroceder.png"))); // NOI18N
        jBretroceder.setBorder(null);
        jBretroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBretrocederActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBretroceder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jBconsultar)
                                .addGap(18, 18, 18)
                                .addComponent(jBbaja))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jBreset)
                                .addGap(97, 97, 97))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(29, 29, 29)
                                .addComponent(jTnumTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTnumTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBconsultar)
                    .addComponent(jBbaja))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBreset)
                    .addComponent(jBretroceder))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBbajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbajaActionPerformed
        // ACTION ELIMINAR
        int preguntaSalida = JOptionPane.showConfirmDialog(this, "¿Realmente deseas eliminar"
                + "\na esta Temporada?");

        if (preguntaSalida == JOptionPane.YES_OPTION) {
            try {
                Controladora.eliminarAdministradorDelaBD(jTnumTemporada.getText(), almacenarCodLogin);
                JOptionPane.showMessageDialog(this, "la temporada ha sido "
                        + "\neliminada correctamente");
                resetearCamposParaConsultarDeNuevo();
            } catch (SQLException | ConexionProblemas EX) {
                Logger.getLogger(VBajaJornadas.class.getName()).log(Level.SEVERE, null, EX);
            }
        }
    }//GEN-LAST:event_jBbajaActionPerformed

    private void jBconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBconsultarActionPerformed
        // ACTION PARA BUSCAR TEMPORADA PRIMERO EN LA BD Y ELIMINAR DESPUES SI SE QUIERE
        try {
            if (jTnumTemporada.getText().isEmpty()) {
                throw new CampoNumTemporadaVacio();
            } else {
                Controladora.localizarTemporadaEnJornadaBD(jTnumTemporada.getText());
            }
        } catch (CampoNumTemporadaVacio CNTV) {
            JOptionPane.showMessageDialog(this, CNTV.getMensaje());
        } catch (Exception E) {
            JOptionPane.showMessageDialog(this, E.getMessage());
        }
    }//GEN-LAST:event_jBconsultarActionPerformed

    private void jBresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBresetActionPerformed
        // ACTION BOTON RESET
        resetearCamposParaConsultarDeNuevo();
    }//GEN-LAST:event_jBresetActionPerformed

    private void jBretrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBretrocederActionPerformed
        // ACTION BOTON RETROCEDER      
        try {
            Controladora.abreTipoVentanas(tipoVentana);
            Controladora.cierraTipoVentanas(tipoVentana);
        } catch (CierreVError CVE) {
            JOptionPane.showMessageDialog(this, CVE.getMessage());
        } catch (Exception E) {
            JOptionPane.showMessageDialog(this, E.getMessage());
        }
    }//GEN-LAST:event_jBretrocederActionPerformed

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
            java.util.logging.Logger.getLogger(VBajaJornadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VBajaJornadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VBajaJornadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VBajaJornadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VBajaJornadas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBbaja;
    private javax.swing.JButton jBconsultar;
    private javax.swing.JButton jBreset;
    private javax.swing.JButton jBretroceder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTnumTemporada;
    // End of variables declaration//GEN-END:variables

    // FUNCIONES PROPIAS DE LA VISTA
    public void rellenarCamposVentana(String dni, String nombre, String apellido, Integer login) {

        jTnumTemporada.setText(nombre);

        jBbaja.setEnabled(true);

        almacenarCodLoginRecibido(login);
    }

    public void configPredeterminadaVentana() {
        jTnumTemporada.setEnabled(true);
        jBbaja.setEnabled(false);
    }

    public void resetearCamposParaConsultarDeNuevo() {
        jTnumTemporada.setText(null);

        configPredeterminadaVentana();
    }

    public void almacenarCodLoginRecibido(Integer login) {
        almacenarCodLogin = login;
    }



}
