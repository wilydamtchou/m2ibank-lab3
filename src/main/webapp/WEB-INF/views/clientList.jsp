<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Liste des clients</title></head>
<body>
    <h2>Clients enregistrés</h2>
    <table border="1">
        <tr>
            <th>ID</th><th>Nom</th><th>Prénom</th><th>Email</th><th>Téléphone</th>
        </tr>
        <c:forEach var="client" items="${clients}">
            <tr>
                <td>${client.clientId}</td>
                <td>${client.nom}</td>
                <td>${client.prenom}</td>
                <td>${client.email}</td>
                <td>${client.telephone}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/clients/form">Créer un nouveau client</a>
    <a href="${pageContext.request.contextPath}">Acceuil</a>
</body>
</html>