package com.fiscalizacao.repository.departamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fiscalizacao.models.Departamento;
import com.fiscalizacao.repository.filter.DepartamentoFilter;

public interface DepartamentoRepositoryQuery {

	Page<Departamento> filtrar(DepartamentoFilter departamentoFilter, Pageable pageable);
}
