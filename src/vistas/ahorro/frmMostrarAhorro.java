/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.ahorro;

import controladores.Conexion;
import controladores.FAhorro;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vistas.abonoAhorro.frmNuevoAbonoAhorro;
import vistas.abonoAhorro.frmNuevoDesembolsoAhorro;
import static vistas.abonoCredito.frmMostrarAbonos.txtIdCredito;
import static vistas.abonoCredito.frmMostrarAbonos.txtMontoRestante;
import vistas.abonoCredito.frmNuevoAbonoCapital;
import vistas.credito.*;
import static vistas.credito.frmMostrarCredito.txtIdCuenta;
import vistas.cuenta.frmMostrarCuenta;
import static vistas.frmEscritorio.dpnlEscritorio;

/**
 *
 * @author Alejandro
 */
public class frmMostrarAhorro extends javax.swing.JInternalFrame implements ActionListener{

   int opcion;
   FAhorro funcion = new FAhorro();
   DefaultTableModel modelo;
   
    public frmMostrarAhorro(int opcionr) {
        initComponents();
        opcion = opcionr;
        txtIdAhorroD.setVisible(false);
        txtIdCuenta1.setVisible(false);
        btnactualizar.addActionListener(this);
        btnactualizar.setVisible(false);
        String n;
        n= txtIdAhorroD.getText();
        String query="SELECT a.Id_abono_ahorro,a.Id_ahorro,a.Monto,a.Fecha_commit,a.Hora_Commit FROM TBL_ABONO_AHORRO\n" +
                     "AS a inner join TBL_AHORRO AS b on a.Id_ahorro = b.Id_ahorro where a.Id_ahorro= '"+n+"' and b.Estado=1 ";
        
        String query1="SELECT a.Id_desembolso_ahorro,a.Id_ahorro,a.Monto,a.Fecha_commit,a.Hora_commit FROM TBL_DESEMBOLSO_AHORRO AS\n" +
        "a inner join TBL_AHORRO AS b on a.Id_ahorro=b.Id_ahorro where a.Id_ahorro = '"+n+"' and b.Estado=1";
       
        mostrar(query);
        mostrar1(query1);
        if(opcion ==1){
            lblTitulo.setText("Detalles de la cuenta de ahorro");
            btnAbonoAhorro.setVisible(false);
            btnDesembolsoAhorro.setVisible(false);
            
            
            
        }else if(opcion ==2){
            lblTitulo.setText("Transaccion: Ahorros");   
            btnAbonoAhorro.setVisible(true);
            btnDesembolsoAhorro.setVisible(true);
        }
        
       
        ButtonGroup grupoBuscar = new ButtonGroup();
        grupoBuscar.add(rbId);
        grupoBuscar.add(rbId1);
        rbId1.setSelected(true);
        btnInformacion.addActionListener(this);
        btnAbonoAhorro.addActionListener(this);
        btnReporte.addActionListener(this);
        btnDesembolsoAhorro.addActionListener(this);
        btnReporte1.addActionListener(this);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
    
        if(e.getSource() == btnDesembolsoAhorro){
            frmNuevoDesembolsoAhorro frmNuevo  = new frmNuevoDesembolsoAhorro(
                    Integer.parseInt(txtIdAhorroD.getText()),
                    Float.parseFloat(txtMontoTotal.getText()));
            dpnlEscritorio.add(frmNuevo);
            Dimension desktopSize = dpnlEscritorio.getSize();
            Dimension FrameSize = frmNuevo.getSize();
            frmNuevo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            frmNuevo.setVisible(true);
            
            frmNuevoDesembolsoAhorro.txtDpi.setText(txtDpi.getText());
            frmNuevoDesembolsoAhorro.txtNombre.setText(txtNombre.getText());
            
        }
        
    if(e.getSource()==btnInformacion){
           
        int posicion = tblDatos.getSelectedRow();
        frmMostrarCuenta frmMostrar = new frmMostrarCuenta(txtIdCuenta1.getText());
        dpnlEscritorio.add(frmMostrar);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmMostrar.getSize();
        frmMostrar.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmMostrar.setVisible(true);
       
       
       }
    
    if(e.getSource()==btnAbonoAhorro){
        
            frmNuevoAbonoAhorro frmNuevo  = new frmNuevoAbonoAhorro();
            dpnlEscritorio.add(frmNuevo);
            Dimension desktopSize = dpnlEscritorio.getSize();
            Dimension FrameSize = frmNuevo.getSize();
            frmNuevo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            frmNuevo.setVisible(true);
            frmNuevoAbonoAhorro.txtIdAhorro.setText(txtIdAhorroD.getText());
           // frmNuevoAbonoCapital.txtCapital.setText(txtMontoRestante.getText()); 
  
        
    }
    
    if(e.getSource()==btnactualizar){
        
    String n;
    n= txtIdAhorroD.getText();
    String query="SELECT a.Id_abono_ahorro,a.Id_ahorro,a.Monto,a.Fecha_commit,a.Hora_Commit FROM TBL_ABONO_AHORRO\n" +
    "AS a inner join TBL_AHORRO AS b on a.Id_ahorro = b.Id_ahorro where a.Id_ahorro= '"+n+"' and b.Estado=1 ";    
     mostrar(query);  
     
     String query1="SELECT a.Id_desembolso_ahorro,a.Id_ahorro,a.Monto,a.Fecha_commit,a.Hora_commit FROM TBL_DESEMBOLSO_AHORRO AS\n" +
        "a inner join TBL_AHORRO AS b on a.Id_ahorro=b.Id_ahorro where a.Id_ahorro = '"+n+"' and b.Estado=1";
      mostrar1(query1);
    }
    
    if(e.getSource()== btnReporte){
    
    String carre = txtIdAhorroD.getText();
    Conexion g = new Conexion();
    g.Conectar();
    try{
               String url = System.getProperty("user.dir");
               // String ruta = url+"/src/reportes/ReporteEspecificoAlum.jasper";
               String ruta = "/reportes/ReporteAbonoAhorro.jasper";
               
               Map parametro = new HashMap();
               parametro.put("id",carre);
               
               InputStream rutaJasper =  frmMostrarAhorro.class.getResourceAsStream(ruta);
                JasperReport jasperReport = (JasperReport) JRLoader.loadObject(rutaJasper);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, g.getConexion());
               
               
                JasperViewer viewer = new JasperViewer(jasperPrint,false);
               // viewer.setTitle("Reporte UMG");
                viewer.setVisible(true);
            }catch(JRException ex){
                System.out.println(ex.getMessage());
            }
    
    
    }
    
