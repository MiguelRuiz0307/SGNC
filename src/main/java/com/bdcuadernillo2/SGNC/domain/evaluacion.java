package com.bdcuadernillo2.SGNC.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "evaluacion")
public class evaluacion {

    /**
     * El campo `eva_id` es la clave primaria de la entidad. Se genera
     * automáticamente con una estrategia de generación de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eva_id;

    /**
     * El campo `eva_num_aleatorios` representa el número aleatorio de la
     * evaluación.
     */
    private String eva_num_aleatorios;

    /**
     * El campo `eva_fecha` representa la fecha de la evaluación. Se mapea a un
     * tipo de dato de fecha en la base de datos.
     */
    @Temporal(TemporalType.DATE)
    private Date eva_fecha;

    /**
     * El campo `alumno` establece una relación de muchos a uno con la entidad
     * `alumnos`. El campo `alu_matricula` en la tabla `evaluacion` actúa como
     * la clave externa.
     */
    @ManyToOne
    @JoinColumn(name = "alu_matricula")
    private alumnos alumno;

    /**
     * El campo `cuadernillo` establece una relación de muchos a uno con la
     * entidad `cuadernillo`. El campo `cua_clave` en la tabla `evaluacion`
     * actúa como la clave externa.
     */
    @ManyToOne
    @JoinColumn(name = "cua_clave")
    private cuadernillo cuadernillo;

    /**
     * Obtiene el valor del campo `eva_id`.
     *
     * @return el identificador de la evaluación.
     */
    public int getEva_id() {
        return eva_id;
    }

    /**
     * Establece el valor del campo `eva_id`.
     *
     * @param eva_id el identificador de la evaluación.
     */
    public void setEva_id(int eva_id) {
        this.eva_id = eva_id;
    }

    /**
     * Obtiene el valor del campo `eva_num_aleatorios`.
     *
     * @return el número aleatorio de la evaluación.
     */
    public String getEva_num_aleatorios() {
        return eva_num_aleatorios;
    }

    /**
     * Establece el valor del campo `eva_num_aleatorios`.
     *
     * @param eva_num_aleatorios el número aleatorio de la evaluación.
     */
    public void setEva_num_aleatorios(String eva_num_aleatorios) {
        this.eva_num_aleatorios = eva_num_aleatorios;
    }

    /**
     * Obtiene el valor del campo `eva_fecha`.
     *
     * @return la fecha de la evaluación.
     */
    public Date getEva_fecha() {
        return eva_fecha;
    }

    /**
     * Establece el valor del campo `eva_fecha`.
     *
     * @param eva_fecha la fecha de la evaluación.
     */
    public void setEva_fecha(Date eva_fecha) {
        this.eva_fecha = eva_fecha;
    }

    /**
     * Obtiene el valor del campo `alumno`.
     *
     * @return el alumno asociado a la evaluación.
     */
    public alumnos getAlumno() {
        return alumno;
    }

    /**
     * Establece el valor del campo `alumno`.
     *
     * @param alumno el alumno asociado a la evaluación.
     */
    public void setAlumno(alumnos alumno) {
        this.alumno = alumno;
    }

    /**
     * Obtiene el valor del campo `cuadernillo`.
     *
     * @return el cuadernillo asociado a la evaluación.
     */
    public cuadernillo getCuadernillo() {
        return cuadernillo;
    }

    /**
     * Establece el valor del campo `cuadernillo`.
     *
     * @param cuadernillo el cuadernillo asociado a la evaluación.
     */
    public void setCuadernillo(cuadernillo cuadernillo) {
        this.cuadernillo = cuadernillo;
    }
}
