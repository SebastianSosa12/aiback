package com.example.aifinalback.exceptions;

import java.io.Serial;

public class ClienteException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 9018648492289155948L;

    public ClienteException(String mensaje) {
        super(mensaje);
    }
}
