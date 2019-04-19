package com.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Consulta extends GenericDomain{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codConsulta;
	
	@Column(nullable = false)
	private Date data;
	
	@Column(length = 150,nullable = false)
	private String sintomas;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Paciente paciente;

	public int getCodConsulta() {
		return codConsulta;
	}

	public void setCodConsulta(int codConsulta) {
		this.codConsulta = codConsulta;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
}
