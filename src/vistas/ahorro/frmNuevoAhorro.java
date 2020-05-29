/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.ahorro;

import controladores.FAhorro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Ahorro;
import static org.apache.xalan.lib.ExsltDatetime.date;
import vistas.credito.*;
import vistas.empleado.frmMostrarEmpleado;
import vistas.frmLogin;
import vistas.frmSeleccionar;
import static vistas.usuario.frmNuevoUsuario.txtId1;

/**
 *
 * @author Alejandro
 */
public class frmNuevoAhorro extends javax.swing.JInternalFrame implements ActionListener{

    FAhorro funcion = new FAhorro();
    String accion = "guardar";
    int id_usuario = frmLogin.idUsuarioSystem;
    String n;
    String m;
   
    public frmNuevoAhorro() {
        initComponents();
        
        txtIdcliente.setVisible(false);
        txtIdahorro.setVisible(false);
        txtfechaa.setVisible(false);
        txtPlazo.setVisible(false);
        txtisr.setVisible(false);
        
        llenarComboBoxAhorro();
        btnGuardar.addActionListener(this);
        btnCancelar.addActionListener(this);
        btnSeleccionarCuenta.addActionListener(this);
        btnInteres.addActionListener(this);
        
        
        //Combobox
        lblPlazo.setVisible(true);
        txtPago.setVisible(true);
        quemarFecha();
        txtFinal.setVisible(true);
        lblFecha.setVisible(true);
        
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
         if (e.getSource() == btnGuardar){
           
            guardarAhorro();
        }
        
        if (e.getSource()==btnSeleccionarCuenta){
            
             frmSeleccionar f = new frmSeleccionar(13,"QUEMADO"); //el numero es para que se haga universal, pero creo que solo usaremos esa ventana
            //el dato quemado es solamente para que no busque ningun departamento, solo se ocupa en la opcion dos
            f.setVisible(true);
        }
    
        if (e.getSource()==btnCancelar){
           cancelar();    
        
        }
        
        if (e.getSource()==btnInteres){
        mensaje();      
        
        }
    
    }
    
    public void llenarComboBoxAhorro(){
        funcion.consultarAhorro(cbAhorro);
    }
    
    public void mensaje(){
    
         JOptionPane.showMessageDialog(null, "TIPOS DE INTERESES" 
         + "\n 100 a 25000 el 1%"
         + "\n 25000 a 100000 el 1.5%"
         + "\n 100000 a 15000000 2%");
    
    }
    
