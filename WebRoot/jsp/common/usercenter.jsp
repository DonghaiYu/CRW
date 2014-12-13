<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.crw.constant.CRWC"%>
<%@page import="com.crw.entity.User"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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

<title>山东科技大学课程资源网(个人中心)</title>
<link rel="stylesheet" type="text/css" href="css/common/main.css">
<link rel="stylesheet" href="css/common/detail.css" type="text/css"></link>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="js/common/jquery-1.11.1.js"></script>
<script type="text/javascript">
	function showdialog(){
		var winNode = $("#dialog");  
    	winNode.fadeIn("slow"); 
	}
	function submitChange(){
		$.ajax({
				cache: false,
				type: "POST",
				url:"changePassword.action", //
				data:$('#dialog').serialize(), //要发送的是表单中的数据
				async: false,
				error: function(request) {
				alert("发送请求失败！");
				},
				success: function(data) {
				$("#returnMess").html(data); 
				alert(data);
				window.location.reload();
				}
		});
	}
</script>
</head>

<body>

	<div id="main">
		<div>

			<jsp:include page="../../jsp/common/maintop.jsp" flush="true" />
		</div>
		<div id="content">
			<table style="float: left;margin-left: 60px;margin-top: 40px;">
				<tr>
					<td>ID</td>
					<td>${session.user.id}</td>
				</tr>
				<tr>
					<td>创建日期</td>
					<td>${session.user.RDate}</td>
				</tr>
				<tr>
					<td>用户名</td>
					<td>${session.user.username}</td>
				</tr>
				<tr>
					<td>性别</td>
					<s:if test="#session.user.sex == false">
						<td>男</td>
					</s:if>
					<s:else>
						<td>女</td>
					</s:else>
				</tr>
				<tr>
					<td>Email</td>
					<td>${session.user.email}</td>
				</tr>
				<tr>
					<td><input type="button" onclick="showdialog()" value="修改密码">
					</td>
					<td>
						<form action="changePassword.action" method="post" id="dialog"
							style="display: none;">
							<table>
								<s:actionerror id="returnMess" />
								<tr>
									<td>原密码：</td>
									<td><input type="password" name="oldpass" />
									</td>
								</tr>
								<tr>
									<td>新密码：</td>
									<td><input type="password" name="newpass" />
									</td>
								</tr>
								<tr>
									<td><input type="button" value="提交"
										onclick="submitChange();" />
									</td>
									<td><input type="reset" name="重置" />
									</td>
								</tr>
							</table>
						</form></td>
				</tr>
			</table>
			<div style="float: left;margin-left: 30px;margin-top: 40px;">

				<p style="font-family: '微软雅黑';">我上传的资源：</p>
				<s:actionerror />
				<HR style="FILTER: alpha(opacity=100,finishopacity=0,style=2)"
					width="96%" color="gray" SIZE=10>
				<table>
					<tr id="topic">
						<td>操作</td>
						<td>名称</td>
						<td>所属课程</td>
						<td>上传时间</td>
						<td>下载次数</td>
					</tr>
					<c:forEach var="one" items="${allMyRes }">
						<tr class="item">
							<td><a
								href="deletRes.action?id=${one.id }" title="删除"><img src="images/common/delete.png" alt="delete">
							</a>
							</td>
							<td>
							<c:choose>  
						         <c:when test="${fn:length(one.name) > 16}">  
						             <c:out value="${fn:substring(one.name, 0, 16)}..." />  
						         </c:when>  
						        <c:otherwise>  
						           <c:out value="${one.name}" />  
						         </c:otherwise>  
						     </c:choose></td>
							<td>${one.course.name }</td>
							<td>${one.date }</td>
							<td>${one.DTimes }</td>
						</tr>
					</c:forEach>

				</table>
				共${resultNum }条数据；分${pageNum }页
				<c:url value="getMyResources.action" var="first">
					<c:param name="currentPage" value="1" />
				</c:url>
				<a href="${first}">首页</a>

				<c:url value="getMyResources.action" var="last">
					<c:param name="currentPage" value="${currentPage -1 }" />
				</c:url>
				<c:choose>
					<c:when test="${currentPage==1}"> 
        上一页
       </c:when>
					<c:otherwise>
						<a href="${last}">上一页</a>
					</c:otherwise>
				</c:choose>
				第${currentPage }页
				<c:url value="getMyResources.action" var="next">
					<c:param name="currentPage" value="${currentPage + 1 }" />
				</c:url>
				<c:choose>
					<c:when test="${currentPage==pageNum}"> 
       	 下一页
       </c:when>
					<c:otherwise>
						<a href="${next}">下一页</a>
					</c:otherwise>
				</c:choose>
				<c:url value="getMyResources.action" var="end">
					<c:param name="currentPage" value="${pageNum }" />
				</c:url>
				<a href="${end}">尾页</a> 
			</div>
		</div>

	</div>
</body>
</html>
