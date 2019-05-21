function checkState(state){
	if (state == '未阅') {
		return 'come';
	}
	if (state == '已阅') {
		return 'open';
	}
	return 'close';
}


$(function(){

	var intiContent = function () {	
		$.ajax({
			url:'../CmWorkSummary/queryPageCmWorkSummary.do',
			type:'post',
			data: {
				cmWorkSummary_departmentId:1,
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
				elem: 'Summarypage',
				count: data.count,
				limit: 7,
				jump: function(obj, first){
					$.ajax({
						url:'../CmWorkSummary/queryPageCmWorkSummary.do',
						type:'post',
						data: {
							cmWorkSummary_departmentId:1,
							page:obj.curr,
							limit:obj.limit,
						},
						dataType:'json',
						success : function(data){
							$("#SummaryDemo").empty();
							for (var i = 0; i < obj.limit; i++) {
								$("#SummaryDemo").append('<div class="ResultCont" style="margin-top: 10px;padding-bottom: 10px;margin-bottom: 10px;">'+
										'<div class="title">'+
										'<a href="" target="_blank"><em></em>'+data.data[i].name+'</a>'+
										'<b class="layui-btn mini '+checkState(data.data[i].state)+
										'">'+data.data[i].state+'</b>'+
										'</div>'+
										'<div class="Volume">'+
										'<div class="summary">'+
										'<em>提交人：</em>：'+data.data[i].userName+''+
										'</div>'+
										'<div class="ResultMoreinfo">'+
										'<a href="" target="_blank">创建时间：'+data.data[i].creatTime+'</a>'+
										'</div>'+
										'</div>'+
										'<div class="result_new_operaRight result_new_operaItem" style="float: right;">'+
										'<input class="layui-btn layui-btn-small layui-btn-normal see" style=" margin-top: -48px; " id="see" onclick="see('+data.data[i].id+
										')" value="查看">'+
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
		window.open ('../CmWorkSummary/openSummaryInfo.do');
	}
});