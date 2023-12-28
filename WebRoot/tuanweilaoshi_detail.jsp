<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>团委老师详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  团委老师详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>编号：</td><td width='39%'>${tuanweilaoshi.bianhao}</td>     <td width='11%'>密码：</td><td width='39%'>${tuanweilaoshi.mima}</td></tr><tr>     <td width='11%'>姓名：</td><td width='39%'>${tuanweilaoshi.xingming}</td>     <td width='11%'>性别：</td><td width='39%'>${tuanweilaoshi.xingbie}</td></tr><tr>     <td width='11%'>联系电话：</td><td width='39%'>${tuanweilaoshi.lianxidianhua}</td>     <td width='11%'>简介：</td><td width='39%'>${tuanweilaoshi.jianjie}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

