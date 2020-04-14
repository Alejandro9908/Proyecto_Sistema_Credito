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
import javax.swing.table.DefaultTableModel;
import modelo.Cargo;

/**
 *
 * @author Carlos
 */
public class FCargo {
    
    public Conexion sqlSERVER = new Conexion();
    public Connection cn = sqlSERVER.Conectar();
    String sql = "";
    public Integer totalRegistros = 0;
    
    
   public void consultarDepartamento(JComboBox cbDepartamentos){
       
       sql = "SELECT Nombre_departamento FROM TBL_DEPARTAMENTO_EMP ORDER BY Nombre_departamento ASC";
       
       try{
     
         if(cn != null){
         
          Statement st = cn.createStatement();
          ResultSet rs = st.executeQuery(sql);  
          
          while(rs.next()){
          
               cbDepartamentos.addItem(rs.getString("Nombre_departamento"));
          
          }
         
         }else{
          
         JOptionPane.showMessageDialog(null, "No se ha establecido conexion con la db");
         
         }
     
     }catch(Exception e){
         
          JOptionPane.showMessageDialog(null, e);
     
     }
    
   }
   
   
   public void consultarIdepartamento(JTextField idepartamento, String buscar){
   
       sql = "SELECT Id_departamento_emp FROM TBL_DEPARTAMENTO_EMP WHERE Nombre_departamento =" + "'" +buscar + "'";
       
       try{
     
      if(cn != null){
      
          Statement st = cn.createStatement();
          ResultSet rs = st.executeQuery(sql);  
          
          
          while(rs.next()){
          
              idepartamento.setText(rs.getString("Id_departamento_emp"));
          
          }
 
      }else{
              JOptionPane.showMessageDialog(null, "No se ha establecido conexion con la db");
            } 
     
     }catch(Exception e){
     
     }
   
   }
    
    public void agregarCargo(Cargo cargo){
        
     try{
         
          if(cn != null ){
           
              sql = "INSERT INTO TBL_CARGO(Id_cargo,Nombre_cargo,Id_departamento_emp,Descripcion,Id_usuario) VALUES(NEXT VALUE FOR CARGO,?,?,?,?) ";
              PreparedStatement pst = cn.prepareStatement(sql);
              
               pst.setString(1, cargo.getNombre_cargo());
               pst.setInt(2, cargo.getId_departamento_emp());
               pst.setString(3, cargo.getDescripcion());
               pst.setInt(4, cargo.getId_usuario());
               
                pst.execute(); 
              
          }else{
                JOptionPane.showMessageDialog(null, "Error al guardar el registro");
               }
          
      }catch(SQLException e){
          
        JOptionPane.showMessageDialog(null,"Error al realizar la conexión por"+ e.getMessage());
      }
    
    
    }
    
    
    public DefaultTableModel mostrarCargo(String buscar){
           DefaultTableModel modelo;
           
    String [] encabezado = {"ID","CARGO","DEPARTAMENTO","DESCRIPCION","FECHA","HORA","ESTADO","USUARIO"};   
    String [] registros = new String [8];
    
    modelo = new DefaultTableModel(null,encabezado);
    String sql = buscar;
    
     try{
         
         Statement st = cn.createStatement();
         ResultSet rs = st.executeQuery(sql);
         
         while(rs.next()){
         
             registros[0] = Integer.toString(rs.getInt("Id_cargo"));
             registros[1] = rs.getString("Nombre_cargo");
             registros[2] = rs.getString("Nombre_departamento");
             registros[3] = rs.getString("Descripcion");
             registros[4] = rs.getString("Fecha_commit");
             registros[5] = rs.getString("Hora_commit");
             registros[6] = Integer.toString(rs.getInt("Estado"));
             registros[7] = Integer.toString(rs.getInt("Id_usuario"));
             
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
