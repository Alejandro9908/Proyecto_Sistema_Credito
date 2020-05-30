/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import sisserviciofinanciero.*;
import vistas.departametoEmpresa.frmIndexDepatamentosEmpresa;
import vistas.departametoEmpresa.frmNuevoDepartamentoEmpresa;
import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import vistas.ahorro.frmIndexAhorro;
import vistas.ahorro.frmNuevoAhorro;
import vistas.cargo.frmIndexCargo;
import vistas.cargo.frmNuevoCargo;
import vistas.cliente.frmIndexCliente;
import vistas.cliente.frmNuevoCliente;
import vistas.cliente.frmNuevoClienteDOS;
import vistas.credito.frmIndexCredito;
import vistas.abonoCredito.frmNuevoAbono;
import vistas.credito.frmNuevoCredito;
import vistas.cuenta.frmIndexCuenta;
import vistas.cuenta.frmNuevoCuenta;
import vistas.empleado.frmIndexEmpleado;
import vistas.empleado.frmNuevoEmpleado;
import vistas.garantia.frmIndexGarantia;
import vistas.garantia.frmIndexTipoGarantia;
import vistas.garantia.frmNuevoGarantia;
import vistas.garantia.frmNuevoTipoGarantia;
import vistas.sucursal.frmIndexSucursal;
import vistas.sucursal.frmNuevoSucursal;
import vistas.usuario.frmIndexUsuario;
import vistas.usuario.frmNuevoUsuario;
import vistas.usuario.frmPerfil;

/**
 *
 * @author Alejandro
 */
public class frmEscritorio extends javax.swing.JFrame {

