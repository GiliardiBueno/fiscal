package com.fiscalizacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.interfaces.IDetalhesConfig;
import com.fiscalizacao.models.Config;
import com.fiscalizacao.models.DetalhesConfig;
import com.fiscalizacao.repository.ConfigRepository;

@Service
public class ConfigService {

	@Autowired
	ConfigRepository repository;
	
	public Config findById(Integer id) {
		Config config = new Config();
		try {
			config = repository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return config;
	}
	
	public Config salvarConfig(Config config) {
		Config novoConfig = new Config();
		try {
			novoConfig = repository.save(config);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return novoConfig;
	}
	public List<IDetalhesConfig> buscarPorConfigAno(Integer config, String ano) {
		return repository.getDetalhesConfigEmitenteAno(config, ano);		
	}
	
	public void deletaConfig(Integer id) {
		repository.deleteById(id);
	}
}
