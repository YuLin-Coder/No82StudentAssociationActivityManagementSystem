<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="shenqingrutuanhsgb" scope="page" class="com.bean.ShenqingrutuanBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=shenqingrutuan.xls");
%>
<html>
  <head>
    <title>申请入团</title>
  </head>

  <body >
 <%
			String sql="select * from shenqingrutuan  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>社团编号</td>    <td align='center' bgcolor='#ebf0f7'>社团名称</td>    <td align='center' bgcolor='#ebf0f7'>学号</td>    <td align='center' bgcolor='#ebf0f7'>姓名</td>    <td align='center' bgcolor='#ebf0f7'>院系</td>    <td align='center' bgcolor='#ebf0f7'>班级</td>    <td align='center' bgcolor='#ebf0f7'>电话</td>        <td  width='80' align='center' bgcolor='#ebf0f7'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=shenqingrutuanhsgb.getAllShenqingrutuan(11);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.shetuanbianhao}</td>    <td>${u.shetuanmingcheng}</td>    <td>${u.xuehao}</td>    <td>${u.xingming}</td>    <td>${u.yuanxi}</td>    <td>${u.banji}</td>    <td>${u.dianhua}</td>        <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=shenqingrutuan'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

