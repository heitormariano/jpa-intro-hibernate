package br.com.alura.loja.testes;

import java.math.BigDecimal;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;

public class AtualizaProduto {

	public static void main(String[] args) {
		// atualizar descrição de produto (id 1)
		ProdutoDAO prodDAO = ProdutoDAO.getInstance();
		Produto prodEncontrado = prodDAO.obterById(1L);
		prodEncontrado.setDescricao("Teclado com multiplas funções");
		prodEncontrado.setPreco(new BigDecimal("450"));
		prodDAO.atualizar(prodEncontrado);

		// atualizar descrição categoria (id 1)
		CategoriaDAO catDAO = CategoriaDAO.getInstance();
		Categoria catEncontrada = catDAO.obterById(1L);
		catEncontrada.setNome("Musica");
		catDAO.atualizar(catEncontrada);
	}
}
