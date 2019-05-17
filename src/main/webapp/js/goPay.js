function jiaofei(id){
	$("#content").val(id);
	$("#pay").trigger("click"); 
}

function checkState(state){
	if (state == '已缴费') {
		return 'come';
	}
	if (state == '未缴费') {
		return 'open';
	}
	return 'close';
}


$(function(){

	var intiContent = function () {	
		$.ajax({
			url:'../CmPayment/queryPageCmPayment.do',
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
				elem: 'Paypage',
				count: data.count,
				limit: 7,
				jump: function(obj, first){
					$.ajax({
						url:'../CmPayment/queryPageCmPayment.do',
						type:'post',
						data: {
							cmAttendance_departmentId:1,
							page:obj.curr,
							limit:obj.limit,
						},
						dataType:'json',
						success : function(data){
							$("#PayDemo").empty();
							for (var i = 0; i < obj.limit; i++) {
								$("#PayDemo").append('<div class="ResultCont" style="margin-top: 10px;padding-bottom: 10px;margin-bottom: 10px;">'+
										'<div class="title">'+
										'<a href="" target="_blank"><em>'+data.data[i].userName+':</em>'+data.data[i].name+'</a>'+
										'<b class="layui-btn mini '+checkState(data.data[i].state)+
										'">'+data.data[i].state+'</b>'+
										'</div>'+
										'<div class="ResultMoreinfo">'+
										'<div class="Volume">'+
										'<a href="" target="_blank">创建时间：'+data.data[i].creatTime+'</a>'+
										'</div>'+
										'</div>'+
										'<div class="result_new_operaRight result_new_operaItem" style="float: right;">'+
										'<input class="layui-btn layui-btn-small layui-btn-normal see" style=" margin-top: -48px; " id="see" onclick="jiaofei('+
										data.data[i].id+
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
});