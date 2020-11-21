package com.fiscalizacao.configs;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig {
	@Autowired
	private URLProperties ymlConfig;

	@Bean(initMethod = "migrate")
	public Flyway flyway() {
		Flyway flyway = Flyway.configure()
				.dataSource(ymlConfig.getSpring().getDatasource().get("url"),
						ymlConfig.getSpring().getDatasource().get("username"),
						ymlConfig.getSpring().getDatasource().get("password"))
				.baselineDescription("Migração do banco de dados da API-FISCALIZA").baselineOnMigrate(true)
				.schemas(ymlConfig.getSpring().getDatasource().get("database")).outOfOrder(true).cleanDisabled(true)
				.load();
		flyway.repair();
		flyway.baseline();

		return flyway;
	}

}
