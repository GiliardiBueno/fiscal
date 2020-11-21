package com.fiscalizacao.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="usuario_perfil")
public class UsuarioPerfil implements Serializable{

	/**
	 * DESENVOLVIDO POR GILIARDI BUENO
	 */
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 
	 @ManyToOne
	 @JoinColumn(name = "usuario_id")
	 public Usuario usuario_id;
	 
	 @ManyToOne
	 @JoinColumn(name="perfil_id")
	 public Perfil perfil_id;

	 
   
}
