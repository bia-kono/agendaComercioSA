package com.example.agendaComercioSA.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Contato {
    //id, cliente_id, tipo, valor, observacao

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false) //fk
    private Cliente cliente;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String valor;

    private String observacao;

}
