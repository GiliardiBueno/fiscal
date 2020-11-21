package com.fiscalizacao.repository.imovel;

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

import com.fiscalizacao.models.Imovel;
import com.fiscalizacao.repository.filter.ImovelFilter;

public class ImovelRepositoryImpl implements ImovelRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Imovel> filtrar(ImovelFilter imovelFilter, Pageable pageable) {
		    CriteriaBuilder buider = manager.getCriteriaBuilder();
		    CriteriaQuery<Imovel> criteria = buider.createQuery(Imovel.class);
		    Root<Imovel> root  = criteria.from(Imovel.class);
		    
		    Predicate[] predicates = criarRestricoes(imovelFilter, buider, root );
		    criteria.where(predicates);
		    
		    
		   
		    TypedQuery<Imovel> query = manager.createQuery(criteria);
		    adicionarRestricoesDePaginacao(query, pageable);
		    
		    return new PageImpl<>(query.getResultList(), pageable, total(imovelFilter));
			
	}

	private Predicate[] criarRestricoes(ImovelFilter imovelFilter, CriteriaBuilder buider, Root<Imovel> root) {
        List<Predicate> predicates = new ArrayList<>();
		
		/*if(!StringUtils.isEmpty(imovelFilter.getCadastro())) {
			predicates.add(buider.equal(buider.lower(root.get("cadastro")), imovelFilter.getCadastro()));
		}*/
		if(!StringUtils.isEmpty(imovelFilter.getNome())) {
			predicates.add(buider.like(buider.lower(root.get("nomeContribuinte")), "%" +imovelFilter.getNome().toLowerCase() + "%"));
		}
		if(!StringUtils.isEmpty(imovelFilter.getCpf())) {
			predicates.add(buider.equal(buider.lower(root.get("cpfContribuinte")), imovelFilter.getCpf()));
		}
		
		if(!StringUtils.isEmpty(imovelFilter.getLogradouro())) {
			predicates.add(buider.like(buider.lower(root.get("logradouroImovel")), "%" +imovelFilter.getLogradouro().toLowerCase() + "%"));
		}
		
		if(!StringUtils.isEmpty(imovelFilter.getNumero())) {
			predicates.add(buider.equal(buider.lower(root.get("numeroImovel")), imovelFilter.getNumero()));
		}
		
		if(!StringUtils.isEmpty(imovelFilter.getCep())) {
			predicates.add(buider.equal(buider.lower(root.get("cepImovel")), imovelFilter.getCep()));
		}
		
		if(!StringUtils.isEmpty(imovelFilter.getBairro())) {
			predicates.add(buider.like(buider.lower(root.get("bairroImovel")), "%" +imovelFilter.getBairro().toLowerCase() + "%"));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void adicionarRestricoesDePaginacao(TypedQuery<Imovel> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistroPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistroPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistroPorPagina);
		
	}

	private Long total(ImovelFilter imovelFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(long.class);
		Root<Imovel> root = criteria.from(Imovel.class);
		
		Predicate[] predicates = criarRestricoes(imovelFilter, builder, root);
		criteria.where(predicates);
		
	    criteria.select(builder.count(root));
	    return manager.createQuery(criteria).getSingleResult();
	}
}
