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

import com.fiscalizacao.models.TipoNotificacao;
import com.fiscalizacao.repository.TipoNotificacaoRepository;
import com.fiscalizacao.repository.filter.TipoNoticacaoFilter;
import com.fiscalizacao.service.TipoNotificacaoService;

@RestController
@RequestMapping("/tiponotificacao")
public class TipoNotificacaoController {
	
	@Autowired
	TipoNotificacaoRepository repository;
	
	@Autowired
	TipoNotificacaoService service;
	
	@GetMapping
	public Page<TipoNotificacao> pesquisar(TipoNoticacaoFilter tipoNotificacaoFilter, Pageable pageable){
    return repository.filtrar(tipoNotificacaoFilter, pageable);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoNotificacao> buscaPorId(@PathVariable Integer id){
		TipoNotificacao tipoNotificacao = new TipoNotificacao();
		tipoNotificacao = service.findById(id);
		return ResponseEntity.ok(tipoNotificacao);
		}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<TipoNotificacao> novoTipo(@Valid @RequestBody TipoNotificacao tipoNotificacao){
		TipoNotificacao novoTipoNotificacao = service.salvaTipoNotificacao(tipoNotificacao);
		return ResponseEntity.ok(novoTipoNotificacao);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deleta(@PathVariable Integer id){
		 service.deletaTipoNotificacao(id);
		 return ResponseEntity.ok(id);
	}

}
