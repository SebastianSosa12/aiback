package com.example.aifinalback.exceptions;

import java.io.Serial;

public class TurnoException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 9018648492209155948L;

    public TurnoException(String mensaje) {
        super(mensaje);
    }
}
