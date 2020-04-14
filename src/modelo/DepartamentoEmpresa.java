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
public class DepartamentoEmpresa {

    /**
     * @return the fecha_commit
     */
    public String getFecha_commit() {
        return fecha_commit;
    }

    /**
     * @param fecha_commit the fecha_commit to set
     */
    public void setFecha_commit(String fecha_commit) {
        this.fecha_commit = fecha_commit;
    }

    /**
     * @return the hora_commit
     */
    public String getHora_commit() {
        return hora_commit;
    }

    /**
     * @param hora_commit the hora_commit to set
     */
    public void setHora_commit(String hora_commit) {
        this.hora_commit = hora_commit;
    }

    /**
     * @return the id_departamento_emp
     */
    public int getId_departamento_emp() {
        return id_departamento_emp;
    }

    /**
     * @param id_departamento_emp the id_departamento_emp to set
     */
    public void setId_departamento_emp(int id_departamento_emp) {
        this.id_departamento_emp = id_departamento_emp;
    }

    /**
     * @return the nombre_departamento
     */
    public String getNombre_departamento() {
        return nombre_departamento;
    }

    /**
     * @param nombre_departamento the nombre_departamento to set
     */
    public void setNombre_departamento(String nombre_departamento) {
        this.nombre_departamento = nombre_departamento;
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
    
    private int id_departamento_emp;
    private String nombre_departamento;
    private String descripcion;
    private int id_usuario;
    
    private String fecha_commit;
    private String hora_commit;

    public void agregarDepartamentoEm(DepartamentoEmpresa departamentoempresa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
