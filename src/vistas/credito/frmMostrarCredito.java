/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.credito;

import controladores.Conexion;
import controladores.FCredito;
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
import vistas.cuenta.frmMostrarCuenta;
import static vistas.frmEscritorio.dpnlEscritorio;

/**
 *
 * @author Alejandro
 */
public class frmMostrarCredito extends javax.swing.JInternalFrame implements ActionListener{

    FCredito funcion = new FCredito();
    DefaultTableModel modelo;
    
    public frmMostrarCredito() {
        initComponents();
        btnactualizarabono.setVisible(false);
        String n;
        n= txtIdCredito.getText();
        String query="SELECT a.Id_abono,a.Id_credito,a.Capital,a.Mora,a.Interes,a.Total_monto,a.Forma_pago,a.Fecha_commit,a.Hora_commit \n" +
                     "FROM TBL_ABONO_CREDITO AS a where  a.Id_credito= '"+n+"' AND (a.Estado=0 OR a.Estado=2)";
        
        String query1="SELECT a.Id_desembolso,a.Id_credito,a.Monto,a.Fecha_commit,a.Hora_commit FROM TBL_DESEMBOLSO_CREDITO \n" +
                      "AS a inner join TBL_USUARIO AS b on a.Id_usuario = b.Id_usuario inner join TBL_CREDITO AS c on \n" +
                      "a.Id_credito = c.Id_credito where a.Id_credito = '"+n+"' AND c.Estado=1";
        btnInformacion.addActionListener(this);
        mostrar(query);
        mostrar2(query1);
        btnactualizarabono.addActionListener(this);
        btnactualizarabono.doClick();
       // btnAbono.addActionListener(this);
        //SI
        txtIdCredito.setVisible(false);
        txtIdCuenta.setVisible(false);
        
        btnReporte.addActionListener(this);
        ButtonGroup grupoBuscar = new ButtonGroup();
        grupoBuscar.add(rbId);
        grupoBuscar.add(rbId1);
        rbId1.setSelected(true);
        btnActualizar.addActionListener(this);
       
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {


            
       if(e.getSource()==btnInformacion){
           
        int posicion = tblDatos.getSelectedRow();
        frmMostrarCuenta frmMostrar = new frmMostrarCuenta(txtIdCuenta.getText());
        dpnlEscritorio.add(frmMostrar);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmMostrar.getSize();
        frmMostrar.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmMostrar.setVisible(true);
       
       
       }
       
       
       if(e.getSource()== btnactualizarabono){
           String n;
        n= txtIdCredito.getText();
        String query="SELECT a.Id_abono,a.Id_credito,a.Capital,a.Mora,a.Interes,a.Total_monto,a.Forma_pago,a.Fecha_commit,a.Hora_commit \n" +
                     "FROM TBL_ABONO_CREDITO AS a where  a.Id_credito= '"+n+"' AND (a.Estado=0 OR a.Estado=2)";
        mostrar(query);
        
        
        String query1="SELECT a.Id_desembolso,a.Id_credito,a.Monto,a.Fecha_commit,a.Hora_commit FROM TBL_DESEMBOLSO_CREDITO \n" +
                      "AS a inner join TBL_USUARIO AS b on a.Id_usuario = b.Id_usuario inner join TBL_CREDITO AS c on \n" +
                      "a.Id_credito = c.Id_credito where a.Id_credito = '"+n+"' AND c.Estado=1";
        mostrar2(query1);
        
       
       
       }
       
       if(e.getSource()==btnReporte){
           String carre = txtIdCredito.getText();
            Conexion g = new Conexion();
           g.Conectar();
           try{
               String url = System.getProperty("user.dir");
               // String ruta = url+"/src/reportes/ReporteEspecificoAlum.jasper";
               String ruta = "/reportes/ReporteAbonoCredito.jasper";
               
               Map parametro = new HashMap();
               parametro.put("id",carre);
               
               InputStream rutaJasper =  frmMostrarCredito.class.getResourceAsStream(ruta);
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
    
    
    private void calcularTotalAbonos() {
        float total = 0;
            if(tblDatosA.getRowCount()>0){
                for (int i = 0; i < tblDatosA.getRowCount(); i++) {
                    total = total + Float.parseFloat(tblDatosA.getValueAt(i, 5).toString());
                   
                }
                txtTotal.setText(Float.toString(total));
            }    
    }
    private void mostrar(String buscar){    
        try {
            modelo = funcion.mostrarAbono(buscar);
            tblDatosA.setModel(modelo);
            
            //txtTotal.setText("    " + Integer.toString(funcion.totalRegistros)); 
            ocultarColumnas(tblDatosA,1);
            //ocultarColumnas(tblDatosA,0);
            //ocultarColumnas(tblDatosA,3);
            //ocultarColumnas(tblDatosA,4);
            //ocultarColumnas(tblDatosA,5);
            //ocultarColumnas(tblDatosA,6);
            //ocultarColumnas(tblDatosA,7);
            //ocultarColumnas(tblDatosA,8);
            //ocultarColumnas(tblDatosA,9);
            
             calcularTotalAbonos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos, motivo: "+ e);
        }
        
    }
    
    private void mostrar2(String buscar){
    
    try {
            modelo = funcion.mostrarDesembolso(buscar);
            tblDatos.setModel(modelo);
            
            txtTotal1.setText("    " + Integer.toString(funcion.totalRegistrosB)); 
            ocultarColumnas(tblDatos,1);
            //ocultarColumnas(tblDatosA,0);
            //ocultarColumnas(tblDatosA,3);
            //ocultarColumnas(tblDatosA,4);
            //ocultarColumnas(tblDatosA,5);
            //ocultarColumnas(tblDatosA,6);
            //ocultarColumnas(tblDatosA,7);
            //ocultarColumnas(tblDatosA,8);
            //ocultarColumnas(tblDatosA,9);
            
             calcularTotalAbonos();
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
    
    private void buscarAbonoCredito(String textoBuscar){
     
     if(rbId.isSelected()==true){
         
         mostrar("SELECT a.Id_abono,a.Id_credito,a.Capital,a.Mora,a.Interes,a.Total_monto,a.Forma_pago,a.Fecha_commit,a.Hora_commit \n" +
                 "FROM TBL_ABONO_CREDITO AS a where (a.Id_credito like '%"+textoBuscar+"%') AND (a.Estado=0 OR a.Estado=2)");

     }
    
        mostrar2("SELECT a.Id_desembolso,a.Id_credito,a.Monto,a.Fecha_commit,a.Hora_commit FROM TBL_DESEMBOLSO_CREDITO \n" +
                      "AS a inner join TBL_USUARIO AS b on a.Id_usuario = b.Id_usuario inner join TBL_CREDITO AS c on \n" +
                      "a.Id_credito = c.Id_credito where (a.Id_credito like '%"+textoBuscar+"%') and c.Estado=1");
        
    
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBase = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlIndex = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnReporte = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        rbId = new javax.swing.JRadioButton();
        btnActualizar = new javax.swing.JButton();
        rbId1 = new javax.swing.JRadioButton();
        txtNombre = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNCredito = new javax.swing.JTextField();
        lblNombre2 = new javax.swing.JLabel();
        txtDpi = new javax.swing.JTextField();
        lblNombre3 = new javax.swing.JLabel();
        btnInformacion = new javax.swing.JButton();
        lblNombre8 = new javax.swing.JLabel();
        txtCapital = new javax.swing.JTextField();
        lblNombre9 = new javax.swing.JLabel();
        txtInteres = new javax.swing.JTextField();
        lblNombre7 = new javax.swing.JLabel();
        txtPlazo = new javax.swing.JTextField();
        lblNombre4 = new javax.swing.JLabel();
        txtCorte = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        txtPago = new javax.swing.JTextField();
        lblNombre5 = new javax.swing.JLabel();
        txtMora = new javax.swing.JTextField();
        lblNombre10 = new javax.swing.JLabel();
        lblNombre11 = new javax.swing.JLabel();
        lblNombre12 = new javax.swing.JLabel();
        txtMontoTotal = new javax.swing.JTextField();
        txtMontoPagado = new javax.swing.JTextField();
        txtMontoRestante = new javax.swing.JTextField();
        btnGarantia = new javax.swing.JButton();
        txtGarantia = new javax.swing.JTextField();
        lblNombre6 = new javax.swing.JLabel();
        txtNCuenta = new javax.swing.JTextField();
        lblNombre13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDatosA = new javax.swing.JTable();
        btnactualizarabono = new javax.swing.JButton();
        txtTotal1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnReporte1 = new javax.swing.JButton();
        txtIdCredito = new javax.swing.JTextField();
        txtIdCuenta = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);

        pnlBase.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel1.setText("Detalles del credito");

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
        rbId.setText("Transacción de Abonos");
        rbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbIdActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnActualizar.setText("Actualizar");

        rbId1.setBackground(new java.awt.Color(255, 255, 255));
        rbId1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbId1.setText("Transacción de Desembolsos");
        rbId1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbId1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbId1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(28, 28, 28)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbId)
                            .addComponent(rbId1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnActualizar)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        txtNombre.setEditable(false);

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre.setText("Cliente");

        txtNCredito.setEditable(false);
        txtNCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNCreditoActionPerformed(evt);
            }
        });

        lblNombre2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre2.setText("No. Credito");

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
        lblNombre8.setText("Capital");

        txtCapital.setEditable(false);

        lblNombre9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre9.setText("Interes Mensual");

        txtInteres.setEditable(false);

        lblNombre7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre7.setText("Plazo");

        txtPlazo.setEditable(false);

        lblNombre4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre4.setText("Fecha de corte");

        txtCorte.setEditable(false);

        lblNombre1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre1.setText("Fecha de pagos");

        txtPago.setEditable(false);

        lblNombre5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre5.setText("Tasa de mora");

        txtMora.setEditable(false);

        lblNombre10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre10.setText("Monto Total");

        lblNombre11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre11.setText("Monto Pagado");

        lblNombre12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre12.setText("Monto Restante");

        txtMontoTotal.setEditable(false);

        txtMontoPagado.setEditable(false);

        txtMontoRestante.setEditable(false);

        btnGarantia.setBackground(new java.awt.Color(255, 255, 255));
        btnGarantia.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnGarantia.setText("Ver Garantía");

        txtGarantia.setEditable(false);

        lblNombre6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre6.setText("Garantía");

        txtNCuenta.setEditable(false);
        txtNCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNCuentaActionPerformed(evt);
            }
        });

        lblNombre13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre13.setText("No. Cuenta");

        tblDatosA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblDatosA.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDatosA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatosAMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDatosA);

        btnactualizarabono.setText("jButton1");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Total de Desembolsos");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setText("Desembolsos");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel6.setText("Abonos");

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIndexLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlIndexLayout.createSequentialGroup()
                        .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlIndexLayout.createSequentialGroup()
                                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNombre)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIndexLayout.createSequentialGroup()
                                            .addComponent(txtGarantia)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lblNombre)
                                        .addGroup(pnlIndexLayout.createSequentialGroup()
                                            .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtNCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblNombre2))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblNombre13)
                                                .addComponent(txtNCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblNombre3)
                                                .addGroup(pnlIndexLayout.createSequentialGroup()
                                                    .addComponent(txtDpi, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(btnInformacion)))))
                                    .addComponent(lblNombre6))
                                .addGap(18, 18, 18)
                                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlIndexLayout.createSequentialGroup()
                                        .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlIndexLayout.createSequentialGroup()
                                                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblNombre8)
                                                    .addComponent(lblNombre4))
                                                .addGap(34, 34, 34))
                                            .addComponent(txtMontoTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlIndexLayout.createSequentialGroup()
                                                .addGap(139, 139, 139)
                                                .addComponent(lblNombre1))
                                            .addGroup(pnlIndexLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(pnlIndexLayout.createSequentialGroup()
                                                        .addComponent(lblNombre11)
                                                        .addGap(43, 43, 43)
                                                        .addComponent(lblNombre12))
                                                    .addGroup(pnlIndexLayout.createSequentialGroup()
                                                        .addComponent(txtMontoPagado, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtMontoRestante, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(btnactualizarabono))))))
                                    .addGroup(pnlIndexLayout.createSequentialGroup()
                                        .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblNombre10, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtCorte, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlIndexLayout.createSequentialGroup()
                                                    .addComponent(txtInteres, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblNombre9)
                                                        .addComponent(txtCapital)))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtPago)
                                            .addGroup(pnlIndexLayout.createSequentialGroup()
                                                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblNombre7))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblNombre5)
                                                    .addComponent(txtMora, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                            .addGroup(pnlIndexLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReporte)
                                .addGap(388, 388, 388)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReporte1)))
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addGroup(pnlIndexLayout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlIndexLayout.createSequentialGroup()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 521, Short.MAX_VALUE)))
        );
        pnlIndexLayout.setVerticalGroup(
            pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIndexLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlIndexLayout.createSequentialGroup()
                        .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlIndexLayout.createSequentialGroup()
                                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlIndexLayout.createSequentialGroup()
                                        .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblNombre2)
                                            .addComponent(lblNombre3)
                                            .addComponent(lblNombre13))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtNCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDpi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblNombre))
                                    .addComponent(lblNombre1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCorte, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlIndexLayout.createSequentialGroup()
                                .addComponent(lblNombre8)
                                .addGap(45, 45, 45)
                                .addComponent(lblNombre4)
                                .addGap(38, 38, 38)))
                        .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre10)
                            .addComponent(lblNombre11)
                            .addComponent(lblNombre12)
                            .addComponent(lblNombre6)))
                    .addGroup(pnlIndexLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlIndexLayout.createSequentialGroup()
                                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNombre9)
                                    .addComponent(lblNombre5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtInteres, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMora, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCapital, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlIndexLayout.createSequentialGroup()
                                .addComponent(lblNombre7)
                                .addGap(38, 38, 38)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMontoPagado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMontoRestante, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnactualizarabono))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnReporte)
                        .addComponent(jLabel6))
                    .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(btnReporte1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
            .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIndexLayout.createSequentialGroup()
                    .addContainerGap(336, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(60, 60, 60)))
        );

        txtIdCredito.setEditable(false);
        txtIdCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCreditoActionPerformed(evt);
            }
        });

        txtIdCuenta.setEditable(false);
        txtIdCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCuentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBaseLayout = new javax.swing.GroupLayout(pnlBase);
        pnlBase.setLayout(pnlBaseLayout);
        pnlBaseLayout.setHorizontalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlBaseLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 22, Short.MAX_VALUE))
        );
        pnlBaseLayout.setVerticalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlIndex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnlBase, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBuscarCaretUpdate
        //buscar();
        buscarAbonoCredito(txtBuscar.getText());
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

    private void txtNCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNCreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNCreditoActionPerformed

    private void txtDpiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDpiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDpiActionPerformed

    private void txtIdCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCreditoActionPerformed

    private void txtNCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNCuentaActionPerformed

    private void txtIdCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCuentaActionPerformed

    private void tblDatosAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosAMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDatosAMouseClicked

    private void rbId1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbId1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbId1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGarantia;
    private javax.swing.JButton btnInformacion;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnReporte1;
    public static javax.swing.JButton btnactualizarabono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre10;
    private javax.swing.JLabel lblNombre11;
    private javax.swing.JLabel lblNombre12;
    private javax.swing.JLabel lblNombre13;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombre4;
    private javax.swing.JLabel lblNombre5;
    private javax.swing.JLabel lblNombre6;
    private javax.swing.JLabel lblNombre7;
    private javax.swing.JLabel lblNombre8;
    private javax.swing.JLabel lblNombre9;
    private javax.swing.JPanel pnlBase;
    private javax.swing.JPanel pnlIndex;
    private javax.swing.JRadioButton rbId;
    private javax.swing.JRadioButton rbId1;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTable tblDatosA;
    private javax.swing.JTextField txtBuscar;
    public static javax.swing.JTextField txtCapital;
    public static javax.swing.JTextField txtCorte;
    public static javax.swing.JTextField txtDpi;
    public static javax.swing.JTextField txtGarantia;
    public static javax.swing.JTextField txtIdCredito;
    public static javax.swing.JTextField txtIdCuenta;
    public static javax.swing.JTextField txtInteres;
    public static javax.swing.JTextField txtMontoPagado;
    public static javax.swing.JTextField txtMontoRestante;
    public static javax.swing.JTextField txtMontoTotal;
    public static javax.swing.JTextField txtMora;
    public static javax.swing.JTextField txtNCredito;
    public static javax.swing.JTextField txtNCuenta;
    public static javax.swing.JTextField txtNombre;
    public static javax.swing.JTextField txtPago;
    public static javax.swing.JTextField txtPlazo;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotal1;
    // End of variables declaration//GEN-END:variables

    
}
