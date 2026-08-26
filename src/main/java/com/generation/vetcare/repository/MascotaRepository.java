package com.generation.vetcare.repository;

import com.generation.vetcare.model.Mascota;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MascotaRepository {

    private final List<Mascota> mascotas = new ArrayList<>();
    private Long siguienteId = 1L;

    public List<Mascota> findAll() {
        return mascotas;
    }

    public Optional<Mascota> findById(Long id) {
        return mascotas.stream()
                .filter(mascota -> mascota.getId().equals(id))
                .findFirst();
    }

    public Mascota save(Mascota mascota) {
        mascota.setId(siguienteId);
        siguienteId++;
        mascotas.add(mascota);
        return mascota;
    }

    public Optional<Mascota> update(Long id, Mascota datos) {
        return findById(id).map(mascota -> {
            mascota.setNombre(datos.getNombre());
            mascota.setEspecie(datos.getEspecie());
            mascota.setRaza(datos.getRaza());
            mascota.setEdad(datos.getEdad());
            mascota.setNombreDueno(datos.getNombreDueno());
            return mascota;
        });
    }

    public boolean deleteById(Long id) {
        return mascotas.removeIf(mascota -> mascota.getId().equals(id));
    }
}
