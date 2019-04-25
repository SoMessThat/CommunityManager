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
								$("#SchemeDemo").append('<div class="ResultCont" style="margin-top: 10px;padding-bottom: 10px;margin-bottom: 10px;">'+
										'<div class="title">'+
										'<a href="" target="_blank"><em></em>'+data.data[i].name+'</a>'+
										'<a href="javascript:void(0)">'+
										'<i class="icon icon_Miner" id="icon1" title="'+data.data[i].state+
										'" style="margin-left: 0px; background: url(../images/Ended.png) no-repeat center center; background-size: cover;"></i>'+
										'</a>'+
										'</div>'+
										'<div class="ResultMoreinfo">'+
										'<div class="Volume">'+
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
		<!--
		window.open ('../CmScheme/openSchemeInfo.do');
		-->
//		layui.use(['layer'], function(){
//			var layer = layui.layer,
//			$ = layui.$;
//			layer.open({
//				type: 2,
//				skin: 'layui-layer-rim',
//				title: '查看策划',
//				shadeClose: false,
//				shade: false,
//				closeBtn:1,
//				area:['100%','100%'],
//				resize:false,
//				content: '../CmScheme/openSchemeInfo.do',
//				success : function(layero, index){
//				},
//
//			});
//		});
	}
});