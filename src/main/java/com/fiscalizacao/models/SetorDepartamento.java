package com.fiscalizacao.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class SetorDepartamento implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id ;
   
   @ManyToOne
   @JsonBackReference
   @JoinColumn(name = "departamento_id")
   private Departamento departamento;
   
   @Column(name = "nome_setor")
   private String nomeSetor ;
   
   @Column(name = "logradouro_setor")
   private String logradouroSetor;
   
   @Column(name = "numero_setor")
   private String numeroSetor;
   
   @Column(name = "complemento_setor")
   private String complementoSetor;
   
   @Column(name = "bairro_setor")
   private String bairroSetor;
   
   @Column(name = "cep_setor")
   private String cepSetor;
   
   @Column(name = "telefone_setor")
   private String telefoneSetor;
   
   @Column(name = "email_setor")
   private String emailSetor;
   
   @Column(name = "responsavel_setor")
   private String responsavelSetor;
}
