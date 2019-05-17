
$(function(){
	
	var row1 =  '<div class="layui-row">'+
				'	<div class="six layui-input-inline">'+
				'		<div class="name layui-input-inline">'+
				'			<input type="text" class="layui-input" id="" />'+
				'		</div>'+
				'		<div class="value layui-input-inline">'+
				'			<select class="layui-input" id="" lay-search>'+
				'				<option value="0571" selected>普通当行输入框</option>'+
				'				<option value="0572" selected>专业选择下拉框</option>'+
				'				<option value="0573" selected>宿舍选择下拉框</option>'+
				'			</select>'+
				'		</div>'+
				'	</div>'+
				'</div>';
	var row2 =  '<div class="layui-row">'+
			    '	<div class="three layui-input-inline">'+
				'		<div class="name layui-input-inline">'+
				'			<input type="text" class="layui-input" id="" />'+
				'		</div>'+
				'		<div class="value layui-input-inline" style="margin-left: -5;">'+
				'			<select class="layui-input" id="" lay-search>'+
				'				<option value="0571" selected>layim</option>'+
				'			</select>'+
				'		</div>'+
				'	</div>'+
				'	<div class="three layui-input-inline">'+
				'		<div class="name layui-input-inline">'+
				'			<input type="text" class="layui-input" id="" />'+
				'		</div>'+
				'		<div class="value layui-input-inline" style="margin-left: -5;">'+
				'			<select class="layui-input" id="" lay-search>'+
				'				<option value="0571" selected>layim</option>'+
				'			</select>'+
				'		</div>'+
				'	</div>'+
				'</div>';
//	var row3 = '<div id="row3"><div class="two"></div><div class="two"></div><div class="two"></div></div>';
//	var row4 = '<div id="row4"><div class="two"></div><div class="four"></div></div>';
	intiPage = function () {
		$("#Statement").append('');
	}
	addCol = function () {
		$("#rt1").append(row);
		$('#table').append(col);
		var divArr = $('#qw div ');
		$.each(divArr,function(i,n){
		});
	}
	intiPage();
	
	$('#addRow1').click(function(){
		$("#Statement").append(row1);
	});
	$('#addRow2').click(function(){
		$("#Statement").append(row2);
	});
	
});