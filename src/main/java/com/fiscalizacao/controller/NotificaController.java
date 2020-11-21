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

import com.fiscalizacao.models.Notifica;
import com.fiscalizacao.repository.NotificaRepository;
import com.fiscalizacao.service.NotificaService;

@RestController
@RequestMapping("/notifica")
public class NotificaController {
	@Autowired
	NotificaRepository repository;
	
	@Autowired
	NotificaService service;
	
	@GetMapping
	public ResponseEntity<List<Notifica>> pesquisa(){
	   List<Notifica> listaNotifica = repository.findAll();
	   return ResponseEntity.ok(listaNotifica);
	   
	}
	@GetMapping("/{id}")
	public ResponseEntity<Notifica> buscaPorId(@PathVariable Integer id){
		Notifica notifica = new Notifica();
		notifica = service.findById(id);
		return ResponseEntity.ok(notifica);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Notifica> novaNotificacao(@Valid @RequestBody Notifica notifica){
		Notifica nova = new Notifica();
		nova = service.salvaNotifica(notifica);
		return ResponseEntity.ok(nova);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deleta(@PathVariable Integer id){
		service.deleta(id);
		return ResponseEntity.ok(id);
	}
	

}
