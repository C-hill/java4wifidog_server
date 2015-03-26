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
    
    <title>error</title>
    
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
	<div class="container">
		错误信息:${param.message}
    </div>
  </body>
</html>
