package com.bdcuadernillo2.SGNC.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.Set;

/**
 *
 * @author Lenovo
 */
@Entity
public class User {

    /**
     * El campo `id` es la clave primaria de la entidad. Se genera
     * automáticamente con una estrategia de generación de identidad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * El campo `username` representa el nombre de usuario.
     */
    private String username;

    /**
     * El campo `password` representa la contraseña del usuario.
     */
    private String password;

    /**
     * El campo `enabled` indica si el usuario está habilitado.
     */
    private boolean enabled;

    /**
     * El campo `roles` define una relación de muchos a muchos con la entidad
     * `Roles`. La relación se carga con ansias y se mapea a través de la tabla
     * de unión `users_roles`.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Roles> roles;

    /**
     * Obtiene el valor del campo `id`.
     *
     * @return el identificador del usuario.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el valor del campo `id`.
     *
     * @param id el identificador del usuario.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el valor del campo `username`.
     *
     * @return el nombre de usuario.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el valor del campo `username`.
     *
     * @param username el nombre de usuario.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene el valor del campo `password`.
     *
     * @return la contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece el valor del campo `password`.
     *
     * @param password la contraseña del usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Verifica si el usuario está habilitado.
     *
     * @return `true` si el usuario está habilitado, `false` en caso contrario.
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Establece si el usuario está habilitado.
     *
     * @param enabled el estado de habilitación del usuario.
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Obtiene el conjunto de roles asociados con este usuario.
     *
     * @return el conjunto de roles.
     */
    public Set<Roles> getRoles() {
        return roles;
    }

    /**
     * Establece el conjunto de roles asociados con este usuario.
     *
     * @param roles el conjunto de roles.
     */
    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
}
