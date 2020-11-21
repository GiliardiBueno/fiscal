package com.fiscalizacao.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fiscalizacao.models.Emitente;

@Repository
public interface EmitenteRepository extends JpaRepository<Emitente, Integer>{
	
	@Query(value = "SELECT COUNT(e) from Emitente e")
	int countEmitente();
	
	@Query(value = "SELECT * from emitente e where e.pessoa_id = :id", nativeQuery = true)
	Optional<Emitente> findbyPessoaId(@Param("id") int id);
	

}
