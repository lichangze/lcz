<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="sec"
    uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="${contextPath}/static/dispatcher/assets/css/bootstrap.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/images/css/layer.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/chosen.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/js/date-time/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="${contextPath}/static/ztree/css/zTreeStyle/zTreeStyle.css" />
<link rel="stylesheet" href="${contextPath}/static/select2/dist/css/select2.css" />
<link rel="stylesheet" href="${contextPath}/static/vis/dist/vis.css" />

<script type="text/javascript" src="${contextPath}/static/assets/js/jquery.js"></script>
<script src="${contextPath}/static/assets/js/bootstrap.js"></script>
<script src="${contextPath}/static/assets/js/ace/ace.js"></script>
<script src="${contextPath}/static/assets/js/ace/ace.ajax-content.js"></script>
<script src="${contextPath}/static/assets/js/ace/ace.touch-drag.js"></script>
<script src="${contextPath}/static/assets/js/ace/ace.sidebar.js"></script>
<script src="${contextPath}/static/assets/js/ace/ace.sidebar-scroll-1.js"></script>
<script src="${contextPath}/static/assets/js/ace/ace.submenu-hover.js"></script>
<script src="${contextPath}/static/assets/js/ace/ace.widget-box.js"></script>
<script src="${contextPath}/static/assets/js/ace/ace.settings.js"></script>
<script src="${contextPath}/static/assets/js/ace/ace.settings-rtl.js"></script>
<script src="${contextPath}/static/assets/js/ace/ace.settings-skin.js"></script>
<script src="${contextPath}/static/jquery-validation-1.14.0/jquery.validate.js"></script>
<script src="${contextPath}/static/assets/js/chosen.jquery.min.js"></script>
<script src="${contextPath}/static/json/json2.js"></script>
<script src="${contextPath}/static/assets/js/bootstrap-multiselect.js"></script>
<script src="${contextPath}/static/json/ajaxfilesupload.js"></script>
<script src="${contextPath}/static/assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
<script src="${contextPath}/static/assets/js/date-time/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="${contextPath}/static/assets/images/js/layer.js"></script>
<script src="${contextPath}/static/dispatcher/assets/js/jquery-dateFormat.js"></script>
<script src="${contextPath}/static/assets/js/jquery.inputlimiter.1.3.1.js"></script>
<script src="${contextPath}/static/select2/dist/js/select2.js"></script>
<script src="${contextPath}/static/ztree/js/jquery.ztree.core-3.5.js"></script>
<script src="${contextPath}/static/ztree/js/jquery.ztree.excheck-3.5.js"></script>
<script src="${contextPath}/static/ztree/js/jquery.ztree.exedit-3.5.js"></script>
<script src="${contextPath}/static/vis/dist/vis.js"></script>
<table class="table table-bordered">
<form id="orgForm">       
    <tbody>
        <tr>
            <td style="background-color: #F9F9F9">所属公司</td>
            <td>
            <input type="hidden" name="companyID" id="companyID" value="${company.id}">
           ${company.cmpName} </td>
            <td style="background-color: #F9F9F9">所属上级</td>
            <td colspan="3">
            <input type="hidden" name="orgID" id="orgID" value="${orgStru.id}">
            ${orgStru.orgName} </td>
        </tr>
        <tr>
            <td style="background-color: #F9F9F9">专业编码</td>
            <td><input type="text" name="orgNo" id="orgNo" value=""></td>
            <td style="background-color: #F9F9F9">专业名称</td>
            <td><input type="text" name="orgName" id="orgName" value=""></td>
            <td style="background-color: #F9F9F9">排序</td>
            <td><input type="text" name="orgOrder" id="orgOrder" value=""></td>
        </tr>
        <tr>
        <td style="background-color: #F9F9F9">备注</td>
            <td>
                <textarea rows="3" cols="20" name="remark" id="remark"></textarea>
            </td>
        <td style="background-color: #F9F9F9">所属部门</td>
        <td>
		<select name="deptId" id="deptId" class="form-control">${deptSelectCn}</select>
        </td>
        </tr>
    </tbody>
    </form>
</table>
<div class="modal-footer no-margin-top">
    <div class="text-right">
        <a id="sData"
            class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm btn-primary"
            onclick="submit()"> <i class="ace-icon fa fa-check"></i>提交 <span
            class="ui-icon ui-icon-disk" style="display: none;"></span>
        </a> <a id="cData" onclick="hiddenModal()"
            class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm">
            <i class="ace-icon fa fa-times"></i>取消 <span
            class="ui-icon ui-icon-close" style="display: none;"></span>
        </a>
    </div>
</div>


<script type="text/javascript">
var index = parent.layer.getFrameIndex(window.name); //得到当前iframe层的索引


    function hiddenModal(){
        parent.layer.close(index); //执行关闭  
        
    }
    function submit() {
    var infostr='此选项不能为空';
        if ($('#orgNo').val() == '') {
            $('#orgNo').val(infostr);
            $('#orgNo').css('color', 'red');
            $('#orgNo').focus(function(event) {
            $('#orgNo').val('');
            $('#orgNo').css('color', '#333');
            });
        };
        if ($('#orgName').val() == '') {
            $('#orgName').val(infostr);
            $('#orgName').css('color', 'red');
            $('#orgName').focus(function(event) {
            $('#orgName').val('');
            $('#orgName').css('color', '#333');
            });
        };

        if ($('#orgOrder').val() == '') {
            $('#orgOrder').val(infostr);
            $('#orgOrder').css('color', 'red');
            $('#orgOrder').focus(function(event) {
            $('#orgOrder').val('');
            $('#orgOrder').css('color', '#333');
            });
        };



        if($('#orgNo').val != infostr && ('#orgName').val != infostr && ('#orgOrder').val != infostr){
           

            $.ajax({
                cache : true,
                type : "POST",
                url : "${contextPath}/sys/sysorgstru/doSave",
                data : $('#orgForm').serialize(),// 你的formid
                async : false,
                error : function(request) {
                },
                success : function(data) {
                    parent.$("#grid-table").trigger("reloadGrid");
               if(data=='isrepeat'){
                  layer.alert("专业编码重复");                   
                }else{
              layer.confirm('添加成功', {
               btn: ['确定'] //按钮
              }, function(){
               hiddenModal();
              });
              parent.reloadTree();
                }
                }
});


        } 
    }
</script>
