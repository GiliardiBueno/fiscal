package com.fiscalizacao.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name="tipo_notificacao")
public class TipoNotificacao implements Serializable {

	/**
	 * DESENVOLVIDO POR GILIARDI BUENO
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nome")
	@NotNull
	private String nome;
	
	@Column(name = "textopadrao")
	@NotNull
	private String textopadrao;
	
	@Column(name = "prazo")
	@NotNull
	private int prazo;
	
	@ManyToOne
	@JoinColumn(name = "setor_id")
	private SetorDepartamento setor;

}
