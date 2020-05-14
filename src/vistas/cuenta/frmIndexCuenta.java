/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.cuenta;

import controladores.Conexion;
import controladores.FCuenta;
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
import vistas.credito.frmNuevoCredito;
import static vistas.frmEscritorio.dpnlEscritorio;
import vistas.sucursal.frmIndexSucursal;

/**
 *
 * @author Alejandro
 */
public class frmIndexCuenta extends javax.swing.JInternalFrame implements ActionListener{

   
    String categoria;
    DefaultTableModel modelo;
    FCuenta funcion = new FCuenta();
    
    String query = "SELECT CUENTA.Id_cuenta, \n" +
                    "CUENTA.Numero_cuenta, \n" +
                    "CLI.Primer_nombre+' '+CLI.Primer_apellido AS CLIENTE,\n" +
                    "TIPO.Clase, CUENTA.Fecha_apertura\n" +
                    "FROM TBL_CUENTA AS CUENTA \n" +
                    "JOIN TBL_CLIENTE AS CLI ON CUENTA.Id_cliente = CLI.Id_cliente\n" +
                    "JOIN TBL_TIPO_SOCIO AS TIPO ON TIPO.Id_tipo_socio = CUENTA.Id_tipo_socio";
                 
    
    public frmIndexCuenta() {
        initComponents();
        mostrar(query);
        ButtonGroup grupoBuscar = new ButtonGroup();
        grupoBuscar.add(rbId);
        grupoBuscar.add(rbNombre);
        rbId.setSelected(true);
        
        btnReporte.addActionListener(this);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==btnReporte){
        
          if(categoria.equals("Tipo de Reporte")==true){
             JOptionPane.showMessageDialog(null,"Seleccione un tipo de reporte"); 
             
        }else if(categoria.equals("Conyuge")==true){
        ReporteConyugue();
        
        }else if(categoria.equals("Tipo de Socio")==true){
        
        ReporteSocio();
        }else if(categoria.equals("Fecha de Nacimiento")==true){
        
        ReporteFecha();
        }
        
        }
        
        
        
    }
    
    private void mostrar(String buscar){    
        try {
            modelo = funcion.mostrarCuentas(buscar);
            tblDatos.setModel(modelo);
            txtTotal.setText("    " + Integer.toString(funcion.totalRegistros));   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos, motivo: "+ e);
        }
    }
    
    private void buscar(String textoBuscar){
        
        if(rbId.isSelected()==true){
            mostrar("SELECT CUENTA.Id_cuenta, \n" +
                "CUENTA.Numero_cuenta, \n" +
                "CLI.Primer_nombre+' '+CLI.Primer_apellido AS CLIENTE,\n" +
                "TIPO.Clase, CUENTA.Fecha_apertura\n" +
                "FROM TBL_CUENTA AS CUENTA \n" +
                "JOIN TBL_CLIENTE AS CLI ON CUENTA.Id_cliente = CLI.Id_cliente\n" +
                "JOIN TBL_TIPO_SOCIO AS TIPO ON TIPO.Id_tipo_socio = CUENTA.Id_tipo_socio\n" +
                "WHERE (Numero_cuenta LIKE '%"+textoBuscar+"%') AND CUENTA.Estado = 1");
        }else{
            mostrar("SELECT CUENTA.Id_cuenta, \n" +
                "CUENTA.Numero_cuenta, \n" +
                "CLI.Primer_nombre+' '+CLI.Primer_apellido AS CLIENTE,\n" +
                "TIPO.Clase, CUENTA.Fecha_apertura\n" +
                "FROM TBL_CUENTA AS CUENTA \n" +
                "JOIN TBL_CLIENTE AS CLI ON CUENTA.Id_cliente = CLI.Id_cliente\n" +
                "JOIN TBL_TIPO_SOCIO AS TIPO ON TIPO.Id_tipo_socio = CUENTA.Id_tipo_socio\n" +
                "WHERE (CLI.Primer_nombre LIKE '%"+textoBuscar+"%' OR CLI.Primer_apellido LIKE '%"+textoBuscar+"%') AND CUENTA.Estado = 1");
        }
    }
    
    private void ocultarColumnas(JTable tabla, int columna){
        tabla.getColumnModel().getColumn(columna).setMaxWidth(0);
        tabla.getColumnModel().getColumn(columna).setMinWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(columna).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(columna).setMinWidth(0);
    }
    
    
     public void ReporteConyugue(){
     
      Conexion g = new Conexion();
        g.Conectar();
      
        try{
          
        String url= System.getProperty("user.dir");
        // String ruta = url+"/src/reportes/ReporteGeneral.jasper";
        String ruta = "/reportes/ReporteConyuge.jasper";
        
        g.Conectar();
        
        InputStream rutaJasper =  frmIndexCuenta.class.getResourceAsStream(ruta);
        JasperReport reporte = (JasperReport) JRLoader.loadObject(rutaJasper);
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, g.getConexion());
        
        
        JasperViewer viewer = new JasperViewer(jasperPrint,false);
        //viewer.setTitle("Reporte UMG");
        viewer.setVisible(true);
         
        
        }catch(Exception ex){
         
         System.out.println("Error de reporte"+ex.getMessage());
         
     }
     
     }
     
     public void ReporteFecha(){
     
     Conexion g = new Conexion();
        g.Conectar();
      
        try{
          
        String url= System.getProperty("user.dir");
        // String ruta = url+"/src/reportes/ReporteGeneral.jasper";
        String ruta = "/reportes/ReporteFecha.jasper";
        
        g.Conectar();
        
        InputStream rutaJasper =  frmIndexCuenta.class.getResourceAsStream(ruta);
        JasperReport reporte = (JasperReport) JRLoader.loadObject(rutaJasper);
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, g.getConexion());
        
        
        JasperViewer viewer = new JasperViewer(jasperPrint,false);
        //viewer.setTitle("Reporte UMG");
        viewer.setVisible(true);
         
        
        }catch(Exception ex){
         
         System.out.println("Error de reporte"+ex.getMessage());
         
     }
     
     }
     
     public void ReporteSocio(){
     
    Conexion g = new Conexion();
        g.Conectar();
      
        try{
          
        String url= System.getProperty("user.dir");
        // String ruta = url+"/src/reportes/ReporteGeneral.jasper";
        String ruta = "/reportes/ReporteTipodeSocio.jasper";
        
        g.Conectar();
        
        InputStream rutaJasper =  frmIndexCuenta.class.getResourceAsStream(ruta);
        JasperReport reporte = (JasperReport) JRLoader.loadObject(rutaJasper);
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, g.getConexion());
        
        
        JasperViewer viewer = new JasperViewer(jasperPrint,false);
        //viewer.setTitle("Reporte UMG");
        viewer.setVisible(true);
         
        
        }catch(Exception ex){
         
         System.out.println("Error de reporte"+ex.getMessage());
         
     }
    
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        rbNombre = new javax.swing.JRadioButton();
        rbId = new javax.swing.JRadioButton();
        pnlIndex = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnReporte = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        cbReporte = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        pnlBase.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel1.setText("Cuentas");

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

        rbNombre.setBackground(new java.awt.Color(255, 255, 255));
        rbNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbNombre.setText("Cliente");

        rbId.setBackground(new java.awt.Color(255, 255, 255));
        rbId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbId.setText("Número de Cuenta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbNombre))
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbNombre)
                    .addComponent(rbId)))
        );

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
        jLabel2.setText("Total de Registros");

        javax.swing.GroupLayout pnlIndexLayout = new javax.swing.GroupLayout(pnlIndex);
        pnlIndex.setLayout(pnlIndexLayout);
        pnlIndexLayout.setHorizontalGroup(
            pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIndexLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
        );
        pnlIndexLayout.setVerticalGroup(
            pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIndexLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        btnReporte.setBackground(new java.awt.Color(255, 255, 255));
        btnReporte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnReporte.setText("Reporte");

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnActualizar.setText("Actualizar");

        cbReporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de Reporte", "Conyuge", "Tipo de Socio", "Fecha de Nacimiento" }));
        cbReporte.setMinimumSize(new java.awt.Dimension(97, 23));
        cbReporte.setPreferredSize(new java.awt.Dimension(97, 23));
        cbReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbReporteActionPerformed(evt);
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
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlBaseLayout.createSequentialGroup()
                        .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlIndex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBaseLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27))))
        );
        pnlBaseLayout.setVerticalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReporte, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlBaseLayout.createSequentialGroup()
                        .addComponent(cbReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlIndex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnlBase, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBuscarCaretUpdate
        buscar(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarCaretUpdate

    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked
        int posicion = tblDatos.getSelectedRow();
        frmMostrarCuenta frmMostrar = new frmMostrarCuenta(tblDatos.getValueAt(posicion,0).toString());
        dpnlEscritorio.add(frmMostrar);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmMostrar.getSize();
        frmMostrar.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmMostrar.setVisible(true);
        
        

    }//GEN-LAST:event_tblDatosMouseClicked

    private void cbReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbReporteActionPerformed
        // TODO add your handling code here:
        categoria = (String) cbReporte.getSelectedItem();
    }//GEN-LAST:event_cbReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JComboBox<String> cbReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlBase;
    private javax.swing.JPanel pnlIndex;
    private javax.swing.JRadioButton rbId;
    private javax.swing.JRadioButton rbNombre;
    public static javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
