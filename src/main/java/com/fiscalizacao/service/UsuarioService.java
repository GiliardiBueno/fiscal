package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.exceptionHandler.CPFExistenteException;
import com.fiscalizacao.exceptionHandler.CPFInvalidoException;
import com.fiscalizacao.models.Usuario;
import com.fiscalizacao.repository.UsuarioRepository;
import com.fiscalizacao.utils.Utils;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario findById(Integer id) {
		Usuario usuario = new Usuario();
		try {
			usuario = usuarioRepository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	public Usuario salvarUsuario(Usuario user) throws CPFInvalidoException, CPFExistenteException {
	   Usuario novoUser = new Usuario();
	   if (!Utils.isCPF(user.getCpf())) {
			throw new CPFInvalidoException();
		}
		try {
			novoUser = usuarioRepository.save(user);
			
		} catch (Exception e) {
			throw new CPFExistenteException();
		}

	return novoUser;
	}
	
	public void deletaUser(Integer id) {
		usuarioRepository.deleteById(id);
		
	}
}
