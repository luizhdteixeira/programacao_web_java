package com.consultorio.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.domain.Medico;

public class MedicosTest {

	@Ignore
	@Test
	public void salvar() {

		
		// new medico
		Medico medico = new Medico();

		// Preenchimento do campo respectivo à tabala 'fornecedor'
		medico.setNome("Luis Felipe");
		medico.setCodMedico(1);
		medico.setCRM("123456");
		medico.setEndereco("Rua abc");
		medico.setTelefone("9987348");
		medico.setEspecialidade("Ginecologista");
		
		
		// Realização de inserção no banco de dados.
		MedicoDao medicodao = new MedicoDao();
		medicodao.salvar(medico);
		
		
		// new medico 2
		Medico medico2 = new Medico();
		
		// Preenchimento do campo respectivo à tabala 'fornecedor'
		medico2.setNome("Luis Felipe");
		medico2.setCodMedico(1);
		medico2.setCRM("123456");
		medico2.setEndereco("Rua abc");
		medico2.setTelefone("9987348");
		medico2.setEspecialidade("Ginecologista");
		
		
		// Realização de inserção no banco de dados.
		MedicoDao medicodao2 = new MedicoDao();
		medicodao2.salvar(medico2);
		
		
		
		// new medico 3
		Medico medico3 = new Medico();
		
		// Preenchimento do campo respectivo à tabala 'fornecedor'
		medico3.setNome("Luis Felipe");
		medico3.setCodMedico(1);
		medico3.setCRM("123456");
		medico3.setEndereco("Rua abc");
		medico3.setTelefone("9987348");
		medico3.setEspecialidade("Ginecologista");
		
		
		// Realização de inserção no banco de dados.
		MedicoDao medicodao3 = new MedicoDao();
		medicodao3.salvar(medico3);
		
		// new medico 4
		Medico medico4 = new Medico();
		
		// Preenchimento do campo respectivo à tabala 'fornecedor'
		medico4.setNome("Luis Felipe");
		medico4.setCodMedico(1);
		medico4.setCRM("123456");
		medico4.setEndereco("Rua abc");
		medico4.setTelefone("9987348");
		medico4.setEspecialidade("Ginecologista");
		
		
		// Realização de inserção no banco de dados.
		MedicoDao medicodao4 = new MedicoDao();
		medicodao4.salvar(medico4);
		
		
		// new medico 5
		Medico medico5 = new Medico();
		
		// Preenchimento do campo respectivo à tabala 'fornecedor'
		medico5.setNome("Luis Felipe");
		medico5.setCodMedico(1);
		medico5.setCRM("123456");
		medico5.setEndereco("Rua abc");
		medico5.setTelefone("9987348");
		medico5.setEspecialidade("Ginecologista");
		
		
		// Realização de inserção no banco de dados.
		MedicoDao medicodao5 = new MedicoDao();
		medicodao5.salvar(medico5);
		

		// Mensagem de sucesso
		System.out.println("Exito no cadastro do medico");

	}
	
	
	@Ignore
	@Test
	public void listar() {
		
		MedicoDao medicodao = new MedicoDao();

		List<Medico> resultado = medicodao.Listar();

		System.out.println("total de registro:" + resultado.size());

		for (Medico medico : resultado) {

			System.out.println(medico.getNome());
		}
	}
	
	
	@Ignore
	@Test
	public void buscar() {

		long codigo = 2L;

		MedicoDao medicodao = new MedicoDao();
		Medico medico = medicodao.buscar(codigo);

		if (medico == null) {
			System.out.println("Nenhum Registro ENcontrado");

		} else {

			System.out.println("Registro encontrado");
			System.out.println(medico.getNome());
		}
	}

	@Ignore
	@Test
	public void alterar() {

		long codigo = 3L;

		MedicoDao medicodao = new MedicoDao();
		Medico medico = medicodao.buscar(codigo);

		if (medico == null) {

			System.out.println("nenhum registro encontrado");

		} else {

			medico.setNome("Nome Teste Alterado");
			medicodao.alterar(medico);

			System.out.println("Registro Editado");
			System.out.println(medico.getNome());
		}
	}
	
}
