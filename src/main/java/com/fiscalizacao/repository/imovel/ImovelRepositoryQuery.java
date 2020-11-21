package com.fiscalizacao.repository.imovel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fiscalizacao.models.Imovel;
import com.fiscalizacao.repository.filter.ImovelFilter;

public interface ImovelRepositoryQuery {

	Page<Imovel> filtrar(ImovelFilter imovelFilter, Pageable pageable);
}
