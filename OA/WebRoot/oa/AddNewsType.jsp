<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.a.bean.*"%>




<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
<title>更新</title>
</head>
<body>
<center>
<font color=black size=72>新闻分类添加页面</font>
<hr>
<form action="AddNewsTypeServlet" method="post" name="form1">
<table border="1" width="100%" >
<tr>
<th style="width: 254px; ">分类名称：</th>
<td >  <input  name="typename" value="" style="width: 254px; "> </td>
</tr>

<tr>
<td colspan="2">
 <center>
<img src="../images/bg1_submit.png" onclick="form1.submit()"> 
 <img   src="../images/bg1_reset.png" onclick="form1.reset()">
</center>
</td>
</tr>
</table>

</form>

</center>
</body>
</html>