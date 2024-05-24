/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bdcuadernillo2.SGNC.repository;

import com.bdcuadernillo2.SGNC.domain.cuadernillo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Lenovo
 */
public interface CuadernilloRepository extends JpaRepository<cuadernillo, Integer> {
    
}
