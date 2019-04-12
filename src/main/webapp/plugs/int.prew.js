$(function () {
  // 分享简历
  $('.share').on('click', function () {
    $('.share-mask').fadeIn()
  })
  $('.close').on('click', function () {
    $('.share-mask').fadeOut()
  })
  // 简历分享开关
  $('.share-setting-btn').on('click', function () {
    $(this).hasClass('closed') ? $(this).removeClass('closed') : $(this).addClass('closed')
  })

  // 投递简历
  $('.send-box').on('click', '.close-send-box', function () {
    $('.send-box-mask').fadeOut()
  })
  $('.send').on('click', function () {
    $('.send-box-mask').fadeIn()
    $('html,body').animate({
      scrollTop: "0px",
    }, 600)
  })

  //错误提示
  function errormotify(tip) {
    $('<div class="errormotify"><div class="motify-inner"><span></span>' + tip + '</div></div>').appendTo("body");
    setTimeout(function () {
      $(".errormotify").hide();
    }, 3000);
  }
  //正确提示
  function okmotify(tip) {
    $('<div class="okmotify"><div class="motify-inner"><span></span>' + tip + '</div></div>').appendTo("body");
    setTimeout(function () {
      $(".okmotify").hide();
    }, 3000);
  }

  function refreshpage(tip) {
    $('<div class="okmotify"><div class="motify-inner"><span></span>' + tip + '</div></div>').appendTo("body");
    setTimeout(function () {
      $(".okmotify").hide();
      window.location.reload();
    }, 1500);
    //刷新当前页面.
  }

  // 简历提交
  function VerificationFrom(para) {
    if (!$(para).val().trim()) {
      errormotify('主题，姓名，邮箱不能为空！')
      return;
    }
    if (para == '#sendEmail') {
      if (!/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/.test($(para).val())) {
        errormotify('邮箱格式不对~')
        return;
      }
    }
    return true;
  }
  $(document).on('click', '.send-resume-btn span', function () {
    if (VerificationFrom('#SendTitle') && VerificationFrom('#truename') && VerificationFrom('#sendEmail')) {
      var data = {
        resumes_id: $('#resumes_id').val(),
        SendTitle: $('#SendTitle').val(),
        truename: $('#truename').val(),
        sendEmail: $('#sendEmail').val(),
        // fromEmail: $('#fromEmail').val(),
        sendTxt: $('#sendTxt').html()
      }
      $.ajax({
        type: 'POST',
        data: data,
        dataType: 'json',
        url: '/resume/resumeMailing',
        success: function (bakjson) {
          $('.send-box-mask').hide()
          $('#sendEmail').val('')
          // $('#fromEmail').val('')

          if (bakjson.error == '1') {
            if (bakjson.bakfuntion == 'errormotify') {
              errormotify(bakjson.errortip);
            }
          } else if (bakjson.error == '0') {
            if (bakjson.bakfuntion == 'okmotify') {
              errormotify(bakjson.errortip);
            } else {
              window[bakjson.bakfuntion](bakjson.errortip, bakjson.bakparameter);
            }
          }

          if (typeof (bakjson.bakurl) !== "undefined" && bakjson.bakurl !== '') {
            window.location = bakjson.bakurl;
          }
        }
      })
    }
  })

  // 复制网址
  var clipboard = new Clipboard('.CopyLink');
  clipboard.on('success', function (e) {
      okmotify("已复制到剪切板！");
      //console.log(e);
  });
  clipboard.on('error', function (e) {
      errormotify("您的浏览器不支持自动复制，请手工复制！");
      //console.log(e);
  });
})