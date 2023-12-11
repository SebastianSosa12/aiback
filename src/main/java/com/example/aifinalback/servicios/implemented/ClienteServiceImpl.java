package com.example.aifinalback.servicios.implemented;

import com.example.aifinalback.modelo.Cliente;
import com.example.aifinalback.repositorios.ClienteRepositorio;
import com.example.aifinalback.servicios.interfaces.IClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j

public class ClienteServiceImpl implements IClienteService {
    private final ClienteRepositorio repositorio;

    //@AutoWired
    public ClienteServiceImpl(ClienteRepositorio repositorio){
        this.repositorio=repositorio;
    }

    @Override
    public List<Cliente> findAll() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Cliente> findById(Integer id) {
        return repositorio.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return repositorio.save(cliente);
    }

    @Override
    public void deleteById(Integer id) {
        repositorio.deleteById(id);
    }

    @Override
    public Cliente update(Cliente clienteActualizado, int id) {
        Cliente clientePorActualizar = repositorio.findById(id).orElse(null);
        clientePorActualizar.setNombre(clienteActualizado.getNombre());
        clientePorActualizar.setApellido(clienteActualizado.getApellido());
        clientePorActualizar.setContrasena(clienteActualizado.getContrasena());

        log.info(clientePorActualizar.toString());
        log.info(clienteActualizado.toString());
        return repositorio.save(clientePorActualizar);
    }
}
