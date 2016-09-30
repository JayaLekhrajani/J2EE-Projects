<%-- 
    Document   : searchMovie
    Created on : May 30, 2016, 10:22:38 PM
    Author     : Jaya_L
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="C:/Users/Dipeeka/Desktop/NEU/Web tools/Pic1.jpg">
        <h1>Searching Movies</h1>
        <form action = 'addData.htm' method = 'get'>
           Keyword : <input type  = 'text' name = 'keyword'><br/><br/>
           <input type  = 'radio' name = 'category' value = 'Search By Title' checked/>Search By Title<br/><br/>
           <input type = 'radio' name = 'category' value = 'Search By Actor'/>Search By Actor<br/><br/>
            <input type = 'radio' name = 'category' value = 'Search By Actress'/>Search By Actress<br/><br/>
            <input type = 'submit' value = 'Search Movies'>
            <input type = 'hidden' name = 'addBrowse' value = 'browse'>
        </form>
</html>
