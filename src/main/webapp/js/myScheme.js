function checkState(state){
	if (state == '驳回') {
		return 'close';
	}
	if (state == '审核通过') {
		return 'open';
	}
	return 'come';
}

$(function(){

	var intiContent = function () {	
		$.ajax({
			url:'../CmScheme/queryPageCmScheme.do',
			type:'post',
			data: {
				cmAttendance_departmentId:1,
				page:1,
				limit:7,
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
				elem: 'Schemepage',
				count: data.count,
				limit: 7,
				jump: function(obj, first){
					$.ajax({
						url:'../CmScheme/queryPageCmScheme.do',
						type:'post',
						data: {
							cmAttendance_departmentId:1,
							page:obj.curr,
							limit:obj.limit,
						},
						dataType:'json',
						success : function(data){
							$("#SchemeDemo").empty();
							for (var i = 0; i < obj.limit; i++) {
								item = data.data[i];
								$("#SchemeDemo").append('<div class="ResultCont" style="margin-top: 10px;padding-bottom: 10px;margin-bottom: 10px;">'+
										'<div class="title">'+
										'<a target="_blank"><em>'+item.department+':</em>'+item.name+'</a>'+
										'<b class="layui-btn mini '+checkState(item.state)+
												'">'+item.state+'</b>'+
										'</div>'+
										'<div class="ResultMoreinfo">'+
										'<div class="author">'+
										'<span class="resultResouceType">'+item.creatPerson+'</span>'+
										'<a>活动主题：'+item.theme+'</a>'+
										'</div>'+
										'<div class="Volume">'+
										'<a>&nbsp;&nbsp;&nbsp;活动形式'+item.form+'</a>'+
										'</div>'+
										'</div>'+
										'<div class="summary">'+
										'<em>摘要</em>：'+item.content+''+
										'</div>'+
										'<div class="Keyword">'+
										'<a><span><em>创建时间</em>：</span><span>'+item.creatTime+'</span></a>'+
										'<a><span><em>开始时间</em>：</span><span>'+item.beginTime+'</span></a>'+
										'</div>'+
										'<div class="Keyword">'+
										'<a><span><em>活动对象</em>：</span><span>'+item.place+'</span></a>'+
										'<a><span><em>活动地点</em>：</span><span>'+item.person+'</span></a>'+
										'</div>'+
										'<div class="result_new_operaWrap clear">'+
										'<div class="result_new_operaLeft result_new_operaItem">'+
										'<ul class="clear result_new_listOperaWrap">'+
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
	see= function (id){
		window.open ('../CmScheme/openSchemeInfo.do');
	}
});