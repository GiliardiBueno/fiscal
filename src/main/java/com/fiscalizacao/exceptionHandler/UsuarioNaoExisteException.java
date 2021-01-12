package com.fiscalizacao.exceptionHandler;

public class UsuarioNaoExisteException extends BackendException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioNaoExisteException(Errors error) {
		super(error);
		
	}
	public UsuarioNaoExisteException() {
	        super(Errors.ERRO_8);
	    }


}
