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
		<TITLE>修改社团信息</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>


	<body>
			<form action="updateShetuanxinxi2.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改社团信息<input type="hidden" name="id" value="${shetuanxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">社团编号：</td><td><input name='shetuanbianhao' type='text' id='shetuanbianhao' value='' onblur='hsgcheck()' class="form-control" />&nbsp;*<label id='clabelshetuanbianhao' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">社团名称：</td><td><input name='shetuanmingcheng' type='text' id='shetuanmingcheng' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelshetuanmingcheng' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">负责人：</td><td><input name='fuzeren' type='text' id='fuzeren' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">社团LOGO：</td><td><input name='shetuanLOGO' type='text' id='shetuanLOGO' size='50' value='' onblur=''  class="form-control" /><div style="margin-top:16px;">&nbsp;<input type='button' value='上传' onClick="up('shetuanLOGO')"/></div></td></tr>		<tr ><td width="200">联系电话：</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabellianxidianhua' style='margin-top:16px;' />必需电话格式[7或8位电话，或11位手机]</td></tr>		<tr ><td width="200">社团人数：</td><td><input name='shetuanrenshu' type='text' id='shetuanrenshu' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelshetuanrenshu' style='margin-top:16px;' />必需数字型</td></tr>		<tr ><td width="200">社团等级：</td><td><input name='shetuandengji' type='text' id='shetuandengji' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">社团简介：</td><td><textarea name='shetuanjianjie' cols='50' rows='5' id='shetuanjianjie' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.shetuanbianhao.value='${shetuanxinxi.shetuanbianhao}';</script>	<script language="javascript">document.form1.mima.value='${shetuanxinxi.mima}';</script>	<script language="javascript">document.form1.shetuanmingcheng.value='${shetuanxinxi.shetuanmingcheng}';</script>	<script language="javascript">document.form1.fuzeren.value='${shetuanxinxi.fuzeren}';</script>	<script language="javascript">document.form1.shetuanLOGO.value='${shetuanxinxi.shetuanLOGO}';</script>	<script language="javascript">document.form1.lianxidianhua.value='${shetuanxinxi.lianxidianhua}';</script>	<script language="javascript">document.form1.shetuanrenshu.value='${shetuanxinxi.shetuanrenshu}';</script>	<script language="javascript">document.form1.shetuandengji.value='${shetuanxinxi.shetuandengji}';</script>	<script language="javascript">document.form1.shetuanjianjie.value='${shetuanxinxi.shetuanjianjie}';</script>	
					 </table>
			</form>
   </body>
</html>



<!--hssgchesck-->


<script language=javascript >  
 
 function checkform(){  
 
	var shetuanbianhaoobj = document.getElementById("shetuanbianhao"); if(shetuanbianhaoobj.value==""){document.getElementById("clabelshetuanbianhao").innerHTML="&nbsp;&nbsp;<font color=red>请输入社团编号</font>";return false;}else{document.getElementById("clabelshetuanbianhao").innerHTML="  "; } 	var shetuanmingchengobj = document.getElementById("shetuanmingcheng"); if(shetuanmingchengobj.value==""){document.getElementById("clabelshetuanmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入社团名称</font>";return false;}else{document.getElementById("clabelshetuanmingcheng").innerHTML="  "; } 	var lianxidianhuaobj = document.getElementById("lianxidianhua"); if(lianxidianhuaobj.value!=""){ if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(lianxidianhuaobj.value) || /^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(lianxidianhuaobj.value)){document.getElementById("clabellianxidianhua").innerHTML=""; }else{document.getElementById("clabellianxidianhua").innerHTML="&nbsp;&nbsp;<font color=red>必需电话格式[7或8位电话，或11位手机]</font>"; return false;}}          


return true;   
}   
popheight=450;
</script>  
