package com.fiscalizacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fiscalizacao.interfaces.IDetalhesConfig;
import com.fiscalizacao.models.Config;

@Repository
public interface ConfigRepository extends JpaRepository<Config, Integer> {
	
	
	@Query(value = "SELECT dc.* FROM detalhes_config dc " + 
			"INNER JOIN config c ON c.id = dc.config_id " + 
			"INNER JOIN emitente e ON e.id = c.emitente_id " + 
			"WHERE e.pessoa_id = :id AND ano_vigente = :ano",nativeQuery = true)
	List<IDetalhesConfig> getDetalhesConfigEmitenteAno(@Param("id") int id, @Param("ano") String ano);
	
}
