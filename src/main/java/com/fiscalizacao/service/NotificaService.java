package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.models.Notifica;
import com.fiscalizacao.repository.NotificaRepository;

@Service
public class NotificaService {
    
	@Autowired
    NotificaRepository repository;
	
	public Notifica findById(Integer id) {
		Notifica notifica = new Notifica();
		try {
			notifica = repository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return notifica;
	}
    
	public Notifica salvaNotifica(Notifica notifica) {
		Notifica novoNotifica = new Notifica();
		try {
			novoNotifica = repository.save(notifica);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return novoNotifica;
	}
	
	public void deleta(Integer id) {
		repository.deleteById(id);
	}
    
}
