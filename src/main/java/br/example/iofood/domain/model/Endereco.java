package br.example.iofood.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Embeddable
public class Endereco {

    @Column(name = "enredereco_cep")
    private String cep;
    @Column(name = "enredereco_logradouro")
    private String logradouro;
    @Column(name = "enredereco_numero")
    private String numero;
    @Column(name = "enredereco_complemento")
    private String complmento;
    @Column(name = "enredereco_bairro")
    private String bairro;
    @ManyToOne
    @JoinColumn(name = "endereco_cidade_id")
    private Cidade cidade;
}
