package com.fiscalizacao.repository.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaFilter {

	private String nome;
	private String cpf;
	private String rg;
	private String logradouro;
	private String numero;
}
