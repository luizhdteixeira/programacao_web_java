package com.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Medico extends GenericDomain{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codMedico;
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	@Column(length = 50, nullable = false)
	private String especialidade;
	
	@Column(length = 10, nullable = false)
	private String CRM;
	
	@Column(length = 20)
	private String telefone;
	
	@Column(length = 100)
	private String endereco;

	public int getCodMedico() {
		return codMedico;
	}

	public void setCodMedico(int codMedico) {
		this.codMedico = codMedico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getCRM() {
		return CRM;
	}

	public void setCRM(String cRM) {
		CRM = cRM;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	
	
}
