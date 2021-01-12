package com.fiscalizacao.exceptionHandler;

public class MissinParameterException extends BackendException {

	public MissinParameterException(Object[] params) {
		super(Errors.ERRO_7, params);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	

}
