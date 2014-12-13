<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>山东科技大学课程资源网(教师作业端)</title>
<link rel="stylesheet" type="text/css" href="css/common/main.css">


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="js/common/jquery-1.11.1.js"></script>
</head>

<body>

	<div id="main">
		<div >
			<jsp:include   page="../../jsp/common/maintop.jsp" flush="true"/>  
		</div>
		<div id="content">
			<div id="leftmenu" >
		
				
			</div>
			<div id="content_text">
			作业
			</div>
		</div>

	</div>
</body>
</html>
