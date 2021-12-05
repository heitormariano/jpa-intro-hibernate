package br.com.alura.loja.testes;

import br.com.alura.loja.dao.ClienteDAO;
import br.com.alura.loja.dao.PedidoDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;

public class CadastroPedido {

	public static void main(String[] args) {
		// recuperar cliente
		ClienteDAO clienteDAO = ClienteDAO.getInstance();
		Cliente joao = clienteDAO.obterByNome("João");

		// recuperar produto
		ProdutoDAO produtoDAO = ProdutoDAO.getInstance();
		Produto mouse = produtoDAO.obterByNome("Mouse");

		// cadastrar pedido
		PedidoDAO pedidoDAO = PedidoDAO.getInstance();
		Pedido pedido = new Pedido(joao);

		ItemPedido item = new ItemPedido(5, pedido, mouse);
		pedido.adicionarItem(item);
		pedidoDAO.cadastrar(pedido);
	}

}
