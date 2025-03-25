package com.example.agendaComercioSA.Controller;

import com.example.agendaComercioSA.Model.Cliente;
import com.example.agendaComercioSA.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@CrossOrigin

public class ClienteController {

    @Autowired
    ClienteService clienteService;

    //Cadastrar cliente
    @PostMapping("/cadastrarCliente")
    public String cadastrarCliente(@RequestBody Cliente cliente) {
        clienteService.cadastrarCliente(cliente);
        return "Usuário cadastrado com sucesso!";
    }

    //Editar cliente
    @PutMapping("/editarCliente/{cpf}")
    public String editarCliente(@RequestBody Cliente cliente) {
        clienteService.editarCliente(cliente);
        return "Dado alterado com sucesso!";
    }

    //Excluir cliente
    @DeleteMapping("/excluirCliente/{cpf}")
    public ResponseEntity<String> excluirCliente(@PathVariable String cpf) {
        try {
            clienteService.excluirCliente(cpf);
            return ResponseEntity.ok("Usuário excluído com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    //Listar clientes
    @GetMapping("/listarClientes")
    public List<Cliente> listarCliente() {
        return clienteService.listarCliente();
    }

    //Buscar clientes
    @GetMapping("/buscarCliente")
    public List<Cliente> buscarClienteNomeCpf(@RequestParam("buscarCliente") String buscarCliente) {
        return clienteService.buscarClienteNomeCpf(buscarCliente);
    }
}