/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisserviciofinanciero;

import controladores.Conexion;
import java.awt.Frame;
import static java.sql.DriverManager.println;
import javax.swing.JFrame;
import vistas.frmEscritorio;

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
        
        frmEscritorio frm_Escritorio1 = new frmEscritorio();
        frm_Escritorio1.setTitle("Sistema de Creditos");
        frm_Escritorio1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm_Escritorio1.setExtendedState(Frame.MAXIMIZED_BOTH);
        frm_Escritorio1.setVisible(true);
        
    }
    
}
