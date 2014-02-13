<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>macwhite测试</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=basePath%>images/css/mystyle.css" type="text/css" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <font color="red"> 注：</font><br>
  <table border="1" cellspacing="1" cellpadding="0">
	  <tr>
	  	<td><font class="font-color-1"> device_token</font></td><td>对应ap表中'dev_md5'字段。</td>
	  </tr>
	  <tr>
	  	<td><font class="font-color-1"> mac</font></td><td>对应rule_macwhite表中'mac'字段。</td>
	  </tr>
  </table>
  	<br><br>
  -----------------------获取-------------------------------------<br>
  		<form name='get' action="<%=basePath%>api/client_op/macwhite/get" method="get">
			<br>
			device_token:<input type="text" name="device_token" value="" /> <br>
			<input type="submit" value="确定"/>
		</form>
  -----------------------增加-------------------------------------<br>
  		<form name='add' action="<%=basePath%>api/client_op/macwhite/add" method="get">
			<br>
			device_token:<input type="text" name="device_token" value="" /> <br>
			mac:<input type="text" name="mac" value="" /> <br>
			<input type="submit" value="确定"/>
		</form>
  -----------------------删除-------------------------------------<br>
  		<form name='del' action="<%=basePath%>api/client_op/macwhite/delete" method="get">
			<br>
			device_token:<input type="text" name="device_token" value="" /> <br>
			mac:<input type="text" name="mac" value="" /> <br>
			<input type="submit" value="确定"/>
		</form>

  </body>
</html>
