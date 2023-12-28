<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

 <%
  String id=request.getParameter("id");
  connDbBean.hsgexecute("update xinwentongzhi set dianjilv=dianjilv+1 where id="+id);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>内容详细</title>
<link rel="stylesheet" type="text/css" href="qtimages/css/fxke.css"/>
<link rel="stylesheet" href="qtimages/hsgbanner.css">
<script type="text/javascript" src="qtimages/jquery.js"></script>
<script type="text/javascript" src="qtimages/inc.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<style type="text/css">
<!--
.STYLE2 {
	font-size: 20px;
	font-weight: bold;
	color: #078548;
}
-->
</style>
<body>
<jsp:include page="qttop.jsp"></jsp:include>
<div class="cpzxban"></div>
<div class="fxmain">
  <div class="fx_fenlei">
     <div class="leibei fl">
       <ul>
         <li><a class="diyi" >内容详细</a></li>
       </ul>
     </div>
     <div class="dqwz fr">
     当前位置：<a href="index.do">网站首页</a> &gt; 内容详细     </div> 
  </div>
  <div class="fxmain_nr">
   
  			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#FA8A89" class="newsline" style="border-collapse:collapse">
                          <tr>
                            <td height="46" align="center" class="STYLE2">${xinwentongzhi.biaoti} (被访问${xinwentongzhi.dianjilv }次) </td>
                          </tr>
                          <tr>
                            <td height="110" align="left">${xinwentongzhi.neirong }</td>
                          </tr>
                          <tr>
                            <td height="33" align="right"><input type="button" name="Submit5" value="返回" onClick="javascript:history.back();" ></td>
                          </tr>
                        </table>
					  
  </div>
</div>
<jsp:include page="qtdown.jsp"></jsp:include>
</body>
</html>