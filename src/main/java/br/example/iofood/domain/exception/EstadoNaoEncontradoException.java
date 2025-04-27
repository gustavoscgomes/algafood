package br.example.iofood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class EstadoNaoEncontradoException extends EntidadeNaoEncontradaException{

    public EstadoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public EstadoNaoEncontradoException(Long id) {
        this(String.format("Não existe um cadastro de estado com código %d", id));
    }
}
