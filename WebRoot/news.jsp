<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

 <%
  String lb=request.getParameter("lb");
  //String lb=new String(request.getParameter("lb").getBytes("8859_1"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><%=lb%></title>
<link rel="stylesheet" type="text/css" href="qtimages/css/fxke.css"/>
<link rel="stylesheet" href="qtimages/hsgbanner.css">
<script type="text/javascript" src="qtimages/jquery.js"></script>
<script type="text/javascript" src="qtimages/inc.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>

<body>
<jsp:include page="qttop.jsp"></jsp:include>
<div class="newsban"></div>
<div class="fxmain">
  <div class="fx_fenlei">
     <div class="leibei fl">
       <ul>
         <li><a class="diyi" ><%=lb%></a></li>
       </ul>
     </div>
     <div class="dqwz fr">
     当前位置：<a href="index.do">网站首页</a> &gt; <%=lb%>     </div> 
  </div>
  <div class="fxmain_nr">
   
  			 <table width="98%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#FA9090" class="newsline" style="border-collapse:collapse">
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                          <tr>
                            <td width="29" height="40" align="center"><%=i %></td>
                            <td width="428"><a href="xwtzDetail.do?id=${u.id}">${u.biaoti}</a></td>
                            <td width="74">被点${u.dianjilv}次</td>
                            <td width="146" align="center">${u.addtime}</td>
                          </tr>
                         </c:forEach>
                        </table>
                          <div align="center"><br>
                           <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="xwtzList.do?page=1&lb=<%=lb%>" >首页</a>
             <a href="xwtzList.do?page=${page.page-1}&lb=<%=lb%>"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="xwtzList.do?page=${page.page+1}&lb=<%=lb%>">下一页</a>
			<a href="xwtzList.do?page=${page.totalPage}&lb=<%=lb%>">末页</a>		    </c:if>		
	</c:if>
	</div>
					  
  </div>
</div>
<jsp:include page="qtdown.jsp"></jsp:include>
</body>
</html>