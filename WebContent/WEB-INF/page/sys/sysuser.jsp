
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<link rel="stylesheet" href="${contextPath}/static/assets/css/jquery-ui.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/datepicker.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/ui.jqgrid.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/bootstrap-duallistbox.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/bootstrap-multiselect.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/select2.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/images/css/layer.css" />
<script src="${contextPath}/static/assets/images/js/layer.js"></script>
<SCRIPT type="text/javascript">
	function Formatter(cellvalue) {
		$("#userNo").attr("value", cellvalue);
		$("#modal-table").modal("toggle");
		$("#rolNoId").val(" + cell.rolNo +");
		var oTable1 = $('#sample-table-1').dataTable({
	            "bServerSide" : true, //是否启动服务器端数据导入
	            "sAjaxSource": "${contextPath}/sys/userroleaccess/getRoleNameList?userId="+cellvalue ,
	            "fnServerData":retrieveData1,
				"bAutoWidth" : false,
				"bPaginate" : false,
				"bSort" : false, //排序功能
				"bInfo": false,
				"bFilter" : false,
		        "aoColumns": 
	                [
						{ 'mDataProp': 'id' },
	                   	{ 'mDataProp': 'rolName' },
	                ]  ,
                "columnDefs": [
                     {
                    	"targets": [2],
                    	//'mDataProp': 'checked',
                       	"data": "id",
                       	"render": function(data, type, full) {
                       		var msg = "";
                       		if(full.checked == 'true'){
                       			msg = "<td class='center'><label class='position-relative'>"+
 		                 	   "<input id='roleBox' name='roleBox' type='checkbox' class='ace' checked='true' value='"+full.rolNo+"'/>"+
                       			"<span class='lbl'></span></label></td>";
                       		}else{
                       			msg = "<td class='center'><label class='position-relative'>"+
 		                 	   "<input id='roleBox' name='roleBox' type='checkbox' class='ace' value='"+full.rolNo+"'/>"+
                      			"<span class='lbl'></span></label></td>";
                       		}
                         	return msg;
                       }
                     }
                   ]
	           
		    } );
    		 //函数的参数是固定，不能更改。  
    		function retrieveData1( sSource, aoData, fnCallback ) {     
    		    //查询条件称加入参数数组     
    		    $.ajax( {     
    		        type: "POST",      
    		        url: sSource,
    		        dataType:"json",
					data:aoData, 
    		        success: function(data) {
    		           	$('#sample-table-1').dataTable().fnDestroy();
    		           	fnCallback(data);//服务器端返回的对象的returnObject部分是要求的格式      
    		        }     
    		    }); 
    		}  
		
    		 //函数的参数是固定，不能更改。  
    		function retrieveData2( sSource, aoData, fnCallback ) {   
    		    //查询条件称加入参数数组     
    		    $.ajax( {     
    		        type: "POST",      
    		        url: sSource,
    		        dataType:"json",
					data:aoData, 
    		        success: function(data) {
						
    		           	$('#sample-table-2').dataTable().fnDestroy();
    		           	fnCallback(data);//服务器端返回的对象的returnObject部分是要求的格式      
    		        }     
    		    }); 
    		}  
    		
	}
	function doSubmit()
	{
		var strCheckedAccess = setCheckedAccess();
		var strCheckedRole = setCheckedRole();
		var userNo = $("#userNo").val();
		
		$.ajax({
					url:"${contextPath}/sys/userroleaccess/saveUserIsRoleAndAccess",
					type : "POST",
					data: {userNo:userNo,checkedAccess:strCheckedAccess,checkedRole:strCheckedRole}
			});
		$('#modal-table').modal('hide');

		//form1.submit();
	}
	function setCheckedAccess() {
		var strCheckedAccess = "";
		var checkedAccessValues = new Array();
		$('input[name=accessBox]:checked').each( function(){
			checkedAccessValues.push($(this).val()); 
		});
		for(var i=0; i < checkedAccessValues.length; i++){
			strCheckedAccess += checkedAccessValues[i] + ",";
		}
		if(strCheckedAccess.length > 0){
			strCheckedAccess = strCheckedAccess.substring(0, strCheckedAccess.length-1);
		}
 		return strCheckedAccess;
	}
	function setCheckedRole(){
		var strCheckedRole = "";
		var checkedRoleValues = new Array();
		$('input[name=roleBox]:checked').each( function(){
			checkedRoleValues.push($(this).val()); 
		});
		for(var i=0; i < checkedRoleValues.length; i++){
			//alert(checkedAccessValues[i]);
			strCheckedRole += checkedRoleValues[i] + ",";
		}
		if(strCheckedRole.length > 0){
			strCheckedRole = strCheckedRole.substring(0, strCheckedRole.length-1);
		}
		return strCheckedRole;
	}
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
		<form id="informationForm">
	
		   <input type="hidden" id="userNo" name="userNo" >
			<div class="modal-content">
				<div class="modal-header no-padding">
					<div class="table-header" style="background: #307ecc">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							<span class="white">&times;</span>
						</button>
						分配用户权限
					</div>
				</div>
				<div class="modal-body" style="max-height: 700px; overflow-y: scroll;">
					<ul class="nav nav-tabs padding-12 tab-color-blue background-blue" id="myTab4">
						<li class="active">
							<a data-toggle="tab" href="#home4">角色组</a>
						</li>
			
						
					</ul>
					<div class="tab-content">
						<div id="home4" class="tab-pane in active">
							<div class="row">
								<div class="col-xs-12">
									<div>
										<table id="sample-table-1" class="table table-striped table-bordered table-hover" >
											<thead>
												<tr>
													<th>ID</th>
													<th>角色组名称</th>
													<th>授权</th>
												</tr>
											</thead>
											<tbody>
												
											</tbody>
										</table>
									</div>
								</div>
							</div>
							
						</div>
	
				</div>
				<div class="modal-footer no-margin-top">
					<div class="text-right">
						<a id="submitButton" type="submit" class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm btn-primary" onclick="doSubmit()">
							<i class="ace-icon fa fa-check"></i>提交
							<span class="ui-icon ui-icon-disk" style="display: none;"></span>
						</a>
						<a class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm" data-dismiss="modal" >
							<i class="ace-icon fa fa-times"></i>取消
							<span class="ui-icon ui-icon-close" style="display: none;"></span>
						</a>
					
					</div>
				</div>
			</div>
			</div><!-- /.modal-content -->
		</form>
	</div><!-- /.modal-dialog -->
