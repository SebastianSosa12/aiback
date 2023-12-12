package com.example.aifinalback.servicios.interfaces;

import com.example.aifinalback.modelos.Peluquero;

import java.util.List;
import java.util.Optional;

public interface IPeluqueroService {
    List<Peluquero> findAll();
    Optional<Peluquero> findById(Integer id);
    Peluquero save(Peluquero peluquero);
    void deleteById(Integer id);
    Peluquero update(Peluquero peluquero, int id);

}
