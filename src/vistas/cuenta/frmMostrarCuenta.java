/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.cuenta;

import controladores.FAhorro;
import controladores.FCuenta;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Cuenta;
import vistas.abonoCredito.frmMostrarAbonos;
import vistas.ahorro.frmMostrarAhorro;
import vistas.cliente.frmMostrarCliente;
import vistas.credito.frmMostrarCredito;
import static vistas.frmEscritorio.dpnlEscritorio;

/**
 *
 * @author Alejandro
 */
public class frmMostrarCuenta extends javax.swing.JInternalFrame implements ActionListener {

    
    DefaultTableModel modelo;
    FAhorro funcion = new FAhorro();
    int opcion;
    
    public frmMostrarCuenta(String id) {
        initComponents();
        String e;
        mostrarDetalles(id);
        e=txtNumeroCuenta.getText();
        String query="SELECT a.Id_ahorro,b.Numero_cuenta,c.Nombre_ahorro,CONCAT(d.Primer_nombre,' ',d.Segundo_nombre,' ',d.Primer_apellido,' ',\n" +
                   "d.Segundo_apellido),d.Dpi,CONCAT(a.Nombre,' ',a.Apellido),a.Monto,a.Pago_mensual,a.Intereses,a.Plazo,a.Fecha_final FROM TBL_AHORRO AS a inner join TBL_TIPO_AHORRO AS c \n" +
                   "on a.Id_tipo_ahorro = c.Id_tipo_ahorro inner join TBL_CUENTA AS b on a.ID_CUENTA = b.Id_cuenta inner join TBL_CLIENTE AS d on\n" +
                   "b.Id_cliente = d.Id_cliente WHERE b.Numero_cuenta= '"+e+"'";
        
        String query1="SELECT a.Id_credito,a.Numero_credito,b.Numero_cuenta,a.Id_cuenta,CONCAT(c.Primer_nombre,' ',c.Segundo_nombre,' ',c.Primer_apellido,' ',c.Segundo_apellido),\n" +
                  "c.Dpi,u.descripcion,j.Nombre_garantia,m.NIckname,CONCAT(e.Primer_nombre,' ',e.Primer_apellido),a.Monto,a.Interes,a.Capital,a.Pagado,a.Capital-a.Pagado,a.Plazo,a.Mora,a.Fecha_pago,a.Fecha_corte\n" +
                   " FROM TBL_CREDITO AS a inner join TBL_CUENTA AS b on a.Id_cuenta = b.Id_cuenta inner join TBL_CLIENTE AS c on b.Id_cliente = c.Id_cliente inner join TBL_USUARIO AS m \n" +
                   "on a.Id_usuario = m.Id_usuario inner join TBL_EMPLEADO AS e on m.Id_empleado=e.Id_empleado inner join TBL_GARANTIA AS u on a.Id_garantia = u.Id_garantia\n" +
                    "inner join TBL_TIPO_GARANTIA AS j on u.Id_tipo_garantia = j.Id_tipo_garantia WHERE b.Numero_cuenta= '"+e+"'";
        btnInfo.addActionListener(this);
        mostrar(query);
        mostrar2(query1);
    }
    
 
    
    
     @Override
    public void actionPerformed(ActionEvent e) {
    
        if(btnInfo == e.getSource()){
        frmMostrarCliente frmMostrar = new frmMostrarCliente();
        dpnlEscritorio.add(frmMostrar);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmMostrar.getSize();
        frmMostrar.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmMostrar.setVisible(true);
        
        //int posicion = tblDatos.getSelectedRow();
        frmMostrarCliente.txtId.setText(txtIdCliente.getText());
        frmMostrarCliente.btnCargarDatos.doClick();
            
            
        }
    
    
    }
    
