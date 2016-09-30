<%-- 
    Document   : SearchResult
    Created on : May 31, 2016, 12:12:22 AM
    Author     : Jaya_L
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="C:/Users/Dipeeka/Desktop/NEU/Web tools/Pic1.jpg">
        <p>You searched for<b>${keyword}</b></p>
        <c:forEach var="detail" items="${movies}">
            <b>Movie Title: </b><c:out value="${detail.title}"></c:out><br></br>
            <b> Actor: </b><c:out value="${detail.actor}"></c:out><br></br>
            <b> Actress: </b><c:out value="${detail.actress}"></c:out><br></br>
            <b> Genre: </b><c:out value="${detail.genre}"></c:out><br></br>
            <b> Year </b><c:out value="${detail.year}"></c:out><br></br>
           <p>******************************************************************************************************</p> 
        
        </c:forEach>
              <a href = "index.jsp">Click here to go back to main page</a>
                
    </body>
</html>
