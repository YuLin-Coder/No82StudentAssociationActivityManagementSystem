<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>学生信息详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  学生信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>学号：</td><td width='39%'>${xueshengxinxi.xuehao}</td><td  rowspan=9 align=center><a href=${xueshengxinxi.zhaopian} target=_blank><img src=${xueshengxinxi.zhaopian} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>密码：</td><td width='39%'>${xueshengxinxi.mima}</td></tr><tr><td width='11%' height=44>姓名：</td><td width='39%'>${xueshengxinxi.xingming}</td></tr><tr><td width='11%' height=44>性别：</td><td width='39%'>${xueshengxinxi.xingbie}</td></tr><tr><td width='11%' height=44>院系：</td><td width='39%'>${xueshengxinxi.yuanxi}</td></tr><tr><td width='11%' height=44>班级：</td><td width='39%'>${xueshengxinxi.banji}</td></tr><tr><td width='11%' height=44>电话：</td><td width='39%'>${xueshengxinxi.dianhua}</td></tr><tr><td width='11%' height=44>身份证：</td><td width='39%'>${xueshengxinxi.shenfenzheng}</td></tr><tr><td width='11%' height=44>地址：</td><td width='39%'>${xueshengxinxi.dizhi}</td></tr><tr><td width='11%' height=100  >个人简介：</td><td width='39%' colspan=2 height=100 >${xueshengxinxi.gerenjianjie}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

