package com.notificacao.infrastructure.exceptions;

public class EmailException extends RuntimeException {
    public EmailException(String menssagem) {

        super(menssagem);
    }

    public EmailException(String mensagem, Throwable throwable){
        super(mensagem, throwable);
    }
}
