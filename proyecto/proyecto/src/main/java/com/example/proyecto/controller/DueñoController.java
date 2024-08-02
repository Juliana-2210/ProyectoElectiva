package com.example.proyecto.controller;

import com.example.proyecto.model.Dueño;
import com.example.proyecto.repository.DueñoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/dueños")
public class DueñoController {
    @Autowired
    private DueñoRepository dueñoRepository;

    @PostMapping
    public ResponseEntity<Dueño> createDueño(@RequestBody Dueño dueño) {
        Dueño savedDueño = dueñoRepository.save(dueño);
        return new ResponseEntity<>(savedDueño, HttpStatus.CREATED);
    }
}
