/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Credito;


/**
 *
 * @author Alejandro
 */
public class FCredito {
    
    public Conexion sqlSERVER = new Conexion();
    public Connection cn = sqlSERVER.Conectar();
    String sql = "";
    public Integer totalRegistros = 0;
    public Integer totalRefistrosA = 0;
    public Integer totalRegistrosB =0;
    
    public void guardarCredito(Credito credito){
           try{  
                if(cn != null){
                    //ByteArrayInputStream datosHuella = new ByteArrayInputStream(alumno.getHuellaPlantilla().serialize());
                    //Integer tamanoHuella = alumno.getHuellaPlantilla().serialize().length;
                    
                    //el ID de alumno no se toma en cuenta ya que es autoincrementable
                    //FALTA COLOCAR LA HUELLA Y FOTO
                
                    //sql = "INSERT INTO Alumno(carnet,nombre,apellido,dpi,edad,telefono,correo,creditos,foto,_id_carrera, estado, huella) values (?,?,?,?,?,?,?,?,?,?,?,?)";
                    
                    sql= "INSERT INTO TBL_CREDITO(\n" +
                                "Id_credito,\n" +
                                "Numero_credito,\n" +
                                "Id_cuenta,\n" +
                                "Monto,\n" +
                                "Interes,\n" +
                                "Capital,\n" +
                                "Plazo,\n" +
                                "Pagado,\n" +
                                "Porcentajae,\n" +
                                "Mora,\n" +
                                "Destino,\n" +
                                "Id_empleado,\n" +
                                "Id_usuario,\n" +
                                "Id_garantia,\n" +
                                "fecha_corte,\n" +
                                "fecha_pago\n" +
                                ")VALUES(\n" +
                                "NEXT VALUE FOR CREDITO,CAST(NEXT VALUE FOR CREDITO AS NVARCHAR(50))+'-'+FORMAT(GETDATE(),'yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                                
                    PreparedStatement pst = cn.prepareStatement(sql);
                    
                    //pst.setString(1, "default");
                    pst.setInt(1, credito.getId_cuenta());
                    pst.setFloat(2, credito.getMonto());
                    pst.setFloat(3, credito.getInteres());
                    pst.setFloat(4, credito.getCapital());
                    pst.setInt(5, Integer.parseInt(credito.getPlazo()));
                    pst.setFloat(6,credito.getPagado());
                    pst.setFloat(7,credito.getPorcentaje());
                    pst.setFloat(8,credito.getMora());
                    pst.setString(9,credito.getDestino());
                    pst.setInt(10, credito.getId_empleado());
                    pst.setInt(11, credito.getId_usuario());
                    pst.setInt(12, credito.getId_garantia());
                    pst.setDate(13,(Date) credito.getFecha_corte());
                    pst.setDate(14,(Date) credito.getFecha_pago());
                    pst.execute(); 
 
                }else{
                    JOptionPane.showMessageDialog(null, "Error al guardar el registro");
                }
            
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al realizar la conexión por"+ e.getMessage() );   
            }    
    }
    
     public DefaultTableModel mostrarCredito(String buscar){
     
      DefaultTableModel modelo;
   
            totalRegistros=0;
     String [] encabezado ={"ID","NO.CREDITO","NO.CUENTA","ID1","CLIENTE","DPI","DESCRIPCION","GARANTIA","NICK","ASESOR","MONTO","INTERESES","CAPITAL","PAGADO","MONTO RESTANTE","PLAZO","MORA","FECHA DE PAGO","FECHA DE CORTE"};       
     String [] registros = new String [19];  
     modelo = new DefaultTableModel(null,encabezado);
     String sql = buscar;
     
     try{
     
      Statement st = cn.createStatement();
         ResultSet rs = st.executeQuery(sql);
         
         
          while(rs.next()){
          
           for(int i=0; i <19; i++){ //SE DEBE EDITAR DEPENDE DE LOS DATOS EN LA TABLA
                   
                 registros[i] = rs.getString(i+1); 
               }
               
       totalRegistros += 1;
       modelo.addRow(registros); 
          
          }
          
          return modelo;
     
     }catch(Exception e){
         
     JOptionPane.showMessageDialog(null,"No se han podido cargar los datos, motivo: "+e);
     
     return null;
     }
     
     }
     
     
     public DefaultTableModel mostrarAbono(String buscar){
     
         
     DefaultTableModel modelo;
     totalRefistrosA=0;
     String [] encabezado ={"ID","ID2","CAPITAL","MORA","INTERES","TOTAL MONTO","TIPO DE PAGO","FECHA DE PAGO","HORA"};
     String [] registros = new String [9];  
     modelo = new DefaultTableModel(null,encabezado);
     String sql = buscar;
      
     try{
         
     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(sql);
     
     while(rs.next()){
     
       for(int i=0; i <9; i++){ //SE DEBE EDITAR DEPENDE DE LOS DATOS EN LA TABLA
                   
                 registros[i] = rs.getString(i+1); 
                 
               }
       
        totalRefistrosA += 1;
         modelo.addRow(registros); 
     
     
     }
     
     return modelo;
     
     }catch(Exception e){
         
     JOptionPane.showMessageDialog(null,"No se han podido cargar los datos, motivo: "+e);
     
     return null;
     }
     
     }
     
     
     public DefaultTableModel mostrarDesembolso(String buscar){
        totalRegistrosB =0;
        DefaultTableModel modelo;
         String [] encabezado ={"ID","ID2","MONTO","FECHA","HORA"};
         String [] registros = new String [5];  
         modelo = new DefaultTableModel(null,encabezado);
         String sql = buscar;
     
     try{
         
     Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(sql);
         
     
     while(rs.next()){
     
       for(int i=0; i <5; i++){ //SE DEBE EDITAR DEPENDE DE LOS DATOS EN LA TABLA
                   
                 registros[i] = rs.getString(i+1); 
                 
               }
       
         totalRegistrosB += 1;
         modelo.addRow(registros); 
     
     
     } 
         
     return modelo;    
     
     }catch(Exception e){
         
     JOptionPane.showMessageDialog(null,"No se han podido cargar los datos, motivo: "+e);
     
     return null;
     
     }
     
 
     }
     
     
     public float actualizarCapitalRestante(int buscar){
         float capital = 0;
        
    
        String sql = "SELECT CAPITAL FROM TBL_CREDITO WHERE Id_credito = '"+buscar+"'";
    
        try{
         
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
         
            while(rs.next()){      
                capital = rs.getFloat("CAPITAL");
            }
         
            return capital;
     
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se han podido cargar los datos, motivo: "+e);
            return capital;
        }
         
         
     }
     
     
}
