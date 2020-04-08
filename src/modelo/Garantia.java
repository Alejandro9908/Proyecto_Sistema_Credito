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
public class Garantia {

    /**
     * @return the id_garantia
     */
    public int getId_garantia() {
        return id_garantia;
    }

    /**
     * @param id_garantia the id_garantia to set
     */
    public void setId_garantia(int id_garantia) {
        this.id_garantia = id_garantia;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the id_credito
     */
    public int getId_credito() {
        return id_credito;
    }

    /**
     * @param id_credito the id_credito to set
     */
    public void setId_credito(int id_credito) {
        this.id_credito = id_credito;
    }

    /**
     * @return the id_tipo_garantia
     */
    public int getId_tipo_garantia() {
        return id_tipo_garantia;
    }

    /**
     * @param id_tipo_garantia the id_tipo_garantia to set
     */
    public void setId_tipo_garantia(int id_tipo_garantia) {
        this.id_tipo_garantia = id_tipo_garantia;
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
     * @return the fotografia
     */
    public byte getFotografia() {
        return fotografia;
    }

    /**
     * @param fotografia the fotografia to set
     */
    public void setFotografia(byte fotografia) {
        this.fotografia = fotografia;
    }

    /**
     * @return the valuacion
     */
    public float getValuacion() {
        return valuacion;
    }

    /**
     * @param valuacion the valuacion to set
     */
    public void setValuacion(float valuacion) {
        this.valuacion = valuacion;
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
    
    private int id_garantia;
    private String nombre;
    private int id_credito;
    private int id_tipo_garantia;
    private String descripcion;
    private byte fotografia;
    private float valuacion;
    private int id_usuario;
            
    
}
