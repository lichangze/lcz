<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>全量数据仓库主数据维护平台</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet"
	href="${contextPath}/static/assets/css/bootstrap.css" />
<link rel="stylesheet"
	href="${contextPath}/static/Font-Awesome/css/font-awesome.min.css" />
<!-- text fonts -->
<link rel="stylesheet"
	href="${contextPath}/static/assets/css/ace-fonts.css" />
<link rel="stylesheet"
	href="${contextPath}/static/assets/css/activities-serverload.css" />
<!-- ace styles -->
<link rel="stylesheet" href="${contextPath}/static/assets/css/ace.css" />

<link rel="stylesheet" href="${contextPath}/static/bmzy/css/common.css" />
<link rel="stylesheet"
	href="${contextPath}/static/assets/css/chosen.css" />

<link rel="stylesheet"
	href="${contextPath}/static/ztree/css/zTreeStyle/zTreeStyle.css"
	type="text/css" />
<link rel="stylesheet"
	href="${contextPath}/static/assets/css/datepicker.css" />
<link rel="stylesheet"
	href="${contextPath}/static/calendar/fullcalendar/fullcalendar.css" />
<link rel="stylesheet"
	href="${contextPath}/static/calendar/dhtmlcalendar/js/dhtmlxScheduler_v4.1.0/dhtmlxscheduler.css" />
<link rel="stylesheet"
	href="${contextPath}/static/calendar/dhtmlcalendar/js/dhtmlxScheduler_v4.1.0/dhtmlxLayout/web/dhtmlx.css" />
<link rel="stylesheet" href="${contextPath}/static/calendar/dhtmlcalendar/js/dhtmlxScheduler_v4.1.0/dhtmlxscheduler.css" type="text/css" charset="utf-8"/>
<link rel="stylesheet" href="${contextPath}/static/jNotify/jNotify.jquery.css" type="text/css" charset="utf-8"/>
<link rel="stylesheet" href="${contextPath}/static/assets/images/css/layer.css" />




<%-- <link rel="stylesheet" href="${contextPath}/static/assets/css/jquery.ui.plupload.css"/>
 --%>
<!--[if lte IE 9]>
			<link rel="stylesheet" href="${contextPath}/static/assets/css/ace-part2.css" class="ace-main-stylesheet" />
		<![endif]-->
<!--[if lte IE 9]>
		  <link rel="stylesheet" href="${contextPath}/static/assets/css/ace-ie.css" />
		<![endif]-->
<!-- ace settings handler -->

<!-- <script type="text/javascript" src="http://api.map.baidu.com/api?v=1.3"></script> -->
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lte IE 8]>
		<script src="${contextPath}/static/assets/js/html5shiv.js"></script>
		<script src="${contextPath}/static/assets/js/respond.js"></script>
		<![endif]-->
</head>
<body class="no-skin" onload="javascript:init();">

