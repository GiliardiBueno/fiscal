package com.fiscalizacao.validate;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiscalizacao.exceptionHandler.EmitenteCadastradoException;
import com.fiscalizacao.models.Emitente;
import com.fiscalizacao.repository.EmitenteRepository;
import com.fiscalizacao.request.EmitenteRequest;

@Component
public class EmitenteValidate {

	@Autowired
	EmitenteRepository emitenteRepository;
	
	public void validateRequest(EmitenteRequest emitenteRequest) throws EmitenteCadastradoException {
		if(emitenteRequest != null) {
	      Optional<Emitente> emitente = emitenteRepository.findbyPessoaId(emitenteRequest.getId());
	      if(emitente.isPresent()) {
	    	  throw new EmitenteCadastradoException();
	      }
		}
	}
}
