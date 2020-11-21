package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.models.SetorDepartamento;
import com.fiscalizacao.repository.SetorDepartamentoRepository;

@Service
public class SetorDepartamentoService {

	
	@Autowired
	SetorDepartamentoRepository repository;
	
	public SetorDepartamento findById(Integer id) {
		SetorDepartamento setorDepartamento = new SetorDepartamento();
		try {
			setorDepartamento = repository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return setorDepartamento;
	}
	public SetorDepartamento salvaSetorDepartamento(SetorDepartamento setorDepartamento){
		SetorDepartamento novo = new SetorDepartamento();
		 try {
			novo = repository.save(setorDepartamento);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return novo;
		}
	public void deletaSetorDepartamento(Integer id) {
		repository.deleteById(id);
	}
	
}
