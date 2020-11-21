package com.fiscalizacao.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name="departamento")
public class Departamento  implements Serializable{

	/**
	 * Desenvolvido por Giliardi Bueno
	 */
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
    @ManyToOne
    @JoinColumn(name = "emitente_id")
    private Emitente emitente;
    
    @Column(name = "nome_departamento")
    @NotNull
	private String nomeDepartamento;
    
    @Column(name = "logradouro_departamento")
    @NotNull
	private String logradouroDepartamento;
	
	@Column(name = "numero_departamento")
    @NotNull
	private String numero_departamento;
	
	@Column(name = "complemento_departamento")
	private String complemento_departamento;
	
	@Column(name = "bairro_departamento")
	private String bairro_departamento;
	
	@Column(name = "cep_departamento")
	private String cep_departamento;
	
    @Column(name = "telefone_departamento")
    @NotNull
	private String telefone_departamento;
    
    @Column(name = "email_departamento")
    @NotNull
	private String email_departamento;
    
    @Column(name = "diretor_departamento")
    @NotNull
	private String diretor_departamento;
    
    @OneToMany(mappedBy = "departamento")
    private List<SetorDepartamento> setor;
    
	
}
