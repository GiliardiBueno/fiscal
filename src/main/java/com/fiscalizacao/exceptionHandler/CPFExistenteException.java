package com.fiscalizacao.exceptionHandler;

public class CPFExistenteException extends BackendException {

	private static final long serialVersionUID = 1L;

	public CPFExistenteException(Exception e) {
        super(Errors.ERRO_1);
    }

    public CPFExistenteException() {
        super(Errors.ERRO_1);
    }
}
