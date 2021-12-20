package br.com.alura.loja.testes;

import br.com.alura.loja.dao.ClienteDAO;
import br.com.alura.loja.modelo.Cliente;

public class CadastroCliente {

	public static void main(String[] args) {
		ClienteDAO clienteDAO = ClienteDAO.getInstance();

		Cliente maria = new Cliente("Maria", "123.456.789-88");
		Cliente joao = new Cliente("João", "455.665.332-89");
		Cliente felipe = new Cliente("Felipe", "582.963.456-99");

		clienteDAO.cadastrar(maria);
		clienteDAO.cadastrar(joao);
		clienteDAO.cadastrar(felipe);
	}

}
