<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE></TITLE>
		<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">
	    <link rel="stylesheet" href="kindeditor_a5/themes/default/default.css" />
	<link rel="stylesheet" href="kindeditor_a5/plugins/code/prettify.css" />
	<script charset="utf-8" src="kindeditor_a5/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor_a5/lang/zh_CN.js"></script>
	<script charset="utf-8" src="kindeditor_a5/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="neirong"]', {
				cssPath : 'kindeditor_a5/plugins/code/prettify.css',
				uploadJson : 'kindeditor_a5/jsp/upload_json.jsp',
				fileManagerJson : 'kindeditor_a5/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>

       
	</head>
<%
String lb=request.getParameter("lb");
String sql="";
String ncontent="";
sql="select * from dx where leibie='"+lb+"'";
 ResultSet RS_result=connDbBean.executeQuery(sql);
 if(!RS_result.next())
 {
 	sql="insert into dx(leibie,content) values('"+lb+"','"+lb+"')";
	connDbBean.hsgexecute(sql);
	out.print("<script language='javascript'>location.href='dx.jsp?lb="+lb+"';</script>");
 }
 else
 {
 	ncontent=RS_result.getString("content");
 }
				



if (request.getParameter("updt")!=null)
{
	sql="update dx set content='"+request.getParameter("neirong")+"' where leibie='"+lb+"'";
	//out.print(sql);
	connDbBean.hsgexecute(sql);
	out.print("<script language='javascript'>alert('操作成功!');location.href='dx.jsp?lb="+lb+"';</script>");
}
%>
	<body>
			<form action="dx.jsp?updt=1&lb=<%=lb%>" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改<%=lb%></td>
						</tr>
		<tr ><td width="116">内容：</td><td><textarea name="neirong" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"><%=ncontent%></textarea></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="116" height="45"  align="right">&nbsp;						    </td>
						    <td width="1327" height="45"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" class="btn btn-info btn-small" />
				          <input type="reset" value="重置" class="btn btn-info btn-small"/>&nbsp;						    </td>
						</tr>
						
			  </table>
			</form>
   </body>
</html>


