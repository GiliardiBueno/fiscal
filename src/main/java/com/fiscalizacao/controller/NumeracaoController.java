package com.fiscalizacao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fiscalizacao.models.Numeracao;
import com.fiscalizacao.repository.NumeracaoRepository;
import com.fiscalizacao.service.NumeracaoService;

@RestController
@RequestMapping("/numeracao")
public class NumeracaoController {

	@Autowired
	NumeracaoRepository repository;
	
	@Autowired 
	NumeracaoService service;
	
	@GetMapping
	public ResponseEntity<List<Numeracao>> pesquisar(){
		List<Numeracao> listar = repository.findAll();
		return ResponseEntity.ok(listar);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Numeracao> buscaPorId(@PathVariable Integer id){
		Numeracao numeracao = service.findById(id);
		return ResponseEntity.ok(numeracao);
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Numeracao> novaNumeracao(@Valid @RequestBody Numeracao numeracao){
		Numeracao nova = service.novaNumeracao(numeracao);
	    return ResponseEntity.ok(nova);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deleta(@PathVariable Integer id){
		service.deletaNumeracao(id);
		return ResponseEntity.ok(id);
	}
}
