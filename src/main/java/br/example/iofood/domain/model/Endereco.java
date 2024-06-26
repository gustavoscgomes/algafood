package br.example.iofood.domain.model;

import jakarta.persistence.*;

import java.util.Objects;

@Embeddable
public class Endereco {

    private String cep;

    private String logradouro;

    private String complmento;

    private String bairro;

    @ManyToOne
    private Cidade cidade;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplmento() {
        return complmento;
    }

    public void setComplmento(String complmento) {
        this.complmento = complmento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
