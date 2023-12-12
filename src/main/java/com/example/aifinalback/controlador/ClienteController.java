package com.example.aifinalback.controlador;

import com.example.aifinalback.exceptions.ClienteException;
import com.example.aifinalback.modelos.Cliente;
import com.example.aifinalback.servicios.interfaces.IClienteService;
import com.example.aifinalback.views.ClienteView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping("/api/clientes")
@Slf4j
public class ClienteController {

    private final IClienteService clienteService;
    private ClienteController(IClienteService clienteService) {
        this.clienteService =clienteService;
    }


    //LISTAR CLIENTES
    @GetMapping(path="/listar")
    public List<ClienteView> getClientes(){
        log.debug("Called getClientes from Controller");
        return clienteService.findAll().stream().map(Cliente::toView).toList();
    }

    //GUARDAR CLIENTE
    @PostMapping
    public Cliente guardarCliente(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }
    //ACTUALIZAR CLIENTE
    @PutMapping("/ID/{id}")
    public Cliente actualizarCliente(@RequestBody Cliente cliente,@PathVariable int id){
        return clienteService.update(cliente, id);
    }
    //ELIMINAR CLIENTE
    @DeleteMapping(path="/eliminar/{id}")
    public void eliminarCliente(@PathVariable int id){
        clienteService.deleteById(id);
    }
    //BUSCAR CLIENTE (GET BY ID)
    @GetMapping(path="/buscar/{id}")
    public ClienteView buscarCliente(@PathVariable int id) throws ClienteException {
        return clienteService.findById(id).orElseThrow(() -> new ClienteException("Cliente no encontrado")).toView();
    }

}
