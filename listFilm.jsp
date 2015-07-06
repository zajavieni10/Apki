<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Pokaż wszystkie filmy</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./style.css" type="text/css">
    </head>
    <body>
        <div id="content">
            <h6>Lista filmów</h6>
            <table border=1 style="margin: 0 auto;">
                <thead>
                    <tr>
                        <th>Film Id</th>
                        <th>Tytul</th>
                        <th>Rok</th>
                        <th>Reżyser</th>
                        <th>Link</th>
                        <th>Kategoria</th>
                        <th colspan=2>Akcja</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="film" items="${requestScope.filmy}">
                        <tr>
                            <td><c:out value="${film.filmId}" /></td>
                            <td><c:out value="${film.tytul}" /></td>
                            <td><c:out value="${film.rok}" /></td>
                            <td><c:out value="${film.rezyser}" /></td>
                            <td><a href="<c:out value="${film.link}" />">link do FilmWeb</a></td>
                            <td><c:out value="${film.kategoria.kategoriaId}" />. <c:out value="${film.kategoria.opis}" /></td>
                            <td><a href="FilmController?action=edit&filmId=<c:out value="${film.filmId}"/>">Aktualizuj</a></td>
                            <td><a href="FilmController?action=delete&filmId=<c:out value="${film.filmId}"/>">Usuń</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <p><a href="FilmController?action=insert">Dodaj film</a></p>
            <form method="GET" action='LosujController'>
                <input type="hidden" name="action" value="listkategorie"/>
                <input type="submit" name="Losuj" value="Strona główna" />   
            </form>
        </div>
    </body>
</html>
