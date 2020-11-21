package com.fiscalizacao.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImovelDTO {

	   private int id;
	   private String nome_contribuinte;
	   private String cpf_contribuinte;
	   private String logradouro_imovel;
	   private String numero_imovel;
	   private String complemento_imovel;
	   private String cep_imovel;
	   private String bairro_imovel;
	   private String setor ;
	   private String quadra;
	   private String lote;
	   private String logradouro_contribuinte;
	   private String numero_contribuinte;
	   private String complemento_contribuinte;
	   private String bairro_contribuinte;
	   private String cep_contribuinte;
	   private String cidade_contribuinte;
	   private String valor_venal_edificacao;
	   private String valor_venal_terreno;
	   private String valor_venal_imovel;
	   private String total_area_edificada;
	   private String area_terreno;
	
}
