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
import modelo.Cuenta;

/**
 *
 * @author Alejandro
 */
public class FCuenta {
    public Conexion sqlSERVER = new Conexion();
    public Connection cn = sqlSERVER.Conectar();
    String sql = "";
    public Integer totalRegistros = 0;
    
    public DefaultTableModel mostrarCuentas(String buscar){
        DefaultTableModel modelo;
        totalRegistros=0;
           
        String [] encabezado = {"ID","CUENTA NO.","CLIENTE","CLASE","FECHA DE APERTURA"};   
        String [] registros = new String [5];
    
        modelo = new DefaultTableModel(null,encabezado);
        String sql = buscar;
    
        try{

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                registros[0] = Integer.toString(rs.getInt("Id_cuenta"));
                registros[1] = rs.getString("Numero_cuenta");
                registros[2] = rs.getString("CLIENTE");
                registros[3] = rs.getString("Clase");
                registros[4] = rs.getString("Fecha_apertura");
                totalRegistros += 1;
                modelo.addRow(registros);
            }  
         
            return modelo;
     
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se han podido cargar los datos, motivo: "+e);
            return null;
        }
    }
    
    public Cuenta mostrarDetalles(int id){
        Cuenta c = new Cuenta();
        System.out.println(id);
        String sql = "SELECT CU.Id_cliente, \n" +
                    "CU.Numero_cuenta, \n" +
                    "CL.Primer_nombre,\n" +
                    "CL.Segundo_nombre,\n" +
                    "CL.Tercer_nombre,\n" +
                    "CL.Primer_apellido,\n" +
                    "CL.Segundo_apellido,\n" +
                    "CL.Apellido_casado,\n" +
                    "CU.Estado,   \n" +
                    "T.Clase,\n" +
                    "FORMAT(CU.Fecha_apertura,'dd-MM-yyyy')AS FECHA_APERTURA,\n" +
                    "FORMAT(CU.Fecha_commit,'dd-MM-yyyy') as FECHA_COMMIT,\n" +
                    "CU.Hora_commit,\n" +
                    "U.NIckname\n" +
                    "FROM TBL_CUENTA AS CU\n" +
                    "JOIN TBL_CLIENTE AS CL ON CU.Id_cliente = CL.Id_cliente\n" +
                    "JOIN TBL_TIPO_SOCIO AS T ON T.Id_tipo_socio = CU.Id_tipo_socio\n" +
                    "JOIN TBL_USUARIO AS U ON U.Id_usuario = CU.Id_usuario\n" +
                    "WHERE Id_cuenta = '"+id+"'";
        
    
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                c.setId_cliente(rs.getString("Id_cliente"));
                c.setNumero_cuenta(rs.getString("Numero_cuenta"));
                c.setPrimer_nombre(rs.getString("Primer_nombre"));
                c.setSegundo_nombre(rs.getString("Segundo_nombre"));
                c.setTercer_nombre(rs.getString("Tercer_nombre"));
                c.setPrimer_apellido(rs.getString("Primer_apellido"));
                c.setSegundo_apellido(rs.getString("Segundo_apellido"));
                c.setApellido_casado(rs.getString("Apellido_casado"));
                c.setEstado(rs.getString("Estado"));
                c.setId_tipo_socio(rs.getString("Clase"));
                c.setFecha_apertura(rs.getString("FECHA_APERTURA"));
                c.setFecha_commit(rs.getString("FECHA_COMMIT"));
                c.setHora_commit(rs.getString("Hora_commit"));
                c.setId_usuario(rs.getString("NIckname"));
            }  
            return c;
     
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se han podido cargar los datos, motivo: "+e);
            return null;
        }
    }
}
