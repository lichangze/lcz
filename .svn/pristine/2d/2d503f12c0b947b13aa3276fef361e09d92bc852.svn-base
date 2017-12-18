<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="${contextPath}/static/assets/css/jquery-ui.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/ui.jqgrid.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/prettify.css" />
<!-- search 2 ge -->
<link rel="stylesheet" href="${contextPath}/static/assets/css/bootstrap.min.css"  />
<!-- ajax layout which only needs content area -->

<div class="row" >
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
		<div class="row" id="row">
		<div class="col-sm-2">
				<div class="widget-box">
					<div class="widget-header widget-header-flat">
						<h4 class="widget-title smaller">
							线路&车站
						</h4>
					</div>
					<!-- search -->
					<input type="hidden" id="typeid" name="typeid" value="" /> 
					<input type="hidden" id="poName" name="poName" value="11" /> 
					<input type="hidden" id="poType" name="poType" value="" /> 
					<input type="hidden" id="nearbystation" name="nearbystation" value="" /> 
					<input type="hidden" id="nameStr" name="nameStr" value="noHaveName" />
					<input type="hidden" id="fid" name="fid" value="all" />
					<input type="hidden" id="positionType" name="positionType"/>
					<input type="hidden" id="rowID" name="rowID"/>
					<div class="row">
						<div class="col-xs-12 col-sm-12">
							<div class="input-group">
								<input type="text" id="text_" class="form-control search-query" placeholder="请输入搜索条件" />
								<span class="input-group-btn">
									<button type="button" tabindex="-1"class="btn btn-purple btn-sm" onclick="search_ztree('treeDemo', 'text_')">
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
							</div>
							<!-- ztree开始 -->
							<div class="content_wrap">
								<div class="zTreeDemoBackground left">
									<ul id="treeDemo" class="ztree"></ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
            <div position="center">
            <div class="col-sm-8">
				<table id="grid-table"></table>
				<div id="grid-pager"></div>
				<script type="text/javascript">
					var $path_base = "${contextPath}/static";//in Ace demo this will be used for editurl parameter
				</script>
			</div>
            </div>
		</div>

		<!-- PAGE CONTENT ENDS -->
	</div>
	<!-- /.col -->
</div>
<!-- /.row -->
<div id="modal-table" class="modal fade" tabindex="-1" data-backdrop="static">
	
	<!-- 删除弹出框 -->
	<div id="delDialog" class="ui-widget ui-widget-content ui-corner-all ui-jqdialog " dir="ltr" tabindex="-1" role="dialog" aria-labelledby="delhdgrid-table" aria-hidden="false" style="width: 240px; height: auto; z-index: 1040; overflow: hidden; top: 98px; left: 214px; display: block;">
		<div class="ui-jqdialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix" style="cursor: move;">
			<div class="widget-header">
				<span class="ui-jqdialog-title" style="float: left;">删除</span>
				<a class="ui-jqdialog-titlebar-close ui-corner-all" style="right: 0.3em;" onclick="delCloseModalTable()">
				<span class="ui-icon ui-icon-closethick"></span></a>
			</div>
		</div>
		<div class="ui-jqdialog-content ui-widget-content">
			<div class="formdata" style="width:undefined;overflow:auto;position:relative;height:auto;">
				<table class="DelTable">
					<tbody>
						<tr id="error" style="display:none">
							<td id="errorMsg" class="ui-state-error"></td>
						</tr>
						<tr>
							<td id="delmsg" class="delmsg" style="white-space:pre;">删除所选记录？</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
					</tbody>
				</table>
			</div>
			<table style="cellspacing:0;cellpadding:0;border:0;" class="EditTable">
				<tbody>
					<tr>
						<td><hr class="ui-widget-content" style="margin:1px"></td>
					</tr>
					<tr>
						<td class="DelButton EditButton">
							<a id="delBut" class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm btn-white btn-round btn-danger" onclick="delAndCloseModalTable()">
							<i class="ace-icon fa fa-trash-o"></i>删除<span class="ui-icon ui-icon-scissors" style="display: none;"></span></a>&nbsp;
							<a class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm btn-white btn-round btn-default" onclick="closeModalTable()">
							<i class="ace-icon fa fa-times"></i>取消<span class="ui-icon ui-icon-cancel" style="display: none;"></span></a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- <div class="ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se">
		</div> -->
	</div>
	<!-- 提示请选择记录弹出框 -->
	<!-- 提示选择一条记录弹出框 -->
	
