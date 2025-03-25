package com.example.agendaComercioSA.Repository;

import com.example.agendaComercioSA.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

   // Cliente buscarClientePorNomeOuCpf(String nome, String cpf);

    @Query("SELECT c FROM Cliente c WHERE c.nome LIKE %:buscarCliente% OR c.cpf LIKE %:buscarCliente%")
    List<Cliente> buscarClienteNomeCpf(@Param("buscarCliente") String buscarCliente);

    Optional<Cliente> findByCpf(String cpf);
}
