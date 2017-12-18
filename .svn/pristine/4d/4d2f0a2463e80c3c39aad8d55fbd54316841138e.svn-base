<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<!-- ajax layout which only needs content area -->
<div class="row">
	<div class="col-xs-12">

		<div class="row">

			<div class="col-sm-12">
				<!-- #section:pages/dashboard.infobox -->
				<div class="widget-box transparent" id="recent-box">
					<div class="widget-header">
						<h4 class="widget-title lighter smaller">
							<i class="ace-icon fa fa-rss orange"></i>最新
						</h4>

						<div class="widget-toolbar no-border">
							<ul class="nav nav-tabs" id="recent-tab">
								<li><a data-toggle="tab" href="#task-tab">工单</a>
								</li>

								<li><a data-toggle="tab" href="#member-tab">通知 <span class="badge badge-danger">8</span></a></li>

								<li  class="active"><a data-toggle="tab" href="#comment-tab">待办<span class="badge badge-danger">11</span></a></li>
							</ul>
						</div>
					</div>

					<div class="widget-body">
						<div class="widget-main padding-4">
							<div class="tab-content padding-8">
								<div id="task-tab" class="tab-pane">
									<!-- #section:pages/dashboard.tasks -->
									<ul id="tasks" class="item-list">
										<li class="item-green clearfix"><label class="inline">
												<span class="lbl">已完成</span>
										</label>

											<div class="pull-right easy-pie-chart percentage"
												data-size="30" data-color="green" data-percent="100">
												<span class="percent">5</span>
											</div></li>


										<li class="item-blue clearfix"><label class="inline">
												<span class="lbl">已接工单</span>
										</label>
											<div class="pull-right easy-pie-chart percentage"
												data-size="30" data-color="blue" data-percent="100">
												<span class="percent">8</span>
											</div></li>

										<li class="item-grey clearfix"><label class="inline">
												<span class="lbl">未接工单</span>
										</label>
											<div class="pull-right easy-pie-chart percentage"
												data-size="30" data-color="grey" data-percent="100">
												<span class="percent">3</span>
											</div></li>


									</ul>

									<!-- /section:pages/dashboard.tasks -->
								</div>

								<div id="member-tab" class="tab-pane">
									<!-- 通知内容 -->
								</div>
								<!-- /.#member-tab -->

								<div id="comment-tab" class="tab-pane active">
									<!-- #section:pages/dashboard.comments -->
									<div class="comments">
										<div class="itemdiv commentdiv">
											<div class="user">
												<img alt="Bob Doe's Avatar"
													src="${contextPath}/static/assets/avatars/avatar.png" />
											</div>

											<div class="body">
												<div class="name">
													<a href="#">李秀峰</a>
												</div>

												<div class="time">
													<i class="ace-icon fa fa-clock-o"></i> <span class="green">6
														min</span>
												</div>

												<div class="text">
													<a href="#">工单(NO:RN-20150817001209)机车B2检修(7~8月)已完成,请确认。 </a>
												</div>
											</div>

							
										</div>

										<div class="itemdiv commentdiv">
											<div class="user">
												<img alt="Jennifer's Avatar"
													src="${contextPath}/static/assets/avatars/avatar.png" />
											</div>

											<div class="body">
												<div class="name">
													<a href="#">王思恩</a>
												</div>

												<div class="time">
													<i class="ace-icon fa fa-clock-o"></i> <span class="blue">15
														min</span>
												</div>

												<div class="text">
													<a href="#">故障(NO:WN-20150820001238)L01果园站屏蔽门故障，请确认。</a>
													
												</div>
											</div>

										
										</div>

										<div class="itemdiv commentdiv">
											<div class="user">
												<img alt="殷华政"
													src="${contextPath}/static/assets/avatars/avatar.png" />
											</div>

											<div class="body">
												<div class="name">
													<a href="#">殷华政</a>
												</div>

												<div class="time">
													<i class="ace-icon fa fa-clock-o"></i> <span class="orange">22
														min</span>
												</div>

												<div class="text">
													<a href="#">故障(NO:WN-20150820009012)L01果园站广告牌灯不亮，请确认。</a>
												</div>
											</div>

											
										</div>

										<div class="itemdiv commentdiv">
											<div class="user">
												<img alt="张傲天"
													src="${contextPath}/static/assets/avatars/avatar2.png" />
											</div>

											<div class="body">
												<div class="name">
													<a href="#">张傲天</a>
												</div>

												<div class="time">
													<i class="ace-icon fa fa-clock-o"></i> <span class="red">50
														min</span>
												</div>

												<div class="text">
												<a href="#">工单(NO:RN-20150817001245)机车1002转向架更换,请确认。 </a>
												</div>
											</div>

											
										</div>
									</div>

									<div class="hr hr8"></div>

									<div class="center"> <a href="#" class="btn btn-sm btn-white btn-info">
											查看所有 &nbsp; <i class="ace-icon fa fa-arrow-right"></i>
										</a>
									</div>

									<div class="hr hr-double hr8"></div>

									<!-- /section:pages/dashboard.comments -->
								</div>
							</div>
						</div>
						<!-- /.widget-main -->
					</div>
					<!-- /.widget-body -->
				</div>
				<!-- /.widget-box -->
				<!-- /section:pages/dashboard.infobox.dark -->
			</div>

			
			<!-- /.col -->
		</div>
		<!-- /.row -->

	

		<!-- /section:custom/extra.hr -->
		<div class="row">
			<div class="col-sm-4">
			<div class="widget-box">
					<div class="widget-header widget-header-flat widget-header-small">
						<h5 class="widget-title">
							<i class="ace-icon fa fa-pie-chart"></i> 设备情况
						</h5>

						<div class="widget-toolbar no-border">
							<div class="inline dropdown-hover">
								<button class="btn btn-minier btn-primary">
									本周 <i
										class="ace-icon fa fa-angle-down icon-on-right bigger-110"></i>
								</button>

								<ul
									class="dropdown-menu dropdown-menu-right dropdown-125 dropdown-lighter dropdown-close dropdown-caret">
									<li class="active"><a href="#" class="blue"> <i
											class="ace-icon fa fa-caret-right bigger-110">&nbsp;</i> 本周
									</a></li>

									<li><a href="#"> <i
											class="ace-icon fa fa-caret-right bigger-110 invisible">&nbsp;</i>
											上周
									</a></li>

									<li><a href="#"> <i
											class="ace-icon fa fa-caret-right bigger-110 invisible">&nbsp;</i>
											本月
									</a></li>

									<li><a href="#"> <i
											class="ace-icon fa fa-caret-right bigger-110 invisible">&nbsp;</i>
											上月
									</a></li>
								</ul>
							</div>
						</div>
					</div>

					<div class="widget-body">
						<div class="widget-main">
							<!-- #section:plugins/charts.flotchart -->
							<div id="piechart-placeholder"></div>

							<!-- /section:plugins/charts.flotchart -->
							<div class="hr hr8 hr-double"></div>

							<div class="clearfix">
								<!-- #section:custom/extra.grid -->
								<div class="grid3">
									<span class="grey"> &nbsp; 正常 </span>
									<h4 class="bigger pull-right">1,255</h4>
								</div>

								<div class="grid3">
									<span class="grey"> &nbsp; 故障 </span>
									<h4 class="bigger pull-right">359</h4>
								</div>

								<div class="grid3">
									<span class="grey"> &nbsp; 维修 </span>
									<h4 class="bigger pull-right">179</h4>
								</div>

								<!-- /section:custom/extra.grid -->
							</div>
						</div>
						<!-- /.widget-main -->
					</div>
					<!-- /.widget-body -->
				</div>
			</div>
			<!-- /.col -->

			<div class="col-sm-4">
			<div class="widget-box">
					<div class="widget-header widget-header-flat widget-header-small">
						<h5 class="widget-title">
							<i class="ace-icon fa fa-bar-chart"></i> 工单情况
						</h5>

						<div class="widget-toolbar no-border">
							<div class="inline dropdown-hover">
								<button class="btn btn-minier btn-primary">
									本周 <i
										class="ace-icon fa fa-angle-down icon-on-right bigger-110"></i>
								</button>

								<ul
									class="dropdown-menu dropdown-menu-right dropdown-125 dropdown-lighter dropdown-close dropdown-caret">
									<li class="active"><a href="#" class="blue"> <i
											class="ace-icon fa fa-caret-right bigger-110">&nbsp;</i> 本周
									</a></li>

									<li><a href="#"> <i
											class="ace-icon fa fa-caret-right bigger-110 invisible">&nbsp;</i>
											上周
									</a></li>

									<li><a href="#"> <i
											class="ace-icon fa fa-caret-right bigger-110 invisible">&nbsp;</i>
											本月
									</a></li>

									<li><a href="#"> <i
											class="ace-icon fa fa-caret-right bigger-110 invisible">&nbsp;</i>
											上月
									</a></li>
								</ul>
							</div>
						</div>
					</div>

					<div class="widget-body">
						<div class="widget-main">
							<!-- #section:plugins/charts.flotchart -->
							<div id="categories-placeholder"></div>

							<!-- /section:plugins/charts.flotchart -->
							<div class="hr hr8 hr-double"></div>

							<div class="clearfix">
								<!-- #section:custom/extra.grid -->
								<div class="grid3">
									<span class="grey"> &nbsp; 已完成 </span>
									<h4 class="bigger pull-right">5</h4>
								</div>

								<div class="grid3">
									<span class="grey"> &nbsp; 已接 </span>
									<h4 class="bigger pull-right">8</h4>
								</div>

								<div class="grid3">
									<span class="grey"> &nbsp; 未接 </span>
									<h4 class="bigger pull-right">3</h4>
								</div>

								<!-- /section:custom/extra.grid -->
							</div>
						</div>
						<!-- /.widget-main -->
					</div>
					<!-- /.widget-body -->
				</div>
			
			</div>
			<div class="col-sm-4">
			<div class="widget-box">
					<div class="widget-header widget-header-flat widget-header-small">
						<h5 class="widget-title">
							<i class="ace-icon fa fa-graduation-cap"></i> 个人资质
						</h5>

						
					</div>

					<div class="widget-body">
						<div class="widget-main">
							
