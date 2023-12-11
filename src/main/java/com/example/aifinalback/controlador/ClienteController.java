package com.example.aifinalback.controlador;

import com.example.aifinalback.exceptions.ClienteException;
import com.example.aifinalback.modelo.Cliente;
import com.example.aifinalback.servicios.interfaces.IClienteService;
import com.example.aifinalback.views.ClienteView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping("/api/cliente")
@Slf4j
public class ClienteController {

    private final IClienteService clienteService;
    private ClienteController(IClienteService clienteService) {
        this.clienteService=clienteService;
    }

    //LISTAR CLIENTES
    public List<ClienteView> getClientes(){
        log.debug("Called getClientes from Controller");
        return clienteService.findAll().stream().map(Cliente::toView).toList();
    }
    //AGREGAR CLIENTE
    public ClienteView agregarCliente(Cliente cliente){
        return clienteService.save(cliente).toView();
    }
    //GUARDAR CLIENTE
    public Cliente guardarCliente(Cliente cliente){
        return clienteService.save(cliente);
    }
    //ACTUALIZAR CLIENTE
    public Cliente actualizarCliente(Cliente cliente, int id){
        return clienteService.update(cliente, id);
    }
    //ELIMINAR CLIENTE
    public void eliminarCliente(int id){
        clienteService.deleteById(id);
    }
    //BUSCAR CLIENTE (GET BY ID)
    public ClienteView buscarCliente(int id) throws ClienteException {
        return clienteService.findById(id).orElseThrow(() -> new ClienteException("Cliente no encontrado")).toView();
    }



}
