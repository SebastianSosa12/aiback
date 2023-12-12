package com.example.aifinalback.servicios.implemented;

import com.example.aifinalback.modelos.Peluquero;
import com.example.aifinalback.repositorios.PeluqueroRepositorio;
import com.example.aifinalback.servicios.interfaces.IPeluqueroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j

public class PeluqueroServiceImpl implements IPeluqueroService {
    private final PeluqueroRepositorio repositorio;

    //@AutoWired
    public PeluqueroServiceImpl(PeluqueroRepositorio repositorio){
        this.repositorio=repositorio;
    }

    @Override
    public List<Peluquero> findAll() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Peluquero> findById(Integer id) {
        return repositorio.findById(id);
    }

    @Override
    public Peluquero save(Peluquero peluquero) {
        return repositorio.save(peluquero);
    }

    @Override
    public void deleteById(Integer id) {
        repositorio.deleteById(id);
    }

    @Override
    public Peluquero update(Peluquero peluqueroActualizado, int id) {
        Peluquero peluqueroPorActualizar = repositorio.findById(id).orElse(null);
        peluqueroPorActualizar.setNombre(peluqueroActualizado.getNombre());
        peluqueroPorActualizar.setApellido(peluqueroActualizado.getApellido());
        peluqueroPorActualizar.setContrasena(peluqueroActualizado.getContrasena());

        log.info(peluqueroPorActualizar.toString());
        log.info(peluqueroActualizado.toString());
        return repositorio.save(peluqueroPorActualizar);
    }
}
