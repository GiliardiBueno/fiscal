package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fiscalizacao.models.Perfil;
import com.fiscalizacao.repository.PerfilRepository;

@Service
public class PerfilService {

	  
		@Autowired
	    PerfilRepository repository;
		
		public Perfil findById(Integer id) {
			Perfil perfil = new Perfil();
			try {
				perfil = repository.findById(id).orElse(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return perfil;
		}
	    
		public Perfil salvaPerfil(Perfil perfil) {
			Perfil novoPerfil = new Perfil();
			try {
				novoPerfil = repository.save(perfil);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return novoPerfil;
		}
		
		public void deletaPerfil(Integer id) {
			repository.deleteById(id);
		}
}
