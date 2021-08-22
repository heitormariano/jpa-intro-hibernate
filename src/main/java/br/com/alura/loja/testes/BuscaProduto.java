package br.com.alura.loja.testes;

import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Produto;

public class BuscaProduto {

	public static void main(String[] args) {
		ProdutoDAO prodDAO = ProdutoDAO.getInstance();
		Produto produtoEncontrado = prodDAO.obterById(1L);
		System.out.println("Dados Produto");
		System.out.println("Nome: " + produtoEncontrado.getNome());
		System.out.println("Descrição: " + produtoEncontrado.getDescricao());
		System.out.println("Categoria: " + produtoEncontrado.getCategoria().getNome());
	}
}
