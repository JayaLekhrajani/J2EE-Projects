import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import java.util.Enumeration;

public class Servlet7 extends HttpServlet
{



public void init()
{
System.out.println("Init CAlled");

}

public void destroy()
{
System.out.println("Destroy CAlled");

}

public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
{

response.setContentType("text/html");
PrintWriter out=response.getWriter();

out.println("<html>");
out.println("<head>");
out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>");
out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css'>");
out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js'></script>");
out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>");
out.println("<style type='text/css'>");

out.println("h1{");
   out.println("color:red");
    out.println("}");
	out.println("h2{margin: 30px 0;padding: 0 100px 15px 0;}");
	out.println("h3{border-bottom: 1px solid #E5E5E5;}");
	out.println(".bs-example{margin: 20px}");
	out.println("h4{color:red;margin: 30px 0;padding: 0 100px 15px 0;border-bottom: 1px solid #E5E5E5}");
	out.println("h5{color:red;margin: 30px 0;padding: 0 100px 15px 0;border-bottom: 1px solid #E5E5E5}");
	out.println("h6{color:red;margin: 30px 0;padding: 0 100px 15px 0;border-bottom: 1px solid #E5E5E5	}");
	 
	
	out.println("</style");
	out.println("</head>");

	

	
	
        
    
       
  
       
        
    
       
   
	out.println("<body>");
	out.println("<form class='form-horizontal' method='POST'>");
	
	out.println("<h1>Physician Referral Form</h1>");
	
	out.println("<h2>Is this referral urgent?");
	out.println("<label class='radio-inline'>");
	out.println("<input type='radio' name='urgentoption' value='Referral is urgent' required> Yes");
	out.println("</label>");
	out.println("<label class='radio-inline'>");
	out.println("<input type='radio' name='urgentoption' value='Referral is not urgent' required> No");
	out.println("</label>");
	out.println("</h2>");
	out.println("<h3>If urgent appointment is needed, please call 614-293-5123 to speak with a scheduling representative.</h3>");
	out.println("Please fill out this form completely, include any clinical documentation relevant to this referral, and fax all documents to 614-293-1456");
out.println("Missing information (including clinical documentation) may result in a processing delay <br>");
out.println("<label class='radio-inline'>");
out.println("<input type='radio' name='clinicalreq' value='is included'><b>Clinical Documentation included</b><br>");
out.println("<b><i>(Examples include: insurance cards, imaging, lab work, office procedures, office notes, etc.)</b> </i>");
out.println("<h4> <i>Patient Information: </i></h4>");

out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("First Name:");
 out.print("</label>");
out.print("<div class='col-xs-5'>");
out.print("<input type='text' class='form-control' name='firstName' placeholder='First Name' required>");
out.print("</div>");
out.print("</div>");

out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("Middle Name:");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<input type='text' class='form-control' name='middlename' placeholder='Middle Name' required>");
  out.print("</div>");
out.print("</div>");

out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("Last Name:");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<input type='text' class='form-control' name='lastName' placeholder='Last Name' required>");
  out.print("</div>");
out.print("</div>");


out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
out.print("Gender:");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<label class='radio-inline'>");
  out.print("<input type='radio' name='genderRadios' value='Male' required>");
  out.print("Male");
  out.print("</label>");
  
  out.print("<label class='radio-inline'>");
  out.print("<input type='radio' name='genderRadios' value='Female' required>");
  out.print("Female");
  out.print("</label>");
   out.print("</div>");
out.print("</div>");

out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("Marital Status:");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<input type='text' class='form-control' name='maritalstatus' placeholder='Marital Status' required>");
  out.print("</div>");
out.print("</div>");
  
  
   out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("Last four digits of SSN:");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<input type='text' class='form-control' name='ssn' placeholder='Last four digits of SSN' required>");
  out.print("</div>");
out.print("</div>");
  
  
  out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("Date of Birth::");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
 out.print("<input class='form-control' id='datepicker' name='datepicker' placeholder='MM/DD/YYYY' type='text' required/>");
 
  out.print("</div>");
  out.print("<link rel='stylesheet' href='//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css'>");
  out.print("<script src='//code.jquery.com/jquery-1.10.2.js'></script>");
  out.print("<script src='//code.jquery.com/ui/1.11.4/jquery-ui.js'></script>");
   out.print("<link rel='stylesheet' href='/resources/demos/style.css'>");
   out.print("<script>");
   out.print(" $(function() {");
   out.print("  $( '#datepicker' ).datepicker()");
   out.print(" });");
   out.print("  </script>");
   
out.print("</div>");

  out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("Primary Phone:");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<input type='text' class='form-control' name='phonenumber' placeholder='Primary Phone:' required>");
  out.print("</div>");
out.print("</div>");

out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("Postal Address:");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<textarea rows='3' class='form-control' name='postalAddress' placeholder='Postal Address' required>");
  out.print("</textarea>");
  
  out.print("</div>");
out.print("</div>");

 out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("City:");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<input type='text' class='form-control' name='city' placeholder='City:' required>");
  out.print("</div>");
out.print("</div>");


 out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("State:");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<input type='text' class='form-control' name='state' placeholder='State:' required>");
  out.print("</div>");
out.print("</div>");



 out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("Zip Code:");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<input type='text' class='form-control' name='ZipCode' placeholder='Zip Code:' required>");
  out.print("</div>");
out.print("</div>");


out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("Country");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<input type='text' class='form-control' name='Country' placeholder='Country' required>");
  out.print("</div>");
out.print("</div>");

out.print("<h5><i>Details:</i></h5>");

out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("Reasons for referral:");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<textarea rows='3' class='form-control' name='Reasons for referral' placeholder='Reasons for referral' required>");
  out.print("</textarea>");
  
  out.print("</div>");
out.print("</div>");


 out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("PreferredPhysician:");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<input type='text' class='form-control' name='PreferredPhysician' placeholder='PreferredPhysician:' required>");
  out.print("</div>");
out.print("</div>");


 out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("Department or Speciality Area:");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<input type='text' class='form-control' name='Department or Speciality Area' placeholder='Department or Speciality Area:' required>");
  out.print("</div>");
out.print("</div>");

out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");

  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<label class='radio-inline'>");
  out.print("<input type='radio' name='typeofreferral' value='Consult or Second Opinion' required>");
  out.print("Consult or Second Opinion");

  out.print("</label>");
  
  out.print("<label class='radio-inline'>");
  out.print("<input type='radio' name='typeofreferral' value='Transfer or Care' required>");
  out.print("Transfer or Care");
  out.print("</label>");
   out.print("</div>");
out.print("</div>");
out.print("<h6> <i> Referring Provider Information:</i></h6>");

 out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("Provider First Name:");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<input type='text' class='form-control' name='Provider First Name' placeholder='Provider First Name:' required>");
  out.print("</div>");
out.print("</div>");

 out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("Provider Last Name:");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<input type='text' class='form-control' name='Provider Last Name' placeholder='Provider Last Name:' required>");
  out.print("</div>");
out.print("</div>");


out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("Provider Title:");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<input type='text' class='form-control' name='Provider Title' placeholder='Provider Title:' required>");
  out.print("</div>");
out.print("</div>");


out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("NPI Number:");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<input type='text' class='form-control' name='NPI Number' placeholder='NPI Number:' required>");
  out.print("</div>");
out.print("</div>");


out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("Street Address");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<input type='text' class='form-control' name='Street Address' placeholder='Street Address:' required>");
  out.print("</div>");
out.print("</div>");

out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("City");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<input type='text' class='form-control' name='City' placeholder='City' required>");
  out.print("</div>");
out.print("</div>");


out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("State");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<input type='text' class='form-control' name='State' placeholder='State' required>");
  out.print("</div>");
out.print("</div>");


out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("Zip");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<input type='text' class='form-control' name='Zip' placeholder='Zip' required>");
  out.print("</div>");
out.print("</div>");


out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("Phone");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<input type='text' class='form-control' name='Phone' placeholder='Phone' required>");
  out.print("</div>");
out.print("</div>");



out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("Extension");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<input type='text' class='form-control' name='Extension' placeholder='Extension' required>");
  out.print("</div>");
out.print("</div>");


out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
 out.print("Fax");
  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<input type='text' class='form-control' name='Fax' placeholder='Fax' required>");
  out.print("</div>");
out.print("</div>");


out.println("<div class='form-group'>");
out.println("<label class='control-label col-xs-3' >");
out.print("Physician Signature");

  out.print("</label>");
  out.print("<div class='col-xs-5'>");
  out.print("<label class='control-label col-xs-3' for='PhysicianSignature'>");

 
  out.print("</div>");
out.print("</div>");






























  
  
  










out.println("<input type='submit' class='btn btn-default'  value='Submit'/>");
out.println("</form>");
	out.println("</html>");
	out.close();
	



	
	
	






}
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
{
	
response.setContentType("text/html");
PrintWriter out=response.getWriter();




out.println("<html>");
out.println("<body>");

out.println("<table width='100%' border='1' align='center'>");

out.println("<tr bgcolor='#949494'>");

out.println("<th>Param Name</th>");

out.println("<th>Param Value(s)</th>");
out.println("</tr>");


Enumeration paramNames = request.getParameterNames();

   while(paramNames.hasMoreElements())
		{
			Object objOri=paramNames.nextElement();
			String param=(String)objOri;
			out.print("<tr><td>" + param + "</td>\n");
			String value=request.getParameter(param);
			out.println("<td> " + value + "</td></tr>\n");
		}		















out.println("</body>");
out.println("</html>");
out.close();












}



















}