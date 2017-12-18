<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="${contextPath}/static/assets/css/jquery-ui.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/ui.jqgrid.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/prettify.css" />
<!-- search 2 ge -->
<link rel="stylesheet" href="${contextPath}/static/assets/css/bootstrap.min.css"  />
<!-- ajax layout which only needs content area -->
<link rel="stylesheet" href="${contextPath}/static/layer/skin/layer.css" />
<script src="${contextPath}/static/layer/layer.js"></script>
<div class="row" >
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
		<div class="row" id="row">
		<div class="col-sm-2">
				<div class="widget-box">
					<div class="widget-header widget-header-flat">
						<h4 class="widget-title smaller">
							线路&位置
						</h4>
					</div>
					<!-- search -->
					<input type="hidden" id="delId" name="delId" value="" /> 
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
	var str="";
	function hiddenModal(){
    	$("#grid-table").trigger("reloadGrid");
		$('#modal-table-info').modal('hide');
		$("#modal-table-info").on("hidden.bs.modal", function() {
	    	$(this).removeData("bs.modal");
		});
	}

	//查看
	function view1(id){
		layer.open({
			   type: 2, //page层
			   area: ['350px', '350px'],
			   title: '添加工作组',
			   skin: 'layui-layer-lan',
			   fix: false, //不固定
			   shift: 1, //0-6的动画形式，-1不开启
			   content:'${contextPath}/sys/qcellcore/addsysqellcore?oper=view&&id='+id
			}); 
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
		layer.open({
	    type: 2, //page层
	   area: ['350px', '350px'],
	   title: '修改',
			   skin: 'layui-layer-lan',
			   fix: false, //不固定
			   shift: 1, //0-6的动画形式，-1不开启
			   content:'${contextPath}/sys/qcellcore/addsysqellcore?oper=exit&&id='+id
			 }); 
	 }

	  function add(){
	  	var id = $("#fid").val();
	  	if(id == 'all'){
	  		layer.msg("请选择归属地位置信息",{
	 			  icon: 2,
					skin: 'layer-ext-moon' 
			});
	  	}else{
	  		layer.open({
			   type: 2, //page层
			   area: ['350px', '350px'],
			   title: '添加工作组',
			   skin: 'layui-layer-lan',
			   fix: false, //不固定
			   shift: 1, //0-6的动画形式，-1不开启
			   content:'${contextPath}/sys/qcellcore/addsysqellcore?oper=add&&poId='+id
			 }); 
	  	}      
	  }



	function style_edit_form(form) {
		var nearbystation=$("#nearbystation").val();
		//alert("nearbystation:"+nearbystation);
	}

	function selectBMB() {
		//var specialtyName = $("#specialtyName").val();
		var fid = $("#fid" ).val();
		var stationId = $.ajax({
		type : "POST",
		data : { //要传递的数据
			fid : function() {
				return fid;
			},
		},
		url : "${contextPath}/sys/sysPositionM/getBMB",
		async : false
		});
		document.getElementById('stationID').innerHTML = stationId.responseText;
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

	function delMone(id){
		del(id);
	}

	function f_Id() {
		var s;
		s = jQuery("#grid-table").jqGrid('getGridParam', 'selarrrow');
		return s;
	}
	/**************删除动作*****************/
	//触发删除动作
	function del(id){
			$("#modal-table").modal("toggle");
			$('#delId').attr("value",id);
			$("body").bind("mousedown", onBodyDown);
	}
	//发送删除请求
	function delAndCloseModalTable(){
		var id = $('#delId').val();
		$.ajax({
				type : "POST",
				dataType: "json",
				url: "${contextPath}/sys/qcellcore/delSysqcellCore?id="+id,
				success:function(data){
					//alert(data.flag);
					if( data.flag == "success" ){
						delCloseModalTable();
					} else if ( data.flag == "notAll" || data.flag == "used"){
						//alert( data.message);
						document.getElementById('error').style.display = "";
						document.getElementById('errorMsg').innerHTML = data.message;
						document.getElementById('delBut').style.display = "none";
						document.getElementById('delmsg').style.display = "none";
						$("#grid-table").trigger("reloadGrid"); 
					} 
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
			callback: {
				beforeRename: zTreeBeforeRemove,
				beforeClick:beforeClick
			}
		};

	var log, className = "dark";
	function beforeClick(treeId, treeNode, clickFlag) {
		$("#fid").val(treeNode.id);
		 $('.page-content-area').ace_ajax('loadScripts', scripts, function() {
			 //trigger("#grid-table");
			 if(treeNode.id == "null"){
				 $("#fid").val("all");
			 }
			 $("#grid-table").jqGrid('setGridParam', {               
				 url : "${contextPath}/sys/qcellcore/getSysQcellcoreList",
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
				    	url : "${contextPath}/sys/sysPositionM/fund?value=" + value+"&nameStr="+$("#nameStr").val(),
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
				//if(str == 111){
					var url="${contextPath}/sys/qcellcore/getSysPositionMTreeName";
				//}else{
				//	var url="${contextPath}/sys/sysPositionM/getSysPositionMTree";
				//}
					$.ajax({
			  		url: url,  
			  		success: function(data){
			  			//json转化树
			  			$.fn.zTree.init($("#treeDemo"), setting, eval(data));
			  			$("#selectAll").bind("click", selectAll);
			  			/* var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
						var nodes = treeObj.getNodes();
						if (nodes.length>0) {
							treeObj.selectNode(nodes[0]);
							$("#fid").val("all");
							$("#grid-table").trigger("reloadGrid");
						} */
			          }
			      });  
					
				
			}
		//初始化zTree,默认选中根节点
		function init_zTree1(){
			var zNodes ="";
			//if(str == 111){
				var url="${contextPath}/sys/sysPositionM/getSysPositionMTree1";
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

	var scripts = [ null, "${contextPath}/static/assets/js/jqGrid/jquery.jqGrid.js", "${contextPath}/static/assets/js/jqGrid/i18n/grid.locale-cn.js", null ];
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
		    		var hiddenCols=$.ajax({url:"${contextPath}/sys/sysPositionM/getColHidden",async:false});
					var hiddenColsJSON=JSON.parse(hiddenCols.responseText);
					
		    		jQuery(grid_selector)
					.jqGrid(
							{
								subGrid : false,
								url : "${contextPath}/sys/qcellcore/getSysQcellcoreList",
								postData : { //要传递的数据
									fid : function() {
				                            var fid = $("#fid" ).val();
				                            return fid;
				                           },
								},
								datatype : "json",
								height : 450,
								colNames : [ '','位置名称','工作组','所属专业','备注'],
								colModel : [
										{
											name : '',
											index : '',
											width : 80,
											fixed : true,
											sortable : false,
											resize : false,
											//formatter : 'actions',
											formatter : authorityFormatter,
											formatoptions : {
												keys : true,
												editbutton : true,
												//delbutton : false,//disable delete button
												delOptions : {
													closeAfterAdd : true,
													reloadAfterSubmit:true,
													recreateForm : true,
													beforeShowForm : beforeDeleteCallback,
													afterSubmit: function (response, postdata) {
									                    $(this).trigger("reloadGrid");
									                    init_zTree();
									                    return [true, response.responseText]
									            	},
									            	errorTextFormat: function (response) {
									  					var result = eval('('+response.responseText+')');
									  				    return result.message;
									  				}
									    		
												}
											//editformbutton:true, editOptions:{recreateForm:true, beforeShowForm:beforeEditCallback}
											},
											search : false
										},{
											name : 'positionEntity.positionName',
											index : 'positionEntity.positionName',
											label : '位置名称',
											hidden:(hiddenColsJSON.clickName=='true'),
											width : 100,
											editable : true,
											editoptions : {
												size : "20",
												maxlength : "40"
											},
											searchoptions : {
												sopt : [ 'cn' ]
											},
											search : false,
											formoptions:{rowpos:1,colpos:1}
										},{
											name : 'sysWorkGroup.workGroupName',
											index : 'sysWorkGroup.workGroupName',
											label : '工作组',
											hidden:(hiddenColsJSON.poName=='true'),
											width : 100,
											editable : true,
											editoptions : {
												size : "20",
												maxlength : "40"
											},
											searchoptions : {
												sopt : [ 'cn' ]
											},
											editrules : {
												required : true
											},
											search : true,
											formoptions:{rowpos:1,colpos:2}
										},{
											name : 'sysWorkGroup.sysOrgStru.orgName',
											index : 'sysWorkGroup.sysOrgStru.orgName',
											label : '专业',
											hidden:(hiddenColsJSON.poNo=='true'),
											width : 100,
											editable : true,
											editoptions : {
												size : "20",
												maxlength : "60"
											},
											editrules : {
												required : true
											},
											searchoptions : {
												sopt : [ 'cn' ]
											},
											search : true,
											formoptions:{rowpos:2,colpos:2},
											unformat : checks,
										},{
											name : 'remake',
											index : 'remake',
											label : '位置类型',
											hidden:(hiddenColsJSON.poType=='true'),
											width : 100,
											search:false,
											editable : true,
											editoptions : {size : "20",maxlength : "10"},
											searchoptions : {
												sopt : [ 'cn' ]
											},
								            formoptions:{rowpos:2,colpos:1},
								            unformat : positionT
										}],
										
								//scroll : 1, // set the scroll property to 1 to enable paging with scrollbar - virtual loading of records
								//排序
								sortable:true,
								sortname:'id',
								sortorder:'asc',
								viewrecords : true,
								showQuery: true,
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
									setTimeout(
											function() {
												styleCheckbox(table);
												updateActionIcons(table);
												updatePagerIcons(table);
												enableTooltips(table);
											}, 0);
								},
								editurl : ""
							
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
						if(s != '' && s != '0'){
							$.ajax({
								type : "POST",
								datatype : "json",
								async : false,
								data:{positionTypeId : s},
								url : "${contextPath}/sys/sysPositionM/getPType",
								success : function(data) {
									var data = JSON.parse(data);
									if(data.poTypeName == '百米标'){
										$("#stationID").toggle();
										selectBMB();
									}else{
										$("#stationID").hide();
									}
								}
							});
						}else{
							$("#stationID").hide();
						}
					}
					// 不可编辑字段
					function check(cellvalue, options, cell) {
						
						setTimeout(function() {
							//$(cell).find('input[name=poNo]').click( function () { alert("警告 位置代码不可编辑") });
							
							$(cell).find('input[name=poNo]').click(function() {
							    jQuery("grid-table_poNo").jqGrid('editRow', "13");
							    this.disabled = 'true';
							    jQuery("grid-table_poNo").attr("disabled", false);
							  });
						}, 0);
						
					}
					// 获取信息
					function checks(cellvalue, options, cell) {
						
						setTimeout(function() {
							$(cell).find('input[name=poNo]').click(function() {
							alert(cellvalue);
							});
						}, 0);
						
					}
					function authorityFormatter(cellvalue, options,	cell) {
	        			//var template ="<div style = 'margin-left:8px;' <div class='ui-pg-div ui-inline-edit'><span><a href='${contextPath}/eqm/eqmaccount/eqmaccountmxRow/"+cell.id+"' id='"+cell.id+"'  title='编辑所选记录' style='text-decoration:none;' class='ui-icon ui-icon-pencil'></a></span><div class='ui-pg-div ui-inline-del'><span><a   title='删除所选记录' style='text-decoration:none;' class='ui-icon ui-icon-trash'></a></span></div></div>"        			
	        			//return template;
	        			//var template = "<div style = 'margin-left:8px;' <div class='ui-pg-div ui-inline-edit'><span><a onclick ='eidt(\""+ cell.id
										//+ "\")' id='a"+ cell.id+ "'  title='编辑' style='text-decoration:none;' class='ui-icon ui-icon-pencil'></a></span>&nbsp;<span><a id='id='a"
										//+ cell.id
										//+ "'' onclick = 'del(\""+ cell.id+"\")' title='删除' style='text-decoration:none;' class='ui-icon ui-icon-trash'></a></span></div></div>"
										
						var template ="<div class='ui-pg-div ui-inline-edit'><a id='a"+cell.id+"'  onclick = 'eidt(\""+cell.id+"\")' title='编辑' style='text-decoration:none;' class='ui-icon ui-icon-pencil'></a>"+
											"<a id='b"+cell.id+"' onclick = 'view1(\""+cell.id+"\")' title='查看' style='text-decoration:none;' class='ui-icon fa-search-plus grey'></a>"+
											"<a id='c"+cell.id+"' onclick = 'del(\""+cell.id+"\")' title='删除' style='text-decoration:none;' class='ui-icon ui-icon-trash'></a></div>";
	        			//var  id='a"+cell.id+"'  title='编辑所选记录' style='text-decoration:none;' class='ui-icon ui-icon-pencil'></a></span>&nbsp<span><a id='id='a"+cell.id+"'' onclick = 'del(\""+cell.id+"\")' title='删除所选记录' style='text-decoration:none;' class='ui-icon ui-icon-trash'></a></span>&nbsp<span><a id='id='a"+cell.id+"'' onclick = 'copy(\""+cell.id+"\")' title='复制信息' style='text-decoration:none;' class='ui-icon fa-files-o green'></a></span></div></div>"
	        			//var template ="<div style = 'margin-left:8px;' <div class='ui-pg-div ui-inline-edit'><a id='id='a"+cell.id+"'' onclick = 'del("+cell.id+")' title='跳转' style='text-decoration:none;' class='glyphicon glyphicon-share-alt'></a><a href='${contextPath}/eqm/eqmaccount/eqmaccountmxRow/"+cell.id+"' role='button'  data-toggle='modal' data-target='#modal-table' title='编辑所选记录' style='text-decoration:none;' class='ui-icon ui-icon-pencil'></a>&nbsp;<a id='id='a"+cell.id+"'' onclick = 'del("+cell.id+")' title='删除所选记录' style='text-decoration:none;' class='ui-icon ui-icon-trash'></a></div>"
	        			return template;
	        		}
		    		
		    		// navButtons
		    		jQuery(grid_selector).jqGrid('navGrid', pager_selector, { // navbar options
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
		    				var form = $(e[0]);
		    				/**********是否站台附近**************/
		    				/*var id=$('#grid-table').jqGrid('getGridParam','selarrrow');
		    				$.ajax({
		    					type : "POST",
		    					dataType:"json",
		    					url : "${contextPath}/sys/sysPositionM/getNearbyStationValue?id=" + id,
		    					success:function(data){
		    						var nearbystation = data.flag;
		    						//若不是站台附近 隐藏
		    						if(nearbystation==false){
		    							$("#directionCN").hide();		
		    						}
		    						//点击事件
		    						$("#nearbyStationCn").bind("click",	function (cellvalue, options,	cell){
		    							$("#directionCN").toggle();
		    						});  
		    					}
		    				}); */
		    				/*******************************/
		    				
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
		    				/*********隐藏方向*********/	
		    				/*
		    				$("#nearbyStationCn").bind("click",	function (cellvalue, options,cell){
    							$("#directionCN").toggle();
    						}); */ 
    						//var logoutTimes = $("#positionTypeEntity.poTypeName").val();
    						//alert(logoutTimes);
		    				/************************/
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
			   				delOnFooter(ids);
			   				var list;
			   				var str=list.getElementsByTagName("div");//获取检索内容块
		    				 for(var i=0;i<str.length;i++)//遍历内容块
		    				    if(str[i].className=="ui-widget-overlay")//判断类名是否为kkk
		    				       //if(str[i].innerHTML=="test1")//判断内容是否为指定
		    				          str[i].style.display="none"
		    			},
		    			onClick : function(e) {
						},
		    			//刷新
		    			errorTextFormat: function (response, postdata) {
		    				alert(4444444);
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
		    		jQuery(grid_selector).jqGrid('navButtonAdd', pager_selector,{   
			    	   			caption:"",
			    	   			title : "删除",
			    	   			buttonicon:"ace-icon fa fa-trash-o red",   
			    	   			onClickButton: function(){   
									delMone(f_Id());
			    	   			},
			    	   			position:"first"
			    	});
					jQuery(grid_selector).jqGrid('navButtonAdd', pager_selector,{   
				    	   		caption:"",
				    	   		title : "添加",
				    	   		buttonicon:"ace-icon fa fa-plus-circle purple",   
				    	   		onClickButton: function(){   
				    	   			add();
				    	   		},
				    	   	position:"first"
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
