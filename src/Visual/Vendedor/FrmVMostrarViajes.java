/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Vendedor;

import Control.Administrador.ViajesManager;
import Model.Usuarios.Administrador.Modulos.AdminViajes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.text.DecimalFormat;
import java.util.Date;

/**
 *
 * @author NexBorn
 */
public class FrmVMostrarViajes extends javax.swing.JFrame {
    private AdminViajes copyViaje;
    /**
     * Creates new form FrmMostrarViajes
     */
    public FrmVMostrarViajes(AdminViajes adminViajes) {
        initComponents();
        insertDataInTable();
        copyViaje = adminViajes;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblViajes = new javax.swing.JTable();
        txtFiltro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblViajes.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        tblViajes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cooperativa", "Bus", "Destino", "Partida", "Fecha", "Horario", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblViajes);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 699, 224));

        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });
        getContentPane().add(txtFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 121, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Filtro:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));

        btnSeleccionar.setBackground(java.awt.SystemColor.activeCaption);
        btnSeleccionar.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visual/img/anadiricon.png"))); // NOI18N
        btnSeleccionar.setText("Selecionar");
        btnSeleccionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSeleccionarMouseClicked(evt);
            }
        });
        getContentPane().add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 170, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        // TODO add your handling code here:
        filtro(txtFiltro.getText(), tblViajes);
    }//GEN-LAST:event_txtFiltroKeyReleased

    /**
     * Filtramos las filas dependiendo de lo que se ponga en el Field
     *
     * @param consulta String del valor a buscar
     * @param jtableBuscar tabla donde se va hacer el filtro
     */
    private void filtro(String consulta, JTable jtableBuscar){
        DefaultTableModel dm = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }

    /**
     * Seleciona un viaje con toda sus caracteristicas para preparse para comprar.
     * @param evt Evento
     */
    private void btnSeleccionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSeleccionarMouseClicked
        int rowSelected = tblViajes.getSelectedRow();
        if(rowSelected >= 0){
            int codigo = (int) tblViajes.getModel().getValueAt(rowSelected,0);
            String cooperativa = (String) tblViajes.getModel().getValueAt(rowSelected,1);
            String bus = (String) tblViajes.getModel().getValueAt(rowSelected,2);
            String destino = (String) tblViajes.getModel().getValueAt(rowSelected,3);
            String partida = (String) tblViajes.getModel().getValueAt(rowSelected,4);
            Date fecha = (Date) tblViajes.getModel().getValueAt(rowSelected,5);
            String horario = (String) tblViajes.getModel().getValueAt(rowSelected,6);
            double valor = (double) tblViajes.getModel().getValueAt(rowSelected,7);
            copyViaje.setBus(bus);
            copyViaje.setId_viaje(codigo);
            copyViaje.setNombreCooperativa(cooperativa);
            copyViaje.setDestino(destino);
            copyViaje.setPartida(partida);
            copyViaje.setFecha(fecha);
            copyViaje.setHora(horario);
            copyViaje.setValor(valor);
            dispose();
            return;
        }
        JOptionPane.showMessageDialog(null,"¡Selecciona un viaje para continuar!");
    }//GEN-LAST:event_btnSeleccionarMouseClicked

    public void insertDataInTable() {
        DefaultTableModel modelo = (DefaultTableModel) tblViajes.getModel();
        if (modelo != null) {
            for (AdminViajes item : ViajesManager.getInstance().getViajes()) {
                Object[] fila = new Object[10];
                fila[0] = item.getId_viaje();
                fila[1] = item.getNombreCooperativa();
                fila[2] = item.getBus();
                fila[3] = item.getDestino();
                fila[4] = item.getPartida();
                fila[5] = item.getFecha();
                fila[6] = item.getHora();
                fila[7] = item.getValor();
                modelo.addRow(fila);
                tblViajes.setModel(modelo);
            }
        }
    }
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
            java.util.logging.Logger.getLogger(FrmVMostrarViajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVMostrarViajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVMostrarViajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVMostrarViajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVMostrarViajes(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblViajes;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
