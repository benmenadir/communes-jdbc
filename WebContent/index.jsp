<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>France - 01</title>
<link rel="stylesheet" href="css/france.css" type="text/css">
</head>
<body>
	<h1>Recherche par code postal (Projet France - 01)</h1>
	<form action="InterrogationVillesServlet">
		Code postal recherché : <input type="text" name="cp" placeholder="minimum deux chiffres"/><input type="submit" value="OK" />
	</form>
	<div>
		<c:if test="${cp != null}">
			<h2>Résultats pour ${cp}</h2>
			<table>
				<tr><th>CP</th><th>Ville</th></tr>
				<c:forEach items="${villes }" var="ville" varStatus="status">
					<tr><td>${ville.codePostal }</td><td>${ville.nom }</td></tr>
				</c:forEach>
			</table>
		</c:if>	
	</div>
</body>
</html>