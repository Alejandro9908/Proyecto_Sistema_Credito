/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.abonoCredito;

import controladores.FAbonoCredito;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.AbonoCredito;
import static vistas.abonoCredito.frmNuevoAbono.txtIdAbono;

/**
 *
 * @author Alejandro
 */
public class frmNuevoAbonoCapital extends javax.swing.JInternalFrame implements ActionListener{
    FAbonoCredito funcion = new FAbonoCredito();
    String query ="";
    
    public frmNuevoAbonoCapital() {
        initComponents();
        btnGuardar.addActionListener(this);
        btnCancelar.addActionListener(this);
        txtEfectivo.setEnabled(true);
        txtEfectivo1.setEnabled(true);
        txtCambio.setEnabled(false);
        cbBanco.setEnabled(false);
        txtCheque.setEnabled(false);
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnGuardar){
            float efectivo = Float.parseFloat(txtEfectivo1.getText());
            float total = Float.parseFloat(txtEfectivo.getText());
            float cambio;
            
            if(cbFormaPago.getSelectedIndex()==0){
                if(efectivo>=total){
                    acreditarAbonoCapital();
                }else{
                     JOptionPane.showMessageDialog(null,"El monto ingresado no es valido");
                }
            }
            if(cbFormaPago.getSelectedIndex()==1){
                if(efectivo==total){
                    acreditarAbonoCapital();
                }else{
                     JOptionPane.showMessageDialog(null,"El monto ingresado no es valido");
                }
            }
            
            dispose();
            
        }
        
