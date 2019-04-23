$(function(){
//	layui.config({
//        base: '../src/' //此处路径请自行处理, 可以使用绝对路径
//    }).extend({
//        formSelects: 'formSelects-v4'
//    });
    //加载模块
    layui.use(['jquery', 'formSelects'], function(){
        var formSelects = layui.formSelects;
        formSelects.render('selectId');
        layui.formSelects.data('selectId', 'local', {
            arr: [
                {"name": "小赵", "value": 1,"selected":"","disabled":""},
                {"name": "小钱", "value": 2,"selected":"","disabled":""},
                {"name": "小孙", "value": 3,"selected":"selected","disabled":""},
                {"name": "小李", "value": 4,"selected":"selected","disabled":""},
                {"name": "小周", "value": 11,"selected":"","disabled":""},
                {"name": "小吴", "value": 12,"selected":"","disabled":""},
                {"name": "小郑", "value": 13,"selected":"selected","disabled":""},
                {"name": "小王", "value": 14,"selected":"selected","disabled":""},
                {"name": "小冯", "value": 21,"selected":"","disabled":"disabled"},
                {"name": "小陈", "value": 22,"selected":"","disabled":""},
                {"name": "小褚", "value": 23,"selected":"selected","disabled":""},
                {"name": "小卫", "value": 24,"selected":"selected","disabled":""},
                {"name": "小蒋", "value": 31,"selected":"","disabled":""},
                {"name": "小沈", "value": 32,"selected":"","disabled":""},
                {"name": "小韩", "value": 33,"selected":"selected","disabled":""},
                {"name": "小杨", "value": 34,"selected":"selected","disabled":""},
                {"name": "小朱", "value": 51,"selected":"","disabled":""}
            ]
        });
//        formSelects.data('select1', 'server', {
//            url: 'http://yapi.demo.qunar.com/mock/9813/layui/data',
//            keyword: '水果'
//        });
//        {
//            "code":0,
//            "msg":"success",
//            "data":[
//                {"name":"北京","value":1,"selected":"","disabled":""},
//                {"name":"上海","value":2,"selected":"","disabled":""},
//                {"name":"广州","value":3,"selected":"selected","disabled":""},
//                {"name":"深圳","value":4,"selected":"","disabled":"disabled"},
//                {"name":"天津","value":5,"selected":"","disabled":""}
//            ]
//        }
//        alert(formSelects.value('selectId', 'valStr')); 
    });
});