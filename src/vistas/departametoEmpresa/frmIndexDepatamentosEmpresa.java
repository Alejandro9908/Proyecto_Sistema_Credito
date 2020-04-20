/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.departametoEmpresa;

import controladores.Conexion;
import controladores.FDepartamentos_emp;
import vistas.departametoEmpresa.frmMostrarDepartamentoEmpresa;
import vistas.departametoEmpresa.frmNuevoDepartamentoEmpresa;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import static vistas.frmEscritorio.dpnlEscritorio;

/**
 *
 * @author Alejandro
 */
public class frmIndexDepatamentosEmpresa extends javax.swing.JInternalFrame implements ActionListener{

    DefaultTableModel modelo;
    FDepartamentos_emp funcion = new FDepartamentos_emp();
 
    
    String query = "SELECT Id_departamento_emp,Nombre_departamento,Descripcion,Estado, Fecha_commit, Hora_commit, Id_usuario FROM  TBL_DEPARTAMENTO_EMP WHERE Estado = 1";
    
    public frmIndexDepatamentosEmpresa() {
        initComponents();
        
        //CONDICIONES CADA VEZ QUE SE ABRE UNA VENTANA (SUPER IMPORTANTES)
        tblDatos.getTableHeader().setReorderingAllowed(false) ; //ESTO ES PARA QUE NO PERMITA MOVER LAS COLUMNAS, DE ALLI TOMO LOS DATOS
        
       
        
        ButtonGroup grupoBuscar = new ButtonGroup();
        grupoBuscar.add(rbId);
        grupoBuscar.add(rbNombre);
        rbNombre.setSelected(true); //prefiero que se busque por nombre por defecto
        mostrar(query);
        
        
        //======================================================================
        
        //Añadir los botones al ActionListener
        btnNuevoDep.addActionListener(this);
        btnActualizar.addActionListener(this);
        btnReporte.addActionListener(this);
        btnBuscar.addActionListener(this);
        
        
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnNuevoDep){
            frmNuevoDepartamentoEmpresa frmNuevoDep = new frmNuevoDepartamentoEmpresa();
            dpnlEscritorio.add(frmNuevoDep);
            Dimension desktopSize = dpnlEscritorio.getSize();
            Dimension FrameSize = frmNuevoDep.getSize();
            frmNuevoDep.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            frmNuevoDep.setVisible(true);
        }
        
        if(e.getSource()==btnActualizar){
            actualizar();
        }
        
        if(e.getSource()==btnReporte){
            
            Reporte();
            
        }
        
    }
    
    private void mostrar(String buscar){    
        try {
            modelo = funcion.mostrarDepartamento(buscar);
            
            tblDatos.setModel(modelo);
            txtTotal.setText("    " + Integer.toString(funcion.totalRegistros));
            
             ocultarColumnas(tblDatos,3); //para ocultar la columna del estado
             ocultarColumnas(tblDatos,4); //para ocultar la columna de Fecha de creacion
             ocultarColumnas(tblDatos,5); //para ocultar la columna de Hora de creacion
             ocultarColumnas(tblDatos,6); //para ocultar la columna del ID de Usuario que hizo eso
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos, motivo: "+ e);
        }
    }
    
    
    
     private void buscar(String textoBuscar){
        if(rbId.isSelected()==true){
            mostrar("SELECT Id_departamento_emp,Nombre_departamento,Descripcion,Estado, Fecha_commit, Hora_commit, Id_usuario FROM TBL_DEPARTAMENTO_EMP WHERE (Id_departamento_emp like '%"+textoBuscar+"%') AND Estado = 1");
        }else{
            //Si no es por ID entonces será por NOMBRE
           mostrar("SELECT Id_departamento_emp,Nombre_departamento,Descripcion,Estado, Fecha_commit, Hora_commit, Id_usuario FROM TBL_DEPARTAMENTO_EMP WHERE (Nombre_departamento like '%"+textoBuscar+"%') AND Estado = 1");
        }   
    }
     
     
      //ESTE METODO SIRVE PARA OCULTAR COLUMNAS QUE NO QUERAMOS QUE SE VEAN, PERO SUS DATOS SI SON UTILIZABLES
     private void ocultarColumnas(JTable tabla, int columna){
        tabla.getColumnModel().getColumn(columna).setMaxWidth(0);
        tabla.getColumnModel().getColumn(columna).setMinWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(columna).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(columna).setMinWidth(0);
    }
     
     public void Reporte(){
         
         Conexion g = new Conexion();
        g.Conectar();
      
        try{
          
            String url= System.getProperty("user.dir");
        // String ruta = url+"/src/reportes/ReporteGeneral.jasper";
        String ruta = "/reportes/ReporteDepartamentos.jasper";
        
        g.Conectar();
        
        InputStream rutaJasper =  frmIndexDepatamentosEmpresa.class.getResourceAsStream(ruta);
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
        btnNuevoDep = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        pnlBase.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel1.setText("Departamentos de empresa");

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
        rbNombre.setText("Nombre");

        rbId.setBackground(new java.awt.Color(255, 255, 255));
        rbId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbId.setText("Id");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(808, Short.MAX_VALUE)
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
            .addComponent(jScrollPane1)
        );
        pnlIndexLayout.setVerticalGroup(
            pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIndexLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        btnNuevoDep.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevoDep.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevoDep.setText("Nuevo Departamento");

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
                        .addComponent(btnNuevoDep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLayout.createSequentialGroup()
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
                    .addComponent(btnNuevoDep)
                    .addComponent(btnReporte)
                    .addComponent(btnActualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlIndex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        getContentPane().add(pnlBase, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBuscarCaretUpdate
        
           buscar(txtBuscar.getText());

    }//GEN-LAST:event_txtBuscarCaretUpdate

    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked
        frmMostrarDepartamentoEmpresa frmMostrarDep = new frmMostrarDepartamentoEmpresa();
        dpnlEscritorio.add(frmMostrarDep);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmMostrarDep.getSize();
        frmMostrarDep.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmMostrarDep.setVisible(true);
        
        //pasar datos
        
        int posicion = tblDatos.getSelectedRow();
        frmMostrarDep.txtId.setText(tblDatos.getValueAt(posicion,0).toString());
        frmMostrarDep.txtNombre.setText(tblDatos.getValueAt(posicion,1).toString());
        frmMostrarDep.txtDescripcion.setText(tblDatos.getValueAt(posicion,2).toString());
        frmMostrarDep.txtEstado.setText(tblDatos.getValueAt(posicion,3).toString());
        frmMostrarDep.txtFecha.setText(tblDatos.getValueAt(posicion,4).toString());
        frmMostrarDep.txtHora.setText(tblDatos.getValueAt(posicion,5).toString());
                   //la posicion 6 es el usuario en este caso, no lo enviaré
        
    }//GEN-LAST:event_tblDatosMouseClicked

    
    private void actualizar(){
        mostrar(query);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnNuevoDep;
    private javax.swing.JButton btnReporte;
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
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

   
}
