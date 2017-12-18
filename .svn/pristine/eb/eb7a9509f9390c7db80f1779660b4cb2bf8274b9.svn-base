<%@page import="java.net.URLEncoder"%>
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
<link rel="stylesheet" href="${contextPath}/static/assets/images/css/layer.css" />
<script src="${contextPath}/static/assets/images/js/layer.js"></script>
<script type="text/javascript">
	function setCheckedNodes() {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo1");
		var nodes = zTree.getCheckedNodes(true);
		var strCheckedNodes = "";
		for (var i=0, iLen=nodes.length; i<iLen; i++) {
			strCheckedNodes += nodes[i].id + ",";
		}
		if (strCheckedNodes.length > 0 ) {
			strCheckedNodes = strCheckedNodes.substring(0, strCheckedNodes.length-1);
		}
		$("#CheckedNodes").attr("value", strCheckedNodes);
		var workGroupNo=$("#workGroupNo").val();
		htmlobj=$.ajax({url:"${contextPath}/sys/workgroup/saveOrgUser?workGroupNo="+workGroupNo+"&CheckedNodes="+strCheckedNodes,async:false});
	}
	
	function doSubmit()
	{
		
		setCheckedNodes();
		$('#modal-table').modal('hide')
	
		//form1.submit();
	}

	function addWorkGrope(){
		var recordType = $("#recordType").val();
	    var hrefLink='${contextPath}/material/record/JOB?recordType='+recordType;
	    layer.open({
	           type: 2, //page层
	           area: ['1000px', '400px'],
	           title: '工单事务',
	           skin: 'layui-layer-lan',
	           fix: false, //不固定
	           moveType: 1, //拖拽风格，0是默认，1是传统拖动
	           shift: 1, //0-6的动画形式，-1不开启
	           content: [hrefLink, 'no']
	         });     
	}

</script>
<input type="hidden" id="delId" name="delId" />

<div id="modal-table" class="modal fade" tabindex="-1"
	data-backdrop="static">
	<!-- 删除弹出框 -->
	<div id="delDialog"
		class="ui-widget ui-widget-content ui-corner-all ui-jqdialog "
		dir="ltr" tabindex="-1" role="dialog"
		aria-labelledby="delhdgrid-table" aria-hidden="false"
		style="width: 240px; height: auto; z-index: 1040; overflow: hidden; top: 40%; left: 40%; display: block;">
		<div
			class="ui-jqdialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix"
			style="cursor: move;">
			<div class="widget-header">
				<span class="ui-jqdialog-title" style="float: left;">删除</span> <a
					class="ui-jqdialog-titlebar-close ui-corner-all"
					style="right: 0.3em;" onclick="delCloseModalTable()"> <span
					class="ui-icon ui-icon-closethick"></span></a>
			</div>
		</div>
		<div class="ui-jqdialog-content ui-widget-content">
			<div class="formdata"
				style="width: undefined; overflow: auto; position: relative; height: auto;">
				<table class="DelTable">
					<tbody>
						<tr id="error" style="display: none">
							<td id="errorMsg" class="ui-state-error"></td>
						</tr>
						<tr>
							<td id="delmsg" class="delmsg" style="white-space: pre;">删除所选记录？</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
					</tbody>
				</table>
			</div>
			<table style="cellspacing: 0; cellpadding: 0; border: 0;"
				class="EditTable">
				<tbody>
					<tr>
						<td><hr class="ui-widget-content" style="margin: 1px"></td>
					</tr>
					<tr>
						<td class="DelButton EditButton"><a id="delBut"
							class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm btn-white btn-round btn-danger"
							onclick="delAndCloseModalTable()"> <i
								class="ace-icon fa fa-trash-o"></i>删除<span
								class="ui-icon ui-icon-scissors" style="display: none;"></span></a>&nbsp;
							<a class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm btn-white btn-round btn-default"
							onclick="closeModalTable()"> <i class="ace-icon fa fa-times"></i>取消<span
								class="ui-icon ui-icon-cancel" style="display: none;"></span></a></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- <div class="ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se">
		</div> -->
	</div>
</div>

<div class="row">
	<div class="col-xs-12">
		<div class="widget-body">
			<table id="grid-table"></table>
			<div id="grid-pager"></div>
			<input type="hidden" id="orgId" name="orgId"/>
			<script type="text/javascript">
				var $path_base = "${contextPath}/static";//in Ace demo this will be used for editurl parameter
			</script>
		</div>

	</div>
