package br.com.alura.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JpaUtil;

public class CategoriaDAO {

	private EntityManager em;
	private static CategoriaDAO instance;

	public CategoriaDAO() {
		super();
		this.em = JpaUtil.getEntityManager();
	}

	public static CategoriaDAO getInstance() {
		if (instance == null) {
			instance = new CategoriaDAO();
		}
		return instance;
	}

	public void cadastrar(Categoria categoria) {
		try {
			this.em.getTransaction().begin();
			this.em.persist(categoria);
			this.em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
		}

	}

	public void atualizar(Categoria categoria) {
		try {
			this.em.getTransaction().begin();
			this.em.merge(categoria);
			this.em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
		}

	}

	public void remover(Categoria categoria) {
		try {
			this.em.getTransaction().begin();
			Categoria catExcluir = this.obterById(categoria.getId());
			this.em.remove(catExcluir);
			this.em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
		}

	}

	public void removerById(final Long id) {
		try {
			Categoria categoriaExcluir = this.obterById(id);
			this.em.remove(categoriaExcluir);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Categoria obterById(final Long id) {
		return this.em.find(Categoria.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Categoria> obterByNome(String nome) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT cat FROM Categoria cat ");
		sql.append("WHERE cat.nome = :nome");

		Query query = this.em.createQuery(sql.toString(), Categoria.class);
		query.setParameter("nome", nome);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Categoria> buscarTodos() {
		Query query = this.em.createQuery("FROM " + Categoria.class.getName());
		return query.getResultList();
	}

}
