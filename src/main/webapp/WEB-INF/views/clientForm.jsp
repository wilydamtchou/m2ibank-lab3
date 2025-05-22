<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Créer un client</title></head>
<body>
    <h2>Créer un nouveau client</h2>

    <c:if test="${not empty erreurs}">
        <ul style="color:red;">
            <c:forEach var="err" items="${erreurs}">
                <li>${err}</li>
            </c:forEach>
        </ul>
    </c:if>

    <form method="post" action="${pageContext.request.contextPath}/clients">
        Nom : <input type="text" name="nom" value="${nom}"/><br/>
        Prénom : <input type="text" name="prenom" value="${prenom}"/><br/>
        Email : <input type="email" name="email" value="${email}"/><br/>
        Téléphone : <input type="text" name="telephone" value="${telephone}"/><br/>
        <input type="submit" value="Créer"/>
    </form>
    <a href="${pageContext.request.contextPath}/clients/form">Acceuil</a>
</body>
</html>
