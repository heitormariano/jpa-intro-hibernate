package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.modelo.Categoria;

public class CadastroCategoria {

	public static void main(String[] args) {

		CategoriaDAO catDAO = CategoriaDAO.getInstance();

		String strCozinha = "Cozinha";
		Categoria categoria = catDAO.obterByNome(strCozinha);

		if (categoria != null) {
			System.out.println("Categoria " + strCozinha + " já existe");
		} else {
			categoria = new Categoria();
			categoria.setNome(strCozinha);

			catDAO.cadastrar(categoria);
			System.out.println("Categoria " + strCozinha + " cadastrada");
		}
	}

}
