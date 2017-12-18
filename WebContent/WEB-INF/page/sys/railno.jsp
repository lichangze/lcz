<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="${contextPath}/static/assets/css/jquery-ui.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/ui.jqgrid.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/prettify.css" />
<!-- search 2 ge -->
<link rel="stylesheet" href="${contextPath}/static/assets/css/bootstrap.min.css"  />	
<!-- ajax layout which only needs content area -->

<style type="text/css">
	.ztree li span.button.add {
		margin-left: 2px;
		margin-right: -1px;
		background-position: -144px 0;
		vertical-align: top;
		*vertical-align: middle
	}
	
</style>
<body>
<input type="hidden" id="treeNodeStr" name="treeNodeStr" value="" /> 
<div class="widget-header">
	<!-- search -->
	<div class="col-sm-12">
		<div class="input-group" style="width:170px">
			<input type="text" id="text_" class="form-control search-query" placeholder="请输入搜索条件"  />
			<span class="input-group-btn">
				<button type="button" class="btn btn-purple btn-sm" name="" onclick="search_ztree('treeDemo', 'text_')">
						查询 
				<!-- <input type="button" value="查询"  id="checkID" class="btn btn-purple btn-sm"> -->
				</button>
			</span>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
		<div class="row" id="row">
            <div position="center">
					<div class="widget-body">
						<div class="zTreeDemoBackground left">
							<ul id="treeDemo" class="ztree"></ul>
						</div>
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

<div id="modal-table" class="modal fade" tabindex="-1" data-backdrop="static" >
	<!-- 删除弹出框 -->
	<div id="delDialog" class="ui-widget ui-widget-content ui-corner-all ui-jqdialog " dir="ltr" tabindex="-1" role="dialog" aria-labelledby="delhdgrid-table" aria-hidden="false" style="width: 260px; height: auto; z-index: 1040; overflow: hidden; top: 98px; left: 214px; display: block;">
		<div class="ui-jqdialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix" style="cursor: move;">
			<div class="widget-header">
				<span class="ui-jqdialog-title" style="float: left;">添加</span>
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
							<td id="" class="" style="white-space:pre;">前缀符：</td>
							<td >
								<input id="nameStr" type="text" /><td>&nbsp;&nbsp;&nbsp;</td>
							</td>
						</tr>
						
						<tr>
							<td>&nbsp;</td>
						</tr>
						
						<tr>
							<td id="" class="" style="white-space:pre;">个数：</td>
							<td >
								<input id="numStr" type="text" /><td>&nbsp;&nbsp;&nbsp;</td>
							</td>
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
							<a  id="confirmStr" class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm btn-white btn-round btn-danger" onclick="addTreeNode()">
							<i class="ace-icon fa fa-check"></i>确定<span class="ui-icon ui-icon-scissors" style="display: none;"></span></a>&nbsp;
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
</div>
<input type="hidden" id="typeid" name="typeid" value="" />

