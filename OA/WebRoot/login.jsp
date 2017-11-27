<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml"  lang="en-US">

<head>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK 
href="images/public.css" type=text/css rel=stylesheet>
<LINK 
href="images/login.css" type=text/css rel=stylesheet>
<STYLE type=text/css>
</STYLE>
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>


</style>
<script language="javascript">
function onsubmit1(){
	if(document.getElementById("loginName").value==''){
		document.getElementById("divMsg").innerHTML="请输入用户名！";
		return false;
	}
	if(document.getElementById("loginPwd").value==''){
		document.getElementById("divMsg").innerHTML="请输入密码！";
		return false;
	}
	form1.submit();
}
function onreset1(){
	document.getElementById("loginName").value='';
	document.getElementById("loginPwd").value='';
	document.getElementById("divMsg").innerHTML='';
	return true;
}
</script>
</head>


<BODY>
<form id="form1" name="form1" action="loginServlet" method="get">
<DIV id=div1>
  <TABLE id=login height="100%" cellSpacing=0 cellPadding=0 width=800 
align=center>
    <TBODY>
      <TR id=main>
        <TD>
          <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%">
            <TBODY>
              <TR>
                <TD colSpan=4>&nbsp;</TD>
              </TR>
              <TR height=30>
                <TD width=380>&nbsp;</TD>
                <TD>&nbsp;</TD>
                <TD><div id="divMsg" style="color:red; font-size:12px;"></div>&nbsp;</TD>
                <TD>&nbsp;</TD>
              </TR>
              <TR height=40>
                <TD rowSpan=4>&nbsp;</TD>
                <TD>用户名：</TD>
                <TD>
                  <INPUT class=textbox id="loginName" name="loginName">
                </TD>
                <TD width=120>&nbsp;</TD>
              </TR>
              <TR height=40>
                <TD>密　码：</TD>
                <TD>
                  <INPUT class=textbox id="loginPwd" name="loginPwd" type=password>
      
                </TD>
                <TD width=120>&nbsp;</TD>
              </TR>
              
              <TR height=40>
                <TD></TD>
                <TD align=right> 

<a href="javascript:void(0);" onclick="onreset1();"><img src="${pageContext.request.contextPath}/images/reset.gif" border="0" height="20" width="57"></a>
             <a href="javascript:void(0);" onclick="onsubmit1();"><img src="${pageContext.request.contextPath}/images/login.gif" border="0" height="20" width="57"></a>
                </TD>
                <TD width=120>&nbsp;</TD>
              </TR>
              <TR height=110>
                <TD colSpan=4>&nbsp;</TD>
              </TR>
            </TBODY>
          </TABLE>
        </TD>
      </TR>
      <TR id=root height=104>
        <TD>&nbsp;</TD>
      </TR>
    </TBODY>
  </TABLE>
</DIV>
</form>
<DIV id=div2 style="DISPLAY: none"></DIV>
</CONTENTTEMPLATE>
</BODY>
</HTML>