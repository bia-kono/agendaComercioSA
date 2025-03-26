package com.example.agendaComercioSA.Service.Implementation;

import com.example.agendaComercioSA.Model.Contato;
import com.example.agendaComercioSA.Repository.ContatoRepository;
import com.example.agendaComercioSA.Service.ContatoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ContatoServiceImpl implements ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Override
    public Contato cadastrarContato(Contato contato) {
        return contatoRepository.save(contato);
    }

    @Override
    public Contato editarContato(Contato contato) {
        Optional<Contato> contatoExistente = contatoRepository.findById(contato.getId());

        if (contatoExistente.isPresent()) {
            Contato editarContato = contatoExistente.get();
            editarContato.setTipo(contato.getTipo());
            editarContato.setValor(contato.getValor());
            editarContato.setObservacao(contato.getObservacao());

            return contatoRepository.save(editarContato);
        } else {
            throw new RuntimeException("Contato não cadastrado! Tente novamente.");
        }

    }

    @Override
    public void excluirContatosPorCliente(Integer clienteId) {
        List<Contato> contatos = contatoRepository.buscarContatoPorCliente(clienteId);

        if (contatos.isEmpty()) {
            throw new RuntimeException("Nenhum contato encontrado para o cliente " + clienteId);
        }
        contatoRepository.deleteAll(contatos);
    }

    @Override
    public List<Contato> buscarContatoPorCliente(Integer clienteId) {
        return contatoRepository.buscarContatoPorCliente(clienteId);
    }
}
