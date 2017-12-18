<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<title>纯CSS实现不固定大小div相对于body垂直居中效果</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.lanrenzhijia {position: fixed;left: -100%;right:100%;top:0;bottom: 0;text-align: center;font-size: 0;}
.lanrenzhijia:after {content:"";display: inline-block;vertical-align: middle;height: 100%;width: 0;}
.content {display: inline-block; *display: inline; *zoom:1;	vertical-align: middle;position: relative;right: -100%;background:#639A29;width:1366px;height:768px;background-image:url(${contextPath}/static/assets/images/login.jpg);}
</style>
</head>
<body >
<div class="lanrenzhijia">
  <div class="content"></div>
</div>
</body>
</html>