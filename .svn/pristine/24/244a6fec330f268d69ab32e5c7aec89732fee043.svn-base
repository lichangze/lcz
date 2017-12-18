<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<link rel="stylesheet" href="${contextPath}/static/assets/css/jquery-ui.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/datepicker.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/ui.jqgrid.css" />

<div class="row">
	<div class="col-xs-12">
		<table id="grid-table"></table>

		<div id="grid-pager"></div>

		<script type="text/javascript">
			var $path_base = "${contextPath}/static";//in Ace demo this will be used for editurl parameter
		</script>

		<!-- PAGE CONTENT ENDS -->
	</div><!-- /.col -->
</div><!-- /.row -->

<!-- page specific plugin scripts -->
<script type="text/javascript">
var scripts = [ null, "${contextPath}/static/assets/js/date-time/bootstrap-datepicker.js",
                "${contextPath}/static/assets/js/date-time/locales/bootstrap-datepicker.zh-CN.js",
                "${contextPath}/static/assets/js/jqGrid/jquery.jqGrid.js",
                "${contextPath}/static/assets/js/jqGrid/i18n/grid.locale-cn.js",
                "${contextPath}/static/assets/js/jquery.bootstrap-duallistbox.js",
                "${contextPath}/static/assets/js/jquery.dataTables.js",
                "${contextPath}/static/assets/js/jquery.dataTables.bootstrap.js",null ]
      $('.page-content-area').ace_ajax('loadScripts', scripts, function() {
      	// inline scripts related to this page
      	jQuery(function($) {
      		var grid_selector = "#grid-table";
      		var pager_selector = "#grid-pager";

        		// resize to fit page size
        		$(window).on('resize.jqGrid', function() {
        			$(grid_selector).jqGrid('setGridWidth', $(".page-content").width());
        		})
        		// resize on sidebar collapse/expand
        		var parent_column = $(grid_selector).closest('[class*="col-"]');
        		$(document).on('settings.ace.jqGrid', function(ev, event_name, collapsed) {
        			if (event_name === 'sidebar_collapsed' || event_name === 'main_container_fixed') {
        				// setTimeout is for webkit only to give time for DOM changes and then redraw!!!
        				setTimeout(function() {
        					$(grid_selector).jqGrid('setGridWidth', parent_column.width());
        				}, 0);
        			}
        		});
								var hiddenCols=$.ajax({url:"${contextPath}/sys/company/getColHidden",async:false});
								var hiddenColsJSON=JSON.parse(hiddenCols.responseText);
								jQuery(grid_selector).jqGrid({
				        			subGrid : false,
				        			url : "${contextPath}/sys/company/getCompany",
				        			datatype : "json",
				        			height : 450,
				        			colNames : ['', '公司编码', '公司名称', '公司类别', '注册日期', '公司职能', '法人', '排序', '财务科目1', '财务科目2', '地址'],
				        			colModel : [ {
				        				name : '',
				        				index : '',
				        				width : 80,
				        				fixed : true,
				        				sortable : false,
				        				resize : false,
				        				formatter : 'actions',
				        				formatoptions : {
				        					keys : true,
				        					//delbutton : false,//disable delete button
				        					delOptions : {
				        						recreateForm : true,
				        						beforeShowForm : beforeDeleteCallback,
				        						errorTextFormat: function (response) {
				        		  					var result = eval('('+response.responseText+')');
				        		  				    return result.message;
				        		  				}
				        					}
				        					//editformbutton:true, editOptions:{recreateForm:true, beforeShowForm:beforeEditCallback}
				        				}
				        			}, {
				        				name : 'cmpNo',
				        				index : 'cmpNo',
				        				label : '公司编码',
				        				width : 130,
				        				editable : true,
				        				hidden:(hiddenColsJSON.cmpNo=='true'),
				        				editoptions : {size : "10", maxlength : "10"},
				        				searchoptions : {sopt : ['cn']},
				        				editrules : {required : true},
				        				formoptions:{rowpos:1,colpos:1}
				        			}, {
				        				name : 'cmpName',
				        				index : 'cmpName',
				        				label : '公司名称',
				        				width : 140,
				        				editable : true,
				        				hidden:(hiddenColsJSON.cmpName=='true'),
				        				editoptions : {size : "30", maxlength : "30"},
				        				searchoptions : {sopt : ['cn']},
				        				editrules : {required : true},
				        				formoptions:{rowpos:1,colpos:2}
				        			}, {
				        			     name : 'cmpTypeCn',
				        			     index : 'cmpType',
				        			     label : '公司类别' ,
				        			     width : 80,     
				        			     editable : true ,     
				        			     edittype : "select" ,
				        			     editoptions : {value : "1:内部公司;9:外部公司" },
				        			     search : false,
				        			     editrules : {required : true},
				         				 hidden:(hiddenColsJSON.cmpType=='true'),
				         				formoptions:{rowpos:1,colpos:3}
				        			  }, {
				        				name : 'cmpRegDate',
				        				index : 'cmpRegDate',
				        				label : '注册日期',
				        				width : 110,
				        				editable : true,
				        				hidden:(hiddenColsJSON.cmpRegDate=='true'),
				        				readonly : true,
				        				search : false,
				        				sorttype : 'date',
				        				editrules : {date : true},
				        				formoptions:{rowpos:2,colpos:1},
				        				unformat:pickDate
				        			}, {
				        			     name : 'cmpFunctiCn',
				        			     index : 'cmpFuncti',
				        			     label : '公司职能' ,
				        			     width : 60,     
				        			     editable : true ,     
				        			     edittype : "select" ,
				        			     editoptions : {value : "1:核心职能;2:一般职能" },
				        			     search : false,
				        			     editrules : {required : true},
				         				 hidden:(hiddenColsJSON.cmpFuncti=='true'),
				         				formoptions:{rowpos:2,colpos:2}
				        			  },{
				        				name : 'cmpLeader',
				        				index : 'cmpLeader',
				        				label : '法人',
				        				width : 110,
				        				editable : true,
				        				searchoptions : {sopt : ['cn']},
				        				hidden:(hiddenColsJSON.cmpLeader=='true'),
				        				editoptions : {size : "20", maxlength : "10"},
				        				search : true,
				        				editrules : {required : true},
				        				formoptions:{rowpos:2,colpos:3}
				        			},{
				        				name : 'cmpOrder',
				        				index : 'cmpOrder',
				        				label : '排序',
				        				width : 50,
				        				align:"right",
				        				editable : true,
				        				hidden:(hiddenColsJSON.cmpOrder=='true'),
				        				editoptions : {size : "20", maxlength : "6"},
				        				search : false,
				        				editrules : {number : true,required : true},				        				
				        				formoptions:{rowpos:3,colpos:1}
				        			},{
				        				name : 'cmpFi1',
				        				index : 'cmpFi1',
				        				label : '财务科目1',
				        				width : 1,
				        				editable : true,
				        				hidden:(hiddenColsJSON.cmpFi1=='true'),
				        				editoptions : {size : "20", maxlength : "10"},
				        				search : false,
				        				formoptions:{rowpos:3,colpos:2}
				        			},{
				        				name : 'cmpFi2',
				        				index : 'cmpFi2',
				        				label : '财务科目2',
				        				width : 1,
				        				editable : true,
				        				hidden:(hiddenColsJSON.cmpFi2=='true'),
				        				editoptions : {size : "20", maxlength : "10"},
				        				search : false,
				        				formoptions:{rowpos:3,colpos:3}
				        			}, {
				        				name : 'cmpAddress',
				        				index : 'cmpAddress',
				        				label : '地址',
				        				width : 110,
				        				editable : true,
				        				edittype : "textarea",
				        				hidden:(hiddenColsJSON.cmpAddress=='true'),
				        				editoptions : {size : "20", maxlength : "50"},
				        				editrules : {required : true},
				        				search : false,
				        				formoptions:{rowpos:4,colpos:1}
				        			}],
				        			//scroll : 1, // set the scroll property to 1 to enable paging with scrollbar - virtual loading of records
				        			sortname : "cmpOrder",
				        			sortorder : "asc",
				        			viewrecords : true,
				        			rowNum : 30,
				        			rowList : [ 30, 60, 90 ],
				        			pager : pager_selector,
				        			altRows : true,
				        			multiselect : true,
				        	        multiboxonly : true,
				        			loadComplete : function() {
				        				var table = this;
				        				setTimeout(function(){
				        					styleCheckbox(table);
				        					updateActionIcons(table);
				        					updatePagerIcons(table);
				        					enableTooltips(table);
				        				}, 0);
				        			},
				        			editurl : "${contextPath}/sys/company/doOperate"
				        		});
				        		
								$(window).triggerHandler('resize.jqGrid');// trigger window resize to make the grid get the correct size
				        		
				        		// switch element when editing inline
				        		 function aceSwitch(cellvalue, options, cell) {
				        			setTimeout(function() {
				        				$(cell).find('input[type=checkbox]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
				        			}, 0);
				        		} 
				        		//点击全选按钮，所有checkbox都被选中，有点问题，不管用，暂时去掉。
				        		$(document).on('click', 'th input:checkbox' , function(){
									var that = this;
									$(this).closest('sample-table-2').find('tr > td:first-child input:checkbox')
									.each(function(){
										this.checked = that.checked;
										$(this).closest('tr').toggleClass('selected');
									});
								}); 
				        		
				        		function pickDate(cellvalue, options, cell) {
				        			setTimeout(function() {
				        				$(cell).find('input[type=text]').datepicker({
				        					format : 'yyyy-mm-dd',
				        					endDate:'+1',//结束时间，在这时间之后都不可选
				        					//language: 'zh-CN',
				        					autoclose : true
				        				});
				        			}, 0);
				        		}
				        		// navButtons
				        		jQuery(grid_selector).jqGrid('navGrid', pager_selector, { // navbar options
				        			edit : true,
				        			editicon : 'ace-icon fa fa-pencil blue',
				        			add : true,
				        			addicon : 'ace-icon fa fa-plus-circle purple',
				        			del : true,
				        			delicon : 'ace-icon fa fa-trash-o red',
				        			search : true,
				        			searchicon : 'ace-icon fa fa-search orange',
				        			refresh : true,
				        			refreshicon : 'ace-icon fa fa-refresh blue',
				        			view : true,
				        			viewicon : 'ace-icon fa fa-search-plus grey'
				        		}, {
				        			// edit record form
				        			closeAfterEdit: true,
				        			width: 1000,
				        			recreateForm : true,
				        			beforeShowForm : function(e) {
				        				var form = $(e[0]);
				        				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
				        				style_edit_form(form);
				        			},

				        			errorTextFormat: function (response) {
				    					//var result = $.parseJSON(response.responseText);
				    				    return response.responseText;
				    				}
				        			
				        		}, {
				        			// new record form
				        			 width: 1000,
				        			closeAfterAdd : true,
				        			recreateForm : true,
				        			viewPagerButtons : false,
				        			beforeShowForm : function(e) {
				        				var form = $(e[0]);
				        				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
				        				style_edit_form(form);
				        			},
				        			errorTextFormat: function (response) {
				    					//var result = $.parseJSON(response.responseText);
				    				    return response.responseText;
				    				}
				        		}, {
				        			// delete record form
				        			recreateForm : true,
				        			beforeShowForm : function(e) {
				        				var form = $(e[0]);
				        				if (form.data('styled'))
				        					return false;
				        				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
				        				style_delete_form(form);
				        				form.data('styled', true);
				        			},
				        			errorTextFormat: function (response) {
				    					//var result = $.parseJSON(response.responseText);
				    				    return response.responseText;
				    				},
				        			onClick : function(e) {
				        			}
				        		}, {
				        			// search form
				        			recreateForm : true,
				        			afterShowSearch : function(e) {
				        				var form = $(e[0]);
				        				form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
				        				style_search_form(form);
				        			},
				        			afterRedraw : function() {
				        				style_search_filters($(this));
				        			},
				        			multipleSearch : true 
					        		/**
					        		 * multipleGroup:true, showQuery: true
					        		 */
				        		}, {
				        			// view record form
				        			width: 1000,
				        			recreateForm : true,
				        			beforeShowForm : function(e) {
				        				var form = $(e[0]);
				        				form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
				        			}
				        		})
				        		
				        		// add custom button to export the data to excel
								jQuery(grid_selector).jqGrid('navButtonAdd', pager_selector,{
								   caption : "",
							       title : "导出Excel",
							       buttonicon : "ace-icon fa fa-file-excel-o green", 
							       onClickButton : function () {
							    	   var keys = [], ii = 0, rows = "";
							    	   var ids = $(grid_selector).getDataIDs(); // Get All IDs
							    	   var row = $(grid_selector).getRowData(ids[0]); // Get First row to get the labels
							    	   //var label = $(grid_selector).jqGrid('getGridParam','colNames');
				   			    	   for (var k in row) {
							    	   	   keys[ii++] = k; // capture col names
							    	   	   rows = rows + k + "\t"; // output each Column as tab delimited
							    	   }
							    	   rows = rows + "\n"; // Output header with end of line
							    	   for (i = 0; i < ids.length; i++) {
							    	   	   row = $(grid_selector).getRowData(ids[i]); // get each row
							    	   	   for (j = 0; j < keys.length; j++)
							    	   		   rows = rows + row[keys[j]] + "\t"; // output each Row as tab delimited
							    	   	   rows = rows + "\n"; // output each row with end of line
							    	   }
							    	   rows = rows + "\n"; // end of line at the end
							    	   var form = "<form name='csvexportform' action='${contextPath}/sys/company/doOperate?oper=excel' method='post'>";
							    	   form = form + "<input type='hidden' name='csvBuffer' value='" +  encodeURI(encodeURI(rows)) + "'>";
							    	   form = form + "</form><script>document.csvexportform.submit();</sc" + "ript>";
							    	   OpenWindow = window.open('', '');
							    	   OpenWindow.document.write(form);
							    	   OpenWindow.document.close();
							       } 
								});
				        		
				        		function style_edit_form(form) {
				        			// enable datepicker on "birthday" field and switches for "stock" field
				        			form.find('input[name=cmpRegDate]').datepicker({
				        				format : 'yyyy-mm-dd',
				        				autoclose : true
				        			});
				        			$(function(){
				        				if(form.find('input[name=cmpNo]').val()==""){
											form.find('input[name=cmpNo]').css('border-color','#f59942');
					        			}
				        				if(form.find('input[name=cmpName]').val()==""){
				        					form.find('input[name=cmpName]').css('border-color','#f59942');
				        				}
				        			})
				        			
				        			form.find('input[name=statusCn]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
				        			// don't wrap inside a label element, the checkbox value won't be submitted (POST'ed)
				        			// .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');

				        			// update buttons classes
				        			var buttons = form.next().find('.EditButton .fm-button');
				        			buttons.addClass('btn btn-sm').find('[class*="-icon"]').hide();// ui-icon, s-icon
				        			buttons.eq(0).addClass('btn-primary').prepend('<i class="ace-icon fa fa-check"></i>');
				        			buttons.eq(1).prepend('<i class="ace-icon fa fa-times"></i>')

				        			buttons = form.next().find('.navButton a');
				        			buttons.find('.ui-icon').hide();
				        			buttons.eq(0).append('<i class="ace-icon fa fa-chevron-left"></i>');
				        			buttons.eq(1).append('<i class="ace-icon fa fa-chevron-right"></i>');
				        		}

				        		function style_delete_form(form) {
				        			var buttons = form.next().find('.EditButton .fm-button');
				        			buttons.addClass('btn btn-sm btn-white btn-round').find('[class*="-icon"]').hide();// ui-icon, s-icon
				        			buttons.eq(0).addClass('btn-danger').prepend('<i class="ace-icon fa fa-trash-o"></i>');
				        			buttons.eq(1).addClass('btn-default').prepend('<i class="ace-icon fa fa-times"></i>')
				        		}

				        		function style_search_filters(form) {
				        			form.find('.delete-rule').val('X');
				        			form.find('.add-rule').addClass('btn btn-xs btn-primary');
				        			form.find('.add-group').addClass('btn btn-xs btn-success');
				        			form.find('.delete-group').addClass('btn btn-xs btn-danger');
				        		}
				        		function style_search_form(form) {
				        			var dialog = form.closest('.ui-jqdialog');
				        			var buttons = dialog.find('.EditTable')
				        			buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'ace-icon fa fa-retweet');
				        			buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'ace-icon fa fa-comment-o');
				        			buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'ace-icon fa fa-search');
				        		}

				        		function beforeDeleteCallback(e) {
				        			var form = $(e[0]);
				        			if (form.data('styled'))
				        				return false;
				        			form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
				        			style_delete_form(form);
				        			form.data('styled', true);
				        		}

				        		function beforeEditCallback(e) {
				        			var form = $(e[0]);
				        			form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
				        			style_edit_form(form);
				        		}

				        		// it causes some flicker when reloading or navigating grid
				        		// it may be possible to have some custom formatter to do this as the grid is being created to prevent this
				        		// or go back to default browser checkbox styles for the grid
				        		function styleCheckbox(table) {
				        			/**
				        			 * $(table).find('input:checkbox').addClass('ace') .wrap('<label />') .after('<span class="lbl align-top" />') $('.ui-jqgrid-labels th[id*="_cb"]:first-child')
				        			 * .find('input.cbox[type=checkbox]').addClass('ace') .wrap('<label />').after('<span class="lbl align-top" />');
				        			 */
				        		}

				        		// unlike navButtons icons, action icons in rows seem to be hard-coded
				        		// you can change them like this in here if you want
				        		function updateActionIcons(table) {
				        			/**
				        			 * var replacement = { 'ui-ace-icon fa fa-pencil' : 'ace-icon fa fa-pencil blue', 'ui-ace-icon fa fa-trash-o' : 'ace-icon fa fa-trash-o red', 'ui-icon-disk' : 'ace-icon fa fa-check green', 'ui-icon-cancel' :
				        			 * 'ace-icon fa fa-times red' }; $(table).find('.ui-pg-div span.ui-icon').each(function(){ var icon = $(this); var $class = $.trim(icon.attr('class').replace('ui-icon', '')); if($class in replacement)
				        			 * icon.attr('class', 'ui-icon '+replacement[$class]); })
				        			 */
				        		}

				        		// replace icons with FontAwesome icons like above
				        		function updatePagerIcons(table) {
				        			var replacement = {
				        				'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
				        				'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
				        				'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
				        				'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
				        			};
				        			$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function() {
				        				var icon = $(this);
				        				var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

				        				if ($class in replacement)
				        					icon.attr('class', 'ui-icon ' + replacement[$class]);
				        			})
				        		}

				        		function enableTooltips(table) {
				        			$('.navtable .ui-pg-button').tooltip({
				        				container : 'body'
				        			});
				        			$(table).find('.ui-pg-div').tooltip({
				        				container : 'body'
				        			});
				        		}

				        		// var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
								jQuery(grid_selector).jqGrid( 'hideCol', "cmpShortname");
 								jQuery(grid_selector).jqGrid( 'hideCol', "cmpFuncti");
 								//jQuery(grid_selector).jqGrid( 'hideCol', "cmpType");
 								jQuery(grid_selector).jqGrid( 'hideCol', "cmpPhone");
 								jQuery(grid_selector).jqGrid( 'hideCol', "cmpEmail");
 								jQuery(grid_selector).jqGrid( 'hideCol', "cmpFi1");
 								jQuery(grid_selector).jqGrid( 'hideCol', "cmpFi2");
 								
				        		$(document).one('ajaxloadstart.page', function(e) {
				        			$(grid_selector).jqGrid('GridUnload');
				        			$('.ui-jqdialog').remove();
				        		});
				        		
				        	});
				        });
		
				</script>