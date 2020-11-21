package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.models.Numeracao;
import com.fiscalizacao.repository.NumeracaoRepository;

@Service
public class NumeracaoService {

	@Autowired
	NumeracaoRepository repository;
	
	public Numeracao findById(Integer id) {
		Numeracao listNumeracao = new Numeracao();
		try {
			listNumeracao = repository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listNumeracao;
	}
	
	public Numeracao novaNumeracao(Numeracao numeracao) {
		Numeracao nova = new Numeracao();
		try {
			nova = repository.save(numeracao);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nova;
	}
	
	public void deletaNumeracao(Integer id) {
		repository.deleteById(id);
	}
}