<div hidden="true"><OBJECT classid=clsid:5EEEA87D-160E-4A2D-8427-B6C333FEDA4D id=RTXAX></OBJECT> </div>
	<!-- #section:basics/navbar.layout -->
	<div id="navbar" class="navbar navbar-default">
		<div class="navbar-container" id="navbar-container">
			<!-- #section:basics/sidebar.mobile.toggle -->
			<button type="button" class="navbar-toggle menu-toggler pull-left"
				id="menu-toggler" data-target="#sidebar">
				<span class="sr-only"> Toggle sidebar </span> <span class="icon-bar">
				</span> <span class="icon-bar"> </span> <span class="icon-bar"> </span>
			</button>
			<!-- /section:basics/sidebar.mobile.toggle -->
			<div class="navbar-header pull-left">
				<!-- #section:basics/navbar.layout.brand -->
				<a href="#" class="navbar-brand"> <small> <i
						class="fa fa-subway"></i> &nbsp;全量数据仓库主数据维护平台
				</small>
				</a>
				
			</div>
			<!-- #section:basics/navbar.dropdown -->
			<div class="navbar-buttons navbar-header pull-right"
				role="navigation">
				<ul class="nav ace-nav">

					<!-- #section:basics/navbar.user_menu -->
					<li class="light-blue"><a data-toggle="dropdown" href="#"
						class="dropdown-toggle"> <img class="nav-user-photo"
							src="${contextPath}/static/assets/avatars/user.jpg"
							alt="Jason's Photo" /> <span> <c:out
									value="${sessionScope.SESSION_SYS_USER.emp_name}" />
						</span> <i class="ace-icon fa fa-caret-down"></i>
					</a>
						<ul
							class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li class="divider"></li>
							<li><a onclick="about()"> <i
									class="ace-icon fa  fa-info-circle"></i> 关于
							</a></li>
							<li><a href="${contextPath}/sys/sysuser/logout"> <i
									class="ace-icon fa fa-power-off"></i> 退出
							</a></li>
						</ul></li>
					<!-- /section:basics/navbar.user_menu -->
				</ul>
			</div>
			<!-- /section:basics/navbar.dropdown -->
		</div>
		<!-- /.navbar-container -->
	</div>
	<!-- /section:basics/navbar.layout -->
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		<!-- #section:basics/sidebar -->
		<div id="sidebar" class="sidebar responsive">
			<script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'fixed')
				} catch (e) {
				}
			</script>

			<!-- /.sidebar-shortcuts -->
			<ul class="nav nav-list">
				<c:forEach var="sysmenu" items="${sysmenuList}">
					<c:if test="${sysmenu != null}">
						<li class=""><a
							href="<c:out value='${sysmenu.menuAddress}'/>"
							class="dropdown-toggle"> <i
								class="<c:out value='${sysmenu.menuClass}'/>"></i> <span
								class="menu-text"><c:out value="${sysmenu.menuName}" /></span>
								<b class="arrow fa fa-angle-down"></b>
						</a> <b class="arrow"></b>
							<ul class="submenu">
								<c:forEach var="subSysMenuList"	items="${sysmenu.subSysMenuList}">


									<c:choose>
										<c:when
											test="${fn:contains(subSysMenuList.menuAddress,'page/')}">
											<li class=""><a data-url="<c:out value='${subSysMenuList.menuAddress}'/>"
												href="home#<c:out value='${subSysMenuList.menuAddress}'/>">
													<i class="<c:out value='${subSysMenuList.menuClass}'/>"></i>
													<c:out value="${subSysMenuList.menuName}" />
											</a> <b class="arrow"></b></li>
										</c:when>
										<c:otherwise>
											<li class=""><a target="${subSysMenuList.herfTarget }"
												data-url="<c:out value='${subSysMenuList.menuAddress}'/>"
												href="<c:out value='${subSysMenuList.menuAddress}'/>"> <i
													class="<c:out value='${subSysMenuList.menuClass}'/>"></i> <c:out
														value="${subSysMenuList.menuName}" />
											</a> <b class="arrow"></b></li>
										</c:otherwise>
									</c:choose>
							</c:forEach>
							</ul></li>
					</c:if>
				</c:forEach>
			</ul>
			<!-- /.nav-list -->
			<!-- #section:basics/sidebar.layout.minimize -->
			<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
				<i class="ace-icon fa fa-angle-double-left"
					data-icon1="ace-icon fa fa-angle-double-left"
					data-icon2="ace-icon fa fa-angle-double-right"></i>
			</div>
			<!-- /section:basics/sidebar.layout.minimize -->
			<script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'collapsed')
				} catch (e) {
				}
			</script>
		</div>
		<!-- /section:basics/sidebar -->
		<div class="main-content">
			<!-- #section:basics/content.breadcrumbs -->
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="">
							首页 </a></li>
				</ul>
				<!-- /.breadcrumb -->
				<!-- #section:basics/content.searchbox -->
                 <!-- 
				<div class="nav-search" id="nav-search">
					<form class="form-search" >
						<span class="input-icon"> <input type="text"
							placeholder="Search ..." class="nav-search-input"
							id="nav-search-input" autocomplete="off" /> <i
							class="ace-icon fa fa-search nav-search-icon"></i>
						</span>
					</form>
				</div>
                   -->
				<!-- /.nav-search -->
				<!-- /section:basics/content.searchbox -->
			</div>
			<!-- /section:basics/content.breadcrumbs -->
			<div class="page-content">
				<!-- #section:settings.box -->
				<div class="ace-settings-container" id="ace-settings-container">
					<div class="btn btn-app btn-xs btn-warning ace-settings-btn"
						id="ace-settings-btn">
						<i class="ace-icon fa fa-cog bigger-130"></i>
					</div>
					<div class="ace-settings-box clearfix" id="ace-settings-box">
						<div class="pull-left width-50">
							<!-- #section:settings.skins -->
							<div class="ace-settings-item">
								<div class="pull-left">
									<select id="skin-colorpicker" class="hide">
										<option data-skin="no-skin" value="#438EB9">#438EB9</option>
										<option data-skin="skin-1" value="#222A2D">#222A2D</option>
										<option data-skin="skin-2" value="#C6487E">#C6487E</option>
										<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
									</select>
								</div>
								<span> &nbsp; 选择皮肤 </span>
							</div>
							<!-- /section:settings.skins -->
							<!-- #section:settings.navbar -->
							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-navbar" /> <label class="lbl"
									for="ace-settings-navbar"> 固定导航栏 </label>
							</div>
							<!-- /section:settings.navbar -->
							<!-- #section:settings.sidebar -->
							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-sidebar" /> <label class="lbl"
									for="ace-settings-sidebar"> 固定侧边栏 </label>
							</div>
							<!-- /section:settings.sidebar -->
							<!-- #section:settings.breadcrumbs -->
							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-breadcrumbs" /> <label class="lbl"
									for="ace-settings-breadcrumbs"> 固定面包屑导航 </label>
							</div>
							<!-- /section:settings.breadcrumbs -->
							<!-- #section:settings.rtl -->
							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-rtl" /> <label class="lbl"
									for="ace-settings-rtl"> 切换到左边 </label>
							</div>
							<!-- /section:settings.rtl -->
							<!-- #section:settings.container -->
							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-add-container" /> <label class="lbl"
									for="ace-settings-add-container"> 切换到窄屏 </label>
							</div>
							<!-- /section:settings.container -->
						</div>
						<!-- /.pull-left -->
						<div class="pull-left width-50">
							<!-- #section:basics/sidebar.options -->
							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-hover" /> <label class="lbl"
									for="ace-settings-hover"> 鼠标滑过显示子菜单 </label>
							</div>
							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-compact" /> <label class="lbl"
									for="ace-settings-compact"> 紧凑侧边栏 </label>
							</div>
							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-highlight" /> <label class="lbl"
									for="ace-settings-highlight"> 菜单项突出 </label>
							</div>
							<!-- /section:basics/sidebar.options -->
						</div>
						<!-- /.pull-left -->
					</div>
					<!-- /.ace-settings-box -->
				</div>
				<!-- /.ace-settings-container -->
				<!-- /section:settings.box -->
				<div class="page-content-area" data-ajax-content="true">
					<!-- ajax content goes here -->
				</div>
				<!-- /.page-content-area -->
			</div>
			<!-- /.page-content -->
		</div>
		<!-- /.main-content -->
		<div class="footer">
			<div class="footer-inner">
				<!-- #section:basics/footer -->
				<div class="footer-content">
					<span class="bigger-120"> <span class="blue bolder">
							研发中心 </span> &copy; 2015-2017
					</span>
				</div>
				<!-- /section:basics/footer -->
			</div>
		</div>
		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
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
	<script src="${contextPath}/static/assets/js/bootstrap.js"></script>
	<!-- ace scripts -->
	<script src="${contextPath}/static/assets/js/ace/elements.scroller.js"></script>
	<script
		src="${contextPath}/static/assets/js/ace/elements.colorpicker.js"></script>
	<script src="${contextPath}/static/assets/js/ace/elements.fileinput.js"></script>
	<script src="${contextPath}/static/assets/js/ace/elements.typeahead.js"></script>
	<script src="${contextPath}/static/assets/js/ace/elements.wysiwyg.js"></script>
	<script src="${contextPath}/static/assets/js/ace/elements.spinner.js"></script>
	<script src="${contextPath}/static/assets/js/ace/elements.treeview.js"></script>
	<script src="${contextPath}/static/assets/js/ace/elements.wizard.js"></script>
	<script src="${contextPath}/static/assets/js/ace/elements.aside.js"></script>
	<script src="${contextPath}/static/assets/js/ace/ace.js"></script>
	<script src="${contextPath}/static/assets/js/ace/ace.ajax-content.js"></script>
	<script src="${contextPath}/static/assets/js/ace/ace.touch-drag.js"></script>
	<script src="${contextPath}/static/assets/js/ace/ace.sidebar.js"></script>
	<script	src="${contextPath}/static/assets/js/ace/ace.sidebar-scroll-1.js"></script>
	<script src="${contextPath}/static/assets/js/ace/ace.submenu-hover.js"></script>
	<script src="${contextPath}/static/assets/js/ace/ace.widget-box.js"></script>
	<script src="${contextPath}/static/assets/js/ace/ace.settings.js"></script>
	<script src="${contextPath}/static/assets/js/ace/ace.settings-rtl.js"></script>
	<script src="${contextPath}/static/assets/js/ace/ace.settings-skin.js"></script>
	<script src="${contextPath}/static/assets/images/js/layer.js"></script>

	<script
		src="${contextPath}/static/assets/js/ace/ace.widget-on-reload.js"></script>
	<script
		src="${contextPath}/static/assets/js/ace/ace.searchbox-autocomplete.js"></script>
	<script src="${contextPath}/static/json/json2.js"></script>
	<script src="${contextPath}/static/jquery-validation-1.14.0/jquery.validate.js"></script>

	<script src="${contextPath}/static/assets/js/chosen.jquery.min.js"></script>
	<!-- 
		<script type="text/javascript" src="../../../js/jquery-1.4.4.min.js"></script>
		 -->
	<script type="text/javascript"
		src="${contextPath}/static/ztree/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript"
		src="${contextPath}/static/ztree/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript"
		src="${contextPath}/static/ztree/js/jquery.ztree.exedit-3.5.js"></script>
	<script type="text/javascript"
		src="${contextPath}/static/jqueryui/js/jquery-ui-1.10.4.custom.js"></script>
	<script
		src="${contextPath}/static/assets/js/date-time/bootstrap-datepicker.js"></script>

	<script
		src="${contextPath}/static/assets/js/date-time/daterangepicker.min.js"></script>
	<script
		src="${contextPath}/static/assets/js/date-time/bootstrap-datepicker.min.js"></script>
	<script
		src="${contextPath}/static/assets/js/date-time/bootstrap-datetimepicker.js"></script>
	<script src="${contextPath}/static/assets/js/date-time/moment.min.js"></script>
	<script src="${contextPath}/static/assets/js/date-time/bootstrap-timepicker.min.js"></script>
	<script src="${contextPath}/static/jNotify/jNotify.jquery.js"></script>
	<script src="${contextPath}/static/assets/images/js/layer.js"></script>

</body>
<script type="text/javascript">

function about(){
	    var hrefLink='${contextPath}/sys/about';
	    layer.open({
	           type: 2, //page层
	           area: ['300px', '200px'],
	           title: '关于',
	           skin: 'layui-layer-lan',
	           fix: false, //不固定
	           moveType: 1, //拖拽风格，0是默认，1是传统拖动
	           shift: 1, //0-6的动画形式，-1不开启
	           content: [hrefLink, 'no']
	         });     
}




</script>
</html>
