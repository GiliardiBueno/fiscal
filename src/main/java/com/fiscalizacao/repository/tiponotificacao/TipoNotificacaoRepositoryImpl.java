package com.fiscalizacao.repository.tiponotificacao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.fiscalizacao.models.TipoNotificacao;
import com.fiscalizacao.repository.filter.TipoNoticacaoFilter;

public class TipoNotificacaoRepositoryImpl implements TipoNotificacaoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<TipoNotificacao> filtrar(TipoNoticacaoFilter tipoNotificacaoFilter, Pageable pageable) {
		    CriteriaBuilder buider = manager.getCriteriaBuilder();
		    CriteriaQuery<TipoNotificacao> criteria = buider.createQuery(TipoNotificacao.class);
		    Root<TipoNotificacao> root  = criteria.from(TipoNotificacao.class);
		    
		    Predicate[] predicates = criarRestricoes(tipoNotificacaoFilter, buider, root );
		    criteria.where(predicates);
		    
		    TypedQuery<TipoNotificacao> query = manager.createQuery(criteria);
		    adicionarRestricoesDePaginacao(query, pageable);
		    
		    return new PageImpl<>(query.getResultList(), pageable, total(tipoNotificacaoFilter));
	}


	private Predicate[] criarRestricoes(TipoNoticacaoFilter tipoNotificacaoFilter, CriteriaBuilder buider, Root<TipoNotificacao> root) {
		List<Predicate> predicates = new ArrayList<>();
		if(!StringUtils.isEmpty(tipoNotificacaoFilter.getNome())) {
			predicates.add(buider.like(buider.lower(root.get("nome")), "%" + tipoNotificacaoFilter.getNome().toLowerCase() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void adicionarRestricoesDePaginacao(TypedQuery<TipoNotificacao> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistroPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistroPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistroPorPagina);
		
	}
	
	private Long total(TipoNoticacaoFilter tipoNotificacaoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(long.class);
		Root<TipoNotificacao> root = criteria.from(TipoNotificacao.class);
		
		Predicate[] predicates = criarRestricoes(tipoNotificacaoFilter, builder, root);
		criteria.where(predicates);
		
	    criteria.select(builder.count(root));
	    return manager.createQuery(criteria).getSingleResult();
	}

	
	
}
