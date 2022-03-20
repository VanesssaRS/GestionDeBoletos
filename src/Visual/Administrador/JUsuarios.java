/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Administrador;

import Control.Administrador.UsuariosManager;
import Control.SingleCallBack;
import Model.Usuarios.Administrador.Modulos.AdminUsuarios;
import Model.Usuarios.Administrador.Modulos.TipoUsuario;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author NexBorn
 */
public class JUsuarios extends javax.swing.JPanel {

    /**
     * Creates new form JUsuarios
     */
    public JUsuarios() {
        initComponents();
        insertDataInTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel35 = new javax.swing.JLabel();
        lblInicio = new javax.swing.JLabel();
        lblUsuarios = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        btnAñadir = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtFiltro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(770, 488));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel35.setText("Usuarios");
        add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        lblInicio.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblInicio.setForeground(new java.awt.Color(3, 145, 181));
        lblInicio.setText("Inicio");
        add(lblInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        lblUsuarios.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblUsuarios.setText(" > Usuarios");
        add(lblUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tblUsuarios.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Apellido", "Cedula", "Email", "Telefono", "Fecha Nacimiento", "Direccion", "TipoUser"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblUsuarios);

        btnAñadir.setBackground(java.awt.SystemColor.activeCaption);
        btnAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visual/img/anadiricon.png"))); // NOI18N
        btnAñadir.setText("  Añadir");
        btnAñadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAñadirMouseClicked(evt);
            }
        });

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visual/img/actualizaricon.png"))); // NOI18N
        btnActualizar.setText("    Actualizar");
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Visual/img/eliminaricon.png"))); // NOI18N
        btnEliminar.setText("    Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Filtro:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(btnActualizar)
                                .addGap(133, 133, 133)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(299, 299, 299)
                                .addComponent(btnAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 178, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 41, -1, 410));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAñadirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAñadirMouseClicked
        FrmAñadirUsuario frmAñadirUsuario = new FrmAñadirUsuario();
        frmAñadirUsuario.setVisible(true);
    }//GEN-LAST:event_btnAñadirMouseClicked

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        int rowSelectect = tblUsuarios.getSelectedRow();
        if (rowSelectect >= 0) {
            AdminUsuarios adminUsuarios = new AdminUsuarios();
            adminUsuarios.setCode((int) tblUsuarios.getModel().getValueAt(rowSelectect, 0));
            adminUsuarios.setNombre((String) tblUsuarios.getModel().getValueAt(rowSelectect, 1));
            adminUsuarios.setApellido((String) tblUsuarios.getModel().getValueAt(rowSelectect, 2));
            adminUsuarios.setCedula((String) tblUsuarios.getModel().getValueAt(rowSelectect, 3));
            adminUsuarios.setEmail((String) tblUsuarios.getModel().getValueAt(rowSelectect, 4));
            adminUsuarios.setTelefono((String) tblUsuarios.getModel().getValueAt(rowSelectect, 5));
            adminUsuarios.setFechanac((Date) tblUsuarios.getModel().getValueAt(rowSelectect, 6));
            adminUsuarios.setDirecc((String) tblUsuarios.getModel().getValueAt(rowSelectect, 7));
            adminUsuarios.setTipoUser((TipoUsuario) tblUsuarios.getModel().getValueAt(rowSelectect, 8));
            FrmActualizarUsuario frmActualizarUsuario = new FrmActualizarUsuario(adminUsuarios);
            frmActualizarUsuario.setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog(null, "¡Selecciona al usuario para Actualizar!");
    }//GEN-LAST:event_btnActualizarMouseClicked

    public void insertDataInTable() {
        DefaultTableModel modelo = (DefaultTableModel) tblUsuarios.getModel();
        if (modelo != null) {
            for (AdminUsuarios item : UsuariosManager.getInstance().getListUsuarios()) {
                Object[] fila = new Object[10];
                fila[0] = item.getCode();
                fila[1] = item.getNombre();
                fila[2] = item.getApellido();
                fila[3] = item.getCedula();
                fila[4] = item.getEmail();
                fila[5] = item.getTelefono();
                fila[6] = item.getFechanac();
                fila[7] = item.getDirecc();
                fila[8] = item.getTipoUser();
                fila[9] = item.getApellido();

                modelo.addRow(fila);
                tblUsuarios.setModel(modelo);
            }
        }
    }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int rowSelectect = tblUsuarios.getSelectedRow();
        if (rowSelectect >= 0) {
            int codigo = (int) tblUsuarios.getModel().getValueAt(rowSelectect, 0);
            UsuariosManager.getInstance().deleteUsuarios(codigo, new SingleCallBack() {
                @Override
                public void onSucces(String msg) {
                    ((DefaultTableModel) tblUsuarios.getModel()).removeRow(rowSelectect);
                    JOptionPane.showMessageDialog(null, msg);
                }

                @Override
                public void onFailed() {
                    JOptionPane.showMessageDialog(null, "¡Ha ocurrido un error al eliminar los datos!");
                }
            });
            return;
        }
        JOptionPane.showMessageDialog(null, "Selecciona un Usuario!");
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        // TODO add your handling code here:
        filtro(txtFiltro.getText(),tblUsuarios);
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void filtro(String consulta, JTable jtableBuscar){
        DefaultTableModel dm = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblUsuarios;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
