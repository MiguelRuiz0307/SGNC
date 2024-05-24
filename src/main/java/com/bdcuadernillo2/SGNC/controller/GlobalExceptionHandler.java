package com.bdcuadernillo2.SGNC.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex, Model model) {
        ModelAndView modelAndView = new ModelAndView("error"); // Nombre de la vista de error
        model.addAttribute("message", ex.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class)
    public ModelAndView handleDataIntegrityViolationException(org.springframework.dao.DataIntegrityViolationException ex, Model model) {
        ModelAndView modelAndView = new ModelAndView("error");
        model.addAttribute("message", "No se puede eliminar el registro debido a restricciones de integridad referencial.");
        return modelAndView;
    }
}

