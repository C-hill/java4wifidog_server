<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>wifidog服务器</title>
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
  -----------------------auth接口-------------------------------------<br>
  		<form name='formAuth' action="<%=basePath%>wifidog/auth/" method="get">
			<br>
			dev_id:<input type="text" name="dev_id" value="" /> <br>
			run_mode:<input type="text" name="run_mode" value="runmode4asd" /> <br>
			wifidog_uptime:<input type="text" name="wifidog_uptime" value="wifidoguptime" /> <br>
			<input type="submit" value="确定"/>
		</form>
  -----------------------login接口-------------------------------------<br>
  		<form name='formLogin' action="<%=basePath%>wifidog/login/" method="get">
			<br>
			dev_id:<input type="text" name="dev_id" value="" /> <br>
			gw_address:<input type="text" name="gw_address" value="gwaddress" /> <br>
			gw_port:<input type="text" name="gw_port" value="gwport" /> <br>
			gw_id:<input type="text" name="gw_id" value="gwid" /> <br>
			url:<input type="text" name="url" value="url" /> <br>
			<input type="submit" value="确定"/>
		</form>
  -----------------------ping接口-------------------------------------<br>
  		<form name='formPing' action="<%=basePath%>wifidog/ping/" method="get">
			<br>
			gw_id:<input type="text" name="gw_id" value="gwid" /> <br>
			sys_uptime:<input type="text" name="sys_uptime" value="1101" /> <br>
			sys_memfree:<input type="text" name="sys_memfree" value="1234" /> <br>
			sys_load:<input type="text" name="sys_load" value="0.11" /> <br>
			wifidog_uptime:<input type="text" name="wifidog_uptime" value="387" /> <br>
			<input type="submit" value="确定"/>
		</form>
  -----------------------portal接口-------------------------------------<br>
  		<form name='formPortal' action="<%=basePath%>wifidog/portal/" method="get">
			<br>
			gw_id:<input type="text" name="gw_id" value="gwid" /> <br>
			dev_id:<input type="text" name="dev_id" value="dev_id" /> <br>
			<input type="submit" value="确定"/>
		</form>

  </body>
</html>
