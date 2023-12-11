package com.example.aifinalback.exceptions;

import java.io.Serial;

public class PeluqueroException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 9018648492209155948L;

    public PeluqueroException(String mensaje) {
        super(mensaje);
    }
}
