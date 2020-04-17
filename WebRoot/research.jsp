<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="model.Model"%>
<%@page import="entity.Notebook"%>
<%@page import="dbutil.Dbconn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'research.jsp' starting page</title>
    
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
        //1、接收从input.jsp中传递过来的参数 
    	//2、执行查询
    	//3、显示结果
    	int id=Integer.parseInt(request.getParameter("notebookid"));
    	Model model=new Model();
    	Notebook notebook=model.load(id);
    	//根据查询数据来决定如何显示结果
    	//查询的数据有两种结果：null，实体对象
    	if(notebook==null){
    		out.println("没有查询到数据");
    	}else{
    		out.println("电脑名："+notebook.getName());
    	}
     %>
     <br>
     <a href="search.jsp">返回继续查询</a>
  </body>
</html>
