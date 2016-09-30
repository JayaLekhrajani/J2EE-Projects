<%-- 
    Document   : addMovie
    Created on : May 31, 2016, 12:11:35 AM
    Author     : Jaya_L
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

            
   
            
            
            
            

        
        <title>JSP Page</title>
    </head>
    <body background="C:/Users/Dipeeka/Desktop/NEU/Web tools/Pic1.jpg">
        <h1>Please enter the details!</h1>
        <form action="addData.htm" method="post" name="Form1" onsubmit="return validateForm()">
            Movie Title: <input type="text" name='title' onkeypress="return isNumber(event)" onblur="checkTextField(this)" required><br></br>
            Lead Actor: <input type="text" name='actor' onkeypress="return isNumber(event)" onblur="checkTextField(this)" required><br></br>
            Lead Actress: <input type="text" name='actress' onkeypress="return isNumber(event)" onblur="checkTextField(this)" required> <br></br>
            Genre: <input type="text" name='genre' onkeypress="return isNumber(event)" onblur="checkTextField(this)" required><br></br>
            Year: <input type="number" name='year' min= "1800" max = "2016" onkeypress="return isValid(event)" required> ><br></br>
            <input type="checkbox" name="remember" value="checked" required>Remember Me <br/>
            <input type="hidden" name="addBrowse" value="add">
            <input type="submit" value="Add Movie">
        </form>
        
     <script type="text/javascript">
                   function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if ((charCode > 96 && charCode < 123) || (charCode > 64 && charCode < 91) || (charCode > 47 && charCode < 58)) {
        
        return true;
    }
  
   
    return false;
}

function isValid(evt)
{
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if((charCode > 47 && charCode < 58))
    {
     return true;   
        
    }
    
    return false;
}


function checkTextField(field)
{
   if (field.value == '') {
        alert("Field is empty");
    } 
  
    
         function validateForm()
        {
            //alert("Entering the function");
            var title=document.forms["Form1"]["title"].value;
            var actor=document.forms["Form1"]["actor"].value;
            var actress=document.forms["Form2"]["actress"].value;
          var genre = document.forms["Form1"]["genre"].value;
            var year =  document.forms["Form1"]["year"].value;
            if(title == '' || actor == '' || actress == '' || genre == '' || year == '' || title == null || actor== null || actress == null || genre == null || year==null )  
            {
                alert('Please enter all the fields');
                return false;
            }  
           
            
            
            
        }
    
}
         
       </script>               
    </body>
</html>