</div>


<!-- page specific plugin scripts -->
<script type="text/javascript">
function showMenu(id) {
	$("#modal-table").modal("toggle");
	$('#delId').attr("value",id);
	$("body").unbind("mousedown", onBodyDown);
}
function delAndCloseModalTable(){
	var id = $('#delId').val();
	$.ajax({
		type : "POST",
		datatype : "json",
		url : "${contextPath}/sys/workgroup/delete?id="+id,
		success : function(data) {
				//刷新页面
				$('.page-content-area').ace_ajax('loadScripts',scripts,function() {
					$("#grid-table").jqGrid('setGridParam',{
						url : "${contextPath}/sys/workgroup/getworkgroup",
						datatype : "json",
					}).trigger("reloadGrid");
				}); 
				delCloseModalTable();
		}
	});
}
function delCloseModalTable(){
	document.getElementById('errorMsg').innerHTML = "";
	document.getElementById('error').style.display = "none";
	document.getElementById('delBut').style.display = "";
	document.getElementById('delmsg').style.display = "";
	closeModalTable();
	$("body").unbind("mousedown", onBodyDown);
	$("#grid-table").trigger("reloadGrid");
}
//隐藏弹出层
function closeModalTable(){
	document.getElementById('errorMsg').innerHTML = "";
	document.getElementById('error').style.display = "none";
	document.getElementById('delBut').style.display = "";
	document.getElementById('delmsg').style.display = "";
	$('#modal-table').modal('hide');
}
var setting1 = {

		data: {
			simpleData: {
				enable: true
			}
		},
		check: {
			enable: true
		},
		callback: {
		
			beforeClick:beforeClick
		}
	};
function Formatter(cellvalue) {
	$('#workGroupNo').val(cellvalue);
	var url="${contextPath}/sys/workgroup/getOrgUsers";
	$.ajax({
		url: url,  
		success: function(data){
			$("#modal-table").modal("toggle");
			$.fn.zTree.init($("#treeDemo1"), setting1, eval(data));
			clearFlag = $("#last").attr("checked");
			//$("#selectAll").bind("click", selectAll);
			checkedZtree();
      }
  });
}

function checkedZtree(){
	var url="${contextPath}/sys/workgroup/selectLine";
	$.ajax({
		url: url, 
		data:{id : $('#workGroupNo').val()},
		success: function(data){
			var objs = $.parseJSON(data);
			var lineID = (objs.sysUsers).split(",");
			var zTree = $.fn.zTree.getZTreeObj("treeDemo1");
			for(var i = 0; i < lineID.length; i++){
			 	var node = zTree.getNodeByParam("id",lineID[i]);
				node.checked = true; 
				zTree.updateNode(node);
			}
      }
  });
}

var scripts1 = [ null, "${contextPath}/static/assets/js/prettify.js", null ]
$('.page-content-area').ace_ajax('loadScripts', scripts1, function() {
	//inline scripts related to this page
	jQuery(function($) {
		window.prettyPrint && prettyPrint();
		$('#id-check-horizontal').removeAttr('checked').on('click', function() {
			$('#dt-list-1').toggleClass('dl-horizontal').prev().html(this.checked ? '&lt;dl class="dl-horizontal"&gt;' : '&lt;dl&gt;');
		});

	})
});


var setting = {

		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
		
			beforeClick:beforeClick
		}
	};


var log, className = "dark";
function beforeClick(treeId, treeNode, clickFlag) {
	 $('.page-content-area').ace_ajax('loadScripts', scripts, function() {
		 //trigger("#grid-table");
		 $("#grid-table").jqGrid('setGridParam', {               
			 url : "${contextPath}/sys/sysorgstru/getSysOrgStru/"+treeNode.id,
    		datatype : "json",
            }).trigger("reloadGrid");
	    });
	className = (className === "dark" ? "":"dark");
	showLog("[ "+getTime()+" beforeClick ]&nbsp;&nbsp;" + treeNode.name );
	return (treeNode.click != false);
}

function Jump(id){//修改
	window.location.href = "${contextPath}/aems/home#page/workgroupmx/"+id;
}

