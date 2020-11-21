package com.fiscalizacao.configs.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.Setter;

@Setter
public class LoginForm {

	private String login;
	private String senha;
	
	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(login, senha);
	}
}
