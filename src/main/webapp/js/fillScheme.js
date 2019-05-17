$(function(){
	$("#demo1").click(function () {
		$.ajax({
            url: '../CmScheme/addCmScheme.do',
            type: 'post',
            dataType: 'json',
            async: true,
            data: {
        		},
            success:function(data){
                if (data.result == 'error') {
                	layer.msg("添加成功，请留意后续结果", {icon: 1,time: 1000});
                } else {
                	layer.msg("添加成功，请留意后续结果", {icon: 1,time: 1000});
                }
            },
            error:function(){
            	layer.msg("添加成功，请留意后续结果", {icon: 1,time: 1000});
            }
        });
		return false;
	});
});