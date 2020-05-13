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
public class Cliente {

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
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the descripcion_direccion
     */
    public String getDescripcion_direccion() {
        return descripcion_direccion;
    }

    /**
     * @param descripcion_direccion the descripcion_direccion to set
     */
    public void setDescripcion_direccion(String descripcion_direccion) {
        this.descripcion_direccion = descripcion_direccion;
    }

    /**
     * @return the referencia_direccion
     */
    public String getReferencia_direccion() {
        return referencia_direccion;
    }

    /**
     * @param referencia_direccion the referencia_direccion to set
     */
    public void setReferencia_direccion(String referencia_direccion) {
        this.referencia_direccion = referencia_direccion;
    }

    /**
     * @return the dpi_referencia
     */
    public String getDpi_referencia() {
        return dpi_referencia;
    }

    /**
     * @param dpi_referencia the dpi_referencia to set
     */
    public void setDpi_referencia(String dpi_referencia) {
        this.dpi_referencia = dpi_referencia;
    }

    /**
     * @return the nombres_referencia
     */
    public String getNombres_referencia() {
        return nombres_referencia;
    }

    /**
     * @param nombres_referencia the nombres_referencia to set
     */
    public void setNombres_referencia(String nombres_referencia) {
        this.nombres_referencia = nombres_referencia;
    }

    /**
     * @return the apellidos_referencia
     */
    public String getApellidos_referencia() {
        return apellidos_referencia;
    }

    /**
     * @param apellidos_referencia the apellidos_referencia to set
     */
    public void setApellidos_referencia(String apellidos_referencia) {
        this.apellidos_referencia = apellidos_referencia;
    }

    /**
     * @return the tipo_referencia
     */
    public String getTipo_referencia() {
        return tipo_referencia;
    }

    /**
     * @param tipo_referencia the tipo_referencia to set
     */
    public void setTipo_referencia(String tipo_referencia) {
        this.tipo_referencia = tipo_referencia;
    }

    /**
     * @return the telefono_referencia
     */
    public String getTelefono_referencia() {
        return telefono_referencia;
    }

    /**
     * @param telefono_referencia the telefono_referencia to set
     */
    public void setTelefono_referencia(String telefono_referencia) {
        this.telefono_referencia = telefono_referencia;
    }

    /**
     * @return the tipo_casa
     */
    public String getTipo_casa() {
        return tipo_casa;
    }

    /**
     * @param tipo_casa the tipo_casa to set
     */
    public void setTipo_casa(String tipo_casa) {
        this.tipo_casa = tipo_casa;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the fecha_nacimiento
     */
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * @param fecha_nacimiento the fecha_nacimiento to set
     */
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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
     * @return the foto
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
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
     * @return the primer_nombre
     */
    public String getPrimer_nombre() {
        return primer_nombre;
    }

    /**
     * @param primer_nombre the primer_nombre to set
     */
    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    /**
     * @return the segundo_nombre
     */
    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    /**
     * @param segundo_nombre the segundo_nombre to set
     */
    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    /**
     * @return the tercer_nombre
     */
    public String getTercer_nombre() {
        return tercer_nombre;
    }

    /**
     * @param tercer_nombre the tercer_nombre to set
     */
    public void setTercer_nombre(String tercer_nombre) {
        this.tercer_nombre = tercer_nombre;
    }

    /**
     * @return the primer_apellido
     */
    public String getPrimer_apellido() {
        return primer_apellido;
    }

    /**
     * @param primer_apellido the primer_apellido to set
     */
    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    /**
     * @return the segundo_apellido
     */
    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    /**
     * @param segundo_apellido the segundo_apellido to set
     */
    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    /**
     * @return the apellido_casado
     */
    public String getApellido_casado() {
        return apellido_casado;
    }

    /**
     * @param apellido_casado the apellido_casado to set
     */
    public void setApellido_casado(String apellido_casado) {
        this.apellido_casado = apellido_casado;
    }

    /**
     * @return the estado_civil
     */
    public String getEstado_civil() {
        return estado_civil;
    }

    /**
     * @param estado_civil the estado_civil to set
     */
    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

  

    /**
     * @return the id_direccion
     */
    public int getId_direccion() {
        return id_direccion;
    }

    /**
     * @param id_direccion the id_direccion to set
     */
    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the profesion
     */
    public String getProfesion() {
        return profesion;
    }

    /**
     * @param profesion the profesion to set
     */
    public void setProfesion(String profesion) {
        this.profesion = profesion;
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
    
    private int id_cliente;
    private String dpi;
    private String primer_nombre;
    private String segundo_nombre;
    private String tercer_nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String apellido_casado;
    private String estado_civil;
    private byte[] foto;
    private int id_direccion;
    private String correo;
    private Date fecha_nacimiento;
    private int id_municipio;
    private int id_departamento;
    private String genero;
    private String profesion;
    private String direccion;
    private int id_usuario;
    
    //otros agregados
    
    private String tipo_casa;
    private String descripcion_direccion;
    private String referencia_direccion;
    private String dpi_referencia;
    private String nombres_referencia;
    private String apellidos_referencia;
    private String tipo_referencia;
    private String telefono_referencia;
    
    
    private String fecha_commit;
    private String hora_commit;
    private String estado;
    
    
    
    
}
