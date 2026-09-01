package com.generation.vetcare.controller;

import com.generation.vetcare.dto.EspecialidadRequestDTO;
import com.generation.vetcare.dto.EspecialidadResponseDTO;
import com.generation.vetcare.service.EspecialidadService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadController {

    private final EspecialidadService especialidadService;

    public EspecialidadController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    @GetMapping
    public List<EspecialidadResponseDTO> listar() {
        return especialidadService.listarEspecialidades();
    }

    @PostMapping
    public ResponseEntity<EspecialidadResponseDTO> crear(@Valid @RequestBody EspecialidadRequestDTO dto) {
        EspecialidadResponseDTO creada = especialidadService.crearEspecialidad(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }
}