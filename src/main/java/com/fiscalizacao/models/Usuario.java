package com.fiscalizacao.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario implements UserDetails {

	/**
	 * Autor: Giliardi de souza Bueno
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nome")
	@NotNull
	private String nome;

	@Column(name = "cpf")
	@NotNull
	private String cpf;

	@Column(name = "matricula")
	@NotNull
	private String matricula;

	@Column(name = "foto")
	private String foto;

	@Column(name = "celular")
	private String celular;

	@Column(name = "login")
	@NotNull
	private String login;

	@Column(name = "senha")
	@NotNull
	private String senha;

	@Column(name = "status")
	private int status;

	@ManyToOne
	@JoinColumn(name = "tipouser")
	public TipoUsuario tipouser;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			  name = "usuario_perfil", 
			  joinColumns = @JoinColumn(name = "usuario_id"), 
			  inverseJoinColumns = @JoinColumn(name = "perfil_id"))
	private List<Perfil> perfis = new ArrayList<>();
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
	}

	@Override
	public String getPassword() {

		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
