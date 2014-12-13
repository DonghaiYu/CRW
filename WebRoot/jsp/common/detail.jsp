<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "/struts-tags"  prefix = "s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <link rel="stylesheet" href="css/common/detail.css"
	type="text/css"></link>
	
    <base href="<%=basePath%>">
    
    <title>资源</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/common/jquery-1.11.1.js"></script>

  </head>
  
  <body style="background-color: #fff;">
  <input type="button" onclick="getCourses()" value="我要上传">
      	<s:actionerror />
  		
  <div>
  <s:form action="uploadFile" method="post" enctype="multipart/form-data" style="display: none;" id="updateWindow">
    	选择文件所属课程：
    	<select id="selectcourse" class="selectcourse" name="selectcourse"></select><br />
    	<br />
    	选择要上传的文件:
    	<s:file name="uploadFile"></s:file>
    	<s:submit value="上传"></s:submit>
    	<s:reset value="重置"></s:reset>
    </s:form>
    </div>
        <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=2)" width="96%" color= "gray" SIZE=10>
    
 <form action="showDetail!searchExecute.action" method="post">
  <input type="text" name="queryCondition">
 	<input type="submit" value="给我搜">
 </form>
    <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=2)" width="96%" color= "blue" SIZE=10>
 
  <table >
  <tr id="topic">
  		<td ></td>
  		<td style="text-align: center;">资源</td>
  		<td >所属课程</td>
  		<td >所属学院</td>
  		<td >上传者</td>
  		<td >上传时间</td>
  		<td >下载次数</td>

  	</tr>
  <c:forEach var="one" items="${all }">
  	<tr class="item">
  		<td ><a href="FileDownload.action?fileName=${one.name}&path=${one.path}&id=${one.id}" title="下载"><img src="images/common/download2.png" alt="download"></a></td>
  		<td ><a href="preview.action?fileName=${one.name}&path=${one.path}&id=${one.id}" target="_blank" title="${one.name }">
  		<c:choose>  
         <c:when test="${fn:length(one.name) > 16}">  
             <c:out value="${fn:substring(one.name, 0, 16)}..." />  
         </c:when>  
        <c:otherwise>  
           <c:out value="${one.name}" />  
         </c:otherwise>  
     </c:choose>
  		</a></td>
  		<td >${one.course.name }</td>
  		<td >${one.course.department.name }</td>
  		<td >${one.user.username }</td>
  		<td>${one.date }</td>
  		<td >${one.DTimes }</td>
  	</tr>
  </c:forEach>
  
  </table>
      <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=2)" width="96%" color= "blue" SIZE=10>
  
  	共${resultNum }条数据；分${pageNum }页
 	<c:url value="showDetail!gotoPageOf.action" var="first">  
       <c:param name="currentPage" value="1" />    
      </c:url>
      <a href="${first}">首页</a>
      
      <c:url value="showDetail!gotoPageOf.action" var="last">  
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
      <c:url value="showDetail!gotoPageOf.action" var="next">  
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
      <c:url value="showDetail!gotoPageOf.action" var="end">  
       <c:param name="currentPage" value="${pageNum }" />    
      </c:url>
      <a href="${end}">尾页</a>
  <script type="text/javascript">
	function upload(){
		var ScreenWidth = screen.availWidth;

	    var ScreenHeight = screen.availHeight;
	    var StartX = (ScreenWidth - 100) / 2;
	    var StartY = (ScreenHeight - 40) / 2;
    	window.open("<%=basePath%>jsp/common/upload.jsp", '', 'left='+ StartX + ', top='+ StartY + ', Width=' + 350 +', height=' + 150+ ', resizable=no, scrollbars=yes, status=no, toolbar=no, menubar=no, location=no'); 
    }
    function showWindowForUpdate(){
		 var winNode = $("#updateWindow");  
	    winNode.fadeIn("slow"); 
	}
	function getCourses() {
			 $.ajax({
			
				url : "loadCourses.action",
				type : 'POST',
				dataType : 'text',
				ContentType : 'application/json; charset=utf-8',
				success : function(data) {
					var zNodes = JSON.parse(data);
					$.each(zNodes, function (id, name) {
                        $("#selectcourse").append("<option value=" + name.id + ">" + name.name + "</option>");
                    });
                     showWindowForUpdate();
			
				},
				error : function(msg) {
					alert('无法取得课程列表！');
				}
			});
			
		}
</script>
  </body>
</html>
