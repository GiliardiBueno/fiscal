package com.fiscalizacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiscalizacao.models.DetalhesConfig;

@Repository
public interface DetalhesConfigRepository extends JpaRepository<DetalhesConfig, Integer>{

}
