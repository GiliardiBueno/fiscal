package com.fiscalizacao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Carro {
	
	String marca;
	String modelo;
	Integer ano;

}
