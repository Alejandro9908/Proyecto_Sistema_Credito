/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.empleado;

import controladores.Conexion;
import controladores.FEmpleado;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class frmIndexEmpleado extends javax.swing.JInternalFrame implements ActionListener{

    DefaultTableModel modelo;
    FEmpleado funcion = new FEmpleado();
    
      
    
    
    
    String query = "SELECT a.Id_empleado,a.Dpi,a.Primer_nombre,a.Segundo_nombre,a.Tercer_nombre,a.Primer_apellido,a.Segundo_apellido, \n" +
                   "a.Apellido_casado,a.Estado_civil,a.Foto,a.Direccion,a.Telefono,a.Correo,a.Genero,a.Profesion,a.Suledo,a.Fecha_nacimiento,\n" +
                    "a.Fecha_commit,a.Hora_commit,b.Nombre_sucursal,c.Nombre_cargo,d.Nombre_municipio,a.Estado,a.Id_sucursal,a.Id_cargo,a.Id_municipio,a.Id_usuario\n" +
                     "FROM TBL_EMPLEADO AS a inner join TBL_SUCURSAL AS b on a.Id_sucursal = b.Id_sucursal inner join [TBL_CARGO] AS c on a.Id_cargo = c.Id_cargo inner join \n" +
                      "[TBL_MUNICIPIO] AS d on a.Id_municipio = d.Id_municipio WHERE a.Estado = 1";
  
    public frmIndexEmpleado() {
        initComponents();
        
        
        ButtonGroup grupoBuscar = new ButtonGroup();
        grupoBuscar.add(rbId);
        grupoBuscar.add(rbNombre);
        rbNombre.setSelected(true);
        
        
        mostrar(query);
        //AGREGAR BOTONES AL ACTION LISTENER
        btnNuevo.addActionListener(this);
        btnActualizar.addActionListener(this);
        btnReporte.addActionListener(this);
        btnBuscar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(btnNuevo == e.getSource()){
            frmNuevoEmpleado frmNuevo = new frmNuevoEmpleado();
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
    
    try {
            modelo = funcion.mostrarEmpleado(buscar);
            
            tblDatos.setModel(modelo);
            txtTotal.setText("    " + Integer.toString(funcion.totalRegistros)); 
            
            
            
            ocultarColumnas(tblDatos,0); //para ocultar el ID de empleado
             ocultarColumnas(tblDatos,1); //para ocultar el ID de sucursal
              ocultarColumnas(tblDatos,11); //para ocultar el la FOTO wtf
               ocultarColumnas(tblDatos,12); //para ocultar el ID de 
               
            
             ocultarColumnas(tblDatos,4); //para ocultar la columna del estado
             ocultarColumnas(tblDatos,7); //para ocultar la columna de Fecha de creacion
             ocultarColumnas(tblDatos,9); //para ocultar la columna de Hora de creacion
             ocultarColumnas(tblDatos,15); //para ocultar la columna del ID de Usuario que hizo eso*/
             ocultarColumnas(tblDatos,17); //para ocultar la columna del ID de Usuario que hizo eso*/
             ocultarColumnas(tblDatos,18); //para ocultar la columna del ID de Usuario que hizo eso*/
             ocultarColumnas(tblDatos,22); //para ocultar la columna del ID de Usuario que hizo eso*/
             ocultarColumnas(tblDatos,23); //para ocultar la columna del ID de Usuario que hizo eso*/
             ocultarColumnas(tblDatos,24); //para ocultar la columna del ID de Usuario que hizo eso*/
             ocultarColumnas(tblDatos,25); //para ocultar la columna del ID de Usuario que hizo eso*/
             ocultarColumnas(tblDatos,26); //para ocultar la columna del ID de Usuario que hizo eso*/
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos, motivo: "+ e);
        }
    
    
    }
    
    
    
       private void buscarEmpleado(String textoBuscar){
     
         
        if(rbId.isSelected()==true){
        mostrar("SELECT a.Id_empleado,a.Dpi,a.Primer_nombre,a.Segundo_nombre,a.Tercer_nombre,a.Primer_apellido,a.Segundo_apellido, \n" +
                   "a.Apellido_casado,a.Estado_civil,a.Foto,a.Direccion,a.Telefono,a.Correo,a.Genero,a.Profesion,a.Suledo,a.Fecha_nacimiento,\n" +
                    "a.Fecha_commit,a.Hora_commit,b.Nombre_sucursal,c.Nombre_cargo,d.Nombre_municipio,a.Estado,a.Id_sucursal,a.Id_cargo,a.Id_municipio,a.Id_usuario\n" +
                     "FROM TBL_EMPLEADO AS a inner join TBL_SUCURSAL AS b on a.Id_sucursal = b.Id_sucursal inner join [TBL_CARGO] AS c on a.Id_cargo = c.Id_cargo inner join \n" +
                      "[TBL_MUNICIPIO] AS d on a.Id_municipio = d.Id_municipio WHERE (Id_empleado like '%"+textoBuscar+"%') AND a.Estado = 1");
        }else{
        
          mostrar("SELECT a.Id_empleado,a.Dpi,a.Primer_nombre,a.Segundo_nombre,a.Tercer_nombre,a.Primer_apellido,a.Segundo_apellido, \n" +
                   "a.Apellido_casado,a.Estado_civil,a.Foto,a.Direccion,a.Telefono,a.Correo,a.Genero,a.Profesion,a.Suledo,a.Fecha_nacimiento,\n" +
                    "a.Fecha_commit,a.Hora_commit,b.Nombre_sucursal,c.Nombre_cargo,d.Nombre_municipio,a.Estado,a.Id_sucursal,a.Id_cargo,a.Id_municipio,a.Id_usuario\n" +
                     "FROM TBL_EMPLEADO AS a inner join TBL_SUCURSAL AS b on a.Id_sucursal = b.Id_sucursal inner join [TBL_CARGO] AS c on a.Id_cargo = c.Id_cargo inner join \n" +
                      "[TBL_MUNICIPIO] AS d on a.Id_municipio = d.Id_municipio WHERE (Primer_nombre like '%"+textoBuscar+"%') AND a.Estado = 1");  
        
        }
     
     
     }
    
    
    
    
    
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
        String ruta = "/reportes/ReporteEmpleados.jasper";
        
        g.Conectar();
        
        InputStream rutaJasper =  frmIndexEmpleado.class.getResourceAsStream(ruta);
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
        btnNuevo = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        pnlBase.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel1.setText("Empleados");

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
        );
        pnlIndexLayout.setVerticalGroup(
            pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIndexLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevo.setText("Nuevo Empleado");

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
        buscarEmpleado(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarCaretUpdate

    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked
        frmMostrarEmpleado frmMostrar = new frmMostrarEmpleado();
        dpnlEscritorio.add(frmMostrar);
        Dimension desktopSize = dpnlEscritorio.getSize();
        Dimension FrameSize = frmMostrar.getSize();
        frmMostrar.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmMostrar.setVisible(true);
        
        
       int posicion = tblDatos.getSelectedRow();
        frmMostrarEmpleado.txtId.setText(tblDatos.getValueAt(posicion,0).toString());
        frmMostrarEmpleado.txtDpi.setText(tblDatos.getValueAt(posicion,1).toString());
        frmMostrarEmpleado.txtNombre1.setText(tblDatos.getValueAt(posicion,2).toString());
        frmMostrarEmpleado.txtNombre2.setText(tblDatos.getValueAt(posicion,3).toString());
        frmMostrarEmpleado.txtNombre3.setText(tblDatos.getValueAt(posicion,4).toString());
        frmMostrarEmpleado.txtApellido1.setText(tblDatos.getValueAt(posicion,5).toString());
        frmMostrarEmpleado.txtApellido2.setText(tblDatos.getValueAt(posicion,6).toString());
        frmMostrarEmpleado.txtApellidoCasado.setText(tblDatos.getValueAt(posicion,7).toString());
        
        //OBTENEMOS EL VALOR DEL ESTADO CIVIL
        //frmMostrarEmpleado.cbEstadoCivil.setText(tblDatos.getValueAt(posicion,8).toString());
        for(int i = 0; i < frmMostrarEmpleado.cbEstadoCivil.getItemCount(); i++){ // <=============================
            if(tblDatos.getValueAt(posicion, 8).toString().equals(frmMostrarEmpleado.cbEstadoCivil.getItemAt(i))){             //============== REVISAR CON EL EDITAR PARA VER SI FUNCIONA
                frmMostrarEmpleado.cbEstadoCivil.setSelectedIndex(i);
            }
        }
        
        
        
        //frmMostrarEmpleado.panelFoto.(tblDatos.getValueAt(posicion,9).toString());
                        //Lo que le mando es el ID desde la tabla, lo pude hacer en una consulta allá pero bueno
        consultarFoto(tblDatos.getValueAt(posicion,0).toString());
        
        
        frmMostrarEmpleado.txtDireccion.setText(tblDatos.getValueAt(posicion,10).toString());
        frmMostrarEmpleado.txtTelefono.setText(tblDatos.getValueAt(posicion,11).toString());  
        frmMostrarEmpleado.txtCorreo.setText(tblDatos.getValueAt(posicion,12).toString());
     
     
     
     //obtener genero
     //   frmMostrarEmpleado.cbGenero.setText(tblDatos.getValueAt(posicion,13).toString());
      for(int i = 0; i < frmMostrarEmpleado.cbGenero.getItemCount(); i++){ // <=============================
            if(tblDatos.getValueAt(posicion, 13).toString().equals(frmMostrarEmpleado.cbGenero.getItemAt(i))){             //============== REVISAR CON EL EDITAR PARA VER SI FUNCIONA
                frmMostrarEmpleado.cbGenero.setSelectedIndex(i);
            }
        }
     
     
     
     
     
        frmMostrarEmpleado.txtProfesion.setText(tblDatos.getValueAt(posicion,14).toString());
        frmMostrarEmpleado.txtSueldo.setText(tblDatos.getValueAt(posicion,15).toString());
        
        
        //Metodo para pasar la fecha de nacimiento
        
        String fechaNacimiento = tblDatos.getValueAt(posicion,16).toString();
         SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fechaNacimiento);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
          frmMostrarEmpleado.txtFechaNacimiento.setDate(fechaDate);
          
          //TEMINA PASAR FECHA DE NACIMIENTO
        
      
        frmMostrarEmpleado.txtFecha.setText(tblDatos.getValueAt(posicion,17).toString());
        frmMostrarEmpleado.txtHora.setText(tblDatos.getValueAt(posicion,18).toString());
        frmMostrarEmpleado.txtSucursal.setText(tblDatos.getValueAt(posicion,19).toString());
        frmMostrarEmpleado.txtCargo.setText(tblDatos.getValueAt(posicion,20).toString());
        frmMostrarEmpleado.txtMunicipio.setText(tblDatos.getValueAt(posicion,21).toString());
        frmMostrarEmpleado.txtEstado.setText(tblDatos.getValueAt(posicion,22).toString());
        frmMostrarEmpleado.txtIdSucursal.setText(tblDatos.getValueAt(posicion,23).toString());
        frmMostrarEmpleado.txtIdCargo.setText(tblDatos.getValueAt(posicion,24).toString());
        frmMostrarEmpleado.txtIdMunicipio.setText(tblDatos.getValueAt(posicion,25).toString());
        
        
        
        //consultarFoto((String)tablaDatosAlumnos.getValueAt(tablaDatosAlumnos.getSelectedRow(),1));
      
     
    }//GEN-LAST:event_tblDatosMouseClicked

     public void consultarFoto(String buscar){
       
 
        Conexion sqlSERVER = new Conexion();
        Connection cn2 = sqlSERVER.Conectar();
        
        
        String sql = "select Foto from TBL_EMPLEADO where ID_EMPLEADO =" + "'" +buscar + "'";
         try{
            if(cn2!=null){
                Statement st = cn2.createStatement();
                ResultSet rs = st.executeQuery(sql);  
    
                while(rs.next()){
                    //el nombre del campo que queremos obtener en la db
                    byte [] imagen = rs.getBytes("Foto");
                    frmMostrarEmpleado.panelFoto.setImagen(imagen);
                }
            }else{
                 JOptionPane.showMessageDialog(null, "No se ha establecido conexion con la db");
            }
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }  
        
    }
    
    
    
    
    private void actualizar(){
        mostrar(query);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnNuevo;
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
