package com.consultorio.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.consultorio.util.hibernateUtil;

import org.hibernate.Session;

@SuppressWarnings("unused")
public class GenericDao<Entidade> {

	private Class<Entidade> classe; // CLASSE - MOSTRA QUAL ENTIDADE ESTA FAZENDO A SOLICITAÇÃO DE ENTRADA.

	@SuppressWarnings("unchecked")
	public GenericDao() { // CAPTURA A ENTIDADE QUE SOLICITOU O REGISTRO.
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		// MOSTRA A POSIÇÃO E DA ENTIDADE DO REGISTRO QUE EU QUERO BUSCAR
	}

	public void salvar(Entidade entidade) {

		Session sessao = hibernateUtil.getFabricaSessoes().openSession();

		// forma de assegurar que todas os dados estão integros.
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();// iniciou a transação.

			sessao.save(entidade);

			transacao.commit();

		} catch (RuntimeException erro) {

			if (transacao != null) {

				// Se der algum erro na operação salvar em duas tabelas o RollBack volta tudo no
				// inicio, não permite erros.
				transacao.rollback();

			}
			throw erro; // mostra o erro, avisa os erros superiores que o erro aconteceu - parecido com
						// o "PRINT".

		} finally {
			sessao.close();// encerra a sessao
		}
	}

	@SuppressWarnings("unchecked")
	public List<Entidade> Listar() {
		Session sessao = hibernateUtil.getFabricaSessoes().openSession();

		try {

			Criteria consulta = sessao.createCriteria(classe);

			List<Entidade> resultado = consulta.list();

			return resultado;

		} catch (RuntimeException erro) {

			throw erro;

		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public Entidade buscar(long codigo) { // BUSCAR NO CANCO DE DADOS

		Session sessao = hibernateUtil.getFabricaSessoes().openSession();

		try {
			Criteria consulta = sessao.createCriteria(classe);

			consulta.add(Restrictions.idEq(codigo));

			Entidade resultado = (Entidade) consulta.uniqueResult();

			return resultado;

		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

	public void excluir(Entidade entidade) {

		Session sessao = hibernateUtil.getFabricaSessoes().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();

			sessao.delete(entidade);

			transacao.commit();

		} catch (RuntimeException erro) {

			if (transacao != null) {
				transacao.rollback();
			}
		}
	}

	public void alterar(Entidade entidade) {

		Session sessao = hibernateUtil.getFabricaSessoes().openSession();

		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();

			sessao.update(entidade);

			transacao.commit();

		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;
		} finally {
			sessao.close();
		}
	}
}
