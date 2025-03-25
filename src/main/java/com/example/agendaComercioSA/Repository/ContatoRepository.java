package com.example.agendaComercioSA.Repository;

import com.example.agendaComercioSA.Model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {


    @Query("SELECT c FROM Contato c WHERE c.cliente.id = :clienteId")
    List<Contato> buscarContatoPorCliente(@Param("clienteId") Integer clienteId);

}
