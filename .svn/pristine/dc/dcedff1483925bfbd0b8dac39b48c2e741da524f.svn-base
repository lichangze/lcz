<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet"
	href="${contextPath}/static/dispatcher/assets/css/bootstrap.css" />
<link rel="stylesheet"
	href="${contextPath}/static/assets/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="${contextPath}/static/ztree/css/zTreeStyle/zTreeStyle.css" />
<link rel="stylesheet"
	href="${contextPath}/static/select2/dist/css/select2.min.css" />
<link rel="stylesheet"
	href="${contextPath}/static/assets/images/css/layer.css" />
<script type="text/javascript"
	src="${contextPath}/static/assets/js/jquery.js"></script>
<script src="${contextPath}/static/assets/js/bootstrap.js"></script>
<script src='${contextPath}/static/assets/js/jquery.js'></script>
<script src="${contextPath}/static/json/json2.js"></script>
<script src="${contextPath}/static/select2/dist/js/select2.min.js"></script>
<script src="${contextPath}/static/assets/images/js/layer.js"></script>
<script src="${contextPath}/static/assets/js/jqGrid/jquery.jqGrid.js"></script>
<script src="${contextPath}/static/assets/js/jqGrid/i18n/grid.locale-cn.js"></script>
<link rel="stylesheet" href="${contextPath}/static/assets/images/css/layer.css" />
<script src="${contextPath}/static/assets/images/js/layer.js"></script>
			

<div id="row">
	<form id="form_job" name="form_job" method="post"
		class="form-horizontal" role="form">
		<fieldset>
			<legend></legend>

			<div class="form-group">
				<div style="text-align:center;font-size:17px;margin-top:-15px;">OMC设备维修信息系统</div>
				<div style="text-align:center;margin-top:5px;">版本号:V1.0.20</div>
				<div style="text-align:center;margin-top:5px;">时间:2017-06-14</div>				
			</div>

		</fieldset>

	</form>
	<div class="modal-footer no-margin-top">
		<div class="text-right">
			<a id="sData" onclick="hiddenView()"
				class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm btn-primary">
				<i class="ace-icon fa fa-check"></i>确认 <span class="ui-icon ui-icon-disk" style="display: none;"></span>
			</a>
		</div>
	</div>
</div>
<script type="text/javascript">

	var index = parent.layer.getFrameIndex(window.name);

	
	function hiddenView() {
		parent.$("#grid-table").trigger("reloadGrid");
		parent.layer.close(index);
	}

</script>
