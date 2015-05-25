
package br.com.larimaia.controller;

import br.com.larimaia.DAO.ItemPedidoPedidoDAO;


public class ItemPedidoPedidoController {

    public ItemPedidoPedidoController() {
    }
    
    
    public void salvarItemPedido_pedido(int idPedido, int idItem){
        ItemPedidoPedidoDAO ippdao = new ItemPedidoPedidoDAO();
        ippdao.salvarItemPedidoPedido(idPedido, idItem);
    }
}
