package com.fiscalizacao.repository.pessoa;

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

import com.fiscalizacao.models.Pessoa;
import com.fiscalizacao.repository.filter.PessoaFilter;

public class PessoaRepositoryImpl implements PessoaRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Pessoa> filtrar(PessoaFilter pessoaFilter, Pageable pageable) {
		    CriteriaBuilder buider = manager.getCriteriaBuilder();
		    CriteriaQuery<Pessoa> criteria = buider.createQuery(Pessoa.class);
		    Root<Pessoa> root  = criteria.from(Pessoa.class);
		    
		    Predicate[] predicates = criarRestricoes(pessoaFilter, buider, root );
		    criteria.where(predicates);
		    
		    TypedQuery<Pessoa> query = manager.createQuery(criteria);
		    adicionarRestricoesDePaginacao(query, pageable);
		    
		    return new PageImpl<>(query.getResultList(), pageable, total(pessoaFilter));
	}

	private Predicate[] criarRestricoes(PessoaFilter pessoaFilter, CriteriaBuilder buider, Root<Pessoa> root) {
		List<Predicate> predicates = new ArrayList<>();
		if(!StringUtils.isEmpty(pessoaFilter.getNome())) {
			predicates.add(buider.like(buider.lower(root.get("nome")), "%" + pessoaFilter.getNome().toLowerCase() + "%"));
		}
		if(!StringUtils.isEmpty(pessoaFilter.getCpf())) {
			predicates.add(buider.equal(buider.lower(root.get("cpf")), pessoaFilter.getCpf()));
		}
		
		if(!StringUtils.isEmpty(pessoaFilter.getRg())) {
			predicates.add(buider.equal(buider.lower(root.get("rg")), pessoaFilter.getRg()));
		}
		
		if(!StringUtils.isEmpty(pessoaFilter.getLogradouro())) {
			predicates.add(buider.like(buider.lower(root.get("logradouro")),"%" + pessoaFilter.getLogradouro() + "%"));
		}
		
		if(!StringUtils.isEmpty(pessoaFilter.getNumero())) {
			predicates.add(buider.equal(buider.lower(root.get("numero")), pessoaFilter.getNumero()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void adicionarRestricoesDePaginacao(TypedQuery<Pessoa> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistroPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistroPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistroPorPagina);
		
	}

	private Long total(PessoaFilter pessoaFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(long.class);
		Root<Pessoa> root = criteria.from(Pessoa.class);
		
		Predicate[] predicates = criarRestricoes(pessoaFilter, builder, root);
		criteria.where(predicates);
		
	    criteria.select(builder.count(root));
	    return manager.createQuery(criteria).getSingleResult();
	}
}
