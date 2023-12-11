package com.example.aifinalback.servicios.implemented;

import com.example.aifinalback.modelo.Turno;
import com.example.aifinalback.repositorios.TurnoRepositorio;
import com.example.aifinalback.servicios.interfaces.ITurnoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j

public class TurnoServiceImpl implements ITurnoService {
    private final TurnoRepositorio repositorio;

    //@AutoWired
    public TurnoServiceImpl(TurnoRepositorio repositorio){
        this.repositorio=repositorio;
    }

    @Override
    public List<Turno> findAll() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Turno> findById(Integer id) {
        return repositorio.findById(id);
    }

    @Override
    public Turno save(Turno turno) {
        return repositorio.save(turno);
    }

    @Override
    public void deleteById(Integer id) {
        repositorio.deleteById(id);
    }

    @Override
    public Turno update(Turno turnoActualizado, int id) {
        Turno turnoPorActualizar = repositorio.findById(id).orElse(null);
        turnoPorActualizar.setDescripcion(turnoActualizado.getDescripcion());
        turnoPorActualizar.setMonto(turnoActualizado.getMonto());
        turnoPorActualizar.setCliente(turnoActualizado.getCliente());
        turnoPorActualizar.setPeluquero(turnoActualizado.getPeluquero());

        log.info(turnoPorActualizar.toString());
        log.info(turnoActualizado.toString());
        return repositorio.save(turnoPorActualizar);
    }

    @Override
    public List<Turno> findByFecha(Date fecha){
        List<Turno> turnos = repositorio.findAll();
        List<Turno> turnosOk = new ArrayList<Turno>();
        for(Turno turno : turnos){
            if(fecha == turno.getFecha()){
                turnosOk.add(turno);
            }
        }
        return turnosOk;
    }
}