<!-- page specific plugin scripts -->
<script type="text/javascript">
	var str="";
	//隐藏删除弹出层
	function delCloseModalTable(){
		//document.getElementById('errorMsg').innerHTML = "";
		//document.getElementById('error').style.display = "none";
		//document.getElementById('delBut').style.display = "";
		//document.getElementById('delmsg').style.display = "";
		closeModalTable();
		$("body").unbind("mousedown", onBodyDown);
		//init_zTree();
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
	/**************弹出框*****************/
	function openTx(){
		$("#modal-table").modal("toggle");
		/* $('#typeid').attr("value",id); */
		$("body").bind("mousedown", onBodyDown);
	}
	//添加动作
	function addTreeNode(treeNode){
		  
		 alert("前缀："+$('#nameStr').val()+"\n"+"数量："+ $('#numStr').val());
		 /* var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		//  treeNode = $("#treeNodeStr").val(treeNode);
		 for(var i=$('#numStr').val();i>=0;i--){
			 alert($('#numStr').val());
			 zTree.addNodes(treeNode, {id:(100 + i), pId:treeNode.id, name:"new node" + (i)});
				 
		 }
		 delCloseModalTable();
		 return false; */ 
		 
		var id = $('#typeid').val();
		 var nameStr = $('#nameStr').val();
		 var bunStr = $('#numStr').val();
		alert("id:"+id);
		alert(nameStr);
		alert(numStr);
			$.ajax({
			type : "POST",
			dataType:"json",
			url: "${contextPath}/sys/railNo/doAdd?id="+id+"&nameStr="+encodeURI(encodeURI(nameStr))+"&numStr="+encodeURI(encodeURI(numStr))+"&oper=add",
			success:function(data){
				//alert(data.flag);
				//alert(data.message);
				if( data.flag == "success" ){
					var idString = data.delIds;
					
					if(idString.search(",") != -1){
						var delIds = idString.split(",");
						for(var i = 0 ; i < delIds.length ; i++){
							$("#grid-table").jqGrid('delRowData', delIds[i]);
						}
					} else {
						$("#grid-table").jqGrid('delRowData', idString);
					}
					delCloseModalTable();
				} else if ( data.flag == "notAll" ){
					//alert(data.delIds);
					var idString = data.delIds;
					if(idString.search(",") != -1){
						var delIds = idString.split(",");
						for(var i = 0 ; i < delIds.length ; i++){
							$("#grid-table").jqGrid('delRowData', delIds[i]);
						}
					} else {
						$("#grid-table").jqGrid('delRowData', idString);
					}
					document.getElementById('error').style.display = "";
					document.getElementById('errorMsg').innerHTML = data.message;
					document.getElementById('delBut').style.display = "none";
					document.getElementById('delmsg').style.display = "none";
				} else {
					document.getElementById('error').style.display = "";
					document.getElementById('errorMsg').innerHTML = data.message;
					document.getElementById('delBut').style.display = "none";
					document.getElementById('delmsg').style.display = "none";
				}
		   	}
		}); 
	}
	//点击背景事件
	function onBodyDown(event) {
		if (!(event.target.id == "menuBtn" || event.target.id == "dialog" || $(
				event.target).parents("#delDialog").length > 0)) {
			delCloseModalTable();
		}
	}

	//获取复选框的值 
	function dianji(){
		str="";
		 $("input[name=checkbox]:checked").each(function(){
             str+=$(this).val();
         })
        init_zTree();
	}
	
	$.extend($.fn.fmatter, {
     		actionFormatter: function(cellvalue, options, rowObject) {
            var retVal = "eidt("+cellvalue.id+")";
            return retVal;
        }
    } );
	//$("#Dexecl").attr({"disabled":true});
	var scripts = [ null, "${contextPath}/static/assets/js/prettify.js", null ]
	$('.page-content-area').ace_ajax('loadScripts', scripts, function() {
		//inline scripts related to this page
		jQuery(function($) {
			window.prettyPrint && prettyPrint();
			$('#id-check-horizontal').removeAttr('checked').on('click', function() {
				$('#dt-list-1').toggleClass('dl-horizontal').prev().html(this.checked ? '&lt;dl class="dl-horizontal"&gt;' : '&lt;dl&gt;');
			});

		})
	});
	function setRemoveBtn(treeId, treeNode) {
		return !treeNode.isParent;
	}
	function setRenameBtn(treeId, treeNode) {
		return !treeNode.isParent;
	}
	var setting = {
			view: {
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom,
				selectedMulti: false,
				fontCss:setFontCss_ztree,
			},
			edit: {
				enable: true,
				editNameSelectAll: true,
				showRemoveBtn: setRemoveBtn,
				showRenameBtn: setRenameBtn
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
				beforeRemove: beforeRemove,
				beforeRename: beforeRename,
				//onRemove:  zTreeOnRemove,
				//onRename: onRename,
				//beforeClick:beforeClick 
			}
		};
	function beforeRename(treeId, treeNode) {
		var id = treeNode.id;
		var name = treeNode.name;
		alert(name);
		$.ajax({
				type : "POST",
				dataType: "json",
				url: "${contextPath}/sys/railNo/doUpdate?id="+id+"&name="+encodeURI(encodeURI(name))+"&oper=del",
				success:function(data){
					//alert(data.flag);
					/* if( data.flag == "success" ){
						delCloseModalTable();
					} else if ( data.flag == "notAll" || data.flag == "used"){
						//alert( data.message);
						document.getElementById('error').style.display = "";
						document.getElementById('errorMsg').innerHTML = data.message;
						document.getElementById('delBut').style.display = "none";
						document.getElementById('delmsg').style.display = "none";
					}  */
			   	}
			});
 }
	function beforeRemove(treeId, treeNode) {
		var id = treeNode.id;
		$.ajax({
				type : "POST",
				dataType: "json",
				url: "${contextPath}/sys/railNo/doDelete?id="+id+"&oper=del",
				success:function(data){
			   	}
			});
 }
	//单击时获取zTree节点的Id,和value的值
	
    function zTreeOnClick(event, treeId, treeNode, clickFlag) {
        var treeValue = treeNode.id + "," + treeNode.name;
        
		
        //alert(treeNode.id + "," + treeNode);
    };
    
	/* var log, className = "dark";
	var clickName;
	function beforeClick(treeId, treeNode, clickFlag) {
		 $("#clickId").val(treeNode.id);
		 $("#clickNode").val(treeNode);
		 clickName = treeNode.name;
		 $('.page-content-area').ace_ajax('loadScripts', scripts, function() {
			 //重新加载页面数据
			 $("#grid-table").jqGrid('setGridParam', {               
				 url : "${contextPath}/eqm/eqmarchitecture/getEqmArchitectures/"+treeNode.id,
	    		datatype : "json",
	         }).trigger("reloadGrid");
		});
		className = (className === "dark" ? "":"dark");
		showLog("[ "+getTime()+" beforeClick ]&nbsp;&nbsp;" + treeNode.name );
		return (treeNode.click != false);
	} */

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
		//alert(h+":"+m+":"+s+ " " +ms);
		return (h+":"+m+":"+s+ " " +ms);
	}

	var newCount = 1;
	function addHoverDom(treeId, treeNode) {
		var sObj = $("#" + treeNode.tId + "_span");
		var flag = treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0;
		if (flag) return;
		var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
			+ "' title='add node' onfocus='this.blur();'></span>";
		sObj.after(addStr);
		var btn = $("#addBtn_"+treeNode.tId);
		 if (btn) btn.bind("click", function(){
			 var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			/* zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"公里标" + (newCount++)});
			return false;  */
			 $("#treeNodeStr").val(treeNode);
			openTx();
			return false; 
		});  
		
		
	};
	//删除
	function removeHoverDom(treeId, treeNode) {
		$("#addBtn_"+treeNode.tId).unbind().remove();
	};
	//全选
	function selectAll() {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.setting.edit.editNameSelectAll =  $("#selectAll").attr("checked");
	}
	//去空格
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
	/**
     * 搜索树，高亮显示并展示【模糊匹配搜索条件的节点s】
     * @param treeId
     * @param searchConditionId 文本框的id
     */
    function search_ztree(treeId, searchConditionId){
    	/* var value = $('#' + searchConditionId).val();
		if(trim(value)!=""){
			$("#grid-table").jqGrid('setGridParam', {               
		    	//url : "${contextPath}/sys/sysPositionM/fund/"+value,
		    	url : "${contextPath}/sys/railNo/fund?value=" + value,
	   			datatype : "json",
           }).trigger("reloadGrid");
		} */
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

var zNodes =[
				{ id:1, pId:0, name:"一号线", open:true},
				{ id:2, pId:1, name:"上行"},
				{ id:3, pId:1, name:"下行"},
				
				{ id:4, pId:2, name:"公里标1"}, { id:5, pId:2, name:"公里标2"},
				{ id:12, pId:2, name:"公里标3"}, { id:13, pId:2, name:"公里标4"},
				{ id:14, pId:2, name:"公里标5"}, { id:15, pId:2, name:"公里标6"},
				{ id:16, pId:2, name:"公里标7"}, { id:17, pId:2, name:"公里标8"},
				{ id:18, pId:2, name:"公里标9"}, { id:19, pId:2, name:"公里标10"},
				{ id:20, pId:2, name:"公里标11"}, { id:21, pId:2, name:"公里标12"},
				{ id:22, pId:2, name:"公里标13"}, { id:23, pId:2, name:"公里标14"},
				{ id:24, pId:2, name:"公里标15"}, { id:25, pId:2, name:"公里标16"},
				{ id:26, pId:2, name:"公里标17"}, { id:27, pId:2, name:"公里标18"},
				{ id:28, pId:2, name:"公里标19"}, { id:29, pId:2, name:"公里标20"},
				
				{ id:6, pId:3, name:"公里标1"},
				{ id:7, pId:3, name:"公里标2"},
				
				{ id:8, pId:4, name:"1号钢轨"}, { id:9, pId:4, name:"2号钢轨"},
				{ id:30, pId:4, name:"3号钢轨"}, { id:31, pId:4, name:"4号钢轨"},
				{ id:32, pId:4, name:"5号钢轨"}, { id:33, pId:4, name:"6号钢轨"},
				{ id:34, pId:4, name:"7号钢轨"}, { id:35, pId:4, name:"8号钢轨"},
				{ id:36, pId:4, name:"9号钢轨"}, { id:37, pId:4, name:"10号钢轨"},
				{ id:38, pId:4, name:"11号钢轨"}, { id:39, pId:4, name:"12号钢轨"},
				{ id:40, pId:4, name:"13号钢轨"}, { id:41, pId:4, name:"14号钢轨"},
				{ id:42, pId:4, name:"15号钢轨"}, { id:43, pId:4, name:"16号钢轨"},
				{ id:44, pId:4, name:"17号钢轨"}, { id:45, pId:4, name:"18号钢轨"},
				{ id:46, pId:4, name:"19号钢轨"}, { id:47, pId:4, name:"20号钢轨"},
				{ id:48, pId:4, name:"21号钢轨"}, { id:49, pId:4, name:"22号钢轨"},
				{ id:50, pId:4, name:"23号钢轨"}, { id:51, pId:4, name:"24号钢轨"},
				{ id:52, pId:4, name:"25号钢轨"}, { id:53, pId:4, name:"26号钢轨"},
				{ id:54, pId:4, name:"27号钢轨"}, { id:55, pId:4, name:"28号钢轨"},
				{ id:56, pId:4, name:"29号钢轨"}, { id:57, pId:4, name:"30号钢轨"},
				{ id:58, pId:4, name:"31号钢轨"}, { id:59, pId:4, name:"32号钢轨"},
				{ id:60, pId:4, name:"33号钢轨"}, { id:61, pId:4, name:"34号钢轨"},
				{ id:62, pId:4, name:"35号钢轨"}, { id:63, pId:4, name:"36号钢轨"},
				{ id:64, pId:4, name:"37号钢轨"}, { id:65, pId:4, name:"38号钢轨"},
				{ id:66, pId:4, name:"39号钢轨"}, { id:67, pId:4, name:"40号钢轨"},
				
				{ id:10, pId:5, name:"1号钢轨"},
				{ id:11, pId:5, name:"2号钢轨"},
				
				
			];
  	/* function init_zTree() {
	$.fn.zTree.init($("#treeDemo"), setting,zNodes);
}  */ 	
	
 	 	 function init_zTree(){
			if(str == 111){
				var url="${contextPath}/sys/railNo/getSysRailNoTree";
			}else{
				var url="${contextPath}/sys/railNo/getSysRailNoTree";
			}
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
	
</script>


