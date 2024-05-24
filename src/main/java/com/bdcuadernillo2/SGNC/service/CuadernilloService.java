package com.bdcuadernillo2.SGNC.service;

import com.bdcuadernillo2.SGNC.domain.cuadernillo;
import com.bdcuadernillo2.SGNC.repository.CuadernilloRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public class CuadernilloService {

    private final CuadernilloRepository cuadernilloRepository;

    /**
     * Constructor que inyecta el repositorio de cuadernillos.
     *
     * @param cuadernilloRepository el repositorio de cuadernillos.
     */
    @Autowired
    public CuadernilloService(CuadernilloRepository cuadernilloRepository) {
        this.cuadernilloRepository = cuadernilloRepository;
    }

    /**
     * Obtiene todos los cuadernillos de la base de datos.
     *
     * @return una lista de todos los cuadernillos.
     */
    public List<cuadernillo> obtenerTodos() {
        return cuadernilloRepository.findAll();
    }

    /**
     * Encuentra un cuadernillo por su clave.
     *
     * @param clave la clave del cuadernillo.
     * @return un `Optional` con el cuadernillo encontrado o vacío si no se
     * encuentra.
     */
    public Optional<cuadernillo> findCuadernilloById(int clave) {
        return cuadernilloRepository.findById(clave);
    }
}
