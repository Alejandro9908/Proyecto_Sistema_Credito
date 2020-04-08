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
public class Departamento {

    /**
     * @return the id_departamento
     */
    public int getId_departamento() {
        return id_departamento;
    }

    /**
     * @param id_departamento the id_departamento to set
     */
    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    /**
     * @return the nombre_departamento
     */
    public String getNombre_departamento() {
        return nombre_departamento;
    }

    /**
     * @param nombre_departamento the nombre_departamento to set
     */
    public void setNombre_departamento(String nombre_departamento) {
        this.nombre_departamento = nombre_departamento;
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
    
    private int id_departamento;
    private String nombre_departamento;
    private int id_usuario;
    
}
