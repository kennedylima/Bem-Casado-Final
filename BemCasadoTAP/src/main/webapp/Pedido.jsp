

<%@page import="br.com.larimaia.service.ClienteService"%>
<%@page import="br.com.larimaia.model.Cliente"%>
<%@page import="br.com.larimaia.model.TipoEvento"%>
<%@page import="br.com.larimaia.model.Produto"%>
<%@page import="br.com.larimaia.service.PedidoService"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*,java.lang.*" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
	<input name="origemProduto"  type="text"/>
	<br>
	
	<label>Data do Pedido: </label>
	<input name="dataPedido"  type="date"/>
	<br>
	
	<label>Cliente: </label>
		<select name="clie" style ="width:200px;">
				<option value="0">Escolha um Cliente</option>
				<% List<Cliente> clien= ClienteService.buscarClientes();
					for (Cliente c: clien) {%>
				<option value = "<%=c.getId()%>"><%=c.getNome()%></option>
  				<% }%>
			
		</select>
	<br>
	
	
	<label>Indica&ccedil;&atilde;o: </label>
	<input name ="indicacao" type="text"/>
	<br>
	
	<label>Observa&ccedil;&otilde;es: </label>
	<textarea name="obs" style="width: 400px; height: 100px;"></textarea>
	<br>
<br>
<br>
	
	
	
</div>

<div style="position: absolute; top:100px;left:550px; width: 500px; background-color: white;">

	<label>Cerimonial: </label>
	<input name ="cerimonial" type="text"/>
	<br>
	
	<label>Data do Evento: </label>
	<input name="dataEvento" type="date"/>
	<br>
	
	<label>Tipo do Evento: </label>
	<select name="tipoEvento" style ="width:200px;">
			<option value="0">Escolha um evento</option>
			<% List<TipoEvento> tipoEvento= PedidoService.buscarTipoEventos();
				for (TipoEvento te: tipoEvento) {%>
			<option value = "<%=te.getId()%>"><%=te.getDescricao()%></option>
 				<% }%>
	
	</select>
	<br>
	
	<label>Horario do Evento: </label>
	<input name="horaEvento" type="text"/>
	<br>
	
	<label>Local do Evento: </label>
	<input name="localEvento" type="text"/>
	<br>
	
	<label>Endere&ccedil;o: </label>
	<input name="enderecoEvento" type="text"/>
	<br>
	<br>
	<label> Produto  </label>
	
	<br>
	
	<select id="produto"name="produto" onchange="adicionar">
		<option value="0">Escolha um produto</option>
			<% List<Produto> prod= PedidoService.buscarProdutos();
				for (Produto produt: prod) {%>
			<option value = "<%=produt.getId()%>"><%=produt.getDescricao()%></option>
 				<% 
 					}	
 				%>
		
	</select>
	
	<label> Quantidade </label>
	<input name= "quantidade"id="qtd" type="number" style="width: 30px">
	<button type="submit" name="adicionar" value="adicionar">Adicionar </button> 
	
	<br>
	<br>
	
	<table id="tabela">
		<thead>
			<tr>
				<th> Id</th>
			    <th>Produto</th>
			    <th>Quantidade</th>
			    <th>Valor</th>
			</tr>
		</thead>	
		<tbody>
			
			
			<c:forEach items="${requestScope.itens}" var="itens" varStatus="contador" >
                <div id="${contador}">
                <tr>
                	<td><c:out value="${contador.index}" /></td>
                	<td><c:out value="${itens.produto.getDescricao()}" /></td>
                    <td><c:out value="${itens.quantidade }" /></td>
                    <td><fmt:formatNumber value="${itens.valor}"/> </td>
                    <c:set var="valorTotal" value="${valorTotal+ itens.valor}"> </c:set>
                    <td><a href="PedidoController?acao=excluir&id=${contador.index}">Excluir</a></td>  
                </tr>
				</div>
				
            </c:forEach>
		</tbody>
	</table>
	<br>
	<br>
	
	<label>Valor Total =<fmt:formatNumber value="${valorTotal}" type="currency"/> </label>


<br>
<br>
<br>
	<button type="submit" name="salvar" value="salvar">Salvar</button>



<br>
<br>
<br>
<br>
</div>

	
</form>
</body>
</html>
