package com.bdcuadernillo2.SGNC.controller;

import com.bdcuadernillo2.SGNC.domain.alumnos;
import com.bdcuadernillo2.SGNC.service.AlumnoService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Lenovo
 */
@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    @Autowired
    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    // Maneja la solicitud para mostrar el formulario de agregar alumno
    @GetMapping("/agregar")
    public String mostrarFormularioAgregarAlumno() {
        return "agregar-alumno";
    }

    // Maneja la solicitud para guardar un nuevo alumno
    @PostMapping("/guardar")
    public String guardarAlumno(alumnos Alumno) {
        alumnoService.guardarAlumno(Alumno);
        return "redirect:/inicio";
    }

    // Maneja la solicitud para eliminar un alumno y sus evaluaciones
    @GetMapping("/eliminar")
    public String eliminarAlumnoYEvaluciones(String alu_matricula) {
        alumnoService.eliminarAlumnoYEvaluciones(alu_matricula);
        return "redirect:/mostrar-alumnos";
    }

    // Maneja la solicitud para mostrar el formulario de edición de un alumno
    @GetMapping("/editar")
    public String editarAlumno(@RequestParam String matricula, Model model) {
        String mensajeError = "";

        Optional<alumnos> opcionalAlumno = alumnoService.findAlumno(matricula);

        if (opcionalAlumno.isPresent()) {
            alumnos alumno = opcionalAlumno.get();
            model.addAttribute("alumno", alumno);
            return "editar-alumno";
        } else {
            mensajeError = "Alumno no encontrado";
            model.addAttribute("mensajeError", mensajeError);
            return "error";
        }
    }

    /**
     * Guarda cambios al editar un videojuego
     *
     * @param alumno
     * @return
     */
    // Guarda los cambios al editar un alumno
    @PostMapping("/guardarCambios")
    public String guardarCambios(@ModelAttribute alumnos alumno) {
        alumnoService.updateAlumno(alumno);
        return "redirect:/mostrar-alumnos";
    }

    @GetMapping
    public String listarAlumnos(Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<alumnos> alumnosPage = alumnoService.listarAlumnos(pageable);
        model.addAttribute("alumnos", alumnosPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", alumnosPage.getTotalPages());
        return "mostrar-alumnos"; // Nombre del template HTML para la lista de alumnos
    }

}
