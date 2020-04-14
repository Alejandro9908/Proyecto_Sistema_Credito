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
    
    int id_usuario = 1;
    
    String sql = "";
    public Integer totalRegistros = 0;
    String mensaje = "";
    
    public void agregarDepartamentoEm(Connection con,DepartamentoEmpresa departamentoempresa){
    
        PreparedStatement pst = null;
        
        sql = "INSERT INTO TBL_DEPARTAMENTO_EMP(Id_departamento_emp,Nombre_departamento,Descripcion,Id_usuario) VALUES(NEXT VALUE FOR DEPARTAMENTO_EMP, ?,?,?)";
        
        try{
            
            pst = con.prepareStatement(sql);
            pst.setString(2, departamentoempresa.getNombre_departamento());
            pst.setString(3, departamentoempresa.getDescripcion());
            pst.setInt(4, departamentoempresa.getId_usuario());
            
            mensaje = "Guardado correctamente";
            System.out.println("Guardado correctamente");
            pst.execute();
            pst.close();
            
            
        
        }catch(SQLException e){
            mensaje = "No se pudo guardar correctamente: Error: " + e.getMessage();
            System.out.println(mensaje);
            
        }
    
    
    
    }
    
}
