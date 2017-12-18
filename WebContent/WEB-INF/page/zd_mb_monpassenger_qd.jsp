<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<meta charset="utf-8" />
		<!-- 开始设置桌面图标，自适应屏幕   -->
		<title>月客流量分析</title>
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
<!-- ajax layout which only needs content area -->
<div data-role="page" id="pageone">
	<div>
		<!-- 日期插件 -->
		<div style="display: inline">
			<input type="hidden" id="hline" name="hline" value="${line}">
			<input type="text" data-role="datebox" id="txtBirthday"
				name="txtBirthday" placeholder="点击选择日期"/>
			<select  id="line">
				<option value="">请选择线路</option>
				<option value="2号线">2号线</option>
				<option value="3号线">3号线</option>
			</select>
			<button onclick="changeUrl()" style="display: inline-block">查询</button>
		</div>
	</div>
	<div class="A">
		<iframe src="" id="myiframe" scrolling="no" onload="changeFrameHeight()" frameborder="0"></iframe>
	</div>
</div>
<style type="text/css">
.A {
	height: 100%;
	width: 100%;
}
.ui-select{
    display: block;
    background: #FFF;
    position: relative;
}
</style>
<script type="text/javascript">
	// 初始化插件内容
	var opt_data = {
		preset : 'date', //日期格式 date（日期）|datetime（日期加时间）
		theme : 'jqm', //皮肤样式
		display : 'modal', //显示方式
		mode : 'clickpick', //日期选择模式
		dateFormat : 'yy-mm', // 日期格式
		setText : '确定', //确认按钮名称
		cancelText : '取消',//取消按钮名籍
		dateOrder : '  yy    mm', //面板中日期排列格式
		monthText : '月',
		yearText : '年', //面板中年月日文字
		yearText : '年',
		monthText : '月',
		endYear : 2020, //结束年份
		showNow : false,
		nowText : '今天',
	};
	// 使用定义插件
	$(document).on("pageinit", "#pageone", function() {
		$("#txtBirthday").mobiscroll(opt_data);
	});

	function changeFrameHeight(){
	    var ifm= document.getElementById("myiframe"); 
	    ifm.height=document.documentElement.clientHeight ;
	    ifm.width=document.documentElement.clientWidth;
	}
	window.onresize=function(){  
	     changeFrameHeight();  
	} 
	
	function getCookie(name) 
	{ 
	    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
	 
	    if(arr=document.cookie.match(reg))
	 
	        return unescape(arr[2]); 
	    else 
	        return null; 
	} 
	
	var dateck = getCookie("dateck");
	if(dateck != null){
		dateck = getCookie("dateck").substring(0,7);
	}else{
		var date = "${date}";
		dateck=date.substring(0,7);
	}
	var url = encodeURI(encodeURI("http://report.bmzymtr.com:10080/webreport/ReportServer?formlet=zd_monpassenger.frm&line=${line}&date="+dateck));
	$('#myiframe').attr('src',url);
	
	function changeUrl(){
		var date = $("#txtBirthday").val();
		var line = $("#line").val();
		if(line == ''||line == null){
			line = $("#hline").val();
		}
		var urlValue = "http://report.bmzymtr.com:10080/webreport/ReportServer?formlet=zd_monpassenger.frm&date="+date+"&line="+line+"";// 这里一定要转两次码，不然解析出来的依然是乱码
		urlValue=encodeURI(encodeURI(urlValue));
		$('#myiframe').attr('src',urlValue);
	}
</script>