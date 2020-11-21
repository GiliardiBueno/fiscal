package com.fiscalizacao.enums;

public enum TipoFcEnum {

	FISICA(0), 
	JURIDICA(1);
	
	public int valor;

	private TipoFcEnum(int valor) {
		this.valor = valor;
	}
}