</div>
<div id="modal-table-choose-none" class="modal fade" tabindex="-1" data-backdrop="static">
	<!-- 提示请选择记录弹出框 -->
	<div id="chooseNoneDialog" class="ui-widget ui-widget-content ui-corner-all ui-jqdialog" dir="ltr" tabindex="-1" role="dialog" aria-labelledby="alerthd_grid-table" aria-hidden="false" style="width: 200px; height: auto; z-index: 1040; overflow: hidden; top: 320px; left: 400px; display: block;">
		<div class="ui-jqdialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix" style="cursor: move;">
			<span class="ui-jqdialog-title" style="float: left;">注意</span>
			<a class="ui-jqdialog-titlebar-close ui-corner-all" style="right: 0.3em;" onclick="chooseNoneCloseModalTable()">
				<span class="ui-icon ui-icon-closethick"></span>
			</a>
		</div>
		<div class="ui-jqdialog-content ui-widget-content">
			<div>请选择记录</div>
			<span tabindex="0">
				<span tabindex="-1">
				</span>
			</span>
		</div>
		<div class="jqResize ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se">
		</div>
	</div>
</div>
<div id="modal-table-choose-many" class="modal fade" tabindex="-1" data-backdrop="static">
	<!-- 提示选择一条记录弹出框 -->
	<div id="chooseManyDialog" class="ui-widget ui-widget-content ui-corner-all ui-jqdialog" dir="ltr" tabindex="-1" role="dialog" aria-labelledby="alerthd_grid-table" aria-hidden="false" style="width: 200px; height: auto; z-index: 1040; overflow: hidden; top: 320px; left: 400px; display: block;">
		<div class="ui-jqdialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix" style="cursor: move;">
			<span class="ui-jqdialog-title" style="float: left;">注意</span>
			<a class="ui-jqdialog-titlebar-close ui-corner-all" style="right: 0.3em;" onclick="chooseManyCloseModalTable()">
				<span class="ui-icon ui-icon-closethick"></span>
			</a>
</div>
	<div class="ui-jqdialog-content ui-widget-content">
			<div>只能选择一条记录</div>
			<span tabindex="0">
				<span tabindex="-1"> </span>
			</span>
	</div>
	<div class="jqResize ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se">
	</div>
</div>
</div>
<div id="modal-table-info" class="modal fade" data-backdrop="static" style="margin: auto 0 0 200px;">
    <div class="modal-content bmzy-modal-content" style="display: inline-block; width: auto">
        
    </div>
