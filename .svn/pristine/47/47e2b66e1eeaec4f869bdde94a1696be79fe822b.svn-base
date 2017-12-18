<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<!-- 开始设置桌面图标，自适应屏幕   -->
		<title>日调整分析</title>
		<meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="viewport" content="width=device-width,initial-scale=1, minimum-scale=1.0, maximum-scale=1, user-scalable=no">
        <meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no,maximum-scale=1.0">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${contextPath}/static/img/icon-72.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${contextPath}/static/img/icon-144.png">
        <link rel="apple-touch-startup-image" sizes="1024x748" href="${contextPath}/static/img/icon-1024x748.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
		<!-- 结束设置桌面图标，自适应屏幕   -->
		<!-- jqueryMobile的css文件  -->
		<link rel="stylesheet" href="${contextPath}/static/css/jqueryMobile.css">
		<!-- 加载jquery文件 -->
		<script type="text/javascript" src="${contextPath}/static/js/jquery.js"></script>
		<!-- 加载jqueryMobile文件 -->
		<script type="text/javascript" src="${contextPath}/static/js/jqueryMobile.js"></script>
		<!--mobiscroll日期插件-->
		<link href="${contextPath}/static/css/mobiscroll.css" rel="stylesheet" type="text/css" />
		<script src="${contextPath}/static/js/mobiscroll.js" type="text/javascript"></script>
		
		<style type="text/css">
		.A { height: 100%;  width: 100%; }
		</style>
	    <script type="text/javascript">
	    	// 初始化插件内容
	    	var opt_data = {
	            preset: 'date', //日期格式 date（日期）|datetime（日期加时间）
	            theme: 'jqm', //皮肤样式
	            display: 'modal', //显示方式
	            mode: 'clickpick', //日期选择模式
	            dateFormat: 'yy-mm-dd', // 日期格式
	            setText: '确定', //确认按钮名称
	            cancelText: '取消',//取消按钮名籍我
	            dateOrder: 'yymmdd', //面板中日期排列格式
	            dayText: '日', monthText: '月', yearText: '年', //面板中年月日文字
	            yearText: '年', monthText: '月',  dayText: '日',  //面板中年月日文字
	            endYear:2020, //结束年份
	            showNow:true,
	            nowText:'今天',
	            hourText:'小时',
	            minuteText:'分'
	        };
			// 使用定义插件
	        $(document).on("pageinit", "#pageone", function(){
	        	$("#txtBirthday").mobiscroll(opt_data);
	        });
	    </script>		
	</head>
	<body>
		<div data-role="page" id="pageone">
			<div>
					<!-- 日期插件 -->
				    <div style="display:inline">
				    	<input type="text" data-role="datebox" id="txtBirthday" name="txtBirthday" placeholder="点击选择日期" />
				    	<button onclick="changeUrl()" style="display:inline-block">查询</button>
				    </div>
			</div>
			<div class="A" ><iframe src="http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?formlet=ZD_MB_JAVA%5B65e5%5D%5B8c03%5D%5B6574%5D%5B5206%5D%5B6790%5D.frm&date=2017-05-06" id="myiframe" scrolling="no" onload="changeFrameHeight()" frameborder="0"></iframe></div>
		</div>
<script type="text/javascript">

$.ajax({
	cache : true,
	type : "POST",
	url : "${contextPath}/report/getAdjustData",
	async : false,
	success : function(data) {
		var url = encodeURI(encodeURI("http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?formlet=ZD_MB_JAVA日调整分析.frm&date="+data+""));
		$('#myiframe').attr('src',url);
	}
});

function changeFrameHeight(){
    var ifm= document.getElementById("myiframe"); 
    ifm.height=document.documentElement.clientHeight ;
    ifm.width=document.documentElement.clientWidth;
}
window.onresize=function(){  
     changeFrameHeight();  
} 

function changeUrl(){
	var date = $("#txtBirthday").val();
	setCookie("adjdate",date,"h12");
	var urlValue = "http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?formlet=ZD_MB_JAVA%5B65e5%5D%5B8c03%5D%5B6574%5D%5B5206%5D%5B6790%5D.frm&date="+date+"";// 这里一定要转两次码，不然解析出来的依然是乱码
	$('#myiframe').attr('src',urlValue);
}

function setCookie(name,value,time)
{ 
    var strsec = getsec(time); 
    var exp = new Date(); 
    exp.setTime(exp.getTime() + strsec*1); 
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString(); 
} 
function getsec(str)
{ 
   var str1=str.substring(1,str.length)*1; 
   var str2=str.substring(0,1); 
   if (str2=="s")
   { 
        return str1*1000; 
   }
   else if (str2=="h")
   { 
       return str1*60*60*1000; 
   }
   else if (str2=="d")
   { 
       return str1*24*60*60*1000; 
   } 
} 
</script>
</body>
</html>