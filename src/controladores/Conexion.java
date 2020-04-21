/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class Conexion {
    
    //Hola como estan
    private static Connection conexion;
    private static String bdName = "DB_Creditos";
    private static String user = "Proyecto_Creditos";//Nombre del usuario
    private static String pass ="admin";//Contraseña del usuario
    private static String url = "jdbc:sqlserver://localhost;databaseName="
                 +bdName+";user="+user+";password="+pass+";"; //url de la base de datos
    
     public Connection getConexion() {
        return conexion;
    }
     
    public static Connection getConnection(){
    
    try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection(url,user,pass);
            conexion.setAutoCommit(false);
           
            
            if(conexion !=null){
                System.out.println("Conexion Exitosa");
            }else{
                System.out.println("Conexion fallida");
            }
            
            
        }catch(ClassNotFoundException | SQLException e){
            
            System.out.println("Error: " + e.getMessage());
            
        }
             
        
        return conexion;
    
    }
    
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    public Connection Conectar()
    { 
    
    //com.microsoft.sqlserver.jdbc.SQLServerDriver
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String BaseDeDatos = "jdbc:sqlserver://localhost;databaseName=DB_Creditos;user=Proyecto_Creditos;password=admin";
        this.conexion= DriverManager.getConnection(BaseDeDatos);
        
        Statement st =  conexion.createStatement();
       /* ResultSet rs = st.executeQuery("SELECT Id_usuario,NIckname,Permisos,Contrasena,Estado FROM TBL_USUARIO");
         
         while(rs.next()){
             
             int ID=rs.getInt(1);
             int ID1=rs.getInt(2);
             String NOMBRE=rs.getString(3);
             String PERMISO=rs.getString(4);
             String CONTRASENA=rs.getString(5);
             int ESTADO=rs.getInt(6);
             System.out.println(ID + " " + ID1 + " " + NOMBRE + " " + PERMISO + " " + CONTRASENA + " " + ESTADO);
         
     }*/
        
        if(this.conexion!=null)
        {
        System.out.println("Conexion exitosa a la base de datos");
        }
        else{System.out.println("Conexion fallida");}
        }
        catch(Exception e)
        {e.printStackTrace();}
     
    return this.conexion;
    
    }
    
    // Metodo publico para cerrar la base de datos
    public void close(){
        try { // lo cargamos en un try por temas de seguridad del cierre de la conexión
            conexion.close();
        } catch (Exception ex) {//si hay un error lo capture
            
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);//para saber en que punto esta el error
        }
    }
    
    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
         
    
}
