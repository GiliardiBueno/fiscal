package com.fiscalizacao.exceptionHandler;

public class CNPJexisteException extends BackendException{

	private static final long serialVersionUID = 1L;

	public CNPJexisteException(Exception e) {
        super(Errors.ERRO_5);
    }

    public CNPJexisteException() {
        super(Errors.ERRO_5);
    }

}
