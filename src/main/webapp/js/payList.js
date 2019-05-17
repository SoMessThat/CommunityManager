function checkState(state){
	if (state == '已缴费') {
		return 'come';
	}
	if (state == '未缴费') {
		return 'open';
	}
	return 'close';
}

function see(type){
	if (type=="1") {
		layer.msg('<p><span style="color:#90AED0">已缴费人员</span>:<span>小黄，</span><span>小吴，</span><span>小李，</span><span>小天</span></p>'+
				'<p><span style="color:#90AED0">未交费人员</span>：<span>mess，</span><span>mess2，</span><span>小林，</span><span>小沙，</span><span>hello</span></p>', {
		    time: 20000, //20s后自动关闭
		    btn: ['知道了']
		});
	}else if (type=="2") {
		layer.msg('<p><span style="color:#90AED0">已缴费人员</span>:<span>小黄，</span><span>小吴，</span><span>mess，</span><span>mess2，</span><span>小林，</span><span>小李，</span><span>小天</span></p>'+
				'<p><span style="color:#90AED0">未交费人员</span>：<span>小沙，</span><span>hello</span></p>', {
		    time: 20000, //20s后自动关闭
		    btn: ['知道了']
		});
	}else{
		layer.msg('<p><span style="color:#90AED0">已缴费人员</span>:</p>'+
				'<p><span style="color:#90AED0">未交费人员</span>：<span>小黄，</span><span>小吴，</span><span>小李，</span><span>小天</span><span>mess，</span><span>mess2，</span><span>小林，</span><span>小沙，</span><span>hello</span></p>', {
		    time: 20000, //20s后自动关闭
		    btn: ['知道了']
		});
	}
}
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
										'<b class="layui-btn mini '+checkState(data.data[i].state)+
										'">'+data.data[i].state+'</b>'+
										'</div>'+
										'<div class="ResultMoreinfo">'+
										'<div class="Volume">'+
										'<a href="" target="_blank">创建时间：'+data.data[i].creatTime+'</a>'+
										'</div>'+
										'</div>'+
										'<div class="result_new_operaRight result_new_operaItem" style="float: right;">'+
										'<input class="layui-btn layui-btn-small layui-btn-normal see" style=" margin-top: -48px; " id="see" onclick="see('+data.data[i].id+')" value="查看">'+
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