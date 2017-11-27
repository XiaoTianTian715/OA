<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.a.dao.impl.*"%>
<%@page import="com.a.dao.*"%>
<%@page import="com.a.bean.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.a.bean.*"%>

<%News mynews= (News)session.getAttribute("news1");%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>审核页面</title>
<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
</head>
<body>
<center>
<font color=red size=72>新闻审核页面</font>
<hr>
<form action="DoCheckServlet" method="post" name="form1">
<table border="1" width="100%" >
<tr>
<th>新闻标题：</th>
<td> <%=mynews.getTitle() %> </td>
</tr>

<tr>
<th>新闻内容：</th>
<td><%=mynews.getContent() %></td>
</tr>
<%ClassesDaoImpl clas= (ClassesDaoImpl)session.getAttribute("cladao");%>
<tr>
<th style="width: 254px; ">新闻类别号：</th>
<td > <%=clas.SearchById(mynews.getClassid()).getClassName() %></td>
</tr>    

<tr>
<th>发布人：</th>
<td><%=mynews.getPbperson() %></td>
</tr>

<tr>
<th>新闻状态：</th>
<td>  <%=mynews.getState() %></td>
</tr>


<input type="hidden"  name="newsid"    value="<%=mynews.getNewsid() %>" >




<input type="hidden" name="title" value="<%=mynews.getTitle() %>" >




<input type="hidden" name="content" value="<%=mynews.getContent() %>" >




<input  type="hidden" name ="classId" value="<%=mynews.getClassid() %>" >



<input type="hidden" name ="Pbperson" value="<%=mynews.getPbperson() %>">




<input  type="hidden" name="newsstate" value="<%=mynews.getState()  %>" >
















<tr>
<td colspan="2">
 <center>
 <img src="../images/bg1_she.png" onclick="form1.submit()"> 

</center>
</td>
</tr>
</table>

</form>

</center>
</body>
</html>