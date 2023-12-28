<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>添加收藏记录</TITLE>
	    

       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="shoucangjilu_add.jsp?id=<%=id%>";
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
			<form action="addShoucangjilu.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加收藏记录</td>
						</tr>
						<tr ><td width="200">username：</td><td><input name='username' type='text' id='username' onblur='checkform()' style='border:solid 1px #000000; color:#666666' value='${sessionScope.userxinxi.username}' readonly="readonly" />&nbsp;*<label id='clabelusername' /></td></tr>		<tr ><td width="200">xwid：</td><td><input name='xwid' type='text' id='xwid' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelxwid' /></td></tr>		<tr ><td width="200">字段：</td><td><input name='ziduan' type='text' id='ziduan' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">表：</td><td><input name='biao' type='text' id='biao' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		
		
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



<!--hssgchesck-->


<script language=javascript >  
 
 function checkform(){  
 
	var usernameobj = document.getElementById("username"); if(usernameobj.value==""){document.getElementById("clabelusername").innerHTML="&nbsp;&nbsp;<font color=red>请输入username</font>";return false;}else{document.getElementById("clabelusername").innerHTML="  "; } 	var xwidobj = document.getElementById("xwid"); if(xwidobj.value==""){document.getElementById("clabelxwid").innerHTML="&nbsp;&nbsp;<font color=red>请输入xwid</font>";return false;}else{document.getElementById("clabelxwid").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
