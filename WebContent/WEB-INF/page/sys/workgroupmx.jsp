<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<link rel="stylesheet"
	href="${contextPath}/static/assets/css/jquery-ui.css" />
<link rel="stylesheet"
	href="${contextPath}/static/assets/css/datepicker.css" />
<link rel="stylesheet"
	href="${contextPath}/static/assets/css/ui.jqgrid.css" />
<link rel="stylesheet"
	href="${contextPath}/static/ztree/css/zTreeStyle.css" />
<link rel="stylesheet"
	href="${contextPath}/static/assets/css/chosen.css" />
<link rel="stylesheet"
	href="${contextPath}/static/assets/css/bootstrap-datetimepicker.css" />
<link rel="stylesheet"
	href="${contextPath}/static/assets/css/bootstrap-duallistbox.css" />
<link rel="stylesheet"
	href="${contextPath}/static/assets/css/bootstrap-multiselect.css" />
<link rel="stylesheet"
	href="${contextPath}/static/assets/css/select2.css" />
<link rel="stylesheet"
	href="${contextPath}/static/jNotify/jNotify.jquery.css" />
<script src="${contextPath}/static/json/json2.js"></script>
<div id="modal-table" class="modal fade" tabindex="-1"
	data-backdrop="static">
	<div class="modal-dialog">
		<form name="form1" method="post">
			<input type="hidden" id="workGroupNo" name="workGroupNo">
			<div class="modal-content">
				<div class="modal-header no-padding">
					<div class="table-header" style="background: #307ecc">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">
							<span class="white">&times;</span>
						</button>
						维护专业人员
					</div>
				</div>
				<div class="modal-body"
					style="max-height: 500px; overflow-y: scroll;">
					<div class="zTreeDemoBackground left">
						<ul id="treeDemo1" class="ztree"></ul>
					</div>
				</div>
				<div class="modal-footer no-margin-top">
					<div class="text-center">
						<a id="submitButton" type="submit"
							class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm btn-primary"
							onclick="doSubmit()"> <i class="ace-icon fa fa-check"></i>提交
							<span class="ui-icon ui-icon-disk" style="display: none;"></span>
						</a> <a id="cData"
							class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm"
							data-dismiss="modal" aria-hidden="true"> <i
							class="ace-icon fa fa-times"></i>取消 <span
							class="ui-icon ui-icon-close" style="display: none;"></span>
						</a>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</form>
	</div>
	<!-- /.modal-dialog -->
</div>

<div class="widget-header">
	<h4></h4>
	<div class="fm-button btn btn-sm btn-primary">
		<a id="cData" onclick="black()" class="white" data-dismiss="modal"
			style="text-decoration: none;"> <i class="ace-icon fa fa-reply"></i>返回
		</a>
	</div>
	<div class="fm-button btn btn-sm btn-primary" style="float: right">
		<a id="cData" onclick="submit()" class="white" data-dismiss="modal"
			style="text-decoration: none;"> <i class="ace-icon fa fa-check"></i>保存
		</a>
	</div>
</div>
<div id="menuContent1" class="menuContent" tabindex="-1"
	data-backdrop="static"
	style="position: absolute; height: 100%; width: 100%; position: fixed; left: 0px; top: 0px; z-index: 1039; opacity: 0.3; display: none; background: #000">
