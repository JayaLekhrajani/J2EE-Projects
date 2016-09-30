<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/custom.tld"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>
    <body>
       
       
       <c:choose>
        
         <c:when test="${requestScope.action=='disp'}">
             <ct:Hello csvFileName="${param['nameCsv']}"></ct:Hello>
                </c:when>
         <c:when test="${!empty requestScope.count}">
                <h1> ${requestScope.count} rows inserted in database successfully.!!!</h1>
            </c:when>
            <c:otherwise>
                <h1>Enter name of CSV file</h1>
                <form action="csv.htm" method="post">
                    <input type="text" name="nameCsv"/>                   
                    <input type="submit" value="Submit"/>
                    <input type="hidden" name="action" value="view"/>
                    
                </form>
            </c:otherwise>
         </c:choose>
    </body>       
</html>
