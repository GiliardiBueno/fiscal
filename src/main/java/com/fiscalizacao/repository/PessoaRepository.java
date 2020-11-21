package com.fiscalizacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiscalizacao.models.Pessoa;
import com.fiscalizacao.repository.pessoa.PessoaRepositoryQuery;

@Repository
public interface PessoaRepository  extends JpaRepository<Pessoa, Integer>, PessoaRepositoryQuery {

}