    private void mostrarDetalles(String id){
        Cuenta c = new Cuenta();
        FCuenta f = new FCuenta();
        
        c = f.mostrarDetalles(Integer.parseInt(id));
        
        //pasamos los datos a los txt
        
        txtIdCliente.setText(c.getId_cliente());
        txtNumeroCuenta.setText(c.getNumero_cuenta());
        String nombreCompleto = c.getPrimer_nombre();
        if(c.getSegundo_nombre()!=null){
            nombreCompleto = nombreCompleto +" "+c.getSegundo_nombre();
        }
        if(c.getTercer_nombre()!=null){
            nombreCompleto = nombreCompleto +" "+c.getTercer_nombre();
        }
        nombreCompleto = nombreCompleto + " "+c.getPrimer_apellido();
        if(c.getSegundo_apellido()!=null){
            nombreCompleto = nombreCompleto +" "+c.getSegundo_apellido();
        }
        if(c.getApellido_casado()!=null){
            nombreCompleto = nombreCompleto +" "+c.getApellido_casado();
        }
        txtNombre.setText(nombreCompleto);
        txtApertura.setText(c.getFecha_apertura());
        txtEstado.setText(c.getEstado());
        txtTipoSocio.setText(c.getId_tipo_socio());
        txtFecha.setText(c.getFecha_commit());
        txtHora.setText(c.getHora_commit());
        txtUsuario.setText(c.getId_usuario());
        
        
    }
    
    
    
    
     private void mostrar(String buscar){    
        try {
            modelo = funcion.mostrarAhorros(buscar);
            
            tblTelefonos.setModel(modelo);
            //txtTotal.setText("    " + Integer.toString(funcion.totalRegistros)); 
            ocultarColumnas(tblTelefonos,1);
             ocultarColumnas(tblTelefonos,9);
              ocultarColumnas(tblTelefonos,10);
             ocultarColumnas(tblTelefonos,3);
              ocultarColumnas(tblTelefonos,4); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos, motivo: "+ e);
        }
    }
    
