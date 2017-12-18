<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<title>全量数据仓库主数据维护平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${contextPath}/static/assets/images/css/layer.css" />
<style>
body {
    padding:0;  /*去除内边距*/
    border:0;   /*去除边框*/
    margin:0;   /*去除外边距*/
    background-color: #92d5ea;
}
.centerDiv {position: fixed;left: -100%;right:100%;top:0;bottom: 0;text-align: center;font-size: 0;}
.centerDiv:after {content:"";display: inline-block;vertical-align: middle;height: 100%;width: 0;}
.content {
display: inline-block;
*display: inline; 
*zoom:1;	
vertical-align: middle;
position: relative;
right: -100%;
width:1366px;
height:768px;
background-image:url(${contextPath}/static/assets/images/tawd1366.png);
}

.inputName{
    padding-left:20px;
    width: 280px;
    height: 40px;
    border: 2px solid #fff;
    border-radius: 19px;
    background-color: #92d5ea;
    margin-top: 267px;
    margin-left: 940px;
    font-size: 24px;
}

.inputPass{
     padding-left:20px;
    width: 280px;
    height: 40px;
    border: 2px solid #fff;
    border-radius: 19px;
    background-color: #92d5ea;
    margin-top: 33px;
    margin-left: 940px;
    font-size: 24px;
}

.buttonPass{
    width: 78px;
    height: 40px;
    border: 2px solid #f8f8f8;
    border-radius: 15px;
    background-color: #38c9f6;
    margin-top: 82px;
    margin-left: 723px;
    color: #000000;
    font-size: 17px;
}



.centerDiv input[placeholder]{ 
color:#fff; 
} 
</style>
</head>
<body >
<form id="validationLoginForm">
<div class="centerDiv">
  <div class="content">
  <img style="margin-top: 12px;" align="left" alt="北京地铁" >
  <input name="phone" id="phone" type="text" class="inputName" placeholder="用户名">
  <input name="password" id="password" type="password" class="inputPass" placeholder="密码">
  <input type="button" class="buttonPass" id="loginButton" value="登     录">
  </div>
</div>
</form>
</body>
	<script src="${contextPath}/static/assets/js/jquery.js"></script>
	<script src="${contextPath}/static/assets/images/js/layer.js"></script>
	
	<script type="text/javascript">
jQuery(function($) {
	$('#loginButton').on('click',function(e){
		$.ajax({
			cache : true,
			type : "POST",
			url : "${contextPath }/sys/sysuser/login",
			data : $('#validationLoginForm').serialize(),// 你的formid
			async : false,
			error : function(request) {
			},
			success : function(data) {
				if(data=='success'){
					location.href='${contextPath}/report/home';
				}else{
					layer.msg(data);
				}
			}
		});
	
	});

});

</script>
</html>