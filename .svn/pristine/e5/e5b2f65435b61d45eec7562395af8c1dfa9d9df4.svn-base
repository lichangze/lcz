<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <title>北京地铁大屏展示方案</title>
   		 <link rel="stylesheet" href="${contextPath}/static/css/jqueryMobile.css">
		<!-- 加载jquery文件 -->
		<script type="text/javascript" src="${contextPath}/static/js/jquery.js"></script>
		<!-- 加载jqueryMobile文件 -->
		<script type="text/javascript" src="${contextPath}/static/js/jqueryMobile.js"></script>
		<!--mobiscroll日期插件-->
		<link href="${contextPath}/static/css/mobiscroll.css" rel="stylesheet" type="text/css" />
		<script src="${contextPath}/static/js/mobiscroll.js" type="text/javascript"></script>
    <style type="text/css">
    	.top{
    	    position:absolute;
    		background-color: rgba(0,0,0,0.5);
    		width: 100%;
    		height: 60px;
    		z-index:1;
    		text-align:center;
    		display:inline;
    	}
       .gis{
       	 position:absolute;
       	 background:#000; 
       	 color:#FFF;
       	 width: 1920px;
       	 height: 1073px;
       }
       .titlefont{
       		font-size:34px;
       		position: relative;
       		font-family: "微软雅黑";
       		color: #6abdf8;
       }
       .timefont{
       		font-size:20px;
       		margin-right:66px;
       		margin-top: -8px;
       		float:right;
       		color : #6abdf8;
       }
       .weather{
       		margin-top: 5px;
       		float:right;
       		color : #6abdf8;
       		margin-right: 25px;
       		font-size:20px;
       }
       .logo{
       		 margin-left: 40px;
             margin-top: 5px;
      		 width: 200px;
       		 height: 50px;
       		 float:left;
       }
       .tablediv{
            position:absolute;
       		width: 19%;
       		height: 25%;
       		background-color: rgba(56,134,160,0.5);
       		z-index:1;
       		margin-left: 10px;
       		background:url('${contextPath}/static/img/jy.png');
       		background-size:100% 100%;
       }
       .tabledivr{
       		position:absolute;
       		width: 500px;
       		height: 25%;
       		background-color: rgba(56,134,160,0.5);
       		z-index:1;
       		margin-left: 1395px;
       		background:url('${contextPath}/static/img/jy.png');
       		background-size:100% 100%;
       		border-radius:10px;
       }
       .titledivr{
       		position:absolute;
       		width: 500px;
       		height: 5%;
       		background-color: rgba(56,134,160,0.5);
       		z-index:1;
       		margin-left: 1395px;
       		background:url('${contextPath}/static/img/title.png');
       		background-size:100% 100%;
       }
       
       .lefttable1{
       		margin-top: 70px;
       }
        .lefttable2{
       		margin-top: 400px;
       }
        .lefttable3{
       		margin-top: 740px;
       }
       
       .righttable{
       		margin-top: 70px;
       		text-align:center;
       		display:inline;
       }
       
       .righttable1{
       		margin-top: 150px;
       }
        .righttable2{
       		margin-top: 450px;
       }
        .righttable3{
       		margin-top: 750px;
       }
       span{
       	 font-size:25px;
       	 color:#6abdf8;
       	 margin: 20px;
       	 margin-top: 10px;
       }
       
       
    </style>
</head>
<body>
    <div class="main">
    	<!-- 头部div 显示标题、时间 -->
        
        <div  class="quarter-div gis">
        	<iframe src="http://finereport.bjdt.bmzymtr.com:30001/WebReport/report/echartsbjasset" width=100%; height=100%; scrolling="no"></iframe>
        </div>
        
         <div class="tablediv lefttable1">
         <a style="color: #FFF;padding: 0PX 130PX">EAM设备占比</a>
            <iframe src="http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?formlet=jy_gis_device.frm" width=360px; height=80%; scrolling="no"; frameborder=0; style="margin:10px 0px 0px 10px;">
        	</iframe>
        </div>
        <div class="tablediv lefttable2">
         <a style="color: #FFF;padding: 0PX 125PX">EAM设备TOP5</a>
           <iframe src="http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?reportlet=jy_gis_device_sum.cpt" width=360px; height=80%; scrolling="no"; frameborder=0; style="margin:10px 0px 0px 10px;">
        	</iframe>
        </div>
        <div class="tablediv lefttable3">
        <a style="color: #FFF;padding: 0PX 130PX">EAM工单占比</a>
            <iframe src="http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?formlet=jy_gis_workorder.frm" width=360px; height=80%; scrolling="no"; frameborder=0; style="margin:10px 0px 0px 10px;">
        	</iframe>
        </div>
        
            
        <div class="tabledivr righttable1">
         <a style="color: #FFF;padding: 0PX 185PX">故障计划修占比</a>
        	<iframe src="http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?formlet=jy_gis_planerror.frm" width=470px; height=80%; scrolling="no"; frameborder=0; style="margin:10px 0px 0px 10px;">
        	</iframe>
        </div>
        <div class="tabledivr righttable2">
        <a style="color: #FFF;padding: 0PX 165PX">EAM（机电）工单维修</a>
        	<iframe src="http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?reportlet=jy_gis_workorder.cpt" width=470px; height=80%; scrolling="no"; frameborder=0; style="margin:10px 0px 0px 10px;">
        	</iframe>
        </div>
        <div class="tabledivr righttable3">
          <a style="color: #FFF;padding: 0PX 175PX">EAM设备数量排行</a>
        	<iframe src="http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?formlet=jy_gis_device_sum.frm" width=470px; height=80%; scrolling="no"; frameborder=0; style="margin:10px 0px 0px 10px;">
        	</iframe>
        </div>
        
        
    </div>
</body>
</html>