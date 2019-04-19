$(function(){
	
	$.ajax({
		url:'../CmAttendance/queryPageCmAttendance.do',
		type:'post',
		data: {
			cmAttendance_departmentId:1,
			page:1,
			limit:5
		},
		dataType:'json',
		error:function (res) {
//			layer.alert('网络错误!');
		},
		success : function(data){
			for (var i = 0; i < data.count; i++) {
				$("#MeetingDemo").append('<div class="ResultCont" style="width:  80%; margin-left: 10%; ">'+
						'<div class="title">'+
						'<a href="" target="_blank"><em>'+data.data[i].userName+':</em>'+data.data[i].name+'</a>'+
						'<a href="javascript:void(0)">'+
						'<i class="icon icon_Miner" id="icon1" onclick="showBox(this.id,"zglsdllc201901004","perio")" title="WFMetrics" style="margin-left: 0px;"></i>'+
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
	});
	
	//查询条件监听
	layui.use(['form','table','layedit', 'laydate'], function(){
		var form = layui.form,
		table = layui.table,
		layer = layui.layer,
		layedit = layui.layedit,
		laydate = layui.laydate,
		$ = layui.$;

		$("#id").bind('input propertychange', function () {
			table.reload('cmAttendancelist', {
				page: {
					curr: 1 //重新从第 1 页开始
				},
				where: {
					id: $("#id").val(),
					name: $("#name").val(),
					content: $("#content").val(),
					place: $("#place").val(),
					creatTime: $("#creatTime").val(),
					beginTime: $("#beginTime").val(),
					endTime: $("#endTime").val(),
					departmentId: $("#departmentId").val(),
					userName: $("#userName").val(),
					state: $("#state").val(),
				}
			});
		});
		$("#name").bind('input propertychange', function () {
			table.reload('cmAttendancelist', {
				page: {
					curr: 1 //重新从第 1 页开始
				},
				where: {
					id: $("#id").val(),
					name: $("#name").val(),
					content: $("#content").val(),
					place: $("#place").val(),
					creatTime: $("#creatTime").val(),
					beginTime: $("#beginTime").val(),
					endTime: $("#endTime").val(),
					departmentId: $("#departmentId").val(),
					userName: $("#userName").val(),
					state: $("#state").val(),
				}
			});
		});
		$("#content").bind('input propertychange', function () {
			table.reload('cmAttendancelist', {
				page: {
					curr: 1 //重新从第 1 页开始
				},
				where: {
					id: $("#id").val(),
					name: $("#name").val(),
					content: $("#content").val(),
					place: $("#place").val(),
					creatTime: $("#creatTime").val(),
					beginTime: $("#beginTime").val(),
					endTime: $("#endTime").val(),
					departmentId: $("#departmentId").val(),
					userName: $("#userName").val(),
					state: $("#state").val(),
				}
			});
		});
		$("#place").bind('input propertychange', function () {
			table.reload('cmAttendancelist', {
				page: {
					curr: 1 //重新从第 1 页开始
				},
				where: {
					id: $("#id").val(),
					name: $("#name").val(),
					content: $("#content").val(),
					place: $("#place").val(),
					creatTime: $("#creatTime").val(),
					beginTime: $("#beginTime").val(),
					endTime: $("#endTime").val(),
					departmentId: $("#departmentId").val(),
					userName: $("#userName").val(),
					state: $("#state").val(),
				}
			});
		});
		$("#creatTime").bind('input propertychange', function () {
			table.reload('cmAttendancelist', {
				page: {
					curr: 1 //重新从第 1 页开始
				},
				where: {
					id: $("#id").val(),
					name: $("#name").val(),
					content: $("#content").val(),
					place: $("#place").val(),
					creatTime: $("#creatTime").val(),
					beginTime: $("#beginTime").val(),
					endTime: $("#endTime").val(),
					departmentId: $("#departmentId").val(),
					userName: $("#userName").val(),
					state: $("#state").val(),
				}
			});
		});
		$("#beginTime").bind('input propertychange', function () {
			table.reload('cmAttendancelist', {
				page: {
					curr: 1 //重新从第 1 页开始
				},
				where: {
					id: $("#id").val(),
					name: $("#name").val(),
					content: $("#content").val(),
					place: $("#place").val(),
					creatTime: $("#creatTime").val(),
					beginTime: $("#beginTime").val(),
					endTime: $("#endTime").val(),
					departmentId: $("#departmentId").val(),
					userName: $("#userName").val(),
					state: $("#state").val(),
				}
			});
		});
		$("#endTime").bind('input propertychange', function () {
			table.reload('cmAttendancelist', {
				page: {
					curr: 1 //重新从第 1 页开始
				},
				where: {
					id: $("#id").val(),
					name: $("#name").val(),
					content: $("#content").val(),
					place: $("#place").val(),
					creatTime: $("#creatTime").val(),
					beginTime: $("#beginTime").val(),
					endTime: $("#endTime").val(),
					departmentId: $("#departmentId").val(),
					userName: $("#userName").val(),
					state: $("#state").val(),
				}
			});
		});
		$("#departmentId").bind('input propertychange', function () {
			table.reload('cmAttendancelist', {
				page: {
					curr: 1 //重新从第 1 页开始
				},
				where: {
					id: $("#id").val(),
					name: $("#name").val(),
					content: $("#content").val(),
					place: $("#place").val(),
					creatTime: $("#creatTime").val(),
					beginTime: $("#beginTime").val(),
					endTime: $("#endTime").val(),
					departmentId: $("#departmentId").val(),
					userName: $("#userName").val(),
					state: $("#state").val(),
				}
			});
		});
		$("#userName").bind('input propertychange', function () {
			table.reload('cmAttendancelist', {
				page: {
					curr: 1 //重新从第 1 页开始
				},
				where: {
					id: $("#id").val(),
					name: $("#name").val(),
					content: $("#content").val(),
					place: $("#place").val(),
					creatTime: $("#creatTime").val(),
					beginTime: $("#beginTime").val(),
					endTime: $("#endTime").val(),
					departmentId: $("#departmentId").val(),
					userName: $("#userName").val(),
					state: $("#state").val(),
				}
			});
		});
		$("#state").bind('input propertychange', function () {
			table.reload('cmAttendancelist', {
				page: {
					curr: 1 //重新从第 1 页开始
				},
				where: {
					id: $("#id").val(),
					name: $("#name").val(),
					content: $("#content").val(),
					place: $("#place").val(),
					creatTime: $("#creatTime").val(),
					beginTime: $("#beginTime").val(),
					endTime: $("#endTime").val(),
					departmentId: $("#departmentId").val(),
					userName: $("#userName").val(),
					state: $("#state").val(),
				}
			});
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

		//清空
		$("#resetbtn").on('click',function(){
			table.reload('cmAttendancelist', {
				page: {
					curr: 1 //重新从第 1 页开始
				},
				where: {
					id: '',
					name: '',
					content: '',
					place: '',
					creatTime: '',
					beginTime: '',
					endTime: '',
					departmentId: '',
					userName: '',
					state: '',
				}
			});
		});


		//新增按钮
		$(document).on('click','#addCmAttendance',function(){
			layer.open({
				type: 2,
				skin: 'layui-layer-rim',
				title: '新增CmAttendance信息',
				btn: ['保存'],
				btnAlign: 'c',
				shadeClose: true,
				shade: true,
				maxmin: false,
				area: ['70%', '80%'],
				content: BASE_PATH+'/addCmAttendance.jsp',
				yes: function (layero, index) {
					var body = layui.layer.getChildFrame('body', layero); //得到iframe页的body内容

					//判断是否为空
					/*if(roomCode==""||roomFloor==""||roomType==""||roomState==""||roomPrix==""){
					layer.alert('请输入完整信息!');
					}
				else if(roomcodeExist==""){*/
					$.ajax({
						url:BASE_PATH+'/CmAttendance/addCmAttendance.do',
						type:'get',
						data: {
							id:body.find("input#id").val(),
							name:body.find("input#name").val(),
							content:body.find("input#content").val(),
							place:body.find("input#place").val(),
							creatTime:body.find("input#creatTime").val(),
							beginTime:body.find("input#beginTime").val(),
							endTime:body.find("input#endTime").val(),
							departmentId:body.find("input#departmentId").val(),
							userName:body.find("input#userName").val(),
							state:body.find("input#state").val(),
						},
						dataType:'json',
						error:function (res) {
							layer.alert('网络错误!');
						},
						success : function(layero, index){
							layer.alert('添加成功!',function(){
								layer.closeAll();
								table.reload('cmAttendancelist');
							});
						}
					});
					//}
					/*else{
				layer.alert('房间已存在!');
				}
					 */
				}
			});
		});
	});
});