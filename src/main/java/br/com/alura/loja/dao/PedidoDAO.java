package br.com.alura.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.util.JpaUtil;

public class PedidoDAO {

	private EntityManager em;
	private static PedidoDAO instance;

	public PedidoDAO() {
		super();
		this.em = JpaUtil.getEntityManager();
	}

	public static PedidoDAO getInstance() {
		if (instance == null) {
			instance = new PedidoDAO();
		}
		return instance;
	}

	public void cadastrar(Pedido pedido) {
		try {
			// definindo valor total do pedido
			pedido.definirValorTotal();
			this.em.getTransaction().begin();
			this.em.persist(pedido);
			this.em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
		}

	}

	public void atualizar(Pedido pedido) {
		try {
			this.em.getTransaction().begin();
			this.em.merge(pedido);
			this.em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
		}

	}

	public void remover(Pedido pedido) {
		try {
			this.em.getTransaction().begin();
			Pedido pedidoExcluir = this.obterById(pedido.getId());
			this.em.remove(pedidoExcluir);
			this.em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
		}

	}

	public void removerById(final Long id) {
		try {

			Pedido pedidoExcluir = this.obterById(id);
			this.em.remove(pedidoExcluir);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Pedido obterById(final Long id) {
		return this.em.find(Pedido.class, id);
	}

	public Pedido obterByCliente(String nomeCliente) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ped FROM Pedido ped ");
		sql.append("WHERE ped.cliente.nome = :nome");

		Query query = this.em.createQuery(sql.toString(), Pedido.class);
		query.setParameter("nome", nomeCliente);

		return (Pedido) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Pedido> buscarTodos() {
		Query query = this.em.createQuery("FROM " + Pedido.class.getName());
		return query.getResultList();
	}

}
