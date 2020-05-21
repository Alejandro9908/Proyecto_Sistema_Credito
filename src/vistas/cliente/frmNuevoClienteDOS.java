/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.cliente;

import controladores.FCliente;
import vistas.empleado.*;
import controladores.FEmpleado;
import controladores.FSucursal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Departamento;
import modelo.Empleado;
import modelo.Municipio;
import modelo.Operador;
import modelo.Telefono;
import vistas.frmLogin;
import vistas.frmSeleccionar;
import static vistas.sucursal.frmNuevoSucursal.cbDepartamentos;
import static vistas.sucursal.frmNuevoSucursal.cbMunicipio;

/**
 *
 * @author Alejandro
 */
public class frmNuevoClienteDOS extends javax.swing.JInternalFrame implements ActionListener{

    
    FCliente funcion = new FCliente();
    FSucursal llenarDepartamentoMunicipio = new FSucursal();
    int n;
    int id= frmLogin.idUsuarioSystem;
    int departamentoSelected;
     int municipioSelected;
     DefaultTableModel modeloTel;
    
    
    /**
     * Creates new form frmNuevoEmpleado
     */
    public frmNuevoClienteDOS() {
        initComponents();
        txtIdClienteNuevo.setVisible(false);
        btnIdCliente.setVisible(false);
        JScrollPane jsp = new JScrollPane();
        jsp.setViewportView(pnlBase);
        add(jsp);
        modeloTel = (DefaultTableModel)tblTelefonos.getModel();
        
        llenarCbOperador();
        
        cbDepartamentoC.removeAllItems();
        
        llenarDepartamentoMunicipio.consultarDepartamento(cbDepartamentoC);
        cbDepartamentoC.setSelectedItem(0);
        departamentoSelected = cbDepartamentoC.getItemAt(cbDepartamentoC.getSelectedIndex()).getId_departamento();    
        llenarDepartamentoMunicipio.consultarMunicipio(cbMunicipioC, String.valueOf(departamentoSelected));
        municipioSelected = cbMunicipioC.getItemAt(cbMunicipioC.getSelectedIndex()).getId_municipio(); 
   
        
        
         cbDepartamentoC.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0){
              
              
 
      //Aqui veremos que hacer cuando se cambie de departamento
      departamentoSelected = cbDepartamentoC.getItemAt(cbDepartamentoC.getSelectedIndex()).getId_departamento(); 
     //
      
      cbMunicipioC.removeAllItems();
      
      llenarDepartamentoMunicipio.consultarMunicipio(cbMunicipioC, String.valueOf(departamentoSelected));
      municipioSelected = cbMunicipioC.getItemAt(cbMunicipioC.getSelectedIndex()).getId_municipio(); 
                           
               }});
         
         //DE MUNICIPIOS
          cbMunicipioC.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent itemEvent) {
            
        
         
        }
        });
        
        
        
        
     
        
        btnGuardar.addActionListener(this);
        
     
        //btnFoto.addActionListener(this);
        btnCancelar.addActionListener(this);
        btnAddTelefono.addActionListener(this);
        btnQuitarTelefono.addActionListener(this);
        btnIdCliente.addActionListener(this);
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == btnGuardar){
            guardarCliente();
            
        }
        
        if(e.getSource() == btnIdCliente){
            consultarIdCliente();
            
        }
        
       
        
     
       
        
        if(e.getSource()==btnCancelar){
            cancelar();
            // System.out.println("Municipio ID: "+ cbMunicipioC.getItemAt(cbMunicipioC.getSelectedIndex()).getId_municipio());
            
        }
        
        if(e.getSource() == btnAddTelefono){
              String registro[] = new String[3];
            registro[0] = txtTelefono.getText();
            registro[1] = String.valueOf(cbOperador.getItemAt(cbOperador.getSelectedIndex()).getId_operador());
            registro[2] = cbOperador.getItemAt(cbOperador.getSelectedIndex()).getNombre_operador();
            modeloTel.addRow(registro);
            txtTelefono.setText("");
             
        }
        
        if (e.getSource() == btnQuitarTelefono){
            if (tblTelefonos.getSelectedRow()>=0){
                int selectedRow = tblTelefonos.getSelectedRow();
                modeloTel.removeRow(selectedRow);
            
            }else{
             JOptionPane.showMessageDialog(null,"No hay ninguna fila seleccionada");
       
            }
            
        }
        
        
    }
    
    public void llenarCbOperador(){
        funcion.consultarOperador(cbOperador);
    }
    
    private void consultarIdCliente(){
            
         String Dpi = txtDpi.getText(); 
       funcion.consultarIdCliente(txtIdClienteNuevo, Dpi);
           
    }
    
    
    private void guardarTel(){
        consultarIdCliente();
        Telefono telefono = new Telefono();
        //Guardamos los telefonos del cliente
            if(tblTelefonos.getRowCount() > 0){
                for(int i = 0; i <tblTelefonos.getRowCount(); i++){
     
                    telefono.setTelefono((String) tblTelefonos.getValueAt(i, 0));
                    telefono.setId_cliente(Integer.parseInt(txtIdClienteNuevo.getText()));
                    telefono.setId_operador(Integer.parseInt((String) tblTelefonos.getValueAt(i, 1)));
                    telefono.setId_usuario(id);   
                    funcion.agregarTelefonos(telefono);
                }
            }else{
                System.out.println("no hay");
            }
    }
    
    
    
    private void guardarCliente(){
        
        if(txtDpi.getText().length()==0 || txtNombre1.getText().length()==0 || txtApellido1.getText().length()==0 || panelFoto.getBytes().length==1 ||
           txtProfesion.getText().length()==0  || txtDescripcion.getText().length()==0 || txtReferencia.getText().length()==0 || txtCorreo.getText().length()==0 ||
           txtDpiReferencia.getText().length()==0 || txtNombresReferencia.getText().length()==0 || txtApellidosReferencia.getText().length()==0 || txtTelefonoReferencia.getText().length()==0 
           || txtFechaNacimiento.getCalendar()==null){
        
           JOptionPane.showMessageDialog(null,"Hace falta rellenar campos obligatorios"); 
        
        }else{
        try{

            Cliente cliente = new  Cliente();
            //empleado.setId_sucursal(Integer.parseInt(txtIdSucursal.getText()));
            cliente.setDpi(txtDpi.getText());
            cliente.setPrimer_nombre(txtNombre1.getText());
            cliente.setSegundo_nombre(txtNombre2.getText());
            cliente.setTercer_nombre(txtNombre3.getText());
            cliente.setPrimer_apellido(txtApellido1.getText());
            cliente.setSegundo_apellido(txtApellido2.getText());
            cliente.setApellido_casado(txtApellidoCasado.getText());
        
           
            cliente.setEstado_civil(cbEstadoCivil.getSelectedItem().toString());
            cliente.setFoto(panelFoto.getBytes());
            
            int idMunicipio = cbMunicipioC.getItemAt(cbMunicipioC.getSelectedIndex()).getId_municipio();
            
           cliente.setId_municipio(idMunicipio);
          
           
           cliente.setDescripcion_direccion(txtDescripcion.getText());
           cliente.setReferencia_direccion(txtReferencia.getText());
           cliente.setTipo_casa(cbTipoCasa.getSelectedItem().toString());
           
           
           
           // empleado.setTelefono(txtTelefono.getText()); NO PUEDO GUARDAR TELEFONOS DEBIDO A QUE SE GUARDARAN EN OTRA TABLA (Y)
           

            cliente.setCorreo(txtCorreo.getText());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            
            
            java.util.Date utilStartDate = txtFechaNacimiento.getDate();
            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
            
            cliente.setFecha_nacimiento(sqlStartDate);
      
           cliente.setGenero(cbGenero.getSelectedItem().toString());
           cliente.setProfesion(txtProfesion.getText());
           cliente.setId_usuario(id);
           cliente.setDireccion(txtDireccion.getText());
           
           
           
           //AHORA VAN LOS DATOS DE REFERENCIA
           
           cliente.setDpi_referencia(txtDpiReferencia.getText());
           cliente.setNombres_referencia(txtNombresReferencia.getText());
           cliente.setApellidos_referencia(txtApellidosReferencia.getText());
           cliente.setTelefono_referencia(txtTelefonoReferencia.getText());
           cliente.setTipo_referencia(cbTipo.getSelectedItem().toString());
           
           
           
        
                    
            
            funcion.guardarCliente(cliente);
            
            btnIdCliente.doClick();
            
            consultarIdCliente(); //esto es para llenar el id del nuevo cliente que hemos guardado
            guardarTel();
            
            
           
            limpiarDatos();
            
           // limpiartxt();
            JOptionPane.showMessageDialog(null,"Datos Guardados Correctamente");
             
            
            frmIndexCliente.btnActualizar.doClick();
           // JOptionPane.showMessageDialog(null,"Es necesario asignar a cursos");
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null,"Error:"+e.getMessage()+"\nVerifique");
        }
        }
    }
    
    
    public void limpiarDatos(){
    
     /*modeloTel=(DefaultTableModel) tblTelefonos.getModel();  
     int filas=tblTelefonos.getRowCount();
     
     for(int i = 0;i<=filas; i++){
     
     modeloTel.removeRow(0);
     
     }*/
        
        
    txtDpi.setText("");
    txtNombre1.setText("");
    txtNombre2.setText("");
    txtNombre3.setText("");
    txtApellido1.setText("");
    txtApellido2.setText("");
    txtApellidoCasado.setText("");
    txtReferencia.setText("");
    txtCorreo.setText("");
    txtProfesion.setText("");
    txtNombresReferencia.setText("");
    txtDireccion.setText("");
    panelFoto.setImagenNull();
    txtDpiReferencia.setText("");
    txtDescripcion.setText("");
    txtFechaNacimiento.setCalendar(null); 
    txtApellidosReferencia.setText("");
    txtTelefonoReferencia.setText("");
   
    
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
        lblTitulo = new javax.swing.JLabel();
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
        jPanel1 = new javax.swing.JPanel();
        lblNombre9 = new javax.swing.JLabel();
        txtApellidoCasado = new javax.swing.JTextField();
        lblNombre10 = new javax.swing.JLabel();
        cbEstadoCivil = new javax.swing.JComboBox<>();
        lblNombre11 = new javax.swing.JLabel();
        txtProfesion = new javax.swing.JTextField();
        lblNombre13 = new javax.swing.JLabel();
        panelFoto = new JPanelWebCam.JPanelWebCam();
        txtFechaNacimiento = new com.toedter.calendar.JDateChooser();
        lblNombre29 = new javax.swing.JLabel();
        btnIdCliente = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlFormularioContacto = new javax.swing.JPanel();
        lblNombre15 = new javax.swing.JLabel();
        lblNombre16 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblNombre17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        lblNombre18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtReferencia = new javax.swing.JTextArea();
        lblNombre19 = new javax.swing.JLabel();
        lblNombre20 = new javax.swing.JLabel();
        cbDepartamentoC = new javax.swing.JComboBox<>();
        cbMunicipioC = new javax.swing.JComboBox<>();
        lblNombre21 = new javax.swing.JLabel();
        cbTipoCasa = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        lblNombre22 = new javax.swing.JLabel();
        lblNombre14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTelefonos = new javax.swing.JTable();
        btnAddTelefono = new javax.swing.JButton();
        btnQuitarTelefono = new javax.swing.JButton();
        txtCorreo = new javax.swing.JTextField();
        lblNombre12 = new javax.swing.JLabel();
        lblNombre23 = new javax.swing.JLabel();
        lblNombre24 = new javax.swing.JLabel();
        txtDpiReferencia = new javax.swing.JTextField();
        lblNombre25 = new javax.swing.JLabel();
        txtNombresReferencia = new javax.swing.JTextField();
        txtApellidosReferencia = new javax.swing.JTextField();
        lblNombre26 = new javax.swing.JLabel();
        lblNombre27 = new javax.swing.JLabel();
        txtTelefonoReferencia = new javax.swing.JTextField();
        lblNombre28 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        txtTelefono = new javax.swing.JTextField();
        cbOperador = new javax.swing.JComboBox<>();
        txtIdClienteNuevo = new javax.swing.JTextField();

        setClosable(true);
        setResizable(true);
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(200, 40));
        setPreferredSize(new java.awt.Dimension(670, 700));

        pnlBase.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        lblTitulo.setText("Nuevo Cliente");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        lblNombre9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre9.setText("Apellido de Casado");

        lblNombre10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre10.setText("Estado Civil");

        cbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casado", "Soltero", "Divorciado", "Viudo", "Unido" }));

        lblNombre11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombre11.setText("Datos del empleado");

        lblNombre13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre13.setText("Fecha de Nacimiento");

        panelFoto.setBackground(new java.awt.Color(255, 255, 255));
        panelFoto.setToolTipText("");

        javax.swing.GroupLayout panelFotoLayout = new javax.swing.GroupLayout(panelFoto);
        panelFoto.setLayout(panelFotoLayout);
        panelFotoLayout.setHorizontalGroup(
            panelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelFotoLayout.setVerticalGroup(
            panelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 153, Short.MAX_VALUE)
        );

        lblNombre29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre29.setText("Foto");

        btnIdCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnIdCliente.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnIdCliente.setText("Guardar");

        javax.swing.GroupLayout pnlFormularioPersonalLayout = new javax.swing.GroupLayout(pnlFormularioPersonal);
        pnlFormularioPersonal.setLayout(pnlFormularioPersonalLayout);
        pnlFormularioPersonalLayout.setHorizontalGroup(
            pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                        .addComponent(txtNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                                .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(12, 12, 12))
                            .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                                .addComponent(lblNombre29)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                        .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                                .addComponent(txtProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre13)
                                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                                .addComponent(lblNombre11)
                                .addGap(131, 131, 131)
                                .addComponent(btnIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlFormularioPersonalLayout.setVerticalGroup(
            pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormularioPersonalLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblNombre11))
                    .addComponent(btnIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(lblNombre4)
                    .addComponent(lblNombre29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        lblNombre15.setText("Dirección");

        lblNombre16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre16.setText("Direccion");

        lblNombre17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre17.setText("Descripcion");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        lblNombre18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre18.setText("Referencia");

        txtReferencia.setColumns(20);
        txtReferencia.setRows(5);
        jScrollPane2.setViewportView(txtReferencia);

        lblNombre19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre19.setText("Departamento");

        lblNombre20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre20.setText("Municipio");

        lblNombre21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre21.setText("Tipo de Casa");

        cbTipoCasa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Propia", "Rentada", "Vive con un familiar" }));

        javax.swing.GroupLayout pnlFormularioContactoLayout = new javax.swing.GroupLayout(pnlFormularioContacto);
        pnlFormularioContacto.setLayout(pnlFormularioContactoLayout);
        pnlFormularioContactoLayout.setHorizontalGroup(
            pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioContactoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre15)
                    .addGroup(pnlFormularioContactoLayout.createSequentialGroup()
                        .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFormularioContactoLayout.createSequentialGroup()
                                .addComponent(lblNombre17)
                                .addGap(217, 217, 217))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormularioContactoLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre18)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlFormularioContactoLayout.createSequentialGroup()
                        .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre19)
                            .addComponent(cbDepartamentoC, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre20)
                            .addComponent(cbMunicipioC, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlFormularioContactoLayout.createSequentialGroup()
                        .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre21)
                            .addComponent(cbTipoCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        pnlFormularioContactoLayout.setVerticalGroup(
            pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioContactoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre19)
                    .addComponent(lblNombre20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDepartamentoC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMunicipioC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre16)
                    .addComponent(lblNombre21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTipoCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre17)
                    .addComponent(lblNombre18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(pnlFormularioContactoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblNombre22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombre22.setText("Contacto");

        lblNombre14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre14.setText("No. Telefono");

        tblTelefonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Id_operador", "Operador"
            }
        ));
        jScrollPane3.setViewportView(tblTelefonos);

        btnAddTelefono.setBackground(new java.awt.Color(255, 255, 255));
        btnAddTelefono.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnAddTelefono.setText("Agregar");

        btnQuitarTelefono.setBackground(new java.awt.Color(255, 255, 255));
        btnQuitarTelefono.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnQuitarTelefono.setText("Quitar");

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        lblNombre12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre12.setText("Correo");

        lblNombre23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombre23.setText("Persona de Referencia");

        lblNombre24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre24.setText("DPI");

        txtDpiReferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDpiReferenciaActionPerformed(evt);
            }
        });

        lblNombre25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre25.setText("Nombres");

        lblNombre26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre26.setText("Apellidos");

        lblNombre27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre27.setText("Teléfono");

        lblNombre28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre28.setText("Tipo de referencia");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Conyugue", "Referencia" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAddTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnQuitarTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(39, 39, 39))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTelefonoReferencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                                .addComponent(txtNombresReferencia, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDpiReferencia, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(lblNombre27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblNombre28)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtApellidosReferencia)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre23)
                            .addComponent(lblNombre24)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblNombre25)
                                .addGap(219, 219, 219)
                                .addComponent(lblNombre26))
                            .addComponent(lblNombre12)
                            .addComponent(lblNombre14)
                            .addComponent(lblNombre22))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuitarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblNombre23)
                        .addGap(18, 18, 18)
                        .addComponent(lblNombre24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDpiReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre25)
                            .addComponent(lblNombre26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombresReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidosReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombre27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefonoReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblNombre28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        txtIdClienteNuevo.setEditable(false);
        txtIdClienteNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdClienteNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBaseLayout = new javax.swing.GroupLayout(pnlBase);
        pnlBase.setLayout(pnlBaseLayout);
        pnlBaseLayout.setHorizontalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFormularioContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFormularioPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBaseLayout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(61, 61, 61)
                        .addComponent(txtIdClienteNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlBaseLayout.setVerticalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(txtIdClienteNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFormularioPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlFormularioContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        getContentPane().add(pnlBase, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtDpiReferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDpiReferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDpiReferenciaActionPerformed

    private void txtIdClienteNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdClienteNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdClienteNuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTelefono;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIdCliente;
    private javax.swing.JButton btnQuitarTelefono;
    public static javax.swing.JComboBox<Departamento> cbDepartamentoC;
    private javax.swing.JComboBox<String> cbEstadoCivil;
    private javax.swing.JComboBox<String> cbGenero;
    public static javax.swing.JComboBox<Municipio> cbMunicipioC;
    public static javax.swing.JComboBox<Operador> cbOperador;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JComboBox<String> cbTipoCasa;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre10;
    private javax.swing.JLabel lblNombre11;
    private javax.swing.JLabel lblNombre12;
    private javax.swing.JLabel lblNombre13;
    private javax.swing.JLabel lblNombre14;
    private javax.swing.JLabel lblNombre15;
    private javax.swing.JLabel lblNombre16;
    private javax.swing.JLabel lblNombre17;
    private javax.swing.JLabel lblNombre18;
    private javax.swing.JLabel lblNombre19;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre20;
    private javax.swing.JLabel lblNombre21;
    private javax.swing.JLabel lblNombre22;
    private javax.swing.JLabel lblNombre23;
    private javax.swing.JLabel lblNombre24;
    private javax.swing.JLabel lblNombre25;
    private javax.swing.JLabel lblNombre26;
    private javax.swing.JLabel lblNombre27;
    private javax.swing.JLabel lblNombre28;
    private javax.swing.JLabel lblNombre29;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombre4;
    private javax.swing.JLabel lblNombre5;
    private javax.swing.JLabel lblNombre6;
    private javax.swing.JLabel lblNombre7;
    private javax.swing.JLabel lblNombre8;
    private javax.swing.JLabel lblNombre9;
    private javax.swing.JLabel lblTitulo;
    private JPanelWebCam.JPanelWebCam panelFoto;
    private javax.swing.JPanel pnlBase;
    private javax.swing.JPanel pnlFormularioContacto;
    private javax.swing.JPanel pnlFormularioPersonal;
    public static javax.swing.JTable tblTelefonos;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtApellidoCasado;
    private javax.swing.JTextField txtApellidosReferencia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDpi;
    private javax.swing.JTextField txtDpiReferencia;
    private com.toedter.calendar.JDateChooser txtFechaNacimiento;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdClienteNuevo;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtNombre2;
    private javax.swing.JTextField txtNombre3;
    private javax.swing.JTextField txtNombresReferencia;
    private javax.swing.JTextField txtProfesion;
    private javax.swing.JTextArea txtReferencia;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoReferencia;
    // End of variables declaration//GEN-END:variables

    
}
