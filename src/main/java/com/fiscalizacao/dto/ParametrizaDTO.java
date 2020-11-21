package com.fiscalizacao.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fiscalizacao.models.TerrenoSujo;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ParametrizaDTO {
   private int id;
   private BigDecimal valorUfm;
   private BigDecimal valTerreno;
   private BigDecimal precoMQ;
   private Date ano;
   
   public TerrenoSujo transFormaParaObj() {
	   return new TerrenoSujo(id, valorUfm, valTerreno, precoMQ, ano);
   }
}
