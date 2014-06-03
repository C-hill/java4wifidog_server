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
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=basePath%>static/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=basePath%>static/bootstrap/css/starter-template.css">
	<link rel="stylesheet" href="<%=basePath%>static/css/login.css">
	<script type="text/javascript" src="<%=basePath%>images/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
		});
	</script>
  </head>
  <body>
    <!--<div id="container">
			<form id="form" method="post" action="<%=basePath%>loginValidate">
                <input type="hidden" name="gw_address" value="${param.gw_address}">
                <input type="hidden" name="gw_port" value="${param.gw_port}">
                <input type="hidden" name="gw_id" value="${param.gw_id}">
                <input type="hidden" name="url" value="${param.url}">
                <input type="hidden" name="dev_id" value="${param.dev_id}">
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
		</div>-->
	<div class="container">
      <form class="form-signin" role="form" method="post" action="<%=basePath%>loginValidate">
      	<input type="hidden" name="gw_address" value="${param.gw_address}">
        <input type="hidden" name="gw_port" value="${param.gw_port}">
        <input type="hidden" name="gw_id" value="${param.gw_id}">
        <input type="hidden" name="url" value="${param.url}">
        <input type="hidden" name="dev_id" value="${param.dev_id}">
        <h3 class="form-signin-heading">请认证登录</h3>
        <input type="text" class="form-control" name="username" placeholder="用户名" required autofocus>
        <input type="password" class="form-control" name="password" placeholder="密码" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">确定</button>
      </form>
    </div>
  </body>
</html>
