package com.fiscalizacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiscalizacao.models.Imovel;
import com.fiscalizacao.repository.imovel.ImovelRepositoryQuery;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Integer> , ImovelRepositoryQuery{

}
