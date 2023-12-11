package com.example.aifinalback.controlador;

import com.example.aifinalback.exceptions.PeluqueroException;
import com.example.aifinalback.modelo.Peluquero;
import com.example.aifinalback.servicios.interfaces.IPeluqueroService;
import com.example.aifinalback.views.PeluqueroView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping("/api/peluquero")
@Slf4j
public class PeluqueroController {

    private final IPeluqueroService peluqueroService;
    private PeluqueroController(IPeluqueroService peluqueroService) {
        this.peluqueroService=peluqueroService;
    }

    //LISTAR PELUQUEROS
    public List<PeluqueroView> getPeluqueros(){
        log.debug("Called getPeluqueros from Controller");
        return peluqueroService.findAll().stream().map(Peluquero::toView).toList();
    }
    //AGREGAR PELUQUERO
    public PeluqueroView agregarPeluquero(Peluquero peluquero){
        return peluqueroService.save(peluquero).toView();
    }
    //GUARDAR PELUQUERO
    public Peluquero guardarPeluquero(Peluquero peluquero){
        return peluqueroService.save(peluquero);
    }
    //ACTUALIZAR PELUQUERO
    public Peluquero actualizarPeluquero(Peluquero peluquero, int id){
        return peluqueroService.update(peluquero, id);
    }
    //ELIMINAR PELUQUERO
    public void eliminarPeluquero(int id){
        peluqueroService.deleteById(id);
    }
    //BUSCAR PELUQUERO (GET BY ID)
    public PeluqueroView buscarPeluquero(int id) throws PeluqueroException {
        return peluqueroService.findById(id).orElseThrow(() -> new PeluqueroException("Peluquero no encontrado")).toView();
    }
    //LISTAR PELUQUEROS PRACTICANTES
    public List<PeluqueroView> getPeluquerosPracticantes(){
        log.debug("Called getPeluquerosPracticantes from Controller");
        List<PeluqueroView> peluqueros = peluqueroService.findAll().stream().map(Peluquero::toView).toList();
        List<PeluqueroView> peluquerosOk = new ArrayList<>();
        for(PeluqueroView peluquero : peluqueros){
            if(peluquero.isPracticante())
                peluquerosOk.add(peluquero);
        }
        return peluquerosOk;
    }
    //LISTAR PELUQUEROS NO PRACTICANTES
    public List<PeluqueroView> getPeluquerosNoPracticantes(){
        log.debug("Called getPeluquerosNoPracticantes from Controller");
        List<PeluqueroView> peluqueros = peluqueroService.findAll().stream().map(Peluquero::toView).toList();
        List<PeluqueroView> peluquerosOk = new ArrayList<>();
        for(PeluqueroView peluquero : peluqueros){
            if(!peluquero.isPracticante())
                peluquerosOk.add(peluquero);
        }
        return peluquerosOk;
    }


}
