<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>接口测试</title>
    
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
  apfree版wifidog认证服务器相关接口测试<hr>
    <a href="<%=basePath%>wifidog.jsp">wifidog接口</a><br><br>
    <br>
    <a href="<%=basePath%>router.jsp">router接口</a><br><br>
    <a href="<%=basePath%>device.jsp">device接口</a><br><br>
    <a href="<%=basePath%>user.jsp">user接口</a><br><br>
    <a href="<%=basePath%>host.jsp">host接口</a><br><br>
    <a href="<%=basePath%>ipwhite.jsp">ipwhite接口</a><br><br>
    <a href="<%=basePath%>macblack.jsp">macblack接口</a><br><br>
    <a href="<%=basePath%>macwhite.jsp">macwhite接口</a><br><br>
    
    为了满足wifidog的接口标准，请配置Tomcat的server.xml文件，参见：https://github.com/C-hill/java4wifidog_server/wiki
  </body>
</html>