    if(e.getSource()== btnReporte1){
       String carre = txtIdAhorroD.getText();
       Conexion g = new Conexion();
       g.Conectar();
           try{
               String url = System.getProperty("user.dir");
               // String ruta = url+"/src/reportes/ReporteEspecificoAlum.jasper";
               String ruta = "/reportes/ReporteDesembolsoAhorro.jasper";
               
               Map parametro = new HashMap();
               parametro.put("id",carre);
               
               InputStream rutaJasper =  frmMostrarAhorro.class.getResourceAsStream(ruta);
                JasperReport jasperReport = (JasperReport) JRLoader.loadObject(rutaJasper);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, g.getConexion());
               
               
                JasperViewer viewer = new JasperViewer(jasperPrint,false);
               // viewer.setTitle("Reporte UMG");
                viewer.setVisible(true);
            }catch(JRException ex){
                System.out.println(ex.getMessage());
            }
    
    
    }
    
    
    
    }
    
     private void buscarAbono(String textoBuscar){
     
     if(rbId.isSelected()==true){
     
     mostrar("SELECT a.Id_abono_ahorro,a.Id_ahorro,a.Monto,a.Fecha_commit,a.Hora_Commit,c.NIckname FROM TBL_ABONO_AHORRO\n" +
            "AS a inner join TBL_AHORRO AS b on a.Id_ahorro = b.Id_ahorro inner join TBL_USUARIO AS c on a.ID_USUARIO=c.Id_usuario\n" +
            "where (a.Id_abono_ahorro like '%"+textoBuscar+"%') and b.Estado=1");
     
     }else{
         
         
     mostrar1("SELECT a.Id_desembolso_ahorro,a.Id_ahorro,a.Monto,a.Fecha_commit,a.Hora_commit FROM TBL_DESEMBOLSO_AHORRO AS\n" +
         "a inner join TBL_AHORRO AS b on a.Id_ahorro=b.Id_ahorro where (a.Id_desembolso_ahorro like '%"+textoBuscar+"%') and b.Estado=1");     
         
     }
    
     }
    
    
      private void mostrar(String buscar){    
        try {
            modelo = funcion.mostrarAbono(buscar);
            tblDatos.setModel(modelo);
            
            txtTotal.setText("    " + Integer.toString(funcion.totalRefistrosA)); 
            ocultarColumnas(tblDatos,1);
            //ocultarColumnas(tblDatosA,0);
            //ocultarColumnas(tblDatosA,3);
            //ocultarColumnas(tblDatosA,4);
            //ocultarColumnas(tblDatosA,5);
            //ocultarColumnas(tblDatosA,6);
            //ocultarColumnas(tblDatosA,7);
            //ocultarColumnas(tblDatosA,8);
            //ocultarColumnas(tblDatosA,9);
            
             //calcularTotalAbonos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos, motivo: "+ e);
        }
        
    }
      
    
     private void mostrar1(String buscar){    
        try {
            modelo = funcion.mostrarDesembolso(buscar);
            tblDatos1.setModel(modelo);
            
            txtTotal1.setText("    " + Integer.toString(funcion.totalRefistrosB)); 
            ocultarColumnas(tblDatos1,1);
            //ocultarColumnas(tblDatosA,0);
            //ocultarColumnas(tblDatosA,3);
            //ocultarColumnas(tblDatosA,4);
            //ocultarColumnas(tblDatosA,5);
            //ocultarColumnas(tblDatosA,6);
            //ocultarColumnas(tblDatosA,7);
            //ocultarColumnas(tblDatosA,8);
            //ocultarColumnas(tblDatosA,9);
            
             //calcularTotalAbonos();
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
        lblTitulo = new javax.swing.JLabel();
        pnlIndex = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        rbId = new javax.swing.JRadioButton();
        rbId1 = new javax.swing.JRadioButton();
        txtNombre = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtIdCuenta = new javax.swing.JTextField();
        lblNombre2 = new javax.swing.JLabel();
        txtDpi = new javax.swing.JTextField();
        lblNombre3 = new javax.swing.JLabel();
        btnInformacion = new javax.swing.JButton();
        lblNombre8 = new javax.swing.JLabel();
        txtInteres = new javax.swing.JTextField();
        lblNombre7 = new javax.swing.JLabel();
        txtPlazo = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        txtPago = new javax.swing.JTextField();
        lblNombre10 = new javax.swing.JLabel();
        lblNombre11 = new javax.swing.JLabel();
        txtMontoTotal = new javax.swing.JTextField();
        txtMontoPagado = new javax.swing.JTextField();
        txtMontoRestante = new javax.swing.JTextField();
        btnGarantia = new javax.swing.JButton();
        txtGarantia = new javax.swing.JTextField();
        lblNombre6 = new javax.swing.JLabel();
        lblNombre13 = new javax.swing.JLabel();
        txtIdCuenta1 = new javax.swing.JTextField();
        btnAbonoAhorro = new javax.swing.JButton();
        btnDesembolsoAhorro = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDatos1 = new javax.swing.JTable();
        lblTitulo1 = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTotal1 = new javax.swing.JTextField();
        btnactualizar = new javax.swing.JButton();
        btnReporte1 = new javax.swing.JButton();
        txtIdAhorroD = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(1090, 717));

        pnlBase.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        lblTitulo.setText("Detalles de la cuenta de ahorro");

        pnlIndex.setBackground(new java.awt.Color(255, 255, 255));

        tblDatos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Total de Abonos");

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnActualizar.setText("Actualizar");

        btnReporte.setBackground(new java.awt.Color(255, 255, 255));
        btnReporte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnReporte.setText("Reporte");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        txtBuscar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtBuscar.setBorder(null);
        txtBuscar.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtBuscarCaretUpdate(evt);
            }
        });
        jPanel1.add(txtBuscar);

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("   ");
        btnBuscar.setBorder(null);
        jPanel1.add(btnBuscar);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Buscar");

        rbId.setBackground(new java.awt.Color(255, 255, 255));
        rbId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbId.setText("Transacción Abono");
        rbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbIdActionPerformed(evt);
            }
        });

        rbId1.setBackground(new java.awt.Color(255, 255, 255));
        rbId1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbId1.setText("Transacción Desembolso");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rbId)
                        .addGap(10, 10, 10)
                        .addComponent(rbId1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbId)
                    .addComponent(rbId1)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(43, 43, 43))
        );

        txtNombre.setEnabled(false);

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre.setText("Cliente");

        txtIdCuenta.setEditable(false);
        txtIdCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCuentaActionPerformed(evt);
            }
        });

        lblNombre2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre2.setText("No. cuanta de ahorro");

        txtDpi.setEditable(false);
        txtDpi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDpiActionPerformed(evt);
            }
        });

        lblNombre3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre3.setText("DPI");

        btnInformacion.setBackground(new java.awt.Color(255, 255, 255));
        btnInformacion.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnInformacion.setText("Información");

        lblNombre8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre8.setText("Tipo de ahorro");

        txtInteres.setEnabled(false);

        lblNombre7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre7.setText("Tasa de Interés");

        txtPlazo.setEnabled(false);

        lblNombre1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre1.setText("Fecha Retiro");

        txtPago.setEnabled(false);

        lblNombre10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre10.setText("Monto Total");

        lblNombre11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre11.setText("Pago Programado");

        txtMontoTotal.setEnabled(false);

        txtMontoPagado.setEnabled(false);

        txtMontoRestante.setEnabled(false);

        btnGarantia.setBackground(new java.awt.Color(255, 255, 255));
        btnGarantia.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnGarantia.setText("Ver beneficiario");

        txtGarantia.setEnabled(false);

        lblNombre6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre6.setText("Beneficiario");

        lblNombre13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre13.setText("Plazo");

        txtIdCuenta1.setEditable(false);
        txtIdCuenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCuenta1ActionPerformed(evt);
            }
        });

        btnAbonoAhorro.setBackground(new java.awt.Color(255, 255, 255));
        btnAbonoAhorro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAbonoAhorro.setText("Abonar ahorro");

        btnDesembolsoAhorro.setBackground(new java.awt.Color(255, 255, 255));
        btnDesembolsoAhorro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDesembolsoAhorro.setText("Desembolsar ahorro");

        tblDatos1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblDatos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDatos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatos1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDatos1);

        lblTitulo1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        lblTitulo1.setText("Abonos");

        lblTitulo2.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        lblTitulo2.setText("Desembolsos");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Total de Desembolsos");

        btnactualizar.setText("jButton1");

        btnReporte1.setBackground(new java.awt.Color(255, 255, 255));
        btnReporte1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnReporte1.setText("Reporte");

        javax.swing.GroupLayout pnlIndexLayout = new javax.swing.GroupLayout(pnlIndex);
        pnlIndex.setLayout(pnlIndexLayout);
        pnlIndexLayout.setHorizontalGroup(
            pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlIndexLayout.createSequentialGroup()
                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlIndexLayout.createSequentialGroup()
                        .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre6)
                            .addComponent(txtGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlIndexLayout.createSequentialGroup()
                                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblNombre)
                                        .addGroup(pnlIndexLayout.createSequentialGroup()
                                            .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblNombre2)
                                                .addComponent(txtIdCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(pnlIndexLayout.createSequentialGroup()
                                                    .addComponent(txtDpi, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(btnInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(lblNombre3)))
                                        .addComponent(txtNombre)))
                                .addGap(18, 18, 18)
                                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(pnlIndexLayout.createSequentialGroup()
                                            .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtInteres, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblNombre8))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblNombre7)
                                                .addComponent(txtPlazo, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
                                        .addGroup(pnlIndexLayout.createSequentialGroup()
                                            .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblNombre1)
                                                .addGroup(pnlIndexLayout.createSequentialGroup()
                                                    .addComponent(lblNombre10)
                                                    .addGap(112, 112, 112)
                                                    .addComponent(lblNombre11))
                                                .addGroup(pnlIndexLayout.createSequentialGroup()
                                                    .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(txtMontoPagado, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(10, 10, 10)
                                            .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(pnlIndexLayout.createSequentialGroup()
                                                    .addComponent(lblNombre13)
                                                    .addGap(0, 0, Short.MAX_VALUE))
                                                .addComponent(txtMontoRestante))))
                                    .addGroup(pnlIndexLayout.createSequentialGroup()
                                        .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtIdCuenta1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnactualizar)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlIndexLayout.createSequentialGroup()
                        .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlIndexLayout.createSequentialGroup()
                                .addComponent(lblTitulo1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAbonoAhorro))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlIndexLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pnlIndexLayout.createSequentialGroup()
                                    .addComponent(lblTitulo2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnReporte1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnDesembolsoAhorro))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIndexLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        pnlIndexLayout.setVerticalGroup(
            pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIndexLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlIndexLayout.createSequentialGroup()
                        .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre2)
                            .addComponent(lblNombre3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDpi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombre))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlIndexLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlIndexLayout.createSequentialGroup()
                                .addComponent(lblNombre8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtInteres, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlIndexLayout.createSequentialGroup()
                                .addComponent(lblNombre7)
                                .addGap(38, 38, 38)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre13)
                            .addComponent(lblNombre10)
                            .addComponent(lblNombre11))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMontoRestante, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMontoPagado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIndexLayout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre6)
                    .addComponent(lblNombre1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIdCuenta1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnactualizar)))
                .addGap(31, 31, 31)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo2)
                    .addComponent(btnReporte)
                    .addComponent(btnActualizar)
                    .addComponent(lblTitulo1)
                    .addComponent(btnAbonoAhorro)
                    .addComponent(btnDesembolsoAhorro)
                    .addComponent(btnReporte1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 31, Short.MAX_VALUE)
                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        txtIdAhorroD.setEditable(false);
        txtIdAhorroD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdAhorroDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBaseLayout = new javax.swing.GroupLayout(pnlBase);
        pnlBase.setLayout(pnlBaseLayout);
        pnlBaseLayout.setHorizontalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBaseLayout.createSequentialGroup()
                        .addComponent(pnlIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addGroup(pnlBaseLayout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdAhorroD, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(300, 300, 300))))
        );
        pnlBaseLayout.setVerticalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(txtIdAhorroD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlIndex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnlBase, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBuscarCaretUpdate
        //buscar();
        buscarAbono(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarCaretUpdate

    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked
        /*frmMostrarCredito frmMostrar = new frmMostrarCredito();
        dpnlEscritorio.add(frmMostrar);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmMostrar.getSize();
        frmMostrar.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmMostrar.setVisible(true);*/

        /*int posicion = tblDatos.getSelectedRow();
        frmMostrarSucursal.txtId.setText(tblDatos.getValueAt(posicion,0).toString());
        frmMostrarSucursal.txtNombre.setText(tblDatos.getValueAt(posicion,1).toString());

        frmMostrarSucursal.txtMunicipio.setText(tblDatos.getValueAt(posicion,2).toString());
        frmMostrarSucursal.txtDepartamento.setText(tblDatos.getValueAt(posicion,3).toString());

        frmMostrarSucursal.txtDireccion.setText(tblDatos.getValueAt(posicion,4).toString());
        frmMostrarSucursal.txtTelefono.setText(tblDatos.getValueAt(posicion,5).toString());
        frmMostrarSucursal.txtCorreo.setText(tblDatos.getValueAt(posicion,6).toString());
        frmMostrarSucursal.txtEstado.setText(tblDatos.getValueAt(posicion,7).toString());
        frmMostrarSucursal.txtIdMunicipio.setText(tblDatos.getValueAt(posicion,8).toString());
        frmMostrarSucursal.txtIdDepartamento.setText(tblDatos.getValueAt(posicion,9).toString());
        frmMostrarSucursal.txtFecha.setText(tblDatos.getValueAt(posicion,10).toString());
        frmMostrarSucursal.txtHora.setText(tblDatos.getValueAt(posicion,11).toString());

        //frmMostrarSucursal.cbMunicipio.setText((tblDatos.getValueAt(posicion,2).toString()));*/
    }//GEN-LAST:event_tblDatosMouseClicked

    private void rbIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbIdActionPerformed

    private void txtIdCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCuentaActionPerformed

    private void txtDpiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDpiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDpiActionPerformed

    private void txtIdCuenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCuenta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCuenta1ActionPerformed

    private void txtIdAhorroDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdAhorroDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdAhorroDActionPerformed

    private void tblDatos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatos1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDatos1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbonoAhorro;
    public static javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDesembolsoAhorro;
    private javax.swing.JButton btnGarantia;
    private javax.swing.JButton btnInformacion;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnReporte1;
    public static javax.swing.JButton btnactualizar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre10;
    private javax.swing.JLabel lblNombre11;
    private javax.swing.JLabel lblNombre13;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombre6;
    private javax.swing.JLabel lblNombre7;
    private javax.swing.JLabel lblNombre8;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JPanel pnlBase;
    private javax.swing.JPanel pnlIndex;
    private javax.swing.JRadioButton rbId;
    private javax.swing.JRadioButton rbId1;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTable tblDatos1;
    private javax.swing.JTextField txtBuscar;
    public static javax.swing.JTextField txtDpi;
    public static javax.swing.JTextField txtGarantia;
    public static javax.swing.JTextField txtIdAhorroD;
    public static javax.swing.JTextField txtIdCuenta;
    public static javax.swing.JTextField txtIdCuenta1;
    public static javax.swing.JTextField txtInteres;
    public static javax.swing.JTextField txtMontoPagado;
    public static javax.swing.JTextField txtMontoRestante;
    public static javax.swing.JTextField txtMontoTotal;
    public static javax.swing.JTextField txtNombre;
    public static javax.swing.JTextField txtPago;
    public static javax.swing.JTextField txtPlazo;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotal1;
    // End of variables declaration//GEN-END:variables
}
