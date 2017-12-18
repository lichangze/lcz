<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<script src="${contextPath}/static/js/jquery.js"></script>
<script src="${contextPath}/static/echarts/js/echarts.js"></script>
<script src="${contextPath}/static/echarts/js/beijing.js"></script>
<script src="${contextPath}/static/echarts/js/beijing.js"></script>
<script src="${contextPath}/static/echarts/bmap/bmap.min.js"></script>
<script src="${contextPath}/static/echarts/bmap/dat.gui.min.js"></script>
<script src="${contextPath}/static/echarts/bmap/run.js"></script>
<script
	src="http://api.map.baidu.com/api?v=2.0&ak=K2wudWFupVkZyz3IfNgGr1NBtHOVWH8F"></script>


<link rel="stylesheet" href="${contextPath}/static/timeLiner/index.css">
	
<script src="${contextPath}/static/timeLiner/js/jquery.min.js"></script>
<script src="${contextPath}/static/timeLiner/js/index.js"></script>
<style type="text/css">
.tablediv {
	position: absolute;
	width:90%;
	background-color: rgba(56, 134, 160, 0);
	z-index: 1;
	margin-top: 1000px;
}
body{
	margin: 0;
}
.anchorBL {
	display: none;
}
</style>

</head>
<body>
<script type="text/javascript">
function progressTimeControl(img) {
    if ($(img).attr("title") == "暂停") {
        $(img).attr("title", "开始");
        $(img).css("background-image", "url(${contextPath}/static/timeLiner/img/play.png)");
        window.clearInterval(_mProgressTimer);
        stopTime();
    }else {
        $(img).attr("title", "暂停");
        $(img).css("background-image", 'url(${contextPath}/static/timeLiner/img/pause.png)');
        _mProgressTimer = window.setInterval(function () {
            if (_index <= ScrollBar.maxValue) {
                _index += 1;
                ScrollBar.SetValue(_index);
                SetTime(_index)
            }else {
                progressTimeStop()
            }
        }, _speed);
        startMap();
    }
}
</script>
	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
	<div class="box tablediv">
	<input type="hidden" id="path" value="<%= request.getContextPath() %>">
        <div id="progressTime_control" onclick="progressTimeControl(this)" title="开始"></div>
        <div class="progressTime" id="progressTime" style="z-index:9">
            <div>
                <p id="startTime" style=" float:left;margin-left:33px;opacity: 0;display: none;"></p>
                <p  id="endTime" style=" float:right;margin-right:33px;opacity: 0;display: none;"></p>
            </div>
            <div class="time_slot">
                <p>06</p>
                <p>07</p>
                <p>08</p>
                <p>09</p>
                <p>10</p>
            </div>
            <div id="progressTime_concent">
                <div id="scrollBarBox">
                    <div id="scrollBar">
                        <div id="scroll_Track"></div>
                        <div id="scroll_Thumb"></div>
                    </div>
                </div>
                <div class="timecode"></div>
                <div style="width:90%; margin-left: auto;margin-right: auto;">
                    <div style="width:300px;float:right;margin-right:-110px;margin-top:-8px">
                    <p id="TimeSpeed" style="float:left;margin-right:40px;display:none">×1</p>
                    <p style="float:right" id="scrollBarTxt"></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
	<div id="main" style="width: 3000px; height: 1000px;"></div>

	<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('main'));
    var myChart = document.getElementById('main');
