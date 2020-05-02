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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Garantia;

/**
 *
 * @author DELL
 */
public class FGarantia {
    
    public Conexion sqlSERVER = new Conexion();
    public Connection cn = sqlSERVER.Conectar();
    String sql = "";
    public Integer totalRegistros = 0;
    
    public void guardarGarantia(Garantia garantia){
    
     try{  
                if(cn != null){
                  
                    sql = "INSERT INTO TBL_GARANTIA(Id_garantia,Nombre,N_identificacion,Id_tipo_garantia,Descripcion,Fotografia,Valuacion,Id_usuario)VALUES(NEXT VALUE FOR GARANTIA,?,?,?,?,?,?,? )";
                    PreparedStatement pst = cn.prepareStatement(sql);
                
                    pst.setString(1, garantia.getNombre());
                    pst.setString(2, garantia.getN_documento());
                    pst.setInt(3, garantia.getId_tipo_garantia());
                    pst.setString(4, garantia.getDescripcion());
                    pst.setBytes(5, garantia.getFotografia());
                    pst.setFloat(6, garantia.getValuacion());
                    pst.setInt(7, garantia.getId_usuario());
                
                    pst.execute(); 
 
                }else{
                    JOptionPane.showMessageDialog(null, "Error al guardar el registro");
                }
            
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al realizar la conexión por"+ e.getMessage() );   
            }    
    
    }
    
    
    public void mostratipogarantia(JTable tabla){
    
    DefaultTableModel model;
    String [] columnas = {"ID_TIPO_GARANTA", "TIPO_DE_GARANTIA"};
    model = new DefaultTableModel(null, columnas);
    
    sql = "SELECT Id_tipo_garantia,Nombre_garantia FROM TBL_TIPO_GARANTIA where Estado=1";
    
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
    
    
    public void buscartipogarantia(JTable tabla, String buscar){
    
    DefaultTableModel model;
    String [] columnas = {"ID_TIPO_GARANTA", "TIPO_DE_GARANTIA"};
    model = new DefaultTableModel(null, columnas);
    
    sql = "SELECT Id_tipo_garantia,Nombre_garantia FROM TBL_TIPO_GARANTIA where UPPER(Nombre_garantia) LIKE '%"+buscar+"%'";
        
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
    
  public DefaultTableModel mostrarGarantia(String buscar){
            DefaultTableModel modelo;
   
            totalRegistros=0;
            
       String [] encabezado = {"ID","NOMBRE","NUMERO DE IDENTIFICACION","GARANTIA","DESCRIPCION","ID GARANTIA","FOTOGRAFIA","VALUACION","ESTADO","FECHA","HORA","USUARIO"};         
       String [] registros = new String [12];  
       modelo = new DefaultTableModel(null,encabezado);
       String sql = buscar;
       
       try{
         
         Statement st = cn.createStatement();
         ResultSet rs = st.executeQuery(sql);
       
       while(rs.next()){
       
       registros[0] = Integer.toString(rs.getInt("Id_garantia"));    
       registros[1] = rs.getString("Nombre");
       registros[2] = rs.getString("N_identificacion"); 
       registros[3] = rs.getString("Nombre_garantia"); 
       registros[4] = rs.getString("Descripcion");
       registros[5] = Integer.toString(rs.getInt("Id_tipo_garantia"));
       registros[6] = rs.getString("Fotografia");
       registros[7] = Integer.toString((int) rs.getFloat("Valuacion"));
       registros[8] = Integer.toString(rs.getInt("Estado"));
       registros[9] = rs.getString("Fecha_commit");
       registros[10] = rs.getString("Hora_commit");
       registros[11] = Integer.toString(rs.getInt("Id_usuario"));
      
       totalRegistros += 1;
       modelo.addRow(registros);    
       }
       return modelo;
       }catch(Exception e){
         
     JOptionPane.showMessageDialog(null,"No se han podido cargar los datos, motivo: "+e);
     
     return null;
     }
       
       
  }  
  
   /*public void editarGarantia(Garantia garantia, String buscar){
   
    sql = "update"
          +  "TBL_GARANTIA"
        + "set" 
          +"Id_garantia= (?), "  
          +"N_identificacion= (?), "  
          +"Nombre= (?), "
          +"Fotografia= (?), " 
          +"Id_tipo_garantia= (?), " 
          +"Descripcion= (?), "
          +"Valuacion= (?) "  
        +"where "
          + "Id_garantia= (?)";  
    
     try{
     
      if(cn!=null){
      
      PreparedStatement pst = cn.prepareStatement(sql);
       pst.setString(1, garantia.getNombre());
       pst.setString(2, garantia.getN_documento());
       pst.setInt(3, garantia.getId_tipo_garantia());
       pst.setString(4, garantia.getDescripcion());
       pst.setBytes(5, garantia.getFotografia());
       pst.setFloat(6, garantia.getValuacion());
       pst.setString(7, buscar);
      
      }
     
   
     }catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Error al editar, motivo:"+ex.getMessage());
        } 
    
    
    
    
   }*/
  
  public void editarGarantia(Garantia garantia, String buscar){
  
  try{
  
  if(cn!=null){
                PreparedStatement st = cn.prepareStatement("update TBL_GARANTIA set Id_garantia='"+garantia.getId_garantia()+ "',N_identificacion='"+garantia.getN_documento()+ "',Nombre='"+garantia.getNombre()+ "',Id_tipo_garantia='"+garantia.getId_tipo_garantia()+ "',Descripcion='"+garantia.getDescripcion()+"',Valuacion='"+garantia.getValuacion()+"' where Id_garantia="+buscar+"");
  
  st.execute();
  }else{
                System.out.println("No es posible editar la informacion");
            }            
  
  
  }catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Error al editar, motivo:"+ex.getMessage());
        } 
  
  
  
  }
   
   

}
