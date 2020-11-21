package com.fiscalizacao.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiscalizacao.models.TerrenoSujo;

@Repository
public interface ParametrizaRepository extends JpaRepository<TerrenoSujo, Integer> {


}
