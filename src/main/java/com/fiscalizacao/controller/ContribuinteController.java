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

import com.fiscalizacao.models.Contribuinte;
import com.fiscalizacao.repository.ContribuinteRepository;
import com.fiscalizacao.service.ContribuinteService;

@RestController
@RequestMapping("/contribuinte")
public class ContribuinteController {

	@Autowired
	ContribuinteRepository contribuinteRepository;
	
	@Autowired
	ContribuinteService contribuinteService;
	
	@GetMapping
	public ResponseEntity<List<Contribuinte>> pesquisa(){
		List<Contribuinte> contribuinte = contribuinteRepository.findAll();
		return ResponseEntity.ok(contribuinte);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Contribuinte> buscarContribuintePorId(@PathVariable Integer id){
		Contribuinte contribuinte  = contribuinteService.findById(id); 
		return ResponseEntity.ok(contribuinte);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Contribuinte> cadastrarContribuinte(@Valid @RequestBody Contribuinte contribuinte){
		Contribuinte salvaContribuinte = contribuinteService.salvaContribuinte(contribuinte);
       return ResponseEntity.ok(salvaContribuinte);
	}
	
    @DeleteMapping("/{id}") 
    public ResponseEntity<Integer> deleteContribuinteId(@PathVariable Integer id) {
    	contribuinteService.deletaContribuinte(id);
              return ResponseEntity.ok(id);
    }
	
}
