package com.fiscalizacao.exceptionHandler;

public class EmitenteExistenteException extends  BackendException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmitenteExistenteException(Exception e) {
        super(Errors.ERRO_3);
    }

    public EmitenteExistenteException() {
        super(Errors.ERRO_3);
    }

}
