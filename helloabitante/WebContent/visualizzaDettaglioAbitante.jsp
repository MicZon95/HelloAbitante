<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
<title>Insert title here</title>
</head>
<body>
<% 
	Abitante abitanteDaVisualizzare = (Abitante)request.getAttribute("abitanteDaInviareAPaginaDettaglio");
%>
<h2>Ciao sei nella pagina di dettaglio di: <%= abitanteDaVisualizzare.getNome() %> <%= abitanteDaVisualizzare.getCognome() %></h2>

<p>I suoi dettagli sono:</p>

	<table style="width: 50%">

			<tr>
				<th style="color: blue;text-align: justify;">Codice Fiscale</th>
				<th style="color: blue; text-align: justify;">Età</th>
				<th style="color: blue; text-align: justify;">Motto Di Vita</th>
			</tr>
				<tr>
					<td><%=abitanteDaVisualizzare.getCodiceFiscale() %></td>
					<td><%=abitanteDaVisualizzare.getEta() %></td>
					<td><%=abitanteDaVisualizzare.getMottoDiVita() %></td>
				</tr>
	</table>
</body>
</html>