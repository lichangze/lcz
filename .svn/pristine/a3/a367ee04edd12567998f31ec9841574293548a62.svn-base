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
<script src="http://api.map.baidu.com/api?v=2.0&ak=K2wudWFupVkZyz3IfNgGr1NBtHOVWH8F"></script>
</head>
<body>

	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main" style="width: 1000px;height:800px;"></div>
    
    <script type="text/javascript">

    function convertData(sourceData) {
        return [].concat.apply([], $.map(sourceData, function(busLine, index) {
            var prevPoint = null;
            var points = [];
            var value = busLine.shift();
            for (var i = 0; i < busLine.length; i += 2) {
                var point = [busLine[i], busLine[i + 1]];
                if (i > 0) {
                    point = [
                        prevPoint[0] + point[0],
                        prevPoint[1] + point[1]
                    ];
                }
                prevPoint = point;
                points.push([point[0] / 1e5, point[1] / 1e5]);
            }
            return {
                value: value,
                coords: points
            };
        }));
    }

    var option = {
        bmap: {
            roam: true
        },
        visualMap: {
            type: "piecewise",
            left: 'right',
            min: 0,
            max: 20,
            splitNumber: 5,
            maxOpen: true,
            color: ['red', 'yellow', 'green']
        },
        tooltip: {
            formatter: function(params, ticket, callback) {
                return "拥堵指数:" + params.value;
            },
            trigger: 'item'
        },
        series: [{
            type: 'lines',
            coordinateSystem: 'bmap',
            polyline: true,
            lineStyle: {
                normal: {
                    opacity: 1,
                    width: 4
                },
                emphasis: {
                    width: 6
                }
            },
            effect: {
                show: true,
                symbolSize: 2,
                color: "white"
            }
        }]
    };

    $.getJSON('${contextPath}/static/echarts/json/linejx.txt', function(rawData) {
    	var myChart = echarts.init(document.getElementById('main'));
        option.series[0].data = convertData(rawData);
        myChart.setOption(option);
        console.log(option);
        //获取echart中使用的bmap实例
        var map = myChart.getModel().getComponent('bmap').getBMap();
        map.disableDoubleClickZoom();
        map.centerAndZoom("嘉兴", 13);

    });
    
   </script>
</body>
</html>