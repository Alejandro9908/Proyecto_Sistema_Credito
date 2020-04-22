/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.sucursal;

import controladores.FSucursal;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Departamento;
import modelo.Municipio;
import modelo.Sucursal;
import vistas.cargo.frmEditarCargo;
import static vistas.frmEscritorio.dpnlEscritorio;
import vistas.frmSeleccionar;
import static vistas.sucursal.frmNuevoSucursal.cbDepartamentos;
import static vistas.sucursal.frmNuevoSucursal.cbMunicipio;

/**
 *
 * @author Alejandro
 */
public class frmMostrarSucursal extends javax.swing.JInternalFrame implements ActionListener{

     FSucursal funcion = new FSucursal();
     int departamentoSelected;
     int municipioSelected;
     
     
     public static String departamentoNombre, municipioNombre;
    
    public frmMostrarSucursal() {
        initComponents();
        
        txtIdMunicipio.setVisible(false);
        txtIdDepartamento.setVisible(false);
        
        
        
        
        //AGREGAR LOS BOTONES AL ACTION LISTENER
        btnEditar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnCancelar.addActionListener(this);
        btnGuardar.addActionListener(this);
        btnSeleccionarDepartamento.addActionListener(this);
        btnSeleccionarMunicipio.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*if(btnCancelar == e.getSource()){
            frmEditarSucursal frmEditar = new frmEditarSucursal();
            dpnlEscritorio.add(frmEditar);
            Dimension desktopSize = dpnlEscritorio.getSize();
            Dimension FrameSize = frmEditar.getSize();
            frmEditar.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            frmEditar.setVisible(true);
            //cerramos el form mostrar departamento
            this.dispose();
        }*/
        
        if(e.getSource()== btnEliminar){
            eliminarSucursal();
        }
        
        if(e.getSource()== btnEditar){
            desbloquearDatos();
        }
        
        if(e.getSource()== btnCancelar){
            cancelar1();
        }
         
         if(e.getSource()== btnGuardar){
            editarSucursal();   
        }
         
        if (e.getSource()== btnSeleccionarDepartamento){
            frmSeleccionar f = new frmSeleccionar(1,"QUEMADO"); //el numero es para que se haga universal, pero creo que solo usaremos esa ventana
            //el dato quemado es solamente para que no busque ninguna direccion, solo se ocupa en la opcion dos
            f.setVisible(true);
        }
        
         if (e.getSource()== btnSeleccionarMunicipio){
            frmSeleccionar f = new frmSeleccionar(2, txtIdDepartamento.getText()); //el numero es para que se haga universal, pero creo que solo usaremos esa ventana
            //el dato quemado es solamente para que no busque ninguna direccion, solo se ocupa en la opcion dos
            f.setVisible(true);
        }
         
         
    }
    
     private void desbloquearDatos(){
        
        txtNombre.setEditable(true);
        txtDireccion.setEditable(true);
        txtTelefono.setEditable(true);
        txtCorreo.setEditable(true);
        btnGuardar.setEnabled(true);
        btnEditar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnSeleccionarDepartamento.setEnabled(true);
        btnSeleccionarMunicipio.setEnabled(true);
        lblTitulo.setText("Editar Sucursal");
        
    }
    
    private void bloquearDatos(){
        
        txtNombre.setEditable(false);
        txtDireccion.setEditable(false);
        txtTelefono.setEditable(false);
        txtCorreo.setEditable(false);
        btnGuardar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnSeleccionarDepartamento.setEnabled(false);
        btnSeleccionarMunicipio.setEnabled(false);
        lblTitulo.setText("Detalles de la Sucursal");
    }
    
     private void cancelar1(){
        this.dispose();
    }
     
  
      private void editarSucursal(){
        
        if(txtNombre.getText().length()==0 || txtIdDepartamento.getText().length()==0 || txtIdMunicipio.getText().length()==0 || txtDireccion.getText().length()==0 || txtTelefono.getText().length()==0 || txtCorreo.getText().length()==0){
              JOptionPane.showMessageDialog(null, "Hace falta rellenar campos obligatorios");
        }
        else{
            Sucursal sucursal = new Sucursal();
        sucursal.setId_sucursal(Integer.parseInt(txtId.getText()));
        sucursal.setNombre_sucursal(txtNombre.getText());
        sucursal.setId_municipio(Integer.parseInt(txtIdMunicipio.getText())); 
        sucursal.setTelefono(txtTelefono.getText());
        sucursal.setCorreo(txtCorreo.getText());
        sucursal.setDireccion(txtDireccion.getText());
  
        funcion.editarSucursal(sucursal, txtId.getText());
        JOptionPane.showMessageDialog(null,"Registro editado correctamente");
         frmIndexSucursal.btnActualizar.doClick();
        bloquearDatos();
  
        }
       
        
    }
      
      private void eliminarSucursal(){
        int confirmado = JOptionPane.showConfirmDialog(
         null,
         "¿Estas seguro que deseas eliminar el registro?");

             if (JOptionPane.OK_OPTION == confirmado){
             
                 funcion.eliminarSucursal(txtId.getText());
                 JOptionPane.showMessageDialog(null,"Registro eliminado correctamente");
                  limpiarFormulario();
                  
                   frmIndexSucursal.btnActualizar.doClick(); //para actualizar el INDEX
                 
                 
             }else{
                            //Ok no borraré nada
             }
    }
      
      
        private void limpiarFormulario(){
        
        txtId.setText("");
        txtNombre.setText("");
        txtIdMunicipio.setText("");
        txtMunicipio.setText("");
        txtIdDepartamento.setText("");
        txtDepartamento.setText("");
        txtEstado.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtFecha.setText("");
        txtHora.setText("");
        btnEliminar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnSeleccionarMunicipio.setEnabled(false);
        btnSeleccionarDepartamento.setEnabled(false);
        
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
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        txtId = new javax.swing.JTextField();
        lblNombre2 = new javax.swing.JLabel();
        lblNombre6 = new javax.swing.JLabel();
        lblNombre7 = new javax.swing.JLabel();
        lblNombre8 = new javax.swing.JLabel();
        lblNombre9 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        lblNombre3 = new javax.swing.JLabel();
        txtDepartamento = new javax.swing.JTextField();
        txtMunicipio = new javax.swing.JTextField();
        btnSeleccionarDepartamento = new javax.swing.JButton();
        btnSeleccionarMunicipio = new javax.swing.JButton();
        lblNombre10 = new javax.swing.JLabel();
        lblNombre11 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        txtIdDepartamento = new javax.swing.JTextField();
        txtIdMunicipio = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);

