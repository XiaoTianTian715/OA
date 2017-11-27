
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.a.bean.*"%>
<%User user= (User)session.getAttribute("myuser");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    
    
    <title>My JSP 'reg.jsp' starting page</title>
    

	<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body > 
  <center>
<font color=blue size=72>添加新闻页面</font>
<hr>

<form name="form1" action="DoAddServlet" method="post">
<table border="1" width="100%" >
<tr>
<th>新闻标题：</th>
<td><input name="title" value="" style="width: 254px; "></td>
</tr>

<tr>
<th style="width: 254px; ">新闻内容：</th>
<td><input name="content" value=""  style="width: 254px; "></td>
</tr>
<input type="hidden"  name="pbperson"    value="<%=user.getName() %>" >


<tr>
<th>新闻类别：</th>
<td><%ArrayList<Classes> clas= (ArrayList)session.getAttribute("cla");%>
<select name="classid" >
<%for(int i=0;i<clas.size();i++){%> 
<option>  <%=clas.get(i).getClassName() %></option>
<%}%>
</select></td>
</tr>



<tr>
<th>审核状态：</th>
<td><input name="newsstate" value="" style="width: 254px; "></td>
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
