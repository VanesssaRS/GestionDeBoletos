/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Pasajero;

import Model.Persona;
import java.awt.BorderLayout;

/**
 *
 * @author NexBorn
 */
public class FrmPDashBoard extends javax.swing.JFrame {
    private Persona loged;
    /**
     * Creates new form JCompraBoleto
     */
    public FrmPDashBoard(Persona pasajero) {
        this.loged = pasajero;
        initComponents();
        lblBienvenida.setText("Bienvenid@, "+pasajero.getNombre() + " " + pasajero.getApellido());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        lblBienvenida = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnPerfil = new javax.swing.JButton();
        btnComprarBoleto = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnVerViajes = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        content = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(980, 559));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel4.setText("11:23 AM");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 30, -1, -1));

        lblBienvenida.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblBienvenida.setText("?");
        getContentPane().add(lblBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 260, 30));

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPerfil.setBackground(new java.awt.Color(0, 0, 0));
        btnPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visual/img/usuario (2).png"))); // NOI18N
        btnPerfil.setText("Mi perfil");
        btnPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });
        jPanel1.add(btnPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 13, 106, 62));

        btnComprarBoleto.setBackground(new java.awt.Color(255, 0, 102));
        btnComprarBoleto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnComprarBoleto.setText("Comprar boleto");
        btnComprarBoleto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnComprarBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarBoletoActionPerformed(evt);
            }
        });
        jPanel1.add(btnComprarBoleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 138, 170, 60));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visual/img/ajustes.png"))); // NOI18N
        jButton3.setText("Ajustes");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 319, 170, 60));

        btnVerViajes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVerViajes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visual/img/lupa.png"))); // NOI18N
        btnVerViajes.setText("Ver Viajes");
        btnVerViajes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnVerViajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerViajesActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerViajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 225, 170, 60));

        jButton5.setBackground(new java.awt.Color(255, 0, 51));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visual/img/cerrar-sesion (1).png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusPainted(false);
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 500, 87, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 562));

        content.setMinimumSize(new java.awt.Dimension(770, 480));
        content.setPreferredSize(new java.awt.Dimension(770, 480));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        getContentPane().add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 770, 480));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel5.setText("Maters 20, de Juilio del 2021");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 23, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComprarBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarBoletoActionPerformed
        // TODO add your handling code here:
        JComprarBoleto comprar = new JComprarBoleto();
        comprar.setSize(770,480);
        comprar.setLocation(0,0);
        content.removeAll();
        content.add(comprar, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_btnComprarBoletoActionPerformed

    private void btnVerViajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerViajesActionPerformed
        // TODO add your handling code here:
        JPViaje viajes = new JPViaje();
        viajes.setSize(770,480);
        viajes.setLocation(0,0);
        content.removeAll();
        content.add(viajes, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_btnVerViajesActionPerformed

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnPerfilActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPDashBoard(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprarBoleto;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnVerViajes;
    private javax.swing.JPanel content;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBienvenida;
    // End of variables declaration//GEN-END:variables
}