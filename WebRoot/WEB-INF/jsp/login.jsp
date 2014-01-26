<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//System.out.println(path);
//System.out.println(basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆认证</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="<%=basePath%>images/css/style.css" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>images/jquery-1.7.1.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			/*$("#sure").click(function(){
				$.ajax({
					type:"post",
					dataType:"json",
					url:"<%=basePath%>loginValidate",
					data:{username:$("#username").val(),pw:$("#password").val()},
					success:function(data){
						if(data.code==0){
							alert("用户名或密码错误,用户名：admin，密码：admin");
						}else{
							alert("success");
							document.location.href="http://www.baidu.com";
						}
					},
					error:function(XMLHttpRequest, textStatus, errorThrown){
						alert("error");
					}
				});
			});*/
		});
	</script>
  </head>
  <body>
    <div id="container">
			<form id="form" method="post" action="<%=basePath%>loginValidate">
                <input type="hidden" name="gw_address" value="${param.gw_address}">
                <input type="hidden" name="gw_port" value="${param.gw_port}">
                <input type="hidden" name="gw_id" value="${param.gw_id}">
                <input type="hidden" name="url" value="${param.url}">
                <div class="login">认证登录</div>
				<div class="username-text">用户名：</div>
				<div class="password-text">密码：</div>
				<div class="username-field">
					<input id="username" type="text" name="username" value="" />
				</div>
				<div class="password-field">
					<input id="password" type="password" name="password" value="" />
				</div>
				<input id="sure" type="submit"  value="确定" />
			</form>
		</div>
  </body>
</html>
