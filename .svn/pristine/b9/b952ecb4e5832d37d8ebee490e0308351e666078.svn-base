<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <title>北京地铁运力运量匹配图</title>
    
    
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
       .tabledivr{
       		position:absolute;
       		width: 500px;
       		height: 25%;
       		background-color: rgba(56,134,160,0.5);
       		z-index:1;
       		margin-left: 1395px;
       		background:url('${contextPath}/static/img/jy.png');
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
       .msgDiv{
       		position:absolute;
       		width: 500px;
       		height: 25%;
       		background-color: rgba(56,134,160,0.5);
       		z-index:1;
       		text-align:center;
       		margin-left: 1395px;
       		margin-top :575px;
       		background:url('${contextPath}/static/img/jy4.png');
       		background-size:100% 100%;
       		border-radius:10px;
       }
       
       input { background:#f00;}
       
       
       .righttable{
       		margin-top: 110px;
       		text-align:center;
       		display:inline;
       		font-size: 33px;
       		color : #6abdf8;
       }
       .leftivr{
       		position:absolute;
       		width: 430px;
       		height: 25%;
       		background-color: rgba(56,134,160,0.5);
       		z-index:1;
       		margin-left: 10px;
       		background:url('${contextPath}/static/img/jy.png');
       		background-size:100% 100%;
       		border-radius:10px;
       }
        .lefttable1{
       		margin-top: 150px;
       }
        .lefttable2{
       		margin-top: 450px;
       }
        .lefttable3{
       		margin-top: 750px;
       }
     .ui-btn {
	    display: block;
	    text-align: center;
	    cursor: pointer;
	    position: relative;
	    margin: .5em 0;
	    padding: 0;
	    background: #052033;
	}
	   div.ui-input-text {
	    margin: .5em 0;
	    background-image: none;
	    position: relative;
	    background: #052033;
	  }
      .ui-select .ui-btn-text{
		    text-overflow: ellipsis;
		    color: #6abdf8;
		}
       td{
       		margin: 2px;
       }
    </style>
    <script type="text/javascript">
	    
    var _lineId = "ALL";
    var _date = "";
    var _transcode = "";
    var _times = "";
    var _num = "";
    var _fshowTime="";
    
    
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
   
    	
    	function changeLine(){
    		 lineId = $('#lineId option:selected').val();
    		 _lineId = lineId;
    		 getTranscode(lineId);
    	}
    	
    	function initMethod() {
    		_date = $("#data").val();
    		_transcode = $('#transcode option:selected').val();
    		_times = $("#times").val();
    		_num = $("#num").val();
    	}
    	
    	function getTranscode(lineId){
    		$.ajax({
    			type : "POST",
    			datatype : "json",
    			async : false,
    			url : "${contextPath}/gisyl/getTranscode",
    			data : { //要传递的数据
    				lineId : function() {
    					return lineId;
    				},
    			},
    			success : function(data) {
    				document.getElementById('transcode').innerHTML = data;
    			}
    		});
    	}
    	
    	/*
    	*String showTime = request.getParameter("showTime");
		String lineId = request.getParameter("lineID");
		String transcode = request.getParameter("transcode");
		String date = request.getParameter("date");
		String times = request.getParameter("times");
		String num = request.getParameter("num");
    	*/
    	
    	function getMsgValue(){
    		$.ajax({
    			type : "POST",
    			datatype : "json",
    			async : false,
    			url : "${contextPath}/gisyl/getMsgValue",
    			data : { //要传递的数据
    				showTime : function() {
    					return _fshowTime;
    				},
    				lineID : function() {
    					return _lineId;
    				},
    				transcode : function() {
    					return _transcode;
    				},
    				date : function() {
    					return _date;
    				},
    				times : function() {
    					return _times;
    				},
    				num : function() {
    					return _num;
    				},
    			},
    			success : function(data) {
    				var data = $.parseJSON(data);
    				$("#dateValue").html(data.dateValue);
    				$("#timeValue").html(data.timeValue);
    				$("#lineValue").html(data.lineValue);
    				$("#transcodeValue").html(data.transcodeValue);
    				$("#numValue").html(data.numValue);
    				$("#ylnumValue").html(data.ylnumValue);
    				$("#yllnumValue").html(data.yllnumValue);
    			}
    		});
    	}
       
    	
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
		        	<font class="titlefont" >北京地铁运力运量匹配图</font>
		        	<div>
		        		<span class="timefont" style="" id="showTime"></span>
		        	</div>
            </div>
        <!-- 选择标题框 -->
        <div class="titledivr righttable">
         		    控制台
        </div>
 	<from id="form">
         <div class="tabledivr righttable" style="margin-top: 220px;">
         	<input type="hidden" name="showTime" id="showTime">
         		<div style="width: 220px; font-size: 20px;margin-left: 10px;">选择运行日期：<input type="date" id="data" name="data" style="width: 200px;color: #6abdf8; text-align:center;"></div>  
         		<div style="width: 220px; font-size: 20px;margin-left: 10px;">选择运行线路：
	         		<select name = "lineId" id="lineId" style="background-color:#052033; color:#6abdf8;width: 200px;"onchange="changeLine()">
	         			<option style="color:#6abdf8" value="ALL" selected="selected">全路网</option>
	         			<option value="1">1号线</option>
	         			<option value="2">2号线</option>
	         			<option value="5">5号线</option>
	         			<option value="20">6号线</option>
	         			<option value="16">7号线</option>
	         			<option value="7">8号线</option>
	         			<option value="13">9号线</option>
	         			<option value="6">10号线</option>
	         			<option value="3">13号线</option>
	         			<option value="9">15号线</option>
	         			<option value="4">八通线</option>
	         		    <option value="8">机场线</option>
	         			<option value="10">昌平线</option>
	         			<option value="11">亦庄线</option>
	         			<option value="12">房山线</option>
         			</select>
         		</div>  
         		<div style="width: 220px; font-size: 20px;margin-left: 10px;">选择运行图号：
         			<select name = "transcode" id="transcode" style="width: 200px">
         				
         			</select>
         		</div>  
         		<div style="float:right; border-left:3px dashed #0c56a3; width: 250px;height: 215px;margin-top: -222px;">
         			<div style="width: 220px; font-size: 20px;margin-left: 10px;">运行时间：
         				<select id="times" name="times" style="background-color:#052033; color:#6abdf8;width: 200px;">
		         			<option style="color:#6abdf8" value="defaut">全天</option>
		         			<option value="05:30">5:30</option>
		         			<option value="06:00">6:00</option>
		         			<option value="06:30">6:30</option>
		         			<option value="07:00">7:00</option>
		         			<option value="07:30">7:30</option>
		         			<option value="08:00">8:00</option>
		         			<option value="08:30">8:30</option>
		         			<option value="09:00">9:00</option>
		         			<option value="09:30">9:30</option>
		         			<option value="10:00">10:00</option>
		         			<option value="10:30">10:30</option>
		         			<option value="11:00">11:00</option>
		         			<option value="11:30">11:30</option>
		         			<option value="12:00">12:00</option>
		         			<option value="12:30">12:30</option>
		         			<option value="13:00">13:00</option>
		         			<option value="13:30">13:30</option>
		         			<option value="14:00">14:00</option>
		         			<option value="14:30">14:30</option>
		         			<option value="15:00">15:00</option>
		         			<option value="15:30">15:30</option>
		         			<option value="16:00">16:00</option>
		         			<option value="16:30">16:30</option>
		         			<option value="17:00">17:00</option>
		         			<option value="17:30">17:30</option>
		         			<option value="18:00">18:00</option>
		         			<option value="18:30">18:30</option>
		         			<option value="19:00">19:00</option>
		         			<option value="19:30">19:30</option>
		         			<option value="20:00">20:00</option>
		         			<option value="20:30">20:30</option>
		         			<option value="21:00">21:00</option>
		         			<option value="21:30">21:30</option>
		         			<option value="22:00">22:00</option>
		         			<option value="22:30">22:30</option>
		         			<option value="23:00">23:00</option>
		         			<option value="23:30">23:30</option>
	         			</select>
         			</div>  
         		    <div style="width: 220px; font-size: 20px;margin-left: 10px;">车数：
	         		    <input type="text" style="color:#6abdf8 " name="num" id="num">
         			</div>  
         		</div>
         </div>
         <!-- 显示信息面板 -->
         <div class="msgDiv">
         	<div style="font-size: 20px;color:#6abdf8 ">信息说明</div>
         	<table style="color: #6abdf8;margin: 10px;text-align: left;">
         		<tr>
         			<td colspan="3">图列说明：</td>
         			<td>红色：表示运量是运力的2倍;</td>
         		</tr>
         		<tr>
         			<td colspan="3"></td>
         			<td>黄色：运量是运力1倍到2倍之间;</td>
         		</tr>
         		<tr>
         			<td colspan="3"></td>
         			<td>绿色：运量小于运力</td>
         		</tr>
         	</table>
         	<div style="border-top: 3px dashed #0c56a3; margin-left:10px;width: 470px;height: 245px;">
         		<table style="color: #6abdf8;margin: 10px;text-align: left;width: 400px;height: 120px;">
         			<tr>
         				<td>日期：</td>
         				<td><span id="dateValue">2017-08-22</span></td>
         				<td>时间：</td>
         				<td><span id="timeValue">05:00</span></td>
         			</tr>
         			<tr>
         				<td>线路：</td>
         				<td><span id="lineValue">全路网</span></td>
         				<td>图号：</td>
         				<td><span id="transcodeValue"></span></td>
         			</tr>
         			<tr>
         				<td>车数：</td>
         				<td><span id="numValue">0</span></td>
         				<td>运力：</td>
         				<td><span id="ylnumValue">0</span></td>
         			</tr>
         			<tr>
         				<td>运量：</td>
         				<td><span id="yllnumValue">0</span></td>
         				<td></td>
         				<td></td>
         			</tr>
         		</table>
         	</div>
         </div>
         
      </from>
      
       <div class="leftivr lefttable1">
       <a style="color: #6abdf8;padding: 0PX 135PX">运力运量分线展示图一</a>
           <iframe src="http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?reportlet=gis_ylyl_one.cpt" width=420px; height=80%; scrolling="no"; frameborder=0; style="margin:10px 0px 0px 10px;">
        	</iframe>
        </div>
        <div class="leftivr lefttable2">
        <a style="color: #6abdf8;padding: 0PX 135PX">运力运量分线展示图二</a>
        <iframe src="http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?reportlet=gis_ylyl_two.cpt" width=420px; height=80%; scrolling="no"; frameborder=0; style="margin:10px 0px 0px 10px;">
        	</iframe>
        </div>
        <div class="leftivr lefttable3">
        <a style="color: #6abdf8;padding: 0PX 135PX">运力运量分线展示图三</a>
        <iframe src="http://finereport.bjdt.bmzymtr.com:30001/webreport/ReportServer?reportlet=gis_ylyl_three.cpt" width=420px; height=80%; scrolling="no"; frameborder=0; style="margin:10px 0px 0px 10px;">
        	</iframe>
        </div>
      
         <!-- 显示主体 -->
        	<iframe id="myframe" src="http://finereport.bjdt.bmzymtr.com:30001/WebReport/report/echartsbjyl" width=100%; height=100%; frameborder=0;  scrolling="no"></iframe>
        </div>
        
</body>
</html>