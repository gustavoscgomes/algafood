package br.example.iofood.domain.exception;

public class EntidadeEmUsoException extends RuntimeException{

    public EntidadeEmUsoException(String mensagem) {
        super(mensagem);
    }
}
