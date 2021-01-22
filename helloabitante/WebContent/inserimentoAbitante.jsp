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

<form action="InserisciAbitanteServlet" method="post">
	<h2>Scegli i campi da modificare:</h2>
	<label>Nome:</label>
	<label style="margin-left: 120px;">Cognome:</label>
	<label style="margin-left: 100px;">Codice Fiscale:</label>
	<label style="margin-left: 68px;">Età:</label>
	<label style="margin-left: 137px;">Motto:</label>
	<br>
	<input type="text" placeholder="Nome" name="nomeDaInserire">
	<input type="text" placeholder="Cognome" name="cognomeDaInserire">
	<input type="text" placeholder="Codice Fiscale" name="codiceFiscaleDaInserire">
	<input type="text" placeholder="Eta" name="etaDaInserire">
	<input type="text" placeholder="Motto" name="mottoDaInserire">
	<input type="submit" value="Inserisci">
</form>

</body>
</html>