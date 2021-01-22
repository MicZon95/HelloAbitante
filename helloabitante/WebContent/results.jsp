<%@page import="java.util.List"%>
<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina dei risultati</title>
<style type="text/css">
	table, th, td {
	  border: 1px solid black;
	}
	
	th, td {
	  padding: 10px;
	}
	.center {
		margin-left: auto;
		margin-right: auto;
	}
</style>

</head>
<body>
	<table class="center">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Azione</th>
			</tr>
		</thead>
		
		<% List<Abitante> listaDaServlet = (List<Abitante>)request.getAttribute("listAbitantiAttributeName");
							for(Abitante abitanteItem : listaDaServlet){
				%>
				<tr>
					<td><%=abitanteItem.getNome() %></td>
					<td><%=abitanteItem.getCognome() %></td>
					<td>
						<a href="VisualizzaDettaglioServlet?idDaInviareComeParametro=<%=abitanteItem.getIdAbitante() %>">Dettaglio</a>
						<br>
						<a href="PreparaModificaServlet?idDaInviareComeParametro=<%=abitanteItem.getIdAbitante() %>">Modifica</a>
						<br>
						<a href="PreparaCancellazioneServlet?idDaInviareComeParametro=<%=abitanteItem.getIdAbitante() %>">Cancella</a>
					</td>
				</tr>
		<%	}%>
	
	</table>
	<br>
	<a href="inserimentoAbitante.jsp" style="margin-left: 10px;">Inserisci un nuovo abitante</a>
</body>
</html>