<%-- 
    Document   : Success
    Created on : May 31, 2016, 3:15:21 PM
    Author     : Jaya_L
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success</title>
    </head>
    <body background="C:/Users/Dipeeka/Desktop/NEU/Web tools/Pic2.jpg">
        <h1><c:out value="${sessionScope.count}" ></c:out>Books Added Successfully....!!!</h1>
              <a href="index.jsp">Click here to go back to home page</a>
    </body>
</html>
