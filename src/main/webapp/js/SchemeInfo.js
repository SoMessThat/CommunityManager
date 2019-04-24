$(function(){

	intiContent = function () {	
		$.ajax({
			url:'../CmScheme/findCmSchemeById.do',
			type:'post',
			data: {
				id:1
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
		$("#page1").empty();
		$("#page1").append(
				'<div align="center">'+
				'	<p class="title">福建工程学院国脉信息学院</p>'+
				'	<p class="title">大型灯谜会活动</p>'+
				'</div>'+
				'<div align="center">'+
				'	<p><span class="BigFont">策</span></p>'+
				'	<p><span class="BigFont">划</span></p>'+
				'	<p><span class="BigFont">书</span></p>'+
				'</div>'+
				'<div align="center" class="DepartmentName">'+
				'	<p class="Tail">福建工程学院国脉信息学院自律委员会</p>'+
		'</div>');
	}
});