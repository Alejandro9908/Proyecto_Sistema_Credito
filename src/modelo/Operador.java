/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Alejandro
 */
public class Operador {

    /**
     * @return the id_operador
     */
    public int getId_operador() {
        return id_operador;
    }

    /**
     * @param id_operador the id_operador to set
     */
    public void setId_operador(int id_operador) {
        this.id_operador = id_operador;
    }

    /**
     * @return the nombre_operador
     */
    public String getNombre_operador() {
        return nombre_operador;
    }

    /**
     * @param nombre_operador the nombre_operador to set
     */
    public void setNombre_operador(String nombre_operador) {
        this.nombre_operador = nombre_operador;
    }

    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    private int id_operador;
    private String nombre_operador;
    private int id_usuario;
    
    
}
