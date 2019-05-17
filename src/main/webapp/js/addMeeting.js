$(function(){
	jeDate("#beginTime",{
	    format:"YYYY-MM-DD",
	    isTime:true,
	    minDate:"2014-09-19",
	    isinitVal:true
	})

	jeDate("#endTime",{
		multiPane:false,
	    range:" ~ ",
	    minDate:'2017-06-16 10:20:25',
	    maxDate:'2019-06-16 18:30:35',
	    format: 'hh:mm:ss'
	});
	
	$("#add").click(function () {
		a = $("#endTime").val().split(" ~ ");
		var beginTime =$("#beginTime").val()+a[0];
		var endTime =$("#beginTime").val()+a[1];
		$.ajax({
            url: '../CmAttendance/addCmAttendance.do',
            type: 'post',
            dataType: 'json',
            async: true,
            data: {
            	cmAttendance_name:$("#name").val(),
            	cmAttendance_content:$("#content").val(),
            	cmAttendance_place:$("#place").val(),
            	cmAttendance_beginTime:beginTime,
            	cmAttendance_endTime:endTime
        		},
            success:function(data){
                if (data.result == 'error') {
                	layer.msg(data.errors[0], {icon: 5,time: 1000});
                } else {
                	layer.msg("添加成功，请记得通知哦", {icon: 1,time: 1000});
                }
            },
            error:function(){
            	layer.msg("网络连接失败，请检查网络", {icon: 5,time: 1000});
            }
        });
		return false;
	});
});