</div>
<!-- page specific plugin scripts -->
<script type="text/javascript">
//查看日志弹出的窗口
function logsfile(id) {
	//alert(id);
	//获取数据在服务器端
    var hrefLink='${contextPath}/sys/eamPosition/logspage?id='+id;
    layer.open({
           type: 2, //page层
           area: ['1180px', '600px'],
           title: '查看日志',
           skin: 'layui-layer-lan',
           maxmin:true,
           fix: false, //不固定
           moveType: 1, //拖拽风格，0是默认，1是传统拖动
           shift: 1, //0-6的动画形式，-1不开启
           content: [hrefLink, 'no']
         }); 
	
	
}



	var str="";
	function hiddenModal(){
    	$("#grid-table").trigger("reloadGrid");
		$('#modal-table-info').modal('hide');
		$("#modal-table-info").on("hidden.bs.modal", function() {
	    	$(this).removeData("bs.modal");
		});
	}

	//查看
	function view(id){
		if (id != null)
			jQuery("#grid-table").jqGrid(
					'viewGridRow',
					id,
					{
						recreateForm : true,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find(
									'.ui-jqdialog-title').wrap(
									'<div class="widget-header" />')
						}
					});
		else
			alert("Please Select Row");
	}

	function statc(id){//获取状态
		var a ;
		a = jQuery("#grid-table").find('tr[id='+id+']').find('td[aria-describedby=grid-table_fpoNameCN]').text();
		return a;
	}

	function statcName(id){//获取状态
		var a ;
		a = jQuery("#grid-table").find('tr[id='+id+']').find('td[aria-describedby=grid-table_positionName]').text();
		return a;
	}


	//编辑弹出框
	function eidt(id) {
		
	  }

	function style_edit_form(form) {
		var nearbystation=$("#nearbystation").val();
		//alert("nearbystation:"+nearbystation);
	}

	function selectBMB() {
		
	}

	
	//隐藏删除弹出层
	function delCloseModalTable(){
		document.getElementById('errorMsg').innerHTML = "";
		document.getElementById('error').style.display = "none";
		document.getElementById('delBut').style.display = "";
		document.getElementById('delmsg').style.display = "";
		closeModalTable();
		$("body").unbind("mousedown", onBodyDown);
		init_zTree();
		$("#grid-table").trigger("reloadGrid"); 
	}
	//隐藏弹出层
	function closeModalTable(){
		$('#modal-table').modal('hide');
	}
	/***********删除（页脚）*************/
	function delOnFooter(id){
		//alert("del:"+id+",idl:"+id.length);
		if(id.length == 0){
			showChooseNoneMsg();
		} else if ( id.length >= 1 ){
			del(id);
		}
	}
	/**************删除动作*****************/
	//触发删除动作
	function del(id){
		//alert(id);
		delAndCloseModalTable(id);
	}
	//发送删除请求
	function delAndCloseModalTable(id){
		
		$.ajax({
				type : "POST",
				dataType: "text",
				url: "${contextPath}/sys/eamPosition/doOperate?id="+id+"&oper=del",
				success:function(response){
					//alert(data);
					init_zTree();
					$("#grid-table").trigger("reloadGrid"); 
					/* if( data.flag == "success" ){
						delCloseModalTable();
					} else if ( data.flag == "notAll" || data.flag == "used"){
						//alert( data.message);
						document.getElementById('error').style.display = "";
						document.getElementById('errorMsg').innerHTML = data.message;
						document.getElementById('delBut').style.display = "none";
						document.getElementById('delmsg').style.display = "none";
						alert("333333333333333");
						init_zTree();
						
					}  */
			   	}
			});
		}
	//点击背景事件
	function onBodyDown(event) {
		if (!(event.target.id == "menuBtn" || event.target.id == "dialog" || $(
				event.target).parents("#delDialog").length > 0)) {
			//delCloseModalTable();
		}
	}
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
	
	var scripts = [ null, "${contextPath}/static/assets/js/prettify.js", null ];
	$('.page-content-area').ace_ajax('loadScripts', scripts, function() {
		//inline scripts related to this page
		jQuery(function($) {
			window.prettyPrint && prettyPrint();
			$('#id-check-horizontal').removeAttr('checked').on('click', function() {
				$('#dt-list-1').toggleClass('dl-horizontal').prev().html(this.checked ? '&lt;dl class="dl-horizontal"&gt;' : '&lt;dl&gt;');
			});

		})
	});
	
	var setting = {
			view: {
				fontCss:setFontCss_ztree,
			},
			edit: {
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			async: {    
                enable: true,    
                url:"${contextPath}/sys/eamPosition/getChildNodes",    
                autoParam:["id"],    
                //otherParam:{"otherParam":"zTreeAsyncTest"},    
			    //dataType: "json",//默认text  
				type:"post",//默认post     ////异步返回后经过Filter    
                dataFilter: filterssss
            },
			callback: {
	            asyncSuccess: zTreeOnAsyncSuccess,//异步加载成功的fun    
	            asyncError: zTreeOnAsyncError,   //加载错误的fun 
				beforeRename: zTreeBeforeRemove,
				beforeClick:beforeClick
			}
		};
	function filterssss(treeId, parentNode, responseData) {    
		
		if (!responseData) return null;
	  	//eval(data)
        /* for (var i=0, l=childNodes.length; i<l; i++) {    
            childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');    
        }  */  
        return eval(responseData);     
    } 
	function zTreeOnAsyncError(event, treeId, treeNode){    
        alert("异步加载失败!");    
    }    
      
    function zTreeOnAsyncSuccess(event, treeId, treeNode, msg){    
    	alert("异步加载失败!！！！");
    } 
	
	//点击线路出现线路的站点
	var log, className = "dark";
	function beforeClick(treeId, treeNode, clickFlag) {
		/***************************************/
		/* var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		var nodes = treeObj.getNodes();
		if (nodes.length>0) {
			alert(nodes[1].name);
		} */
		/***************************************/
		 $("#fid").val(treeNode.id);
		 //可以获取到这个值
		 var line_code = treeNode.id;
		 $('.page-content-area').ace_ajax('loadScripts', scripts, function() {
			 //trigger("#grid-table");
			 if(treeNode.id == "null"){
				 //$("#fid").val("all");
				 line_code = 'all';
			 }
			 $("#grid-table").jqGrid('setGridParam', {               
				 url : "${contextPath}/sys/eamPosition/getPositionForLine?line_code="+line_code,
	    		datatype : "json",
	            }).trigger("reloadGrid");
		    });
		className = (className === "dark" ? "":"dark");
		showLog("[ "+getTime()+" beforeClick ]&nbsp;&nbsp;" + treeNode.name );
		return (treeNode.click != false);
	}

	function zTreeBeforeRemove(treeId, treeNode) {
		return false;
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
		//alert(666666666666);
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.setting.edit.editNameSelectAll =  $("#selectAll").attr("checked");
	}
	
	function trims(s){
		return trimRight(trimLeft(s));
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
				/* var as=" d f ";
				alert(as); */
		
		    	var value = $('#' + searchConditionId).val();
		    	//alert(trim(value) != "");
		    	if (trim(value) != "") {
			    	 $("#grid-table").jqGrid('setGridParam', {               
				    	//url : "${contextPath}/sys/sysPositionM/fund/"+value,
				    	url : "${contextPath}/sys/eamPosition/fund?value=" + value+"&nameStr="+$("#nameStr").val(),
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
		        var searchCondition = $('#' + searchConditionId).val();
		        //<2>.得到模糊匹配搜索条件的节点数组集合
		        var highlightNodes = new Array();
		        if (searchCondition != "") {
		           var treeObj = $.fn.zTree.getZTreeObj(treeId);
		         	//搜索的树节点
		          	//highlightNodes = treeObj.getNodesByParamFuzzy("name", searchCondition, null);
		           //非第一级节点
		           highlightNodes = treeObj.getNodesByFilter(filter);
		          // alert(notFirstNodes);
		        }
		        //<3>.高亮显示并展示【指定节点s】
		        highlightAndExpand_ztree(treeId, highlightNodes, flag);
		    }
		    
		    function filter(node) {
		    	var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		    	var searchCondition = trim($("#text_").val().toUpperCase());
		    	if(searchCondition != ""){
		    		nodeList = treeObj.getNodesByParamFuzzy("name", searchCondition);
			    	return node.level != 0 && node.name.indexOf(searchCondition) != -1;
		    	}else{
		    		$("#grid-table").clearGridData();
		    		return false;
		    	}
		    	
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
		        // close_ztree(treeId);
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
		            return {color:"#333", "font-weight":"blod"};
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
		//初始化树
		function init_zTree(){
				var zNodes ="";
					var url="${contextPath}/sys/eamPosition/getSysPositionMTree1";
					$.ajax({
			  		url: url,  
			  		success: function(data){
			  			//json转化树
			  			$.fn.zTree.init($("#treeDemo"), setting, eval(data));
			  			$("#selectAll").bind("click", selectAll);
			          }
			      });  
					
				
			}
		//初始化zTree,默认选中根节点
		function init_zTree1(){
			var zNodes ="";
			//if(str == 111){
				var url="${contextPath}/sys/eamPosition/getSysPositionMTree1";
			//}else{
			//	var url="${contextPath}/sys/sysPositionM/getSysPositionMTree";
			//}
				$.ajax({
		  		url: url,  
		  		success: function(data){
		  			//json转化树
		  			$.fn.zTree.init($("#treeDemo"), setting, eval(data));
		  			$("#selectAll").bind("click", selectAll);
		  			var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
					var nodes = treeObj.getNodes();
					if (nodes.length>0) {
						treeObj.selectNode(nodes[0]);
						$("#fid").val("all");
						$("#grid-table").trigger("reloadGrid");
					}
		          }
		      });  
				
			
		}
		//初始化zTree
		$(document).ready(init_zTree1());

	var scripts = [ null, "${contextPath}/static/assets/js/jqGrid/jquery.jqGrid.js", 
		"${contextPath}/static/assets/js/jqGrid/i18n/grid.locale-cn.js", null ];
    $('.page-content-area').ace_ajax('loadScripts', scripts, function() {
    	jQuery(function($) {
    		var grid_selector = "#grid-table";
    		var pager_selector = "#grid-pager";

    		// resize to fit page size
    		$(window).on('resize.jqGrid', function() {
    			$(grid_selector).jqGrid('setGridWidth', $(".col-xs-12").width()-$(".col-sm-2").width()-10);
    		});
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
		    		/* var hiddenCols=$.ajax({url:"${contextPath}/sys/eamPosition/getColHidden",async:false});
					var hiddenColsJSON=JSON.parse(hiddenCols.responseText); */
					
					jQuery(grid_selector).jqGrid({
	        			subGrid : false,
	        			url : "${contextPath}/sys/eamPosition/getEamPosition",
	        			datatype : "json",
	        			height : 450,
	        			colNames : ['','合成码','车站编码',/* "父位置编码", */'车站名称','线路编码','经度','纬度','主责单位','所属单位','创建时间','最后修改时间','备注','日志'],
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
									//delbutton : false,//disable delete button,在这里设置的是删除
									delOptions : {
										/* closeAfterAdd : true,
										closeAfterEdit:true, */
										recreateForm : true,
										afterComplete : afterDeleteMsg,
										beforeShowForm : beforeDeleteCallback
									}/* ,
									editOptions:true,{
										//editformbutton:false,在这里设置的是编辑，设置成功但是对话框关不掉
										recreateForm : true, 
										beforeShowForm : beforeEditCallback,
									 	//afterSubmit : beforeEditEven
									} */
								} 
							},
							{
								name : 'position_no',
								index : 'position_no',
								label : '合成码',
								key:true,
								width : 100,
								editable : false,
								sorttype : "long",
								search : false
							},
							{
								name : 'position_code',
								index : 'position_code',
								label : '车站编码',
								width : 100,
								
								editable : true,
								editoptions : {
									size : "20",
									maxlength : "2"
								},
								searchoptions : {
									sopt : [ 'cn' ]
								},
								editrules : {
									required : true
								}
							},/* {
								
								name : 'f_position_no',
								index : 'f_position_no',
								label : '父位置编码',
								width : 100,
								editable : false, 
								edittype:'select',
								editoptions : {
		        					dataUrl : "${contextPath}/sys/company/getCompanyNames"
		        				},
		        				search : true,
		        				editrules : {
									required : true
								}
							}, */{
								name : 'position_name',
								index : 'position_name',
								label : '车站名称',
								width : 100,
								editable : true,
								sorttype : "date",
								editoptions : {
									size : "20",
									maxlength : "50"
								},
								searchoptions : {
									sopt : [ 'eq' ]
								},
								editrules : {
									required : true
								}
								
							},{
								name : 'line_code',
								index : 'line_code',
								label : '线路编码',
								width : 100,
								editable : true,
								edittype:'select',
								editoptions : {
		        					dataUrl : "${contextPath}/sys/eamPosition/getLineNames"
		        				}
								
							},{
								name : 'longitude',
								index : 'longitude',
								label : '经度',
								width : 100,
								//type:date,
								editable : true,
								//formatter:date,
								sorttype : "date",
								editoptions : {
									size : "20",
									maxlength : "50"
								},
								searchoptions : {
									sopt : [ 'eq' ]
								},
								editrules : {
									required : true
								}
								
							},{
								name : 'latitude',
								index : 'latitude',
								label : '纬度',
								width : 100,
								editable : true,
								/* sorttype : "date", */
								editoptions : {
									size : "20",
									maxlength : "50"
								},
								searchoptions : {
									sopt : [ 'eq' ]
								},
								editrules : {
									required : true
								}
								
							},{
								name : 'dept_no',
								index : 'dept_no',
								label : '主责单位',
								width : 100,
								editable : true,
								/* editable : true, */
								/* sorttype : "date", */
								editoptions : {
									size : "20",
									maxlength : "50"
								},
								searchoptions : {
									sopt : [ 'eq' ]
								},
								editrules : {
									required : true
								}
								
							},{
								name : 'belong_dept',
								index : 'belong_dept',
								label : '所在单位',
								width : 100,
								editable : true,
								/* editable : true, */
								/* sorttype : "date", */
								editoptions : {
									size : "20",
									maxlength : "50"
								},
								searchoptions : {
									sopt : [ 'eq' ]
								},
								editrules : {
									required : true
								}
								
							},{
								name : 'createtime',
								index : 'createtime',
								label : '创建时间',
								width : 100,
								/* editable : true, */
								sorttype : "date",
								formatter : function(cellvalue, options, rowObject) {  
									   return $.hd_jqGrid.dateTimeFormatter(cellvalue);
									},
								editoptions : {
									size : "20",
									maxlength : "50"
								},
								searchoptions : {
									sopt : [ 'eq' ]
								},
								editrules : {
									required : true
								}
								
							},{
								name : 'lastupdatetime',
								index : 'lastupdatetime',
								label : '最后修改时间',
								width : 100,
								/* editable : true, */
								sorttype : "date",
								formatter : function(cellvalue, options, rowObject) {  
									   return $.hd_jqGrid.dateTimeFormatter(cellvalue);
									},
								editoptions : {
									size : "20",
									maxlength : "50"
								},
								searchoptions : {
									sopt : [ 'eq' ]
								},
								editrules : {
									required : true
								}
								
							},{
								name : 'memo',
								index : 'memo',
								label : '备注',
								width : 100,
								editable : true,
								/* editable : true, */
								/* sorttype : "date", */
								editoptions : {
									size : "20",
									maxlength : "50"
								},
								searchoptions : {
									sopt : [ 'eq' ]
								}
								},{
		                        name : 'file',
		                        index : 'file',
		                        width : 110,
		                        sortable : false,
		                        edittype : "select" ,
		                        editoptions : {value : "日志:日志;" },
		                        search : false,
		                        formatter:function(cellvalue, options, rowObject){
		                                var temp = "<a id=\"a"+rowObject.id+"\" src=\"#\" onclick=\"logsfile('"+rowObject.id+"')\">查看日志</a>";
		                            return temp;
		                        } 
		                    }],
	        			//scroll : 1, // set the scroll property to 1 to enable paging with scrollbar - virtual loading of records
	        			sortname : "createtime",
	        			sortorder : "asc",
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
	        			editurl : "${contextPath}/sys/eamPosition/doOperate",
	        			gridComplete:function(){ //在此事件中循环为每一行添加修改和删除链接 
	        				 	//在表单加载的时候刷新树
	        				    //init_zTree();
	        					//alert("我执行了");
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
					
					
					function aceSwitch(cellvalue, options, cell) {
						setTimeout(function() {
							$(cell).find('input[type=checkbox]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
						}, 0);
					}
					function positionT(cellvalue, options, cell) {
						$("#positionType").val(cellvalue);
					}
					function positionType(s){
						
					}
					// 不可编辑字段
					function check(cellvalue, options, cell) {
						
						setTimeout(function() {
							
							$(cell).find('input[name=poNo]').click(function() {
							    jQuery("grid-table_poNo").jqGrid('editRow', "13");
							    this.disabled = 'true';
							    jQuery("grid-table_poNo").attr("disabled", false);
							  });
						}, 0);
						
					}
					
		    		
		    		// navButtons
		    		jQuery(grid_selector).jqGrid('navGrid', pager_selector, { // navbar options
		    			edit : true,
		    			editicon : 'ace-icon fa fa-pencil blue',
		    			add : true,
		    			addicon : 'ace-icon fa fa-plus-circle purple',
		    			del : true,
		    			delicon : 'ace-icon fa fa-trash-o red',
		    			search : false,
		    			searchicon : 'ace-icon fa fa-search orange',
		    			refresh : true,
		    			refreshicon : 'ace-icon fa fa-refresh blue',
		    			view : false,
		    			viewicon : 'ace-icon fa fa-search-plus grey'
		    		}, {
		    			// edit record form
		    			closeAfterEdit: true,
		    			width:'auto',
	    				height : 'auto',
		    			recreateForm : true,
		    			beforeEditCell:function(rowid,cellname,v,iRow,iCol){
		    					alert(rowid);
		    				},
		    			beforeShowForm : function(e) {
		    				//alert("delete beforeShowForm");
		    				var form = $(e[0]);
		    				
    						$("#stationID").hide();		
    						
		    				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
		    				style_edit_form(form);
		    			},
						errorTextFormat: function (response) {
							var result = eval('('+response.responseText+')');
						    return result.message;
						},
						//刷新
		    			afterSubmit: function (response, postdata) {
		                        $(this).trigger("reloadGrid");
		                        init_zTree();
		                        return [true, response.responseText]
		                        
		                }
		    			
		    		}, {
		    			// new record form
		    			width:'auto',
	    				height : 'auto',
		    			closeAfterAdd : true,
		    			recreateForm : true,
		    			viewPagerButtons : false,
						reloadAfterSubmit:true,
						closeAfterEdit:false,
		    			beforeShowForm : function(e) {
		    				var form = $(e[0]);
		    				
		    				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
		    				style_edit_form(form);
		    				
		    			},
						errorTextFormat: function (response) {
							var result = eval('('+response.responseText+')');
						    return result.message;
						},
						afterShowForm : function(e) { 
							
							document.getElementById("stationID").style.display= "none";
						},
						//刷新
		    			afterSubmit: function (response, postdata) {
		                        $(this).trigger("reloadGrid");
		                        init_zTree();
		                        return [true, response.responseText]
		                        
		                }
		    		}, {
		    			// delete record form
		    			recreateForm : true,
						closeAfterAdd : true,
		    			beforeShowForm : function(e) {
		    				var ids;
			   			    ids = jQuery("#grid-table").jqGrid('getGridParam', 'selarrrow');
			   			 	//alert("delete"+ids);
			   			    delOnFooter(ids);
			   				var list;
			   				var str=list.getElementsByTagName("div");//获取检索内容块
		    				 for(var i=0;i<str.length;i++)//遍历内容块
		    				    if(str[i].className=="ui-widget-overlay")//判断类名是否为kkk
		    				       //if(str[i].innerHTML=="test1")//判断内容是否为指定
		    				          str[i].style.display="none"
		    			},
		    			onClick : function(e) {
		    				//alert("asdas");
						},
		    			//刷新
		    			errorTextFormat: function (response, postdata) {
		    					//alert(4444444);
		                        $(this).trigger("reloadGrid");
		                        init_zTree();
		                        return [true, response.responseText]
		                        
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
		    			multipleSearch : true ,
		    			errorTextFormat: function (response) {
							var result = eval('('+response.responseText+')');
						    return result.message;
						}
		        		/**
		        		 * multipleGroup:true, showQuery: true
		        		 */
		    		}, {
		    			// view record form
		    			width: 400,
		    			recreateForm : true,
		    			afterSubmit : function(e) {
		    			//closeAfterEdit:true;
		    			closeAfterAdd : true;
		    			reloadTree();
		    			},
		    			multipleSearch : true ,
		    			errorTextFormat: function (response) {
							var result = eval('('+response.responseText+')');
						    return result.message;
						}
		        		/**
		        		 * multipleGroup:true, showQuery: true
		        		 */
		    		},{
		    			width: 750,
		    			recreateForm : true,
		    			beforeShowForm : function(e) {
		    				var form = $(e[0]);
		    				form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
		    			},
		    			errorTextFormat: function (response) {
							var result = eval('('+response.responseText+')');
						    return result.message;
						}
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
				    	   var form = "<form name='csvexportform' action='${contextPath}/sys/sysPositionM/doOperate?oper=excel' method='post'>";
				    	   form = form + "<input type='hidden' name='csvBuffer' value='" +  encodeURI(encodeURI(rows)) + "'>";
				    	   form = form + "</form><script>document.csvexportform.submit();</sc" + "ript>";
				    	   OpenWindow = window.open('', '');
				    	   OpenWindow.document.write(form);
				    	   OpenWindow.document.close();
				       } 
					});
		    		
					
					
		    		function style_edit_form(form) {
		    			var buttons = form.next().find('.EditButton .fm-button');
		    			buttons.addClass('btn btn-sm').find('[class*="-icon"]').hide();// ui-icon, s-icon
		    			buttons.eq(0).addClass('btn-primary').prepend('<i class="ace-icon fa fa-check"></i>');
		    			buttons.eq(1).prepend('<i class="ace-icon fa fa-times"></i>')
		    			//buttons = form.next().find('.navButton a');
		    			//buttons.find('.ui-icon').hide();
		    			//buttons.eq(0).append('<i class="ace-icon fa fa-chevron-left"></i>');
		    			//buttons.eq(1).append('<i class="ace-icon fa fa-chevron-right"></i>');
		    		}

		    		function style_delete_form(form) {
		    			var buttons = form.next().find('.EditButton .fm-button');
		    			buttons.addClass('btn btn-sm btn-white btn-round').find('[class*="-icon"]').hide();// ui-icon, s-icon
		    			buttons.eq(0).addClass('btn-danger').prepend('<i class="ace-icon fa fa-trash-o"></i>');
		    			buttons.eq(1).addClass('btn-default').prepend('<i class="ace-icon fa fa-times"></i>');
		    			//alert("delete test_style_delete_form");
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
		    		function afterDeleteMsg(e){
		    			init_zTree();
						$("#grid-table").trigger("reloadGrid");
		    		}
		    		function beforeDeleteCallback(e) {
		    			//alert("test delete");
		    			var form = $(e[0]);
		    			if (form.data('styled'))
		    				return false;
		    			form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
		    			style_delete_form(form);
		    			form.data('styled', true);
		    			//alert("delete test_beforeDeleteCallback");
		    		}

		    		function beforeEditCallback(e) {
		    			//alert("edit");
		    			var for1m = $(e[0]);
		    			form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
		    			style_edit_form(form);
		    		}
		    		function beforeEditEven(e){
		    			init_zTree();
						$("#grid-table").trigger("reloadGrid");
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
		    			});
		    		}

		    		function enableTooltips(table) {
		    			$('.navtable .ui-pg-button').tooltip({
		    				container : 'body'
		    			});
		    			$(table).find('.ui-pg-div').tooltip({
		    				container : 'body'
		    			});
		    		}
		    		/***********/
		    		function bindDatePlug() {  
					    $(".time").addClass('Wdate');  
					    $(".time").on('focus', function() {  
					        WdatePicker({  
					            skin : 'whyGreen',  
					            dateFmt : 'yyyy-MM-dd HH:mm:ss',  
					            readOnly : true,  
					            maxDate : "%y-%M-%d %H:%m:%s"  
					        });  
					    });  
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
		    		/***********/
		    		
		    		
		    		
		    		
		    		
		    		$("div.ui-pg-div ui-inline-save").click(function(){
		    			$(this).trigger("reloadGrid");
		                init_zTree();
		               
		    		});
		    		$(".ui-pg-div ui-inline-save").bind("click", function(){
		    			$(this).trigger("reloadGrid");
		                init_zTree();
		    			});
		    		
		    		 $("#poNo").bind("click", function(){
		    			//alert("jk");
		    		}); 
		    		
		    		//刷新按钮刷新重载
		    		$("#refresh_grid-table").click(function(){
		    			$(this).trigger("reloadGrid");
		                init_zTree();
		    		});
		    		$("#sData").click(function(){
		    			$(this).trigger("reloadGrid");
		                init_zTree();
		    		});
		    		//隐藏列
		    		jQuery(grid_selector).jqGrid( 'hideCol', "lastModifidTime");
		    		jQuery(grid_selector).jqGrid( 'hideCol', "createdtime"); 
		    		jQuery(grid_selector).jqGrid( 'hideCol', "stationID");
		    		$(document).one('ajaxloadstart.page', function(e) {
		    			$(grid_selector).jqGrid('GridUnload');
		    			$('.ui-jqdialog').remove();
		    		});
		    		
		    	});
		    }); 
    
</script>
