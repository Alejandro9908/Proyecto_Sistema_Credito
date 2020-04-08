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
public class DesembolsoCredito {

    /**
     * @return the id_desembolso
     */
    public int getId_desembolso() {
        return id_desembolso;
    }

    /**
     * @param id_desembolso the id_desembolso to set
     */
    public void setId_desembolso(int id_desembolso) {
        this.id_desembolso = id_desembolso;
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
     * @return the forma_pago
     */
    public String getForma_pago() {
        return forma_pago;
    }

    /**
     * @param forma_pago the forma_pago to set
     */
    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
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
    
    private int id_desembolso;
    private int id_credito;
    private float monto;
    private String forma_pago;
    private String banco_cheque;
    private String numero_cheque;
    private int id_usuario;
    
}
