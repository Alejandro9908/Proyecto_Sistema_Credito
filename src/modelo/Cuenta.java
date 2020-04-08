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
public class Cuenta {

    /**
     * @return the id_cuenta
     */
    public int getId_cuenta() {
        return id_cuenta;
    }

    /**
     * @param id_cuenta the id_cuenta to set
     */
    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    /**
     * @return the numero_cuenta
     */
    public String getNumero_cuenta() {
        return numero_cuenta;
    }

    /**
     * @param numero_cuenta the numero_cuenta to set
     */
    public void setNumero_cuenta(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
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
     * @return the id_referencia
     */
    public int getId_referencia() {
        return id_referencia;
    }

    /**
     * @param id_referencia the id_referencia to set
     */
    public void setId_referencia(int id_referencia) {
        this.id_referencia = id_referencia;
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
    
    private int id_cuenta;
    private String numero_cuenta;
    private int id_cliente;
    private int id_tipo_socio;
    //private Date fecha_apertura;
    private int id_referencia;
    private int id_usuario;
    
}
