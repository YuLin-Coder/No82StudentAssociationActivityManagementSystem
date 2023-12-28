<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db" />

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"
	charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>学生信息</title>

<link rel="stylesheet" type="text/css" href="qtimages/css/fxke.css" />
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

	<%

%>

	<!--新头部的开始-->

	<jsp:include page="qttop.jsp"></jsp:include>
	<!--新头部的结束-->
	<!--产品中心ban开始-->
	<div class="cpzxban"></div>

	<!--产品中心ban结束-->

	<!--主体内容的开始-->
	<div class="fxmain">
		<!--顶部类别开始-->
		<div class="fx_fenlei">
			<div class="leibei fl">
				<ul>
					<li><a class="diyi">学生信息</a></li>
					<!--<li><a href="#">行业动态</a></li>
         <li><a href="#">保养常识</a></li>
         <li><a href="#">技术支持</a></li>-->
				</ul>
			</div>
			<div class="dqwz fr">
				当前位置：<a href="index.do">网站首页</a> &gt; 学生信息
			</div>
		</div>
		<!--顶部类别结束-->
		<!--详细内容的开始-->
		<div class="fxmain_nr">

			<link rel="stylesheet" href="images/hsgcommon/divqt.css"
				type="text/css">
			<form action="xsxxListtp.do" name="myform" method="post"
				style="width: 100%">
				查询 学号：<input name="xuehao" type="text" id="xuehao"
					class="form-control2" /> 姓名：<input name="xingming" type="text"
					id="xingming" class="form-control2" /> 性别：<select name='xingbie'
					id='xingbie' class="form-control2"><option value="">所有</option>
					<option value="男">男</option>
					<option value="女">女</option></select> 院系：<input name="yuanxi" type="text"
					id="yuanxi" class="form-control2" /> 班级：<input name="banji"
					type="text" id="banji" class="form-control2" /> 电话：<input
					name="dianhua" type="text" id="dianhua" class="form-control2" />
				身份证：<input name="shenfenzheng" type="text" id="shenfenzheng"
					class="form-control2" /> 地址：<input name="dizhi" type="text"
					id="dizhi" class="form-control2" /> <input type="submit"
					value="查询" />
			</form>
			<br />

			<table width="100%" height="12%" border="0" align="center"
				cellpadding="0" cellspacing="0">
				<tr>
					<%
					int i=0;
				%>
					<c:forEach items="${list}" var="u">
						<%
					i++;
				%>
						<td height="316" align="center"><table width="225"
								height="285" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td height="250" align="center"><a
										href="xsxxDetail.do?id=${u.id}"><img src="${u.zhaopian}"
											width="210" height="250" border="0" /></a></td>
								</tr>
								<tr>
									<td height="26" align="center">${u.xingming}</td>
								</tr>
							</table></td>
						<%
								if (i==4)
								{
									i=0;
									out.print("</tr><tr>");
								}
				  	
					
				  %>
					</c:forEach>


				</tr>
			</table>
			<br>

			<p align="center">
				<c:if test="${sessionScope.p==1}">
					<c:if test="${page.page>1}">
						<a href="xsxxListtp.do?page=1">首页</a>
						<a href="xsxxListtp.do?page=${page.page-1}"> 上一页</a>
					</c:if>
					<c:if test="${page.page<page.totalPage}">
						<a href="xsxxListtp.do?page=${page.page+1}">下一页</a>
						<a href="xsxxListtp.do?page=${page.totalPage}">末页</a>
					</c:if>
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
