<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>北京地铁能耗平台展示方案</title>
    <link rel="stylesheet" href="${contextPath}/static/css/jqueryMobile.css">
		<!-- 加载jquery文件 -->
		<script type="text/javascript" src="${contextPath}/static/js/jquery.js"></script>
		<!-- 加载jqueryMobile文件 -->
		<script type="text/javascript" src="${contextPath}/static/js/jqueryMobile.js"></script>
		<!--mobiscroll日期插件-->
		<link href="${contextPath}/static/css/mobiscroll.css" rel="stylesheet" type="text/css" />
		<script src="${contextPath}/static/js/mobiscroll.js" type="text/javascript"></script>
    <style type="text/css">
  
		
    	.top{
    	    position:absolute;
    		background-color: rgba(0,0,0,0.5);
    		width: 99%;
    		height: 60px;
    		z-index:1;
    		text-align:center;
    		display:inline;
    		text-shadow: 0 0px 0 #fff;
    		font-weight: 100 !important;
    	}
       .table{
       	 position:absolute;
       	 background:#000; 
       	 color:#FFF;
       	 width: 100%;
       	 height: 1076px;
       }
       .titlefont{
       		font-size:34px;
       		position: relative;
       		font-family: "微软雅黑";
       		color: #6abdf8;
       }
       .timefont{
       		font-size:20px;
       		margin-right:66px;
       		margin-top: -8px;
       		float:right;
       		color : #6abdf8;
       }
       .weather{
       		margin-top: 5px;
       		float:right;
       		color : #6abdf8;
       		margin-right: 25px;
       		font-size:20px;
       }
       .logo{
       		 margin-left: 40px;
             margin-top: 5px;
      		 width: 200px;
       		 height: 50px;
       		 float:left;
       }
       .tablediv{
            position:absolute;
       		width: 19%;
       		height: 25%;
       		background-color: rgba(56,134,160,0.5);
       		z-index:1;
       		margin-left: 10px;
       		background:url('${contextPath}/static/img/right.png');
       		background-size:100% 100%;
       }
       .tabledivr{
       		position:absolute;
       		width: 500px;
       		height: 25%;
       		background-color: rgba(56,134,160,0.5);
       		z-index:1;
       		margin-left: 1395px;
       		background:url('${contextPath}/static/img/right.png');
       		background-size:100% 100%;
       		border-radius:10px;
       }
       .titledivr{
       		position:absolute;
       		width: 500px;
       		height: 5%;
       		background-color: rgba(56,134,160,0.5);
       		z-index:1;
       		margin-left: 1395px;
       		background:url('${contextPath}/static/img/title.png');
       		background-size:100% 100%;
       }
       
       .lefttable1{
       		margin-top: 70px;
       }
        .lefttable2{
       		margin-top: 400px;
       }
        .lefttable3{
       		margin-top: 740px;
       }
       
       .righttable{
       		margin-top: 70px;
       		text-align:center;
       		display:inline;
       }
       
       .righttable1{
       		margin-top: 150px;
       }
        .righttable2{
       		margin-top: 450px;
       }
        .righttable3{
       		margin-top: 750px;
       }
       a{
       	 font-size:20px;
       	 color:#6abdf8;
       	 margin: 20px;
       	 margin-top: 10px;
       	  font-weight: 100 !important ;
       	  text-shadow: 0 0px 0 #fff !important;
       }       
    </style>
    <script type="text/javascript">
	    
    function currentTime(){
    	var show_day=new Array('星期一','星期二','星期三','星期四','星期五','星期六','星期日'); 
    	var date = new Date();  
        var y = date.getFullYear();    
        var m = date.getMonth() + 1;    
        m = m < 10 ? ('0' + m) : m;    
        var d = date.getDate();    
        d = d < 10 ? ('0' + d) : d;    
        var h = date.getHours();  
        h = h < 10 ? ('0' + h) : h;  
        var minute = date.getMinutes();  
        var day=date.getDay(); 
        var second = date.getSeconds();  
        minute = minute < 10 ? ('0' + minute) : minute;    
        second = second < 10 ? ('0' + second) : second;   
        return y + '-' + m + '-' + d+' &nbsp '+ show_day[day-1] +' &nbsp '+ h+':'+minute+':'+second;
    	}
    	setInterval(function(){$('#showTime').html(currentTime)},1000);
	    
    	function findWeather() {
    		  var cityUrl = 'http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js';
    		  $.getScript(cityUrl, function(script, textStatus, jqXHR) {
    		    var citytq = remote_ip_info.city ;// 获取城市
    		    citytq = '北京';
    		    var url = "http://php.weather.sina.com.cn/iframe/index/w_cl.php?code=js&city=" + citytq + "&day=0&dfc=3";
    		    $.ajax({
    		      url : url,
    		      dataType : "script",
    		      scriptCharset : "gbk",
    		      success : function(data) {
    		        var _w = window.SWther.w[citytq][0];
    		        var _f= _w.f1+"_0.png";
    		        if(new Date().getHours() > 17){
    		           _f= _w.f2+"_1.png";        
    		        }
    		        var img = "<img width='20px' height='20px' src='http://i2.sinaimg.cn/dy/main/weather/weatherplugin/wthIco/20_20/" +_f
    		        + "' />";
    		        var tq = citytq + "&nbsp " + img + " " + _w.s1 + " " + _w.t1 + "℃～" + _w.t2 + "℃ " + _w.d1 + _w.p1 + "级";
    		        $('#weather').html(tq);
    		      }
    		    });
    		  });
    		}
    	findWeather();
    	
    	
    

    	
       
    </script>
</head>
<body>
    	<!-- 头部div 显示标题、时间 -->
        <div  class="table">
        	<div class="quarter-div top">
        	<div class="weather" id="weather"></div>
        	<div class="logo">
        		<img style="width: 200px;height: 50px;" alt="" src="${contextPath}/static/img/bjlogo.png">
        	</div>
        	<font class="titlefont" >北京地铁能耗平台展示方案</font>
        	<div>
        		<span class="timefont" style="" id="showTime"></span>
        	</div>
        </div>
        <!-- 选择标题框 -->
       
         <!-- 显示主体 -->
        	<iframe id="myframe" src="http://finereport.bjdt.bmzymtr.com:30001/WebReport/report/bigtablesener" width=100%; height=100%; frameborder=0;  scrolling="no"></iframe>
        </div>
        
</body>
</html>html>