package com.fiscalizacao.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiscalizacao.models.Pessoa;
import com.fiscalizacao.repository.PessoaRepository;
import com.fiscalizacao.repository.filter.PessoaFilter;
import com.fiscalizacao.response.PessoaResponse;
import com.fiscalizacao.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	PessoaRepository repository;
	
	@Autowired
	PessoaService service;
	
	@GetMapping
	public Page<Pessoa> pesquisar(PessoaFilter PessoaFilter, Pageable pageable){
		return repository.filtrar(PessoaFilter, pageable);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> buscaPorId(@PathVariable Integer id){
		Pessoa pessoa = service.findById(id);
		return ResponseEntity.ok(pessoa);
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> novaPessoa(@Valid @RequestBody Pessoa pessoa){
		Pessoa  nova = new Pessoa();
		nova = service.salvaPessoa(pessoa);
		return ResponseEntity.ok(nova);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> delete(@PathVariable Integer id){
		service.deletaPessoa(id);
		return ResponseEntity.ok(id);
	}

}
