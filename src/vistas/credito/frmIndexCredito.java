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
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vistas.abonoCredito.frmMostrarAbonos;
import vistas.cliente.frmIndexCliente;
import static vistas.credito.frmMostrarCredito.btnactualizarabono;
import vistas.desembolsoCredito.frmNuevoDesembolso;
import static vistas.frmEscritorio.dpnlEscritorio;

/**
 *
 * @author Alejandro
 */
public class frmIndexCredito extends javax.swing.JInternalFrame implements ActionListener{

    DefaultTableModel modelo;
    FCredito funcion = new FCredito();
    String query ="SELECT a.Id_credito,a.Numero_credito,b.Numero_cuenta,a.Id_cuenta,CONCAT(c.Primer_nombre,' ',c.Segundo_nombre,' ',c.Primer_apellido,' ',c.Segundo_apellido),\n" +
                  "c.Dpi,u.descripcion,j.Nombre_garantia,m.NIckname,CONCAT(e.Primer_nombre,' ',e.Primer_apellido),a.Monto,a.Interes,a.Capital,a.Pagado,a.Capital-a.Pagado,a.Plazo,a.Mora,a.Fecha_pago,a.Fecha_corte\n" +
                   " FROM TBL_CREDITO AS a inner join TBL_CUENTA AS b on a.Id_cuenta = b.Id_cuenta inner join TBL_CLIENTE AS c on b.Id_cliente = c.Id_cliente inner join TBL_USUARIO AS m \n" +
                   "on a.Id_usuario = m.Id_usuario inner join TBL_EMPLEADO AS e on m.Id_empleado=e.Id_empleado inner join TBL_GARANTIA AS u on a.Id_garantia = u.Id_garantia\n" +
                    "inner join TBL_TIPO_GARANTIA AS j on u.Id_tipo_garantia = j.Id_tipo_garantia WHERE a.Estado =1";
    
    int opcion;
    public frmIndexCredito(int opcionr) {
        initComponents();
        opcion = opcionr;
        if(opcion == 1){
            titulo.setText("Creditos");
        }else if(opcion==2 || opcion ==3){
            titulo.setText("Selecionar Credito");
        }
        mostrar(query);
        ButtonGroup grupoBuscar = new ButtonGroup();
        grupoBuscar.add(rbCuente);
        grupoBuscar.add(rbNombre);
        rbCuente.setSelected(true);
        
        btnNuevo.addActionListener(this);
        btnBuscar.addActionListener(this);
        btnActualizar.addActionListener(this);
        btnReporte.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnNuevo){
            frmNuevoCredito frmNuevo = new frmNuevoCredito();
            dpnlEscritorio.add(frmNuevo);
            Dimension desktopSize = dpnlEscritorio.getSize();
            Dimension FrameSize = frmNuevo.getSize();
            frmNuevo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            frmNuevo.setVisible(true);
        }
        
         if(e.getSource()== btnActualizar){
          //mostrar(query);
           actualizar();
        }
        
