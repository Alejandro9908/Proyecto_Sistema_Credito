/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.garantia;

import controladores.FGarantia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Garantia;
import static vistas.empleado.frmMostrarEmpleado.txtId;
import vistas.frmSeleccionar;
import static vistas.garantia.frmNuevoGarantia.txtIdtipo;
import static vistas.garantia.frmNuevoGarantia.txtNombre;

/**
 *
 * @author Alejandro
 */
public class frmMostrarGarantia extends javax.swing.JInternalFrame implements ActionListener {
  
    
    FGarantia funcion = new FGarantia();
    String idAlumno;
    
    public frmMostrarGarantia() {
        initComponents();
       // panelFoto.setImagenNull();
        btnEditar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnTipo.addActionListener(this);
        btnCancelar.addActionListener(this);
        btnGuardar.addActionListener(this);
        btnT.addActionListener(this);
        txtIdtipo.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    if(btnEditar == e.getSource()){
            desbloquearDatos();
            
            
            
        }
     if(btnGuardar == e.getSource()){ 
           editar(); 
           //panelFoto.setImagenNull();
        }
     
     if(e.getSource()== btnEliminar){
            
            //eliminarEmpleado();
            
        }
     
      if (e.getSource()==btnTipo){
            
             frmSeleccionar f = new frmSeleccionar(10,"QUEMADO"); //el numero es para que se haga universal, pero creo que solo usaremos esa ventana
            //el dato quemado es solamente para que no busque ningun departamento, solo se ocupa en la opcion dos
            f.setVisible(true);
        }
    
     if(e.getSource()==btnCancelar){
                  cancelar();
                  
              }
     
     if(e.getSource()==btnT){
     
       desbloquearDatos1();
     
     }
    
    }

     private void editar(){
     
         if(txtNombre.getText().length()==0 ||txtDireccion.getText().length()==0 || txtCorreo.getText().length()==0 || txtId1.getText().length()==1){
         JOptionPane.showMessageDialog(null,"Hace falta rellenar campos obligatorios");
         
         }/*else if(txtId1.getText().length()==null){
           JOptionPane.showMessageDialog(null,"Hace falta rellenar campos obligatorios");                   
         }*/else{
          Garantia garantia = new Garantia();
          
          //empleado.setId_empleado(Integer.parseInt(txtId.getText()));
          garantia.setId_garantia(Integer.parseInt(txtId.getText()));
          garantia.setNombre(txtNombre.getText());
          garantia.setN_documento(txtId1.getText());
          garantia.setId_tipo_garantia(Integer.parseInt(txtIdtipo.getText()));
          garantia.setDescripcion(txtDireccion.getText());
          //garantia.setFotografia(panelFoto.getBytes());
          garantia.setValuacion(Float.parseFloat(txtCorreo.getText()));
          
          funcion.editarGarantia(garantia, txtId.getText());
          //panelFoto.setImagenNull();
          //limpiarDatos();
          JOptionPane.showMessageDialog(null,"Datos editados Correctamente");
         
          frmIndexGarantia.btnActualizar.doClick();
         bloquear();
        bloquearDatos();
         }
        
     }
     
     public void limpiarDatos(){
    
     txtId.setText("");
     txtNombre.setText("");
     txtId1.setText("");
     txtIdtipo.setText("");
     txtDireccion.setText("");
     txtCorreo.setText("");
     txtCorreo1.setText("");
     panelFoto.setImagenNull();
    
    }
     
      private void desbloquearDatos(){
      
      txtNombre.setEnabled(true);
     //txtId1.setEnabled(true);
     txtIdtipo.setEnabled(true);
     txtDireccion.setEnabled(true);
     txtCorreo.setEnabled(true);
     txtCorreo1.setEnabled(false);    
     panelFoto.setEnabled(false);  
     
     
        btnGuardar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnTipo.setEnabled(true);
        jLabel1.setText("Editar Garantia");
      }
      
      private void bloquearDatos(){
      
       txtNombre.setEnabled(false);
     //txtId1.setEnabled(false);
     txtIdtipo.setEnabled(false);
     txtDireccion.setEnabled(false);
     txtCorreo.setEnabled(false);
     txtCorreo1.setEnabled(false);    
     //panelFoto.setEnabled(false);  
     
     
        btnGuardar.setEnabled(false);
        btnEditar.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnTipo.setEnabled(false);
        jLabel1.setText("Detalles Garantia");
      
      }
    
