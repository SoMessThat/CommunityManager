$(function(){
	var websocket = null;
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://localhost:8088/CommunityManager/websocket");
    }
    else {
        alert('当前浏览器 Not support websocket')
    }

    //连接发生错误的回调方法
    websocket.onerror = function () {
        alert("WebSocket连接发生错误");
    };

    //连接成功建立的回调方法
    websocket.onopen = function () {
//     	alert("WebSocket连接成功");
    	websocket.send((new Date()).toLocaleString()+"  小五进入了会议");
    }

    //接收到消息的回调方法
    websocket.onmessage = function (event) {
//     	alert(event.data);
    	$('#message').append('<li><a href="#">'+event.data+'</a></li>');
    	if (event.data.indexOf("attendance") >= 0 ) {
    		var str = event.data.split("|");
    		$('#'+str[1]).addClass("full");
    		$('#count').html((parseInt($('#count').html())+1));
		}
    }

    //连接关闭的回调方法
    websocket.onclose = function () {
//     	alert("WebSocket连接关闭");
    	websocket.send((new Date()).toLocaleString()+"  小五离开了会议");
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        closeWebSocket();
    }

    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
    	alert(innerHTML);
    }

    //关闭WebSocket连接
    function closeWebSocket() {
        websocket.close();
    }
    
	//滚动条
	$('#myscroll').myScroll({
		speed: 40, //数值越大，速度越慢
		rowHeight: 26 //li的高度
	});
	
	chooseSeat= function (e){
		if ($(e).hasClass("full")) {
			return false;
		}
		if ($("#seat").find(".choose").length>0) {
			$luck.find(".choose").removeClass("choose");
		}
		$(e).addClass("choose");
	}

	//签到
	attendance = function () {	
		if ($("#seat").find(".choose").length==1) {
			var id = $luck.find(".choose").attr('id');
			alert(id);
			//签到
			$("#"+id).removeClass("choose");
			websocket.send('attendance|'+id);
		}
	}
	
	//座位初始化
	for (var row = 0; row < 7; row++) {
		$("#seat").append('<p id=seatRow_'+row+'></p>');
		for (var col = 0; col < 10; col++) {
			$("#seatRow_"+row).append('<span id=seat_'+(row*10+col)+' class="seats-block seat null" onclick="chooseSeat(this)"></span>');
		}
	}
	$("#seat").append('<p style=" margin-left: 5%; ">已签到人数：<span id="count" style=" padding:10px;font-size: 31px;">6</span>人<span>'+
			'<input class="layui-btn layui-btn-small layui-btn-normal see" style="float: right;margin-right: 5%;" onclick="attendance()" value="签到"></span></p>');
	
	//抽取幸运观众
	var luck={
			index:-1,	//当前转动到哪个位置，起点位置
			count:0,	//总共有多少个位置
			timer:0,	//setTimeout的ID，用clearTimeout清除
			speed:20,	//初始转动速度
			times:0,	//转动次数
			cycle:100,	//转动基本次数：即至少需要转动多少次再进入抽奖环节
			prize:-1,	//中奖位置
			init:function(id){
				if ($("#"+id).find(".seats-block").length>0) {
					$luck = $("#"+id);
					$units = $luck.find(".seats-block");
					this.obj = $luck;
					this.count = $units.length;
					$luck.find("#seat_"+this.index).addClass("active");
				};
			},

			roll:function(){
				var index = this.index;
				var count = this.count;
				var luck = this.obj;
				$(luck).find("#seat_"+index).removeClass("active");
				index += 1;
				if (index>count-1) {
					index = 0;
				};
				$(luck).find("#seat_"+index).addClass("active");
				this.index=index;
				return false;
			},
			stop:function(index){
				this.prize=index;
				return false;
			}
	};


	function roll(){
		luck.times += 1;
		luck.roll();
		if (luck.times > luck.cycle+10 && luck.prize==luck.index) {
			clearTimeout(luck.timer);
			luck.prize=-1;
			luck.times=0;
		}else{
			if(luck.speed > 1000){
				return false;
			}
			if (luck.times<luck.cycle) {
				luck.speed -= 5;
			}else if(luck.times==luck.cycle) {
				var index = Math.random()*(luck.count)|0;
				luck.prize = index;		
			}else{
				if (luck.times > luck.cycle+10 && ((luck.prize==0 && luck.index==7) || luck.prize==luck.index+1)) {
					luck.speed += 110;
				}else{
					luck.speed += 80;
				}
			}
			if (luck.speed<20) {
				luck.speed=20;
			};

			luck.timer = setTimeout(roll,luck.speed);
		}
		return false;
	}
	luck.init('seat');
	luck.speed=20;
	luck.cycle=50+Math.ceil(Math.random()*50);
//	roll();


});