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

import com.fiscalizacao.models.Emitente;
import com.fiscalizacao.repository.EmitenteRepository;
import com.fiscalizacao.service.EmitenteService;


@RestController
@RequestMapping("/emitente")
public class EmitenteController {

	@Autowired
	EmitenteRepository emitenteRepository;
	
	@Autowired
	EmitenteService emitenteService;
	

	
	@GetMapping
	public ResponseEntity<List<Emitente>> findAll(){
		List<Emitente>  listEmitente = emitenteRepository.findAll();
		return ResponseEntity.ok(listEmitente);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Emitente> buscarEmitentePorId(@PathVariable Integer id){
		Emitente emitente  = emitenteService.findById(id); 
		return ResponseEntity.ok(emitente);
	}

	@PostMapping
	public ResponseEntity<Emitente> cadastrarEmitente(@Valid @RequestBody Emitente emitente){
		Emitente novo = emitenteService.salvaEmitente(emitente);
       return ResponseEntity.ok(novo);
	}
	
    @DeleteMapping("/{id}") 
    public ResponseEntity<Integer> deleteEmitenteId(@PathVariable Integer id) {
    	emitenteService.deletaEmitente(id);
              return ResponseEntity.ok(id);
    }
	
}
