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
	href="${contextPath}/static/assets/css/bootstrap-duallistbox.css" />
<link rel="stylesheet"
	href="${contextPath}/static/assets/css/bootstrap-multiselect.css" />
<link rel="stylesheet"
	href="${contextPath}/static/assets/css/select2.css" />
<script src="${contextPath}/static/json/json2.js"></script>
<div class="row">
	<input type="hidden" id="typeid" name="typeid" value="" /> 
	<div class="col-xs-12">
	<div class="row" id="row">
		<div class="col-sm-2">
				<div class="widget-box">
					<div class="widget-header widget-header-flat">
						<h4 class="widget-title smaller">
							菜单管理
						</h4>
					</div>
					<!-- search -->
					<div class="row">
						<div class="col-xs-12 col-sm-12">
							<div class="input-group">
								<input type="text" id="text_" class="form-control search-query" placeholder="请输入搜索条件" />
								<span class="input-group-btn">
									<button type="button" class="btn btn-purple btn-sm" onclick="search_ztree('treeDemo', 'text_')">
											查询
									<i class="icon-search icon-on-right bigger-110"></i>
									</button>
								</span>
							</div>
						</div>
					</div>
					<div class="widget-body" style="height: 465px; overflow: auto;" >
						<div class="widget-main">
							<div class="ace" align="left" >
								<!--  <label>
									<input id="checkbox" name="checkbox" type="checkbox" class="" value = "111" onclick="dianji()" >
									显示名称
									</input>
								</label>
								-->
								</label>
							</div>
							<!-- ztree开始 -->
							<div class="content_wrap">
								<input type="hidden" id="oper">
								<input type="hidden" id="clickId">
								<input type="hidden" id="clickNode">
								<input type="hidden" id="nameStr" name="nameStr" value="haveName" />
								<div class="zTreeDemoBackground left">
									<ul id="treeDemo" class="ztree"></ul>
								</div>
							</div>
							<div class="col-xs-6.col-sm-2" id="execlD" >
								<input type="file" id="Dexecl" class="" style="display:none"/>
							</div>
						</div>
					</div>
				</div>
			</div>
            <div position="center">
            <div class="col-sm-10">
				<div class="row">
					<div class="col-xs-12">
					<div class="widget-body">
							<table id="grid-table"></table>
							<div id="grid-pager"></div>
							<div id="consoleDlg"></div>
							<script type="text/javascript">
										var $path_base = "${contextPath}/static";//in Ace demo this will be used for editurl parameter
							</script>
						</div>
						
					</div>
				</div>
			</div>
            </div>
			

			
		</div>
		<table id="grid-table"></table>

		<div id="grid-pager"></div>

		<script type="text/javascript">
			var $path_base = "${contextPath}/static";//in Ace demo this will be used for editurl parameter
		</script>

		<!-- PAGE CONTENT ENDS -->
	</div><!-- /.col -->
