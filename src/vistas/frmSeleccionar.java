/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.FEmpleado;
import controladores.FSucursal;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vistas.empleado.frmMostrarEmpleado;
import vistas.empleado.frmNuevoEmpleado;
import vistas.sucursal.frmMostrarSucursal;



/**
 *
 * @author Kevin
 */
public class frmSeleccionar extends javax.swing.JFrame {
    
    //Variables para el departamento
    public static String id_departamento;
    public static String nombre_departamento;
    FSucursal funcion = new FSucursal();
    
    //Variables para el municipio
    
    public static String id_municipio, nombre_municipio;
    
    //variables para seleccionar la sucursal en FrmNuevoEmpleado
    FEmpleado funcionEmpleado = new FEmpleado();
    public static String id_sucursal, nombre_sucursal;
    
    
    //variables para seleccionar el cargo en FrmNuevoEmpleado
    public static String id_cargo, nombre_cargo;
    
    
    //Variables para selecionar el municipio en FrmNuevoEMpleado
    
    public static String id_municipioEmpleado, nombre_municipioEmpleado;
    
    
    
    
    DefaultTableModel modelo;
    private int opcion;
    private String departamento;
    
    /**
     * Creates new form frmBuscarProfesor
     */
    public frmSeleccionar(int Opcion, String Departamento) {
        this.opcion = Opcion;
        this.departamento = Departamento;
        
        
        initComponents();
        
        if(opcion==1){
           txtAccion.setText("Seleccione un departamento");
           mostrarDepartamentos();
             
        }
        if(opcion==2){
            txtAccion.setText("Seleccione un municipio");
            mostrarMunicipios();
        }
        if(opcion==3){
            txtAccion.setText("Seleccione una sucursal");
            mostrarSucursales();
        }
        
        if(opcion==4){
            txtAccion.setText("Seleccione un cargo");
            mostrarCargos();
            
        }
        
        if(opcion==5){
            txtAccion.setText("Seleccione un municipio");
            mostrarMunicipiosEmpleado();
        }
        
        if(opcion==6){ //edita
            txtAccion.setText("Seleccione un municipio");
            mostrarMunicipiosEmpleado();
        }
        
        if(opcion==7){ //cargo de editar empleado
            txtAccion.setText("Seleccione un cargo");
            mostrarCargos();
            
        }
        
        if(opcion==8){ //sucursal de editar empleado
            txtAccion.setText("Seleccione una sucursal");
            mostrarSucursales();
        }
        
        
        
        
        this.setLocationRelativeTo(null); //para centrar la ventana
    }
    
    
   
    
    
    public void mostrarDepartamentos(){
        
        funcion.mostrarDepartamento(Tabla);
    }
    
    public void mostrarMunicipios(){
        
        funcion.mostrarMunicipio(Tabla, departamento);
          
    }
    
      public void mostrarSucursales(){
        
        funcionEmpleado.mostrarSucursalSeleccionar(Tabla);
          
    }
      
      public void mostrarCargos(){
          funcionEmpleado.mostrarCargoSeleccionar(Tabla);
      }
      
      public void mostrarMunicipiosEmpleado(){
          funcionEmpleado.mostrarMunicipioEmpleado(Tabla);     

      }
    
  
    
  
    private void buscarDepartamento(){
        try {
            String buscar = txtBuscar.getText(); //Es solo para prueba,, borrar luego
            
            funcion.buscarDepartamento(Tabla, buscar.toUpperCase()); //para buscar en mayusculas
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos, motivo: "+ e);
        }
    }
    
    
  
     private void buscarMunicipio(){
        try {
            String search = txtBuscar.getText(); //Es solo para prueba,, borrar luego
            
            funcion.buscarMunicipio(Tabla, departamento, search.toUpperCase()); //para buscar en mayusculas
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos, motivo: "+ e);
        }
    }
     
     
      private void buscarMunicipioGeneral(){
        try {
            String search = txtBuscar.getText(); //Es solo para prueba,, borrar luego
            
            funcionEmpleado.buscarMunicipioGeneral(Tabla, search.toUpperCase()); //para buscar en mayusculas
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos, motivo: "+ e);
        }
    }
      
      
       private void buscarCargoEmpleado(){
        try {
            String search = txtBuscar.getText(); //Es solo para prueba,, borrar luego
            
            funcionEmpleado.buscarCargoEmpleado(Tabla, search.toUpperCase()); //para buscar en mayusculas
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos, motivo: "+ e);
        }
    }
       
