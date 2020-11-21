package com.fiscalizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscalizacao.models.Imovel;
import com.fiscalizacao.repository.ImovelRepository;

@Service
public class ImovelService {
	 
		@Autowired
		ImovelRepository imovelRepository;
		
		public Imovel findById(Integer id) {
			Imovel imovel = new Imovel();
			try {
				imovel = imovelRepository.findById(id).orElse(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return imovel;
		}
		
		public Imovel SalvaImovel(Imovel imovel) {
			Imovel novoImovel = new Imovel();
		   try {
			   novoImovel = imovelRepository.save(imovel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		   return novoImovel;
		}
		
		public void deletaImovel(Integer id) {
			imovelRepository.deleteById(id);
			
		}
		
}
