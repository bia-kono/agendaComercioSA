package com.example.agendaComercioSA.Controller;

import com.example.agendaComercioSA.Model.Contato;
import com.example.agendaComercioSA.Service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
@CrossOrigin

public class ContatoController {

    @Autowired
    ContatoService contatoService;

    //Cadastrar Contato
    @PostMapping("/cadastrarContato")
    public String cadastrarContato(@RequestBody Contato contato) {
        contatoService.cadastrarContato(contato);
        return "Dados cadastrados com sucesso!";
    }

    //Editar contato
    @PutMapping("/editarContato")
    public String editarContato(@RequestBody Contato contato) {
        contatoService.editarContato(contato);
        return "Dados editados com sucesso!";
    }

    //Excluir Contato
    @DeleteMapping("/excluirContatos/{clienteId}")
    public ResponseEntity<String> excluirContatosPorCliente(@PathVariable Integer clienteId) {
        try {
            contatoService.excluirContatosPorCliente(clienteId);
            return ResponseEntity.ok("Todos os contatos do cliente " + clienteId + " foram excluídos com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    //Listar clientes
    @GetMapping("/buscarContatos/{clienteid}")
    public List<Contato> buscarContatoPorCliente(@RequestParam("clienteId") Integer clienteId) {
        return contatoService.buscarContatoPorCliente(clienteId);
    }

}


