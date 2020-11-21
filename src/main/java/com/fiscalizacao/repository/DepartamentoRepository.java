package com.fiscalizacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiscalizacao.models.Departamento;
import com.fiscalizacao.repository.departamento.DepartamentoRepositoryQuery;

@Repository
public interface DepartamentoRepository  extends JpaRepository<Departamento, Integer>, DepartamentoRepositoryQuery{

	

}
