<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<link rel="stylesheet" href="${contextPath}/static/assets/css/jquery-ui.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/ui.jqgrid.css" />
	<SCRIPT type="text/javascript">
	function setCheckedNodes() {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		var nodes = zTree.getCheckedNodes(true);
		var strCheckedNodes = "";
		for (var i=0, iLen=nodes.length; i<iLen; i++) {
			strCheckedNodes += nodes[i].id + ",";
		}
		if (strCheckedNodes.length > 0 ) {
			strCheckedNodes = strCheckedNodes.substring(0, strCheckedNodes.length-1);
		}
		$("#CheckedNodes").attr("value", strCheckedNodes);
		var rolNo=$("#rolNo").val();
	
		 htmlobj=$.ajax({url:"${contextPath}/sys/sysrolec/saveSysRoleC?rolNo="+rolNo+"&CheckedNodes="+strCheckedNodes,async:false});

		
	}
	
	function doSubmit()
	{
		
		//${contextPath}/sys/sysrolec/saveSysRoleC
		setCheckedNodes();
		$('#modal-table').modal('hide')

		//form1.submit();
	}
	function Formatter(cellvalue) {
		var url="${contextPath}/sys/sysmenu/getSysMenuTreeList/"+cellvalue;
		$.ajax({
  		url: url,  
  		success: function(data){
  			$("#modal-table").modal("toggle");
  			$("#rolNo").attr("value", cellvalue);
  			$.fn.zTree.init($("#treeDemo"), setting, eval(data));
  			//$("#selectAll").bind("click", selectAll);
          }
      });
	}
		var setting = {
			view: {
				selectedMulti: false
			},
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onCheck: onCheck
			}
		};

		var zNodes ="";

		var clearFlag = false;
		function onCheck(e, treeId, treeNode) {
			count();
			if (clearFlag) {
				clearCheckedOldNodes();
			}
		}
		function clearCheckedOldNodes() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getChangeCheckedNodes();
			for (var i=0, l=nodes.length; i<l; i++) {
				nodes[i].checkedOld = nodes[i].checked;
			}
		}
		function count() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			checkCount = zTree.getCheckedNodes(true).length,
			nocheckCount = zTree.getCheckedNodes(false).length,
			changeCount = zTree.getChangeCheckedNodes().length;
			$("#checkCount").text(checkCount);
			$("#nocheckCount").text(nocheckCount);
			$("#changeCount").text(changeCount);

		}
		function createTree() {
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			count();
			clearFlag = $("#last").attr("checked");
		}

		$(document).ready(function(){
			createTree();			
			$("#init").bind("change", createTree);
			$("#last").bind("change", createTree);
		});
	</SCRIPT>
<div class="row">
	<div class="col-xs-12">
		<table id="grid-table"></table>

		<div id="grid-pager"></div>

		<script type="text/javascript">
			var $path_base = "${contextPath}/static";//in Ace demo this will be used for editurl parameter
		</script> 

		<!-- PAGE CONTENT ENDS -->
	</div><!-- /.col -->
</div><!-- /.row -->

<div id="modal-table" class="modal fade" tabindex="-1" data-backdrop="static">
	<div class="modal-dialog">
		<form name="form1" action="${contextPath}/sys/sysrolec/saveSysRoleC"  method="post" >
		   <input type="hidden" id="CheckedNodes" name="CheckedNodes" value="">
		   <input type="hidden" id="rolNo" name="rolNo" >
			<div class="modal-content">
				<div class="modal-header no-padding">
					<div class="table-header" style="background: #307ecc">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							<span class="white">&times;</span>
						</button>
						角色授权
					</div>
				</div>
				<div class="modal-body" style="max-height: 500px;overflow-y: scroll;">
					<div class="zTreeDemoBackground left">
						<ul id="treeDemo" class="ztree"></ul>
					</div>
				</div>
				<div class="modal-footer no-margin-top">
					<div class="text-center">
						<a id="submitButton" type="submit" class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm btn-primary" onclick="doSubmit()">
							<i class="ace-icon fa fa-check"></i>提交
							<span class="ui-icon ui-icon-disk" style="display: none;"></span>
						</a>
						
						<a id="cData" class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm" data-dismiss="modal" aria-hidden="true">
							<i class="ace-icon fa fa-times"></i>取消
							<span class="ui-icon ui-icon-close" style="display: none;"></span>
						</a>
					</div>
				</div>
			</div><!-- /.modal-content -->
		</form>
	</div><!-- /.modal-dialog -->
</div>

