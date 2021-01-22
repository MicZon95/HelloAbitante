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
<% 
	Abitante abitanteDaEliminare = (Abitante)request.getAttribute("abitanteDaCancellare");
%>
<h1 style="color: red">SEI CONVINTO DI VOLER ELIMINARE <%= abitanteDaEliminare.getNome().toUpperCase() %> <%= abitanteDaEliminare.getCognome().toUpperCase() %> ?</h1>
<br>
<form action="CancellazioneAbitanteServlet" method="post">
	<input type="hidden" value="<%= abitanteDaEliminare.getIdAbitante() %>" name="idAbitante">
	<input type="submit" value="SI" style="background-color: darkred;color: white; border: none; padding: 14px 28px; margin: 4px 2px; cursor: pointer;"> 
	
</form>

<form action="searchForm.jsp" style="margin-left: 88px; margin-top: -50px!important;">
	<input type="submit" value="NO" style="background-color: green;color: white; border: none; padding: 14px 28px; margin: 4px 2px; cursor: pointer;">
</form>

</body>
</html>