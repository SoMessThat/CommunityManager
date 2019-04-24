$(function(){

	intiContent = function () {	
		$.ajax({
			url:'../CmAttendance/queryPageCmAttendance.do',
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

	intiPage = function (data) {
		layui.use('laypage', function(){
			var laypage = layui.laypage;
			laypage.render({
				elem: 'PayListPage',
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
							$("#PayListDemo").empty();
							for (var i = 0; i < obj.limit; i++) {
								$("#PayListDemo").append('<div class="ResultCont" style="margin-top: 10px;padding-bottom: 10px;margin-bottom: 10px;">'+
										'<div class="title">'+
										'<a href="" target="_blank"><em>'+data.data[i].userName+':</em>'+data.data[i].name+'</a>'+
										'<a href="javascript:void(0)">'+
										'<i class="icon icon_Miner" id="icon1" onclick="showBox(this.id,"zglsdllc201901004","perio")" title="'+data.data[i].state+
										'" style="margin-left: 0px; background: url(../images/Ended.png) no-repeat center center; background-size: cover;"></i>'+
										'</a>'+
										'</div>'+
										'<div class="ResultMoreinfo">'+
										'<div class="Volume">'+
										'<a href="" target="_blank">创建时间：'+data.data[i].creatTime+'</a>'+
										'</div>'+
										'</div>'+
										'<div class="result_new_operaRight result_new_operaItem" style="float: right;">'+
										'<input class="layui-btn layui-btn-small layui-btn-normal see" style=" margin-top: -48px; " id="see" onclick="see()" value="'+data.data[i].state+'">'+
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