        pnlBase.setBackground(new java.awt.Color(255, 255, 255));

        pnlFormulario.setBackground(new java.awt.Color(255, 255, 255));

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre.setText("Nombre de la Sucursal");

        lblNombre1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre1.setText("Detalles de la Dirección");

        txtDireccion.setColumns(20);
        txtDireccion.setRows(5);
        jScrollPane1.setViewportView(txtDireccion);

        txtId.setEditable(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        lblNombre2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre2.setText("Id");

        lblNombre6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre6.setText("Departamento");

        lblNombre7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre7.setText("Municipio");

        lblNombre8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre8.setText("Teléfono");

        lblNombre9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre9.setText("Correo");

        txtEstado.setEditable(false);
        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });

        lblNombre3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre3.setText("Estado");

        txtDepartamento.setEditable(false);
        txtDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartamentoActionPerformed(evt);
            }
        });

        txtMunicipio.setEditable(false);
        txtMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMunicipioActionPerformed(evt);
            }
        });

        btnSeleccionarDepartamento.setText("...");
        btnSeleccionarDepartamento.setEnabled(false);

        btnSeleccionarMunicipio.setText("...");
        btnSeleccionarMunicipio.setEnabled(false);

        lblNombre10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre10.setText("Fecha de creación");

        lblNombre11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre11.setText("Hora de creación");

        txtFecha.setEnabled(false);

        txtHora.setEnabled(false);

        javax.swing.GroupLayout pnlFormularioLayout = new javax.swing.GroupLayout(pnlFormulario);
        pnlFormulario.setLayout(pnlFormularioLayout);
        pnlFormularioLayout.setHorizontalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormularioLayout.createSequentialGroup()
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre8)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreo)
                            .addGroup(pnlFormularioLayout.createSequentialGroup()
                                .addComponent(lblNombre9)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormularioLayout.createSequentialGroup()
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addGroup(pnlFormularioLayout.createSequentialGroup()
                                .addComponent(lblNombre2)
                                .addGap(184, 184, 184)
                                .addComponent(lblNombre3))
                            .addComponent(lblNombre1)
                            .addComponent(lblNombre6)
                            .addGroup(pnlFormularioLayout.createSequentialGroup()
                                .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSeleccionarDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre7)
                            .addGroup(pnlFormularioLayout.createSequentialGroup()
                                .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSeleccionarMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormularioLayout.createSequentialGroup()
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre10)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHora)
                            .addGroup(pnlFormularioLayout.createSequentialGroup()
                                .addComponent(lblNombre11)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        pnlFormularioLayout.setVerticalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre2)
                    .addComponent(lblNombre3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre6)
                    .addComponent(lblNombre7))
                .addGap(1, 1, 1)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionarDepartamento)
                    .addComponent(btnSeleccionarMunicipio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombre1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre8)
                    .addComponent(lblNombre9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre10)
                    .addComponent(lblNombre11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTitulo.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        lblTitulo.setText("Detalles de la Sucursal");

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnEditar.setText("Editar");

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);

        txtIdDepartamento.setEditable(false);
        txtIdDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdDepartamentoActionPerformed(evt);
            }
        });

        txtIdMunicipio.setEditable(false);
        txtIdMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdMunicipioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBaseLayout = new javax.swing.GroupLayout(pnlBase);
        pnlBase.setLayout(pnlBaseLayout);
        pnlBaseLayout.setHorizontalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTitulo)
                .addGap(32, 32, 32)
                .addComponent(txtIdDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtIdMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        pnlBaseLayout.setVerticalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(txtIdDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        getContentPane().add(pnlBase, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    
    
    
    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void txtDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartamentoActionPerformed

    private void txtMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMunicipioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMunicipioActionPerformed

    private void txtIdDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdDepartamentoActionPerformed

    private void txtIdMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdMunicipioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdMunicipioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSeleccionarDepartamento;
    private javax.swing.JButton btnSeleccionarMunicipio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre10;
    private javax.swing.JLabel lblNombre11;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombre6;
    private javax.swing.JLabel lblNombre7;
    private javax.swing.JLabel lblNombre8;
    private javax.swing.JLabel lblNombre9;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBase;
    private javax.swing.JPanel pnlFormulario;
    public static javax.swing.JTextField txtCorreo;
    public static javax.swing.JTextField txtDepartamento;
    public static javax.swing.JTextArea txtDireccion;
    public static javax.swing.JTextField txtEstado;
    public static javax.swing.JTextField txtFecha;
    public static javax.swing.JTextField txtHora;
    public static javax.swing.JTextField txtId;
    public static javax.swing.JTextField txtIdDepartamento;
    public static javax.swing.JTextField txtIdMunicipio;
    public static javax.swing.JTextField txtMunicipio;
    public static javax.swing.JTextField txtNombre;
    public static javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
