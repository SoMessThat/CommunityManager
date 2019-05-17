function intiContent() {	
	$.ajax({
		url:'../CmAttendance/queryPageCmAttendance.do',
		type:'post',
		data: {
			page:1,
			limit:5,
		},
		dataType:'json',
		error:function (res) {
		},
		success : function(data){
			intiPage(data);
		}
	});
}

function shouDao(id){
	$.ajax({
		url:'../CmAttendanceRecord/shouDao.do',
		type:'post',
		data: {
			'id':id
		},
		dataType:'json',
		error:function (res) {
			layer.msg("网络错误", {icon: 5,time: 1000});
		},
		success : function(data){
			layer.msg("已成功收到，请注意签到时间", {icon: 1,time: 1000});
			intiContent();
		}
	});
}
	
function checkState(state){
	if (state == '未开始') {
		return 'come';
	}
	if (state == '进行中') {
		return 'open';
	}
	return 'close';
}


function intiPage(data) {
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
					},
					dataType:'json',
					success : function(data){
						$("#MeetingDemo").empty();
						for (var i = 0; i < obj.limit; i++) {
							item = data.data[i];
							$("#MeetingDemo").append('<div class="ResultCont">'+
									'<div class="title">'+
									'<a target="_blank"><em>'+item.userName+':</em>'+item.name+'</a>'+
									'<b class="layui-btn mini '+checkState(item.state)+
											'">'+item.state+'</b>'+
									'</div>'+
									'<div class="ResultMoreinfo">'+
									'<div class="author">'+
									'<span class="resultResouceType">'+item.department.name+'</span>'+
									'<a>'+item.userName+'</a>'+
									'</div>'+
									'<div class="Label periodical_label">'+
									'<span class="blockspan">'+item.place+'</span>'+
									'</div>'+
									'<div class="Volume">'+
									'<a>&nbsp;&nbsp;&nbsp;'+item.creatTime+'</a>'+
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
									'<div class="Mbtn">'+checkRecode(item)+
									'</div>'+
									'</ul>'+
									'</div>'+
									'<div class="result_new_operaCenter result_new_operaItem">'+
									'<ul class="clear">'+
									'</ul>'+
									'</div>'+
									'<div class="result_new_operaRight result_new_operaItem">'+
									'<ul class="clear">'+
									'<li><b class="layui-btn mini look" onclick="see('+item.id+')">&nbsp;查看&nbsp;</b>'+
									'</li>'+
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

function checkRecode(item){
	var str1 = '<li><a style=" width: 74px;background: rgb( 65, 125, 201 );color: #fff;">'+
	'<i style="background: url(../images/hand.png) no-repeat center center; background-size: cover;left: 12px;"></i>'+
	' <span style="right: 12px;">收到</span></a></li>';
	
	var str2 = '<li><a href="javascript:void(0)" class="result_opera_subscribe " id="col1" onclick="shouDao('+item.id+')">'+
	'<i style="background: url(../images/hand.png) no-repeat center center; background-size: cover;"></i> <span>收到</span>'+
	'</a></li>';
	
	if (typeof item.record == "undefined" || item.record == null || item.record == "") {
		return str2;
	}else{
		if (item.record.state.indexOf("收到") != -1) {
			return str1;
		}else{
			return str2;
		}
	}
	return str2;
}

see= function (id){
	layer.open({
		type: 2,
		skin: 'layui-layer-rim',
		title: '查看会议',
		shadeClose: false,
		shade: false,
		closeBtn:1,
		area:['100%','100%'],
		resize:false,
		content: '../CmAttendance/openMeetingInfo.do?id='+id,
		success : function(layero, index){
		}
	});
}

$(function(){
	
	//会议列表
	intiContent();
});