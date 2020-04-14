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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controladores.Conexion;
import modelo.DepartamentoEmpresa;
import vistas.departametoEmpresa.frmNuevoDepartamentoEmpresa;


/**
 *
 * @author DELL
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
    
}
