package com.fiscalizacao.exceptionHandler;

public class EmitenteCadastradoException extends BackendException {

	public EmitenteCadastradoException(Exception e) {
		super(Errors.ERRO_4);
		
	}
	public EmitenteCadastradoException() {
		super(Errors.ERRO_4);
		
	}

}
