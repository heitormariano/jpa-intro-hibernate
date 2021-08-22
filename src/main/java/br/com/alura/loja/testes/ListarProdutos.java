package br.com.alura.loja.testes;

import java.util.List;

import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Produto;

public class ListarProdutos {

	public static void main(String[] args) {
		ProdutoDAO prodDAO = ProdutoDAO.getInstance();
		List<Produto> listaProdutos = prodDAO.buscarTodos();

		// Listar todos os produtos
		for (Produto prod : listaProdutos) {
			System.out.println("nome: " + prod.getNome());
			System.out.println("descricao: " + prod.getDescricao());
			System.out.println("preco: " + prod.getPreco());
			System.out.println("categoria: " + prod.getCategoria().getNome());
		}

		// Listar por nome
		List<Produto> produtosPorNome = prodDAO.obterByNome("teclado");
		for (Produto prod : produtosPorNome) {
			System.out.println("nome: " + prod.getNome());
			System.out.println("descricao: " + prod.getDescricao());
			System.out.println("preco: " + prod.getPreco());
			System.out.println("categoria: " + prod.getCategoria().getNome());
		}
		
		// Listar por categoria
		List<Produto> produtosPorCategoria = prodDAO.obterByCategoria("Gamer");
		System.out.println("categoria filtro: Gamer");
		for (Produto prod : produtosPorCategoria) {
			System.out.println("nome: " + prod.getNome());
			System.out.println("descricao: " + prod.getDescricao());
			System.out.println("preco: " + prod.getPreco());
		}
	}
}
