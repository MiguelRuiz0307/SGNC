package com.bdcuadernillo2.SGNC.service;

import com.bdcuadernillo2.SGNC.domain.alumnos;
import com.bdcuadernillo2.SGNC.domain.cuadernillo;
import com.bdcuadernillo2.SGNC.domain.evaluacion;
import com.bdcuadernillo2.SGNC.repository.EvaluacionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Servicio para gestionar las evaluaciones.
 */
@Service
public class EvaluacionService {

    private final EvaluacionRepository evaluacionRepository;

    /**
     * Constructor que inyecta el repositorio de evaluaciones.
     *
     * @param evaluacionRepository el repositorio de evaluaciones.
     */
    @Autowired
    public EvaluacionService(EvaluacionRepository evaluacionRepository) {
        this.evaluacionRepository = evaluacionRepository;
    }

    /**
     * Obtiene todas las evaluaciones de la base de datos.
     *
     * @return una lista de todas las evaluaciones.
     */
    public List<evaluacion> obtenerTodasLasEvaluaciones() {
        return evaluacionRepository.findAll();
    }

    /**
     * Elimina una evaluación por su ID.
     *
     * @param id el ID de la evaluación a eliminar.
     */
    public void eliminarEvaluacionPorId(int id) {
        evaluacionRepository.deleteById(id);
    }

    /**
     * Guarda una evaluación en la base de datos.
     *
     * @param eva la evaluación a guardar.
     */
    public void guardarEvaluacion(evaluacion eva) {
        evaluacionRepository.save(eva);
    }

    /**
     * Encuentra evaluaciones de forma paginada.
     *
     * @param page el número de la página.
     * @param size el tamaño de la página.
     * @return una página de evaluaciones.
     */
    public Page<evaluacion> findPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return evaluacionRepository.findAll(pageable);
    }

    /**
     * Verifica si existe una evaluación para un alumno y un cuadernillo
     * específicos.
     *
     * @param alumno el alumno asociado a la evaluación.
     * @param cuadernillo el cuadernillo asociado a la evaluación.
     * @return true si existe la evaluación, false en caso contrario.
     */
    public boolean existeEvaluacion(alumnos alumno, cuadernillo cuadernillo) {
        return evaluacionRepository.existsByAlumnoAndCuadernillo(alumno, cuadernillo);
    }

    /**
     * Encuentra una evaluación por su ID.
     *
     * @param id el ID de la evaluación.
     * @return un `Optional` con la evaluación encontrada o vacío si no se
     * encuentra.
     */
    public Optional<evaluacion> findEvaluacionById(int id) {
        return evaluacionRepository.findById(id);
    }

    /**
     * Elimina una evaluación por su ID.
     *
     * @param id el ID de la evaluación a eliminar.
     */
    public void eliminarEvaluacion(int id) {
        evaluacionRepository.deleteById(id);
    }
}
