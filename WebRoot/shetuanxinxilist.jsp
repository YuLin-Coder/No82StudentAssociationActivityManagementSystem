<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>社团信息</title>

<link rel="stylesheet" type="text/css" href="qtimages/css/fxke.css"/>
<link rel="stylesheet" href="qtimages/hsgbanner.css">
<script type="text/javascript" src="qtimages/jquery.js"></script>
<script type="text/javascript" src="qtimages/inc.js"></script>
</head>
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
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>

<%

%>

<!--新头部的开始-->

<jsp:include page="qttop.jsp"></jsp:include>
<!--新头部的结束--> <!--产品中心ban开始-->
<div class="cpzxban"></div>

<!--产品中心ban结束-->

<!--主体内容的开始-->
<div class="fxmain">
  <!--顶部类别开始-->
  <div class="fx_fenlei">
     <div class="leibei fl">
       <ul>
         <li><a class="diyi" >社团信息</a></li>
         <!--<li><a href="#">行业动态</a></li>
         <li><a href="#">保养常识</a></li>
         <li><a href="#">技术支持</a></li>-->
       </ul>
     </div>
     <div class="dqwz fr">
     当前位置：<a href="index.do">网站首页</a> &gt; 社团信息     </div> 
  </div>
  <!--顶部类别结束-->
  <!--详细内容的开始-->
  <div class="fxmain_nr">
   
  			<link rel="stylesheet" href="images/hsgcommon/divqt.css" type="text/css">    
<form action="stxxList.do" name="myform" method="post" style="width:100%">
									查询   社团编号：<input name="shetuanbianhao" type="text" id="shetuanbianhao" class="form-control2" />  社团名称：<input name="shetuanmingcheng" type="text" id="shetuanmingcheng" class="form-control2" />  社团等级：<input name="shetuandengji" type="text" id="shetuandengji" class="form-control2" />
									<input type="submit" value="查询" /> <input type="button" name="Submit2" value="切换视图"  onClick="javascript:location.href='stxxListtp.do';" />
								</form>	

	
<br />
<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td bgcolor='#ebf0f7'>社团编号</td>    <td bgcolor='#ebf0f7'>密码</td>    <td bgcolor='#ebf0f7'>社团名称</td>    <td bgcolor='#ebf0f7'>负责人</td>    <td bgcolor='#ebf0f7' width='90' align='center'>社团LOGO</td>    <td bgcolor='#ebf0f7'>联系电话</td>    <td bgcolor='#ebf0f7'>社团人数</td>    <td bgcolor='#ebf0f7'>社团等级</td>        
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="50px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list}" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.shetuanbianhao}</td>    <td>${u.mima}</td>    <td>${u.shetuanmingcheng}</td>    <td>${u.fuzeren}</td>    <td width='90'><a href='${u.shetuanLOGO}' target='_blank'><img src='${u.shetuanLOGO}' width=88 height=99 border=0 /></a></td>    <td>${u.lianxidianhua}</td>    <td>${u.shetuanrenshu}</td>    <td>${u.shetuandengji}</td>        
                              <td align="center"> ${u.addtime} </td>
                              <td align="center"><a href="stxxDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table>
<br>

<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="stxxList.do?page=1" >首页</a>
             <a href="stxxList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="stxxList.do?page=${page.page+1 }">下一页</a>
			<a href="stxxList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>




					  
  </div>
  
  <!--详细内容的结束-->
  
</div>

<!--主体内容的结束-->





<!--底部的开始-->
<jsp:include page="qtdown.jsp"></jsp:include>
<!--底部的结束-->

</body>
</html>
