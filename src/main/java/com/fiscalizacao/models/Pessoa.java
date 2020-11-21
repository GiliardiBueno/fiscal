package com.fiscalizacao.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "pessoa")
public class Pessoa implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    
	    @Column(name = "nome_razao_social")
	    public String nome;
	    
	    @Column(name = "rg_ie")
	    public String rg;
	    
	    @Column(name = "cpf_cnpj")
	    public String cpf;
	    
	    @Column(name = "logradouro")
	    public String logradouro;
	    
	    @Column(name = "numero")
	    public String numero;
	    
	    @Column(name = "complemento")
	    public String complemento;
	    
	    @Column(name = "cep")
	    public String cep;
	    
	    @Column(name = "bairro")
	    public String bairro;
	    
	    @Column(name = "cidade")
	    public String cidade;
	    
	    @Column(name = "telefone")
	    public String telefone;
	    
	    @Column(name = "email")
	    public String email;
	    
	    @Column(name = "telefone_recado")
	    public String telefoneRecado;
	    
	    @Column(name = "responsavel_recado")
	    public String responsavelRecado;

}
