package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.models.DetalhesConfig;
import com.fiscalizacao.repository.DetalhesConfigRepository;

@Service
public class DetalhesConfigService {

	@Autowired
	DetalhesConfigRepository repository;
	
	public DetalhesConfig findById(Integer id) {
		DetalhesConfig detalhes = new DetalhesConfig();
		try {
			detalhes = repository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detalhes;
	}
	
	public DetalhesConfig salvarDetConfig(DetalhesConfig detalhesConfig) {
		DetalhesConfig novoDetalhes = new DetalhesConfig();
		try {
			novoDetalhes = repository.save(detalhesConfig);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return novoDetalhes;
	}
	
	public void deletaDetalhesConfig(Integer id) {
		repository.deleteById(id);
	}

}
