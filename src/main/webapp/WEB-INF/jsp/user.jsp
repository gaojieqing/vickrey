<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Access-Control-Allow-Origin" content="*" />
    <title>用户管理界面</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript">
    //插入数据
    function put() {
        //$.post("http://localhost:8080/vickrey/user", "{username:"+$("#username").val()+", password:"+$("#password").val()+"}", function(data) {
		//	$("#message").html(data);
		//}, "json");
		
		$.ajax({
			url: "/vickrey/user",
			type:'POST',
			data:JSON.stringify({username:$("#username").val(),password:$("#password").val()}),
			dataType:'json',
			contentType:'application/json; charset=utf-8',
			success: function(data){
				console.log(data)
			}
		});
    }

    //删除数据
    function del() {
        //$.delete("http://localhost:8080/vickrey/user", "{username:"+$("#username").val()+"}", function(data) {
		//	$("#message").html(data);
		//}, "json");
		
		$.ajax({
			url: "/vickrey/user",
			type:'DELETE',
			data:JSON.stringify({username:$("#username").val()}),
			dataType:'json',
			contentType:'application/json; charset=utf-8',
			success: function(data){
				console.log(data)
			}
		});
    }
	</script>
</head>
<body>
	<input id="username" type="text"/><br/>
	<input id="password" type="text"/><br/>
    <button onclick="put()">插入</button>
    <hr/>
    <button onclick="del()">删除</button>
    <hr/>
    <div id="message"></div>
</body>
</html>