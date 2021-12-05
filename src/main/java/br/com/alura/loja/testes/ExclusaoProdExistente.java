package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;

public class ExclusaoProdExistente {

	public static void main(String[] args) {
		Categoria categoria = new Categoria();
		categoria.setNome("Sala/Jantar");

		Produto prodCadeira = new Produto();
		prodCadeira.setNome("Cadeira");
		prodCadeira.setDescricao("Cadeira de Jantar");
		prodCadeira.setCategoria(categoria);
		prodCadeira.setPreco(new BigDecimal("520"));

		CategoriaDAO catDAO = CategoriaDAO.getInstance();
		catDAO.cadastrar(categoria);

		ProdutoDAO prodDAO = ProdutoDAO.getInstance();
		prodDAO.cadastrar(prodCadeira);

		// recuperar produto para teste de exclusão
		Produto prodRecuperado = prodDAO.obterById(3L);
		if (prodRecuperado != null) {
			System.out.println("Produto antes da exclusão");
			System.out.println(prodRecuperado.getNome());
			System.out.println(prodRecuperado.getDescricao());
			prodDAO.remover(prodRecuperado);
		}
	}
}
