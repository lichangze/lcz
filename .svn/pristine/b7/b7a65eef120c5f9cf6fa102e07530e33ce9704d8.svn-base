<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<link rel="stylesheet"
	href="${contextPath}/static/dispatcher/assets/css/bootstrap.css" />
<link rel="stylesheet"
	href="${contextPath}/static/assets/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="${contextPath}/static/assets/css/ui.jqgrid.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/ace.css" />
<link rel="stylesheet"
	href="${contextPath}/static/assets/css/datepicker.css" />
<link rel="stylesheet"
	href="${contextPath}/static/assets/css/bootstrap-datetimepicker.css" />
<link rel="stylesheet"
	href="${contextPath}/static/assets/css/bootstrap-duallistbox.css" />
<link rel="stylesheet"
	href="${contextPath}/static/assets/css/bootstrap-multiselect.css" />
<link rel="stylesheet"
	href="${contextPath}/static/select2/dist/css/select2.min.css" />
<link rel="stylesheet"
	href="${contextPath}/static/assets/images/css/layer.css" />

<script type="text/javascript"
	src="${contextPath}/static/assets/js/jquery.js"></script>
<script src="${contextPath}/static/assets/js/bootstrap.js"></script>
<script src="${contextPath}/static/assets/js/ace/ace.js"></script>
<script src="${contextPath}/static/assets/js/ace/ace.ajax-content.js"></script>

<script src="${contextPath}/static/json/json2.js"></script>
<script src="${contextPath}/static/dispatcher/assets/js/jquery-dateFormat.js"></script>
<script src="${contextPath}/static/json/json2.js"></script>
<script src="${contextPath}/static/select2/dist/js/select2.min.js"></script>
<script src="${contextPath}/static/assets/images/js/layer.js"></script>
<script src="${contextPath}/static/assets/js/jqGrid/jquery.jqGrid.js"></script>
<link rel="stylesheet"
  href="${contextPath}/static/ztree/css/zTreeStyle/zTreeStyle.css"
  type="text/css" />
<link rel="stylesheet"
  href="${contextPath}/static/ztree/css/zTreeStyle/zTreeStyle.css"
  type="text/css" />
<script type="text/javascript"
    src="${contextPath}/static/ztree/js/jquery.ztree.core-3.5.js"></script>
  <script type="text/javascript"
    src="${contextPath}/static/ztree/js/jquery.ztree.excheck-3.5.js"></script>
  <script type="text/javascript"
    src="${contextPath}/static/ztree/js/jquery.ztree.exedit-3.5.js"></script>

<script
	src="${contextPath}/static/assets/js/jqGrid/i18n/grid.locale-cn.js"></script>
<script
	src="${contextPath}/static/jquery-validation-1.14.0/jquery.validate.js"></script>
<script src="${contextPath}/static/jNotify/jNotify.jquery.js"></script>
<script
	src="${contextPath}/static/assets/js/date-time/bootstrap-datepicker.js"></script>
<link rel="stylesheet"
	href="${contextPath}/static/jNotify/jNotify.jquery.css" />
<script
	src="${contextPath}/static/assets/js/date-time/bootstrap-datetimepicker.js"></script>
<script
	src="${contextPath}/static/assets/js/date-time/locales/bootstrap-datepicker.zh-CN.js"></script>
<script
	src="${contextPath}/static/assets/js/date-time/locales/bootstrap-datetimepicker.zh-CN.js"></script>
