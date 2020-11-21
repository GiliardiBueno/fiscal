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

import com.fiscalizacao.dto.ParametrizaDTO;
import com.fiscalizacao.models.TerrenoSujo;
 
import com.fiscalizacao.repository.ParametrizaRepository;
import com.fiscalizacao.service.ParametrizaService;

@RestController
@RequestMapping("/parametriza")
public class ParametrizaController {

	@Autowired
	ParametrizaRepository parametrizaRepository;
	
	@Autowired
	ParametrizaService parametrizaService;
	
	@GetMapping
	public ResponseEntity<List<TerrenoSujo>> findAll(){
		List<TerrenoSujo> listaParametriza = parametrizaRepository.findAll();
		return ResponseEntity.ok(listaParametriza);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TerrenoSujo>  buscaParametriza(@PathVariable  Integer id){
		TerrenoSujo parametriza = parametrizaService.findById(id);
		return ResponseEntity.ok(parametriza);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<TerrenoSujo> SalvarParametriza(@Valid @RequestBody ParametrizaDTO dto){
		TerrenoSujo salvaParametriza = parametrizaService.SalvaParametriza(dto.transFormaParaObj());
		return ResponseEntity.ok(salvaParametriza);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deletaParametriza(@PathVariable Integer id){
		parametrizaService.deletaParametriza(id);
		return ResponseEntity.ok(id);
	}
	
}
