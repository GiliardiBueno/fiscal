package com.fiscalizacao.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fiscalizacao.exceptionHandler.CPFExistenteException;
import com.fiscalizacao.exceptionHandler.CPFInvalidoException;
import com.fiscalizacao.exceptionHandler.MissinParameterException;
import com.fiscalizacao.exceptionHandler.UsuarioNaoExisteException;
import com.fiscalizacao.models.Usuario;
import com.fiscalizacao.repository.UsuarioRepository;
import com.fiscalizacao.service.UsuarioService;
import com.fiscalizacao.validators.UsuarioValidate;

@RestController
@RequestMapping("/user")
public class UsuarioController {

	private static String caminhoimagem = "upload/usuarios/";

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	UsuarioService usuarioService;
	
    @Autowired
    UsuarioValidate usuarioValidate;

	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> listUsuario = usuarioRepository.findAll();
		return ResponseEntity.ok(listUsuario);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Integer id) {
		Usuario usuario = usuarioService.findById(id);
		return ResponseEntity.ok(usuario);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Usuario> cadastrarUsuario(@Valid @RequestBody Usuario usuario) throws CPFInvalidoException, CPFExistenteException {
		Usuario gravaUsuario = usuarioService.salvarUsuario(usuario);
		return ResponseEntity.ok(gravaUsuario);
	}
	
	@PostMapping("/foto")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> cadastraFoto(@RequestParam("userid") Integer userid, @RequestParam("file") MultipartFile arquivo) 
			throws CPFInvalidoException, CPFExistenteException, MissinParameterException, UsuarioNaoExisteException {
		
		Usuario usuario = usuarioValidate.validaUsuario(userid);
		
		try {
			
			
			if(!arquivo.isEmpty()) {
				byte[] bytes = arquivo.getBytes();
				Path caminho = Paths.get(caminhoimagem+arquivo.getOriginalFilename());
				Files.write(caminho, bytes);
				
				usuario.setFoto(caminho+String.valueOf(usuario.getId()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		usuarioService.salvarUsuario(usuario);
		return ResponseEntity.ok("ok");
		
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Integer> deletaUsuarioPorId(@PathVariable Integer id) {
		usuarioService.deletaUser(id);
		return ResponseEntity.ok(id);
	}

}
