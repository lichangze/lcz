<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="${contextPath}/static/dispatcher/assets/css/bootstrap.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/images/css/layer.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/chosen.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/js/date-time/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet"  href="${contextPath}/static/assets/css/bootstrap-multiselect.css" />
<script type="text/javascript" src="${contextPath}/static/assets/js/jquery.js"></script>
<script src="${contextPath}/static/assets/js/bootstrap.js"></script>
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
<script src="${contextPath}/static/jquery-validation-1.14.0/jquery.validate.js"></script>
<script src="${contextPath}/static/assets/js/chosen.jquery.min.js"></script>
<script src="${contextPath}/static/json/json2.js"></script>
<script type="text/javascript" src="${contextPath}/static/assets/js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="${contextPath}/static/json/ajaxfilesupload.js"></script>
<script src="${contextPath}/static/assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
<script src="${contextPath}/static/assets/js/date-time/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="${contextPath}/static/layer/layer.js"></script>
<script src="${contextPath}/static/dispatcher/assets/js/jquery-dateFormat.js"></script>
<link rel="stylesheet" href="${contextPath}/static/select2/dist/css/select2.min.css" />
<script src="${contextPath}/static/select2/dist/js/select2.min.js"></script>
<script src="${contextPath}/static/select2/dist/js/i18n/zh-CN.js"></script>
<script src="${contextPath}/static/dispatcher/assets/js/jquery.autocomplete.js"></script>
<link rel="stylesheet" href="${contextPath}/static/dispatcher/assets/js/jquery.autocomplete.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/images/css/layer.css" />
<script src="${contextPath}/static/assets/images/js/layer.js"></script>
<link rel="stylesheet"
  href="${contextPath}/static/ztree/css/zTreeStyle/zTreeStyle.css"
  type="text/css" />
<script type="text/javascript"
    src="${contextPath}/static/ztree/js/jquery.ztree.core-3.5.js"></script>
  <script type="text/javascript"
    src="${contextPath}/static/ztree/js/jquery.ztree.excheck-3.5.js"></script>
  <script type="text/javascript"
    src="${contextPath}/static/ztree/js/jquery.ztree.exedit-3.5.js"></script>
 <style type="text/css">
.select2-selection__rendered{
	font-size: 13px;
}
 </style>	

<div id="row">
	<form id="form_job" name="form_job" method="post"
		class="form-horizontal" role="form">
		<input type="hidden" name="poId" id="poId" value="${poEntity.id}">
		<input type="hidden" name="id" id="id" value="${id}">
		<input type="hidden" name="oper" id="oper" value="${oper}">
		<fieldset>
			<legend></legend>
		<div class="form-group">
				<label for="" class="col-sm-2 control-label">位置</label>
				<div class="col-sm-4">
					<input name="lot" id="lot"
						class="form-control input-sm js-example-placeholder-multiple"
						value="${poEntity.positionName}" />
				</div>
				<label for="" class="col-sm-2 control-label">类型</label>
				<div class="col-sm-4">
					<select class="form-control js-data-example-ajax" id="workType" name="workType" style="width: 320px" >
						<option value="jobFault">故障处理</option>
						<option value="point">请消点处理</option>
							</select>
				</div>
				<label for="" class="col-sm-2 control-label">工作组</label>
				<div class="col-sm-4">
					<span class="span">
						<label id="reportLabel" class="pull-left inline">
							<select class="form-control js-data-example-ajax" id="workGroup" name="workGroup" style="width: 320px;" >
							${workGroup}
							</select>
						</label>
					</span>
				</div>
				<label for="" class="col-sm-2 control-label">备注</label>
				<div class="col-sm-4">
					<input name="remake" id="remake"
						class="form-control input-sm js-example-placeholder-multiple"
						value="${remake}" 
						/> 
				</div>
			</div>
		</fieldset>

	</form>
	<div class="modal-footer no-margin-top">
		<div class="text-right">
			<a id="sData" onclick="doSave()"
				class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm btn-primary">
				<i class="ace-icon fa fa-check"></i>提交 <span
				class="ui-icon ui-icon-disk" style="display: none;"></span>
			</a> <a id="cData" onclick="hiddenView()"
				class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm">
				<i class="ace-icon fa fa-times"></i>取消 <span
				class="ui-icon ui-icon-close" style="display: none;"></span>
			</a>
		</div>
	</div>
</div>
<script type="text/javascript">

	var index = parent.layer.getFrameIndex(window.name);


	jQuery(function() {
		$('#workGroup').select2({
		  	placeholder: "请选择工作组",
			  multiple: false,
			  quietMillis: 100,
			  ajax: {
					url: "${contextPath}/sys/qcellcore/getWorkGroupSelect",
				    dataType: 'json',
				    type: 'POST',
				    data: function(term, page) {
				      return {
				        search: term.term,
				        page: page || 1
				      }
				    },
				     initSelection : function (element, callback) {   // 初始化时设置默认值
				        var data = [];
				        $(element.val().split("^")).each(function () {
				            data.push({ id: this, text: this });
				        });
				        callback(data);
				   	 },
				      processResults: function (data, page) {  
				          return {  
				                   results: data
				                };  
				            },             
				    cache: true  
				    },
				  escapeMarkup: function (markup) { return markup; },
				  minimumInputLength: 2,  //至少输入多少个字符后才会去调用ajax  
				  maximumInputLength: 20, //最多能输入多少个字符后才会去调用ajax  
				   formatSelection : function (item) { return item.id; },  // 选择结果中的显示
	    		   formatResult    : function (item) { return item.id; },  // 搜索列表中的显示
	    		   language: "zh-CN", 
				});	
})

jQuery(function() {
	if($("#oper").val() == 'view'){
		$("#sData").hide();
	}
})


	function doSave() {
		$.ajax({
				cache : true,
				type : "POST",
				url : "${contextPath}/sys/qcellcore/doSave",
				data : $('#form_job').serialize(),// 你的formid
				async : false,
				success : function(data) {
					var data = $.parseJSON(data);
					if (data.falg) {
						layer.msg("保存成功",{
								  icon: 1,
								  skin: 'layer-ext-moon' 
						});
						hiddenView();
					}else{
						layer.msg("保存失败"+data.msg,{
								  icon: 2,
								  skin: 'layer-ext-moon' 
						});
					};
						
				}
			});
	}

	function hiddenView() {
		parent.$("#grid-table").trigger("reloadGrid");
		parent.layer.close(index);
	}

</script>