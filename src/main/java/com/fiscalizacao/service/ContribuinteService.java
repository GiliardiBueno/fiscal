package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.models.Contribuinte;
import com.fiscalizacao.repository.ContribuinteRepository;

@Service
public class ContribuinteService {

	@Autowired
	ContribuinteRepository contribuinteRepository;
	
	public Contribuinte findById(Integer id) {
		Contribuinte contribuinte = new Contribuinte();
		try {
			contribuinte = contribuinteRepository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contribuinte;
	}
	
	public Contribuinte salvaContribuinte(Contribuinte contribuinte){
		Contribuinte novoContribuinte = new Contribuinte();
		try {
				novoContribuinte = contribuinteRepository.save(contribuinte);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		return novoContribuinte;
		}
	
	
	public void deletaContribuinte(Integer id) {
		contribuinteRepository.deleteById(id);
		
	}

	
}
