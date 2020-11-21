package com.fiscalizacao.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="terrenoSujo")
@NoArgsConstructor
public class TerrenoSujo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
	
	   @Column(name="valor_ufm")
	   public BigDecimal valorUfm;
	   
	   @Column(name="valor_terreno")
	   public BigDecimal valTerreno;
	   
	   @Column(name="preco_metro_quadrado")
	   public BigDecimal precoMQ;
	   
	   @Column(name = "ano_vigente")
	   @DateTimeFormat(pattern = "dd/MM/yyyy")
	   public Date ano;
	   
	   public TerrenoSujo(int id, BigDecimal valorUfm, BigDecimal valTerreno, BigDecimal precoMQ, Date ano ) {
		   this.id = id;
		   this.valorUfm = valorUfm;
		   this.valTerreno = valTerreno;
		   this.precoMQ = precoMQ;
		   this.ano = ano;
	   }
	
}
