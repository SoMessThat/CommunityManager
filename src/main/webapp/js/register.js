$(function(){
	// 注册
	$("#lang-btn1").click(function () {
		var tel = $.trim($("#tel").val());
		var code = $.trim($("#veri-code").val());
		var agree = $.trim($("#agree").val());
		if (agree=='0') {
			$('.error').removeClass('hide');
			$('.error').text("请先阅读并接受 《XXXX协议说明》");
			return;
		}
		$.ajax({
            url: '../registerVri.do',
            type: 'post',
            dataType: 'json',
            async: true,
            data: {'phone':tel,'code':code},
            success:function(data){
	            	if (data.result == "error") {
	            		$('.error').removeClass('hide');
	        			$('.error').text(data.errors);
					}
	            	else {
	            		$('#form1').addClass('hide');
	            		$("#lang-btn1").addClass('hide');
	            		$('.reg_checkboxline').addClass('hide');
	            		$('.reg_checkboxline').addClass('hide');
	            		$('#form2').removeClass('hide');
	            		$("#lang-btn2").removeClass('hide');
					}
            },
            error:function(res){
                alert(res);
            }
        });
    });
	
	$("#lang-btn2").click(function () {
		var pass1 = hex_md5($.trim($("#passport").val()));
		var pass2 = hex_md5($.trim($("#passport2").val()));
		var agree = $.trim($("#agree").val());
		if (agree=='0') {
			$('.error').removeClass('hide');
			$('.error').text("请先阅读并接受 《XXXX协议说明》");
			return;
		}
		if (pass1 != pass2) {
			$('.confirmpwd-err').removeClass('hide');
			$('.confirmpwd-err').text("两次密码不一致");
			return;
		}
		$.ajax({
            url: '../register.do',
            type: 'post',
            dataType: 'json',
            async: true,
            data: {'pass':pass1},
            success:function(data){
	            	if (data.result == "error") {
	            		$('.error').removeClass('hide');
	        			$('.error').text(data.errors);
	        			$('#form1').removeClass('hide');
	        			$("#lang-btn1").removeClass('hide');
	        			$('.reg_checkboxline').removeClass('hide');
	        			$('.reg_checkboxline').removeClass('hide');
	        			$('#form2').addClass('hide');
	        			$("#lang-btn2").addClass('hide');
					}
	            	else {
	            		window.location.href=data.data;
					}
            },
            error:function(res){
                alert(res);
            }
        });
    });
	
	function checkPhone(phone){
		var status = true;
		if (phone == '') {
			$('.num2-err').removeClass('hide').find("em").text('请输入手机号');
			return false;
		}
		var param = /^1[34578]\d{9}$/;
		if (!param.test(phone)) {
			$('.error').removeClass('hide');
			$('.error').text('手机号不合法，请重新输入');
			return false;
		}
		return status;
	}
	
	$(".form-data").delegate(".send","click",function () {
		var phone = $.trim($('#tel').val());
		if (checkPhone(phone)) {
			//发送短信
				$.ajax({
		            url: '../sendMessage.do',
		            type: 'post',
		            dataType: 'json',
		            async: true,
		            data: {phone:phone,type:"register"},
		            success:function(data){
		                if (data.result == 'error') {
		                	$('.error').removeClass('hide');
		        			$('.error').text(data.errors);
		                } else {
		                	
		                }
		            },
		            error:function(){
		                
		            }
		        });
				var oTime = $(".form-data .time"),
				oSend = $(".form-data .send"),
				num = parseInt(oTime.text()),
				oEm = $(".form-data .time em");
				$(this).hide();
				oTime.removeClass("hide");
				var timer = setInterval(function () {
					var num2 = num-=1;
					oEm.text(num2);
					if(num2==0){
						clearInterval(timer);
						oSend.text("重新发送验证码");
						oSend.show();
						oEm.text("60");
						oTime.addClass("hide");
					}
				},1000);
		}
    });


});