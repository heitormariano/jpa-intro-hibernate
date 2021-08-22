package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JpaUtil;

public class ProdutoDAO {

	private EntityManager em;
	private static ProdutoDAO instance;

	public ProdutoDAO() {
		super();
		this.em = JpaUtil.getEntityManager();
	}

	public static ProdutoDAO getInstance() {
		if (instance == null) {
			instance = new ProdutoDAO();
		}
		return instance;
	}

	public void cadastrar(Produto produto) {
		try {
			this.em.getTransaction().begin();
			this.em.persist(produto);
			this.em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
		}

	}

	public void atualizar(Produto produto) {
		try {
			this.em.getTransaction().begin();
			this.em.merge(produto);
			this.em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
		}

	}

	public void remover(Produto produto) {
		try {
			this.em.getTransaction().begin();
			Produto prodExcluir = this.obterById(produto.getId());
			this.em.remove(prodExcluir);
			this.em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
		}

	}

	public void removerById(final Long id) {
		try {

			Produto prodExcluir = this.obterById(id);
			this.em.remove(prodExcluir);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Produto obterById(final Long id) {
		return this.em.find(Produto.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Produto> obterByNome(String nome) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT prod FROM Produto prod ");
		sql.append("WHERE prod.nome = :nome");

		Query query = this.em.createQuery(sql.toString(), Produto.class);
		query.setParameter("nome", nome);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Produto> obterByCategoria(String nome) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT prod FROM Produto prod ");
		sql.append("WHERE prod.categoria.nome = :nome");

		Query query = this.em.createQuery(sql.toString(), Produto.class);
		query.setParameter("nome", nome);

		return query.getResultList();
	}

	public BigDecimal obterPrecoByNome(String nome) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT prod.preco FROM Produto prod ");
		sql.append("WHERE prod.nome = :nome");

		Query query = this.em.createQuery(sql.toString(), BigDecimal.class);
		query.setParameter("nome", nome);

		return (BigDecimal) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Produto> buscarTodos() {
		Query query = this.em.createQuery("FROM " + Produto.class.getName());
		return query.getResultList();
	}

}
