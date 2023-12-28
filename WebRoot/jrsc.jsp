<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<%@ page isELIgnored="false" %> 

 <%
  if((String)request.getSession().getAttribute("username")==null || (String)request.getSession().getAttribute("username")=="")
{
	out.print("<script>javascript:alert('对不起，请您先登陆！');history.back();</script>");
	
}
else
{
String id=request.getParameter("id");
String biao=request.getParameter("biao");
String ziduan=request.getParameter("ziduan");
String biaoj=request.getParameter("biaoj");
String sql="insert into shoucangjilu(username,xwid,ziduan,biao,biaoj) values('"+request.getSession().getAttribute("username")+"','"+id+"','"+ziduan+"','"+biao+"','"+biaoj+"')";
connDbBean.hsgexecute(sql);
out.print("<script>alert('收藏成功!!');location.href='"+request.getHeader("Referer")+"';</script>");
}
%>
