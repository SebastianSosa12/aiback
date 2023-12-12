package com.example.aifinalback.servicios.interfaces;

import com.example.aifinalback.modelos.Turno;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ITurnoService {
    List<Turno> findAll();
    Optional<Turno> findById(Integer id);
    Turno save(Turno turno);
    void deleteById(Integer id);
    Turno update(Turno turno, int id);

    List<Turno> findByFecha(Date fecha);
}
