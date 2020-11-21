package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.models.Departamento;
import com.fiscalizacao.repository.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
	DepartamentoRepository repository;
	
	public Departamento  findById(Integer id) {
		Departamento departamento = new Departamento();
		try {
			departamento = repository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return departamento;
	}
	
	public Departamento novoDepartamento(Departamento departamento) {
		Departamento novoDepartamento = new Departamento();
		try {
			novoDepartamento = repository.save(departamento);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return novoDepartamento;
	}
	
	public void deletaDepartamento(Integer id) {
		repository.deleteById(id);
	}
	
}
