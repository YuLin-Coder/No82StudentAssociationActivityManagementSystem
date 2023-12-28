<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'adminyanzheng.jsp' starting page</title>
    

  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
  
  <body>
  <%
 

String id=request.getParameter("id");
String biao=request.getParameter("biao");

String sql="update "+biao+" set iszf='是' where id="+id+"";
  	  	
connDbBean.hsgexecute(sql);
out.print("<script>alert('支付成功!!');location.href='sy.jsp';</script>");
  	  


 %>
  </body>
</html>

