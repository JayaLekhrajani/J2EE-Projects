import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;

public class Servlet2 extends HttpServlet
{



public void init()
{
System.out.println("Init CAlled");

}

public void destroy()
{
System.out.println("Destroy CAlled");

}


public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
{
	
response.setContentType("text/html");
PrintWriter out=response.getWriter();




out.println("<html>");
out.println("<body>");

out.println("<h2> <i> Welcome " + request.getParameter("firstName") + " </i> </h2>");
if(request.getParameter("clinicalreq")!=null)
{out.println("Clinical Information " +request.getParameter("clinicalreq"));}
out.println("<br><strong>Patient Information</strong></br>");
out.println("<br>First Name " +request.getParameter("firstName") +"</br>");

out.println("<br>Middle Name " +request.getParameter("middlename") +"</br>");

out.println("<br> Last Name " +request.getParameter("lastName") + "</br>");
out.println("<br> Gender " +request.getParameter("genderRadios") + "</br>");
out.println("<br> Marital status " +request.getParameter("maritalstatus") + "</br>");
out.println("<br> Last four digits of SSN " +request.getParameter("ssn") + "</br>");
out.println("<br> Date of Birth " +request.getParameter("datepicker") + "</br>");
out.println("<br> Phone number " +request.getParameter("phonenumber") + "</br>");
out.println("<br> Postal Address " +request.getParameter("postalAddress") + "</br>");
out.println("<br> State " +request.getParameter("state") + "</br>");
out.println("<br> Zip Code " +request.getParameter("ZipCode") + "</br>");
out.println("<br> Country " +request.getParameter("country") + "</br>");
out.println("<br><strong>Details</strong></br>");
out.println("<br> Reasons for referral " +request.getParameter("Referralreasons") + "</br>");
out.println("<br> Preferred Physician or Provider Name if Applicable " +request.getParameter("PreferredPhysician") + "</br>");
out.println("<br> Department or Speciality Area" + request.getParameter("dept") + "</br>");
out.println("<br> Type of referral" + request.getParameter("typeofreferral") + "</br>");
out.println("<br><strong>Referring Provider Information:</strong></br>");
out.println("<br> Provider First Name" + request.getParameter("providerfirstName") + "</br>");
out.println("<br> Provider Last Name" + request.getParameter("providerlastName") + "</br>");
out.println("<br> Provider Title" + request.getParameter("providertitle") + "</br>");
out.println("<br> NPI number:" + request.getParameter("npinumber") + "</br>");
out.println("<br> Street Address:" + request.getParameter("streetaddress") + "</br>");
out.println("<br> Provider City:" + request.getParameter("providercity") + "</br>");
out.println("<br> Provider State:" + request.getParameter("providerstate") + "</br>");
out.println("<br> Provider Zip:" + request.getParameter("providerzip") + "</br>");
out.println("<br> Provider Phone:" + request.getParameter("providerphone") + "</br>");
out.println("<br> Provider Extension:" + request.getParameter("providerextension") + "</br>");
out.println("<br> Provider Fax:" + request.getParameter("providerfax") + "</br>");

















out.println("</body>");
out.println("</html>");
out.close();












}



















}