</div><!-- /.row -->
<SCRIPT type="text/javascript">
	function Formatter(cellvalue) {
		//var url="${contextPath}/sys/sysmenu/getSysMenuTreeList/"+cellvalue;
		$("#modal-table").modal("toggle");
		$("#rolNoId").val(" + cell.rolNo +");
		/* $.ajax({
		url: url,  
		success: function(data){
			//$("#modal-table").modal("toggle");$("#rolNoId").val(" + cell.rolNo +");
			//$.fn.zTree.init($("#treeDemo"), setting, eval(data));
			//$("#selectAll").bind("click", selectAll);
		  }
		}); */
		//授权
		//访问组jqGrid样式
		var oTable1 = $('#sample-table-2')
				.dataTable(
						{
							//"bProcessing" : true, //DataTables载入数据时，是否显示‘进度’提示  
							"bServerSide" : true, //是否启动服务器端数据导入
							"sAjaxSource" : "${contextPath}/sys/userroleaccess/getAccessNameList?userId=1",
							"fnServerData" : retrieveData,
							//"bStateSave" : true, //是否打开客户端状态记录功能,此功能在ajax刷新纪录的时候不会将个性化设定回复为初始化状态  
							//"bScrollCollapse" : true,
							//"bLengthChange" : false, //改变每页显示数据数量
							"bAutoWidth" : false,
							"bPaginate" : false,
							"bSort" : false, //排序功能
							"bInfo" : false,
							"bFilter" : false,
							//"sPaginationType": "full_numbers",
							//"sSource":"${contextPath}/sys/userroleaccess/getAccessNameList",
							/*"fnServerData": function ( sSource, aoData, fnCallback ) {
								alert("1213");
							    $.ajax( {
							        "dataType": 'json',
							        "type": "POST",
							        "url": sSource,
							        "data": aoData,
							        "success": fnCallback
							    } );
							}, 
							"Columns": [
							  { "data": "accName", "bSortable": false }
							  , { "bSortable": false }
							]*/
							"aoColumns" : [ {
								'aaData' : 'id'
							}, {
								'aaData' : 'accName'
							} ]
						//"aaSorting": [],

						//,
						//"sScrollY": "200px",
						//"bPaginate": false,

						//"sScrollX": "100%",
						//"sScrollXInner": "120%",
						//"bScrollCollapse": true,
						//Note: if you are applying horizontal scrolling (sScrollX) on a ".table-bordered"
						//you may want to wrap the table inside a "div.dataTables_borderWrap" element

						//"iDisplayLength": 50
						});
		//函数的参数是固定，不能更改。  
		function retrieveData(sSource, aoData, fnCallback) {
			//查询条件称加入参数数组     
			$.ajax({
				type : "POST",
				//contentType: "application/json",   //这段代码不要加，我时延的是否后台会接受不到数据  
				url : sSource,
				//"${contextPath}/sys/userroleaccess/getAccessNameList",   
				dataType : "json",
				data : aoData,
				success : function(data) {
					//$('#sample-table-2').datagrid({data:msg}).datagrid('clientPaging');
					if (msg != null) {
						alert(data);
					}
					$("#sample-table-2").val(data);
					//	$('#sample-table-2').dataTable().fnDestroy();
					//	fnCallback(msg);//服务器端返回的对象的returnObject部分是要求的格式      */
				}
			});
			//$('#sample-table-2').dataTable().fnDestroy();
		}
		/*
		var tableTools = new $.fn.dataTable.TableTools( oTable1, {
		"sSwfPath": "../../copy_csv_xls_pdf.swf",
		   "buttons": [
		       "copy",
		       "csv",
		       "xls",
			"pdf",
		       "print"
		   ]
		} );
		$( tableTools.fnContainer() ).insertBefore('#sample-table-2');
		 */

		//oTable1.fnAdjustColumnSizing();

		$(document).on(
				'click',
				'th input:checkbox',
				function() {
					var that = this;
					$(this).closest('table').find(
							'tr > td:first-child input:checkbox').each(
							function() {
								this.checked = that.checked;
								$(this).closest('tr').toggleClass('selected');
							});
				});
	}
</SCRIPT>
<!-- <div class="row">
	<div class="col-xs-12">
		<table id="grid-table"></table>

		<div id="grid-pager"></div>

		<script type="text/javascript">
			var $path_base = "${contextPath}/static";//in Ace demo this will be used for editurl parameter
		</script>

		PAGE CONTENT ENDS
	</div>
	/.col
</div>
/.row -->

