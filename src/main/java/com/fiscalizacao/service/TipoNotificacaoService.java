package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.models.TipoNotificacao;
import com.fiscalizacao.repository.TipoNotificacaoRepository;

@Service
public class TipoNotificacaoService {

	@Autowired
	TipoNotificacaoRepository repository;
	
	public TipoNotificacao findById(Integer id) {
		TipoNotificacao tipoNotificacao =  new TipoNotificacao();
		try {
			tipoNotificacao = repository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipoNotificacao;
	}
	public TipoNotificacao  salvaTipoNotificacao(TipoNotificacao tipoNotificacao) {
		TipoNotificacao novoTipoNotificacao = new TipoNotificacao();
		try {
			novoTipoNotificacao = repository.save(tipoNotificacao);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return novoTipoNotificacao;
		
	}
	public void deletaTipoNotificacao(Integer id) {
		repository.deleteById(id);
	}
}
