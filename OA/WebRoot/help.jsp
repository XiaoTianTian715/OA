<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'help.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <center>
  <body style="filter:progid:dximagetransform.microsoft.alphaimageloader(src='images\bg_water.jpg',sizingmethod='scale'); height: 75px">
    <br><br><br><br><br><br><br><br><br> <font  size=72 style="color:blue; ">更多帮助请联系组长</font><br>
    <font  size=72 style="color:blue; "> 电话：10010</font> <br>
  </body>
  <center>
</html>
