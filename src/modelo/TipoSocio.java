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
public class TipoSocio {

    /**
     * @return the id_tipo_socio
     */
    public int getId_tipo_socio() {
        return id_tipo_socio;
    }

    /**
     * @param id_tipo_socio the id_tipo_socio to set
     */
    public void setId_tipo_socio(int id_tipo_socio) {
        this.id_tipo_socio = id_tipo_socio;
    }

    /**
     * @return the clase
     */
    public String getClase() {
        return clase;
    }

    /**
     * @param clase the clase to set
     */
    public void setClase(String clase) {
        this.clase = clase;
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
    
    private int id_tipo_socio;
    private String clase;
    private String descripcion;
    private int id_usuario;
    
    
}
