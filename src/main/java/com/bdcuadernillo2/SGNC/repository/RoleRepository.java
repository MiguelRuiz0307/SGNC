/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bdcuadernillo2.SGNC.repository;

import com.bdcuadernillo2.SGNC.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Lenovo
 */
public interface RoleRepository extends JpaRepository<Roles, Long> {
    
}
