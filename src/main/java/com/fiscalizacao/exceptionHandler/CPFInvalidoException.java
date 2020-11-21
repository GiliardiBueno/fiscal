package com.fiscalizacao.exceptionHandler;

public class CPFInvalidoException  extends BackendException{

	private static final long serialVersionUID = 1L;

	public CPFInvalidoException(Exception e) {
        super(Errors.ERRO_2);
    }

    public CPFInvalidoException() {
        super(Errors.ERRO_2);
    }

}