</div>
<!-- page specific plugin scripts -->
<script type="text/javascript">
function checkPhone(value, colname){
	if (value.match("^\\d{11}$"))
			return [true, ""];
		else
			return [false, "电话格式不正确"]; 
	}
function checkCardNo(value, colname){
	
	if (value.match("^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$"))
			return [true, ""];
		else
			return [false, "身份证号格式不正确"];
	}

var scripts = [ null, "${contextPath}/static/assets/js/date-time/bootstrap-datepicker.js",
                "${contextPath}/static/assets/js/date-time/locales/bootstrap-datepicker.zh-CN.js",
                "${contextPath}/static/assets/js/jqGrid/jquery.jqGrid.js",
                "${contextPath}/static/assets/js/jqGrid/i18n/grid.locale-cn.js",
                "${contextPath}/static/assets/js/jquery.bootstrap-duallistbox.js",
                "${contextPath}/static/assets/js/jquery.dataTables.js",
                "${contextPath}/static/assets/js/jquery.dataTables.bootstrap.js",null ]
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
        		});
        		
				/* var hiddenCols=$.ajax({url:"${contextPath}/sys/sysuser/getColHidden",async:false});
				var hiddenColsJSON=JSON.parse(hiddenCols.responseText); */
				
        		jQuery(grid_selector).jqGrid({
        			subGrid : false,
        			url : "${contextPath}/sys/sysuser/getSysUser",
        			datatype : "json",
        			height : 450,
        			colNames : ['','', '工号', '姓名', '联系电话','性别','专业', '所属部门', '是否禁用','授权'],
        			colModel : [ {
        				name : '',
        				index : '',
        				width : 50,
        				fixed : true,
        				sortable : false,
        				resize : false,
        				formatter : 'actions',
        				formatoptions : {
        					keys : false,
        					delbutton : false,//disable delete button
        					delOptions : {
        						recreateForm : false,
        						beforeShowForm : beforeDeleteCallback,
        						errorTextFormat: function (response) {
        		  					var result = eval('('+response.responseText+')');
        		  				    return result.message;
        		  				}
        					}
        					//editformbutton:true, editOptions:{recreateForm:true, beforeShowForm:beforeEditCallback}
        				}
        			}, {
        				name : 'id',
        				index : 'id',
        				label : 'id',
        				width : 10,
        				editable : false,
        				//hidden:(hiddenColsJSON.id=='true'),
        				editoptions : {},
        				searchoptions : {sopt : ['cn']},
        				editrules : {edithidden:true,},
        				formoptions:{rowpos:1,colpos:1}
        			}, {
        				name : 'emp_no',
        				index : 'emp_no',
        				label : '工号',
        				width : 100,
        				key:true,
        				editable : false,
        				//hidden:(hiddenColsJSON.workNo=='true'),
        				editoptions : {size : "20", maxlength : "50"},
        				searchoptions : {sopt : ['cn']},
        				editrules : {required : true},
        				formoptions:{rowpos:1,colpos:1}
        			},{
        				name : 'emp_name',
        				index : 'emp_name',
        				label : '姓名',
        				width : 100,
        				editable : false,
        				//hidden:(hiddenColsJSON.userName=='true'),
        				editoptions : {size : "20", maxlength : "50"},
        				searchoptions : {sopt : ['cn']},
        				editrules : {required : true},
        				formoptions:{rowpos:1,colpos:2}
        			}, {
        				name : 'f_cell',
        				index : 'f_cell',
        				label : '联系电话',
        				width : 110,
        				editable : false,
        				//hidden:(hiddenColsJSON.phone=='true'),
        				searchoptions : {
							sopt : [ 'cn' ]
						},
        				editoptions : {size : "20", maxlength : "11"},
        				editrules :{
							required : true,
							number:true,
							custom:true,
							custom_func:checkPhone,
						},
        				formoptions:{rowpos:2,colpos:1}
        			}, {
        				name : 'f_gender',
        				index : 'f_gender',
        				label : '性别',
        				width : 80,
        				editable : true,
        				//hidden:(hiddenColsJSON.sex=='true'),
        				edittype : "select",
        				editoptions : {value : "1:男;2:女"},
                        formatter : 'select',
        				search : false,
        				formoptions:{rowpos:3,colpos:1}
        			},{
		                name : 'sysOrgStru.id',
		                index : 'sysOrgStru.id',
		                label : '专业ID',
		                width : 1,
		                editable : true             
		            },{
        				name : 'dept_no',
        				index : 'dept_no',
        				label : '所属专业',
        				width : 120,
        				editable : true,
        				//hidden:(hiddenColsJSON.orgNo=='true'),
                		searchoptions : {
                                sopt : [ 'cn' ]
                      	},
        				editrules :{
        					readonly : true,
							required : true
						},
        				editoptions : {
                            dataEvents: [{
                                   type: 'click',          //下拉选择的时候
                             fn: function(e) {
                            	 $("#menuContent").remove();
                                   var sid = this.id;
                                   var s= document.getElementById(sid);
                                   var par=s.parentNode;
                                   var ul_file = document.createElement("ul" );
                                   ul_file.setAttribute("class" ,"ztree" );
                                   var ztreeViewID=sid.replace(".","_");
                                   ul_file.setAttribute("id" ,ztreeViewID+"ztree" );
                                   ul_file.setAttribute("style" ,"position:absolute;z-index: 100; width: 180px; height: 200px; overflow: auto;");
                                   var div_file = document.createElement("div" );
                                   div_file.setAttribute("class" ,"menuContent" );
                                   div_file.setAttribute("id" ,"menuContent" );
                                   div_file.appendChild(ul_file);
                                   par.appendChild(div_file);
                                   function beforeClicks(treeId, treeNode) {
                                          var check = treeNode;
                                          return true;
                                   }
                                   function hideMenu() {
                                	   $("#menuContent").remove();
                                	   /* 
                               		$("#menuContent").fadeOut("fast");
                               		$("body").unbind("mousedown", onBodyDown); */
                               	}
                                   function onBodyDown(event) {
                               		if (!(event.target.id == "menuBtn"
                               				|| event.target.id == sid
                               				|| event.target.id == "menuContent" || $(event.target).parents(
                               				"#menuContent").length > 0)) {
                               			hideMenu();
                               		}
                                   }
                                   function onClick(e, treeId, treeNode) {
                                                  var zTree = $.fn.zTree.getZTreeObj(ztreeViewID+"ztree" ),
                                                  nodes = zTree.getSelectedNodes(),
                                                  v = "";n="";
                                                 nodes.sort( function compare(a, b) {
                                                        return a.id - b.id;
                                                 });
                                                  for (var i = 0, l = nodes.length; i < l; i++) {
                                                       v += nodes[i].name + "," ;
                                                       n += nodes[i].id + "," ;
                                                 }
                                                  if (v.length > 0)
                                                       v = v.substring(0, v.length - 1);
                                                  if (n.length > 0)
                                                      n = n.substring(0, n.length - 1);
                                                 // var cityObj = $("#"+sid);
                                                 $("input[name='sysOrgStru.orgName']").val(v);
                                                 $("input[name='sysOrgStru.id']").val(n);
                                                 hideMenu();
                                          }
                                   var setting = {
                                              
                                                data : {
                                                       simpleData : {
                                                              enable : true
                                                       }
                                                },
                                                callback : {
                                                       beforeClick : beforeClicks,
                                                       onClick : onClick
                                                }
                                          };
                                   $.ajax({
                                          url : "${contextPath}/sys/sysorgstru/getSysOrgStruTree" ,
                                          success : function(data) {
                                                 //json转化树
                                                 $.fn.zTree.init($( "#"+ztreeViewID+"ztree" ), setting, eval(data));
                                          }
                                   });
                                   
                           }
                     }]},
        				formoptions:{rowpos:4,colpos:1}
        			}, {
        				name : 'status',
        				index : 'status',
        				label : '是否禁用',
        				width : 80,
        				sortable : false,
        				editable : true,
        				edittype : "select",
        				editoptions : {value : "false:否;true:是"},
                        formatter : 'select',
        				search : false,
        				formoptions:{rowpos:5,colpos:1}
        			}, {
        				name : 'rolno',
        				index : 'rolno',
        				label : '授权',
        				width : 60,
        				editable : false,
        				search : false,
        				sortable : false
        			}],
        			sortname : "EMP_NO",
        			sortorder : "desc",
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
        			editurl : "${contextPath}/sys/sysuser/operateSysUser",
       				gridComplete:function(){ //在此事件中循环为每一行添加修改和删除链接 
       					var ids=jQuery(grid_selector).jqGrid('getDataIDs'); 
       					for(var i=0; i<ids.length; i++){
	       					var id=ids[i]; 
	       					var rowData = $(grid_selector).jqGrid('getRowData',id);
	       					var rolno = rowData.emp_no;
	       					modify ="<a href='#' style='color:#6A5ACD' onclick='Formatter(\""+rolno+"\")' class='btn btn-xs btn-warning'><i class='ace-icon fa fa-flag bigger-120'></i></a>"; //这里的onclick就是调用了上面的javascript函数 Modify(id) 
	       					jQuery(grid_selector).jqGrid('setRowData', ids[i], { rolno: modify}); 
       					} 
      				}
        		});
        		
        		$(window).triggerHandler('resize.jqGrid');// trigger window resize to make the grid get the correct size
        		
        		// switch element when editing inline
        		 function aceSwitch(cellvalue, options, cell) {
        			setTimeout(function() {
        				$(cell).find('input[type=checkbox]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
        			}, 0);
        		} 
        		//点击全选按钮，所有checkbox都被选中，有点问题，不管用，暂时去掉。
        		$(document).on('click', 'th input:checkbox' , function(){
					var that = this;
					$(this).closest('sample-table-2').find('tr > td:first-child input:checkbox')
					.each(function(){
						this.checked = that.checked;
						$(this).closest('tr').toggleClass('selected');
					});
				}); 
        		
        		//
        		
        		$("#modal-table").on("hidden.bs.modal", function() {
        			//location.href = location.href;
				});
        		$('.page-content-area').ace_ajax('loadScripts', scripts, function() {
       			  //inline scripts related to this page
       				  jQuery(function($){
	       			    var demo1 = $('select[name="duallistbox_demo1[]"]').bootstrapDualListbox({
	       			    	nonSelectedListLabel: '未授权',
		       			 	selectedListLabel: '已授权',
		       				moveOnSelect: false,
		       				showFilterInputs:false
	       			    }); 
	       			 	demo1.append('<option value="apples">Apples</option><option value="oranges" selected>Oranges</option>');
	       			 	demo1.bootstrapDualListbox('refresh');
	       				
       				})
       			 })
       			 $("#informationForm").submit(function() {
		              //alert($('[name="duallistbox_demo1[]"]').val());
		              return false;
		         });
        		
        		
        		// enable datepicker
        		function pickDate(cellvalue, options, cell) {
        			setTimeout(function() {
        				$(cell).find('input[type=text]').datepicker({
        					format : 'yyyy-mm-dd',
        					endDate:'+1',//结束时间，在这时间之后都不可选
        					autoclose : true
        				});
        			}, 0);
        		}
        		
        		// navButtons
        		jQuery(grid_selector).jqGrid('navGrid', pager_selector, { // navbar options
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
        		}, {
        			// edit record form
        			closeAfterEdit: true,
        			width: 600,
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
        			width: 600,
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
        				// alert(1);
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
        		// add custom button to export the data to excel
				jQuery(grid_selector).jqGrid('navButtonAdd', pager_selector,{
    	   			caption:"",
    	   			title : "用户同步",
    	   			buttonicon:"ace-icon fa fa-exchange purple",   
    	   			onClickButton: function(){
    	   				//加载层
				    	layer.load(2);
    	   				$.ajax({
    	   					cache : true,
    	   					type : "POST",
    	   					url : "${contextPath}/sys/sysuser/tuser",
    	   					success : function(data) {
    	   						var x_steps = eval('(' +data+')');
    	   						if(x_steps.message=="0"){
				    				layer.msg('用户同步失败！请检查网络', {icon: 2});
    	   							layer.closeAll('loading');
    	   						}else{
				    				layer.msg('用户同步成功！', {icon: 1});
    	   							layer.closeAll('loading');
    	   						}
    	   					},
    	   					error : function(){
			    				layer.msg('用户同步失败！请检查网络', {icon: 2});
    	   						layer.closeAll('loading');
    	   					}
    	   				});
    	   			},
    	   			position:"first"
    			});
        		// add custom button to export the data to excel
				jQuery(grid_selector).jqGrid('navButtonAdd', pager_selector,{
				   caption : "",
			       title : "导出Excel",
			       buttonicon : "ace-icon fa fa-file-excel-o green", 
			       onClickButton : function () {
			    	   var keys = [], ii = 0, rows = "";
			    	   var ids = $(grid_selector).getDataIDs(); // Get All IDs
			    	   var row = $(grid_selector).getRowData(ids[0]); // Get First row to get the labels
			    	   var label = $(grid_selector).jqGrid('getGridParam','colNames');
			    	   for (var k in row) {
			    	   	   keys[ii++] = k; // capture col names
			    	   	   rows = rows + k + "\t"; // output each Column as tab delimited
			    	   }
			    	   rows = rows + "\n"; // Output header with end of line
			    	   for (i = 0; i < ids.length; i++) {
			    	   	   row = $(grid_selector).getRowData(ids[i]); // get each row
			    	   	   for (j = 0; j < keys.length; j++)
			    	   		if(j==keys.length-1){
		    	   		   		rows = rows + "\t"; // output each Row as tab delimited
		    	   		   }else{
		    	   				rows = rows + row[keys[j]] + "\t"; // output each Row as tab delimited
		    	   		   }
			    	   	   rows = rows + "\n"; // output each row with end of line
			    	   }
			    	   rows = rows + "\n"; // end of line at the end
			    	   var form = "<form name='csvexportform' action='${contextPath}/sys/sysuser/operateSysUser?oper=excel' method='post'>";
			    	   form = form + "<input type='hidden' name='csvBuffer' value='" + encodeURI(encodeURI(rows)) + "'>";
			    	   form = form + "</form><script>document.csvexportform.submit();</sc" + "ript>";
			    	   OpenWindow = window.open('', '');
			    	   OpenWindow.document.write(form);
			    	   OpenWindow.document.close();
			       } 
				});
        		
        		function style_edit_form(form) {
        			// enable datepicker on "birthday" field and switches for "stock" field
        			form.find('input[name=birthday]').datepicker({
        				format : 'yyyy-mm-dd',
        				autoclose : true,
        			    language: 'zh-CN'
        			})


      			form.find('input[name=statusCn]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
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
      		jQuery(grid_selector).jqGrid( 'hideCol', "birthday");
      		jQuery(grid_selector).jqGrid( 'hideCol', "id");
      		jQuery(grid_selector).jqGrid( 'hideCol', "orgNo");
          jQuery(grid_selector).jqGrid( 'hideCol', "sysOrgStru.id");
      		//jQuery(grid_selector).jqGrid( 'hideCol', "workGroupCn");
    		$(document).one('ajaxloadstart.page', function(e) {
    			$(grid_selector).jqGrid('GridUnload');
    			$('.ui-jqdialog').remove();
    		});
      	});
      });
</script>
