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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
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
       
       sql = "SELECT Id_municipio, Nombre_municipio FROM TBL_MUNICIPIO WHERE ID_DEPARTAMENTO =" + "'" + buscar + "'"+ "ORDER BY Nombre_municipio ASC";
       
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
   
   
   
    public void agregarSucursal(Sucursal sucursal){
        
     try{
         
          if(cn != null ){
           
              sql = "INSERT INTO TBL_SUCURSAL(Id_sucursal,Nombre_sucursal,direccion,id_municipio,Telefono_sucursal,Correo_sucursal,Id_usuario) VALUES(NEXT VALUE FOR SUCURSAL,?,?,?,?,?,?) ";
              PreparedStatement pst = cn.prepareStatement(sql);
              
               pst.setString(1, sucursal.getNombre_sucursal());
               pst.setString(2, sucursal.getDireccion());
               pst.setInt(3, sucursal.getId_municipio());
               pst.setString(4, sucursal.getTelefono());
               pst.setString(5, sucursal.getCorreo());
               pst.setInt(6, sucursal.getId_usuario());
               
                pst.execute(); 
              
          }else{
                JOptionPane.showMessageDialog(null, "Error al guardar el registro");
               }
          
      }catch(SQLException e){
          
        JOptionPane.showMessageDialog(null,"Error al realizar la conexión por"+ e.getMessage());
      }
    
    
    }
    
    
    //este metodo es el de Seleccionar FRM (deberia ir en FDepartamento pero lo coloqué acá) Att. Kevin
     public void mostrarDepartamento( JTable tabla){
         
        DefaultTableModel model;
        String [] columnas = {"ID_DEPARTAMENTO", "NOMBRE_DEPARTAMENTO"};
        model = new DefaultTableModel(null, columnas);
        
        sql = "SELECT Id_departamento, Nombre_departamento FROM TBL_DEPARTAMENTO";
        
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
     
     public void buscarDepartamento(JTable tabla, String buscar){
         
        DefaultTableModel model;
        String [] columnas = {"ID_DEPARTAMENTO", "NOMBRE_DEPARTAMENTO"};
        model = new DefaultTableModel(null, columnas);
        
         sql = "SELECT Id_departamento, Nombre_departamento FROM TBL_DEPARTAMENTO where UPPER(Nombre_departamento) LIKE '%"+buscar+"%'";
        
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
     
     
     
    //este metodo es el de Seleccionar FRM (deberia ir en FDepartamento pero lo coloqué acá) Att. Kevin
     public void mostrarMunicipio( JTable tabla, String buscar){
         
        DefaultTableModel model;
        String [] columnas = {"ID_MUNICIPIO", "NOMBRE_MUNICIPIO"};
        model = new DefaultTableModel(null, columnas);
        
         sql = "SELECT Id_municipio, Nombre_municipio FROM TBL_MUNICIPIO WHERE ID_DEPARTAMENTO = "+buscar+" ORDER BY Nombre_municipio ASC";
        
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
     
        public void buscarMunicipio( JTable tabla, String buscar, String search){
         
        DefaultTableModel model;
        String [] columnas = {"ID_MUNICIPIO", "NOMBRE_MUNICIPIO"};
        model = new DefaultTableModel(null, columnas);
        
        sql = "SELECT Id_municipio, Nombre_municipio FROM TBL_MUNICIPIO WHERE ID_DEPARTAMENTO = "+buscar+" AND  UPPER(NOMBRE_MUNICIPIO) LIKE '%"+search+"%'";
        
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
        
         public void editarSucursal(Sucursal sucursal, String buscar){
        try{
            if(cn!=null){
                PreparedStatement st = cn.prepareStatement("update TBL_SUCURSAL set Id_sucursal='"+sucursal.getId_sucursal()+"',Nombre_sucursal='"+sucursal.getNombre_sucursal()+"',Id_municipio='"+sucursal.getId_municipio() +"', Telefono_sucursal='"+ sucursal.getTelefono()+  "',Correo_sucursal='"+sucursal.getCorreo() +   "',direccion='"+sucursal.getDireccion() +        "' where Id_sucursal="+buscar+"");
                st.execute();
            }else{
                System.out.println("No es posible editar la informacion");
            }
        }
        catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Error al editar, motivo:"+ex.getMessage());
        } 
    }
         
         public void eliminarSucursal(String idEliminar){
        try{
            if(cn!=null){
                PreparedStatement st = cn.prepareStatement("update TBL_SUCURSAL set Estado=0 where Id_sucursal="+idEliminar+"");
                st.execute();
            }else{
                System.out.println("No es posible eliminar el registro");
            }
        }
        catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Error al eliminar, motivo:"+ex.getMessage());
        } 
    }
     
    
    
    
     public DefaultTableModel mostrarSucursal(String buscar) throws SQLException{
             DefaultTableModel modelo;
             
            totalRegistros=0;
            
             String [] encabezado = {"ID","SUCURSAL","MUNICIPIO","DEPARTAMENTO","DIRECCION","TELEFONO","CORREO","ESTADO","ID_MUNICIPIO","ID_DEPARTAMENTO", "FECHA_COMMIT", "HORA_COMMIT"};   
             String [] registros = new String [12];
             
              modelo = new DefaultTableModel(null,encabezado);
              String sql = buscar;
              
              try{
         
         Statement st = cn.createStatement();
         ResultSet rs = st.executeQuery(sql);
          while(rs.next()){
         
             registros[0] = Integer.toString(rs.getInt("Id_sucursal"));
             registros[1] = rs.getString("Nombre_sucursal");
             registros[2] = rs.getString("Nombre_municipio");
             registros[3] = rs.getString("Nombre_departamento");
             registros[4] = rs.getString("direccion");
             registros[5] = rs.getString("Telefono_sucursal");
             registros[6] = rs.getString("Correo_sucursal");
             registros[7] = Integer.toString(rs.getInt("Estado"));
             registros[8] = Integer.toString(rs.getInt("id_municipio"));
             registros[9] = Integer.toString(rs.getInt("id_departamento"));
             registros[10] = rs.getString("Fecha_commit");
             registros[11] = rs.getString("Hora_commit");
             
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
