package br.com.alura.loja.testes;

import java.math.BigDecimal;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;

public class CadastroProd {

	public static void main(String[] args) {
		CategoriaDAO catDAO = CategoriaDAO.getInstance();

		String strGamer = "Gamer";
		Categoria gamer = catDAO.obterByNome("Gamer");

		// verifica��o: categoria Gamer
		if (gamer != null) {
			System.out.println("Cagatoria " + strGamer + " j� existe");
		} else {
			gamer = new Categoria("Gamer");
			catDAO.cadastrar(gamer);
		}

		// verifica��o: produto Mouse
		ProdutoDAO prodDAO = ProdutoDAO.getInstance();

		String strMouse = "Mouse";
		Produto mouse = prodDAO.obterByNome(strMouse);

		if (mouse != null) {
			System.out.println("Produto " + strMouse + " j� existe");
		} else {
			mouse = new Produto(strMouse, "Mouse com alta precis�o", new BigDecimal("210"), gamer);
			prodDAO.cadastrar(mouse);
		}

		// verifica��o: categoria Sala/Jantar
		String strSalaJantar = "Sala/Jantar";
		Categoria salaJantar = catDAO.obterByNome(strSalaJantar);

		if (salaJantar != null) {
			System.out.println("Categoria " + strSalaJantar + " j� existe");
		} else {
			salaJantar = new Categoria(strSalaJantar);
			catDAO.cadastrar(salaJantar);
		}

		// verifica��o: produto Fogao
		String strFogao = "Fogao";
		Produto fogao = prodDAO.obterByNome(strFogao);

		if (fogao != null) {
			System.out.println("Produto " + strFogao + " j� existe");
		} else {
			fogao = new Produto("Fogao", "Fog�o 4 bocas", new BigDecimal("700"), salaJantar);
			prodDAO.cadastrar(fogao);
		}
	}
}
