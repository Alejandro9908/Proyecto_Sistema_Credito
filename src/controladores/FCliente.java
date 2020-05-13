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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Departamento;
import modelo.Empleado;
import modelo.Operador;
import modelo.Telefono;


/**
 *
 * @author Kevin
 */
public class FCliente {
    
     public Conexion sqlSERVER = new Conexion();
    public Connection cn = sqlSERVER.Conectar();
    String sql = "";
    public Integer totalRegistros = 0;
    
    
    
     public void guardarCliente(Cliente cliente){
           try{  
                if(cn != null){
                  
                    
                   // sql= "INSERT INTO TBL_EMPLEADO(Id_empleado,Id_sucursal, Dpi, Primer_nombre , Segundo_nombre, Tercer_nombre, Primer_apellido, Segundo_apellido, Apellido_casado, Id_cargo, Estado_civil, Foto, Id_municipio, Telefono, Correo, Fecha_nacimiento, Genero, Profesion, Suledo, Id_usuario, Direccion) VALUES(NEXT VALUE FOR EMPLEADO,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    
                   sql = "INSERT INTO TBL_CLIENTE(Id_cliente,Dpi,Primer_nombre,Segundo_nombre,Tercer_nombre,Primer_apellido,Segundo_apellido,Apellido_casado,\n" +
                        "Estado_civil,Foto,Id_municipio,Correo,Fecha_Nacimiento,Genero,Profesion,Direccion,Tipo_casa,Descripcion_direccion,Referencia_direccion,Dpi_referencia,\n" +
                        "Nombres_referencia,Apellidos_referencia,Tipo_referencia,Telefono_referencia,Id_usuario) VALUES(NEXT VALUE FOR CLIENTE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,\n" +
                        "?,?,?,?,?,?,?,?)";
                   
                   
                    PreparedStatement pst = cn.prepareStatement(sql);
                
                    pst.setString(1, cliente.getDpi());
                    pst.setString(2, cliente.getPrimer_nombre());
                    pst.setString(3, cliente.getSegundo_nombre());
                    pst.setString(4, cliente.getTercer_nombre());           
       
                    pst.setString(5, cliente.getPrimer_apellido());
                    pst.setString(6, cliente.getSegundo_apellido());
                    pst.setString(7, cliente.getApellido_casado());
     
             
                    pst.setString(8, cliente.getEstado_civil());
                    pst.setBytes(9, cliente.getFoto());
                    pst.setInt(10, cliente.getId_municipio());
                    pst.setString(11, cliente.getCorreo());
                    pst.setDate(12, (Date) cliente.getFecha_nacimiento());
                    pst.setString(13, cliente.getGenero());
                    pst.setString(14, cliente.getProfesion());
                    pst.setString(15, cliente.getDireccion());
                    pst.setString(16, cliente.getTipo_casa());
                    pst.setString(17, cliente.getDescripcion_direccion());
                    pst.setString(18, cliente.getReferencia_direccion());
                    pst.setString(19, cliente.getDpi_referencia());
                    pst.setString(20, cliente.getNombres_referencia());
                    pst.setString(21, cliente.getApellidos_referencia());
                    pst.setString(22, cliente.getTipo_referencia());
                    pst.setString(23, cliente.getTelefono_referencia());
                      pst.setInt(24, cliente.getId_usuario());
                                
                    pst.execute(); 
 
                }else{
                    JOptionPane.showMessageDialog(null, "Error al guardar el registro");
                }
            
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al realizar la conexión por"+ e.getMessage() );   
            }    
    }
     
     
     //Metod consultar departamento
     public void consultarOperador(JComboBox<Operador> cbOperador){
       
       sql = "SELECT Id_operador, Nombre_operador FROM TBL_OPERADOR ORDER BY Nombre_operador ASC";
       
       try{
     
         if(cn != null){
         
          Statement st = cn.createStatement();
          ResultSet rs = st.executeQuery(sql);  
          
          while(rs.next()){
          
                 cbOperador.addItem(
                        new Operador(
                            rs.getInt("Id_operador"),
                            rs.getString("Nombre_operador")
                          
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
     
     
     public void consultarIdCliente(JTextField idCliente, String buscar){
                    
        sql = "select Id_cliente from TBL_CLIENTE where Dpi =" + "'" +buscar + "'";
         
        try{
            if(cn!=null){
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);  
    
                while(rs.next()){
                    //el nombre del campo que queremos obtener en la db
                    idCliente.setText(rs.getString("Id_cliente")); 
                }
            }else{
                 JOptionPane.showMessageDialog(null, "No se ha establecido conexion con la db");
            }
             
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }  
    }
     
     
     
     
       public void agregarTelefonos(Telefono telefono){
     try{  
                if(cn != null){
                  
                    sql = "INSERT INTO TBL_TELEFONO(Id_telefono, Telefono, Id_cliente,Id_operador, Id_usuario)VALUES(NEXT VALUE FOR TELEFONO,?,?,?,?)";
                    PreparedStatement pst = cn.prepareStatement(sql);
                
                    pst.setString(1, telefono.getTelefono());
                    pst.setInt(2, telefono.getId_cliente());
                    pst.setInt(3, telefono.getId_operador());
                    pst.setInt(4, telefono.getId_usuario());
                    pst.execute(); 
 
                }else{
                    JOptionPane.showMessageDialog(null, "Error al guardar el registro");
                }
            
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al realizar la conexión por"+ e.getMessage() );   
            }    
    
    }
       
       
     public DefaultTableModel mostrarCliente(String buscar) throws SQLException{
             DefaultTableModel modelo;   
     
     totalRegistros=0;
     
      String [] encabezado = {"ID","DPI","NOMBRE","APELLIDO","FECHA DE NACIMIENTO","ESTADO CIVIL","DIRECCION","MUNICIPIO","DEPARTAMENTO"};   
      String [] registros = new String [9];
     
       modelo = new DefaultTableModel(null,encabezado);
       String sql = buscar;
     
       
        try{
         Statement st = cn.createStatement();
         ResultSet rs = st.executeQuery(sql);
         
          while(rs.next()){
          
           registros[0] = Integer.toString(rs.getInt("Id_cliente"));
           registros[1] = rs.getString("Dpi");
           registros[2] = rs.getString("Primer_nombre");
           registros[3] = rs.getString("Primer_apellido");
           registros[4] = rs.getString("Fecha_Nacimiento");
           registros[5] = rs.getString("Estado_civil");
           registros[6] = rs.getString("Direccion");
           registros[7] = rs.getString("Nombre_municipio");
           registros[8] = rs.getString("Nombre_departamento");
      
              
           totalRegistros += 1;
           modelo.addRow(registros);
            
          
          }
        
        
     return modelo;
        
        
     }catch(Exception e){
         
     JOptionPane.showMessageDialog(null,"No se han podido cargar los datos, motivo: "+e);
     
     return null;
     
     }
     
     
     
     }
     
     
     
      public void editarCliente(Cliente cliente, String buscar){ //el editar foto no funciona por el momento en EDITAR
        try{
            if(cn!=null){
                PreparedStatement st = cn.prepareStatement("update TBL_CLIENTE set Id_cliente='"+cliente.getId_cliente()+"',Dpi='"+cliente.getDpi()+"',Primer_nombre='"+cliente.getPrimer_nombre() +"', Segundo_nombre='"+ cliente.getSegundo_nombre()+  "',Tercer_nombre='"+ cliente.getTercer_nombre()+   "', Primer_apellido='"+ cliente.getPrimer_apellido() + "', Segundo_apellido='"+cliente.getSegundo_apellido()+ "', Apellido_casado='"+ cliente.getApellido_casado()+ "', Estado_civil='"+ cliente.getEstado_civil()+"', Id_municipio='"+ cliente.getId_municipio()+ "', Correo='"+ cliente.getCorreo() + "', Fecha_nacimiento='"+ cliente.getFecha_nacimiento()+ "', Genero='"+ cliente.getGenero() + "', Profesion='"+ cliente.getProfesion() + "', Direccion='"+ cliente.getDireccion()+ "', Tipo_casa='"+ cliente.getTipo_casa() + "', Descripcion_direccion='"+ cliente.getDireccion() + "', Referencia_direccion='"+ cliente.getReferencia_direccion() + "', Dpi_referencia='"+ cliente.getDpi_referencia() + "', Nombres_referencia='"+ cliente.getNombres_referencia() + "', Apellidos_referencia='"+ cliente.getApellidos_referencia() + "', Tipo_referencia='"+ cliente.getTipo_referencia() + "', Telefono_referencia='"+ cliente.getTelefono_referencia() + "' where Id_cliente="+buscar+"");
                st.execute();
            }else{
                System.out.println("No es posible editar la informacion");
            }
        }
        catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Error al editar, motivo:"+ex.getMessage());
        } 
    }
      
      
       public void eliminarCliente(String idEliminar){
        try{
            if(cn!=null){
                PreparedStatement st = cn.prepareStatement("update TBL_CLIENTE set Estado=0 where Id_cliente="+idEliminar+"");
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
