/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
                registros[1] = Integer.toString(rs.getInt("Capital"));
                registros[2] = Integer.toString(rs.getInt("Interes"));
                registros[3] = Integer.toString(rs.getInt("Mora"));
                registros[4] = Integer.toString(rs.getInt("Total_monto"));
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
}
