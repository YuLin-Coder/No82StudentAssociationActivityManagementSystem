<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>申请入团详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  申请入团详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>社团编号：</td><td width='39%'>${shenqingrutuan.shetuanbianhao}</td>     <td width='11%'>社团名称：</td><td width='39%'>${shenqingrutuan.shetuanmingcheng}</td></tr><tr>     <td width='11%'>学号：</td><td width='39%'>${shenqingrutuan.xuehao}</td>     <td width='11%'>姓名：</td><td width='39%'>${shenqingrutuan.xingming}</td></tr><tr>     <td width='11%'>院系：</td><td width='39%'>${shenqingrutuan.yuanxi}</td>     <td width='11%'>班级：</td><td width='39%'>${shenqingrutuan.banji}</td></tr><tr>     <td width='11%'>电话：</td><td width='39%'>${shenqingrutuan.dianhua}</td>     <td width='11%'>申请理由：</td><td width='39%'>${shenqingrutuan.shenqingliyou}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

