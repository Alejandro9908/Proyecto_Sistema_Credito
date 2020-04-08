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
public class Direccion {

    /**
     * @return the id_direccion
     */
    public int getId_direccion() {
        return id_direccion;
    }

    /**
     * @param id_direccion the id_direccion to set
     */
    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    /**
     * @return the direccion_cliente
     */
    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    /**
     * @param direccion_cliente the direccion_cliente to set
     */
    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    /**
     * @return the tipo_casa
     */
    public String getTipo_casa() {
        return tipo_casa;
    }

    /**
     * @param tipo_casa the tipo_casa to set
     */
    public void setTipo_casa(String tipo_casa) {
        this.tipo_casa = tipo_casa;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the id_municipio
     */
    public int getId_municipio() {
        return id_municipio;
    }

    /**
     * @param id_municipio the id_municipio to set
     */
    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
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
    
    private int id_direccion;
    private String direccion_cliente;
    private String tipo_casa;
    private String descripcion;
    private String referencia;
    private int id_municipio;
    private int id_usuario;
    
}
