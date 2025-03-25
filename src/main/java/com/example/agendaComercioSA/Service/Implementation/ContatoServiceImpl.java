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
    public Contato excluirContato(int id) {
        Optional<Contato> contatoExistente = contatoRepository.findById(id);

        if (contatoExistente.isPresent()) {
            contatoRepository.delete(contatoExistente.get());
            return contatoExistente.get();
        } else {
            throw new RuntimeException("Contato não encontrado! Tente novamente.");
        }
    }

    @Override
    public List<Contato> buscarContatoPorCliente(Integer clienteId) {
        return contatoRepository.buscarContatoPorCliente(clienteId);
    }
}
