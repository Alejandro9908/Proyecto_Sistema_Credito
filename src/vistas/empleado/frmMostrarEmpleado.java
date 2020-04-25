/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.empleado;

import controladores.FEmpleado;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import modelo.Empleado;
import vistas.cargo.frmEditarCargo;
import static vistas.empleado.frmNuevoEmpleado.txtIdCargo;
import static vistas.empleado.frmNuevoEmpleado.txtIdMunicipio;
import static vistas.empleado.frmNuevoEmpleado.txtIdSucursal;
import static vistas.frmEscritorio.dpnlEscritorio;
import vistas.frmSeleccionar;
import static vistas.sucursal.frmMostrarSucursal.txtCorreo;
import static vistas.sucursal.frmMostrarSucursal.txtDepartamento;
import static vistas.sucursal.frmMostrarSucursal.txtDireccion;
import static vistas.sucursal.frmMostrarSucursal.txtEstado;
import static vistas.sucursal.frmMostrarSucursal.txtFecha;
import static vistas.sucursal.frmMostrarSucursal.txtHora;
import static vistas.sucursal.frmMostrarSucursal.txtId;
import static vistas.sucursal.frmMostrarSucursal.txtIdDepartamento;
import static vistas.sucursal.frmMostrarSucursal.txtIdMunicipio;
import static vistas.sucursal.frmMostrarSucursal.txtMunicipio;
import static vistas.sucursal.frmMostrarSucursal.txtNombre;
import static vistas.sucursal.frmMostrarSucursal.txtTelefono;

/**
 *
 * @author Alejandro
 */
public class frmMostrarEmpleado extends javax.swing.JInternalFrame implements ActionListener{

    
       FEmpleado funcion = new FEmpleado();
    
    /**
     * Creates new form frmMostrarEmpleado
     */
    public frmMostrarEmpleado() {
        initComponents();
        JScrollPane jsp = new JScrollPane();
        jsp.setViewportView(pnlBase);
        add(jsp);
        
        
        txtIdMunicipio.setVisible(false);
        txtIdSucursal.setVisible(false);
        txtIdCargo.setVisible(false);
        
        
        //AGREGAMOS LOS BOTONES AL ACTION LISTENER
        btnEditar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnSucursal.addActionListener(this);
        btnMunicipio.addActionListener(this);
        btnCargo.addActionListener(this);
        btnCancelar.addActionListener(this);
        btnGuardar.addActionListener(this);
     
        
        panelFoto.setEnabled(false);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(btnEditar == e.getSource()){
            desbloquearDatos();
            
            
            
        }
        
        if(btnGuardar == e.getSource()){ 
           editarEmpleado(); 
            
        }
        
        if(e.getSource()== btnEliminar){
            
            eliminarEmpleado();
            
        }
        
        
        if( e.getSource()==btnMunicipio){
             frmSeleccionar f = new frmSeleccionar(6,"QUEMADO"); //el numero es para que se haga universal, pero creo que solo usaremos esa ventana
            //el dato quemado es solamente para que no busque ninguna direccion, solo se ocupa en la opcion dos
            f.setVisible(true);
            
            
        }
        
           if( e.getSource()==btnCargo){
             frmSeleccionar f = new frmSeleccionar(7,"QUEMADO"); //el numero es para que se haga universal, pero creo que solo usaremos esa ventana
            //el dato quemado es solamente para que no busque ninguna direccion, solo se ocupa en la opcion dos
            f.setVisible(true);
            
            
        }
           
              if( e.getSource()==btnSucursal){
             frmSeleccionar f = new frmSeleccionar(8,"QUEMADO"); //el numero es para que se haga universal, pero creo que solo usaremos esa ventana
            //el dato quemado es solamente para que no busque ninguna direccion, solo se ocupa en la opcion dos
            f.setVisible(true);
            
     
        }
              
              if(e.getSource()==btnCancelar){
                  cancelar();
                  
              }
           
           
    }
    
    
    private void cancelar(){
        this.dispose();
    }
    

