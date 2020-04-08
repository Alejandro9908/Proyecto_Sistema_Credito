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
public class TipoGarantia {

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
     * @return the nombre_garantia
     */
    public String getNombre_garantia() {
        return nombre_garantia;
    }

    /**
     * @param nombre_garantia the nombre_garantia to set
     */
    public void setNombre_garantia(String nombre_garantia) {
        this.nombre_garantia = nombre_garantia;
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
   
    private int id_tipo_garantia;
    private String nombre_garantia;
    private String descripcion;
    private int id_usuario;
       
    
}
