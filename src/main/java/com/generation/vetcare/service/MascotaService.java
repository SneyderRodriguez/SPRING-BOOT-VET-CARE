package com.generation.vetcare.service;

import com.generation.vetcare.model.Mascota;
import com.generation.vetcare.repository.MascotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;

    public MascotaService(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    public List<Mascota> listarMascotas() {
        return mascotaRepository.findAll();
    }

    public Optional<Mascota> buscarPorId(Long id) {
        return mascotaRepository.findById(id);
    }

    public Mascota crearMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public Optional<Mascota> actualizarMascota(Long id, Mascota datos) {
        return mascotaRepository.update(id, datos);
    }

    public boolean eliminarMascota(Long id) {
        return mascotaRepository.deleteById(id);
    }
}