package com.ornelas.foodapi.domain.exception;



public class EstadoNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public EstadoNaoEncontradoException(String message) {
        super(message);
    }

    public EstadoNaoEncontradoException(Long estadoId) {
        this(String.format("Não foi encontrado um Estado com o id %d", estadoId));
    }
}
