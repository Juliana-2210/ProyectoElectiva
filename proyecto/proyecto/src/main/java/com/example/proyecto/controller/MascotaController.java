package com.example.proyecto.controller;

import com.example.proyecto.model.Dueño;
import com.example.proyecto.model.Mascota;
import com.example.proyecto.repository.DueñoRepository;
import com.example.proyecto.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {
    @Autowired
    private MascotaRepository mascotaRepository;
    @Autowired
    private DueñoRepository dueñoRepository;

    @GetMapping
    public List<Mascota> getAllMascotas() {
        return mascotaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Mascota> createMascota(@RequestBody Mascota mascota) {
        Dueño dueño = dueñoRepository.findById(mascota.getDueño().getId()).orElse(null);
        if (dueño == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        mascota.setDueño(dueño);
        Mascota savedMascota = mascotaRepository.save(mascota);
        return new ResponseEntity<>(savedMascota, HttpStatus.CREATED);
    }
}
