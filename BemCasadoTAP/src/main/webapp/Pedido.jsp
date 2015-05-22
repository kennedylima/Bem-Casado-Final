

<%@page import="br.com.larimaia.model.Cliente"%>
<%@page import="br.com.larimaia.model.TipoEvento"%>
<%@page import="br.com.larimaia.model.Produto"%>
<%@page import="br.com.larimaia.service.PedidoService"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*,java.lang.*" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="MeuCSS.css">
<meta charset="ISO-8859-1">
<title>Cadastro de Pedido</title>

</head>
<body>
<form action="PedidoController" method="POST">

<h1 align="left">Lari Maia - Pedido</h1>

<div style="position: absolute; top:100px;left:5px; width: 500px; height:500px; background-color: white;">

	<label >Origem do Pedido: </label>
	<input  type="text"/>
	<br>
	
	<label>Data do Pedido: </label>
	<input type="date"/>
	<br>
	
	<label>Cliente: </label>
		<select Name = "choiceCLiente" style ="width:200px;">
				<option value="0">Escolha um Cliente</option>
				<% List<Cliente> clien= PedidoService.buscarClientes();
					for (Cliente c: clien) {%>
				<option value = "<%=c.getId()%>"><%=c.getNome()%></option>
  				<% }%>
			
		</select>
	<br>
	
	
	<label>Indica&ccedil;&atilde;o: </label>
	<input type="text"/>
	<br>
	
	<label>Observa&ccedil;&otilde;es: </label>
	<textarea style="width: 400px; height: 100px;"></textarea>
	<br>
<br>
<br>
	
	
	
</div>

<div style="position: absolute; top:100px;left:550px; width: 500px; background-color: white;">

	<label>Cerimonial: </label>
	<input type="text"/>
	<br>
	
	<label>Data do Evento: </label>
	<input type="date"/>
	<br>
	
	<label>Tipo do Evento: </label>
	<select style ="width:200px;">
			<option value="0">Escolha um evento</option>
			<% List<TipoEvento> tipoEvento= PedidoService.buscarTipoEventos();
				for (TipoEvento te: tipoEvento) {%>
			<option value = "<%=te.getId()%>"><%=te.getDescricao()%></option>
 				<% }%>
	
	</select>
	<br>
	
	<label>Horario do Evento: </label>
	<input type="text"/>
	<br>
	
	<label>Local do Evento: </label>
	<input type="text"/>
	<br>
	
	<label>Endere&ccedil;o: </label>
	<input type="text"/>
	<br>
	<br>
	<label> Produto  </label>
	<label>Quantidade </label>
	<button type="submit" name="adicionar" value="adicionar">Adicionar </button>
	<br>
	
	<select id="produto"name="produto" onchange="adicionar">
		<option value="0">Escolha um produto</option>
			<% List<Produto> prod= PedidoService.buscarProdutos();
				for (Produto produt: prod) {%>
			<option value = "<%=produt%>"><%=produt.getDescricao()%></option>
 				<% 
 					}	
 				%>
		
	</select>
	
	<input name= "quantidade"id="qtd" type="number">
	<br>
	<br>
	
	<table id="tabela">
		<thead>
			<tr>
			    <th>Produto</th>
			    <th>Quantidade</th>
			    <th>Valor</th>
			</tr>
		</thead>	
		<tbody>
			<c:forEach items="${itens}" var="itens">
                <tr>
                    <td><c:out value="${itens.produto.getDescricao()}" /></td>
                    <td><c:out value="${itens.quantidade }" /></td>
                    <td><c:out value="${itens.valor }" /></td>
                    <td><a href="UserController?action=delete&userId=<c:out value="${user.uname}"/>">Delete</a></td>
                </tr>
            </c:forEach>
		</tbody>
	</table>
	<br>
	<br>
	<label>Valor Total:</label>
	<input type="text"/>

	<button type="submit" name="salvar" value="salvar">Salvar</button>


<br>
<br>
<br>
<br>
<br>
<br>
<br>
</div>

	
</form>
</body>
</html>