$(function(){

	var intiContent = function () {	
		$.ajax({
			url:'../CmAttendance/queryPageCmAttendance.do',
			type:'post',
			data: {
				cmAttendance_departmentId:1,
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
						url:'../CmPaymentRecord/queryPageCmPaymentRecord.do',
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
								$("#PayDemo").append('<div class="ResultCont">'+
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
										'摘要：<em>19</em><em>世纪</em>'+data.data[i].content+''+
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
										'<i style="background: url(../images/hand.png) no-repeat center center; background-size: cover;"></i> <span>收到</span>'+
										'</a></li>'+
										'</div>'+
										'</ul>'+
										'</div>'+
										'<div class="result_new_operaCenter result_new_operaItem">'+
										'<ul class="clear">'+
										'</ul>'+
										'</div>'+
										'<div class="result_new_operaRight result_new_operaItem">'+
										'<ul class="clear">'+
										'<li><a href="javascript:void(0)" class="result_new_opera_otherWay">'+
										'<input class="layui-btn layui-btn-small layui-btn-normal see" id="see" onclick="see('+data.data[i].id+')" value="查看">'+
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
});