<ul id="tasks" class="item-list">
										<li class="item-green clearfix"><label class="inline">
												<span class="lbl">总共拥有资质</span>
										</label>

											<div class="pull-right easy-pie-chart percentage"
												data-size="30" data-color="green" data-percent="100">
												<span class="percent">8</span>
											</div></li>


										<li class="item-blue clearfix"><label class="inline">
												<span class="lbl">将要过期资质</span>
										</label>
											<div class="pull-right easy-pie-chart percentage"
												data-size="30" data-color="blue" data-percent="20">
												<span class="percent">2</span>
										</div></li>

										


									</ul>
					
						</div>
						<!-- /.widget-main -->
					</div>
					<!-- /.widget-body -->
				</div>
			
			</div>

		</div>
		<!-- /.row -->

		<div class="hr hr32 hr-dotted"></div>

	</div>
	<!-- /.col -->
</div>
<!-- /.row -->

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
  <script src="${contextPath}/static/assets/js/excanvas.js"></script>
<![endif]-->
<script type="text/javascript">
function RtxSycn(){
	alert(1);
    try{
        var key="${rtxkey}";            //上面取到的sessionkey 
        var account="${phone}";    //用户登陆名,当然在RTX里面也要有一个一样的用户名 
        var ip="${rtxip}"; 
        var RTXCRoot = RTXAX.GetObject("KernalRoot");    //客户端SDK 
        RTXCRoot.LoginSessionKey(ip,8000,account,key); 
       }catch(e){
        alert("RTX未能成功登陆，请重试或与管理员联系！"); 
       } 
} 
	var scripts = [ null,
			"${contextPath}/static/assets/js/jquery-ui.custom.js",
			"${contextPath}/static/assets/js/jquery.ui.touch-punch.js",
			"${contextPath}/static/assets/js/jquery.easypiechart.js",
			"${contextPath}/static/assets/js/jquery.sparkline.js",
			"${contextPath}/static/assets/js/flot/jquery.flot.js",
			"${contextPath}/static/assets/js/flot/jquery.flot.pie.js",
			"${contextPath}/static/assets/js/flot/jquery.flot.resize.js",
			"${contextPath}/static/assets/js/flot/jquery.flot.categories.js",
			"${contextPath}/static/assets/js/activities-serverload.js", null ]
	$('.page-content-area')
			.ace_ajax(
					'loadScripts',
					scripts,
					function() {
						// inline scripts related to this page
						jQuery(function($) {
							$('.easy-pie-chart.percentage')
									.each(
											function() {
												var $box = $(this).closest(
														'.infobox');
												var barColor = $(this).data(
														'color')
														|| (!$box
																.hasClass('infobox-dark') ? $box
																.css('color')
																: 'rgba(255,255,255,0.95)');
												var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)'
														: '#E2E2E2';
												var size = parseInt($(this)
														.data('size')) || 50;
												$(this)
														.easyPieChart(
																{
																	barColor : barColor,
																	trackColor : trackColor,
																	scaleColor : false,
																	lineCap : 'butt',
																	lineWidth : parseInt(size / 10),
																	animate : /msie\s*(8|7|6)/
																			.test(navigator.userAgent
																					.toLowerCase()) ? false
																			: 1000,
																	size : size
																});
											})

							$('.sparkline')
									.each(
											function() {
												var $box = $(this).closest(
														'.infobox');
												var barColor = !$box
														.hasClass('infobox-dark') ? $box
														.css('color')
														: '#FFF';
												$(this)
														.sparkline(
																'html',
																{
																	tagValuesAttribute : 'data-values',
																	type : 'bar',
																	barColor : barColor,
																	chartRangeMin : $(
																			this)
																			.data(
																					'min') || 0
																});
											});

							// flot chart resize plugin, somehow manipulates default browser resize event to optimize it!
							// but sometimes it brings up errors with normal resize event handlers
							$.resize.throttleWindow = false;

							var placeholder = $('#piechart-placeholder').css({
								'width' : '90%',
								'min-height' : '150px'
							});
							var data = [ {
								label : "正常",
								data : 70,
								color : "#68BC31"
							}, {
								label : "故障",
								data : 20,
								color : "#2091CF"
							}, {
								label : "维修",
								data : 10,
								color : "#AF4E96"
							} ]
							
							function drawPieChart(placeholder, data, position) {
								$.plot(placeholder, data, {
									series : {
										pie : {
											show : true,
											tilt : 0.8,
											highlight : {
												opacity : 0.25
											},
											stroke : {
												color : '#fff',
												width : 2
											},
											startAngle : 2
										}
									},
									legend : {
										show : true,
										position : position || "ne",
										labelBoxBorderColor : null,
										margin : [ -30, 15 ]
									},
									grid : {
										hoverable : true,
										clickable : true
									}
								})
							}
							drawPieChart(placeholder, data);

							/**
							 * we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically so that's not needed actually.
							 */
							placeholder.data('chart', data);
							placeholder.data('draw', drawPieChart);
							
							$(function() {
								var placeholder2 = $('#categories-placeholder').css({
									'width' : '100%',
									'min-height' : '150px'
								});
								var data2 = [ ["已完成", 5], ["已接", 8], ["未接", 3] ];

								$.plot(placeholder2, [ data2 ], {
									series: {
										bars: {
											show: true,
											barWidth: 0.8,
											align: "center"
										}
									},
									xaxis: {
										mode: "categories",
										tickLength: 0
									},
									grid: {
										backgroundColor: { colors: [ "#fff", "#fff" ] },
										borderWidth: 0
									}
									
								});

								// Add the Flot version string to the footer

								$("#footer").prepend("Flot " + $.plot.version + " &ndash; ");
							});
							// pie chart tooltip example
							var $tooltip = $(
									"<div class='tooltip top in'><div class='tooltip-inner'></div></div>")
									.hide().appendTo('body');
							var previousPoint = null;

							placeholder.on('plothover', function(event, pos,
									item) {
								if (item) {
									if (previousPoint != item.seriesIndex) {
										previousPoint = item.seriesIndex;
										var tip = item.series['label'] + " : "
												+ item.series['percent'] + '%';
										$tooltip.show().children(0).text(tip);
									}
									$tooltip.css({
										top : pos.pageY + 10,
										left : pos.pageX + 10
									});
								} else {
									$tooltip.hide();
									previousPoint = null;
								}

							});

							
							// Android's default browser somehow is confused when tapping on label which will lead to dragging the task
							// so disable dragging when clicking on label
							var agent = navigator.userAgent.toLowerCase();
							if ("ontouchstart" in document
									&& /applewebkit/.test(agent)
									&& /android/.test(agent))
								$('#tasks').on(
										'touchstart',
										function(e) {
											var li = $(e.target).closest(
													'#tasks li');
											if (li.length == 0)
												return;
											var label = li.find('label.inline')
													.get(0);
											if (label == e.target
													|| $.contains(label,
															e.target))
												e.stopImmediatePropagation();
										});

							$('#tasks').sortable({
								opacity : 0.8,
								revert : true,
								forceHelperSize : true,
								placeholder : 'draggable-placeholder',
								forcePlaceholderSize : true,
								tolerance : 'pointer',
								stop : function(event, ui) {
									// just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
									$(ui.item).css('z-index', 'auto');
								}
							});
							$('#tasks').disableSelection();
							$('#tasks input:checkbox')
									.removeAttr('checked')
									.on(
											'click',
											function() {
												if (this.checked)
													$(this).closest('li')
															.addClass(
																	'selected');
												else
													$(this).closest('li')
															.removeClass(
																	'selected');
											});

							// show the dropdowns on top or bottom depending on window height and menu position
							$('#task-tab .dropdown-hover').on(
									'mouseenter',
									function(e) {
										var offset = $(this).offset();

										var $w = $(window)
										if (offset.top > $w.scrollTop()
												+ $w.innerHeight() - 100)
											$(this).addClass('dropup');
										else
											$(this).removeClass('dropup');
									});

							Index.initCharts(); // init activities-serverload.js's method

						})
					});
</script>
