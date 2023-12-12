package com.example.aifinalback.modelos;

import com.example.aifinalback.views.TurnoView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name="turnos")
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_turno")
    private int id;
    private Date fecha;
    private String descripcion;
    private float monto;

    @ManyToOne // Cambiado a OneToOne si la relación es exactamente uno a uno
    @JoinColumn(name = "id_cliente") // Nombre de la columna que actúa como clave foránea en la tabla de Turno
    private Cliente cliente;

    @ManyToOne // Cambiado a OneToOne si la relación es exactamente uno a uno
    @JoinColumn(name = "id_peluquero") // Nombre de la columna que actúa como clave foránea en la tabla de Turno
    private Peluquero peluquero;

    public Turno() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Peluquero getPeluquero() {
        return peluquero;
    }

    public void setPeluquero(Peluquero peluquero) {
        this.peluquero = peluquero;
    }

    public TurnoView toView(){
        return new TurnoView(id, fecha, descripcion, monto);
    }
}
