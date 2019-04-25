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
				intiPage(data.data);
			}
		});
	}
	intiContent();

	intiPage = function (data) {
		$("#page1").empty();
		$("#page1").append(
				'<div align="center"><img alt="" src="../images/school.png">'+
//				'	<p class="title">福建工程学院国脉信息学院</p>'+
				'	<p class="title">'+data.name+'</p>'+
				'	<p><span class="BigFont">策</span></p>'+
				'	<p><span class="BigFont">划</span></p>'+
				'	<p><span class="BigFont">书</span></p>'+
				'</div>'+
				'<div align="center" class="DepartmentName">'+
				'	<p class="Tail" style="margin-top: 10em;">'+data.department+'</p>'+
				'</div>');
		$("#page2").append('<div id="divpage"></div>');
		re = new RegExp("<br/>","g"); //定义正则表达式
		var goal = data.goal.replace(re,"</p><p>");
		var arrangements = data.arrangements.replace(re,"</p><p>");
		var flow = data.flow.replace(re,"</p><p>");
		var content = data.content.replace(re,"</p><p>");
		var budget = data.budget.replace(re,"</p><p>");
		var award = data.award.replace(re,"</p><p>");
		var description = data.description.replace(re,"</p><p>");
		$("#divpage").append(
				'<div align="center" style="text-align: center;">'+
				'	<p class="Name">福建工程学院国脉信息学院'+data.name+'</p>'+
				'</div>'+
				'<div class="FirstLine Text">'+
				'	<p class="FirstTitle">一、活动主题：</p>'+
				'	<p>'+data.theme+'</p>'+
				'	<p class="FirstTitle">二、活动目的：</p>'+
				'	<p>'+goal+'</p>'+
				'	<p class="FirstTitle">三、活动时间：</p>'+
				'	<p>'+data.beginTime+'</p>'+
				'	<p class="FirstTitle">四、活动地点：</p>'+
				'	<p>'+data.place+'</p>'+
				'	<p class="FirstTitle">五、活动对象：</p>'+
				'	<p>'+data.person+'</p>'+
				'	<p class="FirstTitle">六、活动形式：</p>'+
				'	<p>'+data.form+'</p>'+
				'	<p class="FirstTitle">七、主办单位：</p>'+
				'	<p>'+data.department+'</p>'+
				'	<p class="FirstTitle">八、承办单位：</p>'+
				'	<p>'+data.department+'</p>'+
				'	<p class="FirstTitle">九、活动人员安排</p>'+
				'	<p>'+arrangements+'</p>'+
				'	<p class="FirstTitle">十、活动流程</p>'+
				'	<p>'+flow+'</p>'+
				'	<p class="FirstTitle">十一、活动内容：</p>'+
				'	<p>'+content+'</p>'+
				'	<p class="FirstTitle">十二、资金预算：</p>'+
				'	<p>'+budget+'</p>'+
				'	<p class="FirstTitle">十三、奖励：</p>'+
				'	<p>'+award+'</p>'+
				'</div>');
		$("#divpage").append(
				'<div align="right">'+
				'	<div class="Sign">'+
				'		<p class="FirstTitle" align="center">福建工程学院国脉信息学院</p>'+
				'		<p class="FirstTitle" align="center">'+data.department+'</p>'+
				'		<p class="FirstTitle" align="center">'+data.creatTime+'</p>'+
				'	</div>'+
				'</div>');
		alert($("#divpage").outerHeight());
	}
});