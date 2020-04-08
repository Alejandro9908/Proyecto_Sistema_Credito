/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Alejandro
 */
public class TipoAhorro {

    /**
     * @return the id_tipo_ahorro
     */
    public int getId_tipo_ahorro() {
        return id_tipo_ahorro;
    }

    /**
     * @param id_tipo_ahorro the id_tipo_ahorro to set
     */
    public void setId_tipo_ahorro(int id_tipo_ahorro) {
        this.id_tipo_ahorro = id_tipo_ahorro;
    }

    /**
     * @return the nombre_ahorro
     */
    public String getNombre_ahorro() {
        return nombre_ahorro;
    }

    /**
     * @param nombre_ahorro the nombre_ahorro to set
     */
    public void setNombre_ahorro(String nombre_ahorro) {
        this.nombre_ahorro = nombre_ahorro;
    }

    /**
     * @return the intereses
     */
    public float getIntereses() {
        return intereses;
    }

    /**
     * @param intereses the intereses to set
     */
    public void setIntereses(float intereses) {
        this.intereses = intereses;
    }

    /**
     * @return the monto
     */
    public float getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }

    /**
     * @return the plazo
     */
    public String getPlazo() {
        return plazo;
    }

    /**
     * @param plazo the plazo to set
     */
    public void setPlazo(String plazo) {
        this.plazo = plazo;
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
    
    private int id_tipo_ahorro;
    private String nombre_ahorro;
    private float intereses;
    private float monto;
    private String plazo;
    //private Date fecha_inicio;
   // private Date fecha_final;
    private int id_usuario;
    
}
