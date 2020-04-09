/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisserviciofinanciero;

import controladores.Conexion;
import static java.sql.DriverManager.println;

/**
 *
 * @author Alejandro
 */
public class SisServicioFinanciero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        println("kol");
        println("Sirve");
        System.out.println("Hola Ya sirve");
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        
    }
    
}
