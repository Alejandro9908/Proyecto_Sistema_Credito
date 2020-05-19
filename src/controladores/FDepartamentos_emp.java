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
import modelo.DepartamentoEmpresa;


/**
 *
 * @author Carlos
 */
public class FDepartamentos_emp {
     
    public Conexion sqlSERVER = new Conexion();
    public Connection cn = sqlSERVER.Conectar();
    
    String sql = "";
    public Integer totalRegistros = 0;
    String mensaje = "";
    
    public void agregarDepartamentoEm(DepartamentoEmpresa departamentoempresa){
    
        try{
        
            if(cn != null ){
            
            sql = "INSERT INTO TBL_DEPARTAMENTO_EMP(Id_departamento_emp,Nombre_departamento,Descripcion,Id_usuario) VALUES(NEXT VALUE FOR DEPARTAMENTO_EMP,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1, departamentoempresa.getNombre_departamento());
            pst.setString(2, departamentoempresa.getDescripcion());
            pst.setInt(3, departamentoempresa.getId_usuario());
            pst.execute();
            
            }else{
                    JOptionPane.showMessageDialog(null, "Error al guardar el registro");
                }
        
        
        }catch(SQLException e){
        
        JOptionPane.showMessageDialog(null,"Error al realizar la conexión por"+ e.getMessage() );
            
        }
    
    
    }
    
     public DefaultTableModel mostrarDepartamento(String buscar){
            DefaultTableModel modelo;
            
            totalRegistros=0; //para que no se sumen los registros
            
    String [] encabezado = {"ID","DEPARTAMENTO","DESCRIPCION","ESTADO", "FECHA_COMMIT", "HORA_COMMIT", "ID_USUARIO"};   
    String [] registros = new String [7];
    
    modelo = new DefaultTableModel(null,encabezado);
    String sql = buscar;
     
     try{
         
         Statement st = cn.createStatement();
         ResultSet rs = st.executeQuery(sql);
         
         while(rs.next()){
         
             registros[0] = Integer.toString(rs.getInt("Id_departamento_emp"));
             registros[1] = rs.getString("Nombre_departamento");
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
     
     
      public void editarDepartamentoEm(DepartamentoEmpresa departamentoEmpresa, String buscar){
        try{
            if(cn!=null){
                PreparedStatement st = cn.prepareStatement("update TBL_DEPARTAMENTO_EMP set Id_departamento_emp='"+departamentoEmpresa.getId_departamento_emp()+"',Nombre_departamento='"+departamentoEmpresa.getNombre_departamento()+"',Descripcion='"+departamentoEmpresa.getDescripcion()+"' where Id_departamento_emp="+buscar+"");
                st.execute();
            }else{
                System.out.println("No es posible editar la informacion");
            }
        }
        catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Error al editar, motivo:"+ex.getMessage());
        } 
    }
     
      
      public void eliminarDepartamentoEm(String idEliminar){
        try{
            if(cn!=null){
                PreparedStatement st = cn.prepareStatement("update TBL_DEPARTAMENTO_EMP set Estado=0 where Id_departamento_emp="+idEliminar+"");
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
