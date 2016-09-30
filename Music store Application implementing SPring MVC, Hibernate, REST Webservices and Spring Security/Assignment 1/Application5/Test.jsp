<%@ page import="java.io.*,java.util.*" %>
<html>
<Head>
<title> <strong> Details</strong></title>
<link rel=STYLESHEET
 HREF="JSP-Styles.css" TYPE="text/css">
</head>
<body>
<table width="100%" border="1" align="center">
<tr bgcolor="#949494">
<th>Param Name</th>
<th>Param Value(s)</th>
</tr>



<%
   Enumeration paramNames = request.getParameterNames();

   while(paramNames.hasMoreElements())
		{
			Object objOri=paramNames.nextElement();
			String param=(String)objOri;
			out.print("<tr><td>" + param + "</td>\n");
			String value=request.getParameter(param);
			out.println("<td> " + value + "</td></tr>\n");
		}		
%>
</table>
</body>
</html>