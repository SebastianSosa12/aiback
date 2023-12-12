package com.example.aifinalback.repositorios;

import com.example.aifinalback.modelos.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepositorio extends JpaRepository <Turno,Integer> {
}
