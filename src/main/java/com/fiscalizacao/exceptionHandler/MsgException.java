package com.fiscalizacao.exceptionHandler;

public class MsgException extends BackendException {
	private static final long serialVersionUID = 1L;

	public MsgException(Exception e) {
        super(Errors.ERRO_99);
    }

    public MsgException() {
        super(Errors.ERRO_99);
    }


	

	
	

}
