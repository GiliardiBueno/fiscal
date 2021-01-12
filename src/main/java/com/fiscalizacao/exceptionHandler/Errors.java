package com.fiscalizacao.exceptionHandler;

public enum Errors {

    // @formatter:off
    ERRO_1("CPF já existe!"),
    ERRO_2("CPF informado é inválido"),
	ERRO_99("Erro inexperado"),
	ERRO_3("Já existe um emitente cadastrado!!"),
	ERRO_4("Emitente já cadastrado!"),
	ERRO_5("CNPJ já cadastrado!"),
	ERRO_6("CNPJ INVALIDO!"),
	ERRO_7("Falta informar o paramentro: %s "),
	ERRO_8("Usuário informado não encontrado");
    // @formatter:on

    private String errorCode;
    private String errorMessage;

    private Errors(String errorMessage) {
        this.errorCode = name().substring(3);
        this.errorMessage = errorMessage;
    }

    public String format(Object... params) {
        return String.format(errorMessage, params);
    }

    public String getCode() {
        return errorCode;
    }

    public String getMessage() {
        return errorMessage;
    }
}