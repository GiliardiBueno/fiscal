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
@Table(name="imovel")
public class Imovel implements Serializable {

   /**
	 * DESENVOLVIDO POR GILIARDI BUENO
	 */
	private static final long serialVersionUID = 1L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Column(name = "nome_contribuinte")
   private String nomeContribuinte;
   
   @Column(name = "cpf_contribuinte")
   private String cpfContribuinte;
   
   @Column(name = "logradouro_imovel")
   private String logradouroImovel;
   
   @Column(name = "numero_imovel")
   private String numeroImovel;
   
   @Column(name = "complemento_imovel")
   private String complementoImovel;
   
   @Column(name = "cep_imovel")
   private String cepImovel;
   
   @Column(name = "bairro_imovel")
   private String bairroImovel;
   
   @Column(name = "setor")
   private String setor ;
   
   @Column(name = "quadra")
   private String quadra;
   
   @Column(name = "lote")
   private String lote;
   
   @Column(name = "logradouro_contribuinte")
   private String logradouroContribuinte;
   
   @Column(name = "numero_contribuinte")
   private String numeroContribuinte;
   
   @Column(name = "complemento_contribuinte")
   private String complementoContribuinte;
   
   @Column(name = "bairro_contribuinte")
   private String bairroContribuinte;
   
   @Column(name = "cep_contribuinte")
   private String cepContribuinte;
   
   @Column(name = "cidade_contribuinte")
   private String cidadeContribuinte;
   
   @Column(name = "valor_venal_edificacao")
   private String valorVenalEdificacao;
   
   @Column(name = "valor_venal_terreno")
   private String valorVenalTerreno;
   
   @Column(name = "valor_venal_imovel")
   private String valorVenalImovel;
   
   @Column(name = "total_area_edificada")
   private String totalAreaEdificada;
   
   
   @Column(name = "area_terreno")
   private String areaTerreno;
  
}