        if(e.getSource()==btnReporte){
            Reporte();
        }
    }
    
    private void mostrar(String buscar){ 
    
    try{
    
    if(opcion == 1){
    modelo = funcion.mostrarCredito(buscar);
    tblDatos.setModel(modelo);
    txtTotal.setText("    " + Integer.toString(funcion.totalRegistros)); 
    
    ocultarColumnas(tblDatos,3);
    ocultarColumnas(tblDatos,6);
    ocultarColumnas(tblDatos,8);
    /*ocultarColumnas(tblDatos,6);
    ocultarColumnas(tblDatos,8);
    ocultarColumnas(tblDatos,9);
    ocultarColumnas(tblDatos,10);
    ocultarColumnas(tblDatos,11);
    */
    }
    if(opcion == 2 || opcion ==3){
        
        modelo = funcion.mostrarCredito(buscar);
        tblDatos.setModel(modelo);
        txtTotal.setText("    " + Integer.toString(funcion.totalRegistros)); 

        ocultarColumnas(tblDatos,3);
        ocultarColumnas(tblDatos,6);
        ocultarColumnas(tblDatos,8);
        ocultarColumnas(tblDatos,6);
        ocultarColumnas(tblDatos,7);
        ocultarColumnas(tblDatos,8);
        ocultarColumnas(tblDatos,9);
        ocultarColumnas(tblDatos,10);
        ocultarColumnas(tblDatos,11);
        ocultarColumnas(tblDatos,12);
        ocultarColumnas(tblDatos,13);
        ocultarColumnas(tblDatos,14);
        ocultarColumnas(tblDatos,15);
        ocultarColumnas(tblDatos,16);
        ocultarColumnas(tblDatos,17);
        ocultarColumnas(tblDatos,18);
        TableColumnModel columna = tblDatos.getColumnModel();
        columna.getColumn(0).setPreferredWidth(50);
        columna.getColumn(0).setMaxWidth(50);
        columna.getColumn(0).setMinWidth(50);
        columna.getColumn(1).setPreferredWidth(150);
        columna.getColumn(1).setMaxWidth(150);
        columna.getColumn(1).setMinWidth(150);
        columna.getColumn(2).setPreferredWidth(150);
        columna.getColumn(2).setMaxWidth(150);
        columna.getColumn(2).setMinWidth(150);
        columna.getColumn(5).setPreferredWidth(150);
        columna.getColumn(5).setMaxWidth(150);
        columna.getColumn(5).setMinWidth(150);
    
    }
    
    }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos, motivo: "+ e);
        }
    
    
    }
    
    private void buscarCredito(String textoBuscar){
     
     if(rbCuente.isSelected()==true){
     
     
       mostrar("SELECT a.Id_credito,a.Numero_credito,b.Numero_cuenta,a.Id_cuenta,CONCAT(c.Primer_nombre,' ',c.Segundo_nombre,' ',c.Primer_apellido,' ',c.Segundo_apellido),\n" +
                  "c.Dpi,u.descripcion,j.Nombre_garantia,m.NIckname,CONCAT(e.Primer_nombre,' ',e.Primer_apellido),a.Monto,a.Interes,a.Capital,a.Pagado,a.Capital-a.Pagado,a.Plazo,a.Mora,a.Fecha_pago,a.Fecha_corte\n" +
                   " FROM TBL_CREDITO AS a inner join TBL_CUENTA AS b on a.Id_cuenta = b.Id_cuenta inner join TBL_CLIENTE AS c on b.Id_cliente = c.Id_cliente inner join TBL_USUARIO AS m \n" +
                   "on a.Id_usuario = m.Id_usuario inner join TBL_EMPLEADO AS e on m.Id_empleado=e.Id_empleado inner join TBL_GARANTIA AS u on a.Id_garantia = u.Id_garantia\n" +
                    "inner join TBL_TIPO_GARANTIA AS j on u.Id_tipo_garantia = j.Id_tipo_garantia  WHERE (a.Numero_credito like '%"+textoBuscar+"%') and a.Estado=1 ");
     }else{
         
         
      mostrar("SELECT a.Id_credito,a.Numero_credito,b.Numero_cuenta,a.Id_cuenta,CONCAT(c.Primer_nombre,' ',c.Segundo_nombre,' ',c.Primer_apellido,' ',c.Segundo_apellido),\n" +
                  "c.Dpi,u.descripcion,j.Nombre_garantia,m.NIckname,CONCAT(e.Primer_nombre,' ',e.Primer_apellido),a.Monto,a.Interes,a.Capital,a.Pagado,a.Capital-a.Pagado,a.Plazo,a.Mora,a.Fecha_pago,a.Fecha_corte\n" +
                   " FROM TBL_CREDITO AS a inner join TBL_CUENTA AS b on a.Id_cuenta = b.Id_cuenta inner join TBL_CLIENTE AS c on b.Id_cliente = c.Id_cliente inner join TBL_USUARIO AS m \n" +
                   "on a.Id_usuario = m.Id_usuario inner join TBL_EMPLEADO AS e on m.Id_empleado=e.Id_empleado inner join TBL_GARANTIA AS u on a.Id_garantia = u.Id_garantia\n" +
                    "inner join TBL_TIPO_GARANTIA AS j on u.Id_tipo_garantia = j.Id_tipo_garantia WHERE (CONCAT(c.Primer_nombre,' ',c.Segundo_nombre,' ',c.Primer_apellido,' ',c.Segundo_apellido) like '%"+textoBuscar+"%') and a.Estado=1 ");   
     
     
     }
    
    
    }
    
    private void ocultarColumnas(JTable tabla, int columna){
        
        tabla.getColumnModel().getColumn(columna).setMaxWidth(0);
        tabla.getColumnModel().getColumn(columna).setMinWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(columna).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(columna).setMinWidth(0);
    }
    
     private void actualizar(){
        mostrar(query);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBase = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        rbCuente = new javax.swing.JRadioButton();
        rbNombre = new javax.swing.JRadioButton();
        pnlIndex = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        pnlBase.setBackground(new java.awt.Color(255, 255, 255));
        pnlBase.setPreferredSize(new java.awt.Dimension(999, 652));

        titulo.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        titulo.setText("Creditos");

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

        rbCuente.setBackground(new java.awt.Color(255, 255, 255));
        rbCuente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbCuente.setText("Numero de Credito");

        rbNombre.setBackground(new java.awt.Color(255, 255, 255));
        rbNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbNombre.setText("Nombre del Cliente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbCuente))
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
                    .addComponent(rbCuente)
                    .addComponent(rbNombre)))
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
        );
        pnlIndexLayout.setVerticalGroup(
            pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIndexLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevo.setText("Nuevo Credito");

        btnReporte.setBackground(new java.awt.Color(255, 255, 255));
        btnReporte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnReporte.setText("Reporte");

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnActualizar.setText("Actualizar");

        javax.swing.GroupLayout pnlBaseLayout = new javax.swing.GroupLayout(pnlBase);
        pnlBase.setLayout(pnlBaseLayout);
        pnlBaseLayout.setHorizontalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBaseLayout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLayout.createSequentialGroup()
                        .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlIndex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBaseLayout.createSequentialGroup()
                                .addComponent(titulo)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27))))
        );
        pnlBaseLayout.setVerticalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnReporte)
                    .addComponent(btnActualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlIndex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnlBase, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBuscarCaretUpdate
        //buscar();
        //buscar(txtBuscar.getText());
        buscarCredito(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarCaretUpdate

    public void Reporte(){
         
         Conexion g = new Conexion();
        g.Conectar();
      
        try{
          
            String url= System.getProperty("user.dir");
        // String ruta = url+"/src/reportes/ReporteGeneral.jasper";
        String ruta = "/reportes/ReporteCreditos.jasper";
        
        g.Conectar();
        
        InputStream rutaJasper =  frmIndexCredito.class.getResourceAsStream(ruta);
        JasperReport reporte = (JasperReport) JRLoader.loadObject(rutaJasper);
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, g.getConexion());
        
        JasperViewer viewer = new JasperViewer(jasperPrint,false);
        //viewer.setTitle("Reporte UMG");
        viewer.setVisible(true);
            
        }catch(Exception ex){
         
         System.out.println("Error de reporte"+ex.getMessage());
         
     }
        
     }
    
    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked
        if(opcion == 1){
        frmMostrarCredito frmMostrar = new frmMostrarCredito();
        dpnlEscritorio.add(frmMostrar);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmMostrar.getSize();
        frmMostrar.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmMostrar.setVisible(true);

        int posicion = tblDatos.getSelectedRow();
        frmMostrarCredito.txtIdCredito.setText(tblDatos.getValueAt(posicion,0).toString());
        frmMostrarCredito.txtIdCuenta.setText(tblDatos.getValueAt(posicion,3).toString());
        frmMostrarCredito.txtNCredito.setText(tblDatos.getValueAt(posicion,1).toString());
        frmMostrarCredito.txtNCuenta.setText(tblDatos.getValueAt(posicion,2).toString());
        frmMostrarCredito.txtDpi.setText(tblDatos.getValueAt(posicion,5).toString());
        frmMostrarCredito.txtNombre.setText(tblDatos.getValueAt(posicion,4).toString());
        frmMostrarCredito.txtGarantia.setText(tblDatos.getValueAt(posicion,6).toString());
        frmMostrarCredito.txtInteres.setText(tblDatos.getValueAt(posicion,12).toString());
        frmMostrarCredito.txtCapital.setText(tblDatos.getValueAt(posicion,11).toString());
        frmMostrarCredito.txtPlazo.setText(tblDatos.getValueAt(posicion,15).toString());
        frmMostrarCredito.txtMora.setText(tblDatos.getValueAt(posicion,16).toString());
        frmMostrarCredito.txtCorte.setText(tblDatos.getValueAt(posicion,18).toString());
        frmMostrarCredito.txtPago.setText(tblDatos.getValueAt(posicion,17).toString());
        frmMostrarCredito.txtMontoTotal.setText(tblDatos.getValueAt(posicion,10).toString());
        frmMostrarCredito.txtMontoPagado.setText(tblDatos.getValueAt(posicion,13).toString());
        frmMostrarCredito.txtMontoRestante.setText(tblDatos.getValueAt(posicion,14).toString()); btnactualizarabono.doClick();
        }
        
        if(opcion ==2){
        int posicion = tblDatos.getSelectedRow();
        frmMostrarAbonos frmMostrar = new frmMostrarAbonos(Integer.parseInt(tblDatos.getValueAt(posicion,0).toString()));
        dpnlEscritorio.add(frmMostrar);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmMostrar.getSize();
        frmMostrar.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmMostrar.setVisible(true);

   
        
        frmMostrarAbonos.txtIdCuenta.setText(tblDatos.getValueAt(posicion,3).toString());
        frmMostrarAbonos.txtNCredito.setText(tblDatos.getValueAt(posicion,1).toString());
        frmMostrarAbonos.txtNCuenta.setText(tblDatos.getValueAt(posicion,2).toString());
        frmMostrarAbonos.txtDpi.setText(tblDatos.getValueAt(posicion,5).toString());
        frmMostrarAbonos.txtNombre.setText(tblDatos.getValueAt(posicion,4).toString());
      
        frmMostrarAbonos.txtInteres.setText(tblDatos.getValueAt(posicion,12).toString());
        frmMostrarAbonos.txtCapital.setText(tblDatos.getValueAt(posicion,11).toString());
        frmMostrarAbonos.txtPlazo.setText(tblDatos.getValueAt(posicion,15).toString());
        frmMostrarAbonos.txtMora.setText(tblDatos.getValueAt(posicion,16).toString());
        frmMostrarAbonos.txtCorte.setText(tblDatos.getValueAt(posicion,18).toString());
        frmMostrarAbonos.txtPago.setText(tblDatos.getValueAt(posicion,17).toString());
        frmMostrarAbonos.txtMontoTotal.setText(tblDatos.getValueAt(posicion,10).toString());
        frmMostrarAbonos.txtMontoPagado.setText(tblDatos.getValueAt(posicion,13).toString());
        frmMostrarAbonos.txtMontoRestante.setText(tblDatos.getValueAt(posicion,14).toString());
        }
        
        if(opcion ==3){
            
            int posicion = tblDatos.getSelectedRow();
            frmNuevoDesembolso frmMostrar = new frmNuevoDesembolso(Integer.parseInt(tblDatos.getValueAt(posicion,0).toString()),
            Float.parseFloat(tblDatos.getValueAt(posicion,10).toString()));
            dpnlEscritorio.add(frmMostrar);
            Dimension desktopSize = dpnlEscritorio.getSize();
            Dimension FrameSize = frmMostrar.getSize();
            frmMostrar.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            frmMostrar.setVisible(true);

            frmNuevoDesembolso.txtIdCuenta.setText(tblDatos.getValueAt(posicion,3).toString());
            frmNuevoDesembolso.txtNCredito.setText(tblDatos.getValueAt(posicion,1).toString());
            frmNuevoDesembolso.txtNCuenta.setText(tblDatos.getValueAt(posicion,2).toString());
            frmNuevoDesembolso.txtDpi.setText(tblDatos.getValueAt(posicion,5).toString());
            frmNuevoDesembolso.txtNombre.setText(tblDatos.getValueAt(posicion,4).toString());
     
            frmNuevoDesembolso.txtCapital.setText(tblDatos.getValueAt(posicion,10).toString());
           
 
        }
        
        
        
    }//GEN-LAST:event_tblDatosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnReporte;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlBase;
    private javax.swing.JPanel pnlIndex;
    private javax.swing.JRadioButton rbCuente;
    private javax.swing.JRadioButton rbNombre;
    private javax.swing.JTable tblDatos;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
