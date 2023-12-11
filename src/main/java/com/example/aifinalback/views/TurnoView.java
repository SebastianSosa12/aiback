package com.example.aifinalback.views;

import com.example.aifinalback.modelo.Cliente;
import com.example.aifinalback.modelo.Peluquero;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class TurnoView {
    private int id;
    private Date fecha;
    private String descripcion;
    private int monto;
    private Cliente cliente;
    private Peluquero peluquero;
}
