package com.example.aifinalback.views;

import ch.qos.logback.core.net.server.Client;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class ClienteView {
    private int id;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasena;


    public ClienteView toView() {
        return new ClienteView(id, nombre, apellido, usuario, contrasena);
    }
}
