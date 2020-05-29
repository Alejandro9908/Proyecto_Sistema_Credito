/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Ahorro;

/**
 *
 * @author Carlos
 */
public class FAhorro {
    
    public Conexion sqlSERVER = new Conexion();
    public Connection cn = sqlSERVER.Conectar();
    String sql = "";
    public Integer totalRegistros = 0;
    public Integer totalRefistrosA = 0;
    
     public void mostracliente(JTable tabla){
     
    DefaultTableModel model;
    String [] columnas = {"ID_CUENTA", "NUMERO DE CUENTA","CLIENTE","DPI"};
    model = new DefaultTableModel(null, columnas);
    
    sql = "SELECT a.Id_cuenta,a.Numero_cuenta,CONCAT(b.Primer_nombre,' ',b.Segundo_nombre,' ',b.Primer_apellido,' ',\n" +
          "b.Segundo_apellido),b.Dpi FROM TBL_CUENTA AS a inner join TBL_CLIENTE AS b on a.Id_cliente = b.Id_cliente WHERE b.Estado=1";
     
     String[] filas = new String [4]; //registros
    Statement st = null;
    ResultSet rs = null;
    
     try{
     
    st = cn.createStatement();
    rs = st.executeQuery(sql);   
         
      while(rs.next()){
      
       // es como for (int i=0; i <4; i++)
               for(int i=0; i <4; i++){ //SE DEBE EDITAR DEPENDE DE LOS DATOS EN LA TABLA
                   
                 filas[i] = rs.getString(i+1); 
               }
                totalRegistros += 1;
               model.addRow(filas);
      
      }
     
     tabla.setModel(model);
    
     }catch (Exception e) {
           JOptionPane.showMessageDialog(null, "No se pueden mostrar los datos");
    }
     
     
     }
     
     
     
  public void buscarempleado(JTable tabla, String buscar){
  
   DefaultTableModel model;
   String [] columnas = {"ID_CUENTA", "NUMERO DE CUENTA","CLIENTE","DPI"};
   model = new DefaultTableModel(null, columnas);
   
   sql = "SELECT a.Id_cuenta,a.Numero_cuenta,CONCAT(b.Primer_nombre,' ',b.Segundo_nombre,' ',b.Primer_apellido,' ',\n" +
          "b.Segundo_apellido),b.Dpi FROM TBL_CUENTA AS a inner join TBL_CLIENTE AS b on a.Id_cliente = b.Id_cliente WHERE UPPER(a.Numero_cuenta) LIKE '%"+buscar+"%'";
   
    String[] filas = new String [4]; //registros
        
        Statement st = null;
        ResultSet rs = null;
        
     try{
     
     st = cn.createStatement();
     rs = st.executeQuery(sql);
     
      while(rs.next()){
      
       // es como for (int i=0; i <4; i++)
               for(int i=0; i <4; i++){ //SE DEBE EDITAR DEPENDE DE LOS DATOS EN LA TABLA
                   
                 filas[i] = rs.getString(i+1); 
               }
                totalRegistros += 1;
               model.addRow(filas);
      
      }
     
     tabla.setModel(model);
     
     }catch (Exception e) {
           JOptionPane.showMessageDialog(null, "No se pueden mostrar los datos");
    }   
        
  
  }
  
  public void consultarAhorro(JComboBox cbAhorro){
  
  sql = "SELECT Nombre_ahorro FROM TBL_TIPO_AHORRO where Estado = 1 ORDER BY Nombre_ahorro ASC";
  
  try{
  
  if(cn != null){
  
  Statement st = cn.createStatement();
  ResultSet rs = st.executeQuery(sql);  
          
          while(rs.next()){
          
               cbAhorro.addItem(rs.getString("Nombre_ahorro"));
          
          }
  }else{
          
         JOptionPane.showMessageDialog(null, "No se ha establecido conexion con la db");
         
         }

  }catch(Exception e){
         
          JOptionPane.showMessageDialog(null, e);
     
     }
  
  }
  
  
  //CONSULTAR ID DEL DEPARTAMENTO DE LA EMPRESA Y SE LO MANDAMOS A UN TXT
   public void consultarIdahorro(JTextField idepartamento, String buscar){
   
   sql ="SELECT Id_tipo_ahorro FROM TBL_TIPO_AHORRO WHERE Nombre_ahorro=" + "'" +buscar + "'";
   
   try{
   
   if(cn != null){
   
   Statement st = cn.createStatement();
          ResultSet rs = st.executeQuery(sql);  
          
          
          while(rs.next()){
          
              idepartamento.setText(rs.getString("Id_tipo_ahorro"));
          
          }
   
   }else{
              JOptionPane.showMessageDialog(null, "No se ha establecido conexion con la db");
            } 
    
   }catch(Exception e){
     
     }
   
   
   }
  
