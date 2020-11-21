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

import com.fiscalizacao.models.DetalhesConfig;
import com.fiscalizacao.repository.DetalhesConfigRepository;
import com.fiscalizacao.service.DetalhesConfigService;

@RestController
@RequestMapping("/detalhesconfig")
public class DetalhesConfigController {

	@Autowired
	DetalhesConfigRepository repository;
	
	@Autowired 
	DetalhesConfigService service;
	
	@GetMapping
	public ResponseEntity<List<DetalhesConfig>>  pesquisar(){
		List<DetalhesConfig> listar = repository.findAll();
		return ResponseEntity.ok(listar);
	}
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesConfig> buscarPorId(@PathVariable Integer id){
		DetalhesConfig listaDetalhe = service.findById(id);
		return ResponseEntity.ok(listaDetalhe);
	}
	@PostMapping
	public ResponseEntity<DetalhesConfig> novoDetalheConfig(@Valid @RequestBody DetalhesConfig detalhesConfig){
		DetalhesConfig novo = new DetalhesConfig();
		novo = service.salvarDetConfig(detalhesConfig);
		return ResponseEntity.ok(novo);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deletarDetalhe(@PathVariable Integer id){
		service.deletaDetalhesConfig(id);
		return ResponseEntity.ok(id);
	}
	
}
