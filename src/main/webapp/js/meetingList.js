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
								$("#MeetingDemo").append('<div class="ResultCont">'+
										'<div class="title">'+
										'<a href="" target="_blank"><em>'+data.data[i].userName+':</em>'+data.data[i].name+'</a>'+
										'<a href="javascript:void(0)">'+
										'<i class="icon icon_Miner" id="icon1" onclick="showBox(this.id,"zglsdllc201901004","perio")" title="'+data.data[i].state+
										'" style="margin-left: 0px; background: url(../images/Ended.png) no-repeat center center; background-size: cover;"></i>'+
										'</a>'+
										'</div>'+
										'<div class="ResultMoreinfo">'+
										'<div class="author">'+
										'<span class="resultResouceType">'+data.data[i].departmentId+'</span>'+
										'<a href="" target="_blank">'+data.data[i].userName+'</a>'+
										'</div>'+
										'<div class="Label periodical_label">'+
										'<span class="blockspan">'+data.data[i].place+'</span>'+
										'</div>'+
										'<div class="Volume">'+
										'<a href="" target="_blank">'+data.data[i].creatTime+'</a>'+
										'</div>'+
										'</div>'+
										'<div class="summary">'+
										'摘要：通过对《扁舟过三峡》等书的考证,可知<em>19</em><em>世纪</em>'+data.data[i].content+''+
										'</div>'+
										'<div class="Keyword">'+
										'<a><span>开始时间：</span><span>'+data.data[i].beginTime+'</span></a>'+
										'<a><span>结束时间：</span><span>'+data.data[i].endTime+'</span></a>'+
										'</div>'+
										'<div class="result_new_operaWrap clear">'+
										'<div class="result_new_operaLeft result_new_operaItem">'+
										'<ul class="clear result_new_listOperaWrap">'+
										'<div class="Mbtn">'+
										'<li><a href="javascript:void(0)" class="result_opera_subscribe " id="col1" onclick="collectionOne("zglsdllc201901004","perio",this.id)">'+
										'<i></i> <span>收藏</span>'+
										'</a></li>'+
										'<li><a href="javascript:void(0)" class="result_opera_share" type="0" data-type="shareDiv1"><i></i><span>分享</span> </a>'+
										'</li>'+
										'</div>'+
										'</ul>'+
										'</div>'+
										'<div class="result_new_operaCenter result_new_operaItem">'+
										'<ul class="clear">'+
										'</ul>'+
										'</div>'+
										'<div class="result_new_operaRight result_new_operaItem">'+
										'<ul class="clear">'+
										'<li><a href="javascript:void(0)" class="result_new_opera_otherWay"> 被引：<span style="left: 43px;">0</span>'+
										'</a></li>'+
										'<li></li>'+
										'</ul>'+
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