<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<div class="jdbj">
  <div class="syqlj">
    <div class="scp1" style="width:1000px;"><strong class="bt1">友情链接</strong><span class="bt2">LINKS</span></div>
    <div class="yqljs"> 
	 <%
			String sqlyqlj="select  * from youqinglianjie   order by id desc limit 0,5";
			ResultSet RS_resultyqlj=connDbBean.executeQuery(sqlyqlj);
while(RS_resultyqlj.next())
{
		%>
	<a target="_blank" href="<%=RS_resultyqlj.getString("wangzhi")%>"><%=RS_resultyqlj.getString("wangzhanmingcheng")%></a>
	   <%
								  }
								  %>
	
      <div style="clear:both;"></div>
    </div>
  </div>
</div>
<div class="footWrap">
  <div class="footer_nav">
    <div class="fnavc"> <a href="#">网站首页</a> <a href="#" target="_blank">社联介绍</a> <a href="#" target="_blank">活动中心</a> <a href="#" target="_blank">新闻中心</a> <a href="#" target="_blank">社联历史</a> <a  href="#" target="_blank">联系我们</a> </div>
  </div>
  <div class="hbfooter">
    <div class="hbbottom">
      <div class="hbtmleft">
        <p>版权所有:LRH<br />
          联系方式：Q74999XXXX <br />
          学校地址：四川省雅安市    技术支持：<a href="http://www.xxxxxxx.com" target="_blank">四川农业大学信息工程学院</a> </p>
      </div>
      <div class="hbtmright"> <img src="qtimages/jianguan.png" width="88" height="88" /> <br />
        工商网监 </div>
      <div class="clear"></div>
    </div>
  </div>
  <div class="clear"></div>
</div>




