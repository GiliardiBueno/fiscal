package com.fiscalizacao.repository.departamento;

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

import com.fiscalizacao.models.Departamento;
import com.fiscalizacao.repository.filter.DepartamentoFilter;

public class DepartamentoRepositoryImpl implements DepartamentoRepositoryQuery{
   
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Departamento> filtrar(DepartamentoFilter departamentoFilter, Pageable pageable) {
		    CriteriaBuilder buider = manager.getCriteriaBuilder();
		    CriteriaQuery<Departamento> criteria = buider.createQuery(Departamento.class);
		    Root<Departamento> root  = criteria.from(Departamento.class);
		    
		    Predicate[] predicates = criarRestricoes(departamentoFilter, buider, root );
		    criteria.where(predicates);
		    
		    TypedQuery<Departamento> query = manager.createQuery(criteria);
		    adicionarRestricoesDePaginacao(query, pageable);
		    return new PageImpl<>(query.getResultList(), pageable, total(departamentoFilter));	
	}

	private Predicate[] criarRestricoes(DepartamentoFilter departamentoFilter, CriteriaBuilder buider, Root<Departamento> root) {
		List<Predicate> predicates = new ArrayList<>();
		if(!StringUtils.isEmpty(departamentoFilter.getNome())) {
			predicates.add(buider.like(buider.lower(root.get("nome")), "%" + departamentoFilter.getNome().toLowerCase() + "%"));
		}
		if(!StringUtils.isEmpty(departamentoFilter.getDivisao())) {
			predicates.add(buider.like(buider.lower(root.get("divisao")), "%" + departamentoFilter.getDivisao().toLowerCase() + "%"));
		}
		
		if(!StringUtils.isEmpty(departamentoFilter.getResponsavel())) {
			predicates.add(buider.like(buider.lower(root.get("responsavel")), "%" + departamentoFilter.getResponsavel().toLowerCase() + "%"));
		}
		
		
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void adicionarRestricoesDePaginacao(TypedQuery<Departamento> query, Pageable pageable) {
		 int paginaAtual = pageable.getPageNumber();
	     int totalRegistroPorPagina = pageable.getPageSize();
	     int primeiroRegistroDaPagina = paginaAtual * totalRegistroPorPagina;
	        
	        query.setFirstResult(primeiroRegistroDaPagina);
	        query.setMaxResults(totalRegistroPorPagina);
		
	}
	

	private Long total(DepartamentoFilter departamentoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(long.class);
		Root<Departamento> root = criteria.from(Departamento.class);
		
		Predicate[] predicates = criarRestricoes(departamentoFilter, builder, root);
		criteria.where(predicates);
		
	    criteria.select(builder.count(root));
	    return manager.createQuery(criteria).getSingleResult();
	}

	
	

}
