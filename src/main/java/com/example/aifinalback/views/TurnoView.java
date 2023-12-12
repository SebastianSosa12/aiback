package com.example.aifinalback.views;

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
    private float monto;
}
