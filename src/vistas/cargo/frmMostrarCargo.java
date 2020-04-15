/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.cargo;

import controladores.Conexion;
import controladores.FCargo;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Cargo;
import static vistas.frmEscritorio.dpnlEscritorio;

/**
 *
 * @author Alejandro
 */
public class frmMostrarCargo extends javax.swing.JInternalFrame implements ActionListener{

    FCargo funcion = new FCargo();
    Conexion cn = new Conexion();

    public frmMostrarCargo() {
        initComponents();
        
        //AGREGAR LOS BOTONES AL ACTION LISTENER
        btnEditar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnCancelar.addActionListener(this);
        btnGuardar.addActionListener(this);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
       /* if(btnCancelar == e.getSource()){
            frmEditarCargo frmEditar = new frmEditarCargo();
            dpnlEscritorio.add(frmEditar);
            Dimension desktopSize = dpnlEscritorio.getSize();
            Dimension FrameSize = frmEditar.getSize();
            frmEditar.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            frmEditar.setVisible(true);
            //cerramos el form mostrar departamento
            //this.dispose();
        }*/
        
        if(e.getSource()== btnEliminar){
         
            eliminarCargos2();
           
        }
        
        if(e.getSource()== btnEditar){
            desbloquearDatos();
        }
        
         if(e.getSource()== btnCancelar){
            cancelar1();
        }
         
         if(e.getSource()== btnGuardar){
            editarCargo();
            
        }
    }
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBase = new javax.swing.JPanel();
        pnlFormulario = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtId = new javax.swing.JTextField();
        lblNombre2 = new javax.swing.JLabel();
        lblNombre3 = new javax.swing.JLabel();
        lblNombre4 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        lblNombre5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        lblNombre6 = new javax.swing.JLabel();
        txtDepartamento = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setClosable(true);

        pnlBase.setBackground(new java.awt.Color(255, 255, 255));

        pnlFormulario.setBackground(new java.awt.Color(255, 255, 255));

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre.setText("Nombre del Cargo");

        txtNombre.setEditable(false);

        lblNombre1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre1.setText("Descripción");

