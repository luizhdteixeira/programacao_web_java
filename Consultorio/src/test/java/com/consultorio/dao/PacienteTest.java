package com.consultorio.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.domain.Paciente;

public class PacienteTest {

	@Ignore
	@Test
	public void salvar() throws ParseException {

		// new paciente
		Paciente paciente = new Paciente();

		// Preenchimento do campo respectivo à tabala 'pacientes'
		paciente.setCodPaciente(1);
		paciente.setCPF("45454545");
		paciente.setEndereco("Rua Aleluia");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = formato.parse("20/11/2005");
		paciente.setNascimento(data);
		paciente.setNome("Madagascarla");

		// Realização de inserção no banco de dados.
		PacienteDao pacientedao = new PacienteDao();
		pacientedao.salvar(paciente);

		int i = 1;
		while (i <= 5) {
			pacientedao.salvar(paciente);
			i++;
		}

		// Mensagem de sucesso
		System.out.println("Exito no cadastro do medico");
	}

	@Ignore
	@Test
	public void listar() {

		PacienteDao pacientedao = new PacienteDao();

		List<Paciente> resultado = pacientedao.Listar();

		System.out.println("total de registro:" + resultado.size());

		for (Paciente paciente : resultado) {

			System.out.println(paciente.getNome());
		}
	}

	@Ignore
	@Test
	public void buscar() {

		long codigo = 2L;
		PacienteDao pacientedao = new PacienteDao();
		Paciente paciente = pacientedao.buscar(codigo);

		if (paciente == null) {
			System.out.println("Nenhum Registro ENcontrado");

		} else {

			System.out.println("Registro encontrado");
			System.out.println(paciente.getNome());
		}
	}

	@Ignore
	@Test
	public void alterar() {

		long codigo = 3L;
		PacienteDao pacientedao = new PacienteDao();
		Paciente paciente = pacientedao.buscar(codigo);
		
		if (paciente == null) {

			System.out.println("nenhum registro encontrado");

		} else {

			paciente.setNome("Madagascarla Teste Alterado");
			pacientedao.alterar(paciente);

			System.out.println("Registro Editado");
			System.out.println(paciente.getNome());
		}
	}
}
