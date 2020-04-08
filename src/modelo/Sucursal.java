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
public class Sucursal {

    /**
     * @return the id_sucursal
     */
    public int getId_sucursal() {
        return id_sucursal;
    }

    /**
     * @param id_sucursal the id_sucursal to set
     */
    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    /**
     * @return the nombre_sucursal
     */
    public String getNombre_sucursal() {
        return nombre_sucursal;
    }

    /**
     * @param nombre_sucursal the nombre_sucursal to set
     */
    public void setNombre_sucursal(String nombre_sucursal) {
        this.nombre_sucursal = nombre_sucursal;
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
    
    private int id_sucursal;
    private String nombre_sucursal;
    private int id_empleado;
    
    
}
