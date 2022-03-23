/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Vendedor;

import Control.GenericCallBack;
import Control.Pasajero.ComprarBoletoManager;
import Control.SingleCallBack;
import Control.Validaciones;
import Model.Modulos.AdminUsuarios;
import Model.Modulos.AdminViajes;
import Model.Usuarios.Monto;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

/**
 * @author NexBorn
 */
public class JVComprarBoleto extends javax.swing.JPanel {
    private final AdminViajes viajeSelected = new AdminViajes();
    private final DecimalFormat df = new DecimalFormat("###.##");
    private final Monto monto = new Monto();
    private boolean isUserRegister = false;


    /**
     * Creates new form JComprarBoleto
     */
    public JVComprarBoleto() {
        initComponents();
        rbEfectivo.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnSelecionarViaje = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        rbEfectivo = new javax.swing.JRadioButton();
        rbTarjeta = new javax.swing.JRadioButton();
        btnSeleccionarAsientos = new javax.swing.JButton();
        lblHorario = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        lblPrecioTotal1 = new javax.swing.JLabel();
        lblCooperativa = new javax.swing.JLabel();
        lblDestino = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblIva = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        lblPartida = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblValorUnitario = new javax.swing.JLabel();
        lblCheckAsientos = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        btnComprar1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1040, 478));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setText("Destino:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setText("Cedula:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setText("Núm. de Boletos:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, -1, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setText("Horario:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setText("Total a pagar:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 130, -1, -1));

        btnSelecionarViaje.setBackground(new java.awt.Color(255, 255, 255));
        btnSelecionarViaje.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnSelecionarViaje.setText("Seleccionar Viaje");
        btnSelecionarViaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnSelecionarViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarViajeActionPerformed(evt);
            }
        });
        jPanel2.add(btnSelecionarViaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 156, 33));

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel13.setText("Metodo de pago:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, -1, -1));

        rbEfectivo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        rbEfectivo.setText("Efectivo");
        rbEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEfectivoActionPerformed(evt);
            }
        });
        jPanel2.add(rbEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, -1, -1));

        rbTarjeta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbTarjeta.setText("Tarjeta");
        rbTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTarjetaActionPerformed(evt);
            }
        });
        jPanel2.add(rbTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 260, -1, -1));

        btnSeleccionarAsientos.setBackground(new java.awt.Color(255, 255, 255));
        btnSeleccionarAsientos.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnSeleccionarAsientos.setText("Seleccionar asiento");
        btnSeleccionarAsientos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnSeleccionarAsientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarAsientosActionPerformed(evt);
            }
        });
        jPanel2.add(btnSeleccionarAsientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 156, 33));

        lblHorario.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblHorario.setText("?");
        jPanel2.add(lblHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, -1, -1));

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel14.setText("Partida:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, -1, -1));

        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        jPanel2.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 80, -1));

        lblPrecioTotal1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblPrecioTotal1.setText("?");
        lblPrecioTotal1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 1));
        jPanel2.add(lblPrecioTotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 130, -1, 20));

        lblCooperativa.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblCooperativa.setText("?");
        jPanel2.add(lblCooperativa, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, -1, -1));

        lblDestino.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblDestino.setText("?");
        jPanel2.add(lblDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, -1, -1));

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel15.setText("Iva %12:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, -1, -1));

        lblIva.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblIva.setText("?");
        lblIva.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 1));
        jPanel2.add(lblIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 90, -1, -1));

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel16.setText("SubTotal");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, -1, -1));

        lblSubtotal.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblSubtotal.setText("?");
        lblSubtotal.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 1));
        jPanel2.add(lblSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 60, -1, -1));

        lblPartida.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblPartida.setText("?");
        jPanel2.add(lblPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, -1));

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnLimpiar.setText("Clear");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 50, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel1.setText("Selecciona el viaje, de acuerdo con el tiempo y costo que se mostrará");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 20));

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel17.setText("Valor unitario:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, -1, 20));

        lblValorUnitario.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblValorUnitario.setText("?");
        lblValorUnitario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 1));
        jPanel2.add(lblValorUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, -1, -1));

        lblCheckAsientos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCheckAsientos.setForeground(new java.awt.Color(0, 255, 153));
        lblCheckAsientos.setText("   ");
        jPanel2.add(lblCheckAsientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, -1, -1));

        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });
        jPanel2.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 130, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        jLabel19.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel19.setText("Cooperativa:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));

        jLabel20.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel20.setText("Nombre:");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel21.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel21.setText("Apellido:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 200, -1));

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });
        jPanel2.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 200, -1));

        btnComprar1.setBackground(new java.awt.Color(255, 255, 255));
        btnComprar1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnComprar1.setText("Comprar Boleto");
        btnComprar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnComprar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnComprar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 180, 170, 40));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 10, 350));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, 10, 350));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 1010, 410));

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel10.setText("Venta Boleto");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, -1));

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 204, 255));
        jLabel11.setText("Perfil");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, -1));

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel12.setText(" > Comprar boleto");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void rbEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEfectivoActionPerformed
        // TODO add your handling code here:
        if (rbTarjeta.isSelected()) {
            rbEfectivo.setSelected(true);
            rbTarjeta.setSelected(false);
            return;
        }
        rbEfectivo.setSelected(true);
    }//GEN-LAST:event_rbEfectivoActionPerformed

    private void rbTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTarjetaActionPerformed
        // TODO add your handling code here:
        if (rbEfectivo.isSelected()) {
            rbTarjeta.setSelected(true);
            rbEfectivo.setSelected(false);
            return;
        }
        rbTarjeta.setSelected(true);
    }//GEN-LAST:event_rbTarjetaActionPerformed

    /**
     * Metodo para agregar los datos selecionados del JTable en los labals respondientes
     *
     * @param evt Evento
     */
    private void btnSelecionarViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarViajeActionPerformed
        // TODO add your handling code here:
        FrmVMostrarViajes frmMostrarViajes = new FrmVMostrarViajes(viajeSelected);
        frmMostrarViajes.setVisible(true);
        ComprarBoletoManager.getInstace().getAsientos().clear();
        frmMostrarViajes.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                if (viajeSelected != null) {
                    lblCooperativa.setText(viajeSelected.getNombreCooperativa());
                    lblPartida.setText(viajeSelected.getPartida());
                    lblDestino.setText(viajeSelected.getDestino());
                    lblHorario.setText(viajeSelected.getHora());
                    lblValorUnitario.setText("$ " + viajeSelected.getValor());
                    lblCheckAsientos.setText("OK");
                }
            }
        });
    }//GEN-LAST:event_btnSelecionarViajeActionPerformed

    /**
     * Este metodo limpia todo los datos cargados en memoria.
     */
    private void clearFields() {
        isUserRegister = false;
        viajeSelected.setValor(0);
        viajeSelected.setId_viaje(0);
        viajeSelected.setHora(null);
        viajeSelected.setFecha(null);
        viajeSelected.setPartida(null);
        viajeSelected.setDestino(null);
        viajeSelected.setBus(null);
        viajeSelected.setNombreCooperativa(null);
        lblCooperativa.setText("?");
        lblPartida.setText("?");
        lblDestino.setText("?");
        lblHorario.setText("?");
        lblValorUnitario.setText("?");
        monto.setTotal(0);
        monto.setIva(0);
        monto.setSubTotal(0);
        lblPrecioTotal1.setText("?");
        lblIva.setText("?");
        lblSubtotal.setText("?");
        txtCedula.setText("");
        txtApellido.setText("");
        txtNombre.setText("");
        txtApellido.setEditable(true);
        txtNombre.setEditable(true);
        txtCedula.setEditable(true);
    }

    /**
     * Inicia un Frame donde mostrar al jugador mostrar los asientos
     *
     * @param evt Evento
     */
    private void btnSeleccionarAsientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarAsientosActionPerformed
        // TODO add your handling code here:
        if ((int) jSpinner1.getValue() > 0 && viajeSelected.getBus() != null) {
            new FrmVAsiento(viajeSelected.getBus(), (int) jSpinner1.getValue()).setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog(null, "¡Selecciona el numero de asientos o el viaje!");
    }//GEN-LAST:event_btnSeleccionarAsientosActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        clearFields();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    /**
     * Mostrar el valor del monto en tiempo real y evitamos una exepcion negativa
     *
     * @param evt event
     */
    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // TODO add your handling code here:
        int unidades = (int) jSpinner1.getValue();
        if (unidades > 0) {
            double subtotal = unidades * viajeSelected.getValor();
            double iva = subtotal * 0.12;
            double total = iva + subtotal;
            lblSubtotal.setText("$" + df.format(subtotal));
            lblIva.setText("$" + df.format(iva));
            lblPrecioTotal1.setText("$" + df.format(total));
            monto.setSubTotal(subtotal);
            monto.setIva(iva);
            monto.setTotal(total);
            return;
        }
        jSpinner1.setValue(0);
    }//GEN-LAST:event_jSpinner1StateChanged

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        // TODO add your handling code here:
        char valida = evt.getKeyChar();
        if (!Character.isDigit(valida)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        char valida = evt.getKeyChar();
        if (!Character.isLetter(valida)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String cedula = txtCedula.getText();
        if (Validaciones.validarStrings(cedula)) {
            ComprarBoletoManager.getInstace().getPersona(cedula, new GenericCallBack() {
                @Override
                public void onSucces(Object o) {
                    AdminUsuarios adminUsuarios = (AdminUsuarios) o;
                    txtApellido.setText("");
                    txtNombre.setText("");
                    txtCedula.setEditable(false);
                    txtNombre.setText(adminUsuarios.getNombre());
                    txtApellido.setText(adminUsuarios.getApellido());
                    txtNombre.setEditable(false);
                    txtApellido.setEditable(false);
                    isUserRegister = true;
                }

                @Override
                public void onFailed() {
                    JOptionPane.showMessageDialog(null, "¡El usuario no está registrado,\n debe continuar rellenando los campos!");
                }
            });
            return;
        }
        JOptionPane.showMessageDialog(null, "Por favor, ingresa la cedula");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        // TODO add your handling code here:
        char valida = evt.getKeyChar();
        if (!Character.isLetter(valida)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void btnComprar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprar1ActionPerformed
        // TODO add your handling code here:
        String cedula = txtCedula.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        if (viajeSelected != null && monto != null && ComprarBoletoManager.getInstace().getAsientos().size() > 0 && (int) jSpinner1.getValue() > 0) {
            int tipoPago = rbEfectivo.isSelected() ? 1 : 2;
            ComprarBoletoManager.getInstace().insertarBoletos(cedula, nombre, apellido, monto, viajeSelected, (int) jSpinner1.getValue(), tipoPago, isUserRegister, new SingleCallBack() {
                @Override
                public void onSucces(String msg) {
                    clearFields();
                    JOptionPane.showMessageDialog(null, msg);
                }

                @Override
                public void onFailed() {
                    JOptionPane.showMessageDialog(null, "¡Ocurrio un problema en la insercción de datos!");
                }
            });
            return;
        }
        JOptionPane.showMessageDialog(null, "¡Completelos campos! \n 1.- Asegurese de escoger el viaje. \n 2. Asegurese si escogio la cantidad de los asientos y sus puestos.");
    }//GEN-LAST:event_btnComprar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnComprar1;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSeleccionarAsientos;
    private javax.swing.JButton btnSelecionarViaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lblCheckAsientos;
    private javax.swing.JLabel lblCooperativa;
    private javax.swing.JLabel lblDestino;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblIva;
    private javax.swing.JLabel lblPartida;
    private javax.swing.JLabel lblPrecioTotal1;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblValorUnitario;
    private javax.swing.JRadioButton rbEfectivo;
    private javax.swing.JRadioButton rbTarjeta;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
