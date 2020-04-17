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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Departamento;
import modelo.Municipio;
import modelo.Sucursal;

/**
 *
 * @author DELL
 */
public class FSucursal {
    
    public Conexion sqlSERVER = new Conexion();
    public Connection cn = sqlSERVER.Conectar();
    String sql = "";
    public Integer totalRegistros = 0;
    
    
    //Metod consultar departamento
     public void consultarDepartamento(JComboBox<Departamento> cbDepartamentos){
       
       sql = "SELECT Id_departamento, Nombre_Departamento FROM TBL_DEPARTAMENTO ORDER BY Nombre_departamento ASC";
       
       try{
     
         if(cn != null){
         
          Statement st = cn.createStatement();
          ResultSet rs = st.executeQuery(sql);  
          
          while(rs.next()){
          
                 cbDepartamentos.addItem(
                        new Departamento(
                            rs.getInt("Id_departamento"),
                            rs.getString("Nombre_departamento")
                          
                        )
                    );
          
          }
         
         }else{
          
         JOptionPane.showMessageDialog(null, "No se ha establecido conexion con la db");
         
         }
     
     }catch(Exception e){
         
          JOptionPane.showMessageDialog(null, e);
     
     }
    
   }
     
     //Consultar el id del departamento
   public void consultarIdepartamento(JTextField idepartamento, String buscar){
   
       sql = "SELECT Id_departamento FROM TBL_Departamento WHERE Nombre_departamento =" + "'" +buscar + "'";
       
       try{
     
      if(cn != null){
      
          Statement st = cn.createStatement();
          ResultSet rs = st.executeQuery(sql);  
          
          
          while(rs.next()){
          
              idepartamento.setText(rs.getString("Id_departamento"));
          
          }
 
      }else{
              JOptionPane.showMessageDialog(null, "No se ha establecido conexion con la db");
            } 
     
     }catch(Exception e){
     
     }
   
   }
     
   //Metod consultar departamento
   
   public void consultarMunicipio(JComboBox<Municipio> cbMunicipio, String buscar){
       
       sql = "SELECT Id_municipio, Nombre_municipio FROM TBL_MUNICIPIO WHERE ID_DEPARTAMENTO =" + "'" + buscar + "'";
       
       try{
     
         if(cn != null){
         
          Statement st = cn.createStatement();
          ResultSet rs = st.executeQuery(sql);  
          
         while(rs.next()){
              
                cbMunicipio.addItem(
                        new Municipio(
                            rs.getInt("Id_municipio"),
                            rs.getString("Nombre_municipio")
                          
                        )
                    );   
                
             }
         
         }else{
          
         JOptionPane.showMessageDialog(null, "No se ha establecido conexion con la db");
         
         }
     
     }catch(Exception e){
         
          JOptionPane.showMessageDialog(null, e);
     
     }
    
   }
     
   //CONSULTAR ID DEL MUNICIPIO DE LA EMPRESA Y SE LO MANDAMOS A UN TXT
   public void consultarIdmunicipio(JTextField idmunicipio, String buscar){
   
      sql = "SELECT Id_municipio FROM TBL_MUNICIPIO WHERE  Nombre_municipio =" + "'" +buscar + "'";
       
       try{
     
      if(cn != null){
      
          Statement st = cn.createStatement();
          ResultSet rs = st.executeQuery(sql);  
          
          
          while(rs.next()){
          
              idmunicipio.setText(rs.getString("Id_municipio"));
          
          }
 
      }else{
              JOptionPane.showMessageDialog(null, "No se ha establecido conexion con la db");
            } 
     
     }catch(Exception e){
     
     }
   
   
   }
   
   
   
    public void agregarCargo(Sucursal sucursal){
        
     try{
         
          if(cn != null ){
           
              sql = "INSERT INTO TBL_SUCURSAL(Id_sucursal,Nombre_sucursal,direccion,id_municipio,Telefono_sucursal,Correo_sucursal) VALUES(NEXT VALUE FOR SUCURSAL,?,?,?,?,?) ";
              PreparedStatement pst = cn.prepareStatement(sql);
              
               pst.setString(1, sucursal.getNombre_sucursal());
               pst.setString(2, sucursal.getDireccion());
               pst.setInt(3, sucursal.getId_municipio());
               pst.setString(4, sucursal.getTelefono());
               pst.setString(6, sucursal.getCorreo());
               
                pst.execute(); 
              
          }else{
                JOptionPane.showMessageDialog(null, "Error al guardar el registro");
               }
          
      }catch(SQLException e){
          
        JOptionPane.showMessageDialog(null,"Error al realizar la conexión por"+ e.getMessage());
      }
    
    
    }
    
    
}
