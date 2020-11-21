package com.fiscalizacao.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "notificacao")
public class Notifica implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "fiscal_id")
    private Usuario fiscal;
    
	@ManyToOne
	@JoinColumn(name = "tpnotificacao_id")
	private TipoNotificacao tipoNotificacao;
	
	@ManyToOne
	@JoinColumn(name = "imovel_id")
	private Imovel imovel;

	
	@Column(name = "data_hora_emissao")
	private Date dataHora;

	@Column(name="observacao")
	private String observacao;
    
    @Column(name="vencimento")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date vencimento;
    
    @Column(name="nome_notificado")
    private String nomeNotificado;
    
    @Column(name="cpf_notificado")
    private String cpfNotificado;
    
    @Column(name="assinou")
    private String assinou;
    
    @Column(name="foto_notificacao")
    private String fotoNotificacao;
    
    @Column(name="status")
    private String status;

}
