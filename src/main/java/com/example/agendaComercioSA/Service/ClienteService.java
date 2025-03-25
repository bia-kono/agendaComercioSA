    package com.example.agendaComercioSA.Service;

    import com.example.agendaComercioSA.Model.Cliente;

    import java.util.List;


    public interface ClienteService {

        //Cadastrar
        Cliente cadastrarCliente(Cliente cliente);

        //Editar
        Cliente editarCliente(Cliente cliente);

        //Excluir
        Cliente excluirCliente(String cpf);

        //Listar todos os clientes
        List<Cliente> listarCliente();

        //Buscar pelo cpf ou nome
        List<Cliente> buscarClienteNomeCpf(String buscarCliente);

    }
