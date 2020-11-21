package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.models.Emitente;
import com.fiscalizacao.repository.EmitenteRepository;
import com.fiscalizacao.validate.EmitenteValidate;

@Service
public class EmitenteService {
  
	@Autowired
	EmitenteRepository emitenteRepository;
	
	@Autowired
	EmitenteValidate emitenteValidate;
	
	public Emitente findById(Integer id) {
		Emitente emitente = new Emitente();
		try {
			emitente = emitenteRepository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emitente;
	}
	
	public Emitente salvaEmitente(Emitente emitente){
		Emitente novoEmitente = new Emitente();
	   try {
		   novoEmitente = emitenteRepository.save(emitente);	
	   } catch (Exception e) {
		e.printStackTrace();
	}
	   return novoEmitente;
	}
	
	public void deletaEmitente(Integer id) {
		emitenteRepository.deleteById(id);
		
	}
	
}
