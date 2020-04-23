/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;

/**
 *
 * @author Kevin
 */
public class FEmpleado {
    
    public Conexion sqlSERVER = new Conexion();
    public Connection cn = sqlSERVER.Conectar();
    String sql = "";
    public Integer totalRegistros = 0;
    
    
    
    public void guardarEmpleado(Empleado empleado){
           try{  
                if(cn != null){
                    //ByteArrayInputStream datosHuella = new ByteArrayInputStream(alumno.getHuellaPlantilla().serialize());
                    //Integer tamanoHuella = alumno.getHuellaPlantilla().serialize().length;
                    
                    //el ID de alumno no se toma en cuenta ya que es autoincrementable
                    //FALTA COLOCAR LA HUELLA Y FOTO
                
                    //sql = "INSERT INTO Alumno(carnet,nombre,apellido,dpi,edad,telefono,correo,creditos,foto,_id_carrera, estado, huella) values (?,?,?,?,?,?,?,?,?,?,?,?)";
                    
                    sql= "INSERT INTO TBL_EMPLEADO(Id_empleado,Id_sucursal, Dpi, Primer_nombre , Segundo_nombre, Tercer_nombre, Primer_apellido, Segundo_apellido, Apellido_casado, Id_cargo, Estado_civil, Foto, Id_municipio, Telefono, Correo, Fecha_nacimiento, Genero, Profesion, Suledo, Id_usuario, Direccion) VALUES(NEXT VALUE FOR EMPLEADO,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    
                    PreparedStatement pst = cn.prepareStatement(sql);
                
                    pst.setInt(1, empleado.getId_sucursal());
                    pst.setString(2, empleado.getDpi());
                    pst.setString(3, empleado.getPrimer_nombre());
                    pst.setString(4, empleado.getSegundo_nombre());               //FALTA COLOCAR LA HUELLA, FOTO
                    pst.setString(5, empleado.getTercer_nombre());
                    pst.setString(6, empleado.getPrimer_apellido());
                    pst.setString(7, empleado.getSegundo_apellido());
                    pst.setString(8, empleado.getApellido_casado());
                    pst.setInt(9, empleado.getId_cargo());
                   // pst.setInt(10, empleado.getId_departamento());
                    pst.setString(10, empleado.getEstado_civil());
                    pst.setBytes(11, empleado.getFoto());
                    pst.setInt(12, empleado.getId_municipio());
                    pst.setString(13, empleado.getTelefono());
                    pst.setString(14, empleado.getCorreo());
                    pst.setDate(15, (Date) empleado.getFecha_nacimiento());
                    pst.setString(16, empleado.getGenero());
                    pst.setString(17, empleado.getProfesion());
                    pst.setFloat(18, empleado.getSueldo());
                     pst.setInt(19, empleado.getId_usuario());
                     pst.setString(20, empleado.getDireccion());
                 //   pst.setBinaryStream(12, datosHuella, tamanoHuella);
                    
                
                    pst.execute(); 
 
                }else{
                    JOptionPane.showMessageDialog(null, "Error al guardar el registro");
                }
            
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al realizar la conexión por"+ e.getMessage() );   
            }    
    }
    
    
    
