import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import java.util.Enumeration;

public class Servlet3 extends HttpServlet

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

Enumeration en= request.getParameterNames();

while(en.hasMoreElements())
		{
			Object objOri=en.nextElement();
			String param=(String)objOri;
			String value=request.getParameter(param);
			out.println("<br> Parameter Name is "+ param+ " and Parameter Value is "+value + "</br>");
		}		



}















}



