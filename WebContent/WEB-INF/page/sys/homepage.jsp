<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<!-- ajax layout which only needs content area -->
<div class="row" style="width: 100%; height: 620px">
	<div class="col-xs-12" style="width: 100%; height: 100%">
		<div class="row" style="width: 100%; height: 100%">
			 <iframe src="http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?formlet=report.frm" style="width:100%; height:100%;"></iframe>
		</div>
	</div>
	<!-- /.row -->


	</div>
	<!-- /.col -->

<!-- /.row -->

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
  <script src="${contextPath}/static/assets/js/excanvas.js"></script>
<![endif]-->
<script type="text/javascript">
 
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
						// inline scripts related to this page
						jQuery(function($) {
							
						})
					});
</script>
