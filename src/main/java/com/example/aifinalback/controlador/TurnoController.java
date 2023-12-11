package com.example.aifinalback.controlador;

import com.example.aifinalback.exceptions.TurnoException;
import com.example.aifinalback.modelo.Turno;
import com.example.aifinalback.servicios.interfaces.ITurnoService;
import com.example.aifinalback.views.TurnoView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping("/api/turno")
@Slf4j
public class TurnoController {

    private final ITurnoService turnoService;
    private TurnoController(ITurnoService turnoService) {
        this.turnoService=turnoService;
    }

    //LISTAR TURNOS
    public List<TurnoView> getTurnos(){
        log.debug("Called getTurnos from Controller");
        return turnoService.findAll().stream().map(Turno::toView).toList();
    }
    //AGREGAR TURNO
    public TurnoView agregarTurno(Turno turno){
        return turnoService.save(turno).toView();
    }
    //GUARDAR TURNO
    public Turno guardarTurno(Turno turno){
        return turnoService.save(turno);
    }
    //ACTUALIZAR TURNO
    public Turno actualizarTurno(Turno turno, int id){
        return turnoService.update(turno, id);
    }
    //ELIMINAR TURNO
    public void eliminarPeluquero(int id){
        turnoService.deleteById(id);
    }
    //BUSCAR TURNO (GET BY ID)
    public TurnoView buscarPeluquero(int id) throws TurnoException {
        return turnoService.findById(id).orElseThrow(() -> new TurnoException("Turno no encontrado")).toView();
    }
    //TURNOS POR CLIENTE
    public List<TurnoView> getTurnosByCliente(int id){
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
    public List<TurnoView> getTurnosByPeluqueroe(int id){
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
    public List<TurnoView> getTurnosByFecha(Date fecha){
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

