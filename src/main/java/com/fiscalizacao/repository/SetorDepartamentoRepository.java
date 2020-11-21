package com.fiscalizacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiscalizacao.models.SetorDepartamento;

@Repository
public interface SetorDepartamentoRepository  extends JpaRepository<SetorDepartamento, Integer>{

}
