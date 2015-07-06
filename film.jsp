<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head> 
        <title>Dodaj nowy film</title>
        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
        <link rel="stylesheet" href="./style.css" type="text/css">
    </head>
    <body>
        <div id="content">
            <h6>Dodaj nowy film<h6>
            <form method="POST" action='FilmController' name="frmAddFilm">
                <p>Tytuł: <input type="text" name="tytul"
                    value="<c:out value="${film.tytul}" />" />
                <p>Rok Produkcji: <input type="text" name="rok"
                    value="<c:out value="${film.rok}" />" />
                <p>Reżyser: <input type="text" name="rezyser"
                    value="<c:out value="${film.rezyser}" />" /> 
                <p>Link: <input type="text" name="link"
                    value="<c:out value="${film.link}" />" />
                <p>Kategoria: <input type="text" name="kategoria_id"
                    value="<c:out value="${film.kategoria.kategoriaId}" />" />
                <p><input type="hidden" name="filmId"
                    value="<c:out value="${film.filmId}" />" /> 
                <p><input type="submit" value="Submit" />
            </form>
        </div>
    </body>
</html>
