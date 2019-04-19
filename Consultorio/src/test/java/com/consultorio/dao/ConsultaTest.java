package com.consultorio.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.domain.Consulta;
import com.domain.Medico;
import com.domain.Paciente;

public class ConsultaTest {

	public class ConsultaDaoTest {
		
		@Ignore
		@Test
		public void salvar() throws ParseException {

			Consulta consulta = new Consulta();
			
			
			// instanciar medico que vai consultar
			MedicoDao medicodao = new MedicoDao();
			Medico medico = medicodao.buscar(1L);
			
			
			// instanciar paciente 
			PacienteDao pacientedao = new PacienteDao();
			Paciente paciente = pacientedao.buscar(1L);
			
			
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			Date data = formato.parse("20/11/2016");
			paciente.setNascimento(data);
			
			
			// Preenchimento do campo respectivo à tabala 'consulta'
			consulta.setCodConsulta(1);
			consulta.setData(data);
			consulta.setMedico(medico);
			consulta.setPaciente(paciente);
			consulta.setSintomas("coceira na barriga");
			
			// Realização de inserção no banco de dados.
			ConsultaDao consultadao = new ConsultaDao();
			
			
			int i = 1;
			while (i <= 5) {
				consultadao.salvar(consulta);
				i++;
			}

			// Mensagem de sucesso
			System.out.println("Exito no cadastro da consulta");

		}
		
		@Ignore
		@Test
		public void Listar() {
			
			ConsultaDao consultadao = new ConsultaDao();
			
			List<Consulta> resultado = consultadao.Listar();

			System.out.println("total de registro:" + resultado.size());

			for (Consulta consulta: resultado) {

				System.out.println("Código consulta: "+ consulta.getCodConsulta() + "\n Data: "+ consulta.getData());
			}
		}
		
		@Ignore
		@Test
		public void buscar() {

			long codigo = 2L;

			ConsultaDao consultadao = new ConsultaDao();
			Consulta consulta = consultadao.buscar(codigo);
			

			if (consulta == null) {
				System.out.println("Nenhum Registro ENcontrado");

			} else {

				System.out.println("Registro encontrado");
				System.out.println(consulta.getSintomas());
			}
		}
		
		
		@Test
		public void altera() {

			long codigo = 3L;
			
			ConsultaDao consultadao = new ConsultaDao();
			Consulta consulta = consultadao.buscar(codigo);

			if (consulta == null) {

				System.out.println("nenhum registro encontrado");

			} else {

				consulta.setSintomas("Dor no olho teste alteração");
				consultadao.alterar(consulta);

				System.out.println("Registro Editado");
				System.out.println(consulta.getSintomas());
			}
		}
	}
}