      private void cancelar(){
        this.dispose();
    }
    private void desbloquearDatos1(){
    
        txtId1.setEnabled(true);
    
    }
    
    private void bloquear(){
     
        txtId1.setEnabled(false);
        btnT.setEnabled(false);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        txtId = new javax.swing.JTextField();
        lblNombre2 = new javax.swing.JLabel();
        lblNombre6 = new javax.swing.JLabel();
        lblNombre8 = new javax.swing.JLabel();
        lblNombre9 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblNombre3 = new javax.swing.JLabel();
        txtId1 = new javax.swing.JTextField();
        btnGuardar1 = new javax.swing.JButton();
        lblNombre10 = new javax.swing.JLabel();
        txtCorreo1 = new javax.swing.JTextField();
        btnTipo = new javax.swing.JButton();
        panelFoto = new JPanelWebCam.JPanelWebCam();
        txtIdtipo = new javax.swing.JTextField();
        btnT = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        pnlBase.setBackground(new java.awt.Color(255, 255, 255));

        pnlFormulario.setBackground(new java.awt.Color(255, 255, 255));

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre.setText("Nombre");

        txtNombre.setEnabled(false);

        txtDireccion.setColumns(20);
        txtDireccion.setRows(5);
        txtDireccion.setEnabled(false);
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
        lblNombre6.setText("Descripción");

        lblNombre8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre8.setText("Foto");

        lblNombre9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre9.setText("Valuación");

        txtCorreo.setEnabled(false);

        lblNombre3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre3.setText("Número de Identificación");

        txtId1.setEnabled(false);
        txtId1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtId1ActionPerformed(evt);
            }
        });

        btnGuardar1.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnGuardar1.setText("Seleccionar Foto");
        btnGuardar1.setEnabled(false);

        lblNombre10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre10.setText("Tipo");

        txtCorreo1.setEnabled(false);

        btnTipo.setText("...");

        panelFoto.setBackground(new java.awt.Color(255, 255, 255));
        panelFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelFoto.setToolTipText("");

        javax.swing.GroupLayout panelFotoLayout = new javax.swing.GroupLayout(panelFoto);
        panelFoto.setLayout(panelFotoLayout);
        panelFotoLayout.setHorizontalGroup(
            panelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelFotoLayout.setVerticalGroup(
            panelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnT.setText("...");

        javax.swing.GroupLayout pnlFormularioLayout = new javax.swing.GroupLayout(pnlFormulario);
        pnlFormulario.setLayout(pnlFormularioLayout);
        pnlFormularioLayout.setHorizontalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre)
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGuardar1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(lblNombre8)
                            .addComponent(panelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(txtCorreo)
                            .addGroup(pnlFormularioLayout.createSequentialGroup()
                                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre9)
                                    .addComponent(lblNombre6)
                                    .addComponent(lblNombre10)
                                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                                        .addComponent(txtCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnTipo)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addGroup(pnlFormularioLayout.createSequentialGroup()
                                .addComponent(lblNombre2)
                                .addGap(188, 188, 188)
                                .addComponent(lblNombre3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtId1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnT)
                        .addGap(2, 2, 2)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormularioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtIdtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145))
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
                    .addComponent(txtId1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre8)
                    .addComponent(lblNombre10))
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombre6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombre9))
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(panelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(txtIdtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel1.setText("Detalles de la Garantía");

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnEditar.setText("Editar");

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);

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
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        pnlBaseLayout.setVerticalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(pnlFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(pnlBase, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtId1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtId1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtId1ActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnT;
    private javax.swing.JButton btnTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre10;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombre6;
    private javax.swing.JLabel lblNombre8;
    private javax.swing.JLabel lblNombre9;
    public static JPanelWebCam.JPanelWebCam panelFoto;
    private javax.swing.JPanel pnlBase;
    private javax.swing.JPanel pnlFormulario;
    public static javax.swing.JTextField txtCorreo;
    public static javax.swing.JTextField txtCorreo1;
    public static javax.swing.JTextArea txtDireccion;
    public static javax.swing.JTextField txtId;
    public static javax.swing.JTextField txtId1;
    public static javax.swing.JTextField txtIdtipo;
    public static javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