</div>
<br>
<form action="" id="form" name="form" method="post">
	<input type="hidden" id="id" name="id" value="${workGroup.id}" /> <input
		type="hidden" id="orgId" name="orgId"
		value="${workGroup.sysOrgStru.id}" />
	<table class="bmzy-table table-condensed" style="margin-bottom: 0px;">
		<tr>
			<td>名称:</td>
			<td style="width: 200px;"><input maxlength=20 id="workGroupName"
				name="workGroupName" class="form-control"
				value="${workGroup.workGroupName}" /></td>
			<td>公私属性:</td>
			<td><select id="prvaiteOwned" name="prvaiteOwned">
					<c:choose>
						<c:when test="${workGroup.prvaiteOwned}">
							<option value="true" selected>公有</option>
							<option value="false">私有</option>
						</c:when>
						<c:otherwise>
							<option value="false" selected>私有</option>
							<option value="true">公有</option>
						</c:otherwise>
					</c:choose>
			</select></td>
			<td style="width: 100px; text-align: center;">备注:</td>
			<td><input id="remarks" maxlength=50 name="remarks"
				class="form-control" value="${workGroup.remarks}"></input></td>

		</tr>
	</table>
	<br>
	<div class="col-md-12">
		<ul class="nav nav-tabs padding-12 tab-color-blue background-blue"
			id="myTab4">
			<li class="active"><a data-toggle="tab" href="#work_inventory">工作组人员</a></li>
		</ul>
	</div>
	<div class="col-md-12">
		<div class="tab-content aaa">
			<div id="work_inventory" class="tab-pane fade in active">
				<div class="widget-body">
					<table id="grid-table"></table>
					<div id="grid-pager"></div>
				</div>
			</div>

		</div>
	</div>
</form>