     private void mostrar2(String buscar){    
        try {
            modelo = funcion.mostrarCreditos(buscar);
            
            tblTelefonos1.setModel(modelo);
            //txtTotal.setText("    " + Integer.toString(funcion.totalRegistros));   
            ocultarColumnas(tblTelefonos1,3);
            ocultarColumnas(tblTelefonos1,6);
            ocultarColumnas(tblTelefonos1,8);
            ocultarColumnas(tblTelefonos1,2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos, motivo: "+ e);
        }
    }
     
     private void ocultarColumnas(JTable tabla, int columna){
        tabla.getColumnModel().getColumn(columna).setMaxWidth(0);
        tabla.getColumnModel().getColumn(columna).setMinWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(columna).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(columna).setMinWidth(0);
    }
     
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBase = new javax.swing.JPanel();
        pnlFormulario = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNombre2 = new javax.swing.JLabel();
        lblNombre6 = new javax.swing.JLabel();
        lblNombre7 = new javax.swing.JLabel();
        btnInfo = new javax.swing.JButton();
        txtNumeroCuenta = new javax.swing.JTextField();
        txtTipoSocio = new javax.swing.JTextField();
        txtApertura = new javax.swing.JTextField();
        lblNombre11 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        lblNombre12 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        lblNombre3 = new javax.swing.JLabel();
        lblNombre4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTelefonos = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTelefonos1 = new javax.swing.JTable();
        lblNombre8 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        lblNombre9 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblNombre10 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        pnlBase.setBackground(new java.awt.Color(255, 255, 255));

        pnlFormulario.setBackground(new java.awt.Color(255, 255, 255));

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre.setText("Nombre del Cliente");

        txtNombre.setEditable(false);

        lblNombre2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre2.setText("Id del Cliente");

        lblNombre6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre6.setText("Número de Cuenta");

        lblNombre7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre7.setText("Tipo de Socio");

        btnInfo.setBackground(new java.awt.Color(255, 255, 255));
        btnInfo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnInfo.setText("Informacion del Cliente");

        txtNumeroCuenta.setEditable(false);
        txtNumeroCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroCuentaActionPerformed(evt);
            }
        });

        txtTipoSocio.setEditable(false);
        txtTipoSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoSocioActionPerformed(evt);
            }
        });

        txtApertura.setEditable(false);
        txtApertura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAperturaActionPerformed(evt);
            }
        });

        lblNombre11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre11.setText("Estado");

        txtEstado.setEditable(false);
        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });

        lblNombre12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre12.setText("Apertura");

        txtIdCliente.setEditable(false);
        txtIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdClienteActionPerformed(evt);
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
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtNumeroCuenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(lblNombre2))
                        .addGap(27, 27, 27)
                        .addComponent(lblNombre6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApertura, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlFormularioLayout.createSequentialGroup()
                                .addComponent(lblNombre11)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtEstado))
                        .addGap(18, 18, 18)
                        .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre7)
                            .addComponent(txtTipoSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pnlFormularioLayout.setVerticalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre2)
                    .addComponent(lblNombre6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre7)
                    .addComponent(lblNombre11)
                    .addComponent(lblNombre12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(txtApertura)
                    .addComponent(txtTipoSocio, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel1.setText("Detalles de la Cuenta");

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnCancelar.setText("Cerrar");

        lblNombre3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre3.setText("Cuentas de Ahorro");

        lblNombre4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre4.setText("Cuentas de Crédito");

        tblTelefonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "otroCampo"
            }
        ));
        tblTelefonos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTelefonosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblTelefonos);

        tblTelefonos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "otroCampo"
            }
        ));
        tblTelefonos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTelefonos1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblTelefonos1);

        lblNombre8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre8.setText("Fecha de Creación");

        txtHora.setEditable(false);
        txtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraActionPerformed(evt);
            }
        });

        txtFecha.setEditable(false);
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        lblNombre9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre9.setText("Hora de creación");

        txtUsuario.setEditable(false);
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        lblNombre10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre10.setText("Usuario");

        javax.swing.GroupLayout pnlBaseLayout = new javax.swing.GroupLayout(pnlBase);
        pnlBase.setLayout(pnlBaseLayout);
        pnlBaseLayout.setHorizontalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBaseLayout.createSequentialGroup()
                        .addComponent(pnlFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLayout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre3)
                            .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBaseLayout.createSequentialGroup()
                                    .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNombre9))
                                    .addGap(18, 18, 18)
                                    .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlBaseLayout.createSequentialGroup()
                                            .addComponent(lblNombre8)
                                            .addGap(66, 66, 66))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLayout.createSequentialGroup()
                                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)))
                                    .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNombre10)
                                        .addComponent(txtUsuario))))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre4))
                        .addGap(26, 26, 26))))
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(333, Short.MAX_VALUE))
        );
        pnlBaseLayout.setVerticalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(pnlFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre8)
                    .addComponent(lblNombre9)
                    .addComponent(lblNombre10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(61, 61, 61))
        );

        getContentPane().add(pnlBase, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumeroCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroCuentaActionPerformed

    private void txtTipoSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoSocioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoSocioActionPerformed

    private void txtHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtAperturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAperturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAperturaActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void txtIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdClienteActionPerformed

    private void tblTelefonosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTelefonosMouseClicked
        frmMostrarAhorro frmMostrar = new frmMostrarAhorro(1); //aca daba error
        dpnlEscritorio.add(frmMostrar);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmMostrar.getSize();
        frmMostrar.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmMostrar.setVisible(true);

        int posicion = tblTelefonos.getSelectedRow();
        frmMostrarAhorro.txtIdAhorroD.setText(tblTelefonos.getValueAt(posicion,0).toString());
        frmMostrarAhorro.txtIdCuenta.setText(tblTelefonos.getValueAt(posicion,1).toString());
        frmMostrarAhorro.txtDpi.setText(tblTelefonos.getValueAt(posicion,4).toString());
        frmMostrarAhorro.txtNombre.setText(tblTelefonos.getValueAt(posicion,3).toString());
        frmMostrarAhorro.txtGarantia.setText(tblTelefonos.getValueAt(posicion,5).toString());
        frmMostrarAhorro.txtInteres.setText(tblTelefonos.getValueAt(posicion,2).toString());
        frmMostrarAhorro.txtPlazo.setText(tblTelefonos.getValueAt(posicion,8).toString());
        frmMostrarAhorro.txtMontoTotal.setText(tblTelefonos.getValueAt(posicion,6).toString());
        frmMostrarAhorro.txtMontoPagado.setText(tblTelefonos.getValueAt(posicion,7).toString());
        frmMostrarAhorro.txtMontoRestante.setText(tblTelefonos.getValueAt(posicion,9).toString());
        frmMostrarAhorro.txtPago.setText(tblTelefonos.getValueAt(posicion,10).toString());
    }//GEN-LAST:event_tblTelefonosMouseClicked

    private void tblTelefonos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTelefonos1MouseClicked
         
        frmMostrarCredito frmMostrar = new frmMostrarCredito();
        dpnlEscritorio.add(frmMostrar);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmMostrar.getSize();
        frmMostrar.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmMostrar.setVisible(true);

        int posicion = tblTelefonos1.getSelectedRow();
        frmMostrarCredito.txtIdCredito.setText(tblTelefonos1.getValueAt(posicion,0).toString());
        frmMostrarCredito.txtIdCuenta.setText(tblTelefonos1.getValueAt(posicion,3).toString());
        frmMostrarCredito.txtNCredito.setText(tblTelefonos1.getValueAt(posicion,1).toString());
        frmMostrarCredito.txtNCuenta.setText(tblTelefonos1.getValueAt(posicion,2).toString());
        frmMostrarCredito.txtDpi.setText(tblTelefonos1.getValueAt(posicion,5).toString());
        frmMostrarCredito.txtNombre.setText(tblTelefonos1.getValueAt(posicion,4).toString());
        frmMostrarCredito.txtGarantia.setText(tblTelefonos1.getValueAt(posicion,6).toString());
        frmMostrarCredito.txtInteres.setText(tblTelefonos1.getValueAt(posicion,12).toString());
        frmMostrarCredito.txtCapital.setText(tblTelefonos1.getValueAt(posicion,11).toString());
        frmMostrarCredito.txtPlazo.setText(tblTelefonos1.getValueAt(posicion,15).toString());
        frmMostrarCredito.txtMora.setText(tblTelefonos1.getValueAt(posicion,16).toString());
        frmMostrarCredito.txtCorte.setText(tblTelefonos1.getValueAt(posicion,18).toString());
        frmMostrarCredito.txtPago.setText(tblTelefonos1.getValueAt(posicion,17).toString());
        frmMostrarCredito.txtMontoTotal.setText(tblTelefonos1.getValueAt(posicion,10).toString());
        frmMostrarCredito.txtMontoPagado.setText(tblTelefonos1.getValueAt(posicion,13).toString());
        frmMostrarCredito.txtMontoRestante.setText(tblTelefonos1.getValueAt(posicion,14).toString());
        
        
        
    }//GEN-LAST:event_tblTelefonos1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre10;
    private javax.swing.JLabel lblNombre11;
    private javax.swing.JLabel lblNombre12;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombre4;
    private javax.swing.JLabel lblNombre6;
    private javax.swing.JLabel lblNombre7;
    private javax.swing.JLabel lblNombre8;
    private javax.swing.JLabel lblNombre9;
    private javax.swing.JPanel pnlBase;
    private javax.swing.JPanel pnlFormulario;
    public static javax.swing.JTable tblTelefonos;
    public static javax.swing.JTable tblTelefonos1;
    private javax.swing.JTextField txtApertura;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    public static javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroCuenta;
    private javax.swing.JTextField txtTipoSocio;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
