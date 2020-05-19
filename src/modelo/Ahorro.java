/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static java.sql.JDBCType.DATE;
import java.util.Date;

/**
 *
 * @author Alejandro
 */
public class Ahorro {

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
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
     * @return the inicio
     */
    public Date getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the finall
     */
    public Date getFinall() {
        return finall;
    }

    /**
     * @param finall the finall to set
     */
    public void setFinall(Date finall) {
        this.finall = finall;
    }

    /**
     * @return the pago_mensual
     */
    public float getPago_mensual() {
        return pago_mensual;
    }

    /**
     * @param pago_mensual the pago_mensual to set
     */
    public void setPago_mensual(float pago_mensual) {
        this.pago_mensual = pago_mensual;
    }

    /**
     * @return the isr
     */
    public float getIsr() {
        return isr;
    }

    /**
     * @param isr the isr to set
     */
    public void setIsr(float isr) {
        this.isr = isr;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the dpi
     */
    public String getDpi() {
        return dpi;
    }

    /**
     * @param dpi the dpi to set
     */
    public void setDpi(String dpi) {
        this.dpi = dpi;
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
     * @return the parentesco
     */
    public String getParentesco() {
        return parentesco;
    }

    /**
     * @param parentesco the parentesco to set
     */
    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    /**
     * @return the id_ahorro
     */
    public int getId_ahorro() {
        return id_ahorro;
    }

    /**
     * @param id_ahorro the id_ahorro to set
     */
    public void setId_ahorro(int id_ahorro) {
        this.id_ahorro = id_ahorro;
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
    
    private int id_ahorro;
    private int id_cuenta;
    private int id_tipo_ahorro;
   //private float capital;
    private int id_usuario;
    private float intereses;
    private float monto;
    private String plazo;
    private Date inicio;
    private Date finall;
    private float pago_mensual;
    private float isr;
    private String nombres;
    private String apellidos;
    private String dpi;
    private String telefono;
    private String parentesco;
    private String fecha;
    
    
    
    
}
