package com.bdcuadernillo2.SGNC.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "cuadernillo")
public class cuadernillo {

    /**
     * El campo `cua_clave` es la clave primaria de la entidad. Se genera
     * automáticamente con una estrategia de generación de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cua_clave;

    /**
     * El campo `cua_nombre` representa el nombre del cuadernillo.
     */
    private String cua_nombre;

    /**
     * El campo `cua_total_ejercicios` representa el total de ejercicios en el
     * cuadernillo.
     */
    private int cua_total_ejercicios;

    /**
     * El campo `cua_cantidad_ejercicios` representa la cantidad de ejercicios
     * disponibles en el cuadernillo.
     */
    private int cua_cantidad_ejercicios;

    /**
     * El campo `cua_mostrar` indica si el cuadernillo debe ser mostrado.
     */
    private boolean cua_mostrar;

    /**
     * El campo `asign_clave` representa la clave de la asignatura asociada al
     * cuadernillo.
     */
    private int asign_clave;

    /**
     * Obtiene el valor del campo `cua_clave`.
     *
     * @return la clave del cuadernillo.
     */
    public int getCua_clave() {
        return cua_clave;
    }

    /**
     * Establece el valor del campo `cua_clave`.
     *
     * @param cua_clave la clave del cuadernillo.
     */
    public void setCua_clave(int cua_clave) {
        this.cua_clave = cua_clave;
    }

    /**
     * Obtiene el valor del campo `cua_nombre`.
     *
     * @return el nombre del cuadernillo.
     */
    public String getCua_nombre() {
        return cua_nombre;
    }

    /**
     * Establece el valor del campo `cua_nombre`.
     *
     * @param cua_nombre el nombre del cuadernillo.
     */
    public void setCua_nombre(String cua_nombre) {
        this.cua_nombre = cua_nombre;
    }

    /**
     * Obtiene el valor del campo `cua_total_ejercicios`.
     *
     * @return el total de ejercicios del cuadernillo.
     */
    public int getCua_total_ejercicios() {
        return cua_total_ejercicios;
    }

    /**
     * Establece el valor del campo `cua_total_ejercicios`.
     *
     * @param cua_total_ejercicios el total de ejercicios del cuadernillo.
     */
    public void setCua_total_ejercicios(int cua_total_ejercicios) {
        this.cua_total_ejercicios = cua_total_ejercicios;
    }

    /**
     * Obtiene el valor del campo `cua_cantidad_ejercicios`.
     *
     * @return la cantidad de ejercicios disponibles en el cuadernillo.
     */
    public int getCua_cantidad_ejercicios() {
        return cua_cantidad_ejercicios;
    }

    /**
     * Establece el valor del campo `cua_cantidad_ejercicios`.
     *
     * @param cua_cantidad_ejercicios la cantidad de ejercicios disponibles en
     * el cuadernillo.
     */
    public void setCua_cantidad_ejercicios(int cua_cantidad_ejercicios) {
        this.cua_cantidad_ejercicios = cua_cantidad_ejercicios;
    }

    /**
     * Verifica si el cuadernillo debe ser mostrado.
     *
     * @return `true` si el cuadernillo debe ser mostrado, `false` en caso
     * contrario.
     */
    public boolean isCua_mostrar() {
        return cua_mostrar;
    }

    /**
     * Establece si el cuadernillo debe ser mostrado.
     *
     * @param cua_mostrar el estado de visibilidad del cuadernillo.
     */
    public void setCua_mostrar(boolean cua_mostrar) {
        this.cua_mostrar = cua_mostrar;
    }

    /**
     * Obtiene el valor del campo `asign_clave`.
     *
     * @return la clave de la asignatura asociada al cuadernillo.
     */
    public int getAsign_clave() {
        return asign_clave;
    }

    /**
     * Establece el valor del campo `asign_clave`.
     *
     * @param asign_clave la clave de la asignatura asociada al cuadernillo.
     */
    public void setAsign_clave(int asign_clave) {
        this.asign_clave = asign_clave;
    }
}
