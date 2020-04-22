/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static vistas.cliente.frmNuevoCliente.modeloTel;

/**
 *
 * @author Alejandro
 */
public class frmAgregarTelefono extends javax.swing.JInternalFrame implements  ActionListener{

    /**
     * Creates new form frmMostrarTelefono
     */
    public frmAgregarTelefono() {
        initComponents();
        
        btnAgregar.addActionListener(this);
        btnCancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(btnAgregar == e.getSource()){
            String registro[] = new String[2];
            registro[0] = txtTelefono.getText();
            registro[1] = (String) cbOperador.getSelectedItem();
            modeloTel.addRow(registro);
            this.dispose();
        }
        if(e.getSource()==btnCancelar){
            this.dispose();
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

        jPanel1 = new javax.swing.JPanel();
        txtTelefono = new javax.swing.JTextField();
        cbOperador = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lblNombre2 = new javax.swing.JLabel();
        lblNombre3 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cbOperador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CLARO", "TIGO" }));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel1.setText("Agregar Teléfono");

        lblNombre2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre2.setText("Número de Telefono");

        lblNombre3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre3.setText("Operador");

        btnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnAgregar.setText("Agregar");

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblNombre2)
                                .addComponent(jLabel1)
                                .addComponent(lblNombre3)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(113, 113, 113)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(lblNombre2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnCancelar))
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cbOperador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    
}
