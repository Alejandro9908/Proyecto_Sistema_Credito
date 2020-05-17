
package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Garantia;
import modelo.Usuario;

/**
 *
 * @author DELL
 */
public class FUsuario {
    
    public Conexion sqlSERVER = new Conexion();
    public Connection cn = sqlSERVER.Conectar();
    String sql = "";
    public Integer totalRegistros = 0;
    
    public void guardarUsuarioo(Usuario usuario){
        
        
         try{  
                if(cn != null){
                  
                    sql = "INSERT INTO TBL_USUARIO(Id_usuario,Id_empleado,NIckname,Permisos,Contrasena) VALUES(NEXT VALUE FOR USUARIO,?,?,?,? )";
                    PreparedStatement pst = cn.prepareStatement(sql);
                
                   pst.setInt(1, usuario.getId_empleado());
                   pst.setString(2, usuario.getNickname());
                   pst.setString(3, usuario.getPermisasos());
                   pst.setString(4, usuario.getContrasena());
                   
                
                    pst.execute(); 
 
                }else{
                    JOptionPane.showMessageDialog(null, "Error al guardar el registro");
                }
            
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al realizar la conexión por"+ e.getMessage() );   
            }   
    }
    
    
     public void mostraempleado(JTable tabla){
     
    DefaultTableModel model;
    String [] columnas = {"ID_EMPLEADO", "DPI","EMPLEADO"};
    model = new DefaultTableModel(null, columnas);
    
    sql = "SELECT Id_empleado,Dpi,CONCAT(Primer_nombre,' ',Segundo_nombre,' ',Tercer_nombre,' ',Primer_apellido,' ',Segundo_apellido,' ',\n" +
           "Apellido_casado) FROM TBL_EMPLEADO";
    
    String[] filas = new String [3]; //registros
    
    Statement st = null;
    ResultSet rs = null;
    
    try{
        
    st = cn.createStatement();
    rs = st.executeQuery(sql);  
    
    while(rs.next()){
    
          // es como for (int i=0; i <4; i++)
               for(int i=0; i <3; i++){ //SE DEBE EDITAR DEPENDE DE LOS DATOS EN LA TABLA
                   
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
    String [] columnas = {"ID_EMPLEADO", "DPI","EMPLEADO"};
    model = new DefaultTableModel(null, columnas);
    
    sql = "SELECT Id_empleado,Dpi,CONCAT(Primer_nombre,' ',Segundo_nombre,' ',Tercer_nombre,' ',Primer_apellido,' ',Segundo_apellido,' ',\n" +
           "Apellido_casado) FROM TBL_EMPLEADO WHERE UPPER(CONCAT(Primer_nombre,' ',Segundo_nombre,' ',Tercer_nombre,' ',Primer_apellido,' ',Segundo_apellido,' ',\n" +
           "Apellido_casado)) LIKE '%"+buscar+"%'";
    
    String[] filas = new String [3]; //registros
        
        Statement st = null;
        ResultSet rs = null;
        
    try{
    
     st = cn.createStatement();
     rs = st.executeQuery(sql);   
        
     while(rs.next()){
    
          // es como for (int i=0; i <4; i++)
               for(int i=0; i <3; i++){ //SE DEBE EDITAR DEPENDE DE LOS DATOS EN LA TABLA
                   
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
    
    
    public DefaultTableModel mostrarUsuarioInx(String buscar){
        
        DefaultTableModel modelo;
   
            totalRegistros=0;
            
       String [] encabezado = {"ID","DPI","NOMBRE","ID_EMPLEADO","NICKNAME","PERMISO","CONTRASEÑA"};
       String [] registros = new String [7];  
       modelo = new DefaultTableModel(null,encabezado);
       String sql = buscar;
       
       try{
           
            
         Statement st = cn.createStatement();
         ResultSet rs = st.executeQuery(sql);
         
         while(rs.next()){
             
        for(int i=0; i <7; i++){ //SE DEBE EDITAR DEPENDE DE LOS DATOS EN LA TABLA
                   
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
    
    public void eliminarUsuario(String idEliminar){
    
        try{
            if(cn!=null){
                PreparedStatement st = cn.prepareStatement("update TBL_USUARIO set Estado=0 where Id_usuario="+idEliminar+"");
                st.execute();
            }else{
                System.out.println("No es posible eliminar el registro");
            }
        }
        catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Error al eliminar, motivo:"+ex.getMessage());
        } 
    
    
    }
    
  public void editarUsuario(Usuario usuario, String buscar){
      
      try{
          
          if(cn!=null){
          PreparedStatement st = cn.prepareStatement("update TBL_USUARIO set NIckname='"+usuario.getNickname()+"',Permisos='"+usuario.getPermisasos()+"',Contrasena='"+usuario.getContrasena()+"' where Id_usuario="+buscar+"");
          st.execute();
          
          }else{
                System.out.println("No es posible editar la informacion");
            }
      
      
      }catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Error al editar, motivo:"+ex.getMessage());
        } 
  
  
  
  
  }  
    
    
    
}
