package com.example.aifinalback.controlador;

import com.example.aifinalback.exceptions.PeluqueroException;
import com.example.aifinalback.modelo.Peluquero;
import com.example.aifinalback.servicios.interfaces.IPeluqueroService;
import com.example.aifinalback.views.PeluqueroView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping("/api/peluqueros")
@Slf4j
public class PeluqueroController {

    private final IPeluqueroService peluqueroService;
    private PeluqueroController(IPeluqueroService peluqueroService) {
        this.peluqueroService=peluqueroService;
    }

    //LISTAR PELUQUEROS
    @GetMapping(path="/listar")
    public List<PeluqueroView> getPeluqueros(){
        log.debug("Called getPeluqueros from Controller");
        return peluqueroService.findAll().stream().map(Peluquero::toView).toList();
    }
    //GUARDAR PELUQUERO
    @PostMapping
    public Peluquero guardarPeluquero(@RequestBody Peluquero peluquero){
        return peluqueroService.save(peluquero);
    }
    //ACTUALIZAR PELUQUERO
    @PutMapping("/ID/{id}")
    public Peluquero actualizarPeluquero(@RequestBody Peluquero peluquero,@PathVariable int id){
        return peluqueroService.update(peluquero, id);
    }
    //ELIMINAR PELUQUERO
    @DeleteMapping(path="eliminar/{id}")
    public void eliminarPeluquero(@PathVariable int id){
        peluqueroService.deleteById(id);
    }
    //BUSCAR PELUQUERO (GET BY ID)
    @GetMapping(path ="/buscar/{id}")
    public PeluqueroView buscarPeluquero(@PathVariable int id) throws PeluqueroException {
        return peluqueroService.findById(id).orElseThrow(() -> new PeluqueroException("Peluquero no encontrado")).toView();
    }
    //LISTAR PELUQUEROS PRACTICANTES
    @GetMapping(path="/practicantes")
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
    @GetMapping(path="/nopracticantes")
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