<!-- page specific plugin scripts -->
<script type="text/javascript">
		var scripts = [ null, "${contextPath}/static/assets/js/jqGrid/jquery.jqGrid.js", "${contextPath}/static/assets/js/jqGrid/i18n/grid.locale-cn.js", "${contextPath}/static/assets/js/fuelux/fuelux.tree.js", null ]
        $('.page-content-area').ace_ajax('loadScripts', scripts, function() {
        	// inline scripts related to this page
        	jQuery(function($) {
        		var grid_selector = "#grid-table";
        		var pager_selector = "#grid-pager";

        		// resize to fit page size
        		$(window).on('resize.jqGrid', function() {
        			$(grid_selector).jqGrid('setGridWidth', $(".page-content").width());
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

        		jQuery(grid_selector).jqGrid({
        			subGrid : false,
        			url : "${contextPath}/sys/sysrolem/getSysRoleM",
        			datatype : "json",
        			height : 450,
        			colNames : ['','ID','角色编码', '角色名称', '备注', '授权'],
        			colModel : [ {
        				name : '',
        				index : '',
        				width : 80,
        				fixed : true,
        				sortable : false,
        				resize : false,
        				formatter : 'actions',
        				search : false,
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
        				name : 'id',
        				index : 'id',
        				label : 'ID',
        				width : 60,
        				sorttype : "long",
        				hidden:true,
        				search : false
        			},{
        				name : 'rolNo',
        				index : 'rolNo',
        				label : '角色编码',
        				width : 120,
        				editable : true,
        				//hidden:true,
        				searchoptions : {sopt : ['cn']},
        				editoptions : {size : "20", maxlength : "10"},
        				searchoptions : {sopt : ['eq']},
        				editrules : {required : true,edithidden:true}
        			},{
        				name : 'rolName',
        				index : 'rolName',
        				label : '角色名称',
        				width : 260,
        				editable : true,
        				searchoptions : {sopt : ['cn']},
        				editoptions : {size : "20", maxlength : "20"},
        				editrules : {required : true}
        			}, {
        				name : 'remark',
        				index : 'remark',
        				label : '备注',
        				width : 200,
        				editable : true,
        				search : false,
        				edittype : 'textarea', 
        				editoptions : {rows : "2", cols : "18", maxlength : "40"}
        			}, {
        				name : 'sq',
        				index : 'sq',
        				label : '授权',
        				width : 60,
        				editable : false,
        				search : false,
        				sortable : false
        				//formatter : authorityFormatter
        			} ],
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
        			editurl : "${contextPath}/sys/sysrolem/operateSysRoleM",
        			gridComplete:function(){ //在此事件中循环为每一行添加修改和删除链接 
        					var ids=jQuery(grid_selector).jqGrid('getDataIDs'); 
        					for(var i=0; i<ids.length; i++){
        					var id=ids[i]; 
        					var rowData = $(grid_selector).jqGrid('getRowData',id);
        					var rolno = rowData.rolNo;
        					modify ="<a href='#' style='color:#6A5ACD' onclick='Formatter(\""+rolno+"\")' class='btn btn-xs btn-warning'><i class='ace-icon fa fa-flag bigger-120'></i></a>"; //这里的onclick就是调用了上面的javascript函数 Modify(id) 
        					jQuery(grid_selector).jqGrid('setRowData', ids[i], { sq: modify}); 
        					} 
        					}
        			
        			
        		});
        		
        		$(window).triggerHandler('resize.jqGrid');// trigger window resize to make the grid get the correct size
        		
        		// enable search/filter toolbar
        		// jQuery(grid_selector).jqGrid('filterToolbar',{defaultSearch:true,stringResult:true})
        		// jQuery(grid_selector).filterToolbar({});
        		// switch element when editing inline
        		
        		function aceSwitch(cellvalue, options, cell) {
        			setTimeout(function() {
        				$(cell).find('input[type=checkbox]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
        			}, 0);
        		}
        		
        		function authorityFormatter(cellvalue, options, cell) {
        			//Formatter(cellvalue);
        			var template = "<button data-toggle='modal' onclick='javascript:$(\"#modal-table\").modal(\"toggle\");$(\"#rolNoId\").val(\"" + cell.rolNo +"\")' class='btn btn-xs btn-warning'><i class='ace-icon fa fa-flag bigger-120'></i></button>";
        			return template;
        		}
        		
        		$("#modal-table").on("hidden.bs.modal", function() {
        			//location.href = location.href;
				});
        		
        		var remoteDateSource = function(options, callback) {
        			var parent_id = null;
        			if (!('text' in options || 'type' in options)) {
        				parent_id = 0;// load first level data
        			} else if ('type' in options && options['type'] == 'folder') {// it has children
        				if ('additionalParameters' in options && 'children' in options.additionalParameters)
        					parent_id = options.additionalParameters['id'];
        			}
        			if (parent_id !== null) {
        				var url="${contextPath}/sys/sysmenu/getSysMenuTreeList/"+cellvalue;
        				$.ajax({
        		  		url: url,  
        		  		success: function(data){
        		  			$.fn.zTree.init($("#treeDemo"), setting, eval(data));
        		  			//$("#selectAll").bind("click", selectAll);
        		          }
        		      });
        			}
        		};
        		$('#authorityTree').ace_tree({
        			dataSource : remoteDateSource,
        			multiSelect : true,
        			loadingHTML : '<div class="tree-loading"><i class="ace-icon fa fa-refresh fa-spin blue"></i></div>',
        			'open-icon' : 'ace-icon tree-minus',
        			'close-icon' : 'ace-icon tree-plus',
        			'selectable' : true,
        			'selected-icon' : 'ace-icon fa fa-check',
        			'unselected-icon' : 'ace-icon fa fa-times',
        			cacheItems : true,
        			folderSelect : false
        		});
        		$('#submitButton').on('click', function() {
					var output = '';
					var items = $('#authorityTree').tree('selectedItems');
					for(var i in items) if (items.hasOwnProperty(i)) {
						var item = items[i];
						output += item.additionalParameters['id'] + ",";
					}
					$.ajax({
    					url : "${contextPath}/sys/sysrolec/saveSysRoleC",
    					data : {
    						rolNo : $("#rolNoId").val(),
    						menuNo : output
    					},
    					type : 'POST',
    					dataType : 'json',
    					complete : function(response) {
    						$("#modal-table").modal("toggle");
    					}
    				});
					//$('#authorityTree').tree('destroy');
				});
        		
        		// navButtons
        		jQuery(grid_selector).jqGrid('navGrid', pager_selector, { // navbar options
        			edit : true,
        			editicon : 'ace-icon fa fa-pencil blue',
        			add : true,
        			addicon : 'ace-icon fa fa-plus-circle purple',
        			del : true,
        			delicon : 'ace-icon fa fa-trash-o red',
        			search : true,
        			searchicon : 'ace-icon fa fa-search orange',
        			refresh : true,
        			refreshicon : 'ace-icon fa fa-refresh blue',
        			view : true,
        			viewicon : 'ace-icon fa fa-search-plus grey'
        		}, {
        			// edit record form
        			closeAfterEdit: true,
        			// width: 700,
        			recreateForm : true,
        			beforeShowForm : function(e) {
        				var form = $(e[0]);
        				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
        				style_edit_form(form);
        			},
    				errorTextFormat: function (response) {
    					//var result = eval('('+response.responseText+')');
    				    return response.responseText;
    				}
        		}, {
        			// new record form
        			// width: 700,
        			closeAfterAdd : true,
        			recreateForm : true,
        			viewPagerButtons : false,
        			beforeShowForm : function(e) {
        				var form = $(e[0]);
        				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
        				style_edit_form(form);
        			},
    				errorTextFormat: function (response) {
    					//var result = eval('('+response.responseText+')');
    				    return response.responseText;
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
        			},
        			onClick : function(e) {
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
        			recreateForm : true,
        			beforeShowForm : function(e) {
        				var form = $(e[0]);
        				form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
        			}
        		})
        		
        		// add custom button to export the data to excel
				jQuery(grid_selector).jqGrid('navButtonAdd', pager_selector,{
				   caption : "",
			       title : "导出Excel",
			       buttonicon : "ace-icon fa fa-file-excel-o green", 
			       onClickButton : function () { 
			    	   var keys = [], ii = 0, rows = "";
			    	   var ids = $(grid_selector).getDataIDs(); // Get All IDs
			    	   var row = $(grid_selector).getRowData(ids[0]); // Get First row to get the labels
			    	   //var label = $(grid_selector).jqGrid('getGridParam','colNames');
   			    	   for (var k in row) {
			    	   	   keys[ii++] = k; // capture col names
			    	   	   rows = rows + k + "\t"; // output each Column as tab delimited
			    	   }
			    	   rows = rows + "\n"; // Output header with end of line
			    	   for (i = 0; i < ids.length; i++) {
			    	   	   row = $(grid_selector).getRowData(ids[i]); // get each row
			    	   	   for (j = 0; j < keys.length; j++)
			    	   		   rows = rows + row[keys[j]] + "\t"; // output each Row as tab delimited
			    	   	   rows = rows + "\n"; // output each row with end of line
			    	   }
			    	   rows = rows + "\n"; // end of line at the end
			    	   var form = "<form name='csvexportform' action='${contextPath}/sys/sysrolem/operateSysRoleM?oper=excel' method='post'>";
			    	   form = form + "<input type='hidden' name='csvBuffer' value='" + rows + "'>";
			    	   form = form + "</form><script>document.csvexportform.submit();</sc" + "ript>";
			    	   OpenWindow = window.open('', '');
			    	   OpenWindow.document.write(form);
			    	   OpenWindow.document.close();
			       } 
				});
        		
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

        		// var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');

        		$(document).one('ajaxloadstart.page', function(e) {
        			$(grid_selector).jqGrid('GridUnload');
        			$('.ui-jqdialog').remove();
        		});
        		
        	});
        });
</script>
