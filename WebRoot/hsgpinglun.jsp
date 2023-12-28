<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>

<%
if((String)request.getSession().getAttribute("username")==null || (String)request.getSession().getAttribute("username")=="")
{
	out.print("<script>alert('对不起,请您先登陆!');parent.location=parent.location;</script>");
}
if(request.getParameter("ok")!=null)
{
out.print("<script>parent.location=parent.location;</script>");
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>在线评论</title>

<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style><meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>

<body>
<%
  String id=request.getParameter("id");
  String biao=request.getParameter("biao");

   %>
   <script language="javascript">
   function check()
{
	if(document.form1.pinglunneirong.value==""){alert("请输入评论内容");document.form1.pinglunneirong.focus();return false;}
}

   </script>
  <form action="addPinglun.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加评论</td>
						</tr>
						<tr  style="display:none"><td width="200">新闻ID：</td><td><input name='xinwenID' type='text' id='xinwenID' value='<%=id%>' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelxinwenID' /></td></tr>
		<tr ><td width="200">评分：</td>
		  <td><select name="pingfen" id="pingfen">
		    <option value="1">1</option>
		    <option value="2">2</option>
		    <option value="3">3</option>
		    <option value="4">4</option>
		    <option value="5">5</option>
		    </select>
		  </td>
		</tr>
		<tr ><td width="200">评论内容：</td><td><textarea name='pinglunneirong' cols='50' rows='5' id='pinglunneirong' onblur='checkform()' style='border:solid 1px #000000; color:#666666' ></textarea>&nbsp;*<label id='clabelpinglunneirong' /></td></tr>
		<tr ><td width="200">评论人：</td><td><input name='pinglunren' type='text' id='pinglunren' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>
		
		<tr style="display:none" ><td width="200">表：</td><td><input name='biao' type='text' id='biao' value='<%=biao%>' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
</body>
</html>