     public void guardarAhorro(){
       
       if(txtIdCuenta.getText().length()==0 || txtDpi.getText().length()==0 || txtNombre.getText().length()==0 ||
          cbAhorro.getSelectedItem().toString()=="" || txtPlazo.getText().length()==0 || txtDestino.getText().length()==0 ||
          txtprogramado.getText().length()==0 || txtisr.getText().length()==0  || txtGarantia.getText().length()==0 ||
          txtDescripcion.getText().length()==0 || txtValoracion.getText().length()==0 ||  txtValoracion1.getText().length()==0  ||
          jComboBox2.getSelectedItem().toString()==""){

           JOptionPane.showMessageDialog(null,"Hace falta rellenar campos obligatorios");
       
       }else{
       
        try{
        
        Ahorro ahorro = new Ahorro();
        ahorro.setId_tipo_ahorro(Integer.parseInt(txtIdahorro.getText()));
        ahorro.setId_usuario(id_usuario);
        ahorro.setId_cuenta(Integer.parseInt(txtIdcliente.getText()));
        ahorro.setIntereses(Float.parseFloat(txtPlazo.getText()));
        ahorro.setMonto(Float.parseFloat(txtDestino.getText()));
        ahorro.setPlazo(txtPago.getText());
        
        
        java.util.Date utilStartDate = txtFinal.getDate();
        java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
        
        String n = sqlStartDate.toString();
        txtfechaa.setText(n);
        
        ahorro.setFecha(txtfechaa.getText());
        ahorro.setPago_mensual(Float.parseFloat(txtprogramado.getText()));
        ahorro.setIsr(Float.parseFloat(txtisr.getText()));
        ahorro.setNombres(txtGarantia.getText());
        ahorro.setApellidos(txtDescripcion.getText());
        ahorro.setDpi(txtValoracion.getText());
        ahorro.setTelefono(txtValoracion1.getText());
        ahorro.setParentesco(jComboBox2.getSelectedItem().toString());
        
        funcion.guardarAhorro(ahorro);
        limpiar();
        JOptionPane.showMessageDialog(null,"Datos Guardados Correctamente");  
        frmIndexAhorro.btnActualizar.doClick();
        
          
        
        
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null,"Error:"+e.getMessage()+"\nVerifique");
            
        }
       
       
       }
       
     }
     
     public void limpiar(){
     
     txtIdahorro.setText("");
     txtIdcliente.setText("");
     txtPlazo.setText("");
     txtDestino.setText("");
     txtPago.setText("");
     txtFinal.setCalendar(null); 
     txtprogramado.setText("");
     txtisr.setText("");
     txtGarantia.setText("");
     txtDescripcion.setText("");
     txtValoracion.setText("");
     txtValoracion1.setText("");
     txtIdCuenta.setText("");
     txtDpi.setText("");
     txtNombre.setText("");
     
     
     }
    
    public void cancelar(){
        
        this.dispose();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBase = new javax.swing.JPanel();
        pnlFormulario = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblPlazo = new javax.swing.JLabel();
        txtIdCuenta = new javax.swing.JTextField();
        lblNombre2 = new javax.swing.JLabel();
        lblNombre6 = new javax.swing.JLabel();
        lblNombre7 = new javax.swing.JLabel();
        lblNombre8 = new javax.swing.JLabel();
        txtDpi = new javax.swing.JTextField();
        lblNombre3 = new javax.swing.JLabel();
        btnSeleccionarCuenta = new javax.swing.JButton();
        txtPago = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        lblNombre10 = new javax.swing.JLabel();
        lblNombre11 = new javax.swing.JLabel();
        txtGarantia = new javax.swing.JTextField();
        txtDestino = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtValoracion = new javax.swing.JTextField();
        lblNombre12 = new javax.swing.JLabel();
        lblNombre13 = new javax.swing.JLabel();
        cbAhorro = new javax.swing.JComboBox<>();
        lblNombre14 = new javax.swing.JLabel();
        lblNombre15 = new javax.swing.JLabel();
        lblNombre16 = new javax.swing.JLabel();
        txtValoracion1 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        lblNombre17 = new javax.swing.JLabel();
        txtFinal = new com.toedter.calendar.JDateChooser();
        btnInteres = new javax.swing.JButton();
        txtprogramado = new javax.swing.JTextField();
        lblProgramado = new javax.swing.JLabel();
        cbInteres = new javax.swing.JComboBox<>();
        cbIsr = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtIdcliente = new javax.swing.JTextField();
        txtIdahorro = new javax.swing.JTextField();
        txtfechaa = new javax.swing.JTextField();
        txtPlazo = new javax.swing.JTextField();
        txtisr = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);

        pnlBase.setBackground(new java.awt.Color(255, 255, 255));

        pnlFormulario.setBackground(new java.awt.Color(255, 255, 255));

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre.setText("Cliente");

        txtNombre.setEnabled(false);

        lblPlazo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPlazo.setText("Plazo");

        txtIdCuenta.setEditable(false);
        txtIdCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCuentaActionPerformed(evt);
            }
        });

        lblNombre2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre2.setText("Numero de cuenta");

        lblNombre6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombre6.setText("Datos de  cuenta de ahorro");

        lblNombre7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre7.setText("Tasa de Interés:");

        lblNombre8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre8.setText("Tipo de cuenta de ahorro");

        txtDpi.setEditable(false);
        txtDpi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDpiActionPerformed(evt);
            }
        });

        lblNombre3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre3.setText("DPI ");

        btnSeleccionarCuenta.setBackground(new java.awt.Color(255, 255, 255));
        btnSeleccionarCuenta.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnSeleccionarCuenta.setText("Seleccionar");

        lblFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFecha.setText("Fecha Retiro");

        lblNombre10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre10.setText("Monto Ahorrar");

        lblNombre11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre11.setText("Nombres");

        lblNombre12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre12.setText("Apellidos");

        lblNombre13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre13.setText("Telefono");

        cbAhorro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAhorroItemStateChanged(evt);
            }
        });
        cbAhorro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAhorroActionPerformed(evt);
            }
        });

        lblNombre14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombre14.setText("Dabos del benficiario");

        lblNombre15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre15.setText("Dpi");

        lblNombre16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre16.setText("Parentesco");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Padre", "Madre", "Hermano", "Tio", "Abuelo", "Primo", "Otro" }));

        lblNombre17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre17.setText("ISR");

        btnInteres.setText("...");

        txtprogramado.setText("0");

        lblProgramado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblProgramado.setText("Monto Programado");

        cbInteres.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2%", "1.5%", "1%" }));
        cbInteres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbInteresActionPerformed(evt);
            }
        });

        cbIsr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pago de ISR", "1.45%" }));
        cbIsr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIsrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFormularioLayout = new javax.swing.GroupLayout(pnlFormulario);
        pnlFormulario.setLayout(pnlFormularioLayout);
        pnlFormularioLayout.setHorizontalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre)
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre3)
                            .addGroup(pnlFormularioLayout.createSequentialGroup()
                                .addComponent(txtDpi, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSeleccionarCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbAhorro, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlFormularioLayout.createSequentialGroup()
                                .addComponent(lblPlazo)
                                .addGap(239, 239, 239)
                                .addComponent(lblFecha)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFormularioLayout.createSequentialGroup()
                                .addComponent(lblNombre7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlFormularioLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(cbInteres, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnInteres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre11)
                            .addComponent(txtGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre15))
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFormularioLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                                        .addComponent(lblNombre12)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtDescripcion)))
                            .addGroup(pnlFormularioLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(lblNombre16)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(lblNombre6)
                            .addComponent(lblNombre8)
                            .addGroup(pnlFormularioLayout.createSequentialGroup()
                                .addComponent(lblNombre10)
                                .addGap(182, 182, 182)
                                .addComponent(lblNombre17))
                            .addComponent(lblNombre14)
                            .addGroup(pnlFormularioLayout.createSequentialGroup()
                                .addComponent(txtValoracion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre13)
                                    .addComponent(txtValoracion1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(12, 12, 12)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addComponent(lblProgramado)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormularioLayout.createSequentialGroup()
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtprogramado, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFormularioLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbIsr, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(txtIdCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDpi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNombre6)
                .addGap(18, 18, 18)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre8)
                    .addComponent(lblNombre7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbInteres)
                    .addComponent(btnInteres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbAhorro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha)
                    .addComponent(lblPlazo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre17)
                    .addComponent(lblNombre10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbIsr, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(lblProgramado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtprogramado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNombre14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre11)
                    .addComponent(lblNombre12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre13)
                    .addComponent(lblNombre16)
                    .addComponent(lblNombre15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtValoracion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtValoracion1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel1.setText("Nueva cuenta de ahorro");

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
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBaseLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlBaseLayout.createSequentialGroup()
                        .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBaseLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1))
                            .addGroup(pnlBaseLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(txtIdcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdahorro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtfechaa, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(txtPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtisr, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(159, 159, 159))
        );
        pnlBaseLayout.setVerticalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdahorro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfechaa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtisr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(26, 26, 26))
        );

        getContentPane().add(pnlBase, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbIsrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIsrActionPerformed
        // TODO add your handling code here:
        m = (String) cbIsr.getSelectedItem();

        if(m=="Pago de ISR"){

            JOptionPane.showMessageDialog(null,"Seleccion el interes de ISR");

        }
        else if(m=="1.45%"){

            String cad = "0.000145";
            txtisr.setText(cad);
        }
    }//GEN-LAST:event_cbIsrActionPerformed

    private void cbInteresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbInteresActionPerformed
        // TODO add your handling code here:
        n =(String) cbInteres.getSelectedItem();
        if(n=="1%"){

            String cadena = "0.00010";
            //JOptionPane.showMessageDialog(null,u);
            txtPlazo.setText(cadena);
        }else if(n=="1.5%"){

            String cadena1 = "0.00015";
            txtPlazo.setText(cadena1);
        }else if(n=="2%"){

            String cadena2 = "0.0002";
            txtPlazo.setText(cadena2);
        }
    }//GEN-LAST:event_cbInteresActionPerformed

    private void cbAhorroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAhorroActionPerformed
        // TODO add your handling code here:
        String seleccionado = cbAhorro.getSelectedItem().toString();
        funcion.consultarIdahorro(txtIdahorro, seleccionado);

    }//GEN-LAST:event_cbAhorroActionPerformed

    private void cbAhorroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAhorroItemStateChanged

        if(cbAhorro.getSelectedIndex()==0){

            //Plazo fijo

            lblPlazo.setVisible(true);
            txtPago.setVisible(true);
            lblFecha.setVisible(true);
            quemarFecha();
            txtFinal.setVisible(true);

            txtprogramado.setText("0");
            txtprogramado.setVisible(true);
            lblProgramado.setVisible(true);

        }

        if(cbAhorro.getSelectedIndex()==1){

            //Corriente

            lblPlazo.setVisible(false);
            txtPago.setVisible(false);
            lblFecha.setVisible(false);
            quemarFecha();
            txtFinal.setVisible(false);

            txtprogramado.setText("0");
            txtprogramado.setVisible(false);
            lblProgramado.setVisible(false);

        }
        if(cbAhorro.getSelectedIndex()==2){
            //Ahorro Programado

            lblPlazo.setVisible(true);
            txtPago.setVisible(true);
            lblFecha.setVisible(true);
            quemarFecha();
            txtFinal.setVisible(true);

            txtprogramado.setText("0");
            txtprogramado.setVisible(true);
            lblProgramado.setVisible(true);

        }

    }//GEN-LAST:event_cbAhorroItemStateChanged

    private void txtDpiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDpiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDpiActionPerformed

    private void txtIdCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCuentaActionPerformed

    private void quemarFecha(){
         String fechaNacimiento = "2020-01-01"; //fecha quemada NUNCA USAR PLEASE
         SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fechaNacimiento);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
          txtFinal.setDate(fechaDate);
        
    }
    
    
    
 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnInteres;
    private javax.swing.JButton btnSeleccionarCuenta;
    private javax.swing.JComboBox<String> cbAhorro;
    private javax.swing.JComboBox<String> cbInteres;
    private javax.swing.JComboBox<String> cbIsr;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre10;
    private javax.swing.JLabel lblNombre11;
    private javax.swing.JLabel lblNombre12;
    private javax.swing.JLabel lblNombre13;
    private javax.swing.JLabel lblNombre14;
    private javax.swing.JLabel lblNombre15;
    private javax.swing.JLabel lblNombre16;
    private javax.swing.JLabel lblNombre17;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombre6;
    private javax.swing.JLabel lblNombre7;
    private javax.swing.JLabel lblNombre8;
    private javax.swing.JLabel lblPlazo;
    private javax.swing.JLabel lblProgramado;
    private javax.swing.JPanel pnlBase;
    private javax.swing.JPanel pnlFormulario;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDestino;
    public static javax.swing.JTextField txtDpi;
    private com.toedter.calendar.JDateChooser txtFinal;
    private javax.swing.JTextField txtGarantia;
    public static javax.swing.JTextField txtIdCuenta;
    public static javax.swing.JTextField txtIdahorro;
    public static javax.swing.JTextField txtIdcliente;
    public static javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPago;
    private javax.swing.JTextField txtPlazo;
    private javax.swing.JTextField txtValoracion;
    private javax.swing.JTextField txtValoracion1;
    private javax.swing.JTextField txtfechaa;
    private javax.swing.JTextField txtisr;
    private javax.swing.JTextField txtprogramado;
    // End of variables declaration//GEN-END:variables
}
