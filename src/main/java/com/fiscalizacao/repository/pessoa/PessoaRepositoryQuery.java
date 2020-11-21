package com.fiscalizacao.repository.pessoa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fiscalizacao.models.Pessoa;
import com.fiscalizacao.repository.filter.PessoaFilter;

public interface PessoaRepositoryQuery {
	
	Page<Pessoa> filtrar(PessoaFilter pessoaFilter, Pageable pageable);
}
