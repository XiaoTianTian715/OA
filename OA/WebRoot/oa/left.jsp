<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<STYLE type=text/css> 
{
	FONT-SIZE: 12px
}
#menuTree A {
	COLOR: #566984; TEXT-DECORATION: none
}
</STYLE>
<SCRIPT src="Left.files/TreeNode.js" type=text/javascript></SCRIPT>
<SCRIPT src="Left.files/Tree.js" type=text/javascript></SCRIPT>
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
</HEAD>
<BODY 
style="BACKGROUND-POSITION-Y: -120px; BACKGROUND-IMAGE: url(../images/bg.gif); BACKGROUND-REPEAT: repeat-x">
<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%">
  <TBODY>
    <TR>
      <TD width=10 height=29><IMG src="Left.files/bg_left_tl.gif"></TD>
      <TD 
    style="FONT-SIZE: 18px; BACKGROUND-IMAGE: url(../images/bg_left_tc.gif); COLOR: white; FONT-FAMILY: system">主菜单</TD>
      <TD width=10><IMG src="Left.files/bg_left_tr.gif"></TD>
    </TR>
    <TR>
      <TD style="BACKGROUND-IMAGE: url(../images/bg_left_ls.gif)"></TD>
      <TD id=menuTree 
    style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; PADDING-BOTTOM: 10px; PADDING-TOP: 10px; HEIGHT: 100%; BACKGROUND-COLOR: white" 
    vAlign=top></TD>
      <TD style="BACKGROUND-IMAGE: url(../images/bg_left_rs.gif)"></TD>
    </TR>
    <TR>
      <TD width=10><IMG src="Left.files/bg_left_bl.gif"></TD>
      <TD style="BACKGROUND-IMAGE: url(../images/bg_left_bc.gif)"></TD>
      <TD width=10><IMG 
src="Left.files/bg_left_br.gif"></TD>
    </TR>
  </TBODY>
</TABLE>
<SCRIPT type=text/javascript>
var tree = null;var root = new TreeNode('系统菜单');var fun1 = new TreeNode('用戶管理');var fun2 = new TreeNode('用戶列表', 'userListServlet', 'tree_node.gif', null, 'tree_node.gif', null);fun1.add(fun2);root.add(fun1);var fun5 = new TreeNode('新闻类别管理');var fun6 = new TreeNode('新聞類別', 'newsTypeListServlet', 'tree_node.gif', null, 'tree_node.gif', null);fun5.add(fun6);root.add(fun5);var fun9 = new TreeNode('新聞管理');var fun10 = new TreeNode('全部新聞', 'newsListServlet', 'tree_node.gif', null, 'tree_node.gif', null);fun9.add(fun10);var fun11 = new TreeNode('待審核列表', 'reviewNewsListServlet', 'tree_node.gif', null, 'tree_node.gif', null);fun9.add(fun11);var fun12 = new TreeNode('新聞列表', 'releaseNewsListServlet', 'tree_node.gif', null, 'tree_node.gif', null);fun9.add(fun12);root.add(fun9);var fun13 = new TreeNode('菜單管理');var fun14 = new TreeNode('菜單列表', 'menuListServlet', 'tree_node.gif', null, 'tree_node.gif', null);fun13.add(fun14);root.add(fun13);tree = new Tree(root);tree.show('menuTree')
</SCRIPT>
</BODY>
</HTML>
