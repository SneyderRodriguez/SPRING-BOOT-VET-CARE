package com.generation.vetcare.service;

import com.generation.vetcare.dto.EspecialidadRequestDTO;
import com.generation.vetcare.dto.EspecialidadResponseDTO;
import com.generation.vetcare.model.Especialidad;
import com.generation.vetcare.repository.EspecialidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadService {

    private final EspecialidadRepository especialidadRepository;

    public EspecialidadService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    public List<EspecialidadResponseDTO> listarEspecialidades() {
        return especialidadRepository.findAll()
                .stream()
                .map(especialidad -> new EspecialidadResponseDTO(especialidad.getId(), especialidad.getNombre()))
                .toList();
    }

    public EspecialidadResponseDTO crearEspecialidad(EspecialidadRequestDTO datos) {
        Especialidad especialidad = new Especialidad();
        especialidad.setNombre(datos.nombre());

        Especialidad creada = especialidadRepository.save(especialidad);
        return new EspecialidadResponseDTO(creada.getId(), creada.getNombre());
    }
}