function edit(id){
	layer.open({
		type: 2,
		skin: 'layui-layer-rim',
		title: '编辑商品信息',
		btn: ['保存'],
		btnAlign: 'c',
		shadeClose: true,
		shade: true,
		maxmin: false,
		area: ['70%', '80%'],
		content: './editMeeting.html',
		success : function(layero, index){
//  	    	  var body = layer.getChildFrame('body', index);
//	    	      var iframeWin = window[layero.find('iframe')[0]['name']];
//	    	      var dialogform = iframeWin.layui.form;
//  	    	  var id = obj.data.id;
//  	    	  $.ajax({
//		                url:'',
//		                type:'get',
//		                dataType:'json',
//		                async:true,  //异步加载
//		                error:function (res) {
//		                    layer.alert(res.data.erro);
//		                },
//		                success : function(data){
//							body.find("input#id").val(data.data.id);
//		    	        }
//		            });
		},
		yes: function (layero, index) {
//  	    	  var body = layui.layer.getChildFrame('body', layero); //得到iframe页的body内容
//  	    	
//  	    	  $.ajax({
//  	    		  url:BASE_PATH+'/TCommodity/updateTCommodityById.do',
//  	    		  type:'get',
//  	    		  data: {
//						  id:body.find("#id").val(),
//						  name:body.find("#name").val(),
//						  category:body.find("#category").val(),
//						  info:body.find("#info").val(),
//						  price:body.find("#price").val(),
//						  secprice:body.find("#secprice").val(),
//						  conditions:body.find("#conditions").val(),
//						  state:body.find("#state").val()
//  	    			},
//  	    		  error:function (res) {
//  	    			  layer.alert('网络错误!');
//  	    		  },
//  	    		  success : function(layero, index){
			layer.msg("已发送,请注意查收", {icon: 1,time: 1000});
//  	    				  table.reload('tCommoditylist');
//  	    			  });
//  	    	  });
			
		}
	});
}

function del(id){
	layer.confirm('真的删除行么', function(index){
		$('#row_'+id).remove();
//		$.ajax({
//			url:BASE_PATH+'/TDemand/delTDemand.do',
//			type:'get',
//			dataType:'json',
//			error:function (res) {
//				layer.alert(res.errors);
//			},
//			success:function (res) {
//				layer.alert('保存成功!',function(){
					layer.closeAll();
//					table.reload('tDemandlist');
//				});
//				
//			}
//		});
		layer.msg("删除成功", {icon: 1,time: 1000});
	});
}

