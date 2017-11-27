
<%@page import="com.a.dao.impl.*"%>
<%@page import="com.a.dao.*"%>
<%@page import="com.a.bean.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>

    
    <title>My JSP 'reviewNewsList.jsp' starting page</title>
 
<link href="tablecloth/tablecloth.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="tablecloth/tablecloth.js"></script>
<title>新闻列表</title>
<script>
function selected(o)
{ 
location.href=o.value;
}
function Page(iAbsolute,sTableId,sTBodyId,page)
{
this.absolute = iAbsolute; //每页最大记录数
this.tableId = sTableId;
this.tBodyId = sTBodyId;
this.rowCount = 0;//记录数
this.pageCount = 0;//页数
this.pageIndex = 0;//页索引
this.__oTable__ = null;//表格引用
this.__oTBody__ = null;//要分页内容
this.__dataRows__ = 0;//记录行引用
this.__oldTBody__ = null;
this.__init__(); //初始化;
};
/**//*
初始化
*/
Page.prototype.__init__ = function(){
this.__oTable__ = document.getElementById(this.tableId);//获取table引用
this.__oTBody__ = this.__oTable__.tBodies[this.tBodyId];//获取tBody引用
this.__dataRows__ = this.__oTBody__.rows;
this.rowCount = this.__dataRows__.length;
try{
this.absolute = (this.absolute <= 0) || (this.absolute>this.rowCount) ? this.rowCount : this.absolute;
this.pageCount = parseInt(this.rowCount%this.absolute == 0
? this.rowCount/this.absolute : this.rowCount/this.absolute+1);
}catch(exception){}
this.__updateTableRows__();
};
Page.prototype.GetBar=function(obj)
{
var bar= document.getElementById(obj.id);
bar.innerHTML= "每页"+this.absolute+"条/共"+this.rowCount+"条";// 第2页/共6页 首页 上一页 1 2 3 4 5 6 下一页 末页
}
/**//*
下一页
*/
Page.prototype.nextPage = function(){
if(this.pageIndex + 1 < this.pageCount){
this.pageIndex += 1;
this.__updateTableRows__();
}
};
/**//*
上一页
*/
Page.prototype.prePage = function(){
if(this.pageIndex >= 1){
this.pageIndex -= 1;
this.__updateTableRows__();
}
};
/**//*
首页
*/
Page.prototype.firstPage = function(){
if(this.pageIndex != 0){
this.pageIndex = 0;
this.__updateTableRows__();
}
};
/**//*
尾页
*/
Page.prototype.lastPage = function(){
if(this.pageIndex+1 != this.pageCount){
this.pageIndex = this.pageCount - 1;
this.__updateTableRows__();
}
};
/**//*
页定位方法
*/
Page.prototype.aimPage = function(){
var abc = document.getElementById("pageno");
var iPageIndex = abc.value;
var iPageIndex = iPageIndex*1;
if(iPageIndex > this.pageCount-1){
this.pageIndex = this.pageCount -1;
}else if(iPageIndex < 0){
this.pageIndex = 0;
}else{
this.pageIndex = iPageIndex-1;
}
this.__updateTableRows__();
};
/**//*
执行分页时，更新显示表格内容
*/
Page.prototype.__updateTableRows__ = function(){
var iCurrentRowCount = this.absolute * this.pageIndex;
var iMoreRow = this.absolute+iCurrentRowCount > this.rowCount ? this.absolute+iCurrentRowCount - this.rowCount : 0;
var tempRows = this.__cloneRows__();
var removedTBody = this.__oTable__.removeChild(this.__oTBody__);
var newTBody = document.createElement("TBODY");
newTBody.setAttribute("id", this.tBodyId);
for(var i=iCurrentRowCount; i < this.absolute+iCurrentRowCount-iMoreRow; i++){
newTBody.appendChild(tempRows[i]);
}
this.__oTable__.appendChild(newTBody);
this.__dataRows__ = tempRows;
this.__oTBody__ = newTBody;
//页脚显示分
var divFood = document.getElementById("divFood");//分页工具栏
divFood.innerHTML="";
var rightBar = document.createElement("divFood");
rightBar.setAttribute("display","");
rightBar.setAttribute("float","left");
rightBar.innerHTML="第"+(this.pageIndex+1)+"页/共"+this.pageCount+"页";
var isOK="Y";
var cssColor="";
divFood.appendChild(rightBar);
////页脚显示分页结
};
/**//*
克隆原始操作行集合
*/
Page.prototype.__cloneRows__ = function(){
var tempRows = [];
for(var i=0; i<this.__dataRows__.length; i++){
tempRows[i] = this.__dataRows__[i].cloneNode(1);
}
return tempRows;
};
</script>
<script type="text/javascript" language="javascript">
window.onload = function(){
page = new Page(3,'senfe','group_one'); };
</script>
<script language="javascript"><!--
function senfe(o,a,b,c,d){
var t=document.getElementById(o).getElementsByTagName("tr");
for(var i=0;i<t.length;i++){
t[i].style.backgroundColor=(t[i].sectionRowIndex%2==0)?a:b;
}
}
--></script>
<style type="text/css"><!--
#senfe {
border-top: #000 1px solid;
border-left: #000 1px solid;
}
#senfe td {
border-right: #000 1px solid;
border-bottom: #000 1px solid;
}
--></style>
<style>

