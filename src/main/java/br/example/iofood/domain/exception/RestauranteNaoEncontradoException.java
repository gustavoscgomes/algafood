package br.example.iofood.domain.exception;


public class RestauranteNaoEncontradoException extends EntidadeNaoEncontradaException{

    public RestauranteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public RestauranteNaoEncontradoException(Long id) {
        this(String.format("Não existe um cadastro de restaurante com código %d", id));
    }
}
