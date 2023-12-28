<%
 '功能：支付宝接口公用函数
 '详细：该页面是请求、通知返回两个文件所调用的公用函数核心处理文件，不需要修改
 '版本：3.1
 '修改日期：2010-10-29
 '说明：
 '以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 '该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
%>

<!--#include file="alipay_md5.asp"-->

<%


'*************************************************************************************************

'生成签名结果
'sArray 要签名的数组
'key 安全校验码
'sign_type 签名类型
'输出 签名结果字符串
function build_mysign(sArray, key, sign_type,input_charset)
	prestr = create_linkstring(sArray)		'把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
	'去掉最後一個&字符
	nLen = Len(prestr)
	prestr = left(prestr,nLen-1)
	
    prestr = prestr & key					'把拼接后的字符串再与安全校验码直接连接起来
    mysign = sign(prestr,sign_type,input_charset)	'把最终的字符串签名，获得签名结果

    build_mysign = mysign
end function

'*************************************************************************************************

'把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
'sArray 需要拼接的数组
'输出 拼接完成以后的字符串
function create_linkstring(sArray)
	nCount = ubound(sArray)
	dim prestr
	for i = 0 to nCount
		prestr = prestr & sArray(i) & "&"
	next
	
	create_linkstring = prestr
end function

'*************************************************************************************************

'除去数组中的空值和签名参数
'sArray 签名参数组
'输出 去掉空值与签名参数后的新签名参数组
function para_filter(sArray)
	dim para()
	nCount = ubound(sArray)
	dim j
	j = 0
	for i = 0 to nCount
		'把sArray的数组里的元素格式：变量名=值，分割开来
		pos = Instr(sArray(i),"=")			'获得=字符的位置
		nLen = Len(sArray(i))				'获得字符串长度
		itemName = left(sArray(i),pos-1)	'获得变量名
		itemValue = right(sArray(i),nLen-pos)'获得变量的值
		
		if itemName <> "sign" and itemName <> "sign_type" and itemValue <> "" then
			Redim Preserve para(j)
			para(j) = sArray(i)
			j = j + 1
		end if
	next
	para_filter = para
end function

'*************************************************************************************************

'对数组排序
'sArray 排序前的数组
'输出 排序后的数组
function arg_sort(sArray)
	nCount = ubound(sArray)
	For i = nCount TO 0 Step -1
		minmax = sArray( 0 )
    	minmaxSlot = 0
    	For j = 1 To i
            mark = (sArray( j ) > minmax)
        	If mark Then 
            	minmax = sArray( j )
            	minmaxSlot = j
        	End If
    	Next
		If minmaxSlot <> i Then 
			temp = sArray( minmaxSlot )
			sArray( minmaxSlot ) = sArray( i )
			sArray( i ) = temp
		End If
	Next
	arg_sort = sArray
end function

'*************************************************************************************************

'签名字符串
'prestr 需要签名的字符串
'sign_type 签名类型
'输出 签名结果
function sign(prestr,sign_type,input_charset)
	dim sResult
	if sign_type = "MD5" then
		sResult = md5(prestr,input_charset)
	else 
		sResult = ""
	end if
	sign = sResult
end function

'*************************************************************************************************

'用于防钓鱼，调用接口query_timestamp来获取时间戳的处理函数
'注意：远程解析XML出错，与IIS服务器配置有关
'partner 合作身份者ID
'输出 时间戳字符串
function query_timestamp(partner)
    url = "https://mapi.alipay.com/gateway.do?service=query_timestamp&partner="&partner
	dim encrypt_key
	
	Dim http,xml
	Set http=Server.CreateObject("Microsoft.XMLHTTP")
	http.Open "GET",url,False
	http.send
	Set xml=Server.CreateObject("Microsoft.XMLDOM")
	xml.Async=true
	xml.ValidateOnParse=False
	xml.Load(http.ResponseXML)
	
	set UserData=xml.getElementsByTagName("encrypt_key")  ' 节点的名称
	if isnull(xml.getElementsByTagName("encrypt_key") ) then
		encrypt_key = ""
	else
		encrypt_key = UserData.item(0).childnodes(0).text
	end if
	
	query_timestamp = encrypt_key
end function

'*************************************************************************************************

'写日志，方便测试（看网站需求，也可以改成存入数据库）
'sWord 要写入日志里的文本内容
function log_result(sWord)
	randomize
	set fs= createobject("scripting.filesystemobject")
	set ts=fs.createtextfile(server.MapPath("log/"&GetDateTime()&INT((1000+1)*RND)&".txt"),true)
	ts.writeline(sWord)
	ts.close
	set ts=Nothing
	set fs=Nothing
end function

'*************************************************************************************************

'转换时间，
'格式：年[4位]-月[2位]-日[2位] 小时[2位 24小时制]:分[2位]:秒[2位]，如：2007-10-01 13:13:13
function GetDateTime_Format()
	sTime=now()
	sResult	= year(sTime)&"-"&right("0" & month(sTime),2)&"-"&right("0" & day(sTime),2)&" "&right("0" & hour(sTime),2)&":"&right("0" & minute(sTime),2)&":"&right("0" & second(sTime),2)
	GetDateTime_Format = sResult
end function

'*************************************************************************************************

'转换时间，
'格式：年[4位]月[2位]日[2位]小时[2位 24小时制]分[2位]秒[2位]，如：20071001131313
function GetDateTime()
	sTime=now()
	sResult	= year(sTime)&right("0" & month(sTime),2)&right("0" & day(sTime),2)&right("0" & hour(sTime),2)&right("0" & minute(sTime),2)&right("0" & second(sTime),2)
	GetDateTime = sResult
end function

'*************************************************************************************************

'过滤特殊字符
'Str 要被过滤的字符串
'输出 已被过滤掉的新字符串
Function DelStr(Str)
	If IsNull(Str) Or IsEmpty(Str) Then
		Str	= ""
	End If
	DelStr	= Replace(Str,";","")
	DelStr	= Replace(DelStr,"'","")
	DelStr	= Replace(DelStr,"&","")
	DelStr	= Replace(DelStr," ","")
	DelStr	= Replace(DelStr,"　","")
	DelStr	= Replace(DelStr,"%20","")
	DelStr	= Replace(DelStr,"--","")
	DelStr	= Replace(DelStr,"==","")
	DelStr	= Replace(DelStr,"<","")
	DelStr	= Replace(DelStr,">","")
	DelStr	= Replace(DelStr,"%","")
End Function

'*************************************************************************************************
%>