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
		<TITLE>修改社团活动</TITLE>
	    <link rel="stylesheet" href="kindeditor_a5/themes/default/default.css" />
	<link rel="stylesheet" href="kindeditor_a5/plugins/code/prettify.css" />
	<script charset="utf-8" src="kindeditor_a5/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor_a5/lang/zh_CN.js"></script>
	<script charset="utf-8" src="kindeditor_a5/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="huodongjianjie"]', {
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
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="shetuanhuodong_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="updateShetuanhuodong.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改社团活动<input type="hidden" name="id" value="${shetuanhuodong.id}" /></td>
						</tr>
						<tr ><td width="200">活动名称：</td><td><input name='huodongmingcheng' type='text' id='huodongmingcheng' value='' onblur='checkform()' size='50' class="form-control" style="width:600px;" />&nbsp;*<label id='clabelhuodongmingcheng' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">活动时间：</td><td><input name='huodongshijian' type='text' id='huodongshijian' value='<%=connDbBean.gettime()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd HH:mm:ss'})" class="form-control" />&nbsp;*<label id='clabelhuodongshijian' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">社团编号：</td><td><input name='shetuanbianhao' type='text' id='shetuanbianhao' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		<tr ><td width="200">社团名称：</td><td><input name='shetuanmingcheng' type='text' id='shetuanmingcheng' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.shetuanmingcheng.value='<%=connDbBean.readzd("shetuanxinxi","shetuanmingcheng","shetuanbianhao",(String)request.getSession().getAttribute("username"))%>';document.form1.shetuanmingcheng.setAttribute("readOnly",'true');</script>		<tr ><td width="200">活动简介：</td><td><textarea name="huodongjianjie" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.huodongmingcheng.value='${shetuanhuodong.huodongmingcheng}';</script>	<script language="javascript">document.form1.huodongshijian.value='${shetuanhuodong.huodongshijian}';</script>	<script language="javascript">document.form1.shetuanbianhao.value='${shetuanhuodong.shetuanbianhao}';</script>	<script language="javascript">document.form1.shetuanmingcheng.value='${shetuanhuodong.shetuanmingcheng}';</script>	<script language="javascript">document.form1.huodongjianjie.value='${shetuanhuodong.huodongjianjie}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var huodongmingchengobj = document.getElementById("huodongmingcheng"); if(huodongmingchengobj.value==""){document.getElementById("clabelhuodongmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入活动名称</font>";return false;}else{document.getElementById("clabelhuodongmingcheng").innerHTML="  "; } 	var huodongshijianobj = document.getElementById("huodongshijian"); if(huodongshijianobj.value==""){document.getElementById("clabelhuodongshijian").innerHTML="&nbsp;&nbsp;<font color=red>请输入活动时间</font>";return false;}else{document.getElementById("clabelhuodongshijian").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
