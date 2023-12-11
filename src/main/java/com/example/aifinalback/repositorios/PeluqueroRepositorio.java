package com.example.aifinalback.repositorios;

import com.example.aifinalback.modelo.Peluquero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeluqueroRepositorio extends JpaRepository <Peluquero,Integer> {
}