   public void guardarAhorro(Ahorro ahorro){
     try{
         
          if(cn != null ){
           
              sql = "INSERT INTO TBL_AHORRO(Id_ahorro,Id_tipo_ahorro,Id_usuario,ID_CUENTA,Intereses,Monto,Plazo,Fecha_final,\n" +
                     "Pago_mensual,Isr,Nombre,Apellido,Dpi,Telefono,Parentesco)VALUES(NEXT VALUE FOR AHORRO,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
              
              PreparedStatement pst = cn.prepareStatement(sql);
              
              pst.setInt(1, ahorro.getId_tipo_ahorro());
              pst.setInt(2, ahorro.getId_usuario());
              pst.setInt(3, ahorro.getId_cuenta());
              pst.setFloat(4, ahorro.getIntereses());
              pst.setFloat(5, ahorro.getMonto());
              pst.setString(6, ahorro.getPlazo());
              //pst.setDate(7, (Date) ahorro.getFinall());
              pst.setString(7, ahorro.getFecha());
              pst.setFloat(8, ahorro.getPago_mensual());
              pst.setFloat(9, ahorro.getIsr());
              pst.setString(10, ahorro.getNombres());
              pst.setString(11, ahorro.getApellidos());
              pst.setString(12, ahorro.getTelefono());
              pst.setString(13, ahorro.getDpi());
              pst.setString(14, ahorro.getParentesco());
              
             
                pst.execute(); 
                
                //JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
              
          }else{
                JOptionPane.showMessageDialog(null, "Error al guardar el registro");
               }
          
      }catch(SQLException e){
          
        JOptionPane.showMessageDialog(null,"Error al realizar la conexión por"+ e.getMessage());
      }
       
   }
   
   public DefaultTableModel mostrarAhorro(String buscar){
   
    DefaultTableModel modelo;
   
            totalRegistros=0;
            
     String [] encabezado = {"ID","NO.CUENTA","TIPO DE AHORRO","CLIENTE","DPI","BENEFICIARIO","MONTO","PAGO PROGRAMADO","INTERES","PLAZO","FECHA RETIRO","ID1"};
     String [] registros = new String [12];  
     modelo = new DefaultTableModel(null,encabezado);
     String sql = buscar;
     
     try{
     
      Statement st = cn.createStatement();
         ResultSet rs = st.executeQuery(sql);
         
         
          while(rs.next()){
          
           for(int i=0; i <12; i++){ //SE DEBE EDITAR DEPENDE DE LOS DATOS EN LA TABLA
                   
                 registros[i] = rs.getString(i+1); 
               }
               
       totalRegistros += 1;
       modelo.addRow(registros); 
          
          }
          
          return modelo;
     
     }catch(Exception e){
         
     JOptionPane.showMessageDialog(null,"No se han podido cargar los datos, motivo: "+e);
     
     return null;
     }
   
   
   }
   
   public DefaultTableModel mostrarAhorros(String buscar){
   
    DefaultTableModel modelo;
    String [] encabezado = {"ID","NO.CUENTA","TIPO DE AHORRO","CLIENTE","DPI","BENEFICIARIO","MONTO","PAGO PROGRAMADO","INTERES","PLAZO","FECHA RETIRO"};
     String [] registros = new String [11];  
     modelo = new DefaultTableModel(null,encabezado);
     String sql = buscar;
     
   try{
       
   Statement st = cn.createStatement();
   ResultSet rs = st.executeQuery(sql);
   
    while(rs.next()){
    
         for(int i=0; i <11; i++){ //SE DEBE EDITAR DEPENDE DE LOS DATOS EN LA TABLA
                   
                 registros[i] = rs.getString(i+1); 
               }
        
         modelo.addRow(registros); 
    }
   return modelo;
   
   }catch(Exception e){
         
     JOptionPane.showMessageDialog(null,"No se han podido cargar los datos, motivo: "+e);
     
     return null;
     }
 
    
   }
   
    public DefaultTableModel mostrarCreditos(String buscar){
    
    DefaultTableModel modelo;
    String [] encabezado ={"ID","NO.CREDITO","NO.CUENTA","ID1","CLIENTE","DPI","DESCRIPCION","GARANTIA","NICK","ASESOR","MONTO","INTERESES","CAPITAL","PAGADO","MONTO RESTANTE","PLAZO","MORA","FECHA DE PAGO","FECHA DE CORTE"};       
     String [] registros = new String [19];  
     modelo = new DefaultTableModel(null,encabezado);
     String sql = buscar;
    
    try{
    Statement st = cn.createStatement();
   ResultSet rs = st.executeQuery(sql);
    while(rs.next()){
    
         for(int i=0; i <19; i++){ //SE DEBE EDITAR DEPENDE DE LOS DATOS EN LA TABLA
                   
                 registros[i] = rs.getString(i+1); 
               }
        
         modelo.addRow(registros); 
    
    }
     return modelo;
    
    }catch(Exception e){
         
     JOptionPane.showMessageDialog(null,"No se han podido cargar los datos, motivo: "+e);
     
     return null;
     }
    
    } 
    
    
     public DefaultTableModel mostrarAbono(String buscar){
     
    DefaultTableModel modelo;
    totalRefistrosA=0;
    String [] registros = new String [5];  
    String [] encabezado ={"ID","ID1","AHORRO REALIZADO","FECHA","HORA"};
    modelo = new DefaultTableModel(null,encabezado);
    String sql = buscar;
     
    try{
        
        Statement st = cn.createStatement();
     ResultSet rs = st.executeQuery(sql);
     
         while(rs.next()){
     
       for(int i=0; i <5; i++){ //SE DEBE EDITAR DEPENDE DE LOS DATOS EN LA TABLA
                   
                 registros[i] = rs.getString(i+1); 
                 
               }
       
        totalRefistrosA += 1;
         modelo.addRow(registros); 
     
     
     }
          
    return modelo;
    }catch(Exception e){
         
     JOptionPane.showMessageDialog(null,"No se han podido cargar los datos, motivo: "+e);
     
     return null;
     }
     
     
     
     }
    
   

}
