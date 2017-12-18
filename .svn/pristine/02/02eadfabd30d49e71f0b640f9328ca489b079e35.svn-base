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

<script type="text/javascript"
	src="${contextPath}/static/assets/js/jquery.js"></script>
<script src="${contextPath}/static/assets/js/bootstrap.js"></script>
<script src="${contextPath}/static/assets/js/ace/ace.js"></script>
<script src="${contextPath}/static/assets/js/ace/ace.ajax-content.js"></script>

<script src="${contextPath}/static/json/json2.js"></script>
<script src="${contextPath}/static/dispatcher/assets/js/jquery-dateFormat.js"></script>
<script src="${contextPath}/static/json/json2.js"></script>
<script src="${contextPath}/static/select2/dist/js/select2.min.js"></script>
<script src="${contextPath}/static/layer/layer.js"></script>
<script src="${contextPath}/static/assets/js/jqGrid/jquery.jqGrid.js"></script>
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
	function initModelView(){

							//设备类别中，故障的jqgrid表格
							var eqm_fault_table_selector = "#eqm-fault-table";
							var eqm_fault_pager_selector = "#eqm-fault-pager";
							// resize to fit page size
							// resize to fit page size
        		$(window).on('resize.jqGrid', function() {
        			$(eqm_fault_table_selector).jqGrid('setGridWidth', $(".tab-pane").width());
        		})
        		// resize on sidebar collapse/expand
        		var parent_column = $(eqm_fault_table_selector).closest('[class*="col-"]');
        		$(document).on('settings.ace.jqGrid', function(ev, event_name, collapsed) {
        			if (event_name === 'sidebar_collapsed' || event_name === 'main_container_fixed') {
        				// setTimeout is for webkit only to give time for DOM changes and then redraw!!!
        				setTimeout(function() {
        					$(eqm_fault_table_selector).jqGrid('setGridWidth', parent_column.width());
        				}, 0);
        			}
        		})

							jQuery(eqm_fault_table_selector).jqGrid({
												subGrid : false,
												url : "${contextPath}/sys/eamPosLine/logsDate",
												datatype : "json",
							        			height : 450,
							        			postData : {
													logid : function(params,postdata){
														var logid = $("#logid").val();
														return logid;
													}
												},
							        			colNames : ['版本','线路编码','线路名称',"公里数",'开通时间','类型','备注','修改人','修改时间'],
							        			colModel : [
							        				{
														name : 'version',
														index : 'version',
														label : '线路编码',
														width : 80,
														editable : true,
														sorttype : "long",
														search : true,
														searchoptions : {
															sopt : [ 'cn' ]
														},
														editoptions : {
															size : "20",
															maxlength : "2"
														},
														editrules : {
															required : true
														}
													}, {
														name : 'line_code',
														index : 'line_code',
														label : '线路编码',
														width : 130,
														editable : true,
														sorttype : "long",
														search : true,
														searchoptions : {
															sopt : [ 'cn' ]
														},
														editoptions : {
															size : "20",
															maxlength : "2"
														},
														editrules : {
															required : true
														}
													},
													{
														name : 'line_name',
														index : 'line_name',
														label : '线路名称',
														width : 130,
														editable : true,
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
													},{
														
														name : 'line_m',
														index : 'line_m',
														label : '公里数',
														width : 130,
														editable : true, 
														/* edittype:'select', */
														/* editoptions : {
								        					dataUrl : "${contextPath}/sys/company/getCompanyNames"
								        				}, */
								        				search : true,
								        				searchoptions : {
															sopt : [ 'ge' ]
														},
													},{
														name : 'line_strart_date',
														index : 'line_strart_date',
														label : '开通时间',
														width : 130,
														formatoptions:{srcformat: 'Y-m-d', newformat: 'Y-m-d'},
														formatter : function(cellvalue, options, rowObject) {  
															   return $.hd_jqGrid.dateTimeFormatter(cellvalue);
															},
														editable : true,
														sorttype : "date",
														search : false,
														editrules : {
															required : true
														}
														
													},{
														name : 'line_type',
														index : 'line_type',
														label : '类型',
														width : 130,
														editable : true,
														/* sorttype : "date", */
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
														
													},{
														name : 'memo',
														index : 'memo',
														label : '备注',
														width : 130,
														editable : true,
														/* sorttype : "date", */
														search : false
														
								                    },{
														name : 'userId',
														index : 'userId',
														label : '备注',
														width : 80,
														editable : true,
														/* sorttype : "date", */
														search : false
														
								                    },{
														name : 'lastModifidTime',
														index : 'lastModifidTime',
														label : '备注',
														width : 160,
														formatoptions:{srcformat: 'Y-m-d', newformat: 'Y-m-d'},
														formatter : function(cellvalue, options, rowObject) {  
															   return $.hd_jqGrid.dateTimeFormatter(cellvalue);
															},
													    sorttype : "date",
														editable : true,
														/* sorttype : "date", */
														search : false
														
								                    }],
							        			//scroll : 1, // set the scroll property to 1 to enable paging with scrollbar - virtual loading of records
							        			sortname : "version",
							        			sortorder : "desc",
							        			viewrecords : true,
							        			rowNum : 10,
							        			rowList : [ 10, 20, 30 ],
												pager : eqm_fault_pager_selector,
												altRows : true,
												//toppager : true,
												multiselect : true,
												//multikey : "ctrlKey",
												multiboxonly : true,
											});
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

			(function($) {    
			    // jqgrid插件  
			    $.hd_jqGrid = function(){};  
			    $.extend($.hd_jqGrid, {  
			        defaults : {  
			            rightHtml : "<font color='green'>√</font>",  
			            wrongHtml : "<font color='red'>×</font>",  
			              
			            date_yyyy_MM_dd_HH_mm_ss : "yyyy-MM-dd HH:mm:ss",  
			            date_yyyy_MM_dd : "yyyy-MM-dd"  
			        },  
			          
			        dateTimeFormatter : function(cellvalue, fmt) {  
			            return (null != cellvalue && cellvalue > 0) ? $.method.dateFormat(cellvalue, fmt) : "";  
			        },  
			          
			        statusFormatter : function(cellvalue) {  
			            return cellvalue == 1 ? $.hd_jqGrid.defaults.rightHtml : $.hd_jqGrid.defaults.wrongHtml;  
			        }  
			    });  
			})(jQuery);  
			(function ($) {  
			    $.method = function(){};  
			    $.extend($.method, {          
			        dateFormat : function( time, fmt) { // author: meizz  
			            if(null == fmt || typeof fmt == "undefined" || $.trim(fmt).length == 0){  
			                fmt = "yyyy-MM-dd HH:mm:ss";  
			            }  
			              
			            if(typeof time == "number"){  
			                time = new Date(time);  
			            }  
			              
			            var o = {  
			                "M+" : time.getMonth() + 1, // 月份  
			                "d+" : time.getDate(), // 日  
			                "h+" : time.getHours(), // 小时  
			                "H+" : time.getHours(), // 小时  
			                "m+" : time.getMinutes(), // 分  
			                "s+" : time.getSeconds(), // 秒  // 季度  
			                "q+" : Math.floor((time.getMonth() + 3) / 3), 
			                "S" : time.getMilliseconds() // 毫秒  
			            };  
			            if (/(y+)/.test(fmt)) {  
			                fmt = fmt.replace(RegExp.$1, (time.getFullYear() + "").substr(4 - RegExp.$1.length));  
			            }  
			                  
			            for ( var k in o) {  
			                if (new RegExp("(" + k + ")").test(fmt)) {  
			                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));  
			                }  
			            }  
			            return fmt;  
			        }  
			    });  
			})(jQuery);
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