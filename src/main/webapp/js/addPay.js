$(function(){
//	layui.config({
//        base: '../src/' //此处路径请自行处理, 可以使用绝对路径
//    }).extend({
//        formSelects: 'formSelects-v4'
//    });
    //加载模块
        	layui.use(['jquery', 'formSelects'], function(){
        		var formSelects = layui.formSelects;
        		
        		formSelects.config('selectId', {
                    beforeSuccess: function(id, url, searchVal, result){
                        //我要把数据外层的code, msg, data去掉
                        result = result.data;
                        //我要反转name
                        $.each(result, function(index, item) {
                            item.name && (item.name = item.name.split('').join(''))
                        });
                        //然后返回数据
                        return result;
                    }
                }).data('selectId', 'server', {
                    url: '../CmPayment/getEmplayee.do'
                });
        		formSelects.render();
        	});
        	
        	$("#demo1").click(function () {
        		$.ajax({
                    url: '../CmPayment/addCmPayment.do',
                    type: 'post',
                    dataType: 'json',
                    async: true,
                    data: {
                    	cmPayment_name:$("#name").val(),
                		},
                    success:function(data){
                        if (data.result == 'error') {
                        	layer.msg(data.errors[0], {icon: 5,time: 1000});
                        	layer.msg("添加成功，请记得通知哦", {icon: 1,time: 1000});
                        } else {
                        	layer.msg("添加成功，请记得通知哦", {icon: 1,time: 1000});
                        }
                    },
                    error:function(){
                    	layer.msg("添加成功，请记得通知哦", {icon: 1,time: 1000});
                    }
                });
        		return false;
        	});
	
});