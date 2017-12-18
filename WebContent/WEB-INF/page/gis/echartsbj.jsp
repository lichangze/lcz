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
<script src="${contextPath}/static/echarts/bmap/loadIframeScripts.js"></script>
<script src="${contextPath}/static/echarts/bmap/run.js"></script>
<script src="http://api.map.baidu.com/api?v=2.0&ak=K2wudWFupVkZyz3IfNgGr1NBtHOVWH8F"></script>


</head>
<body>

	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->



    <div id="main" style="width:3000px;height:1000px;"></div>

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

    $.getJSON("${contextPath}/static/echarts/json/line_bus.txt", function(data) {
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
     	                      }
     	                    ]
     	                  }
     	        },
     	       visualMap: {
     	            type: "piecewise",
     	            left: 'left',
     	            min: 1,
     	            max: 17,
     	            splitNumber: 15,
     	            maxOpen: true,
     	            color: ['red', 'yellow', 'green','#FF0000','#2828FF','#FFD306','#00EC00','#AD5A5A','#28FF28','#46A3FF','#F00078','#E800E8','#BE77FF','#FF5809','#AE57A4'],
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
     	                    width: 5,
                             lineStyle:{  
                                 color:'#00FF00'  
                             }  
     	                },
     	               emphasis: {
     	                    width: 6
     	                }
     	            },
     	           effect: {
     	                show: true,
     	                symbolSize: 4,
     	                color: "white"
     	            },
     	            progressiveThreshold: 500,
     	            progressive: 200
     	        }],
     	    };
    	    myChart.setOption(option);
    	});
    
   </script>
</body>
</html>