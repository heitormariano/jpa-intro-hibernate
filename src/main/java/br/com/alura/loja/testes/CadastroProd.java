package br.com.alura.loja.testes;

import java.math.BigDecimal;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;

public class CadastroProd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Categoria gamer = new Categoria("Gamer");
		Produto mouse = new Produto("Mouse", "Mouse com alta precisão", new BigDecimal("210"), gamer);

		CategoriaDAO catDAO = CategoriaDAO.getInstance();
		catDAO.cadastrar(gamer);

		ProdutoDAO prodDAO = ProdutoDAO.getInstance();
		prodDAO.cadastrar(mouse);

	}
}
