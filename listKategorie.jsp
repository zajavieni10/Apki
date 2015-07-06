<%-- 
    Document   : listKategorie
    Created on : 2015-06-22, 09:32:14
    Author     : Anna
--%>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Wylosuj swój film</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./style.css" type="text/css">
    </head>
    <body>
        <div id="content">
            <h6>Wylosuj swój film</h6>
            <form method="GET" action='FilmController' name="frmLosujFilm">
                <select name="kategoria">
                    <c:forEach var="kategoria" items="${requestScope.kategorie}">
                        <option value="<c:out value="${kategoria.kategoriaId}" />"><c:out value="${kategoria.opis}" /></option>
                    </c:forEach>
                </select>
                <input type="hidden" name="action" value="losuj"/>
                <input type="submit" name="Losuj" value="Losuj" />
            </form>
            <br>
            <br>
            <br>
            <form method="GET" action='FilmController'>
                <input type="hidden" name="action" value="listFilm"/>
                <input type="submit" name="Baza" value="Baza filmów" />
            </form>
        </div>
    </body>
</html>
