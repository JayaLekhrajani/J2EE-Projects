<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>
    <script>
       function save() {
           if(xmlHttp==null){
               alert("Your browser does not support AJAX!");
                return;
           }
       }
       function GetXmlHttpObject()
        {
            var xmlHttp = null;
            try
            {
                // Firefox, Opera 8.0+, Safari
                xmlHttp = new XMLHttpRequest();
            } catch (e)
            {
                // Internet Explorer
                try
                {
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e)
                {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
            }
            return xmlHttp;
        }
    </script>
    <body>

        <c:choose>
            <c:when test="${!empty requestScope.salesOrderList}">
                <h1>SalesOrder</h1>
                <form action="csv.htm" method="post">
                    <table border="1">
                        <tr>
                            <th>SalesOrderID</th>
                            <th>RevisionNumber</th>
                            <th>OrderDate</th>
                            <th>DueDate</th>
                            <th>ShipDate</th>
                            <th>Status</th>
                            <th>OnlineOrderFlag</th>
                            <th>SalesOrderNumber</th>
                            <th>PurchaseOrderNumber</th>
                            <th>AccountNumber</th>
                            <th>CustomerID</th>
                            <th>SalesPersonID</th>
                            <th>TerritoryID</th>
                            <th>BillToAddressID</th>
                            <th>ShipToAddressID</th>
                            <th>ShipMethodID</th>
                            <th>CreditCardID</th>
                            <th>CreditCardApprovalCode</th>
                            <th>CurrencyRateID</th>
                            <th>SubTotal</th>
                            <th>TaxAmt</th>
                            <th>Freight</th>
                            <th>TotalDue</th>
                            <th>Comment</th>
                            <th>ModifiedDate</th>
                            <th>Modify Row</th>

                        </tr>
                        <c:forEach var="salesOrder" items="${requestScope.salesOrderList}">
                            <tr>
                                <td><input type="text" name="value" value="${salesOrder.salesOrderID}"></td>
                                <td><input type="text" name="value" value="${salesOrder.revisionNumber}"></td>
                                <td><input type="text" name="value" value="${salesOrder.orderDate}"></td>
                                <td><input type="text" name="value" value="${salesOrder.dueDate}"></td>
                                <td><input type="text" name="value" value="${salesOrder.shipDate}"></td>
                                <td><input type="text" name="value" value="${salesOrder.status}"></td>
                                <td><input type="text" name="value" value="${salesOrder.onlineOrderFlag}"></td>
                                <td><input type="text" name="value" value="${salesOrder.salesOrderNumber}"></td>
                                <td><input type="text" name="value" value="${salesOrder.purchaseOrderNumber}"></td>
                                <td><input type="text" name="value" value="${salesOrder.accountNumber}"></td>
                                <td><input type="text" name="value" value="${salesOrder.customerID}"></td>
                                <td><input type="text" name="value" value="${salesOrder.salesPersonID}"></td>
                                <td><input type="text" name="value" value="${salesOrder.territoryID}"></td>
                                <td><input type="text" name="value" value="${salesOrder.billToAddressID}"></td>
                                <td><input type="text" name="value" value="${salesOrder.shipToAddressID}"></td>
                                <td><input type="text" name="value" value="${salesOrder.shipMethodID}"></td>
                                <td><input type="text" name="value" value="${salesOrder.creditCardID}"></td>
                                <td><input type="text" name="value" value="${salesOrder.creditCardApprovalCode}"></td>
                                <td><input type="text" name="value" value="${salesOrder.currencyRateID}"></td>
                                <td><input type="text" name="value" value="${salesOrder.subTotal}"></td>
                                <td><input type="text" name="value" value="${salesOrder.taxAmt}"></td>
                                <td><input type="text" name="value" value="${salesOrder.freight}"></td>
                                <td><input type="text" name="value" value="${salesOrder.totalDue}"></td>
                                <td><input type="text" name="value" value="${salesOrder.comment}"></td>
                                <td><input type="text" name="value" value="${salesOrder.modifiedDate}"></td>
                                <td><input type='submit' name='Save' value="Save" onclick="return save()" id='${salesOrder.salesOrderID}'> <input type='submit' name='Delete' value="Delete"></td>
                            </tr>
                        </c:forEach> 
                    </table></br></br>

                   
                              
                                        <c:forEach begin="1" end="4" var="i">                                            
                                                                <td><a href="csv.htm?page=${i}">${i}</a></td>
                                        
                                            </c:forEach>
                            

                        <input type="Submit" value="Inert into DB"/>
                        <input type="hidden" name="action" value="insert"/>
                    </form>

            </c:when>
            <c:when test="${!empty requestScope.count}">
                <h1> ${requestScope.count} rows inserted in database successfully.!!!</h1>
            </c:when>
            <c:otherwise>
                <h1>Enter the name of CSV file</h1>
                <form action="csv.htm" method="post">
                    <input type="text" name="nameCsv"/>                   
                    <input type="submit" value="Submit"/>
                    <input type="hidden" name="action" value="view"/>
                </form>
            </c:otherwise>
        </c:choose>
    </body>
</html>
