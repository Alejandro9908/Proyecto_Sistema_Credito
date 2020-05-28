/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.AbonoAhorro;
import vistas.frmLogin;

/**
 *
 * @author Kevin
 */
public class FAbonoAhorro {
    
     public Conexion sqlSERVER = new Conexion();
    public Connection cn = sqlSERVER.Conectar();
    String sql = "";
    public Integer totalRegistros = 0;
    
    
     public void agregarAbonoAhorro(AbonoAhorro abonoAhorro){
        try{
        
            if(cn != null ){
            
            sql = "INSERT INTO TBL_ABONO_AHORRO(\n" +
                    "Id_abono_ahorro, Id_ahorro,Monto,Forma_pago, Banco_cheque,Numero_cheque,ID_USUARIO\n" +
                    ")\n" +
                    "VALUES(\n" +
                    "NEXT VALUE FOR ABONO_AHORRO,?,?,?,?,?,?)";
            
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, abonoAhorro.getId_ahorro());
            pst.setFloat(2, abonoAhorro.getMonto());//este es para columna capital
            pst.setString(3, abonoAhorro.getForma_pago());
            pst.setString(4, abonoAhorro.getBanco_cheque());
            pst.setString(5, abonoAhorro.getNumero_cheque());
            //pst.setInt(6,2);
            pst.setInt(6, frmLogin.idUsuarioSystem);
            pst.execute();
            
            
            JOptionPane.showMessageDialog(null, "Se ha realizado la transaccion con exito");
            
            }else{
                    JOptionPane.showMessageDialog(null, "Error al guardar el registro");
                }
        }catch(SQLException e){
        
        JOptionPane.showMessageDialog(null,"Error al realizar la conexión por"+ e.getMessage() );
            
        }
    }
    
    
    
    
    
    
}