//点

		
    
  //自适应宽高
  var myChartContainer = function () {
      myChart.style.width = window.innerWidth+'px';
      myChart.style.height = window.innerHeight+'px';
  };
  
  myChartContainer();
  var myChart = echarts.init(myChart);
  //浏览器大小改变时重置大小
  window.onresize = function () {
     myChartContainer();
     myChart.resize();
 };

    $.getJSON("${contextPath}/gisyl/gisflow", function(data) {
    	 var hStep = 300 / (data.length - 1);
    	 var busLines = [].concat.apply([], data.map(function (busLine, idx) {
    	        var prevPt;
    	        var points = [];
    	        var value = busLine.shift();
    	        for (var i = 0; i < busLine.length; i += 2) {
    	            var pt = [busLine[i], busLine[i + 1]];
    	            if (i > 0) {
    	                pt = [
    	                    prevPt[0] + pt[0],
    	                    prevPt[1] + pt[1]
    	                ];
    	            }
    	            prevPt = pt;
    	            points.push([pt[0] / 1e4, pt[1] / 1e4]);
    	        }
    	        return {
    	        	value: value,
    	            coords: points
    	        };
    	    }));
    	 
    	var  option = {
     	        bmap: {
     	            center: [116.46, 39.92],
     	            zoom: 12,
     	           label: {
    	                emphasis: {
    	                    show: false
    	                }
    	            },
     	            roam: true,
     	            	mapStyle: {
     	                    'styleJson': [
     	                      {
     	                        'featureType': 'water',
     	                        'elementType': 'all',
     	                        'stylers': {
     	                          'color': '#031628'
     	                        }
     	                      },
     	                      {
     	                        'featureType': 'land',
     	                        'elementType': 'geometry',
     	                        'stylers': {
     	                          'color': '#000102'
     	                        }
     	                      },
     	                      {
     	                        'featureType': 'highway',
     	                        'elementType': 'all',
     	                        'stylers': {
     	                          'visibility': 'off'
     	                        }
     	                      },
     	                      {
     	                        'featureType': 'arterial',
     	                        'elementType': 'geometry.fill',
     	                        'stylers': {
     	                          'color': '#000000'
     	                        }
     	                      },
     	                      {
     	                        'featureType': 'arterial',
     	                        'elementType': 'geometry.stroke',
     	                        'stylers': {
     	                          'color': '#0b3d51'
     	                        }
     	                      },
     	                      {
     	                        'featureType': 'local',
     	                        'elementType': 'geometry',
     	                        'stylers': {
     	                          'color': '#000000'
     	                        }
     	                      },
     	                      {
     	                        'featureType': 'railway',
     	                        'elementType': 'geometry.fill',
     	                        'stylers': {
     	                          'color': '#000000'
     	                        }
     	                      },
     	                      {
     	                        'featureType': 'railway',
     	                        'elementType': 'geometry.stroke',
     	                        'stylers': {
     	                          'color': '#08304b'
     	                        }
     	                      },
     	                      {
     	                        'featureType': 'subway',
     	                        'elementType': 'geometry',
     	                        'stylers': {
     	                          'lightness': -70
     	                        }
     	                      }, {
     	                         'featureType': 'subway',
     	                        'elementType': 'all',
     	                        'stylers': {
     	                            'visibility': 'off'
     	                        }
     	                    },
     	                      {
     	                        'featureType': 'building',
     	                        'elementType': 'geometry.fill',
     	                        'stylers': {
     	                          'color': '#000000'
     	                        }
     	                      },
     	                      {
     	                        'featureType': 'all',
     	                        'elementType': 'labels.text.fill',
     	                        'stylers': {
     	                          'color': '#857f7f'
     	                        }
     	                      },
     	                      {
     	                        'featureType': 'all',
     	                        'elementType': 'labels.text.stroke',
     	                        'stylers': {
     	                          'color': '#000000'
     	                        }
     	                      },
     	                      {
     	                        'featureType': 'building',
     	                        'elementType': 'geometry',
     	                        'stylers': {
     	                          'color': '#022338'
     	                        }
     	                      },
     	                      {
     	                        'featureType': 'green',
     	                        'elementType': 'geometry',
     	                        'stylers': {
     	                          'color': '#062032'
     	                        }
     	                      },
     	                      {
     	                        'featureType': 'boundary',
     	                        'elementType': 'all',
     	                        'stylers': {
     	                          'color': '#465b6c'
     	                        }
     	                      },
     	                      {
     	                        'featureType': 'manmade',
     	                        'elementType': 'all',
     	                        'stylers': {
     	                          'color': '#022338'
     	                        }
     	                      },
     	                      {
     	                        'featureType': 'label',
     	                        'elementType': 'all',
     	                        'stylers': {
     	                          'visibility': 'off'
     	                        }
     	                      }, {
     	                         'featureType': 'poi',
     	                        'elementType': 'all',
     	                        'stylers': {
     	                            'visibility': 'off'
     	                        }
     	                    }
     	                    ]
     	                  }
     	        },
     	       visualMap: {
     	            type: "piecewise",
     	            left: 1260 ,
     	            bottom : '20%',
     	            min: 0,
     	            max: 2,
     	            splitNumber: 2,
     	            maxOpen: true,
     	            color: ['red', 'yellow', 'green'],
     	           textStyle: {
     	                color: '#fff'
     	            },
     	        },
     	        tooltip: {
     	            formatter: function(params, ticket, callback) {
     	                return "线路:" + params.value;
     	            },
     	            trigger: 'item'
     	        },
     	        series: [{
     	            type: 'lines',
     	            coordinateSystem: 'bmap',
     	            polyline: true,
     	            data: busLines,
     	            silent: true,
     	            lineStyle: {
     	                normal: {
     	                    opacity: 2,
     	                    width: 3,
     	                },
     	               emphasis: {
     	                    width: 0
     	                }
     	            },
     	           effect: {
     	                show: false,
     	                symbolSize: 4,
     	                color: "white"
     	            },
     	            progressiveThreshold: 500,
     	            progressive: 200
     	        }],
     	    };
    	    myChart.setOption(option);
    	});
    
    var showTime;
    //
    function startMap(){
    	showTime = window.setInterval(function () {
          parent._fshowTime = _shouTime;
          parent.initMethod();
          parent.getMsgValue();
        	$.getJSON("${contextPath}/gisyl/gisflow?showTime="+_shouTime+"&lineID="+parent._lineId+"&transcode="+parent._transcode
        			+"&date="+parent._date+"&times="+parent._times+"&num="+parent._num, function(data) {
           	 var hStep = 300 / (data.length - 1);
           	 var busLines = [].concat.apply([], data.map(function (busLine, idx) {
           	        var prevPt;
           	        var points = [];
           	        var value = busLine.shift();
           	        for (var i = 0; i < busLine.length; i += 2) {
           	            var pt = [busLine[i], busLine[i + 1]];
           	            if (i > 0) {
           	                pt = [
           	                    prevPt[0] + pt[0],
           	                    prevPt[1] + pt[1]
           	                ];
           	            }
           	            prevPt = pt;
           	            points.push([pt[0] / 1e4, pt[1] / 1e4]);
           	        }
           	        return {
           	        	value: value,
           	            coords: points
           	        };
           	    }));
        	    	refreshData(busLines);
        		})
        },_speed);
    }
    function stopTime(){
    	clearInterval(showTime);  
    }
    function refreshData(data){
        if(!myChart){
             return;
        }
        //更新数据
         var option = myChart.getOption();
         option.series[0].data = data;   
         myChart.setOption(option);    
   }
    
    
   </script>
</body>
</html>