package br.com.alura.loja.testes;

import java.util.List;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;

public class ListarCategorias {

	public static void main(String[] args) {
		CategoriaDAO catDAO = CategoriaDAO.getInstance();
		List<Categoria> categorias = catDAO.buscarTodos();

		for (Categoria cat : categorias) {
			System.out.println("Nome: " + cat.getNome());
			System.out.println("ID do banco: " + cat.getId());
		}

		List<Categoria> categoriasPorNome = catDAO.obterByNome("Gamer");
		for (Categoria cat : categoriasPorNome) {
			System.out.println("Nome: " + cat.getNome());
			System.out.println("ID do banco: " + cat.getId());
		}
	}
}
