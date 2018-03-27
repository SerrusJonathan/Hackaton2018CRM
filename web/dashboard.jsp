<%-- 
    Document   : dashboard
    Created on : 26-mrt-2018, 22:30:09
    Author     : Jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My dashboard</title>
    </head>
    <body>
        <h1>Hello <%= session.getAttribute("user") %></h1>
    </body>
</html>
