package br.com.alura.loja.testes;

import java.math.BigDecimal;

import br.com.alura.loja.dao.ProdutoDAO;

public class RecuperarDadosProd {

	public static void main(String[] args) {
		// recuperar pre�o, informando nome do produto
		ProdutoDAO prodDAO = ProdutoDAO.getInstance();
		BigDecimal precoProduto = prodDAO.obterPrecoByNome("teclado");
		
		System.out.println("Preco do produto: " + precoProduto);
	}
}