function showLog(str) {
	if (!log) log = $("#log");
	log.append("<li class='"+className+"'>"+str+"</li>");
	if(log.children("li").length > 8) {
		log.get(0).removeChild(log.children("li")[0]);
	}
}
function getTime() {
	var now= new Date(),
	h=now.getHours(),
	m=now.getMinutes(),
	s=now.getSeconds(),
	ms=now.getMilliseconds();
	return (h+":"+m+":"+s+ " " +ms);
}

var newCount = 1;
function addHoverDom(treeId, treeNode) {
	var sObj = $("#" + treeNode.tId + "_span");
	if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
	var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
		+ "' title='add node' onfocus='this.blur();'></span>";
	sObj.after(addStr);
	var btn = $("#addBtn_"+treeNode.tId);
	if (btn) btn.bind("click", function(){
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
		return false;
	});
};
function removeHoverDom(treeId, treeNode) {
	$("#addBtn_"+treeNode.tId).unbind().remove();
};
function selectAll() {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	zTree.setting.edit.editNameSelectAll =  $("#selectAll").attr("checked");
}
$("#consoleDlg").dialog({
	autoOpen : false, // 是否自动弹出窗口
	modal : true, // 设置为模态对话框
	resizable : true,
	width : 900,
	height : 430,
	position : "center" // 窗口显示的位置
	});

