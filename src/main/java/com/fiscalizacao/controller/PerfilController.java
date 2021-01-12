package com.fiscalizacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiscalizacao.models.Perfil;
import com.fiscalizacao.repository.PerfilRepository;
import com.fiscalizacao.service.PerfilService;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

	@Autowired
	PerfilRepository repository;
	
	@Autowired
	PerfilService service;
	
	@GetMapping
	public ResponseEntity<List<Perfil>> pesquisar(){
		List<Perfil> perfil = repository.findAll();
		return ResponseEntity.ok(perfil);
 	}
	
}
