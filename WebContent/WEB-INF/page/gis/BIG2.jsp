<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <title>BIG2</title>
    <link rel="stylesheet" href="${contextPath}/static/css/jqueryMobile.css">
		<!-- 加载jquery文件 -->
		<script type="text/javascript" src="${contextPath}/static/js/jquery.js"></script>
		<!-- 加载jqueryMobile文件 -->
		<script type="text/javascript" src="${contextPath}/static/js/jqueryMobile.js"></script>
 <style type="text/css">
        .main{
            width: 100%;
            height: 100%;
            position: absolute;
        }
        .quarter-div{
            float: left;
        }
        .blue{
         width: 50%;
            height: 100%;
      
        }
        .green{
          width: 50%;
          height: 50%;
              
        }
        .orange{
         width: 50%;
            height: 50%;
          	float:right
          
        }
       
    </style>
</head>
<body> 
<div class="main">
        <div class="quarter-div blue">
        <iframe src=" " 
          width=100%; height=100%; scrolling="no"  frameborder="0"></iframe>
        </div>
        <div  class="quarter-div green">
         <iframe src=" " 
          width=100%; height=100%; scrolling="no"  frameborder="0"></iframe>
        </div>
        <div class="quarter-div orange">
         <iframe src=" " 
          width=100%; height=100%; scrolling="no"  frameborder="0"></iframe>
    </div>
    </div>
</body>
</html>