    @Override
    public void dispose() {
        super.dispose(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
     private void desbloquearDatos(){
        
        txtDpi.setEnabled(true);
        txtNombre1.setEnabled(true);
        txtNombre2.setEnabled(true);
        txtNombre3.setEnabled(true);
        txtApellido1.setEnabled(true);
        txtApellido2.setEnabled(true);
        txtApellidoCasado.setEnabled(true);
        cbEstadoCivil.setEnabled(true);
        panelFoto.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtCorreo.setEnabled(true);
        cbGenero.setEnabled(true);
        txtProfesion.setEnabled(true);
        txtSueldo.setEnabled(true);
        txtFechaNacimiento.setEnabled(true);
        
        
        
        btnGuardar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnMunicipio.setEnabled(true);
        btnCargo.setEnabled(true);
        btnSucursal.setEnabled(true);
        lblTitulo.setText("Editar Empleado");
        
    }
     
     
     private void bloquearDatos(){
        
        txtDpi.setEnabled(false);
        txtNombre1.setEnabled(false);
        txtNombre2.setEnabled(false);
        txtNombre3.setEnabled(false);
        txtApellido1.setEnabled(false);
        txtApellido2.setEnabled(false);
        txtApellidoCasado.setEnabled(false);
        cbEstadoCivil.setEnabled(false);
        panelFoto.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtCorreo.setEnabled(false);
        cbGenero.setEnabled(false);
        txtProfesion.setEnabled(false);
        txtSueldo.setEnabled(false);
        txtFechaNacimiento.setEnabled(false);
        
        
        
        btnGuardar.setEnabled(false);
        btnEditar.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnMunicipio.setEnabled(false);
        btnCargo.setEnabled(false);
        btnSucursal.setEnabled(false);
        lblTitulo.setText("Detalles del Empleado");
        
    }
     
     
      private void editarEmpleado(){
        
        if(txtId.getText().length()==0 || txtDpi.getText().length()==0 || txtNombre1.getText().length()==0 || txtApellido1.getText().length()==0 || txtIdCargo.getText().length()==0 || txtIdMunicipio.getText().length()==0 || txtTelefono.getText().length()==0 || txtCorreo.getText().length()==0 || txtProfesion.getText().length()==0 || txtSueldo.getText().length()==0 ){
              JOptionPane.showMessageDialog(null, "Hace falta rellenar campos obligatorios");
        }
        else{
            
            
            Empleado empleado = new  Empleado();
            empleado.setId_empleado(Integer.parseInt(txtId.getText()));
            empleado.setId_sucursal(Integer.parseInt(txtIdSucursal.getText()));
            empleado.setDpi(txtDpi.getText());
            empleado.setPrimer_nombre(txtNombre1.getText());
            empleado.setSegundo_nombre(txtNombre2.getText());
            empleado.setTercer_nombre(txtNombre3.getText());
            empleado.setPrimer_apellido(txtApellido1.getText());
            empleado.setSegundo_apellido(txtApellido2.getText());
            empleado.setApellido_casado(txtApellidoCasado.getText());
            empleado.setId_cargo(Integer.parseInt(txtIdCargo.getText()));
           // empleado.setId_departamento(Integer.parseInt(txtIdDepartamento.getText()));
            empleado.setEstado_civil(cbEstadoCivil.getSelectedItem().toString());
            empleado.setFoto(panelFoto.getBytes());
            empleado.setId_municipio(Integer.parseInt(txtIdMunicipio.getText()));
            empleado.setTelefono(txtTelefono.getText());
            empleado.setCorreo(txtCorreo.getText());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            
            java.util.Date utilStartDate = txtFechaNacimiento.getDate();
            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
            
            empleado.setFecha_nacimiento(sqlStartDate);
           
            //String fecha = (df.format(txtFechaNacimiento.getDate()));
            //JOptionPane.showMessageDialog(null, df.format(txtFechaNacimiento.getDate()));
           //
          // empleado.setFecha_nacimiento(new java.sql.Date(((Date) txtFechaNacimiento.getDate())));
           //empleado.setFecha_nacimiento(new java.sql.Date (((Date) txtFechaNacimiento.getCalendar().getTime())));
           empleado.setGenero(cbGenero.getSelectedItem().toString());
           empleado.setProfesion(txtProfesion.getText());
           empleado.setSueldo(Float.parseFloat(txtSueldo.getText()));
           empleado.setId_usuario(1);
           empleado.setDireccion(txtDireccion.getText());
           
           
  
        funcion.editarEmpleado(empleado, txtId.getText());
        JOptionPane.showMessageDialog(null,"Registro editado correctamente");
       // panelFoto.setImagenNull();
         frmIndexEmpleado.btnActualizar.doClick();
         
        bloquearDatos();
  
        }
       
        
    }
      
      
       private void eliminarEmpleado(){
        int confirmado = JOptionPane.showConfirmDialog(
         null,
         "¿Estas seguro que deseas eliminar el registro?");

             if (JOptionPane.OK_OPTION == confirmado){
             
                 funcion.eliminarEmpleado(txtId.getText());
                 JOptionPane.showMessageDialog(null,"Registro eliminado correctamente");
                  limpiarFormulario();
                  
                   frmIndexEmpleado.btnActualizar.doClick(); //para actualizar el INDEX
                 
                 
             }else{
                            //Ok no borraré nada
             }
    }
       
        private void limpiarFormulario(){
        
        txtId.setText("");
        txtDpi.setText("");
        txtNombre1.setText("");
       
        txtNombre2.setText("");
        txtNombre3.setText("");
        txtApellido1.setText("");
        txtApellido2.setText("");
        txtApellidoCasado.setText("");
        txtIdCargo.setText("");
        cbEstadoCivil.setEnabled(false);
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtFechaNacimiento.setCalendar(null);
        cbGenero.setEnabled(false);
        txtProfesion.setText("");
        txtSueldo.setText("");
        //txtId_Usuario.setText("");
        txtDireccion.setText("");
        panelFoto.setImagenNull();
        
        txtFecha.setText("");
        txtHora.setText("");
        txtMunicipio.setText("");
        txtCargo.setText("");
        txtSucursal.setText("");
        txtEstado.setText("");
        
        
        
        
        
        
        btnEliminar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnMunicipio.setEnabled(false);
        btnCargo.setEnabled(false);
        btnSucursal.setEnabled(false);
        
        bloquearDatos();
        btnEditar.setEnabled(false);
        
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
        lblTitulo = new javax.swing.JLabel();
        pnlFormularioPersonal = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre2 = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblNombre2 = new javax.swing.JLabel();
        lblNombre6 = new javax.swing.JLabel();
        lblNombre3 = new javax.swing.JLabel();
        txtDpi = new javax.swing.JTextField();
        lblNombre4 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        lblNombre5 = new javax.swing.JLabel();
        txtApellido2 = new javax.swing.JTextField();
        lblNombre7 = new javax.swing.JLabel();
        txtNombre3 = new javax.swing.JTextField();
        lblNombre8 = new javax.swing.JLabel();
        txtApellido1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblNombre9 = new javax.swing.JLabel();
        txtApellidoCasado = new javax.swing.JTextField();
        lblNombre10 = new javax.swing.JLabel();
        lblNombre11 = new javax.swing.JLabel();
        txtProfesion = new javax.swing.JTextField();
        lblNombre13 = new javax.swing.JLabel();
        lblNombre27 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        lblNombre28 = new javax.swing.JLabel();
        cbEstadoCivil = new javax.swing.JComboBox<>();
        cbGenero = new javax.swing.JComboBox<>();
        txtFechaNacimiento = new com.toedter.calendar.JDateChooser();
        panelFoto = new JPanelWebCam.JPanelWebCam();
        pnlFormularioContacto = new javax.swing.JPanel();
        lblNombre15 = new javax.swing.JLabel();
        lblNombre14 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblNombre12 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblNombre16 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblNombre20 = new javax.swing.JLabel();
        txtMunicipio = new javax.swing.JTextField();
        btnMunicipio = new javax.swing.JButton();
        txtIdMunicipio = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblNombre22 = new javax.swing.JLabel();
        btnSucursal = new javax.swing.JButton();
        lblNombre23 = new javax.swing.JLabel();
        txtSucursal = new javax.swing.JTextField();
        lblNombre25 = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        lblNombre26 = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        lblNombre29 = new javax.swing.JLabel();
        lblNombre30 = new javax.swing.JLabel();
        btnCargo = new javax.swing.JButton();
        txtIdSucursal = new javax.swing.JTextField();
        txtIdCargo = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setMaximumSize(new java.awt.Dimension(680, 700));
        setPreferredSize(new java.awt.Dimension(680, 750));

        pnlBase.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        lblTitulo.setText("Detalles del Empleado");

        pnlFormularioPersonal.setBackground(new java.awt.Color(255, 255, 255));

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre.setText("Primer Nombre");

        txtNombre2.setEnabled(false);

        lblNombre1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre1.setText("Genero");

        txtId.setEnabled(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        lblNombre2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre2.setText("Id");

        lblNombre6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre6.setText("Profesión");

        lblNombre3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre3.setText("DPI");

        txtDpi.setEnabled(false);
        txtDpi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDpiActionPerformed(evt);
            }
        });

        lblNombre4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre4.setText("Segundo Nombre");

        txtNombre1.setToolTipText("");
        txtNombre1.setEnabled(false);

        lblNombre5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre5.setText("Tercer Nombre");

        txtApellido2.setEnabled(false);

        lblNombre7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre7.setText("Primer Apellido");

        txtNombre3.setEnabled(false);

        lblNombre8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre8.setText("Segundo Apellido");

        txtApellido1.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        lblNombre9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre9.setText("Apellido de Casado");

        txtApellidoCasado.setEnabled(false);

        lblNombre10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre10.setText("Estado Civil");

        lblNombre11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombre11.setText("Datos del empleado");

        txtProfesion.setEnabled(false);

        lblNombre13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre13.setText("Fecha de Nacimiento");

        lblNombre27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre27.setText("Estado:");

        txtEstado.setEnabled(false);

        lblNombre28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre28.setText("Foto");

        cbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casado", "Soltero", "Divorciado", "Viudo", "Unido" }));
        cbEstadoCivil.setEnabled(false);

        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        cbGenero.setEnabled(false);

        txtFechaNacimiento.setEnabled(false);

        panelFoto.setBackground(new java.awt.Color(255, 255, 255));
        panelFoto.setToolTipText("");
        panelFoto.setEnabled(false);

        javax.swing.GroupLayout panelFotoLayout = new javax.swing.GroupLayout(panelFoto);
        panelFoto.setLayout(panelFotoLayout);
        panelFotoLayout.setHorizontalGroup(
            panelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 167, Short.MAX_VALUE)
        );
        panelFotoLayout.setVerticalGroup(
            panelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlFormularioPersonalLayout = new javax.swing.GroupLayout(pnlFormularioPersonal);
        pnlFormularioPersonal.setLayout(pnlFormularioPersonalLayout);
        pnlFormularioPersonalLayout.setHorizontalGroup(
            pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                        .addComponent(lblNombre11)
                        .addGap(64, 64, 64))
                    .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                        .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDpi))
                            .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                                .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                                        .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblNombre5))
                                        .addGap(18, 18, 18)
                                        .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblNombre9)
                                            .addComponent(lblNombre7)
                                            .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lblNombre8)
                                    .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                                        .addComponent(lblNombre2)
                                        .addGap(182, 182, 182)
                                        .addComponent(lblNombre3))
                                    .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                                        .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                                                .addComponent(lblNombre)
                                                .addGap(104, 104, 104))
                                            .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                                                .addComponent(txtNombre1)
                                                .addGap(18, 18, 18)))
                                        .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblNombre4)
                                            .addComponent(txtNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                                        .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblNombre6)
                                            .addComponent(lblNombre10)
                                            .addComponent(cbEstadoCivil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblNombre1)
                                            .addComponent(txtApellidoCasado, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNombre27)
                            .addComponent(lblNombre28)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                        .addComponent(txtProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblNombre13)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormularioPersonalLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87))))))
        );
        pnlFormularioPersonalLayout.setVerticalGroup(
            pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblNombre11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre2)
                    .addComponent(lblNombre3)
                    .addComponent(lblNombre27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDpi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(lblNombre4)
                    .addComponent(lblNombre28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                        .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre7)
                            .addComponent(lblNombre5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre8)
                            .addComponent(lblNombre9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidoCasado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre10)
                            .addComponent(lblNombre1)))
                    .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre6)
                    .addComponent(lblNombre13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtProfesion, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlFormularioContacto.setBackground(new java.awt.Color(255, 255, 255));

        lblNombre15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombre15.setText("Datos de contacto");

        lblNombre14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre14.setText("Teléfono");

        txtTelefono.setEnabled(false);

        lblNombre12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre12.setText("Correo");

        txtCorreo.setEnabled(false);

        lblNombre16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre16.setText("Direccion");

        txtDireccion.setEnabled(false);

        lblNombre20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre20.setText("Municipio");

        txtMunicipio.setEnabled(false);

        btnMunicipio.setBackground(new java.awt.Color(255, 255, 255));
        btnMunicipio.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnMunicipio.setText("Seleccionar");
        btnMunicipio.setEnabled(false);

        txtIdMunicipio.setEnabled(false);
        txtIdMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdMunicipioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFormularioContactoLayout = new javax.swing.GroupLayout(pnlFormularioContacto);
        pnlFormularioContacto.setLayout(pnlFormularioContactoLayout);
        pnlFormularioContactoLayout.setHorizontalGroup(
            pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioContactoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDireccion)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblNombre15)
                        .addComponent(lblNombre16)
                        .addGroup(pnlFormularioContactoLayout.createSequentialGroup()
                            .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNombre14))
                            .addGap(105, 105, 105)
                            .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblNombre12)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                .addComponent(btnMunicipio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(pnlFormularioContactoLayout.createSequentialGroup()
                            .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtIdMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblNombre20))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFormularioContactoLayout.setVerticalGroup(
            pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioContactoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre15)
                .addGap(18, 18, 18)
                .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre14)
                    .addComponent(lblNombre12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblNombre22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombre22.setText("Datos de empleo");

        btnSucursal.setBackground(new java.awt.Color(255, 255, 255));
        btnSucursal.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnSucursal.setText("Seleccionar");
        btnSucursal.setEnabled(false);

        lblNombre23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre23.setText("Sucursal");

        txtSucursal.setEnabled(false);

        lblNombre25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre25.setText("Cargo");

        txtCargo.setEnabled(false);

        lblNombre26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre26.setText("Sueldo");

        txtSueldo.setEnabled(false);

        txtFecha.setEnabled(false);

        txtHora.setEnabled(false);

        lblNombre29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre29.setText("Fecha de Creacion");

        lblNombre30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre30.setText("Hora de Creacion");

        btnCargo.setBackground(new java.awt.Color(255, 255, 255));
        btnCargo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnCargo.setText("Seleccionar");
        btnCargo.setEnabled(false);

        txtIdSucursal.setEnabled(false);
        txtIdSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdSucursalActionPerformed(evt);
            }
        });

        txtIdCargo.setEnabled(false);
        txtIdCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCargoActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnEditar.setText("Editar");

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblNombre26)
                        .addGap(152, 152, 152)
                        .addComponent(lblNombre29)
                        .addGap(100, 100, 100)
                        .addComponent(lblNombre30))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblNombre23)
                        .addGap(85, 85, 85)
                        .addComponent(txtIdSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNombre22)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                    .addComponent(lblNombre25)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCargo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSucursal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                            .addComponent(btnCargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHora)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre22)
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombre23)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIdCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombre25)
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre26)
                    .addComponent(lblNombre29)
                    .addComponent(lblNombre30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(btnEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBaseLayout = new javax.swing.GroupLayout(pnlBase);
        pnlBase.setLayout(pnlBaseLayout);
        pnlBaseLayout.setHorizontalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTitulo)
                    .addComponent(pnlFormularioContacto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFormularioPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBaseLayout.setVerticalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFormularioPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFormularioContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(pnlBase, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtDpiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDpiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDpiActionPerformed

    private void txtIdSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdSucursalActionPerformed

    private void txtIdCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCargoActionPerformed

    private void txtIdMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdMunicipioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdMunicipioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCargo;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMunicipio;
    private javax.swing.JButton btnSucursal;
    public static javax.swing.JComboBox<String> cbEstadoCivil;
    public static javax.swing.JComboBox<String> cbGenero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre10;
    private javax.swing.JLabel lblNombre11;
    private javax.swing.JLabel lblNombre12;
    private javax.swing.JLabel lblNombre13;
    private javax.swing.JLabel lblNombre14;
    private javax.swing.JLabel lblNombre15;
    private javax.swing.JLabel lblNombre16;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre20;
    private javax.swing.JLabel lblNombre22;
    private javax.swing.JLabel lblNombre23;
    private javax.swing.JLabel lblNombre25;
    private javax.swing.JLabel lblNombre26;
    private javax.swing.JLabel lblNombre27;
    private javax.swing.JLabel lblNombre28;
    private javax.swing.JLabel lblNombre29;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombre30;
    private javax.swing.JLabel lblNombre4;
    private javax.swing.JLabel lblNombre5;
    private javax.swing.JLabel lblNombre6;
    private javax.swing.JLabel lblNombre7;
    private javax.swing.JLabel lblNombre8;
    private javax.swing.JLabel lblNombre9;
    private javax.swing.JLabel lblTitulo;
    public static JPanelWebCam.JPanelWebCam panelFoto;
    private javax.swing.JPanel pnlBase;
    private javax.swing.JPanel pnlFormularioContacto;
    private javax.swing.JPanel pnlFormularioPersonal;
    public static javax.swing.JTextField txtApellido1;
    public static javax.swing.JTextField txtApellido2;
    public static javax.swing.JTextField txtApellidoCasado;
    public static javax.swing.JTextField txtCargo;
    public static javax.swing.JTextField txtCorreo;
    public static javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtDpi;
    public static javax.swing.JTextField txtEstado;
    public static javax.swing.JTextField txtFecha;
    public static com.toedter.calendar.JDateChooser txtFechaNacimiento;
    public static javax.swing.JTextField txtHora;
    public static javax.swing.JTextField txtId;
    public static javax.swing.JTextField txtIdCargo;
    public static javax.swing.JTextField txtIdMunicipio;
    public static javax.swing.JTextField txtIdSucursal;
    public static javax.swing.JTextField txtMunicipio;
    public static javax.swing.JTextField txtNombre1;
    public static javax.swing.JTextField txtNombre2;
    public static javax.swing.JTextField txtNombre3;
    public static javax.swing.JTextField txtProfesion;
    public static javax.swing.JTextField txtSucursal;
    public static javax.swing.JTextField txtSueldo;
    public static javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
