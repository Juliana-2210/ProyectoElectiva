package com.example.proyecto.repository;

import com.example.proyecto.model.Dueño;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DueñoRepository extends JpaRepository<Dueño, Long> {}