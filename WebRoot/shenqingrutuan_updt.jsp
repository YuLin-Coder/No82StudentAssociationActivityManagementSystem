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
		<TITLE>修改申请入团</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="shenqingrutuan_add.jsp?id=<%=id%>";
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
			<form action="updateShenqingrutuan.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改申请入团<input type="hidden" name="id" value="${shenqingrutuan.id}" /></td>
						</tr>
						<tr ><td width="200">社团编号：</td><td><input name='shetuanbianhao' type='text' id='shetuanbianhao' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">社团名称：</td><td><input name='shetuanmingcheng' type='text' id='shetuanmingcheng' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">学号：</td><td><input name='xuehao' type='text' id='xuehao' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.xingming.value='<%=connDbBean.readzd("xueshengxinxi","xingming","xuehao",(String)request.getSession().getAttribute("username"))%>';document.form1.xingming.setAttribute("readOnly",'true');</script>		<tr ><td width="200">院系：</td><td><input name='yuanxi' type='text' id='yuanxi' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.yuanxi.value='<%=connDbBean.readzd("xueshengxinxi","yuanxi","xuehao",(String)request.getSession().getAttribute("username"))%>';document.form1.yuanxi.setAttribute("readOnly",'true');</script>		<tr ><td width="200">班级：</td><td><input name='banji' type='text' id='banji' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.banji.value='<%=connDbBean.readzd("xueshengxinxi","banji","xuehao",(String)request.getSession().getAttribute("username"))%>';document.form1.banji.setAttribute("readOnly",'true');</script>		<tr ><td width="200">电话：</td><td><input name='dianhua' type='text' id='dianhua' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.dianhua.value='<%=connDbBean.readzd("xueshengxinxi","dianhua","xuehao",(String)request.getSession().getAttribute("username"))%>';document.form1.dianhua.setAttribute("readOnly",'true');</script>		<tr ><td width="200">申请理由：</td><td><textarea name='shenqingliyou' cols='50' rows='5' id='shenqingliyou' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.shetuanbianhao.value='${shenqingrutuan.shetuanbianhao}';</script>	<script language="javascript">document.form1.shetuanmingcheng.value='${shenqingrutuan.shetuanmingcheng}';</script>	<script language="javascript">document.form1.xuehao.value='${shenqingrutuan.xuehao}';</script>	<script language="javascript">document.form1.xingming.value='${shenqingrutuan.xingming}';</script>	<script language="javascript">document.form1.yuanxi.value='${shenqingrutuan.yuanxi}';</script>	<script language="javascript">document.form1.banji.value='${shenqingrutuan.banji}';</script>	<script language="javascript">document.form1.dianhua.value='${shenqingrutuan.dianhua}';</script>	<script language="javascript">document.form1.shenqingliyou.value='${shenqingrutuan.shenqingliyou}';</script>	
					 </table>
			</form>
   </body>
</html>






