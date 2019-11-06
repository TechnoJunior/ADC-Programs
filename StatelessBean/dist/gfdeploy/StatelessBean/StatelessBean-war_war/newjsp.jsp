<%-- 
    Document   : newjsp
    Created on : 21 Oct, 2019, 1:25:39 PM
    Author     : TechnoBoy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stateless Session Bean</title>
    </head>
    <body>
        <h1>Stateless Session Bean</h1>
        <form action="showData" method="post">
            Enter No1 : <input type="number" name="no1"><br>
            Enter No2 : <input type="number" name="no2"><br>
            <input type="submit" value="add">
        </form>
    </body>
</html>
