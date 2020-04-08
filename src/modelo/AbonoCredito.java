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
public class AbonoCredito {

    /**
     * @return the id_abono
     */
    public int getId_abono() {
        return id_abono;
    }

    /**
     * @param id_abono the id_abono to set
     */
    public void setId_abono(int id_abono) {
        this.id_abono = id_abono;
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
     * @return the pago
     */
    public float getPago() {
        return pago;
    }

    /**
     * @param pago the pago to set
     */
    public void setPago(float pago) {
        this.pago = pago;
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
     * @return the froma_pago
     */
    public String getFroma_pago() {
        return froma_pago;
    }

    /**
     * @param froma_pago the froma_pago to set
     */
    public void setFroma_pago(String froma_pago) {
        this.froma_pago = froma_pago;
    }

    /**
     * @return the banco_cheque
     */
    public String getBanco_cheque() {
        return banco_cheque;
    }

    /**
     * @param banco_cheque the banco_cheque to set
     */
    public void setBanco_cheque(String banco_cheque) {
        this.banco_cheque = banco_cheque;
    }

    /**
     * @return the numero_cheque
     */
    public String getNumero_cheque() {
        return numero_cheque;
    }

    /**
     * @param numero_cheque the numero_cheque to set
     */
    public void setNumero_cheque(String numero_cheque) {
        this.numero_cheque = numero_cheque;
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
    
    private int id_abono;
    private int id_credito;
    private float pago;
    private float mora;
    private float monto;
    private String froma_pago;
    private String banco_cheque;
    private String numero_cheque;
    private int id_usuario;
    
}
