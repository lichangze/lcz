
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set> 
<head>
	
</head>
<body>
     <iframe width=100% height=600px 
     src="http://${report_service_ip}/aems-report/ReportServer?reportlet=searchWork.cpt"></iframe>
<script type="text/javascript">
     var pageContent=$(".page-content");
     var height=pageContent.height();
     $("#iframepage").height(height);
	  var scripts = [ null,
			"${contextPath}/static/assets/js/jquery-ui.custom.js",
			"${contextPath}/static/assets/js/jquery.ui.touch-punch.js",
			"${contextPath}/static/assets/js/jquery.easypiechart.js",
			"${contextPath}/static/assets/js/jquery.sparkline.js",
			"${contextPath}/static/assets/js/flot/jquery.flot.js",
			"${contextPath}/static/assets/js/flot/jquery.flot.pie.js",
			"${contextPath}/static/assets/js/flot/jquery.flot.resize.js",
			"${contextPath}/static/assets/js/flot/jquery.flot.categories.js",
			"${contextPath}/static/assets/js/activities-serverload.js", null ]
	$('.page-content-area')
			.ace_ajax(
					'loadScripts',
					scripts,
					function() {
						
					});
</script>
</body>




 