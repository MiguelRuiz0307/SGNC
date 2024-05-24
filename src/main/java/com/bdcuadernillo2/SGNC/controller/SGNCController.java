package com.bdcuadernillo2.SGNC.controller;

import com.bdcuadernillo2.SGNC.domain.alumnos;
import com.bdcuadernillo2.SGNC.service.AlumnoService;
import com.bdcuadernillo2.SGNC.service.EvaluacionService;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author José Miguel Ruiz Gómez
 */
@Controller
public class SGNCController {

    private final AlumnoService alumnoService;
    private final EvaluacionService evaluacionService;

    public SGNCController(AlumnoService alumnoService, EvaluacionService evaluacionService) {
        this.alumnoService = alumnoService;
        this.evaluacionService = evaluacionService;
    }

    @RequestMapping("/inicio")
    public String Formulario() {
        return "inicio";
    }

    // Maneja la solicitud para mostrar el formulario de agregar alumno
    @GetMapping("/agregar-alumno")
    public String mostrarFormularioAgregarAlumno(Model model) {
        model.addAttribute("alumno", new alumnos());
        return "agregar-alumno";
    }

    @GetMapping("/mostrar-alumnos")
    public String mostrarAlumnos(Model model) {
        List<alumnos> alumno = alumnoService.obtenerTodosLosAlumnos();

        model.addAttribute("alumnos", alumno);

        return "mostrar-alumnos";
    }

    @RequestMapping("/buscar")
    public String buscar(String matricula, Model model) {
        
        List<alumnos> alumno = alumnoService.buscar(matricula); 
        
        model.addAttribute("alumnos", alumno);
        
        return "mostrar-alumnos"; 
    }
    
    @GetMapping("/")
    public String home(){
        return "bienvenida";
    }
    
    @GetMapping("/login")
    public String login(){
        return "login";
    } 

}