body{
	margin:0;
	padding:0;
	
	font:70% Arial, Helvetica, sans-serif; 
	color:#555;
	line-height:150%;
	text-align:left;
}
a{
	text-decoration:none;
	color:#057fac;
}
a:hover{
	text-decoration:none;
	color:#999;
}
h1{
	font-size:140%;
	margin:0 20px;
	line-height:80px;	
}
h2{
	font-size:120%;
}

form{
	margin:1em 0;
	padding:.2em 20px;
	background:#eee;
}
</style>

</head>
<body>
<div>
<table  cellpadding="0" cellspacing="0" id="senfe" align="center">
<thead>
<tr>

<td><select name="select" dir="ltr" onchange="selected(this)">
<option>编号排序</option>
<option value="reviewNewsListServlet">增序</option>
<option value="reviewNewsListServletdel">降序</option>
</select></td>
<th>新闻标题</th>
<th>新闻内容</th>
<th>发布时间</th>
<th>发布人</th>
<th>新闻类别</th>
<th>审核状态</th>
<th></th>
</tr>
</thead>
<tbody id="group_one">
<%ArrayList<News> news= (ArrayList)session.getAttribute("newslistz");%>
<%ClassesDaoImpl clas= (ClassesDaoImpl)session.getAttribute("cladao");%>
<%for(int i=0;i<news.size();i++){%>  
<tr>
<th><%=news.get(i).getNewsid() %> </th>
<td><%=news.get(i).getTitle() %></td>
<td><%=news.get(i).getContent() %> </td>
<td><%=news.get(i).getPbTime() %> </td>
<td><%=news.get(i).getPbperson() %> </td>

<td><%=clas.SearchById(news.get(i).getClassid()).getClassName() %></td>

<td><%=news.get(i).getState() %> </td>
<td><a href="ReviewSearchById?newsId=<%=news.get(i).getNewsid()%>">审核</a></td>
</tr>
<%}%>
</tbody>
</table>

</div>
<div align="center"><a href=' Javascript: void(0)' onclick="page.firstPage();">首 页</a>/<a href=' Javascript: void(0)' onclick="page.nextPage();">下一页</a>/<a href=' Javascript: void(0)' onclick="page.prePage();">上一页</a>/<a href=' Javascript: void(0)' onclick="page.lastPage();">末 页</a><span id="divFood">
</span>
/第
<input id="pageno" value="1" style="width:20px"/>页/<a href=' Javascript: void(0)' onclick="page.aimPage();">跳转</a>
</div>
</body>
</html>
