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
	
	layui.use(['jquery','layer','form'], function() {
		var $ = layui.jquery,
		layer = layui.layer,
		form = layui.form;
		form.on('submit(demo1)', function(data){
			alert($("#endTime").val());
		});
	});
});