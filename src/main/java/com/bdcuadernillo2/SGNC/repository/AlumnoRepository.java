package com.bdcuadernillo2.SGNC.repository;

import com.bdcuadernillo2.SGNC.domain.alumnos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 *
 * @author Lenovo
 */
public interface AlumnoRepository extends JpaRepository<alumnos, String> {
   
    @Query("SELECT a FROM alumnos a WHERE a.alu_matricula = ?1")
    alumnos findByAluMatricula(String alu_matricula);
    
    @Query("from alumnos a where a.alu_nombre like %?1%")
    List<alumnos> buscar(String consulta);
    
    
    
//    @Query("SELECT a.alu_matricula FROM alumnos a")
//    List<String> findAllMatriculas();
    
}
