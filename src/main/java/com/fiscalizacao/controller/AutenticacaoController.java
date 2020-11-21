package com.fiscalizacao.controller;

import javax.naming.AuthenticationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiscalizacao.configs.security.LoginForm;
import com.fiscalizacao.configs.security.TokenService;
import com.fiscalizacao.dto.TokenDTO;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService  tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDTO> autenticar(@RequestBody @Valid LoginForm form) throws AuthenticationException{
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		Authentication authentication = authenticationManager.authenticate(dadosLogin);
		String token = tokenService.gerarToken(authentication);
		System.out.println(token);
		return ResponseEntity.ok(new TokenDTO(token,"Bearer"));
		
	}
}
