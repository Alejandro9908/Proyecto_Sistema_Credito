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
public class Municipio {

     public Municipio(int idMunicipio, String nombre) {
        this.id_municipio = idMunicipio;
        this.nombre_muncipio = nombre;
     
    }

      @Override
    public String toString(){
        return nombre_muncipio;
    }
    /**
     * @return the id_municipio
     */
    public int getId_municipio() {
        return id_municipio;
    }

    /**
     * @param id_municipio the id_municipio to set
     */
    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }

    /**
     * @return the nombre_muncipio
     */
    public String getNombre_muncipio() {
        return nombre_muncipio;
    }

    /**
     * @param nombre_muncipio the nombre_muncipio to set
     */
    public void setNombre_muncipio(String nombre_muncipio) {
        this.nombre_muncipio = nombre_muncipio;
    }

    /**
     * @return the id_departamento
     */
    public int getId_departamento() {
        return id_departamento;
    }

    /**
     * @param id_departamento the id_departamento to set
     */
    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
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
    
    private int id_municipio;
    private String nombre_muncipio;
    private int id_departamento;
    private int id_usuario;
    
     public Municipio(){
          
      }
    
}
