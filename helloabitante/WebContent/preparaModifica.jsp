<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% if(request.getAttribute("messaggioDiErrore") != null){ %>
		<p style="color: red;"><%=request.getAttribute("messaggioDiErrore") %></p>
<%}    %>

<% 
	Abitante abitanteDaModificare = (Abitante)request.getAttribute("abitanteDaInviareAPaginaPreparaModifica");
%>
<form action="ModificaAbitanteServlet" method="post">
	<h2>Scegli i campi da modificare:</h2>
	<label>Nome:</label>
	<label style="margin-left: 120px;">Cognome:</label>
	<label style="margin-left: 100px;">Codice Fiscale:</label>
	<label style="margin-left: 68px;">Età:</label>
	<label style="margin-left: 137px;">Motto:</label>
	<br>
	<input type="text" value="<%= abitanteDaModificare.getNome() %>" name="nomeModificato">
	<input type="text" value="<%= abitanteDaModificare.getCognome() %>" name="cognomeModificato">
	<input type="text" value="<%= abitanteDaModificare.getCodiceFiscale() %>" name="codiceFiscaleModificato">
	<input type="text" value="<%= abitanteDaModificare.getEta() %>" name="etaModificata">
	<input type="text" value="<%= abitanteDaModificare.getMottoDiVita() %>" name="mottoModificato">
	<input type="hidden" value="<%= abitanteDaModificare.getIdAbitante() %>" name="idAbitante">
	<input type="submit" value="Modifica">
</form>
</body>
</html>