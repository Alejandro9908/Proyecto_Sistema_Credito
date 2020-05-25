/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.empleado;

import controladores.FEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import modelo.Empleado;
import vistas.frmLogin;
import vistas.frmSeleccionar;

/**
 *
 * @author Alejandro
 */
public class frmNuevoEmpleado extends javax.swing.JInternalFrame implements ActionListener{

    
    FEmpleado funcion = new FEmpleado();
    int idUsuario = frmLogin.idUsuarioSystem;
    /**
     * Creates new form frmNuevoEmpleado
     */
    public frmNuevoEmpleado() {
        initComponents();
        JScrollPane jsp = new JScrollPane();
        jsp.setViewportView(pnlBase);
        add(jsp);
        
        txtIdMunicipio.setVisible(false);
        txtIdSucursal.setVisible(false);
        txtIdCargo.setVisible(false);
        
        btnGuardar.addActionListener(this);
        btnCancelar.addActionListener(this);
        btnSucursal.addActionListener(this);
        btnCargo.addActionListener(this);
        btnFoto.addActionListener(this);
        btnMunicipio.addActionListener(this);
        btnCancelar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == btnGuardar){
            guardarEmpleado();
            
        }
        
        if (e.getSource()==btnSucursal){
            
             frmSeleccionar f = new frmSeleccionar(3,"QUEMADO"); //el numero es para que se haga universal, pero creo que solo usaremos esa ventana
            //el dato quemado es solamente para que no busque ningun departamento, solo se ocupa en la opcion dos
            f.setVisible(true);
        }
        
        if(e.getSource()==btnCargo){
            
            frmSeleccionar f = new frmSeleccionar(4,"QUEMADO"); //el numero es para que se haga universal, pero creo que solo usaremos esa ventana
            //el dato quemado es solamente para que no busque ningun departamento, solo se ocupa en la opcion dos
            f.setVisible(true);
            
        }
        