     //este metodo es el de Seleccionar FRM (deberia ir en FDepartamento pero lo coloqué acá) Att. Kevin
     public void mostrarSucursalSeleccionar( JTable tabla){
         
        DefaultTableModel model;
        String [] columnas = {"ID_SUCURSAL", "NOMBRE_SUCURSAL"};
        model = new DefaultTableModel(null, columnas);
        
        sql = "SELECT Id_sucursal, Nombre_sucursal FROM TBL_SUCURSAL";
        
        String[] filas = new String [2]; //registros
        
        Statement st = null;
        ResultSet rs = null;
        
         try {
             
             st = cn.createStatement();
             rs = st.executeQuery(sql);
             
             while(rs.next()){
                 // es como for (int i=0; i <4; i++)
               for(int i=0; i <2; i++){ //SE DEBE EDITAR DEPENDE DE LOS DATOS EN LA TABLA
                   
                 filas[i] = rs.getString(i+1); 
               }
                totalRegistros += 1;
               model.addRow(filas);
                
             }
             tabla.setModel(model);
             
         } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "No se pueden mostrar los datos");
         }
            
         
     }
     
     
     public void mostrarCargoSeleccionar( JTable tabla){
         
        DefaultTableModel model;
        String [] columnas = {"ID_CARGO", "NOMBRE_CARGO"};
        model = new DefaultTableModel(null, columnas);
        
        sql = "SELECT Id_cargo, Nombre_cargo FROM TBL_CARGO";
        
        String[] filas = new String [2]; //registros
        
        Statement st = null;
        ResultSet rs = null;
        
         try {
             
             st = cn.createStatement();
             rs = st.executeQuery(sql);
             
             while(rs.next()){
                 // es como for (int i=0; i <4; i++)
               for(int i=0; i <2; i++){ //SE DEBE EDITAR DEPENDE DE LOS DATOS EN LA TABLA
                   
                 filas[i] = rs.getString(i+1); 
               }
                totalRegistros += 1;
               model.addRow(filas);
                
             }
             tabla.setModel(model);
             
         } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "No se pueden mostrar los datos");
         }
            
         
     }
    
     
     public void mostrarMunicipioEmpleado( JTable tabla){
         
        DefaultTableModel model;
        String [] columnas = {"ID_MUNICIPIO", "NOMBRE_MUNICIPIO", "DEPARTAMENTO"};
        model = new DefaultTableModel(null, columnas);
        
        sql = "SELECT a.Id_municipio, a.Nombre_municipio,b.Nombre_departamento FROM TBL_MUNICIPIO AS a\n" +
"inner join TBL_DEPARTAMENTO AS b on a.ID_DEPARTAMENTO = b.Id_departamento" ;
        
        String[] filas = new String [3]; //registros
        
        Statement st = null;
        ResultSet rs = null;
        
         try {
             
             st = cn.createStatement();
             rs = st.executeQuery(sql);
             
             while(rs.next()){
                 // es como for (int i=0; i <4; i++)
               for(int i=0; i <3; i++){ //SE DEBE EDITAR DEPENDE DE LOS DATOS EN LA TABLA
                   
                 filas[i] = rs.getString(i+1); 
               }
                totalRegistros += 1;
               model.addRow(filas);
                
             }
             tabla.setModel(model);
             
         } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "No se pueden mostrar los datos");
         }
            
         
     }
    
    public DefaultTableModel mostrarEmpleado(String buscar){
            DefaultTableModel modelo;
    
      totalRegistros=0;

      String [] encabezado = {"ID","DPI","PRIMER NOMBRE","SEGUNDO NOMBRE","TERCER NOMBRE","PRIMER APELLID","SEGUNDO APELLIDO","APELLIDO CASADO","ESTADO CIVIL","FOTO","DIRECCION","TELEFONO","CORREO","GENERO","PROFESION","SUELDO","FECHA NACIMIENTO","FECHA","HORA","SUCURSAL","CARGO","MUNICIPIO","ESTADO","ID SUCURSAL","ID CARGO","ID MUNICIPIO","ID USUARIO"};   
      String [] registros = new String [27];      
     
       modelo = new DefaultTableModel(null,encabezado);
       String sql = buscar;
       
        try{
         
         Statement st = cn.createStatement();
         ResultSet rs = st.executeQuery(sql);
         
         while(rs.next()){
         
             registros[0] = Integer.toString(rs.getInt("Id_empleado"));
             registros[1] = rs.getString("Dpi");
             registros[2] = rs.getString("Primer_nombre");
             registros[3] = rs.getString("Segundo_nombre");
             registros[4] = rs.getString("Tercer_nombre");
             registros[5] = rs.getString("Primer_apellido");
             registros[6] = rs.getString("Segundo_apellido");
             registros[7] = rs.getString("Apellido_casado");
             registros[8] = rs.getString("Estado_civil");
             registros[9] = rs.getString("Foto");
             registros[10] = rs.getString("Direccion");
             registros[11] = rs.getString("Telefono");
             registros[12] = rs.getString("Correo");
             registros[13] = rs.getString("Genero");
             registros[14] = rs.getString("Profesion");
             registros[15] = Integer.toString((int) rs.getFloat("Suledo"));
             registros[16] = rs.getString("Fecha_nacimiento");
             registros[17] = rs.getString("Fecha_commit");
             registros[18] = rs.getString("Hora_commit");
             registros[19] = rs.getString("Nombre_sucursal");
             registros[20] = rs.getString("Nombre_cargo");
             registros[21] = rs.getString("Nombre_municipio");
             registros[22] = Integer.toString(rs.getInt("Estado"));
             registros[23] = Integer.toString(rs.getInt("Id_sucursal"));
             registros[24] = Integer.toString(rs.getInt("Id_cargo"));
             registros[25] = Integer.toString(rs.getInt("Id_municipio"));
             registros[26] = Integer.toString(rs.getInt("Id_usuario"));
             
             totalRegistros += 1;
             modelo.addRow(registros);
         
         
         }
         
         return modelo;
     
     }catch(Exception e){
         
     JOptionPane.showMessageDialog(null,"No se han podido cargar los datos, motivo: "+e);
     
     return null;
     }

    }
    
    
    
    
}
