package com.bdcuadernillo2.SGNC.controller;

import com.bdcuadernillo2.SGNC.domain.alumnos;
import com.bdcuadernillo2.SGNC.domain.cuadernillo;
import com.bdcuadernillo2.SGNC.domain.evaluacion;
import com.bdcuadernillo2.SGNC.service.AlumnoService;
import com.bdcuadernillo2.SGNC.service.CuadernilloService;
import com.bdcuadernillo2.SGNC.service.EvaluacionService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controlador para gestionar las evaluaciones.
 */
@Controller
@RequestMapping("/evaluaciones")
public class EvaluacionController {

    private final EvaluacionService evaluacionService;
    private final CuadernilloService cuadernilloService;
    private final AlumnoService alumnoService;

    @Autowired
    public EvaluacionController(EvaluacionService evaluacionService, CuadernilloService cuadernilloService, AlumnoService alumnoService) {
        this.evaluacionService = evaluacionService;
        this.cuadernilloService = cuadernilloService;
        this.alumnoService = alumnoService;
    }

    // Maneja la solicitud para eliminar un alumno por su matrícula
    @RequestMapping("/eliminar")
    public String eliminarAlumnoByMatricula(int id) {
        evaluacionService.eliminarEvaluacionPorId(id);
        return "redirect:/evaluaciones/mostrar-evaluacion";
    }

    @GetMapping("/agregar-evaluacion")
    public String mostrarFormulario(Model model) {
        model.addAttribute("evaluacion", new evaluacion());
        model.addAttribute("cuadernillos", cuadernilloService.obtenerTodos());
        model.addAttribute("alumnos", alumnoService.obtenerTodosLosAlumnos());
        return "agregar-evaluacion.html";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @PostMapping("/guardar-evaluacion")
    public String guardarEvaluacion(@ModelAttribute("evaluacion") evaluacion evaluacion1) {
        evaluacionService.guardarEvaluacion(evaluacion1);
        return "redirect:/evaluaciones/agregar-evaluacion";
    }

    @GetMapping("/eliminarEvaluacion/{id}")
    public String eliminarEvaluacion(@PathVariable("id") Integer id) {
        evaluacionService.eliminarEvaluacion(id);
        return "redirect:/evaluaciones/mostrar-evaluacion";
    }

    @GetMapping("/editarEvaluacion/{id}")
    public String mostrarFormularioEditar(@PathVariable int id, Model model) {
        Optional<evaluacion> evaluacionOpt = evaluacionService.findEvaluacionById(id);
        if (evaluacionOpt.isPresent()) {
            model.addAttribute("evaluacion", evaluacionOpt.get());
            model.addAttribute("cuadernillos", cuadernilloService.obtenerTodos());
            model.addAttribute("alumnos", alumnoService.obtenerTodosLosAlumnos());
            return "formulario-editar-evaluacion"; // Nombre del template HTML para editar evaluación
        } else {
            return "redirect:/evaluaciones/mostrar-evaluacion";
        }
    }

    @PostMapping("/editarEvaluacion")
    public String guardarEvaluacionEditada(@ModelAttribute evaluacion evaluacion1) {
        evaluacionService.guardarEvaluacion(evaluacion1);
        return "redirect:/evaluaciones/mostrar-evaluacion";
    }

    @GetMapping("/exists")
    public ResponseEntity<Boolean> existsEvaluacion(@RequestParam String alu_matricula, @RequestParam int cua_clave) {
        alumnos alumno = alumnoService.findAlumno(alu_matricula).orElse(null);
        cuadernillo cuadernillo = cuadernilloService.findCuadernilloById(cua_clave).orElse(null);

        if (alumno == null || cuadernillo == null) {
            return ResponseEntity.badRequest().body(false);
        }

        boolean exists = evaluacionService.existeEvaluacion(alumno, cuadernillo);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/mostrar-evaluacion")
    public String mostrarEvaluaciones(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<evaluacion> evaluacionesPage = evaluacionService.findPaginated(page, 5); // 5 elementos por página
        model.addAttribute("evaluaciones", evaluacionesPage.getContent()); // Añade la lista de evaluaciones paginadas al modelo
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", evaluacionesPage.getTotalPages());
        return "mostrar-evaluacion";
    }

}
