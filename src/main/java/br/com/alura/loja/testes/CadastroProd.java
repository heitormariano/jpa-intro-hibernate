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

		// verificação: categoria Gamer
		if (gamer != null) {
			System.out.println("Cagatoria " + strGamer + " já existe");
		} else {
			gamer = new Categoria("Gamer");
			catDAO.cadastrar(gamer);
		}

		// verificação: produto Mouse
		ProdutoDAO prodDAO = ProdutoDAO.getInstance();

		String strMouse = "Mouse";
		Produto mouse = prodDAO.obterByNome(strMouse);

		if (mouse != null) {
			System.out.println("Produto " + strMouse + " já existe");
		} else {
			mouse = new Produto(strMouse, "Mouse com alta precisão", new BigDecimal("210"), gamer);
			prodDAO.cadastrar(mouse);
		}

		// verificação: categoria Sala/Jantar
		String strSalaJantar = "Sala/Jantar";
		Categoria salaJantar = catDAO.obterByNome(strSalaJantar);

		if (salaJantar != null) {
			System.out.println("Categoria " + strSalaJantar + " já existe");
		} else {
			salaJantar = new Categoria(strSalaJantar);
			catDAO.cadastrar(salaJantar);
		}

		// verificação: produto Fogao
		String strFogao = "Fogao";
		Produto fogao = prodDAO.obterByNome(strFogao);

		if (fogao != null) {
			System.out.println("Produto " + strFogao + " já existe");
		} else {
			fogao = new Produto("Fogao", "Fogão 4 bocas", new BigDecimal("700"), salaJantar);
			prodDAO.cadastrar(fogao);
		}
	}
}
