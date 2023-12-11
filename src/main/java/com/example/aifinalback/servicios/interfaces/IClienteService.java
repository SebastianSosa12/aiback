package com.example.aifinalback.servicios.interfaces;

import com.example.aifinalback.modelo.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    List<Cliente> findAll();
    Optional<Cliente> findById(Integer id);
    Cliente save(Cliente cliente);
    void deleteById(Integer id); //o id_cliente?
    Cliente update(Cliente cliente, int id);

}
