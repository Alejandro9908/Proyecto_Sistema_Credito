/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.sucursal;

import controladores.FSucursal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;
import modelo.Departamento;
import modelo.Municipio;
import modelo.Sucursal;
import vistas.cargo.frmIndexCargo;

/**
 *
 * @author Alejandro
 */
public class frmNuevoSucursal extends javax.swing.JInternalFrame implements ActionListener{

     FSucursal funcion = new FSucursal();
     FSucursal funcion1 = new FSucursal();
     int n;
   
      int departamentoSelected;
      int municipioSelected;
      String accion = "guardar";
    
    public frmNuevoSucursal() {
        initComponents();
        
        //btnGuardar.addActionListener(this);
        btnCancelar.addActionListener(this);
        
         cbDepartamentos.removeAllItems();
        
        funcion.consultarDepartamento(cbDepartamentos);
        cbDepartamentos.setSelectedItem(0);
        departamentoSelected = cbDepartamentos.getItemAt(cbDepartamentos.getSelectedIndex()).getId_departamento();    
        funcion.consultarMunicipio(cbMunicipio, String.valueOf(departamentoSelected));
        municipioSelected = cbMunicipio.getItemAt(cbMunicipio.getSelectedIndex()).getId_municipio(); 

        
        btnGuardar.addActionListener(this);
          
         
         cbDepartamentos.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0){
              
              
              System.out.println("Diferente departamento");
      //Aqui veremos que hacer cuando se cambie de departamento
      departamentoSelected = cbDepartamentos.getItemAt(cbDepartamentos.getSelectedIndex()).getId_departamento(); 
     //
      
      cbMunicipio.removeAllItems();
      
      funcion.consultarMunicipio(cbMunicipio, String.valueOf(departamentoSelected));
      municipioSelected = cbMunicipio.getItemAt(cbMunicipio.getSelectedIndex()).getId_municipio(); 
                           
               }});
         
         //DE MUNICIPIOS
          cbMunicipio.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent itemEvent) {
            
        
         
        }
        });
   
        }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
       /* if (e.getSource()== btnGuardar){
            accion = "guardar";/*
            System.out.println("================================");
            System.out.println("Departamento ID: "+ cbDepartamentos.getItemAt(cbDepartamentos.getSelectedIndex()).getId_departamento());
            System.out.println("Departamento NOMBRE: "+ cbDepartamentos.getItemAt(cbDepartamentos.getSelectedIndex()).getNombre_departamento());
            
            System.out.println("Municipio ID: "+ cbMunicipio.getItemAt(cbMunicipio.getSelectedIndex()).getId_municipio());
            System.out.println("Municipio NOMBRE: "+ cbMunicipio.getItemAt(cbMunicipio.getSelectedIndex()).getNombre_muncipio());
            System.out.println("================================");*/
        //} 
        
        if(e.getSource()== btnGuardar){
        
          /*if((txtNombre.getText().length()==0)||(txtDirección.getText().length()==0)||(txtTelefono.getText().length()==0)||(txtCorreo.getText().length()==0)){
          JOptionPane.showMessageDialog(null, "Por Favor llena todos los campos necearios");
          }else{*/
            if(accion == "guardar"){
            guardaSucursal();
            //}
          }
        }
         if(e.getSource()==btnCancelar){
            this.dispose();
        }
    
    }
    
    public void guardaSucursal(){
    
     try{
     
        Sucursal sucursal = new Sucursal();
        
        sucursal.setNombre_sucursal(txtNombre.getText());
        sucursal.setDireccion(txtDirección.getText());
        sucursal.setId_municipio(cbMunicipio.getItemAt(cbMunicipio.getSelectedIndex()).getId_municipio());
        sucursal.setTelefono(txtTelefono.getText());
        sucursal.setCorreo(txtCorreo.getText());
        
        funcion.agregarSucursal(sucursal);
        
        //JOptionPane.showMessageDialog(null,"Datos Guardados Correctamente");
        frmIndexSucursal.btnActualizar.doClick();
        limpiar();
     
     }catch(Exception e){
       
       JOptionPane.showMessageDialog(null,"Error:"+e.getMessage()+"\nVerifiqueCarlos");
       
       }
    
    
    }

    public void llenarComboBoxDepartamentos(){
        funcion.consultarDepartamento(cbDepartamentos);
    }
    

    
    public void llenarComboBoxMunicipios(String id){
        
        funcion.consultarMunicipio(cbMunicipio, id);
      
    }
    
    public void limpiar(){
    
        txtNombre.setText("");
        txtDirección.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
    
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
        txtDirección = new javax.swing.JTextArea();
        txtId = new javax.swing.JTextField();
        lblNombre2 = new javax.swing.JLabel();
        lblNombre6 = new javax.swing.JLabel();
        cbDepartamentos = new javax.swing.JComboBox<>();
        lblNombre7 = new javax.swing.JLabel();
        cbMunicipio = new javax.swing.JComboBox<>();
        lblNombre8 = new javax.swing.JLabel();
        lblNombre9 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        pnlBase.setBackground(new java.awt.Color(255, 255, 255));

        pnlFormulario.setBackground(new java.awt.Color(255, 255, 255));

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre.setText("Nombre de la Sucursal");

        lblNombre1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre1.setText("Detalles de la Dirección");

        txtDirección.setColumns(20);
        txtDirección.setRows(5);
        jScrollPane1.setViewportView(txtDirección);

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

        cbDepartamentos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDepartamentosItemStateChanged(evt);
            }
        });
        cbDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDepartamentosActionPerformed(evt);
            }
        });

        lblNombre7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre7.setText("Municipio");

        cbMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMunicipioActionPerformed(evt);
            }
        });

        lblNombre8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre8.setText("Teléfono");

        lblNombre9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre9.setText("Correo");

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
                            .addComponent(lblNombre)
                            .addComponent(lblNombre2)
                            .addComponent(lblNombre1)
                            .addComponent(lblNombre6)
                            .addComponent(cbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMunicipio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlFormularioLayout.createSequentialGroup()
                                .addComponent(lblNombre7)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormularioLayout.createSequentialGroup()
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefono)
                            .addGroup(pnlFormularioLayout.createSequentialGroup()
                                .addComponent(lblNombre8)
                                .addGap(0, 109, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre9)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlFormularioLayout.setVerticalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre6)
                    .addComponent(lblNombre7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel1.setText("Nueva Sucursal");

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnGuardar.setText("Guardar");

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnCancelar.setText("Cancelar");

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
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        pnlBaseLayout.setVerticalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(pnlFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(26, 26, 26))
        );

        getContentPane().add(pnlBase, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void cbDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDepartamentosActionPerformed
        // TODO add your handling code here:
        //String seleccionado = cbDepartamentos.getSelectedItem().toString();
       //funcion.consultarIdepartamento(txtIdepartamento, seleccionado);
       
        //System.out.println(txtIdepartamento.getText());
        
        
        //llenarComboBoxMunicipios(txtIdepartamento.getText());
       
       
    }//GEN-LAST:event_cbDepartamentosActionPerformed

    private void cbMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMunicipioActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_cbMunicipioActionPerformed

    private void cbDepartamentosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDepartamentosItemStateChanged
        // TODO add your handling code here:
       
        //llenarComboBoxMunicipios(txtIdepartamento.getText());
    }//GEN-LAST:event_cbDepartamentosItemStateChanged

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    public static javax.swing.JComboBox<Departamento> cbDepartamentos;
    public static javax.swing.JComboBox<Municipio> cbMunicipio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre6;
    private javax.swing.JLabel lblNombre7;
    private javax.swing.JLabel lblNombre8;
    private javax.swing.JLabel lblNombre9;
    private javax.swing.JPanel pnlBase;
    private javax.swing.JPanel pnlFormulario;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextArea txtDirección;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
