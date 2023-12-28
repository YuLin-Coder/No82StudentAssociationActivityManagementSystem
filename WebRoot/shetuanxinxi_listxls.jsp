<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="shetuanxinxihsgb" scope="page" class="com.bean.ShetuanxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=shetuanxinxi.xls");
%>
<html>
  <head>
    <title>社团信息</title>
  </head>

  <body >
 <%
			String sql="select * from shetuanxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>社团编号</td>    <td align='center' bgcolor='#ebf0f7'>密码</td>    <td align='center' bgcolor='#ebf0f7'>社团名称</td>    <td align='center' bgcolor='#ebf0f7'>负责人</td>    <td  width='90' align='center' bgcolor='#ebf0f7'>社团LOGO</td>    <td align='center' bgcolor='#ebf0f7'>联系电话</td>    <td align='center' bgcolor='#ebf0f7'>社团人数</td>    <td align='center' bgcolor='#ebf0f7'>社团等级</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=shetuanxinxihsgb.getAllShetuanxinxi(11);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.shetuanbianhao}</td>    <td>${u.mima}</td>    <td>${u.shetuanmingcheng}</td>    <td>${u.fuzeren}</td>    <td width='90' align='center' bgcolor='#ebf0f7'><a href='${u.shetuanLOGO}' target='_blank'><img src='${u.shetuanLOGO}' width=88 height=99 border=0 /></a></td>    <td>${u.lianxidianhua}</td>    <td>${u.shetuanrenshu}</td>    <td>${u.shetuandengji}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

