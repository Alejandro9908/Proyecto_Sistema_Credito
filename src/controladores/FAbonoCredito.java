/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.AbonoCredito;
import vistas.frmLogin;

/**
 *
 * @author Alejandro
 */
public class FAbonoCredito {
    public Conexion sqlSERVER = new Conexion();
    public Connection cn = sqlSERVER.Conectar();
    String sql = "";
    public Integer totalRegistros = 0;
    
    public DefaultTableModel mostrarAbonos(String buscar){
        DefaultTableModel modelo;
        totalRegistros=0;
           
        String [] encabezado = {"ID","CAPITAL","INTERES","MORA","TOTAL","FECHA LIMITE"};   
        String [] registros = new String [6];
    
        modelo = new DefaultTableModel(null,encabezado);
        String sql = buscar;
    
        try{

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                registros[0] = Integer.toString(rs.getInt("Id_abono"));
                registros[1] = Float.toString(rs.getFloat("Capital"));
                registros[2] = Float.toString(rs.getFloat("Interes"));
                registros[3] = Float.toString(rs.getFloat("Mora"));
                registros[4] = Float.toString(rs.getFloat("Total_monto"));
                registros[5] = rs.getString("fecha_pago");
                totalRegistros += 1;
                modelo.addRow(registros);
            }  
         
            return modelo;
     
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se han podido cargar los datos, motivo: "+e);
            return null;
        }
    }
    
    public void consultaMora(int idCredito,int idAbono, String fechaPago, float montoMes){
        try{
     
            CallableStatement cst = cn.prepareCall("{call ACTUALIZAR_MORA (?,?,?,?)}");
            cst.setInt(1, idCredito);
            cst.setInt(2, idAbono);
            cst.setString(3, fechaPago);
            cst.setFloat(4, montoMes);
            cst.execute();
              
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se han podido cargar los datos, motivo: "+e);
    
        }
    }
    
    
    public void consultaFecha(int idCredito){
        String sql = "SELECT TOP 1 DATEADD(MONTH,+1,fecha_corte) AS FECHA_CORTE, DATEADD(MONTH,+1,fecha_pago) AS FECHA_PAGO, Estado\n" +
                        "FROM TBL_ABONO_CREDITO WHERE Id_credito = '"+idCredito+"' AND Estado =1 OR Estado = 0 ORDER BY fecha_corte DESC";
        
        String fechaCorte = "";
        String fechaPago = "";
        try{

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                fechaCorte = rs.getString("FECHA_CORTE");
                fechaPago = rs.getString("FECHA_PAGO");
                cargarAbono(fechaCorte, fechaPago, idCredito);
            }  
         
           
     
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se han podido cargar los datos, motivo: "+e);
    
        }
    }
    
    public void cargarAbono(String fechaCorte, String fechaPago, int idCredito){

        try{

           
            CallableStatement cst = cn.prepareCall("{call CREAR_NUEVO_ABONO (?,?,?)}");
            cst.setInt(1, idCredito);
            cst.setString(2, fechaCorte);
            cst.setString(3, fechaPago);
            cst.execute();
               
       
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se han podido cargar los datos, motivo: "+e);
    
        }
    }
    
    public void agregarAbono(AbonoCredito abonoCredito, String buscar,float total){
        try{
            if(cn!=null){
                PreparedStatement st = cn.prepareStatement("UPDATE TBL_ABONO_CREDITO SET\n" +
                                                    "Forma_pago = '"+abonoCredito.getFroma_pago()+"',\n" +
                                                    "Banco_cheque = '"+abonoCredito.getBanco_cheque()+"',\n" +
                                                    "Numero_cheque = '"+abonoCredito.getNumero_cheque()+"',\n" +
                                                    "ID_USUARIO = '"+frmLogin.idUsuarioSystem+"',\n" +
                                                    "Total_monto = '"+total+"',\n" +
                                                    "Fecha_commit = CAST(GETDATE() AS DATE),\n" +
                                                    "Hora_commit = CAST(GETDATE() AS TIME),\n" +
                                                    "Estado = 0\n" +
                                                    "WHERE Id_abono = '"+buscar+"'");
                st.execute();
                JOptionPane.showMessageDialog(null, "La opereción se ha completado con éxito");
            }else{
                System.out.println("No es posible completar la operacion");
            }
        }
        catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Error al completar la operacion, motivo:"+ex.getMessage());
        } 
        
    }
    
    public void agregarAbonoCapital(AbonoCredito abonoCredito){
        try{
        
            if(cn != null ){
            
            sql = "INSERT INTO TBL_ABONO_CREDITO(\n" +
                    "Id_abono,Id_credito,Capital,Forma_pago, Banco_cheque,Numero_cheque,Estado,ID_USUARIO\n" +
                    ")\n" +
                    "VALUES(\n" +
                    "NEXT VALUE FOR ABONO_CREDITO,?,?,?,?,?,?,?)";
            
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, abonoCredito.getId_credito());
            pst.setFloat(2, abonoCredito.getMonto());//este es para columna capital
            pst.setString(3, abonoCredito.getFroma_pago());
            pst.setString(4, abonoCredito.getBanco_cheque());
            pst.setString(5, abonoCredito.getNumero_cheque());
            pst.setInt(6,2);
            pst.setInt(7, frmLogin.idUsuarioSystem);
            pst.execute();
            JOptionPane.showMessageDialog(null, "La opereción se ha completado con éxito");
            }else{
                    JOptionPane.showMessageDialog(null, "Error al guardar el registro");
                }
        
        
        }catch(SQLException e){
        
        JOptionPane.showMessageDialog(null,"Error al realizar la conexión por"+ e.getMessage() );
            
        }
    }
    
}