<script type="text/javascript">
	function setCheckedNodes() {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo1");
		var nodes = zTree.getCheckedNodes(true);
		var strCheckedNodes = "";
		for (var i = 0, iLen = nodes.length; i < iLen; i++) {
			strCheckedNodes += nodes[i].id + ",";
		}
		if (strCheckedNodes.length > 0) {
			strCheckedNodes = strCheckedNodes.substring(0,
					strCheckedNodes.length - 1);
		}
		$("#CheckedNodes").attr("value", strCheckedNodes);
		var workGroupNo = $("#workGroupNo").val();
		htmlobj = $.ajax({
			url : "${contextPath}/sys/workgroup/saveOrgUser?workGroupNo="
					+ workGroupNo + "&CheckedNodes=" + strCheckedNodes,
			async : false
		});
	}

	function doSubmit() {
		setCheckedNodes();
		$("#grid-table")
				.jqGrid(
						'setGridParam',
						{
							url : "${contextPath}/sys/workgroup/getWorkGroupUserList/${workGroup.id}",
							datatype : "json",
						}).trigger("reloadGrid");
		$('#modal-table').modal('hide');

	}

	var setting1 = {
		data : {
			simpleData : {
				enable : true
			}
		},
		check : {
			enable : true
		}
	};
	function Formatter(cellvalue) {
		$('#workGroupNo').val(cellvalue);
		var url = "${contextPath}/sys/workgroup/getOrgUsers";
		$.ajax({
			url : url,
			success : function(data) {
				$("#modal-table").modal("toggle");
				$.fn.zTree.init($("#treeDemo1"), setting1, eval(data));
				clearFlag = $("#last").attr("checked");
				//$("#selectAll").bind("click", selectAll);
				checkedZtree();
			}
		});
	}
	function checkedZtree() {
		var url = "${contextPath}/sys/workgroup/selectLine";
		$.ajax({
			url : url,
			data : {
				id : $('#workGroupNo').val()
			},
			success : function(data) {
				var lineID = data.split(",");
				var zTree = $.fn.zTree.getZTreeObj("treeDemo1");
				for (var i = 0; i < lineID.length; i++) {
					var node = zTree.getNodeByParam("id", lineID[i]);
					node.checked = true;
					zTree.updateNode(node);
				}
			}
		});
	}

	function black() {
		var message = $.ajax({
			url : "${contextPath}/sys/workgroup/isblack?id=${workGroup.id}",
			async : false
		});
		if (message == "0") {
			if (confirm("该工作组无负责人为无效状态，是否确定返回？")) {
				window.location.href = "${contextPath}/aems/home#page/workgroup";
			}
		} else {
			window.location.href = "${contextPath}/aems/home#page/workgroup";
		}
	}
	//保存
	function submit() {
		if ($("#form").valid()) {
			$.ajax({
				cache : true,
				type : "POST",
				url : "${contextPath}/sys/workgroup/operateWorkGroup?oper=exit",
				data : $('#form').serialize(),// 你的formid
				async : false,
				success : function(data) {
					var x_steps = data;
					if (x_steps.length != "0") {
						jError(x_steps, {
							VerticalPosition : 'center',
							HorizontalPosition : 'center'
						});
					} else {
						jSuccess("保存成功！", {
							VerticalPosition : 'center',
							HorizontalPosition : 'center'
						});
					}
				}
			});
		}
	}

	function zTree(id) {
		$("#menuContent").remove();
		var sid = id;
		var s = document.getElementById(sid);
		var par = s.parentNode;
		var ul_file = document.createElement("ul");
		ul_file.setAttribute("class", "ztree");
		ul_file.setAttribute("id", sid + "ztree");
		ul_file
				.setAttribute(
						"style",
						"position:absolute;z-index: 100; width: 160px; margin-top:0px; height: 180px; overflow: auto;");
		var div_file = document.createElement("div");
		div_file.setAttribute("class", "menuContent");
		div_file.setAttribute("id", "menuContent");
		div_file.appendChild(ul_file);
		par.appendChild(div_file);

		function hideMenu() {
			$("#menuContent").remove();

			$("#menuContent").fadeOut("fast");
			$("body").unbind("mousedown", onBodyDown);
		}
		function onBodyDown(event) {
			if (!(event.target.id == "menuBtn" || event.target.id == sid
					|| event.target.id == "menuContent" || $(event.target)
					.parents("#menuContent").length > 0)) {
				hideMenu();
			}
		}
		function onClick(e, treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj(sid + "ztree"), nodes = zTree
					.getSelectedNodes(), v = "";
			n = "";
			nodes.sort(function compare(a, b) {
				return a.id - b.id;
			});
			for (var i = 0, l = nodes.length; i < l; i++) {
				v += nodes[i].name + ",";
				n += nodes[i].id + ",";
			}
			if (v.length > 0)
				v = v.substring(0, v.length - 1);
			if (n.length > 0)
				n = n.substring(0, n.length - 1);
			// var cityObj = $("#"+sid);
			$("#" + sid).val(v);
			$("#orgId").val(n);

			hideMenu();
		}
		var setting = {
			view : {
				dblClickExpand : false
			},
			data : {
				simpleData : {
					enable : true
				}
			},
			callback : {
				onClick : onClick
			}
		};
		$.ajax({
			url : "${contextPath}/sys/workgroup/getOrgTree",
			success : function(data) {
				//json转化树
				$.fn.zTree.init($("#" + sid + "ztree"), setting, eval(data));
			}
		});

	}

	var scripts = [
			null,
			"${contextPath}/static/assets/js/date-time/bootstrap-datepicker.js",
			"${contextPath}/static/assets/js/date-time/locales/bootstrap-datepicker.zh-CN.js",
			"${contextPath}/static/assets/js/jqGrid/jquery.jqGrid.js",
			"${contextPath}/static/assets/js/jqGrid/i18n/grid.locale-cn.js",
			"${contextPath}/static/assets/js/date-time/bootstrap-datetimepicker.js",
			"${contextPath}/static/assets/js/date-time/locales/bootstrap-datetimepicker.zh-CN.js",
			"${contextPath}/static/assets/js/jquery.bootstrap-duallistbox.js",
			"${contextPath}/static/assets/js/jquery.dataTables.js",
			"${contextPath}/static/assets/js/jquery.validate.js",
			"${contextPath}/static/assets/js/jquery.dataTables.bootstrap.js",
			"${contextPath}/static/assets/js/chosen.jquery.js", null ]
	$('.page-content-area')
			.ace_ajax(
					'loadScripts',
					scripts,
					function() {
						// inline scripts related to this page
						$(document).one(
								'ajaxloadstart.page',
								function(e) {
									$('[class*=select2]').remove();
									$('select[name="duallistbox_demo1[]"]')
											.bootstrapDualListbox('destroy');
								});
						var demo1 = $('select[name="duallistbox_demo1[]"]')
								.bootstrapDualListbox(
										{
											infoTextFiltered : '<span class="label label-purple label-lg">Filtered</span>'
										});
						jQuery(function($) {
							var grid_selector = "#grid-table";
							var pager_selector = "#grid-pager";

							// resize to fit page size
							$(window).on(
									'resize.jqGrid',
									function() {
										$(grid_selector).jqGrid('setGridWidth',
												$(".aaa").width());
									})
							// resize on sidebar collapse/expand
							var parent_column = $(grid_selector).closest(
									'[class*="col-"]');
							$(document)
									.on(
											'settings.ace.jqGrid',
											function(ev, event_name, collapsed) {
												if (event_name === 'sidebar_collapsed'
														|| event_name === 'main_container_fixed') {
													// setTimeout is for webkit only to give time for DOM changes and then redraw!!!
													setTimeout(
															function() {
																$(grid_selector)
																		.jqGrid(
																				'setGridWidth',
																				parent_column
																						.width());
															}, 0);
												}
											})

							var hiddenCols = $
									.ajax({
										url : "${contextPath}/work/workstandard/getColHidden",
										async : false
									});
							var hiddenColsJSON = JSON
									.parse(hiddenCols.responseText);

							jQuery(grid_selector)
									.jqGrid(
											{
												subGrid : false,
												url : "${contextPath}/sys/workgroup/getWorkGroupUserList/${workGroup.id}",
												datatype : "json",
												//data: grid_data,
												height : 245,
												colNames : [ '', '工号', '姓名',
														'联系电话', '专业', '负责人' ],
												colModel : [
														{
															name : '',
															index : '',
															width : 80,
															fixed : true,
															sortable : false,
															resize : false,
															formatter : 'actions',
															formatoptions : {
																keys : true,
																//delbutton : false,//disable delete button
																delOptions : {
																	recreateForm : true,
																	beforeShowForm : beforeDeleteCallback
																}
															//editformbutton:true, editOptions:{recreateForm:true, beforeShowForm:beforeEditCallback}
															}
														},
														{
															name : 'sysUser.workNo',
															index : 'sysUser.workNo',
															label : '工号',
															width : 100,
															editable : false,
															hidden : (hiddenColsJSON.workNo == 'true'),
															editoptions : {
																size : "20",
																maxlength : "50"
															},
															searchoptions : {
																sopt : [ 'cn' ]
															},
															editrules : {
																required : true
															}
														},
														{
															name : 'sysUser.userName',
															index : 'sysUser.userName',
															label : '姓名',
															width : 100,
															editable : false,
															hidden : (hiddenColsJSON.userName == 'true'),
															editoptions : {
																size : "20",
																maxlength : "50"
															},
															searchoptions : {
																sopt : [ 'cn' ]
															},
															editrules : {
																required : true
															}
														},
														{
															name : 'sysUser.phone',
															index : 'phone',
															label : '联系电话',
															width : 100,
															editable : false,
															hidden : (hiddenColsJSON.phone == 'true'),
															editoptions : {
																size : "20",
																maxlength : "20"
															},
															search : false
														},
														{
															name : 'sysUser.sysOrgStru.orgName',
															index : 'orgNo',
															label : '专业',
															width : 120,
															editable : false,
															edittype : "select",
															hidden : (hiddenColsJSON.orgNo == 'true'),
															editoptions : {
																dataUrl : "${contextPath}/sys/sysorgstru/getSysOrgStruSelectList"
															},
															search : false
														},
														{
															name : 'isuser',
															index : 'isuser',
															label : '负责人',
															width : 80,
															editable : true,
															edittype : "checkbox",
															hidden : (hiddenColsJSON.status == 'true'),
															editoptions : {
																value : "是:否"
															},
															unformat : aceSwitch,
															search : false
														} ],
												sortname : "id",
												sortorder : "asc",
												viewrecords : true,
												rowNum : 6,
												rowList : [ 6, 10, 20 ],
												pager : pager_selector,
												altRows : true,
												multiselect : true,
												multiboxonly : true,
												loadComplete : function() {
													var table = this;
													setTimeout(
															function() {
																styleCheckbox(table);
																updateActionIcons(table);
																updatePagerIcons(table);
																enableTooltips(table);
															}, 0);
												},
												editurl : "${contextPath}/sys/workgroup/operateSysUser/${workGroup.id}",
											});

							$(window).triggerHandler('resize.jqGrid');// trigger window resize to make the grid get the correct size

							function aceSwitch(cellvalue, options, cell) {
								setTimeout(
										function() {
											$(cell)
													.find(
															'input[type=checkbox]')
													.addClass(
															'ace ace-switch ace-switch-5')
													.after(
															'<span class="lbl"></span>');
										}, 0);
							}

							// enable datepicker
							function pickDate(cellvalue, options, cell) {
								setTimeout(function() {
									$(cell).find('input[type=text]')
											.datepicker({
												format : 'yyyy-mm-dd',
												autoclose : true,
												language : 'zh-CN'
											});
								}, 0);
							}

							// navButtons
							jQuery(grid_selector)
									.jqGrid(
											'navGrid',
											pager_selector,
											{// navbar options
												edit : false,
												editicon : 'ace-icon fa fa-pencil blue',
												add : false,
												addicon : 'ace-icon fa fa-plus-circle purple',
												del : false,
												delicon : 'ace-icon fa fa-trash-o red',
												search : true,
												searchicon : 'ace-icon fa fa-search orange',
												refresh : true,
												refreshicon : 'ace-icon fa fa-refresh blue',
												view : true,
												viewicon : 'ace-icon fa fa-search-plus grey'
											},
											{
												// edit record form
												closeAfterEdit : true,
												// width: 700,
												recreateForm : true,
												beforeShowForm : function(e) {
													var form = $(e[0]);
													form
															.closest(
																	'.ui-jqdialog')
															.find(
																	'.ui-jqdialog-titlebar')
															.wrapInner(
																	'<div class="widget-header" />')
													style_edit_form(form);
												},
												errorTextFormat : function(
														response) {
													var result = eval('('
															+ response.responseText
															+ ')');
													return result.message;
												}
											},
											{
												// new record form
												// width: 700,
												closeAfterAdd : true,
												recreateForm : true,
												viewPagerButtons : false,
												beforeShowForm : function(e) {
													var form = $(e[0]);
													form
															.closest(
																	'.ui-jqdialog')
															.find(
																	'.ui-jqdialog-titlebar')
															.wrapInner(
																	'<div class="widget-header" />')
													style_edit_form(form);
												},
												errorTextFormat : function(
														response) {
													var result = eval('('
															+ response.responseText
															+ ')');
													return result.message;
												}
											},
											{
												// delete record form
												recreateForm : true,
												beforeShowForm : function(e) {
													var form = $(e[0]);
													if (form.data('styled'))
														return false;
													form
															.closest(
																	'.ui-jqdialog')
															.find(
																	'.ui-jqdialog-titlebar')
															.wrapInner(
																	'<div class="widget-header" />')
													style_delete_form(form);
													form.data('styled', true);
												},
												errorTextFormat : function(
														response) {
													var result = eval('('
															+ response.responseText
															+ ')');
													alert(result.message);
													return result.message;
												}
											},
											{
												// search form
												recreateForm : true,
												afterShowSearch : function(e) {
													var form = $(e[0]);
													form
															.closest(
																	'.ui-jqdialog')
															.find(
																	'.ui-jqdialog-title')
															.wrap(
																	'<div class="widget-header" />')
													style_search_form(form);
												},
												afterRedraw : function() {
													style_search_filters($(this));
												},
												multipleSearch : true
											/**
											 * multipleGroup:true, showQuery: true
											 */
											},
											{
												// view record form
												recreateForm : true,
												beforeShowForm : function(e) {
													var form = $(e[0]);
													form
															.closest(
																	'.ui-jqdialog')
															.find(
																	'.ui-jqdialog-title')
															.wrap(
																	'<div class="widget-header" />')
												}
											})

							jQuery(grid_selector)
									.jqGrid(
											'navButtonAdd',
											pager_selector,
											{
												caption : "",
												title : "编辑专业人员",
												buttonicon : "ace-icon fa fa-exchange purple",
												onClickButton : function() {
													Formatter("${workGroup.id}");
												},
												position : "first"
											});
							// add custom button to export the data to excel
							jQuery(grid_selector)
									.jqGrid(
											'navButtonAdd',
											pager_selector,
											{
												caption : "",
												title : "导出Excel",
												buttonicon : "ace-icon fa fa-file-excel-o green",
												onClickButton : function() {
													var keys = [], ii = 0, rows = "";
													var ids = $(grid_selector)
															.getDataIDs(); // Get All IDs
													var row = $(grid_selector)
															.getRowData(ids[0]); // Get First row to get the labels
													//var label = $(grid_selector).jqGrid('getGridParam','colNames');
													for ( var k in row) {
														keys[ii++] = k; // capture col names
														rows = rows + k + "\t"; // output each Column as tab delimited
													}
													rows = rows + "\n"; // Output header with end of line
													for (i = 0; i < ids.length; i++) {
														row = $(grid_selector)
																.getRowData(
																		ids[i]); // get each row
														for (j = 0; j < keys.length; j++)
															rows = rows
																	+ row[keys[j]]
																	+ "\t"; // output each Row as tab delimited
														rows = rows + "\n"; // output each row with end of line
													}
													rows = rows + "\n"; // end of line at the end
													var form = "<form name='csvexportform' action='${contextPath}/sys/sysuser/operateSysUser?oper=excel' method='post'>";
													form = form
															+ "<input type='hidden' name='csvBuffer' value='"
															+ encodeURI(encodeURI(rows))
															+ "'>";
													form = form
															+ "</form><script>document.csvexportform.submit();</sc" + "ript>";
													OpenWindow = window.open(
															'', '');
													OpenWindow.document
															.write(form);
													OpenWindow.document.close();
												}
											});
							$(document).one('ajaxloadstart.page', function(e) {
								$(grid_selector).jqGrid('GridUnload');
								$('.ui-jqdialog').remove();
							});

							/* function updateActionIcons(table) {
							} */

							// replace icons with FontAwesome icons like above
							function updatePagerIcons(table) {
								var replacement = {
									'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
									'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
									'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
									'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
								};
								$(
										'.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon')
										.each(
												function() {
													var icon = $(this);
													var $class = $.trim(icon
															.attr('class')
															.replace('ui-icon',
																	''));
													if ($class in replacement)
														icon
																.attr(
																		'class',
																		'ui-icon '
																				+ replacement[$class]);
												})
							}

							function enableTooltips(table) {
								$('.navtable .ui-pg-button').tooltip({
									container : 'body'
								});
								$(table).find('.ui-pg-div').tooltip({
									container : 'body'
								});
							}

							function style_edit_form(form) {
								// enable datepicker on "birthday" field and switches for "stock" field
								form.find('input[name=birthday]').datepicker({
									format : 'yyyy-mm-dd',
									autoclose : true,
									language : 'zh-CN'
								})

								form.find('input[name=statusCn]').addClass(
										'ace ace-switch ace-switch-5').after(
										'<span class="lbl"></span>');
								// don't wrap inside a label element, the checkbox value won't be submitted (POST'ed)
								// .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');

								// update buttons classes
								var buttons = form.next().find(
										'.EditButton .fm-button');
								buttons.addClass('btn btn-sm').find(
										'[class*="-icon"]').hide();// ui-icon, s-icon
								buttons.eq(0).addClass('btn-primary').prepend(
										'<i class="ace-icon fa fa-check"></i>');
								buttons.eq(1).prepend(
										'<i class="ace-icon fa fa-times"></i>')

								buttons = form.next().find('.navButton a');
								buttons.find('.ui-icon').hide();
								buttons
										.eq(0)
										.append(
												'<i class="ace-icon fa fa-chevron-left"></i>');
								buttons
										.eq(1)
										.append(
												'<i class="ace-icon fa fa-chevron-right"></i>');
							}

							function style_delete_form(form) {
								var buttons = form.next().find(
										'.EditButton .fm-button');
								buttons.addClass(
										'btn btn-sm btn-white btn-round').find(
										'[class*="-icon"]').hide();// ui-icon, s-icon
								buttons
										.eq(0)
										.addClass('btn-danger')
										.prepend(
												'<i class="ace-icon fa fa-trash-o"></i>');
								buttons.eq(1).addClass('btn-default').prepend(
										'<i class="ace-icon fa fa-times"></i>')
							}

							function style_search_filters(form) {
								form.find('.delete-rule').val('X');
								form.find('.add-rule').addClass(
										'btn btn-xs btn-primary');
								form.find('.add-group').addClass(
										'btn btn-xs btn-success');
								form.find('.delete-group').addClass(
										'btn btn-xs btn-danger');
							}
							function style_search_form(form) {
								var dialog = form.closest('.ui-jqdialog');
								var buttons = dialog.find('.EditTable')
								buttons.find('.EditButton a[id*="_reset"]')
										.addClass('btn btn-sm btn-info').find(
												'.ui-icon').attr('class',
												'ace-icon fa fa-retweet');
								buttons.find('.EditButton a[id*="_query"]')
										.addClass('btn btn-sm btn-inverse')
										.find('.ui-icon').attr('class',
												'ace-icon fa fa-comment-o');
								buttons.find('.EditButton a[id*="_search"]')
										.addClass('btn btn-sm btn-purple')
										.find('.ui-icon').attr('class',
												'ace-icon fa fa-search');
							}

							function beforeDeleteCallback(e) {
								var form = $(e[0]);
								if (form.data('styled'))
									return false;
								form.closest('.ui-jqdialog').find(
										'.ui-jqdialog-titlebar').wrapInner(
										'<div class="widget-header" />')
								style_delete_form(form);
								form.data('styled', true);
							}

							function beforeEditCallback(e) {
								var form = $(e[0]);
								form.closest('.ui-jqdialog').find(
										'.ui-jqdialog-titlebar').wrapInner(
										'<div class="widget-header" />')
								style_edit_form(form);
							}

							// it causes some flicker when reloading or navigating grid
							// it may be possible to have some custom formatter to do this as the grid is being created to prevent this
							// or go back to default browser checkbox styles for the grid
							function styleCheckbox(table) {
								/**
								 * $(table).find('input:checkbox').addClass('ace') .wrap('<label />') .after('<span class="lbl align-top" />') $('.ui-jqgrid-labels th[id*="_cb"]:first-child')
								 * .find('input.cbox[type=checkbox]').addClass('ace') .wrap('<label />').after('<span class="lbl align-top" />');
								 */
							}

							// unlike navButtons icons, action icons in rows seem to be hard-coded
							// you can change them like this in here if you want
							function updateActionIcons(table) {

							}

							// replace icons with FontAwesome icons like above
							function updatePagerIcons(table) {
								var replacement = {
									'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
									'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
									'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
									'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
								};
								$(
										'.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon')
										.each(
												function() {
													var icon = $(this);
													var $class = $.trim(icon
															.attr('class')
															.replace('ui-icon',
																	''));

													if ($class in replacement)
														icon
																.attr(
																		'class',
																		'ui-icon '
																				+ replacement[$class]);
												})
							}

							function enableTooltips(table) {
								$('.navtable .ui-pg-button').tooltip({
									container : 'body'
								});
								$(table).find('.ui-pg-div').tooltip({
									container : 'body'
								});
							}

							// var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
						});
					});
</script>
