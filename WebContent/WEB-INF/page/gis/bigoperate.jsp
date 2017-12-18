
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="UTF-8">
<title>运分公司数据统计分析</title>
<link rel="stylesheet" href="${contextPath}/static/css/jqueryMobile.css">
<!-- 加载jquery文件 -->
<script type="text/javascript" src="${contextPath}/static/js/jquery.js"></script>
<!-- 加载jqueryMobile文件 -->
<script type="text/javascript"
	src="${contextPath}/static/js/jqueryMobile.js"></script>
<!--mobiscroll日期插件-->
<link href="${contextPath}/static/css/mobiscroll.css" rel="stylesheet"
	type="text/css" />
<script src="${contextPath}/static/js/mobiscroll.js"
	type="text/javascript"></script>
<script src="${contextPath}/static/nicescroll/jquery.nicescroll.js"
	type="text/javascript"></script>
<style type="text/css">
.top {
	position: absolute;
	background-color: rgba(0, 0, 0, 0.5);
	width: 100%;
	height: 60px;
	z-index: 1;
	text-align: center;
	display: inline;
}

.gis {
	position: absolute;
	background: #000;
	color: #FFF;
	width: 1920px;
	height: 1073px;
}

.titlefont {
	font-size: 34px;
	position: relative;
	font-family: "微软雅黑";
	color: #6abdf8;
}

.timefont {
	font-size: 20px;
	margin-right: 66px;
	margin-top: -8px;
	float: right;
	color: #6abdf8;
}

.weather {
	margin-top: 5px;
	float: right;
	color: #6abdf8;
	margin-right: 25px;
	font-size: 20px;
}

.logo {
	margin-left: 40px;
	margin-top: 5px;
	width: 200px;
	height: 50px;
	float: left;
}

.tablediv {
	position: absolute;
	width: 49%;
	height: 630px;
	background-color: rgba(56, 134, 160, 0.5);
	z-index: 1;
	margin-left: 10px;
	background: url('${contextPath}/static/img/left1.png');
	background-size: 100% 100%;
}

.tablediv2 {
	position: absolute;
	width: 49%;
	height: 500px;
	background-color: rgba(56, 134, 160, 0.5);
	z-index: 1;
	margin-left: 10px;
	background: url('${contextPath}/static/img/left1.png');
	background-size: 100% 100%;
}

.tabledivr {
	position: absolute;
	width: 48%;
	height: 630px;
	background-color: rgba(56, 134, 160, 0.5);
	z-index: 1;
	margin-left: 51%;
	background: url('${contextPath}/static/img/left1.png');
	background-size: 100% 100%;
	border-radius: 10px;
}

.tabledivr2 {
	position: absolute;
	width: 49%;
	height: 300px;
	background-color: rgba(56, 134, 160, 0.5);
	z-index: 1;
	margin-left: 51%;
	background: url('${contextPath}/static/img/left1.png');
	background-size: 100% 100%;
	border-radius: 10px;
}

.tabledivr3 {
	position: absolute;
	width: 48%;
	height: 170px;
	background-color: rgba(56, 134, 160, 0.5);
	z-index: 1;
	margin-left: 51%;

	background-size: 100% 100%;
	border-radius: 10px;
}

.titledivr {
	position: absolute;
	width: 500px;
	height: 5%;
	background-color: rgba(56, 134, 160, 0.5);
	z-index: 1;
	margin-left: 1395px;
	background: url('${contextPath}/static/img/title.png');
	background-size: 100% 100%;
}

.lefttable1 {
	margin-top: 70px;
}

.lefttable2 {
	margin-top: 680px;
}

.righttable {
	margin-top: 70px;
	text-align: center;
	display: inline;
}

.righttable1 {
	margin-top: 70px;
}

.righttable2 {
	margin-top: 400px;
}
.righttable3{
	margin-top: 670px;
}


#boxscroll2 {
	padding: 5px;
	height: 300px;
	width: 900px;
	border: 2px solid #000;
	overflow: auto;
	background-color: #000;
}

