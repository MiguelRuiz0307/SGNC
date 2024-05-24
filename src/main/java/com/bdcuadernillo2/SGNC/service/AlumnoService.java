package com.bdcuadernillo2.SGNC.service;

import com.bdcuadernillo2.SGNC.domain.alumnos;
import com.bdcuadernillo2.SGNC.repository.AlumnoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
    @Transactional
    public void updateAlumno(alumnos alumno) {
        String sql = "CALL update_alumno(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, alumno.getAlu_matricula(), alumno.getAlu_nombre(), alumno.getAlu_apellido(),
                alumno.getAlu_carrera(), alumno.getAlu_correo(), alumno.getAlu_password());
    }
    
    /**
     * Constructor que inyecta el repositorio de alumnos.
     *
     * @param alumnoRepository el repositorio de alumnos.
     */
    @Autowired
    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    /**
     * Guarda un alumno en la base de datos.
     *
     * @param alumno el alumno a guardar.
     * @return el alumno guardado.
     */
    public alumnos guardarAlumno(alumnos alumno) {
        return alumnoRepository.save(alumno);
    }

    /**
     * Obtiene todos los alumnos de la base de datos.
     *
     * @return una lista de todos los alumnos.
     */
    public List<alumnos> obtenerTodosLosAlumnos() {
        return alumnoRepository.findAll();
    }

    /**
     * Elimina un alumno y sus evaluaciones asociadas de la base de datos.
     *
     * @param alu_matricula la matrícula del alumno a eliminar.
     */
    @Transactional
    public void eliminarAlumnoYEvaluciones(String alu_matricula) {
        alumnos alumno = alumnoRepository.findByAluMatricula(alu_matricula);
        if (alumno != null) {
            alumnoRepository.delete(alumno);
        }
    }

    /**
     * Busca alumnos por matrícula.
     *
     * @param matricula la matrícula a buscar.
     * @return una lista de alumnos que coinciden con la matrícula.
     */
    public List<alumnos> buscar(String matricula) {
        return alumnoRepository.buscar(matricula);
    }

    /**
     * Encuentra un alumno por su matrícula.
     *
     * @param matricula la matrícula del alumno.
     * @return un `Optional` con el alumno encontrado o vacío si no se
     * encuentra.
     */
    public Optional<alumnos> findAlumno(String matricula) {
        return alumnoRepository.findById(matricula);
    }

    /**
     * Guarda los cambios realizados en un alumno.
     *
     * @param alumno el alumno con los cambios a guardar.
     */
    public void guardarCambios(alumnos alumno) {
        alumnoRepository.save(alumno);
    }

    /**
     * Lista los alumnos de forma paginada.
     *
     * @param pageable la información de paginación.
     * @return una página de alumnos.
     */
    public Page<alumnos> listarAlumnos(Pageable pageable) {
        return alumnoRepository.findAll(pageable);
    }

}
