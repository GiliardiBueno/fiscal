package com.fiscalizacao.exceptionHandler;

public class CNPJInvalidoException extends BackendException {

	private static final long serialVersionUID = 1L;
	
	
	public CNPJInvalidoException(Exception e) {
		super(Errors.ERRO_6);
		// TODO Auto-generated constructor stub
	}
	public CNPJInvalidoException() {
		super(Errors.ERRO_6);
		// TODO Auto-generated constructor stub
	}

}