$(function(){

	var intiContent = function () {	
		$.ajax({
			url:'../CmAttendance/queryPageCmAttendance.do',
			type:'post',
			data: {
				cmAttendance_departmentId:1,
				page:1,
				limit:5,
				cmAttendance_name: $("#name").val(),
				cmAttendance_content: $("#content").val(),
				cmAttendance_place: $("#place").val(),
				cmAttendance_beginTime: $("#beginTime").val(),
				cmAttendance_userName: $("#userName").val(),
				cmAttendance_state: $("#state").val()
			},
			dataType:'json',
			error:function (res) {
			},
			success : function(data){
				intiPage(data);
			}
		});
	}
	intiContent();
	function checkState(state){
		if (state == '未开始') {
			return 'come';
		}
		if (state == '进行中') {
			return 'open';
		}
		return 'close';
	}
	var intiPage = function (data) {
		layui.use('laypage', function(){
			var laypage = layui.laypage;
			laypage.render({
				elem: 'page',
				count: data.count,
				limit:5,
				jump: function(obj, first){
					$.ajax({
						url:'../CmAttendance/queryPageCmAttendance.do',
						type:'post',
						data: {
							cmAttendance_departmentId:1,
							page:obj.curr,
							limit:obj.limit,
							cmAttendance_name: $("#name").val(),
							cmAttendance_content: $("#content").val(),
							cmAttendance_place: $("#place").val(),
							cmAttendance_beginTime: $("#beginTime").val(),
							cmAttendance_userName: $("#userName").val(),
							cmAttendance_state: $("#state").val()
						},
						dataType:'json',
						success : function(data){
							$("#MeetingDemo").empty();
							for (var i = 0; i < obj.limit; i++) {
								item = data.data[i];
								$("#MeetingDemo").append('<div class="ResultCont" id="row_'+item.id+'">'+
										'<div class="title">'+
										'<a target="_blank"><em>'+item.userName+':</em>'+item.name+'</a>'+
										'<b class="layui-btn mini '+checkState(item.state)+
												'">'+item.state+'</b>'+
										'</div>'+
										'<div class="ResultMoreinfo">'+
										'<div class="author">'+
										'<span class="resultResouceType">'+item.departmentId+'</span>'+
										'<a href="" target="_blank">'+item.userName+'</a>'+
										'</div>'+
										'<div class="Label periodical_label">'+
										'<span class="blockspan">'+item.place+'</span>'+
										'</div>'+
										'<div class="Volume">'+
										'<a href="" target="_blank">'+item.creatTime+'</a>'+
										'</div>'+
										'</div>'+
										'<div class="summary">'+
										'<em>摘要</em>：'+item.content+''+
										'</div>'+
										'<div class="Keyword">'+
										'<a><span><em>开始时间</em>：</span><span>'+item.beginTime+'</span></a>'+
										'<a><span><em>结束时间</em>：</span><span>'+item.endTime+'</span></a>'+
										'</div>'+
										'<div class="result_new_operaWrap clear">'+
										'<div class="result_new_operaLeft result_new_operaItem">'+
										'<ul class="clear result_new_listOperaWrap">'+
										'<div class="Mbtn">'+
										'<li><a href="javascript:void(0)" class="result_opera_subscribe " id="col1" onclick="edit('+item.id+')">'+
										'<i class="layui-icon  layui-icon-edit"></i> <span>编辑</span>'+
										'</a></li>'+
										'<li><a href="javascript:void(0)" class="result_opera_subscribe " id="col1" onclick="del('+item.id+')">'+
										'<i class="layui-icon  layui-icon-delete"></i> <span>删除</span>'+
										'</a></li>'+
										'</div>'+
										'</ul>'+
										'</div>'+
										'<div class="result_new_operaCenter result_new_operaItem">'+
										'<ul class="clear">'+
										'</ul>'+
										'</div>'+
										'<div class="result_new_operaRight result_new_operaItem">'+
//										'<ul class="clear">'+
//										'<li><b class="layui-btn mini look" onclick="see('+item.id+')">&nbsp;查看&nbsp;</b>'+
//										'</li>'+
//										'<li></li>'+
//										'</ul>'+
										'</div>'+
										'</div>'+
								'</div>');
							}
						},
					}) 
				}
			});
		});
	}
	layui.use(['form','laypage', 'laydate'], function(){
		var form = layui.form,
		laypage = layui.laypage,
		laydate = layui.laydate,
		$ = layui.$;

		$("#name").bind('input propertychange', function () {
			intiContent();
		});
		$("#content").bind('input propertychange', function () {
			intiContent();
		});
		$("#place").bind('input propertychange', function () {
			intiContent();
		});
		$("#beginTime").bind('input propertychange', function () {
			intiContent();
		});
		$("#userName").bind('input propertychange', function () {
			intiContent();
		});
		$("#state").bind('input propertychange', function () {
			intiContent();
		});
		/*下拉框
	      form.on('select(roomfloor)', function(data){
	   		table.reload('roomlist', {
			        page: {
			          curr: 1 //重新从第 1 页开始
			        },
			        where: {
			        	roomcode:$('#roomcode').val(),
	  	            	roomfloor:$('#roomfloor').val(),
	  	            	roomtype:$('#roomtype').val(),
	  	            	roomstate:$('#roomstate').val(),
		            	roomprix:$('#roomprix').val()
			        }
		      });
	  	    });
		 */

		$("#resetbtn").on('click',function(){
			reset();
			intiContent();
		});
		var reset = function (){
			$("#name").val('');
			$("#content").val('');
			$("#place").val('');
			$("#beginTime").val('');
			$("#userName").val('');
			$("#state").val('');
		}
	});
});