<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Losowanie filmu</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="./style.css" type="text/css">
    </head>
    <body>
        <div id="content">
            <jsp:forward page="/LosujController" >
                <jsp:param name="action" value="listkategorie"/>
            </jsp:forward> 
        </div>
    </body>
</html>
