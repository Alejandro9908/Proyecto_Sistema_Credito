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
public class Credito {

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
     * @return the numero_credito
     */
    public String getNumero_credito() {
        return numero_credito;
    }

    /**
     * @param numero_credito the numero_credito to set
     */
    public void setNumero_credito(String numero_credito) {
        this.numero_credito = numero_credito;
    }

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
     * @return the interes
     */
    public float getInteres() {
        return interes;
    }

    /**
     * @param interes the interes to set
     */
    public void setInteres(float interes) {
        this.interes = interes;
    }

    /**
     * @return the capital
     */
    public float getCapital() {
        return capital;
    }

    /**
     * @param capital the capital to set
     */
    public void setCapital(float capital) {
        this.capital = capital;
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
     * @return the pagado
     */
    public int getPagado() {
        return pagado;
    }

    /**
     * @param pagado the pagado to set
     */
    public void setPagado(int pagado) {
        this.pagado = pagado;
    }

    /**
     * @return the porcentaje
     */
    public float getPorcentaje() {
        return porcentaje;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    /**
     * @return the mora
     */
    public float getMora() {
        return mora;
    }

    /**
     * @param mora the mora to set
     */
    public void setMora(float mora) {
        this.mora = mora;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return the id_empleado
     */
    public int getId_empleado() {
        return id_empleado;
    }

    /**
     * @param id_empleado the id_empleado to set
     */
    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
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
    
     public int getId_garantia() {
        return id_garantia;
    }

    public void setId_garantia(int id_garantia) {
        this.id_garantia = id_garantia;
    }

    public Date getFecha_corte() {
        return fecha_corte;
    }

    public void setFecha_corte(Date fecha_corte) {
        this.fecha_corte = fecha_corte;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }
    
    private int id_credito;
    private String numero_credito;
    private int id_cuenta;
    private float monto;
    private float interes;
    private float capital;
    private String plazo;
    private int pagado;
    private float porcentaje;
    private float mora;
    private String destino;
    private int id_empleado;
    private int id_usuario;
    private int id_garantia;
    private Date fecha_corte;
    private Date fecha_pago;
}