    /**
     * Creates new form frmEscritorio
     */
    public frmEscritorio() {
        initComponents();
        permisos();
        
        lblUsuario.setText("" + frmLogin.nicknameSystem + " - " + frmLogin.permisosSystem);
        
        try{
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        }catch (Exception e){
            e.printStackTrace();
        }
        
        
        //Defino los permisos o bloqueo menus
        
        
        
        
        
        
        
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        dpnlEscritorio = new javax.swing.JDesktopPane();
        lblUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmEmpresa = new javax.swing.JMenu();
        jmiDepartamentos = new javax.swing.JMenuItem();
        jmiNuevoDepartamento = new javax.swing.JMenuItem();
        jmiCargos = new javax.swing.JMenuItem();
        jmiNuevoCargo = new javax.swing.JMenuItem();
        jmiEmpleados = new javax.swing.JMenuItem();
        jmiNuevoEmpleado = new javax.swing.JMenuItem();
        jmiSucursal = new javax.swing.JMenuItem();
        jmiNuevaSucursal = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiClientes = new javax.swing.JMenuItem();
        jmiNuevoCliente = new javax.swing.JMenuItem();
        jmCuentas = new javax.swing.JMenu();
        jmiCuentas = new javax.swing.JMenuItem();
        jmCreditos = new javax.swing.JMenu();
        jmiCreditos = new javax.swing.JMenuItem();
        jmiNuevoCredito = new javax.swing.JMenuItem();
        jmiGarantias = new javax.swing.JMenuItem();
        jmiNuevoGarantia = new javax.swing.JMenuItem();
        jmiTipoGarantia = new javax.swing.JMenuItem();
        jmiNuevoTipoGarantia = new javax.swing.JMenuItem();
        jmAhorros = new javax.swing.JMenu();
        jmiAhorros = new javax.swing.JMenuItem();
        jmiNuevoAhorro = new javax.swing.JMenuItem();
        jmCaja = new javax.swing.JMenu();
        jmiPerfil1 = new javax.swing.JMenuItem();
        jmiUsuarios1 = new javax.swing.JMenuItem();
        jmiAbonoAhorros = new javax.swing.JMenuItem();
        jmSistema = new javax.swing.JMenu();
        jmiPerfil = new javax.swing.JMenuItem();
        jmiUsuarios = new javax.swing.JMenuItem();
        jmiNuevoUsuario = new javax.swing.JMenuItem();
        jmiSalir = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dpnlEscritorio.setBackground(new java.awt.Color(255, 255, 255));

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuario.setText("Informacion");

        dpnlEscritorio.setLayer(lblUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dpnlEscritorioLayout = new javax.swing.GroupLayout(dpnlEscritorio);
        dpnlEscritorio.setLayout(dpnlEscritorioLayout);
        dpnlEscritorioLayout.setHorizontalGroup(
            dpnlEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dpnlEscritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario)
                .addContainerGap(1232, Short.MAX_VALUE))
        );
        dpnlEscritorioLayout.setVerticalGroup(
            dpnlEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dpnlEscritorioLayout.createSequentialGroup()
                .addContainerGap(646, Short.MAX_VALUE)
                .addComponent(lblUsuario)
                .addContainerGap())
        );

        getContentPane().add(dpnlEscritorio, java.awt.BorderLayout.CENTER);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        jmEmpresa.setText("Empresa");
        jmEmpresa.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jmiDepartamentos.setText("Departamentos");
        jmiDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDepartamentosActionPerformed(evt);
            }
        });
        jmEmpresa.add(jmiDepartamentos);

        jmiNuevoDepartamento.setText("Nuevo Departamento");
        jmiNuevoDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNuevoDepartamentoActionPerformed(evt);
            }
        });
        jmEmpresa.add(jmiNuevoDepartamento);

        jmiCargos.setText("Cargos");
        jmiCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCargosActionPerformed(evt);
            }
        });
        jmEmpresa.add(jmiCargos);

        jmiNuevoCargo.setText("Nuevo Cargo");
        jmiNuevoCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNuevoCargoActionPerformed(evt);
            }
        });
        jmEmpresa.add(jmiNuevoCargo);

        jmiEmpleados.setText("Empleados");
        jmiEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEmpleadosActionPerformed(evt);
            }
        });
        jmEmpresa.add(jmiEmpleados);

        jmiNuevoEmpleado.setText("Nuevo Empleado");
        jmiNuevoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNuevoEmpleadoActionPerformed(evt);
            }
        });
        jmEmpresa.add(jmiNuevoEmpleado);

        jmiSucursal.setText("Sucursal");
        jmiSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSucursalActionPerformed(evt);
            }
        });
        jmEmpresa.add(jmiSucursal);

        jmiNuevaSucursal.setText("Nueva Sucursal");
        jmiNuevaSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNuevaSucursalActionPerformed(evt);
            }
        });
        jmEmpresa.add(jmiNuevaSucursal);

        jMenuBar1.add(jmEmpresa);

        jMenu2.setText("Clientes");
        jMenu2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jmiClientes.setText("Clientes");
        jmiClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiClientesActionPerformed(evt);
            }
        });
        jMenu2.add(jmiClientes);

        jmiNuevoCliente.setText("Nuevo Cliente");
        jmiNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNuevoClienteActionPerformed(evt);
            }
        });
        jMenu2.add(jmiNuevoCliente);

        jMenuBar1.add(jMenu2);

        jmCuentas.setText("Cuentas");
        jmCuentas.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jmiCuentas.setText("Cuentas");
        jmiCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCuentasActionPerformed(evt);
            }
        });
        jmCuentas.add(jmiCuentas);

        jMenuBar1.add(jmCuentas);

        jmCreditos.setText("Creditos");
        jmCreditos.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jmiCreditos.setText("Creditos");
        jmiCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCreditosActionPerformed(evt);
            }
        });
        jmCreditos.add(jmiCreditos);

        jmiNuevoCredito.setText("Nuevo Credito");
        jmiNuevoCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNuevoCreditoActionPerformed(evt);
            }
        });
        jmCreditos.add(jmiNuevoCredito);

        jmiGarantias.setText("Garantías");
        jmiGarantias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiGarantiasActionPerformed(evt);
            }
        });
        jmCreditos.add(jmiGarantias);

        jmiNuevoGarantia.setText("Nueva Garantía");
        jmiNuevoGarantia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNuevoGarantiaActionPerformed(evt);
            }
        });
        jmCreditos.add(jmiNuevoGarantia);

        jmiTipoGarantia.setText("Tipos de Garantía");
        jmiTipoGarantia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTipoGarantiaActionPerformed(evt);
            }
        });
        jmCreditos.add(jmiTipoGarantia);

        jmiNuevoTipoGarantia.setText("Nuevo tipo de Garantia");
        jmiNuevoTipoGarantia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNuevoTipoGarantiaActionPerformed(evt);
            }
        });
        jmCreditos.add(jmiNuevoTipoGarantia);

        jMenuBar1.add(jmCreditos);

        jmAhorros.setText("Ahorros");
        jmAhorros.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jmiAhorros.setText("Ahorros");
        jmiAhorros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAhorrosActionPerformed(evt);
            }
        });
        jmAhorros.add(jmiAhorros);

        jmiNuevoAhorro.setText("Nuevo Ahorro");
        jmiNuevoAhorro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNuevoAhorroActionPerformed(evt);
            }
        });
        jmAhorros.add(jmiNuevoAhorro);

        jMenuBar1.add(jmAhorros);

        jmCaja.setText("Caja");
        jmCaja.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jmiPerfil1.setText("Abono de Creditos");
        jmiPerfil1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPerfil1ActionPerformed(evt);
            }
        });
        jmCaja.add(jmiPerfil1);

        jmiUsuarios1.setText("Desembolso de Creditos");
        jmiUsuarios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUsuarios1ActionPerformed(evt);
            }
        });
        jmCaja.add(jmiUsuarios1);

        jmiAbonoAhorros.setText("Transacciones de ahorros");
        jmiAbonoAhorros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAbonoAhorrosActionPerformed(evt);
            }
        });
        jmCaja.add(jmiAbonoAhorros);

        jMenuBar1.add(jmCaja);

        jmSistema.setText("Sistema");
        jmSistema.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jmiPerfil.setText("Mi perfil");
        jmiPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPerfilActionPerformed(evt);
            }
        });
        jmSistema.add(jmiPerfil);

        jmiUsuarios.setText("Usuarios");
        jmiUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUsuariosActionPerformed(evt);
            }
        });
        jmSistema.add(jmiUsuarios);

        jmiNuevoUsuario.setText("Nuevo Usuario");
        jmiNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNuevoUsuarioActionPerformed(evt);
            }
        });
        jmSistema.add(jmiNuevoUsuario);

        jmiSalir.setText("Salir");
        jmiSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalirActionPerformed(evt);
            }
        });
        jmSistema.add(jmiSalir);

        jMenuBar1.add(jmSistema);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void permisos(){
        
        if(frmLogin.permisosSystem.equals("Supervisor")){
            
        jmiUsuarios.setEnabled(false);
        jmiNuevoUsuario.setEnabled(false);
        
        }else if(frmLogin.permisosSystem.equals("Gerente")){
            
        jmiUsuarios.setEnabled(false);
        jmiNuevoUsuario.setEnabled(false);
        }
        else if(frmLogin.permisosSystem.equals("Asesor")){
            
        jmiUsuarios.setEnabled(false);
        jmiNuevoUsuario.setEnabled(false);
        
         jmiUsuarios.setEnabled(false);
        jmiNuevoUsuario.setEnabled(false);
        
        jmCuentas.setEnabled(false);
        jMenu2.setEnabled(false); //para clientes
        jmEmpresa.setEnabled(false);
        jmAhorros.setEnabled(false);
        jmCaja.setEnabled(false);
        
        
        
        
        
        
        }
        
        else if(frmLogin.permisosSystem.equals("Cajero")){
            
        jmiUsuarios.setEnabled(false);
        jmiNuevoUsuario.setEnabled(false);
        jmCreditos.setEnabled(false);
        jmCuentas.setEnabled(false);
        jMenu2.setEnabled(false); //para clientes
        jmEmpresa.setEnabled(false);
        
      
        }
        
        
        
       
           
    }
    
    
    private void jmiNuevoDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNuevoDepartamentoActionPerformed
        // TODO add your handling code here:
        
        frmNuevoDepartamentoEmpresa frmNuevoDep = new frmNuevoDepartamentoEmpresa();
        dpnlEscritorio.add(frmNuevoDep);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmNuevoDep.getSize();
        frmNuevoDep.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmNuevoDep.setVisible(true);
        
    }//GEN-LAST:event_jmiNuevoDepartamentoActionPerformed

    private void jmiDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDepartamentosActionPerformed
        frmIndexDepatamentosEmpresa frmIndex =new frmIndexDepatamentosEmpresa();
        dpnlEscritorio.add(frmIndex);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmIndex.getSize();
        frmIndex.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmIndex.setVisible(true);
    }//GEN-LAST:event_jmiDepartamentosActionPerformed

    private void jmiCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCargosActionPerformed
        frmIndexCargo frmIndex =new frmIndexCargo();
        dpnlEscritorio.add(frmIndex);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmIndex.getSize();
        frmIndex.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmIndex.setVisible(true);
    }//GEN-LAST:event_jmiCargosActionPerformed

    private void jmiNuevoCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNuevoCargoActionPerformed
        frmNuevoCargo frmNuevo = new frmNuevoCargo();
        dpnlEscritorio.add(frmNuevo);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmNuevo.getSize();
        frmNuevo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmNuevo.setVisible(true);
    }//GEN-LAST:event_jmiNuevoCargoActionPerformed

    private void jmiEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEmpleadosActionPerformed
        frmIndexEmpleado frmIndex =new frmIndexEmpleado();
        dpnlEscritorio.add(frmIndex);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmIndex.getSize();
        frmIndex.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmIndex.setVisible(true);
    }//GEN-LAST:event_jmiEmpleadosActionPerformed

    private void jmiNuevoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNuevoEmpleadoActionPerformed
        frmNuevoEmpleado frmNuevo = new frmNuevoEmpleado();
        dpnlEscritorio.add(frmNuevo);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmNuevo.getSize();
        frmNuevo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmNuevo.setVisible(true);
    }//GEN-LAST:event_jmiNuevoEmpleadoActionPerformed

    private void jmiSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSucursalActionPerformed
        frmIndexSucursal frmIndex =new frmIndexSucursal();
        dpnlEscritorio.add(frmIndex);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmIndex.getSize();
        frmIndex.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmIndex.setVisible(true);
    }//GEN-LAST:event_jmiSucursalActionPerformed

    private void jmiNuevaSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNuevaSucursalActionPerformed
        frmNuevoSucursal frmNuevo = new frmNuevoSucursal();
        dpnlEscritorio.add(frmNuevo);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmNuevo.getSize();
        frmNuevo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmNuevo.setVisible(true);
    }//GEN-LAST:event_jmiNuevaSucursalActionPerformed

    private void jmiClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiClientesActionPerformed
        frmIndexCliente frmIndex =new frmIndexCliente();
        dpnlEscritorio.add(frmIndex);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmIndex.getSize();
        frmIndex.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmIndex.setVisible(true);
    }//GEN-LAST:event_jmiClientesActionPerformed

    private void jmiNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNuevoClienteActionPerformed
        
        frmNuevoClienteDOS frmNuevo = new frmNuevoClienteDOS();
        dpnlEscritorio.add(frmNuevo);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmNuevo.getSize();
        frmNuevo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmNuevo.setVisible(true);
    }//GEN-LAST:event_jmiNuevoClienteActionPerformed

    private void jmiCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCuentasActionPerformed
        frmIndexCuenta frmIndex =new frmIndexCuenta();
        dpnlEscritorio.add(frmIndex);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmIndex.getSize();
        frmIndex.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmIndex.setVisible(true);
    }//GEN-LAST:event_jmiCuentasActionPerformed

    private void jmiCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCreditosActionPerformed
        frmIndexCredito frmIndex =new frmIndexCredito(1);
        dpnlEscritorio.add(frmIndex);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmIndex.getSize();
        frmIndex.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmIndex.setVisible(true);
    }//GEN-LAST:event_jmiCreditosActionPerformed

    private void jmiNuevoCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNuevoCreditoActionPerformed
        frmNuevoCredito frmNuevo = new frmNuevoCredito();
        dpnlEscritorio.add(frmNuevo);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmNuevo.getSize();
        frmNuevo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmNuevo.setVisible(true);
    }//GEN-LAST:event_jmiNuevoCreditoActionPerformed

    private void jmiAhorrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAhorrosActionPerformed
        frmIndexAhorro frmIndex =new frmIndexAhorro(1);
        dpnlEscritorio.add(frmIndex);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmIndex.getSize();
        frmIndex.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmIndex.setVisible(true);
    }//GEN-LAST:event_jmiAhorrosActionPerformed

    private void jmiNuevoAhorroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNuevoAhorroActionPerformed
        frmNuevoAhorro frmNuevo = new frmNuevoAhorro();
        dpnlEscritorio.add(frmNuevo);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmNuevo.getSize();
        frmNuevo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmNuevo.setVisible(true);
    }//GEN-LAST:event_jmiNuevoAhorroActionPerformed

    private void jmiGarantiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiGarantiasActionPerformed
        frmIndexGarantia frmIndex =new frmIndexGarantia();
        dpnlEscritorio.add(frmIndex);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmIndex.getSize();
        frmIndex.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmIndex.setVisible(true);
    }//GEN-LAST:event_jmiGarantiasActionPerformed

    private void jmiNuevoGarantiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNuevoGarantiaActionPerformed
        frmNuevoGarantia frmNuevo = new frmNuevoGarantia();
        dpnlEscritorio.add(frmNuevo);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmNuevo.getSize();
        frmNuevo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmNuevo.setVisible(true);
    }//GEN-LAST:event_jmiNuevoGarantiaActionPerformed

    private void jmiTipoGarantiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTipoGarantiaActionPerformed
        frmIndexTipoGarantia frmIndex =new frmIndexTipoGarantia();
        dpnlEscritorio.add(frmIndex);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmIndex.getSize();
        frmIndex.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmIndex.setVisible(true);
    }//GEN-LAST:event_jmiTipoGarantiaActionPerformed

    private void jmiNuevoTipoGarantiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNuevoTipoGarantiaActionPerformed
        frmNuevoTipoGarantia frmNuevo = new frmNuevoTipoGarantia();
        dpnlEscritorio.add(frmNuevo);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmNuevo.getSize();
        frmNuevo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmNuevo.setVisible(true);
    }//GEN-LAST:event_jmiNuevoTipoGarantiaActionPerformed

    private void jmiPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPerfilActionPerformed
       
         frmPerfil frmNuevo = new frmPerfil();
        dpnlEscritorio.add(frmNuevo);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmNuevo.getSize();
        frmNuevo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmNuevo.setVisible(true);
        
        frmPerfil.txtIdPerfil.setText(String.valueOf(frmLogin.idUsuarioSystem));
        frmPerfil.txtUsuario.setText(frmLogin.nicknameSystem);
        frmPerfil.txtPermisos.setText(frmLogin.permisosSystem);
        
        
        
        
        
        
    }//GEN-LAST:event_jmiPerfilActionPerformed

    private void jmiUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUsuariosActionPerformed
        frmIndexUsuario frmIndex =new frmIndexUsuario();
        dpnlEscritorio.add(frmIndex);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmIndex.getSize();
        frmIndex.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmIndex.setVisible(true);
    }//GEN-LAST:event_jmiUsuariosActionPerformed

    private void jmiNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNuevoUsuarioActionPerformed
        frmNuevoUsuario frmNuevo = new frmNuevoUsuario();
        dpnlEscritorio.add(frmNuevo);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmNuevo.getSize();
        frmNuevo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmNuevo.setVisible(true);
    }//GEN-LAST:event_jmiNuevoUsuarioActionPerformed

    private void jmiPerfil1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPerfil1ActionPerformed
        frmIndexCredito frmNuevo = new frmIndexCredito(2);
        dpnlEscritorio.add(frmNuevo);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmNuevo.getSize();
        frmNuevo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmNuevo.setVisible(true);
    }//GEN-LAST:event_jmiPerfil1ActionPerformed

    private void jmiUsuarios1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUsuarios1ActionPerformed
        frmIndexCredito frmNuevo = new frmIndexCredito(3);
        dpnlEscritorio.add(frmNuevo);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmNuevo.getSize();
        frmNuevo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmNuevo.setVisible(true);
    }//GEN-LAST:event_jmiUsuarios1ActionPerformed

    private void jmiAbonoAhorrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAbonoAhorrosActionPerformed
      
         frmIndexAhorro frmIndex =new frmIndexAhorro(2);
        dpnlEscritorio.add(frmIndex);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmIndex.getSize();
        frmIndex.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmIndex.setVisible(true);
        
        
        
    }//GEN-LAST:event_jmiAbonoAhorrosActionPerformed

    private void jmiSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalirActionPerformed
       
        frmLogin login = new frmLogin();
	
		//login.setSize(380, 365);
		login.setVisible(true);
		login.setResizable(false);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                login.setLocationRelativeTo(null);
        this.dispose();
        
        
    }//GEN-LAST:event_jmiSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmEscritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEscritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEscritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEscritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEscritorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane dpnlEscritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenu jmAhorros;
    private javax.swing.JMenu jmCaja;
    private javax.swing.JMenu jmCreditos;
    private javax.swing.JMenu jmCuentas;
    private javax.swing.JMenu jmEmpresa;
    private javax.swing.JMenu jmSistema;
    private javax.swing.JMenuItem jmiAbonoAhorros;
    private javax.swing.JMenuItem jmiAhorros;
    private javax.swing.JMenuItem jmiCargos;
    private javax.swing.JMenuItem jmiClientes;
    private javax.swing.JMenuItem jmiCreditos;
    private javax.swing.JMenuItem jmiCuentas;
    private javax.swing.JMenuItem jmiDepartamentos;
    private javax.swing.JMenuItem jmiEmpleados;
    private javax.swing.JMenuItem jmiGarantias;
    private javax.swing.JMenuItem jmiNuevaSucursal;
    private javax.swing.JMenuItem jmiNuevoAhorro;
    private javax.swing.JMenuItem jmiNuevoCargo;
    private javax.swing.JMenuItem jmiNuevoCliente;
    private javax.swing.JMenuItem jmiNuevoCredito;
    private javax.swing.JMenuItem jmiNuevoDepartamento;
    private javax.swing.JMenuItem jmiNuevoEmpleado;
    private javax.swing.JMenuItem jmiNuevoGarantia;
    private javax.swing.JMenuItem jmiNuevoTipoGarantia;
    private javax.swing.JMenuItem jmiNuevoUsuario;
    private javax.swing.JMenuItem jmiPerfil;
    private javax.swing.JMenuItem jmiPerfil1;
    private javax.swing.JMenuItem jmiSalir;
    private javax.swing.JMenuItem jmiSucursal;
    private javax.swing.JMenuItem jmiTipoGarantia;
    private javax.swing.JMenuItem jmiUsuarios;
    private javax.swing.JMenuItem jmiUsuarios1;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables
}
