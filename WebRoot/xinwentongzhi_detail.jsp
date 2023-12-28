<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>新闻通知详细</title>


  </head>

  <body >

  新闻通知详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>标题：</td><td width='39%'>${xinwentongzhi.biaoti}</td><td  rowspan=4 align=center><a href=${xinwentongzhi.biaoti} target=_blank><img src=${xinwentongzhi.biaoti} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>类别：</td><td width='39%'>${xinwentongzhi.leibie}</td></tr><tr><td width='11%' height=44>点击率：</td><td width='39%'>${xinwentongzhi.dianjilv}</td></tr><tr><td width='11%' height=44>添加人：</td><td width='39%'>${xinwentongzhi.tianjiaren}</td></tr><tr><td width='11%' height=100  >内容：</td><td width='39%' colspan=2 height=100 >${xinwentongzhi.neirong}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

