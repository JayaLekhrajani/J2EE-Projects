
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Enumeration;

public class Servlet1 extends HttpServlet

		
{
public void init()
{
System.out.println("Init CAlled");

}

public void destroy()
{
System.out.println("Destroy Called");

}

public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
{
String auth=request.getAuthType();
String contextPath=request.getContextPath();
String method=request.getMethod();
String queryString=request.getQueryString();
String uri=request.getRequestURI();
String url=request.getRequestURL().toString();
String protocol=request.getProtocol();
String ip=request.getRemoteAddr();
String title = "Servlet Example: Showing Request Headers";


response.setContentType("text/html");
PrintWriter out=response.getWriter();
out.println("<HTML>\n" +
 "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
 "<BODY BGCOLOR=\"#FDF5E6\">\n" +
 "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
 "<B>Request Method: </B>" +
 request.getMethod() + "<BR>\n" +
 "<B>Request URI: </B>" +
 request.getRequestURI() + "<BR>\n" +
 "<B>Request Protocol: </B>" + request.getProtocol() + "<BR>\n"+ "<B> Remote Address:</B>"+ip+"<BR>\n" +"<B> URL:</B>" +url +"<BR>\n" +
 "<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
 "<TR BGCOLOR=\"#FFAD00\">\n" +
 "<TH>Header Name<TH>Header Value");
 Enumeration headerNames = request.getHeaderNames();
 while(headerNames.hasMoreElements()) {
 String headerName = (String)headerNames.nextElement();
 out.println("<TR><TD>" + headerName);
 out.println(" <TD>" + request.getHeader(headerName));
 }
 out.println("</TABLE>\n</BODY></HTML>");
out.close();


}

}