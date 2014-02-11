<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userlist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=basePath%>images/css/style.css" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>images/jquery-1.7.1.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		$.ajax({
					type:"get",
					dataType:"json",
					url:"<%=basePath%>api/wifidog_user/get_all",
					//data:{username:$("#username").val(),pw:$("#password").val()},
					success:function(data){
						alert(data.result);
					},
					error:function(XMLHttpRequest, textStatus, errorThrown){
						alert("error");
					}
				})
		$(document).ready(function(){
			
		
		});
	</script>
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
