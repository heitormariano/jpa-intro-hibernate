package br.com.alura.loja.testes;

import java.math.BigDecimal;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;

public class CadastroProdCatExistente {

	public static void main(String[] args) {
		Categoria gamer = CategoriaDAO.getInstance().obterByNome("Gamer");

		Produto notebookGamer = new Produto("Notebook Gamer", "Notebook Gamer XYZ", new BigDecimal("3450"), gamer);
		ProdutoDAO.getInstance().cadastrar(notebookGamer);
	}
}
