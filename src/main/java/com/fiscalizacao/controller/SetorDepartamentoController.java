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

import com.fiscalizacao.models.SetorDepartamento;
import com.fiscalizacao.repository.SetorDepartamentoRepository;
import com.fiscalizacao.service.SetorDepartamentoService;

@RestController
@RequestMapping("/setorDepartamento")
public class SetorDepartamentoController {

	@Autowired
	SetorDepartamentoRepository repository;
	
	@Autowired 
	SetorDepartamentoService service;
	
	@GetMapping
	public ResponseEntity<List<SetorDepartamento>> pesqusa(){
	  List<SetorDepartamento>  listar = repository.findAll();
	   return ResponseEntity.ok(listar);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SetorDepartamento> buscaPorId(@PathVariable Integer id){
		SetorDepartamento buscaSetorDepartamento = service.findById(id);
		return ResponseEntity.ok(buscaSetorDepartamento);
	}
	
	@PostMapping
	public ResponseEntity<SetorDepartamento> salvaSetorDepartamento(@Valid @RequestBody SetorDepartamento setorDepartamento){
		SetorDepartamento salvaSDepartamento = service.salvaSetorDepartamento(setorDepartamento);
		return ResponseEntity.ok(salvaSDepartamento);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deletaSetorDepartamento(@PathVariable Integer id){
	     service.deletaSetorDepartamento(id);
	     return ResponseEntity.ok(id);
	}
}
