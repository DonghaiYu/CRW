<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>山东科技大学课程资源网(发布作业)</title>
    
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
   	<div id="main">
		<div >
			<jsp:include   page="../../jsp/common/maintop.jsp" flush="true"/>  
		</div>
		<div id="content">
			<div id="leftmenu" >
		
				
			</div>
			<div id="content_text">
			
       <form name="question" action="updateQuestion.action"  method="post" >

<table align="center" border="1px"  width="60%" height="235"  >
	<tr>
		<th colspan="4" height="34" >更改 </th>
	</tr>
	<tr>
	  <td width="120" height="32">编号：</td>
	  <td width="230"><input type="text"  readonly name="id" value="${question.id}">
	  </td>
	</tr>	
	<tr>
	  <td width="120" height="32">名称：</td>
	  <td width="230"><input type="text"  name="name" value="${question.name}">
	  </td>
	</tr>	
	<tr>
		<td width="90" height="32">内容：</td>
		 <td width="230">
		 <textarea name="reply" rows="5" cols="65"  >${question.reply}</textarea>
		
	  </td>
    </tr>
</table>
  <div align="right" style="width:80%">
    <input type="submit" name="button" value="提交" class="right-button02"/> 
    </td></td></td></td></td>
    <input type="reset" name="" value="重置" class="right-button02" onclick=""/>
    <input name="button" type="button" class="right-button02" value="返回" onclick="javascript:history.back();"/>
  </div>
</form>
			</div>
		</div>

	</div>
  </body>
</html>