function reloadTree() {
	var zNodes ="";
	var url="${contextPath}/sys/sysorgstru/getSysOrgStruTree";
		$.ajax({
  		url: url,  
  		success: function(data){
  			$.fn.zTree.init($("#treeDemo"), setting, eval(data));
  			$("#selectAll").bind("click", selectAll);
          }
      });  
}
$(document).ready(function(){
	var zNodes ="";
	var url="${contextPath}/sys/sysorgstru/getSysOrgStruTree";
		$.ajax({
  		url: url,  
  		success: function(data){
  			$.fn.zTree.init($("#treeDemo"), setting, eval(data));
  			$("#selectAll").bind("click", selectAll);
          }
      });  
});


		var scripts = [ null, "${contextPath}/static/assets/js/date-time/bootstrap-datepicker.js",
		                "${contextPath}/static/assets/js/date-time/bootstrap-datepicker.min.js", 
		                "${contextPath}/static/assets/js/date-time/locales/bootstrap-datepicker.zh-CN.js", 
		                "${contextPath}/static/assets/js/jqGrid/jquery.jqGrid.js", 
		                "${contextPath}/static/assets/js/jqGrid/i18n/grid.locale-cn.js", 
		                null ]
        $('.page-content-area').ace_ajax('loadScripts', scripts, function() {
        	// inline scripts related to this page
        	jQuery(function($) {
        		var grid_selector = "#grid-table";
        		var pager_selector = "#grid-pager";

        		// resize to fit page size
        		$(window).on('resize.jqGrid', function() {
        			$(grid_selector).jqGrid('setGridWidth', $(".col-xs-12").width()-$(".col-sm-2").width()-10);
            		})
        		// resize on sidebar collapse/expand
        		var parent_column = $(grid_selector).closest('[class*="col-"]');
        		$(document).on('settings.ace.jqGrid', function(ev, event_name, collapsed) {
        			if (event_name === 'sidebar_collapsed' || event_name === 'main_container_fixed') {
        				// setTimeout is for webkit only to give time for DOM changes and then redraw!!!
        				setTimeout(function() {
        					$(grid_selector).jqGrid('setGridWidth', parent_column.width());
        				}, 0);
        			}
        		})
        		var hiddenCols=$.ajax({url:"${contextPath}/sys/workgroup/getColHidden",async:false});
    			var hiddenColsJSON=JSON.parse(hiddenCols.responseText);
        		jQuery(grid_selector).jqGrid({
        			subGrid : false,
        			url : "${contextPath}/sys/workgroup/getworkgroup",
        			datatype : "json",
        			height : 450,
        			colNames : [ '','工作组', '专业','公私','备注'],
        			colModel : [ {
        				name : '',
        				index : '',
        				width : 70,
        				fixed : true,
        				sortable : false,
        				resize : false,
        				formatter : authorityFormatter,
        				//formatter : 'actions',
        				formatoptions : {
        					keys : true,
        					//delbutton : false,//disable delete button
        					delOptions : {
        						recreateForm : true,
        						beforeShowForm : beforeDeleteCallback,
        						errorTextFormat: function (response) {
        		  					var result = eval('('+response.responseText+')');
        		  				    return result.message;
        		  				}
        					}
        					//editformbutton:true, editOptions:{recreateForm:true, beforeShowForm:beforeEditCallback}
        				}
        			}, {
        				name : 'workGroupName',
        				index : 'workGroupName',
        				label : '工作组',
        				width : 120,
        				editable : true,
        				editoptions : {size : "20", maxlength : "20"},
        				searchoptions : {sopt : ['cn']},
        				editrules : {required : true},
        			},{
        				name : 'sysOrgStru.orgName',
        				index : 'orgName',
        				label : '专业',
        				width : 100,
						editrules : {required : true},
						editable : false,
						search : false,
					
        			},{
        				name : 'prvaiteOwned',
        				index : 'prvaiteOwned',
        				label : '公私',
        				width : 120,
        				editable : true,
        				search : false,
        				
        				edittype : "select",
						editoptions : {
						value : "true:公有;false:私有"
						},
        				editrules : {required : true},
        				formatter:'select'
        				
        			},{
        				name : 'remarks',
        				index : 'remarks',
        				label : '备注',
        				width : 200,
        				editable : true,
        				edittype : "textarea",
        				searchoptions : {sopt : ['cn']},
        			}],
        			//scroll : 1, // set the scroll property to 1 to enable paging with scrollbar - virtual loading of records
        			sortname : "createdTime",
        			sortorder : "desc",
        			viewrecords : true,
        			rowNum : 30,
        			rowList : [ 30, 60, 90 ],
        			pager : pager_selector,
        			altRows : true,
        			//toppager : true,
        			multiselect : true,
        			//multikey : "ctrlKey",
        	        multiboxonly : true,
        			loadComplete : function() {
        				var table = this;
        				setTimeout(function(){
        					styleCheckbox(table);
        					updateActionIcons(table);
        					updatePagerIcons(table);
        					enableTooltips(table);
        			}, 0);
        			},
        			
        			editurl : "${contextPath}/sys/workgroup/operateWorkGroup",
        			
        		});
        		function authorityFormatter(cellvalue, options,
						cell) {
					var template = "<div class='ui-pg-div ui-inline-edit'><span><a onclick ='Jump(\""+ cell.id
							+ "\")' id='a"+ cell.id+ "'  title='编辑' style='text-decoration:none;' class='ui-icon ui-icon-pencil'></a></span>&nbsp;<span><a id='a"
							+ cell.id
							+ "' onclick = 'showMenu(\""+ cell.id+"\")' title='删除' style='text-decoration:none;' class='ui-icon ui-icon-trash'></a></span>"
					return template;
				}
        		$(window).triggerHandler('resize.jqGrid');// trigger window resize to make the grid get the correct size
        		function aceSwitch(cellvalue, options, cell) {
        			setTimeout(function() {
        				$(cell).find('input[type=checkbox]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
        			}, 0);
        		}
        		
        		// navButtons
        		jQuery(grid_selector).jqGrid('navGrid', pager_selector, { // navbar options
        			edit : false,
        			editicon : 'ace-icon fa fa-pencil blue',
        			add : true,
        			addicon : 'ace-icon fa fa-plus-circle purple',
        			del : false,
        			delicon : 'ace-icon fa fa-trash-o red',
        			search : true,
        			searchicon : 'ace-icon fa fa-search orange',
        			refresh : true,
        			refreshicon : 'ace-icon fa fa-refresh blue',
        			view : true,
        			viewicon : 'ace-icon fa fa-search-plus grey'
        		}, {
        			// edit record form
        			// closeAfterEdit: true,
        			//width: 1000,
        			closeAfterEdit: true,
        			recreateForm : true,
        			beforeShowForm : function(e) {
        				var form = $(e[0]);
        				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
        				style_edit_form(form);
        			},
    				errorTextFormat: function (response) {
    					//var result = $.parseJSON(response.responseText);
    				    return response.responseText;
    				}
        		}, {
        			// new record form
        			//width: 300,
        			//height:350,
        			closeAfterAdd : true,
        			//closeAfterSubmit : true,
        			recreateForm : true,
        			viewPagerButtons : false,
        			beforeShowForm : function(e) {
        				var form = $(e[0]);
        				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
        				style_edit_form(form);
        			},
        			onclickSubmit : function(params, postdata) {
						
						var orgworkId = $("#orgId").val();
								return {"orgworkId":orgworkId };
					},
        			errorTextFormat: function (response) {
    					//var result = $.parseJSON(response.responseText);
    				    return response.responseText;
    				},
        			//提交后响应刷新
					afterSubmit : function(response, postdata) { 
						 $(this).trigger("reloadGrid");
						reloadTree();
						return [true, response.responseText];
	        			}
        		}, {
        			// delete record form
        			recreateForm : true,
        			beforeShowForm : function(e) {
        				var form = $(e[0]);
        				if (form.data('styled'))
        					return false;
        				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
        				style_delete_form(form);
        				form.data('styled', true);
        			},//提交后响应刷新
					afterSubmit : function(response, postdata) { 
						 $(this).trigger("reloadGrid");
						reloadTree();
						return [true, response.responseText];
	       			},
	       			errorTextFormat: function (response) {
    					//var result = $.parseJSON(response.responseText);
    				    return response.responseText;
    				}
        		}, {
        			// search form
        			recreateForm : true,
        			afterShowSearch : function(e) {
        				var form = $(e[0]);
        				form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
        				style_search_form(form);
        			},
        			afterRedraw : function() {
        				style_search_filters($(this));
        			},
        			multipleSearch : true 
            		/**
            		 * multipleGroup:true, showQuery: true
            		 */
        		}, {
        			// view record form
        			width: 800,
	       			recreateForm : true,
	       			beforeShowForm : function(e) {
	       				var form = $(e[0]);
	       				form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
	       			}
        		});
        		// add custom button to export the data to excel
    			
        		
        		function style_edit_form(form) {
        			// form.find('input[name=statusCn]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
        			// don't wrap inside a label element, the checkbox value won't be submitted (POST'ed)
        			// .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');

        			// update buttons classes
        			var buttons = form.next().find('.EditButton .fm-button');
        			buttons.addClass('btn btn-sm').find('[class*="-icon"]').hide();// ui-icon, s-icon
        			buttons.eq(0).addClass('btn-primary').prepend('<i class="ace-icon fa fa-check"></i>');
        			buttons.eq(1).prepend('<i class="ace-icon fa fa-times"></i>')

        			buttons = form.next().find('.navButton a');
        			buttons.find('.ui-icon').hide();
        			buttons.eq(0).append('<i class="ace-icon fa fa-chevron-left"></i>');
        			buttons.eq(1).append('<i class="ace-icon fa fa-chevron-right"></i>');
        		}

        		function style_delete_form(form) {
        			var buttons = form.next().find('.EditButton .fm-button');
        			buttons.addClass('btn btn-sm btn-white btn-round').find('[class*="-icon"]').hide();// ui-icon, s-icon
        			buttons.eq(0).addClass('btn-danger').prepend('<i class="ace-icon fa fa-trash-o"></i>');
        			buttons.eq(1).addClass('btn-default').prepend('<i class="ace-icon fa fa-times"></i>')
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
        			buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'ace-icon fa fa-retweet');
        			buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'ace-icon fa fa-comment-o');
        			buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'ace-icon fa fa-search');
        		}

        		function beforeDeleteCallback(e) {
        			var form = $(e[0]);
        			if (form.data('styled'))
        				return false;
        			form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
        			style_delete_form(form);
        			form.data('styled', true);
        		}

        		function beforeEditCallback(e) {
        			var form = $(e[0]);
        			form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
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
        			$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function() {
        				var icon = $(this);
        				var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

        				if ($class in replacement)
        					icon.attr('class', 'ui-icon ' + replacement[$class]);
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
     			jQuery(grid_selector).jqGrid( 'hideCol', "orgShortname");
     			//jQuery(grid_selector).jqGrid( 'hideCol', "orgAddress");
     			jQuery(grid_selector).jqGrid( 'hideCol', "remark");
     			jQuery(grid_selector).jqGrid( 'hideCol', "orgType");
     			jQuery(grid_selector).jqGrid( 'hideCol', "cmpNo");
     			jQuery(grid_selector).jqGrid( 'hideCol', "orgFunction");
        		$(document).one('ajaxloadstart.page', function(e) {
        			$(grid_selector).jqGrid('GridUnload');
        			$('.ui-jqdialog').remove();
        		});
        		
        	});
        });
        
    </script>
<style type="text/css">
.ztree li span.button.add {
	margin-left: 2px;
	margin-right: -1px;
	background-position: -144px 0;
	vertical-align: top;
	*vertical-align: middle
}
</style>