package com.example.aifinalback.servicios.interfaces;

import com.example.aifinalback.modelos.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    List<Cliente> findAll();
    Optional<Cliente> findById(Integer id);
    Cliente save(Cliente cliente);
    void deleteById(Integer id);
    Cliente update(Cliente cliente, int id);

}
