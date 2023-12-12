package com.example.aifinalback.controlador;

import com.example.aifinalback.exceptions.TurnoException;
import com.example.aifinalback.modelo.Turno;
import com.example.aifinalback.servicios.interfaces.ITurnoService;
import com.example.aifinalback.views.TurnoView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping("/api/turnos")
@Slf4j
public class TurnoController {

    private final ITurnoService turnoService;
    private TurnoController(ITurnoService turnoService) {
        this.turnoService=turnoService;
    }

    //LISTAR TURNOS
    @GetMapping(path="/listar")
    public List<TurnoView> getTurnos(){
        log.debug("Called getTurnos from Controller");
        return turnoService.findAll().stream().map(Turno::toView).toList();
    }
    //AGREGAR TURNO
    @PostMapping
    public TurnoView agregarTurno(@RequestBody Turno turno){
        return turnoService.save(turno).toView();
    }
    //GUARDAR TURNO
    @PostMapping
    public Turno guardarTurno(@RequestBody Turno turno){
        return turnoService.save(turno);
    }
    //ACTUALIZAR TURNO
    @PutMapping(path="/ID/{id}")
    public Turno actualizarTurno(@RequestBody Turno turno,@PathVariable int id){
        return turnoService.update(turno, id);
    }
    //ELIMINAR TURNO
    @DeleteMapping(path="/eliminar/{id}")
    public void eliminarPeluquero(@PathVariable int id){
        turnoService.deleteById(id);
    }
    //BUSCAR TURNO (GET BY ID)
    @GetMapping(path ="/buscar/{id}")
    public TurnoView buscarPeluquero(@PathVariable int id) throws TurnoException {
        return turnoService.findById(id).orElseThrow(() -> new TurnoException("Turno no encontrado")).toView();
    }
    //TURNOS POR CLIENTE
    @GetMapping(path="/porcliente/{id}")
    public List<TurnoView> getTurnosByCliente(@PathVariable int id){
        List<TurnoView> turnos = turnoService.findAll().stream().map(Turno::toView).toList();
        List<TurnoView> turnosOk= new ArrayList<>();
        for (TurnoView turno: turnos){
            if (id == turno.getCliente().getId()){
                turnosOk.add(turno);
            }
        }
        return turnosOk;
    }
    //TURNOS POR PELUQUERO
    @GetMapping(path="/porpeluquero/{id}")
    public List<TurnoView> getTurnosByPeluqueroe(@PathVariable int id){
        List<TurnoView> turnos = turnoService.findAll().stream().map(Turno::toView).toList();
        List<TurnoView> turnosOk= new ArrayList<>();
        for (TurnoView turno: turnos){
            if (id == turno.getPeluquero().getId()){
                turnosOk.add(turno);
            }
        }
        return turnosOk;
    }
    //TURNOS EN UNA FECHA DETERMINADA
    @GetMapping(path="/porfecha/{fecha}")
    public List<TurnoView> getTurnosByFecha(@PathVariable Date fecha){
        List<TurnoView> turnos = turnoService.findAll().stream().map(Turno::toView).toList();
        List<TurnoView> turnosOk= new ArrayList<>();
        for (TurnoView turno: turnos){
            if (fecha == turno.getFecha()){
                turnosOk.add(turno);
            }
        }
        return turnosOk;
    }

}

