<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.util.db"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>川农学生社团管理系统网站首页</title>
<link rel="stylesheet" type="text/css" href="qtimages/css/fxke.css" />
<link rel="stylesheet" href="qtimages/hsgbanner.css">
<script type="text/javascript" src="qtimages/jquery.js"></script>
<script type="text/javascript" src="qtimages/inc.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<jsp:include page="qttop.jsp"></jsp:include>
	<jsp:include page="bht.jsp"></jsp:include>
	<div class="spgy">
		<div class="sspzx">
			<div class="sspzx1">
				<strong class="bt1">视频中心</strong><span class="bt2">Video
					Introduction</span>
			</div>
			<div class="sspzx2">
				<video src="movie.ogg" controls="controls"> 您的浏览器不支持 video
				标签。 </video>
			</div>
		</div>
		<div class="gywm">
			<div class="gywm1">
				<strong class="bt1">关于我们</strong><span class="bt2">About Us</span><a
					class="gd" href="dx_detail.jsp?lb=关于我们" target="_blank">更多&gt;&gt;</a>
			</div>
			<div class="gywm2">
				<img src="qtimages/damen.png" width="244" height="240" />
				<h2>四川农业大学学生社团联合会</h2>
				<p>
					<%=connDbBean.ensubStr(connDbBean.readzd("dx", "content", "leibie", "关于我们"), 185)%>
					<a href="" target="_blank">[详情]</a>
				</p>
				<div style="clear: both;"></div>
			</div>
		</div>
		<div style="clear: both;"></div>
	</div>
	<div class='jfcp'>
		<div class='jfcpright fr'>
			<div class='tjcp_title'>
				<div class='tjcpleft'>
					<p>
						Hot Products<br /> <span>社团推荐</span>
					</p>
				</div>
				<a href='stxxList.do'><img src='qtimages/tongtai_15-05.gif'
					width='59' height='20' /></a>
			</div>
			<div class='tjcp_nr'>
				<c:forEach items="${syshetuanxinxi}" var="a">
					<div class='cpalt'>
						<a href="stxxDetail.do?id=${a.id}"><img src="${a.shetuanLOGO}"
							width='226' height='151' /></a> <a href="stxxDetail.do?id=${a.id}">${a.shetuanmingcheng}</a>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class='clear'></div>
	</div>

	<div class="fxgg"></div>

	<div class='jfcp'>
		<div class='jfcpright fr'>
			<div class='tjcp_title'>
				<div class='tjcpleft'>
					<p>
						Hot Products<br /> <span>会员风彩</span>
					</p>
				</div>
				<a href='yhzcList.do'><img src='qtimages/tongtai_15-05.gif'
					width='59' height='20' /></a>
			</div>
		</div>
		<div class='clear'></div>
	</div>
	<div class='bghj'>
		<div class='bghjc'>
			<div class='bghj_nr'>
				<div class='xian' id='Setl1'>
					<c:forEach items="${syyonghuzhuce1}" var="b">
						<div class='bgal'>
							<a href="yhzcDetail.do?id=${b.id}"><img src='${b.touxiang}'
								width='230' height='163' /></a><br /> ${b.xingming}
						</div>
					</c:forEach>
					<div class='clear'></div>
				</div>
			</div>
		</div>
	</div>

	<div class="jxwzx">
		<div class="jnews fl">
			<div class="jnews_title">
				<ul>
					<li style="border-right: 1px solid #d6d6d6;" id="lm1"
						onmousemove="setTabb(1)" class="selectTab4"><a href="#"><strong>校内新闻</strong><span>COMPANY
								NEWS</span></a></li>
					<li id="lm2" onmousemove="setTabb(2)"><a href="#"><strong>站内新闻2</strong><span>TECHNIQUE
								SUPPORT</span></a></li>
				</ul>
			</div>
			<div class="jnews_nr">
				<div class="newsxian" id="Setln1">
					<div class="newsc">
						<div class="newss_list">
							<ul>
								<c:forEach items="${syxinwentongzhi1 }" var="a">
									<li><a href="xwtzDetail.do?id=${a.id}">${fn:substring(a.biaoti, 0, 24)}</a><span>${fn:substring(a.addtime, 0, 10)}</span></li>
								</c:forEach>

							</ul>
						</div>
					</div>
				</div>
				<div class="newsyin" id="Setln2">
					<div class="newsc">

						<div class="newss_list">
							<ul>
								<c:forEach items="${syxinwentongzhi2 }" var="a">
									<li><a href="xwtzDetail.do?id=${a.id}">${fn:substring(a.biaoti, 0, 24)}</a><span>${fn:substring(a.addtime, 0, 10)}</span></li>
								</c:forEach>

							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script src="js/sy.js" type="text/javascript"></script>
		<div class="jlxwm fr">
			<div class="jlxwm1">
				<strong class="bt1">联系我们</strong><span class="bt2">Contact Us</span><a
					class="gd" href="dx_detail.jsp?lb=联系我们">更多&gt;&gt;</a>
			</div>
			<div class="slxwmc">
				<div class="dianhua">
					川农大社联电话：<br> <span style="font-size: 20px;">0835-XXXXXXX</span>
				</div>
				<p>
					<strong>四川农业大学学生社团联合会</strong><br /> 电子邮箱：xxxxxx@126.com<br />
					办事处电话：0991-xxxxxx<br /> 地址：xxxxxxxxxxxxxxxx号
				</p>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<jsp:include page="qtdown.jsp"></jsp:include>
</body>
</html>