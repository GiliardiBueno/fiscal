package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fiscalizacao.models.TipoUsuario;
import com.fiscalizacao.repository.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {
  @Autowired
  TipoUsuarioRepository tipoUsuarioRepository;
  
  public TipoUsuario findById(Integer id) {
	  TipoUsuario tipoUsuario = new TipoUsuario();
		try {
			tipoUsuario = tipoUsuarioRepository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipoUsuario;
	}
	
	public TipoUsuario SalvaTipoUsuario(TipoUsuario tipoUsuario) {
		TipoUsuario novoTipoUsuario = new TipoUsuario();
	   try {
		   novoTipoUsuario = tipoUsuarioRepository.save(tipoUsuario);
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return novoTipoUsuario;
	}
	
	public void deletaTipoUsuario(Integer id) {
		tipoUsuarioRepository.deleteById(id);
		
	}
	
  
  
}
