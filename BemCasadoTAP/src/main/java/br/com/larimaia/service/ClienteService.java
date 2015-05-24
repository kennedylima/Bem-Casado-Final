package br.com.larimaia.service;

import br.com.larimaia.DAO.ClienteDAO;
import br.com.larimaia.model.Cliente;

public class ClienteService {

	public ClienteService() {
		// TODO Auto-generated constructor stub
	}
	
	public static Cliente buscarClientePorId(Integer id) {
    	ClienteDAO clienteDAO = new ClienteDAO(); 
    	return clienteDAO.buscarClientePorId(id);
    
    }
}
