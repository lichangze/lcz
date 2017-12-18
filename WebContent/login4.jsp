<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>OMC|设备维修信息系统</title>


<meta name="description" content="login.jsp" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="${contextPath}/static/assets/css/bootstrap.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/font-awesome.min.css" />

<!-- text fonts -->
<link rel="stylesheet"	href="${contextPath}/static/assets/css/ace-fonts.css" />

<!-- ace styles -->
<link rel="stylesheet" href="${contextPath}/static/assets/css/ace.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/images/css/layer.css" />

<!--[if lte IE 9]>
			<link rel="stylesheet" href="${contextPath}/static/assets/css/ace-part2.css" />
		<![endif]-->
<link rel="stylesheet"
	href="${contextPath}/static/assets/css/ace-rtl.css" />

<!--[if lte IE 9]>
		  <link rel="stylesheet" href="${contextPath}/static/assets/css/ace-ie.css" />
		<![endif]-->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
		<script src="${contextPath}/static/assets/js/html5shiv.js"></script>
		<script src="${contextPath}/static/assets/js/respond.js"></script>
		<![endif]-->
</head>

<body class="login-layout light-login">

	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1" style="margin-left: 225px">
					<div class="login-container" style="margin-left: 533px;margin-top: 79px;">

						<div class="center">
							<h1>
								<span class="red">&nbsp;</span>
							</h1>
						</div>

						<div class="space-6"></div>
						<div class="space-6"></div>
						<br/><br/><br/>
						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="ace-icon fa fa-subway green"></i> 登录 OMC 设备维修信息系统
										</h4>

										<div class="space-6"></div>

										<form id="validationLoginForm" method="post" action="#" >
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <!-- <input id="loginEmail" name="email" type="text" class="form-control" placeholder="邮箱" data-rel="tooltip" title="邮箱作为账号" data-placement="right" /> -->
														<input id="phone" name="phone" type="text"
														class="form-control" value=""
														placeholder="电话" /> <i class="ace-icon fa fa-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														id="loginPassword" name="password" type="password"
														class="form-control" value="" placeholder="密码" /> <i
														class="ace-icon fa fa-lock"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <span
														id="loginTip" style="color: #A94442"></span>
												</span>
												</label>

												<div class="space"></div>

												<div class="clearfix">
												

													<button id="loginButton" type="button"
														class="width-35 pull-right btn btn-sm btn-primary">
														<i class="ace-icon fa fa-key"></i> <span
															class="bigger-110">登录</span>
													</button>
												</div>

												<div id="detail" class="space-4">${detail}</div>
											</fieldset>
										</form>

									</div>
									
								</div>
								<!-- /.widget-body -->
							</div>
							<!-- /.login-box -->



							<!-- /.signup-box -->
						</div>
						<!-- /.position-relative -->
						<div class="navbar-fixed-top align-right">
							<br /> &nbsp; <a id="btn-login-dark" href="#">实景</a> &nbsp; <span
								class="blue">/</span> &nbsp;  <a id="btn-login-light"
								href="#">地铁</a> &nbsp;<span class="blue">/</span>&nbsp; <a id="btn-login-blur" href="#">高山</a>
							&nbsp;  &nbsp; &nbsp; &nbsp;
						</div>
					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.main-content -->
		<div class="footer">
			<div class="footer-inner">
				<!-- #section:basics/footer -->
				<div class="footer-content-nobordertop">
				
				</div>
			
			</div>
		</div>
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->
	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='${contextPath}/static/assets/js/jquery.js'>"
								+ "<"+"/script>");
	</script>
	<!-- <![endif]-->

	<!--[if IE]>
		<script type="text/javascript">
 			window.jQuery || document.write("<script src='${contextPath}/static/assets/js/jquery1x.js'>"+"<"+"/script>");
		</script>
		<![endif]-->

	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='${contextPath}/static/assets/js/jquery.mobile.custom.js'>"
							+ "<"+"/script>");
	</script>

	<script type="text/javascript"
		src="${contextPath}/static/assets/js/jquery.validate.js"></script>
	<script type="text/javascript"
		src="${contextPath}/static/assets/js/tooltip.js"></script>
	<script type="text/javascript"
		src="${contextPath}/static/assets/js/date-time/bootstrap-datepicker.js"></script>
	<script type="text/javascript"
		src="${contextPath}/static/assets/js/date-time/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="${contextPath}/static/assets/images/js/layer.js"></script>

</body>
<script type="text/javascript">
jQuery(function($) {
	$(document).on('click', '.toolbar a[data-target]', function(e) {
		e.preventDefault();
		var target = $(this).data('target');
		$('.widget-box.visible').removeClass('visible');// hide others
		$(target).addClass('visible');// show target
	});

	// 登录页面切换背景图
	$('#btn-login-dark').on('click', function(e) {
		$('body').attr('class', 'login-layout');
		e.preventDefault();
	});
	$('#btn-login-light').on('click', function(e) {
		$('body').attr('class', 'login-layout light-login');
		e.preventDefault();
	});
	$('#btn-login-blur').on('click', function(e) {
		$('body').attr('class', 'login-layout blur-login');
		e.preventDefault();
	});	
	
	$('#loginButton').on('click',function(e){
		
		$.ajax({
			cache : true,
			type : "POST",
			url : "${contextPath }/sys/sysuser/login",
			data : $('#validationLoginForm').serialize(),// 你的formid
			async : false,
			error : function(request) {
			},
			success : function(data) {
				if(data=='success'){
					location.href='${contextPath}/aems/home';
				}else{
					layer.msg(data);
				}
			}
		});
	
	});

});

</script>
</html>
