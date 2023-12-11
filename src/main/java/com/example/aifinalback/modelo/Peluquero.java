package com.example.aifinalback.modelo;

import com.example.aifinalback.views.PeluqueroView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name="peluqueros")
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Peluquero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_peluquero")
    private int id;
    private String username;
    private String contrasena;
    private String nombre;
    private String apellido;
    private boolean practicante;

    @OneToMany(mappedBy = "peluquero") // Nombre del atributo en la clase Turno que representa esta relación
    private List<Turno> turnos;

    public Peluquero() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isPracticante() {
        return practicante;
    }

    public void setPracticante(boolean practicante) {
        this.practicante = practicante;
    }
    public PeluqueroView toView(){
        return new PeluqueroView(id, nombre, apellido,username, contrasena, practicante);
    }
}
