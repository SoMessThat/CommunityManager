$(function(){
	refresh();
	function refresh(){
		$.ajax({
			url: '../CmUser/findCmUser.do',
			type: 'post',
			dataType: 'json',
			async: true,
			success:function(data){
				$('#avatar1').attr('src',data.data.avatar);
				$('#avatar2').attr('src',data.data.avatar);
				$('#userName').text(data.data.username);
				$('#departmentName').text(data.data.department.name);
				$('#role').text(data.data.state);
				$('#account').text(data.data.account);
				$('#account1').val(data.data.account);
				$('#tel').text(data.data.tel);
				$('#tel1').val(data.data.tel);
				$('#sex').text(data.data.student.sex);
				$('#birthday').text(data.data.student.birthday);
				$('#email').text(data.data.student.email);
				$('#roots').text(data.data.student.roots);
				$('#political').text(data.data.student.political);
				$('#volk').text(data.data.student.volk);
				$('#age').text(data.data.student.age);
				$('#school').text(data.data.student.school);
				$('#code').text(data.data.student.code);
				$('#code1').val(data.data.student.code);
				$('#address').text(data.data.student.address);
				$('#award').html('');
				for (var i = 0; i < data.data.award.length; i++) {
					var array_element = data.data.award[i];
					$('#award').append('<ul><li>'+array_element.time+'		 '+array_element.awardName+'</li></u');
				}
				$('#departmentName').text(data.data.department.name);
				$('#departmentCreatTime').text('成立时间：'+data.data.department.registrationTime);
				$('#departmentCount').text('总人数：'+data.data.department.num+'人');
				$('#departmentMasterName').text('负责人：'+data.data.department.masterName);
				$('#departmentMasterTel').text('负责人电话：'+data.data.department.masterTel);
				$('#departmentLead').text('领导组织：'+data.data.department.leadOrganize);
			},
			error:function(res){
				layer.msg('网络错误，请重新登录', {icon: 5,time: 1000});
			}
		});
	}
   
	$("#modify1").click(function () {
		$('.show').removeClass('resume_key');
		$('.modify').removeClass('hide');
		$('#modify2').removeClass('hide');
		$('#modify1').addClass('hide');
    });
	
	$("#modify2").click(function () {
		$('.show').addClass('resume_key');
		$('.modify').addClass('hide');
		$('#modify2').addClass('hide');
		$('#modify1').removeClass('hide');
		$.ajax({
            url: '../CmUser/updateCmUser.do',
            type: 'post',
            dataType: 'json',
            async: true,
            data: {
            	'cmUser_avatar':$('#avatar2').attr('src'),
            	'cmUser_account':$('#account1').val(),
            	'cmUser_tel':$('#tel1').val(),
            	'cmUser_code':$('#code1').val()
            	},
            success:function(data){
            	if (data.result == "error") {
            		layer.msg(data.errors, {icon: 5,time: 1000});
				}
            	else {
            		layer.msg('修改成功', {icon: 1,time:1000});
            		refresh();
				}
            },
            error:function(res){
                layer.msg('保存失败，请重新修改', {icon: 5,time: 1000});
            }
        });
    });

	layui.use(['upload'],function() {
		var upload = layui.upload;
		upload.render({
		    elem: '#avatar2'
		    ,url: '../CmUser/upload.do'
		    ,multiple: false
		    ,done: function(res){
		    	$('#avatar2').attr("src",res.data.avatar);
		    	$('#avatar1').attr("src",res.data.avatar);
		    }
		  });
	});
});