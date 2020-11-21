package com.fiscalizacao.configs;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Giovani de Souza Bueno
 */

@Configuration
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "url")
@Getter
@Setter
public class URLProperties {

@Autowired 
private SpringProperties spring;

    @Configuration
    @EnableConfigurationProperties
    @ConfigurationProperties(prefix = "spring")
    public class SpringProperties {

        private Map<String, String> datasource;

        
		public Map<String, String> getDatasource() {
            return datasource;
        }

        public void setDatasource(Map<String, String> datasource) {
            this.datasource = datasource;
        }
        

    }

}