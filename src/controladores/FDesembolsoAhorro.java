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
import modelo.DesembolsoAhorro;
import modelo.DesembolsoCredito;
import vistas.frmLogin;

/**
 *
 * @author Alejandro
 */
public class FDesembolsoAhorro {
    public Conexion sqlSERVER = new Conexion();
    public Connection cn = sqlSERVER.Conectar();
    String sql = "";
    public Integer totalRegistros = 0;
    
    
    public void agregarDesembolso(DesembolsoAhorro desembolso){
        
     try{
         
          if(cn != null ){
           
                sql = "INSERT INTO TBL_DESEMBOLSO_AHORRO(Id_desembolso_ahorro,Id_ahorro,Monto,ID_USUARIO)\n" +
                     "VALUES(NEXT VALUE FOR DESEMBOLSO_AHORRO,?,?,?)";
              
                PreparedStatement pst = cn.prepareStatement(sql);
                
                pst.setInt(1, desembolso.getId_ahorro());
                pst.setFloat(2, desembolso.getMonto());
                pst.setInt(3, frmLogin.idUsuarioSystem);

                pst.execute(); 
                //JOptionPane.showMessageDialog(null, "Desembolso guardado correctamente");
          }else{
                JOptionPane.showMessageDialog(null, "Error al guardar el registro");
               }
          
      }catch(SQLException e){
          
        JOptionPane.showMessageDialog(null,"Error al realizar la conexión por"+ e.getMessage());
      }
    
    
    }
    
    public float mostrarCapitalActual(int buscar){
        float monto = 0;
        
    
        String sql = "SELECT MONTO FROM TBL_AHORRO WHERE Id_ahorro = '"+buscar+"'";
    
        try{
         
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
         
            while(rs.next()){      
                monto = rs.getInt("MONTO");
            }
         
            return monto;
     
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se han podido cargar los datos, motivo: "+e);
            return monto;
        }
    
    }
}
