package com.generation.vetcare.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SaludoController {
    @GetMapping("/Saludo")
    public String saludo() {
        return "Bienvenido a VetCare, el backend de la clínica veterinaria";
    }
    @GetMapping("/chaito")
    public String despedirse() {
        return "Ya me fui";
    }
}
