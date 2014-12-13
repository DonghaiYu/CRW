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
    
    <title>山东科技大学课程资源网(问题答疑)</title>
    
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
		  <div id="content_text">
			<table width="100%" border="1"> 
			  <tr>
			   <td width="20%" align="center"><a>学生未解决的问题</a></td>
			   <td >
			     <table width="100%" border="1"> 
			      <thead>
							<th align="center">问题</th>
							 <th>操作</th>
						</thead>
<c:forEach var="question" items="${questions}">
  	   <tr >
			       <td width=75% align="left">${question.name}  </td>
			       <td align="center"><a href="getQuestionById.action?id=${question.id}">查看解决</a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			       </tr>
  </c:forEach>	
			      
			       
			     </table>
			     </td>
			   </tr>
			   
			      
			</table>
	<table width="100%" border="1">
	   <tr>
	     <td width="20%" align="center"><a>已解决的问题</a></td>
	      <td>
	        <table width="100%" border="1"> 
			      <thead>
							<th align="center">问题</th>
							 <th>操作</th>
						</thead>
<c:forEach var="question" items="${resolvedQuestions}">
  	   <tr >
			       <td width=75% align="left">${question.name} </td>
			       <td align="center"><a href="getQuestionById.action?id=${question.id}">查看</a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			       </tr>
  </c:forEach>	
			       
			     </table>
	      </td>
	   
	   </tr>
			
     </table>
   <table width="100%" border="1">
	  <tr>
	     <td width="20%" align="center"><a>学生意见</a>
	     </td>
	      <td>
	           <table width="100%" border="1"> 
			      <thead>
							<th align="center">意见</th>
							 <th>操作</th>
						</thead>
			      <c:forEach var="question" items="${suggests}">
  	   				<tr >
			       <td width=75% align="left">${question.name}  </td>
			       <td align="center"><a href="getQuestionById.action?id=${question.id}">查看回复</a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			       </tr>
  				</c:forEach>	
			       
			     </table>
	      </td>
	
	   </tr>	
			
   </table>
			
			</div>
    </div>
    </div>
  </body>
</html>
