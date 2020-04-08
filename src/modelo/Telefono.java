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
public class Telefono {

    /**
     * @return the id_telefono
     */
    public int getId_telefono() {
        return id_telefono;
    }

    /**
     * @param id_telefono the id_telefono to set
     */
    public void setId_telefono(int id_telefono) {
        this.id_telefono = id_telefono;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the id_cliente
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

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
    
    private int id_telefono;
    private String telefono;
    private int id_cliente;
    private int id_operador;
    private int id_usuario;
            
    
}
