package br.com.larimaia.service;

import br.com.larimaia.DAO.ItemPedidoPedidoDAO;
import br.com.larimaia.model.ItemPedidoPedido;


public class ItemPedidoPedidoService {

	public void salvarItemPedidoPedido(int idPedido, int idItem) {
		ItemPedidoPedidoDAO ippDAO = new ItemPedidoPedidoDAO();
		ippDAO.salvarItemPedidoPedido(idPedido, idItem);
		
	}

}