        private void buscarSucursalEmpleado(){
        try {
            String search = txtBuscar.getText(); //Es solo para prueba,, borrar luego
            
            funcionEmpleado.buscarSucursalEmpleado(Tabla, search.toUpperCase()); //para buscar en mayusculas
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos, motivo: "+ e);
        }
    }
    
  

    
    public void pasarDatos(){
            
        int posicion = Tabla.getSelectedRow();
         
       
        //opcion 1 == DEPARTAMENTO
        if(opcion == 1){
            
         id_departamento = (Tabla.getValueAt(posicion,0).toString());  
         nombre_departamento = (Tabla.getValueAt(posicion,1).toString());
            
         frmMostrarSucursal.txtIdDepartamento.setText(id_departamento);
         frmMostrarSucursal.txtDepartamento.setText(nombre_departamento);
         
         //voy a limpiar tambien el municipio, al cambiar el departamento es reinician los municipios
         frmMostrarSucursal.txtMunicipio.setText("");
         frmMostrarSucursal.txtIdMunicipio.setText("");
            
  
            
            
        }else if(opcion == 2){
            
            id_municipio = (Tabla.getValueAt(posicion,0).toString());  
         nombre_municipio = (Tabla.getValueAt(posicion,1).toString());
          frmMostrarSucursal.txtIdMunicipio.setText(id_municipio);
           frmMostrarSucursal.txtMunicipio.setText(nombre_municipio);
            
            
        }else if(opcion == 3){
            id_sucursal = (Tabla.getValueAt(posicion,0).toString());
            nombre_sucursal = (Tabla.getValueAt(posicion,1).toString());
            
            
            frmNuevoEmpleado.txtIdSucursal.setText(id_sucursal);
            frmNuevoEmpleado.txtSucursal.setText(nombre_sucursal);
            
            
        }else if (opcion==4){
            
            id_cargo= (Tabla.getValueAt(posicion, 0).toString());
            nombre_cargo = (Tabla.getValueAt(posicion,1).toString());
            
            frmNuevoEmpleado.txtIdCargo.setText(id_cargo);
            frmNuevoEmpleado.txtCargo.setText(nombre_cargo);
            
        }else if (opcion==5){
            
            id_municipioEmpleado= (Tabla.getValueAt(posicion, 0).toString());
            nombre_municipioEmpleado = (Tabla.getValueAt(posicion,1).toString());
            
            frmNuevoEmpleado.txtIdMunicipio.setText(id_municipioEmpleado);
            frmNuevoEmpleado.txtMunicipio.setText(nombre_municipioEmpleado);
         
        }
        
        
        else if (opcion==6){ //si la opcion 6 será municipio pero para el editar de empleado
            
            id_municipioEmpleado= (Tabla.getValueAt(posicion, 0).toString());
            nombre_municipioEmpleado = (Tabla.getValueAt(posicion,1).toString());
            
            frmMostrarEmpleado.txtIdMunicipio.setText(id_municipioEmpleado);
            frmMostrarEmpleado.txtMunicipio.setText(nombre_municipioEmpleado);
         
        }     
        else if (opcion==7){ //si la opcion 7 será cargo de editar empleado
            
            id_cargo= (Tabla.getValueAt(posicion, 0).toString());
            nombre_cargo = (Tabla.getValueAt(posicion,1).toString());
            
            frmMostrarEmpleado.txtIdCargo.setText(id_cargo);
            frmMostrarEmpleado.txtCargo.setText(nombre_cargo);
         
        }
        
        else if (opcion==8){ //si la opcion 8 será sucursal de editar empleado
            
            id_sucursal= (Tabla.getValueAt(posicion, 0).toString());
            nombre_sucursal = (Tabla.getValueAt(posicion,1).toString());
            
            frmMostrarEmpleado.txtIdSucursal.setText(id_sucursal);
            frmMostrarEmpleado.txtSucursal.setText(nombre_sucursal);
         
        }
        
        //para cerrar el frmBuscar
        this.dispose(); 
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
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtAccion = new javax.swing.JLabel();

        setTitle("Seleccione");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtBuscar.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtBuscarCaretUpdate(evt);
            }
        });
        txtBuscar.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtBuscarInputMethodTextChanged(evt);
            }
        });

        jLabel1.setText("Nombre:");

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtAccion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtAccion.setText("Accion a realizar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtBuscar)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtAccion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtAccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtBuscarInputMethodTextChanged
       // buscarNombre();
    }//GEN-LAST:event_txtBuscarInputMethodTextChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      //  buscarNombre();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtBuscarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBuscarCaretUpdate
      
        if(opcion==1){
       buscarDepartamento();    
        }
        
        
        //Solamente buscara los del departamento seleccionado Att.Kevin
        if(opcion==2){
        buscarMunicipio();
        }
        
        if(opcion==3){ //para sucursal
            buscarSucursalEmpleado();
            
            
        }
        
        if(opcion==4){ //para buscar cargo
            buscarCargoEmpleado();
            
        }
        
        if(opcion==5){ //para buscar municipio con el empleado
            buscarMunicipioGeneral();
           
        }
        
        if(opcion==6){ //busca municipios en el buscar Editar
            buscarMunicipioGeneral();
            
        }
        
        if(opcion==7){ //buscar en cargo editar empleado
            buscarCargoEmpleado();
            
            
        }
        
        if(opcion==8){ //buscar en sucursal editar empleado
            buscarSucursalEmpleado();
            
            
        }
       
       
       
        
        
    }//GEN-LAST:event_txtBuscarCaretUpdate

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
       
       pasarDatos();
        
    }//GEN-LAST:event_TablaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable Tabla;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel txtAccion;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
