<%@page import="com.crw.constant.CRWC"%>
<%@page import="com.crw.entity.User"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

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

<title>山东科技大学课程资源网</title>
<link rel="stylesheet" type="text/css" href="css/common/main.css">
<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css"
	type="text/css"></link>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="js/common/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/common/jquery.DigitClock.js"></script>
<script type="text/javascript"
	src="js/common/jquery.ztree.all-3.5.min.js"></script>
<script src="js/common/jquery.slideBox.min.js" type="text/javascript"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {

						$("#clock")
								.DigitClock(
										{
											fontSize : 18,
											background : "transparent",
											fontColor : "#d5b51f",
											timeFormat : "yyyy年MM月dd日   <br/>  HH<label>:</label>mm<label>:</label>ss "
										});

					});
</script>


</head>

<body>

	<div id="main">
		<div id="top_main">
			<div id="top">
				<div id="clock"></div>
				<div id="message">
					<table>
						<tr>

							<td><img src="images/common/userlogo.png" alt="当前用户">
							</td>
							<td width="10px"></td>
							<td style="color:white;font-family:"微软雅黑";>${session.user.username}
							</td>
							<td width="30px"></td>
							<td><a href="exit.action" style="color: red;"><img
									src="images/common/exit.png" alt="退出">
							</a>
							</td>
						</tr>
					</table>
				</div>
				<div id="mainmenu">
					<table id="menutable">
						<tr id="top_tr">
							<%
								String typePath = null;
								int typen = ((User) request.getSession().getAttribute("user"))
										.getType();
								if (typen == CRWC.ADMIN) {
									typePath = CRWC.ADM;
								} else if (typen == CRWC.STUDENT) {
									typePath = CRWC.STU;
								} else if (typen == CRWC.TEACHER) {
									typePath = CRWC.TEA;
								}
								if (typen == CRWC.ADMIN) {
							%>

							<td class="toptd"><a href="jsp/<%=typePath%>/index.jsp">首页</a>
							</td>
							<td class="toptd"><a href="resManage.action">资源管理</a>
							</td>
						
							<td class="toptd"><a href="userManage.action">用户管理</a>
							</td>
							<td class="toptd"><a href="depart_cour.action">部门与课程</a>
							</td>
							<td class="toptd"><a
								href="getMyResources.action">个人中心</a>
							</td>
						</tr>
						<%
							} else {
						%>
						<td class="toptd"><a href="jsp/<%=typePath%>/index.jsp">首页</a>
						</td>
						<td class="toptd"><a href="jsp/<%=typePath%>/source.jsp">课程资源</a>
						</td>
						<td class="toptd"><a href="getAllQuestion.action">问题答疑</a></td>
						<td class="toptd"><a href="getMyResources.action">个人中心</a>
						</td>
						<%
							}
						%>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
