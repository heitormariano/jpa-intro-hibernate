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

		// Obter produto pelo nome
		Produto produtosPorNome = prodDAO.obterByNome("teclado");
		System.out.println("Informações produto - recuperado por nome");
		System.out.println("nome: " + produtosPorNome.getNome());
		System.out.println("descricao: " + produtosPorNome.getDescricao());
		System.out.println("preco: " + produtosPorNome.getPreco());
		System.out.println("categoria: " + produtosPorNome.getCategoria().getNome());

		// Listar por categoria
		List<Produto> produtosPorCategoria = prodDAO.obterByCategoria("Gamer");
		System.out.println("categoria usada na busca: Gamer");
		for (Produto prod : produtosPorCategoria) {
			System.out.println("nome: " + prod.getNome());
			System.out.println("descricao: " + prod.getDescricao());
			System.out.println("preco: " + prod.getPreco());
		}
	}
}
