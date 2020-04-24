/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.TipoGarantia;

/**
 *
 * @author Carlos
 */
public class FTipo_garantia {
    
    public Conexion sqlSERVER = new Conexion();
    public Connection cn = sqlSERVER.Conectar();
    String sql = "";
    public Integer totalRegistros = 0;
    
    public void AgregarTipogantia(TipoGarantia tipogarantia){
    
    try{
    
    if(cn != null){
    
        sql = "INSERT INTO TBL_TIPO_GARANTIA(Id_tipo_garantia,Nombre_garantia,Descripcion,Id_usuario) VALUES(NEXT VALUE FOR TIPO_GARANTIA,?,?,?)";
        PreparedStatement pst = cn.prepareStatement(sql);
        
        pst.setString(1, tipogarantia.getNombre_garantia());
        pst.setString(2, tipogarantia.getDescripcion());
        pst.setInt(3, tipogarantia.getId_usuario());
        
        pst.execute();
        
    }else{
    
     JOptionPane.showMessageDialog(null, "Error al guardar el registro");
    
    }
    
    }catch(SQLException e){
          
        JOptionPane.showMessageDialog(null,"Error al realizar la conexión por"+ e.getMessage());
     }
     
    
    }
    
     public DefaultTableModel mostrarTipoGarantia(String buscar){
            DefaultTableModel modelo;
           
            totalRegistros=0;
      
     String [] encabezado = {"ID","GARANTIA","DESCRIPCION","ESTADO","FECHA","HORA","USUARIO"};   
     String [] registros = new String [7];      
     
      modelo = new DefaultTableModel(null,encabezado);
      String sql = buscar;
      
      try{
         
         Statement st = cn.createStatement();
         ResultSet rs = st.executeQuery(sql);
         
         while(rs.next()){
         
             registros[0] = Integer.toString(rs.getInt("Id_tipo_garantia"));
             registros[1] = rs.getString("Nombre_garantia");
             registros[2] = rs.getString("Descripcion");
             registros[3] = Integer.toString(rs.getInt("Estado"));
             registros[4] = rs.getString("Fecha_commit");
             registros[5] = rs.getString("Hora_commit");
             registros[6] = Integer.toString(rs.getInt("Id_usuario"));
             
             totalRegistros += 1;
             modelo.addRow(registros);
         
         
         }
         
         return modelo;
     
     }catch(Exception e){
         
     JOptionPane.showMessageDialog(null,"No se han podido cargar los datos, motivo: "+e);
     
     return null;
     }
           
     }
    
  public void editarTipoGarantia(TipoGarantia tipogarantia, String buscar){  
  
      try{
            if(cn!=null){
                PreparedStatement st = cn.prepareStatement("update TBL_TIPO_GARANTIA set Id_tipo_garantia='"+tipogarantia.getId_tipo_garantia()+"',Nombre_garantia='"+tipogarantia.getNombre_garantia()+"',Descripcion='"+tipogarantia.getDescripcion()+"' where Id_tipo_garantia="+buscar+"");
                st.execute();
            }else{
                System.out.println("No es posible editar la informacion");
            }
        }
        catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Error al editar, motivo:"+ex.getMessage());
        } 
  
  } 
  
  
   public void eliminarTipoGarantia(String idEliminar){
   
   try{
            if(cn!=null){
                PreparedStatement st = cn.prepareStatement("update TBL_TIPO_GARANTIA set Estado=0 where Id_tipo_garantia="+idEliminar+"");
                st.execute();
            }else{
                System.out.println("No es posible eliminar el registro");
            }
        }
        catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Error al eliminar, motivo:"+ex.getMessage());
        } 
   
   
   }
     
    
}
