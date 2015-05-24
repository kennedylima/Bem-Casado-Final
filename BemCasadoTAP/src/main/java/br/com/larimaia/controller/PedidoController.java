
package br.com.larimaia.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.larimaia.model.Cliente;
import br.com.larimaia.model.ItemPedido;
import br.com.larimaia.model.Pedido;
import br.com.larimaia.model.Produto;
import br.com.larimaia.model.TipoEvento;
import br.com.larimaia.service.ClienteService;
import br.com.larimaia.service.PedidoService;


@WebServlet("/PedidoController")
public class PedidoController extends HttpServlet{
	 
	private static List<ItemPedido> itemPedido = new ArrayList<ItemPedido>();;
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//System.out.println("botao = "+req.getParameter("salvar"));
		String acao =req.getParameter("acao");
		
		
		if(acao.equals("excluir")){
			int id = Integer.parseInt(req.getParameter("id"));
			System.out.println("ID lista:"+id);
			itemPedido.remove(id);
			req.setAttribute("itens", itemPedido);
			req.getRequestDispatcher("Pedido.jsp").forward(req, resp);
		}
		 
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		if(req.getParameter("salvar")!=null){
			Pedido ped = new Pedido();
		    ped.setOrigemPedido(req.getParameter("origemProduto"));
		    ped.setDataPedido(req.getParameter("dataPedido"));
		    
			//Inteiro idCliente recebe do cliente escolhido pelo choicebox convertendo em inteiro
		    int idCliente =Integer.parseInt(req.getParameter("clie"));
		    
		    //ClienteService  busca o cliente por id e seta no novo cliente 
		    Cliente cliente = ClienteService.buscarClientePorId(idCliente);
		    
		    //setando o cliente dentro do pedido
		    ped.setCliente(cliente);
		    
		    ped.setCerimonial(req.getParameter("cerimonial"));
		    ped.setDataEvento(req.getParameter("dataEvento"));
		    //anterior ok
			
		    //inteiro te(tipo evento) recebe o id do tipo evento escolhido no combobox
		    int te = Integer.parseInt(req.getParameter("tipoEvento"));
		    
		    //setando o tipo do evento buscado por id no banco 
			TipoEvento tipoEvento = TipoEventoService.BuscarTipoEventoPorId(te);
			
		    ped.setTipoEvento(tipoEvento);
		    ped.setHoraEvento(req.getParameter("horaEvento"));
		    ped.setIndicacao(req.getParameter("indicacao"));
		    ped.setLocalEvento(req.getParameter("localEvento"));
		    ped.setEnderecoEvento(req.getParameter("enderecoEvento"));
		    ped.setObs(req.getParameter("obs"));
			
			
		}
		
		else if(req.getParameter("adicionar")!=null){
			System.out.println("Get Adicionar");
			System.out.println(req.getParameter("produto"));
			ItemPedido ip = new ItemPedido();
			
			ip.setQuantidade(Integer.parseInt(req.getParameter("quantidade")));
			System.out.println("QTD: "+ ip.getQuantidade());
			
			PedidoService ps = new PedidoService();
			List<Produto> prod = ps.buscarProdutos();
			int id = Integer.parseInt(req.getParameter("produto"));
			System.out.println("ID"+id);
			for(Produto p : prod){
				if(p.getId().equals(id)){
					ip.setProduto(p);
				}
				else{
					System.out.println("Não:" + p.getDescricao() +" - "+ id);
				}
				
			}
			
			ip.setValor(ip.getProduto().getValor()*ip.getQuantidade());
			System.out.println("Valor: "+ ip.getValor());
			
			
			System.out.println(ip.getPedido() +" - "+ ip.getProduto().getDescricao() +" - "+ ip.getQuantidade() +" - "+ ip.getValor());
			
			
			itemPedido.add(ip);
			
			
			req.setAttribute("itens", itemPedido);
			req.getRequestDispatcher("Pedido.jsp").forward(req, resp);
			
			
		}
		
		
//		Integer id;
//	    String origemPedido = req.getParameter("origemPedido");
//	    String dataPedido = req.getParameter("dataPedido");
//	    Cliente cliente = (Cliente) req.getAttribute("cliente");
//	    String cerimonial = req.getParameter("cerimonial");
//	    String dataEvento = req.getParameter("dataEvento");
//	    TipoEvento tipoEvento = (TipoEvento) req.getAttribute("tipoEvento");
//	    String horaEvento = req.getParameter("horaEvento");
//	    String indicacao = req.getParameter("indicacao");
//	    String localEvento = req.getParameter("localEvento");
//	    String enderecoEvento = req.getParameter("enderecoEvento");
//	    String obs = req.getParameter("obs");
//	    
//	    
//	    
//		PedidoService ps = new PedidoService();
//		try {
//			ps.salvar(ped);
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
		
		
	}
	
	
	
    
}
