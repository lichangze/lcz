<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="${contextPath}/static/assets/css/jquery-ui.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/datepicker.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/ui.jqgrid.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/images/css/layer.css" />
<script src="${contextPath}/static/json/json2.js"></script>
<script src="${contextPath}/static/assets/images/js/layer.js"></script>
<script src="${contextPath}/static/ztree/js/jquery.ztree.core-3.5.js"></script>
<script src="${contextPath}/static/ztree/js/jquery.ztree.excheck-3.5.js"></script>
<script src="${contextPath}/static/ztree/js/jquery.ztree.exedit-3.5.js"></script>
<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
		<div class="row" id="row">
		<div class="col-sm-2" style="padding:5px;">
				<div class="widget-box">
					<div class="widget-header widget-header-flat">
						<h4 class="widget-title smaller">
							公司 & 专业
						</h4>
					</div>

					<div class="widget-body" style="height: 500px; overflow-y: scroll;">
						<div class="widget-main">
						
									<ul id="treeDemo" class="ztree"></ul>
								
						</div>
					</div>
				</div>
			</div>
          
            <div class="col-sm-10" style="padding:5px;">
				
					<div class="widget-body">
							<table id="grid-table"></table>

							<div id="grid-pager"></div>
							<div id="consoleDlg"></div>
							<script type="text/javascript">
										var $path_base = "${contextPath}/static";
							</script>
					</div>
						
					
			</div>
          
			

			
		</div>

		<!-- PAGE CONTENT ENDS -->
	</div>
	<!-- /.col -->
</div>


<!-- page specific plugin scripts -->
<script type="text/javascript">
var strOrgLeaders="";
function checkPhone(value, colname){
	if (value.match("^\\d{11}$"))
			return [true, ""];
		else
			return [false, "电话格式不正确"]; 
	}


