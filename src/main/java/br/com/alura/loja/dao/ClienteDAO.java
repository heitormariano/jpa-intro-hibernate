package br.com.alura.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.util.JpaUtil;

public class ClienteDAO {

	private EntityManager em;
	private static ClienteDAO instance;

	public ClienteDAO() {
		super();
		this.em = JpaUtil.getEntityManager();
	}

	public static ClienteDAO getInstance() {
		if (instance == null) {
			instance = new ClienteDAO();
		}
		return instance;
	}

	public void cadastrar(Cliente cliente) {
		try {
			this.em.getTransaction().begin();
			this.em.persist(cliente);
			this.em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
		}

	}

	public void atualizar(Cliente cliente) {
		try {
			this.em.getTransaction().begin();
			this.em.merge(cliente);
			this.em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
		}

	}

	public void remover(Cliente cliente) {
		try {
			this.em.getTransaction().begin();
			Cliente clienteEcluir = this.obterById(cliente.getId());
			this.em.remove(clienteEcluir);
			this.em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
		}

	}

	public void removerById(final Long id) {
		try {

			Cliente clienteExcluir = this.obterById(id);
			this.em.remove(clienteExcluir);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Cliente obterById(final Long id) {
		return this.em.find(Cliente.class, id);
	}

	public Cliente obterByNome(String nome) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT cli FROM Cliente cli ");
		sql.append("WHERE cli.nome = :nome");

		Query query = this.em.createQuery(sql.toString(), Cliente.class);
		query.setParameter("nome", nome);

		return (Cliente) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> buscarTodos() {
		Query query = this.em.createQuery("FROM " + Cliente.class.getName());
		return query.getResultList();
	}

}
