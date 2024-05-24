package com.bdcuadernillo2.SGNC.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "alumnos")
public class alumnos {

    /**
     * El campo `alu_matricula` es la clave primaria de la entidad.
     */
    @Id
    private String alu_matricula;

    /**
     * El campo `alu_nombre` representa el nombre del estudiante.
     */
    private String alu_nombre;

    /**
     * El campo `alu_apellido` representa el apellido del estudiante.
     */
    private String alu_apellido;

    /**
     * El campo `alu_carrera` representa la carrera del estudiante.
     */
    private String alu_carrera;

    /**
     * El campo `alu_correo` representa el correo electrónico del estudiante.
     */
    private String alu_correo;

    /**
     * El campo `alu_password` representa la contraseña del estudiante.
     */
    private String alu_password;

    /**
     * Obtiene el valor del campo `alu_nombre`.
     *
     * @return el nombre del estudiante.
     */
    public String getAlu_nombre() {
        return alu_nombre;
    }

    /**
     * Establece el valor del campo `alu_nombre`.
     *
     * @param alu_nombre el nombre del estudiante.
     */
    public void setAlu_nombre(String alu_nombre) {
        this.alu_nombre = alu_nombre;
    }

    /**
     * Obtiene el valor del campo `alu_apellido`.
     *
     * @return el apellido del estudiante.
     */
    public String getAlu_apellido() {
        return alu_apellido;
    }

    /**
     * Establece el valor del campo `alu_apellido`.
     *
     * @param alu_apellido el apellido del estudiante.
     */
    public void setAlu_apellido(String alu_apellido) {
        this.alu_apellido = alu_apellido;
    }

    /**
     * Obtiene el valor del campo `alu_carrera`.
     *
     * @return la carrera del estudiante.
     */
    public String getAlu_carrera() {
        return alu_carrera;
    }

    /**
     * Establece el valor del campo `alu_carrera`.
     *
     * @param alu_carrera la carrera del estudiante.
     */
    public void setAlu_carrera(String alu_carrera) {
        this.alu_carrera = alu_carrera;
    }

    /**
     * Obtiene el valor del campo `alu_correo`.
     *
     * @return el correo electrónico del estudiante.
     */
    public String getAlu_correo() {
        return alu_correo;
    }

    /**
     * Establece el valor del campo `alu_correo`.
     *
     * @param alu_correo el correo electrónico del estudiante.
     */
    public void setAlu_correo(String alu_correo) {
        this.alu_correo = alu_correo;
    }

    /**
     * Obtiene el valor del campo `alu_password`.
     *
     * @return la contraseña del estudiante.
     */
    public String getAlu_password() {
        return alu_password;
    }

    /**
     * Establece el valor del campo `alu_password`.
     *
     * @param alu_password la contraseña del estudiante.
     */
    public void setAlu_password(String alu_password) {
        this.alu_password = alu_password;
    }

    /**
     * Obtiene el valor del campo `alu_matricula`.
     *
     * @return la matrícula del estudiante.
     */
    public String getAlu_matricula() {
        return alu_matricula;
    }

    /**
     * Establece el valor del campo `alu_matricula`.
     *
     * @param alu_matricula la matrícula del estudiante.
     */
    public void setAlu_matricula(String alu_matricula) {
        this.alu_matricula = alu_matricula;
    }
}
