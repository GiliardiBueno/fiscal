package com.fiscalizacao.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.fiscalizacao.models.Departamento;
import com.fiscalizacao.repository.DepartamentoRepository;
import com.fiscalizacao.repository.filter.DepartamentoFilter;
import com.fiscalizacao.service.DepartamentoService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
 
	@Autowired
	DepartamentoRepository repository;
	
	@Autowired
	DepartamentoService service;
	
	@GetMapping
	public Page<Departamento>  pesquisa(DepartamentoFilter departamentoFilter, Pageable pageable){
		return  repository.filtrar(departamentoFilter, pageable);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Departamento>  buscaPorId(@PathVariable Integer id){
		Departamento departamento = service.findById(id);
		return ResponseEntity.ok(departamento);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Departamento>  cadastraDepartamento(@Valid @RequestBody Departamento departamento){
		Departamento novo = service.novoDepartamento(departamento);
		return ResponseEntity.ok(novo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deletaDept(@PathVariable Integer id){
		service.deletaDepartamento(id);
		return ResponseEntity.ok(id);
				
	}
	
	
	
	
}
