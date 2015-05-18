
package br.com.larimaia.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.larimaia.exception.ServiceException;
import br.com.larimaia.model.Cliente;
import br.com.larimaia.model.Pedido;
import br.com.larimaia.model.TipoEvento;
import br.com.larimaia.service.PedidoService;


@WebServlet("/PedidoController")
public class PedidoController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
//		System.err.println("Passou aqui Controller");
//		List<Cliente> clientes = new ArrayList<>();
//		ClienteService cs = new ClienteService();
//		clientes = cs.listar();
//		req.setAttribute("listaCliente",clientes);
//		RequestDispatcher dispatcher = req.getRequestDispatcher("Pedido.jsp");  
//		dispatcher.forward(req,resp); 
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("botao = "+req.getParameter("adicionar"));
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
//	    Pedido ped = new Pedido();
//	    ped.setOrigemPedido(origemPedido);
//	    ped.setDataPedido(dataPedido);
//	    ped.setCliente(cliente);
//	    ped.setCerimonial(cerimonial);
//	    ped.setDataEvento(dataEvento);
//	    ped.setTipoEvento(tipoEvento);
//	    ped.setHoraEvento(horaEvento);
//	    ped.setIndicacao(indicacao);
//	    ped.setLocalEvento(localEvento);
//	    ped.setEnderecoEvento(enderecoEvento);
//	    ped.setObs(obs);
//	    
//		PedidoService ps = new PedidoService();
//		try {
//			ps.salvar(ped);
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
		
		
	}
	
	
	
    
}
