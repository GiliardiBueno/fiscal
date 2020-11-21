package com.fiscalizacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiscalizacao.models.TipoNotificacao;
import com.fiscalizacao.repository.tiponotificacao.TipoNotificacaoRepositoryQuery;

@Repository
public interface TipoNotificacaoRepository extends JpaRepository<TipoNotificacao, Integer>, TipoNotificacaoRepositoryQuery{

	

}
