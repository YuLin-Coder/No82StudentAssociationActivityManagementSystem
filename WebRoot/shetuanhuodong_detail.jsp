<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>社团活动详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  社团活动详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>活动名称：</td><td width='39%'>${shetuanhuodong.huodongmingcheng}</td>     <td width='11%'>活动时间：</td><td width='39%'>${shetuanhuodong.huodongshijian}</td></tr><tr>     <td width='11%'>社团编号：</td><td width='39%'>${shetuanhuodong.shetuanbianhao}</td>     <td width='11%'>社团名称：</td><td width='39%'>${shetuanhuodong.shetuanmingcheng}</td></tr><tr>     <td width='11%'>活动简介：</td><td width='39%'>${shetuanhuodong.huodongjianjie}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