        txtDescripcion.setEditable(false);
        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        txtId.setEditable(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        lblNombre2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre2.setText("Id");

        lblNombre3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre3.setText("Estado");

        lblNombre4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre4.setText("Fecha de Creación");

        txtEstado.setEditable(false);

        lblNombre5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre5.setText("Hora de Creación");

        txtFecha.setEditable(false);

        txtHora.setEditable(false);

        lblNombre6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre6.setText("Departamento");

        txtDepartamento.setEditable(false);

        javax.swing.GroupLayout pnlFormularioLayout = new javax.swing.GroupLayout(pnlFormulario);
        pnlFormulario.setLayout(pnlFormularioLayout);
        pnlFormularioLayout.setHorizontalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre)
                    .addComponent(jScrollPane1)
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFormularioLayout.createSequentialGroup()
                                .addComponent(lblNombre3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtEstado)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormularioLayout.createSequentialGroup()
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre)
                            .addComponent(lblNombre2)
                            .addComponent(lblNombre4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre5)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtDepartamento)
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre6)
                            .addComponent(lblNombre1))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addComponent(lblNombre6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre4)
                    .addComponent(lblNombre5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lblTitulo.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        lblTitulo.setText("Detalles del Cargo");

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.setMaximumSize(new java.awt.Dimension(87, 27));
        btnCancelar.setMinimumSize(new java.awt.Dimension(87, 27));

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.setMaximumSize(new java.awt.Dimension(87, 27));
        btnEliminar.setMinimumSize(new java.awt.Dimension(87, 27));

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setMaximumSize(new java.awt.Dimension(87, 27));
        btnGuardar.setMinimumSize(new java.awt.Dimension(87, 27));
        btnGuardar.setPreferredSize(new java.awt.Dimension(87, 27));

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setMaximumSize(new java.awt.Dimension(87, 27));
        btnEditar.setMinimumSize(new java.awt.Dimension(87, 27));
        btnEditar.setPreferredSize(new java.awt.Dimension(87, 27));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        pnlBaseLayout.setVerticalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(pnlFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        getContentPane().add(pnlBase, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

     private void pasarDatos(){
        //txtIdCarrera.setText((String) tablaDatosCarrera.getValueAt(tablaDatosCarrera.getSelectedRow(),0));
        //txtNombreCarrera.setText((String) tablaDatosCarrera.getValueAt(tablaDatosCarrera.getSelectedRow(),1));
        //txtDuracionCarrera.setText((String) tablaDatosCarrera.getValueAt(tablaDatosCarrera.getSelectedRow(),2));
        //idCarrera = tablaDatosCarrera.getValueAt(tablaDatosCarrera.getSelectedRow(),0).toString();
        
    }
     
     private void desbloquearDatos(){
        
        txtNombre.setEditable(true);
        txtDescripcion.setEditable(true);
        txtDepartamento.setEditable(false);
        btnGuardar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(true);
        lblTitulo.setText("Editar Cargo");
        
    }
     
     private void bloquearDatos(){
        
        txtNombre.setEditable(false);
        txtDescripcion.setEditable(false);
        txtDepartamento.setEditable(false);
        btnGuardar.setEnabled(false);
        btnEditar.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        lblTitulo.setText("Detalles del Cargo");
    }
     
      private void cancelar1(){
        this.dispose();
    }
      
    private void editarCargo(){
        
        if(txtNombre.getText().length()==0 || txtDescripcion.getText().length()==0 || txtDepartamento.getText().length()==0){
              JOptionPane.showMessageDialog(null, "Hace falta rellenar campos obligatorios");
        }
        else{
        Cargo cargo = new Cargo();
        cargo.setId_cargo(Integer.parseInt(txtId.getText()));
        cargo.setNombre_cargo(txtNombre.getText());
        cargo.setDescripcion(txtDescripcion.getText());
        
  
        funcion.editarCargo(cargo, txtId.getText());
        JOptionPane.showMessageDialog(null,"Registro editado correctamente");
         frmIndexCargo.btnActualizar.doClick(); //para actualizar el index
         bloquearDatos(); //botones y cajas de texto
       // limpiarFormulario();
            
        }
       
        
    }
    
    private void eliminarCargos(){
    
         int res = JOptionPane.showConfirmDialog(
        null, 
                 
        "¿Quieres continuar?", 
        "Confirm",
        JOptionPane.YES_NO_OPTION , 
        JOptionPane.QUESTION_MESSAGE
       );
         
       if ( res == JOptionPane.YES_OPTION ) {
       System.out.println( "Seleccionaste SI" );
       
       funcion.eliminarCargo(txtId.getText());
        JOptionPane.showMessageDialog(null,"Registro eliminado correctamente");
        limpiarFormulario();
        
         frmIndexCargo.btnActualizar.doClick(); //para actualizar el INDEX
      
       }else if (res == JOptionPane.NO_OPTION) {
     

       } else if (res == JOptionPane.CLOSED_OPTION) {
      
       } 
   
    }
    
    private void eliminarCargos2(){
    
    int confirmado = JOptionPane.showConfirmDialog(
         null,
         "¿Lo confirmas?");

             if (JOptionPane.OK_OPTION == confirmado){
             
                 funcion.eliminarCargo(txtId.getText());
                 JOptionPane.showMessageDialog(null,"Registro eliminado correctamente");
                  limpiarFormulario();
                  
                   frmIndexCargo.btnActualizar.doClick(); //para actualizar el INDEX
                 
                 
             }else{
                            //Ok no borraré nada
             }
    
    }
    
    private void limpiarFormulario(){
    
        txtId.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtDepartamento.setText("");
        txtEstado.setText("");
        txtFecha.setText("");
        txtHora.setText("");
        btnEliminar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
    
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombre4;
    private javax.swing.JLabel lblNombre5;
    private javax.swing.JLabel lblNombre6;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBase;
    private javax.swing.JPanel pnlFormulario;
    public static javax.swing.JTextField txtDepartamento;
    public static javax.swing.JTextArea txtDescripcion;
    public static javax.swing.JTextField txtEstado;
    public static javax.swing.JTextField txtFecha;
    public static javax.swing.JTextField txtHora;
    public static javax.swing.JTextField txtId;
    public static javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    
}