#boxscroll3 {
	padding: 5px;
	height: 304px;
	top: 26px;
	width: 926px;
	border: 2px solid #000;
	overflow: auto;
	background-color: #000;
}
#boxscroll4 {
	padding: 5px;
	height: 290px;
	margin-left: 988px;
	width: 890px;
	border: 2px solid #000;
	overflow: auto;
	background-color: #000;
}

#boxframe {
	position: absolute;
	top: 28px;
	left: 420px;
	width: 400px;
	height: 300px;
	overflow: auto;
	border: 2px solid #000;
}

span {
	font-size: 25px;
	color: #6abdf8;
	margin: 20px;
	margin-top: 10px;
}
</style>
<script>
	$(document).ready(function() {

		$("#boxscroll2").niceScroll("#contentscroll2", {
			cursorcolor : "#FFF",
			cursoropacitymax : 0.7,
			boxzoom : true,
			touchbehavior : true
		}); // Second scrollable DIV

		$("#boxscroll3").niceScroll("#contentscroll3", {
			cursorcolor : "#FFF",
			cursoropacitymax : 0.7,
			boxzoom : true,
			touchbehavior : true
		}); // Second scrollable DIV
		$("#boxscroll4").niceScroll("#contentscroll4", {
			cursorcolor : "#FFF",
			cursoropacitymax : 0.7,
			boxzoom : true,
			touchbehavior : true
		}); // Second scrollable DIV

	});
</script>
</head>
<body>
	<div class="main">
		<!-- 头部div 显示标题、时间 -->

		<div class="quarter-div gis"></div>

		<div class="tablediv lefttable1">
			<div style="width: 100%; height: 100%; padding-left: 1%;">
				<iframe
					src="http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?formlet=2_car_overhaul.frm"
					width=58%;style= "margin-bottom:10px; height=90%; scrolling="no"
					; frameborder=0; style="margin: 20px 0px 0px 0px;"> </iframe>
				<iframe
					src="http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?formlet=2_cartrend_zb.frm"
					align="right" width=40%; style="margin-top: 40px;" height=90%;
					scrolling="no" ; frameborder=0; style="margin: 20px 0px 0px 40px;">
				</iframe>

			</div>

		</div>
		<div id="boxscroll3" class="tablediv2 lefttable2">
			<div  id="contentscroll3">
				<iframe
					src="http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?formlet=1_MAINTENANCE.frm"
					width=95%; height=800px; scrolling="no" ; frameborder=0;
					style="margin: 0px 0px 30px 10px;"> </iframe>
			</div>
		</div>


		<div id="boxscroll2" class=" tabledivr2 righttable1">
			<div id="contentscroll2">
				<iframe
					src="http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?formlet=3_MAINTENANCE.frm"
					width=95%; height=1200px; scrolling="no" ; frameborder=0;
					style="margin: 20px 0px 0px 20px;"> </iframe>
			</div>
		</div>
		<div class="tabledivr righttable2">
			<div style="width: 95%; height: 48%;">
				<iframe
					src="http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?formlet=4_hr_quarter.frm"
					width=45%; height=90%; scrolling="no" ; frameborder=0;
					style="margin: 5px 0px 0px 20px;"> </iframe>

				<iframe
					src="http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?formlet=4_hr_quarter_top.frm"
					align="right" style="margin-top: 5px;" width=46%; height=90%;
					scrolling="no" ; frameborder=0; style="margin:5px 0px 0px 20px;">
				</iframe>

			</div>	</div>
			<div id="boxscroll4" class=" tabledivr3 righttable3">
			<div  id="contentscroll4" >
				<iframe
					src="http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?formlet=4_facility_check.frm"
					width=95%; height=1200px; scrolling="no"; frameborder=0; style="margin: 1px 0px 10px 15px;"> </iframe>
			</div>
		</div>



	</div>
</body>
</html>