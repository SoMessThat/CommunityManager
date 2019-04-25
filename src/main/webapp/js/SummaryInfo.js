$(function(){

	intiContent = function () {	
		$.ajax({
			url:'../CmWorkSummary/findCmWorkSummaryById.do',
			type:'post',
			data: {
				id:2
			},
			dataType:'json',
			error:function (res) {
			},
			success : function(data){
				intiPage(data.data);
			}
		});
	}
	intiContent();

	intiPage = function (data) {
		$("#page1").empty();
		$("#page1").append('<div id="divpage"></div>');
		re = new RegExp("<br/>","g"); //定义正则表达式
		var content = data.content.replace(re,"</p><p>");
		$("#divpage").append(
				'<div align="center" style="text-align: center;">'+
				'	<p class="Name">'+data.title+'</p>'+
				'</div>'+
				'<div class="FirstLine Text">'+
				'	<p>'+content+'</p>'+
				'</div>');
		$("#divpage").append(
				'<div align="right">'+
				'	<div class="Sign">'+
				'		<p class="FirstTitle" align="center">'+data.departmentId+'</p>'+
				'		<p class="FirstTitle" align="center">'+data.userName+'</p>'+
				'		<p class="FirstTitle" align="center">'+data.creatTime+'</p>'+
				'	</div>'+
				'</div>');
	}
});