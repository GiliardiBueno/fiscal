package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.models.TerrenoSujo;
import com.fiscalizacao.repository.ParametrizaRepository;

@Service
public class ParametrizaService {

	@Autowired
	ParametrizaRepository parametrizaRepository;
	
	public TerrenoSujo findById(Integer id) {
		TerrenoSujo parametriza  = new TerrenoSujo();
		try {
			parametriza = parametrizaRepository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parametriza;
	}
	public TerrenoSujo SalvaParametriza(TerrenoSujo parametriza) {
		 TerrenoSujo novoParametriza = new TerrenoSujo();
		 try {
			novoParametriza = parametrizaRepository.save(parametriza);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return novoParametriza;
	}
	public void deletaParametriza(Integer id) {
		 parametrizaRepository.deleteById(id);
	}
}
