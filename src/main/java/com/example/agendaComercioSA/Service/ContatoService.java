package com.example.agendaComercioSA.Service;

import com.example.agendaComercioSA.Model.Cliente;
import com.example.agendaComercioSA.Model.Contato;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ContatoService {

    //Cadastrar
    Contato cadastrarContato(Contato contato);

    //Editar
    Contato editarContato(Contato contato);

    //Excluir
    Contato excluirContato(Contato contato);

    //Listar
    List<Contato> listarContatoPorCliente(Cliente cliente);
}
