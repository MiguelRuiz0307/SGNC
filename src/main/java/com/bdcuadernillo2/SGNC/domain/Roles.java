package com.bdcuadernillo2.SGNC.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.Set;

/**
 *
 * @author Lenovo
 */
@Entity
public class Roles {

    /**
     * El campo `id` es la clave primaria de la entidad. Se genera
     * automáticamente con una estrategia de generación de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * El campo `name` representa el nombre del rol.
     */
    private String name;

    /**
     * El campo `users` define una relación de muchos a muchos con la entidad
     * `User`. Está mapeado por el campo `roles` en la entidad `User`.
     */
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    /**
     * Obtiene el valor del campo `id`.
     *
     * @return el identificador del rol.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el valor del campo `id`.
     *
     * @param id el identificador del rol.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el valor del campo `name`.
     *
     * @return el nombre del rol.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el valor del campo `name`.
     *
     * @param name el nombre del rol.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el conjunto de usuarios asociados con este rol.
     *
     * @return el conjunto de usuarios.
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * Establece el conjunto de usuarios asociados con este rol.
     *
     * @param users el conjunto de usuarios.
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
