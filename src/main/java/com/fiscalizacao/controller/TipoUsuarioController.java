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

import com.fiscalizacao.models.TipoUsuario;
import com.fiscalizacao.repository.TipoUsuarioRepository;
import com.fiscalizacao.service.TipoUsuarioService;

@RestController
@RequestMapping("/tipouser")
public class TipoUsuarioController {

	@Autowired
	TipoUsuarioRepository tipoUsuarioRepository;
	
	@Autowired
	TipoUsuarioService tipoUsuarioService;
	
	@GetMapping
	public ResponseEntity<List<TipoUsuario>> findAll(){
		List<TipoUsuario>  listTipoUsuario = tipoUsuarioRepository.findAll();
		return ResponseEntity.ok(listTipoUsuario);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoUsuario> buscarTipoUsuario(@PathVariable Integer id){
		TipoUsuario tipoUsuario  = tipoUsuarioService.findById(id); 
		return ResponseEntity.ok(tipoUsuario);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<TipoUsuario> cadastrarTipoUsuario(@Valid @RequestBody TipoUsuario tipousuario) {
		TipoUsuario gravaTipoUsuario = tipoUsuarioService.SalvaTipoUsuario(tipousuario);
       return ResponseEntity.ok(gravaTipoUsuario);
	}
	
    @DeleteMapping("/{id}") 
    public ResponseEntity<Integer> deleteTipoUsuario(@PathVariable Integer id) {
    	tipoUsuarioService.deletaTipoUsuario(id);
              return ResponseEntity.ok(id);
    }
	
}
