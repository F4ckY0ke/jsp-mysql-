<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="model.Model"%>
<%@page import="entity.Notebook"%>
<%@page import="dbutil.Dbconn"%>
<%@page import="java.math.BigDecimal"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <%
    Model model=new Model();
    List<Notebook> list=model.notebookSelect();
	%>
	<table border="1">         
	<%for(int i=0;i<list.size();i++){%>
				<tr>
				<td><%=list.get(i).getName() %></td>
				<td><%=list.get(i).getPrice() %></td>
				<td><%=list.get(i).getDate() %></td>
				<td><%=list.get(i).getBrand() %></td>
				<td><%=list.get(i).getConfiguration() %></td>
				<td><%=list.get(i).getPurpose() %></td>
				<td><%=list.get(i).getDurable() %></td>
				<td><%=list.get(i).getLocation() %></td>
				</tr>
		<% 	
		}
     %>

     </table>

  </body>
</html>
