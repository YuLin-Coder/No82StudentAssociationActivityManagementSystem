<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>社团信息详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  社团信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>社团编号：</td><td width='39%'>${shetuanxinxi.shetuanbianhao}</td><td  rowspan=7 align=center><a href=${shetuanxinxi.shetuanLOGO} target=_blank><img src=${shetuanxinxi.shetuanLOGO} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>密码：</td><td width='39%'>${shetuanxinxi.mima}</td></tr><tr><td width='11%' height=44>社团名称：</td><td width='39%'>${shetuanxinxi.shetuanmingcheng}</td></tr><tr><td width='11%' height=44>负责人：</td><td width='39%'>${shetuanxinxi.fuzeren}</td></tr><tr><td width='11%' height=44>联系电话：</td><td width='39%'>${shetuanxinxi.lianxidianhua}</td></tr><tr><td width='11%' height=44>社团人数：</td><td width='39%'>${shetuanxinxi.shetuanrenshu}</td></tr><tr><td width='11%' height=44>社团等级：</td><td width='39%'>${shetuanxinxi.shetuandengji}</td></tr><tr><td width='11%' height=100  >社团简介：</td><td width='39%' colspan=2 height=100 >${shetuanxinxi.shetuanjianjie}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

