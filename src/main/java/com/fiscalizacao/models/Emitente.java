package com.fiscalizacao.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="emitente")
public class Emitente implements Serializable{
   /* Autor: Giliardi Bueno*/

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nome_emitente")
    private String nomeEmitente;
	
	@Column(name = "cnpj_emitente")
    private String cnpjEmitente;
	
	@Column(name = "logradouro_emitente")
    private String logradouroEmitente;
	
	@Column(name = "numero_emitente")
    private String numero_emitente;
	
	@Column(name = "complemento_emitente")
    private String complementoEmitente;
	
	@Column(name = "bairro_emitente")
    private String bairroEmitente;

	@Column(name = "cep_emitente")
    private String cepEmitente;
	
	@Column(name = "telefone_emitente")
    private String telefoneEmitente;
	
	@Column(name = "email_emitente")
    private String emailEmitente;
	
	@Column(name = "logo_emitente")
    private String logoEmitente;
    
    
	
}
