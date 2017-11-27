<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.a.bean.*"%>

<%News mynew= (News)session.getAttribute("news2");%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
<title>更新</title>
</head>
<body  style="filter:progid:dximagetransform.microsoft.alphaimageloader(src='web1\WebRoot\images\bgmu.png',sizingmethod='scale')">



<center>
<form action="DoModServlet" method="post" name="form1">
<center style="width: 525px; height: 439px">
<table border="1" width="100%" >
<tr>
<td colspan="2">
 <center style='font-size: larger; font-family: "Book Antiqua", "Times New Roman", Serif; font-style: normal;  '>
<strong style='font-size: larger; font-family: "Times New Roman", Serif'><big>新闻修改页面
</big></strong></center>
</td>
</tr>

<tr>
<th style="width: 254px; ">新闻标题：</th>
<td><input name="title" value="<%=mynew.getTitle()  %>" style="width: 254px; "></td>
</tr>

<tr>
<th style="width: 125px; ">新闻内容：</th>
<td><input name="content" value="<%=mynew.getContent()  %>" style="width: 254px; "></td>
</tr>

<tr>
<th>新闻类别：</th>
<td><%ArrayList<Classes> clas= (ArrayList)session.getAttribute("cla");%>

<select name="classId" >
<%for(int i=0;i<clas.size();i++){%> 
<option>  
 <%=clas.get(i).getClassName() %></option>
<%}%>
</select></td>
</tr>

<tr>
<th>发布人：</th>
<td><input name ="Pbperson" value="<%=mynew.getPbperson() %>" style="width: 254px; "></td>
</tr>

<tr>
<th>新闻状态：</th>
<td><input  name="newsstate" value="<%=mynew.getState() %>" style="width: 254px; "></td>
</tr>
<tr>
<td><input type="hidden"  name="newsid"    value="<%=mynew.getNewsid()  %>" ></td>
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
</center>
</form>
</center>

</body>
</html>