        if(e.getSource()==btnMunicipio){
            
            frmSeleccionar f = new frmSeleccionar(5,"QUEMADO"); //el numero es para que se haga universal, pero creo que solo usaremos esa ventana
            //el dato quemado es solamente para que no busque ningun departamento, solo se ocupa en la opcion dos
            f.setVisible(true);
 
        }
        
        
        if(e.getSource()==btnCancelar){
            cancelar();
            
        }
        
        
    }

    
    private void guardarEmpleado(){
        
        if(txtDpi.getText().length()==0 || txtNombre1.getText().length()==0 || txtNombre2.getText().length()==0 || txtApellido1.getText().length()==0 ||
           txtApellido2.getText().length()==0 || cbEstadoCivil.getSelectedItem().toString()=="" || cbGenero.getSelectedItem().toString()=="" || panelFoto.getBytes().length==1 ||
           txtProfesion.getText().length()==0 || txtFechaNacimiento.getCalendar()==null || txtTelefono.getText().length()==0 || txtCorreo.getText().length()==0 || 
           txtMunicipio.getText().length()==0 || txtDireccion.getText().length()==0 || txtSucursal.getText().length()==0 || txtCargo.getText().length()==0 || txtSueldo.getText().length()==0){
        
        JOptionPane.showMessageDialog(null,"Hace falta rellenar campos obligatorios"); 
        
        }else{
        try{
            
            Empleado empleado = new  Empleado();
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
           empleado.setId_usuario(idUsuario);
           empleado.setDireccion(txtDireccion.getText());
           
           
           
           
           //new java.sql.Date(((Date) celda.getDateCellValue()).getTime())
                    
            
            funcion.guardarEmpleado(empleado);
            limpiarDatos();
            JOptionPane.showMessageDialog(null,"Datos Guardados Correctamente");
            frmIndexEmpleado.btnActualizar.doClick();
            
            
           // limpiartxt();
            
           // JOptionPane.showMessageDialog(null,"Es necesario asignar a cursos");
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null,"Error:"+e.getMessage()+"\nVerifique");
        }
        
        }
    }
    
    
    public void limpiarDatos(){
    
    txtDpi.setText("");
    txtNombre1.setText("");
    txtNombre2.setText("");
    txtNombre3.setText("");
    txtApellido1.setText("");
    txtApellido2.setText("");
    txtApellidoCasado.setText("");
    txtTelefono.setText("");
    txtCorreo.setText("");
    txtProfesion.setText("");
    txtSueldo.setText("");
    txtDireccion.setText("");
    panelFoto.setImagenNull();
    txtMunicipio.setText("");
    txtDireccion.setText("");
    txtFechaNacimiento.setCalendar(null); 
    txtSucursal.setText("");
    txtCargo.setText("");
    
    }
    
    public void cancelar(){
        
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

        jCalendar1 = new com.toedter.calendar.JCalendar();
        pnlBase = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlFormularioPersonal = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre2 = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblNombre2 = new javax.swing.JLabel();
        lblNombre6 = new javax.swing.JLabel();
        cbGenero = new javax.swing.JComboBox<>();
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
        lblNombre9 = new javax.swing.JLabel();
        txtApellidoCasado = new javax.swing.JTextField();
        btnFoto = new javax.swing.JButton();
        lblNombre10 = new javax.swing.JLabel();
        cbEstadoCivil = new javax.swing.JComboBox<>();
        lblNombre11 = new javax.swing.JLabel();
        txtProfesion = new javax.swing.JTextField();
        lblNombre13 = new javax.swing.JLabel();
        panelFoto = new JPanelWebCam.JPanelWebCam();
        txtFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
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
        btnCargo = new javax.swing.JButton();
        lblNombre26 = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        txtIdSucursal = new javax.swing.JTextField();
        txtIdCargo = new javax.swing.JTextField();

        setClosable(true);
        setResizable(true);
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(200, 40));
        setPreferredSize(new java.awt.Dimension(670, 700));

        pnlBase.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel1.setText("Nuevo Empleado");

        pnlFormularioPersonal.setBackground(new java.awt.Color(255, 255, 255));

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre.setText("Primer Nombre");

        lblNombre1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre1.setText("Genero");

        txtId.setEditable(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        lblNombre2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre2.setText("Id");

        lblNombre6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre6.setText("Profesión");

        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));

        lblNombre3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre3.setText("DPI");

        lblNombre4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre4.setText("Segundo Nombre");

        lblNombre5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre5.setText("Tercer Nombre");

        lblNombre7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre7.setText("Primer Apellido");

        lblNombre8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre8.setText("Segundo Apellido");

        lblNombre9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre9.setText("Apellido de Casado");

        btnFoto.setBackground(new java.awt.Color(255, 255, 255));
        btnFoto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFoto.setText("Seleccionar Foto");

        lblNombre10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre10.setText("Estado Civil");

        cbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casado", "Soltero", "Divorciado", "Viudo", "Unido" }));

        lblNombre11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombre11.setText("Datos del empleado");

        lblNombre13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre13.setText("Fecha de Nacimiento");

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Fotografía");

        javax.swing.GroupLayout pnlFormularioPersonalLayout = new javax.swing.GroupLayout(pnlFormularioPersonal);
        pnlFormularioPersonal.setLayout(pnlFormularioPersonalLayout);
        pnlFormularioPersonalLayout.setHorizontalGroup(
            pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                        .addComponent(txtProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre13)
                            .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))
                    .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                        .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                                .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNombre10)
                                    .addComponent(cbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNombre6))
                                .addGap(18, 18, 18)
                                .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNombre1)
                                    .addComponent(txtApellidoCasado, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                            .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlFormularioPersonalLayout.createSequentialGroup()
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtDpi))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlFormularioPersonalLayout.createSequentialGroup()
                                    .addComponent(lblNombre2)
                                    .addGap(182, 182, 182)
                                    .addComponent(lblNombre3))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlFormularioPersonalLayout.createSequentialGroup()
                                    .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                                            .addComponent(lblNombre)
                                            .addGap(104, 104, 104))
                                        .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                                            .addComponent(txtNombre1)
                                            .addGap(18, 18, 18)))
                                    .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNombre4)
                                        .addComponent(txtNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(lblNombre11))
                        .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormularioPersonalLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(71, 71, 71))))))
        );
        pnlFormularioPersonalLayout.setVerticalGroup(
            pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblNombre11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre2)
                            .addComponent(lblNombre3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDpi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(lblNombre4)))
                    .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                    .addComponent(panelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre6)
                    .addComponent(lblNombre13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtProfesion, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnGuardar.setText("Guardar");

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnCancelar.setText("Cancelar");

        pnlFormularioContacto.setBackground(new java.awt.Color(255, 255, 255));

        lblNombre15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombre15.setText("Datos de contacto");

        lblNombre14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre14.setText("Teléfono");

        lblNombre12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre12.setText("Correo");

        lblNombre16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre16.setText("Direccion");

        lblNombre20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre20.setText("Municipio");

        txtMunicipio.setEditable(false);

        btnMunicipio.setBackground(new java.awt.Color(255, 255, 255));
        btnMunicipio.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnMunicipio.setText("Seleccionar");

        txtIdMunicipio.setEditable(false);
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
                .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtMunicipio, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre15)
                            .addGroup(pnlFormularioContactoLayout.createSequentialGroup()
                                .addComponent(lblNombre14)
                                .addGap(145, 145, 145)
                                .addComponent(lblNombre12))
                            .addComponent(lblNombre16)
                            .addGroup(pnlFormularioContactoLayout.createSequentialGroup()
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblNombre20))
                .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormularioContactoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMunicipio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(17, 17, 17))
                    .addGroup(pnlFormularioContactoLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(txtIdMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombre20)
                .addGap(1, 1, 1)
                .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblNombre22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombre22.setText("Datos de empleo");

        btnSucursal.setBackground(new java.awt.Color(255, 255, 255));
        btnSucursal.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnSucursal.setText("Seleccionar");

        lblNombre23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre23.setText("Sucursal");

        txtSucursal.setEditable(false);

        lblNombre25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre25.setText("Cargo");

        txtCargo.setEditable(false);

        btnCargo.setBackground(new java.awt.Color(255, 255, 255));
        btnCargo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnCargo.setText("Seleccionar");

        lblNombre26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre26.setText("Sueldo");

        txtIdSucursal.setEditable(false);
        txtIdSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdSucursalActionPerformed(evt);
            }
        });

        txtIdCargo.setEditable(false);
        txtIdCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCargoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblNombre23)
                                        .addGap(58, 58, 58)
                                        .addComponent(txtIdSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblNombre22))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCargo)
                                    .addComponent(txtSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblNombre25)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre26)
                            .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre22)
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombre23)
                    .addComponent(txtIdSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblNombre26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtIdCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBaseLayout = new javax.swing.GroupLayout(pnlBase);
        pnlBase.setLayout(pnlBaseLayout);
        pnlBaseLayout.setHorizontalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlFormularioPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(pnlFormularioContacto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        pnlBaseLayout.setVerticalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFormularioPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlFormularioContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 55, Short.MAX_VALUE)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(25, 25, 25))
        );

        getContentPane().add(pnlBase, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

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
    private javax.swing.JButton btnFoto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMunicipio;
    private javax.swing.JButton btnSucursal;
    private javax.swing.JComboBox<String> cbEstadoCivil;
    private javax.swing.JComboBox<String> cbGenero;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombre4;
    private javax.swing.JLabel lblNombre5;
    private javax.swing.JLabel lblNombre6;
    private javax.swing.JLabel lblNombre7;
    private javax.swing.JLabel lblNombre8;
    private javax.swing.JLabel lblNombre9;
    private JPanelWebCam.JPanelWebCam panelFoto;
    private javax.swing.JPanel pnlBase;
    private javax.swing.JPanel pnlFormularioContacto;
    private javax.swing.JPanel pnlFormularioPersonal;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtApellidoCasado;
    public static javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDpi;
    private com.toedter.calendar.JDateChooser txtFechaNacimiento;
    private javax.swing.JTextField txtId;
    public static javax.swing.JTextField txtIdCargo;
    public static javax.swing.JTextField txtIdMunicipio;
    public static javax.swing.JTextField txtIdSucursal;
    public static javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtNombre2;
    private javax.swing.JTextField txtNombre3;
    private javax.swing.JTextField txtProfesion;
    public static javax.swing.JTextField txtSucursal;
    private javax.swing.JTextField txtSueldo;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    
}
