<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

    </head>
    <body background="C:/Users/Dipeeka/Desktop/NEU/Web tools/Pic2.jpg">
         <h1>How many books do you want to add?</h1>
    <c:choose>
        <c:when test="${empty sessionScope.count}" >
            <form name="form1" action="Books.do" method="post" onsubmit="return ValidateForm()">
                <input type="number" name="noOfBooks" id="check" onkeypress="return isNumber(event)" onblur="checkTextField(this)"/>
       <input type="submit" name="Submit"  />
                       
            </form>
        </c:when>
        <c:otherwise >
            <form action="Books.do" method="post">
                <table border="1" cellspacing="10">
                    <tr>
                        <th>ISBN</th>
                        <th>Book Title</th>
                        <th>Author</th>
                        <th>Price</th>
                     </tr>
                     <c:set var="k" value="0"></c:set>
                     <c:forEach begin="1" end="${sessionScope.count}" var="i">
                         <tr>
                             <c:forEach begin="1" end="4" var="j">
                                 <td>
                                     <c:set var="k" value="${k+1}"></c:set>

                                         <input type="text" name="value${k}" onkeypress=" return isValid()" onblur="checkTextField(this)"/>
                                 </td>
                             </c:forEach>
                         </tr>
                     </c:forEach>
                </table>
                     <input type="submit" value="Add Books"/>
                </form>
                               
            </c:otherwise>    
        
    </c:choose>
         
         <script type="text/javascript">
    function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        
        return false;
    }
  
   
    return true;
}


function checkTextField(field)
{
   if (field.value == '') {
        alert("Field is empty");
    } 
    
}

function isValid(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if ((charCode > 96 && charCode < 123) || (charCode > 64 && charCode < 91) || (charCode > 47 && charCode < 58)) {
        
        return true;
    }
  
   
    return false;
}
       
   function  ValidateForm()
   {
       var p=document.getElementById("check");
       var c=p.value;
       if(c=='')
       {alert("No valid value entered");
       return false;}
   return true;
       
   }
       
       
       
       
       </script>  
    </body>
</html>
