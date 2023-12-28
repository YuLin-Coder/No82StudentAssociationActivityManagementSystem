<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="youqinglianjiehsgb" scope="page" class="com.bean.YouqinglianjieBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=youqinglianjie.xls");
%>
<html>
  <head>
    <title>友情连接</title>
  </head>

  <body >
 <%
			String sql="select * from youqinglianjie  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>网站名称</td>    <td align='center'>网址</td>    <td  width='90' align='center'>LOGO</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=youqinglianjiehsgb.getAllYouqinglianjie(5);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.wangzhanmingcheng}</td>    <td>${u.wangzhi}</td>    <td width='90' align='center'><a href='${u.LOGO}' target='_blank'><img src='${u.LOGO}' width=88 height=99 border=0 /></a></td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