        if(e.getSource()==btnCancelar){
            this.dispose();
        }
    }
    
        public void acreditarAbonoCapital(){
                AbonoCredito abonoCredito = new AbonoCredito();
            
                if(cbFormaPago.getSelectedIndex()==0){
                    abonoCredito.setId_credito(Integer.parseInt(txtIdCredito.getText()));
                    abonoCredito.setMonto(Float.parseFloat(txtEfectivo.getText()));
                    abonoCredito.setFroma_pago("EFECTIVO");
                    funcion.agregarAbonoCapital(abonoCredito);
                }
                if(cbFormaPago.getSelectedIndex()==1){
                    abonoCredito.setId_credito(Integer.parseInt(txtIdCredito.getText()));
                    abonoCredito.setFroma_pago("CHEQUE");
                    abonoCredito.setBanco_cheque(cbBanco.getSelectedItem().toString());
                    abonoCredito.setNumero_cheque(txtCheque.getText());
                    abonoCredito.setMonto(Float.parseFloat(txtEfectivo.getText()));
                    funcion.agregarAbonoCapital(abonoCredito);
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

        pnlBase = new javax.swing.JPanel();
        pnlFormulario = new javax.swing.JPanel();
        pnlPago = new javax.swing.JPanel();
        lblNombre10 = new javax.swing.JLabel();
        cbFormaPago = new javax.swing.JComboBox<>();
        lbl1 = new javax.swing.JLabel();
        cbBanco = new javax.swing.JComboBox<>();
        lbl2 = new javax.swing.JLabel();
        txtCheque = new javax.swing.JTextField();
        lbl3 = new javax.swing.JLabel();
        txtEfectivo = new javax.swing.JTextField();
        lbl4 = new javax.swing.JLabel();
        txtCambio = new javax.swing.JTextField();
        txtCapital = new javax.swing.JTextField();
        lblNombre11 = new javax.swing.JLabel();
        txtEfectivo1 = new javax.swing.JTextField();
        lbl5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtIdCredito = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);

        pnlBase.setBackground(new java.awt.Color(255, 255, 255));

        pnlFormulario.setBackground(new java.awt.Color(255, 255, 255));

        pnlPago.setBackground(new java.awt.Color(255, 255, 255));

        lblNombre10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre10.setText("Forma Pago");

        cbFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Cheque" }));
        cbFormaPago.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFormaPagoItemStateChanged(evt);
            }
        });

        lbl1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl1.setText("Banco");

        cbBanco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Banrural", "Credomatic", "Internacional", "Banco Industrial", "CHN", "Banco GYT", "BanTrab" }));

        lbl2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl2.setText("No. Cheque");

        lbl3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl3.setText("Cantidad a abonar");

        lbl4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl4.setText("Cambio");

        txtCambio.setEnabled(false);

        txtCapital.setEditable(false);
        txtCapital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCapitalActionPerformed(evt);
            }
        });

        lblNombre11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre11.setText("Capital Restante");

        txtEfectivo1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtEfectivo1CaretUpdate(evt);
            }
        });
        txtEfectivo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEfectivo1ActionPerformed(evt);
            }
        });

        lbl5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl5.setText("Confirma cantidad");

        javax.swing.GroupLayout pnlPagoLayout = new javax.swing.GroupLayout(pnlPago);
        pnlPago.setLayout(pnlPagoLayout);
        pnlPagoLayout.setHorizontalGroup(
            pnlPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPagoLayout.createSequentialGroup()
                .addGroup(pnlPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl3)
                    .addComponent(lbl4)
                    .addComponent(lbl5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEfectivo, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(txtCambio)
                    .addComponent(txtEfectivo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)))
            .addGroup(pnlPagoLayout.createSequentialGroup()
                .addGroup(pnlPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre10)
                    .addComponent(lbl1)
                    .addComponent(lbl2)
                    .addComponent(lblNombre11))
                .addGap(79, 79, 79)
                .addGroup(pnlPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCapital, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCheque, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbBanco, javax.swing.GroupLayout.Alignment.TRAILING, 0, 257, Short.MAX_VALUE)
                    .addComponent(cbFormaPago, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlPagoLayout.setVerticalGroup(
            pnlPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPagoLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(pnlPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCapital, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre10)
                    .addComponent(cbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl1)
                    .addComponent(cbBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCheque, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl2))
                .addGap(12, 12, 12)
                .addGroup(pnlPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEfectivo1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl4))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlFormularioLayout = new javax.swing.GroupLayout(pnlFormulario);
        pnlFormulario.setLayout(pnlFormularioLayout);
        pnlFormularioLayout.setHorizontalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFormularioLayout.setVerticalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel1.setText("Abono a Capital");

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnGuardar.setText("Realizar Transacción");

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnCancelar.setText("Cancelar");

        txtIdCredito.setEditable(false);
        txtIdCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCreditoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBaseLayout = new javax.swing.GroupLayout(pnlBase);
        pnlBase.setLayout(pnlBaseLayout);
        pnlBaseLayout.setHorizontalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBaseLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBaseLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIdCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBaseLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(pnlFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        pnlBaseLayout.setVerticalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlBase, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbFormaPagoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFormaPagoItemStateChanged

        if(cbFormaPago.getSelectedIndex()==0){
            txtEfectivo.setEnabled(true);
            txtEfectivo1.setEnabled(true);
            txtCambio.setEnabled(false);
            cbBanco.setEnabled(false);
            txtCheque.setEnabled(false);
        }
        if(cbFormaPago.getSelectedIndex()==1){
            cbBanco.setEnabled(true);
            txtCheque.setEnabled(true);
            txtEfectivo.setEnabled(true);
            txtEfectivo1.setEnabled(true);
            txtCambio.setEnabled(false);
        }
    }//GEN-LAST:event_cbFormaPagoItemStateChanged

    private void txtIdCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCreditoActionPerformed

    private void txtCapitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCapitalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCapitalActionPerformed

    private void txtEfectivo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEfectivo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEfectivo1ActionPerformed

    private void txtEfectivo1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtEfectivo1CaretUpdate
         if(cbFormaPago.getSelectedIndex()==0){
            float efectivo = Float.parseFloat(txtEfectivo1.getText());
            float total = Float.parseFloat(txtEfectivo.getText());
            float cambio;
            
            if(efectivo >= total){
                cambio = efectivo - total;
                txtCambio.setText(Float.toString(cambio));
            }else{
                txtCambio.setText("NO VALIDO");
            }
        }
    }//GEN-LAST:event_txtEfectivo1CaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbBanco;
    private javax.swing.JComboBox<String> cbFormaPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lblNombre10;
    private javax.swing.JLabel lblNombre11;
    private javax.swing.JPanel pnlBase;
    private javax.swing.JPanel pnlFormulario;
    private javax.swing.JPanel pnlPago;
    private javax.swing.JTextField txtCambio;
    public static javax.swing.JTextField txtCapital;
    private javax.swing.JTextField txtCheque;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtEfectivo1;
    public static javax.swing.JTextField txtIdCredito;
    // End of variables declaration//GEN-END:variables
}
