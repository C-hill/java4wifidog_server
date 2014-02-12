<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String mypath="http://192.168.1.97:8080/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>user测试</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  -----------------------获取-------------------------------------<br>
  		<form name='get' action="<%=basePath%>api/wifidog_user/get_all" method="get">
			<br>
			device_token:<input type="text" name="device_token" value="adfsadf1312" /> <br>
			<input type="submit" value="确定"/>
		</form>
  -----------------------增加-------------------------------------<br>
  		<form name='add' action="<%=basePath%>api/wifidog_user/add" method="get">
			<br>
			device_token:<input type="text" name="device_token" value="adfsadf1312" /> <br>
			username:<input type="text" name="username" value="" /> <br>
			password:<input type="text" name="password" value="" /> <br>
			状态:<select name="active">
				<option value="1">激活</option>
				<option value="0">非激活</option>
			</select><br>
			<input type="submit" value="确定"/>
		</form>
  -----------------------删除-------------------------------------<br>
  		<form name='del' action="<%=basePath%>api/wifidog_user/delete" method="get">
			<br>
			device_token:<input type="text" name="device_token" value="adfsadf1312" /> <br>
			id:<input type="text" name="id" value="" />(正整数) <br>
			<input type="submit" value="确定"/>
		</form>
  -----------------------修改-------------------------------------<br>
  		<form name='modify' action="<%=basePath%>api/wifidog_user/modify" method="get">
			<br>
			device_token:<input type="text" name="device_token" value="adfsadf1312" /> <br>
			id:<input type="text" name="id" value="" /> <br>
			username:<input type="text" name="username" value="" /> <br>
			password:<input type="text" name="password" value="" /> <br>
			<input type="submit" value="确定"/>
		</form>
  -----------------------启用禁用-------------------------------------<br>
  		<form name='active' action="<%=basePath%>api/wifidog_user/active" method="get">
			<br>
			device_token:<input type="text" name="device_token" value="adfsadf1312" /> <br>
			id:<input type="text" name="id" value="" /> <br>
			状态:<select name="active">
				<option value="1">激活</option>
				<option value="0">非激活</option>
			</select><br>
			<input type="submit" value="确定"/>
		</form>

  </body>
</html>