<!-- page specific plugin scripts -->
<script type="text/javascript">
	var str="";
	var scripts = [
			null,
			"${contextPath}/static/assets/js/date-time/bootstrap-datepicker.js",
			"${contextPath}/static/assets/js/date-time/locales/bootstrap-datepicker.zh-CN.js",
			"${contextPath}/static/assets/js/jqGrid/jquery.jqGrid.js",
			"${contextPath}/static/assets/js/jqGrid/i18n/grid.locale-cn.js",
			"${contextPath}/static/assets/js/jquery.bootstrap-duallistbox.js",
			"${contextPath}/static/assets/js/jquery.dataTables.js",
			"${contextPath}/static/assets/js/jquery.dataTables.bootstrap.js",
			null ]
	var setting = {
			view: {
//				addHoverDom: addHoverDom,
//				removeHoverDom: removeHoverDom,
//				selectedMulti: false
				fontCss:setFontCss_ztree,
			},
			edit: {
//				enable: true,
//				editNameSelectAll: true,
//				showRemoveBtn: showRemoveBtn,
//				showRenameBtn: showRenameBtn
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onClick: zTreeOnClick,
				//beforeDrag: beforeDrag,
				//beforeEditName: beforeEditName,
				//beforeRemove: beforeRemove,
				//beforeRename: beforeRename,
				//onRemove: onRemove,
				//onRename: onRename,
				beforeClick:beforeClick
			}
		};

	//单击时获取zTree节点的Id,和value的值
	
    function zTreeOnClick(event, treeId, treeNode, clickFlag) {
        var treeValue = treeNode.id + "," + treeNode.name;
        
		
        //alert(treeNode.id + "," + treeNode);
    };
	var log, className = "dark";
	var clickName;
	function beforeClick(treeId, treeNode, clickFlag) {
		 $("#clickId").val(treeNode.id);
		 $("#clickNode").val(treeNode);
		 clickName = treeNode.name;
		 $('.page-content-area').ace_ajax('loadScripts', scripts, function() {
			 //trigger("#grid-table");
			 $("#grid-table").jqGrid('setGridParam', {               
				 url : "${contextPath}/sys/sysmenu/getSysMenu/"+treeNode.id,
	    		datatype : "json",
	            }).trigger("reloadGrid");
		    });
		className = (className === "dark" ? "":"dark");
		showLog("[ "+getTime()+" beforeClick ]&nbsp;&nbsp;" + treeNode.name );
		return (treeNode.click != false);
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
	function trim(str) {
		str = str.replace(/^(\s|\u00A0)+/, '');
		for (var i = str.length - 1; i >= 0; i--) {
			if (/\S/.test(str.charAt(i))) {
				str = str.substring(0, i + 1);
				break;
			}
		}
		return str;
	}
	////////////////////////////////查询与刷新
			/**
		     * 搜索树，高亮显示并展示【模糊匹配搜索条件的节点s】
		     * @param treeId
		     * @param searchConditionId 文本框的id
		     */
	function search_ztree(treeId, searchConditionId){
    	var value = $('#' + searchConditionId).val();
		if(trim(value)!=""){
			$("#grid-table").jqGrid('setGridParam', {               
		    	//url : "${contextPath}/sys/sysPositionM/fund/"+value,
		    	url : "${contextPath}/sys/sysmenu/fund?value=" + value+"&nameStr="+$("#nameStr").val(),
	   			datatype : "json",
           }).trigger("reloadGrid");
		}
       searchByFlag_ztree(treeId, searchConditionId, "");
    }
			
		    /**
		     * 搜索树，高亮显示并展示【模糊匹配搜索条件的节点s】
		     * @param treeId
		     * @param searchConditionId     搜索条件Id
		     * @param flag                  需要高亮显示的节点标识
		     */
		    function searchByFlag_ztree(treeId, searchConditionId, flag){
		        //<1>.搜索条件
		        var searchCondition = trim($('#' + searchConditionId).val());
		        //<2>.得到模糊匹配搜索条件的节点数组集合
		        var highlightNodes = new Array();
		        if (searchCondition != "") {
		            var treeObj = $.fn.zTree.getZTreeObj(treeId);
		            var node = treeObj.getNodeByParam("id", "home", null);
		            highlightNodes = treeObj.getNodesByParamFuzzy("name", searchCondition, node);
		            
		        }else{
		        	$("#grid-table").clearGridData();
		        }
		        //<3>.高亮显示并展示【指定节点s】
		        highlightAndExpand_ztree(treeId, highlightNodes, flag);
		    }
		    
		    /**
		     * 高亮显示并展示【指定节点s】
		     * @param treeId
		     * @param highlightNodes 需要高亮显示的节点数组
		     * @param flag           需要高亮显示的节点标识
		     */
		    function highlightAndExpand_ztree(treeId, highlightNodes, flag){
		        var treeObj = $.fn.zTree.getZTreeObj(treeId);
		        //<1>. 先把全部节点更新为普通样式
		        var treeNodes = treeObj.transformToArray(treeObj.getNodes());
		        for (var i = 0; i < treeNodes.length; i++) {
		            treeNodes[i].highlight = false;
		            treeObj.updateNode(treeNodes[i]);
		        }
		        //<2>.收起树, 只展开根节点下的一级节点
		        close_ztree(treeId);
		        //<3>.把指定节点的样式更新为高亮显示，并展开
		        if (highlightNodes != null) {
		            for (var i = 0; i < highlightNodes.length; i++) {
		                if (flag != null && flag != "") {
		                    if (highlightNodes[i].flag == flag) {
		                        //高亮显示节点，并展开
		                        highlightNodes[i].highlight = true;
		                        treeObj.updateNode(highlightNodes[i]);
		                        //高亮显示节点的父节点的父节点....直到根节点，并展示
		                        var parentNode = highlightNodes[i].getParentNode();
		                        var parentNodes = getParentNodes_ztree(treeId, parentNode);
		                        treeObj.expandNode(parentNodes, true, false, true);
		                        treeObj.expandNode(parentNode, true, false, true);
		                    }
		                } else {
		                    //高亮显示节点，并展开
		                    highlightNodes[i].highlight = true;
		                    treeObj.updateNode(highlightNodes[i]);
		                    //高亮显示节点的父节点的父节点....直到根节点，并展示
		                    var parentNode = highlightNodes[i].getParentNode();
		                    var parentNodes = getParentNodes_ztree(treeId, parentNode);
		                    treeObj.expandNode(parentNodes, true, false, true);
		                    treeObj.expandNode(parentNode, true, false, true);
		                }
		            }
		        }
		    }
		     
			/**
		     * 展开树
		     * @param treeId  
		     */
		    function expand_ztree(treeId){
		        var treeObj = $.fn.zTree.getZTreeObj(treeId);
		        treeObj.expandAll(true);
		    }
		     
		    /**
		     * 收起树：只展开根节点下的一级节点
		     * @param treeId
		     */
		    function close_ztree(treeId){
		        var treeObj = $.fn.zTree.getZTreeObj(treeId);
		        var nodes = treeObj.transformToArray(treeObj.getNodes());
		        var nodeLength = nodes.length;
		        for (var i = 0; i < nodeLength; i++) {
		            if (nodes[i].id == '0') {
		                //根节点：展开
		                treeObj.expandNode(nodes[i], true, true, false);
		                
		            } else {
		                //非根节点：收起
		                treeObj.expandNode(nodes[i], false, true, false);
		            }
		        }
		    }
		    /**
		     * 递归得到指定节点的父节点的父节点....直到根节点
		     */
		    function getParentNodes_ztree(treeId, node){
		        if (node != null) {
		            var treeObj = $.fn.zTree.getZTreeObj(treeId);
		            var parentNode = node.getParentNode();
		            return getParentNodes_ztree(treeId, parentNode);
		        } else {
		            return node;
		        }
		    }
		     
		    /**
		     * 设置树节点字体样式
		     */
		    function setFontCss_ztree(treeId, treeNode) {
		        if (treeNode.id == 0) {
		            //根节点
		            return {color:"#333", "font-weight":"bold"};
		        } else if (treeNode.isParent == false){
		            //叶子节点
		            return (!!treeNode.highlight) ? {color:"#ff0000", "font-weight":"bold"} : {color:"#0099", "font-weight":"normal"};
		        } else {
		            //父节点
		            return (!!treeNode.highlight) ? {color:"#ff0000", "font-weight":"bold"} : {color:"#333", "font-weight":"normal"};
		        }
		    }
					
				
		function shuaxin(treeId){
			var treeObj = $.fn.zTree.getZTreeObj(treeId);
	        var treeNodes = treeObj.transformToArray(treeObj.getNodes());
	        for (var i = 0; i < treeNodes.length; i++) {
	            treeNodes[i].highlight = false;
	            treeObj.updateNode(treeNodes[i]);
	        }
			
		};
		
		
			
		function init_zTree(){
					//if(str == 111){
						var url="${contextPath}/sys/sysmenu/getSysMenuTree1";
					// }else{
					//	var url="${contextPath}/sys/sysmenu/getSysMenuTree";
					//}
					$.ajax({
			  		url: url,  
			  		success: function(data){
			  			//json转化树
			  			$.fn.zTree.init($("#treeDemo"), setting, eval(data));
			  			$("#selectAll").bind("click", selectAll);
			          }
			      });  
				
			}
			//初始化zTree
			$(document).ready(init_zTree());
	//获取复选框的值 
	function dianji(){
		 str="";
		 $("input[name=checkbox]:checked").each(function(){
	         str+=$(this).val();
			
	     });
		  if(document.getElementById("checkbox").checked==true){
			 $("#nameStr").val("haveName");
		 } else {
			 $("#nameStr").val("noHaveName");
		 } 
	    init_zTree();
	}
	$('.page-content-area')
			.ace_ajax(
					'loadScripts',
					scripts,
					function() {
						// inline scripts related to this page
						jQuery(function($) {
							var grid_selector = "#grid-table";
							var pager_selector = "#grid-pager";

							// resize to fit page size
							$(window).on(
									'resize.jqGrid',
									function() {
										$(grid_selector).jqGrid('setGridWidth',
												$(".col-sm-10").width());
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
											
											
											$.extend($.fn.fmatter, {
										        actionFormatter: function(cellvalue, options, rowObject) {
										            var retVal = "eidt("+cellvalue.id+")";
										            return retVal;
										        }
										    } );
											//$("#Dexecl").attr({"disabled":true});
											/* var scripts = [ null, "${contextPath}/static/assets/js/prettify.js", null ] */
											$('.page-content-area').ace_ajax('loadScripts', scripts, function() {
												//inline scripts related to this page
												jQuery(function($) {
													window.prettyPrint && prettyPrint();
													$('#id-check-horizontal').removeAttr('checked').on('click', function() {
														$('#dt-list-1').toggleClass('dl-horizontal').prev().html(this.checked ? '&lt;dl class="dl-horizontal"&gt;' : '&lt;dl&gt;');
													});

												})
											});
											
											

							/* var hiddenCols = $
									.ajax({
										url : "${contextPath}/sys/sysmenu/getColHidden",
										async : false
									});
							var hiddenColsJSON = JSON
									.parse(hiddenCols.responseText); */
							jQuery(grid_selector)
									.jqGrid(
											{
												subGrid : false,
												url : "${contextPath}/sys/sysmenu/getSysMenu/null",
												datatype : "json",
												height : 450,
												colNames : [ '', '菜单编码',
														'菜单名称', '菜单class属性值',
														'菜单url属性值', '排序',
														'上级菜单编码', '打开方式', '描述' ],
												colModel : [
														{
															name : 'id',
															index : 'id',
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
															name : 'menuNo',
															index : 'menuNo',
															label : '菜单编码',
															width : 130,
															editable : true,
															//hidden : (hiddenColsJSON.menuNo == 'true'),
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
															name : 'menuName',
															index : 'menuName',
															label : '菜单名称',
															width : 140,
															editable : true,
															//hidden : (hiddenColsJSON.menuName == 'true'),
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
															name : 'menuClass',
															index : 'menuClass',
															label : '菜单class属性值',
															width : 180,
															editable : true,
															//hidden : (hiddenColsJSON.menuClass == 'true'),
															editoptions : {
																size : "20",
																maxlength : "50"
															},
															editrules : {
																required : true
															},
															search : false
														},
														{
															name : 'menuAddress',
															index : 'menuAddress',
															label : '菜单data-url属性值',
															width : 130,
															editable : true,
															//hidden : (hiddenColsJSON.menuAddress == 'true'),
															editoptions : {
																size : "20",
																maxlength : "100"
															},
															editrules : {
																required : true
															},
															search : false
														},
														{
															name : 'menuOrder',
															index : 'menuOrder',
															label : '排序',
															width : 100,
															align:"right",
															editable : true,
															//hidden : (hiddenColsJSON.menuOrder == 'true'),
															sorttype : "long",
															search : false,
															editrules : {
																number : true
															}
														},
														{
															name : 'modNo',
															index : 'modNo',
															label : '上级菜单编码',
															width : 100,
															editable : true,
															//hidden : (hiddenColsJSON.modNo == 'true'),
															editoptions : {
																size : "20",
																maxlength : "50",
																title : "如果没有上级，不填即可"
															},
															search : false
														},
														{
															name : 'herfTarget',
															index : 'herfTarget',
															label:'打开方式',
															width : 90,
															editable : true,
															edittype : "select",
															editoptions : {
																value : ":默认;_blank:新窗口"
															}
														},
														{
															name : 'remark',
															index : 'remark',
															label : '描述',
															width : 110,
															editable : true,
															//hidden : (hiddenColsJSON.remark == 'true'),
															editoptions : {
																size : "20",
																maxlength : "120"
															},
															edittype : "textarea",
															//editoptions : {size : "20", maxlength : "50", title : "如果没有上级，不填即可"},
															search : false
														} ],
												//scroll : 1, // set the scroll property to 1 to enable paging with scrollbar - virtual loading of records
												sortname : "menuOrder",
												sortorder : "asc",
												viewrecords : true,
												rowNum : 10,
							        			rowList : [ 10, 15, 20 ],
												pager : pager_selector,
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
												editurl : "${contextPath}/sys/sysmenu/operateSysMenu"
											//caption : "用户管理列表",
											//autowidth : true,
											/**
											grouping : true, 
											groupingView : { 
												 groupField : ['name'],
												 groupDataSorted : true,
												 plusicon : 'fa fa-chevron-down bigger-110',
												 minusicon : 'fa fa-chevron-up bigger-110'
											},
											 */
											});

							$(window).triggerHandler('resize.jqGrid');// trigger window resize to make the grid get the correct size

							// enable search/filter toolbar
							// jQuery(grid_selector).jqGrid('filterToolbar',{defaultSearch:true,stringResult:true})
							// jQuery(grid_selector).filterToolbar({});
							// switch element when editing inline
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

							// navButtons
							jQuery(grid_selector)
									.jqGrid(
											'navGrid',
											pager_selector,
											{ // navbar options
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
											},
											{
												// edit record form
												// closeAfterEdit: true,
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
												onClick : function(e) {
													// alert(1);
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
													var form = "<form name='csvexportform' action='${contextPath}/sys/sysmenu/operateSysMenu?oper=excel' method='post'>";
													form = form
															+ "<input type='hidden' name='csvBuffer' value='" + rows + "'>";
													form = form
															+ "</form><script>document.csvexportform.submit();</sc" + "ript>";
													OpenWindow = window.open(
															'', '');
													OpenWindow.document
															.write(form);
													OpenWindow.document.close();
												}
											});

							function style_edit_form(form) {
								// form.find('input[name=statusCn]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
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

							$(document).one('ajaxloadstart.page', function(e) {
								$(grid_selector).jqGrid('GridUnload');
								$('.ui-jqdialog').remove();
							});

						});
					});
	$(document)
			.ready(
					function() {
						//$("#FrmGrid_grid-table").validate(); 
						$("#FrmGrid_grid-table").validate({
							rules : {
								menuNo : {
									required : true
								},
							//			Countries: { validateCountries:true } 
							},
							messages : {
								menuNo : {
									required : "menuNo is required"
								},
							//LastName: { required: "Last Name is required" }, 
							//Countries: { validateCountries:"Please select at least 2 items from the Countries" } 
							},

						});
						// add the validate countries method 
						jQuery.validator
								.addMethod(
										"validateCountries",
										function(value, element) {
											var noOfSelectedCountries = $("#Countries :selected").length;
											if (noOfSelectedCountries < 2)
												return false;
											return true;
										});
					});
</script>
