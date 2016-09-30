import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet4 extends HttpServlet
{
	
	
public void init()
{
System.out.println("Init CAlled");

}

public void destroy()
{
System.out.println("Destroy Called");

}


public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
{

response.setContentType("text/html");
PrintWriter out=response.getWriter();


out.println("<html>");
out.println("<body>");

Map m=request.getParameterMap();
        Set s = m.entrySet();
        Iterator it = s.iterator();
 
            while(it.hasNext()){
 
                Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>)it.next();
 
                String key             = entry.getKey();
                String[] value         = entry.getValue();
 
                out.println("Key is "+key+"<br>");
 
                    if(value.length>1){    
                        for (int i = 0; i < value.length; i++) {
                            out.println("<li>" + value[i].toString() + "</li><br>");
                        }
                    }else
                            out.println("Value is "+value[0].toString()+"<br>");
 
                    out.println("-------------------<br>");
            }



  out.close();


}
}