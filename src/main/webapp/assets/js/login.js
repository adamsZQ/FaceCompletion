layui.use(['form'], function() {
	var form = layui.form;
    //location.replace("index.html");
	checkLogin();
	//提交
	form.on('submit(LAY-user-login-submit)', function(obj) {
		obj.field.verkey = codeKey;
		layer.load(1);
		/*$.post("user/login", obj.field, function(data) {
			if (data.code == 200) {
				layer.msg(data.msg,{icon: 1});
				localStorage.setItem("token", data.token);
				localStorage.setItem("user", JSON.stringify(data.user));
				setTimeout(function() {
					location.replace("index.html");
				}, 2000);
			} else {
				layer.closeAll('loading');
				layer.msg(data.msg,{icon: 2});
			}
		}, "json");*/
        $.ajax({
            url:"user/login",
            type:"POST",
            data:obj.field,
            dataType:"json",
            success: function(data) {
                console.log(data);
                //$("#result").val(JSON.stringify(data));
                layer.msg(data.msg,{icon: 1});
                //localStorage.setItem("token", data.token);
                localStorage.setItem("user", JSON.stringify(data));
                setTimeout(function() {
                    location.replace("index.html");
                }, 2000);
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
        })
        //location.replace("index.html");
	});
	
	getCode();  //获取验证码
	$("#LAY-user-get-vercode").click(function(){
		getCode();
	});
});

//获取验证码
var codeKey = null;
function getCode(){
	if(codeKey==null){
		codeKey = guid();
	}
	$("#LAY-user-get-vercode").attr("src","image/captcha?codeKey="+codeKey+"&n="+Math.random());
}

//检查是否登录
function checkLogin(){
	var tempUser = JSON.parse(localStorage.getItem("user"));
	if (tempUser != null) {
		location.replace("index.html");
	}
}

//生成uuid
function guid() {
    function S4() {
       return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
    }
    return (S4()+S4()+"-"+S4()+"-"+S4()+"-"+S4()+"-"+S4()+S4()+S4());
}