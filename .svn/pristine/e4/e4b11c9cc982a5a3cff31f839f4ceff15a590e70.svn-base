<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <title>BIG</title>
    <link rel="stylesheet" href="${contextPath}/static/css/jqueryMobile.css">
		<!-- 加载jquery文件 -->
		<script type="text/javascript" src="${contextPath}/static/js/jquery.js"></script>
		<!-- 加载jqueryMobile文件 -->
		<script type="text/javascript" src="${contextPath}/static/js/jqueryMobile.js"></script>
		<!--mobiscroll日期插件-->
		<link href="${contextPath}/static/css/mobiscroll.css" rel="stylesheet" type="text/css" />
		<script src="${contextPath}/static/js/mobiscroll.js" type="text/javascript"></script>
    <style type="text/css">
        .main{
            width: 100%;
            height: 100%;
            position: absolute;
        }
        .quarter-div{
            float: left;
        }
        .blue{
         width: 100%;
            height: 10%;
        
        }
        .green{
          width: 50%;
          height: 20%;
        }
        .orange{
         width: 50%;
            height: 90%;
          	float:right
        }
        .yellow{
         width: 50%;
            height: 70%;
        }
    </style>
    <script type="text/javascript">
    
     setTimeout("abc()",10000*6*5); 
	  function abc(){
		  setTimeout("abc()",10000*6*5); 
		  	document.getElementById('ifrmname').src="http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?reportlet=PEOPLE.cpt";
	    };
	    
    </script>
</head>
<body>
    <div class="main">
        <div class="quarter-div blue">
        <iframe src="http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?reportlet=TOP.cpt" 
          width=100%; height=100%; scrolling="no"  frameborder="0"></iframe>
        </div>
        <div  class="quarter-div green">
          <iframe id="ifrmname" name="ifrmname" src="http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?reportlet=PEOPLE.cpt" 
          width=100%; height=100%; scrolling="no"  frameborder="0"></iframe>
        </div>
        <div class="quarter-div orange">
          <iframe src="http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?formlet=DEVICE.frm" 
          width=100%; height=100%; scrolling="no"  frameborder="0"></iframe>
        </div>
        <div class="quarter-div yellow">
          <iframe src="http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?formlet=WORKORDER.frm" 
          width=100%; height=100%; scrolling="no"  frameborder="0"></iframe>
        </div>
    </div>
</body>
</html>