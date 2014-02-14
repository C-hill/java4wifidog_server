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
    
    <title>用户认证页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=basePath%>images/jquery-1.7.1.min.js"></script>
	<script type="text/javascript">
	</script>
  </head>
  <body>
  此页面为用户认证页面<hr><br><br><br>
  	<div>
			<form  method="post" action="<%=basePath%>loginValidate">
                <input type="hidden" name="gw_address" value="${param.gw_address}">
                <input type="hidden" name="gw_port" value="${param.gw_port}">
                <input type="hidden" name="gw_id" value="${param.gw_id}">
                <input type="hidden" name="url" value="${param.url}">
                <input type="hidden" name="dev_id" value="${param.dev_id}">
				<input  type="submit"  value="开始上网" />
			</form>
	</div>
  </body>
</html>
