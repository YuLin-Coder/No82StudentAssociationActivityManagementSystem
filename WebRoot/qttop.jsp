<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db" />
<div class="itop">
	<div class="itopc">
		<div class="itopcl">
			<span>欢迎来到四川农业大学学生社团联合会!</span>
		</div>
		<div class="itopcr">
			<div align="right">
				<%
				if ((String) request.getSession().getAttribute("username") == null
						|| (String) request.getSession().getAttribute("username") == "") {
				%>
				<a href="userlog.jsp">用户登陆</a><span>|</span><a href="userreg.jsp">用户注册</a>
				<%
				} else {
				%>
				当前用户:<%=request.getSession().getAttribute("username")%>,权限:<%=request.getSession().getAttribute("cx")%>;&nbsp;&nbsp;
				<a href="logout.jsp">退出</a><span>|</span><a href="main.jsp">个人后台</a>
				<%
				}
				%>
			</div>
		</div>
	</div>
</div>
<div class="ilogo">
	<div class="ilogoc">
		<div class="ilogol">
			<img src="qtimages/timg.jpg" width="70" height="65" />
			<p>
				<strong>四川农业大学学生社团联合会</strong><br> <span>追求真理、造福社会、自强不息</span>
			</p>
		</div>
		<div class="ilogor">
			<p>
				川农大社联咨询电话：<br> <strong>0835-XXXXXXX</strong>
			</p>
		</div>
		<div class="clear"></div>
	</div>
</div>
<div id='hsgbanner'>
	<div class='navgrp'>
		<ul class='nav' id='nav'>
			<li class='cur'><a href='index.do'>网站首页</a></li>
			<li><a onclick="change_bg(this)" href='xsxxListtp.do'>学生信息</a></li>
			<li><a href='xueshengxinxiadd.jsp'>学生注册</a></li>
			<li><a href='stxxListtp.do'>社团信息</a></li>
			<li><a href='sthdList.do'>社团活动</a></li>

			<li><a style='cursor: pointer'>新闻信息</a>
				<div id='navChild'>
					<a href='xwtzList.do?lb=校内新闻'>校内新闻</a>
				</div></li>
			<li><a style='cursor: pointer'>系统概要</a>
				<div id='navChild'>
					<a href='dx_detail.jsp?lb=关于我们'>关于我们</a>
				</div></li>
			<li><a style='cursor: pointer'>在线留言</a>
				<div id='navChild'>
					<a href='lyb.jsp'>在线留言</a> <a href='lybList.do'>查看留言</a>
				</div></li>
			<!--yoxulixuyaxn-->
			<li><a href='login.jsp'>后台管理</a></li>
		</ul>
	</div>
</div>