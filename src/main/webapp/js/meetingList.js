$(function(){
	layui.use(['layer', 'table','element','form','laydate'], function(){
		var layer = layui.layer, 
		table = layui.table, 
		element = layui.element, 
		laydate = layui.laydate,
		laypage=layui.laypage,
		form = layui.form,
		$ = layui.$;

		table.render({
			elem: '#cmAttendancelist',
			url: '../CmAttendance/queryPageCmAttendance.do',
			//   toolbar: '#barDemo',
			data:[
			      departmentId=1
			      ],
			limit:10,	
			limits:[5,10,15,20],
			toolbar: true,
			page:true, //开启分页
			height:'500px',
			response: {
				statusName: 'status' //数据状态的字段名称，默认：code
				,statusCode: 200//成功的状态码，默认：0
				,msgName: 'messages' //状态信息的字段名称，默认：msg
				,countName: 'count' //数据总数的字段名称，默认：count
				,dataName: 'data' //数据列表的字段名称，默认：data
			},
			cols: [[ //表头
			         {column:"id", title: '', width:200, fixed: 'left' }  ,
			         {column:"name", title: '', width:200, fixed: 'left' }  ,
			         {column:"content", title: '', width:200, fixed: 'left' }  ,
			         {column:"place", title: '', width:200, fixed: 'left' }  ,
			         {column:"creatTime", title: '', width:200, fixed: 'left' }  ,
			         {column:"beginTime", title: '', width:200, fixed: 'left' }  ,
			         {column:"endTime", title: '', width:200, fixed: 'left' }  ,
			         {column:"departmentId", title: '', width:200, fixed: 'left' }  ,
			         {column:"userName", title: '', width:200, fixed: 'left' }  ,
			         {column:"state", title: '', width:200, fixed: 'left' }  ,
			         {fixed: 'right', title: '操作',width: 150, align:'center', toolbar: '#barDemo'}
			         ]]
		});

		//监听行工具事件
		table.on('tool(cmAttendancelist)', function(obj){
			if(obj.event === 'del'){
				layer.confirm('真的删除行么', function(index){
					var id = obj.data.id;
					$.ajax({
						url:BASE_PATH+'/CmAttendance/delCmAttendance.do',
						type:'get',
						dataType:'text',
						data:{
							id:id
						},
						error:function (res) {
							layer.alert(res.errors);
						},
						success:function (res) {
							layer.alert('保存成功!',function(){
								layer.closeAll();
								table.reload('cmAttendancelist');
							});
							obj.del();
						}
					});
				});
			} else if(obj.event === 'edit'){
				layer.open({
					type: 2,
					skin: 'layui-layer-rim',
					title: '编辑房间信息',
					btn: ['保存'],
					btnAlign: 'c',
					shadeClose: true,
					shade: true,
					maxmin: false,
					area: ['70%', '80%'],
					content: BASE_PATH+'../editCmAttendance.html',
					success : function(layero, index){
						var body = layer.getChildFrame('body', index);
						var iframeWin = window[layero.find('iframe')[0]['name']];
						var dialogform = iframeWin.layui.form;
						var id = obj.data.id;
						//设置不可编辑
						//body.find("input#roomcode").attr("disabled",true);
						//body.find("select#roomfloor").attr("disabled",true);
						$.ajax({
							url:BASE_PATH+'/CmAttendance/findCmAttendanceById.do',
							type:'get',
							dataType:'json',
							async:true,  //异步加载
							data:{
								'id':id
							},
							error:function (res) {
								layer.alert(res.data.erro);
							},
							success : function(data){
								body.find("input#id").val(data.data.id),
								body.find("input#name").val(data.data.name),
								body.find("input#content").val(data.data.content),
								body.find("input#place").val(data.data.place),
								body.find("input#creatTime").val(data.data.creatTime),
								body.find("input#beginTime").val(data.data.beginTime),
								body.find("input#endTime").val(data.data.endTime),
								body.find("input#departmentId").val(data.data.departmentId),
								body.find("input#userName").val(data.data.userName),
								body.find("input#state").val(data.data.state)
								//dialogform.render('select');

							},
						});
					},
					yes: function (layero, index) {
						var body = layui.layer.getChildFrame('body', layero); //得到iframe页的body内容
						//获取值弹出框值
//						var id=body.find("input#id").val(),
//						var name=body.find("input#name").val(),
//						var content=body.find("input#content").val(),
//						var place=body.find("input#place").val(),
//						var creatTime=body.find("input#creatTime").val(),
//						var beginTime=body.find("input#beginTime").val(),
//						var endTime=body.find("input#endTime").val(),
//						var departmentId=body.find("input#departmentId").val(),
//						var userName=body.find("input#userName").val(),
//						var state=body.find("input#state").val(),
						//判断是否为空
						/*if(roomCode==""||roomFloor==""||roomType==""||roomState==""||roomPrix==""){
		    				layer.alert('请输入完整信息!');
		    			}
		    			else {*/ 	
						$.ajax({
							url:'../CmAttendance/updateCmAttendanceById.do',
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
							error:function (res) {
								layer.alert('网络错误!');
							},
							success : function(layero, index){
								layer.alert('修改成功!',function(){
									layer.closeAll();
									table.reload('cmAttendancelist');
								});
							},
						});
						//}

					}
				});
			}
		});

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