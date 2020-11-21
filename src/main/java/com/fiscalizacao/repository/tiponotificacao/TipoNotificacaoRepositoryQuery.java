package com.fiscalizacao.repository.tiponotificacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fiscalizacao.models.TipoNotificacao;
import com.fiscalizacao.repository.filter.TipoNoticacaoFilter;

public interface TipoNotificacaoRepositoryQuery {

	Page<TipoNotificacao> filtrar(TipoNoticacaoFilter tipoNotificacaoFilter, Pageable pageable);
}