function toOrgStru(){
	var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
    var nodes = treeObj.getSelectedNodes();
    if(nodes.length==1){
    var node=nodes[0];
    var id=node.id;
    var nodeType=node.nodeType;
	var hrefLink='${contextPath}/sys/sysorgstru/toSysOrgStru?fid='+id+'&nodeType='+nodeType;
	layer.open({
		   type: 2, //page层
		   area: ['1000px', '375px'],
		   title: '添加',
		   skin: 'layui-layer-lan',
		   fix: false, //不固定
		   maxmin: true,
		   moveType: 1, //拖拽风格，0是默认，1是传统拖动
		   shift: 1, //0-6的动画形式，-1不开启
		   content: [hrefLink, 'yes']
		 });   
   }else{
   	layer.alert("请选择左侧父级信息");
   }  
}


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
			 url : "${contextPath}/sys/sysorgstru/getSysOrgStru",
			 postData : {id:treeNode.id,nodeType:treeNode.nodeType},
    		 datatype : "json",
            }).trigger("reloadGrid");
	    });
	className = (className === "dark" ? "":"dark");

	return (treeNode.click != false);
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
	//var zNodes ="";
	var url="${contextPath}/sys/sysorgstru/getSysOrgStruTree";
		$.ajax({
  		url: url,  
  		success: function(data){
  			$.fn.zTree.init($("#treeDemo"), setting, eval(data));
  			$("#selectAll").bind("click", selectAll);
          }
      });  
	
		//var zNodes ="";
});


		var scripts = [ null, "${contextPath}/static/assets/js/date-time/bootstrap-datepicker.js","${contextPath}/static/assets/js/date-time/bootstrap-datepicker.min.js", "${contextPath}/static/assets/js/date-time/locales/bootstrap-datepicker.zh-CN.js", "${contextPath}/static/assets/js/jqGrid/jquery.jqGrid.js", "${contextPath}/static/assets/js/jqGrid/i18n/grid.locale-cn.js", null ]
        $('.page-content-area').ace_ajax('loadScripts', scripts, function() {
        	// inline scripts related to this page
        	jQuery(function($) {
        		var grid_selector = "#grid-table";
        		var pager_selector = "#grid-pager";

        		// resize to fit page size
        		$(window).on('resize.jqGrid', function() {
        			$(grid_selector).jqGrid('setGridWidth', $(".col-sm-10").width());
            		})
        		// resize on sidebar collapse/expand
        		var parent_column = $(grid_selector).closest('[class*="col-"]');
        		$(document).on('settings.ace.jqGrid', function(ev, event_name, collapsed) {
        			if (event_name === 'sidebar_collapsed' || event_name === 'main_container_fixed') {
        				// setTimeout is for webkit only to give time for DOM changes and then redraw!!!
        				setTimeout(function() {
        					$(grid_selector).jqGrid('setGridWidth', $(".col-sm-10").width());
        				}, 0);
        			}
        		})
    
        		jQuery(grid_selector).jqGrid({
        			subGrid : false,
        			url : "${contextPath}/sys/sysorgstru/getSysOrgStru",
        			datatype : "json",
        			height : 450,
        			colNames : [ '','专业编码', '专业名称', '所属公司', '父级专业', '所属部门' ,'排序','备注'],
        			colModel : [ {
        				name : '',
        				index : '',
        				width : 70,
        				fixed : true,
        				sortable : false,
        				resize : false,
        				formatter : 'actions',
        				formatoptions : {
        					keys : true,
        					delOptions : {
        						recreateForm : true,
        						beforeShowForm : beforeDeleteCallback,
        						errorTextFormat: function (response) {
        		  				 return response.responseText;
        		  				},
        		  				//提交后响应刷新
        						afterSubmit : function(response, postdata) { 
        							if(response.responseText == "fail1"){
	        							layer.alert("该专业下存在子专业，无法删除!");
        							}else{
	        							 $(this).trigger("reloadGrid");
	        							reloadTree();
        							}
        							return [true, response.responseText];        								
        		        		}
        					},
                            editformbutton: true,
        					editOptions : {
        						closeAfterEdit: true,
        						//提交后响应刷新
        						afterSubmit : function(response, postdata) { 						
        							 $(this).trigger("reloadGrid");
        							reloadTree();
        							return [true, response.responseText];
        		        		}
        					}
        					
        				}
        			},
        			 /* {
        				name : 'id',
        				index : 'id',
        				label : 'id',
        				width : 1,
        				editable : false,
        				//hidden:(hiddenColsJSON.id=='true')
        			},  */
        			{
        				name : 'orgNo',
        				index : 'orgNo',
        				label : '专业编码',
        				width : 50,
        				editable : true,
        				editoptions : {size : "10", maxlength : "10"},
        				editrules : {required : true},
        				searchoptions : {sopt : [ 'eq','ne' ]}
        			},{
        				name : 'orgName',
        				index : 'orgName',
        				label : '专业名称',
        				width : 100,
        				editable : true,
        				editoptions : {size : "20", maxlength : "20"},
        				editrules : {required : true},
        				searchoptions : {sopt : ['cn','nc']} 
        			},{
        				name : 'company.cmpName',
        				index : 'company.cmpName',
        				label : '所属公司',
        				width : 100,
        				editable : false,
        				search : true,
        				searchoptions : {sopt : ['in','ni']}
        			},
        			{
        				name : 'forgStru.orgName',
        				index : 'forgStru.orgName',
        				label : '父级专业',
        				width : 100,
        				editable : false,
        			    search : true,
        			    searchoptions : {sopt : ['cn','nc']}
        			},
        			{
        				name : 'deptId',
        				index : 'deptId',
        				label : '所属部门',
        				width : 100,
        				editable : true,
        				edittype:'select',
        				editoptions : {
        					dataUrl : "${contextPath}/sys/sysdept/getDepts",
        				},
        				//editrules : {required : true},
        				search : true,
        				stype : 'select',
        			    searchoptions : {
        			    	sopt : ['eq'],
        			    	dataUrl	: "${contextPath}/sys/sysdept/getDepts"
        			    }
        			},
        			{
        				name : 'orgOrder',
        				index : 'orgOrder',
        				label : '排序',
        				width : 30,
        				align:"right",
        				editable : true,
        				sorttype : "long",
        				search : false,
        				editrules : {required : true,number : true}
        			},{
        				name : 'remark',
        				index : 'remark',
        				label : '备注',
        				width : 100,
        				editable : true,
        				search : false
        			}],
        			sortname : "orgOrder",
        			sortorder : "asc",
        			viewrecords : true,
        			rowNum : 30,
        			rowList : [ 30, 60, 90 ],
        			pager : pager_selector,
        			altRows : true,
        			multiselect : true,
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
        			editurl : "${contextPath}/sys/sysorgstru/operateSysOrgStru"
        		});

        		$(window).triggerHandler('resize.jqGrid');// trigger window resize to make the grid get the correct size
        		function aceSwitch(cellvalue, options, cell) {
        			setTimeout(function() {
        				$(cell).find('input[type=checkbox]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
        			}, 0);
        		}
        		//隐藏ID
        		//jQuery(grid_selector).jqGrid('hideCol','id');
        		
        		// navButtons
        		jQuery(grid_selector).jqGrid('navGrid', pager_selector, { // navbar options
        			edit : true,
        			editicon : 'ace-icon fa fa-pencil blue',
        			add : false,
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
        			// closeAfterEdit: true,
        			width: 800,
        			closeAfterEdit: true,
        			recreateForm : true,
        			beforeShowForm : function(e) {
        				var form = $(e[0]);
        				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
        				style_edit_form(form);
        			},
    				errorTextFormat: function (response) {
    					 return response.responseText;
    				},
    				//提交后响应刷新
					afterSubmit : function(response, postdata) { 						
						 $(this).trigger("reloadGrid");
						reloadTree();
						return [true, response.responseText];
	        			}
        		}, {
        			// new record form
        			width: 800,
        			closeAfterAdd : true,
        			recreateForm : false,
        			viewPagerButtons : false,
        			beforeShowForm : function(e) {
        				var form = $(e[0]);
        				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
        				style_edit_form(form);
        			},
        			errorTextFormat: function (response) {
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
						if(response.responseText == 'fail1'){
							layer.alert("存在子专业，无法删除!");
						}
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
            
        		}, {
        			// view record form
        			width: 800,
	       			recreateForm : true,
	       			beforeShowForm : function(e) {
	       				var form = $(e[0]);
	       				form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
	       			}
        		});

			jQuery(grid_selector).jqGrid('navButtonAdd', pager_selector,{
    	   			caption:"",
    	   			title : "添加",
    	   			buttonicon:"ace-icon fa fa-plus-circle purple",   
    	   			onClickButton: function(){
    	   				toOrgStru();		  
    	   			},
    	   			position:"first"
    			});
        	
    	
        		function style_edit_form(form) {
        			var buttons = form.next().find('.EditButton .fm-button');
        			buttons.addClass('btn btn-sm').find('[class*="-icon"]').hide();// ui-icon, s-icon
        			buttons.eq(0).addClass('btn-primary').prepend('<i class="ace-icon fa fa-check"></i>');
        			buttons.eq(1).prepend('<i class="ace-icon fa fa-times"></i>');
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

                $("div.ui-pg-div ui-inline-save").click(function(){
                        $(this).trigger("reloadGrid");
                        reloadTree();
                       
                    });
                    $(".ui-pg-div ui-inline-save").bind("click", function(){
                        $(this).trigger("reloadGrid");
                        reloadTree();
                        });
                    
                     
                    
                    //刷新按钮刷新重载
                    $("#refresh_grid-table").click(function(){
                        $(this).trigger("reloadGrid");
                        reloadTree();
                    });
                   


        		function enableTooltips(table) {
        			$('.navtable .ui-pg-button').tooltip({
        				container : 'body'
        			});
        			$(table).find('.ui-pg-div').tooltip({
        				container : 'body'
        			});
        		}
     			//jQuery(grid_selector).jqGrid( 'hideCol', "orgShortname");
     			//jQuery(grid_selector).jqGrid( 'hideCol', "orgAddress");
     			//jQuery(grid_selector).jqGrid( 'hideCol', "remark");
     			jQuery(grid_selector).jqGrid( 'hideCol', "supperOrgName");
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