</head>
<body style="background-color: #fff">
	<form action="" name="form" id="form" method="post">
	<input type="hidden" id="logid" name="logid" value="${logid}">
		<div class="widget-body">
			<div class="widget-main">
				
				<div class="row" style="margin: -4px;">
				<div class="col-md-12">
				
				<div id="model_fault" class="tab-pane">
					<div id="model_fault_row">
						<div class="widget-body">
							<table id="eqm-fault-table"></table>
							<div id="eqm-fault-pager"></div>
							<script type="text/javascript">
								var $path_base = "${contextPath}/static";
							</script>
						</div>
					</div>
				</div>

				</div>
				</div>
				</div>

			</div>
		
	</form>

	<div class="modal-footer">
		<div class="text-right">
		<!-- <a id="sData" onclick="submit()"
			class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm btn-primary">
			<i class="ace-icon fa fa-check"></i>提交</a> -->
			<a id="cData" onclick="hiddenModal()"
			class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm btn-warning">
			<i class="ace-icon fa fa-times"></i>取消
			</a>
		</div>
	</div>

	<script type="text/javascript">
	
	$(document).ready(initModelView()); 
	
		var index = parent.layer.getFrameIndex(window.name);
		function hiddenModal() {
			parent.layer.close(index); //执行关闭  
		}

 function showMenu(event) {
    init_zTree();
    
    $("#menuContent").slideDown("fast");
    $("body").bind("mousedown", onBodyDown);
  }
  function hideMenu() {
    $("#menuContent").fadeOut("fast");
    $("body").unbind("mousedown", onBodyDown);
  }
  function onBodyDown(event) {
    //$("#poNo").removeAttr("readonly");
    if (!(event.target.id == "menuBtn" || event.target.id == "eqmArchitectureID"
        || event.target.id == "menuContent" || $(event.target).parents(
        "#menuContent").length > 0)) {
      hideMenu();
    }
  }

	
	  
	  
		
		function inputChecked(checkid) {
			if ($('#' + checkid).val() == '') {
				$('#' + checkid).val('此选项为必填项');
				$('#' + checkid).css('color', 'red');
				$('#' + checkid).focus(function(event) {
					$('#' + checkid).val('');
					$('#' + checkid).css('color', '#333');
				});
			}
			;
		}

		function submit() {
			$('#tyContinue').val($('#tyContinueCheckbox').is(':checked'));
			$('#typeComplex').val($('#typeComplexCheckbox').is(':checked'));
			inputChecked("tyNo");
			inputChecked("tyInfo");
			inputChecked("orgName");
			inputChecked("eqmArchitectureEntity");
			if ($('#tyNo').val != '此选项为必填项' && $('#tyInfo').val() != '此选项为必填项'
					&& $('#orgName').val() != '此选项为必填项'
					&& $('#eqmArchitectureEntity').val() != '此选项为必填项') {
				layer.confirm('您确认保存修改吗？', {
					btn : [ '确定', '取消' ]
				//按钮
				}, function() {
					$.ajax({
						type : "POST",
						url : "${contextPath}/equ/eqmtypem/doOperate",
						data : $('#form').serialize(),// 你的formid
						async : false,
						success : function(data) {
							layer.msg('已提交', {
								icon : 1
							});
							parent.$("#grid-table").trigger("reloadGrid");
							parent.$.fn.zTree.getZTreeObj("eqmTypeTree");
							hiddenModal();
						}
					});

				}, function() {
					layer.msg('已取消', {
						icon : 1
					});
					hiddenModal();
				});

			}
		}

		
		
    
	function initModelView(){

							//设备类别中，故障的jqgrid表格
							var eqm_fault_table_selector = "#eqm-fault-table";
							var eqm_fault_pager_selector = "#eqm-fault-pager";
							// resize to fit page size
							$(window).on(
									'resize.jqGrid',
									function() {
										$(eqm_fault_table_selector).jqGrid(
												'setGridWidth',
												$(".tab-pane").width());
									})
							// resize on sidebar collapse/expand
							var parent_column = $(eqm_fault_table_selector)
									.closest('[class*="col-"]');
							$(document)
									.on(
											'settings.ace.jqGrid',
											function(ev, event_name, collapsed) {
												if (event_name === 'sidebar_collapsed'
														|| event_name === 'main_container_fixed') {
													// setTimeout is for webkit only to give time for DOM changes and then redraw!!!
													setTimeout(
															function() {
																$(
																		eqm_fault_table_selector)
																		.jqGrid(
																				'setGridWidth',
																				parent_column
																						.width());
															}, 0);
												}
											})

							jQuery(eqm_fault_table_selector)
									.jqGrid(
											{
												subGrid : false,
												url : "${contextPath}/sys/sysmenu/logsDate",
												datatype : "json",
												postData : {
													typeid : function(params,
															postdata) {
														var typeid = $(
																"#typeid")
																.val();
														return typeid;
													},
													logid : function(params,postdata){
														var logid = $("#logid").val();
														return logid;
													}
												},
												height : '300',
<<<<<<< HEAD
												colNames : [ '版本','IP', '修改人', '操作','修改时间','菜单编码','菜单名称','菜单class属性值','菜单url属性值','排序','上级菜单编码','打开方式'],
=======
												colNames : [ '版本','IP', '修改人','修改时间','操作类型','菜单编码','菜单名称','菜单class属性值','菜单url属性值','排序','上级菜单编码','打开方式'],
>>>>>>> 4ad35b774987cafe991a6ad8a813925af378ef95
												colModel : [
														{
															name : 'ver',
															index : 'ver',
															label : '版本',
															width : 50,
															editable : false,
															sorttype : "long",
															search : false
														},
														{
															name : 'ip',
															index : 'ip',
															label : 'IP',
															width : 100,
															editable : false,
															sorttype : "long",
															search : false
														},
														{
															name : 'username',
															index : 'username',
															label : '修改人',
															width : 100,
															editable : true,
															search : true
														},{
															name : 'type',
															index : 'type',
															label : '修改人',
															width : 50,
															editable : true,
															search : true
														},{
															name : 'timestamp',
															index : 'timestamp',
															label : '修改时间',
															width : 100,
															sorttype : "date",
															formatter:'date',
															formatoptions:{srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'},
															editable : true, 
									        				search : true
<<<<<<< HEAD
														},
														{
															name : 'entity.menuNo',
=======
														},{
															name : 'revtype',
															index : 'revtype',
															label : '操作类型',
															width : 100,
															editable : true
															
														},{
															name : 'sysmenu.menuNo',
>>>>>>> 4ad35b774987cafe991a6ad8a813925af378ef95
															index : 'menuNo',
															label : '菜单编码',
															width : 100,
															editable : true
															
														},
														{
															name : 'entity.menuName',
															index : 'menuName',
															label : '菜单名称',
															width : 100,
															editable : true
															
														},
														{
															name : 'entity.menuClass',
															index : 'menuClass',
															label : '菜单class属性值',
															width : 100,
															editable : true
															
														},
														{
															name : 'entity.menuAddress',
															index : 'menuAddress',
															label : '菜单data-url属性值',
															width : 100,
															editable : true,
													
															search : false
														},
														{
															name : 'entity.menuOrder',
															index : 'menuOrder',
															label : '排序',
															width : 100,
															align:"right",
															editable : false
														},
														{
															name : 'entity.modNo',
															index : 'modNo',
															label : '上级菜单编码',
															width : 100,
															editable : false,
															search : false
														},
														{
															name : 'entity.herfTarget',
															index : 'herfTarget',
															label:'打开方式',
															width : 90,
															editable : false,
															edittype : "select",
															editoptions : {
																value : ":默认;_blank:新窗口"
															}
														}],
														
												//scroll : 1, // set the scroll property to 1 to enable paging with scrollbar - virtual loading of records
												sortname : "ver",
												sortorder : "asc",
												viewrecords : true,
												rowNum : 10,
												rowList : [10,20,30],
												pager : eqm_fault_pager_selector,
												altRows : true,
												//toppager : true,
												multiselect : true,
												//multikey : "ctrlKey",
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

												//editurl : "${contextPath}/equ/eqmfault/doOperate",
											});
							function authorityFormatter(cellvalue, options,
									cell) {
								var template = "<div class='ui-pg-div ui-inline-edit'><a id='a"
									+ cell.id
									+ "'  onclick = 'editFault(\""
									+ cell.id
									+ "\")' title='编辑记录' style='text-decoration:none;' class='ui-icon ui-icon-pencil'></a><a id='c"
									+ cell.id
									+ "' onclick = 'delFault(\""
									+ cell.id
									+ "\")' title='删除所选记录' style='text-decoration:none;' class='ui-icon ui-icon-trash'></a></div>";
								return template;
							}
							// navButtons
							jQuery(eqm_fault_table_selector)
									.jqGrid(
											'navGrid',
											eqm_fault_pager_selector,
											{ // navbar options
												edit : false,
												editicon : 'ace-icon fa fa-pencil blue',
												add : false,
												addicon : 'ace-icon fa fa-plus-circle purple',
												del : false,
												delicon : 'ace-icon fa fa-trash-o red',
												search : false,
												searchicon : 'ace-icon fa fa-search orange',
												refresh : true,
												refreshicon : 'ace-icon fa fa-refresh blue',
												view : true,
												viewicon : 'ace-icon fa fa-search-plus grey'
											},
											{
												// edit record form
												// closeAfterEdit: true,
												// width: 700,
												recreateForm : true,
												onclickSubmit : function(
														params, postdata) {
													var typeid = $("#typeid")
															.val();
													//alert(5555+"typid:"+typeid);
													return {
														"typeid" : typeid
													};
												},
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
												onclickSubmit : function(
														params, postdata) {
													var typeid = $("#typeid")
															.val();
													//alert(5555+"typid:"+typeid);
													return {
														"typeid" : typeid
													};
												},
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
													var result = eval('('+ response.responseText+ ')');
													//$("#eqm-fault-table").trigger("reloadGrid");
													return result.message;
												}
											},
											{
												// search form
												recreateForm : true,
												onclickSubmit : function(
														params, postdata) {
													var typeid = $("#typeid")
															.val();
													//alert(5555+"typid:"+typeid);
													return {
														"typeid" : typeid
													};
												},
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
												onclickSubmit : function(
														params, postdata) {
													var typeid = $("#typeid")
															.val();
													//alert(5555+"typid:"+typeid);
													return {
														"typeid" : typeid
													};
												},
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


			////////////////////////////////////////////////////////////////////////////////////////////////
			$(document).one('ajaxloadstart.page', function(e) {
				$(work_doc_grid_selector).jqGrid('GridUnload');
				$('.ui-jqdialog').remove();
			});
			function style_edit_form(form) {

				// update buttons classes
				var buttons = form.next().find('.EditButton .fm-button');
				buttons.addClass('btn btn-sm').find('[class*="-icon"]').hide();// ui-icon, s-icon
				buttons.eq(0).addClass('btn-primary').prepend(
						'<i class="ace-icon fa fa-check"></i>');
				buttons.eq(1).prepend('<i class="ace-icon fa fa-times"></i>')

			}

			function style_delete_form(form) {
				var buttons = form.next().find('.EditButton .fm-button');
				buttons.addClass('btn btn-sm btn-white btn-round').find(
						'[class*="-icon"]').hide();// ui-icon, s-icon
				buttons.eq(0).addClass('btn-danger').prepend(
						'<i class="ace-icon fa fa-trash-o"></i>');
				buttons.eq(1).addClass('btn-default').prepend(
						'<i class="ace-icon fa fa-times"></i>')
			}

			function style_search_filters(form) {
				form.find('.delete-rule').val('X');
				form.find('.add-rule').addClass('btn btn-xs btn-primary');
				form.find('.add-group').addClass('btn btn-xs btn-success');
				form.find('.delete-group').addClass('btn btn-xs btn-danger');
			}
			function style_search_form(form) {
				var dialog = form.closest('.ui-jqdialog');
				var buttons = dialog.find('.EditTable')
				buttons.find('.EditButton a[id*="_reset"]').addClass(
						'btn btn-sm btn-info').find('.ui-icon').attr('class',
						'ace-icon fa fa-retweet');
				buttons.find('.EditButton a[id*="_query"]').addClass(
						'btn btn-sm btn-inverse').find('.ui-icon').attr(
						'class', 'ace-icon fa fa-comment-o');
				buttons.find('.EditButton a[id*="_search"]').addClass(
						'btn btn-sm btn-purple').find('.ui-icon').attr('class',
						'ace-icon fa fa-search');
			}

			function beforeDeleteCallback(e) {
				var form = $(e[0]);
				if (form.data('styled'))
					return false;
				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar')
						.wrapInner('<div class="widget-header" />')
				style_delete_form(form);
				form.data('styled', true);
			}

			function beforeEditCallback(e) {
				var form = $(e[0]);
				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar')
						.wrapInner('<div class="widget-header" />')
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
				/**
				 * var replacement = { 'ui-ace-icon fa fa-pencil' : 'ace-icon fa fa-pencil blue', 'ui-ace-icon fa fa-trash-o' : 'ace-icon fa fa-trash-o red', 'ui-icon-disk' : 'ace-icon fa fa-check green', 'ui-icon-cancel' :
				 * 'ace-icon fa fa-times red' }; $(table).find('.ui-pg-div span.ui-icon').each(function(){ var icon = $(this); var $class = $.trim(icon.attr('class').replace('ui-icon', '')); if($class in replacement)
				 * icon.attr('class', 'ui-icon '+replacement[$class]); })
				 */
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
									var $class = $.trim(icon.attr('class')
											.replace('ui-icon', ''));

									if ($class in replacement)
										icon.attr('class', 'ui-icon '
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
		}
	</script>
</body>