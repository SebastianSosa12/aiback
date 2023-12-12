package com.example.aifinalback.modelos;

import com.example.aifinalback.views.ClienteView;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name= "clientes")
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private int id;

    private String username;
    private String contrasena;
    private String nombre;
    private String apellido;
    @OneToMany(mappedBy = "cliente") // Nombre del atributo en la clase Turno que representa esta relación
    private List<Turno> turnos;

    public Cliente() {
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

    public ClienteView toView(){
        return new ClienteView(id, nombre, apellido,username,contrasena);
    }
}
