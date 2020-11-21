package com.fiscalizacao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiscalizacao.interfaces.IDetalhesConfig;
import com.fiscalizacao.models.Config;
import com.fiscalizacao.repository.ConfigRepository;
import com.fiscalizacao.service.ConfigService;

@RestController
@RequestMapping("/config")
public class ConfigController {

	@Autowired
	ConfigRepository repository;
	
	@Autowired
	ConfigService service;
	
	@GetMapping
	public ResponseEntity<List<Config>>  pesquisar(){
		List<Config> listar = repository.findAll();
		return ResponseEntity.ok(listar);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Config> buscaPorId(@PathVariable Integer id){
		Config config = service.findById(id);
		return ResponseEntity.ok(config);
	}
	
	@GetMapping("/{id}/{ano}")
	public ResponseEntity<List<IDetalhesConfig>> buscaPorIdTeste(@PathVariable Integer id, @PathVariable String ano){
		List<IDetalhesConfig> detalhesConfigList = service.buscarPorConfigAno(id, ano);
		return ResponseEntity.ok(detalhesConfigList);
	}
	
	
	@PostMapping
	public ResponseEntity<Config> novoConfig(@Valid @RequestBody Config config){
		Config novoConfig = new Config();
		novoConfig = service.salvarConfig(config);
		return ResponseEntity.ok(novoConfig);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deletarConfig(@PathVariable Integer id){
		service.deletaConfig(id);
		return ResponseEntity.ok(id);
	}
}
