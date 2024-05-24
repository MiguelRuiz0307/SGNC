package com.bdcuadernillo2.SGNC.repository;

import com.bdcuadernillo2.SGNC.domain.alumnos;
import com.bdcuadernillo2.SGNC.domain.cuadernillo;
import com.bdcuadernillo2.SGNC.domain.evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Lenovo
 */
public interface EvaluacionRepository extends JpaRepository<evaluacion, Integer> {
    
    boolean existsByAlumnoAndCuadernillo(alumnos alumno, cuadernillo cuadernillo);
    
}
