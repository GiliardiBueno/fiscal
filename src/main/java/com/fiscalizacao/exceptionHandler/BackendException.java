package com.fiscalizacao.exceptionHandler;

public class BackendException extends Exception{

    private static final long serialVersionUID = 1L;

    private final Errors error;
    private Object[] params;

    public BackendException(Exception e) {
        this(Errors.ERRO_99, null, e);
    }

    public BackendException(Errors error) {
        super(error.format());
        this.error = error;
    }

    public BackendException(Errors error, Exception cause) {
        super(error.format(), cause);
        this.error = error;
    }

    public BackendException(Errors error, Object... params) {
        super(error.format(params));
        this.error = error;
        this.params = params;
    }

    public BackendException(Errors error, Exception cause, Object... params) {
        super(error.format(params), cause);
        this.error = error;
        this.params = params;
    }

    public final String getErrorCode() {
        return error.getCode();
    }

    public final String getErrorDescription() {
        return error.format(params);
    }

    public final String getErrorMessage() {
        return error.format(params);
    }

    public Object[] getParams() {
        return params;
    }

    public String getErrorField() {
        return String.format("%s", params);
    }

}
