<%
 '类名：alipay_notify
 '功能：付款过程中服务器通知类
 '详细：该页面是通知返回核心处理文件，不需要修改
 '版本：3.1
 '修改日期：2010-10-29
 '说明：
 '以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 '该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 
'''''''''''''''''''''''注意''''''''''''''''''''''''
'调试通知返回时，可查看或改写log日志的写入TXT里的数据，来检查通知返回是否正常
'''''''''''''''''''''''''''''''''''''''''''''''''''
%>

<!--#include file="alipay_function.asp"-->

<%
dim gateway			'网关地址
dim mysign			'签名结果
gateway = "http://notify.alipay.com/trade/notify_query.do?"

'********************************************************************************

'对notify_url的认证
'输出 验证结果：true/false
function notify_verify()
	responseTxt = get_http()			'判断消息是不是支付宝发出
	
	sGetArray = GetRequestPost()		'获取支付宝POST过来通知消息，并以“参数名=参数值”的形式组成数组

	if IsArray(sGetArray) then			'验证是否有数组传来
		'生成签名结果
		sArray = para_filter(sGetArray)	'对所有POST反馈回来的数据去空格
		sort_para = arg_sort(sArray)	'对所有POST反馈回来的数据排序
		mysign  = build_mysign(sort_para,key,sign_type,input_charset)	'生成签名结果
		
		'写日志记录（若要调试，请取消下面两行注释）
		sWord = "responseTxt="& responseTxt &"\n return_url_log:sign="&request.Form("sign")&"&mysign="&mysign&"&"&create_linkstring(sort_para)
		log_result(sWord)
	
		'判断veryfy_responsetTxtresult是否为ture，生成的签名结果mysign与获得的签名结果sign是否一致
		'responsetTxt的结果不是true，与服务器设置问题、合作身份者ID、notify_id一分钟失效有关
		'mysign与sign不等，与安全校验码、请求时的参数格式（如：带自定义参数等）、编码格式有关
		if mysign = request.Form("sign") and responseTxt = "true" then
			notify_verify = true
		else
			notify_verify = false
		end if
	else
		notify_verify = false
	end if
end function

'********************************************************************************

'对return_url的认证
'输出 验证结果：true/false
function return_verify()
	responseTxt = get_http()			'判断消息是不是支付宝发出

	sGetArray = GetRequestGet()			'获取支付宝GET过来通知消息，并以“参数名=参数值”的形式组成数组

	if IsArray(sGetArray) then			'验证是否有数组传来
		'生成签名结果
		sArray = para_filter(sGetArray)	'对所有GET反馈回来的数据去空格
		sort_para = arg_sort(sArray)	'对所有GET反馈回来的数据排序
		mysign  = build_mysign(sort_para,key,sign_type,input_charset)	'生成签名结果
		
		'写日志记录（若要调试，请取消下面两行注释）
		'sWord = "responseTxt="& responseTxt &"\n return_url_log:sign="&request.QueryString("sign")&"&mysign="&mysign&"&"&create_linkstring(sort_para)
		'log_result(sWord)
	
		'判断responsetTxt是否为ture，生成的签名结果mysign与获得的签名结果sign是否一致
		'responsetTxt的结果不是true，与服务器设置问题、合作身份者ID、notify_id一分钟失效有关
		'mysign与sign不等，与安全校验码、请求时的参数格式（如：带自定义参数等）、编码格式有关
		if mysign = request.QueryString("sign") and responseTxt = "true" then
			return_verify = true
		else
			return_verify = false
		end if
	else
		return_verify = false
	end if
end function

'********************************************************************************

'获取支付宝GET过来通知消息，并以“参数名=参数值”的形式组成数组
'输出 request回来的信息组成的数组
function GetRequestGet()
	dim sArray()
	i = 0
	For Each varItem in Request.QueryString
		Redim Preserve sArray(i)
		sArray(i) = varItem&"="&Request(varItem) 
		i = i + 1
	Next 
	
	if i = 0 then	'验证是否有数组传来
		GetRequestGet = ""
	else
		GetRequestGet = sArray
	end if
	
end function

'********************************************************************************

'获取支付宝POST过来通知消息，并以“参数名=参数值”的形式组成数组
'输出 request回来的信息组成的数组
function GetRequestPost()
	dim sArray()
	i = 0
	For Each varItem in Request.Form
		Redim Preserve sArray(i)
		sArray(i) = varItem&"="&Request(varItem) 
		i = i + 1
	Next 
	
	if i = 0 then	'验证是否有数组传来
		GetRequestPost = ""
	else
		GetRequestPost = sArray
	end if
end function

'********************************************************************************

'获取远程服务器ATN结果
'输出 服务器ATN结果字符串
function get_http()
	gateway = gateway &"partner=" & partner & "&notify_id=" & request("notify_id")
	Set Retrieval = Server.CreateObject("Msxml2.ServerXMLHTTP.3.0")
    Retrieval.setOption 2, 13056 
    Retrieval.open "GET", gateway, False, "", "" 
    Retrieval.send()
    ResponseTxt = Retrieval.ResponseText
	Set Retrieval = Nothing
	get_http = ResponseTxt
end function

'********************************************************************************

%>