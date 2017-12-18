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
<script src="${contextPath}/static/echarts/js/echarts.min.js"></script>
<script src="${contextPath}/static/echarts/js/beijing.js"></script>
<script src="${contextPath}/static/echarts/js/china.js"></script>
<script src="${contextPath}/static/echarts/bmap/bmap.min.js"></script>
<script src="${contextPath}/static/echarts/bmap/dat.gui.min.js"></script>
<script src="${contextPath}/static/echarts/bmap/run.js"></script>
<script
	src="http://api.map.baidu.com/api?v=2.0&ak=K2wudWFupVkZyz3IfNgGr1NBtHOVWH8F"></script>


</head>
<body>
<style>
.anchorBL{ 
display:none; 
} 
</style>
	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->

	<div id="main" style="width: 1900px; height: 1070px;"></div>

	<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('main'));
    var myChart = document.getElementById('main');
//点

	/************************************************************/

	
	    // 首先获取serie
    var myChart;
    var test = 10;
	var databtn;
	var geoCoordMap;
	
	var datajobbtn;
	var datajobbtnValue;
	var geoCoordjobMap;
	
	
	//
	
	$.ajax({
		type : "POST",
		datatype : "json",
		async : false,
		url :"${contextPath}/gis/enerflow",
		success : function(data) {
			var data = $.parseJSON(data);
			datajobbtn = eval('(' + data.value + ')');
			datajobbtnValue = eval('(' + data.value + ')');
			geoCoordjobMap = eval('(' + data.station + ')');
		}
	});
	
	var jobData = function(datajobbtn) {
	    var res = [];
	    for (var i = 0; i < datajobbtn.length; i++) {
	        var geoCoord = geoCoordjobMap[datajobbtn[i].name];
	        if (geoCoord) {
	            res.push({
	                name: datajobbtn[i].name,
	                value: geoCoord.concat(datajobbtn[i].value,datajobbtn[i].valueshow,datajobbtn[i].valuein,datajobbtn[i].valueout),
	            });
	        }
	    }
	    return res;
	};
	
	
	
	var convertedjobData = [
		jobData(datajobbtn),
		jobData(datajobbtn.sort(function(a, b) {
	        return b.value - a.value;
	    }).slice(0, 6))
	];
	
	datajobbtn.sort(function(a, b) {
	    return a.value - b.value;
	})
 //----end
	
	$.ajax({
		type : "POST",
		datatype : "json",
		async : false,
		url :"${contextPath}/gis/enerflow2",
		success : function(data) {
			var data = $.parseJSON(data);
			databtn = eval('(' + data.value + ')');
			geoCoordMap = eval('(' + data.station + ')');
			}
	});
	
	
		var convertData = function(databtn,datajobbtnValue) {
			if(datajobbtnValue != null){
			    var res = [];
			    for (var i = 0; i < databtn.length; i++) {
			        var only = true;
			        var geoCoord = geoCoordMap[databtn[i].name];
			    	for(var j=0;j < datajobbtnValue.length; j++){
			    		if(databtn[i].name == datajobbtnValue[j].name){
			    			 res.push({
					                name: databtn[i].name,
					                value: geoCoord.concat(databtn[i].value,databtn[i].valueshow,databtn[i].valuein,databtn[i].valueout,datajobbtnValue[j].value),
					          });
			    		}else{
			    			if(only){
						        if (geoCoord) {
						            res.push({
						                name: databtn[i].name,
						                value: geoCoord.concat(databtn[i].value,databtn[i].valueshow,databtn[i].valuein,databtn[i].valueout,0),
						            });
						            only = false;
						        }
			    			}
			    		}
			    	}
			    }
			    return res;
			}
		};
		var convertedData = [
		    convertData(databtn,datajobbtnValue),
		    convertData(databtn.sort(function(a, b) {
		        return b.value - a.value;
		    }).slice(0, 6))
		];
		
		databtn.sort(function(a, b) {
		    return a.value - b.value;
		})

		
		
		
		var selectedItems = [];
		var categoryData = [];
		var barData = [];
		//   var maxBar = 30;
		var sum = 0;
		var count = databtn.length;
		for (var i = 0; i < databtn.length; i++) {
		    categoryData.push(databtn[i].name);
		    barData.push(databtn[i].value);
		    sum += databtn[i].value;
		}
		console.log(categoryData);
		console.log(sum + "   " + count)

		function renderBrushed(params) {
		    var mainSeries = params.batch[0].selected[0];

		    var selectedItems = [];
		    var categoryData = [];
		    var barData = [];
		    var maxBar = 30;
		    var sum = 0;
		    var count = 0;

		    for (var i = 0; i < mainSeries.dataIndex.length; i++) {
		        var rawIndex = mainSeries.dataIndex[i];
		        var dataItem = convertedData[0][rawIndex];
		        var pmValue = dataItem.value[2];

		        sum += pmValue;
		        count++;

		        selectedItems.push(dataItem);
		    }

		    selectedItems.sort(function(a, b) {
		        return a.value - b.value;
		    });

		    for (var i = 0; i < Math.min(selectedItems.length, maxBar); i++) {
		        categoryData.push(selectedItems[i].name);
		        barData.push(selectedItems[i].value[2]);
		    }
		}
		
		var schema = [
		    {name: 'date', index: 0},
		    {name: '设备数量', index: 1, text: '外部电量'},
		    {name: '工单数量', index: 2, text: '牵引电量'},
		];
    
  //自适应宽高
