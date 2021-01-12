package com.fiscalizacao.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiscalizacao.exceptionHandler.MissinParameterException;
import com.fiscalizacao.exceptionHandler.UsuarioNaoExisteException;
import com.fiscalizacao.models.Usuario;
import com.fiscalizacao.service.UsuarioService;

@Component
public class UsuarioValidate {
	
	@Autowired
	private UsuarioService usuarioService;
	
	public Usuario validaUsuario(Integer userid) throws MissinParameterException, UsuarioNaoExisteException {
		if(userid == null) {
			throw new MissinParameterException(new Object[]{ (Object) "userId"});
		}
		
		Usuario usuario = usuarioService.findById(userid);
		if(usuario  == null) {
			throw new UsuarioNaoExisteException();
		}
		return usuario;
	}

}
