package com.example.agendaComercioSA.Service.Implementation;

import com.example.agendaComercioSA.Model.Cliente;
import com.example.agendaComercioSA.Repository.ClienteRepository;
import com.example.agendaComercioSA.Service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor

public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;

    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente editarCliente(Cliente cliente) {
        Optional<Cliente> clienteExistente = clienteRepository.findByCpf(cliente.getCpf());

        if (clienteExistente.isPresent()) {
            Cliente editarCliente = clienteExistente.get();
            editarCliente.setNome(cliente.getNome());
            editarCliente.setCpf(cliente.getCpf());
            editarCliente.setData_nascimento(cliente.getData_nascimento());
            editarCliente.setEndereco(cliente.getEndereco());

            return clienteRepository.save(editarCliente);
        } else {
            throw new RuntimeException("Usuário não cadastrado! Tente novamente.");
        }

    }

    @Override
    public Cliente excluirCliente(String cpf) {
        Optional<Cliente> clienteExistente = clienteRepository.findByCpf(cpf);

        if (clienteExistente.isPresent()) {
            clienteRepository.delete(clienteExistente.get());
            return clienteExistente.get();
        } else {
            throw new RuntimeException("Usuário não encontrado! Tente novamente.");
        }
    }

    @Override
    public List<Cliente> listarCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public List<Cliente> buscarClienteNomeCpf (String buscarCliente){
        return clienteRepository.buscarClienteNomeCpf(buscarCliente);
    }
}