//  var myChartContainer = function () {
  //    myChart.style.width = window.innerWidth+'px';
  //    myChart.style.height = window.innerHeight+'px';
  //};
  
  //myChartContainer();
  var myChart = echarts.init(myChart);
  //浏览器大小改变时重置大小
 // window.onresize = function () {
   //  myChartContainer();
  //   myChart.resize();
 //};

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
    	            coords: points,
    	            lineStyle: {
    	                normal: {
    	                    color: echarts.color.modifyHSL('#5A94DF', Math.round(hStep * idx))
    	                }
    	            }
    	        };
    	    }));
    	var option = {
     	        bmap: {
     	            center: [116.45, 39.945],
     	            zoom: 12,
     	            roam: true,
     	            label: {
     	                emphasis: {
     	                    show: false
     	                }
     	            },
     	            roam: true,
     	            itemStyle: {
     	                normal: {
     	                    areaColor: '#323c48',
     	                    borderColor: '#111'
     	                },
     	                emphasis: {
     	                    areaColor: '#2a333d'
     	                }
     	            },
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
     	       visualMap: [{
   	            type: "piecewise",
   	            left: '20%',
   	            bottom : '5%',
   	            min: 1,
   	            max: 17,
   	            splitNumber: 15,
   	            maxOpen: true,
   	         	textStyle: {
   	          	  color: '#fff',
   	          	  fontSize:'5',
   	        	},
	   	        pieces: [
	   	        	{value: 16, label: '1号线',   color: '#FF5151'}, // 表示 value 等于 123 的情况。
	   	        	{value: 15, label: '2号线',   color: '#0000E3'}, // 表示 value 等于 123 的情况
	   	        	{value: 14, label: '5号线',   color: '#9F4D95'}, // 表示 value 等于 123 的情况
	   	        	{value: 13, label: '6号线',   color: '#FF8000'}, // 表示 value 等于 123 的情况
	   	        	{value: 12, label: '7号线',  color: '#FF8EFF'}, // 表示 value 等于 123 的情况
	   	        	{value: 11, label: '8号线',   color: '#01B468'}, // 表示 value 等于 123 的情况
	   	        	{value: 10, label: '9号线',  color: '#A8FF24'}, // 表示 value 等于 123 的情况
	   	        	{value: 9, label: '10号线',  color: '#2894FF'}, // 表示 value 等于 123 的情况
	   	        	{value: 8, label: '13号线', color: '#FFFF37'}, // 表示 value 等于 123 的情况
	   	        	{value: 7, label: '15号线', color: '#FF5809'}, // 表示 value 等于 123 的情况
	   	        	{value: 6, label: '八通线',  color: '#FF5151'}, // 表示 value 等于 123 的情况
	   	        	{value: 5, label: '亦庄线',  color: '#00FFFF'}, // 表示 value 等于 123 的情况
	   	        	{min:3,max:4, label: '机场线',  color: '#CA8EFF'}, // 表示 value 等于 123 的情况
	   	        	{value: 2, label: '昌平线', color: '#AE00AE'}, // 表示 value 等于 123 的情况
	   	        	{value: 1, label: '房山线', color: '#FF5151'}, // 表示 value 等于 123 的情况
	   	      ],	
	   	      target: {
		            outOfRange: {
		            	 type: 'effectScatter',
		            	 data: convertedData[0],
		                 shadowBlur: 100,
 		                 shadowColor: '#FFF'
		            },
		            inRange: {
    	   	        	color: ['#1cff00', '#1cff00'],
    	          },
		        },
   	        }],
   	        
     	       tooltip: {
     	          padding: 10,
     	          backgroundColor: '#222',
     	          borderColor: '#777',
     	          borderWidth: 1,
     	          formatter: function (obj) {
     	              var value = obj.value;
     	              return '<div style="border-bottom: 1px solid rgba(255,255,255,.3); font-size: 18px;padding-bottom: 7px;margin-bottom: 7px">'
     	                  + obj.seriesName + ' ' + obj.name 
     	                  + '</div>'
     	                  + schema[1].text + '：' + value[3] + '<br>' 
     	                  + schema[2].text + '：' + value[6] + '<br>' ;
     	          }
     	         },
     	        series: [{
     	        	id   : 'exSeries',
     	            type: 'lines',
     	            coordinateSystem: 'bmap',
     	            polyline: true,
     	            data: busLines,
     	            silent: true,
     	            lineStyle: {
     	                normal: {
     	                    width: 5
     	                },
     	               emphasis: {
    	                    width: 5
    	                }
     	            },
     	           effect: {
    	                show: true,
    	                symbolSize: 4,
    	            },
     	            progressiveThreshold: 500,
     	            progressive: 200
     	        },{
     		        // name: 'Top 5',
     		        type: 'scatter',
     		        coordinateSystem: 'bmap',
     		        data: convertedData[0],
     		        symbolSize: function(val) {
     		            return Math.max(val[2], 8);
     		        },
     		       inRange: {
   	   	        	color: ['#f4e925', 'red'],
   	            	},
     		        showEffectOn: 'render',
     		        rippleEffect: {
     		            brushType: 'stroke'
     		        },
     		        hoverAnimation: true,
     		        itemStyle: {
     		            normal: {
     		                color: '#1cff00',//#f4e925 28,255,0
     		                shadowBlur: 100,
     		                shadowColor: '#FFF'
     		            }
     		        },
     		        zlevel: 2
     		    },{
     		        // name: 'Top 5',
     		        type: 'effectScatter',
     		        coordinateSystem: 'bmap',
     		        data: convertedjobData[0],
     		        symbolSize: function(val) {
     		            return Math.max(val[2], 8);
     		        },
     		       inRange: {
   	   	        	color: ['#f4e925', 'red'],
   	            	},
     		        showEffectOn: 'render',
     		        rippleEffect: {
     		            brushType: 'stroke'
     		        },
     		        hoverAnimation: true,
     		        itemStyle: {
     		            normal: {
     		                color: '#F00',//#f4e925
     		                shadowBlur: 100,
     		                shadowColor: '#FFF'
     		            }
     		        },
     		        zlevel: 2
     		    }]
     	    }
    	    myChart.setOption(option);
    	});
    
    
    function refreshData(data){
        if(!myChart){
             return;
        }
        //更新数据
         var option = myChart.getOption();
         option.series[1].data = data;   
         myChart.setOption(option);    
   }
   </script>
</body>
</html>