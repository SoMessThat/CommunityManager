function checkState(state){
	if (state == '未阅') {
		return 'come';
	}
	if (state == '已阅') {
		return 'open';
	}
	return 'close';
}

function look(){
	$('#divv').removeClass('hide');
}

function closeDialog(){
	$('#divv').addClass('hide');
}

$(function(){
	$('#EmployeeDemo').html("");
	layui.use('flow', function(){
		var flow = layui.flow;
		flow.load({
			elem: '#EmployeeDemo',
			done: function(page, next){
				var lis = [];
				$.get('../CmUser/queryEmployee.do?limit=6&page='+page,function(res){
					layui.each(res.data, function(index, item){
						lis.push('<div class="layui-col-md4 layui-col-sm6">');
						lis.push('<div class="layadmin-contact-box" > ');
						lis.push('<div class="layui-col-md4 layui-col-sm6">');
						lis.push('<div class="layadmin-text-center">');
						lis.push('<img src="'+item.avatar+'">');
						lis.push('<div class="layadmin-maillist-img layadmin-font-blod">'+item.student.name+'</div>');
						lis.push('<div class="layadmin-maillist-img layadmin-font-blod">');
						lis.push('<div class="layui-btn-group" style="margin-top: 12px">');
						lis.push('<button class="layui-btn layui-btn-primary layui-btn-sm" onclick="look()">查看</button>');
						lis.push('<button class="layui-btn layui-btn-primary layui-btn-sm">辞退</button>');
						lis.push('</div>');
						lis.push('</div>');
						lis.push('</div>');
						lis.push('</div>');
						lis.push('<div class="layui-col-md8 layadmin-padding-left20 layui-col-sm6">');
						lis.push('<div class="layui-row">');
						lis.push('<div class="layui-col-md8">');
						lis.push('<h3 class="layadmin-title">');
						lis.push('<strong>'+item.username+'</strong>');
						lis.push('</h3>');
						lis.push('</div>');
						lis.push('<div class="layui-col-md2">');
						lis.push('<span style="line-height: 2em;text-align: center;">'+item.student.sex+'</span>');
						lis.push('</div>');
						lis.push('<div class="layui-col-md2">');
						lis.push('<span style="line-height: 2em;text-align: center;">'+item.student.volk+'</span>');
						lis.push('</div>');
						lis.push('</div>');
						lis.push('<p class="layadmin-textimg">');
						lis.push('<i class="layui-icon layui-icon-location"></i>');
						lis.push(item.student.address);
						lis.push('</p>');
						lis.push('<div class="layadmin-address">');
						lis.push('<p>'+item.student.birthday+'<p>');
						lis.push('<p><i class="layui-icon layui-icon-cellphone"></i>:'+item.tel+'</p>');
						lis.push('<p><i class="layui-icon layui-icon-cellphone"></i>:'+item.student.email+'</p>');
						lis.push('<p>'+item.student.school+'</p>');
						lis.push('<p>'+item.student.major+''+item.student.grade+'级'+item.student.clas+'</p>');
						lis.push('</div>');
						lis.push('</div>');
						lis.push('</div>');
						lis.push('</div>');
					}); 
					next(lis.join(' '), page < res.count/6);    
				},"json");
			}
		});
	});
	see= function (id){
		window.open ('../CmWorkSummary/openSummaryInfo.do');
	}
});